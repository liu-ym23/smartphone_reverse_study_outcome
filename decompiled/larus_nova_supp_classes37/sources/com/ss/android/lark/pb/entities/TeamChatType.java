package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum TeamChatType extends Enum<TeamChatType> implements WireEnum {
    private static final /* synthetic */ TeamChatType[] $VALUES = null;
    public static final ProtoAdapter<TeamChatType> ADAPTER = null;
    public static final TeamChatType TEAM_CHAT_TYPE_DEFAULT = null;
    public static final TeamChatType TEAM_CHAT_TYPE_OPEN = null;
    public static final TeamChatType TEAM_CHAT_TYPE_PRIVATE = null;
    public static final TeamChatType TEAM_CHAT_TYPE_PUBLIC = null;
    public static final TeamChatType TEAM_CHAT_TYPE_UNKNOWN = null;
    private final int value;

    static {
        TeamChatType r0 = new TeamChatType("TEAM_CHAT_TYPE_UNKNOWN", 0, 0);
        TEAM_CHAT_TYPE_UNKNOWN = r0;
        TeamChatType r1 = new TeamChatType("TEAM_CHAT_TYPE_DEFAULT", 1, 1);
        TEAM_CHAT_TYPE_DEFAULT = r1;
        TeamChatType r3 = new TeamChatType("TEAM_CHAT_TYPE_PUBLIC", 2, 2);
        TEAM_CHAT_TYPE_PUBLIC = r3;
        TeamChatType r5 = new TeamChatType("TEAM_CHAT_TYPE_PRIVATE", 3, 3);
        TEAM_CHAT_TYPE_PRIVATE = r5;
        TeamChatType r7 = new TeamChatType("TEAM_CHAT_TYPE_OPEN", 4, 4);
        TEAM_CHAT_TYPE_OPEN = r7;
        $VALUES = new TeamChatType[]{r0, r1, r3, r5, r7};
        ADAPTER = ProtoAdapter.newEnumAdapter(TeamChatType.class);
    }

    public static TeamChatType[] values() {
        return (TeamChatType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TeamChatType fromValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return TEAM_CHAT_TYPE_OPEN;
    L16:
        return TEAM_CHAT_TYPE_PRIVATE;
    L18:
        return TEAM_CHAT_TYPE_PUBLIC;
    L20:
        return TEAM_CHAT_TYPE_DEFAULT;
    L22:
        return TEAM_CHAT_TYPE_UNKNOWN;
    }

    public static TeamChatType valueOf(String r1) {
        return (TeamChatType) a.a(TeamChatType.class, r1);
    }

    private TeamChatType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
