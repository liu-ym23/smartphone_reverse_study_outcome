package com.larus.bmhome.instruction.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/instruction/core/model/ActionBarDisplayType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "SWITCH", "MENU", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionBarDisplayType extends Enum<ActionBarDisplayType> {
    public static final ActionBarDisplayType MENU = null;
    public static final ActionBarDisplayType NORMAL = null;
    public static final ActionBarDisplayType SWITCH = null;
    public static final /* synthetic */ ActionBarDisplayType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ActionBarDisplayType> getEntries() {
        return b;
    }

    static {
        ActionBarDisplayType r0 = new ActionBarDisplayType("NORMAL", 0, 0);
        NORMAL = r0;
        ActionBarDisplayType r1 = new ActionBarDisplayType("SWITCH", 1, 1);
        SWITCH = r1;
        ActionBarDisplayType r3 = new ActionBarDisplayType("MENU", 2, 2);
        MENU = r3;
        ActionBarDisplayType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ActionBarDisplayType[] values() {
        return (ActionBarDisplayType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ActionBarDisplayType valueOf(String r1) {
        return (ActionBarDisplayType) a.a(ActionBarDisplayType.class, r1);
    }

    public ActionBarDisplayType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
