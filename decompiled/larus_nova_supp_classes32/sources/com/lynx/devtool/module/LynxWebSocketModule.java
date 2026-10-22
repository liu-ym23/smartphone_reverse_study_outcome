package com.lynx.devtool.module;

import com.lynx.jsbridge.LynxContextModule;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxWebSocketModule extends LynxContextModule implements LynxWebSocket.Delegate {
    public static final String NAME = "LynxWebSocketModule";
    private final LynxWebSocket mWebSocket;

    @Override // com.lynx.jsbridge.LynxContextModule, com.lynx.jsbridge.LynxModule
    public void destroy() {
        super.destroy();
        this.mWebSocket.destroy();
    }

    public LynxWebSocketModule(LynxContext r1) {
        super(r1);
        this.mWebSocket = new LynxWebSocket(this);
    }

    @LynxMethod
    public void ping(double r2) {
        this.mWebSocket.ping(r2);
    }

    @LynxMethod
    public void send(String r2, double r3) {
        this.mWebSocket.send(r2, r3);
    }

    @Override // com.lynx.devtool.module.LynxWebSocket.Delegate
    public void sendEvent(String r2, WritableMap r3) {
        JavaOnlyArray r0 = new JavaOnlyArray();
        r0.pushMap(r3);
        this.mLynxContext.sendGlobalEvent(r2, r0);
    }

    @LynxMethod
    public void close(double r7, String r9, double r10) {
        this.mWebSocket.close(r7, r9, r10);
    }

    @LynxMethod
    public void connect(String r7, ReadableArray r8, ReadableMap r9, double r10) {
        this.mWebSocket.connect(r7, r8, r9, r10);
    }
}
