package com.obric.aikernel.middleware.impl.settings;

import android.content.IntentFilter;
import com.bytedance.applog.h;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.settings.ISettingsManager;
import com.obric.aikernel.middleware.impl.settings.api.AppInfoSettings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.z0;
import org.json.JSONObject;
import s7.g;
import s7.i;

/* JADX INFO: loaded from: classes2.dex */
public final class AppSettingsManager implements ISettingsManager {
    public static final AppSettingsManager INSTANCE = null;
    private static final String TAG = "InitSettingsTask";
    private static final Lazy appSettingsConfig$delegate = null;
    private static long lastUpdateTime;
    private static final l0 screenOnUpdateScope = null;
    private static final Object updateTimeLock = null;

    public static final class a implements h {
        a() {
        }

        @Override // com.bytedance.applog.h
        public void a(boolean r10, JSONObject r11) {
        }

        @Override // com.bytedance.applog.h
        public void onIdLoaded(String r10, String r11, String r12) {
            if (r10 != null) goto L5;
        L8:
            boolean r13 = true;
        L9:
            if (r13 == true) goto L12;
            AIKLog.INSTANCE.d(AppSettingsManager.TAG, "did load and update now");
            e4.e.l(true);
            return;
        L12:
            return;
        L5:
            if (r10.length() == 0) goto L8;
            r13 = false;
            goto L9
        }

        @Override // com.bytedance.applog.h
        public void onRemoteIdGet(boolean r10, String r11, String r12, String r13, String r14, String r15, String r16) {
            if (r12 != null) goto L5;
        L8:
            boolean r17 = true;
        L9:
            if (r17 == true) goto L12;
            AIKLog.INSTANCE.d(AppSettingsManager.TAG, "did remote load and update now");
            e4.e.l(true);
            return;
        L12:
            return;
        L5:
            if (r12.length() == 0) goto L8;
            r17 = false;
            goto L9
        }
    }

    static {
        INSTANCE = new AppSettingsManager();
        appSettingsConfig$delegate = LazyKt.lazy(AppSettingsManager$appSettingsConfig$2.INSTANCE);
        screenOnUpdateScope = m0.a(q2.b(null, 1, null).plus(z0.b()));
        updateTimeLock = new Object();
    }

    private AppSettingsManager() {
    }

    public static final /* synthetic */ l0 access$getScreenOnUpdateScope$p() {
        return screenOnUpdateScope;
    }

    public static final /* synthetic */ boolean access$shouldTriggerScreenOnUpdate(AppSettingsManager r10, long r11) {
        return r10.shouldTriggerScreenOnUpdate(r11);
    }

    private final AppSettingsConfig getAppSettingsConfig() {
        return (AppSettingsConfig) appSettingsConfig$delegate.getValue();
    }

    @JvmStatic
    public static final AppSettingsManager getInst() {
        return INSTANCE;
    }

    private final boolean shouldTriggerScreenOnUpdate(long r10) {
        long r11 = ((getSettingsSetting().a() * 60) * 60) * 1000;
        Object r12 = updateTimeLock;
        monitor-enter(r12);
    L14:
        th = move-exception;
        throw th;
    L5:
        if ((r10 - lastUpdateTime) <= r11) goto L10;
        lastUpdateTime = r10;     // Catch: Throwable -> L14
        monitor-exit(r12);
        return true;
    L10:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r12);
        return false;
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public String getABValueWith(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return "";
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public String getAppValueWith(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return getAppSettingsConfig().h(r10);
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public s7.b getCloudSlmInterceptorSetting() {
        return ((AppInfoSettings) e4.e.g(AppInfoSettings.class)).CloudSlmInterceptorSetting();
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public s7.c getMemoryCollectSetting() {
        return ((AppInfoSettings) e4.e.g(AppInfoSettings.class)).memoryCollectSetting();
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public s7.d getModelQuotaConfigs() {
        return ((AppInfoSettings) e4.e.g(AppInfoSettings.class)).NativeModelQuotaMappingSetting();
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public g getSettingsSetting() {
        return ((AppInfoSettings) e4.e.g(AppInfoSettings.class)).settingsSetting();
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public s7.h getTTNetStandbySettings() {
        return ((AppInfoSettings) e4.e.g(AppInfoSettings.class)).ttnetStandbyWhitelist();
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public i getVmSettings() {
        return ((AppInfoSettings) e4.e.g(AppInfoSettings.class)).vmSettings();
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public void init() {
        String r10 = com.bytedance.applog.a.d();
        getAppSettingsConfig().i();
        boolean r11 = false;
        if (r10 != null) goto L5;
    L10:
        if (r11 == false) goto L12;
        e4.e.l(true);
        AIKLog.INSTANCE.d(TAG, "did is not empty and update now");
    L12:
        com.bytedance.applog.a.a(new a());
        AppContext.INSTANCE.getContext().registerReceiver(new AnonymousClass2(), new IntentFilter("android.intent.action.SCREEN_ON"));
        return;
    L5:
        if (r10.length() <= 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 != true) goto L10;
        r11 = true;
        goto L10
    L7:
        r12 = false;
        goto L8
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public void registerObserver(s7.f r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        getAppSettingsConfig().l(r10);
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public void unregisterObserver(s7.f r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        getAppSettingsConfig().m(r10);
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public void update() {
        e4.e.l(true);
    }
}
