package com.larus.bmhome.view.screenmenu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.interaction.ObricMessagePopupServiceDelegate;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public static void b(View r1) {
        Intrinsics.checkNotNullParameter(r1, "host");
        Balloon r2 = d(r1);
        if (r2 != null) goto L10;
        return;
    L10:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        r2.h();     // Catch: Throwable -> L7
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static View c(List r3) {
        Iterator r4 = CollectionsKt.reversed(r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L23;
        DialogFragment r0 = (Fragment) r4.next();
        View r1 = c(r0.getChildFragmentManager().getFragments());
        if (r1 != null) goto L7;
        if ((r0 instanceof DialogFragment) == false) goto L4;
        DialogFragment r2 = r0;
        if (r2.isAdded() == false) goto L4;
        Dialog r5 = r2.getDialog();
        if (r5 == null) goto L4;
        if (r5.isShowing() == false) goto L4;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L23;
        View r7 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L36;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r8 = ThreadMethodProxy.currentThread();
        if (r8 == com.larus.home.impl.utils.c.a) goto L37;
        com.larus.home.impl.utils.c.a(r8, "getDecorView");
        return r7;
    L37:
        return r7;
    L36:
        return r7;
    L7:
        return r1;
    L23:
        return null;
    }

    public static Balloon d(View r4) {
        Object r1 = com.larus.utils.l.b(r4, "ext_balloon_pop");
        Balloon r2 = null;
        if (r1 != null) goto L6;
        return null;
    L6:
        if ((r1 instanceof WeakReference) == false) goto L13;
        Object r3 = ((WeakReference) r1).get();
        if ((r3 instanceof Balloon) == false) goto L10;
        r2 = (Balloon) r3;
    L10:
        if (r2 != null) goto L17;
        com.larus.utils.l.d(r4, "ext_balloon_pop");
        return r2;
    L17:
        return r2;
    L13:
        if ((r1 instanceof Balloon) == false) goto L15;
        Balloon r5 = (Balloon) r1;
        com.larus.utils.l.c(r4, "ext_balloon_pop", new WeakReference(r5));
        return r5;
    L15:
        com.larus.utils.l.d(r4, "ext_balloon_pop");
        return null;
    }

    public static boolean e(View r0) {
        if (r0 == null) goto L4;
        Balloon r1 = d(r0);
    L5:
        if (r1 != null) goto L9;
        return false;
    L9:
        return r1.g;
    L4:
        r1 = null;
        goto L5
    }

    public final Balloon f(final View r21, View r22, int r23, boolean r24, Integer r25, Function1 r26, final Function0 r27) {
        Intrinsics.checkNotNullParameter(r21, "itemView");
        Intrinsics.checkNotNullParameter(r22, "menuView");
        Context r0 = r21.getContext();
    L3:
        View r3 = null;
        if ((r0 instanceof ContextWrapper) == false) goto L9;
        if ((r0 instanceof Activity) == true) goto L7;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L3
    L7:
        Activity r1 = (Activity) r0;
    L11:
        if ((r1 instanceof FragmentActivity) == false) goto L13;
        FragmentActivity r2 = (FragmentActivity) r1;
    L14:
        if (r2 == null) goto L18;
        r3 = c(r2.getSupportFragmentManager().getFragments());
    L18:
        if (r3 != null) goto L20;
    L23:
        Balloon r4 = a(this, r21, r22, r24, r25, r26, null, r27, 32);
        r4.v(r21, 0, r23);
        return r4;
    L20:
        if (r3.isAttachedToWindow() == false) goto L23;
        Balloon r5 = a(this, r3, r22, r24, r25, r26, null, new b(r27, r21), 32);
        com.larus.utils.l.c(r21, "ext_balloon_pop", new WeakReference(r5));
        int[] r6 = new int[2];
        r21.getLocationOnScreen(r6);
        int[] r7 = new int[2];
        r3.getLocationOnScreen(r7);
        r5.v(r3, ((r6[0] + (r21.getWidth() / 2)) - (r7[0] + (r3.getWidth() / 2))) + 0, (r6[1] - r7[1]) + r23);
        return r5;
    L13:
        r2 = null;
        goto L14
    L9:
        r1 = null;
        goto L11
    }

    public static Balloon a(d r3, final View r4, View r5, boolean r6, Integer r7, Function1 r8, LifecycleOwner r9, final Function0 r10, int r11) {
        if ((r11 & 4) == 0) goto L6;
        r6 = true;
    L6:
        if ((r11 & 8) == 0) goto L9;
        r7 = null;
    L9:
        if ((r11 & 16) == 0) goto L12;
        r8 = null;
    L12:
        if ((r11 & 32) == 0) goto L15;
        r9 = null;
    L15:
        if ((r11 & 64) == 0) goto L17;
        r10 = null;
    L17:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "host");
        Intrinsics.checkNotNullParameter(r5, "menu");
        Balloon.a r12 = new Balloon.a(r4.getContext());
        int r13 = Integer.MIN_VALUE;
        r12.n(Integer.MIN_VALUE);
        if (r7 == null) goto L20;
        r13 = r7.intValue();
    L20:
        r12.j(r13);
        r12.z = 16.0f;
        r12.e(ArrowPositionRules.ALIGN_BALLOON);
        r12.f(0);
        r12.p = 0.5f;
        r12.v = 0;
        r12.g(BalloonAnimation.FADE);
        r12.g0 = r6;
        r12.h(true);
        r12.T = true;
        r12.l(new a(r10, r4));
        if (r9 == null) goto L23;
        r12.W = r9;
    L23:
        r12.c(v19.c.b(2130972060, r4.getContext(), 2131243034));
        Intrinsics.checkNotNullParameter(r5, "layout");
        r12.I = r5;
        if (r8 == null) goto L26;
        r8.invoke(r12);
    L26:
        Balloon r14 = r12.b();
        com.larus.utils.l.c(r4, "ext_balloon_pop", new WeakReference(r14));
        return r14;
    }

    public static void g(Balloon r4, View r5, View r6, float r7, float r8, int r9, int r10, int r11, boolean r12, int r13) {
        if ((r13 & 16) == 0) goto L6;
        r9 = i5.y0(v19.c.b(2130971299, null, 2131166968));
    L6:
        if ((r13 & 32) == 0) goto L9;
        r10 = 0;
    L9:
        if ((r13 & 64) == 0) goto L12;
        r11 = 0;
    L12:
        if ((r13 & 128) == 0) goto L14;
        r12 = false;
    L14:
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "anchor");
        Intrinsics.checkNotNullParameter(r6, "menuView");
        ObricMessagePopupServiceDelegate r14 = ObricMessagePopupServiceDelegate.b;
        if (r14.prepareFollowClickMenuBeforeShow(r5, r6) == true) goto L17;
        com.larus.utils.l.d(r5, "ext_balloon_pop");
        return;
    L17:
        int[] r2 = new int[2];
        r5.getLocationOnScreen(r2);
        r6.measure(r10, r11);
        int r15 = (int) r7;
        int r16 = r15 - (r6.getMeasuredWidth() / 2);
        int r17 = (int) r8;
        int r18 = -((r5.getHeight() - r17) + r9);
        r14.markNextDropdownRewriteIfNeeded(r5, r4.e);
        if ((((r2[1] + r5.getHeight()) + r18) + r6.getMeasuredHeight()) <= com.larus.utils.i.c(r5.getContext())) goto L25;
        int r19 = r17 + r9;
        int r20 = r15 - (r5.getWidth() / 2);
        if (r12 == false) goto L24;
        int r21 = ((r2[0] + (r5.getWidth() / 2)) - (r6.getMeasuredWidth() / 2)) * (-1);
        if (r20 >= r21) goto L24;
        r20 = r21;
    L24:
        r4.v(r5, r20, r19);
        return;
    L25:
        if (r12 == false) goto L29;
        int r22 = r2[0] * (-1);
        if (r16 >= r22) goto L29;
        r16 = r22;
    L29:
        r4.x(r5, r16, r18);
    }
}
