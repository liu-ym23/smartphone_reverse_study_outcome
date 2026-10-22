package androidx.appcompat.widget;

import ai.j0;
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

    public static final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View r5) {
            this.mText1 = (TextView) r5.findViewById(R.id.text1);
            this.mText2 = (TextView) r5.findViewById(R.id.text2);
            this.mIcon1 = (ImageView) r5.findViewById(R.id.icon1);
            this.mIcon2 = (ImageView) r5.findViewById(R.id.icon2);
            this.mIconRefine = (ImageView) r5.findViewById(androidx.appcompat.R.id.edit_query);
        }
    }

    public SuggestionsAdapter(Context r5, SearchView r10, SearchableInfo r11, WeakHashMap<String, Drawable.ConstantState> r12) {
        super(r5, r10.getSuggestionRowLayout(), null, true);
        this.mClosed = false;
        this.mQueryRefinement = 1;
        this.mText1Col = -1;
        this.mText2Col = -1;
        this.mText2UrlCol = -1;
        this.mIconName1Col = -1;
        this.mIconName2Col = -1;
        this.mFlagsCol = -1;
        this.mSearchView = r10;
        this.mSearchable = r11;
        this.mCommitIconResId = r10.getSuggestionCommitIconResId();
        this.mProviderContext = r5;
        this.mOutsideDrawablesCache = r12;
    }

    private Drawable checkIconCache(String r5) {
        Drawable.ConstantState r10 = this.mOutsideDrawablesCache.get(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.newDrawable();
    }

    private CharSequence formatUrl(CharSequence r10) {
        if (this.mUrlColor != null) goto L5;
        TypedValue r5 = new TypedValue();
        this.mProviderContext.getTheme().resolveAttribute(androidx.appcompat.R.attr.textColorSearchUrl, r5, true);
        this.mUrlColor = this.mProviderContext.getResources().getColorStateList(r5.resourceId);
    L5:
        SpannableString r11 = new SpannableString(r10);
        r11.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, r10.length(), 33);
        return r11;
    }

    private Drawable getActivityIcon(ComponentName r10) {
        PackageManager r5 = this.mProviderContext.getPackageManager();
        ActivityInfo r11 = r5.getActivityInfo(r10, 128);     // Catch: PackageManager.NameNotFoundException -> L12
        int r12 = r11.getIconResource();
        if (r12 != 0) goto L7;
        return null;
    L7:
        Drawable r13 = r5.getDrawable(r10.getPackageName(), r12, r11.applicationInfo);
        if (r13 != null) goto L11;
        StringBuilder r14 = j0.s(r12, "Invalid icon resource ", " for ");
        r14.append(r10.flattenToShortString());
        Log.w(LOG_TAG, r14.toString());
        return null;
    L11:
        return r13;
    L12:
        e = move-exception;
        Log.w(LOG_TAG, e.toString());
        return null;
    }

    private Drawable getActivityIconWithCache(ComponentName r5) {
        String r10 = r5.flattenToShortString();
        Drawable.ConstantState r11 = null;
        if (this.mOutsideDrawablesCache.containsKey(r10) == false) goto L9;
        Drawable.ConstantState r12 = this.mOutsideDrawablesCache.get(r10);
        if (r12 != null) goto L8;
        return null;
    L8:
        return r12.newDrawable(this.mProviderContext.getResources());
    L9:
        Drawable r13 = getActivityIcon(r5);
        if (r13 == null) goto L13;
        r11 = r13.getConstantState();
    L13:
        this.mOutsideDrawablesCache.put(r10, r11);
        return r13;
    }

    public static String getColumnString(Cursor r5, String r10) {
        return getStringOrNull(r5, r5.getColumnIndex(r10));
    }

    private Drawable getDefaultIcon1() {
        Drawable r5 = getActivityIconWithCache(this.mSearchable.getSearchActivity());
        if (r5 == null) goto L6;
        return r5;
    L6:
        return this.mProviderContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable getDrawable(Uri r10) {
    L7:
        e = move-exception;
        Log.w(LOG_TAG, "Icon not found: " + r10 + ", " + e.getMessage());
        return null;
    L4:
        if ("android.resource".equals(r10.getScheme()) == true) goto L33;
        InputStream r11 = this.mProviderContext.getContentResolver().openInputStream(r10);     // Catch: FileNotFoundException -> L7
        if (r11 == null) goto L26;
        Drawable r5 = Drawable.createFromStream(r11, null);     // Catch: Throwable -> L19
    L35:
        r11.close();     // Catch: IOException -> L16
    L18:
        return r5;
    L16:
        e = move-exception;
        Log.e(LOG_TAG, "Error closing icon stream for " + r10, e);     // Catch: FileNotFoundException -> L7
    L19:
        th = move-exception;
        r11.close();     // Catch: IOException -> L22
    L24:
        throw th;     // Catch: FileNotFoundException -> L7
    L22:
        e = move-exception;
        Log.e(LOG_TAG, "Error closing icon stream for " + r10, e);     // Catch: FileNotFoundException -> L7
        goto L24
    L26:
        throw new FileNotFoundException("Failed to open " + r10);     // Catch: FileNotFoundException -> L7
    L33:
        return getDrawableFromResourceUri(r10);
    L10:
        throw new FileNotFoundException("Resource does not exist: " + r10);     // Catch: FileNotFoundException -> L7
    }

    private Drawable getDrawableFromResourceValue(String r5) {
        if (r5 != null) goto L5;
    L21:
        return null;
    L5:
        if (r5.isEmpty() == true) goto L21;
        if ("0".equals(r5) == true) goto L21;
        int r10 = Integer.parseInt(r5);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        String r11 = "android.resource://" + this.mProviderContext.getPackageName() + "/" + r10;     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        Drawable r12 = checkIconCache(r11);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        if (r12 == null) goto L12;
        return r12;
    L12:
        Drawable r13 = ContextCompat.getDrawable(this.mProviderContext, r10);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        storeInIconCache(r11, r13);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        return r13;
    L14:
        Log.w(LOG_TAG, "Icon resource not found: ".concat(r5));
        return null;
    L16:
        Drawable r14 = checkIconCache(r5);
        if (r14 == null) goto L19;
        return r14;
    L19:
        Drawable r15 = getDrawable(Uri.parse(r5));
        storeInIconCache(r5, r15);
        return r15;
    }

    private Drawable getIcon1(Cursor r5) {
        int r10 = this.mIconName1Col;
        if (r10 != (-1)) goto L6;
        return null;
    L6:
        Drawable r11 = getDrawableFromResourceValue(r5.getString(r10));
        if (r11 == null) goto L10;
        return r11;
    L10:
        return getDefaultIcon1();
    }

    private Drawable getIcon2(Cursor r5) {
        int r10 = this.mIconName2Col;
        if (r10 != (-1)) goto L7;
        return null;
    L7:
        return getDrawableFromResourceValue(r5.getString(r10));
    }

    private static String getStringOrNull(Cursor r5, int r10) {
        if (r10 != (-1)) goto L10;
        return null;
    L10:
        return r5.getString(r10);
    L7:
        e = move-exception;
        Log.e(LOG_TAG, "unexpected error retrieving valid column from cursor, did the remote process die?", e);
        return null;
    }

    private void setViewDrawable(ImageView r5, Drawable r10, int r11) {
        r5.setImageDrawable(r10);
        if (r10 != null) goto L5;
        r5.setVisibility(r11);
        return;
    L5:
        r5.setVisibility(0);
        r10.setVisible(false, false);
        r10.setVisible(true, false);
    }

    private void setViewText(TextView r5, CharSequence r10) {
        r5.setText(r10);
        if (TextUtils.isEmpty(r10) == false) goto L5;
        r5.setVisibility(8);
        return;
    L5:
        r5.setVisibility(0);
    }

    private void storeInIconCache(String r5, Drawable r10) {
        if (r10 == null) goto L5;
        this.mOutsideDrawablesCache.put(r5, r10.getConstantState());
        return;
    }

    private void updateSpinnerState(Cursor r5) {
        if (r5 == null) goto L4;
        Bundle r10 = r5.getExtras();
    L5:
        if (r10 == null) goto L8;
        r10.getBoolean("in_progress");
        return;
    L8:
        return;
    L4:
        r10 = null;
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
        String r5 = getStringOrNull(r12, this.mText2UrlCol);
        if (r5 == null) goto L14;
        CharSequence r16 = formatUrl(r5);
    L16:
        if (TextUtils.isEmpty(r16) == false) goto L20;
        TextView r17 = r13.mText1;
        if (r17 == null) goto L23;
        r17.setSingleLine(false);
        r13.mText1.setMaxLines(2);
    L23:
        setViewText(r13.mText2, r16);
        goto L24
    L20:
        TextView r18 = r13.mText1;
        if (r18 == null) goto L23;
        r18.setSingleLine(true);
        r13.mText1.setMaxLines(1);
        goto L23
    L14:
        r16 = getStringOrNull(r12, this.mText2Col);
    L24:
        ImageView r19 = r13.mIcon1;
        if (r19 == null) goto L27;
        setViewDrawable(r19, getIcon1(r12), 4);
    L27:
        ImageView r20 = r13.mIcon2;
        if (r20 == null) goto L30;
        setViewDrawable(r20, getIcon2(r12), 8);
    L30:
        int r21 = this.mQueryRefinement;
        if (r21 == 2) goto L37;
        if (r21 == 1) goto L34;
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
    public void changeCursor(Cursor r5) {
        if (this.mClosed == false) goto L15;
        Log.w(LOG_TAG, "Tried to change cursor after adapter was closed.");
        if (r5 == null) goto L17;
        r5.close();
        return;
    L17:
        return;
    L15:
        super.changeCursor(r5);     // Catch: Exception -> L12
        if (r5 == null) goto L18;
        this.mText1Col = r5.getColumnIndex("suggest_text_1");     // Catch: Exception -> L12
        this.mText2Col = r5.getColumnIndex("suggest_text_2");     // Catch: Exception -> L12
        this.mText2UrlCol = r5.getColumnIndex("suggest_text_2_url");     // Catch: Exception -> L12
        this.mIconName1Col = r5.getColumnIndex("suggest_icon_1");     // Catch: Exception -> L12
        this.mIconName2Col = r5.getColumnIndex("suggest_icon_2");     // Catch: Exception -> L12
        this.mFlagsCol = r5.getColumnIndex("suggest_flags");     // Catch: Exception -> L12
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
    public CharSequence convertToString(Cursor r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        String r10 = getColumnString(r5, "suggest_intent_query");
        if (r10 == null) goto L9;
        return r10;
    L9:
        if (this.mSearchable.shouldRewriteQueryFromData() == false) goto L14;
        String r11 = getColumnString(r5, "suggest_intent_data");
        if (r11 == null) goto L14;
        return r11;
    L14:
        if (this.mSearchable.shouldRewriteQueryFromText() == false) goto L18;
        String r12 = getColumnString(r5, "suggest_text_1");
        if (r12 == null) goto L18;
        return r12;
    L18:
        return null;
    }

    public Drawable getDrawableFromResourceUri(Uri r10) throws FileNotFoundException {
        String r5 = r10.getAuthority();
        if (TextUtils.isEmpty(r5) == true) goto L28;
        Resources r11 = this.mProviderContext.getPackageManager().getResourcesForApplication(r5);     // Catch: PackageManager.NameNotFoundException -> L25
        List<String> r12 = r10.getPathSegments();
        if (r12 == null) goto L24;
        int r13 = r12.size();
        if (r13 != 1) goto L14;
        int r14 = Integer.parseInt(r12.get(0));     // Catch: NumberFormatException -> L11
    L16:
        if (r14 == 0) goto L20;
        return r11.getDrawable(r14);
    L20:
        throw new FileNotFoundException(j0.i(r10, "No resource found for: "));
    L12:
        throw new FileNotFoundException(j0.i(r10, "Single path segment is not a resource ID: "));
    L14:
        if (r13 != 2) goto L22;
        r14 = r11.getIdentifier(r12.get(1), r12.get(0), r5);
        goto L16
    L22:
        throw new FileNotFoundException(j0.i(r10, "More than two path segments: "));
    L24:
        throw new FileNotFoundException(j0.i(r10, "No path: "));
    L26:
        throw new FileNotFoundException(j0.i(r10, "No package found for authority: "));
    L28:
        throw new FileNotFoundException(j0.i(r10, "No authority: "));
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r5, View r10, ViewGroup r11) {
        return super.getDropDownView(r5, r10, r11);
    L4:
        e = move-exception;
        Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e);
        View r12 = newDropDownView(this.mProviderContext, getCursor(), r11);
        if (r12 == null) goto L8;
        ((ChildViewCache) r12.getTag()).mText1.setText(e.toString());
    L8:
        return r12;
    }

    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }

    public Cursor getSearchManagerSuggestions(SearchableInfo r10, String r11, int r12) {
        String[] r5 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        String r13 = r10.getSuggestAuthority();
        if (r13 != null) goto L8;
        return null;
    L8:
        Uri.Builder r14 = new Uri.Builder().scheme("content").authority(r13).query("").fragment("");
        String r15 = r10.getSuggestPath();
        if (r15 == null) goto L11;
        r14.appendEncodedPath(r15);
    L11:
        r14.appendPath("search_suggest_query");
        String r16 = r10.getSuggestSelection();
        if (r16 == null) goto L15;
        r5 = new String[]{r11};
    L14:
        String[] r17 = r5;
        if (r12 <= 0) goto L19;
        r14.appendQueryParameter("limit", String.valueOf(r12));
    L19:
        return this.mProviderContext.getContentResolver().query(r14.build(), null, r16, r17, null);
    L15:
        r14.appendPath(r11);
        goto L14
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int r5, View r10, ViewGroup r11) {
        return super.getView(r5, r10, r11);
    L4:
        e = move-exception;
        Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e);
        View r12 = newView(this.mProviderContext, getCursor(), r11);
        if (r12 == null) goto L8;
        ((ChildViewCache) r12.getTag()).mText1.setText(e.toString());
    L8:
        return r12;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context r5, Cursor r10, ViewGroup r11) {
        View r12 = super.newView(r5, r10, r11);
        r12.setTag(new ChildViewCache(r12));
        ((ImageView) r12.findViewById(androidx.appcompat.R.id.edit_query)).setImageResource(this.mCommitIconResId);
        return r12;
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
    public void onClick(View r5) {
        Object r10 = r5.getTag();
        if ((r10 instanceof CharSequence) == false) goto L6;
        this.mSearchView.onQueryRefine((CharSequence) r10);
        return;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence r5) {
        if (r5 != null) goto L4;
        String r10 = "";
    L6:
        if (this.mSearchView.getVisibility() == 0) goto L8;
    L16:
        return null;
    L8:
        if (this.mSearchView.getWindowVisibility() != 0) goto L16;
        Cursor r11 = getSearchManagerSuggestions(this.mSearchable, r10, 50);     // Catch: RuntimeException -> L14
        if (r11 == null) goto L16;
        r11.getCount();     // Catch: RuntimeException -> L14
        return r11;
    L14:
        e = move-exception;
        Log.w(LOG_TAG, "Search suggestions query threw an exception.", e);
        goto L16
    L4:
        r10 = r5.toString();
        goto L6
    }

    public void setQueryRefinement(int r5) {
        this.mQueryRefinement = r5;
    }
}
