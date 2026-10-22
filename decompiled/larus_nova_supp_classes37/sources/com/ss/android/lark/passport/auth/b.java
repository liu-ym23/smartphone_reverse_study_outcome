package com.ss.android.lark.passport.auth;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class b implements e {
    @Inject
    public b() {
    }

    @Override // com.ss.android.lark.passport.auth.e
    public final a a(String r2, com.ss.android.lark.player.player.g r3, com.ss.android.lark.player.player.f r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "build");
        Intrinsics.checkNotNullParameter(r4, "onHeadersChanged");
        return new a(r3, r4);
    }
}
