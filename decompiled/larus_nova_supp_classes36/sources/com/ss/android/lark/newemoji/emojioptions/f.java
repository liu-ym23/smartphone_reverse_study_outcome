package com.ss.android.lark.newemoji.emojioptions;

import android.view.View;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements Runnable {
    public final /* synthetic */ OptionsSelectPopupMenu<Object> a;

    public f(OptionsSelectPopupMenu<Object> r1) {
        this.a = r1;
    }

    public final void a() {
        OptionsSelectPopupMenu<Object> r0 = this.a;
        r0.i = true;
        View r2 = r0.h;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("targetView");
        r2 = null;
    L5:
        ViewParent r3 = r2.getParent();
        if (r3 == null) goto L8;
        r3.requestDisallowInterceptTouchEvent(true);
    L8:
        int[] r4 = new int[2];
        View r5 = r0.s.get(r0.c);
        if (r5 == null) goto L15;
        Log.i("OptionsPopupMenu", "handleActionDown: selectedView is not null , compute location");
        r5.getLocationOnScreen(r4);
        ((LinkedHashMap) r0.o).clear();
        Iterator<Map.Entry<Object, View>> r6 = r0.s.entrySet().iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        Map.Entry<Object, View> r7 = r6.next();
        Object r8 = r7.getKey();
        View r9 = r7.getValue();
        int[] r10 = new int[2];
        r9.getLocationOnScreen(r10);
        Map<Object, IntRange> r11 = r0.o;
        int r12 = r10[0];
        r11.put(r8, new IntRange(r12, r9.getWidth() + r12));
        goto L13
    L17:
        return;
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
