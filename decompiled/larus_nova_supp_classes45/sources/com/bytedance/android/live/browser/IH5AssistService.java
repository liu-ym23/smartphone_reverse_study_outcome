package com.bytedance.android.live.browser;

import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.livesdkapi.base.ILiveBrowserFragment;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH&J\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/browser/IH5AssistService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/os/Bundle;", "bundle", "Lcom/bytedance/android/livesdkapi/base/ILiveBrowserFragment;", "createSaaSDeprecatedBrowserFragment", "Lcom/bytedance/android/live/browser/webview/fragment/BaseWebDialogFragment;", "createWebDialogFragment", "Lcom/bytedance/android/annie/xbridge/mix/e;", "getExternalMethodInjector", "", "bid", "", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "providerMethod", "providerPreHandleMethod", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IH5AssistService extends IService {
    ILiveBrowserFragment createSaaSDeprecatedBrowserFragment(Bundle r1);

    BaseWebDialogFragment createWebDialogFragment();

    com.bytedance.android.annie.xbridge.mix.e getExternalMethodInjector();

    Map<String, IDLXBridgeMethod> providerMethod(String r1);

    Map<String, IDLXBridgeMethod> providerPreHandleMethod(String r1);
}
