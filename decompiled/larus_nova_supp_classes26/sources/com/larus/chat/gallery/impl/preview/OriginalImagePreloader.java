package com.larus.chat.gallery.impl.preview;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class OriginalImagePreloader {
    public static final OriginalImagePreloader a = null;

    static {
        a = new OriginalImagePreloader();
    }

    public OriginalImagePreloader() {
    }

    public final Object b(String r5, String r6, Continuation<? super Boolean> r7) {
        if ((r7 instanceof OriginalImagePreloader$awaitReady$1) == false) goto L7;
        OriginalImagePreloader$awaitReady$1 r0 = (OriginalImagePreloader$awaitReady$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        boolean r9 = Intrinsics.areEqual(r8, Boxing.boxBoolean(true));
        FLogger.a.i("OriginalImagePreloader", "awaitReady: result=" + r9);
        return Boxing.boxBoolean(r9);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        OriginalImagePreloader$awaitReady$result$1 r10 = new OriginalImagePreloader$awaitReady$result$1(r5, r6, null);
        r0.label = 1;
        r8 = TimeoutKt.c(5000, r10, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new OriginalImagePreloader$awaitReady$1(this, r7);
        goto L8
    }

    public static final Object a(OriginalImagePreloader r9, String r10, String r11, Continuation r12) {
        r9.getClass();
        if ((r12 instanceof OriginalImagePreloader$awaitPrefetchReady$1) == false) goto L7;
        OriginalImagePreloader$awaitPrefetchReady$1 r0 = (OriginalImagePreloader$awaitPrefetchReady$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        DataSource r15 = (DataSource) r0.L$2;
        String r16 = (String) r0.L$1;
        String r17 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L25:
        return r13;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = (String) r0.L$1;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        DataSource r18 = (DataSource) r13;
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.L$2 = r18;
        r0.label = 2;
        kotlinx.coroutines.j r3 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r3.C();
        r18.subscribe(new a(r11, r10, r3), CallerThreadExecutor.getInstance());
        r3.i(new b(r18));
        r13 = r3.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L22:
        if (r13 != r14) goto L25;
        return r14;
    L16:
        ResultKt.throwOnFailure(r13);
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.label = 1;
        r13 = ImageLoaderKt.C(r10, r11, null, null, r0, 60);
        if (r13 != r14) goto L19;
        return r14;
    L7:
        r0 = new OriginalImagePreloader$awaitPrefetchReady$1(r9, r12);
        goto L8
    }
}
