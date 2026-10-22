package com.ss.android.lark.officesdk.plugin;

import com.ss.android.lark.officesdk.api.OfficeSDKException;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginError;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/plugin/OfficeSDKPluginException;", "Lcom/ss/android/lark/officesdk/api/OfficeSDKException;", "error", "Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginError;", "cause", "", "<init>", "(Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginError;Ljava/lang/Throwable;)V", "getError", "()Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginError;", "officesdk-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeSDKPluginException extends OfficeSDKException {
    private final OfficeSDKPluginError error;

    public final OfficeSDKPluginError getError() {
        return this.error;
    }

    public OfficeSDKPluginException(OfficeSDKPluginError r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "error");
        super(r2.getMessage(), r3);
        this.error = r2;
    }

    public /* synthetic */ OfficeSDKPluginException(OfficeSDKPluginError r1, Throwable r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
