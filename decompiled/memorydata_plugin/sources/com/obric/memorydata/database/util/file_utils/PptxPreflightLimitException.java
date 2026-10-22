package com.obric.memorydata.database.util.file_utils;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PptxPreflightLimitException;", "Ljava/io/IOException;", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/memorydata/database/util/file_utils/PptxPreflightRejectReason;", "<init>", "(Lcom/obric/memorydata/database/util/file_utils/PptxPreflightRejectReason;)V", "getReason", "()Lcom/obric/memorydata/database/util/file_utils/PptxPreflightRejectReason;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PptxPreflightLimitException extends IOException {
    private final PptxPreflightRejectReason reason;

    public PptxPreflightLimitException(PptxPreflightRejectReason r2) {
        Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);
        super(r2.name());
        this.reason = r2;
    }

    public final PptxPreflightRejectReason getReason() {
        return this.reason;
    }
}
