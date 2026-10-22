package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.IDidAidlInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class ASUSOaidImpl extends BaseOaidImpl<IDidAidlInterface> {
    ASUSOaidImpl() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    public Intent buildIntent(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intent r4 = new Intent();
        r4.setAction("com.asus.msa.action.ACCESS_DID");
        r4.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return r4;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    public ServiceBlockBinder.ServiceBindedListener<IDidAidlInterface, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "ASUS";
    }
}
