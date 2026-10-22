package com.ss.android.lark.imageqrcode.ui;

import com.ss.android.lark.imageqrcode.QRCodeShowParam;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements RxScheduledExecutor.Producer {
    public final /* synthetic */ QRCodeShowParam a;

    public c(QRCodeShowParam r1) {
        this.a = r1;
    }

    public final Object produce() {
        int r0 = com.ss.android.lark.imageqrcode.utils.a.a;
        return com.ss.android.lark.imageqrcode.utils.a.a(this.a.getPath());
    }
}
