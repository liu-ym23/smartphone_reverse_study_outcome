package com.bytedance.android.live.broadcastgame.channel;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.InteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.JsFuncInjector;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements JsFuncInjector {
    public final IJsBridgeManager a;

    public static final class a {
    }

    static {
    }

    public d(IJsBridgeManager r2, DataCenter r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "jsbridge");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.a = r2;
        InteractGameService.Companion.getClass();
        InteractGameService.access$getDiComponent$cp().getClass();
    }
}
