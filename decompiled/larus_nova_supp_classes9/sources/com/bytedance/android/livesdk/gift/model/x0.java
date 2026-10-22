package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x0 {
    public static final /* synthetic */ KProperty[] a = null;
    public static final vh7.i b = null;

    static {
        KMutableProperty1 r0 = Reflection.mutableProperty1(new MutablePropertyReference1Impl(x0.class, "nowTimeDiff", "getNowTimeDiff(Lcom/bytedance/android/livesdk/gift/model/GroupShowInfo;)Ljava/lang/Long;", 1));
        a = new KProperty[]{r0};
        int r1 = vh7.a.a;
        b = new vh7.i(new vh7.a.b(r0.getName()));
    }

    public static final void a(w0 r3, Long r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$nowTimeDiff");
        vh7.i r0 = b;
        KProperty r1 = a[0];
        w0 r5 = r3;
        if ((r5 instanceof FlexModelBase) == true) goto L5;
        r5 = null;
    L5:
        FlexModelBase r6 = (FlexModelBase) r5;
        if (r6 == null) goto L9;
        r6.set(r0.a, r4);
        return;
    }
}
