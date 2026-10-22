package ey9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003Js\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "", "vid", "", "downloadUrl", "duration", "", "videoType", "videoModel", "cover", "Lcom/larus/uaigc/avatar/api/Image;", "thumbnail", "readingText", "reviewInfo", "Lcom/larus/uaigc/avatar/api/VideoReviewInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Lcom/larus/uaigc/avatar/api/Image;Lcom/larus/uaigc/avatar/api/Image;Ljava/lang/String;Lcom/larus/uaigc/avatar/api/VideoReviewInfo;)V", "getVid", "()Ljava/lang/String;", "getDownloadUrl", "getDuration", "()D", "getVideoType", "getVideoModel", "getCover", "()Lcom/larus/uaigc/avatar/api/Image;", "getThumbnail", "getReadingText", "getReviewInfo", "()Lcom/larus/uaigc/avatar/api/VideoReviewInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class a {

    @SerializedName("cover")
    private final f cover;

    @SerializedName("download_url")
    private final String downloadUrl;

    @SerializedName("duration")
    private final double duration;

    @SerializedName("reading_text")
    private final String readingText;

    @SerializedName("review_info")
    private final m reviewInfo;

    @SerializedName("thumbnail")
    private final f thumbnail;

    @SerializedName("vid")
    private final String vid;

    @SerializedName("video_model")
    private final String videoModel;

    @SerializedName("video_type")
    private final String videoType;

    public a() {
        this(null, 0.0d, null, null, 511);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.vid, r9.vid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.downloadUrl, r9.downloadUrl) == true) goto L15;
        return false;
    L15:
        if (Double.compare(this.duration, r9.duration) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoType, r9.videoType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.videoModel, r9.videoModel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cover, r9.cover) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.thumbnail, r9.thumbnail) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.readingText, r9.readingText) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.reviewInfo, r9.reviewInfo) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r0 = this.vid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.downloadUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = Double.doubleToLongBits(this.duration);
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        String r9 = this.videoType;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        String r12 = this.videoModel;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        f r15 = this.cover;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r14 + r16) * 31;
        f r18 = this.thumbnail;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (r17 + r19) * 31;
        String r21 = this.readingText;
        if (r21 != null) goto L29;
        int r22 = 0;
    L30:
        int r23 = (r20 + r22) * 31;
        m r24 = this.reviewInfo;
        if (r24 == null) goto L35;
        r1 = r24.hashCode();
    L35:
        return r23 + r1;
    L29:
        r22 = r21.hashCode();
        goto L30
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "AiReplicaRefVideo(vid=" + this.vid + ", downloadUrl=" + this.downloadUrl + ", duration=" + this.duration + ", videoType=" + this.videoType + ", videoModel=" + this.videoModel + ", cover=" + this.cover + ", thumbnail=" + this.thumbnail + ", readingText=" + this.readingText + ", reviewInfo=" + this.reviewInfo + ')';
    }

    public final f a() {
        return this.cover;
    }

    public final String b() {
        return this.downloadUrl;
    }

    public final double c() {
        return this.duration;
    }

    public final f d() {
        return this.thumbnail;
    }

    public final String e() {
        return this.vid;
    }

    public final String f() {
        return this.videoModel;
    }

    public final String g() {
        return this.videoType;
    }

    public a(String r3, double r4, String r6, String r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r4 = 0.0d;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 128) == 0) goto L14;
        r7 = null;
    L14:
        this.vid = r3;
        this.downloadUrl = null;
        this.duration = r4;
        this.videoType = r6;
        this.videoModel = null;
        this.cover = null;
        this.thumbnail = null;
        this.readingText = r7;
        this.reviewInfo = null;
    }
}
