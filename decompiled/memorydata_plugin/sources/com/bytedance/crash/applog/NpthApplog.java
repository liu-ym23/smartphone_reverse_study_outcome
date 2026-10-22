package com.bytedance.crash.applog;

import com.bytedance.crash.NpthCustomHeaderApi;

/* JADX INFO: loaded from: classes2.dex */
public class NpthApplog {
    public NpthApplog() {
    }

    public static void init() {
        NpthCustomHeaderApi.addCustomHeaderService(new AnonymousClass1());
        NpthAppLogHeader.init();
    }
}
