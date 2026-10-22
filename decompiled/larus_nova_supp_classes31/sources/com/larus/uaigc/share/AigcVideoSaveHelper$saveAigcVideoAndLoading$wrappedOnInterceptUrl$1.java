package com.larus.uaigc.share;

import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.share.AigcVideoSaveHelper$saveAigcVideoAndLoading$wrappedOnInterceptUrl$1", f = "AigcVideoSaveHelper.kt", i = {0}, l = {39, 51}, m = "invokeSuspend", n = {"vid"}, s = {"L$0"})
public final class AigcVideoSaveHelper$saveAigcVideoAndLoading$wrappedOnInterceptUrl$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ Function1<Continuation<? super String>, Object> $onInterceptUrl;
    final /* synthetic */ g $videoPlayData;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AigcVideoSaveHelper this$0;

    public AigcVideoSaveHelper$saveAigcVideoAndLoading$wrappedOnInterceptUrl$1(g r1, AigcVideoSaveHelper r2, Function1<? super Continuation<? super String>, ? extends Object> r3, Continuation<? super AigcVideoSaveHelper$saveAigcVideoAndLoading$wrappedOnInterceptUrl$1> r4) {
        this.$videoPlayData = r1;
        this.this$0 = r2;
        this.$onInterceptUrl = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new AigcVideoSaveHelper$saveAigcVideoAndLoading$wrappedOnInterceptUrl$1(this.$videoPlayData, this.this$0, this.$onInterceptUrl, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super String> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        String r5 = null;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L70:
        String r10 = (String) r9;
        if (r10 != null) goto L83;
    L74:
        g r11 = this.$videoPlayData;
        if (r11 == null) goto L77;
        r5 = r11.c;
    L77:
        if (r5 != null) goto L80;
        return "";
    L80:
        return r5;
    L83:
        return r10;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        g r2 = (g) this.L$1;
        String r6 = (String) this.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L12
    L24:
        g r12 = CreationNoWatermarkManager.a.h0(r6, r2, null);     // Catch: Throwable -> L12
        if (r12 == null) goto L34;
        String r7 = r12.b;     // Catch: Throwable -> L12
        if (r2 == null) goto L29;
        String r8 = r2.b;     // Catch: Throwable -> L12
    L31:
        if (Intrinsics.areEqual(r7, r8) == true) goto L34;
        if (r2 == null) goto L34;
        r2.b = r12.b;     // Catch: Throwable -> L12
        goto L34
    L29:
        r8 = null;
    L34:
        if (r12 == null) goto L43;
        String r13 = r12.d;     // Catch: Throwable -> L12
        if (r2 == null) goto L38;
        String r14 = r2.d;     // Catch: Throwable -> L12
    L40:
        if (Intrinsics.areEqual(r13, r14) == true) goto L43;
        if (r2 == null) goto L43;
        r2.d = r12.d;     // Catch: Throwable -> L12
        goto L43
    L38:
        r14 = null;
    L43:
        if (r12 == null) goto L45;
        String r15 = r12.c;     // Catch: Throwable -> L12
    L46:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L12
    L50:
        if (Result.isFailure-impl(r16) == false) goto L52;
        r16 = null;
    L52:
        String r17 = (String) r16;
        if (r17 != null) goto L55;
    L65:
        Function1<Continuation<? super String>, Object> r18 = this.$onInterceptUrl;
        if (r18 == null) goto L74;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        r9 = r18.invoke(this);
        if (r9 != r0) goto L70;
        return r0;
    L55:
        if (r17.length() > 0) goto L58;
        r4 = false;
    L58:
        if (r4 == true) goto L61;
        r17 = null;
    L61:
        if (r17 == null) goto L65;
        g r3 = this.$videoPlayData;
        if (r3 == null) goto L65;
        r3.c = r17;
        goto L65
    L45:
        r15 = null;
        goto L46
    L14:
        ResultKt.throwOnFailure(r9);
        r2 = this.$videoPlayData;
        if (r2 == null) goto L17;
        String r19 = r2.a;
    L18:
        if (r19 != null) goto L20;
        r6 = "";
    L21:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L12
        CreationNoWatermarkManager r21 = CreationNoWatermarkManager.a;     // Catch: Throwable -> L12
        this.L$0 = r6;     // Catch: Throwable -> L12
        this.L$1 = r2;     // Catch: Throwable -> L12
        this.label = 1;     // Catch: Throwable -> L12
        if (r21.t(r6, "download_save", this) != r0) goto L24;
        return r0;
    L20:
        r6 = r19;
        goto L21
    L17:
        r19 = null;
    L12:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    }
}
