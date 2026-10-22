package gvb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpErrorMsg;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpErrorResp;", "", "code", "", "commonErrorMsg", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpErrorMsg;", "<init>", "(ILcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpErrorMsg;)V", "getCode", "()I", "setCode", "(I)V", "getCommonErrorMsg", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpErrorMsg;", "setCommonErrorMsg", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpErrorMsg;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class b {

    @SerializedName("code")
    private int code;

    @SerializedName("newMsg")
    private MmHttpErrorMsg commonErrorMsg;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commonErrorMsg, r6.commonErrorMsg) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.code * 31;
        MmHttpErrorMsg r1 = this.commonErrorMsg;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmHttpErrorResp(code=" + this.code + ", commonErrorMsg=" + this.commonErrorMsg + ')';
    }

    public b() {
        this.code = 0;
        this.commonErrorMsg = null;
    }

    public final int a() {
        return this.code;
    }

    public final MmHttpErrorMsg b() {
        return this.commonErrorMsg;
    }
}
