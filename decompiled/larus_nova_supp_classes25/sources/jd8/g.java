package jd8;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.h9;
import com.larus.bmhome.chat.input.swipe.InputContentMode;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public boolean A;
    public boolean B;
    public int C;
    public long D;
    public int E;
    public int F;
    public u G;
    public View H;
    public s I;
    public ze8.d J;
    public d K;
    public int L;
    public ValueAnimator M;
    public float N;
    public float O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public float U;
    public int V;
    public int W;
    public int X;
    public boolean Y;
    public final int[] Z;
    public final ViewGroup a;
    public final View b;
    public final ICoreInputAbility c;
    public final va8.o d;
    public boolean e;
    public View f;
    public jd8.a g;
    public jd8.a h;
    public ze8.d i;
    public String j;
    public String k;
    public ze8.d l;
    public Integer m;
    public View n;
    public Integer o;
    public Drawable p;
    public boolean q;
    public Integer r;
    public final HashMap<String, Integer> s;
    public final HashMap<String, Boolean> t;
    public final HashMap<String, Boolean> u;
    public int v;
    public int w;
    public ze8.d x;
    public jd8.c y;
    public ViewTreeObserver z;

    public static final class a {
    }

    public static final class b {
        public final View a;
        public final int b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "SnapshotAlignmentState(view=" + this.a + ", topToTop=" + this.b + ", bottomToBottom=" + this.c + ')';
        }

        public b(View r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
        public final View a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "SnapshotVisibilityState(view=" + this.a + ", visibility=" + this.b + ')';
        }

        public c(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public static int u(boolean r0) {
        if (r0 == false) goto L4;
        return 0;
    L4:
        return 8;
    }

    public final void m() {
        ViewTreeObserver r0 = null;
        this.J = null;
        this.L = 0;
        d r1 = this.K;
        if (r1 != null) goto L5;
        return;
    L5:
        this.K = null;
        View r2 = this.H;
        if (r2 == null) goto L15;
        ViewTreeObserver r3 = r2.getViewTreeObserver();
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.isAlive() == false) goto L12;
        r0 = r3;
    L12:
        if (r0 == null) goto L17;
        r0.removeOnPreDrawListener(r1);
        return;
    L17:
        return;
    }

    public final void f() {
        jd8.a r0 = this.g;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        jd8.a r1 = this.g;
        if (r1 == null) goto L8;
        r1.a(null);
    L8:
        jd8.a r2 = this.g;
        if (r2 == null) goto L11;
        r2.setClipBounds(null);
    L11:
        jd8.a r3 = this.h;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
    L14:
        jd8.a r4 = this.h;
        if (r4 == null) goto L17;
        r4.a(null);
    L17:
        jd8.a r5 = this.h;
        if (r5 == null) goto L21;
        r5.setClipBounds(null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.ViewTreeObserver$OnPreDrawListener, jd8.d] */
    public final void g() {
        ze8.d r0 = this.x;
        if (r0 != null) goto L5;
        return;
    L5:
        this.x = null;
        l();
        o();
        s r2 = this.I;
        if (r2 == null) goto L8;
        r2.a();
    L8:
        View r3 = this.f;
        if (r3 == null) goto L12;
        r3.getLocationInWindow(this.Z);
        this.P = MathKt.roundToInt(this.Z[0] - r3.getTranslationX());
        this.Q = MathKt.roundToInt(this.Z[1] - r3.getTranslationY());
        this.R = r3.getWidth();
        this.S = r3.getHeight();
    L12:
        TextView r4 = j();
        if (r4 == null) goto L15;
        r4.scrollTo(0, t(r4));
    L15:
        Integer r5 = this.o;
        if (r5 == null) goto L20;
        int r6 = r5.intValue();
        View r7 = this.f;
        if (r7 == null) goto L20;
        r7.setVisibility(r6);
    L20:
        this.o = null;
        Integer r8 = this.m;
        if (r8 == null) goto L25;
        int r9 = r8.intValue();
        View r10 = this.n;
        if (r10 == null) goto L25;
        r10.setVisibility(r9);
    L25:
        this.m = null;
        this.n = null;
        if (this.q == false) goto L29;
        this.q = false;
        this.b.setBackground(this.p);
        this.p = null;
    L29:
        jd8.a r11 = this.g;
        if (r11 == null) goto L32;
        r11.setVisibility(8);
    L32:
        jd8.a r12 = this.g;
        if (r12 == null) goto L35;
        r12.a(null);
    L35:
        jd8.a r13 = this.g;
        if (r13 == null) goto L38;
        r13.setClipBounds(null);
    L38:
        jd8.a r14 = this.h;
        if (r14 != null) goto L41;
    L44:
        f();
    L45:
        View r15 = this.H;
        if (r15 != null) goto L48;
    L55:
        ValueAnimator r1 = this.M;
        if (r1 == null) goto L58;
        this.M = null;
        r1.removeAllListeners();
        r1.cancel();
    L58:
        f();
        s r16 = this.I;
        if (r16 == null) goto L61;
        r16.e();
    L61:
        this.j = null;
        this.k = null;
        this.i = null;
        this.s.clear();
        this.t.clear();
        this.u.clear();
        return;
    L48:
        if (this.G == null) goto L55;
        this.J = r0;
        this.L = 0;
        q();
        if (this.J == null) goto L61;
        if (this.K != null) goto L61;
        ?? r17 = new d(this);
        this.K = r17;
        r15.getViewTreeObserver().addOnPreDrawListener(r17);
        goto L61
    L41:
        if (r14.getVisibility() != 0) goto L44;
        r14.a(null);
        r14.setBorderFadeFraction(1.0f);
        goto L45
    }

    public final TextView j() {
        g9.b r0 = new g9.b(this.b);
        Intrinsics.checkNotNullParameter(r0, "finder");
        Object r1 = new h9(r0, 2131375415).a;
        if ((r1 instanceof TextView) == true) goto L7;
        return null;
    L7:
        return (TextView) r1;
    }

    public final void l() {
        jd8.c r0 = this.y;
        ViewTreeObserver r1 = this.z;
        this.y = null;
        this.z = null;
        if (r0 == null) goto L11;
        if (r1 != null) goto L6;
    L8:
        boolean r4 = false;
    L9:
        if (r4 == false) goto L11;
        r1.removeOnPreDrawListener(r0);
        goto L11
    L6:
        if (r1.isAlive() != true) goto L8;
        r4 = true;
    L11:
        this.A = false;
        this.B = false;
        this.C = 0;
        this.D = 0;
        this.E++;
        this.F = -1;
    }

    public final void o() {
        Integer r0 = this.r;
        if (r0 == null) goto L11;
        int r1 = r0.intValue();
        this.r = null;
        View r2 = this.f;
        if (r2 != null) goto L7;
        return;
    L7:
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L12;
        r3.height = r1;
        r2.setLayoutParams(r3);
        return;
    L12:
        return;
    }

    public final void q() {
        final u r0 = this.G;
        View r1 = this.H;
        ze8.d r2 = this.J;
        if (r0 == null) goto L38;
        if (r1 == null) goto L38;
        if (r2 == null) goto L38;
        r1.getLocationInWindow(this.Z);
        float r4 = this.P;
        s r5 = this.I;
        if (r5 == null) goto L10;
        int r3 = r5.b(r2);
    L11:
        int r6 = MathKt.roundToInt(r4);
        int[] r7 = this.Z;
        int r8 = r6 - r7[0];
        int r9 = r7[1];
        Rect r10 = new Rect(r8 - r1.getPaddingLeft(), (r3 - r9) - r1.getPaddingTop(), (r8 + this.R) + r1.getPaddingRight(), ((this.Q + this.S) - r9) + r1.getPaddingBottom());
        if (r10.left <= 1) goto L14;
    L20:
        boolean r11 = false;
    L21:
        if (r11 == true) goto L25;
        int r12 = this.L + 1;
        this.L = r12;
        if (r12 >= 60) goto L25;
        return;
    L25:
        if (r0.b == false) goto L27;
    L29:
        ValueAnimator r13 = r0.d;
        if (r13 == null) goto L32;
        r0.d = null;
        r13.cancel();
    L32:
        r0.b = false;
        r0.c = 0;
        ValueAnimator r14 = ValueAnimator.ofInt(new int[]{0, 255});
        r14.setDuration(300);
        r14.setInterpolator(new LinearInterpolator());
        r14.addUpdateListener(new t(r0));
        r14.addListener(new v(r0));
        r14.start();
        r0.d = r14;
    L33:
        ValueAnimator r15 = this.M;
        if (r15 == null) goto L36;
        this.M = null;
        r15.removeAllListeners();
        r15.cancel();
    L36:
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r16.setDuration(300);
        r16.setInterpolator(new LinearInterpolator());
        r16.addUpdateListener(new f(this));
        r16.addListener(new h(this));
        r16.start();
        this.M = r16;
        m();
        return;
    L27:
        if (r0.d != null) goto L29;
    L14:
        if (r10.top > 1) goto L20;
        if (r10.right < (r1.getWidth() - 1)) goto L20;
        if (r10.bottom < (r1.getHeight() - 1)) goto L20;
        r11 = true;
        goto L21
    L10:
        r3 = this.Q;
    L38:
        ValueAnimator r17 = this.M;
        if (r17 == null) goto L41;
        this.M = null;
        r17.removeAllListeners();
        r17.cancel();
    L41:
        f();
        s r18 = this.I;
        if (r18 == null) goto L44;
        r18.e();
    L44:
        m();
    }

    public static void p(List r2) {
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        c r0 = (c) r3.next();
        r0.a.setVisibility(r0.b);
        goto L4
    }

    public static Bitmap r(View r3) {
        if (r3.getWidth() > 0) goto L5;
    L9:
        return null;
    L5:
        if (r3.getHeight() <= 0) goto L9;
        Bitmap r0 = Bitmap.createBitmap(r3.getWidth(), r3.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L11
        r3.draw(new Canvas(r0));     // Catch: Throwable -> L11
        return r0;
    }

    public static int t(TextView r4) {
        Layout r0 = r4.getLayout();
        if (r0 != null) goto L5;
        return 0;
    L5:
        int r2 = (r4.getHeight() - r4.getCompoundPaddingTop()) - r4.getCompoundPaddingBottom();
        if (r2 > 0) goto L9;
        return 0;
    L9:
        return RangesKt.coerceAtLeast(r0.getHeight() - r2, 0);
    }

    public final void a(ze8.d r12) {
        Intrinsics.checkNotNullParameter(r12, "spec");
        this.e = true;
        String r1 = r12.c;
        if (r1 == null) goto L17;
        TextView r2 = j();
        if (r2 == null) goto L14;
        CharSequence r3 = r2.getHint();
        if (r3 == null) goto L10;
        String r4 = r3.toString();
    L12:
        if (Intrinsics.areEqual(r4, r1) == false) goto L14;
    L10:
        r4 = null;
    L14:
        ICoreInputAbility r5 = this.c;
        if (r5 == null) goto L17;
        r5.Yk(r1);
    L17:
        va8.o r6 = this.d;
        if (r6 == null) goto L20;
        r6.Fn(r12.g);
    L20:
        ICoreInputAbility r7 = this.c;
        if (r7 == null) goto L23;
        ICoreInputAbility.b.d(r7, r12.b, false, false, Integer.valueOf(r12.d), Integer.valueOf(r12.e), false, 32);
    L23:
        ICoreInputAbility r8 = this.c;
        if (r8 != null) goto L26;
    L33:
        this.l = r12;
        this.b.post(new jd8.b(this));
        if (this.x == null) goto L47;
        View r9 = this.f;
        if (r9 == null) goto L48;
        jd8.c r10 = this.y;
        if (r10 == null) goto L49;
        this.x = r12;
        if (this.B == false) goto L45;
        i(r9);
    L45:
        this.A = false;
        this.B = false;
        this.C = 0;
        this.D = 0;
        this.F = -1;
        int r13 = this.E + 1;
        this.E = r13;
        r9.post(new e(this, r10, r13, r9));
        r9.requestLayout();
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L26:
        if (r12.i != InputContentMode.SPEAK) goto L29;
        int r11 = 2;
    L32:
        r8.g2(r11, true);
        goto L33
    L29:
        if (r12.f == false) goto L31;
        r11 = 3;
        goto L32
    L31:
        r11 = 1;
        goto L32
    }

    public final void c(jd8.a r7) {
        Integer r1 = null;
        if (this.Y == true) goto L6;
        r7.setClipBounds(null);
        return;
    L6:
        float r0 = this.V + r7.getTranslationX();
        ViewGroup.LayoutParams r2 = r7.getLayoutParams();
        if (r2 == null) goto L16;
        Integer r3 = Integer.valueOf(r2.height);
        if (r3.intValue() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        r1 = r3;
    L14:
        if (r1 == null) goto L16;
        int r5 = r1.intValue();
    L17:
        r7.setClipBounds(new Rect(MathKt.roundToInt(this.W - r0), 0, MathKt.roundToInt(this.X - r0), r5));
        return;
    L11:
        r4 = false;
    L16:
        r5 = this.S;
        goto L17
    }

    public final void i(View r3) {
        if (this.r == null) goto L5;
        return;
    L5:
        if (r3.getHeight() <= 0) goto L13;
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 == null) goto L12;
        this.r = Integer.valueOf(r0.height);
        r0.height = r3.getHeight();
        r3.setLayoutParams(r0);
        return;
    L12:
        return;
    }

    public final void n(ze8.d r10) {
        this.e = true;
        ICoreInputAbility r1 = this.c;
        if (r1 == null) goto L5;
        ICoreInputAbility.b.d(r1, r10.b, false, false, Integer.valueOf(r10.d), Integer.valueOf(r10.e), false, 32);
    L5:
        this.e = false;
    }

    public static List e(g9.c r6, InputContentMode r7) {
        if (r7 == null) goto L4;
        int r1 = 0;
        if (r7 != InputContentMode.SPEAK) goto L8;
        boolean r8 = true;
    L9:
        Pair[] r0 = new Pair[3];
        Object r3 = r6.d().a;
        Pair r4 = null;
        if (r3 == null) goto L12;
        Pair r5 = TuplesKt.to(r3, Integer.valueOf(u(r8)));
    L13:
        r0[0] = r5;
        Object r9 = r6.k().a;
        if (r9 == null) goto L19;
        if (r8 == true) goto L18;
        r1 = 4;
    L18:
        Pair r2 = TuplesKt.to(r9, Integer.valueOf(r1));
    L20:
        r0[1] = r2;
        Object r10 = r6.j().a;
        if (r10 == null) goto L23;
        r4 = TuplesKt.to(r10, Integer.valueOf(u(!r8)));
    L23:
        r0[2] = r4;
        List r11 = CollectionsKt.listOfNotNull(r0);
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L25:
        if (r13.hasNext() == false) goto L27;
        Pair r14 = (Pair) r13.next();
        View r15 = (View) r14.component1();
        int r16 = ((Number) r14.component2()).intValue();
        c r17 = new c(r15, r15.getVisibility());
        r15.setVisibility(r16);
        r12.add(r17);
        goto L25
    L27:
        return r12;
    L19:
        r2 = null;
        goto L20
    L12:
        r5 = null;
        goto L13
    L8:
        r8 = false;
        goto L9
    L4:
        return CollectionsKt.emptyList();
    }

    public final void b(TextView r3, boolean r4) {
        if (r4 == false) goto L5;
        r3.setMaxLines(1);
        return;
    L5:
        Integer r5 = Integer.valueOf(r3.getMaxHeight());
        if (r5.intValue() < 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L14;
        int r6 = r5.intValue();
    L15:
        r3.setMaxHeight(r6);
        return;
    L14:
        Resources r7 = this.b.getResources();
        r6 = (int) TypedValue.applyDimension(1, 122.0f, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()));
        goto L15
    L8:
        r1 = false;
        goto L9
    }

    public final jd8.a h(boolean r5, int r6) {
        if (r5 == false) goto L4;
        jd8.a r0 = this.g;
    L5:
        if (r0 == null) goto L14;
        ViewGroup.LayoutParams r7 = r0.getLayoutParams();
        if (r7 == null) goto L13;
        int r1 = r7.width;
        int r2 = this.R;
        if (r1 == r2) goto L11;
    L12:
        r7.width = r2;
        r7.height = r6;
        r0.setLayoutParams(r7);
        goto L13
    L11:
        if (r7.height != r6) goto L12;
    L13:
        return r0;
    L14:
        jd8.a r3 = new jd8.a(this.a.getContext());
        r3.setVisibility(8);
        ViewGroup r4 = this.a;
        if ((r4 instanceof ConstraintLayout) == false) goto L17;
        ConstraintLayout.LayoutParams r8 = new ConstraintLayout.LayoutParams(this.R, r6);
        r8.topToTop = 0;
        r8.startToStart = 0;
    L18:
        r4.addView(r3, r8);
        if (r5 == false) goto L21;
        this.g = r3;
    L22:
        return r3;
    L21:
        this.h = r3;
        goto L22
    L17:
        r8 = new ViewGroup.LayoutParams(this.R, r6);
        goto L18
    L4:
        r0 = this.h;
        goto L5
    }

    public final int k(jd8.a r19, ze8.d r20) {
        View r1 = this.f;
        if (r1 == null) goto L5;
        ze8.d r2 = this.l;
        if (r2 != null) goto L12;
        r2 = this.i;
        if (r2 != null) goto L12;
        return this.S;
    L12:
        ze8.d r10 = r2;
        Integer r3 = this.s.get(r20.a);
        if (r3 == null) goto L15;
        int r4 = r3.intValue();
    L23:
        View r17 = r1;
        int r9 = r4;
    L88:
        TextView r11 = j();
        if (r11 == null) goto L91;
        CharSequence r12 = r11.getHint();
    L92:
        if (r11 == null) goto L94;
        int r13 = r11.getMaxLines();
    L95:
        if (r11 == null) goto L97;
        int r14 = r11.getMaxHeight();
    L98:
        String r5 = r20.c;
        if (r5 == null) goto L102;
        if (r11 == null) goto L102;
        r11.setHint(r5);
    L102:
        n(r20);
        if (r11 != null) goto L105;
    L109:
        va8.o r6 = this.d;
        if (r6 == null) goto L112;
        r6.Fn(r20.g);
    L112:
        boolean r7 = r20.f;
        Boolean r8 = this.t.get(r20.a);
        if (r8 == null) goto L115;
        boolean r15 = r8.booleanValue();
    L116:
        View r16 = r17;
        int r18 = r9;
        Bitmap r0 = s(r16, r7, r18, Boolean.valueOf(r15), this.u.get(r20.a), r20.h, r20.i);
        va8.o r21 = this.d;
        if (r21 == null) goto L119;
        r21.Fn(r10.g);
    L119:
        n(r10);
        if (r11 == null) goto L125;
        if (r14 < 0) goto L123;
        r11.setMaxHeight(r14);
        goto L125
    L123:
        if (r13 < 0) goto L125;
        r11.setMaxLines(r13);
    L125:
        if (r11 == null) goto L127;
        r11.setHint(r12);
    L127:
        ViewGroup.LayoutParams r22 = r19.getLayoutParams();
        if (r22 == null) goto L130;
        r22.width = this.R;
        r22.height = r9;
        jd8.a r23 = r19;
        r23.setLayoutParams(r22);
    L131:
        r23.a(r0);
        return r9;
    L130:
        r23 = r19;
        goto L131
    L115:
        r15 = false;
        goto L116
    L105:
        if (r20.b.length() != 0) goto L107;
        boolean r24 = true;
    L108:
        b(r11, r24);
        goto L109
    L107:
        r24 = false;
        goto L108
    L97:
        r14 = -1;
        goto L98
    L94:
        r13 = -1;
        goto L95
    L91:
        r12 = null;
        goto L92
    L15:
        View r25 = this.f;
        if (r25 != null) goto L18;
        r4 = this.S;
        goto L23
    L18:
        ze8.d r26 = this.l;
        if (r26 != null) goto L25;
        r26 = this.i;
        if (r26 != null) goto L25;
        r4 = this.S;
    L25:
        if (this.R > 0) goto L27;
    L87:
        r17 = r1;
        r9 = this.S;
        goto L88
    L27:
        if (this.S <= 0) goto L87;
        TextView r110 = j();
        if (r110 == null) goto L32;
        CharSequence r111 = r110.getHint();
    L33:
        if (r110 == null) goto L35;
        int r112 = r110.getMaxLines();
    L36:
        if (r110 == null) goto L38;
        int r113 = r110.getMaxHeight();
    L39:
        String r114 = r20.c;
        if (r114 == null) goto L43;
        if (r110 == null) goto L43;
        r110.setHint(r114);
    L43:
        g9.c r115 = new g9.c(new g9.b(this.b));
        List r27 = e(r115, r20.i);
        List r28 = d(r115, r20.f, r20.h, r20.i);
        n(r20);
        if (r110 != null) goto L46;
    L50:
        r25.measure(View.MeasureSpec.makeMeasureSpec(this.R, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r29 = RangesKt.coerceAtLeast(r25.getMeasuredHeight(), 1);
        HashMap<String, Boolean> r30 = this.t;
        String r116 = r20.a;
        InputContentMode r31 = r20.i;
        InputContentMode r117 = InputContentMode.SPEAK;
        if (r31 == r117) goto L58;
        if (r110 == null) goto L58;
        if (r110.getVisibility() != 0) goto L58;
        r17 = r1;
        if (r110.getLineCount() <= 2) goto L59;
        boolean r32 = true;
    L60:
        r30.put(r116, Boolean.valueOf(r32));
        HashMap<String, Boolean> r33 = this.u;
        String r34 = r20.a;
        if (r20.i == r117) goto L71;
        if (r110 == null) goto L67;
        if (r110.getLineCount() <= 1) goto L67;
        boolean r35 = true;
    L68:
        if (r35 == false) goto L71;
        boolean r36 = true;
    L72:
        r33.put(r34, Boolean.valueOf(r36));
        n(r26);
        if (r110 == null) goto L78;
        if (r113 < 0) goto L76;
        r110.setMaxHeight(r113);
        goto L78
    L76:
        if (r112 < 0) goto L78;
        r110.setMaxLines(r112);
    L78:
        if (r110 == null) goto L80;
        r110.setHint(r111);
    L80:
        p(r28);
        p(r27);
        if (r25.getWidth() > 0) goto L83;
    L86:
        Integer r37 = Integer.valueOf(r29);
        this.s.put(r20.a, r37);
        r9 = r29;
        goto L88
    L83:
        if (r25.getHeight() <= 0) goto L86;
        r25.measure(View.MeasureSpec.makeMeasureSpec(r25.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r25.getHeight(), 1073741824));
        r25.layout(r25.getLeft(), r25.getTop(), r25.getRight(), r25.getBottom());
    L67:
        r35 = false;
    L71:
        r36 = false;
    L59:
        r32 = false;
    L58:
        r17 = r1;
        goto L59
    L46:
        if (r20.b.length() != 0) goto L48;
        boolean r38 = true;
    L49:
        b(r110, r38);
        goto L50
    L48:
        r38 = false;
        goto L49
    L38:
        r113 = -1;
        goto L39
    L35:
        r112 = -1;
        goto L36
    L32:
        r111 = null;
        goto L33
    L5:
        return this.S;
    }

    public final void update(float r6, ze8.d r7, ze8.d r8) {
        Intrinsics.checkNotNullParameter(r7, "lower");
        if (Intrinsics.areEqual(this.j, r7.a) == true) goto L9;
        if (Intrinsics.areEqual(this.k, r7.a) == false) goto L7;
        jd8.a r0 = this.g;
        this.g = this.h;
        this.h = r0;
        this.j = this.k;
        this.k = null;
        int r1 = this.v;
        this.v = this.w;
        this.w = r1;
        goto L9
    L7:
        this.v = k(h(true, this.S), r7);
        this.j = r7.a;
    L9:
        if (r8 != null) goto L12;
        this.k = null;
    L14:
        jd8.a r2 = this.g;
        if (r2 == null) goto L17;
        r2.setTranslationX(this.N - ((this.T * r6) * this.U));
        r2.setTranslationY(this.O + (this.S - this.v));
        c(r2);
        r2.setVisibility(0);
    L17:
        if (r8 != null) goto L22;
        jd8.a r9 = this.h;
        if (r9 == null) goto L47;
        r9.setVisibility(8);
        return;
    L47:
        return;
    L22:
        jd8.a r3 = this.h;
        if (r3 == null) goto L26;
        r3.setTranslationX(this.N + (((1.0f - r6) * this.T) * this.U));
        r3.setTranslationY(this.O + (this.S - this.w));
        c(r3);
        r3.setVisibility(0);
    L26:
        if (this.r == null) goto L51;
        View r10 = this.f;
        if (r10 == null) goto L52;
        Integer r4 = this.s.get(r7.a);
        if (r4 == null) goto L48;
        int r5 = r4.intValue();
        Integer r11 = this.s.get(r8.a);
        if (r11 == null) goto L49;
        int r12 = r11.intValue();
        int r13 = Math.min(r5, r12);
        ViewGroup.LayoutParams r14 = r10.getLayoutParams();
        if (r14 != null) goto L38;
    L40:
        s r15 = this.I;
        if (r15 == null) goto L43;
        r15.d(r7, r13 - r5);
    L43:
        s r16 = this.I;
        if (r16 == null) goto L50;
        r16.d(r8, r13 - r12);
        return;
    L50:
        return;
    L38:
        if (r14.height == r13) goto L40;
        r14.height = r13;
        r10.setLayoutParams(r14);
        goto L40
    L49:
        return;
    L48:
        return;
    L52:
        return;
    L51:
        return;
    L12:
        if (Intrinsics.areEqual(this.k, r8.a) == true) goto L14;
        this.w = k(h(false, this.S), r8);
        this.k = r8.a;
        goto L14
    }

    public g(ViewGroup r2, View r3, ICoreInputAbility r4, va8.o r5) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "realInputView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.s = new HashMap();
        this.t = new HashMap();
        this.u = new HashMap();
        this.F = -1;
        this.U = 1.0f;
        this.Z = new int[2];
    }

    public static List d(g9.c r6, boolean r7, ze8.c r8, InputContentMode r9) {
        boolean r1 = true;
        boolean r2 = false;
        Pair r3 = null;
        if (r8 == null) goto L26;
        Pair[] r10 = new Pair[4];
        Object r4 = r6.a().a;
        if (r4 == null) goto L7;
        Pair r5 = TuplesKt.to(r4, Integer.valueOf(u(r8.a)));
    L8:
        r10[0] = r5;
        Object r11 = r6.h().a;
        if (r11 == null) goto L11;
        Pair r12 = TuplesKt.to(r11, Integer.valueOf(u(r8.c)));
    L12:
        r10[1] = r12;
        Object r13 = r6.i().a;
        if (r13 != null) goto L15;
        Pair r14 = null;
    L22:
        r10[2] = r14;
        Object r15 = r6.e().a;
        if (r15 == null) goto L25;
        r3 = TuplesKt.to(r15, Integer.valueOf(u(r8.d)));
    L25:
        r10[3] = r3;
        List r16 = CollectionsKt.listOfNotNull(r10);
    L38:
        List r17 = r16;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L40:
        if (r19.hasNext() == false) goto L42;
        Pair r20 = (Pair) r19.next();
        View r21 = (View) r20.component1();
        int r22 = ((Number) r20.component2()).intValue();
        c r0 = new c(r21, r21.getVisibility());
        r21.setVisibility(r22);
        r18.add(r0);
        goto L40
    L42:
        return r18;
    L15:
        if (r8.b == true) goto L17;
    L19:
        r1 = false;
    L20:
        r14 = TuplesKt.to(r13, Integer.valueOf(u(r1)));
        goto L22
    L17:
        if (r9 == InputContentMode.SPEAK) goto L19;
    L11:
        r12 = null;
        goto L12
    L7:
        r5 = null;
        goto L8
    L26:
        Pair[] r23 = new Pair[2];
        Object r24 = r6.h().a;
        if (r24 == null) goto L29;
        Pair r25 = TuplesKt.to(r24, Integer.valueOf(u(r7)));
    L30:
        r23[0] = r25;
        Object r26 = r6.i().a;
        if (r26 == null) goto L37;
        if (r7 == false) goto L34;
    L36:
        r3 = TuplesKt.to(r26, Integer.valueOf(u(r2)));
        goto L37
    L34:
        if (r9 == InputContentMode.SPEAK) goto L36;
        r2 = true;
    L37:
        r23[1] = r3;
        r16 = CollectionsKt.listOfNotNull(r23);
        goto L38
    L29:
        r25 = null;
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.view.View[], java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v12, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View, java.lang.Object] */
    public final Bitmap s(View r20, boolean r21, int r22, Boolean r23, Boolean r24, ze8.c r25, InputContentMode r26) {
        g9.c r4 = new g9.c(new g9.b(this.b));
        List r5 = e(r4, r26);
        ?? r6 = r4.h().a;
        ?? r7 = r4.i().a;
        g9.b r8 = r4.a;
        r8.getClass();
        View r9 = r8.a;
        if (r9 == null) goto L5;
        View r10 = r9.findViewById(2131362093);
    L7:
        if (r24 != null) goto L10;
        List r12 = CollectionsKt.emptyList();
    L39:
        List r11 = d(r4, r21, r25, r26);
        if (r6 == 0) goto L42;
        Boolean r13 = Boolean.valueOf(r6.isEnabled());
    L43:
        if (r6 == 0) goto L45;
        Float r14 = Float.valueOf(r6.getAlpha());
    L46:
        if (r7 == 0) goto L48;
        Boolean r15 = Boolean.valueOf(r7.isEnabled());
    L49:
        if (r7 == 0) goto L51;
        Float r16 = Float.valueOf(r7.getAlpha());
    L52:
        if (r10 == null) goto L54;
        Integer r17 = Integer.valueOf(r10.getVisibility());
    L55:
        if (r25 == null) goto L67;
        Float r27 = r16;
        if (r6 == 0) goto L59;
        r6.setEnabled(r25.c);
        r6.setAlpha(1.0f);
    L59:
        if (r7 != 0) goto L61;
    L68:
        if (r23 == null) goto L75;
        if (r10 == null) goto L75;
        if (r23.booleanValue() == false) goto L73;
        int r2 = 0;
    L74:
        r10.setVisibility(r2);
        goto L75
    L73:
        r2 = 8;
    L75:
        int r3 = r20.getLeft();
        int r18 = r20.getTop();
        int r19 = r20.getRight();
        int r110 = r20.getBottom();
        Integer r111 = Integer.valueOf(r22);
        if (r111.intValue() <= 0) goto L78;
        boolean r112 = true;
    L79:
        if (r112 == true) goto L82;
        r111 = null;
    L82:
        if (r111 == null) goto L84;
        int r28 = r111.intValue();
    L85:
        Boolean r29 = r15;
        r20.measure(View.MeasureSpec.makeMeasureSpec(this.R, 1073741824), View.MeasureSpec.makeMeasureSpec(r28, 1073741824));
        r20.layout(r3, r110 - r28, r19, r110);
        TextView r30 = j();
        if (r30 == null) goto L88;
        int r31 = r30.getScrollX();
    L89:
        if (r30 == null) goto L91;
        int r113 = r30.getScrollY();
    L92:
        if (r30 == null) goto L95;
        r30.scrollTo(0, t(r30));
    L95:
        Bitmap r0 = r(r20);
        if (r30 == null) goto L98;
        r30.scrollTo(r31, r113);
    L98:
        p(r5);
        Iterator r32 = r12.iterator();
    L100:
        if (r32.hasNext() == false) goto L108;
        b r33 = (b) r32.next();
        ConstraintLayout.LayoutParams r34 = r33.a.getLayoutParams();
        if ((r34 instanceof ConstraintLayout.LayoutParams) == false) goto L104;
        ConstraintLayout.LayoutParams r35 = r34;
    L105:
        if (r35 == null) goto L100;
        r35.topToTop = r33.b;
        r35.bottomToBottom = r33.c;
        r33.a.setLayoutParams(r35);
        goto L100
    L104:
        r35 = null;
        goto L105
    L108:
        if (r17 == null) goto L112;
        int r36 = r17.intValue();
        if (r10 == null) goto L112;
        r10.setVisibility(r36);
    L112:
        p(r11);
        if (r13 == null) goto L117;
        boolean r37 = r13.booleanValue();
        if (r6 == 0) goto L117;
        r6.setEnabled(r37);
    L117:
        if (r14 == null) goto L121;
        float r38 = r14.floatValue();
        if (r6 == 0) goto L121;
        r6.setAlpha(r38);
    L121:
        if (r29 == null) goto L125;
        boolean r39 = r29.booleanValue();
        if (r7 == 0) goto L125;
        ?? r40 = r7;
        r40.setEnabled(r39);
        ?? r41 = r40;
    L126:
        if (r27 == null) goto L130;
        float r42 = r27.floatValue();
        if (r41 == 0) goto L130;
        r41.setAlpha(r42);
    L130:
        r20.measure(View.MeasureSpec.makeMeasureSpec(this.R, 1073741824), View.MeasureSpec.makeMeasureSpec(r110 - r18, 1073741824));
        r20.layout(r3, r18, r19, r110);
        return r0;
    L125:
        r41 = r7;
        goto L126
    L91:
        r113 = 0;
        goto L92
    L88:
        r31 = 0;
        goto L89
    L84:
        r28 = this.S;
        goto L85
    L78:
        r112 = false;
        goto L79
    L61:
        if (r25.b == true) goto L63;
    L65:
        boolean r43 = false;
    L66:
        r7.setEnabled(r43);
        r7.setAlpha(1.0f);
        goto L68
    L63:
        if (r26 == InputContentMode.SPEAK) goto L65;
        r43 = true;
        goto L66
    L67:
        r27 = r16;
        goto L68
    L54:
        r17 = null;
        goto L55
    L51:
        r16 = null;
        goto L52
    L48:
        r15 = null;
        goto L49
    L45:
        r14 = null;
        goto L46
    L42:
        r13 = null;
        goto L43
    L10:
        View r114 = this.b.findViewById(2131375347);
        if (r114 != null) goto L13;
        r12 = CollectionsKt.emptyList();
        goto L39
    L13:
        ?? r115 = new View[3];
        r115[0] = j();
        g9.b r116 = r4.a;
        r116.getClass();
        View r117 = r116.a;
        if (r117 == null) goto L16;
        View r118 = r117.findViewById(2131362039);
    L17:
        r115[1] = r118;
        r115[2] = r4.a().a;
        List r119 = CollectionsKt.listOfNotNull(r115);
        ArrayList r120 = new ArrayList();
        Iterator r121 = r119.iterator();
    L19:
        if (r121.hasNext() == false) goto L38;
        View r122 = (View) r121.next();
        ConstraintLayout.LayoutParams r44 = r122.getLayoutParams();
        if ((r44 instanceof ConstraintLayout.LayoutParams) == false) goto L23;
        ConstraintLayout.LayoutParams r45 = r44;
    L24:
        if (r45 != null) goto L26;
        b r123 = null;
    L35:
        if (r123 == null) goto L37;
        r120.add(r123);
    L37:
        r121 = r121;
        goto L19
    L26:
        r123 = new b(r122, r45.topToTop, r45.bottomToBottom);
        if (r24.booleanValue() == false) goto L29;
        int r124 = -1;
    L30:
        r45.topToTop = r124;
        if (r24.booleanValue() == false) goto L33;
        int r125 = 0;
    L34:
        r45.bottomToBottom = r125;
        r122.setLayoutParams(r45);
        goto L35
    L33:
        r125 = r114.getId();
        goto L34
    L29:
        r124 = r114.getId();
        goto L30
    L23:
        r45 = null;
        goto L24
    L38:
        r12 = r120;
        goto L39
    L16:
        r118 = null;
        goto L17
    L5:
        r10 = null;
        goto L7
    }
}
