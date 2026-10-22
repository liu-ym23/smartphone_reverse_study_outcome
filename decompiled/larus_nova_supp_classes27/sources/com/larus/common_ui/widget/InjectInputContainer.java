package com.larus.common_ui.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import v19.j7;
import v19.k7;
import v19.z5;
import z19.l;
import z19.m;
import z19.n;
import z19.o;
import z19.p;
import z19.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0013\u001a\u00020\rH\u0014J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0014\u0010\u001b\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\u001d\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\u001e\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u001f\u001a\u00020\rJ*\u0010 \u001a\u00020\r2\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/common_ui/widget/InjectInputContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "navigationPadding", "onShowImeCallback", "Lkotlin/Function0;", "", "onHideImeCallback", "onTouchDownCallback", "safeBottomResolver", "Lkotlin/Function3;", "Landroidx/core/view/WindowInsetsCompat;", "onAttachedToWindow", "addView", "child", "Landroid/view/View;", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onShowIme", "block", "onHideIme", "onTouchDown", "resetImePadding", "setSafeBottomResolver", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InjectInputContainer extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public final int a;
    public Function0<Unit> b;
    public Function0<Unit> c;
    public final o d;
    public Function3<? super Context, ? super WindowInsetsCompat, ? super Integer, Integer> e;

    public InjectInputContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InjectInputContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e == null) goto L6;
        post(new l(this));
        return;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r4) {
        Intrinsics.checkNotNullParameter(r4, "child");
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        r0.gravity = 80;
        addView(r4, r0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        if (r2.getAction() != 0) goto L6;
        getClass();
        Unit r0 = Unit.INSTANCE;
    L6:
        return super.onInterceptTouchEvent(r2);
    }

    public final void setSafeBottomResolver(Function3<? super Context, ? super WindowInsetsCompat, ? super Integer, Integer> r1) {
        this.e = r1;
    }

    /* JADX WARN: Type inference failed for: r8v8, types: [z19.o] */
    public InjectInputContainer(final Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        Activity r10 = null;
        if ((r7 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r11 = (FragmentActivity) r7;
    L6:
        if (r11 == null) goto L8;
        int r12 = u.b(r11);
    L9:
        this.a = r12;
        this.b = new m();
        this.c = new n();
        this.d = new o();
        Function1 r1 = new p();
        Function2 r4 = new q(this, r7);
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (z5.d() == false) goto L13;
        z5.e(this, r1, r4, null);
        return;
    L13:
        if (Build.VERSION.SDK_INT < 30) goto L15;
        Intrinsics.checkNotNullParameter(this, "<this>");
        ViewCompat.setWindowInsetsAnimationCallback(this, new ViewExtKt.watchOnImeInsetsAnimationInternal.1(r1, null, null, r4, null));
        return;
    L15:
        Context r13 = getContext();
    L16:
        boolean r14 = r13 instanceof Activity;
        if (r14 == true) goto L21;
        if ((r13 instanceof ContextWrapper) == false) goto L21;
        r13 = ((ContextWrapper) r13).getBaseContext();
    L21:
        if (r14 == false) goto L23;
        r10 = (Activity) r13;
    L23:
        if (r10 == null) goto L44;
        Window r15 = r10.getWindow();
        if (r15 == null) goto L43;
        View r16 = r15.getDecorView();
        if (c.e == false) goto L32;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r17 = ThreadMethodProxy.currentThread();
        if (r17 == c.a) goto L32;
        c.a(r17, "getDecorView");
    L32:
        if (r16 == null) goto L45;
        View r18 = r10.findViewById(R.id.content);
        if (r18 != null) goto L37;
        r18 = r16;
    L37:
        k7 r20 = new k7(r18, r16, r4);
        r18.getViewTreeObserver().addOnGlobalLayoutListener(r20);
        addOnAttachStateChangeListener(new j7(r18, r20));
        return;
    L45:
        return;
    L43:
        return;
    L44:
        return;
    L8:
        r12 = 0;
        goto L9
    L5:
        r11 = null;
        goto L6
    }

    public /* synthetic */ InjectInputContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
