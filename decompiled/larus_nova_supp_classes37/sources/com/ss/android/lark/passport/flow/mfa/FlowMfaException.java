package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowMfaException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "error", "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaError;", "<init>", "(Lcom/ss/android/lark/passport/flow/mfa/FlowMfaError;)V", "getError", "()Lcom/ss/android/lark/passport/flow/mfa/FlowMfaError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class FlowMfaException extends RuntimeException {
    private final FlowMfaError error;

    public static /* synthetic */ FlowMfaException copy$default(FlowMfaException r0, FlowMfaError r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.error;
    L6:
        return r0.copy(r1);
    }

    public final FlowMfaError component1() {
        return this.error;
    }

    public final FlowMfaException copy(FlowMfaError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        return new FlowMfaException(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof FlowMfaException) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.error, ((FlowMfaException) r4).error) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.error.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "FlowMfaException(error=" + this.error + ')';
    }

    public final FlowMfaError getError() {
        return this.error;
    }

    public FlowMfaException(FlowMfaError r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        super(r3.getMessage(), r3.getCause());
        this.error = r3;
    }
}
