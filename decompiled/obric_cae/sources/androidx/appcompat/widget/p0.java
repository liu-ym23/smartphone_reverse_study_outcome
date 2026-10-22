package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class p0 extends n0.c implements View.OnClickListener {
    public static final /* synthetic */ int H = 0;
    public ColorStateList A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SearchView f1234u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final SearchableInfo f1235v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Context f1236w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f1237x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f1238y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1239z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f1240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f1241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f1242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f1243d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f1244e;

        public a(View r8) {
            this.f1240a = (TextView) r8.findViewById(R.id.text1);
            this.f1241b = (TextView) r8.findViewById(R.id.text2);
            this.f1242c = (ImageView) r8.findViewById(R.id.icon1);
            this.f1243d = (ImageView) r8.findViewById(R.id.icon2);
            this.f1244e = (ImageView) r8.findViewById(com.obric.cae.R.id.edit_query);
        }
    }

    public p0(Context r8, SearchView r10, SearchableInfo r11, WeakHashMap<String, Drawable.ConstantState> r12) {
        super(r8, r10.getSuggestionRowLayout());
        this.f1239z = 1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.f1234u = r10;
        this.f1235v = r11;
        this.f1238y = r10.getSuggestionCommitIconResId();
        this.f1236w = r8;
        this.f1237x = r12;
    }

    public static String i(Cursor r8, int r10) {
        if (r10 != (-1)) goto L10;
        return null;
    L10:
        return r8.getString(r10);
    L7:
        e = move-exception;
        Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
        return null;
    }

    @Override // n0.a
    public final void b(View r21, Cursor r22) {
        a r8 = (a) r21.getTag();
        int r10 = this.G;
        if (r10 == (-1)) goto L5;
        int r11 = r22.getInt(r10);
    L6:
        TextView r12 = r8.f1240a;
        if (r12 == null) goto L13;
        String r13 = i(r22, this.B);
        r12.setText(r13);
        if (TextUtils.isEmpty(r13) == false) goto L11;
        int r14 = 8;
    L12:
        r12.setVisibility(r14);
        goto L13
    L11:
        r14 = 0;
    L13:
        Context r15 = this.f1236w;
        TextView r16 = r8.f1241b;
        if (r16 == null) goto L33;
        String r17 = i(r22, this.D);
        if (r17 != null) goto L18;
        CharSequence r18 = i(r22, this.C);
    L23:
        if (TextUtils.isEmpty(r18) == false) goto L26;
        if (r12 == null) goto L28;
        r12.setSingleLine(false);
        r12.setMaxLines(2);
    L28:
        r16.setText(r18);
        if (TextUtils.isEmpty(r18) == false) goto L31;
        int r19 = 8;
    L32:
        r16.setVisibility(r19);
        goto L33
    L31:
        r19 = 0;
        goto L32
    L26:
        if (r12 == null) goto L28;
        r12.setSingleLine(true);
        r12.setMaxLines(1);
        goto L28
    L18:
        if (this.A != null) goto L20;
        TypedValue r110 = new TypedValue();
        r15.getTheme().resolveAttribute(com.obric.cae.R.attr.textColorSearchUrl, r110, true);
        this.A = r15.getResources().getColorStateList(r110.resourceId);
    L20:
        SpannableString r111 = new SpannableString(r17);
        r111.setSpan(new TextAppearanceSpan(null, 0, 0, this.A, null), 0, r17.length(), 33);
        r18 = r111;
    L33:
        ImageView r20 = r8.f1242c;
        if (r20 == null) goto L70;
        int r23 = this.E;
        if (r23 != (-1)) goto L38;
        Drawable r24 = null;
    L66:
        r20.setImageDrawable(r24);
        if (r24 != null) goto L69;
        r20.setVisibility(4);
        goto L70
    L69:
        r20.setVisibility(0);
        r24.setVisible(false, false);
        r24.setVisible(true, false);
        goto L70
    L38:
        r24 = g(r22.getString(r23));
        if (r24 != null) goto L66;
        ComponentName r25 = this.f1235v.getSearchActivity();
        String r112 = r25.flattenToShortString();
        WeakHashMap<String, Drawable.ConstantState> r113 = this.f1237x;
        if (r113.containsKey(r112) == false) goto L47;
        Drawable.ConstantState r26 = r113.get(r112);
        if (r26 != null) goto L46;
        r24 = null;
    L63:
        if (r24 != null) goto L66;
        r24 = r15.getPackageManager().getDefaultActivityIcon();
        goto L66
    L46:
        r24 = r26.newDrawable(r15.getResources());
        goto L63
    L47:
        PackageManager r114 = r15.getPackageManager();
        ActivityInfo r115 = r114.getActivityInfo(r25, 128);     // Catch: PackageManager.NameNotFoundException -> L55
        int r116 = r115.getIconResource();
        if (r116 == 0) goto L58;
        Drawable r117 = r114.getDrawable(r25.getPackageName(), r116, r115.applicationInfo);
        if (r117 != null) goto L59;
        StringBuilder r118 = defpackage.b.f("Invalid icon resource ", r116, " for ");
        r118.append(r25.flattenToShortString());
        String r27 = r118.toString();
    L57:
        Log.w("SuggestionsAdapter", r27);
    L59:
        if (r117 != null) goto L61;
        Drawable.ConstantState r28 = null;
    L62:
        r113.put(r112, r28);
        r24 = r117;
        goto L63
    L61:
        r28 = r117.getConstantState();
    L58:
        r117 = null;
    L55:
        e = move-exception;
        r27 = e.toString();
    L70:
        ImageView r29 = r8.f1243d;
        if (r29 == null) goto L80;
        int r30 = this.F;
        if (r30 != (-1)) goto L75;
        Drawable r31 = null;
    L76:
        r29.setImageDrawable(r31);
        if (r31 != null) goto L79;
        r29.setVisibility(8);
        goto L80
    L79:
        r29.setVisibility(0);
        r31.setVisible(false, false);
        r31.setVisible(true, false);
        goto L80
    L75:
        r31 = g(r22.getString(r30));
    L80:
        int r32 = this.f1239z;
        ImageView r33 = r8.f1244e;
        if (r32 == 2) goto L87;
        if (r32 == 1) goto L84;
    L86:
        r33.setVisibility(8);
        return;
    L84:
        if ((r11 & 1) == 0) goto L86;
    L87:
        r33.setVisibility(0);
        r33.setTag(r12.getText());
        r33.setOnClickListener(this);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // n0.a
    public final void c(Cursor r8) {
        super.c(r8);     // Catch: Exception -> L6
        if (r8 == null) goto L11;
        this.B = r8.getColumnIndex("suggest_text_1");     // Catch: Exception -> L6
        this.C = r8.getColumnIndex("suggest_text_2");     // Catch: Exception -> L6
        this.D = r8.getColumnIndex("suggest_text_2_url");     // Catch: Exception -> L6
        this.E = r8.getColumnIndex("suggest_icon_1");     // Catch: Exception -> L6
        this.F = r8.getColumnIndex("suggest_icon_2");     // Catch: Exception -> L6
        this.G = r8.getColumnIndex("suggest_flags");     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
    }

    @Override // n0.a
    public final String d(Cursor r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        String r10 = i(r8, r8.getColumnIndex("suggest_intent_query"));
        if (r10 == null) goto L8;
        return r10;
    L8:
        SearchableInfo r11 = this.f1235v;
        if (r11.shouldRewriteQueryFromData() == false) goto L14;
        String r12 = i(r8, r8.getColumnIndex("suggest_intent_data"));
        if (r12 == null) goto L14;
        return r12;
    L14:
        if (r11.shouldRewriteQueryFromText() == false) goto L18;
        String r13 = i(r8, r8.getColumnIndex("suggest_text_1"));
        if (r13 == null) goto L18;
        return r13;
    L18:
        return null;
    }

    @Override // n0.a
    public final View e(ViewGroup r8) {
        View r10 = this.f9418t.inflate(this.f9416r, r8, false);
        r10.setTag(new a(r10));
        ((ImageView) r10.findViewById(com.obric.cae.R.id.edit_query)).setImageResource(this.f1238y);
        return r10;
    }

    public final Drawable f(Uri r8) {
        String r10 = r8.getAuthority();
        if (TextUtils.isEmpty(r10) == true) goto L28;
        Resources r11 = this.f1236w.getPackageManager().getResourcesForApplication(r10);     // Catch: PackageManager.NameNotFoundException -> L25
        List<String> r12 = r8.getPathSegments();
        if (r12 == null) goto L24;
        int r13 = r12.size();
        if (r13 != 1) goto L14;
        int r14 = Integer.parseInt(r12.get(0));     // Catch: NumberFormatException -> L11
    L16:
        if (r14 == 0) goto L20;
        return r11.getDrawable(r14);
    L20:
        throw new FileNotFoundException(defpackage.b.b("No resource found for: ", r8));
    L12:
        throw new FileNotFoundException(defpackage.b.b("Single path segment is not a resource ID: ", r8));
    L14:
        if (r13 != 2) goto L22;
        r14 = r11.getIdentifier(r12.get(1), r12.get(0), r10);
        goto L16
    L22:
        throw new FileNotFoundException(defpackage.b.b("More than two path segments: ", r8));
    L24:
        throw new FileNotFoundException(defpackage.b.b("No path: ", r8));
    L26:
        throw new FileNotFoundException(defpackage.b.b("No package found for authority: ", r8));
    L28:
        throw new FileNotFoundException(defpackage.b.b("No authority: ", r8));
    }

    public final Drawable g(String r11) {
        WeakHashMap<String, Drawable.ConstantState> r8 = this.f1237x;
        Context r10 = this.f1236w;
        Drawable r12 = null;
        if (r11 != null) goto L5;
    L54:
        return r12;
    L5:
        if (r11.isEmpty() == true) goto L54;
        if ("0".equals(r11) == true) goto L54;
        int r13 = Integer.parseInt(r11);     // Catch: Resources.NotFoundException -> L19 NumberFormatException -> L21
        String r14 = "android.resource://" + r10.getPackageName() + "/" + r13;     // Catch: Resources.NotFoundException -> L19 NumberFormatException -> L21
        Drawable.ConstantState r15 = r8.get(r14);     // Catch: Resources.NotFoundException -> L19 NumberFormatException -> L21
        if (r15 != null) goto L12;
        Drawable r16 = null;
    L13:
        if (r16 == null) goto L15;
        return r16;
    L15:
        Object r17 = androidx.core.content.a.f1674a;     // Catch: Resources.NotFoundException -> L19 NumberFormatException -> L21
        Drawable r18 = androidx.core.content.a.b.b(r10, r13);     // Catch: Resources.NotFoundException -> L19 NumberFormatException -> L21
        if (r18 == null) goto L18;
        r8.put(r14, r18.getConstantState());     // Catch: Resources.NotFoundException -> L19 NumberFormatException -> L21
    L18:
        return r18;
    L12:
        r16 = r15.newDrawable();     // Catch: Resources.NotFoundException -> L19 NumberFormatException -> L21
    L19:
        Log.w("SuggestionsAdapter", "Icon resource not found: ".concat(r11));
        return null;
    L21:
        Drawable.ConstantState r19 = r8.get(r11);
        if (r19 != null) goto L24;
        Drawable r20 = null;
    L25:
        if (r20 == null) goto L27;
        return r20;
    L27:
        Uri r21 = Uri.parse(r11);
    L50:
        e = move-exception;
        Log.w("SuggestionsAdapter", "Icon not found: " + r21 + ", " + e.getMessage());
    L52:
        if (r12 == null) goto L54;
        r8.put(r11, r12.getConstantState());
        goto L54
    L29:
        if ("android.resource".equals(r21.getScheme()) == true) goto L62;
        InputStream r110 = r10.getContentResolver().openInputStream(r21);     // Catch: FileNotFoundException -> L50
        if (r110 == null) goto L49;
        Drawable r22 = Drawable.createFromStream(r110, null);     // Catch: Throwable -> L42
        r110.close();     // Catch: IOException -> L39
    L41:
        r12 = r22;
        goto L52
    L39:
        e = move-exception;
        Log.e("SuggestionsAdapter", "Error closing icon stream for " + r21, e);     // Catch: FileNotFoundException -> L50
        goto L41
    L42:
        th = move-exception;
        r110.close();     // Catch: IOException -> L45
    L47:
        throw th;     // Catch: FileNotFoundException -> L50
    L45:
        e = move-exception;
        Log.e("SuggestionsAdapter", "Error closing icon stream for " + r21, e);     // Catch: FileNotFoundException -> L50
        goto L47
    L49:
        throw new FileNotFoundException("Failed to open " + r21);     // Catch: FileNotFoundException -> L50
    L62:
        r12 = f(r21);     // Catch: Resources.NotFoundException -> L32 FileNotFoundException -> L50
        goto L52
    L33:
        throw new FileNotFoundException("Resource does not exist: " + r21);     // Catch: FileNotFoundException -> L50
    L24:
        r20 = r19.newDrawable();
        goto L25
    }

    @Override // n0.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int r8, View r10, ViewGroup r11) {
        return super.getDropDownView(r8, r10, r11);
    L4:
        e = move-exception;
        Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
        View r12 = this.f9418t.inflate(this.f9417s, r11, false);
        if (r12 == null) goto L8;
        ((a) r12.getTag()).f1240a.setText(e.toString());
    L8:
        return r12;
    }

    @Override // n0.a, android.widget.Adapter
    public final View getView(int r8, View r10, ViewGroup r11) {
        return super.getView(r8, r10, r11);
    L4:
        e = move-exception;
        Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
        View r12 = e(r11);
        ((a) r12.getTag()).f1240a.setText(e.toString());
        return r12;
    }

    public final Cursor h(SearchableInfo r10, String r11) {
        String[] r8 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        String r12 = r10.getSuggestAuthority();
        if (r12 != null) goto L8;
        return null;
    L8:
        Uri.Builder r13 = new Uri.Builder().scheme("content").authority(r12).query("").fragment("");
        String r14 = r10.getSuggestPath();
        if (r14 == null) goto L11;
        r13.appendEncodedPath(r14);
    L11:
        r13.appendPath("search_suggest_query");
        String r15 = r10.getSuggestSelection();
        if (r15 == null) goto L14;
        r8 = new String[]{r11};
    L15:
        r13.appendQueryParameter("limit", String.valueOf(50));
        Uri r16 = r13.build();
        ContentResolver r17 = this.f1236w.getContentResolver();
        return r17.query(r16, null, r15, r8, null);
    L14:
        r13.appendPath(r11);
        goto L15
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Cursor r8 = this.f9408m;
        if (r8 == null) goto L5;
        Bundle r10 = r8.getExtras();
    L6:
        if (r10 == null) goto L9;
        r10.getBoolean("in_progress");
        return;
    L9:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        Cursor r8 = this.f9408m;
        if (r8 == null) goto L5;
        Bundle r10 = r8.getExtras();
    L6:
        if (r10 == null) goto L9;
        r10.getBoolean("in_progress");
        return;
    L9:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        Object r10 = r8.getTag();
        if ((r10 instanceof CharSequence) == false) goto L6;
        this.f1234u.o((CharSequence) r10);
        return;
    }
}
