package com.ss.android.lark.player.player;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements com.ss.android.lark.passport.auth.j {
    public final /* synthetic */ q a;

    public f(e r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.passport.auth.j
    public final void a(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "headers");
        this.a.a(r2);
    }
}
