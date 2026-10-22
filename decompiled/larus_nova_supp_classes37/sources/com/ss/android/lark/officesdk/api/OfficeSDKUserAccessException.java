package com.ss.android.lark.officesdk.api;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/OfficeSDKUserAccessException;", "Lcom/ss/android/lark/officesdk/api/OfficeSDKException;", "errorCode", "", "message", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getErrorCode", "()Ljava/lang/String;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeSDKUserAccessException extends OfficeSDKException {
    private final String errorCode;

    public final String getErrorCode() {
        return this.errorCode;
    }

    public OfficeSDKUserAccessException(String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, "errorCode");
        Intrinsics.checkNotNullParameter(r4, "message");
        super("[" + r3 + "] " + r4, r5);
        this.errorCode = r3;
    }

    public /* synthetic */ OfficeSDKUserAccessException(String r1, String r2, Throwable r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
