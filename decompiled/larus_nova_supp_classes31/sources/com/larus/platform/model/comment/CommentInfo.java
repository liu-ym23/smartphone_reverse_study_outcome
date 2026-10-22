package com.larus.platform.model.comment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 P2\u00020\u0001:\u0001PBÁ\u0001\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u0001`\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J!\u00105\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u0001`\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010<\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010+J\u0013\u0010A\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0017HÆ\u0003JÈ\u0001\u0010B\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u0001`\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010CJ\u0006\u0010D\u001a\u00020\rJ\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020\rHÖ\u0001J\t\u0010J\u001a\u00020\u0006HÖ\u0001J\u0016\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\rR.\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b2\u0010+R \u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006Q"}, d2 = {"Lcom/larus/platform/model/comment/CommentInfo;", "Landroid/os/Parcelable;", "childrenList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "parentId", "", "replyToId", "repliedCommentUserInfo", "Lcom/larus/platform/model/comment/UserInfo;", "commentId", "clientCommentId", "status", "", "content", "Lcom/larus/platform/model/comment/CommentContent;", "createTime", "", "creatorUserInfo", "likeInfo", "Lcom/larus/platform/model/comment/LikeInfo;", "replyCount", "tagList", "", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/comment/UserInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/platform/model/comment/CommentContent;Ljava/lang/Long;Lcom/larus/platform/model/comment/UserInfo;Lcom/larus/platform/model/comment/LikeInfo;Ljava/lang/Long;Ljava/util/List;)V", "getChildrenList", "()Ljava/util/ArrayList;", "getParentId", "()Ljava/lang/String;", "getReplyToId", "getRepliedCommentUserInfo", "()Lcom/larus/platform/model/comment/UserInfo;", "getCommentId", "getClientCommentId", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContent", "()Lcom/larus/platform/model/comment/CommentContent;", "getCreateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreatorUserInfo", "getLikeInfo", "()Lcom/larus/platform/model/comment/LikeInfo;", "setLikeInfo", "(Lcom/larus/platform/model/comment/LikeInfo;)V", "getReplyCount", "getTagList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/comment/UserInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/platform/model/comment/CommentContent;Ljava/lang/Long;Lcom/larus/platform/model/comment/UserInfo;Lcom/larus/platform/model/comment/LikeInfo;Ljava/lang/Long;Ljava/util/List;)Lcom/larus/platform/model/comment/CommentInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CommentInfo implements Parcelable {
    public static final Parcelable.Creator<CommentInfo> CREATOR = null;

    @SerializedName("reply_list")
    private final ArrayList<CommentInfo> childrenList;

    @SerializedName("client_comment_id")
    private final String clientCommentId;

    @SerializedName("comment_id")
    private final String commentId;

    @SerializedName("content")
    private final CommentContent content;

    @SerializedName("create_time")
    private final Long createTime;

    @SerializedName("creator_info")
    private final UserInfo creatorUserInfo;

    @SerializedName("like_info")
    private LikeInfo likeInfo;

    @SerializedName("parent_id")
    private final String parentId;

    @SerializedName("reply_to_user_info")
    private final UserInfo repliedCommentUserInfo;

    @SerializedName("reply_count")
    private final Long replyCount;

    @SerializedName("reply_to_id")
    private final String replyToId;

    @SerializedName("status")
    private Integer status;

    @SerializedName("tag_list")
    private final List<Integer> tagList;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<CommentInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommentInfo createFromParcel(Parcel r21) {
            Intrinsics.checkNotNullParameter(r21, "parcel");
            int r2 = 0;
            if (r21.readInt() != 0) goto L5;
            ArrayList r7 = null;
        L13:
            String r8 = r21.readString();
            String r9 = r21.readString();
            if (r21.readInt() != 0) goto L16;
            UserInfo r1 = null;
        L17:
            UserInfo r10 = r1;
            String r11 = r21.readString();
            String r12 = r21.readString();
            if (r21.readInt() != 0) goto L20;
            Integer r13 = null;
        L22:
            if (r21.readInt() != 0) goto L24;
            CommentContent r3 = null;
        L25:
            CommentContent r14 = r3;
            if (r21.readInt() != 0) goto L28;
            Long r15 = null;
        L30:
            if (r21.readInt() != 0) goto L32;
            UserInfo r4 = null;
        L33:
            UserInfo r16 = r4;
            if (r21.readInt() != 0) goto L36;
            LikeInfo r5 = null;
        L37:
            LikeInfo r17 = r5;
            if (r21.readInt() != 0) goto L40;
            Long r18 = null;
        L42:
            if (r21.readInt() != 0) goto L44;
            ArrayList r19 = null;
        L53:
            return new CommentInfo(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        L44:
            int r6 = r21.readInt();
            ArrayList r20 = new ArrayList(r6);
        L45:
            if (r2 == r6) goto L51;
            if (r21.readInt() != 0) goto L49;
            Integer r22 = null;
        L50:
            r20.add(r22);
            r2 = r2 + 1;
            goto L45
        L49:
            r22 = Integer.valueOf(r21.readInt());
            goto L50
        L51:
            r19 = r20;
            goto L53
        L40:
            r18 = Long.valueOf(r21.readLong());
            goto L42
        L36:
            r5 = LikeInfo.CREATOR.createFromParcel(r21);
            goto L37
        L32:
            r4 = UserInfo.CREATOR.createFromParcel(r21);
            goto L33
        L28:
            r15 = Long.valueOf(r21.readLong());
            goto L30
        L24:
            r3 = CommentContent.CREATOR.createFromParcel(r21);
            goto L25
        L20:
            r13 = Integer.valueOf(r21.readInt());
            goto L22
        L16:
            r1 = UserInfo.CREATOR.createFromParcel(r21);
            goto L17
        L5:
            int r23 = r21.readInt();
            ArrayList r24 = new ArrayList(r23);
            int r25 = 0;
        L6:
            if (r25 == r23) goto L12;
            if (r21.readInt() != 0) goto L10;
            CommentInfo r26 = null;
        L11:
            r24.add(r26);
            r25 = r25 + 1;
            goto L6
        L10:
            r26 = CommentInfo.CREATOR.createFromParcel(r21);
            goto L11
        L12:
            r7 = r24;
            goto L13
        }

        @Override // android.os.Parcelable.Creator
        public final CommentInfo[] newArray(int r1) {
            return new CommentInfo[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    public CommentInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, 8191);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CommentInfo) == true) goto L8;
        return false;
    L8:
        CommentInfo r6 = (CommentInfo) r5;
        if (Intrinsics.areEqual(this.childrenList, r6.childrenList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parentId, r6.parentId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.replyToId, r6.replyToId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.repliedCommentUserInfo, r6.repliedCommentUserInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.commentId, r6.commentId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.clientCommentId, r6.clientCommentId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.creatorUserInfo, r6.creatorUserInfo) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.likeInfo, r6.likeInfo) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.replyCount, r6.replyCount) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.tagList, r6.tagList) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        ArrayList<CommentInfo> r0 = this.childrenList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.parentId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.replyToId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        UserInfo r10 = this.repliedCommentUserInfo;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.commentId;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.clientCommentId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.status;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        CommentContent r22 = this.content;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.createTime;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        UserInfo r28 = this.creatorUserInfo;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        LikeInfo r31 = this.likeInfo;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Long r34 = this.replyCount;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        List<Integer> r37 = this.tagList;
        if (r37 == null) goto L55;
        r1 = r37.hashCode();
    L55:
        return r36 + r1;
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommentInfo(childrenList=" + this.childrenList + ", parentId=" + this.parentId + ", replyToId=" + this.replyToId + ", repliedCommentUserInfo=" + this.repliedCommentUserInfo + ", commentId=" + this.commentId + ", clientCommentId=" + this.clientCommentId + ", status=" + this.status + ", content=" + this.content + ", createTime=" + this.createTime + ", creatorUserInfo=" + this.creatorUserInfo + ", likeInfo=" + this.likeInfo + ", replyCount=" + this.replyCount + ", tagList=" + this.tagList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        ArrayList<CommentInfo> r0 = this.childrenList;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L12:
        r6.writeString(this.parentId);
        r6.writeString(this.replyToId);
        UserInfo r1 = this.repliedCommentUserInfo;
        if (r1 != null) goto L15;
        r6.writeInt(0);
    L16:
        r6.writeString(this.commentId);
        r6.writeString(this.clientCommentId);
        Integer r2 = this.status;
        if (r2 != null) goto L19;
        r6.writeInt(0);
    L20:
        CommentContent r3 = this.content;
        if (r3 != null) goto L23;
        r6.writeInt(0);
    L24:
        Long r4 = this.createTime;
        if (r4 != null) goto L27;
        r6.writeInt(0);
    L28:
        UserInfo r5 = this.creatorUserInfo;
        if (r5 != null) goto L31;
        r6.writeInt(0);
    L32:
        LikeInfo r8 = this.likeInfo;
        if (r8 != null) goto L35;
        r6.writeInt(0);
    L36:
        Long r9 = this.replyCount;
        if (r9 != null) goto L39;
        r6.writeInt(0);
    L40:
        List<Integer> r10 = this.tagList;
        if (r10 != null) goto L43;
        r6.writeInt(0);
        return;
    L43:
        r6.writeInt(1);
        r6.writeInt(r10.size());
        Iterator<Integer> r11 = r10.iterator();
    L45:
        if (r11.hasNext() == false) goto L63;
        Integer r12 = r11.next();
        if (r12 == null) goto L48;
        r6.writeInt(1);
        r6.writeInt(r12.intValue());
        goto L45
    L48:
        r6.writeInt(0);
        goto L45
    L63:
        return;
    L39:
        r6.writeInt(1);
        r6.writeLong(r9.longValue());
        goto L40
    L35:
        r6.writeInt(1);
        r8.writeToParcel(r6, r7);
        goto L36
    L31:
        r6.writeInt(1);
        r5.writeToParcel(r6, r7);
        goto L32
    L27:
        r6.writeInt(1);
        r6.writeLong(r4.longValue());
        goto L28
    L23:
        r6.writeInt(1);
        r3.writeToParcel(r6, r7);
        goto L24
    L19:
        r6.writeInt(1);
        r6.writeInt(r2.intValue());
        goto L20
    L15:
        r6.writeInt(1);
        r1.writeToParcel(r6, r7);
        goto L16
    L5:
        r6.writeInt(1);
        r6.writeInt(r0.size());
        Iterator<CommentInfo> r13 = r0.iterator();
    L7:
        if (r13.hasNext() == false) goto L12;
        CommentInfo r14 = r13.next();
        if (r14 == null) goto L10;
        r6.writeInt(1);
        r14.writeToParcel(r6, r7);
        goto L7
    L10:
        r6.writeInt(0);
        goto L7
    }

    public final ArrayList<CommentInfo> b() {
        return this.childrenList;
    }

    public final String c() {
        return this.clientCommentId;
    }

    public final String d() {
        return this.commentId;
    }

    public final CommentContent e() {
        return this.content;
    }

    public final Long g() {
        return this.createTime;
    }

    public final UserInfo h() {
        return this.creatorUserInfo;
    }

    public final LikeInfo i() {
        return this.likeInfo;
    }

    public final String j() {
        return this.parentId;
    }

    public final UserInfo k() {
        return this.repliedCommentUserInfo;
    }

    public final Long o() {
        return this.replyCount;
    }

    public final String q() {
        return this.replyToId;
    }

    public final List<Integer> r() {
        return this.tagList;
    }

    public final void s(LikeInfo r1) {
        this.likeInfo = r1;
    }

    public static CommentInfo a(CommentInfo r14, String r15) {
        return new CommentInfo(r14.childrenList, r14.parentId, r14.replyToId, r14.repliedCommentUserInfo, r15, r14.clientCommentId, r14.status, r14.content, r14.createTime, r14.creatorUserInfo, r14.likeInfo, r14.replyCount, r14.tagList);
    }

    public /* synthetic */ CommentInfo(String r17, String r18, UserInfo r19, String r20, String r21, CommentContent r22, Long r23, UserInfo r24, LikeInfo r25, Long r26, List r27, int r28) {
        String r3 = "";
        if ((r28 & 2) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r28 & 4) != 0) goto L11;
        r3 = r18;
    L11:
        if ((r28 & 8) == 0) goto L13;
        UserInfo r4 = null;
    L15:
        if ((r28 & 16) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r28 & 32) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r28 & 64) == 0) goto L25;
        Integer r8 = 0;
    L27:
        if ((r28 & 128) == 0) goto L29;
        CommentContent r9 = null;
    L31:
        if ((r28 & 256) == 0) goto L33;
        Long r10 = 0L;
    L35:
        if ((r28 & 512) == 0) goto L37;
        UserInfo r13 = null;
    L39:
        if ((r28 & 1024) == 0) goto L41;
        LikeInfo r14 = null;
    L43:
        if ((r28 & 2048) == 0) goto L45;
        Long r12 = 0L;
    L47:
        if ((r28 & 4096) == 0) goto L49;
        List r15 = CollectionsKt.emptyList();
    L50:
        this(null, r2, r3, r4, r6, r7, r8, r9, r10, r13, r14, r12, r15);
        return;
    L49:
        r15 = r27;
        goto L50
    L45:
        r12 = r26;
        goto L47
    L41:
        r14 = r25;
        goto L43
    L37:
        r13 = r24;
        goto L39
    L33:
        r10 = r23;
        goto L35
    L29:
        r9 = r22;
        goto L31
    L25:
        r8 = null;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L5:
        r2 = r17;
        goto L7
    }

    public CommentInfo(ArrayList<CommentInfo> r1, String r2, String r3, UserInfo r4, String r5, String r6, @CommentStatus Integer r7, CommentContent r8, Long r9, UserInfo r10, LikeInfo r11, Long r12, List<Integer> r13) {
        this.childrenList = r1;
        this.parentId = r2;
        this.replyToId = r3;
        this.repliedCommentUserInfo = r4;
        this.commentId = r5;
        this.clientCommentId = r6;
        this.status = r7;
        this.content = r8;
        this.createTime = r9;
        this.creatorUserInfo = r10;
        this.likeInfo = r11;
        this.replyCount = r12;
        this.tagList = r13;
    }
}
