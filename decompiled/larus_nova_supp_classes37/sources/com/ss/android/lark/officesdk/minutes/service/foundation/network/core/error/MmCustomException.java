package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/error/MmCustomException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errCode", "", "errMsg", "", "<init>", "(ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmCustomException extends Exception {
    private final int errCode;
    private final String errMsg;

    public MmCustomException() {
        String r0 = null;
        int r2 = 0;
        this(r2, r0, 3, r0);
    }

    public static /* synthetic */ MmCustomException copy$default(MmCustomException r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.errCode;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.errMsg;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.errCode;
    }

    public final String component2() {
        return this.errMsg;
    }

    public final MmCustomException copy(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errMsg");
        return new MmCustomException(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmCustomException) == true) goto L8;
        return false;
    L8:
        MmCustomException r6 = (MmCustomException) r5;
        if (this.errCode == r6.errCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errMsg, r6.errMsg) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.errCode * 31) + this.errMsg.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "MmCustomException(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ')';
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public MmCustomException(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errMsg");
        super(r3);
        this.errCode = r2;
        this.errMsg = r3;
    }

    public /* synthetic */ MmCustomException(int r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = -1;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = "unknown";
    L8:
        this(r1, r2);
    }
}
