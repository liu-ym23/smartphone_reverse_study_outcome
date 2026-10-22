package com.bytedance.applog.priority;

import n4.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NativeLazyString {
    private final c<JSONObject> loader;

    public NativeLazyString(c<JSONObject> r8) {
        this.loader = r8;
    }

    public String getValue() {
        return this.loader.a().toString();
    }
}
