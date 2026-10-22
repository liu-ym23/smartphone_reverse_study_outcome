package com.ss.android.lark.compose.chatsetting.common.repository;

import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.passportc.entity.UserSession;
import gy7.q;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final d a(UserSession r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r3 = iy7.a.b(new q(r2.b, r2.a)).a(Reflection.getOrCreateKotlinClass(d.class));
        if (r3 == null) goto L7;
        return (d) r3;
    L7:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(d.class).getSimpleName() + " found");
    }
}
