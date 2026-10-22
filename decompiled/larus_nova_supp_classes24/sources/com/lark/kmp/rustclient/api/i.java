package com.lark.kmp.rustclient.api;

import com.lark.kmp.pb.basic.v1.Command;
import com.lark.wire.ProtoAdapter;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i {
    public static com.lark.kmp.rustclient.api.model.g a(final rpc.c r2, ProtoAdapter r3, com.lark.kmp.rustclient.api.model.j r4, Command r5) {
        Function0<byte[]> r0 = new RustPushKt$toRustPush$1(r2);
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r4, "scopePayload");
        Intrinsics.checkNotNullParameter(r5, "command");
        Intrinsics.checkNotNullParameter(r0, "binarySource");
        Pair r6 = com.lark.kmp.rustclient.api.model.i.c(r3, (byte[]) r0.invoke(), r5, null);
        Object r7 = r6.component1();
        com.lark.kmp.rustclient.api.model.f r8 = (com.lark.kmp.rustclient.api.model.f) r6.component2();
        if (r7 == null) goto L6;
        return new com.lark.kmp.rustclient.api.model.k(r7, r2, r4);
    L6:
        return new com.lark.kmp.rustclient.api.model.b(r8, r2, r4);
    }
}
