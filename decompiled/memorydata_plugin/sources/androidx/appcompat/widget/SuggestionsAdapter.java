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
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        public ChildViewCache(View r5) {
            this.mText1 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(R.id.text1), TextView.class, "com.obric.memorydata.plugin");
            this.mText2 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(R.id.text2), TextView.class, "com.obric.memorydata.plugin");
            this.mIcon1 = (ImageView) ZeusTransformUtils.preCheckCast(r5.findViewById(R.id.icon1), ImageView.class, "com.obric.memorydata.plugin");
            this.mIcon2 = (ImageView) ZeusTransformUtils.preCheckCast(r5.findViewById(R.id.icon2), ImageView.class, "com.obric.memorydata.plugin");
            this.mIconRefine = (ImageView) ZeusTransformUtils.preCheckCast(r5.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.edit_query, OaidModel.KEY_ID, "edit_query")), ImageView.class, "com.obric.memorydata.plugin");
        }
    }

    public SuggestionsAdapter(Context r5, SearchView r6, SearchableInfo r7, WeakHashMap<String, Drawable.ConstantState> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        super(r9, r6.getSuggestionRowLayout(), null, true);
        this.mClosed = false;
        this.mQueryRefinement = 1;
        this.mText1Col = -1;
        this.mText2Col = -1;
        this.mText2UrlCol = -1;
        this.mIconName1Col = -1;
        this.mIconName2Col = -1;
        this.mFlagsCol = -1;
        this.mSearchView = r6;
        this.mSearchable = r7;
        this.mCommitIconResId = r6.getSuggestionCommitIconResId();
        this.mProviderContext = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.mOutsideDrawablesCache = r8;
    }

    private Drawable checkIconCache(String r2) {
        Drawable.ConstantState r1 = (Drawable.ConstantState) ZeusTransformUtils.preCheckCast(this.mOutsideDrawablesCache.get(r2), Drawable.ConstantState.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.newDrawable();
    }

    private CharSequence formatUrl(CharSequence r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.mUrlColor != null) goto L5;
        TypedValue r0 = new TypedValue();
        this.mProviderContext.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.textColorSearchUrl, "attr", "textColorSearchUrl"), r0, true);
        this.mUrlColor = ZeusTransformUtils.getResources(this.mProviderContext, "com.obric.memorydata.plugin").getColorStateList(r0.resourceId);
    L5:
        SpannableString r1 = new SpannableString(r10);
        r1.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, r10.length(), 33);
        return r1;
    }

    private Drawable getActivityIcon(ComponentName r6) {
        PackageManager r5 = this.mProviderContext.getPackageManager();
        ActivityInfo r1 = r5.getActivityInfo(r6, 128);     // Catch: PackageManager.NameNotFoundException -> L13
        int r3 = r1.getIconResource();
        if (r3 != 0) goto L7;
        return null;
    L7:
        Drawable r7 = r5.getDrawable(r6.getPackageName(), r3, r1.applicationInfo);
        if (r7 != null) goto L12;
        String r8 = "Invalid icon resource " + r3 + " for " + r6.flattenToShortString();
    L10:
        Log.w(LOG_TAG, r8);
        return null;
    L12:
        return r7;
    L13:
        e = move-exception;
        r8 = e.toString();
        goto L10
    }

    private Drawable getActivityIconWithCache(ComponentName r4) {
        String r0 = r4.flattenToShortString();
        Drawable.ConstantState r2 = null;
        if (this.mOutsideDrawablesCache.containsKey(r0) == false) goto L9;
        Drawable.ConstantState r5 = (Drawable.ConstantState) ZeusTransformUtils.preCheckCast(this.mOutsideDrawablesCache.get(r0), Drawable.ConstantState.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.newDrawable(ZeusTransformUtils.getResources(this.mProviderContext, "com.obric.memorydata.plugin"));
    L9:
        Drawable r6 = getActivityIcon(r4);
        if (r6 == null) goto L13;
        r2 = r6.getConstantState();
    L13:
        this.mOutsideDrawablesCache.put(r0, r2);
        return r6;
    }

    public static String getColumnString(Cursor r2, String r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        return getStringOrNull(r4, r4.getColumnIndex(r3));
    }

    private Drawable getDefaultIcon1() {
        Drawable r0 = getActivityIconWithCache(this.mSearchable.getSearchActivity());
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.mProviderContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable getDrawable(Uri r6) {
    L25:
        e = move-exception;
        Log.w(LOG_TAG, "Icon not found: " + r6 + ", " + e.getMessage());
        return null;
    L4:
        if ("android.resource".equals(r6.getScheme()) == true) goto L28;
        InputStream r5 = this.mProviderContext.getContentResolver().openInputStream(r6);     // Catch: FileNotFoundException -> L25
        if (r5 == null) goto L24;
        Drawable r3 = Drawable.createFromStream(r5, null);     // Catch: Throwable -> L17
        r5.close();     // Catch: IOException -> L14 FileNotFoundException -> L25
    L16:
        return r3;
    L14:
        e = move-exception;
        Log.e(LOG_TAG, "Error closing icon stream for " + r6, e);     // Catch: FileNotFoundException -> L25
        goto L16
    L17:
        th = move-exception;
        r5.close();     // Catch: IOException -> L20 FileNotFoundException -> L25
    L22:
        throw th;     // Catch: FileNotFoundException -> L25
    L20:
        e = move-exception;
        Log.e(LOG_TAG, "Error closing icon stream for " + r6, e);     // Catch: FileNotFoundException -> L25
        goto L22
    L24:
        throw new FileNotFoundException("Failed to open " + r6);     // Catch: FileNotFoundException -> L25
    L28:
        return getDrawableFromResourceUri(r6);
    L8:
        throw new FileNotFoundException("Resource does not exist: " + r6);     // Catch: FileNotFoundException -> L25
    }

    private Drawable getDrawableFromResourceValue(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return null;
    L7:
        if ("0".equals(r5) == true) goto L25;
        int r1 = Integer.parseInt(r5);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        String r2 = "android.resource://" + this.mProviderContext.getPackageName() + "/" + r1;     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        Drawable r3 = checkIconCache(r2);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        if (r3 == null) goto L12;
        return r3;
    L12:
        Drawable r4 = ContextCompat.getDrawable(this.mProviderContext, r1);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        storeInIconCache(r2, r4);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        return r4;
    L14:
        Log.w(LOG_TAG, "Icon resource not found: " + r5);
        return null;
    L16:
        Drawable r0 = checkIconCache(r5);
        if (r0 == null) goto L19;
        return r0;
    L19:
        Drawable r6 = getDrawable(Uri.parse(r5));
        storeInIconCache(r5, r6);
        return r6;
    L25:
        return null;
    }

    private Drawable getIcon1(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        int r0 = this.mIconName1Col;
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        Drawable r5 = getDrawableFromResourceValue(r4.getString(r0));
        if (r5 == null) goto L10;
        return r5;
    L10:
        return getDefaultIcon1();
    }

    private Drawable getIcon2(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        int r0 = this.mIconName2Col;
        if (r0 != (-1)) goto L7;
        return null;
    L7:
        return getDrawableFromResourceValue(r4.getString(r0));
    }

    private static String getStringOrNull(Cursor r2, int r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        if (r3 != (-1)) goto L10;
        return null;
    L10:
        return r4.getString(r3);
    L7:
        e = move-exception;
        Log.e(LOG_TAG, "unexpected error retrieving valid column from cursor, did the remote process die?", e);
        return null;
    }

    private void setViewDrawable(ImageView r1, Drawable r2, int r3) {
        r1.setImageDrawable(r2);
        if (r2 != null) goto L5;
        r1.setVisibility(r3);
        return;
    L5:
        r1.setVisibility(0);
        r2.setVisible(false, false);
        r2.setVisible(true, false);
    }

    private void setViewText(TextView r2, CharSequence r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        r2.setText(r1);
        if (TextUtils.isEmpty(r1) == false) goto L5;
        int r4 = 8;
    L6:
        r2.setVisibility(r4);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    private void storeInIconCache(String r1, Drawable r2) {
        if (r2 == null) goto L5;
        this.mOutsideDrawablesCache.put(r1, r2.getConstantState());
        return;
    }

    private void updateSpinnerState(Cursor r2) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        Bundle r3 = r1.getExtras();
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.getBoolean("in_progress") == true) goto L10;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View r7, Context r8, Cursor r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Cursor r11 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r9, Cursor.class, "com.obric.memorydata.plugin");
        ChildViewCache r12 = (ChildViewCache) ZeusTransformUtils.preCheckCast(r7.getTag(), ChildViewCache.class, "com.obric.memorydata.plugin");
        int r13 = this.mFlagsCol;
        if (r13 == (-1)) goto L5;
        int r14 = r11.getInt(r13);
    L7:
        if (r12.mText1 == null) goto L10;
        setViewText(r12.mText1, getStringOrNull(r11, this.mText1Col));
    L10:
        if (r12.mText2 == null) goto L25;
        String r1 = getStringOrNull(r11, this.mText2UrlCol);
        if (r1 == null) goto L14;
        CharSequence r2 = formatUrl(r1);
    L16:
        if (TextUtils.isEmpty(r2) == false) goto L21;
        if (r12.mText1 == null) goto L23;
        r12.mText1.setSingleLine(false);
        r12.mText1.setMaxLines(2);
    L23:
        setViewText(r12.mText2, r2);
        goto L25
    L21:
        if (r12.mText1 == null) goto L23;
        r12.mText1.setSingleLine(true);
        r12.mText1.setMaxLines(1);
        goto L23
    L14:
        r2 = getStringOrNull(r11, this.mText2Col);
    L25:
        if (r12.mIcon1 == null) goto L28;
        setViewDrawable(r12.mIcon1, getIcon1(r11), 4);
    L28:
        if (r12.mIcon2 == null) goto L30;
        setViewDrawable(r12.mIcon2, getIcon2(r11), 8);
    L30:
        int r15 = this.mQueryRefinement;
        if (r15 == 2) goto L37;
        if (r15 == 1) goto L34;
    L36:
        r12.mIconRefine.setVisibility(8);
        return;
    L34:
        if ((r14 & 1) == 0) goto L36;
    L37:
        r12.mIconRefine.setVisibility(0);
        r12.mIconRefine.setTag(r12.mText1.getText());
        r12.mIconRefine.setOnClickListener(this);
        return;
    L5:
        r14 = 0;
        goto L7
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        if (this.mClosed == false) goto L15;
        Log.w(LOG_TAG, "Tried to change cursor after adapter was closed.");
        if (r4 == null) goto L17;
        r4.close();
        return;
    L17:
        return;
    L15:
        super.changeCursor(r4);     // Catch: Exception -> L12
        if (r4 == null) goto L18;
        this.mText1Col = r4.getColumnIndex("suggest_text_1");     // Catch: Exception -> L12
        this.mText2Col = r4.getColumnIndex("suggest_text_2");     // Catch: Exception -> L12
        this.mText2UrlCol = r4.getColumnIndex("suggest_text_2_url");     // Catch: Exception -> L12
        this.mIconName1Col = r4.getColumnIndex("suggest_icon_1");     // Catch: Exception -> L12
        this.mIconName2Col = r4.getColumnIndex("suggest_icon_2");     // Catch: Exception -> L12
        this.mFlagsCol = r4.getColumnIndex("suggest_flags");     // Catch: Exception -> L12
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
    public CharSequence convertToString(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        String r1 = getColumnString(r4, "suggest_intent_query");
        if (r1 == null) goto L9;
        return r1;
    L9:
        if (this.mSearchable.shouldRewriteQueryFromData() == false) goto L14;
        String r2 = getColumnString(r4, "suggest_intent_data");
        if (r2 == null) goto L14;
        return r2;
    L14:
        if (this.mSearchable.shouldRewriteQueryFromText() == false) goto L18;
        String r5 = getColumnString(r4, "suggest_text_1");
        if (r5 == null) goto L18;
        return r5;
    L18:
        return null;
    }

    Drawable getDrawableFromResourceUri(Uri r8) {
        String r0 = r8.getAuthority();
        if (TextUtils.isEmpty(r0) == true) goto L28;
        Resources r7 = this.mProviderContext.getPackageManager().getResourcesForApplication(r0);     // Catch: PackageManager.NameNotFoundException -> L25
        List<String> r1 = r8.getPathSegments();
        if (r1 == null) goto L24;
        int r2 = r1.size();
        if (r2 != 1) goto L14;
        int r3 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r1.get(0), String.class, "com.obric.memorydata.plugin"));     // Catch: NumberFormatException -> L11
    L16:
        if (r3 == 0) goto L20;
        return r7.getDrawable(r3);
    L20:
        throw new FileNotFoundException("No resource found for: " + r8);
    L12:
        throw new FileNotFoundException("Single path segment is not a resource ID: " + r8);
    L14:
        if (r2 != 2) goto L22;
        r3 = ZeusTransformUtils.getIdentifier(r7, (String) ZeusTransformUtils.preCheckCast(r1.get(1), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.get(0), String.class, "com.obric.memorydata.plugin"), r0, "com.obric.memorydata.plugin");
        goto L16
    L22:
        throw new FileNotFoundException("More than two path segments: " + r8);
    L24:
        throw new FileNotFoundException("No path: " + r8);
    L26:
        throw new FileNotFoundException("No package found for authority: " + r8);
    L28:
        throw new FileNotFoundException("No authority: " + r8);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r2, View r3, ViewGroup r4) {
        return super.getDropDownView(r2, r3, r4);
    L4:
        e = move-exception;
        Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e);
        View r1 = newDropDownView(this.mProviderContext, getCursor(), r4);
        if (r1 == null) goto L8;
        ((ChildViewCache) ZeusTransformUtils.preCheckCast(r1.getTag(), ChildViewCache.class, "com.obric.memorydata.plugin")).mText1.setText(e.toString());
    L8:
        return r1;
    }

    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }

    Cursor getSearchManagerSuggestions(SearchableInfo r11, String r12, int r13) {
        String[] r0 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        String r1 = r11.getSuggestAuthority();
        if (r1 != null) goto L8;
        return null;
    L8:
        Uri.Builder r2 = new Uri.Builder().scheme(Params.CONTENT).authority(r1).query("").fragment("");
        String r3 = r11.getSuggestPath();
        if (r3 == null) goto L11;
        r2.appendEncodedPath(r3);
    L11:
        r2.appendPath("search_suggest_query");
        String r6 = r11.getSuggestSelection();
        if (r6 == null) goto L14;
        r0 = new String[]{r12};
    L15:
        String[] r7 = r0;
        if (r13 <= 0) goto L19;
        r2.appendQueryParameter("limit", String.valueOf(r13));
    L19:
        return ZeusProviderTransform.query(this.mProviderContext.getContentResolver(), r2.build(), null, r6, r7, null, "com.obric.memorydata.plugin");
    L14:
        r2.appendPath(r12);
        goto L15
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int r2, View r3, ViewGroup r4) {
        return super.getView(r2, r3, r4);
    L4:
        e = move-exception;
        Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e);
        View r1 = newView(this.mProviderContext, getCursor(), r4);
        if (r1 == null) goto L8;
        ((ChildViewCache) ZeusTransformUtils.preCheckCast(r1.getTag(), ChildViewCache.class, "com.obric.memorydata.plugin")).mText1.setText(e.toString());
    L8:
        return r1;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context r3, Cursor r4, ViewGroup r5) {
        View r6 = super.newView((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin"), r5);
        r6.setTag(new ChildViewCache(r6));
        ((ImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.edit_query, OaidModel.KEY_ID, "edit_query")), ImageView.class, "com.obric.memorydata.plugin")).setImageResource(this.mCommitIconResId);
        return r6;
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
    public void onClick(View r3) {
        Object r4 = r3.getTag();
        if (ZeusTransformUtils.instanceOf(r4, CharSequence.class) == false) goto L6;
        this.mSearchView.onQueryRefine((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        String r6 = "";
    L7:
        if (this.mSearchView.getVisibility() == 0) goto L9;
    L17:
        return null;
    L9:
        if (this.mSearchView.getWindowVisibility() != 0) goto L17;
        Cursor r3 = getSearchManagerSuggestions(this.mSearchable, r6, 50);     // Catch: RuntimeException -> L15
        if (r3 == null) goto L17;
        r3.getCount();     // Catch: RuntimeException -> L15
        return r3;
    L15:
        e = move-exception;
        Log.w(LOG_TAG, "Search suggestions query threw an exception.", e);
        goto L17
    L5:
        r6 = r5.toString();
        goto L7
    }

    public void setQueryRefinement(int r1) {
        this.mQueryRefinement = r1;
    }
}
