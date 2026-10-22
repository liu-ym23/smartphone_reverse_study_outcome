package com.obric.aiagent.product.platform.impl;

import android.app.Application;
import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.platform.a.a;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.platform.b;
import com.obric.aiagent.product.feature.FeatureListConfig;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.aiagent.product.platform.api.app.IObricActivityManager;
import com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager;
import com.obric.aiagent.product.platform.api.app.ObricActivityManager;
import com.obric.aiagent.product.platform.api.app.ObricActivityTaskManager;
import com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController;
import com.obric.aiagent.product.platform.api.device.ObricDeviceIdleController;
import com.obric.aiagent.product.platform.api.memory.IObricMemoryManager;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryManager;
import com.obric.aiagent.product.platform.api.notification.IObricNotificationManager;
import com.obric.aiagent.product.platform.api.notification.ObricNotificationManager;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.aiagent.product.platform.api.rom.RomInfo;
import com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager;
import com.obric.aiagent.product.platform.api.sleepmode.ObricSleepModeManager;
import com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback;
import com.obric.aiagent.product.platform.api.vibratefeedback.VibrateFeedback;
import com.obric.aiagent.product.platform.api.view.IObricWindowManager;
import com.obric.aiagent.product.platform.api.view.ObricWindowManager;
import com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects;
import com.obric.aiagent.product.platform.api.windoweffects.WindowEffects;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006&"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/PlatformServiceImpl;", "Lcom/obric/aiagent/product/platform/api/IPlatformService;", "<init>", "()V", "featureListConfig", "Lcom/obric/aiagent/product/feature/FeatureListConfig;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "destroy", "romInfo", "Lcom/obric/aiagent/product/platform/api/rom/IRomInfo;", "activityManager", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityManager;", "activityTaskManager", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityTaskManager;", "windowManager", "Lcom/obric/aiagent/product/platform/api/view/IObricWindowManager;", "inputmethodManager", "Lcom/obric/framework/inputmethod/api/IObricInputmethodManager;", "sleepModeManager", "Lcom/obric/aiagent/product/platform/api/sleepmode/IObricSleepModeManager;", "memoryManager", "Lcom/obric/aiagent/product/platform/api/memory/IObricMemoryManager;", "deviceIdleController", "Lcom/obric/aiagent/product/platform/api/device/IObricDeviceIdleController;", "notificationManager", "Lcom/obric/aiagent/product/platform/api/notification/IObricNotificationManager;", "vibrateFeedback", "Lcom/obric/aiagent/product/platform/api/vibratefeedback/IVibrateFeedback;", "windowEffects", "Lcom/obric/aiagent/product/platform/api/windoweffects/IWindowEffects;", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformServiceImpl implements IPlatformService {
    public static final Companion Companion = null;
    private static final String TAG = "PlatformServiceImpl";
    private static final Lazy<PlatformServiceImpl> instance$delegate = null;
    private final Lazy context$delegate;
    private FeatureListConfig featureListConfig;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/PlatformServiceImpl$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/obric/aiagent/product/platform/impl/PlatformServiceImpl;", "getInstance", "()Lcom/obric/aiagent/product/platform/impl/PlatformServiceImpl;", "instance$delegate", "Lkotlin/Lazy;", "Lcom/obric/aiagent/product/platform/api/IPlatformService;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final PlatformServiceImpl getInstance() {
            return (PlatformServiceImpl) ZeusTransformUtils.preCheckCast(PlatformServiceImpl.access$getInstance$delegate$cp().getValue(), PlatformServiceImpl.class, "com.obric.memorydata.plugin");
        }

        /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
        public final synchronized IPlatformService m174getInstance() {
            monitor-enter(this);
            IPlatformService r0 = (IPlatformService) ZeusTransformUtils.preCheckCast(getInstance(), IPlatformService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy($$Lambda$PlatformServiceImpl$LOuBEbbwJDvqVetJkXxA3FaBnCQ.INSTANCE);
    }

    public PlatformServiceImpl() {
        this.context$delegate = LazyKt.lazy($$Lambda$PlatformServiceImpl$MTh4Nl87156tpVoDIexpoee0vw.INSTANCE);
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    private static final Context context_delegate$lambda$1() {
        Object r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r0 = 0;
    L9:
        if (r0 != 0) goto L13;
        r0 = b.f5959a.a("base");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.content.Context");
    L13:
        return (Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin");
    L5:
        r2 = false;
        goto L6
    }

    private final Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(this.context$delegate.getValue(), Context.class, "com.obric.memorydata.plugin");
    }

    private static final PlatformServiceImpl instance_delegate$lambda$2() {
        return new PlatformServiceImpl();
    }

    public static /* synthetic */ PlatformServiceImpl lambda$LOuBEbbwJDvqVetJkXxA3FaBnCQ() {
        return instance_delegate$lambda$2();
    }

    /* JADX INFO: renamed from: lambda$MTh4Nl87156tpVoDIexp-oee0vw, reason: not valid java name */
    public static /* synthetic */ Context m173lambda$MTh4Nl87156tpVoDIexpoee0vw() {
        return context_delegate$lambda$1();
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricActivityManager activityManager() {
        return (IObricActivityManager) ZeusTransformUtils.preCheckCast(ObricActivityManager.Companion, IObricActivityManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricActivityTaskManager activityTaskManager() {
        return (IObricActivityTaskManager) ZeusTransformUtils.preCheckCast(ObricActivityTaskManager.Companion, IObricActivityTaskManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public void destroy() {
        d.f5954a.b(TAG, "destroy");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricDeviceIdleController deviceIdleController() {
        return (IObricDeviceIdleController) ZeusTransformUtils.preCheckCast(ObricDeviceIdleController.Companion, IObricDeviceIdleController.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public void init() {
        d.f5954a.b(TAG, CommonConsts.APM_INNER_EVENT_COST_INIT);
        RomInfo.INSTANCE.tryInit();
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public com.obric.framework.inputmethod.api.a inputmethodManager() {
        return (com.obric.framework.inputmethod.api.a) ZeusTransformUtils.preCheckCast(com.obric.framework.inputmethod.a.f8041a, com.obric.framework.inputmethod.api.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricMemoryManager memoryManager() {
        return (IObricMemoryManager) ZeusTransformUtils.preCheckCast(ObricMemoryManager.Companion, IObricMemoryManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricNotificationManager notificationManager() {
        return (IObricNotificationManager) ZeusTransformUtils.preCheckCast(ObricNotificationManager.Companion, IObricNotificationManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IRomInfo romInfo() {
        return (IRomInfo) ZeusTransformUtils.preCheckCast(RomInfo.INSTANCE, IRomInfo.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricSleepModeManager sleepModeManager() {
        return (IObricSleepModeManager) ZeusTransformUtils.preCheckCast(ObricSleepModeManager.Companion, IObricSleepModeManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IVibrateFeedback vibrateFeedback() {
        return (IVibrateFeedback) ZeusTransformUtils.preCheckCast(VibrateFeedback.INSTANCE, IVibrateFeedback.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IWindowEffects windowEffects() {
        return (IWindowEffects) ZeusTransformUtils.preCheckCast(WindowEffects.INSTANCE, IWindowEffects.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricWindowManager windowManager() {
        return (IObricWindowManager) ZeusTransformUtils.preCheckCast(ObricWindowManager.Companion, IObricWindowManager.class, "com.obric.memorydata.plugin");
    }
}
