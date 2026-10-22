package com.obric.aikernel.res.update;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ApiTimeoutCancellationException extends CancellationException {
    public ApiTimeoutCancellationException(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        super("session cancel " + r10 + " by api. timeout:" + r11);
    }
}
