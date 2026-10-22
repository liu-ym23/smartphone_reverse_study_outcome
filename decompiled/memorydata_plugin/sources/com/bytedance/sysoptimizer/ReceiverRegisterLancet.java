package com.bytedance.sysoptimizer;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ReceiverRegisterLancet {
    public ReceiverRegisterLancet() {
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public Intent registerReceiver(PluginBroadcastReceiver r3, IntentFilter r4) {
        return (Intent) ZeusTransformUtils.preCheckCast(Origin.call(), Intent.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r3, r4);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public Intent registerReceiver(PluginBroadcastReceiver r3, IntentFilter r4, int r5) {
        return (Intent) ZeusTransformUtils.preCheckCast(Origin.call(), Intent.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r3, r4, r5);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public Intent registerReceiver(PluginBroadcastReceiver r3, IntentFilter r4, String r5, Handler r6) {
        return (Intent) ZeusTransformUtils.preCheckCast(Origin.call(), Intent.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r3, r4, r5, r6);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public Intent registerReceiver(PluginBroadcastReceiver r3, IntentFilter r4, String r5, Handler r6, int r7) {
        return (Intent) ZeusTransformUtils.preCheckCast(Origin.call(), Intent.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r3, r4, r5, r6, r7);
    }
}
