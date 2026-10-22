package vfb;

import android.graphics.Rect;
import android.view.View;
import com.ss.android.lark.floating.enums.ShowPattern;
import com.ss.android.lark.floating.enums.SidePattern;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wfb.b;
import wfb.c;
import wfb.d;
import wfb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public f A;
    public wfb.a B;
    public final d C;
    public final b D;
    public final c E;
    public final Set<String> F;
    public final boolean G;
    public boolean H;
    public Integer a;
    public View b;
    public View c;
    public String d;
    public Boolean e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final boolean l;
    public SidePattern m;
    public ShowPattern n;
    public final boolean o;
    public final boolean p;
    public boolean q;
    public final float r;
    public final boolean s;
    public final boolean t;
    public int u;
    public final Pair<Integer, Integer> v;
    public int w;
    public int x;
    public Pair<Integer, Integer> y;
    public final List<Rect> z;

    public a() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (this.q == r6.q) goto L60;
        return false;
    L60:
        if (Float.compare(this.r, r6.r) == 0) goto L63;
        return false;
    L63:
        if (this.s == r6.s) goto L66;
        return false;
    L66:
        if (this.t == r6.t) goto L69;
        return false;
    L69:
        if (this.u == r6.u) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L75;
        return false;
    L75:
        if (this.w == r6.w) goto L78;
        return false;
    L78:
        if (this.x == r6.x) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r6.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r6.z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r6.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(null, null) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.B, r6.B) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.C, r6.C) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.D, r6.D) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.E, r6.E) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.F, r6.F) == true) goto L108;
        return false;
    L108:
        if (this.G == r6.G) goto L111;
        return false;
    L111:
        if (this.H == r6.H) goto L113;
        return false;
    L113:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        View r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        View r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (((((r12 + r14) * 31) + this.f) * 31) + this.g) * 31;
        int r16 = 1231;
        if (this.h == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.i == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        if (this.j == false) goto L33;
        int r21 = 1231;
    L34:
        int r22 = (r20 + r21) * 31;
        if (this.k == false) goto L37;
        int r23 = 1231;
    L38:
        int r24 = (r22 + r23) * 31;
        if (this.l == false) goto L41;
        int r25 = 1231;
    L42:
        int r26 = (((((r24 + r25) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31;
        if (this.o == false) goto L45;
        int r27 = 1231;
    L46:
        int r28 = (r26 + r27) * 31;
        if (this.p == false) goto L49;
        int r29 = 1231;
    L50:
        int r30 = (r28 + r29) * 31;
        if (this.q == false) goto L53;
        int r31 = 1231;
    L54:
        int r32 = (((r30 + r31) * 31) + Float.floatToIntBits(this.r)) * 31;
        if (this.s == false) goto L57;
        int r33 = 1231;
    L58:
        int r34 = (r32 + r33) * 31;
        if (this.t == false) goto L61;
        int r35 = 1231;
    L62:
        int r36 = (((((((((((((r34 + r35) * 31) + this.u) * 31) + this.v.hashCode()) * 31) + this.w) * 31) + this.x) * 31) + this.y.hashCode()) * 31) + this.z.hashCode()) * 31;
        f r37 = this.A;
        if (r37 != null) goto L65;
        int r38 = 0;
    L66:
        int r39 = (((r36 + r38) * 31) + 0) * 31;
        wfb.a r40 = this.B;
        if (r40 != null) goto L69;
        int r41 = 0;
    L70:
        int r42 = (r39 + r41) * 31;
        d r43 = this.C;
        if (r43 != null) goto L73;
        int r44 = 0;
    L74:
        int r45 = (r42 + r44) * 31;
        b r46 = this.D;
        if (r46 == null) goto L78;
        r1 = r46.hashCode();
    L78:
        int r47 = (((((r45 + r1) * 31) + this.E.hashCode()) * 31) + this.F.hashCode()) * 31;
        if (this.G == false) goto L81;
        int r48 = 1231;
    L82:
        int r49 = (r47 + r48) * 31;
        if (this.H == true) goto L87;
        r16 = 1237;
    L87:
        return r49 + r16;
    L81:
        r48 = 1237;
        goto L82
    L73:
        r44 = r43.hashCode();
        goto L74
    L69:
        r41 = r40.hashCode();
        goto L70
    L65:
        r38 = r37.hashCode();
        goto L66
    L61:
        r35 = 1237;
        goto L62
    L57:
        r33 = 1237;
        goto L58
    L53:
        r31 = 1237;
        goto L54
    L49:
        r29 = 1237;
        goto L50
    L45:
        r27 = 1237;
        goto L46
    L41:
        r25 = 1237;
        goto L42
    L37:
        r23 = 1237;
        goto L38
    L33:
        r21 = 1237;
        goto L34
    L29:
        r19 = 1237;
        goto L30
    L25:
        r17 = 1237;
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "FloatConfig(layoutId=" + this.a + ", layoutView=" + this.b + ", containerView=" + this.c + ", floatTag=" + this.d + ", onlyVc=" + this.e + ", vcSideHideBtnWidth=" + this.f + ", vcShadowWidth=" + this.g + ", dragEnable=" + this.h + ", isDrag=" + this.i + ", _isAnim=" + this.j + ", isShow=" + this.k + ", hasEditText=" + this.l + ", sidePattern=" + this.m + ", showPattern=" + this.n + ", keepScreenOn=" + this.o + ", hardwareAccelerated=" + this.p + ", banRequestPermission=" + this.q + ", dimBehind=" + this.r + ", widthMatch=" + this.s + ", heightMatch=" + this.t + ", gravity=" + this.u + ", offsetPair=" + this.v + ", targetOffsetX=" + this.w + ", targetOffsetY=" + this.x + ", locationPair=" + this.y + ", evictRects=" + this.z + ", invokeView=" + this.A + ", callbacks=null, floatCallbacks=" + this.B + ", floatAnimator=" + this.C + ", appFloatAnimator=" + this.D + ", displayHeight=" + this.E + ", filterSet=" + this.F + ", filterSelf=" + this.G + ", needShow=" + this.H + ')';
    }

    public a(Object r12) {
        SidePattern r13 = SidePattern.DEFAULT;
        ShowPattern r0 = ShowPattern.CURRENT_ACTIVITY;
        Pair<Integer, Integer> r1 = new Pair(0, 0);
        Pair<Integer, Integer> r3 = new Pair(0, 0);
        List<Rect> r4 = CollectionsKt.emptyList();
        ufb.d r5 = new ufb.d();
        ufb.c r6 = new ufb.c();
        xfb.c r7 = new xfb.c();
        LinkedHashSet r8 = new LinkedHashSet();
        Intrinsics.checkNotNullParameter(r13, "sidePattern");
        Intrinsics.checkNotNullParameter(r0, "showPattern");
        Intrinsics.checkNotNullParameter(r1, "offsetPair");
        Intrinsics.checkNotNullParameter(r3, "locationPair");
        Intrinsics.checkNotNullParameter(r4, "evictRects");
        Intrinsics.checkNotNullParameter(r7, "displayHeight");
        Intrinsics.checkNotNullParameter(r8, "filterSet");
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = -1;
        this.g = -1;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = r13;
        this.n = r0;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = -1.0f;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = r1;
        this.w = 0;
        this.x = 0;
        this.y = r3;
        this.z = r4;
        this.A = null;
        this.B = null;
        this.C = r5;
        this.D = r6;
        this.E = r7;
        this.F = r8;
        this.G = false;
        this.H = true;
    }
}
