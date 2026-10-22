package com.lark.kmp.rustclient.api.model;

import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.LarkError;
import com.lark.wire.ProtoAdapter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i {
    public static final f a = null;

    static {
        a = new f(null, null, Command.UNKNOWN_COMMAND, null);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.lark.kmp.rustclient.api.model.RustOutputKt$errorAsException$$inlined$map$1] */
    public static final RustOutputKt$errorAsException$$inlined$map$1 a(final Flow r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new RustOutputKt$errorAsException$$inlined$map$1(r1);
    }

    public static final f b(Command r2, com.lark.kmp.server.pb.improto.Command r3, byte[] r4, Exception r5) {
        Intrinsics.checkNotNullParameter(r2, "command");
        LarkError r0 = null;
        if (r4 == null) goto L10;
        r0 = LarkError.ADAPTER.e(r4);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        if (r5 != null) goto L10;
        r5 = e;
    L10:
        return new f(r5, r0, r2, r3);
    }

    public static final <T> Pair<T, f> c(ProtoAdapter<T> r1, byte[] r2, Command r3, com.lark.kmp.server.pb.improto.Command r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "command");
        return TuplesKt.to(r1.e(r2), a);
    L5:
        e = move-exception;
        return TuplesKt.to(null, b(r3, r4, r2, e));
    }
}
