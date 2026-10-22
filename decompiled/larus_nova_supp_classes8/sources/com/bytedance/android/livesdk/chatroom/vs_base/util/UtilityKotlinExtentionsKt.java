package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class UtilityKotlinExtentionsKt {
    public static final Handler a = null;

    static {
        a = new Handler(Looper.getMainLooper());
    }

    public static final Sequence<View> a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$children");
        return SequencesKt.sequence(new UtilityKotlinExtentionsKt$children$1(r2, null));
    }

    public static final float b(float r2) {
        Resources r0 = TTMiddlewareLiveSDK.getContext().getApplicationContext().getResources();
        return (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r2) + 0.5f;
    }

    public static final int c(int r0) {
        return (int) b(r0);
    }

    public static final float d(int r2) {
        Resources r0 = TTMiddlewareLiveSDK.getContext().getApplicationContext().getResources();
        return (r2 / WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f;
    }

    public static final ViewGroup f(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$parentView");
        ViewParent r2 = r1.getParent();
        if ((r2 instanceof ViewGroup) == true) goto L6;
        r2 = null;
    L6:
        return (ViewGroup) r2;
    }

    public static void g(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        a.post(new a0(r2));
    }

    public static final void h(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$setVisibilityGone");
        UIUtils.setViewVisibility(r1, 8);
    }

    public static final void i(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$setVisibilityInVisible");
        UIUtils.setViewVisibility(r1, 4);
    }

    public static final void j(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$setVisibilityVisible");
        UIUtils.setViewVisibility(r1, 0);
    }

    public static final boolean e(Object r4, Object... r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$isAnyOf");
        Intrinsics.checkNotNullParameter(r5, "args");
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (Intrinsics.areEqual(r5[r2], r4) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    public static final void k(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$visibleOrGone");
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }
}
