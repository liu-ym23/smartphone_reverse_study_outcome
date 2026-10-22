package com.bytedance.android.annie.bridge.method;

import com.bytedance.pia.core.api.bridge.PiaMethod;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f1<T> implements l47.a {
    public final /* synthetic */ g1 a;

    public f1(g1 r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        g1 r0 = this.a;
        r0.finishWithFailure((PiaMethod.Error) r10);
    }
}
