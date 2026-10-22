package com.ss.android.common.applog;

import android.content.Context;
import com.bytedance.applog.compress.CompressManager;
import com.bytedance.applog.m;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class i implements m {
    public final CompressManager a;

    public class a implements pw3.c {
        public a() {
        }
    }

    public i(Context r4) {
        this.a = new CompressManager(r4, null, new a(), null);
    }

    public final com.bytedance.applog.e a(byte[] r7) {
        com.bytedance.applog.e r0 = new com.bytedance.applog.e();
        pw3.a r1 = new pw3.a();
        r0.a = this.a.compress(r7, AppLog.g0.H(), r1);     // Catch: Throwable -> L5
    L7:
        r0.b = r1.c;
        HashMap r8 = new HashMap(4);
        int r2 = r1.c;
        if (r2 != 0) goto L11;
        r8.put("log-encode-type", "gzip");
        r8.put("Content-Encoding", "gzip");
        r8.put("Content-Type", "application/octet-stream;tt-data=b");
    L19:
        r0.c = r8;
        return r0;
    L11:
        if (r2 != 1) goto L13;
    L18:
        r8.put("log-encode-type", "zstd");
        r8.put("log-encode-token", String.valueOf(0));
        r8.put("Content-Type", "application/octet-stream;tt-data=b");
        goto L19
    L13:
        if (r2 == 2) goto L18;
        if (r2 != (-1)) goto L19;
        r8.put("Content-Type", "application/json;charset=utf-8");
    L5:
        th = move-exception;
        ita.j.c("Compress do compress failed", th);
        goto L7
    }
}
