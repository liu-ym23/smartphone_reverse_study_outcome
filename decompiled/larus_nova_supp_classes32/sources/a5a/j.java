package a5a;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j extends WebChromeClient {
    public final /* synthetic */ h a;

    public j(h r1) {
        this.a = r1;
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r1, String r2) {
        super.onReceivedTitle(r1, r2);
        h r3 = this.a;
        int r4 = h.c;
        r3.a("if (!window.logbox) {  (function () {    var id = 0, callbacks = {}, eventListeners = {};    var nativeBridge = window.nativeBridge || window.webkit.messageHandlers.nativeBridge;    window.logbox = {      call: function(bridgeName, callback, data) {        var thisId = id++;        callbacks[thisId] = callback;        nativeBridge.postMessage(JSON.stringify({          bridgeName: bridgeName,          data: data ? JSON.stringify(data) : {},          callbackId: thisId        }));      },      on: function(event, handler) {        eventListeners[event] = handler;      },      sendResult: function(msg) {        var callbackId = msg.callbackId;        if (callbacks[callbackId]) {          callbacks[callbackId](msg.data);        }      },      sendEvent: function(msg) {        if (eventListeners[msg.event]) {          eventListeners[msg.event](msg.data);        }      }    };  })();  setTimeout(function(){document.dispatchEvent(new Event('LogBoxReady'))}, 0);};");
    }
}
