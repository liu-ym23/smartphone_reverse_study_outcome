package com.ss.android.lark.newemoji.emojioptions;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.i0;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements Runnable {
    public final /* synthetic */ OptionsSelectPopupMenu<Object> a;

    public g(OptionsSelectPopupMenu<Object> r1) {
        this.a = r1;
    }

    public final void a() {
        OptionsSelectPopupMenu<Object> r1 = this.a;
        r1.getClass();
        Log.i("OptionsPopupMenu", "onLongClick");
        View r3 = r1.h;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("targetView");
        r3 = null;
    L5:
        r3.sendAccessibilityEvent(2);
        r3.performHapticFeedback(0);
        int r8 = r1.b(6);
        int r4 = r1.b(6);
        Resources r9 = r1.a.getResources();
        DisplayMetrics r10 = WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics());
        Pair r11 = TuplesKt.to(Integer.valueOf(r10.widthPixels), Integer.valueOf(r10.heightPixels));
        int r12 = ((Number) r11.component1()).intValue();
        int r13 = ((Number) r11.component2()).intValue();
        View r14 = r1.d;
        if (r14 != null) goto L8;
        Pair r15 = TuplesKt.to(new IntRange((r8 + 0) - r4, (r12 + r8) - r4), new IntRange(((Number) r1.r.getValue()).intValue() + r8, r13 - r8));
    L9:
        IntRange r5 = (IntRange) r15.component1();
        IntRange r16 = (IntRange) r15.component2();
        int[] r17 = new int[2];
        View r18 = r1.h;
        if (r18 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("targetView");
        r18 = null;
    L12:
        r18.getLocationOnScreen(r17);
        if (i0.a(r1.a) == false) goto L28;
        int r19 = r17[0];
        Object r110 = r1.a.getSystemService("window");
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.view.WindowManager");
        Display r111 = ((WindowManager) r110).getDefaultDisplay();
        DisplayMetrics r112 = new DisplayMetrics();
        if (r111 == null) goto L17;
        r111.getRealMetrics(r112);
    L17:
        int r113 = r112.widthPixels;
        Context r114 = r1.a;
        Intrinsics.checkNotNullParameter(r114, "context");
        Resources r115 = r114.getResources();
        if (r115 == null) goto L22;
        DisplayMetrics r116 = WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics());
        if (r116 == null) goto L22;
        int r117 = r116.widthPixels;
    L23:
        Integer r118 = Integer.valueOf(r117);
        if (r118 == null) goto L26;
        int r119 = r118.intValue();
    L27:
        r17[0] = r19 - (r113 - r119);
        goto L28
    L26:
        r119 = 0;
    L22:
        r117 = 0;
    L28:
        int r7 = r17[0];
        View r120 = r1.h;
        if (r120 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("targetView");
        r120 = null;
    L31:
        int r20 = r7 + (r120.getWidth() / 2);
        IntRange r121 = new IntRange(r20 - (r1.u.getMeasuredWidth() / 2), (r1.u.getMeasuredWidth() / 2) + r20);
        int r122 = r1.b(2);
        int r123 = ((r17[1] - r122) + r4) - r1.u.getMeasuredHeight();
        int r6 = r17[1];
        View r124 = r1.h;
        if (r124 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("targetView");
        View r125 = null;
    L35:
        IntRange r126 = new IntRange(r123, (((r6 + r125.getHeight()) + r122) - r4) + r1.u.getMeasuredHeight());
        if (r121.getFirst() >= r5.getFirst()) goto L41;
        if (r121.getLast() <= r5.getLast()) goto L41;
        Log.e("OptionsPopupMenu", "showImpl: Show popup Error , there no enough horizontal spaces provided to show this popup window. Required width : " + (r121.getLast() - r121.getFirst()) + " , provided : " + (r5.getLast() - r5.getFirst()) + '.');
    L57:
        r1.u.post(new f(r1));
        return;
    L41:
        if (r126.getFirst() >= r5.getFirst()) goto L46;
        if (r126.getLast() <= r16.getLast()) goto L46;
        Log.e("OptionsPopupMenu", "showImpl: Show popup Error , there no enough vertical spaces provided to show this popup window. Required height : " + (r126.getLast() - r126.getFirst()) + " , provided : " + (r16.getLast() - r16.getFirst()) + '.');
    L46:
        if (r121.getFirst() >= r5.getFirst()) goto L49;
        Log.i("OptionsPopupMenu", "showImpl: Exceed left edge, move right.");
        int r21 = r5.getFirst();
    L52:
        b r22 = r1.t;
        r22.setTailOffsetX(((r20 - r21) - (r22.getTailWidth() / 2)) - r8);
        if (r126.getFirst() >= r16.getFirst()) goto L55;
        Log.i("OptionsPopupMenu", "showImpl: Exceed top edge, show drop down");
        r1.t.setPopupGravity(80);
        int r2 = r126.getLast() - r1.u.getMeasuredHeight();
    L56:
        r1.f(r21, r2);
        goto L57
    L55:
        Log.i("OptionsPopupMenu", "showImpl: There is enough vertical spaces to show the popup window.");
        r1.t.setPopupGravity(48);
        r2 = r126.getFirst();
        goto L56
    L49:
        if (r121.getLast() <= r5.getLast()) goto L51;
        Log.i("OptionsPopupMenu", "showImpl: Exceed right edge, move left.");
        r21 = r5.getLast() - r1.u.getMeasuredWidth();
        goto L52
    L51:
        Log.i("OptionsPopupMenu", "showImpl: There is enough horizontal spaces to show the popup window.");
        r21 = r121.getFirst();
        goto L52
    L34:
        r125 = r124;
        goto L35
    L8:
        int[] r127 = new int[2];
        r14.getLocationOnScreen(r127);
        r15 = TuplesKt.to(new IntRange((Math.max(r127[0], 0) + r8) - r4, (Math.min(r127[0] + r1.d.getWidth(), r12) + r8) - r4), new IntRange(Math.max(r127[1], 1) + r8, Math.min(r127[1] + r1.d.getHeight(), r13) - r8));
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
