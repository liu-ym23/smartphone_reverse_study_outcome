package com.larus.bmhome.instruction.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/instruction/core/model/ActiveSwitchType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEEPTHINK", "NETSEARCH", "VOICEINPUT", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActiveSwitchType extends Enum<ActiveSwitchType> {
    public static final ActiveSwitchType DEEPTHINK = null;
    public static final ActiveSwitchType NETSEARCH = null;
    public static final ActiveSwitchType UNKNOWN = null;
    public static final ActiveSwitchType VOICEINPUT = null;
    public static final /* synthetic */ ActiveSwitchType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ActiveSwitchType> getEntries() {
        return b;
    }

    static {
        ActiveSwitchType r0 = new ActiveSwitchType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        ActiveSwitchType r1 = new ActiveSwitchType("DEEPTHINK", 1, 1);
        DEEPTHINK = r1;
        ActiveSwitchType r3 = new ActiveSwitchType("NETSEARCH", 2, 2);
        NETSEARCH = r3;
        ActiveSwitchType r5 = new ActiveSwitchType("VOICEINPUT", 3, 4);
        VOICEINPUT = r5;
        ActiveSwitchType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ActiveSwitchType[] values() {
        return (ActiveSwitchType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ActiveSwitchType valueOf(String r1) {
        return (ActiveSwitchType) a.a(ActiveSwitchType.class, r1);
    }

    public ActiveSwitchType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
