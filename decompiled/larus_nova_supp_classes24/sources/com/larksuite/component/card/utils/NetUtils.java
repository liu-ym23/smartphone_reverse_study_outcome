package com.larksuite.component.card.utils;

import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class NetUtils {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Callback {
        public final /* synthetic */ kotlinx.coroutines.i<Response> a;

        public a(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void onFailure(Call r2, IOException r3) {
            Intrinsics.checkNotNullParameter(r2, "call");
            Intrinsics.checkNotNullParameter(r3, "e");
            kotlinx.coroutines.i<Response> r4 = this.a;
            Result.Companion r0 = Result.Companion;
            r4.resumeWith(Result.constructor-impl(ResultKt.createFailure(r3)));
        }

        public final void onResponse(Call r2, Response r3) {
            Intrinsics.checkNotNullParameter(r2, "call");
            Intrinsics.checkNotNullParameter(r3, "response");
            this.a.resumeWith(Result.constructor-impl(r3));
        }
    }

    static {
    }

    public static Object a(String r3, Continuation r4) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r0.C();
        final Call r5 = new OkHttpClient.Builder().build().newCall(new Request.Builder().url(r3).build());
        r5.enqueue(new a(r0));
        r0.i(new NetUtils$getSuspend$2$2(r5));
        Object r6 = r0.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r6;
    }
}
