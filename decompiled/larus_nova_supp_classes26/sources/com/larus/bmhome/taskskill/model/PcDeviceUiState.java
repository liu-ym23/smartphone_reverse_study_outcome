package com.larus.bmhome.taskskill.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/taskskill/model/PcDeviceUiState;", "", "<init>", "(Ljava/lang/String;I)V", "AUTHORIZED_AVAILABLE", "UNAUTHORIZED_AVAILABLE", "OFFLINE", "NEED_UPGRADE", "CONTROL_DISABLED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PcDeviceUiState extends Enum<PcDeviceUiState> {
    public static final PcDeviceUiState AUTHORIZED_AVAILABLE = null;
    public static final PcDeviceUiState CONTROL_DISABLED = null;
    public static final PcDeviceUiState NEED_UPGRADE = null;
    public static final PcDeviceUiState OFFLINE = null;
    public static final PcDeviceUiState UNAUTHORIZED_AVAILABLE = null;
    public static final /* synthetic */ PcDeviceUiState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PcDeviceUiState> getEntries() {
        return b;
    }

    static {
        PcDeviceUiState r0 = new PcDeviceUiState("AUTHORIZED_AVAILABLE", 0);
        AUTHORIZED_AVAILABLE = r0;
        PcDeviceUiState r1 = new PcDeviceUiState("UNAUTHORIZED_AVAILABLE", 1);
        UNAUTHORIZED_AVAILABLE = r1;
        PcDeviceUiState r3 = new PcDeviceUiState("OFFLINE", 2);
        OFFLINE = r3;
        PcDeviceUiState r5 = new PcDeviceUiState("NEED_UPGRADE", 3);
        NEED_UPGRADE = r5;
        PcDeviceUiState r7 = new PcDeviceUiState("CONTROL_DISABLED", 4);
        CONTROL_DISABLED = r7;
        PcDeviceUiState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static PcDeviceUiState[] values() {
        return (PcDeviceUiState[]) a.clone();
    }

    public static PcDeviceUiState valueOf(String r1) {
        return (PcDeviceUiState) r27.a.a(PcDeviceUiState.class, r1);
    }

    public PcDeviceUiState(String r1, int r2) {
        super(r1, r2);
    }
}
