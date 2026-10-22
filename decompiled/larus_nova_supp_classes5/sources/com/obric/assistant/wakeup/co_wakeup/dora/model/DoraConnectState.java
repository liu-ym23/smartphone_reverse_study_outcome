package com.obric.assistant.wakeup.co_wakeup.dora.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraConnectState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "NOT_CONNECTED", "CONNECTED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraConnectState extends Enum<DoraConnectState> {
    public static final DoraConnectState CONNECTED = null;
    public static final DoraConnectState NA = null;
    public static final DoraConnectState NOT_CONNECTED = null;
    public static final /* synthetic */ DoraConnectState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraConnectState> getEntries() {
        return b;
    }

    static {
        DoraConnectState r0 = new DoraConnectState("NA", 0);
        NA = r0;
        DoraConnectState r1 = new DoraConnectState("NOT_CONNECTED", 1);
        NOT_CONNECTED = r1;
        DoraConnectState r3 = new DoraConnectState("CONNECTED", 2);
        CONNECTED = r3;
        DoraConnectState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DoraConnectState[] values() {
        return (DoraConnectState[]) a.clone();
    }

    public static DoraConnectState valueOf(String r1) {
        return (DoraConnectState) a.a(DoraConnectState.class, r1);
    }

    public DoraConnectState(String r1, int r2) {
        super(r1, r2);
    }
}
