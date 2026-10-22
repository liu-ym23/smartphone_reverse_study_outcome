package com.ss.android.lark.framework.assembly.rust;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d0<T> implements ObservableOnSubscribe {
    public final /* synthetic */ String a;
    public final /* synthetic */ com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.b, Object> b;

    public d0(String r1, com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.b, Object> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.b, Object>> r3) {
        Intrinsics.checkNotNullParameter(r3, "emitter");
        String r0 = this.a;
        ThreadLocal<String> r1 = qqb.a.a;
        Intrinsics.checkNotNullParameter(r0, "contextId");
        String r2 = qqb.a.b(r0);
        if (r2.length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        r2 = qqb.a.d();
    L8:
        qqb.a.g(r2);
        r3.onNext(this.b);
        r3.onComplete();
        qqb.a.a();
        return;
    L5:
        r4 = false;
        goto L6
    }
}
