package com.lynx.jsbridge;

import android.content.Context;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public abstract class LynxModule {
    protected Context mContext;
    protected Object mExtraData;
    protected Object mParam;

    @Keep
    public LynxModule(Context r5) {
        this(r5, null);
    }

    @Keep
    public void destroy() {
    }

    public void setExtraData(Object r5) {
        this.mExtraData = r5;
    }

    @Keep
    public LynxModule(Context r5, Object r10) {
        this.mContext = r5;
        this.mParam = r10;
    }
}
