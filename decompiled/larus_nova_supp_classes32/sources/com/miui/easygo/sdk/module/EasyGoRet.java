package com.miui.easygo.sdk.module;

import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class EasyGoRet {
    public int code;
    public Bundle result;

    public EasyGoRet() {
        this.code = 0;
        this.result = new Bundle();
    }

    public EasyGoRet(int r2, Bundle r3) {
        this.code = 0;
        new Bundle();
        this.code = r2;
        this.result = r3;
    }
}
