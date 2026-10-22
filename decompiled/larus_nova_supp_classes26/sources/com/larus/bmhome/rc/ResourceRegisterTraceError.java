package com.larus.bmhome.rc;

import com.larus.platform.model.upload.ResourceUploadError;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/rc/ResourceRegisterTraceError;", "", "uploadError", "Lcom/larus/platform/model/upload/ResourceUploadError;", "traceExtra", "", "", "", "<init>", "(Lcom/larus/platform/model/upload/ResourceUploadError;Ljava/util/Map;)V", "getUploadError", "()Lcom/larus/platform/model/upload/ResourceUploadError;", "getTraceExtra", "()Ljava/util/Map;", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceRegisterTraceError extends Throwable {
    private final Map<String, Object> traceExtra;
    private final ResourceUploadError uploadError;

    public final Map<String, Object> getTraceExtra() {
        return this.traceExtra;
    }

    public final ResourceUploadError getUploadError() {
        return this.uploadError;
    }

    public ResourceRegisterTraceError(ResourceUploadError r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "uploadError");
        Intrinsics.checkNotNullParameter(r3, "traceExtra");
        super(r2.getMsg());
        this.uploadError = r2;
        this.traceExtra = r3;
    }
}
