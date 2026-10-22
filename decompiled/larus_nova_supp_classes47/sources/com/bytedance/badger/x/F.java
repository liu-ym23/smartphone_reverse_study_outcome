package com.bytedance.badger.x;

import android.security.keystore.KeyGenParameterSpec;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class F extends Lambda implements Function0 {
    final /* synthetic */ String a;
    final /* synthetic */ int b;

    public F(String r1, int r2) {
        this.a = r1;
        this.b = r2;
        super(0);
    }

    public Object invoke() {
        return new KeyGenParameterSpec.Builder(this.a, this.b);
    }
}
