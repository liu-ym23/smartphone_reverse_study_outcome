package com.bytedance.android.accessibilityLib_Core.base.largertoucharea;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class TouchDelegateComposite extends TouchDelegate {
    public final ConcurrentHashMap<WeakReference<View>, TouchDelegate> a;

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(final MotionEvent r10) {
        return a(r10, new AnonymousClass1(r10));
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchExplorationHoverEvent(final MotionEvent r10) {
        return a(r10, new C02241(r10));
    }

    public TouchDelegateComposite(View r1, Rect r10) {
        super(r10, r1);
        this.a = new ConcurrentHashMap();
    }

    public final boolean a(MotionEvent r10, Function1<? super TouchDelegate, Boolean> r11) {
        float r0 = r10.getX();
        float r1 = r10.getY();
        Iterator<Map.Entry<WeakReference<View>, TouchDelegate>> r12 = this.a.entrySet().iterator();
        boolean r13 = false;
    L4:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<WeakReference<View>, TouchDelegate> r14 = r12.next();
        r10.setLocation(r0, r1);
        View r15 = r14.getKey().get();
        if (r15 == null) goto L16;
        if (r15.getVisibility() != 0) goto L16;
        if (((Boolean) r11.invoke(r14.getValue())).booleanValue() == true) goto L14;
        if (r13 == true) goto L14;
        r13 = false;
    L14:
        r13 = true;
    L16:
        if (("callEvent result = " + r13 + ",x = " + r0 + ",y = " + r1) == null) goto L4;
        Context r16 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        goto L4
    L18:
        return r13;
    }
}
