package com.bytedance.forest.pollyfill;

import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends l {
    public final com.bytedance.forest.utils.e g;

    public d(HttpResponseException r10, c r11, com.bytedance.forest.utils.e r12) {
        int r5 = r10.getStatusCode();
        String r13 = r10.getMessage();
        if (r13 == null) goto L5;
    L4:
        String r14 = r13;
        HashMap r15 = new HashMap();
        Integer r16 = Integer.valueOf(r5);
        if (r5 != 0) goto L10;
        r16 = null;
    L10:
        if (r16 == null) goto L13;
        int r17 = r16.intValue();
    L12:
        int r18 = r17;
        super(r18, r14, r15, r11, System.currentTimeMillis());
        this.g = r12;
        return;
    L13:
        r17 = -1;
        goto L12
    L5:
        r13 = "";
        goto L4
    }

    public final InputStream b() {
        com.bytedance.forest.utils.e r5 = this.g;
        String r10 = (String) this.f4528c.get("content-length");
        if (r10 == null) goto L5;
        Integer r11 = StringsKt.toIntOrNull(r10);
    L6:
        if (r11 != null) goto L9;
    L17:
        com.bytedance.forest.utils.d.b(r5.g, 6, "TTNetDepender", "response in empty when providing input stream", true, null, null, 48);     // Catch: Exception -> L14
        return null;
    L14:
        e = move-exception;
        com.bytedance.forest.utils.d.b(r5.g, 6, "TTNetDepender", "error occurs when getting input stream from response", true, e, null, 32);
        return null;
    L9:
        if (r11.intValue() != 0) goto L17;
        return new ByteArrayInputStream(new byte[0]);
    L5:
        r11 = null;
        goto L6
    }
}
