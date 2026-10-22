package com.lynx.tasm.service;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.IServiceProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onInitialize(IServiceProvider r0, Context r1) {
        }
    }

    Class<? extends IServiceProvider> getServiceClass();

    void onInitialize(Context r1);
}
