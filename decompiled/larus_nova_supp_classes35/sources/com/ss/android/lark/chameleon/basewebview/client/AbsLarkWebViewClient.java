package com.ss.android.lark.chameleon.basewebview.client;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class AbsLarkWebViewClient extends WebViewClient {

    public interface ILoadCanceledCalBack {
        void sslErrorLoadEnsureCancel();
    }

    public abstract void onReceivedSslError(WebView r1, SslErrorHandler r2, SslError r3, ILoadCanceledCalBack r4);

    public AbsLarkWebViewClient() {
    }
}
