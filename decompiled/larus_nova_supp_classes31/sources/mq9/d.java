package mq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/platform/model/avatar/DigitalAvatarVideoRecordingConfigV2;", "", "duration", "", "guideInfo", "Lcom/larus/platform/model/avatar/GuideInfoConfigV2;", "recordInfo", "Lcom/larus/platform/model/avatar/RecordInfoConfigV2;", "recordResultInfo", "Lcom/larus/platform/model/avatar/RecordResultInfoConfigV2;", "<init>", "(Ljava/lang/Integer;Lcom/larus/platform/model/avatar/GuideInfoConfigV2;Lcom/larus/platform/model/avatar/RecordInfoConfigV2;Lcom/larus/platform/model/avatar/RecordResultInfoConfigV2;)V", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGuideInfo", "()Lcom/larus/platform/model/avatar/GuideInfoConfigV2;", "getRecordInfo", "()Lcom/larus/platform/model/avatar/RecordInfoConfigV2;", "getRecordResultInfo", "()Lcom/larus/platform/model/avatar/RecordResultInfoConfigV2;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/larus/platform/model/avatar/GuideInfoConfigV2;Lcom/larus/platform/model/avatar/RecordInfoConfigV2;Lcom/larus/platform/model/avatar/RecordResultInfoConfigV2;)Lcom/larus/platform/model/avatar/DigitalAvatarVideoRecordingConfigV2;", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class d {

    @SerializedName("duration")
    private final Integer duration;

    @SerializedName("guide_info")
    private final g guideInfo;

    @SerializedName("record_info")
    private final i recordInfo;

    @SerializedName("record_result_info")
    private final k recordResultInfo;

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.guideInfo, r6.guideInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.recordInfo, r6.recordInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recordResultInfo, r6.recordResultInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.duration;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        g r4 = this.guideInfo;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        i r7 = this.recordInfo;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        k r10 = this.recordResultInfo;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "DigitalAvatarVideoRecordingConfigV2(duration=" + this.duration + ", guideInfo=" + this.guideInfo + ", recordInfo=" + this.recordInfo + ", recordResultInfo=" + this.recordResultInfo + ')';
    }

    public final Integer a() {
        return this.duration;
    }

    public final g b() {
        return this.guideInfo;
    }

    public final i c() {
        return this.recordInfo;
    }

    public final k d() {
        return this.recordResultInfo;
    }

    public /* synthetic */ d(int r2) {
        this(4, null, null, null);
    }

    public d(Integer r1, g r2, i r3, k r4) {
        this.duration = r1;
        this.guideInfo = r2;
        this.recordInfo = r3;
        this.recordResultInfo = r4;
    }
}
