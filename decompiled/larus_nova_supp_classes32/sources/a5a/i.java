package a5a;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i extends WebViewClient {
    public final /* synthetic */ h a;

    public i(h r1) {
        this.a = r1;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r1, String r2) {
        super.onPageFinished(r1, r2);
        h r3 = this.a;
        int r4 = h.c;
        r3.a("if (!window.logbox) {  (function () {    var id = 0, callbacks = {}, eventListeners = {};    var nativeBridge = window.nativeBridge || window.webkit.messageHandlers.nativeBridge;    window.logbox = {      call: function(bridgeName, callback, data) {        var thisId = id++;        callbacks[thisId] = callback;        nativeBridge.postMessage(JSON.stringify({          bridgeName: bridgeName,          data: data ? JSON.stringify(data) : {},          callbackId: thisId        }));      },      on: function(event, handler) {        eventListeners[event] = handler;      },      sendResult: function(msg) {        var callbackId = msg.callbackId;        if (callbacks[callbackId]) {          callbacks[callbackId](msg.data);        }      },      sendEvent: function(msg) {        if (eventListeners[msg.event]) {          eventListeners[msg.event](msg.data);        }      }    };  })();  setTimeout(function(){document.dispatchEvent(new Event('LogBoxReady'))}, 0);};");
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r1, WebResourceRequest r2, WebResourceError r3) {
        super.onReceivedError(r1, r2, r3);
        ((b) this.a).g.booleanValue();
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r1, WebResourceRequest r2, WebResourceResponse r3) {
        super.onReceivedHttpError(r1, r2, r3);
        ((b) this.a).g.booleanValue();
    }
}
