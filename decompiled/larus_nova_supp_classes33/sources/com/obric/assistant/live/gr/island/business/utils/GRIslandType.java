package com.obric.assistant.live.gr.island.business.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/live/gr/island/business/utils/GRIslandType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COMPLEX_TASK", "REALTIME_CALL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GRIslandType extends Enum<GRIslandType> {
    public static final GRIslandType COMPLEX_TASK = null;
    public static final GRIslandType REALTIME_CALL = null;
    public static final /* synthetic */ GRIslandType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<GRIslandType> getEntries() {
        return b;
    }

    static {
        GRIslandType r0 = new GRIslandType("COMPLEX_TASK", 0, "complex_task");
        COMPLEX_TASK = r0;
        GRIslandType r1 = new GRIslandType("REALTIME_CALL", 1, "realtime_call");
        REALTIME_CALL = r1;
        GRIslandType[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static GRIslandType[] values() {
        return (GRIslandType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static GRIslandType valueOf(String r1) {
        return (GRIslandType) a.a(GRIslandType.class, r1);
    }

    public GRIslandType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
