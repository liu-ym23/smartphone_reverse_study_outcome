package com.obric.assistant.network.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/network/impl/ObricNetworkServiceImpl$OmniUploadPrepareException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "reasonCode", "", "message", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getReasonCode", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricNetworkServiceImpl$OmniUploadPrepareException extends Exception {
    private final String reasonCode;

    public final String getReasonCode() {
        return this.reasonCode;
    }

    public ObricNetworkServiceImpl$OmniUploadPrepareException(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "reasonCode");
        Intrinsics.checkNotNullParameter(r3, "message");
        super(r3, r4);
        this.reasonCode = r2;
    }

    public /* synthetic */ ObricNetworkServiceImpl$OmniUploadPrepareException(String r1, String r2, Throwable r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
