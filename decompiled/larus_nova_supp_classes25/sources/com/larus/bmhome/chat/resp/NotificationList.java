package com.larus.bmhome.chat.resp;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u000bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/larus/bmhome/chat/resp/NotificationList;", "", "hasMore", "", "nextCursor", "", "noticeList", "", "Lcom/larus/bmhome/chat/resp/Notice;", "readTime", "contentModifyVersion", "", "<init>", "(ZJLjava/util/List;JLjava/lang/String;)V", "getHasMore", "()Z", "getNextCursor", "()J", "getNoticeList", "()Ljava/util/List;", "getReadTime", "getContentModifyVersion", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class NotificationList {

    @SerializedName("content_modify_version")
    private final String contentModifyVersion;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("next_cursor")
    private final long nextCursor;

    @SerializedName("notice_list")
    private final List<Notice> noticeList;

    @SerializedName("read_time")
    private final long readTime;

    public NotificationList() {
        this(false, 0, null, 0, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotificationList copy$default(NotificationList r5, boolean r6, long r7, List r9, long r10, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.hasMore;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.nextCursor;
    L8:
        long r0 = r7;
        if ((r13 & 4) == 0) goto L11;
        r9 = r5.noticeList;
    L11:
        List r15 = r9;
        if ((r13 & 8) == 0) goto L14;
        r10 = r5.readTime;
    L14:
        long r2 = r10;
        if ((r13 & 16) == 0) goto L17;
        r12 = r5.contentModifyVersion;
    L17:
        boolean r8 = r6;
        return r5.copy(r8, r0, r15, r2, r12);
    }

    public final boolean component1() {
        return this.hasMore;
    }

    public final long component2() {
        return this.nextCursor;
    }

    public final List<Notice> component3() {
        return this.noticeList;
    }

    public final long component4() {
        return this.readTime;
    }

    public final String component5() {
        return this.contentModifyVersion;
    }

    public final NotificationList copy(boolean r10, long r11, List<Notice> r13, long r14, String r16) {
        return new NotificationList(r10, r11, r13, r14, r16);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof NotificationList) == true) goto L8;
        return false;
    L8:
        NotificationList r9 = (NotificationList) r8;
        if (this.hasMore == r9.hasMore) goto L12;
        return false;
    L12:
        if (this.nextCursor == r9.nextCursor) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.noticeList, r9.noticeList) == true) goto L18;
        return false;
    L18:
        if (this.readTime == r9.readTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.contentModifyVersion, r9.contentModifyVersion) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.hasMore == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.nextCursor;
        int r2 = ((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        List<Notice> r3 = this.noticeList;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        long r6 = this.readTime;
        int r7 = (((r2 + r5) * 31) + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        String r8 = this.contentModifyVersion;
        if (r8 == null) goto L15;
        r4 = r8.hashCode();
    L15:
        return r7 + r4;
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "NotificationList(hasMore=" + this.hasMore + ", nextCursor=" + this.nextCursor + ", noticeList=" + this.noticeList + ", readTime=" + this.readTime + ", contentModifyVersion=" + this.contentModifyVersion + ')';
    }

    public final String getContentModifyVersion() {
        return this.contentModifyVersion;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final long getNextCursor() {
        return this.nextCursor;
    }

    public final List<Notice> getNoticeList() {
        return this.noticeList;
    }

    public final long getReadTime() {
        return this.readTime;
    }

    public NotificationList(boolean r1, long r2, List<Notice> r4, long r5, String r7) {
        this.hasMore = r1;
        this.nextCursor = r2;
        this.noticeList = r4;
        this.readTime = r5;
        this.contentModifyVersion = r7;
    }

    public /* synthetic */ NotificationList(boolean r6, long r7, List r9, long r10, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        r6 = false;
    L5:
        long r0 = -1;
        if ((r13 & 2) == 0) goto L8;
        long r2 = -1;
    L10:
        if ((r13 & 4) == 0) goto L12;
        r9 = null;
    L12:
        List r15 = r9;
        if ((r13 & 8) != 0) goto L17;
        r0 = r10;
    L17:
        if ((r13 & 16) == 0) goto L19;
        r12 = "";
    L19:
        this(r6, r2, r15, r0, r12);
        return;
    L8:
        r2 = r7;
        goto L10
    }
}
