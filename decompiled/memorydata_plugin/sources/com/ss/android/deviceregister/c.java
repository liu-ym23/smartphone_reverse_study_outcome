package com.ss.android.deviceregister;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15199b;

    c(Context r3, boolean r4) {
        this.f15198a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f15199b = r4;
    }

    static /* synthetic */ boolean a(c r0) {
        return r0.f15199b;
    }

    static /* synthetic */ Context b(c r0) {
        return r0.f15198a;
    }

    void a() {
        Runnable r0 = new AnonymousClass1(this);
        com.bytedance.common.utility.a.a.c().submit(r0);
    }
}
