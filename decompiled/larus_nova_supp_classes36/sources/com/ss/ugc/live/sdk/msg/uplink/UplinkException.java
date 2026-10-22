package com.ss.ugc.live.sdk.msg.uplink;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/ugc/live/sdk/msg/uplink/UplinkException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "statusCode", "", INotificationHitPoint.NoticeType.MESSAGE, "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "logId", "(ILjava/lang/String;Ljava/lang/Exception;Ljava/lang/String;)V", "getLogId", "()Ljava/lang/String;", "getStatusCode", "()I", "message_release"}, k = 1, mv = {1, 4, 0})
public final class UplinkException extends RuntimeException {
    private final String logId;
    private final int statusCode;

    public final String getLogId() {
        return this.logId;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public UplinkException(int r2, String r3, Exception r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, INotificationHitPoint.NoticeType.MESSAGE);
        super(r3, r4);
        this.statusCode = r2;
        this.logId = r5;
    }

    public /* synthetic */ UplinkException(int r2, String r3, Exception r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        this(r2, r3, r4, r5);
    }
}
