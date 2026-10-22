package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/rc/VideoModelResult;", "", "statusCode", "", "message", "", "videoModel", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "getVideoModel", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/rc/VideoModelResult;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoModelResult {

    @SerializedName("message")
    private final String message;

    @SerializedName("status_code")
    private final Integer statusCode;

    @SerializedName("video_model")
    private final String videoModel;

    public VideoModelResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ VideoModelResult copy$default(VideoModelResult r0, Integer r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.statusCode;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.videoModel;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Integer component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.videoModel;
    }

    public final VideoModelResult copy(Integer r2, String r3, String r4) {
        return new VideoModelResult(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VideoModelResult) == true) goto L8;
        return false;
    L8:
        VideoModelResult r6 = (VideoModelResult) r5;
        if (Intrinsics.areEqual(this.statusCode, r6.statusCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.videoModel, r6.videoModel) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.statusCode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.message;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.videoModel;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "VideoModelResult(statusCode=" + this.statusCode + ", message=" + this.message + ", videoModel=" + this.videoModel + ')';
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final String getVideoModel() {
        return this.videoModel;
    }

    public VideoModelResult(Integer r1, String r2, String r3) {
        this.statusCode = r1;
        this.message = r2;
        this.videoModel = r3;
    }

    public /* synthetic */ VideoModelResult(Integer r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
