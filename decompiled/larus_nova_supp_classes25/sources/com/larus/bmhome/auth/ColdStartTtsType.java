package com.larus.bmhome.auth;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/auth/ColdStartTtsType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "INVALID", "ENABLED", "DISABLED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ColdStartTtsType extends Enum<ColdStartTtsType> {
    public static final ColdStartTtsType DISABLED = null;
    public static final ColdStartTtsType ENABLED = null;
    public static final ColdStartTtsType INVALID = null;
    public static final /* synthetic */ ColdStartTtsType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<ColdStartTtsType> getEntries() {
        return b;
    }

    static {
        ColdStartTtsType r0 = new ColdStartTtsType("INVALID", 0, 0);
        INVALID = r0;
        ColdStartTtsType r1 = new ColdStartTtsType("ENABLED", 1, 1);
        ENABLED = r1;
        ColdStartTtsType r3 = new ColdStartTtsType("DISABLED", 2, 2);
        DISABLED = r3;
        ColdStartTtsType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ColdStartTtsType[] values() {
        return (ColdStartTtsType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static ColdStartTtsType valueOf(String r1) {
        return (ColdStartTtsType) a.a(ColdStartTtsType.class, r1);
    }

    public ColdStartTtsType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
