package com.bytedance.awemeopen.infra.plugs.settings;

import android.content.Context;
import com.bytedance.awemeopen.infra.plugs.settings.dao.AoSettingsDao;
import com.bytedance.awemeopen.infra.plugs.settings.update.AoAppSettingsUpdater;
import com.bytedance.awemeopen.infra.plugs.settings.update.AoAppSettingsUpdater$mUpdateReceiver$2;
import com.bytedance.awemeopen.infra.plugs.settings.update.MainSettingsProviderImpl;
import com.bytedance.awemeopen.servicesapi.log.AoLogService;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0017\u0018\u0000 -2\u00020\u0001:\u0001-B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0018\u001a\u00020\u0005J\u0010\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u0005J\b\u0010#\u001a\u00020\rH\u0005J\u0006\u0010$\u001a\u00020\u0017J\u0010\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00020\u0005J\u0012\u0010&\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010(\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u001eJ\b\u0010*\u001a\u00020\u0017H\u0007J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u0005H\u0007R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\u00030\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006."}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/settings/AoSettings;", "", "context", "Landroid/content/Context;", "mBdpId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", "mAppHandler", "Lcom/bytedance/awemeopen/infra/plugs/settings/IAppSettingsHandler;", "mBdpSettingsDao", "Lcom/bytedance/awemeopen/infra/plugs/settings/dao/AoSettingsDao;", "mCacheSettingsModel", "Lcom/bytedance/awemeopen/infra/plugs/settings/SettingsModel;", "mContext", "kotlin.jvm.PlatformType", "mSettingsUpdater", "Lcom/bytedance/awemeopen/infra/plugs/settings/update/AoAppSettingsUpdater;", "getMSettingsUpdater", "()Lcom/bytedance/awemeopen/infra/plugs/settings/update/AoAppSettingsUpdater;", "mSettingsUpdater$delegate", "Lkotlin/Lazy;", "clearMockSettings", "", "key", "getLastUpdateTime", "", "getQueryParams", "", "getSettings", "Lorg/json/JSONObject;", "getSettingsArray", "Lorg/json/JSONArray;", "isSettingMocked", "", "loadSettingsModel", "onDestroy", "opt", "setAppSettingsHandler", "appHandler", "setMockSettings", "mockObject", "updateSettings", "force", "from", "Companion", "ao_plugin_settings_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class AoSettings {
    public static final Companion Companion = null;
    private static final ConcurrentHashMap<String, AoSettings> mAppSettingsMap = null;
    private final String TAG;
    private IAppSettingsHandler mAppHandler;
    private final String mBdpId;
    private AoSettingsDao mBdpSettingsDao;
    private volatile SettingsModel mCacheSettingsModel;
    private Context mContext;
    private final Lazy mSettingsUpdater$delegate;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/settings/AoSettings$Companion;", "", "()V", "mAppSettingsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/awemeopen/infra/plugs/settings/AoSettings;", "get", "context", "Landroid/content/Context;", "bdpAppId", "ao_plugin_settings_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final AoSettings get(Context r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "bdpAppId");
            Object r0 = AoSettings.access$getMAppSettingsMap$cp().get(r5);
            if (r0 == null) goto L7;
            return (AoSettings) r0;
        L7:
            monitor-enter(AoSettings.class);
            Object r1 = AoSettings.access$getMAppSettingsMap$cp().get(r5);     // Catch: Throwable -> L16
            if (r1 == null) goto L13;
            AoSettings r2 = (AoSettings) r1;     // Catch: Throwable -> L16
            monitor-exit(AoSettings.class);
            return r2;
        L13:
            AoSettings r3 = new AoSettings(r4, r5, null);     // Catch: Throwable -> L16
            AoSettings r6 = (AoSettings) AoSettings.access$getMAppSettingsMap$cp().put(r5, r3);     // Catch: Throwable -> L16
            monitor-exit(AoSettings.class);
            return r3;
        L16:
            th = move-exception;
            throw th;
        }
    }

    public /* synthetic */ AoSettings(Context r1, String r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @JvmStatic
    public static final AoSettings get(Context r1, String r2) {
        return Companion.get(r1, r2);
    }

    public final void updateSettings() {
        updateSettings(false, "unknown");
    }

    static {
        Companion = new Companion(null);
        mAppSettingsMap = new ConcurrentHashMap();
    }

    private final AoAppSettingsUpdater getMSettingsUpdater() {
        return (AoAppSettingsUpdater) this.mSettingsUpdater$delegate.getValue();
    }

    private final Map<String, String> getQueryParams() {
        IAppSettingsHandler r0 = this.mAppHandler;
        if (r0 == null) goto L7;
        Map<String, String> r1 = r0.onQueryParams(this.mBdpId);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return MapsKt.emptyMap();
    }

    public final SettingsModel loadSettingsModel() {
        SettingsModel r0 = this.mCacheSettingsModel;
        if (r0 != null) goto L6;
        SettingsModel r1 = this.mBdpSettingsDao.loadSettingsModel();
        this.mCacheSettingsModel = r1;
        return r1;
    L6:
        return r0;
    }

    public final long getLastUpdateTime() {
        return loadSettingsModel().getLastUpdateTime();
    }

    @Deprecated(message = "后续去除，建议使用 getSettings(key)")
    public final JSONObject getSettings() {
        JSONObject r0 = loadSettingsModel().getSettings();
        updateSettings(false, "getSettings");
        return r0;
    }

    public final void onDestroy() {
        AoAppSettingsUpdater r0 = getMSettingsUpdater();
        Context r1 = r0.a;
        AoAppSettingsUpdater$mUpdateReceiver$2.AnonymousClass1 r2 = (AoAppSettingsUpdater$mUpdateReceiver$2.AnonymousClass1) r0.g.getValue();
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMAppSettingsMap$cp() {
        return mAppSettingsMap;
    }

    public static final /* synthetic */ IAppSettingsHandler access$getMAppHandler$p(AoSettings r0) {
        return r0.mAppHandler;
    }

    public static final /* synthetic */ String access$getMBdpId$p(AoSettings r0) {
        return r0.mBdpId;
    }

    public static final /* synthetic */ AoSettingsDao access$getMBdpSettingsDao$p(AoSettings r0) {
        return r0.mBdpSettingsDao;
    }

    public static final /* synthetic */ Context access$getMContext$p(AoSettings r0) {
        return r0.mContext;
    }

    public static final /* synthetic */ Map access$getQueryParams(AoSettings r0) {
        return r0.getQueryParams();
    }

    public final void clearMockSettings(String r2) {
        getMSettingsUpdater().c(r2);
    }

    public final JSONObject getSettings(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r3 = opt(r2);
        if ((r3 instanceof JSONObject) == true) goto L7;
        return null;
    L7:
        return (JSONObject) r3;
    }

    public final JSONArray getSettingsArray(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r3 = opt(r2);
        if ((r3 instanceof JSONArray) == true) goto L7;
        return null;
    L7:
        return (JSONArray) r3;
    }

    public final boolean isSettingMocked(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        AoAppSettingsUpdater r1 = getMSettingsUpdater();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "key");
        return ((MainSettingsProviderImpl) r1.f.getValue()).isSettingMocked(r1.b, r3);
    }

    public final Object opt(String r6) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Object r0 = loadSettingsModel().getSettings().opt(r6);
        AoLogService r1 = j64.a.a(AoLogService.class);
        if (r1 == null) goto L5;
        r1.i(this.TAG, "getSettings" + r6 + r0);
    L5:
        updateSettings(false, "opt_" + r6);
        return r0;
    }

    public final void setAppSettingsHandler(IAppSettingsHandler r1) {
        this.mAppHandler = r1;
    }

    private AoSettings(Context r3, String r4) {
        this.mBdpId = r4;
        this.TAG = "AoAppSettings_" + r4;
        this.mContext = r3.getApplicationContext();
        this.mBdpSettingsDao = new AoSettingsDao(this.mContext, r4);
        this.mSettingsUpdater$delegate = LazyKt.lazy(new AoSettings$mSettingsUpdater$2(this));
    }

    public static final /* synthetic */ void access$setMCacheSettingsModel$p(AoSettings r0, SettingsModel r1) {
        r0.mCacheSettingsModel = r1;
    }

    public final void setMockSettings(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        getMSettingsUpdater().d(r2, r3);
    }

    public final void updateSettings(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        getMSettingsUpdater().e(new AnonymousClass1(this), r3, r4);
    }
}
