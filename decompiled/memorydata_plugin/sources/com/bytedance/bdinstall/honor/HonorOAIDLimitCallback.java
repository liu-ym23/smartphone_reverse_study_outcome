package com.bytedance.bdinstall.honor;

import android.os.Bundle;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.oaid.impl.IOAIDCallBack;

/* JADX INFO: loaded from: classes.dex */
public class HonorOAIDLimitCallback extends IOAIDCallBack.Stub {
    private volatile boolean isLimit;

    public HonorOAIDLimitCallback() {
        this.isLimit = false;
    }

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public void basicTypes(int r1, long r2, boolean r4, float r5, double r6, String r8) {
    }

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public void handleResult(int r3, Bundle r4) {
        DrLog.d("honor# OAIDLimitCallback handleResult retCode= " + r3 + " retInfo= " + r4);
        if (r3 != 0) goto L7;
        if (r4 == null) goto L8;
        this.isLimit = r4.getBoolean(HonorKeys.KEY_OA_ID_LIMIT_STATE);
        DrLog.d("honor# OAIDLimitCallback handleResult success isLimit? " + this.isLimit);
        return;
    L8:
        return;
    }

    public boolean isLimit() {
        return this.isLimit;
    }
}
