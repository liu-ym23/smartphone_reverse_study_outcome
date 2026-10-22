package com.larus.platform.service;

import com.larus.platform.api.v3;
import com.larus.platform.service.watermark.LocalImageWatermarkRequest;
import com.larus.platform.service.watermark.g;
import com.larus.utils.logger.FLogger;
import java.util.ArrayDeque;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class DownloadWatermarkService {
    public static final DownloadWatermarkService a = null;
    public static final HashSet<String> b = null;
    public static final ArrayDeque<String> c = null;
    public static final Lazy d = null;

    public DownloadWatermarkService() {
    }

    static {
        a = new DownloadWatermarkService();
        b = new HashSet();
        c = new ArrayDeque();
        d = LazyKt.lazy(new j0());
    }

    public static boolean d() {
        if (((v3) d.getValue()) != null) goto L7;
        return false;
    L7:
        return e();
    }

    public static boolean e() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(n0.a.b()));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L11;
        FLogger.a.w("DownloadWatermarkSvc", "isInEnterpriseMode failed, fallback false: " + r2);
        r1 = Boolean.FALSE;
    L11:
        if (((Boolean) r1).booleanValue() == true) goto L26;
        return false;
    L26:
        Object r3 = Result.constructor-impl(Boolean.valueOf(z2.a.enableEnterpriseDownloadWatermark()));     // Catch: Throwable -> L16
    L18:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L23;
        FLogger.a.w("DownloadWatermarkSvc", "settings read failed, fallback true: " + r4);
        r3 = Boolean.TRUE;
    L23:
        return ((Boolean) r3).booleanValue();
    L16:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        if (StringsKt.isBlank(r3) == false) goto L5;
        return;
    L5:
        HashSet<String> r0 = b;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (r0.add(r3) == true) goto L11;
        monitor-exit(r0);
        return;
    L11:
        c.addLast(r3);     // Catch: Throwable -> L18
    L12:
        ArrayDeque<String> r4 = c;     // Catch: Throwable -> L18
        if (r4.size() <= 128) goto L15;
        b.remove(r4.removeFirst());     // Catch: Throwable -> L18
        goto L12
    L15:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
    }

    public final Object a(com.larus.platform.service.watermark.a r5, Continuation<? super g> r6) {
        if ((r6 instanceof DownloadWatermarkService$applyWatermarkToFileAsLocal$1) == false) goto L7;
        DownloadWatermarkService$applyWatermarkToFileAsLocal$1 r0 = (DownloadWatermarkService$applyWatermarkToFileAsLocal$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L13
    L28:
        Object r8 = Result.constructor-impl((g) r7);     // Catch: Throwable -> L13
    L31:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L38;
        FLogger.a.w("DownloadWatermarkSvc", "applyWatermarkToFileAsLocal failed: " + r9);
        return new g.a("applyWatermarkToFileAsLocal exception: " + r9.getMessage());
    L38:
        return r8;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r7);
        v3 r10 = (v3) d.getValue();
        if (r10 != null) goto L22;
        return new g.a("service unavailable");
    L22:
        if (e() == false) goto L24;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r7 = r10.b(r5, r0);     // Catch: Throwable -> L13
        if (r7 != r2) goto L28;
        return r2;
    L24:
        return new g.a("gate closed");
    L13:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new DownloadWatermarkService$applyWatermarkToFileAsLocal$1(this, r6);
        goto L8
    }

    public final Object b(LocalImageWatermarkRequest r5, Continuation<? super g> r6) {
        if ((r6 instanceof DownloadWatermarkService$applyWatermarkToLocalImage$1) == false) goto L7;
        DownloadWatermarkService$applyWatermarkToLocalImage$1 r0 = (DownloadWatermarkService$applyWatermarkToLocalImage$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L13
    L28:
        Object r8 = Result.constructor-impl((g) r7);     // Catch: Throwable -> L13
    L31:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L38;
        FLogger.a.w("DownloadWatermarkSvc", "applyWatermarkToLocalImage failed: " + r9);
        return new g.a("applyWatermarkToLocalImage exception: " + r9.getMessage());
    L38:
        return r8;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r7);
        v3 r10 = (v3) d.getValue();
        if (r10 != null) goto L22;
        return new g.a("service unavailable");
    L22:
        if (e() == false) goto L24;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r7 = r10.c(r5, r0);     // Catch: Throwable -> L13
        if (r7 != r2) goto L28;
        return r2;
    L24:
        return new g.a("gate closed");
    L13:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new DownloadWatermarkService$applyWatermarkToLocalImage$1(this, r6);
        goto L8
    }

    public final Object c(com.larus.platform.service.watermark.d r5, Continuation<? super g> r6) {
        if ((r6 instanceof DownloadWatermarkService$exchangeWatermarkUrl$1) == false) goto L7;
        DownloadWatermarkService$exchangeWatermarkUrl$1 r0 = (DownloadWatermarkService$exchangeWatermarkUrl$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L13
    L38:
        Object r8 = Result.constructor-impl((g) r7);     // Catch: Throwable -> L13
    L41:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L45;
        FLogger.a.w("DownloadWatermarkSvc", "exchangeWatermarkUrl failed: " + r9);
        r8 = new g.a("exchangeWatermarkUrl exception: " + r9.getMessage());
    L45:
        g r10 = (g) r8;
        if ((r10 instanceof g.b) == false) goto L48;
        g.b r11 = (g.b) r10;
    L49:
        if (r11 == null) goto L51;
        DownloadWatermarkService r4 = a;
        String r12 = r11.a;
        r4.getClass();
        f(r12);
    L51:
        return r8;
    L48:
        r11 = null;
        goto L49
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r7);
        String r13 = r5.a;
        Intrinsics.checkNotNullParameter(r13, "url");
        if (StringsKt.isBlank(r13) == false) goto L20;
        boolean r14 = false;
    L24:
        if (r14 == false) goto L27;
        FLogger.a.i("DownloadWatermarkSvc", "skip resolved watermark url");
        return new g.b(r5.a);
    L27:
        v3 r15 = (v3) d.getValue();
        if (r15 != null) goto L32;
        return new g.a("service unavailable");
    L32:
        if (e() == false) goto L34;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r7 = r15.a(r5, r0);     // Catch: Throwable -> L13
        if (r7 != r2) goto L38;
        return r2;
    L34:
        return new g.a("gate closed");
    L20:
        HashSet<String> r17 = b;
        monitor-enter(r17);
        r14 = r17.contains(r13);     // Catch: Throwable -> L52
        monitor-exit(r17);
    L52:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new DownloadWatermarkService$exchangeWatermarkUrl$1(this, r6);
        goto L8
    }
}
