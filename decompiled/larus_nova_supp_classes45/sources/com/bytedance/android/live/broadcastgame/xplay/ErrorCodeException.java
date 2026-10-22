package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\u0018\u00002\u00060\u0001j\u0002`\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/ErrorCodeException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errorCode", "", "errorMsg", "", "cause", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Throwable;)V", "code", "getCode", "()I", "Ljava/lang/Integer;", "msg", "getMsg", "()Ljava/lang/String;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ErrorCodeException extends RuntimeException {
    private final Integer errorCode;
    private final String errorMsg;

    public ErrorCodeException() {
        this(null, null, null, 7, null);
    }

    public final int getCode() {
        Integer r0 = this.errorCode;
        if (r0 != null) goto L10;
        Throwable r1 = getCause();
        if (r1 != null) goto L11;
        return -1;
    L11:
        return com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r1);
    L10:
        return r0.intValue();
    }

    public final String getMsg() {
        String r0 = this.errorMsg;
        if (r0 != null) goto L10;
        Throwable r1 = getCause();
        if (r1 == null) goto L8;
        String r2 = com.bytedance.android.livesdk.utils.o1.a(r1);
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    L10:
        return r0;
    }

    public ErrorCodeException(Integer r1, String r2, Throwable r3) {
        super(r2, r3);
        this.errorCode = r1;
        this.errorMsg = r2;
    }

    public /* synthetic */ ErrorCodeException(Integer r2, String r3, Throwable r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
