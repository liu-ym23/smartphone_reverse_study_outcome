package com.larus.uaigc.service;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v implements ky9.a {
    public static final v a = null;

    static {
        a = new v();
    }

    public v() {
    }

    @Override // ky9.a
    public final void a(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    @Override // ky9.a
    public final void c(String r1, boolean r2, Message r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    @Override // ky9.a
    public final void d(String r1, Message r2, Message r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "cid");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // ky9.a
    public final void e(Message r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "msg");
    }

    @Override // ky9.a
    public final boolean b(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return false;
    }
}
