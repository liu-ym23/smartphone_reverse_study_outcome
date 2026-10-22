package com.ss.android.lark.officesdk.api.init;

import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/IEnvProvider;", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "getTTEnv", "", "getEnv", "", "()Ljava/lang/Integer;", "env-officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface IEnvProvider extends IOfficeSDKProtocol {
    Integer getEnv();

    String getTTEnv();
}
