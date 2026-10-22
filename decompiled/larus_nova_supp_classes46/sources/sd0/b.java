package sd0;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lsd0/b;", "", "", "type", "Ljava/lang/Long;", "getType", "()Ljava/lang/Long;", "", "statusCode", "Ljava/lang/Integer;", "getStatusCode", "()Ljava/lang/Integer;", "minCursor", "c", "maxCursor", "b", "", "hasMore", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "", "Lsd0/a;", "videoList", "Ljava/util/List;", "d", "()Ljava/util/List;", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("has_more")
    private final Boolean hasMore;

    @SerializedName("max_cursor")
    private final Long maxCursor;

    @SerializedName("min_cursor")
    private final Long minCursor;

    @SerializedName("status_code")
    private final Integer statusCode;

    @SerializedName("type")
    private final Long type;

    @SerializedName("video_list")
    private final List<a> videoList;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L18;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.statusCode, r4.statusCode) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.minCursor, r4.minCursor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxCursor, r4.maxCursor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.hasMore, r4.hasMore) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.videoList, r4.videoList) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.type;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.statusCode;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.minCursor;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.maxCursor;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.hasMore;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<a> r16 = this.videoList;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoListResponse(type=" + this.type + ", statusCode=" + this.statusCode + ", minCursor=" + this.minCursor + ", maxCursor=" + this.maxCursor + ", hasMore=" + this.hasMore + ", videoList=" + this.videoList + ")";
    }

    public b() {
        this.type = null;
        this.statusCode = null;
        this.minCursor = null;
        this.maxCursor = null;
        this.hasMore = null;
        this.videoList = null;
    }

    public final Boolean a() {
        return this.hasMore;
    }

    public final Long b() {
        return this.maxCursor;
    }

    public final Long c() {
        return this.minCursor;
    }

    public final List<a> d() {
        return this.videoList;
    }

    public final Long getType() {
        return this.type;
    }
}
