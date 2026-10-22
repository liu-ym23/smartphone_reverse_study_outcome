package com.obric.aikernel.res.task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: classes2.dex */
public final class NamedTaskScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NamedTaskScheduler f5100a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, a> f5101b = null;

    static {
        f5100a = new NamedTaskScheduler();
        f5101b = new ConcurrentHashMap();
    }

    private NamedTaskScheduler() {
    }

    public final <T> Object a(String r10, Function1<? super Continuation<? super T>, ? extends Object> r11, Continuation<? super T> r12) {
        if ((r12 instanceof NamedTaskScheduler$executeWith$1) == false) goto L7;
        NamedTaskScheduler$executeWith$1 r13 = (NamedTaskScheduler$executeWith$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L20;
        if (r17 == 1) goto L19;
        if (r17 != 2) goto L18;
        a r18 = (a) r13.L$1;
        String r19 = (String) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L15
    L30:
        r18.c(r19);
        return r15;
    L15:
        th = th;
    L34:
        r18.c(r19);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        a r20 = (a) r13.L$2;
        r11 = (Function1) r13.L$1;
        String r21 = (String) r13.L$0;
        ResultKt.throwOnFailure(r15);
        a r22 = r20;
        r10 = r21;
    L38:
        r13.L$0 = r10;     // Catch: Throwable -> L32
        r13.L$1 = r22;     // Catch: Throwable -> L32
        r13.L$2 = null;     // Catch: Throwable -> L32
        r13.label = 2;     // Catch: Throwable -> L32
        r15 = r11.invoke(r13);     // Catch: Throwable -> L32
        if (r15 != r16) goto L29;
        return r16;
    L29:
        r19 = r10;
        r18 = r22;
    L32:
        th = th;
        r19 = r10;
        r18 = r22;
        goto L34
    L20:
        ResultKt.throwOnFailure(r15);
        Map<String, a> r23 = f5101b;
        a r24 = r23.get(r10);
        if (r24 != null) goto L23;
        r24 = MutexKt.b(false, 1, null);
        r23.put(r10, r24);
    L23:
        r22 = r24;
        r13.L$0 = r10;
        r13.L$1 = r11;
        r13.L$2 = r22;
        r13.label = 1;
        if (r22.b(r10, r13) != r16) goto L38;
        return r16;
    L7:
        r13 = new NamedTaskScheduler$executeWith$1(this, r12);
        goto L8
    }
}
