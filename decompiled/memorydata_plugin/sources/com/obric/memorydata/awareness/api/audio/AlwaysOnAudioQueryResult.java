package com.obric.memorydata.awareness.api.audio;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioQueryResult;", "", "segments", "", "Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioSegment;", "error", "Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioError;", "<init>", "(Ljava/util/List;Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioError;)V", "getSegments", "()Ljava/util/List;", "getError", "()Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioError;", "isSuccess", "", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AlwaysOnAudioQueryResult {
    private final AlwaysOnAudioError error;
    private final List<AlwaysOnAudioSegment> segments;

    /* JADX WARN: Multi-variable type inference failed */
    public AlwaysOnAudioQueryResult() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public AlwaysOnAudioQueryResult(List<AlwaysOnAudioSegment> r3, AlwaysOnAudioError r4) {
        List<AlwaysOnAudioSegment> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "segments");
        this.segments = r5;
        this.error = r4;
    }

    public /* synthetic */ AlwaysOnAudioQueryResult(List r2, AlwaysOnAudioError r3, int r4, DefaultConstructorMarker r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = CollectionsKt.emptyList();
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r6, r3);
    }

    public static /* synthetic */ AlwaysOnAudioQueryResult copy$default(AlwaysOnAudioQueryResult r1, List r2, AlwaysOnAudioError r3, int r4, Object r5) {
        List<AlwaysOnAudioSegment> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.segments;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.error;
    L9:
        return r1.copy(r6, r3);
    }

    public final List<AlwaysOnAudioSegment> component1() {
        return this.segments;
    }

    public final AlwaysOnAudioError component2() {
        return this.error;
    }

    public final AlwaysOnAudioQueryResult copy(List<AlwaysOnAudioSegment> r2, AlwaysOnAudioError r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "segments");
        return new AlwaysOnAudioQueryResult(r1, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AlwaysOnAudioQueryResult.class) == true) goto L8;
        return false;
    L8:
        AlwaysOnAudioQueryResult r6 = (AlwaysOnAudioQueryResult) ZeusTransformUtils.preCheckCast(r5, AlwaysOnAudioQueryResult.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.segments, r6.segments) == true) goto L12;
        return false;
    L12:
        if (this.error == r6.error) goto L14;
        return false;
    L14:
        return true;
    }

    public final AlwaysOnAudioError getError() {
        return this.error;
    }

    public final List<AlwaysOnAudioSegment> getSegments() {
        return this.segments;
    }

    public int hashCode() {
        int r0 = this.segments.hashCode() * 31;
        AlwaysOnAudioError r1 = this.error;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final boolean isSuccess() {
        if (this.error != null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "AlwaysOnAudioQueryResult(segments=" + this.segments + ", error=" + this.error + ')';
    }
}
