package com.ss.android.lark.officesdk.api;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/api/ServiceNotImplementedException;", "Lcom/ss/android/lark/officesdk/api/OfficeSDKException;", "serviceName", "", "<init>", "(Ljava/lang/String;)V", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ServiceNotImplementedException extends OfficeSDKException {
    public ServiceNotImplementedException(String r3) {
        Intrinsics.checkNotNullParameter(r3, "serviceName");
        super("Service not implemented: " + r3, null, 2, null);
    }
}
