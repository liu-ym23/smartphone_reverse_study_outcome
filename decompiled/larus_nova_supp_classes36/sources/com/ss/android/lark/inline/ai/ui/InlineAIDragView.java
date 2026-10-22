package com.ss.android.lark.inline.ai.ui;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.inline.ai.ui.prompts.PromptsRecyclerView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.CarUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InlineAIDragView {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public Integer F;
    public boolean G;
    public boolean H;
    public int I;
    public int J;
    public ObjectAnimator K;
    public ObjectAnimator L;
    public boolean M;
    public Boolean N;
    public boolean O;
    public final int P;
    public final int Q;
    public Boolean R;
    public boolean S;
    public Runnable T;
    public boolean U;
    public final com.ss.android.lark.inline.ai.ui.j V;
    public final com.ss.android.lark.inline.ai.ui.k W;
    public final com.ss.android.lark.inline.ai.ui.d X;
    public final com.ss.android.lark.inline.ai.ui.c Y;
    public final Activity a;
    public final View b;
    public final ViewGroup c;
    public final wlb.d d;
    public final d e;
    public final int f;
    public final boolean g;
    public float h;
    public View i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public ValueAnimator n;
    public ValueAnimator o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/InlineAIDragView$AdjustTopSource;", "", "<init>", "(Ljava/lang/String;I)V", "VIEW_CHANGE", "DRAG", "KEYBOARD_CHANGE", "CONTAINER_CHANGE", "CONTENT_HEIGHT_CHANGE", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum AdjustTopSource extends Enum<AdjustTopSource> {
        public static final AdjustTopSource CONTAINER_CHANGE = null;
        public static final AdjustTopSource CONTENT_HEIGHT_CHANGE = null;
        public static final AdjustTopSource DRAG = null;
        public static final AdjustTopSource KEYBOARD_CHANGE = null;
        public static final AdjustTopSource VIEW_CHANGE = null;
        public static final /* synthetic */ AdjustTopSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AdjustTopSource> getEntries() {
            return b;
        }

        static {
            AdjustTopSource r0 = new AdjustTopSource("VIEW_CHANGE", 0);
            VIEW_CHANGE = r0;
            AdjustTopSource r1 = new AdjustTopSource("DRAG", 1);
            DRAG = r1;
            AdjustTopSource r3 = new AdjustTopSource("KEYBOARD_CHANGE", 2);
            KEYBOARD_CHANGE = r3;
            AdjustTopSource r5 = new AdjustTopSource("CONTAINER_CHANGE", 3);
            CONTAINER_CHANGE = r5;
            AdjustTopSource r7 = new AdjustTopSource("CONTENT_HEIGHT_CHANGE", 4);
            CONTENT_HEIGHT_CHANGE = r7;
            AdjustTopSource[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static AdjustTopSource[] values() {
            return (AdjustTopSource[]) a.clone();
        }

        public static AdjustTopSource valueOf(String r1) {
            return (AdjustTopSource) r27.a.a(AdjustTopSource.class, r1);
        }

        public AdjustTopSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final class a implements View.OnTouchListener {
        public long a;
        public float b;
        public float c;
        public final /* synthetic */ InlineAIDragView d;

        public a(InlineAIDragView r1) {
            this.d = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r9, MotionEvent r10) {
            Intrinsics.checkNotNullParameter(r9, "v");
            Intrinsics.checkNotNullParameter(r10, "event");
            boolean r0 = false;
            if (this.d.C == false) goto L5;
        L7:
            int r11 = r10.getAction();
            if (r11 == 0) goto L34;
            if (r11 != 1) goto L11;
            long r3 = System.currentTimeMillis();
            float r12 = r10.getRawX();
            float r1 = r10.getRawY();
            float r13 = r10.getY();
            float r5 = this.d.c.getY();
            long r4 = r3 - this.a;
            float r14 = Math.abs(r12 - this.b);
            float r2 = Math.abs(r1 - this.c);
            if (r13 >= r5) goto L17;
            boolean r15 = true;
        L19:
            if (r4 >= 200) goto L21;
            boolean r6 = true;
        L23:
            if (r14 >= f0.a(20)) goto L25;
            boolean r16 = true;
        L27:
            if (r2 >= f0.a(20)) goto L29;
            r0 = true;
        L29:
            if (r15 == false) goto L35;
            if (r6 == false) goto L35;
            if (r16 == false) goto L35;
            if (r0 == false) goto L35;
            this.d.e.d();
        L35:
            return true;
        L25:
            r16 = false;
            goto L27
        L21:
            r6 = false;
            goto L23
        L17:
            r15 = false;
            goto L19
        L11:
            if (r11 != 3) goto L35;
            Log.i("InlineAIDragView", "background touch cancel");
            goto L35
        L34:
            this.a = System.currentTimeMillis();
            this.b = r10.getRawX();
            this.c = r10.getRawY();
            Log.i("InlineAIDragView", "background touch down: " + this.a + ", startRawX = " + this.b + ", startRawY = " + this.c);
            goto L35
        L5:
            if (r10.getY() >= this.d.c.getY()) goto L7;
            return false;
        }
    }

    public static final class b {
    }

    public final class c implements View.OnTouchListener {
        public float a;
        public int b;
        public final /* synthetic */ InlineAIDragView c;

        public c(InlineAIDragView r1) {
            this.c = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r11, MotionEvent r12) {
            Intrinsics.checkNotNullParameter(r11, "v");
            Intrinsics.checkNotNullParameter(r12, "event");
            int r13 = r12.getAction();
            boolean r2 = false;
            if (r13 == 0) goto L34;
            if (r13 != 1) goto L6;
        L22:
            this.c.D = false;
            Log.i("InlineAIDragView", "touch up/cancel y = " + r12.getRawY() + ", rawY = " + r12.getRawY());
            if (this.c.B == true) goto L25;
        L28:
            InlineAIDragView r14 = this.c;
            if (r14.G == true) goto L31;
        L41:
            return true;
        L31:
            if ((r12.getRawY() - this.a) <= f0.a(60)) goto L33;
            r2 = true;
        L33:
            r14.h(r2, true, AdjustTopSource.DRAG);
            goto L41
        L25:
            if ((r12.getRawY() - this.a) <= f0.a(60)) goto L28;
            this.c.e.onClose();
            return true;
        L6:
            if (r13 != 2) goto L8;
            Log.d("InlineAIDragView", "touch move y = " + r12.getY(0) + ", rawY = " + r12.getRawY());
            InlineAIDragView r15 = this.c;
            if (r15.G == true) goto L14;
            r15.D = false;
            return false;
        L14:
            r15.E = this.b + ((int) (r12.getRawY() - this.a));
            InlineAIDragView r4 = this.c;
            if (r4.h <= 0.0f) goto L18;
            InlineAIDragView.e(r4, r4.E, false, false, AdjustTopSource.DRAG, 12);
            goto L41
        L18:
            if ((r4.i instanceof wlb.g) == false) goto L20;
            int r16 = Math.max(r4.I, r4.E);
        L21:
            InlineAIDragView.e(r4, r16, false, false, AdjustTopSource.DRAG, 12);
            goto L41
        L20:
            r16 = r4.E;
            goto L21
        L8:
            if (r13 == 3) goto L22;
        L34:
            InlineAIDragView r17 = this.c;
            if (r17.H == false) goto L37;
            return false;
        L37:
            r17.D = true;
            r17.G = true;
            ValueAnimator r18 = r17.n;
            if (r18 == null) goto L40;
            r18.cancel();
        L40:
            this.a = r12.getRawY();
            int r19 = this.c.c.getTop() + ((int) this.c.c.getTranslationY());
            this.b = r19;
            this.c.E = r19;
            Log.i("InlineAIDragView", "touch down y = " + r12.getY(0) + ", rawY = " + r12.getRawY() + ", panelInitTop = " + this.b);
            goto L41
        }
    }

    public interface d {
        void a(int r1);

        void b(boolean r1);

        void c();

        void d();

        void onClose();
    }

    public final class e implements NSPConstraintLayout.a {
        public int a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        public boolean f;
        public int g;
        public int h;
        public final int i;
        public final /* synthetic */ InlineAIDragView j;

        public final void d() {
            boolean r2 = true;
            if (this.f == false) goto L11;
            if (this.e == true) goto L7;
        L9:
            boolean r0 = false;
        L23:
            if (r0 == false) goto L29;
            InlineAIDragView r1 = this.j;
            if (r1.A == true) goto L27;
        L32:
            int r3 = this.d;
            if (r0 == true) goto L35;
        L36:
            InlineAIDragView r4 = this.j;
            if ((r4.i instanceof wlb.g) == true) goto L39;
        L41:
            int r5 = 0;
        L42:
            int r8 = r3 + r5;
            if (r0 == false) goto L55;
            InlineAIDragView r6 = this.j;
            if (r6.A == true) goto L55;
            if ((r6.i instanceof wlb.g) == false) goto L50;
            int r7 = r6.I;
        L52:
            if (r6.i() == false) goto L54;
            int r9 = ((this.g - r7) - this.j.j()) + this.j.P;
        L56:
            InlineAIDragView r10 = this.j;
            float r11 = r9;
            int r12 = r10.c.getHeight();
            float r13 = r10.c.getTranslationY();
            Log.i("InlineAIDragView", "doNestedScrollRebound, currentHeight = " + r12 + ", currentTranslationY = " + r13 + ", targetHeight = " + r8 + ", targetTranslationY = " + r11 + ", currentTop = " + r10.c.getY());
            if (r12 == r8) goto L59;
        L64:
            ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r14.addUpdateListener(new com.ss.android.lark.inline.ai.ui.g(r12, r8, r10, r13, r11));
            r14.setDuration(200);
            Intrinsics.checkNotNull(r14);
            r14.addListener(new com.ss.android.lark.inline.ai.ui.h(r10, r0));
            r14.start();
            return;
        L59:
            if (r13 == r11) goto L62;
            r2 = false;
        L62:
            if (r2 == false) goto L64;
            Log.i("InlineAIDragView", "doNestedScrollRebound, target pos is the same as current, so return");
            return;
        L54:
            r9 = this.g - r7;
            goto L56
        L50:
            r7 = this.a;
        L55:
            r9 = 0;
            goto L56
        L39:
            if (r4.F != null) goto L41;
            r5 = this.a - r4.I;
            goto L42
        L35:
            if (this.j.A == false) goto L41;
        L27:
            if ((r1.i instanceof wlb.g) == false) goto L32;
            int r15 = r1.I;
            goto L32
        L29:
            InlineAIDragView r16 = this.j;
            if ((r16.i instanceof wlb.g) == false) goto L32;
            int r17 = r16.I;
            goto L32
        L7:
            if ((this.c - this.a) <= f0.a(60)) goto L9;
        L8:
            r0 = true;
            goto L23
        L11:
            if (this.j.i() == false) goto L16;
            if (((((this.g - this.c) - this.j.j()) + this.j.P) / this.g) < 0.2f) goto L17;
        L18:
            boolean r18 = false;
        L19:
            if (r18 == false) goto L9;
            if ((this.c - this.a) <= f0.a(60)) goto L9;
        L17:
            r18 = true;
            goto L19
        L16:
            if (this.c <= this.j.v) goto L18;
            goto L17
        }

        public e(InlineAIDragView r1) {
            this.j = r1;
            this.i = f0.a(60);
        }

        @Override // com.ss.android.lark.inline.ai.ui.NSPConstraintLayout.a
        public final boolean a(View r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "target");
            Log.i("InlineAIDragView", "onNestedPreFling, velocityY = " + r3 + ", currentTop = " + this.b + ", dampedCurrentTop = " + this.c + ", startTop = " + this.a + ", isDown = " + this.e);
            this.f = true;
            if (this.c <= this.a) goto L5;
            this.j.o();
            d();
            return true;
        L5:
            InlineAIDragView.b(this.j);
            return false;
        }

        @Override // com.ss.android.lark.inline.ai.ui.NSPConstraintLayout.a
        public final void onStopNestedScroll(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "target");
            Log.i("InlineAIDragView", "onStopNestedScroll, type = " + r3 + ", hasFling = " + this.f + ", dampedCurrentTop = " + this.c + ", startTop = " + this.a);
            if (r3 == 0) goto L5;
            return;
        L5:
            if (this.f == false) goto L7;
            return;
        L7:
            if (this.c == this.a) goto L9;
            this.j.o();
            d();
            return;
        L9:
            InlineAIDragView.b(this.j);
        }

        @Override // com.ss.android.lark.inline.ai.ui.NSPConstraintLayout.a
        public final void onStartNestedScroll(View r2, View r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "child");
            Intrinsics.checkNotNullParameter(r3, "target");
            if (r4 != 0) goto L7;
            int r5 = (int) this.j.c.getY();
            this.a = r5;
            this.b = r5;
            this.c = r5;
            this.d = this.j.c.getHeight();
            InlineAIDragView r6 = this.j;
            int r7 = r6.q;
            this.g = r7;
            this.h = r7 - this.a;
            this.e = false;
            this.f = false;
            r6.H = true;
            ValueAnimator r8 = r6.n;
            if (r8 == null) goto L7;
            r8.cancel();
        L7:
            Log.i("InlineAIDragView", "onStartNestedScroll, startTop = " + this.a + ", currentTop = " + this.b + ", type = " + r4);
        }

        @Override // com.ss.android.lark.inline.ai.ui.NSPConstraintLayout.a
        public final void b(View r4, int r5, int r6, int[] r7) {
            Intrinsics.checkNotNullParameter(r4, "target");
            Intrinsics.checkNotNullParameter(r7, "consumed");
            Log.d("InlineAIDragView", "onNestedScroll, dyUnconsumed = " + r5 + ", type = " + r6);
            if (r5 < 0) goto L5;
            return;
        L5:
            if (r6 == 1) goto L14;
            this.e = true;
            r7[1] = r5;
            int r8 = this.b - r5;
            this.b = r8;
            int r9 = this.a;
            if (r8 == r9) goto L11;
            int r10 = this.g;
            int r11 = this.h;
            int r1 = this.i;
            r8 = r10 - ((int) ((((r11 - r1) / r11) * (r10 - r8)) + r1));
        L11:
            this.c = r8;
            this.j.c.setTranslationY(r8 - r9);
            Log.d("InlineAIDragView", "onNestedScroll, currentTop = " + this.b + ", dampedCurrentTop = " + this.c);
            return;
        }

        @Override // com.ss.android.lark.inline.ai.ui.NSPConstraintLayout.a
        public final void c(View r5, int r6, int[] r7, int r8) {
            Intrinsics.checkNotNullParameter(r5, "target");
            Intrinsics.checkNotNullParameter(r7, "consumed");
            Log.d("InlineAIDragView", "onNestedPreScroll, dy = " + r6 + ", currentTop = " + this.b + ", startTop = " + this.a + ", type = " + r8);
            if (r6 > 0) goto L5;
            return;
        L5:
            if (r8 == 1) goto L21;
            this.e = false;
            int r9 = this.b;
            int r1 = this.a;
            if (r9 <= r1) goto L20;
            int r2 = r9 - r1;
            if ((r2 - r6) >= 0) goto L12;
            r7[1] = r7[1] + r2;
            this.b = r1;
        L13:
            int r10 = this.b;
            if (r10 == r1) goto L17;
            int r11 = this.g;
            int r12 = this.h;
            int r13 = this.i;
            r10 = r11 - ((int) ((((r12 - r13) / r12) * (r11 - r10)) + r13));
        L17:
            this.c = r10;
            this.j.c.setTranslationY(r10 - r1);
            Log.d("InlineAIDragView", "onNestedPreScroll, currentTop = " + this.b + ", dampedCurrentTop = " + this.c);
            return;
        L12:
            r7[1] = r7[1] + r6;
            this.b = r9 - r6;
            goto L13
        L20:
            return;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ InlineAIDragView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ AdjustTopSource f;

        public f(InlineAIDragView r1, int r2, boolean r3, boolean r4, boolean r5, AdjustTopSource r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.i("InlineAIDragView", "execute pending adjustToTop task");     // Catch: Throwable -> L4
            this.a.d(this.b, this.c, this.d, this.e, this.f);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ InlineAIDragView a;
        public final /* synthetic */ AdjustTopSource b;

        public g(InlineAIDragView r1, AdjustTopSource r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r7) {
            Intrinsics.checkNotNullParameter(r7, "it");
            Object r8 = r7.getAnimatedValue();
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Float");
            int r1 = (int) ((Float) r8).floatValue();
            this.a.d(r1, false, false, true, this.b);
        }
    }

    public static final class h extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ InlineAIDragView b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.a == false) goto L9;
            InlineAIDragView r3 = this.b;
            if (r3.A == false) goto L7;
            r3.e.c();
            return;
        L7:
            r3.e.onClose();
            return;
        }

        public h(boolean r1, InlineAIDragView r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class i extends AnimatorListenerAdapter {
        public final /* synthetic */ InlineAIDragView a;
        public final /* synthetic */ Function0<Unit> b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            InlineAIDragView r4 = this.a;
            r4.b.setAlpha(0.0f);
            r4.c.setTranslationY(0.0f);
            r4.J = -1;
            Function0<Unit> r5 = this.b;
            if (r5 == null) goto L6;
            r5.invoke();
            return;
        }

        public i(InlineAIDragView r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class j implements wlb.g.a {
        public final /* synthetic */ InlineAIDragView a;

        public j(InlineAIDragView r1) {
            this.a = r1;
        }

        @Override // wlb.g.a
        public final void b(int r8) {
            Log.i("InlineAIDragView", "content height change, contentHeight = " + r8 + ", isNestedScrolling = " + this.a.H);
            InlineAIDragView r9 = this.a;
            if ((r9.i instanceof wlb.g) == true) goto L5;
            return;
        L5:
            if (r9.H == true) goto L17;
            r9.o();
            InlineAIDragView r1 = this.a;
            if (r1.D == false) goto L10;
            int r10 = Math.max(r1.E, r1.I);
        L14:
            InlineAIDragView.e(r1, r10, this.a.U, false, AdjustTopSource.CONTENT_HEIGHT_CHANGE, 12);
            return;
        L10:
            Integer r11 = r1.F;
            if (r11 == null) goto L13;
            r10 = Math.max(r11.intValue(), r1.I);
            goto L14
        L13:
            r10 = r1.I;
            goto L14
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ InlineAIDragView a;

        public k(InlineAIDragView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.o();     // Catch: Throwable -> L4
            this.a.n(false, false, AdjustTopSource.VIEW_CHANGE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ InlineAIDragView a;

        public l(InlineAIDragView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.n(false, false, AdjustTopSource.VIEW_CHANGE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class m implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ InlineAIDragView a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Log.i("InlineAIDragView", "onGlobalLayout, keyboardHeightMemory = " + this.a.m);
            this.a.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            InlineAIDragView r0 = this.a;
            r0.b.addOnLayoutChangeListener(r0.W);
            FrameLayout r1 = (FrameLayout) this.a.a.findViewById(R.id.content);
            if (r1 == null) goto L6;
            r1.addOnLayoutChangeListener(this.a.W);
        L6:
            if (Intrinsics.areEqual(this.a.N, Boolean.TRUE) == false) goto L10;
            InlineAIDragView r2 = this.a;
            if (r2.m != 0) goto L10;
            r2.O = true;
            r2.b.postDelayed(r2.X, 200);
            return;
        L10:
            InlineAIDragView.c(this.a);
        }

        public m(InlineAIDragView r1) {
            this.a = r1;
        }
    }

    public static final class n implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ InlineAIDragView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ AdjustTopSource d;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.a.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.a.n(this.b, this.c, this.d);
        }

        public n(InlineAIDragView r1, boolean r2, boolean r3, AdjustTopSource r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final void f() {
        this.p = this.b.getWidth();
        int r0 = this.b.getHeight();
        this.q = r0;
        float r1 = this.h;
        if (r1 <= 0.0f) goto L5;
        float r2 = r0;
        this.s = (int) (r2 - (r1 * r2));
    L6:
        float r3 = r0;
        this.t = (int) (r3 - (0.6f * r3));
        this.u = (int) (r3 - (0.3f * r3));
        this.v = (int) (r3 - (0.2f * r3));
        boolean r4 = true;
        if (idb.f.a().isCurrentEnable("ccm.mobile.forseti") == false) goto L9;
    L20:
        WindowInsetsCompat r5 = ViewCompat.getRootWindowInsets(a(this.a.getWindow()));
        if (r5 == null) goto L25;
        Insets r6 = r5.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r6 == null) goto L25;
        int r7 = r6.bottom;
    L26:
        int[] r8 = new int[2];
        this.b.getLocationInWindow(r8);
        int[] r9 = new int[2];
        a(this.a.getWindow()).getLocationInWindow(r9);
        this.y = (r9[1] + r7) - r8[1];
        if (r5 == null) goto L31;
        Insets r10 = r5.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r10 == null) goto L31;
        int r11 = r10.bottom;
    L32:
        int[] r12 = new int[2];
        this.b.getLocationInWindow(r12);
        int[] r13 = new int[2];
        a(this.a.getWindow()).getLocationInWindow(r13);
        this.z = ((r13[1] + a(this.a.getWindow()).getHeight()) - r11) - (r12[1] + this.q);
    L33:
        int r14 = this.f;
        if (r14 != (-1)) goto L37;
        r14 = f0.a(44);
    L37:
        this.w = r14 + Math.max(this.y, 0);
        this.M = true;
        if (this.S == false) goto L47;
        int r15 = this.r;
        if (r15 > 0) goto L42;
    L46:
        this.r = this.q;
        goto L47
    L42:
        if (r15 > this.q) goto L45;
        r4 = false;
    L45:
        this.R = Boolean.valueOf(r4);
    L47:
        Log.i("InlineAIDragView", "calculateHeights, rootViewHeight = " + this.q + ", topInNormalPercent = " + this.s + ", topIn60Percent = " + this.t + ", topIn30Percent = " + this.u + ", topExceptNaviBar = " + this.w + ", disBetweenRootTopAndActivityTop = " + this.y + ", disBetweenRootBottomAndActivityBottom = " + this.z);
        o();
        return;
    L31:
        r11 = 0;
    L25:
        r7 = 0;
        goto L26
    L9:
        if (CarUtils.a() == true) goto L20;
        FrameLayout r16 = (FrameLayout) this.a.findViewById(R.id.content);
        if (r16 == null) goto L14;
        int[] r17 = new int[2];
        this.b.getLocationInWindow(r17);
        int[] r18 = new int[2];
        r16.getLocationInWindow(r18);
        int r19 = r18[1] - r17[1];
    L15:
        this.y = r19;
        if (r16 == null) goto L18;
        int[] r20 = new int[2];
        this.b.getLocationInWindow(r20);
        int[] r21 = new int[2];
        r16.getLocationInWindow(r21);
        int r22 = (r21[1] + r16.getHeight()) - (r20[1] + this.q);
    L19:
        this.z = r22;
        goto L33
    L18:
        r22 = 0;
        goto L19
    L14:
        r19 = 0;
        goto L15
    L5:
        float r23 = r0;
        this.s = (int) (r23 - (0.8f * r23));
        goto L6
    }

    public final boolean i() {
        Boolean r0 = this.N;
        if (r0 != null) goto L10;
        r0 = this.R;
        if (r0 != null) goto L10;
        return this.k;
    L10:
        return r0.booleanValue();
    }

    public final int k() {
        return ((this.q - j()) + this.P) - ((int) (this.q * 0.3f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o() {
        if (this.h <= 0.0f) goto L6;
        this.I = this.s;
        return;
    L6:
        View r0 = this.i;
        if ((r0 instanceof wlb.g) == false) goto L13;
        int r1 = r0.getHeight();
        int r2 = ((wlb.g) r0).getViewHeight();
        int r3 = this.c.getHeight() + (r2 - r1);
        if (i() == false) goto L11;
        int r4 = Math.max(this.w, Math.min((this.q - r3) - j(), k()));
    L12:
        Log.i("InlineAIDragView", "updateSelfAdjustTop, currentContentHeight = " + r1 + ", targetContentHeight = " + r2 + ", targetPanelHeight = " + r3 + ", selfAdjustTop = " + r4);
    L17:
        this.I = r4;
        Log.i("InlineAIDragView", "updateSelfAdjustTop: " + this.I);
        return;
    L11:
        r4 = Math.max(this.s, Math.min((this.q - r3) - j(), this.u));
        goto L12
    L13:
        Log.w("InlineAIDragView", "updateSelfAdjustTop, but is not selfAdjust");
        if (i() == false) goto L16;
        r4 = k();
        goto L17
    L16:
        r4 = this.u;
        goto L17
    }

    public final int j() {
        if (i() == true) goto L5;
        int r0 = this.z;
        if (r0 >= 0) goto L19;
        return this.Q - r0;
    L19:
        return this.Q;
    L5:
        if (this.S == false) goto L8;
        return this.P;
    L8:
        if (Intrinsics.areEqual(this.N, Boolean.TRUE) == false) goto L13;
        int r1 = this.l;
        if (r1 > 0) goto L21;
        r1 = this.m;
    L21:
        return Math.max(r1 + this.P, this.Q) - this.z;
    L13:
        r1 = this.l;
        goto L21
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final void b(InlineAIDragView r7) {
        r7.getClass();
        Log.i("InlineAIDragView", "onNestedScrollFinished");
        r7.H = false;
        if ((r7.i instanceof wlb.g) == false) goto L10;
        r7.o();
        Integer r0 = r7.F;
        if (r0 == null) goto L7;
        int r1 = Math.max(r0.intValue(), r7.I);
    L8:
        e(r7, r1, true, false, AdjustTopSource.CONTENT_HEIGHT_CHANGE, 12);
        return;
    L7:
        r1 = r7.I;
        goto L8
    }

    public static final void c(InlineAIDragView r3) {
        r3.getClass();
        Log.i("InlineAIDragView", "showInternal");
        r3.f();
        r3.n(true, false, AdjustTopSource.VIEW_CHANGE);
        r3.b.post(new com.ss.android.lark.inline.ai.ui.l(r3));
    }

    public final void m(Boolean r4) {
        if (this.g == false) goto L11;
        ViewParent r0 = this.b.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L7;
        ViewGroup r1 = (ViewGroup) r0;
    L9:
        if (Intrinsics.areEqual(r1, a(this.a.getWindow())) == true) goto L11;
        boolean r2 = true;
    L12:
        this.S = r2;
        Log.i("InlineAIDragView", "show, keyboardShowingByForce = " + r4 + ", isRootParentAdjustResize = " + this.S);
        this.O = false;
        this.k = this.d.isKeyboardShowing();
        int r3 = this.d.c();
        if (r3 <= 0) goto L15;
        this.m = r3;
    L15:
        this.l = r3;
        this.d.b(this.V);
        this.b.setAlpha(0.0f);
        this.N = r4;
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new m(this));
        this.b.requestLayout();
        return;
    L7:
        r1 = null;
    L11:
        r2 = false;
        goto L12
    }

    public final void g(boolean r4, Function0<Unit> r5) {
        Log.i("InlineAIDragView", "dismiss, doAnim = " + r4);
        this.M = false;
        this.d.a(this.V);
        ObjectAnimator r1 = this.K;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        ObjectAnimator r2 = this.L;
        if (r2 == null) goto L8;
        r2.cancel();
    L8:
        ValueAnimator r3 = this.n;
        if (r3 == null) goto L11;
        r3.cancel();
    L11:
        ValueAnimator r6 = this.o;
        if (r6 == null) goto L14;
        r6.cancel();
    L14:
        this.b.removeCallbacks(this.Y);
        this.b.removeOnLayoutChangeListener(this.W);
        ((FrameLayout) this.a.findViewById(R.id.content)).removeOnLayoutChangeListener(this.W);
        if (r4 == false) goto L17;
        this.b.setAlpha(1.0f);
        ViewGroup r7 = this.c;
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r7, "translationY", new float[]{r7.getTranslationY(), this.q - this.c.getTop()});
        r8.setDuration(200);
        r8.setInterpolator(new DecelerateInterpolator());
        r8.addListener(new i(this, r5));
        this.L = r8;
        r8.start();
        return;
    L17:
        this.b.setAlpha(0.0f);
        this.c.setTranslationY(0.0f);
        this.J = -1;
        r5.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(View r5, int r6) {
        Log.i("InlineAIDragView", "setAdjustableView, view = " + r5 + ", mode = " + r6 + ", isShown = " + this.b.isShown() + ", heightsReady = " + this.M);
        KeyEvent.Callback r0 = this.i;
        boolean r2 = true;
        boolean r1 = Intrinsics.areEqual(r0, r5) ^ true;
        if (r0 == null) goto L5;
    L7:
        r2 = false;
    L8:
        this.i = r5;
        if (r1 == false) goto L17;
        if (r0 == null) goto L15;
        if ((r0 instanceof wlb.g) == false) goto L15;
        ((wlb.g) r0).setOnHeightChangeListener(null);
    L15:
        if ((r5 instanceof wlb.g) == false) goto L17;
        ((wlb.g) r5).setOnHeightChangeListener(new j(this));
    L17:
        this.j = r6;
        if (r5 != 0) goto L21;
        ViewGroup r7 = this.c;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        r8.height = -2;
        r7.setLayoutParams(r8);
    L21:
        if (this.M == false) goto L26;
        this.b.post(new k(this));
        if (r2 == false) goto L27;
        this.b.postDelayed(new l(this), 100);
        return;
    L27:
        return;
    L26:
        return;
    L5:
        if ((r5 instanceof PromptsRecyclerView) == false) goto L7;
        goto L7
    }

    public final void h(boolean r8, boolean r9, AdjustTopSource r10) {
        Log.i("InlineAIDragView", "doRebound()... canHide = " + r8 + ", smooth = " + r9 + ", adjustTopSource = " + r10);
        if (i() == true) goto L5;
        float r0 = this.c.getTop() + this.c.getTranslationY();
        int r1 = this.t;
        int r2 = this.s;
        float r3 = (r1 + r2) / 2;
        if (r0 < r3) goto L29;
        if (r8 == true) goto L35;
    L52:
        boolean r11 = this.i instanceof wlb.g;
        if (r11 == false) goto L58;
        int r4 = (int) r0;
        int r5 = this.I;
        if (r4 != r5) goto L58;
        Pair r12 = new Pair(Integer.valueOf(r5), Boolean.FALSE);
    L63:
        int r6 = ((Number) r12.component1()).intValue();
        boolean r7 = ((Boolean) r12.component2()).booleanValue();
        if (r10 == AdjustTopSource.DRAG) goto L66;
    L72:
        e(this, r6, r9, r7, r10, 8);
        int r13 = (this.q - r6) + this.z;
        if (r13 == this.J) goto L76;
        this.e.a(r13);
        this.J = r13;
        return;
    L76:
        return;
    L66:
        if ((this.i instanceof wlb.g) == false) goto L72;
        if (r6 != this.I) goto L70;
        Integer r14 = null;
    L71:
        this.F = r14;
        goto L72
    L70:
        r14 = Integer.valueOf(r6);
    L58:
        if (r11 == false) goto L60;
        int r15 = this.I;
    L61:
        Pair r16 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r1, r15)), Boolean.FALSE);
    L62:
        r12 = r16;
        goto L63
    L60:
        r15 = this.x;
        goto L61
    L35:
        if (r0 >= this.u) goto L40;
        if (r0 > r3) goto L52;
    L40:
        if (this.A == false) goto L51;
        boolean r17 = this.i instanceof wlb.g;
        if (r17 == false) goto L47;
        int r18 = (int) r0;
        int r19 = this.I;
        if (r18 != r19) goto L47;
        r12 = new Pair(Integer.valueOf(r19), Boolean.FALSE);
    L47:
        if (r17 == false) goto L49;
        int r20 = this.I;
    L50:
        r16 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r1, r20)), Boolean.TRUE);
        goto L62
    L49:
        r20 = this.x;
        goto L50
    L51:
        r12 = new Pair(Integer.valueOf(this.q), Boolean.TRUE);
        goto L63
    L29:
        if ((this.i instanceof wlb.g) == false) goto L31;
        int r21 = this.I;
    L32:
        r12 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r2, r21)), Boolean.FALSE);
        goto L63
    L31:
        r21 = this.x;
        goto L32
    L5:
        if (this.j != 0) goto L7;
        int r22 = this.w;
    L8:
        float r23 = ((this.q - j()) + this.P) - (this.c.getTop() + this.c.getTranslationY());
        if (r8 == false) goto L22;
        int r24 = this.q;
        if ((r23 / r24) >= 0.3f) goto L22;
        if (this.A == true) goto L16;
        r16 = new Pair(Integer.valueOf(r24 - this.l), Boolean.TRUE);
        goto L62
    L16:
        if ((this.i instanceof wlb.g) == false) goto L18;
        int r25 = this.I;
    L19:
        r12 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r22, r25)), Boolean.TRUE);
        goto L63
    L18:
        r25 = this.x;
    L22:
        if ((this.i instanceof wlb.g) == false) goto L24;
        int r26 = this.I;
    L25:
        r12 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r22, r26)), Boolean.FALSE);
        goto L63
    L24:
        r26 = this.x;
        goto L25
    L7:
        r22 = this.s;
        goto L8
    }

    public final void n(boolean r14, boolean r15, AdjustTopSource r16) {
        if (this.M == true) goto L6;
        Log.w("InlineAIDragView", "updateHeight when heights are not ready! so return");
        return;
    L6:
        ObjectAnimator r2 = this.K;
        boolean r5 = true;
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L15;
        Log.w("InlineAIDragView", "updateHeight when showAnim is running! so return");
        return;
    L15:
        int r8 = -2;
        if (this.c.getHeight() != 0) goto L28;
        Log.w("InlineAIDragView", "height is 0, add layout observer");
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new n(this, r14, r15, r16));
        if (this.c.getLayoutParams().height <= 0) goto L20;
        return;
    L20:
        if (this.c.getLayoutParams().height != (-1)) goto L22;
        return;
    L22:
        if (this.c.getLayoutParams().height == (-2)) goto L145;
        ViewGroup r0 = this.c;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (this.i == null) goto L26;
        r8 = f0.a(500);
    L26:
        r1.height = r8;
        r0.setLayoutParams(r1);
        return;
    L145:
        return;
    L28:
        View r4 = this.i;
        if (r4 != null) goto L32;
        ViewGroup r11 = this.c;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        r12.height = -2;
        r11.setLayoutParams(r12);
        this.c.measure(View.MeasureSpec.makeMeasureSpec(this.p, 1073741824), View.MeasureSpec.makeMeasureSpec(this.q, Target.SIZE_ORIGINAL));
        this.x = (this.q - this.c.getMeasuredHeight()) - j();
    L36:
        Log.i("InlineAIDragView", "updateHeight, isInit = " + r14 + ", keyboardChange = " + r15 + ", isKeyboardShowing = " + this.k + ", forceKeyboardWhenShowing = " + this.N + ", topWithMaxHeight = " + this.x + ", adjustableView = " + r4);
        if (r15 == true) goto L39;
    L40:
        ViewGroup r9 = this.c;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r10;
        if (r14 == false) goto L43;
        int r17 = 0;
    L44:
        r13.bottomMargin = r17;
        r9.setLayoutParams(r13);
    L46:
        if (this.h <= 0.0f) goto L49;
        e(this, this.s, false, false, r16, 12);
        return;
    L49:
        if (r15 == false) goto L103;
        if (this.S == true) goto L103;
        this.G = false;
        ValueAnimator r6 = this.o;
        if (r6 == null) goto L55;
        r6.cancel();
    L55:
        ObjectAnimator r7 = this.K;
        if (r7 == null) goto L58;
        r7.cancel();
    L58:
        ValueAnimator r18 = this.n;
        if (r18 == null) goto L61;
        r18.cancel();
    L61:
        ViewGroup.LayoutParams r19 = this.c.getLayoutParams();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int r20 = ((ViewGroup.MarginLayoutParams) r19).bottomMargin;
        int r21 = this.c.getHeight();
        float r22 = this.c.getTranslationY();
        int r110 = j();
        if ((this.i instanceof wlb.g) == false) goto L72;
        if (i() == false) goto L66;
        int r23 = Math.max(this.I, this.w);
    L78:
        int r111 = r23;
        int r24 = (this.q - r111) - r110;
        Log.i("InlineAIDragView", "doKeyboardAnimation, currentMarginBottom = " + r20 + ", currentHeight = " + r21 + ", currentTranslationY = " + r22 + ", targetMarginBottom = " + r110 + ", targetHeight = " + r24 + ", targetTranslationY = 0.0, currentTop = " + this.c.getY() + ", targetTop = " + r111);
        if (r20 != r110) goto L87;
        if (r21 != r24) goto L87;
        if (r22 == 0.0f) goto L85;
        r5 = false;
    L85:
        if (r5 == false) goto L87;
        Log.i("InlineAIDragView", "doKeyboardAnimation, target pos is the same as current, so return");
        return;
    L87:
        ValueAnimator r25 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.o = r25;
        if (r25 == null) goto L90;
        r25.addUpdateListener(new com.ss.android.lark.inline.ai.ui.f(r21, r24, this, r20, r110, r22));
    L90:
        ValueAnimator r26 = this.o;
        if (r26 == null) goto L93;
        r26.addListener(new com.ss.android.lark.inline.ai.ui.e(this));
    L93:
        ValueAnimator r27 = this.o;
        if (r27 == null) goto L96;
        r27.setDuration(140);
    L96:
        ValueAnimator r28 = this.o;
        if (r28 == null) goto L99;
        r28.start();
    L99:
        int r29 = (this.q - r111) + this.z;
        if (r29 == this.J) goto L147;
        this.e.a(r29);
        this.J = r29;
        return;
    L147:
        return;
    L66:
        Integer r30 = this.F;
        if (r30 == null) goto L69;
        int r31 = Math.max(r30.intValue(), this.I);
    L70:
        r23 = Math.max(r31, this.s);
        goto L78
    L69:
        r31 = this.I;
        goto L70
    L72:
        if (i() == true) goto L74;
        r23 = RangesKt.coerceAtLeast(this.t, this.x);
        goto L78
    L74:
        if (this.j != 0) goto L76;
        r23 = RangesKt.coerceAtLeast(this.w, this.x);
        goto L78
    L76:
        r23 = RangesKt.coerceAtLeast(this.s, this.x);
    L103:
        if (this.D == false) goto L106;
        e(this, ((int) this.c.getTranslationY()) + this.c.getTop(), false, false, r16, 12);
        return;
    L106:
        if (this.H == true) goto L150;
        if (r14 == false) goto L126;
        if (i() == true) goto L111;
        View r32 = this.i;
        if (this.j == 0) goto L121;
    L123:
        int r33 = RangesKt.coerceAtLeast(this.t, this.x);
    L124:
        e(this, r33, false, false, r16, 12);
        return;
    L121:
        if ((r32 instanceof wlb.g) == false) goto L123;
        r33 = Math.max(this.s, Math.min(this.I, this.u));
        goto L124
    L111:
        if (this.j != 0) goto L117;
        int r34 = this.w;
        if ((this.i instanceof wlb.g) == false) goto L115;
        int r35 = Math.min(this.I, this.u);
    L116:
        r33 = Math.max(r34, r35);
        goto L124
    L115:
        r35 = this.x;
        goto L116
    L117:
        r33 = RangesKt.coerceAtLeast(this.s, this.x);
        goto L124
    L126:
        if ((this.i instanceof wlb.g) == false) goto L138;
        if (i() == false) goto L131;
        int r36 = Math.max(this.I, this.w);
    L136:
        e(this, r36, false, false, r16, 12);
        return;
    L131:
        Integer r37 = this.F;
        if (r37 == null) goto L134;
        int r38 = Math.max(r37.intValue(), this.I);
    L135:
        r36 = Math.max(r38, this.s);
        goto L136
    L134:
        r38 = this.I;
        goto L135
    L138:
        if (r16 != AdjustTopSource.CONTAINER_CHANGE) goto L141;
        r5 = false;
    L141:
        h(false, r5, r16);
        return;
    L150:
        return;
    L43:
        r17 = j();
        goto L44
    L39:
        if (this.S == false) goto L46;
    L32:
        if (this.j != 0) goto L34;
        int r39 = 0;
    L35:
        this.x = r39;
        goto L36
    L34:
        int r40 = this.c.getHeight();
        int r112 = r4.getHeight();
        r4.measure(View.MeasureSpec.makeMeasureSpec(r4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.q, Target.SIZE_ORIGINAL));
        Log.i("InlineAIDragView", "initContainerHeight: " + r40 + ", initAdjustableViewHeight: " + r112 + ", measuredHeight: " + r4.getMeasuredHeight());
        r39 = (this.q - (r40 + (r4.getMeasuredHeight() - r112))) - j();
        goto L35
    L9:
        if (r2.isRunning() != true) goto L11;
        r3 = true;
        goto L12
    }

    public final void d(int r13, boolean r14, boolean r15, boolean r16, AdjustTopSource r17) {
        if (this.H == false) goto L6;
        return;
    L6:
        if (r14 == false) goto L8;
        Log.i("InlineAIDragView", "adjustToTop, targetTop = " + r13 + ", currentTop = " + this.c.getY() + ", smooth = true, isHide = " + r15 + ", forceKeyboardWhenShowing = " + this.N + ", fromAnimation = " + r16 + ", adjustTopSource = " + r17);
    L9:
        ValueAnimator r0 = this.o;
        if (r0 != null) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L18;
        this.T = new f(this, r13, r14, r15, r16, r17);
        Log.i("InlineAIDragView", "keyboardAnimation is running, add pending adjustToTop task");
        return;
    L18:
        if (r16 == true) goto L23;
        ValueAnimator r2 = this.n;
        if (r2 == null) goto L23;
        r2.cancel();
    L23:
        if (r14 == false) goto L44;
        if (r13 != ((int) this.c.getY())) goto L28;
        Log.i("InlineAIDragView", "adjustToTop smooth return");
        return;
    L28:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{this.c.getY(), r13});
        this.n = r3;
        if (r3 == null) goto L31;
        r3.setDuration(200);
    L31:
        ValueAnimator r4 = this.n;
        if (r4 == null) goto L34;
        r4.setInterpolator(new DecelerateInterpolator());
    L34:
        ValueAnimator r5 = this.n;
        if (r5 == null) goto L37;
        r5.addUpdateListener(new g(this, r17));
    L37:
        ValueAnimator r6 = this.n;
        if (r6 == null) goto L40;
        r6.addListener(new h(r15, this));
    L40:
        ValueAnimator r7 = this.n;
        if (r7 == null) goto L108;
        r7.start();
        return;
    L108:
        return;
    L44:
        if (this.i != null) goto L46;
    L52:
        int r8 = -2;
        if (i() == false) goto L89;
        if (this.j != 0) goto L57;
        int r9 = this.w;
    L59:
        if (r13 > Math.max(r9, this.x)) goto L70;
        this.c.setTranslationY(0.0f);
        ViewGroup r10 = this.c;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L68;
        if (this.i == null) goto L66;
        r8 = (this.q - Math.max(r9, this.x)) - j();
    L66:
        r11.height = r8;
        r10.setLayoutParams(r11);
        return;
    L68:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L70:
        if (this.i != null) goto L77;
        this.c.setTranslationY(r13 - Math.max(r9, this.x));
        ViewGroup r12 = this.c;
        ViewGroup.LayoutParams r18 = r12.getLayoutParams();
        if (r18 == null) goto L75;
        r18.height = -2;
        r12.setLayoutParams(r18);
        return;
    L75:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L77:
        if (r13 > k()) goto L83;
        this.c.setTranslationY(0.0f);
        ViewGroup r19 = this.c;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        if (r20 == null) goto L82;
        r20.height = (this.q - r13) - j();
        r19.setLayoutParams(r20);
        return;
    L82:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L83:
        this.c.setTranslationY(r13 - k());
        ViewGroup r21 = this.c;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L87;
        r22.height = (this.q - k()) - j();
        r21.setLayoutParams(r22);
        return;
    L87:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L57:
        r9 = this.s;
        goto L59
    L89:
        if (r13 >= RangesKt.coerceAtLeast(this.s, this.x)) goto L96;
        ViewGroup r23 = this.c;
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        if (this.i == null) goto L94;
        r8 = (this.q - RangesKt.coerceAtLeast(this.s, this.x)) - j();
    L94:
        r24.height = r8;
        r23.setLayoutParams(r24);
        this.c.setTranslationY(0.0f);
        return;
    L96:
        if (r13 <= RangesKt.coerceAtLeast(this.u, this.x)) goto L102;
        ViewGroup r25 = this.c;
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        if (this.i == null) goto L101;
        r8 = (this.q - RangesKt.coerceAtLeast(this.u, this.x)) - j();
    L101:
        r26.height = r8;
        r25.setLayoutParams(r26);
        this.c.setTranslationY(r13 - RangesKt.coerceAtLeast(this.u, this.x));
        return;
    L102:
        ViewGroup r27 = this.c;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
        if (this.i == null) goto L106;
        r8 = (this.q - r13) - j();
    L106:
        r28.height = r8;
        r27.setLayoutParams(r28);
        this.c.setTranslationY(0.0f);
        return;
    L46:
        if (CollectionsKt.listOf(new AdjustTopSource[]{AdjustTopSource.VIEW_CHANGE, AdjustTopSource.CONTENT_HEIGHT_CHANGE}).contains(r17) == false) goto L52;
        if (this.j != 0) goto L50;
        int r29 = this.w;
    L51:
        ViewGroup r30 = this.c;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
        r31.height = (this.q - RangesKt.coerceAtLeast(r29, r13)) - j();
        r30.setLayoutParams(r31);
        this.c.setTranslationY(0.0f);
        return;
    L50:
        r29 = this.s;
        goto L51
    L12:
        if (r0.isRunning() != true) goto L14;
        r1 = true;
        goto L15
    L8:
        Log.d("InlineAIDragView", "adjustToTop, targetTop = " + r13 + ", currentTop = " + this.c.getY() + ", smooth = false, isHide = " + r15 + ", forceKeyboardWhenShowing = " + this.N + ", fromAnimation = " + r16 + ", adjustTopSource = " + r17);
        goto L9
    }

    public static /* synthetic */ void e(InlineAIDragView r6, int r7, boolean r8, boolean r9, AdjustTopSource r10, int r11) {
        if ((r11 & 4) == 0) goto L5;
        boolean r3 = false;
    L6:
        r6.d(r7, r8, r3, false, r10);
        return;
    L5:
        r3 = r9;
        goto L6
    }

    public InlineAIDragView(FragmentActivity r2, ConstraintLayout r3, ConstraintLayout r4, wlb.d r5, d r6, slb.a r7, int r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "panelRootView");
        Intrinsics.checkNotNullParameter(r4, "panelView");
        Intrinsics.checkNotNullParameter(r5, "keyboardHeightProvider");
        Intrinsics.checkNotNullParameter(r6, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.k = r5.isKeyboardShowing();
        this.l = r5.c();
        this.m = r5.c();
        this.C = true;
        this.G = true;
        this.I = Integer.MAX_VALUE;
        this.J = -1;
        if ((r4 instanceof NSPConstraintLayout) == false) goto L5;
        ((NSPConstraintLayout) r4).setNSPHandler(new e(this));
    L5:
        if (r7 == null) goto L7;
        int r10 = r7.b;
    L8:
        this.P = r10;
        if (r7 == null) goto L11;
        int r11 = r7.a;
    L12:
        this.Q = r11;
        this.V = new com.ss.android.lark.inline.ai.ui.j(this);
        this.W = new com.ss.android.lark.inline.ai.ui.k(this);
        r3.setOnTouchListener(new a(this));
        this.X = new com.ss.android.lark.inline.ai.ui.d(this);
        this.Y = new com.ss.android.lark.inline.ai.ui.c(this);
        return;
    L11:
        r11 = f0.a(32);
        goto L12
    L7:
        r10 = f0.a(8);
        goto L8
    }
}
