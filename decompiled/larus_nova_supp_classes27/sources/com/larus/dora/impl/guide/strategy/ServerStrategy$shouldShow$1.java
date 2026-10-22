package com.larus.dora.impl.guide.strategy;

import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.network.HttpConst;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.strategy.ServerStrategy", f = "ServerStrategy.kt", i = {}, l = {54}, m = "shouldShow-IoAF18A", n = {}, s = {})
final class ServerStrategy$shouldShow$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ f this$0;

    public ServerStrategy$shouldShow$1(f r1, Continuation<? super ServerStrategy$shouldShow$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        this.label |= Integer.MIN_VALUE;
        f r13 = this.this$0;
        int r1 = f.c;
        r13.getClass();
        int r3 = this.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r3 - Integer.MIN_VALUE;
        ServerStrategy$shouldShow$1 r7 = this;
    L6:
        Object r0 = r7.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r7.label;
        if (r4 == 0) goto L13;
        if (r4 != 1) goto L12;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L37
    L17:
        y r2 = (com.larus.network.http.a) r0;     // Catch: Throwable -> L37
        if ((r2 instanceof y) == false) goto L31;
        Long r14 = r2.g;     // Catch: Throwable -> L37
        if (r14 == null) goto L31;
        if (r14.longValue() != 0) goto L31;
        f.b r15 = (f.b) ((com.larus.network.http.a) r2).b;     // Catch: Throwable -> L37
        if (r15 == null) goto L29;
        Boolean r16 = r15.a();     // Catch: Throwable -> L37
        if (r16 == null) goto L29;
        boolean r17 = r16.booleanValue();     // Catch: Throwable -> L37
    L30:
        g49.d.d("ServerStrategy", "shouldShow() success, allowBindGuide=" + r17);     // Catch: Throwable -> L37
        Object r18 = Result.constructor-impl(Boxing.boxBoolean(r17));     // Catch: Throwable -> L37
    L39:
        r9 = r18;
        Throwable r110 = Result.exceptionOrNull-impl(r9);
        if (r110 == null) goto L43;
        g49.d.c("ServerStrategy", "shouldShow() error: " + r110.getMessage(), r110);
    L43:
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        return r9;
    L46:
        return Result.box-impl(r9);
    L29:
        r17 = false;
    L31:
        StringBuilder r5 = new StringBuilder("http error, code=");     // Catch: Throwable -> L37
        if ((r2 instanceof y) == false) goto L34;
        Long r6 = r2.g;     // Catch: Throwable -> L37
    L35:
        r5.append(r6);     // Catch: Throwable -> L37
        throw new IllegalStateException(r5.toString());     // Catch: Throwable -> L37
    L34:
        r6 = Boxing.boxLong(-1);     // Catch: Throwable -> L37
        goto L35
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r0);
        g49.d.d("ServerStrategy", "shouldShow() start, usingA2dp=" + r13.a);
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L37
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L37
        HttpConst.a.getClass();     // Catch: Throwable -> L37
        r10.append(HttpConst.m);     // Catch: Throwable -> L37
        r10.append("/alice/w/libra/allow_bind_guide");     // Catch: Throwable -> L37
        String r11 = r10.toString();     // Catch: Throwable -> L37
        Map r20 = MapsKt.mapOf(TuplesKt.to("using_a2dp_audio", String.valueOf(r13.a)));     // Catch: Throwable -> L37
        r7.label = 1;     // Catch: Throwable -> L37
        r0 = HttpExtKt.h("ServerStrategy", f.b.class, r11, r20, r7, BaiduNaviStatus.NO_PERMISSION);     // Catch: Throwable -> L37
        if (r0 != r9) goto L17;
    L37:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L5:
        r7 = new ServerStrategy$shouldShow$1(r13, this);
        goto L6
    }
}
