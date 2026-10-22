package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements ToolbarComponentCheckInterface {
    public a() {
    }

    public final boolean checkThenLoad(ToolbarMatchInterface r2, Function0<Unit> r3, Function1<? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "loadButton");
        Intrinsics.checkNotNullParameter(r4, "stopLoadCallback");
        if (jc0.a.a() == false) goto L5;
        r4.invoke("stop By rtChorus");
        return true;
    L5:
        r3.invoke();
        return true;
    }
}
