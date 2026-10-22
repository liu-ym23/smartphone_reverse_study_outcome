package com.bytedance.android.live.broadcastgame.opengame.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PluginContext$getPlugin$1 extends MutablePropertyReference0Impl {
    public PluginContext$getPlugin$1(PluginContext r7) {
        super(r7, PluginContext.class, "plugin", "getPlugin()Lcom/bytedance/android/live/broadcastgame/opengame/runtime/ILivePlugin;", 0);
    }

    public Object get() {
        k r0 = ((PluginContext) ((CallableReference) this).receiver).a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
    L5:
        return r0;
    }

    public void set(Object r2) {
        k r3 = (k) r2;
        ((PluginContext) ((CallableReference) this).receiver).a = r3;
    }
}
