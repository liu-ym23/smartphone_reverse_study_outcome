package com.ss.android.lark.officesdk.integrator.im.impl;

import com.ss.android.lark.preload.v2.api.IPrimaryTabService;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class l implements IPrimaryTabService {
    @Inject
    public l() {
    }

    @Override // com.ss.android.lark.preload.v2.api.IPrimaryTabService
    public final String getDefaultTabName() {
        return "message";
    }
}
