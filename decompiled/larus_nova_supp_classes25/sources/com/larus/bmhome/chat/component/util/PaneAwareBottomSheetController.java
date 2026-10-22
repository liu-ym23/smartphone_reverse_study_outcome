package com.larus.bmhome.chat.component.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ce8.e;
import ce8.f;
import ce8.g;
import ce8.h;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import t1a.b;
import va8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PaneAwareBottomSheetController {
    public static final WeakHashMap<View, Boolean> d = null;
    public final BottomSheetDialogFragment a;
    public View b;
    public final PaneAwareBottomSheetController$lifecycleObserver$1 c;

    public static final class a {
        public static void b(View r2) {
            if (r2.getFitsSystemWindows() == false) goto L6;
            r2.setFitsSystemWindows(false);
        L6:
            if (r2.getPaddingLeft() == 0) goto L8;
        L13:
            r2.setPadding(0, 0, 0, 0);
            return;
        L8:
            if (r2.getPaddingTop() != 0) goto L13;
            if (r2.getPaddingRight() != 0) goto L13;
            if (r2.getPaddingBottom() != 0) goto L13;
        }

        public static WindowInsetsCompat a(View r1, WindowInsetsCompat r2) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r2, "insets");
            WeakHashMap<View, Boolean> r0 = PaneAwareBottomSheetController.d;
            b(r1);
            WindowInsetsCompat.Builder r3 = new WindowInsetsCompat.Builder(r2);
            int r4 = WindowInsetsCompat.Type.navigationBars();
            Insets r5 = Insets.NONE;
            return r3.setInsets(r4, r5).setInsets(WindowInsetsCompat.Type.statusBars(), r5).build();
        }

        public static Pair c(View r4, View r5) {
            Intrinsics.checkNotNullParameter(r4, "pane");
            Intrinsics.checkNotNullParameter(r5, "rootView");
            int r0 = 0;
            int r1 = 0;
        L3:
            if (r4 == r5) goto L11;
            r0 = r0 + (r4.getLeft() - r4.getScrollX());
            r1 = r1 + (r4.getTop() - r4.getScrollY());
            Object r6 = r4.getParent();
            if ((r6 instanceof View) == false) goto L7;
            r4 = (View) r6;
        L8:
            if (r4 != null) goto L3;
            return null;
        L7:
            r4 = null;
            goto L8
        L11:
            return TuplesKt.to(Integer.valueOf(r0), Integer.valueOf(r1));
        }
    }

    static {
        d = new WeakHashMap();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.bmhome.chat.component.util.PaneAwareBottomSheetController$createDialog$1] */
    public final PaneAwareBottomSheetController$createDialog$1 b() {
        final Context r0 = this.a.requireContext();
        final int r1 = this.a.getTheme();
        return new PaneAwareBottomSheetController$createDialog$1(this, r0, r1);
    }

    public final boolean c() {
        Fragment r0 = this.a.getParentFragment();
        xe8.a r1 = null;
        if (r0 == null) goto L9;
        b r2 = s1a.a.g(r0);
        if (r2 == null) goto L9;
        m r3 = r2.getAbility(m.class);
        if (r3 == null) goto L9;
        Fragment r4 = r3.getChatFragment();
    L11:
        if ((r4 instanceof xe8.a) == false) goto L14;
        r1 = (xe8.a) r4;
    L14:
        if (r1 == null) goto L21;
        ChatBubbleParams r5 = r1.Mz();
        if (r5 != null) goto L18;
        return false;
    L18:
        if (r5.a != true) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    L9:
        r4 = null;
        goto L11
    }

    public final void e() {
        this.a.getLifecycle().removeObserver(this.c);
        View r0 = this.b;
        if (r0 == null) goto L13;
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L8;
        ViewGroup r2 = (ViewGroup) r1;
    L9:
        if (r2 == null) goto L11;
        r2.removeView(r0);
    L11:
        this.b = null;
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void d() {
        if (c() == true) goto L6;
        return;
    L6:
        if (this.b != null) goto L42;
        FragmentActivity r0 = this.a.getActivity();
        View r2 = null;
        if (r0 == null) goto L17;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L17;
        View r3 = r1.getDecorView();
        if (c.e == false) goto L19;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == c.a) goto L19;
        c.a(r4, "getDecorView");
    L19:
        if ((r3 instanceof ViewGroup) == false) goto L21;
        ViewGroup r5 = (ViewGroup) r3;
    L22:
        if (r5 != null) goto L24;
        FLogger.a.w("PaneAwareBSC", "attachMask skip: activity or decorView unavailable");
        goto L42
    L24:
        final View r6 = new View(r5.getContext());
        r6.setBackgroundColor(1711276032);
        r6.setOnClickListener(new h(r6, this));
        Fragment r7 = this.a.getParentFragment();
        if (r7 == null) goto L27;
        View r8 = r7.getView();
    L28:
        if (r8 == null) goto L30;
        r2 = r8.getRootView();
    L30:
        int r9 = 0;
        if (r8 == null) goto L40;
        if (r2 == null) goto L40;
        if (r8.getWidth() <= 0) goto L40;
        if (r2.getWidth() <= 0) goto L40;
        Pair r10 = a.c(r8, r2);
        if (r10 == null) goto L40;
        int r11 = RangesKt.coerceAtLeast(((Number) r10.getFirst()).intValue(), 0);
        r9 = r8.getWidth();
        int r12 = r11;
    L41:
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(r9, -1);
        r13.gravity = 8388659;
        r13.leftMargin = r12;
        r5.addView(r6, r13);
        this.b = r6;
        this.a.getLifecycle().addObserver(this.c);
        FLogger.a.d("PaneAwareBSC", "maskAttach: initLeft=" + r12 + ", initWidth=" + r9);
    L40:
        r12 = 0;
        goto L41
    L27:
        r8 = null;
        goto L28
    L21:
        r5 = null;
    L17:
        r3 = null;
    L42:
        Dialog r14 = this.a.getDialog();
        if (r14 == null) goto L62;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L53
        View r16 = r14.findViewById(2131368870);     // Catch: Throwable -> L53
        if (r16 != null) goto L48;
        FLogger.a.w("PaneAwareBSC", "ensureExpanded: design_bottom_sheet not found");     // Catch: Throwable -> L53
    L51:
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L61;
        FLogger.a.w("PaneAwareBSC", "ensureBottomSheetExpanded failed: " + r18);
        return;
    L61:
        return;
    L48:
        BottomSheetBehavior r19 = BottomSheetBehavior.from(r16);     // Catch: Throwable -> L53
        if (r19.getState() == 3) goto L51;
        r19.setSkipCollapsed(true);     // Catch: Throwable -> L53
        r19.setState(3);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.bmhome.chat.component.util.PaneAwareBottomSheetController$lifecycleObserver$1] */
    public PaneAwareBottomSheetController(BottomSheetDialogFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.c = new PaneAwareBottomSheetController$lifecycleObserver$1(this);
    }

    public final void a(Window r7) {
        Intrinsics.checkNotNullParameter(r7, "window");
        if (c() == true) goto L5;
        return;
    L5:
        Fragment r0 = this.a.getParentFragment();
        if (r0 == null) goto L8;
        View r1 = r0.getView();
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        int r2 = r1.getWidth();
        int r3 = r1.getHeight();
        if (r2 <= 0) goto L26;
        if (r3 <= 0) goto L27;
        View r4 = r1.getRootView();
        if (r4 != null) goto L18;
        return;
    L18:
        int r5 = r4.getHeight();
        if (r5 > 0) goto L21;
        return;
    L21:
        Pair r6 = a.c(r1, r4);
        if (r6 != null) goto L24;
        return;
    L24:
        int r8 = ((Number) r6.component1()).intValue();
        int r9 = ((Number) r6.component2()).intValue();
        int r10 = RangesKt.coerceAtLeast(r8, 0);
        int r11 = RangesKt.coerceAtLeast(r5 - (r9 + r3), 0);
        WindowManager.LayoutParams r12 = r7.getAttributes();
        r12.width = r2;
        r12.height = -2;
        r12.gravity = 8388691;
        r12.x = r10;
        r12.y = r11;
        r7.setAttributes(r12);
        FLogger.a.d("PaneAwareBSC", "initialWindowApply: paneW=" + r2 + ", paneH=" + r3 + ", paneLeft=" + r10 + ", y=" + r11);
        return;
    L27:
        return;
    L26:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final View f(Context r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "content");
        if (c() == true) goto L5;
        return r6;
    L5:
        PaneAwareFrameLayout r0 = new PaneAwareFrameLayout(r5, null, 6, 0);
        r0.setPaneProvider(new e(this));
        r0.setWindowProvider(new f(this));
        r0.setMaskProvider(new g(this));
        r0.addView(r6, new FrameLayout.LayoutParams(-1, -2));
        return r0;
    }
}
