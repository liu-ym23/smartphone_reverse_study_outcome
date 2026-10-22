package com.bytedance.ug.cloud;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class i implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f3345b;
    private final String c;

    i(Context r3, String r4) {
        this.f3344a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.c = "[UGCloud " + r4 + "]";
        this.f3345b = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ Context a(i r0) {
        return r0.f3344a;
    }

    private void a(Runnable r3) {
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        r4.run();
        return;
    L5:
        this.f3345b.post(new AnonymousClass2(this, r4));
    }

    static /* synthetic */ String b(i r0) {
        return r0.c;
    }

    @Override // com.bytedance.ug.cloud.m
    public void a(final b r2) {
        if (r2.a() == false) goto L6;
        a(new AnonymousClass1(this, r2));
        return;
    }
}
