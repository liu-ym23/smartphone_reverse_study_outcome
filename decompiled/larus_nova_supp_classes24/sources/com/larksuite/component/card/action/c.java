package com.larksuite.component.card.action;

import com.bytedance.lark.pb.openplatform.v1.PutUniversalCardActionResponse;
import com.bytedance.lark.pb.openplatform.v1.PutUniversalCardActionResponseInner;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c<T> implements SdkSender.IParser {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object parse(byte[] r13) {
        if (r13 == null) goto L15;
        PutUniversalCardActionResponse r14 = (PutUniversalCardActionResponse) PutUniversalCardActionResponse.ADAPTER.decode(r13);
        dz7.c.b r1 = new dz7.c.b();
        PutUniversalCardActionResponseInner.Toast r0 = r14.inner.toast;
        if (r0 == null) goto L6;
        r1.a = r0.code.getValue();
        r1.b = r0.error_code;
        r1.c = r0.content;
    L6:
        dz7.c.a r3 = new dz7.c.a();
        PutUniversalCardActionResponseInner r15 = r14.inner;
        PutUniversalCardActionResponseInner.URL r2 = r15.url;
        if (r2 == null) goto L9;
        r3.b = r2.android_url;
        r3.a = r2.url;
    L9:
        String r16 = r15.app_cli_id;
        if (r16 != null) goto L16;
        r16 = "";
    L16:
        return new dz7.c(r1, r16, r3, "requestFinished", 48);
    L15:
        return new dz7.c(null, "", null, null, 56);
    }
}
