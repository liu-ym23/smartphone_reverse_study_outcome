package com.bytedance.sdk.xbridge.cn.utils;

import android.os.Handler;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f7504a = null;

    static {
        f7504a = LazyKt.lazy(UGLogger$logHandler$2.f7498a);
    }

    public static void a(final String r5, final String r10, final Map r11, final c r12) {
        Intrinsics.checkNotNullParameter("BulletSdk", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        ki.a r13 = ki.a.f18646a;
        if (ki.a.f18648c == false) goto L5;
        return;
    L5:
        Function0<Unit> r14 = new UGLogger$i$1(r10, r5, r11, r12);
        ((Handler) f7504a.getValue()).post(new com.bytedance.android.monitorV2.executor.a(r14));
    }
}
