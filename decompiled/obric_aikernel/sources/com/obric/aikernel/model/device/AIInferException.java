package com.obric.aikernel.model.device;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class AIInferException extends RuntimeException {
    private final int code;
    private final String traceback;
    private final String type;

    public AIInferException(String r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r13, "traceback");
        super(r12);
        this.type = r10;
        this.code = r11;
        this.traceback = r13;
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
