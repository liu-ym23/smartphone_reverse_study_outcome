package com.larus.dora.impl;

import com.larus.applog.api.IApplog;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ JSONObject b;

    public /* synthetic */ c(String r1, JSONObject r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        JSONObject r1 = this.b;
        IApplog.a.reportEvent(r0, r1);
    }
}
