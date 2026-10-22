package com.obric.memorydata.awareness.impl;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/awareness/impl/AwarenessConstant;", "", "<init>", "()V", "TAG", "", "AWARENESS_STORE_NAME", "SKIP_VALUE_LOG_FEATURES", "", "getSKIP_VALUE_LOG_FEATURES$awareness_obricRelease", "()Ljava/util/Set;", "featureEnable", "", "ttsEnable", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8632a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f8633b = null;

    static {
        f8632a = new b();
        f8633b = SetsKt.setOf(new String[]{"location_city", "location_home_gps", "location_company_gps", "current_location_info", "current_geofences", "device_wifi", "current_wifi_ssid", "connect_bluetooth_devices", "device_foreground_app"});
    }

    private b() {
    }

    public final Set<String> a() {
        return f8633b;
    }

    public final boolean b() {
        return true;
    }

    public final boolean c() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_recommend_tts_switch_on", false);
    }
}
