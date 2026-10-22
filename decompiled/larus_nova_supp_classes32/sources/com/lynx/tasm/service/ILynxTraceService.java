package com.lynx.tasm.service;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ILynxTraceService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.ILynxTraceService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxTraceService r0) {
            return ILynxTraceService.class;
        }
    }

    long getDefaultTraceFunction();

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();
}
