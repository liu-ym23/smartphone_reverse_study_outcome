package com.ss.android.lark.inline.ai.creationai;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.inline.ai.creationai.quickPrompt.QuickPromptRecyclerView;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.lark.emm.design.edittext.SCUDEditText;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CreationAIDragView {
    public static int h0;
    public static boolean i0;
    public static int j0;
    public int A;
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
    public boolean V;
    public final View W;
    public final View X;
    public boolean Y;
    public final com.ss.android.lark.inline.ai.creationai.i Z;
    public final FragmentActivity a;
    public final com.ss.android.lark.inline.ai.creationai.j a0;
    public final View b;
    public Function0<Unit> b0;
    public final ViewGroup c;
    public final com.ss.android.lark.inline.ai.creationai.b c0;
    public final wlb.d d;
    public final o d0;
    public final d e;
    public final int e0;
    public final int f;
    public final float f0;
    public final boolean g;
    public final com.ss.android.lark.inline.ai.creationai.a g0;
    public final boolean h;
    public final vlb.d i;
    public View j;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public ValueAnimator o;
    public ValueAnimator p;
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/CreationAIDragView$AdjustTopSource;", "", "<init>", "(Ljava/lang/String;I)V", "VIEW_CHANGE", "DRAG", "KEYBOARD_CHANGE", "CONTAINER_CHANGE", "CONTENT_HEIGHT_CHANGE", "SET_ADJUST_CHANGE", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum AdjustTopSource extends Enum<AdjustTopSource> {
        public static final AdjustTopSource CONTAINER_CHANGE = null;
        public static final AdjustTopSource CONTENT_HEIGHT_CHANGE = null;
        public static final AdjustTopSource DRAG = null;
        public static final AdjustTopSource KEYBOARD_CHANGE = null;
        public static final AdjustTopSource SET_ADJUST_CHANGE = null;
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
            AdjustTopSource r9 = new AdjustTopSource("SET_ADJUST_CHANGE", 5);
            SET_ADJUST_CHANGE = r9;
            AdjustTopSource[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
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
        public final /* synthetic */ CreationAIDragView d;

        public a(CreationAIDragView r1) {
            this.d = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r9, MotionEvent r10) {
            Intrinsics.checkNotNullParameter(r9, "v");
            Intrinsics.checkNotNullParameter(r10, "event");
            if (this.d.C == false) goto L5;
        L8:
            int r11 = r10.getAction();
            if (r11 == 0) goto L24;
            if (r11 != 1) goto L12;
            long r2 = System.currentTimeMillis();
            float r12 = r10.getRawX();
            float r4 = r10.getRawY();
            float r13 = r10.getY();
            float r5 = this.d.c.getY();
            Log.i("CreationAIDragView", "background touch up: " + r2 + ", endRawX = " + r12 + ", endRawY = " + r4 + ", endY = " + r13 + ", panelViewTop = " + r5);
            if (r13 < r5) goto L18;
        L25:
            return true;
        L18:
            if ((r2 - this.a) >= 200) goto L25;
            if (Math.abs(r12 - this.b) >= n0.a(20)) goto L25;
            if (Math.abs(r4 - this.c) >= n0.a(20)) goto L25;
            Log.i("CreationAIDragView", "click outside");
            this.d.e.d();
            goto L25
        L12:
            if (r11 != 3) goto L25;
            Log.i("CreationAIDragView", "background touch cancel");
            goto L25
        L24:
            this.a = System.currentTimeMillis();
            this.b = r10.getRawX();
            this.c = r10.getRawY();
            Log.i("CreationAIDragView", "background touch down: " + this.a + ", startRawX = " + this.b + ", startRawY = " + this.c);
            goto L25
        L5:
            if (r10.getY() >= this.d.c.getY()) goto L8;
            return false;
        }
    }

    public static final class b {
    }

    public final class c implements View.OnTouchListener {
        public float a;
        public int b;
        public final /* synthetic */ CreationAIDragView c;

        public c(CreationAIDragView r1) {
            this.c = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r11, MotionEvent r12) {
            Intrinsics.checkNotNullParameter(r11, "v");
            Intrinsics.checkNotNullParameter(r12, "event");
            int r13 = r12.getAction();
            boolean r3 = false;
            if (r13 == 0) goto L35;
            if (r13 != 1) goto L6;
        L22:
            this.c.D = false;
            Log.i("CreationAIDragView", "touch up/cancel y = " + r12.getRawY() + ", rawY = " + r12.getRawY());
            if ((r12.getRawY() - this.a) <= n0.a(60)) goto L26;
            this.c.e.onClose();
            return true;
        L26:
            CreationAIDragView r14 = this.c;
            if (r14.V == false) goto L29;
            r14.c.setTranslationY(0.0f);
        L29:
            CreationAIDragView r15 = this.c;
            if (r15.G == true) goto L32;
        L42:
            return true;
        L32:
            if ((r12.getRawY() - this.a) <= n0.a(60)) goto L34;
            r3 = true;
        L34:
            r15.i(r3, true, AdjustTopSource.DRAG);
            goto L42
        L6:
            if (r13 != 2) goto L8;
            Log.d("CreationAIDragView", "touch move y = " + r12.getY(0) + ", rawY = " + r12.getRawY());
            CreationAIDragView r16 = this.c;
            if (r16.G == true) goto L14;
            r16.D = false;
            return false;
        L14:
            int r17 = (int) (r12.getRawY() - this.a);
            if (r17 >= 0) goto L17;
            return false;
        L17:
            CreationAIDragView r4 = this.c;
            int r18 = this.b + r17;
            r4.E = r18;
            if ((r4.j instanceof wlb.g) == false) goto L20;
            int r5 = Math.max(r4.I, r18);
        L21:
            CreationAIDragView.f(r4, r5, false, false, AdjustTopSource.DRAG, 12);
            goto L42
        L20:
            r5 = r18;
            goto L21
        L8:
            if (r13 == 3) goto L22;
        L35:
            CreationAIDragView r19 = this.c;
            if (r19.H == false) goto L38;
            return false;
        L38:
            r19.D = true;
            r19.G = true;
            ValueAnimator r110 = r19.o;
            if (r110 == null) goto L41;
            r110.cancel();
        L41:
            this.a = r12.getRawY();
            int r111 = this.c.c.getTop() + ((int) this.c.c.getTranslationY());
            this.b = r111;
            this.c.E = r111;
            Log.i("CreationAIDragView", "touch down y = " + r12.getY(0) + ", rawY = " + r12.getRawY() + ", panelInitTop = " + this.b);
            goto L42
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
        public final /* synthetic */ CreationAIDragView j;

        public final void d() {
            boolean r2 = true;
            if (this.f == false) goto L11;
            if (this.e == true) goto L7;
        L9:
            boolean r0 = false;
        L23:
            if (r0 == false) goto L29;
            CreationAIDragView r1 = this.j;
            if (r1.B == true) goto L27;
        L32:
            int r3 = this.d;
            if (r0 == true) goto L35;
        L36:
            CreationAIDragView r4 = this.j;
            if ((r4.j instanceof wlb.g) == true) goto L39;
        L41:
            int r5 = 0;
        L42:
            int r8 = r3 + r5;
            if (r0 == false) goto L55;
            CreationAIDragView r6 = this.j;
            if (r6.B == true) goto L55;
            if ((r6.j instanceof wlb.g) == false) goto L50;
            int r7 = r6.I;
        L52:
            if (r6.k() == false) goto L54;
            int r9 = ((this.g - r7) - this.j.l()) + this.j.P;
        L56:
            CreationAIDragView r10 = this.j;
            float r11 = r9;
            int r12 = r10.c.getHeight();
            float r13 = r10.c.getTranslationY();
            Log.i("CreationAIDragView", "doNestedScrollRebound, currentHeight = " + r12 + ", currentTranslationY = " + r13 + ", targetHeight = " + r8 + ", targetTranslationY = " + r11 + ", currentTop = " + r10.c.getY());
            if (r12 == r8) goto L59;
        L64:
            ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r14.addUpdateListener(new com.ss.android.lark.inline.ai.creationai.e(r12, r8, r10, r13, r11));
            r14.setDuration(200);
            Intrinsics.checkNotNull(r14);
            r14.addListener(new com.ss.android.lark.inline.ai.creationai.f(r10, r0));
            r14.start();
            return;
        L59:
            if (r13 == r11) goto L62;
            r2 = false;
        L62:
            if (r2 == false) goto L64;
            Log.i("CreationAIDragView", "doNestedScrollRebound, target pos is the same as current, so return");
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
            if (this.j.B == false) goto L41;
        L27:
            if ((r1.j instanceof wlb.g) == false) goto L32;
            int r15 = r1.I;
            goto L32
        L29:
            CreationAIDragView r16 = this.j;
            if ((r16.j instanceof wlb.g) == false) goto L32;
            int r17 = r16.I;
            goto L32
        L7:
            if ((this.c - this.a) <= n0.a(60)) goto L9;
        L8:
            r0 = true;
            goto L23
        L11:
            if (this.j.k() == false) goto L16;
            if (((((this.g - this.c) - this.j.l()) + this.j.P) / this.g) < 0.2f) goto L17;
        L18:
            boolean r18 = false;
        L19:
            if (r18 == false) goto L9;
            if ((this.c - this.a) <= n0.a(60)) goto L9;
        L17:
            r18 = true;
            goto L19
        L16:
            if (this.c <= this.j.w) goto L18;
            goto L17
        }

        public e(CreationAIDragView r1) {
            this.j = r1;
            this.i = n0.a(60);
        }

        @Override // com.ss.android.lark.inline.ai.creationai.NSPConstraintLayout.a
        public final boolean a(View r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "target");
            Log.i("CreationAIDragView", "onNestedPreFling, velocityY = " + r3 + ", currentTop = " + this.b + ", dampedCurrentTop = " + this.c + ", startTop = " + this.a + ", isDown = " + this.e);
            this.f = true;
            if (this.c <= this.a) goto L5;
            this.j.u();
            d();
            return true;
        L5:
            CreationAIDragView.b(this.j);
            return false;
        }

        @Override // com.ss.android.lark.inline.ai.creationai.NSPConstraintLayout.a
        public final void onStopNestedScroll(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "target");
            Log.i("CreationAIDragView", "onStopNestedScroll, type = " + r3 + ", hasFling = " + this.f + ", dampedCurrentTop = " + this.c + ", startTop = " + this.a);
            if (r3 == 0) goto L5;
            return;
        L5:
            if (this.f == false) goto L7;
            return;
        L7:
            if (this.c == this.a) goto L9;
            this.j.u();
            d();
            return;
        L9:
            CreationAIDragView.b(this.j);
        }

        @Override // com.ss.android.lark.inline.ai.creationai.NSPConstraintLayout.a
        public final void onStartNestedScroll(View r2, View r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "child");
            Intrinsics.checkNotNullParameter(r3, "target");
            if (r4 != 0) goto L7;
            int r5 = (int) this.j.c.getY();
            this.a = r5;
            this.b = r5;
            this.c = r5;
            this.d = this.j.c.getHeight();
            CreationAIDragView r6 = this.j;
            int r7 = r6.r;
            this.g = r7;
            this.h = r7 - this.a;
            this.e = false;
            this.f = false;
            r6.H = true;
            ValueAnimator r8 = r6.o;
            if (r8 == null) goto L7;
            r8.cancel();
        L7:
            Log.i("CreationAIDragView", "onStartNestedScroll, startTop = " + this.a + ", currentTop = " + this.b + ", type = " + r4);
        }

        @Override // com.ss.android.lark.inline.ai.creationai.NSPConstraintLayout.a
        public final void b(View r4, int r5, int r6, int[] r7) {
            Intrinsics.checkNotNullParameter(r4, "target");
            Intrinsics.checkNotNullParameter(r7, "consumed");
            Log.d("CreationAIDragView", "onNestedScroll, dyUnconsumed = " + r5 + ", type = " + r6);
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
            Log.d("CreationAIDragView", "onNestedScroll, currentTop = " + this.b + ", dampedCurrentTop = " + this.c);
            return;
        }

        @Override // com.ss.android.lark.inline.ai.creationai.NSPConstraintLayout.a
        public final void c(View r5, int r6, int[] r7, int r8) {
            Intrinsics.checkNotNullParameter(r5, "target");
            Intrinsics.checkNotNullParameter(r7, "consumed");
            Log.d("CreationAIDragView", "onNestedPreScroll, dy = " + r6 + ", currentTop = " + this.b + ", startTop = " + this.a + ", type = " + r8);
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
            Log.d("CreationAIDragView", "onNestedPreScroll, currentTop = " + this.b + ", dampedCurrentTop = " + this.c);
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
        public final /* synthetic */ CreationAIDragView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ AdjustTopSource f;

        public f(CreationAIDragView r1, int r2, boolean r3, boolean r4, boolean r5, AdjustTopSource r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.i("CreationAIDragView", "execute pending adjustToTop task");     // Catch: Throwable -> L4
            this.a.e(this.b, this.c, this.d, this.e, this.f);     // Catch: Throwable -> L4
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
        public final /* synthetic */ CreationAIDragView a;
        public final /* synthetic */ AdjustTopSource b;

        public g(CreationAIDragView r1, AdjustTopSource r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r7) {
            Intrinsics.checkNotNullParameter(r7, "it");
            Object r8 = r7.getAnimatedValue();
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Float");
            int r1 = (int) ((Float) r8).floatValue();
            this.a.e(r1, false, false, true, this.b);
        }
    }

    public static final class h extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ CreationAIDragView b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.a == false) goto L9;
            CreationAIDragView r3 = this.b;
            if (r3.B == false) goto L7;
            r3.e.c();
            return;
        L7:
            r3.e.onClose();
            return;
        }

        public h(boolean r1, CreationAIDragView r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class i extends AnimatorListenerAdapter {
        public final /* synthetic */ CreationAIDragView a;
        public final /* synthetic */ Function0<Unit> b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.o();
            Function0<Unit> r3 = this.b;
            if (r3 == null) goto L5;
            r3.invoke();
        L5:
            this.a.n();
        }

        public i(CreationAIDragView r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class j implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;
        public final /* synthetic */ CreationAIDragView c;

        public j(float r1, float r2, CreationAIDragView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            Object r6 = r5.getAnimatedValue();
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Float");
            float r7 = ((Float) r6).floatValue();
            float r0 = this.a - this.b;
            Log.i("CreationAIDragView", "targetY: " + this.a + ", startY: " + this.b);
            StringBuilder r1 = new StringBuilder("translationY: ");
            r1.append(r7);
            r1.append(", total: ");
            r1.append(r0);
            r1.append(", unalpha: ");
            float r3 = r7 / r0;
            r1.append(r3);
            Log.i("CreationAIDragView", r1.toString());
            float r2 = 0.0f;
            if (r0 <= 0.0f) goto L6;
            r2 = 1 - r3;
        L6:
            View r4 = this.c.X;
            if (r4 == null) goto L9;
            r4.setAlpha(r2);
        L9:
            CreationAIDragView r8 = this.c;
            if (r8.Y == false) goto L12;
            r8.q(r2);
        L12:
            float r9 = r7 - this.b;
            CreationAIDragView r10 = this.c;
            if (r9 <= r10.n) goto L16;
            r10.n();
            return;
        }
    }

    public static final class k implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ CreationAIDragView a;

        public static final class a implements Runnable {
            public final /* synthetic */ CreationAIDragView a;

            public a(CreationAIDragView r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CreationAIDragView r0 = this.a;     // Catch: Throwable -> L4
                int r1 = CreationAIDragView.h0;     // Catch: Throwable -> L4
                r0.n();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Log.i("CreationAIDragView", "onGlobalLayout, keyboardHeightMemory = " + this.a.n);
            this.a.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            CreationAIDragView r0 = this.a;
            r0.b.addOnLayoutChangeListener(r0.a0);
            FrameLayout r1 = (FrameLayout) this.a.a.findViewById(R.id.content);
            if (r1 == null) goto L5;
            r1.addOnLayoutChangeListener(this.a.a0);
        L5:
            this.a.getClass();
            boolean r2 = CreationAIDragView.j();
            boolean r3 = rcb.b.a(this.a.a);
            Log.i("CreationAIDragView", "onGlobalLayout: hasHardKeyboard = " + r3 + " enable:" + r2);
            if (r2 == false) goto L10;
            if (r3 == false) goto L10;
            CreationAIDragView.c(this.a);
            CreationAIDragView r4 = this.a;
            r4.b.post(new a(r4));
            return;
        L10:
            if (Intrinsics.areEqual(this.a.N, Boolean.TRUE) == false) goto L14;
            CreationAIDragView r5 = this.a;
            if (r5.n != 0) goto L14;
            r5.O = true;
            r5.b.postDelayed(r5.c0, 200);
            return;
        L14:
            CreationAIDragView.c(this.a);
        }

        public k(CreationAIDragView r1) {
            this.a = r1;
        }
    }

    public static final class l implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ CreationAIDragView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ AdjustTopSource d;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.a.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.a.t(this.b, this.c, this.d);
        }

        public l(CreationAIDragView r1, boolean r2, boolean r3, AdjustTopSource r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final void g() {
        this.q = this.b.getWidth();
        int r0 = this.b.getHeight();
        this.r = r0;
        this.u = (int) (r0 - (r0 * 0.6f));
        this.v = (int) (r0 - (r0 * 0.3f));
        this.w = (int) (r0 - (r0 * 0.2f));
        WindowInsetsCompat r1 = ViewCompat.getRootWindowInsets(a(this.a.getWindow()));
        boolean r2 = false;
        if (r1 == null) goto L7;
        Insets r3 = r1.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r3 == null) goto L7;
        int r4 = r3.top;
    L8:
        int[] r5 = new int[2];
        this.b.getLocationInWindow(r5);
        int[] r6 = new int[2];
        a(this.a.getWindow()).getLocationInWindow(r6);
        this.z = (r6[1] + r4) - r5[1];
        if (r1 == null) goto L13;
        Insets r7 = r1.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r7 == null) goto L13;
        int r8 = r7.bottom;
    L14:
        int[] r9 = new int[2];
        this.b.getLocationInWindow(r9);
        int[] r10 = new int[2];
        a(this.a.getWindow()).getLocationInWindow(r10);
        this.A = ((r10[1] + a(this.a.getWindow()).getHeight()) - r8) - (r9[1] + this.r);
        boolean r11 = idb.f.a().isCurrentEnable("ccm.mobile.forseti");
        int r12 = this.f;
        if (r12 != (-1)) goto L18;
        r12 = n0.a(44);
    L18:
        this.x = r12 + Math.max(this.z, 0);
        this.M = true;
        if (this.S == false) goto L27;
        int r13 = this.s;
        if (r13 > 0) goto L23;
    L26:
        this.s = this.r;
        goto L27
    L23:
        if (r13 <= this.r) goto L25;
        r2 = true;
    L25:
        this.R = Boolean.valueOf(r2);
    L27:
        this.t = this.x;
        Log.i("CreationAIDragView", "calculateHeights, rootViewHeight = " + this.r + ", panelView.height = " + this.c.getHeight() + ", topInNormalPercent = " + this.t + ", isForsetiEnable = " + r11 + ", topIn60Percent = " + this.u + ", topIn30Percent = " + this.v + ", topExceptNaviBar = " + this.x + ", disBetweenRootTopAndActivityTop = " + this.z + ", disBetweenRootBottomAndActivityBottom = " + this.A);
        u();
        return;
    L13:
        r8 = 0;
    L7:
        r4 = 0;
        goto L8
    }

    public final boolean k() {
        Boolean r0 = this.N;
        if (r0 != null) goto L10;
        r0 = this.R;
        if (r0 != null) goto L10;
        return this.l;
    L10:
        return r0.booleanValue();
    }

    public final int m() {
        return ((this.r - l()) + this.P) - ((int) (this.r * 0.3f));
    }

    public final void n() {
        StringBuilder r0 = new StringBuilder("hideKeyboardBg, height: ");
        View r1 = this.W;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getHeight());
    L6:
        r0.append(r2);
        Log.d("CreationAIDragView", r0.toString());
        View r3 = this.W;
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.getVisibility() != 0) goto L13;
        r3.setVisibility(8);
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void o() {
        this.b.setAlpha(0.0f);
        this.c.setTranslationY(0.0f);
        ViewGroup r0 = this.c;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (this.j == null) goto L8;
        int r3 = this.r;
        if (r3 <= 0) goto L7;
        int r4 = (int) (r3 * 0.95f);
    L9:
        r2.height = r4;
        r0.setLayoutParams(r2);
        this.J = -1;
        this.j = null;
        this.M = false;
        Log.i("CreationAIDragView", "reset, setStatusBarTransparent, syncStatusBarColor = " + this.Y);
        if (this.Y == false) goto L12;
        q(0.0f);
    L12:
        h0--;
        return;
    L7:
        r4 = n0.a(714);
        goto L9
    L8:
        r4 = -2;
        goto L9
    }

    public final void s() {
        View r0 = this.W;
        if (r0 != null) goto L5;
    L9:
        StringBuilder r1 = new StringBuilder("showKeyboardBg, height: ");
        View r2 = this.W;
        if (r2 == null) goto L12;
        Integer r3 = Integer.valueOf(r2.getHeight());
    L13:
        r1.append(r3);
        Log.d("CreationAIDragView", r1.toString());
        return;
    L12:
        r3 = null;
        goto L13
    L5:
        if (r0.getVisibility() != 8) goto L9;
        r0.setVisibility(0);
        ViewGroup.LayoutParams r4 = r0.getLayoutParams();
        if (r4 == null) goto L9;
        r4.height = this.n;
        goto L9
    }

    public final void u() {
        this.I = this.t;
        Log.i("CreationAIDragView", "updateSelfAdjustTop: " + this.I + ",  topIn30Percent: " + this.v + ",  topIn30PercentVisibleWithKeyboard: " + m());
    }

    public static boolean j() {
        return idb.f.a().isCurrentEnable("ccm.mobile.fix_pad_show_panel_after_keyboard");
    }

    public final int l() {
        if (k() == true) goto L5;
        int r0 = this.A;
        if (r0 >= 0) goto L19;
        return this.Q - r0;
    L19:
        return this.Q;
    L5:
        if (this.S == false) goto L8;
        return this.P;
    L8:
        if (Intrinsics.areEqual(this.N, Boolean.TRUE) == false) goto L13;
        int r1 = this.m;
        if (r1 > 0) goto L21;
        r1 = this.n;
    L21:
        return Math.max(r1 + this.P, this.Q) - this.A;
    L13:
        r1 = this.m;
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

    public static final void b(CreationAIDragView r7) {
        r7.getClass();
        Log.i("CreationAIDragView", "onNestedScrollFinished");
        r7.H = false;
        if ((r7.j instanceof wlb.g) == false) goto L10;
        r7.u();
        Integer r0 = r7.F;
        if (r0 == null) goto L7;
        int r1 = Math.max(r0.intValue(), r7.I);
    L8:
        f(r7, r1, true, false, AdjustTopSource.CONTENT_HEIGHT_CHANGE, 12);
        return;
    L7:
        r1 = r7.I;
        goto L8
    }

    public static final void c(CreationAIDragView r3) {
        r3.getClass();
        Log.i("CreationAIDragView", "showInternal");
        r3.g();
        r3.t(true, false, AdjustTopSource.VIEW_CHANGE);
        r3.b.post(new n(r3));
    }

    public static final void d(CreationAIDragView r4) {
        r4.getClass();
        boolean r0 = j();
        Log.i("CreationAIDragView", "showKeyboard() called enable:" + r0);
        if (r0 == true) goto L15;
        rcb.c.g(r4.a);
        return;
    L15:
        SCUDEditText r1 = (CreationAIEditText) r4.b.findViewById(2131368258);     // Catch: Exception -> L11
        r1.requestFocus();     // Catch: Exception -> L11
        Object r2 = r1.getContext().getSystemService("input_method");     // Catch: Exception -> L11
        if ((r2 instanceof InputMethodManager) == false) goto L7;
        InputMethodManager r3 = (InputMethodManager) r2;     // Catch: Exception -> L11
    L8:
        if (r3 == null) goto L17;
        r3.showSoftInput(r1, 2);     // Catch: Exception -> L11
        return;
    L17:
        return;
    L7:
        r3 = null;
    L11:
        e = move-exception;
        Log.e("CreationAIDragView", "showKeyboard: Exception:", e);
        rcb.c.g(r4.a);
        Unit r5 = Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(View r9) {
        Log.i("CreationAIDragView", "setAdjustableView, view = " + r9 + ", mode = 0, isShown = " + this.b.isShown() + ", heightsReady = " + this.M);
        KeyEvent.Callback r0 = this.j;
        boolean r2 = Intrinsics.areEqual(r0, r9) ^ true;
        if (r0 == null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        this.j = r9;
        if (r2 == false) goto L17;
        if (r0 == null) goto L15;
        if ((r0 instanceof wlb.g) == false) goto L15;
        ((wlb.g) r0).setOnHeightChangeListener(null);
    L15:
        if ((r9 instanceof wlb.g) == false) goto L17;
        ((wlb.g) r9).setOnHeightChangeListener(new com.ss.android.lark.inline.ai.creationai.k(this));
    L17:
        this.k = 0;
        if (this.D == true) goto L20;
    L22:
        if (r9 != 0) goto L24;
        ViewGroup r1 = this.c;
        ViewGroup.LayoutParams r6 = r1.getLayoutParams();
        r6.height = -2;
        r1.setLayoutParams(r6);
    L24:
        if (r2 == true) goto L26;
        return;
    L26:
        if (this.M == false) goto L36;
        if (r9 != 0) goto L29;
        u();
        t(false, false, AdjustTopSource.CONTENT_HEIGHT_CHANGE);
        Log.i("CreationAIDragView", "setAdjustableView, setStatusBarTransparent ---->");
        q(0.0f);
    L32:
        if (r5 == false) goto L37;
        this.b.postDelayed(new m(this), 100);
        return;
    L37:
        return;
    L29:
        this.d.a(this.Z);
        u();
        t(false, false, AdjustTopSource.SET_ADJUST_CHANGE);
        this.b.postDelayed(new com.ss.android.lark.inline.ai.creationai.l(this), 140);
        this.l = false;
        this.m = 0;
        n();
        Log.i("CreationAIDragView", "setAdjustableView, setStatusBarMask ---->, panelCount = " + h0);
        if (h0 > 1) goto L32;
        q(1.0f);
        goto L32
    L36:
        return;
    L20:
        if (this.V == false) goto L22;
        return;
    L5:
        if ((r9 instanceof QuickPromptRecyclerView) == false) goto L7;
        r5 = true;
        goto L8
    }

    public final void q(float r13) {
        Log.i("CreationAIDragView", "statusbar color, alpha = " + r13 + ", panelCount: " + h0);
        if (r13 >= 0.0f) goto L5;
    L29:
        Log.e("CreationAIDragView", "alpha value over range, alpha: " + r13);
        return;
    L5:
        if (r13 > 1.0f) goto L29;
        Ref.FloatRef r3 = new Ref.FloatRef();
        boolean r5 = true;
        if (i0 == false) goto L10;
        int r4 = h0;
    L12:
        if (r4 >= 2) goto L14;
        r3.element = this.f0 * r13;
    L15:
        Log.i("CreationAIDragView", "set statusBar color alpha: " + r3.element);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new CreationAIDragView$setStatusBarColorAlpha$1(this, r3, null), 3, null);
        if (h0 <= 1) goto L18;
        return;
    L18:
        if (r13 != 1.0f) goto L20;
        boolean r14 = true;
    L21:
        if (r14 == false) goto L23;
        i0 = true;
    L23:
        if (r13 == 0.0f) goto L26;
        r5 = false;
    L26:
        if (r5 == false) goto L32;
        i0 = false;
        return;
    L32:
        return;
    L20:
        r14 = false;
        goto L21
    L14:
        r3.element = 1 - (((float) Math.pow(0.6d, r4 - 1)) * (1.0f - (this.f0 * r13)));
        goto L15
    L10:
        r4 = h0 - 1;
        goto L12
    }

    public final void h(boolean r5, Function0<Unit> r6) {
        Log.i("CreationAIDragView", "dismiss, doAnim = " + r5);
        this.M = false;
        this.d.a(this.Z);
        ObjectAnimator r1 = this.K;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        ObjectAnimator r2 = this.L;
        if (r2 == null) goto L8;
        r2.cancel();
    L8:
        ValueAnimator r3 = this.o;
        if (r3 == null) goto L11;
        r3.cancel();
    L11:
        ValueAnimator r4 = this.p;
        if (r4 == null) goto L14;
        r4.cancel();
    L14:
        this.b.removeCallbacks(this.g0);
        this.b.removeOnLayoutChangeListener(this.a0);
        ((FrameLayout) this.a.findViewById(R.id.content)).removeOnLayoutChangeListener(this.a0);
        if (r5 == false) goto L21;
        this.b.setAlpha(1.0f);
        float r7 = this.c.getTranslationY();
        if (k() == false) goto L19;
        s();
        float r8 = this.c.getHeight() + this.n;
    L20:
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.c, "translationY", new float[]{r7, r8});
        r0.setDuration(250);
        r0.setInterpolator(new DecelerateInterpolator());
        r0.addListener(new i(this, r6));
        r0.addUpdateListener(new j(r8, r7, this));
        this.L = r0;
        r0.start();
    L23:
        if (j() == false) goto L26;
        this.a.getWindow().setSoftInputMode(j0);
        return;
    L26:
        return;
    L19:
        r8 = this.c.getHeight();
        goto L20
    L21:
        o();
        r6.invoke();
        goto L23
    }

    public final void r(Boolean r3, Function0<Unit> r4) {
        this.b0 = r4;
        if (this.g == false) goto L11;
        ViewParent r5 = this.b.getParent();
        if ((r5 instanceof ViewGroup) == false) goto L7;
        ViewGroup r6 = (ViewGroup) r5;
    L9:
        if (Intrinsics.areEqual(r6, a(this.a.getWindow())) == true) goto L11;
        boolean r7 = true;
    L12:
        this.S = r7;
        Log.i("CreationAIDragView", "show, keyboardShowingByForce = " + r3 + ", isRootParentAdjustResize = " + this.S);
        this.O = false;
        this.l = this.d.isKeyboardShowing();
        int r8 = this.d.c();
        if (r8 <= 0) goto L15;
        this.n = r8;
    L15:
        this.m = r8;
        this.d.b(this.Z);
        this.b.setAlpha(0.0f);
        this.N = r3;
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new k(this));
        this.b.requestLayout();
        if (j() == false) goto L19;
        j0 = this.a.getWindow().getAttributes().softInputMode;
        Log.i("CreationAIDragView", "show: originalSoftInputMode:" + j0);
        this.a.getWindow().setSoftInputMode(48);
        return;
    L19:
        return;
    L7:
        r6 = null;
    L11:
        r7 = false;
        goto L12
    }

    public final void i(boolean r9, boolean r10, AdjustTopSource r11) {
        Log.i("CreationAIDragView", "doRebound()... canHide = " + r9 + ", smooth = " + r10 + ", adjustTopSource = " + r11);
        ViewGroup r0 = this.c;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.View");
        int r1 = r0.getMinimumHeight();
        if (r1 <= 0) goto L6;
        Pair r2 = new Pair(Integer.valueOf(this.r - r1), Boolean.valueOf(r9));
    L67:
        int r12 = ((Number) r2.component1()).intValue();
        boolean r5 = ((Boolean) r2.component2()).booleanValue();
        if (r11 == AdjustTopSource.DRAG) goto L70;
    L76:
        f(this, r12, r10, r5, r11, 8);
        int r13 = (this.r - r12) + this.A;
        if (r13 == this.J) goto L80;
        this.e.a(r13);
        this.J = r13;
        return;
    L80:
        return;
    L70:
        if ((this.j instanceof wlb.g) == false) goto L76;
        if (r12 != this.I) goto L74;
        Integer r3 = null;
    L75:
        this.F = r3;
        goto L76
    L74:
        r3 = Integer.valueOf(r12);
        goto L75
    L6:
        if (k() == true) goto L8;
        float r4 = this.c.getTop() + this.c.getTranslationY();
        int r6 = this.u;
        int r7 = this.t;
        float r8 = (r6 + r7) / 2;
        if (r4 < r8) goto L32;
        if (r9 == true) goto L39;
    L56:
        boolean r14 = this.j instanceof wlb.g;
        if (r14 == false) goto L62;
        int r15 = (int) r4;
        int r16 = this.I;
        if (r15 != r16) goto L62;
        Pair r17 = new Pair(Integer.valueOf(r16), Boolean.FALSE);
    L36:
        r2 = r17;
    L62:
        if (r14 == false) goto L64;
        int r18 = this.I;
    L65:
        Pair r19 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r6, r18)), Boolean.FALSE);
    L66:
        r2 = r19;
        goto L67
    L64:
        r18 = this.y;
        goto L65
    L39:
        if (r4 >= this.v) goto L44;
        if (r4 > r8) goto L56;
    L44:
        if (this.B == false) goto L55;
        boolean r20 = this.j instanceof wlb.g;
        if (r20 == false) goto L51;
        int r21 = (int) r4;
        int r22 = this.I;
        if (r21 != r22) goto L51;
        r17 = new Pair(Integer.valueOf(r22), Boolean.FALSE);
    L51:
        if (r20 == false) goto L53;
        int r23 = this.I;
    L54:
        r19 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r6, r23)), Boolean.TRUE);
        goto L66
    L53:
        r23 = this.y;
        goto L54
    L55:
        r17 = new Pair(Integer.valueOf(this.r), Boolean.TRUE);
        goto L36
    L32:
        if ((this.j instanceof wlb.g) == false) goto L34;
        int r24 = this.I;
    L35:
        r17 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r7, r24)), Boolean.FALSE);
        goto L36
    L34:
        r24 = this.y;
        goto L35
    L8:
        if (this.k != 0) goto L10;
        int r25 = this.x;
    L11:
        float r26 = ((this.r - l()) + this.P) - (this.c.getTop() + this.c.getTranslationY());
        if (r9 == false) goto L25;
        int r27 = this.r;
        if ((r26 / r27) >= 0.3f) goto L25;
        if (this.B == true) goto L19;
        r19 = new Pair(Integer.valueOf(r27 - this.m), Boolean.TRUE);
        goto L66
    L19:
        if ((this.j instanceof wlb.g) == false) goto L21;
        int r28 = this.I;
    L22:
        r17 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r25, r28)), Boolean.TRUE);
        goto L36
    L21:
        r28 = this.y;
    L25:
        if ((this.j instanceof wlb.g) == false) goto L27;
        int r29 = this.I;
    L28:
        r17 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r25, r29)), Boolean.FALSE);
        goto L36
    L27:
        r29 = this.y;
        goto L28
    L10:
        r25 = this.t;
        goto L11
    }

    public final void t(boolean r11, boolean r12, AdjustTopSource r13) {
        if (this.M == true) goto L6;
        Log.w("CreationAIDragView", "updateHeight when heights are not ready! so return");
        return;
    L6:
        ObjectAnimator r0 = this.K;
        boolean r2 = true;
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L15;
        Log.w("CreationAIDragView", "updateHeight when showAnim is running! so return");
        return;
    L15:
        int r4 = -2;
        if (this.c.getHeight() != 0) goto L31;
        Log.w("CreationAIDragView", "height is 0, add layout observer");
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new l(this, r11, r12, r13));
        if (this.c.getLayoutParams().height <= 0) goto L20;
        return;
    L20:
        if (this.c.getLayoutParams().height != (-1)) goto L22;
        return;
    L22:
        if (this.c.getLayoutParams().height == (-2)) goto L126;
        ViewGroup r14 = this.c;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (this.j == null) goto L29;
        int r16 = this.r;
        if (r16 <= 0) goto L28;
        r4 = (int) (r16 * 0.95f);
        goto L29
    L28:
        r4 = n0.a(714);
    L29:
        r15.height = r4;
        r14.setLayoutParams(r15);
        return;
    L126:
        return;
    L31:
        View r3 = this.j;
        if (r3 != null) goto L35;
        ViewGroup r7 = this.c;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        r8.height = -2;
        r7.setLayoutParams(r8);
        this.c.measure(View.MeasureSpec.makeMeasureSpec(this.q, 1073741824), View.MeasureSpec.makeMeasureSpec(this.r, Target.SIZE_ORIGINAL));
        this.y = (this.r - this.c.getMeasuredHeight()) - l();
    L39:
        Log.i("CreationAIDragView", "updateHeight, isInit = " + r11 + ", keyboardChange = " + r12 + ", isKeyboardShowing = " + this.l + ",  isRootParentAdjustResize = " + this.S + ", forceKeyboardWhenShowing = " + this.N + ", topWithMaxHeight = " + this.y + ", adjustableView = " + r3);
        if (r12 == true) goto L42;
    L43:
        ViewGroup r5 = this.c;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r6;
        r9.bottomMargin = l();
        r5.setLayoutParams(r9);
    L44:
        if (r12 == false) goto L81;
        if (this.S == true) goto L81;
        this.G = false;
        ValueAnimator r17 = this.p;
        if (r17 == null) goto L50;
        r17.cancel();
    L50:
        ObjectAnimator r18 = this.K;
        if (r18 == null) goto L53;
        r18.cancel();
    L53:
        ValueAnimator r19 = this.o;
        if (r19 == null) goto L56;
        r19.cancel();
    L56:
        ViewGroup.LayoutParams r110 = this.c.getLayoutParams();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int r10 = ((ViewGroup.MarginLayoutParams) r110).bottomMargin;
        int r20 = this.c.getHeight();
        float r111 = this.c.getTranslationY();
        int r21 = l();
        int r112 = (int) this.c.getY();
        int r22 = (this.r - r112) - r21;
        Log.i("CreationAIDragView", "doKeyboardAnimation, currentMarginBottom = " + r10 + ", currentHeight = " + r20 + ", currentTranslationY = " + r111 + ", targetMarginBottom = " + r21 + ", targetHeight = " + r22 + ", targetTranslationY = 0.0, currentTop = " + this.c.getY() + ", targetTop = " + r112);
        if (r10 != r21) goto L65;
        if (r20 != r22) goto L65;
        if (r111 == 0.0f) goto L63;
        r2 = false;
    L63:
        if (r2 == false) goto L65;
        Log.i("CreationAIDragView", "doKeyboardAnimation, target pos is the same as current, so return");
        return;
    L65:
        ValueAnimator r113 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.p = r113;
        if (r113 == null) goto L68;
        r113.addUpdateListener(new com.ss.android.lark.inline.ai.creationai.d(r20, r22, this, r10, r21));
    L68:
        ValueAnimator r114 = this.p;
        if (r114 == null) goto L71;
        r114.addListener(new com.ss.android.lark.inline.ai.creationai.c(this));
    L71:
        ValueAnimator r115 = this.p;
        if (r115 == null) goto L74;
        r115.setDuration(140);
    L74:
        ValueAnimator r116 = this.p;
        if (r116 == null) goto L77;
        r116.start();
    L77:
        int r117 = (this.r - r112) + this.A;
        if (r117 == this.J) goto L128;
        this.e.a(r117);
        this.J = r117;
        return;
    L128:
        return;
    L81:
        if (this.D == false) goto L84;
        f(this, this.c.getTop() + ((int) this.c.getTranslationY()), false, false, r13, 12);
        return;
    L84:
        if (this.H == true) goto L131;
        if (r11 == false) goto L107;
        if (k() == true) goto L89;
        View r118 = this.j;
        if (this.k == 0) goto L99;
    L101:
        int r119 = RangesKt.coerceAtLeast(this.u, this.y);
    L103:
        if (this.h == false) goto L105;
        r119 = this.r - this.c.getHeight();
    L105:
        f(this, r119, false, false, r13, 12);
        return;
    L99:
        if ((r118 instanceof wlb.g) == false) goto L101;
        r119 = Math.max(this.t, Math.min(this.I, this.v));
        goto L103
    L89:
        if (this.k != 0) goto L95;
        int r120 = this.x;
        if ((this.j instanceof wlb.g) == false) goto L93;
        int r121 = Math.min(this.I, this.v);
    L94:
        r119 = Math.max(r120, r121);
        goto L103
    L93:
        r121 = this.y;
        goto L94
    L95:
        r119 = RangesKt.coerceAtLeast(this.t, this.y);
        goto L103
    L107:
        if ((this.j instanceof wlb.g) == false) goto L119;
        if (k() == false) goto L112;
        int r122 = Math.max(this.I, this.x);
    L117:
        f(this, r122, false, false, r13, 12);
        return;
    L112:
        Integer r123 = this.F;
        if (r123 == null) goto L115;
        int r124 = Math.max(r123.intValue(), this.I);
    L116:
        r122 = Math.max(r124, this.t);
        goto L117
    L115:
        r124 = this.I;
        goto L116
    L119:
        if (r13 != AdjustTopSource.CONTAINER_CHANGE) goto L122;
        r2 = false;
    L122:
        i(false, r2, r13);
        return;
    L131:
        return;
    L42:
        if (this.S == false) goto L44;
    L35:
        if (this.k != 0) goto L37;
        int r23 = 0;
    L38:
        this.y = r23;
        goto L39
    L37:
        int r24 = this.c.getHeight();
        int r25 = r3.getHeight();
        r3.measure(View.MeasureSpec.makeMeasureSpec(r3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.r, Target.SIZE_ORIGINAL));
        Log.i("CreationAIDragView", "initContainerHeight: " + r24 + ", initAdjustableViewHeight: " + r25 + ", measuredHeight: " + r3.getMeasuredHeight());
        r23 = (this.r - (r24 + (r3.getMeasuredHeight() - r25))) - l();
        goto L38
    L9:
        if (r0.isRunning() != true) goto L11;
        r1 = true;
        goto L12
    }

    public final void e(int r13, boolean r14, boolean r15, boolean r16, AdjustTopSource r17) {
        if (this.H == false) goto L6;
        return;
    L6:
        if (r14 == false) goto L8;
        Log.i("CreationAIDragView", "adjustToTop, targetTop = " + r13 + ", currentTop = " + this.c.getY() + ", smooth = true, isHide = " + r15 + ", forceKeyboardWhenShowing = " + this.N + ", fromAnimation = " + r16 + ", adjustTopSource = " + r17);
    L9:
        ValueAnimator r0 = this.p;
        int r3 = 0;
        if (r0 != null) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L18;
        this.T = new f(this, r13, r14, r15, r16, r17);
        Log.i("CreationAIDragView", "keyboardAnimation is running, add pending adjustToTop task");
        return;
    L18:
        if (r16 == true) goto L23;
        ValueAnimator r2 = this.o;
        if (r2 == null) goto L23;
        r2.cancel();
    L23:
        if (r17 != AdjustTopSource.SET_ADJUST_CHANGE) goto L31;
        int r4 = this.A;
        if (r4 >= 0) goto L27;
        int r5 = this.Q - r4;
    L28:
        int r6 = this.I;
        ViewGroup r7 = this.c;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        r9.height = (this.r - r6) - r5;
        r9.bottomMargin = 0;
        r7.setLayoutParams(r9);
        this.c.setTranslationY(0.0f);
        Log.i("CreationAIDragView", "set adjust change panelView height: " + this.c.getHeight());
        return;
    L27:
        r5 = this.Q;
        goto L28
    L31:
        if (r14 == false) goto L52;
        if (r13 != ((int) this.c.getY())) goto L36;
        Log.i("CreationAIDragView", "adjustToTop smooth return");
        return;
    L36:
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{this.c.getY(), r13});
        this.o = r10;
        if (r10 == null) goto L39;
        r10.setDuration(200);
    L39:
        ValueAnimator r11 = this.o;
        if (r11 == null) goto L42;
        r11.setInterpolator(new DecelerateInterpolator());
    L42:
        ValueAnimator r12 = this.o;
        if (r12 == null) goto L45;
        r12.addUpdateListener(new g(this, r17));
    L45:
        ValueAnimator r18 = this.o;
        if (r18 == null) goto L48;
        r18.addListener(new h(r15, this));
    L48:
        ValueAnimator r19 = this.o;
        if (r19 == null) goto L155;
        r19.start();
        return;
    L155:
        return;
    L52:
        if (this.j != null) goto L54;
    L83:
        int r20 = -2;
        if (k() == false) goto L126;
        if (this.k != 0) goto L88;
        int r21 = this.x;
    L90:
        if (r13 > Math.max(r21, this.y)) goto L101;
        this.c.setTranslationY(0.0f);
        ViewGroup r22 = this.c;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L99;
        if (this.j == null) goto L97;
        r20 = (this.r - Math.max(r21, this.y)) - l();
    L97:
        r23.height = r20;
        r22.setLayoutParams(r23);
        return;
    L99:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L101:
        if (this.V == false) goto L107;
        if (this.D == false) goto L107;
        ViewGroup r24 = this.c;
        r24.setTranslationY(r13 - r24.getTop());
        return;
    L107:
        if (this.j != null) goto L114;
        this.c.setTranslationY(r13 - Math.max(r21, this.y));
        ViewGroup r25 = this.c;
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        if (r26 == null) goto L112;
        r26.height = -2;
        r25.setLayoutParams(r26);
        return;
    L112:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L114:
        if (r13 > m()) goto L120;
        this.c.setTranslationY(0.0f);
        ViewGroup r27 = this.c;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
        if (r28 == null) goto L119;
        r28.height = (this.r - r13) - l();
        r27.setLayoutParams(r28);
        return;
    L119:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L120:
        this.c.setTranslationY(r13 - m());
        ViewGroup r29 = this.c;
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
        if (r30 == null) goto L124;
        r30.height = (this.r - m()) - l();
        r29.setLayoutParams(r30);
        return;
    L124:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L88:
        r21 = this.t;
        goto L90
    L126:
        if (this.V == false) goto L132;
        if (this.D == false) goto L132;
        ViewGroup r31 = this.c;
        r31.setTranslationY(r13 - r31.getTop());
        return;
    L132:
        if (r13 >= RangesKt.coerceAtLeast(this.t, this.y)) goto L139;
        ViewGroup r32 = this.c;
        ViewGroup.LayoutParams r33 = r32.getLayoutParams();
        if (this.j == null) goto L137;
        r20 = (this.r - RangesKt.coerceAtLeast(this.t, this.y)) - l();
    L137:
        r33.height = r20;
        r32.setLayoutParams(r33);
        this.c.setTranslationY(0.0f);
        return;
    L139:
        if (r13 <= RangesKt.coerceAtLeast(this.v, this.y)) goto L145;
        ViewGroup r34 = this.c;
        ViewGroup.LayoutParams r35 = r34.getLayoutParams();
        if (this.j == null) goto L144;
        r20 = (this.r - RangesKt.coerceAtLeast(this.v, this.y)) - l();
    L144:
        r35.height = r20;
        r34.setLayoutParams(r35);
        this.c.setTranslationY(r13 - RangesKt.coerceAtLeast(this.v, this.y));
        return;
    L145:
        ViewGroup r36 = this.c;
        ViewGroup.LayoutParams r37 = r36.getLayoutParams();
        if (this.j == null) goto L149;
        r20 = (this.r - r13) - l();
    L149:
        r37.height = r20;
        r36.setLayoutParams(r37);
        this.c.setTranslationY(0.0f);
        return;
    L54:
        if (CollectionsKt.listOf(new AdjustTopSource[]{AdjustTopSource.VIEW_CHANGE, AdjustTopSource.CONTENT_HEIGHT_CHANGE}).contains(r17) == false) goto L83;
        if (this.k != 0) goto L58;
        int r38 = this.x;
    L59:
        ViewGroup r39 = this.c;
        ViewGroup.LayoutParams r40 = r39.getLayoutParams();
        r40.height = (this.r - RangesKt.coerceAtLeast(r38, r13)) - l();
        r39.setLayoutParams(r40);
        this.c.setTranslationY(0.0f);
        if (this.U == true) goto L62;
        return;
    L62:
        if ((this.j instanceof QuickPromptRecyclerView) == false) goto L158;
        Iterator r41 = ViewGroupKt.getChildren(this.c).iterator();
        int r42 = 0;
        int r43 = 0;
    L65:
        if (r41.hasNext() == false) goto L73;
        Object r44 = r41.next();
        int r45 = r43 + 1;
        if (r43 >= 0) goto L70;
        CollectionsKt.throwIndexOverflow();
    L70:
        if (Intrinsics.areEqual((View) r44, this.j) == false) goto L72;
        r42 = r43;
    L72:
        r43 = r45;
        goto L65
    L73:
        if (r42 <= 0) goto L78;
        int r46 = 0;
    L75:
        if (r3 >= r42) goto L77;
        r46 = r46 + this.c.getChildAt(r3).getHeight();
        r3 = r3 + 1;
        goto L75
    L77:
        r3 = r46;
    L78:
        View r47 = this.j;
        if (r47 == null) goto L159;
        ViewGroup.LayoutParams r48 = r47.getLayoutParams();
        if (r48 == null) goto L160;
        r48.height = this.c.getLayoutParams().height - r3;
        return;
    L160:
        return;
    L159:
        return;
    L158:
        return;
    L58:
        r38 = this.t;
        goto L59
    L12:
        if (r0.isRunning() != true) goto L14;
        r1 = true;
        goto L15
    L8:
        Log.d("CreationAIDragView", "adjustToTop, targetTop = " + r13 + ", currentTop = " + this.c.getY() + ", smooth = false, isHide = " + r15 + ", forceKeyboardWhenShowing = " + this.N + ", fromAnimation = " + r16 + ", adjustTopSource = " + r17);
        goto L9
    }

    public static /* synthetic */ void f(CreationAIDragView r6, int r7, boolean r8, boolean r9, AdjustTopSource r10, int r11) {
        if ((r11 & 4) == 0) goto L5;
        boolean r3 = false;
    L6:
        r6.e(r7, r8, r3, false, r10);
        return;
    L5:
        r3 = r9;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationAIDragView(FragmentActivity r2, ConstraintLayout r3, ViewGroup r4, wlb.d r5, d r6, slb.a r7, int r8, boolean r9, boolean r10, vlb.d r11) {
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
        this.h = r10;
        this.i = r11;
        this.l = r5.isKeyboardShowing();
        this.m = r5.c();
        this.n = r5.c();
        this.C = true;
        this.G = true;
        this.I = Integer.MAX_VALUE;
        this.J = -1;
        this.Y = true;
        if ((r4 instanceof NSPConstraintLayout) == false) goto L6;
        ((NSPConstraintLayout) r4).setNSPHandler(new e(this));
    L6:
        if (r7 == null) goto L8;
        int r12 = r7.b;
    L9:
        this.P = r12;
        if (r7 == null) goto L12;
        int r13 = r7.a;
    L13:
        this.Q = r13;
        r3.setOnTouchListener(new a(this));
        this.W = r3.findViewById(2131368224);
        this.X = r3.findViewById(2131368263);
        this.Z = new com.ss.android.lark.inline.ai.creationai.i(this);
        this.a0 = new com.ss.android.lark.inline.ai.creationai.j(this);
        this.c0 = new com.ss.android.lark.inline.ai.creationai.b(this);
        this.d0 = new o(this);
        this.e0 = 2131100562;
        this.f0 = 0.4f;
        this.g0 = new com.ss.android.lark.inline.ai.creationai.a(this);
        return;
    L12:
        r13 = n0.a(0);
        goto L13
    L8:
        r12 = n0.a(0);
        goto L9
    }
}
