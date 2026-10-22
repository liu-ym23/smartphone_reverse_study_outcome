package com.ss.android.lark.chat.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/TeamChatType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEFAULT", "PUBLIC", "PRIVATE", "OPEN", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TeamChatType extends Enum<TeamChatType> {
    public static final a Companion = null;
    public static final TeamChatType DEFAULT = null;
    public static final TeamChatType OPEN = null;
    public static final TeamChatType PRIVATE = null;
    public static final TeamChatType PUBLIC = null;
    public static final TeamChatType UNKNOWN = null;
    public static final /* synthetic */ TeamChatType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static TeamChatType a(int r2) {
            TeamChatType r0 = TeamChatType.DEFAULT;
            if (r2 == r0.getValue()) goto L16;
            TeamChatType r1 = TeamChatType.PUBLIC;
            if (r2 == r1.getValue()) goto L17;
            TeamChatType r3 = TeamChatType.PRIVATE;
            if (r2 == r3.getValue()) goto L18;
            TeamChatType r4 = TeamChatType.OPEN;
            if (r2 != r4.getValue()) goto L15;
            return r4;
        L15:
            return TeamChatType.UNKNOWN;
        L18:
            return r3;
        L17:
            return r1;
        L16:
            return r0;
        }
    }

    @JvmStatic
    public static final TeamChatType fromValue(int r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static EnumEntries<TeamChatType> getEntries() {
        return b;
    }

    static {
        TeamChatType r0 = new TeamChatType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        TeamChatType r1 = new TeamChatType("DEFAULT", 1, 1);
        DEFAULT = r1;
        TeamChatType r3 = new TeamChatType("PUBLIC", 2, 2);
        PUBLIC = r3;
        TeamChatType r5 = new TeamChatType("PRIVATE", 3, 3);
        PRIVATE = r5;
        TeamChatType r7 = new TeamChatType("OPEN", 4, 4);
        OPEN = r7;
        TeamChatType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static TeamChatType[] values() {
        return (TeamChatType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TeamChatType valueOf(String r1) {
        return (TeamChatType) r27.a.a(TeamChatType.class, r1);
    }

    public TeamChatType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
