package com.larus.dora.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraServiceImpl$tryInitBotConversationWhenDeviceIdReady$1 implements com.larus.platform.api.y {
    public final /* synthetic */ DoraServiceImpl a;

    public final boolean a() {
        return false;
    }

    public DoraServiceImpl$tryInitBotConversationWhenDeviceIdReady$1(DoraServiceImpl r1) {
        this.a = r1;
    }

    public final void onGetId(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "did");
        Intrinsics.checkNotNullParameter(r8, "iid");
        Intrinsics.checkNotNullParameter(r9, "ssid");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new DoraServiceImpl$tryInitBotConversationWhenDeviceIdReady$1$onGetId$1(this.a, null), 3, null);
    }
}
