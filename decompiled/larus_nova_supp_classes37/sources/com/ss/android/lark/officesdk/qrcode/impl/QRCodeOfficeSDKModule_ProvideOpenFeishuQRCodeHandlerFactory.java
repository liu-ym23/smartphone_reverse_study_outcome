package com.ss.android.lark.officesdk.qrcode.impl;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import owb.b;
import pwb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class QRCodeOfficeSDKModule_ProvideOpenFeishuQRCodeHandlerFactory implements Factory<b> {
    private final c module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m555get() {
        return provideOpenFeishuQRCodeHandler(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m555get();
    }

    public QRCodeOfficeSDKModule_ProvideOpenFeishuQRCodeHandlerFactory(c r1) {
        this.module = r1;
    }

    public static QRCodeOfficeSDKModule_ProvideOpenFeishuQRCodeHandlerFactory create(c r1) {
        return new QRCodeOfficeSDKModule_ProvideOpenFeishuQRCodeHandlerFactory(r1);
    }

    public static b provideOpenFeishuQRCodeHandler(c r0) {
        r0.getClass();
        Object r1 = (b) OfficeSDKManager.getHostGlobalService(b.class);
        if (r1 != null) goto L6;
        r1 = new pwb.b();
    L6:
        return (b) Preconditions.checkNotNullFromProvides(r1);
    }
}
