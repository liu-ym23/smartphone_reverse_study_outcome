package com.bytedance.android.annie.xbridge.mix;

import android.webkit.WebView;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o extends le7.a<Object> {
    public final PlatformType M;
    public final Object N;
    public final String O;

    public final Object b() {
        return this.N;
    }

    public final PlatformType c() {
        return this.M;
    }

    public final String d() {
        return this.O;
    }

    public o(CallContext r1, Map<String, ? extends Object> r10, String r11) {
        super(r11);
        List<String> r12 = s.a;
        if ((r1.d instanceof WebView) == false) goto L5;
        PlatformType r13 = PlatformType.WEB;
    L6:
        this.M = r13;
        this.N = r10;
        String r14 = r1.b;
        if (r14 != null) goto L9;
        r14 = "";
    L9:
        this.O = r14;
        return;
    L5:
        r13 = PlatformType.LYNX;
        goto L6
    }
}
