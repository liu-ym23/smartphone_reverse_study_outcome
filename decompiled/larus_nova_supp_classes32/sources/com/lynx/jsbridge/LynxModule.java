package com.lynx.jsbridge;

import android.content.Context;
import com.lynx.react.bridge.JavaOnlyArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class LynxModule {
    protected Context mContext;
    protected Object mExtraData;
    protected Object mParam;

    public interface a {
        boolean a(String r1, String r2, JavaOnlyArray r3);
    }

    public void destroy() {
    }

    public LynxModule(Context r2) {
        this(r2, null);
    }

    public void setExtraData(Object r1) {
        this.mExtraData = r1;
    }

    public LynxModule(Context r1, Object r2) {
        this.mContext = r1;
        this.mParam = r2;
    }
}
