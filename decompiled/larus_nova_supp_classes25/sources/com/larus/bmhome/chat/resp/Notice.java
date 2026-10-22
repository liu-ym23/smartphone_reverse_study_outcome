package com.larus.bmhome.chat.resp;

import bb8.i;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00100\u001a\u00020\u000bHÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00102\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011HÆ\u0003J\u0082\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0006HÖ\u0001J\t\u0010:\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\"\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006;"}, d2 = {"Lcom/larus/bmhome/chat/resp/Notice;", "", "noticeId", "", "createTime", "noticeGroup", "", "noticeType", "noticeTypeStr", "", "hasRead", "", "auditPass", "commonNoticeData", "Lcom/larus/bmhome/chat/resp/CommonNoticeData;", "uniqId", "bannerModels", "", "Lcom/larus/bmhome/banner/BannerModel;", "<init>", "(JJIILjava/lang/String;ZLjava/lang/Boolean;Lcom/larus/bmhome/chat/resp/CommonNoticeData;Ljava/lang/String;Ljava/util/List;)V", "getNoticeId", "()J", "getCreateTime", "getNoticeGroup", "()I", "getNoticeType", "getNoticeTypeStr", "()Ljava/lang/String;", "getHasRead", "()Z", "setHasRead", "(Z)V", "getAuditPass", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCommonNoticeData", "()Lcom/larus/bmhome/chat/resp/CommonNoticeData;", "getUniqId", "getBannerModels", "()Ljava/util/List;", "setBannerModels", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(JJIILjava/lang/String;ZLjava/lang/Boolean;Lcom/larus/bmhome/chat/resp/CommonNoticeData;Ljava/lang/String;Ljava/util/List;)Lcom/larus/bmhome/chat/resp/Notice;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class Notice {

    @SerializedName("audit_pass")
    private final Boolean auditPass;
    private transient List<i> bannerModels;

    @SerializedName("common_notice_data")
    private final CommonNoticeData commonNoticeData;

    @SerializedName("create_time")
    private final long createTime;

    @SerializedName("has_read")
    private boolean hasRead;

    @SerializedName("notice_group")
    private final int noticeGroup;

    @SerializedName("notice_id")
    private final long noticeId;

    @SerializedName("notice_type")
    private final int noticeType;

    @SerializedName("notice_type_str")
    private final String noticeTypeStr;

    @SerializedName("uniq_id")
    private final String uniqId;

    public Notice() {
        this(0, 0, 0, 0, null, false, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Notice copy$default(Notice r13, long r14, long r16, int r18, int r19, String r20, boolean r21, Boolean r22, CommonNoticeData r23, String r24, List r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        long r2 = r13.noticeId;
    L7:
        if ((r26 & 2) == 0) goto L9;
        long r4 = r13.createTime;
    L11:
        if ((r26 & 4) == 0) goto L13;
        int r6 = r13.noticeGroup;
    L15:
        if ((r26 & 8) == 0) goto L17;
        int r7 = r13.noticeType;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r8 = r13.noticeTypeStr;
    L23:
        if ((r26 & 32) == 0) goto L25;
        boolean r9 = r13.hasRead;
    L27:
        if ((r26 & 64) == 0) goto L29;
        Boolean r10 = r13.auditPass;
    L31:
        if ((r26 & 128) == 0) goto L33;
        CommonNoticeData r11 = r13.commonNoticeData;
    L35:
        if ((r26 & 256) == 0) goto L37;
        String r12 = r13.uniqId;
    L39:
        if ((r26 & 512) == 0) goto L41;
        List r1 = r13.bannerModels;
    L43:
        return r13.copy(r2, r4, r6, r7, r8, r9, r10, r11, r12, r1);
    L41:
        r1 = r25;
        goto L43
    L37:
        r12 = r24;
        goto L39
    L33:
        r11 = r23;
        goto L35
    L29:
        r10 = r22;
        goto L31
    L25:
        r9 = r21;
        goto L27
    L21:
        r8 = r20;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final long component1() {
        return this.noticeId;
    }

    public final List<i> component10() {
        return this.bannerModels;
    }

    public final long component2() {
        return this.createTime;
    }

    public final int component3() {
        return this.noticeGroup;
    }

    public final int component4() {
        return this.noticeType;
    }

    public final String component5() {
        return this.noticeTypeStr;
    }

    public final boolean component6() {
        return this.hasRead;
    }

    public final Boolean component7() {
        return this.auditPass;
    }

    public final CommonNoticeData component8() {
        return this.commonNoticeData;
    }

    public final String component9() {
        return this.uniqId;
    }

    public final Notice copy(long r15, long r17, int r19, int r20, String r21, boolean r22, Boolean r23, CommonNoticeData r24, String r25, List<i> r26) {
        Intrinsics.checkNotNullParameter(r26, "bannerModels");
        return new Notice(r15, r17, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof Notice) == true) goto L8;
        return false;
    L8:
        Notice r9 = (Notice) r8;
        if (this.noticeId == r9.noticeId) goto L12;
        return false;
    L12:
        if (this.createTime == r9.createTime) goto L15;
        return false;
    L15:
        if (this.noticeGroup == r9.noticeGroup) goto L18;
        return false;
    L18:
        if (this.noticeType == r9.noticeType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.noticeTypeStr, r9.noticeTypeStr) == true) goto L24;
        return false;
    L24:
        if (this.hasRead == r9.hasRead) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.auditPass, r9.auditPass) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.commonNoticeData, r9.commonNoticeData) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.uniqId, r9.uniqId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bannerModels, r9.bannerModels) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        long r0 = this.noticeId;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.createTime;
        int r2 = (((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.noticeGroup) * 31) + this.noticeType) * 31;
        String r4 = this.noticeTypeStr;
        int r5 = 0;
        if (r4 != null) goto L5;
        int r6 = 0;
    L6:
        int r7 = (r2 + r6) * 31;
        if (this.hasRead == false) goto L9;
        int r8 = 1231;
    L10:
        int r9 = (r7 + r8) * 31;
        Boolean r10 = this.auditPass;
        if (r10 != null) goto L13;
        int r11 = 0;
    L14:
        int r12 = (r9 + r11) * 31;
        CommonNoticeData r13 = this.commonNoticeData;
        if (r13 != null) goto L17;
        int r14 = 0;
    L18:
        int r15 = (r12 + r14) * 31;
        String r16 = this.uniqId;
        if (r16 == null) goto L23;
        r5 = r16.hashCode();
    L23:
        return ((r15 + r5) * 31) + this.bannerModels.hashCode();
    L17:
        r14 = r13.hashCode();
        goto L18
    L13:
        r11 = r10.hashCode();
        goto L14
    L9:
        r8 = 1237;
        goto L10
    L5:
        r6 = r4.hashCode();
        goto L6
    }

    public String toString() {
        return "Notice(noticeId=" + this.noticeId + ", createTime=" + this.createTime + ", noticeGroup=" + this.noticeGroup + ", noticeType=" + this.noticeType + ", noticeTypeStr=" + this.noticeTypeStr + ", hasRead=" + this.hasRead + ", auditPass=" + this.auditPass + ", commonNoticeData=" + this.commonNoticeData + ", uniqId=" + this.uniqId + ", bannerModels=" + this.bannerModels + ')';
    }

    public final Boolean getAuditPass() {
        return this.auditPass;
    }

    public final List<i> getBannerModels() {
        return this.bannerModels;
    }

    public final CommonNoticeData getCommonNoticeData() {
        return this.commonNoticeData;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final boolean getHasRead() {
        return this.hasRead;
    }

    public final int getNoticeGroup() {
        return this.noticeGroup;
    }

    public final long getNoticeId() {
        return this.noticeId;
    }

    public final int getNoticeType() {
        return this.noticeType;
    }

    public final String getNoticeTypeStr() {
        return this.noticeTypeStr;
    }

    public final String getUniqId() {
        return this.uniqId;
    }

    public final void setBannerModels(List<i> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.bannerModels = r2;
    }

    public final void setHasRead(boolean r1) {
        this.hasRead = r1;
    }

    public Notice(long r2, long r4, int r6, int r7, String r8, boolean r9, Boolean r10, CommonNoticeData r11, String r12, List<i> r13) {
        Intrinsics.checkNotNullParameter(r13, "bannerModels");
        this.noticeId = r2;
        this.createTime = r4;
        this.noticeGroup = r6;
        this.noticeType = r7;
        this.noticeTypeStr = r8;
        this.hasRead = r9;
        this.auditPass = r10;
        this.commonNoticeData = r11;
        this.uniqId = r12;
        this.bannerModels = r13;
    }

    public /* synthetic */ Notice(long r14, long r16, int r18, int r19, String r20, boolean r21, Boolean r22, CommonNoticeData r23, String r24, List r25, int r26, DefaultConstructorMarker r27) {
        long r2 = -1;
        if ((r26 & 1) == 0) goto L5;
        long r4 = -1;
    L7:
        if ((r26 & 2) != 0) goto L10;
        r2 = r16;
    L10:
        int r6 = -1;
        if ((r26 & 4) == 0) goto L13;
        int r1 = -1;
    L15:
        if ((r26 & 8) != 0) goto L18;
        r6 = r19;
    L18:
        String r8 = "";
        if ((r26 & 16) == 0) goto L21;
        String r7 = "";
    L23:
        if ((r26 & 32) == 0) goto L25;
        boolean r9 = false;
    L26:
        CommonNoticeData r11 = null;
        if ((r26 & 64) == 0) goto L29;
        Boolean r10 = null;
    L31:
        if ((r26 & 128) != 0) goto L35;
        r11 = r23;
    L35:
        if ((r26 & 256) != 0) goto L39;
        r8 = r24;
    L39:
        if ((r26 & 512) == 0) goto L41;
        List r0 = CollectionsKt.emptyList();
    L42:
        this(r4, r2, r1, r6, r7, r9, r10, r11, r8, r0);
        return;
    L41:
        r0 = r25;
        goto L42
    L29:
        r10 = r22;
        goto L31
    L25:
        r9 = r21;
        goto L26
    L21:
        r7 = r20;
        goto L23
    L13:
        r1 = r18;
        goto L15
    L5:
        r4 = r14;
        goto L7
    }
}
