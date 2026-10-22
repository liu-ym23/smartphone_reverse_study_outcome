package com.lark.kmp.rustclient.api.model;

import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.LarkError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public final Exception a;
    public final LarkError b;
    public final Command c;
    public final com.lark.kmp.server.pb.improto.Command d;

    public final RustClientException a() {
        StringBuilder r0 = new StringBuilder("Error encountered while processing ");
        com.lark.kmp.server.pb.improto.Command r1 = this.d;
        if (r1 == null) goto L6;
        String r2 = "Server Command " + r1.getValue();
        if (r2 == null) goto L6;
    L7:
        r0.append(r2);
        r0.append('.');
        String r3 = r0.toString();
        if (this.b == null) goto L22;
        StringBuilder r4 = new StringBuilder();
        r4.append(r3);
        r4.append("\nRust error: code=");
        r4.append(this.b.getCode());
        r4.append(", status=");
        r4.append(this.b.getStatus());
        r4.append(", dbg=");
        LarkError.ErrorDetails r5 = this.b.getDetails();
        String r6 = "";
        if (r5 == null) goto L13;
        String r7 = r5.getDebug_message();
        if (r7 == null) goto L13;
    L14:
        r4.append(r7);
        r4.append(", display=");
        r4.append(this.b.getDisplay_message());
        r4.append(", reqId=");
        LarkError.ErrorDetails r8 = this.b.getDetails();
        if (r8 == null) goto L20;
        String r9 = r8.getServer_request_id();
        if (r9 == null) goto L20;
        r6 = r9;
    L20:
        r4.append(r6);
        r4.append('.');
        r3 = r4.toString();
    L13:
        r7 = "";
    L22:
        if (this.a == null) goto L24;
        r3 = r3 + "\nAndroid error: " + this.a.getMessage();
    L24:
        Exception r10 = this.a;
        if (r10 == null) goto L28;
        return new RustClientException(r3, r10);
    L28:
        return new RustClientException(r3, this.b);
    L6:
        r2 = "Command " + this.c.getValue();
        goto L7
    }

    public f(Exception r2, LarkError r3, Command r4, com.lark.kmp.server.pb.improto.Command r5) {
        Intrinsics.checkNotNullParameter(r4, "command");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
