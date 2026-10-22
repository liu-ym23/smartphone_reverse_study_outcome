package com.ss.android.lark.officesdk.integrator.im;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final boolean b() {
        return ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.messenger.url_card");
    }

    public c() {
    }

    public final Map<String, Chatter> a(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "chatterIds");
        ImSdk r0 = ImSdk.a;
        if (ImSdk.c == true) goto L7;
        return MapsKt.emptyMap();
    L7:
        return ImSdkService.d().l0(r2);
    }
}
