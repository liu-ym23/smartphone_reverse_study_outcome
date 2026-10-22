package com.ss.android.lark.inline.ai.utils;

import com.bumptech.glide.RequestManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(RequestManager r4, String r5, Continuation r6) {
        j r0 = new j(IntrinsicsKt.intercepted(r6), 1);
        r0.C();
        Ref.IntRef r1 = new Ref.IntRef();
        r4.downloadOnly().load(r5).listener(new c(r1, r0, r4, r5)).preload();
        Object r7 = r0.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r7;
    }
}
