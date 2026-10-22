package com.obric.aikernel.model.device;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/obric/aikernel/model/device/AIInferException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "type", "", "code", "", "message", "traceback", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getTraceback", "()Ljava/lang/String;", "getType", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIInferException extends RuntimeException {
    private final int code;
    private final String traceback;
    private final String type;

    public AIInferException(String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "traceback");
        super(r4);
        this.type = r2;
        this.code = r3;
        this.traceback = r5;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getTraceback() {
        return this.traceback;
    }

    public final String getType() {
        return this.type;
    }
}
