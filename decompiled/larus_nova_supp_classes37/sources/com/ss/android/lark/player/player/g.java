package com.ss.android.lark.player.player;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements com.ss.android.lark.passport.auth.i {
    public final /* synthetic */ p a;

    public g() {
        this.a = d.a;
    }

    @Override // com.ss.android.lark.passport.auth.i
    public final Map<String, String> a(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "authHeaders");
        return this.a.a(r2);
    }
}
