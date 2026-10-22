package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t implements ToolbarComponentCheckInterface {
    public t() {
    }

    public final boolean checkThenLoad(ToolbarMatchInterface r2, Function0<Unit> r3, Function1<? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "loadButton");
        Intrinsics.checkNotNullParameter(r4, "stopLoadCallback");
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L5;
        r3.invoke();
        return true;
    L5:
        r4.invoke("TreasureBoxConfig: User is not logged in");
        return true;
    }
}
