package com.larus.business.debug.base.register;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/business/debug/base/register/EntranceType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "BUTTON", "SWITCH", "SPINNER", "INPUT", "TEXT", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EntranceType extends Enum<EntranceType> {
    public static final EntranceType BUTTON = null;
    public static final EntranceType INPUT = null;
    public static final EntranceType SPINNER = null;
    public static final EntranceType SWITCH = null;
    public static final EntranceType TEXT = null;
    public static final /* synthetic */ EntranceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<EntranceType> getEntries() {
        return b;
    }

    static {
        EntranceType r0 = new EntranceType("BUTTON", 0, 0);
        BUTTON = r0;
        EntranceType r1 = new EntranceType("SWITCH", 1, 1);
        SWITCH = r1;
        EntranceType r3 = new EntranceType("SPINNER", 2, 2);
        SPINNER = r3;
        EntranceType r5 = new EntranceType("INPUT", 3, 3);
        INPUT = r5;
        EntranceType r7 = new EntranceType("TEXT", 4, 4);
        TEXT = r7;
        EntranceType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static EntranceType[] values() {
        return (EntranceType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static EntranceType valueOf(String r1) {
        return (EntranceType) a.a(EntranceType.class, r1);
    }

    public EntranceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
