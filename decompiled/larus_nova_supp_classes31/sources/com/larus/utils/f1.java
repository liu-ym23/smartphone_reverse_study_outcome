package com.larus.utils;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.service.r;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f1 {

    public static final class a implements IIMCallback<wc9.e> {
        public final /* synthetic */ kotlinx.coroutines.i<wc9.e> a;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public a(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.resumeWith(Result.constructor-impl(null));
        }

        public final void onSuccess(Object r2) {
            this.a.resumeWith(Result.constructor-impl((wc9.e) r2));
        }
    }

    public static final class b implements IIMCallback<Message> {
        public final /* synthetic */ kotlinx.coroutines.i<Message> a;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public b(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.resumeWith(Result.constructor-impl(null));
        }

        public final void onSuccess(Object r2) {
            Message r3 = (Message) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.resumeWith(Result.constructor-impl(r3));
        }
    }

    public static final Object a(String r10, Continuation<? super wc9.e> r11) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r11), 1);
        r0.C();
        r.a.c(com.larus.im.d.d(), r10, true, new a(r0), null, null, 24);
        Object r12 = r0.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L6:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r12;
    L9:
        return (wc9.e) r12;
    }

    public static final Object b(String r3, Continuation<? super Message> r4) {
        if (StringsKt.isBlank(r3) == false) goto L6;
        return null;
    L6:
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r0.C();
        com.larus.im.d.e().m(r3, new b(r0));
        Object r5 = r0.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L10:
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r5;
    L13:
        return (Message) r5;
    }
}
