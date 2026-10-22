package com.obric.memorydata.task.condition;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0018\u001a\u00020\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/task/condition/Condition;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NETWORK_AVAILABLE", "NETWORK_WINDOW", "WIFI_CONNECTED", "SCREEN_ON", "SCREEN_OFF", "TEMPERATURE_LOW_RANGE", "TEMPERATURE_SEVERE_RANGE", "NOT_IN_POWER_SAVE_MODE", "POWER_CONNECTED", "BATTERY_MEETS_REQUIREMENT", "LIGHT_POWER_CONTROL", "COMMON_POWER_CONTROL", "MEMORY_EXTRACT_POWER_CONTROL", "STRICTLY_POWER_CONTROL", "SCREEN_ON_OR_CHARGE", "BATTERY_BELOW_80_CHARGING_10_MIN", "toJson", "Lorg/json/JSONObject;", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum Condition extends Enum<Condition> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Condition[] $VALUES = null;
    public static final Condition BATTERY_BELOW_80_CHARGING_10_MIN = null;
    public static final Condition BATTERY_MEETS_REQUIREMENT = null;
    public static final Condition COMMON_POWER_CONTROL = null;
    public static final a Companion = null;
    public static final Condition LIGHT_POWER_CONTROL = null;
    public static final Condition MEMORY_EXTRACT_POWER_CONTROL = null;
    public static final Condition NETWORK_AVAILABLE = null;
    public static final Condition NETWORK_WINDOW = null;
    public static final Condition NOT_IN_POWER_SAVE_MODE = null;
    public static final Condition POWER_CONNECTED = null;
    public static final Condition SCREEN_OFF = null;
    public static final Condition SCREEN_ON = null;
    public static final Condition SCREEN_ON_OR_CHARGE = null;
    public static final Condition STRICTLY_POWER_CONTROL = null;
    public static final Condition TEMPERATURE_LOW_RANGE = null;
    public static final Condition TEMPERATURE_SEVERE_RANGE = null;
    public static final Condition WIFI_CONNECTED = null;
    private final String value;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/task/condition/Condition$Companion;", "", "<init>", "()V", "from", "Lcom/obric/memorydata/task/condition/Condition;", EventBody.KEY_VALUE, "", "fromJson", "json", "Lorg/json/JSONObject;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final Condition a(String r5) {
            Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
            Condition[] r4 = Condition.values();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            Condition r2 = r4[r1];
            if (Intrinsics.areEqual(r2.getValue(), r5) == true) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r2;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ Condition[] $values() {
        return new Condition[]{NETWORK_AVAILABLE, NETWORK_WINDOW, WIFI_CONNECTED, SCREEN_ON, SCREEN_OFF, TEMPERATURE_LOW_RANGE, TEMPERATURE_SEVERE_RANGE, NOT_IN_POWER_SAVE_MODE, POWER_CONNECTED, BATTERY_MEETS_REQUIREMENT, LIGHT_POWER_CONTROL, COMMON_POWER_CONTROL, MEMORY_EXTRACT_POWER_CONTROL, STRICTLY_POWER_CONTROL, SCREEN_ON_OR_CHARGE, BATTERY_BELOW_80_CHARGING_10_MIN};
    }

    static {
        NETWORK_AVAILABLE = new Condition("NETWORK_AVAILABLE", 0, "network_available");
        NETWORK_WINDOW = new Condition("NETWORK_WINDOW", 1, "network_window");
        WIFI_CONNECTED = new Condition("WIFI_CONNECTED", 2, "wifi_connected");
        SCREEN_ON = new Condition("SCREEN_ON", 3, "screen_on");
        SCREEN_OFF = new Condition("SCREEN_OFF", 4, "screen_off");
        TEMPERATURE_LOW_RANGE = new Condition("TEMPERATURE_LOW_RANGE", 5, "temperature_low_range");
        TEMPERATURE_SEVERE_RANGE = new Condition("TEMPERATURE_SEVERE_RANGE", 6, "temperature_severe_range");
        NOT_IN_POWER_SAVE_MODE = new Condition("NOT_IN_POWER_SAVE_MODE", 7, "not_in_power_save_mode");
        POWER_CONNECTED = new Condition("POWER_CONNECTED", 8, "power_connected");
        BATTERY_MEETS_REQUIREMENT = new Condition("BATTERY_MEETS_REQUIREMENT", 9, "battery_meets_requirement");
        LIGHT_POWER_CONTROL = new Condition("LIGHT_POWER_CONTROL", 10, "light_power_control");
        COMMON_POWER_CONTROL = new Condition("COMMON_POWER_CONTROL", 11, "common_power_control");
        MEMORY_EXTRACT_POWER_CONTROL = new Condition("MEMORY_EXTRACT_POWER_CONTROL", 12, "memory_extract_power_control");
        STRICTLY_POWER_CONTROL = new Condition("STRICTLY_POWER_CONTROL", 13, "strictly_power_control");
        SCREEN_ON_OR_CHARGE = new Condition("SCREEN_ON_OR_CHARGE", 14, "screen_on_or_charge");
        BATTERY_BELOW_80_CHARGING_10_MIN = new Condition("BATTERY_BELOW_80_CHARGING_10_MIN", 15, "battery_below_80_charging_10_min");
        Condition[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private Condition(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<Condition> getEntries() {
        return $ENTRIES;
    }

    public static Condition valueOf(String r2) {
        return (Condition) ZeusTransformUtils.preCheckCast(Enum.valueOf(Condition.class, r2), Condition.class, "com.obric.memorydata.plugin");
    }

    public static Condition[] values() {
        return (Condition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Condition[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }

    public final JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        r0.put(EventBody.KEY_VALUE, this.value);
        return r0;
    }
}
