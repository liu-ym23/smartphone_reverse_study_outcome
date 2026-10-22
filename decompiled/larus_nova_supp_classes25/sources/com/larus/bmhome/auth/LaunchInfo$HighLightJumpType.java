package com.larus.bmhome.auth;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/auth/LaunchInfo$HighLightJumpType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "Unknown", "Wiki", "MESSAGE_SEARCH", "MESSAGE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum LaunchInfo$HighLightJumpType extends Enum<LaunchInfo$HighLightJumpType> {
    public static final LaunchInfo$HighLightJumpType MESSAGE = null;
    public static final LaunchInfo$HighLightJumpType MESSAGE_SEARCH = null;
    public static final LaunchInfo$HighLightJumpType Unknown = null;
    public static final LaunchInfo$HighLightJumpType Wiki = null;
    public static final /* synthetic */ LaunchInfo$HighLightJumpType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<LaunchInfo$HighLightJumpType> getEntries() {
        return b;
    }

    static {
        LaunchInfo$HighLightJumpType r0 = new LaunchInfo$HighLightJumpType("Unknown", 0, "");
        Unknown = r0;
        LaunchInfo$HighLightJumpType r1 = new LaunchInfo$HighLightJumpType("Wiki", 1, "wiki");
        Wiki = r1;
        LaunchInfo$HighLightJumpType r2 = new LaunchInfo$HighLightJumpType("MESSAGE_SEARCH", 2, "msg_search");
        MESSAGE_SEARCH = r2;
        LaunchInfo$HighLightJumpType r4 = new LaunchInfo$HighLightJumpType("MESSAGE", 3, "msg");
        MESSAGE = r4;
        LaunchInfo$HighLightJumpType[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static LaunchInfo$HighLightJumpType[] values() {
        return (LaunchInfo$HighLightJumpType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static LaunchInfo$HighLightJumpType valueOf(String r1) {
        return (LaunchInfo$HighLightJumpType) a.a(LaunchInfo$HighLightJumpType.class, r1);
    }

    public LaunchInfo$HighLightJumpType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
