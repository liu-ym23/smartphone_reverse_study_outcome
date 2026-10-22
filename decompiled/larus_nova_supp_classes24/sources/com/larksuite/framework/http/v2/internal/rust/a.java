package com.larksuite.framework.http.v2.internal.rust;

import android.util.Base64;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.x;
import com.larksuite.framework.utils.Reflect;
import com.squareup.wire.Message;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements Interceptor {
    public final l a;
    public final boolean b;

    public final Response intercept(Interceptor.Chain r12) {
        Intrinsics.checkNotNullParameter(r12, "chain");
        if (r12.call().isCanceled() == true) goto L23;
        new Reflect(r12).i("calls", 1);
        Request r13 = r12.request();
        Intrinsics.checkNotNull(r13);
        if (this.b == false) goto L7;
        e r0 = i.a;
    L8:
        com.bytedance.lark.rustclient.api.d r10 = new com.bytedance.lark.rustclient.api.d(r0.b(r13), r0.c(), r0.getCommand(), null, null, null, null, 248);
        x r1 = this.a.h(r10).execute();
        if ((r1 instanceof x) == false) goto L17;
        Response r2 = r0.a((Message) r1.c, r13);
        String r3 = new String(Base64.encode(r13.url().redact().getBytes(StandardCharsets.UTF_8), 0), Charsets.UTF_8);
        if (r2.body() != null) goto L13;
        Log.w("lark_http_rust", "response body is null, origin request: ".concat(r3));
    L14:
        Log.d("lark_http_rust", r2.toString());
        return r2;
    L13:
        Log.i("lark_http_rust", "response body is not null, origin request: ".concat(r3));
        goto L14
    L17:
        if ((r1 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L21;
        com.bytedance.lark.rustclient.api.c r4 = (com.bytedance.lark.rustclient.api.c) r1;
        throw new IOException(r4.c.c(), r4.c.b());
    L21:
        throw new NoWhenBranchMatchedException();
    L7:
        r0 = f.a;
        goto L8
    L23:
        throw new IOException("Canceled");
    }

    public a(l r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "rust");
        this.a = r2;
        this.b = r3;
    }
}
