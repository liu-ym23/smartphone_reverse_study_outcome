package com.lark.kmp.rustclient.api.model;

import com.bytedance.larksuite.wire.CommandScope;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l extends j {
    public final String a;
    public final Long b;

    public l(String r2, Long r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        CommandScope r0 = CommandScope.GlobalScope;
        this.a = r2;
        this.b = r3;
    }
}
