package com.ss.android.lark.officesdk.minutes.service.foundation.hardware.api;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/hardware/api/MmHardwareOperationException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "code", "", "message", "", "debugMessage", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getDebugMessage", "()Ljava/lang/String;", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmHardwareOperationException extends IllegalStateException {
    private final int code;
    private final String debugMessage;

    public final int getCode() {
        return this.code;
    }

    public final String getDebugMessage() {
        return this.debugMessage;
    }

    public MmHardwareOperationException(int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "debugMessage");
        super("code=" + r3 + ", message=" + r4 + ", debugMessage=" + r5);
        this.code = r3;
        this.debugMessage = r5;
    }

    public /* synthetic */ MmHardwareOperationException(int r1, String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = r2;
    L5:
        this(r1, r2, r3);
    }
}
