package com.bytedance.android.accessibilityLib_Core.tool;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.bytedance.android.accessibilityLib_Core.config.base.AbstractBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.bean.b;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AccessibilityCommonToolExtKt {
    public static final int c() {
        Resources r0 = com.bytedance.android.accessibilityLib_Core.helper.a.a().getResources();
        if (r0 == null) goto L7;
        DisplayMetrics r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics());
        if (r1 == null) goto L7;
        float r10 = r1.density;
    L9:
        return (int) ((60.0f * r10) + 0.5f);
    L7:
        r10 = 1.0f;
        goto L9
    }

    public static final void a(IBaseConfig r10, Function1<? super IBaseConfig, Unit> r11) {
        ArrayDeque r0 = new ArrayDeque();
        r0.add(r10);
    L4:
        if ((!r0.isEmpty()) == false) goto L16;
        IBaseConfig r12 = (IBaseConfig) r0.removeFirst();
        r11.invoke(r12);
        if ((r12 instanceof AbstractBaseConfig) == false) goto L4;
        Iterator<b> r13 = ((AbstractBaseConfig) r12).b.b.iterator();
    L9:
        if (r13.hasNext() == false) goto L4;
        com.bytedance.android.accessibilityLib_Core.config.bean.a r1 = r13.next().a;
        if (r1 == null) goto L13;
        IBaseConfig r14 = r1.a;
    L14:
        if (r14 == null) goto L9;
        r0.add(r14);
        goto L9
    L13:
        r14 = null;
        goto L14
    }

    public static final void b(final View r10, final Function1<? super View, Boolean> r11, final Function1<? super View, Unit> r12) {
        if ((r10 instanceof ViewGroup) == true) goto L8;
        boolean r13 = ((Boolean) r11.invoke(r10)).booleanValue();
        Function0<Unit> r0 = new AccessibilityCommonToolExtKt$bfsVisitWithCondition$1(r12, r10);
        if (r13 == false) goto L30;
        r0.invoke();
        return;
    L30:
        return;
    L8:
        final ArrayDeque r1 = new ArrayDeque();
        r1.add(r10);
    L10:
        if ((!r1.isEmpty()) == false) goto L23;
        final ViewGroup r14 = (ViewGroup) r1.removeFirst();
        boolean r15 = ((Boolean) r11.invoke(r14)).booleanValue();
        Function0<Unit> r16 = new AccessibilityCommonToolExtKt$bfsVisitWithCondition$2(r12, r14);
        if (r15 == false) goto L14;
        r16.invoke();
    L14:
        Iterator r17 = ViewGroupKt.getChildren(r14).iterator();
    L16:
        if (r17.hasNext() == false) goto L10;
        final View r18 = (View) r17.next();
        boolean r19 = ((Boolean) r11.invoke(r18)).booleanValue();
        Function0<Unit> r20 = new AccessibilityCommonToolExtKt$bfsVisitWithCondition$$inlined$forEach$lambda$1(r18, r11, r12, r1);
        if (r19 == false) goto L21;
        r20.invoke();
    L21:
        if ((r18 instanceof ViewGroup) == false) goto L16;
        r1.add(r18);
        goto L16
    }
}
