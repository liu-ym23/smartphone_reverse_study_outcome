package com.obric.memorydata.datatransport.utils;

import com.obric.memorydata.datatransport.manager.ExportFailureReason;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/AttachmentFailureClassifier;", "", "<init>", "()V", "classify", "Lcom/obric/memorydata/datatransport/manager/ExportFailureReason;", "error", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9829a = null;

    static {
        f9829a = new b();
    }

    private b() {
    }

    public final ExportFailureReason a(Throwable r1) {
        Intrinsics.checkNotNullParameter(r1, "error");
        if (ZeusTransformUtils.instanceOf(r1, FileNotFoundException.class) == false) goto L6;
        return ExportFailureReason.SOURCE_NOT_FOUND;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, SecurityException.class) == false) goto L9;
        return ExportFailureReason.ACCESS_DENIED;
    L9:
        if (ZeusTransformUtils.instanceOf(r1, IOException.class) == false) goto L12;
        return ExportFailureReason.READ_FAILED;
    L12:
        return ExportFailureReason.UNKNOWN;
    }
}
