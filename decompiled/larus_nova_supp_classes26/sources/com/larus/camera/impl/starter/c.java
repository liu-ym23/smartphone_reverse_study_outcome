package com.larus.camera.impl.starter;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ com.bytedance.router.c a;

    public /* synthetic */ c(com.bytedance.router.c r1) {
        this.a = r1;
    }

    public final Object invoke() {
        return UriProtector.getQueryParameter(this.a.d, "capture_mode");
    }
}
