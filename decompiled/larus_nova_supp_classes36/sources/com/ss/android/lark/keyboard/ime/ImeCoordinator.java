package com.ss.android.lark.keyboard.ime;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b \b\u0000\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u000201B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\u001a\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010 \u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rH\u0002J\u0018\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\tH\u0016JR\u0010'\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\rH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/ss/android/lark/keyboard/ime/ImeCoordinator;", "Landroid/view/View;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/view/View$OnLayoutChangeListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "lastRootWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "windowInsetsDispatched", "", "contentAvoidImeTolerancePx", "", "insetsDispatchListeners", "", "Lcom/ss/android/lark/keyboard/ime/ImeCoordinator$InsetsDispatchListener;", "addDispatchInsetsListener", "", "listener", "removeDispatchInsetsListener", "onAttachedToWindow", "onDetachedFromWindow", "getContentRootView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "dispatchWindowInsets", "isContentAvoidImeFixEnabled", "isContentAlreadyAvoidIme", "rootInsets", "contentRootView", "getContentAvoidHeight", "isHeightClose", "actual", "expected", "onApplyWindowInsets", "v", "insets", "onLayoutChange", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "InsetsDispatchListener", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImeCoordinator extends View implements OnApplyWindowInsetsListener, View.OnLayoutChangeListener {
    public static final int e = 0;
    public WindowInsetsCompat a;
    public boolean b;
    public final int c;
    public final List<b> d;

    public static final class a {
    }

    public interface b {
        void r(boolean r1, WindowInsetsCompat r2);
    }

    static {
        e = View.generateViewId();
    }

    private final View getContentRootView() {
        return getRootView().findViewById(R.id.content);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewCompat.setOnApplyWindowInsetsListener(this, this);
        View r0 = getContentRootView();
        if (r0 == null) goto L6;
        r0.addOnLayoutChangeListener(this);
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        View r0 = getContentRootView();
        if (r0 == null) goto L6;
        r0.removeOnLayoutChangeListener(this);
        return;
    }

    public ImeCoordinator(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = WindowInsetsCompat.CONSUMED;
        Resources r3 = r2.getResources();
        this.c = (int) (WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density * 24);
        setVisibility(4);
        this.d = new ArrayList();
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r4, final WindowInsetsCompat r5) {
        Intrinsics.checkNotNullParameter(r4, "v");
        Intrinsics.checkNotNullParameter(r5, "insets");
        Log.d("GlobalTraversalObserver", "onApplyWindowInsets called, window insets " + r5.getInsets(WindowInsetsCompat.Type.ime()));
        final View r6 = getContentRootView();
        com.ss.android.lark.keyboard.ime.b r1 = com.ss.android.lark.keyboard.ime.b.a;
        Function0<String> r2 = new AnonymousClass1(this, r6, r5);
        r1.getClass();
        com.ss.android.lark.keyboard.ime.b.a("GlobalTraversalObserver", r2);
        this.b = true;
        requestLayout();
        return r5;
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        Log.d("GlobalTraversalObserver", "onMeasure called");
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r14, final int r15, final int r16, final int r17, final int r18, final int r19, final int r20, final int r21, final int r22) {
        com.ss.android.lark.keyboard.ime.b r0 = com.ss.android.lark.keyboard.ime.b.a;
        Function0<String> r12 = new C04111(r15, r16, r17, r18, r19, r20, r21, r22, this);
        r0.getClass();
        com.ss.android.lark.keyboard.ime.b.a("GlobalTraversalObserver", r12);
        final WindowInsetsCompat r2 = ViewCompat.getRootWindowInsets(getRootView());
        if (Intrinsics.areEqual(r2, this.a) == true) goto L57;
        if (r2 == null) goto L61;
        this.a = r2;
        final View r3 = getContentRootView();
        boolean r4 = true;
        final boolean r5 = !this.b;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Object r6 = Result.constructor-impl(Boolean.valueOf(KeyboardBaseModule.a().isFeatureGatingEnable("messenger.im.enable_ime_coordinator_content_avoid_fix")));     // Catch: Throwable -> L9
    L11:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L14;
        r6 = r7;
    L14:
        final boolean r8 = ((Boolean) r6).booleanValue();
        if (r8 == false) goto L18;
        Log.i("GlobalTraversalObserver", "IME_DIAG ImeCoordinator content avoid IME fix enabled");
    L18:
        if (r8 == false) goto L48;
        if (r3 != null) goto L21;
    L45:
        boolean r9 = false;
    L46:
        if (r9 == false) goto L48;
        boolean r10 = true;
    L49:
        if (r5 == true) goto L53;
        if (r10 == true) goto L53;
        r4 = false;
    L53:
        com.ss.android.lark.keyboard.ime.b r11 = com.ss.android.lark.keyboard.ime.b.a;
        final boolean r110 = r4;
        final boolean r111 = r10;
        Function0<String> r13 = new ImeCoordinator$dispatchWindowInsets$1(r110, r5, r8, r111, this, r3, r2);
        r11.getClass();
        com.ss.android.lark.keyboard.ime.b.a("GlobalTraversalObserver", r13);
        this.b = false;
        Iterator r23 = ((ArrayList) this.d).iterator();
    L55:
        if (r23.hasNext() == false) goto L62;
        ((b) r23.next()).r(r4, this.a);
        goto L55
    L62:
        return;
    L21:
        if (getRootView().getHeight() <= 0) goto L45;
        if (r3.getBottom() <= 0) goto L45;
        int r24 = r2.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        if (r24 <= 0) goto L45;
        if (r2.isVisible(WindowInsetsCompat.Type.ime()) == false) goto L45;
        int r25 = getRootView().getHeight() - r3.getBottom();
        if (r25 <= 0) goto L45;
        int r26 = RangesKt.coerceAtLeast(r24 - r2.getInsets(WindowInsetsCompat.Type.systemBars()).bottom, 0);
        if (Math.abs(r25 - r24) > this.c) goto L36;
        boolean r27 = true;
    L37:
        if (r27 == true) goto L44;
        if (r26 <= 0) goto L45;
        if (Math.abs(r25 - r26) > this.c) goto L42;
        boolean r28 = true;
    L43:
        if (r28 == false) goto L45;
    L42:
        r28 = false;
    L44:
        r9 = true;
        goto L46
    L36:
        r27 = false;
    L48:
        r10 = false;
    L9:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L61:
        return;
    }
}
