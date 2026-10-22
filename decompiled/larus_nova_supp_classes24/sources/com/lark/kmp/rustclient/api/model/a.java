package com.lark.kmp.rustclient.api.model;

import com.lark.kmp.pb.basic.v1.Command;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a {
    public final Command a;
    public final String b;
    public final StreamDataSource c;
    public final com.lark.kmp.server.pb.improto.Command d;

    public final Command a() {
        if (this.d != null) goto L6;
        return this.a;
    L6:
        return Command.POST_GATEWAY;
    }

    public a(Command r1, String r2, StreamDataSource r3, com.lark.kmp.server.pb.improto.Command r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
