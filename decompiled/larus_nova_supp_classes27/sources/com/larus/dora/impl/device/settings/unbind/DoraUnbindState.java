package com.larus.dora.impl.device.settings.unbind;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindState;", "", "<init>", "(Ljava/lang/String;I)V", "NO_DEVICE_CONNECTED", "SERVER_UNBIND_NETWORK_ERROR", "SERVER_UNBIND_FAILED", "SPP_DISCONNECT_FAILED", "UNBIND_SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraUnbindState extends Enum<DoraUnbindState> {
    public static final DoraUnbindState NO_DEVICE_CONNECTED = null;
    public static final DoraUnbindState SERVER_UNBIND_FAILED = null;
    public static final DoraUnbindState SERVER_UNBIND_NETWORK_ERROR = null;
    public static final DoraUnbindState SPP_DISCONNECT_FAILED = null;
    public static final DoraUnbindState UNBIND_SUCCESS = null;
    public static final /* synthetic */ DoraUnbindState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraUnbindState> getEntries() {
        return b;
    }

    static {
        DoraUnbindState r0 = new DoraUnbindState("NO_DEVICE_CONNECTED", 0);
        NO_DEVICE_CONNECTED = r0;
        DoraUnbindState r1 = new DoraUnbindState("SERVER_UNBIND_NETWORK_ERROR", 1);
        SERVER_UNBIND_NETWORK_ERROR = r1;
        DoraUnbindState r3 = new DoraUnbindState("SERVER_UNBIND_FAILED", 2);
        SERVER_UNBIND_FAILED = r3;
        DoraUnbindState r5 = new DoraUnbindState("SPP_DISCONNECT_FAILED", 3);
        SPP_DISCONNECT_FAILED = r5;
        DoraUnbindState r7 = new DoraUnbindState("UNBIND_SUCCESS", 4);
        UNBIND_SUCCESS = r7;
        DoraUnbindState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static DoraUnbindState[] values() {
        return (DoraUnbindState[]) a.clone();
    }

    public static DoraUnbindState valueOf(String r1) {
        return (DoraUnbindState) r27.a.a(DoraUnbindState.class, r1);
    }

    public DoraUnbindState(String r1, int r2) {
        super(r1, r2);
    }
}
