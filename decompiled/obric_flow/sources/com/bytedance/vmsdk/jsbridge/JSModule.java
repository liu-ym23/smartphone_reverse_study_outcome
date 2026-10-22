package com.bytedance.vmsdk.jsbridge;

import android.content.Context;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public abstract class JSModule {
    protected Context mContext;
    protected Object mParam;

    @Keep
    public JSModule(Context r5) {
        this(r5, null);
    }

    @Keep
    public JSModule(Context r5, Object r10) {
        this.mContext = r5;
        this.mParam = r10;
    }
}
