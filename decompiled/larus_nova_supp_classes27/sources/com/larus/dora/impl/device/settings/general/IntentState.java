package com.larus.dora.impl.device.settings.general;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/impl/device/settings/general/IntentState;", "", "<init>", "(Ljava/lang/String;I)V", "ACTION_NO_DEVICE_CONNECTED", "ACTION_SERVER_UNBIND_NETWORK_ERROR", "ACTION_SERVER_UNBIND_FAILED", "ACTION_SPP_DISCONNECT_FAILED", "ACTION_UNBIND_SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IntentState extends Enum<IntentState> {
    public static final IntentState ACTION_NO_DEVICE_CONNECTED = null;
    public static final IntentState ACTION_SERVER_UNBIND_FAILED = null;
    public static final IntentState ACTION_SERVER_UNBIND_NETWORK_ERROR = null;
    public static final IntentState ACTION_SPP_DISCONNECT_FAILED = null;
    public static final IntentState ACTION_UNBIND_SUCCESS = null;
    public static final /* synthetic */ IntentState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<IntentState> getEntries() {
        return b;
    }

    static {
        IntentState r0 = new IntentState("ACTION_NO_DEVICE_CONNECTED", 0);
        ACTION_NO_DEVICE_CONNECTED = r0;
        IntentState r1 = new IntentState("ACTION_SERVER_UNBIND_NETWORK_ERROR", 1);
        ACTION_SERVER_UNBIND_NETWORK_ERROR = r1;
        IntentState r3 = new IntentState("ACTION_SERVER_UNBIND_FAILED", 2);
        ACTION_SERVER_UNBIND_FAILED = r3;
        IntentState r5 = new IntentState("ACTION_SPP_DISCONNECT_FAILED", 3);
        ACTION_SPP_DISCONNECT_FAILED = r5;
        IntentState r7 = new IntentState("ACTION_UNBIND_SUCCESS", 4);
        ACTION_UNBIND_SUCCESS = r7;
        IntentState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static IntentState[] values() {
        return (IntentState[]) a.clone();
    }

    public static IntentState valueOf(String r1) {
        return (IntentState) r27.a.a(IntentState.class, r1);
    }

    public IntentState(String r1, int r2) {
        super(r1, r2);
    }
}
