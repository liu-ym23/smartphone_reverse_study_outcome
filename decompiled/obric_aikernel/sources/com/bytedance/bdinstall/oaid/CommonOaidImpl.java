package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.MsaIdInterface;

/* JADX INFO: loaded from: classes.dex */
final class CommonOaidImpl extends BaseOaidImpl<MsaIdInterface> {
    private static final String PACKAGE_NAME = "com.mdid.msa";

    CommonOaidImpl() {
        super(PACKAGE_NAME);
    }

    private void startMsaklServer(Context r10, String r11) {
        Intent r12 = new Intent();
        r12.setClassName(PACKAGE_NAME, "com.mdid.msa.service.MsaKlService");
        r12.setAction("com.bun.msa.action.start.service");
        r12.putExtra("com.bun.msa.param.pkgname", r11);
        r12.putExtra("com.bun.msa.param.runinset", true);     // Catch: Exception -> L5
        r10.startService(r12);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context r10) {
        Intent r11 = new Intent();
        r11.setClassName(PACKAGE_NAME, "com.mdid.msa.service.MsaIdService");
        r11.setAction("com.bun.msa.action.bindto.service");
        r11.putExtra("com.bun.msa.param.pkgname", r10.getPackageName());
        return r11;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<MsaIdInterface, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Common";
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl, com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r10) {
        startMsaklServer(r10, r10.getPackageName());
        return super.getOaid(r10);
    }
}
