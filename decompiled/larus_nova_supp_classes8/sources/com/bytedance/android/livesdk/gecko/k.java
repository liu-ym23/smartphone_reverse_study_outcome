package com.bytedance.android.livesdk.gecko;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.geckox.OptionCheckUpdateParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements OptionCheckUpdateParams.CustomValue {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final Object getValue() {
        return jc1.k.n(IMiddleWareHostContext.class).getVersionName();
    }
}
