package com.ss.android.deviceregister.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
abstract class c<SERVICE> implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ss.android.deviceregister.d.f<Boolean> f15130b;

    c(String r2) {
        this.f15130b = new AnonymousClass1(this);
        this.f15129a = r2;
    }

    private n.a a(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return null;
    L6:
        n.a r0 = new n.a();
        r0.f15141a = r1;
        return r0;
    }

    static /* synthetic */ String a(c r0) {
        return r0.f15129a;
    }

    public abstract Intent a(Context r1);

    public abstract w.b<SERVICE, String> a();

    @Override // com.ss.android.deviceregister.a.n
    public boolean b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        return false;
    L6:
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f15130b.c(new Object[]{r5}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // com.ss.android.deviceregister.a.n
    public n.a c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        return a((String) ZeusTransformUtils.preCheckCast(new w(r6, a(r6), a()).a(), String.class, "com.obric.memorydata.plugin"));
    }
}
