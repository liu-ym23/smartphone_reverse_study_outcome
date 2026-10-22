package com.ss.android.deviceregister.a;

import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class d extends c<com.c.a.a> {
    d() {
        super("com.mdid.msa");
    }

    private void a(Context r4, String r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intent r6 = new Intent();
        r6.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        r6.setAction("com.bun.msa.action.start.service");
        r6.putExtra("com.bun.msa.param.pkgname", r5);
        r6.putExtra("com.bun.msa.param.runinset", true);     // Catch: Exception -> L5
        ZeusTransformUtils.startService(r3, r6, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.deviceregister.a.c
    public Intent a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intent r4 = new Intent();
        r4.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        r4.setAction("com.bun.msa.action.bindto.service");
        r4.putExtra("com.bun.msa.param.pkgname", r2.getPackageName());
        return r4;
    }

    @Override // com.ss.android.deviceregister.a.c
    public w.b<com.c.a.a, String> a() {
        return new AnonymousClass1(this);
    }

    @Override // com.ss.android.deviceregister.a.c, com.ss.android.deviceregister.a.n
    public n.a c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        a(r4, r4.getPackageName());
        return super.c(r4);
    }
}
