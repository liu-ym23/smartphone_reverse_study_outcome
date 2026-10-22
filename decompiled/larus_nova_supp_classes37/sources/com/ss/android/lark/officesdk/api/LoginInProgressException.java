package com.ss.android.lark.officesdk.api;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/api/LoginInProgressException;", "Lcom/ss/android/lark/officesdk/api/OfficeSDKException;", "message", "", "<init>", "(Ljava/lang/String;)V", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class LoginInProgressException extends OfficeSDKException {
    public LoginInProgressException() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public LoginInProgressException(String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        super(r3, null, 2, null);
    }

    public /* synthetic */ LoginInProgressException(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "User login is in progress";
    L5:
        this(r1);
    }
}
