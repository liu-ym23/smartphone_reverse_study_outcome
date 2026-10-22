package com.obric.memorydata.ability;

import com.obric.memorydata.ability.impl.p;
import com.obric.memorydata.ability.impl.s;
import com.obric.memorydata.ability.impl.t;
import com.obric.memorydata.ability.impl.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010%\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\"\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00050\u00050+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/memorydata/ability/AbilityInfoManager;", "", "<init>", "()V", "TAG", "", "UNKNOWN_DATA_ID", "", "GEOGRAPHY_DATA_ID", "WIFI_DATA_ID", "MOBILE_CELLULAR_DATA_ID", "LOCATION_DATA_ID", "SCREEN_STATE_DATA_ID", "TIME_DATA_ID", "BLUETOOTH_DEVICE_DATA_ID", "SCREEN_BRIGHTNESS_DATA_ID", "LANGUAGE_CHANGE_EVENT_DATA_ID", "BATTERY_STATE_DATA_ID", "STREAM_VOLUME_DATA_ID", "NETWORK_STATUS_DATA_ID", "LIGHT_SENSOR_DATA_ID", "FLOAT_WINDOW_DATA_ID", "TEMPERATURE_STATE_DATA_ID", "APP_ACTIVITY_STATUS_DATA_ID", "PACKAGE_EVENT_DATA_ID", "DEVICE_BOOT_DATA_ID", "DEVICE_SHUTDOWN_DATA_ID", "SETTINGS_CHANGED_DATA_ID", "APP_USE_DATA_ID", "DEVICE_ALARM_DATA_ID", "ACTIVE_AUDIO_DATA_ID", "USER_ACTION_RECORDER_DATA_ID", "WECHAT_CHAT_HISTORY_DATA_ID", "COMMON_APP_EVENT_DATA_ID", "COMMON_COLLECT_MIN_DATA_ID", "MEI_TUAN_DATA_ID", "XIAO_HONG_SHU_DATA_ID", "COMMON_COLLECT_MAX_DATA_ID", "TEST_QUERY_DATA_ID", "EXCLUDE_BOT_CHAT_OS_DATA_ID", "EXCLUDE_BOT_CHAT_OS_DATA_V2_ID", "AUTO_QUERY_ID", "abilityInstanceMap", "", "kotlin.jvm.PlatformType", "queryAbilityClass", "dataId", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8307a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Integer, String> f8308b = null;

    static {
        f8307a = new c();
        Map<Integer, String> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(100000002, u.class.getName()), TuplesKt.to(100001002, com.obric.memorydata.ability.impl.n.class.getName()), TuplesKt.to(100000005, p.class.getName()), TuplesKt.to(100000006, t.class.getName()), TuplesKt.to(100000010, com.obric.memorydata.ability.impl.b.class.getName()), TuplesKt.to(100000012, com.obric.memorydata.ability.impl.m.class.getName()), TuplesKt.to(100000015, s.class.getName())});
        f8308b = r0;
        r0.putAll(b.f8305a.a());
    }

    private c() {
    }

    public final String a(int r3) {
        String r2 = (String) ZeusTransformUtils.preCheckCast(f8308b.get(Integer.valueOf(r3)), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("unknown ability data id: " + r3);
    }
}
