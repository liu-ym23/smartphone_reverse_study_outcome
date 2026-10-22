package com.larus.reach.impl;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\tHÆ\u0003JQ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR&\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/larus/reach/impl/ReachBannerShowReportRequest;", "", "bannerScene", "", "showTime", "", "bannerSource", "pushId", "extraParams", "", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getBannerScene", "()Ljava/lang/String;", "getShowTime", "()J", "getBannerSource", "getPushId", "getExtraParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ReachBannerShowReportRequest {

    @SerializedName("banner_scene")
    private final String bannerScene;

    @SerializedName("banner_source")
    private final String bannerSource;

    @SerializedName("extra_params")
    private final Map<String, String> extraParams;

    @SerializedName("push_id")
    private final String pushId;

    @SerializedName("show_time")
    private final long showTime;

    public ReachBannerShowReportRequest() {
        this(null, 0, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReachBannerShowReportRequest copy$default(ReachBannerShowReportRequest r4, String r5, long r6, String r8, String r9, Map r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.bannerScene;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.showTime;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = r4.bannerSource;
    L11:
        String r13 = r8;
        if ((r11 & 8) == 0) goto L14;
        r9 = r4.pushId;
    L14:
        String r2 = r9;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.extraParams;
    L17:
        String r7 = r5;
        return r4.copy(r7, r0, r13, r2, r10);
    }

    public final String component1() {
        return this.bannerScene;
    }

    public final long component2() {
        return this.showTime;
    }

    public final String component3() {
        return this.bannerSource;
    }

    public final String component4() {
        return this.pushId;
    }

    public final Map<String, String> component5() {
        return this.extraParams;
    }

    public final ReachBannerShowReportRequest copy(String r9, long r10, String r12, String r13, Map<String, String> r14) {
        return new ReachBannerShowReportRequest(r9, r10, r12, r13, r14);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ReachBannerShowReportRequest) == true) goto L8;
        return false;
    L8:
        ReachBannerShowReportRequest r9 = (ReachBannerShowReportRequest) r8;
        if (Intrinsics.areEqual(this.bannerScene, r9.bannerScene) == true) goto L12;
        return false;
    L12:
        if (this.showTime == r9.showTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bannerSource, r9.bannerSource) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pushId, r9.pushId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extraParams, r9.extraParams) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.bannerScene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        long r3 = this.showTime;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.bannerSource;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.pushId;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Map<String, String> r11 = this.extraParams;
        if (r11 == null) goto L19;
        r1 = r11.hashCode();
    L19:
        return r10 + r1;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ReachBannerShowReportRequest(bannerScene=" + this.bannerScene + ", showTime=" + this.showTime + ", bannerSource=" + this.bannerSource + ", pushId=" + this.pushId + ", extraParams=" + this.extraParams + ')';
    }

    public final String getBannerScene() {
        return this.bannerScene;
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

    public ReachBannerShowReportRequest(String r1, long r2, String r4, String r5, Map<String, String> r6) {
        this.bannerScene = r1;
        this.showTime = r2;
        this.bannerSource = r4;
        this.pushId = r5;
        this.extraParams = r6;
    }

    public /* synthetic */ ReachBannerShowReportRequest(String r6, long r7, String r9, String r10, Map r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        r7 = 0;
    L9:
        long r1 = r7;
        if ((r12 & 4) == 0) goto L12;
        String r3 = null;
    L14:
        if ((r12 & 8) == 0) goto L16;
        String r4 = null;
    L18:
        if ((r12 & 16) == 0) goto L20;
        Map r15 = null;
    L21:
        this(r14, r1, r3, r4, r15);
        return;
    L20:
        r15 = r11;
        goto L21
    L16:
        r4 = r10;
        goto L18
    L12:
        r3 = r9;
        goto L14
    L5:
        r14 = r6;
        goto L7
    }
}
