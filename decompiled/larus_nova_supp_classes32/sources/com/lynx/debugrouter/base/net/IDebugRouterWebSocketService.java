package com.lynx.debugrouter.base.net;

import com.lynx.debugrouter.base.NativeMessageTransceiver;
import com.lynx.debugrouter.base.service.IRouterServiceProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IDebugRouterWebSocketService extends IRouterServiceProvider {
    NativeMessageTransceiver init(long r1);
}
