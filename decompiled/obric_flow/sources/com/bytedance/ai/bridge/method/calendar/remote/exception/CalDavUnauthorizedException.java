package com.bytedance.ai.bridge.method.calendar.remote.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.s0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/remote/exception/CalDavUnauthorizedException;", "Lcom/bytedance/ai/bridge/method/calendar/remote/exception/CalDavHttpException;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CalDavUnauthorizedException extends CalDavHttpException {
    public CalDavUnauthorizedException(s0 r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        super(r5);
    }
}
