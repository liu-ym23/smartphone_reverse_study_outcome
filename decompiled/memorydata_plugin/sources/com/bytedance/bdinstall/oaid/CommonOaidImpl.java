package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.MsaIdInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class CommonOaidImpl extends BaseOaidImpl<MsaIdInterface> {
    private static final String PACKAGE_NAME = "com.mdid.msa";

    CommonOaidImpl() {
        super(PACKAGE_NAME);
    }

    private void startMsaklServer(Context r4, String r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intent r6 = new Intent();
        r6.setClassName(PACKAGE_NAME, "com.mdid.msa.service.MsaKlService");
        r6.setAction("com.bun.msa.action.start.service");
        r6.putExtra("com.bun.msa.param.pkgname", r5);
        r6.putExtra("com.bun.msa.param.runinset", true);     // Catch: Exception -> L5
        ZeusTransformUtils.startService(r3, r6, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    public Intent buildIntent(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intent r4 = new Intent();
        r4.setClassName(PACKAGE_NAME, "com.mdid.msa.service.MsaIdService");
        r4.setAction("com.bun.msa.action.bindto.service");
        r4.putExtra("com.bun.msa.param.pkgname", r2.getPackageName());
        return r4;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    public ServiceBlockBinder.ServiceBindedListener<MsaIdInterface, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Common";
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl, com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        startMsaklServer(r4, r4.getPackageName());
        return super.getOaid(r4);
    }
}
