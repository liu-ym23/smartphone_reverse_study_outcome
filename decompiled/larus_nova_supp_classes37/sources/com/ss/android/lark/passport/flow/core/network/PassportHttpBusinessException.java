package com.ss.android.lark.passport.flow.core.network;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/passport/flow/core/network/PassportHttpBusinessException;", "Ljava/io/IOException;", "code", "", "bizCode", "nextStep", "", "logId", "message", "<init>", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getBizCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNextStep", "()Ljava/lang/String;", "getLogId", "flow-passport-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PassportHttpBusinessException extends IOException {
    private final Integer bizCode;
    private final int code;
    private final String logId;
    private final String nextStep;

    public final Integer getBizCode() {
        return this.bizCode;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getNextStep() {
        return this.nextStep;
    }

    public PassportHttpBusinessException(int r2, Integer r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        super(r6);
        this.code = r2;
        this.bizCode = r3;
        this.nextStep = r4;
        this.logId = r5;
    }
}
