package com.obric.matrix.platform.sdk.ones.init;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\"\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J*\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0004H\u0003J\u000e\u0010\u001c\u001a\u00020\u0011*\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentInitHelper;", "", "()V", "TAG", "", "initExecutor", "Ljava/util/concurrent/ExecutorService;", "getInitExecutor", "()Ljava/util/concurrent/ExecutorService;", "initExecutor$delegate", "Lkotlin/Lazy;", "isInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "packageInfo", "Landroid/content/pm/PackageInfo;", "unlockReceiverRegistered", "deferNetworkUntilUserUnlocked", "", "context", "Landroid/content/Context;", "deviceId", "baseComponentConfig", "Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentConfig;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "initInterval", "initNetwork", AILabCheckPermissionTask.KEY_SOURCE, "isValidDeviceIdOrInstallId", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8100a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f8101b = null;
    private static final AtomicBoolean c = null;
    private static final Lazy d = null;

    static {
        f8100a = new a();
        f8101b = new AtomicBoolean(false);
        c = new AtomicBoolean(false);
        d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(BaseComponentInitHelper$initExecutor$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private a() {
    }
}
