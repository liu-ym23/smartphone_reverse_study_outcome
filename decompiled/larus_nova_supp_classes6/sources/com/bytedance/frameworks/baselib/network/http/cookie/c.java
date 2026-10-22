package com.bytedance.frameworks.baselib.network.http.cookie;

import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import ix5.b;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c implements SSCookieHandler.a {
    public final /* synthetic */ b.b a;

    public final ArrayList<String> getCookieFlushPathList() {
        return this.a.getCookieFlushPathList();
    }

    public c(b.b r1) {
        this.a = r1;
    }

    public final void onEvent(String r3, JSONObject r4) {
        if (b.f == false) goto L6;
        this.a.OnReportEvent("TTNET-COOKIE", r3, r4);
        return;
    }
}
