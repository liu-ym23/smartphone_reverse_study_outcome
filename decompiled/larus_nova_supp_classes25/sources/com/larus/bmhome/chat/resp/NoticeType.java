package com.larus.bmhome.chat.resp;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/resp/NoticeType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Undefined", "FollowFriend", "FollowBot", "UserInfoReview", "BotReview", "GlobalActivity", "Activity", "ChatWithUgcBot", "LikeUgcBot", "ReportUser", "ReportConv", "LikeCreation", "CommentCreation", "ReplyCreationComment", "LikeCreationComment", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum NoticeType extends Enum<NoticeType> {
    public static final NoticeType Activity = null;
    public static final NoticeType BotReview = null;
    public static final NoticeType ChatWithUgcBot = null;
    public static final NoticeType CommentCreation = null;
    public static final NoticeType FollowBot = null;
    public static final NoticeType FollowFriend = null;
    public static final NoticeType GlobalActivity = null;
    public static final NoticeType LikeCreation = null;
    public static final NoticeType LikeCreationComment = null;
    public static final NoticeType LikeUgcBot = null;
    public static final NoticeType ReplyCreationComment = null;
    public static final NoticeType ReportConv = null;
    public static final NoticeType ReportUser = null;
    public static final NoticeType Undefined = null;
    public static final NoticeType UserInfoReview = null;
    public static final /* synthetic */ NoticeType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<NoticeType> getEntries() {
        return b;
    }

    static {
        NoticeType r0 = new NoticeType("Undefined", 0, 0);
        Undefined = r0;
        NoticeType r1 = new NoticeType("FollowFriend", 1, 1);
        FollowFriend = r1;
        NoticeType r3 = new NoticeType("FollowBot", 2, 2);
        FollowBot = r3;
        NoticeType r5 = new NoticeType("UserInfoReview", 3, 3);
        UserInfoReview = r5;
        NoticeType r7 = new NoticeType("BotReview", 4, 4);
        BotReview = r7;
        NoticeType r9 = new NoticeType("GlobalActivity", 5, 5);
        GlobalActivity = r9;
        NoticeType r11 = new NoticeType("Activity", 6, 6);
        Activity = r11;
        NoticeType r13 = new NoticeType("ChatWithUgcBot", 7, 7);
        ChatWithUgcBot = r13;
        NoticeType r15 = new NoticeType("LikeUgcBot", 8, 8);
        LikeUgcBot = r15;
        NoticeType r14 = new NoticeType("ReportUser", 9, 9);
        ReportUser = r14;
        NoticeType r12 = new NoticeType("ReportConv", 10, 10);
        ReportConv = r12;
        NoticeType r10 = new NoticeType("LikeCreation", 11, MessageCellStateTransformerType.DOWNLOAD_APP_ENTITY);
        LikeCreation = r10;
        NoticeType r6 = new NoticeType("CommentCreation", 12, DoraCallStateCode.DOUBAO_CMD_13);
        CommentCreation = r6;
        NoticeType r4 = new NoticeType("ReplyCreationComment", 13, DoraCallStateCode.DOUBAO_CMD_14);
        ReplyCreationComment = r4;
        NoticeType r2 = new NoticeType("LikeCreationComment", 14, DoraCallStateCode.DOUBAO_CMD_21);
        LikeCreationComment = r2;
        NoticeType[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r6, r4, r2};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static NoticeType[] values() {
        return (NoticeType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static NoticeType valueOf(String r1) {
        return (NoticeType) a.a(NoticeType.class, r1);
    }

    public NoticeType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
