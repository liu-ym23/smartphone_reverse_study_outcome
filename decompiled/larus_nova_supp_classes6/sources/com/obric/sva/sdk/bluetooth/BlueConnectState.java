package com.obric.sva.sdk.bluetooth;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/sva/sdk/bluetooth/BlueConnectState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "CONNECTED", "DISCONNECTED", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum BlueConnectState extends Enum<BlueConnectState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BlueConnectState[] $VALUES = null;
    public static final BlueConnectState CONNECTED = null;
    public static final BlueConnectState DISCONNECTED = null;
    public static final BlueConnectState NA = null;

    private static final /* synthetic */ BlueConnectState[] $values() {
        return new BlueConnectState[]{NA, CONNECTED, DISCONNECTED};
    }

    public static EnumEntries<BlueConnectState> getEntries() {
        return $ENTRIES;
    }

    static {
        NA = new BlueConnectState("NA", 0);
        CONNECTED = new BlueConnectState("CONNECTED", 1);
        DISCONNECTED = new BlueConnectState("DISCONNECTED", 2);
        BlueConnectState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static BlueConnectState[] values() {
        return (BlueConnectState[]) $VALUES.clone();
    }

    public static BlueConnectState valueOf(String r1) {
        return (BlueConnectState) r27.a.a(BlueConnectState.class, r1);
    }

    private BlueConnectState(String r1, int r2) {
        super(r1, r2);
    }
}
