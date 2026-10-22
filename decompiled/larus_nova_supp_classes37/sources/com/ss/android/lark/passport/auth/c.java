package com.ss.android.lark.passport.auth;

import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class c implements f {
    @Inject
    public c() {
    }

    @Override // com.ss.android.lark.passport.auth.f
    public final Map<String, String> a(String r2, String r3, Function1<? super Map<String, String>, ? extends Map<String, String>> r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "build");
        return (Map) r4.invoke(MapsKt.emptyMap());
    }
}
