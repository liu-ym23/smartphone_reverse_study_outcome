package com.obric.memorydata.personalcontext.impl;

import android.content.Context;
import android.os.PowerManager;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.framwork.core.sdklib.apm6.LogReportController;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.g;
import com.bytedance.ttnet.config.AppConfig;
import com.monitor.cloudmessage.CloudMessageManager;
import com.obric.memorydata.ability.condition.e;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.controller.INetworkController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.BackgroundOsResourceOptimizeSettings;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.condition.b;
import com.obric.memorydata.task.condition.d;
import com.obric.memorydata.task.condition.h;
import com.obric.memorydata.task.condition.j;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.memorydata.utils.ao;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0000H\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0017J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0017J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/NetworkControllerImpl;", "Lcom/obric/memorydata/middleware/api/controller/INetworkController;", "Lcom/obric/memorydata/task/condition/ConditionChangeListener;", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "<init>", "()V", "TAG", "", "isNetworkWindowOpened", "", "screenOn", "powerConnected", "networkAllow", "backgroundNetworkMode", "", "getInst", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "isNetWindowOpen", "isScreenOn", "isNetworkPolicySatisfied", "refreshBackgroundNetworkMode", "readBackgroundNetworkMode", "isMemoryAppForeground", "switchNetworkPolicy", "allow", "onConditionChange", "condition", "Lcom/obric/memorydata/task/condition/Condition;", "isSatisfied", "onSettingsChanged", "key", "updateNetworkPolicyState", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NetworkControllerImpl implements INetworkController, SettingsChangeListener, d {
    public static final NetworkControllerImpl INSTANCE = null;
    public static final String TAG = "NetworkController";
    private static volatile int backgroundNetworkMode;
    private static boolean isNetworkWindowOpened;
    private static boolean networkAllow;
    private static boolean powerConnected;
    private static boolean screenOn;

    static {
        INSTANCE = new NetworkControllerImpl();
        isNetworkWindowOpened = true;
        screenOn = true;
        networkAllow = true;
        backgroundNetworkMode = 1;
    }

    private NetworkControllerImpl() {
    }

    @JvmStatic
    public static final NetworkControllerImpl getInst() {
        return INSTANCE;
    }

    private final boolean isMemoryAppForeground() {
        Object r2 = FeatureManager.INSTANCE.getFeature("device_foreground_app");
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L5;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L7:
        return Intrinsics.areEqual(r3, AppContext.INSTANCE.getPackageName());
    L5:
        r3 = null;
        goto L7
    }

    public static /* synthetic */ Unit lambda$CDjN3wVnP71HlfHbokiEvSE6YJs() {
        return updateNetworkPolicyState$lambda$1();
    }

    private final int readBackgroundNetworkMode() {
        SettingsManager r13 = SettingsManager.INSTANCE;
        Object r6 = new BackgroundOsResourceOptimizeSettings(false, null, null, 7, null);
        String r0 = r13.getSettingsStr(SettingsManager.KEY_BACKGROUND_OS_RESOURCE_OPTIMIZE);
        Object r1 = null;
        if (r0 != null) goto L23;
    L9:
        if (r1 == null) goto L12;
        r6 = r1;
    L12:
        BackgroundOsResourceOptimizeSettings r14 = (BackgroundOsResourceOptimizeSettings) ZeusTransformUtils.preCheckCast(r6, BackgroundOsResourceOptimizeSettings.class, "com.obric.memorydata.plugin");
        if (r14.getEnable() == false) goto L21;
        int r15 = r14.getBackgroundNetworkModeConfig().getMode();
        if (r15 == 0) goto L26;
        if (r15 == 1) goto L26;
        if (r15 == 2) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "invalid backgroundNetworkMode: " + r15 + ", use default medium", false, 4, null);
        return 1;
    L26:
        return r15;
    L21:
        return 0;
    L23:
        r1 = r13.getGSON().fromJson(r0, BackgroundOsResourceOptimizeSettings.class);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        goto L9
    }

    private final void refreshBackgroundNetworkMode() {
        backgroundNetworkMode = readBackgroundNetworkMode();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "backgroundNetworkMode: " + backgroundNetworkMode, false, 4, null);
    }

    private final void switchNetworkPolicy(boolean r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "switchNetworkPolicy: " + r10, false, 4, null);
        if (r10 == false) goto L5;
        int r9 = 4;
    L6:
        Logger.setLogLevel(r9);
        if (r10 == false) goto L9;
        long r2 = 1;
    L10:
        LogReportController r11 = LogReportController.getInstance();
        Method r0 = r11.getClass().getDeclaredMethod("delayReport", new Class[]{Long.TYPE});
        r0.setAccessible(true);
        r0.invoke(r11, new Object[]{Long.valueOf(r2)});
        SDKMonitor r12 = g.a(String.valueOf(AppContext.INSTANCE.getAid()));
        Field r1 = r12.getClass().getDeclaredField("mLastFetchSettingTime");
        r1.setAccessible(true);
        long r5 = System.currentTimeMillis();
        if (r10 == false) goto L13;
        long r6 = r5 - 600000;
    L14:
        r1.set(r12, Long.valueOf(r6));
        AppConfig r13 = AppConfig.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        Field r3 = r13.getClass().getDeclaredField("mConfigUpdating");
        r3.setAccessible(true);
        Object r14 = r3.get(r13);
        if (ZeusTransformUtils.instanceOf(r14, AtomicBoolean.class) == false) goto L17;
        AtomicBoolean r15 = (AtomicBoolean) ZeusTransformUtils.preCheckCast(r14, AtomicBoolean.class, "com.obric.memorydata.plugin");
    L18:
        if (r15 == null) goto L20;
        r15.set(!r10);
    L20:
        Object r16 = ao.a(CloudMessageManager.class, "sIsInit");
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Boolean");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L28;
        CloudMessageManager r17 = CloudMessageManager.getInstance();
        Field r4 = r17.getClass().getDeclaredField("mLastFetchTime");
        r4.setAccessible(true);
        if (r10 == false) goto L25;
        Long r18 = Long.valueOf(System.currentTimeMillis() - 60000);
    L26:
        r4.set(r17, r18);
        return;
    L25:
        r18 = Long.valueOf(System.currentTimeMillis() + 2592000000L);
        goto L26
    L28:
        return;
    L17:
        r15 = null;
        goto L18
    L13:
        r6 = r5 + 2592000000L;
        goto L14
    L9:
        r2 = 2592000;
        goto L10
    L5:
        r9 = 3;
        goto L6
    }

    private final void updateNetworkPolicyState() {
        boolean r6 = isNetworkPolicySatisfied();
        if (networkAllow == r6) goto L6;
        networkAllow = r6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "networkAllow state -> " + networkAllow, false, 4, null);
        y.a(null, $$Lambda$NetworkControllerImpl$CDjN3wVnP71HlfHbokiEvSE6YJs.INSTANCE, 1, null);
        return;
    }

    private static final Unit updateNetworkPolicyState$lambda$1() {
        INSTANCE.switchNetworkPolicy(networkAllow);
        return Unit.INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.controller.INetworkController
    public void init() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.PowerManager");
        screenOn = ((PowerManager) ZeusTransformUtils.preCheckCast(r0, PowerManager.class, "com.obric.memorydata.plugin")).isInteractive();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "init screenOn: " + screenOn + ", powerConnected: " + powerConnected, false, 4, null);
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new b[]{new j(), new h(), new e(Condition.POWER_CONNECTED)}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.memorydata.plugin");
        r2.b();
        r2.b((d) ZeusTransformUtils.preCheckCast(INSTANCE, d.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        refreshBackgroundNetworkMode();
        SettingsManager.INSTANCE.registerChangeListener(SettingsManager.KEY_BACKGROUND_OS_RESOURCE_OPTIMIZE, (SettingsChangeListener) ZeusTransformUtils.preCheckCast(this, SettingsChangeListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.middleware.api.controller.INetworkController
    public boolean isNetWindowOpen() {
        return isNetworkWindowOpened;
    }

    @Override // com.obric.memorydata.middleware.api.controller.INetworkController
    public boolean isNetworkPolicySatisfied() {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getServerDeviceId(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return true;
    L9:
        if (backgroundNetworkMode != 2) goto L15;
        if (isMemoryAppForeground() == true) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "isNetworkPolicySatisfied false by strict background network policy.", false, 4, null);
        return false;
    L15:
        if (screenOn == false) goto L17;
        return true;
    L17:
        if (powerConnected == false) goto L20;
        return true;
    L20:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.controller.INetworkController
    public boolean isScreenOn() {
        Object r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) ZeusTransformUtils.preCheckCast(r2, PowerManager.class, "com.obric.memorydata.plugin")).isInteractive();
    }

    @Override // com.obric.memorydata.task.condition.d
    public void onConditionChange(Condition r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "condition");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onConditionChange -> " + r8 + ", " + r9, false, 4, null);
        if (r8 != Condition.NETWORK_WINDOW) goto L6;
        isNetworkWindowOpened = r9;
    L11:
        updateNetworkPolicyState();
        return;
    L6:
        if (r8 != Condition.SCREEN_ON) goto L9;
        screenOn = r9;
        goto L11
    L9:
        if (r8 != Condition.POWER_CONNECTED) goto L11;
        powerConnected = r9;
        goto L11
    }

    @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
    public void onSettingsChanged(String r8) {
        Intrinsics.checkNotNullParameter(r8, "key");
        if (Intrinsics.areEqual(r8, SettingsManager.KEY_BACKGROUND_OS_RESOURCE_OPTIMIZE) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onSettingsChanged -> " + r8, false, 4, null);
        refreshBackgroundNetworkMode();
        updateNetworkPolicyState();
        return;
    }
}
