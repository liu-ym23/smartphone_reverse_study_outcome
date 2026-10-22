package com.obric.aiagent.product.platform.api;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.app.IObricActivityManager;
import com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager;
import com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController;
import com.obric.aiagent.product.platform.api.memory.IObricMemoryManager;
import com.obric.aiagent.product.platform.api.notification.IObricNotificationManager;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager;
import com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback;
import com.obric.aiagent.product.platform.api.view.IObricWindowManager;
import com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects;
import com.obric.aiagent.product.platform.impl.PlatformServiceImpl;
import com.obric.framework.inputmethod.api.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u001aH&¨\u0006\u001c"}, d2 = {"Lcom/obric/aiagent/product/platform/api/IPlatformService;", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "destroy", "romInfo", "Lcom/obric/aiagent/product/platform/api/rom/IRomInfo;", "activityManager", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityManager;", "activityTaskManager", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityTaskManager;", "windowManager", "Lcom/obric/aiagent/product/platform/api/view/IObricWindowManager;", "inputmethodManager", "Lcom/obric/framework/inputmethod/api/IObricInputmethodManager;", "sleepModeManager", "Lcom/obric/aiagent/product/platform/api/sleepmode/IObricSleepModeManager;", "memoryManager", "Lcom/obric/aiagent/product/platform/api/memory/IObricMemoryManager;", "deviceIdleController", "Lcom/obric/aiagent/product/platform/api/device/IObricDeviceIdleController;", "notificationManager", "Lcom/obric/aiagent/product/platform/api/notification/IObricNotificationManager;", "vibrateFeedback", "Lcom/obric/aiagent/product/platform/api/vibratefeedback/IVibrateFeedback;", "windowEffects", "Lcom/obric/aiagent/product/platform/api/windoweffects/IWindowEffects;", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IPlatformService {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/api/IPlatformService$Companion;", "", "<init>", "()V", "get", "Lcom/obric/aiagent/product/platform/api/IPlatformService;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final IPlatformService get() {
            return PlatformServiceImpl.Companion.m174getInstance();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    IObricActivityManager activityManager();

    IObricActivityTaskManager activityTaskManager();

    void destroy();

    IObricDeviceIdleController deviceIdleController();

    void init();

    a inputmethodManager();

    IObricMemoryManager memoryManager();

    IObricNotificationManager notificationManager();

    IRomInfo romInfo();

    IObricSleepModeManager sleepModeManager();

    IVibrateFeedback vibrateFeedback();

    IWindowEffects windowEffects();

    IObricWindowManager windowManager();
}
