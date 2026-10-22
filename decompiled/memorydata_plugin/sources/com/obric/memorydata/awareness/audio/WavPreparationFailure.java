package com.obric.memorydata.awareness.audio;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/awareness/audio/WavPreparationFailure;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "stage", "", "segmentIndex", "", InfoRequestQPSOptTraceLogger.REASON, "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V", "getStage", "()Ljava/lang/String;", "getSegmentIndex", "()I", "getReason", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WavPreparationFailure extends IllegalArgumentException {
    private final String reason;
    private final int segmentIndex;
    private final String stage;

    public WavPreparationFailure(String r3, int r4, String r5, Exception r6) {
        Intrinsics.checkNotNullParameter(r3, "stage");
        Intrinsics.checkNotNullParameter(r5, InfoRequestQPSOptTraceLogger.REASON);
        super(r5, (Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin"));
        this.stage = r3;
        this.segmentIndex = r4;
        this.reason = r5;
    }

    public /* synthetic */ WavPreparationFailure(String r1, int r2, String r3, Exception r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }

    public final String getReason() {
        return this.reason;
    }

    public final int getSegmentIndex() {
        return this.segmentIndex;
    }

    public final String getStage() {
        return this.stage;
    }
}
