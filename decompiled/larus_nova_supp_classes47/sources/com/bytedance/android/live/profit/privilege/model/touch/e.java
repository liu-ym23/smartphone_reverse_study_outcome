package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final /* synthetic */ KProperty[] a = null;
    public static final vh7.i b = null;

    static {
        KMutableProperty1 r0 = Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "expire", "getExpire(Lcom/bytedance/android/live/profit/privilege/model/touch/FreqCtrlParams;)Ljava/lang/Long;", 1));
        a = new KProperty[]{r0};
        int r1 = vh7.a.a;
        b = new vh7.i(new vh7.a.b(r0.getName()));
    }

    public static final Long a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$expire");
        vh7.i r0 = b;
        KProperty r1 = a[0];
        Object r2 = null;
        if ((r3 instanceof FlexModelBase) == true) goto L5;
        r3 = null;
    L5:
        FlexModelBase r4 = (FlexModelBase) r3;
        if (r4 == null) goto L9;
        r2 = r4.get(r0.a);
    L9:
        return (Long) r2;
    }

    public static final void b(d r3, Long r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$expire");
        vh7.i r0 = b;
        KProperty r1 = a[0];
        if ((r3 instanceof FlexModelBase) == true) goto L5;
        r3 = null;
    L5:
        FlexModelBase r5 = (FlexModelBase) r3;
        if (r5 == null) goto L9;
        r5.set(r0.a, r4);
        return;
    }
}
