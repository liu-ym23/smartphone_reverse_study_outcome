package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003Js\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/larus/platform/model/SaasShareConfig;", "", "ecomDetailCopyLink", "", "ecomDetailDesc", "lifeDetailCopyLink", "lifeDetailDesc", "lifePoiCopyLink", "lifePoiDesc", "liveCopyDesc", "liveCopyLink", "shortUrlCreateTimeoutMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getEcomDetailCopyLink", "()Ljava/lang/String;", "getEcomDetailDesc", "getLifeDetailCopyLink", "getLifeDetailDesc", "getLifePoiCopyLink", "getLifePoiDesc", "getLiveCopyDesc", "getLiveCopyLink", "getShortUrlCreateTimeoutMs", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class h4 {

    @SerializedName("ecom_detail_copy_link")
    private final String ecomDetailCopyLink;

    @SerializedName("ecom_detail_desc")
    private final String ecomDetailDesc;

    @SerializedName("life_detail_copy_link")
    private final String lifeDetailCopyLink;

    @SerializedName("life_detail_desc")
    private final String lifeDetailDesc;

    @SerializedName("life_poi_copy_link")
    private final String lifePoiCopyLink;

    @SerializedName("life_poi_desc")
    private final String lifePoiDesc;

    @SerializedName("live_copy_desc")
    private final String liveCopyDesc;

    @SerializedName("live_copy_link")
    private final String liveCopyLink;

    @SerializedName("short_url_create_timeout_ms")
    private final long shortUrlCreateTimeoutMs;

    public h4() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h4) == true) goto L8;
        return false;
    L8:
        h4 r9 = (h4) r8;
        if (Intrinsics.areEqual(this.ecomDetailCopyLink, r9.ecomDetailCopyLink) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ecomDetailDesc, r9.ecomDetailDesc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lifeDetailCopyLink, r9.lifeDetailCopyLink) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lifeDetailDesc, r9.lifeDetailDesc) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lifePoiCopyLink, r9.lifePoiCopyLink) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lifePoiDesc, r9.lifePoiDesc) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.liveCopyDesc, r9.liveCopyDesc) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.liveCopyLink, r9.liveCopyLink) == true) goto L33;
        return false;
    L33:
        if (this.shortUrlCreateTimeoutMs == r9.shortUrlCreateTimeoutMs) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r0 = this.ecomDetailCopyLink;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.ecomDetailDesc;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.lifeDetailCopyLink;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.lifeDetailDesc;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.lifePoiCopyLink;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.lifePoiDesc;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.liveCopyDesc;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.liveCopyLink;
        if (r22 == null) goto L34;
        r1 = r22.hashCode();
    L34:
        int r23 = (r21 + r1) * 31;
        long r24 = this.shortUrlCreateTimeoutMs;
        return r23 + ((int) (r24 ^ (r24 >>> 32)));
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
        return "SaasShareConfig(ecomDetailCopyLink=" + this.ecomDetailCopyLink + ", ecomDetailDesc=" + this.ecomDetailDesc + ", lifeDetailCopyLink=" + this.lifeDetailCopyLink + ", lifeDetailDesc=" + this.lifeDetailDesc + ", lifePoiCopyLink=" + this.lifePoiCopyLink + ", lifePoiDesc=" + this.lifePoiDesc + ", liveCopyDesc=" + this.liveCopyDesc + ", liveCopyLink=" + this.liveCopyLink + ", shortUrlCreateTimeoutMs=" + this.shortUrlCreateTimeoutMs + ')';
    }

    public final String a() {
        return this.ecomDetailCopyLink;
    }

    public final String b() {
        return this.ecomDetailDesc;
    }

    public final String c() {
        return this.lifeDetailCopyLink;
    }

    public final String d() {
        return this.lifeDetailDesc;
    }

    public final String e() {
        return this.lifePoiCopyLink;
    }

    public final String f() {
        return this.lifePoiDesc;
    }

    public final String g() {
        return this.liveCopyDesc;
    }

    public final String h() {
        return this.liveCopyLink;
    }

    public final long i() {
        return this.shortUrlCreateTimeoutMs;
    }

    public h4(int r3) {
        this.ecomDetailCopyLink = "【豆包】%s %s 【点击链接查看商品详情】";
        this.ecomDetailDesc = "买前问豆包，避坑省钱又省心";
        this.lifeDetailCopyLink = "【豆包】 %s %s 【点击链接查看商品详情】";
        this.lifeDetailDesc = "出行问豆包，避坑省钱又省心";
        this.lifePoiCopyLink = "【豆包】 %s %s 【点击链接查看店铺详情】";
        this.lifePoiDesc = "出行问豆包，避坑省钱又省心";
        this.liveCopyDesc = "直播中！快来看看有哪些商品正在讲解~";
        this.liveCopyLink = "【%s】正在直播，来和我一起支持Ta吧。复制下方链接 %s，打开【豆包】，直接观看直播！";
        this.shortUrlCreateTimeoutMs = 5000;
    }
}
