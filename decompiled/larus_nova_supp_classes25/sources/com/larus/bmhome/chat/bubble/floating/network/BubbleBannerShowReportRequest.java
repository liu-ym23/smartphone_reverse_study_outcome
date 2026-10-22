package com.larus.bmhome.chat.bubble.floating.network;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR&\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/network/BubbleBannerShowReportRequest;", "", "bannerSource", "", "showTime", "", "pushId", "extraParams", "", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/util/Map;)V", "getBannerSource", "()Ljava/lang/String;", "getShowTime", "()J", "getPushId", "getExtraParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BubbleBannerShowReportRequest {

    @SerializedName("banner_source")
    private final String bannerSource;

    @SerializedName("extra_params")
    private final Map<String, String> extraParams;

    @SerializedName("push_id")
    private final String pushId;

    @SerializedName("show_time")
    private final long showTime;

    public BubbleBannerShowReportRequest() {
        this(null, 0, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BubbleBannerShowReportRequest copy$default(BubbleBannerShowReportRequest r3, String r4, long r5, String r7, Map r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.bannerSource;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.showTime;
    L8:
        long r0 = r5;
        if ((r9 & 4) == 0) goto L11;
        r7 = r3.pushId;
    L11:
        String r11 = r7;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.extraParams;
    L14:
        String r6 = r4;
        return r3.copy(r6, r0, r11, r8);
    }

    public final String component1() {
        return this.bannerSource;
    }

    public final long component2() {
        return this.showTime;
    }

    public final String component3() {
        return this.pushId;
    }

    public final Map<String, String> component4() {
        return this.extraParams;
    }

    public final BubbleBannerShowReportRequest copy(String r8, long r9, String r11, Map<String, String> r12) {
        return new BubbleBannerShowReportRequest(r8, r9, r11, r12);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof BubbleBannerShowReportRequest) == true) goto L8;
        return false;
    L8:
        BubbleBannerShowReportRequest r9 = (BubbleBannerShowReportRequest) r8;
        if (Intrinsics.areEqual(this.bannerSource, r9.bannerSource) == true) goto L12;
        return false;
    L12:
        if (this.showTime == r9.showTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pushId, r9.pushId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extraParams, r9.extraParams) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.bannerSource;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        long r3 = this.showTime;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.pushId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Map<String, String> r8 = this.extraParams;
        if (r8 == null) goto L15;
        r1 = r8.hashCode();
    L15:
        return r7 + r1;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BubbleBannerShowReportRequest(bannerSource=" + this.bannerSource + ", showTime=" + this.showTime + ", pushId=" + this.pushId + ", extraParams=" + this.extraParams + ')';
    }

    public final String getBannerSource() {
        return this.bannerSource;
    }

    public final Map<String, String> getExtraParams() {
        return this.extraParams;
    }

    public final String getPushId() {
        return this.pushId;
    }

    public final long getShowTime() {
        return this.showTime;
    }

    public BubbleBannerShowReportRequest(String r1, long r2, String r4, Map<String, String> r5) {
        this.bannerSource = r1;
        this.showTime = r2;
        this.pushId = r4;
        this.extraParams = r5;
    }

    public /* synthetic */ BubbleBannerShowReportRequest(String r5, long r6, String r8, Map r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        r6 = 0;
    L9:
        long r1 = r6;
        if ((r10 & 4) == 0) goto L12;
        String r3 = null;
    L14:
        if ((r10 & 8) == 0) goto L16;
        Map r13 = null;
    L17:
        this(r12, r1, r3, r13);
        return;
    L16:
        r13 = r9;
        goto L17
    L12:
        r3 = r8;
        goto L14
    L5:
        r12 = r5;
        goto L7
    }
}
