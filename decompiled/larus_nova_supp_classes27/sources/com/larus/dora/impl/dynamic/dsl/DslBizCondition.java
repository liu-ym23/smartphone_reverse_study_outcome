package com.larus.dora.impl.dynamic.dsl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslBizCondition;", "", "<init>", "(Ljava/lang/String;I)V", "SUPPORT_INTERPRETATION", "SUPPORT_NOTIFICATION_BROADCAST", "SUPPORT_OWEN_WAKEUP", "SUPPORT_MEETING_MINUTES", "SUPPORT_QUICK_NOTES", "SUPPORT_QUICK_NOTE", "SUPPORT_WIFI_SETTINGS", "SUPPORT_CASE_VERSION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DslBizCondition extends Enum<DslBizCondition> {

    @SerializedName("support_case_version")
    public static final DslBizCondition SUPPORT_CASE_VERSION = null;

    @SerializedName("support_interpretation")
    public static final DslBizCondition SUPPORT_INTERPRETATION = null;

    @SerializedName("support_meeting_minutes")
    public static final DslBizCondition SUPPORT_MEETING_MINUTES = null;

    @SerializedName("support_notification_broadcast")
    public static final DslBizCondition SUPPORT_NOTIFICATION_BROADCAST = null;

    @SerializedName("support_owen_wakeup")
    public static final DslBizCondition SUPPORT_OWEN_WAKEUP = null;

    @SerializedName("support_quick_note")
    public static final DslBizCondition SUPPORT_QUICK_NOTE = null;

    @SerializedName("support_quick_notes")
    public static final DslBizCondition SUPPORT_QUICK_NOTES = null;

    @SerializedName("support_wifi_settings")
    public static final DslBizCondition SUPPORT_WIFI_SETTINGS = null;
    public static final /* synthetic */ DslBizCondition[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DslBizCondition> getEntries() {
        return b;
    }

    static {
        DslBizCondition r0 = new DslBizCondition("SUPPORT_INTERPRETATION", 0);
        SUPPORT_INTERPRETATION = r0;
        DslBizCondition r1 = new DslBizCondition("SUPPORT_NOTIFICATION_BROADCAST", 1);
        SUPPORT_NOTIFICATION_BROADCAST = r1;
        DslBizCondition r3 = new DslBizCondition("SUPPORT_OWEN_WAKEUP", 2);
        SUPPORT_OWEN_WAKEUP = r3;
        DslBizCondition r5 = new DslBizCondition("SUPPORT_MEETING_MINUTES", 3);
        SUPPORT_MEETING_MINUTES = r5;
        DslBizCondition r7 = new DslBizCondition("SUPPORT_QUICK_NOTES", 4);
        SUPPORT_QUICK_NOTES = r7;
        DslBizCondition r9 = new DslBizCondition("SUPPORT_QUICK_NOTE", 5);
        SUPPORT_QUICK_NOTE = r9;
        DslBizCondition r11 = new DslBizCondition("SUPPORT_WIFI_SETTINGS", 6);
        SUPPORT_WIFI_SETTINGS = r11;
        DslBizCondition r13 = new DslBizCondition("SUPPORT_CASE_VERSION", 7);
        SUPPORT_CASE_VERSION = r13;
        DslBizCondition[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static DslBizCondition[] values() {
        return (DslBizCondition[]) a.clone();
    }

    public static DslBizCondition valueOf(String r1) {
        return (DslBizCondition) r27.a.a(DslBizCondition.class, r1);
    }

    public DslBizCondition(String r1, int r2) {
        super(r1, r2);
    }
}
