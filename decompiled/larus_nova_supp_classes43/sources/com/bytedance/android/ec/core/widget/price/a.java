package com.bytedance.android.ec.core.widget.price;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.common.utility.UIUtils;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int K = 0;
    public float A;
    public Drawable B;
    public Long C;
    public b D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public Typeface I;
    public int J;
    public c a;
    public final TextView b;
    public float c;
    public Long d;
    public String e;
    public int f;
    public float g;
    public boolean h;
    public boolean i;
    public float j;
    public boolean k;
    public int l;
    public boolean m;
    public int n;
    public float o;
    public String p;
    public boolean q;
    public float r;
    public int s;
    public int t;
    public float u;
    public String v;
    public boolean w;
    public float x;
    public int y;
    public int z;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.widget.price.a$a, reason: collision with other inner class name */
    public static final class C0147a {
    }

    public static final class b {
        public final float a;
        public final float b;
        public final float c;
        public final int d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof b) == false) goto L14;
            b r11 = (b) r10;
            if (Float.compare(this.a, r11.a) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.b, r11.b) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.c, r11.c) == 0) goto L12;
            return false;
        L12:
            if (this.d == r11.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + this.d;
        }

        public final String toString() {
            return "Shadow(radius=" + this.a + ", dx=" + this.b + ", dy=" + this.c + ", shadowColor=" + this.d + ")";
        }

        public b(int r10) {
            this.a = 2.0f;
            this.b = 0.0f;
            this.c = 2.0f;
            this.d = r10;
        }
    }

    public static final class c {
        public final int a;
        public final int b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof c) == false) goto L10;
            c r11 = (c) r10;
            if (this.a == r11.a) goto L8;
            return false;
        L8:
            if (this.b == r11.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "StrikeRange(start=" + this.a + ", end=" + this.b + ")";
        }

        public c(int r1, int r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    static {
    }

    private final Context getContext() {
        return this.b.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.text.SpannableString] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.widget.TextView] */
    public final void a() {
        int r1 = com.bytedance.android.ec.core.widget.price.b.a;
        Intrinsics.checkNotNullParameter(this, "priceBuilder");
        Long r10 = this.d;
        String r11 = "";
        if (r10 == null) goto L117;
        long r12 = r10.longValue();
        ?? r13 = new SpannableStringBuilder();
        String r14 = this.p;
        if (r14 != null) goto L7;
    L18:
        int r15 = r13.length();
        if (this.i == true) goto L24;
        SpannableString r16 = new SpannableString("¥");
        r16.setSpan(new ForegroundColorSpan(this.f), 0, r16.length(), 17);
        r16.setSpan(new RelativeSizeSpan(this.j), 0, r16.length(), 17);
        if (this.k == false) goto L23;
        r16.setSpan(new StyleSpan(1), 0, r16.length(), 17);
    L23:
        r13.append(r16);
        SpannableString r17 = new SpannableString(" ");
        r17.setSpan(new com.bytedance.android.ec.core.widget.price.b.c(this.l), 0, r17.length(), 17);
        r13.append(r17);
    L24:
        String r18 = this.e;
        if (r18 == null) goto L30;
        String r19 = a2.d(r18);
        if (r19 == null) goto L30;
    L57:
        if (StringsKt.contains$default(r19, ".", false, 2, null) == false) goto L63;
        int r20 = StringsKt.indexOf$default(r19, ".", 0, false, 6, null);
        if (r19 == null) goto L62;
        String r21 = r19.substring(0, r20);
    L65:
        if (this.G == false) goto L69;
        Long r22 = StringsKt.toLongOrNull(r21);
        if (r22 == null) goto L69;
        r21 = String.format("%,d", Arrays.copyOf(new Object[]{r22}, 1));
    L69:
        String r23 = null;
        if (StringsKt.contains$default(r19, ".", false, 2, null) == false) goto L76;
        int r24 = StringsKt.indexOf$default(r19, ".", 0, false, 6, null);
        if (r19 == null) goto L75;
        r11 = r19.substring(r24);
        goto L76
    L75:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L76:
        SpannableString r25 = new SpannableString(r21);
        r25.setSpan(new ForegroundColorSpan(this.f), 0, r25.length(), 17);
        r25.setSpan(new RelativeSizeSpan(1.0f), 0, r25.length(), 17);
        b r26 = this.D;
        if (r26 == null) goto L80;
        r25.setSpan(new com.bytedance.android.ec.core.widget.price.b.C0148b(r26), 0, r25.length(), 17);
    L80:
        if (this.h == false) goto L82;
        r25.setSpan(new StyleSpan(1), 0, r25.length(), 17);
    L82:
        Typeface r27 = this.I;
        if (r27 == null) goto L85;
        r25.setSpan(new PriceTypefaceSpan(r27, this.h), 0, r25.length(), 17);
    L85:
        r13.append(r25);
        if (r11.length() <= 0) goto L88;
        boolean r28 = true;
    L89:
        if (r28 == false) goto L99;
        SpannableString r29 = new SpannableString(r11);
        r29.setSpan(new ForegroundColorSpan(this.f), 0, r29.length(), 17);
        r29.setSpan(new RelativeSizeSpan(this.g), 0, r29.length(), 17);
        if (this.h == false) goto L93;
        r29.setSpan(new StyleSpan(1), 0, r29.length(), 17);
    L93:
        Typeface r30 = this.I;
        if (r30 == null) goto L96;
        r29.setSpan(new PriceTypefaceSpan(r30, this.h), 0, r29.length(), 17);
    L96:
        r13.append(r29);
        b r31 = this.D;
        if (r31 == null) goto L99;
        r29.setSpan(new com.bytedance.android.ec.core.widget.price.b.C0148b(r31), 0, r29.length(), 17);
    L99:
        this.a = new c(r15, r13.length());
        String r32 = this.v;
        if (r32 != null) goto L102;
    L118:
        this.b.setText(r13);
        TextView r33 = this.b;
        Long r34 = this.d;
        if (r34 != null) goto L121;
    L140:
        String r35 = r23;
    L141:
        r33.setContentDescription(r35);
        this.b.requestLayout();
        return;
    L121:
        if (r34.longValue() <= 0) goto L140;
        StringBuilder r36 = new StringBuilder();
        if (TextUtils.isEmpty(this.p) == false) goto L130;
        Context r37 = getContext();
        if (this.m == false) goto L128;
        int r38 = 2131913940;
    L129:
        r36.append(r37.getString(r38));
    L131:
        long r39 = 100;
        r36.append(r34.longValue() / r39);
        r36.append(".");
        r36.append(r34.longValue() % r39);
        Long r40 = this.C;
        if (r40 == null) goto L136;
        Intrinsics.checkNotNull(r40);
        if (r40.longValue() <= 0) goto L136;
        r36.append("至");
        Long r41 = this.C;
        Intrinsics.checkNotNull(r41);
        r36.append(r41.longValue() / r39);
        r36.append(".");
        Long r42 = this.C;
        Intrinsics.checkNotNull(r42);
        r36.append(r42.longValue() % r39);
    L136:
        r36.append(getContext().getString(2131913847));
        if (TextUtils.isEmpty(this.v) == true) goto L139;
        r36.append(this.v);
    L139:
        r35 = r36.toString();
        goto L141
    L128:
        r38 = 2131913848;
        goto L129
    L130:
        r36.append(this.p);
        goto L131
    L102:
        if (r32.length() <= 0) goto L104;
        boolean r43 = true;
    L105:
        if (r43 != true) goto L118;
        Drawable r44 = this.B;
        if (r44 == null) goto L109;
        SpannableString r45 = new SpannableString(" ");
        int r46 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r47 = 17;
        r45.setSpan(new com.bytedance.android.ec.core.widget.price.b.c(com.bytedance.android.ec.hybrid.list.util.c.d(2)), 0, r45.length(), 17);
        r13.append(r45);
        r44.setBounds(0, 0, r44.getIntrinsicWidth(), r44.getIntrinsicHeight());
        SpannableString r48 = new SpannableString(" ");
        r48.setSpan(new ImageSpan(r44, 1), 0, r48.length(), 17);
        r13.append(r48);
    L110:
        SpannableString r49 = new SpannableString(" ");
        r49.setSpan(new com.bytedance.android.ec.core.widget.price.b.c(this.y), 0, r49.length(), r47);
        r13.append(r49);
        SpannableString r50 = new SpannableString(this.v);
        r50.setSpan(new ForegroundColorSpan(this.z), 0, r50.length(), r47);
        r50.setSpan(new RelativeSizeSpan(this.x), 0, r50.length(), r47);
        if (this.w == false) goto L114;
        r50.setSpan(new StyleSpan(1), 0, r50.length(), r47);
    L114:
        if (this.A <= 0) goto L116;
        r50.setSpan(new com.bytedance.android.ec.core.widget.price.b.a(0.15f), 0, r50.length(), r47);
    L116:
        r13.append(r50);
        goto L118
    L109:
        r47 = 17;
        goto L110
    L104:
        r43 = false;
        goto L105
    L88:
        r28 = false;
        goto L89
    L62:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L63:
        r21 = r19;
    L30:
        boolean r110 = this.H;
        Long r111 = this.C;
        int r112 = this.J;
        Long[] r51 = {Long.valueOf(r12), r111};
        if (ArraysKt.filterNotNull(r51).size() < 2) goto L33;
        boolean r52 = true;
    L34:
        if (r52 == false) goto L46;
        Long r53 = r51[0];
        if (r53 == null) goto L45;
        long r113 = r53.longValue();
        Long r54 = r51[1];
        if (r54 == null) goto L43;
        if (r113 >= r54.longValue()) goto L46;
        boolean r55 = true;
    L47:
        if (r55 == true) goto L49;
        if (r112 != 0) goto L49;
    L50:
        boolean r56 = true;
    L52:
        if (r56 != true) goto L54;
        String r57 = com.bytedance.android.ec.core.widget.price.b.b(r12, r110);
    L55:
        r19 = r57;
        goto L57
    L54:
        r57 = com.bytedance.android.ec.core.widget.price.b.b(r12, r110) + '-' + com.bytedance.android.ec.core.widget.price.b.b(r111.longValue(), r110);
    L49:
        if (r111 == null) goto L50;
        r56 = false;
        goto L52
    L43:
        throw new IllegalStateException("Required value was null.".toString());
    L45:
        throw new IllegalStateException("Required value was null.".toString());
    L46:
        r55 = false;
        goto L47
    L33:
        r52 = false;
        goto L34
    L7:
        if (r14.length() <= 0) goto L9;
        boolean r58 = true;
    L10:
        if (r58 != true) goto L18;
        SpannableString r59 = new SpannableString(this.p);
        r59.setSpan(new ForegroundColorSpan(this.s), 0, r59.length(), 17);
        r59.setSpan(new RelativeSizeSpan(this.r), 0, r59.length(), 17);
        if (this.q == false) goto L15;
        r59.setSpan(new StyleSpan(1), 0, r59.length(), 17);
    L15:
        if (this.u <= 0) goto L17;
        r59.setSpan(new com.bytedance.android.ec.core.widget.price.b.a(this.u), 0, r59.length(), 17);
    L17:
        r13.append(r59);
        SpannableString r60 = new SpannableString(" ");
        r60.setSpan(new com.bytedance.android.ec.core.widget.price.b.c(this.t), 0, r60.length(), 17);
        r13.append(r60);
        goto L18
    L9:
        r58 = false;
        goto L10
    L117:
        r23 = null;
        r13 = new SpannableString("");
        goto L118
    }

    public a(TextView r10) {
        float r0 = UIUtils.sp2px(r10.getContext(), 13.0f);
        int r1 = vf4.a.a(r10.getContext(), 2.0f);
        float r11 = vf4.a.a(r10.getContext(), 1.0f);
        int r12 = vf4.a.a(r10.getContext(), 4.0f);
        int r13 = vf4.a.a(r10.getContext(), 2.0f);
        Intrinsics.checkNotNullParameter(r10, "textView");
        this.b = r10;
        this.c = r0;
        this.d = null;
        this.e = null;
        this.f = -119723;
        this.g = 0.6666667f;
        this.h = false;
        this.i = false;
        this.j = 0.6666667f;
        this.k = false;
        this.l = r1;
        this.m = false;
        this.n = 0;
        this.o = r11;
        this.p = "";
        this.q = false;
        this.r = 1.0f;
        this.s = 0;
        this.t = r12;
        this.u = 0.0f;
        this.v = "";
        this.w = false;
        this.x = 1.0f;
        this.y = r13;
        this.z = 0;
        this.A = 0.0f;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = false;
        this.F = Integer.MAX_VALUE;
        this.G = false;
        this.H = false;
        this.I = null;
        this.J = 0;
    }
}
