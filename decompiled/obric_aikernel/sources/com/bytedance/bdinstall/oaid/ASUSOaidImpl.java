package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.IDidAidlInterface;

/* JADX INFO: loaded from: classes.dex */
final class ASUSOaidImpl extends BaseOaidImpl<IDidAidlInterface> {
    ASUSOaidImpl() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context r10) {
        Intent r11 = new Intent();
        r11.setAction("com.asus.msa.action.ACCESS_DID");
        r11.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return r11;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDidAidlInterface, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "ASUS";
    }
}
