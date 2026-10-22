package com.lynx.tasm.service;

import com.lynx.jsbridge.network.HttpRequest;
import i8a.i;
import z5a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ILynxHttpService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.ILynxHttpService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxHttpService r0) {
            return ILynxHttpService.class;
        }
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    void request(HttpRequest r1, i r2);

    void requestStreaming(HttpRequest r1, i r2, a r3);
}
