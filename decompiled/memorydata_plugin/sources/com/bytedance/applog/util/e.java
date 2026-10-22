package com.bytedance.applog.util;

import android.content.Context;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.applog.compress.CompressManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.applog.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.k.b f1881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CompressManager f1882b;

    public e(com.bytedance.applog.b r4, com.bytedance.applog.k.b r5) {
        this.f1881a = r5;
        this.f1882b = new CompressManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4.aA());
    }

    @Override // com.bytedance.applog.k
    public com.bytedance.applog.d a(byte[] r7) {
        com.bytedance.applog.d r0 = new com.bytedance.applog.d();
        com.bytedance.applog.compress.a r1 = new com.bytedance.applog.compress.a();
        r0.a(this.f1882b.compress(r7, this.f1881a.k(), r1));
        r0.a(r1.c);
        HashMap r6 = new HashMap(4);
        if (r1.c != 0) goto L7;
        String r8 = NetConst.GZIP;
        r6.put("log-encode-type", NetConst.GZIP);
        String r2 = NetConst.KEY_CONTENT_ENCODING;
    L5:
        r6.put(r2, r8);
        r6.put(NetConst.KEY_CONTENT_TYPE, "application/octet-stream;tt-data=b");
    L15:
        r0.a(r6);
        return r0;
    L7:
        if (r1.c != 1) goto L9;
    L14:
        r6.put("log-encode-type", NetConst.TYPE_ZSTD);
        r8 = String.valueOf(0);
        r2 = "log-encode-token";
        goto L5
    L9:
        if (r1.c == 2) goto L14;
        if (r1.c != (-1)) goto L15;
        r6.put(NetConst.KEY_CONTENT_TYPE, "application/json;charset=utf-8");
        goto L15
    }
}
