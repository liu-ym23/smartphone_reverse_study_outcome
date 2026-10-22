package com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool;

import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IWebViewPool {

    public interface TraverseAction {
        boolean onWebViewTraverse(ChameleonWebView r1);
    }

    public interface WebViewLifecycleListener {
        void onWebViewCreated(ChameleonWebView r1);

        void onWebViewDestroyed(ChameleonWebView r1);
    }

    ChameleonWebView createWebView(ChameleonConfig r1);

    void destroyAll();

    void destroyWebView(ChameleonWebView r1);

    ChameleonWebView detachWebView(Object r1);

    ChameleonWebView getCurWebView(Object r1, boolean r2);

    WebViewPool.WebViewItem getCurWebViewItem(Object r1, boolean r2);

    ChameleonWebView getOverMaxUsedWebView(int r1);

    int occupiedSize();

    int poolSize();

    ChameleonWebView provideWebView(Object r1, boolean r2);

    void setWebViewLifeCycleListener(WebViewLifecycleListener r1);

    void traversePool(TraverseAction r1);
}
