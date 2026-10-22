package com.xiphias.browser.scanner;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/xiphias/browser/scanner/VisionSearchException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/xiphias/browser/scanner/VisionSearchError;", "message", "", "cause", "", "serverCode", "<init>", "(Lcom/xiphias/browser/scanner/VisionSearchError;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V", "getError", "()Lcom/xiphias/browser/scanner/VisionSearchError;", "getServerCode", "()Ljava/lang/String;", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VisionSearchException extends Exception {
    private final VisionSearchError error;
    private final String serverCode;

    public VisionSearchException(VisionSearchError r2, String r3, Throwable r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r3, "message");
        super(r3, r4);
        this.error = r2;
        this.serverCode = r5;
    }

    public /* synthetic */ VisionSearchException(VisionSearchError r2, String r3, Throwable r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        this(r2, r3, r4, r5);
    }

    public final VisionSearchError getError() {
        return this.error;
    }

    public final String getServerCode() {
        return this.serverCode;
    }
}
