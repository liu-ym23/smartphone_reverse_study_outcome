package com.bytedance.bdinstall.honor;

import android.os.Bundle;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.oaid.impl.IOAIDCallBack;

/* JADX INFO: loaded from: classes.dex */
public class HonorOAIDCallback extends IOAIDCallBack.Stub {
    private volatile String oaid;

    public HonorOAIDCallback() {
        this.oaid = "";
    }

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public void basicTypes(int r1, long r2, boolean r4, float r5, double r6, String r8) {
    }

    public String getOaid() {
        return this.oaid;
    }

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public void handleResult(int r3, Bundle r4) {
        DrLog.d("honor# OAIDCallBack handleResult retCode= " + r3 + " retInfo= " + r4);
        if (r3 != 0) goto L7;
        if (r4 == null) goto L8;
        this.oaid = r4.getString(HonorKeys.KEY_OA_ID_FLAG);
        DrLog.d("honor# OAIDCallBack handleResult success " + this.oaid);
        return;
    L8:
        return;
    }
}
