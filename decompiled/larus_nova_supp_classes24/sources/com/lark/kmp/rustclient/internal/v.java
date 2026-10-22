package com.lark.kmp.rustclient.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class v extends WaitConditionInterceptor {
    public final com.lark.kmp.rustclient.barrier.a d;

    public static final class a implements com.lark.kmp.rustclient.barrier.b {
        public final /* synthetic */ v a;

        public a(v r1) {
            this.a = r1;
        }

        @Override // com.lark.kmp.rustclient.barrier.b
        public final Object a(boolean r1, Continuation<? super Unit> r2) {
            if (r1 == true) goto L9;
            Object r3 = this.a.e(r2);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
            return r3;
        L7:
            return Unit.INSTANCE;
        L9:
            return Unit.INSTANCE;
        }
    }

    public v(com.lark.kmp.rustclient.barrier.a r2) {
        Intrinsics.checkNotNullParameter(r2, "rustBarrier");
        super(0);
        this.d = r2;
        r2.a(new a(this));
    }

    @Override // com.lark.kmp.rustclient.internal.WaitConditionInterceptor
    public final <T> boolean c(com.lark.kmp.rustclient.api.a<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        return !this.d.c();
    }
}
