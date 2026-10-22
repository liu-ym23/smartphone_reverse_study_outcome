package com.obric.assistant.wakeup.co_wakeup.dora.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraWearState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "ON", "OFF", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraWearState extends Enum<DoraWearState> {
    public static final DoraWearState NA = null;
    public static final DoraWearState OFF = null;
    public static final DoraWearState ON = null;
    public static final /* synthetic */ DoraWearState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraWearState> getEntries() {
        return b;
    }

    static {
        DoraWearState r0 = new DoraWearState("NA", 0);
        NA = r0;
        DoraWearState r1 = new DoraWearState("ON", 1);
        ON = r1;
        DoraWearState r3 = new DoraWearState("OFF", 2);
        OFF = r3;
        DoraWearState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DoraWearState[] values() {
        return (DoraWearState[]) a.clone();
    }

    public static DoraWearState valueOf(String r1) {
        return (DoraWearState) a.a(DoraWearState.class, r1);
    }

    public DoraWearState(String r1, int r2) {
        super(r1, r2);
    }
}
