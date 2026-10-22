package com.ss.android.lark.officesdk.api.plugin;

import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/api/plugin/IOfficeSDKPluginService;", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "isPluginSupported", "", "pluginId", "", "getPluginState", "Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginState;", "installPlugin", "", "callback", "Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginCallback;", "loadPlugin", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface IOfficeSDKPluginService extends IOfficeSDKProtocol {
    OfficeSDKPluginState getPluginState(String r1);

    void installPlugin(String r1, OfficeSDKPluginCallback r2);

    boolean isPluginSupported(String r1);

    void loadPlugin(String r1, OfficeSDKPluginCallback r2);
}
