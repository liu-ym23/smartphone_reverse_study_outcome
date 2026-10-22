package com.bytedance.android.live.browser.jsbridge.newmethods;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/RawNotJsonException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "raw", "", "xTTLogId", "(Ljava/lang/String;Ljava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "getXTTLogId", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RawNotJsonException extends Exception {
    private final String raw;
    private final String xTTLogId;

    public RawNotJsonException() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public final String getRaw() {
        return this.raw;
    }

    public final String getXTTLogId() {
        return this.xTTLogId;
    }

    public RawNotJsonException(String r1, String r2) {
        this.raw = r1;
        this.xTTLogId = r2;
    }

    public /* synthetic */ RawNotJsonException(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r2, r3);
    }
}
