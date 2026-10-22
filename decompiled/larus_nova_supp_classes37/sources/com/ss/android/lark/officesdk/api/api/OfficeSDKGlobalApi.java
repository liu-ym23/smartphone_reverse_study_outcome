package com.ss.android.lark.officesdk.api.api;

import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\u0007J-\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\u0003*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\f\u001a\u0002H\u0003H&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/api/api/OfficeSDKGlobalApi;", "", "getService", "T", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKCapacity;", "serviceClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKCapacity;", "setHostService", "", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "serviceType", "service", "(Ljava/lang/Class;Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;)V", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface OfficeSDKGlobalApi {
    <T extends IOfficeSDKCapacity> T getService(Class<T> r1);

    <T extends IOfficeSDKProtocol> void setHostService(Class<T> r1, T r2);
}
