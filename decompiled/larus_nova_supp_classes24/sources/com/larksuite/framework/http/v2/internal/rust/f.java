package com.larksuite.framework.http.v2.internal.rust;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements e<SendHttpRequest.Builder, SendHttpResponse> {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.e
    public final ProtoAdapter<SendHttpResponse> c() {
        return SendHttpResponse.ADAPTER;
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.e
    public final Command getCommand() {
        return Command.SEND_HTTP;
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.e
    public final Message.Builder b(Request r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        return b.b(r2);
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.e
    public final Response a(Message r2, Request r3) {
        SendHttpResponse r4 = (SendHttpResponse) r2;
        Intrinsics.checkNotNullParameter(r4, "rustResp");
        Intrinsics.checkNotNullParameter(r3, "request");
        return c.a(r4, r3).build();
    }
}
