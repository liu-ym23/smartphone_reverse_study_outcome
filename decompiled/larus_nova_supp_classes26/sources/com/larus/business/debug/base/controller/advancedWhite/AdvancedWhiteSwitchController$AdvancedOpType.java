package com.larus.business.debug.base.controller.advancedWhite;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/business/debug/base/controller/advancedWhite/AdvancedWhiteSwitchController$AdvancedOpType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "OPEN", "CLOSE", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AdvancedWhiteSwitchController$AdvancedOpType extends Enum<AdvancedWhiteSwitchController$AdvancedOpType> {
    public static final AdvancedWhiteSwitchController$AdvancedOpType CLOSE = null;
    public static final AdvancedWhiteSwitchController$AdvancedOpType OPEN = null;
    public static final /* synthetic */ AdvancedWhiteSwitchController$AdvancedOpType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<AdvancedWhiteSwitchController$AdvancedOpType> getEntries() {
        return b;
    }

    static {
        AdvancedWhiteSwitchController$AdvancedOpType r0 = new AdvancedWhiteSwitchController$AdvancedOpType("OPEN", 0, 1);
        OPEN = r0;
        AdvancedWhiteSwitchController$AdvancedOpType r1 = new AdvancedWhiteSwitchController$AdvancedOpType("CLOSE", 1, 2);
        CLOSE = r1;
        AdvancedWhiteSwitchController$AdvancedOpType[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static AdvancedWhiteSwitchController$AdvancedOpType[] values() {
        return (AdvancedWhiteSwitchController$AdvancedOpType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static AdvancedWhiteSwitchController$AdvancedOpType valueOf(String r1) {
        return (AdvancedWhiteSwitchController$AdvancedOpType) a.a(AdvancedWhiteSwitchController$AdvancedOpType.class, r1);
    }

    public AdvancedWhiteSwitchController$AdvancedOpType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
