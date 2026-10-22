package com.bytedance.android.bst.api;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a {
    private final String biz;
    private final transient HashMap<String, Object> extraInfo;
    private final String key;

    public abstract boolean checkValid(vc.a r1);

    public abstract a copy();

    public abstract String getTag();

    public final a deepCopy$api_cnRelease() {
        a r0 = copy();
        r0.extraInfo.putAll(this.extraInfo);
        return r0;
    }

    public final String getBiz() {
        return this.biz;
    }

    public final HashMap<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public final String getKey() {
        return this.key;
    }

    public a(String r1, String r10) {
        this.biz = r1;
        this.key = r10;
        this.extraInfo = new HashMap();
    }
}
