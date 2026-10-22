package com.obric.aikernel.runtime.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001c\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0019\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/obric/aikernel/runtime/utils/DozeModeReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "TAG", "", "dozeState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getDozeState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "isDozeActive", "()Z", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "context", "Landroid/content/Context;", "onReceive", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "waitForState", "expected", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForStateChange", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ae<Boolean> f6215b = null;

    static {
        f6214a = new b();
        f6215b = at.a(false);
    }

    private b() {
    }

    public final Object a(Continuation<? super Boolean> r3) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.flow.k.e(kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(f6215b, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), 1), r2);
    }

    public final void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        IntentFilter r0 = new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        ZeusTransformUtils.registerReceiver(r5, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r0, "com.obric.memorydata.plugin");
        Object r3 = r5.getSystemService("power");
        if (ZeusTransformUtils.instanceOf(r3, PowerManager.class) == false) goto L5;
        PowerManager r6 = (PowerManager) ZeusTransformUtils.preCheckCast(r3, PowerManager.class, "com.obric.memorydata.plugin");
    L6:
        ae<Boolean> r7 = f6215b;
        if (r6 == null) goto L9;
        boolean r8 = r6.isDeviceIdleMode();
    L10:
        r7.a(Boolean.valueOf(r8));
        return;
    L9:
        r8 = false;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    public final boolean a() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(f6215b.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public void onReceive(Context r3, Intent r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        PowerManager r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.getAction();
    L7:
        if (Intrinsics.areEqual("android.os.action.DEVICE_IDLE_MODE_CHANGED", r6) == false) goto L19;
        if (r2 == null) goto L10;
        Object r7 = r2.getSystemService("power");
    L12:
        if (ZeusTransformUtils.instanceOf(r7, PowerManager.class) == false) goto L14;
        r5 = (PowerManager) ZeusTransformUtils.preCheckCast(r7, PowerManager.class, "com.obric.memorydata.plugin");
    L14:
        if (r5 == null) goto L16;
        boolean r8 = r5.isDeviceIdleMode();
    L17:
        f6215b.a(Boolean.valueOf(r8));
        return;
    L16:
        r8 = false;
        goto L17
    L10:
        r7 = null;
        goto L12
    L19:
        return;
    L5:
        r6 = null;
        goto L7
    }
}
