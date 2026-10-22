package com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy;

import android.util.Base64;
import com.bytedance.lark.rustclient.api.c;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.sdk.InvokeResponse;
import com.ss.android.lark.pb.improto.Command;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final l a;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.a$a, reason: collision with other inner class name */
    public static final class C0018a {
    }

    static {
    }

    public a(l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    public final Object a(WebProxyRequest r17) {
        String r0 = r17.getProxyRequestId();
        if (r0 != null) goto L5;
        r0 = "unknown";
    L5:
        String r1 = r0;
        Command r2 = Command.fromValue(r17.getCommand());
        if (r2 != null) goto L21;
        lvb.a.b("RecordUX_D_WebNetworkProxy", "[" + r1 + "] Invalid command: " + r17.getCommand());
        Result.Companion r3 = Result.Companion;
        WebProxyResponse.a r4 = WebProxyResponse.Companion;
        WebProxyClientError.a r5 = WebProxyClientError.Companion;
        WebProxyErrorCode r6 = WebProxyErrorCode.INVALID_COMMAND;
        r5.getClass();
        WebProxyClientError r7 = WebProxyClientError.a.a(r6);
        r4.getClass();
        return Result.constructor-impl(WebProxyResponse.a.a(r1, r7));
    L21:
        byte[] r8 = r17.decodeRequest();     // Catch: Exception -> L16
        int r9 = b.a;
        Intrinsics.checkNotNullParameter(r2, "command");
        Intrinsics.checkNotNullParameter(r8, "requestBytes");
        lvb.a.e("RecordUX_D_WebNetworkProxy", "[" + r1 + "] Execute request, command=" + r2);
        s r10 = this.a.h(new d(new RawBytesMessageBuilder(r8), RawBytesProtoAdapter.INSTANCE, com.bytedance.lark.pb.basic.v1.Command.POST_GATEWAY, null, null, r2, null, 184)).execute();     // Catch: Exception -> L13
        Result.Companion r11 = Result.Companion;     // Catch: Exception -> L13
        return Result.constructor-impl(b(r1, r2, r10));
    L13:
        e = move-exception;
        lvb.a.b("RecordUX_D_WebNetworkProxy", "[" + r1 + "] Request failed: " + e.getMessage());
        Result.Companion r12 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(e));
    L16:
        e = move-exception;
        lvb.a.b("RecordUX_D_WebNetworkProxy", "[" + r1 + "] Failed to decode request base64: " + e.getMessage());
        Result.Companion r13 = Result.Companion;
        WebProxyResponse.a r14 = WebProxyResponse.Companion;
        WebProxyClientError.a r15 = WebProxyClientError.Companion;
        WebProxyErrorCode r16 = WebProxyErrorCode.DECODE_REQUEST_FAILED;
        r15.getClass();
        WebProxyClientError r18 = WebProxyClientError.a.a(r16);
        r14.getClass();
        return Result.constructor-impl(WebProxyResponse.a.a(r1, r18));
    }

    public static WebProxyResponse b(String r15, Command r16, s r17) {
        InvokeResponse r3 = (InvokeResponse) r17.a;
        if (r3.a != 0) goto L6;
        int r4 = b.a;
        byte[] r5 = r3.c;
        Intrinsics.checkNotNullParameter(r16, "command");
        Intrinsics.checkNotNullParameter(r5, "responseBytes");
        lvb.a.e("RecordUX_D_WebNetworkProxy", "[" + r15 + "] Request succeeded");
        WebProxyResponse.a r0 = WebProxyResponse.Companion;
        byte[] r2 = ((InvokeResponse) r17.a).c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r15, "proxyRequestId");
        Intrinsics.checkNotNullParameter(r2, "data");
        return new WebProxyResponse(r15, true, Base64.encodeToString(r2, 2), null, null, 24, null);
    L6:
        String r6 = null;
        if ((r17 instanceof c) == false) goto L9;
        c r7 = (c) r17;
    L10:
        if (r7 == null) goto L12;
        p r8 = r7.c;
    L13:
        StringBuilder r9 = new StringBuilder("[");
        r9.append(r15);
        r9.append("] Request failed: ");
        r9.append(((InvokeResponse) r17.a).a);
        r9.append(", RustClientError=");
        if (r8 == null) goto L16;
        r6 = r8.c();
    L16:
        r9.append(r6);
        lvb.a.b("RecordUX_D_WebNetworkProxy", r9.toString());
        int r10 = b.a;
        byte[] r11 = ((InvokeResponse) r17.a).c;
        Intrinsics.checkNotNullParameter(r16, "command");
        Intrinsics.checkNotNullParameter(r11, "responseBytes");
        WebProxyResponse.a r1 = WebProxyResponse.Companion;
        byte[] r12 = ((InvokeResponse) r17.a).c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r15, "proxyRequestId");
        Intrinsics.checkNotNullParameter(r12, "rawData");
        return new WebProxyResponse(r15, false, null, null, Base64.encodeToString(r12, 2), 12, null);
    L12:
        r8 = null;
        goto L13
    L9:
        r7 = null;
        goto L10
    }
}
