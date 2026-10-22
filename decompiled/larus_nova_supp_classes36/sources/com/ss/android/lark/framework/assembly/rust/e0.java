package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.sdk.InvokeResponse;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e0 implements com.bytedance.lark.rustclient.api.m {

    public static final class a<T, R> implements Function {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            com.bytedance.lark.rustclient.api.s r4 = (com.bytedance.lark.rustclient.api.s) r3;
            Intrinsics.checkNotNullParameter(r4, "value");
            return Observable.create(new d0(this.a, r4));
        }
    }

    @Inject
    public e0() {
    }

    public final <Resp> Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.b, Resp>> a(com.bytedance.lark.rustclient.api.n<Resp> r3) {
        Intrinsics.checkNotNullParameter(r3, "chain");
        com.bytedance.lark.rustclient.api.b r0 = r3.c;
        String r1 = ((com.bytedance.lark.rustclient.api.a) r0.a).b;
        return r3.b(r0).flatMap(new a(r1));
    }

    public final <Resp> com.bytedance.lark.rustclient.api.s<InvokeResponse, Resp> b(com.bytedance.lark.rustclient.api.n<Resp> r2) {
        Intrinsics.checkNotNullParameter(r2, "chain");
        return r2.a(r2.c);
    }
}
