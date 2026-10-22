package com.ss.ugc.live.sdk.platform.network.ws.compress;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/ugc/live/sdk/platform/network/ws/compress/ZstdDecompressException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "reason", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "platform_release"}, k = 1, mv = {1, 4, 0})
public final class ZstdDecompressException extends RuntimeException {
    public ZstdDecompressException(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        super(r2, r3);
    }

    public /* synthetic */ ZstdDecompressException(String r1, Throwable r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
