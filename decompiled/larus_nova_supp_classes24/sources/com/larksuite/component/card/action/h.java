package com.larksuite.component.card.action;

import com.bytedance.lark.pb.openplatform.v1.PutUniversalCardActionByEntityResponse;
import com.bytedance.lark.pb.openplatform.v1.PutUniversalCardActionResponseInner;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h<T> implements SdkSender.IParser {
    public static final h<T> a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final Object parse(byte[] r7) {
        PutUniversalCardActionByEntityResponse r8 = (PutUniversalCardActionByEntityResponse) PutUniversalCardActionByEntityResponse.ADAPTER.decode(r7);     // Catch: Throwable -> L14
        dz7.c.b r1 = new dz7.c.b();     // Catch: Throwable -> L14
        PutUniversalCardActionResponseInner.Toast r0 = r8.inner.toast;     // Catch: Throwable -> L14
        if (r0 == null) goto L5;
        r1.a = r0.code.getValue();     // Catch: Throwable -> L14
        r1.b = r0.error_code;     // Catch: Throwable -> L14
        r1.c = r0.content;     // Catch: Throwable -> L14
    L5:
        dz7.c.a r3 = new dz7.c.a();     // Catch: Throwable -> L14
        PutUniversalCardActionResponseInner r9 = r8.inner;     // Catch: Throwable -> L14
        PutUniversalCardActionResponseInner.URL r2 = r9.url;     // Catch: Throwable -> L14
        if (r2 == null) goto L8;
        r3.b = r2.android_url;     // Catch: Throwable -> L14
        r3.a = r2.url;     // Catch: Throwable -> L14
    L8:
        String r10 = r9.app_cli_id;     // Catch: Throwable -> L14
        if (r10 == null) goto L11;
        String r4 = r10;
    L12:
        return new dz7.c(r1, r4, r3, "requestFinished", 48);
    L11:
        r4 = "";
    L14:
        th = move-exception;
        Log.e("WithEntityCardActionService", "decode PutUniversalCardActionByEntityResponse error", th);
        return null;
    }
}
