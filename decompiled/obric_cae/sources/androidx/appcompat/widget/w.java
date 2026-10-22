package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f1277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t0 f1278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t0 f1279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t0 f1280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t0 f1281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t0 f1282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t0 f1283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t0 f1284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z f1285i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1286j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1287k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Typeface f1288l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1289m;

    public class a extends z.f.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f1292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ w f1293d;

        public a(w r8, int r10, int r11, WeakReference r12) {
            this.f1293d = r8;
            this.f1290a = r10;
            this.f1291b = r11;
            this.f1292c = r12;
        }

        @Override // z.f.e
        public final void c(int r8) {
        }

        @Override // z.f.e
        public final void d(Typeface r8) {
            int r10 = this.f1290a;
            if (r10 != (-1)) goto L5;
        L9:
            w r11 = this.f1293d;
            if (r11.f1289m == false) goto L18;
            r11.f1288l = r8;
            TextView r12 = (TextView) this.f1292c.get();
            if (r12 == null) goto L19;
            WeakHashMap<View, j0.h0> r13 = j0.w.f8437a;
            if (j0.w.g.b(r12) == false) goto L16;
            r12.post(new x(r12, r8, r11.f1286j));
            return;
        L16:
            r12.setTypeface(r8, r11.f1286j);
            return;
        L19:
            return;
        L18:
            return;
        L5:
            if ((this.f1291b & 2) == 0) goto L7;
            boolean r14 = true;
        L8:
            r8 = e.a(r8, r10, r14);
            goto L9
        L7:
            r14 = false;
            goto L8
        }
    }

    public static class b {
        public static Drawable[] a(TextView r8) {
            return r8.getCompoundDrawablesRelative();
        }

        public static void b(TextView r8, Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
            r8.setCompoundDrawablesRelativeWithIntrinsicBounds(r10, r11, r12, r13);
        }

        public static void c(TextView r8, Locale r10) {
            r8.setTextLocale(r10);
        }
    }

    public static class c {
        public static LocaleList a(String r8) {
            return LocaleList.forLanguageTags(r8);
        }

        public static void b(TextView r8, LocaleList r10) {
            r8.setTextLocales(r10);
        }
    }

    public static class d {
        public static int a(TextView r8) {
            return r8.getAutoSizeStepGranularity();
        }

        public static void b(TextView r8, int r10, int r11, int r12, int r13) {
            r8.setAutoSizeTextTypeUniformWithConfiguration(r10, r11, r12, r13);
        }

        public static void c(TextView r8, int[] r10, int r11) {
            r8.setAutoSizeTextTypeUniformWithPresetSizes(r10, r11);
        }

        public static boolean d(TextView r8, String r10) {
            return r8.setFontVariationSettings(r10);
        }
    }

    public static class e {
        public static Typeface a(Typeface r8, int r10, boolean r11) {
            return Typeface.create(r8, r10, r11);
        }
    }

    public w(TextView r8) {
        this.f1286j = 0;
        this.f1287k = -1;
        this.f1277a = r8;
        this.f1285i = new z(r8);
    }

    public static t0 c(Context r8, j r10, int r11) {
        monitor-enter(r10);
        ColorStateList r12 = r10.f1193a.h(r8, r11);     // Catch: Throwable -> L10
        monitor-exit(r10);
        if (r12 == null) goto L8;
        t0 r13 = new t0();
        r13.f1265d = true;
        r13.f1262a = r12;
        return r13;
    L8:
        return null;
    L10:
        th = move-exception;
        throw th;
    }

    public final void a(Drawable r8, t0 r10) {
        if (r8 == null) goto L6;
        if (r10 == null) goto L7;
        j.e(r8, r10, this.f1277a.getDrawableState());
        return;
    L7:
        return;
    }

    public final void b() {
        t0 r8 = this.f1278b;
        TextView r10 = this.f1277a;
        if (r8 == null) goto L5;
    L10:
        Drawable[] r11 = r10.getCompoundDrawables();
        a(r11[0], this.f1278b);
        a(r11[1], this.f1279c);
        a(r11[2], this.f1280d);
        a(r11[3], this.f1281e);
    L12:
        if (this.f1282f == null) goto L14;
    L15:
        Drawable[] r12 = b.a(r10);
        a(r12[0], this.f1282f);
        a(r12[2], this.f1283g);
        return;
    L14:
        if (this.f1283g != null) goto L15;
        return;
    L5:
        if (this.f1279c != null) goto L10;
        if (this.f1280d != null) goto L10;
        if (this.f1281e == null) goto L12;
        goto L10
    }

    public final ColorStateList d() {
        t0 r8 = this.f1284h;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1262a;
    }

    public final PorterDuff.Mode e() {
        t0 r8 = this.f1284h;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1263b;
    }

    @SuppressLint({"NewApi"})
    public final void f(AttributeSet r23, int r24) {
        TextView r10 = this.f1277a;
        Context r11 = r10.getContext();
        j r12 = j.a();
        int[] r8 = c.a.f3222h;
        v0 r13 = v0.m(r11, r23, r8, r24);
        Context r14 = r10.getContext();
        TypedArray r15 = r13.f1275b;
        WeakHashMap<View, j0.h0> r16 = j0.w.f8437a;
        j0.w.m.c(r10, r14, r8, r23, r15, r24, 0);
        int r17 = r13.i(0, -1);
        if (r13.l(3) == false) goto L6;
        this.f1278b = c(r11, r12, r13.i(3, 0));
    L6:
        if (r13.l(1) == false) goto L9;
        this.f1279c = c(r11, r12, r13.i(1, 0));
    L9:
        if (r13.l(4) == false) goto L12;
        this.f1280d = c(r11, r12, r13.i(4, 0));
    L12:
        if (r13.l(2) == false) goto L15;
        this.f1281e = c(r11, r12, r13.i(2, 0));
    L15:
        if (r13.l(5) == false) goto L18;
        this.f1282f = c(r11, r12, r13.i(5, 0));
    L18:
        if (r13.l(6) == false) goto L20;
        this.f1283g = c(r11, r12, r13.i(6, 0));
    L20:
        r13.n();
        boolean r18 = r10.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] r19 = c.a.f3238x;
        if (r17 == (-1)) goto L37;
        v0 r20 = new v0(r11, r11.obtainStyledAttributes(r17, r19));
        if (r18 == false) goto L25;
    L27:
        boolean r21 = false;
        boolean r110 = false;
    L28:
        j(r11, r20);
        if (r20.l(15) == false) goto L31;
        String r111 = r20.j(15);
    L33:
        if (r20.l(13) == false) goto L35;
        String r22 = r20.j(13);
    L36:
        r20.n();
    L38:
        v0 r25 = new v0(r11, r11.obtainStyledAttributes(r23, r19, r24, 0));
        if (r18 == true) goto L44;
        if (r25.l(14) == false) goto L44;
        r21 = r25.a(14, false);
        r110 = true;
    L44:
        if (r25.l(15) == false) goto L47;
        r111 = r25.j(15);
    L47:
        if (r25.l(13) == false) goto L49;
        r22 = r25.j(13);
    L49:
        String r26 = r22;
        if (r25.l(0) == true) goto L52;
    L54:
        j(r11, r25);
        r25.n();
        if (r18 == true) goto L58;
        if (r110 == false) goto L58;
        r10.setAllCaps(r21);
    L58:
        Typeface r27 = this.f1288l;
        if (r27 != null) goto L61;
    L64:
        if (r26 == null) goto L66;
        d.d(r10, r26);
    L66:
        if (r111 == null) goto L68;
        c.b(r10, c.a(r111));
    L68:
        int[] r28 = c.a.f3223i;
        z r29 = this.f1285i;
        Context r30 = r29.f1331i;
        TypedArray r31 = r30.obtainStyledAttributes(r23, r28, r24, 0);
        TextView r32 = r29.f1330h;
        j0.w.m.c(r32, r32.getContext(), r28, r23, r31, r24, 0);
        if (r31.hasValue(5) == false) goto L72;
        r29.f1323a = r31.getInt(5, 0);
    L72:
        if (r31.hasValue(4) == false) goto L74;
        float r33 = r31.getDimension(4, -1.0f);
    L76:
        if (r31.hasValue(2) == false) goto L78;
        float r34 = r31.getDimension(2, -1.0f);
    L80:
        if (r31.hasValue(1) == false) goto L82;
        float r35 = r31.getDimension(1, -1.0f);
    L84:
        if (r31.hasValue(3) == false) goto L94;
        int r36 = r31.getResourceId(3, 0);
        if (r36 <= 0) goto L94;
        TypedArray r37 = r31.getResources().obtainTypedArray(r36);
        int r38 = r37.length();
        int[] r112 = new int[r38];
        if (r38 <= 0) goto L93;
        int r113 = 0;
    L90:
        if (r113 >= r38) goto L92;
        r112[r113] = r37.getDimensionPixelSize(r113, -1);
        r113 = r113 + 1;
        goto L90
    L92:
        r29.f1328f = z.a(r112);
        r29.c();
    L93:
        r37.recycle();
    L94:
        r31.recycle();
        if (r29.d() == true) goto L97;
        r29.f1323a = 0;
    L113:
        Method r39 = b1.f1104a;
        if (r29.f1323a == 0) goto L121;
        int[] r40 = r29.f1328f;
        if (r40.length <= 0) goto L121;
        if (d.a(r10) == (-1.0f)) goto L120;
        d.b(r10, Math.round(r29.f1326d), Math.round(r29.f1327e), Math.round(r29.f1325c), 0);
        goto L121
    L120:
        d.c(r10, r40, 0);
    L121:
        v0 r41 = new v0(r11, r11.obtainStyledAttributes(r23, r28));
        int r42 = r41.i(8, -1);
        if (r42 == (-1)) goto L124;
        Drawable r43 = r12.b(r11, r42);
        int r44 = 13;
    L125:
        int r45 = r41.i(r44, -1);
        if (r45 == (-1)) goto L128;
        Drawable r46 = r12.b(r11, r45);
    L129:
        int r47 = r41.i(9, -1);
        if (r47 == (-1)) goto L132;
        Drawable r48 = r12.b(r11, r47);
    L133:
        int r49 = r41.i(6, -1);
        if (r49 == (-1)) goto L136;
        Drawable r50 = r12.b(r11, r49);
    L137:
        int r51 = r41.i(10, -1);
        if (r51 == (-1)) goto L140;
        Drawable r52 = r12.b(r11, r51);
    L141:
        int r53 = r41.i(7, -1);
        if (r53 == (-1)) goto L144;
        Drawable r54 = r12.b(r11, r53);
    L145:
        if (r52 != null) goto L179;
        if (r54 != null) goto L179;
        if (r43 != null) goto L152;
        if (r46 != null) goto L152;
        if (r48 != null) goto L152;
        if (r50 != null) goto L152;
    L194:
        if (r41.l(11) == false) goto L197;
        androidx.core.widget.m.f(r10, r41.b(11));
    L197:
        if (r41.l(12) == false) goto L199;
        int r55 = -1;
        androidx.core.widget.m.g(r10, d0.b(r41.h(12, -1), null));
    L200:
        int r56 = r41.d(15, r55);
        int r57 = r41.d(18, r55);
        int r58 = r41.d(19, r55);
        r41.n();
        if (r56 == r55) goto L203;
        t2.b.m(r56);
        androidx.core.widget.n.c(r10, r56);
    L203:
        if (r57 == r55) goto L212;
        t2.b.m(r57);
        Paint.FontMetricsInt r59 = r10.getPaint().getFontMetricsInt();
        if (androidx.core.widget.k.a(r10) == false) goto L207;
        int r60 = r59.bottom;
    L209:
        if (r57 <= Math.abs(r60)) goto L211;
        r10.setPadding(r10.getPaddingLeft(), r10.getPaddingTop(), r10.getPaddingRight(), r57 - r60);
    L211:
        int r61 = -1;
    L213:
        if (r58 == r61) goto L219;
        t2.b.m(r58);
        int r62 = r10.getPaint().getFontMetricsInt(null);
        if (r58 == r62) goto L220;
        r10.setLineSpacing(r58 - r62, 1.0f);
        return;
    L220:
        return;
    L219:
        return;
    L207:
        r60 = r59.descent;
        goto L209
    L212:
        r61 = r55;
        goto L213
    L199:
        r55 = -1;
    L152:
        Drawable[] r63 = b.a(r10);
        Drawable r64 = r63[0];
        if (r64 == null) goto L155;
    L171:
        if (r46 != null) goto L174;
        r46 = r63[1];
    L174:
        Drawable r65 = r63[2];
        if (r50 != null) goto L178;
        r50 = r63[3];
    L178:
        b.b(r10, r64, r46, r65, r50);
        goto L194
    L155:
        if (r63[2] != null) goto L171;
        Drawable[] r66 = r10.getCompoundDrawables();
        if (r43 != null) goto L161;
        r43 = r66[0];
    L161:
        if (r46 != null) goto L164;
        r46 = r66[1];
    L164:
        if (r48 != null) goto L167;
        r48 = r66[2];
    L167:
        if (r50 != null) goto L170;
        r50 = r66[3];
    L170:
        r10.setCompoundDrawablesWithIntrinsicBounds(r43, r46, r48, r50);
    L179:
        Drawable[] r67 = b.a(r10);
        if (r52 != null) goto L183;
        r52 = r67[0];
    L183:
        if (r46 != null) goto L186;
        r46 = r67[1];
    L186:
        if (r54 != null) goto L189;
        r54 = r67[2];
    L189:
        if (r50 != null) goto L192;
        r50 = r67[3];
    L192:
        b.b(r10, r52, r46, r54, r50);
        goto L194
    L144:
        r54 = null;
        goto L145
    L140:
        r52 = null;
        goto L141
    L136:
        r50 = null;
        goto L137
    L132:
        r48 = null;
        goto L133
    L128:
        r46 = null;
        goto L129
    L124:
        r44 = 13;
        r43 = null;
        goto L125
    L97:
        if (r29.f1323a != 1) goto L113;
        if (r29.f1329g == true) goto L111;
        DisplayMetrics r68 = r30.getResources().getDisplayMetrics();
        if (r34 != (-1.0f)) goto L103;
        int r69 = 2;
        r34 = TypedValue.applyDimension(2, 12.0f, r68);
    L105:
        if (r35 != (-1.0f)) goto L108;
        r35 = TypedValue.applyDimension(r69, 112.0f, r68);
    L108:
        if (r33 != (-1.0f)) goto L110;
        r33 = 1.0f;
    L110:
        r29.e(r34, r35, r33);
        goto L111
    L103:
        r69 = 2;
    L111:
        r29.b();
        goto L113
    L82:
        r35 = -1.0f;
        goto L84
    L78:
        r34 = -1.0f;
        goto L80
    L74:
        r33 = -1.0f;
        goto L76
    L61:
        if (this.f1287k != (-1)) goto L63;
        r10.setTypeface(r27, this.f1286j);
        goto L64
    L63:
        r10.setTypeface(r27);
        goto L64
    L52:
        if (r25.d(0, -1) != 0) goto L54;
        r10.setTextSize(0, 0.0f);
        goto L54
    L35:
        r22 = null;
        goto L36
    L31:
        r111 = null;
        goto L33
    L25:
        if (r20.l(14) == false) goto L27;
        r21 = r20.a(14, false);
        r110 = true;
        goto L28
    L37:
        r111 = null;
        r22 = null;
        r21 = false;
        r110 = false;
        goto L38
    }

    public final void g(Context r8, int r10) {
        v0 r11 = new v0(r8, r8.obtainStyledAttributes(r10, c.a.f3238x));
        boolean r12 = r11.l(14);
        TextView r13 = this.f1277a;
        if (r12 == false) goto L6;
        r13.setAllCaps(r11.a(14, false));
    L6:
        if (r11.l(0) == true) goto L8;
    L10:
        j(r8, r11);
        if (r11.l(13) == false) goto L15;
        String r14 = r11.j(13);
        if (r14 == null) goto L15;
        d.d(r13, r14);
    L15:
        r11.n();
        Typeface r15 = this.f1288l;
        if (r15 == null) goto L19;
        r13.setTypeface(r15, this.f1286j);
        return;
    L19:
        return;
    L8:
        if (r11.d(0, -1) != 0) goto L10;
        r13.setTextSize(0, 0.0f);
        goto L10
    }

    public final void h(ColorStateList r8) {
        if (this.f1284h != null) goto L5;
        this.f1284h = new t0();
    L5:
        t0 r10 = this.f1284h;
        r10.f1262a = r8;
        if (r8 == null) goto L8;
        boolean r11 = true;
    L9:
        r10.f1265d = r11;
        this.f1278b = r10;
        this.f1279c = r10;
        this.f1280d = r10;
        this.f1281e = r10;
        this.f1282f = r10;
        this.f1283g = r10;
        return;
    L8:
        r11 = false;
        goto L9
    }

    public final void i(PorterDuff.Mode r8) {
        if (this.f1284h != null) goto L5;
        this.f1284h = new t0();
    L5:
        t0 r10 = this.f1284h;
        r10.f1263b = r8;
        if (r8 == null) goto L8;
        boolean r11 = true;
    L9:
        r10.f1264c = r11;
        this.f1278b = r10;
        this.f1279c = r10;
        this.f1280d = r10;
        this.f1281e = r10;
        this.f1282f = r10;
        this.f1283g = r10;
        return;
    L8:
        r11 = false;
        goto L9
    }

    public final void j(Context r10, v0 r11) {
        this.f1286j = r11.h(2, this.f1286j);
        int r8 = r11.h(11, -1);
        this.f1287k = r8;
        boolean r12 = false;
        if (r8 == (-1)) goto L5;
        this.f1286j = (this.f1286j & 2) | 0;
    L5:
        int r13 = 10;
        if (r11.l(10) == false) goto L8;
    L23:
        this.f1288l = null;
        if (r11.l(12) == false) goto L26;
        r13 = 12;
    L26:
        int r14 = this.f1287k;
        int r15 = this.f1286j;
        if (r10.isRestricted() == true) goto L45;
        Typeface r16 = r11.g(r13, this.f1286j, new a(this, r14, r15, new WeakReference(this.f1277a)));     // Catch: Throwable -> L57
        if (r16 == null) goto L40;
        if (this.f1287k == (-1)) goto L38;
        Typeface r17 = Typeface.create(r16, 0);     // Catch: Throwable -> L57
        int r18 = this.f1287k;     // Catch: Throwable -> L57
        if ((this.f1286j & 2) == 0) goto L36;
        boolean r19 = true;
    L37:
        r16 = e.a(r17, r18, r19);     // Catch: Throwable -> L57
        goto L38
    L36:
        r19 = false;
    L38:
        this.f1288l = r16;     // Catch: Throwable -> L57
    L40:
        if (this.f1288l != null) goto L42;
        boolean r20 = true;
    L43:
        this.f1289m = r20;     // Catch: Throwable -> L57
        goto L45
    L42:
        r20 = false;
    L45:
        if (this.f1288l != null) goto L62;
        String r21 = r11.j(r13);
        if (r21 != null) goto L49;
        return;
    L49:
        if (this.f1287k == (-1)) goto L54;
        Typeface r22 = Typeface.create(r21, 0);
        int r110 = this.f1287k;
        if ((this.f1286j & 2) == 0) goto L53;
        r12 = true;
    L53:
        Typeface r23 = e.a(r22, r110, r12);
    L55:
        this.f1288l = r23;
        return;
    L54:
        r23 = Typeface.create(r21, this.f1286j);
        goto L55
    L62:
        return;
    L8:
        if (r11.l(12) == true) goto L23;
        if (r11.l(1) == false) goto L60;
        this.f1289m = false;
        int r24 = r11.h(1, 1);
        if (r24 == 1) goto L20;
        if (r24 != 2) goto L16;
        Typeface r25 = Typeface.SERIF;
    L21:
        this.f1288l = r25;
        return;
    L16:
        if (r24 != 3) goto L61;
        r25 = Typeface.MONOSPACE;
        goto L21
    L61:
        return;
    L20:
        r25 = Typeface.SANS_SERIF;
        goto L21
    }
}
