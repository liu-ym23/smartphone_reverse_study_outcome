package com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmEditTitleResponse;", "Ljava/io/Serializable;", "result", "", "<init>", "(Ljava/lang/String;)V", "getResult", "()Ljava/lang/String;", "setResult", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmEditTitleResponse implements Serializable {
    private String result;

    public MmEditTitleResponse() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public final String getResult() {
        return this.result;
    }

    public MmEditTitleResponse(String r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        this.result = r2;
    }

    public final void setResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.result = r2;
    }

    public /* synthetic */ MmEditTitleResponse(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }
}
