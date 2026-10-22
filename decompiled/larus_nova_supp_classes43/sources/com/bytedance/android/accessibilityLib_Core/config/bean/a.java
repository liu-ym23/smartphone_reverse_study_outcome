package com.bytedance.android.accessibilityLib_Core.config.bean;

import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final IBaseConfig a;

    public final String toString() {
        IBaseConfig r0 = this.a;
        if (r0 == null) goto L9;
        ViewVirtualNode r1 = r0.getVirtualNode();
        if (r1 == null) goto L9;
        String r10 = r1.toString();
        if (r10 == null) goto L9;
        return r10;
    L9:
        return "null config";
    }

    public a(IBaseConfig r1) {
        this.a = r1;
    }
}
