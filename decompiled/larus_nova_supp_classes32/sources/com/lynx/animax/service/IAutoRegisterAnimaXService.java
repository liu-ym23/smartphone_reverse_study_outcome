package com.lynx.animax.service;

import w4a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IAutoRegisterAnimaXService extends IAnimaXService {

    /* JADX INFO: renamed from: com.lynx.animax.service.IAutoRegisterAnimaXService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static e $default$getAutoRegisterServiceScope(IAutoRegisterAnimaXService r0) {
            return e.b;
        }
    }

    e getAutoRegisterServiceScope();

    Class<? extends IAnimaXService> getServiceClass();
}
