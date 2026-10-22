package com.larus.e_commerce.impl;

import android.content.Context;
import android.content.Intent;
import com.ss.android.ugc.aweme.search.common.impl.ECSaaSPhotoSearchCommand;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class i implements Function0 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Intent b;

    public /* synthetic */ i(Context r1, Intent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        Context r0 = this.a;
        Intent r1 = this.b;
        int r2 = ECommerceServiceImpl.d;
        ECSaaSPhotoSearchCommand.b.getClass();
        ECSaaSPhotoSearchCommand.g(r0, r1);
        return Unit.INSTANCE;
    }
}
