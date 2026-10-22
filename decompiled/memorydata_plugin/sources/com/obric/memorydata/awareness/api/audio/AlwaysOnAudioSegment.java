package com.obric.memorydata.awareness.api.audio;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioSegment;", "", "timestampMillis", "", "durationMillis", "originalFilePath", "", "<init>", "(JJLjava/lang/String;)V", "getTimestampMillis", "()J", "getDurationMillis", "getOriginalFilePath", "()Ljava/lang/String;", "endTimestampMillis", "getEndTimestampMillis", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AlwaysOnAudioSegment {
    private final long durationMillis;
    private final String originalFilePath;
    private final long timestampMillis;

    public AlwaysOnAudioSegment(long r2, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "originalFilePath");
        this.timestampMillis = r2;
        this.durationMillis = r4;
        this.originalFilePath = r6;
    }

    public static /* synthetic */ AlwaysOnAudioSegment copy$default(AlwaysOnAudioSegment r6, long r7, long r9, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.timestampMillis;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.durationMillis;
    L8:
        long r3 = r9;
        if ((r12 & 4) == 0) goto L12;
        r11 = r6.originalFilePath;
    L12:
        return r6.copy(r1, r3, r11);
    }

    public final long component1() {
        return this.timestampMillis;
    }

    public final long component2() {
        return this.durationMillis;
    }

    public final String component3() {
        return this.originalFilePath;
    }

    public final AlwaysOnAudioSegment copy(long r7, long r9, String r11) {
        Intrinsics.checkNotNullParameter(r11, "originalFilePath");
        return new AlwaysOnAudioSegment(r7, r9, r11);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AlwaysOnAudioSegment.class) == true) goto L8;
        return false;
    L8:
        AlwaysOnAudioSegment r10 = (AlwaysOnAudioSegment) ZeusTransformUtils.preCheckCast(r9, AlwaysOnAudioSegment.class, "com.obric.memorydata.plugin");
        if (this.timestampMillis == r10.timestampMillis) goto L12;
        return false;
    L12:
        if (this.durationMillis == r10.durationMillis) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.originalFilePath, r10.originalFilePath) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final long getDurationMillis() {
        return this.durationMillis;
    }

    public final long getEndTimestampMillis() {
        return this.timestampMillis + this.durationMillis;
    }

    public final String getOriginalFilePath() {
        return this.originalFilePath;
    }

    public final long getTimestampMillis() {
        return this.timestampMillis;
    }

    public int hashCode() {
        return (((Long.hashCode(this.timestampMillis) * 31) + Long.hashCode(this.durationMillis)) * 31) + this.originalFilePath.hashCode();
    }

    public String toString() {
        return "AlwaysOnAudioSegment(timestampMillis=" + this.timestampMillis + ", durationMillis=" + this.durationMillis + ", originalFilePath=" + this.originalFilePath + ')';
    }
}
