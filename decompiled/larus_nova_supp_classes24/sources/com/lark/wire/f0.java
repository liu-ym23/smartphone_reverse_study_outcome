package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f0 {
    public static final void a(ProtoAdapter r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "delegate");
        Intrinsics.checkNotNullParameter(r9, "typeUrl");
        new d0(r9, r8, FieldEncoding.LENGTH_DELIMITED, r8.getType(), Syntax.PROTO_3, r8.e);
    }
}
