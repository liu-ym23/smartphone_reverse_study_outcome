package com.ss.android.lark.officesdk.container;

import com.bytedance.lark.sdk.refactor.n;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/container/U2OUEntryPoint;", "", "getRustSDK", "Lcom/bytedance/lark/sdk/refactor/IRustSDK;", "getUserId", "", "getOfficeSDKUserComponentManager", "Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponentManager;", "officesdk-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface U2OUEntryPoint {
    OfficeSDKUserComponentManager getOfficeSDKUserComponentManager();

    n getRustSDK();

    String getUserId();
}
