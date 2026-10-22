package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.bytedance.apm6.util.constant.NetConst;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    private static final boolean DBG = false;
    static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_ALL = 2;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_NONE = 0;
    private boolean mClosed;
    private final int mCommitIconResId;
    private int mFlagsCol;
    private int mIconName1Col;
    private int mIconName2Col;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private final Context mProviderContext;
    private int mQueryRefinement;
    private final SearchView mSearchView;
    private final SearchableInfo mSearchable;
    private int mText1Col;
    private int mText2Col;
    private int mText2UrlCol;
    private ColorStateList mUrlColor;

    private static final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View r10) {
            this.mText1 = (TextView) r10.findViewById(R.id.text1);
            this.mText2 = (TextView) r10.findViewById(R.id.text2);
            this.mIcon1 = (ImageView) r10.findViewById(R.id.icon1);
            this.mIcon2 = (ImageView) r10.findViewById(R.id.icon2);
            this.mIconRefine = (ImageView) r10.findViewById(androidx.appcompat.R.id.edit_query);
        }
    }

    public SuggestionsAdapter(Context r10, SearchView r11, SearchableInfo r12, WeakHashMap<String, Drawable.ConstantState> r13) {
        super(r10, r11.getSuggestionRowLayout(), null, true);
        this.mClosed = false;
        this.mQueryRefinement = 1;
        this.mText1Col = -1;
        this.mText2Col = -1;
        this.mText2UrlCol = -1;
        this.mIconName1Col = -1;
        this.mIconName2Col = -1;
        this.mFlagsCol = -1;
        this.mSearchView = r11;
        this.mSearchable = r12;
        this.mCommitIconResId = r11.getSuggestionCommitIconResId();
        this.mProviderContext = r10;
        this.mOutsideDrawablesCache = r13;
    }

    private Drawable checkIconCache(String r10) {
        Drawable.ConstantState r11 = this.mOutsideDrawablesCache.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.newDrawable();
    }

    private CharSequence formatUrl(CharSequence r10) {
        if (this.mUrlColor != null) goto L5;
        TypedValue r11 = new TypedValue();
        this.mProviderContext.getTheme().resolveAttribute(androidx.appcompat.R.attr.textColorSearchUrl, r11, true);
        this.mUrlColor = this.mProviderContext.getResources().getColorStateList(r11.resourceId);
    L5:
        SpannableString r12 = new SpannableString(r10);
        r12.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, r10.length(), 33);
        return r12;
    }

    private Drawable getActivityIcon(ComponentName r10) {
        PackageManager r11 = this.mProviderContext.getPackageManager();
        ActivityInfo r12 = r11.getActivityInfo(r10, 128);     // Catch: PackageManager.NameNotFoundException -> L13
        int r13 = r12.getIconResource();
        if (r13 != 0) goto L7;
        return null;
    L7:
        Drawable r14 = r11.getDrawable(r10.getPackageName(), r13, r12.applicationInfo);
        if (r14 != null) goto L12;
        String r15 = "Invalid icon resource " + r13 + " for " + r10.flattenToShortString();
    L10:
        Log.w(LOG_TAG, r15);
        return null;
    L12:
        return r14;
    L13:
        e = move-exception;
        r15 = e.toString();
        goto L10
    }

    private Drawable getActivityIconWithCache(ComponentName r10) {
        String r11 = r10.flattenToShortString();
        Drawable.ConstantState r12 = null;
        if (this.mOutsideDrawablesCache.containsKey(r11) == false) goto L9;
        Drawable.ConstantState r13 = this.mOutsideDrawablesCache.get(r11);
        if (r13 != null) goto L8;
        return null;
    L8:
        return r13.newDrawable(this.mProviderContext.getResources());
    L9:
        Drawable r14 = getActivityIcon(r10);
        if (r14 == null) goto L13;
        r12 = r14.getConstantState();
    L13:
        this.mOutsideDrawablesCache.put(r11, r12);
        return r14;
    }

    public static String getColumnString(Cursor r10, String r11) {
        return getStringOrNull(r10, r10.getColumnIndex(r11));
    }

    private Drawable getDefaultIcon1() {
        Drawable r10 = getActivityIconWithCache(this.mSearchable.getSearchActivity());
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.mProviderContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable getDrawable(Uri r10) {
    L25:
        e = move-exception;
        Log.w(LOG_TAG, "Icon not found: " + r10 + ", " + e.getMessage());
        return null;
    L4:
        if ("android.resource".equals(r10.getScheme()) == true) goto L28;
        InputStream r11 = this.mProviderContext.getContentResolver().openInputStream(r10);     // Catch: FileNotFoundException -> L25
        if (r11 == null) goto L24;
        Drawable r12 = Drawable.createFromStream(r11, null);     // Catch: Throwable -> L17
    L35:
        r11.close();     // Catch: IOException -> L14
    L16:
        return r12;
    L14:
        e = move-exception;
        Log.e(LOG_TAG, "Error closing icon stream for " + r10, e);     // Catch: FileNotFoundException -> L25
    L17:
        th = move-exception;
        r11.close();     // Catch: IOException -> L20
    L22:
        throw th;     // Catch: FileNotFoundException -> L25
    L20:
        e = move-exception;
        Log.e(LOG_TAG, "Error closing icon stream for " + r10, e);     // Catch: FileNotFoundException -> L25
        goto L22
    L24:
        throw new FileNotFoundException("Failed to open " + r10);     // Catch: FileNotFoundException -> L25
    L28:
        return getDrawableFromResourceUri(r10);
    L8:
        throw new FileNotFoundException("Resource does not exist: " + r10);     // Catch: FileNotFoundException -> L25
    }

    private Drawable getDrawableFromResourceValue(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        if (NetConst.NOT_ENCRYPT_VERISON_CODE.equals(r10) == true) goto L25;
        int r11 = Integer.parseInt(r10);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        String r12 = "android.resource://" + this.mProviderContext.getPackageName() + "/" + r11;     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        Drawable r13 = checkIconCache(r12);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        if (r13 == null) goto L12;
        return r13;
    L12:
        Drawable r14 = ContextCompat.getDrawable(this.mProviderContext, r11);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        storeInIconCache(r12, r14);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        return r14;
    L14:
        Log.w(LOG_TAG, "Icon resource not found: " + r10);
        return null;
    L16:
        Drawable r15 = checkIconCache(r10);
        if (r15 == null) goto L19;
        return r15;
    L19:
        Drawable r16 = getDrawable(Uri.parse(r10));
        storeInIconCache(r10, r16);
        return r16;
    L25:
        return null;
    }

    private Drawable getIcon1(Cursor r10) {
        int r11 = this.mIconName1Col;
        if (r11 != (-1)) goto L6;
        return null;
    L6:
        Drawable r12 = getDrawableFromResourceValue(r10.getString(r11));
        if (r12 == null) goto L10;
        return r12;
    L10:
        return getDefaultIcon1();
    }

    private Drawable getIcon2(Cursor r10) {
        int r11 = this.mIconName2Col;
        if (r11 != (-1)) goto L7;
        return null;
    L7:
        return getDrawableFromResourceValue(r10.getString(r11));
    }

    private static String getStringOrNull(Cursor r10, int r11) {
        if (r11 != (-1)) goto L10;
        return null;
    L10:
        return r10.getString(r11);
    L7:
        e = move-exception;
        Log.e(LOG_TAG, "unexpected error retrieving valid column from cursor, did the remote process die?", e);
        return null;
    }

    private void setViewDrawable(ImageView r10, Drawable r11, int r12) {
        r10.setImageDrawable(r11);
        if (r11 != null) goto L5;
        r10.setVisibility(r12);
        return;
    L5:
        r10.setVisibility(0);
        r11.setVisible(false, false);
        r11.setVisible(true, false);
    }

    private void setViewText(TextView r10, CharSequence r11) {
        r10.setText(r11);
        if (TextUtils.isEmpty(r11) == false) goto L5;
        int r12 = 8;
    L6:
        r10.setVisibility(r12);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    private void storeInIconCache(String r10, Drawable r11) {
        if (r11 == null) goto L5;
        this.mOutsideDrawablesCache.put(r10, r11.getConstantState());
        return;
    }

    private void updateSpinnerState(Cursor r10) {
        if (r10 == null) goto L4;
        Bundle r11 = r10.getExtras();
    L5:
        if (r11 == null) goto L8;
        r11.getBoolean("in_progress");
        return;
    L8:
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View r10, Context r11, Cursor r12) {
        ChildViewCache r13 = (ChildViewCache) r10.getTag();
        int r14 = this.mFlagsCol;
        if (r14 == (-1)) goto L5;
        int r15 = r12.getInt(r14);
    L7:
        if (r13.mText1 == null) goto L10;
        setViewText(r13.mText1, getStringOrNull(r12, this.mText1Col));
    L10:
        if (r13.mText2 == null) goto L24;
        String r16 = getStringOrNull(r12, this.mText2UrlCol);
        if (r16 == null) goto L14;
        CharSequence r17 = formatUrl(r16);
    L16:
        if (TextUtils.isEmpty(r17) == false) goto L20;
        TextView r18 = r13.mText1;
        if (r18 == null) goto L23;
        r18.setSingleLine(false);
        r13.mText1.setMaxLines(2);
    L23:
        setViewText(r13.mText2, r17);
        goto L24
    L20:
        TextView r19 = r13.mText1;
        if (r19 == null) goto L23;
        r19.setSingleLine(true);
        r13.mText1.setMaxLines(1);
        goto L23
    L14:
        r17 = getStringOrNull(r12, this.mText2Col);
    L24:
        ImageView r20 = r13.mIcon1;
        if (r20 == null) goto L27;
        setViewDrawable(r20, getIcon1(r12), 4);
    L27:
        ImageView r21 = r13.mIcon2;
        if (r21 == null) goto L30;
        setViewDrawable(r21, getIcon2(r12), 8);
    L30:
        int r22 = this.mQueryRefinement;
        if (r22 == 2) goto L37;
        if (r22 == 1) goto L34;
    L36:
        r13.mIconRefine.setVisibility(8);
        return;
    L34:
        if ((r15 & 1) == 0) goto L36;
    L37:
        r13.mIconRefine.setVisibility(0);
        r13.mIconRefine.setTag(r13.mText1.getText());
        r13.mIconRefine.setOnClickListener(this);
        return;
    L5:
        r15 = 0;
        goto L7
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor r10) {
        if (this.mClosed == false) goto L15;
        Log.w(LOG_TAG, "Tried to change cursor after adapter was closed.");
        if (r10 == null) goto L17;
        r10.close();
        return;
    L17:
        return;
    L15:
        super.changeCursor(r10);     // Catch: Exception -> L12
        if (r10 == null) goto L18;
        this.mText1Col = r10.getColumnIndex("suggest_text_1");     // Catch: Exception -> L12
        this.mText2Col = r10.getColumnIndex("suggest_text_2");     // Catch: Exception -> L12
        this.mText2UrlCol = r10.getColumnIndex("suggest_text_2_url");     // Catch: Exception -> L12
        this.mIconName1Col = r10.getColumnIndex("suggest_icon_1");     // Catch: Exception -> L12
        this.mIconName2Col = r10.getColumnIndex("suggest_icon_2");     // Catch: Exception -> L12
        this.mFlagsCol = r10.getColumnIndex("suggest_flags");     // Catch: Exception -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        Log.e(LOG_TAG, "error changing cursor and caching columns", e);
    }

    public void close() {
        changeCursor(null);
        this.mClosed = true;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r11 = getColumnString(r10, "suggest_intent_query");
        if (r11 == null) goto L9;
        return r11;
    L9:
        if (this.mSearchable.shouldRewriteQueryFromData() == false) goto L14;
        String r12 = getColumnString(r10, "suggest_intent_data");
        if (r12 == null) goto L14;
        return r12;
    L14:
        if (this.mSearchable.shouldRewriteQueryFromText() == false) goto L18;
        String r13 = getColumnString(r10, "suggest_text_1");
        if (r13 == null) goto L18;
        return r13;
    L18:
        return null;
    }

    Drawable getDrawableFromResourceUri(Uri r10) {
        String r11 = r10.getAuthority();
        if (TextUtils.isEmpty(r11) == true) goto L28;
        Resources r12 = this.mProviderContext.getPackageManager().getResourcesForApplication(r11);     // Catch: PackageManager.NameNotFoundException -> L25
        List<String> r13 = r10.getPathSegments();
        if (r13 == null) goto L24;
        int r14 = r13.size();
        if (r14 != 1) goto L14;
        int r15 = Integer.parseInt(r13.get(0));     // Catch: NumberFormatException -> L11
    L16:
        if (r15 == 0) goto L20;
        return r12.getDrawable(r15);
    L20:
        throw new FileNotFoundException("No resource found for: " + r10);
    L12:
        throw new FileNotFoundException("Single path segment is not a resource ID: " + r10);
    L14:
        if (r14 != 2) goto L22;
        r15 = r12.getIdentifier(r13.get(1), r13.get(0), r11);
        goto L16
    L22:
        throw new FileNotFoundException("More than two path segments: " + r10);
    L24:
        throw new FileNotFoundException("No path: " + r10);
    L26:
        throw new FileNotFoundException("No package found for authority: " + r10);
    L28:
        throw new FileNotFoundException("No authority: " + r10);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r10, View r11, ViewGroup r12) {
        return super.getDropDownView(r10, r11, r12);
    L4:
        e = move-exception;
        Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e);
        View r13 = newDropDownView(this.mProviderContext, getCursor(), r12);
        if (r13 == null) goto L8;
        ((ChildViewCache) r13.getTag()).mText1.setText(e.toString());
    L8:
        return r13;
    }

    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }

    Cursor getSearchManagerSuggestions(SearchableInfo r10, String r11, int r12) {
        String[] r13 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        String r14 = r10.getSuggestAuthority();
        if (r14 != null) goto L8;
        return null;
    L8:
        Uri.Builder r15 = new Uri.Builder().scheme("content").authority(r14).query("").fragment("");
        String r16 = r10.getSuggestPath();
        if (r16 == null) goto L11;
        r15.appendEncodedPath(r16);
    L11:
        r15.appendPath("search_suggest_query");
        String r17 = r10.getSuggestSelection();
        if (r17 == null) goto L14;
        r13 = new String[]{r11};
    L15:
        String[] r18 = r13;
        if (r12 <= 0) goto L19;
        r15.appendQueryParameter("limit", String.valueOf(r12));
    L19:
        return this.mProviderContext.getContentResolver().query(r15.build(), null, r17, r18, null);
    L14:
        r15.appendPath(r11);
        goto L15
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        return super.getView(r10, r11, r12);
    L4:
        e = move-exception;
        Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e);
        View r13 = newView(this.mProviderContext, getCursor(), r12);
        if (r13 == null) goto L8;
        ((ChildViewCache) r13.getTag()).mText1.setText(e.toString());
    L8:
        return r13;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context r10, Cursor r11, ViewGroup r12) {
        View r13 = super.newView(r10, r11, r12);
        r13.setTag(new ChildViewCache(r13));
        ((ImageView) r13.findViewById(androidx.appcompat.R.id.edit_query)).setImageResource(this.mCommitIconResId);
        return r13;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateSpinnerState(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        updateSpinnerState(getCursor());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        Object r11 = r10.getTag();
        if ((r11 instanceof CharSequence) == false) goto L6;
        this.mSearchView.onQueryRefine((CharSequence) r11);
        return;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence r10) {
        if (r10 != null) goto L4;
        String r11 = "";
    L6:
        if (this.mSearchView.getVisibility() == 0) goto L8;
    L16:
        return null;
    L8:
        if (this.mSearchView.getWindowVisibility() != 0) goto L16;
        Cursor r12 = getSearchManagerSuggestions(this.mSearchable, r11, 50);     // Catch: RuntimeException -> L14
        if (r12 == null) goto L16;
        r12.getCount();     // Catch: RuntimeException -> L14
        return r12;
    L14:
        e = move-exception;
        Log.w(LOG_TAG, "Search suggestions query threw an exception.", e);
        goto L16
    L4:
        r11 = r10.toString();
        goto L6
    }

    public void setQueryRefinement(int r10) {
        this.mQueryRefinement = r10;
    }
}
