package com.larus.platform.model.comment.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.comment.CommentInfo;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001cJp\u0010%\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020(J\u0013\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020(HÖ\u0001J\t\u0010-\u001a\u00020\tHÖ\u0001J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020(R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c¨\u00063"}, d2 = {"Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;", "Landroid/os/Parcelable;", "replies", "", "Lcom/larus/platform/model/comment/CommentInfo;", "comments", "hasMore", "", "nextOffsetToken", "", "additionalToast", "totalCount", "", "fromCache", "<init>", "(Ljava/util/List;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getReplies", "()Ljava/util/List;", "getComments", "getHasMore", "()Z", "getNextOffsetToken", "()Ljava/lang/String;", "getAdditionalToast", "getTotalCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFromCache", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CommentHttpApi$GetCommentListData implements Parcelable {
    public static final Parcelable.Creator<CommentHttpApi$GetCommentListData> CREATOR = null;
    public final transient Boolean a;

    @SerializedName("toast")
    private final String additionalToast;

    @SerializedName("comments")
    private final List<CommentInfo> comments;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("next_offset_token")
    private final String nextOffsetToken;

    @SerializedName("replies")
    private final List<CommentInfo> replies;

    @SerializedName("total_count")
    private final Long totalCount;

    public static final class a implements Parcelable.Creator<CommentHttpApi$GetCommentListData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommentHttpApi$GetCommentListData createFromParcel(Parcel r14) {
            Intrinsics.checkNotNullParameter(r14, "parcel");
            boolean r1 = false;
            Boolean r2 = null;
            if (r14.readInt() != 0) goto L5;
            ArrayList r6 = null;
        L14:
            if (r14.readInt() != 0) goto L16;
            ArrayList r7 = null;
        L25:
            if (r14.readInt() == 0) goto L27;
            boolean r8 = true;
        L28:
            String r9 = r14.readString();
            String r10 = r14.readString();
            if (r14.readInt() != 0) goto L31;
            Long r11 = null;
        L33:
            if (r14.readInt() != 0) goto L36;
        L40:
            return new CommentHttpApi$GetCommentListData(r6, r7, r8, r9, r10, r11, r2);
        L36:
            if (r14.readInt() == 0) goto L38;
            r1 = true;
        L38:
            r2 = Boolean.valueOf(r1);
            goto L40
        L31:
            r11 = Long.valueOf(r14.readLong());
            goto L33
        L27:
            r8 = false;
            goto L28
        L16:
            int r0 = r14.readInt();
            ArrayList r3 = new ArrayList(r0);
            int r4 = 0;
        L17:
            if (r4 == r0) goto L23;
            if (r14.readInt() != 0) goto L21;
            CommentInfo r5 = null;
        L22:
            r3.add(r5);
            r4 = r4 + 1;
            goto L17
        L21:
            r5 = CommentInfo.CREATOR.createFromParcel(r14);
            goto L22
        L23:
            r7 = r3;
            goto L25
        L5:
            int r12 = r14.readInt();
            ArrayList r13 = new ArrayList(r12);
            int r15 = 0;
        L6:
            if (r15 == r12) goto L12;
            if (r14.readInt() != 0) goto L10;
            CommentInfo r16 = null;
        L11:
            r13.add(r16);
            r15 = r15 + 1;
            goto L6
        L10:
            r16 = CommentInfo.CREATOR.createFromParcel(r14);
            goto L11
        L12:
            r6 = r13;
            goto L14
        }

        @Override // android.os.Parcelable.Creator
        public final CommentHttpApi$GetCommentListData[] newArray(int r1) {
            return new CommentHttpApi$GetCommentListData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CommentHttpApi$GetCommentListData() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CommentHttpApi$GetCommentListData) == true) goto L8;
        return false;
    L8:
        CommentHttpApi$GetCommentListData r6 = (CommentHttpApi$GetCommentListData) r5;
        if (Intrinsics.areEqual(this.replies, r6.replies) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.comments, r6.comments) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r6.hasMore) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nextOffsetToken, r6.nextOffsetToken) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.additionalToast, r6.additionalToast) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.totalCount, r6.totalCount) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        List<CommentInfo> r0 = this.replies;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<CommentInfo> r4 = this.comments;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.hasMore == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        String r9 = this.nextOffsetToken;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        String r12 = this.additionalToast;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        Long r15 = this.totalCount;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        Boolean r18 = this.a;
        if (r18 == null) goto L31;
        r1 = r18.hashCode();
    L31:
        return r17 + r1;
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "GetCommentListData(replies=" + this.replies + ", comments=" + this.comments + ", hasMore=" + this.hasMore + ", nextOffsetToken=" + this.nextOffsetToken + ", additionalToast=" + this.additionalToast + ", totalCount=" + this.totalCount + ", fromCache=" + this.a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        List<CommentInfo> r0 = this.replies;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L12:
        List<CommentInfo> r1 = this.comments;
        if (r1 != null) goto L15;
        r6.writeInt(0);
    L22:
        r6.writeInt(this.hasMore ? 1 : 0);
        r6.writeString(this.nextOffsetToken);
        r6.writeString(this.additionalToast);
        Long r8 = this.totalCount;
        if (r8 != null) goto L25;
        r6.writeInt(0);
    L26:
        Boolean r9 = this.a;
        if (r9 != null) goto L29;
        r6.writeInt(0);
        return;
    L29:
        r6.writeInt(1);
        r6.writeInt(r9.booleanValue() ? 1 : 0);
        return;
    L25:
        r6.writeInt(1);
        r6.writeLong(r8.longValue());
        goto L26
    L15:
        r6.writeInt(1);
        r6.writeInt(r1.size());
        Iterator<CommentInfo> r2 = r1.iterator();
    L17:
        if (r2.hasNext() == false) goto L22;
        CommentInfo r3 = r2.next();
        if (r3 == null) goto L20;
        r6.writeInt(1);
        r3.writeToParcel(r6, r7);
        goto L17
    L20:
        r6.writeInt(0);
        goto L17
    L5:
        r6.writeInt(1);
        r6.writeInt(r0.size());
        Iterator<CommentInfo> r4 = r0.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        CommentInfo r5 = r4.next();
        if (r5 == null) goto L10;
        r6.writeInt(1);
        r5.writeToParcel(r6, r7);
        goto L7
    L10:
        r6.writeInt(0);
        goto L7
    }

    public final String a() {
        return this.additionalToast;
    }

    public final List<CommentInfo> b() {
        return this.comments;
    }

    public final boolean c() {
        return this.hasMore;
    }

    public final String d() {
        return this.nextOffsetToken;
    }

    public final List<CommentInfo> e() {
        return this.replies;
    }

    public final Long g() {
        return this.totalCount;
    }

    public /* synthetic */ CommentHttpApi$GetCommentListData(int r9) {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, "", "", 0L, Boolean.FALSE);
    }

    public CommentHttpApi$GetCommentListData(List<CommentInfo> r1, List<CommentInfo> r2, boolean r3, String r4, String r5, Long r6, Boolean r7) {
        this.replies = r1;
        this.comments = r2;
        this.hasMore = r3;
        this.nextOffsetToken = r4;
        this.additionalToast = r5;
        this.totalCount = r6;
        this.a = r7;
    }
}
