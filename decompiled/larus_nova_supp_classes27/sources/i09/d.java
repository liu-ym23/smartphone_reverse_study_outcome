package i09;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u001e\u001a\u00020\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\u0013\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u0013\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\fHÆ\u0003Ju\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\tHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u0006-"}, d2 = {"Lcom/larus/common/baidunavi/api/bean/BaiduNaviRouteInfo;", "", "routeId", "", "tag", "start", "Lcom/larus/common/baidunavi/api/bean/BaiduNaviGeoPoint;", "end", "distance", "", "duration", "steps", "", "Lcom/larus/common/baidunavi/api/bean/BaiduNaviRouteStep;", "guideInfo", "Lcom/larus/common/baidunavi/api/bean/BaiduNaviGuideInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/common/baidunavi/api/bean/BaiduNaviGeoPoint;Lcom/larus/common/baidunavi/api/bean/BaiduNaviGeoPoint;IILjava/util/List;Ljava/util/List;)V", "getRouteId", "()Ljava/lang/String;", "getTag", "getStart", "()Lcom/larus/common/baidunavi/api/bean/BaiduNaviGeoPoint;", "getEnd", "getDistance", "()I", "getDuration", "getSteps", "()Ljava/util/List;", "getGuideInfo", "toSimpleString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("distance")
    private final int distance;

    @SerializedName("duration")
    private final int duration;

    @SerializedName("destination")
    private final a end;

    @SerializedName("guide_info")
    private final List<b> guideInfo;

    @SerializedName("route_id")
    private final String routeId;

    @SerializedName("origin")
    private final a start;

    @SerializedName("steps")
    private final List<f> steps;

    @SerializedName("tag")
    private final String tag;

    public d() {
        this(null, 0, 0, null, 255);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.routeId, r6.routeId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tag, r6.tag) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.start, r6.start) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.end, r6.end) == true) goto L21;
        return false;
    L21:
        if (this.distance == r6.distance) goto L24;
        return false;
    L24:
        if (this.duration == r6.duration) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.steps, r6.steps) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.guideInfo, r6.guideInfo) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r0 = this.routeId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.tag;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        a r7 = this.start;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        a r10 = this.end;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((((r9 + r11) * 31) + this.distance) * 31) + this.duration) * 31;
        List<f> r13 = this.steps;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<b> r16 = this.guideInfo;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "BaiduNaviRouteInfo(routeId=" + this.routeId + ", tag=" + this.tag + ", start=" + this.start + ", end=" + this.end + ", distance=" + this.distance + ", duration=" + this.duration + ", steps=" + this.steps + ", guideInfo=" + this.guideInfo + ')';
    }

    public d(String r4, int r5, int r6, List r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 16) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r8 & 32) == 0) goto L12;
        r6 = 0;
    L12:
        if ((r8 & 64) == 0) goto L14;
        r7 = null;
    L14:
        this.routeId = r4;
        this.tag = null;
        this.start = null;
        this.end = null;
        this.distance = r5;
        this.duration = r6;
        this.steps = r7;
        this.guideInfo = null;
    }
}
