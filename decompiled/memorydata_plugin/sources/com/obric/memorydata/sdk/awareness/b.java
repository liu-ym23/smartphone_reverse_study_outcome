package com.obric.memorydata.sdk.awareness;

import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b:\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010?\u001a\u00020\u00052\b\u0010@\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010AJ\u000e\u0010B\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/FeatureValues;", "", "<init>", "()V", "ACTIVE_NETWORK_WIFI", "", "ACTIVE_NETWORK_CELLULAR", "ACTIVE_NETWORK_NONE", "WIFI_SWITCH_ON", "", "WIFI_SWITCH_OFF", "WIFI_CONNECTED", "WIFI_DIS_CONNECTED", "CELLULAR_DISABLE", "CELLULAR_ENABLE", "CELLULAR_CONNECTED", "SCREEN_STATE_OFF", "SCREEN_STATE_ON", "LOCK_STATE_LOCK", "LOCK_STATE_UNLOCK", "MOVEMENT_STATE_STATIC", "MOVEMENT_STATE_BY_CAR", "MOVEMENT_STATE_WALKING", "MOVEMENT_STATE_LYING", "MOVEMENT_STATE_SUBWAY", "MOVEMENT_STATE_DRIVING", "MOVEMENT_STATE_SUPPORT", "DEVICE_SCREEN_UP", "DEVICE_SCREEN_DOWN", "DEVICE_SCREEN_VERTICAL", "COMMUTE_STATE_INACTIVE", "COMMUTING_TO_HOME", "COMMUTING_TO_COMPANY", "WAKE_SLEEP_STATE_SLEEP", "WAKE_SLEEP_STATE_WAKE", "STATE_OFF", "STATE_ON", "OHR_HAND_LEFT", "OHR_HAND_RIGHT", "OHR_HAND_FREE", "HAR_STATE_STATIONARY", "HAR_STATE_RUNNING", "HAR_STATE_WALKING", "HAR_STATE_OTHER", "HAR_STATE_SUBWAY", "HAR_STATE_CYCLING", "HAR_STATE_ELECTRIC_BIKE", "HAR_STATE_CAR", "HAR_STATE_ELEVATOR_IN", "HAR_STATE_STAIR_UP", "HAR_STATE_STAIR_DOWN", "HAR_STATE_ESCALATOR_UP", "HAR_STATE_ESCALATOR_DOWN", "PRECISE_HAR_STATE_WALKING", "PRECISE_HAR_STATE_RUNNING", "PRECISE_HAR_STATE_STILL", "LOCATION_TYPE_HOME", "LOCATION_TYPE_COMPANY", "LOCATION_TYPE_NONE", "LOCATION_TYPE_AIRPORT", "LOCATION_TYPE_SUBWAY_STATION", "LOCATION_TYPE_RAILWAY_STATION", "LOCATION_TYPE_MALL", "getHARDesc", "state", "(Ljava/lang/Integer;)Ljava/lang/String;", "getLocationStateDesc", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12819a = null;

    static {
        f12819a = new b();
    }

    private b() {
    }

    public final String a(Integer r2) {
        if (r2 == null) goto L8;
        if (r2.intValue() != 0) goto L8;
        return "静止";
    L8:
        if (r2 == null) goto L14;
        if (r2.intValue() != 1) goto L14;
        return "跑步";
    L14:
        if (r2 == null) goto L20;
        if (r2.intValue() != 2) goto L20;
        return "走路";
    L20:
        if (r2 == null) goto L26;
        if (r2.intValue() != 4) goto L26;
        return IRecommendSettings.ProfileTag.OTHER;
    L26:
        if (r2 == null) goto L32;
        if (r2.intValue() != 5) goto L32;
        return "地铁";
    L32:
        if (r2 == null) goto L38;
        if (r2.intValue() != 6) goto L38;
        return "自行车";
    L38:
        if (r2 == null) goto L44;
        if (r2.intValue() != 7) goto L44;
        return "电动车";
    L44:
        if (r2 == null) goto L50;
        if (r2.intValue() != 8) goto L50;
        return "汽车";
    L50:
        if (r2 == null) goto L56;
        if (r2.intValue() != 201) goto L56;
        return "进直梯";
    L56:
        if (r2 == null) goto L62;
        if (r2.intValue() != 211) goto L62;
        return "上步梯";
    L62:
        if (r2 == null) goto L68;
        if (r2.intValue() != 212) goto L68;
        return "下步梯";
    L68:
        if (r2 == null) goto L74;
        if (r2.intValue() != 213) goto L74;
        return "上扶梯";
    L74:
        if (r2 != null) goto L77;
    L79:
        return "未知";
    L77:
        if (r2.intValue() != 214) goto L79;
        return "下扶梯";
    }

    public final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        int r0 = r2.hashCode();
        if (r0 == (-742111583)) goto L18;
        if (r0 == (-456606405)) goto L14;
        if (r0 == 24665195) goto L10;
        return r3;
    L10:
        if (r2.equals("inactive") == false) goto L25;
        return "未在通勤";
    L25:
        return r3;
    L14:
        if (r2.equals("commuting_to_home") == false) goto L26;
        return "通勤回家";
    L26:
        return r3;
    L18:
        if (r2.equals("commuting_to_company") == false) goto L27;
        return "通勤去公司";
    L27:
        return r3;
    }
}
