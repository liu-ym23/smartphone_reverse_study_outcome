package com.obric.assistant.dora;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/assistant/dora/DoraPrivateProtocolService$BatteryDeviceType;", "", "<init>", "(Ljava/lang/String;I)V", "LITE", "H_FREE_CLIP_2", "H_FREE_BUDS_PRO_5", "G1", "G2", "G_AIR", "G_PIN", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum DoraPrivateProtocolService$BatteryDeviceType extends Enum<DoraPrivateProtocolService$BatteryDeviceType> {
    public static final a Companion = null;
    public static final DoraPrivateProtocolService$BatteryDeviceType G1 = null;
    public static final DoraPrivateProtocolService$BatteryDeviceType G2 = null;
    public static final DoraPrivateProtocolService$BatteryDeviceType G_AIR = null;
    public static final DoraPrivateProtocolService$BatteryDeviceType G_PIN = null;
    public static final DoraPrivateProtocolService$BatteryDeviceType H_FREE_BUDS_PRO_5 = null;
    public static final DoraPrivateProtocolService$BatteryDeviceType H_FREE_CLIP_2 = null;
    public static final DoraPrivateProtocolService$BatteryDeviceType LITE = null;
    public static final /* synthetic */ DoraPrivateProtocolService$BatteryDeviceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DoraPrivateProtocolService$BatteryDeviceType> getEntries() {
        return b;
    }

    static {
        DoraPrivateProtocolService$BatteryDeviceType r0 = new DoraPrivateProtocolService$BatteryDeviceType("LITE", 0);
        LITE = r0;
        DoraPrivateProtocolService$BatteryDeviceType r1 = new DoraPrivateProtocolService$BatteryDeviceType("H_FREE_CLIP_2", 1);
        H_FREE_CLIP_2 = r1;
        DoraPrivateProtocolService$BatteryDeviceType r3 = new DoraPrivateProtocolService$BatteryDeviceType("H_FREE_BUDS_PRO_5", 2);
        H_FREE_BUDS_PRO_5 = r3;
        DoraPrivateProtocolService$BatteryDeviceType r5 = new DoraPrivateProtocolService$BatteryDeviceType("G1", 3);
        G1 = r5;
        DoraPrivateProtocolService$BatteryDeviceType r7 = new DoraPrivateProtocolService$BatteryDeviceType("G2", 4);
        G2 = r7;
        DoraPrivateProtocolService$BatteryDeviceType r9 = new DoraPrivateProtocolService$BatteryDeviceType("G_AIR", 5);
        G_AIR = r9;
        DoraPrivateProtocolService$BatteryDeviceType r11 = new DoraPrivateProtocolService$BatteryDeviceType("G_PIN", 6);
        G_PIN = r11;
        DoraPrivateProtocolService$BatteryDeviceType[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static DoraPrivateProtocolService$BatteryDeviceType[] values() {
        return (DoraPrivateProtocolService$BatteryDeviceType[]) a.clone();
    }

    public static DoraPrivateProtocolService$BatteryDeviceType valueOf(String r1) {
        return (DoraPrivateProtocolService$BatteryDeviceType) r27.a.a(DoraPrivateProtocolService$BatteryDeviceType.class, r1);
    }

    public DoraPrivateProtocolService$BatteryDeviceType(String r1, int r2) {
        super(r1, r2);
    }
}
