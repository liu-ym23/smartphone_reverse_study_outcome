package com.ss.android.lark.message.lynxcard.action;

import com.bytedance.lark.pb.im.v2.PutActionResponse;
import com.ss.android.lark.sdk.SdkSender;
import dz7.c;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a<T> implements SdkSender.IParser {
    public static final a<T> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object parse(byte[] r14) {
        if (r14 == null) goto L12;
        PutActionResponse r15 = (PutActionResponse) PutActionResponse.ADAPTER.decode(r14);
        c.b r2 = new c.b();
        PutActionResponse.Toast r0 = r15.toast;
        if (r0 == null) goto L6;
        r2.a = r0.code.intValue();
        r2.b = r0.error_code;
        r2.c = r0.content;
    L6:
        String r1 = r15.app_cli_id;
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        String r3 = r1;
        return new mrb.b(r15.method.getValue(), r2, r3, r15.timestamp_detail, r15.time_cost);
    L12:
        return new mrb.b(0, null, "", new HashMap(), new HashMap());
    }
}
