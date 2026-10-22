package com.ss.android.lark.keyboard.keyboard2;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.keyboard.event.HeightChange;
import com.ss.android.lark.keyboard.event.ImeState;
import com.ss.android.lark.keyboard.event.r;
import com.ss.android.lark.keyboard.ime.ExtensionImeKt;
import com.ss.android.lark.keyboard.ime.ImeStateDetail;
import com.ss.android.lark.keyboard.ime.ImeWrapper;
import com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent;
import com.ss.android.lark.keyboard.keyboard2.content.KeyboardMainContent;
import com.ss.android.lark.keyboard.utils.TransitionUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class BasicKeyboard implements com.ss.android.lark.keyboard.b, com.ss.android.lark.keyboard.ime.e, View.OnLayoutChangeListener, com.ss.android.lark.keyboard.ime.i, com.ss.android.lark.keyboard.ime.g {
    public static final /* synthetic */ int u = 0;
    public final Map<c.a<?>, c> a;
    public final KeyboardRootContainer b;
    public final FrameLayout c;
    public final ViewGroup d;
    public final com.ss.android.lark.keyboard.event.o e;
    public final KeyboardMainContent f;
    public final com.ss.android.lark.keyboard.keyboard2.content.b g;
    public final KeyboardImeWrapper h;
    public final KeyboardMenu i;
    public final k j;
    public int k;
    public final List<Function0<Unit>> l;
    public Function0<Unit> m;
    public boolean n;
    public boolean o;
    public boolean p;
    public final Lazy q;
    public final Lazy r;
    public boolean s;
    public TransitionWrapper t;

    public static final class a {
    }

    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ BasicKeyboard b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
            this.a.removeOnAttachStateChangeListener(this);
            BasicKeyboard.P(this.b);
        }

        public b(KeyboardRootContainer r1, BasicKeyboard r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.ime.e
    public final void K(int r1, int r2, int r3, float r4, float r5) {
    }

    public abstract View T();

    @Override // com.ss.android.lark.keyboard.ime.e
    public final void g(int r1, int r2, int r3, int r4, float r5) {
    }

    @Override // com.ss.android.lark.keyboard.b
    public final d H() {
        c r0 = y(d.N1);
        if (r0 == null) goto L7;
        return (d) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.ss.android.lark.keyboard.ime.e
    public final void J() {
        this.m.invoke();
    }

    @Override // com.ss.android.lark.keyboard.b
    public com.ss.android.lark.keyboard.keyboard2.b L() {
        c r0 = y(com.ss.android.lark.keyboard.keyboard2.b.K1);
        if (r0 == null) goto L7;
        return (com.ss.android.lark.keyboard.keyboard2.b) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void U() {
        KeyboardRootContainer r0 = this.b;
        r0.getClass();
        long r1 = System.currentTimeMillis();
        r0.measure(r0.e, r0.f);
        Log.d("keyboard", "keyboard remeasure, cost: " + (System.currentTimeMillis() - r1));
    }

    @Override // com.ss.android.lark.keyboard.b
    public final k l() {
        c r0 = y(k.f);
        if (r0 == null) goto L7;
        return (k) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.ss.android.lark.keyboard.b
    public final com.ss.android.lark.keyboard.keyboard2.content.c v() {
        c r0 = y(com.ss.android.lark.keyboard.keyboard2.content.c.O1);
        if (r0 == null) goto L7;
        return (com.ss.android.lark.keyboard.keyboard2.content.c) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.ss.android.lark.keyboard.b
    public final com.ss.android.lark.keyboard.ime.a z() {
        c r0 = y(KeyboardImeWrapper.D);
        if (r0 == null) goto L7;
        return (com.ss.android.lark.keyboard.ime.a) r0;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.ss.android.lark.keyboard.b
    public final com.ss.android.lark.keyboard.event.k e() {
        return this.e;
    }

    public static final void P(BasicKeyboard r2) {
        r2.getClass();
        Log.i("keyboard", "attached");
        Iterator r0 = ((ArrayList) r2.l).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function0) r0.next()).invoke();
        goto L4
    L6:
        Iterator r1 = ((LinkedHashMap) r2.a).values().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((c) r1.next()).d();
        goto L8
    L10:
        KeyboardRootContainer r3 = r2.b;
        if (r3.isAttachedToWindow() == true) goto L13;
        Q(r2);
    L14:
        r2.b.addOnLayoutChangeListener(r2);
        if (r2.p == true) goto L17;
        return;
    L17:
        if (((Boolean) r2.r.getValue()).booleanValue() == false) goto L23;
        r2.d.removeAllViews();
        r2.d.addView(r2.h);
        r2.h.l(r2);
        ExtensionImeKt.a(r2.h, r2);
        r2.h.n(r2);
        return;
    L23:
        return;
    L13:
        r3.addOnAttachStateChangeListener(new com.ss.android.lark.keyboard.keyboard2.a(r3, r2));
        goto L14
    }

    public static final void Q(BasicKeyboard r2) {
        r2.getClass();
        Log.i("keyboard", "detached");
        r2.h.H(r2);
        ExtensionImeKt.b(r2.h, r2);
        KeyboardImeWrapper r0 = r2.h;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) r0.k).remove(r2);
        Iterator r1 = ((LinkedHashMap) r2.a).values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((c) r1.next()).j();
        goto L4
    L6:
        r2.b.removeOnLayoutChangeListener(r2);
        r2.p = true;
    }

    public final void S(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        r2.addView(this.b);
        KeyboardRootContainer r3 = this.b;
        if (r3.isAttachedToWindow() == false) goto L5;
        P(this);
        return;
    L5:
        r3.addOnAttachStateChangeListener(new b(r3, this));
    }

    public final void V(int r4) {
        int r0 = this.f.d.getHeight();
        int r2 = 0;
        if (this.b.getVisibility() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r2 = (this.c.getHeight() - r0) + r4;
    L8:
        this.k = r2;
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.ime.e
    public final void a(int r3) {
        if (this.o == true) goto L5;
        this.b.setMinimumHeight(0);
    L5:
        this.g.l().c(r3);
        V(r3);
        Log.i("keyboard", "notifyKeyboardHeightChange: height is " + this.k);
    }

    @Override // com.ss.android.lark.keyboard.ime.g
    public final boolean r(com.ss.android.lark.keyboard.ime.f r5) {
        Intrinsics.checkNotNullParameter(r5, "imeInsets");
        if (r5.d == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == false) goto L33;
        View r7 = this.b.getRootView().findFocus();
        if (r7 == null) goto L12;
    L15:
        if (r7 == null) goto L20;
        boolean r8 = !Intrinsics.areEqual(this.b.findFocus(), r7);
        if (r8 == false) goto L19;
        Log.i("keyboard", "focus view is not in keyboard, intercept action");
    L19:
        return r8;
    L20:
        Log.i("keyboard", "focus view is null ,request focus");
        boolean r9 = this.j.getContext().hasWindowFocus();
        if (com.larus.home.impl.utils.c.e == false) goto L25;
        FLogger.a.i("DecorViewLancet", "hasWindowFocus");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L25;
        com.larus.home.impl.utils.c.a(r0, "hasWindowFocus");
    L25:
        if (r9 == false) goto L33;
        KeyboardImeWrapper r10 = this.h;
        Function0<? extends View> r1 = r10.u;
        View r11 = r10;
        if (r1 == null) goto L32;
        View r2 = (View) r1.invoke();
        r11 = r10;
        if (r2 == null) goto L32;
        r11 = r2;
    L32:
        r11.requestFocus();
        goto L33
    L12:
        if (((Boolean) this.q.getValue()).booleanValue() == false) goto L15;
        Log.i("keyboard", "focus view is null, intercept ime enter");
        return true;
    L33:
        return false;
    L5:
        if (r5.e == false) goto L7;
        r6 = true;
        goto L8
    }

    @Override // com.ss.android.lark.keyboard.b
    public final <E extends c> E y(c.a<E> r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        c r3 = this.a.get(r2);
        if ((r3 instanceof c) == true) goto L7;
        return null;
    L7:
        return (E) r3;
    }

    public final void R(c.a<?> r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "element");
        this.a.put(r2, r3);
        r3.setKeyboard(this);
    }

    @Override // com.ss.android.lark.keyboard.ime.i
    public final void u(ImeState r2, ImeState r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "to");
        this.h.requestLayout();
        com.ss.android.lark.keyboard.event.k.a.a(this.e, com.ss.android.lark.keyboard.event.e.a(r2, r3));
    }

    @Override // com.ss.android.lark.keyboard.ime.i
    public final void B(ImeStateDetail r4, ImeStateDetail r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r5, "to");
        if (r4 != r5) goto L5;
        return;
    L5:
        Log.d("keyboard", "notifyStateTransform: from " + r4 + ", to " + r5 + ", type: " + r6);
        ImeWrapper.a r0 = ImeWrapper.B;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (r6 != 1) goto L8;
        com.ss.android.lark.keyboard.event.k.a.a(this.e, com.ss.android.lark.keyboard.event.e.a(new com.ss.android.lark.keyboard.event.n(r4), new com.ss.android.lark.keyboard.event.n(r5)));
        return;
    L8:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (r6 != 2) goto L13;
        com.ss.android.lark.keyboard.event.k.a.a(this.e, com.ss.android.lark.keyboard.event.e.a(new r(r4), new r(r5)));
        return;
    }

    public BasicKeyboard(Context r5, KeyboardImeWrapper r6, KeyboardMenu r7, k r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "wrapper");
        Intrinsics.checkNotNullParameter(r7, "menu");
        Intrinsics.checkNotNullParameter(r8, "keyboardContext");
        this.a = new LinkedHashMap();
        View r0 = LayoutInflater.from(r5).inflate(2131561719, null, false);
        r0.setTag(2131376756, Boolean.TRUE);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.keyboard.keyboard2.KeyboardRootContainer");
        KeyboardRootContainer r1 = (KeyboardRootContainer) r0;
        this.b = r1;
        FrameLayout r2 = (FrameLayout) r1.findViewById(2131376758);
        this.c = r2;
        ViewGroup r3 = (ViewGroup) r1.findViewById(2131375111);
        this.d = r3;
        this.e = new com.ss.android.lark.keyboard.event.o(this);
        KeyboardMainContent r4 = new KeyboardMainContent(r5);
        this.f = r4;
        com.ss.android.lark.keyboard.keyboard2.content.b r9 = new com.ss.android.lark.keyboard.keyboard2.content.b(r4);
        this.g = r9;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.l = new ArrayList();
        this.m = BasicKeyboard$animateHeightChangeNotifier$1.INSTANCE;
        this.q = LazyKt.lazy(BasicKeyboard$isFocuslessImeInsetsFilterEnabled$2.INSTANCE);
        this.r = LazyKt.lazy(BasicKeyboard$isVoiceKeyboardWithEmoji$2.INSTANCE);
        R(com.ss.android.lark.keyboard.keyboard2.content.c.O1, r9);
        R(KeyboardImeWrapper.D, r6);
        R(d.N1, r7);
        R(k.f, r8);
        Intrinsics.checkNotNullParameter(r2, "contentContainer");
        r9.d = r2;
        KeyboardMainContent r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "content");
        r10.k(r9.r());
        Map<String, IKeyboardContent> r11 = r9.e;
        r10.b.getClass();
        r11.put("MainContent", r10);
        if (r9.i == true) goto L5;
        ((ArrayList) r9.g).add(r10);
    L6:
        r9.a(r9.a.b, true);
        r3.removeAllViews();
        r3.addView(r6);
        r6.l(this);
        ExtensionImeKt.a(r6, this);
        r6.n(this);
        View r12 = r7.f;
        Intrinsics.checkNotNullParameter(r12, "menuView");
        r4.e.removeAllViews();
        r4.e.addView(r12);
        return;
    L5:
        r9.n(r10);
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.ime.e
    public final void n(int r17, final int r18, final long r19, final Interpolator r21) {
        Intrinsics.checkNotNullParameter(r21, "interpolator");
        this.g.l().c(r18);
        if (this.n == true) goto L30;
        Log.d("keyboard", "setupHeightChangeTransition called");
        V(r18);
        final FrameLayout r4 = this.c;
        if (TransitionUtils.a(r4) == false) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L13;
        Log.e("keyboard", "setupHeightChangeTransition: current content has transition running, method return.");
        return;
    L13:
        KeyboardMainContent r2 = this.f;
        KeyboardChangeBounds r11 = new KeyboardChangeBounds();
        KeyboardRootContainer r12 = this.b;
        final Rect r13 = new Rect(r12.getLeft(), r12.getTop(), r12.getRight(), r12.getBottom());
        final Rect r9 = new Rect();
        Function3<View, Rect, Rect, Unit> r14 = new BasicKeyboard$prepareChangeBounds$1$1(this, r9, r13);
        Intrinsics.checkNotNullParameter(r14, "handleAction");
        r11.d = r14;
        TransitionWrapper r3 = new TransitionWrapper(r2.j(r11));
        TransitionWrapper r5 = this.t;
        if (r5 == null) goto L16;
        r5.cancel();
    L16:
        this.t = r3;
        r3.excludeTarget(this.i.f, true);
        r3.setDuration(r19);
        r3.setInterpolator(r21);
        final int r6 = r4.getHeight();
        if (r18 >= r17) goto L19;
        KeyboardRootContainer r10 = this.b;
        r10.setMinimumHeight(r10.getHeight());
    L19:
        if (r18 < r17) goto L21;
    L23:
        boolean r15 = false;
    L24:
        r3.addListener(new BasicKeyboard$setupHeightChangeTransition$1(this));
        if (r15 == false) goto L27;
        ChangeBounds r0 = new ChangeBounds();
        r0.excludeTarget(this.h.getPanel(), true);
        r0.setDuration(r19);
        r0.setInterpolator(r21);
        TransitionManager.beginDelayedTransition(this.d, r0);
    L27:
        TransitionManager.beginDelayedTransition(r4, r3);
        this.o = true;
        this.s = true;
        this.m = new BasicKeyboard$setupHeightChangeTransition$2(this, r6, r18, r4, r19, r21);
        return;
    L21:
        if (this.h.B() == true) goto L23;
        r15 = true;
        goto L24
    L8:
        if (ViewCompat.isLaidOut(r4) == false) goto L10;
        r1 = true;
        goto L11
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        com.ss.android.lark.keyboard.keyboard2.b r10 = this.f.e().L();
        if ((r10 instanceof mob.a) == false) goto L5;
        mob.a r11 = (mob.a) r10;
    L6:
        if (r11 == null) goto L8;
        r11.A();
    L8:
        boolean r12 = false;
        int r13 = this.b.getHeight() - 0;
        Log.d("keyboard", "onGlobalLayout: height change " + this.k + " -> " + r13);
        this.k = r13;
        if (this.h.T() == false) goto L11;
    L16:
        boolean r14 = true;
    L17:
        if (r14 == false) goto L20;
        return;
    L20:
        if (this.b.getVisibility() != 0) goto L22;
        r12 = true;
    L22:
        if (r12 == false) goto L31;
        Log.i("keyboard", "notifyKeyboardHeightChange: height is " + this.k);
        int r15 = this.k;
        if (this.s == false) goto L27;
        Log.d("keyboard", "NotifyHeightChange suppressed");
        return;
    L27:
        Log.i("keyboard", "notifyKeyboardHeightChange: height is " + r15);
        HeightChange r16 = HeightChange.b.a();
        r16.a = r15;
        com.ss.android.lark.keyboard.event.k.a.a(this.e, r16);
        r16.recycle();
        return;
    L31:
        return;
    L11:
        if (this.n == true) goto L16;
        if (this.o == true) goto L16;
        r14 = false;
        goto L17
    L5:
        r11 = null;
        goto L6
    }
}
