package com.larus.dora.impl.guide.service;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t39.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/api/IDoraGuideInteractor;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$selectNextGuide$2", f = "DoraGuideServiceImpl.kt", i = {0, 0}, l = {582}, m = "invokeSuspend", n = {"$this$withContext", "element$iv"}, s = {"L$0", "L$3"})
final class GuideSession$selectNextGuide$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super l>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$selectNextGuide$2(GuideSession r1, Continuation<? super GuideSession$selectNextGuide$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        GuideSession$selectNextGuide$2 r0 = new GuideSession$selectNextGuide$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super l> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0092 -> B:20:0x009a). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Object r2 = this.L$3;
        Iterator r3 = (Iterator) this.L$2;
        GuideSession r4 = (GuideSession) this.L$1;
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
        CoroutineScope r6 = r5;
        GuideSession r7 = r4;
        Iterator r8 = r3;
        Object r9 = r2;
        Object r10 = r0;
        GuideSession$selectNextGuide$2 r11 = this;
    L21:
        if (((Boolean) r12).booleanValue() == true) goto L28;
        GuideSession$selectNextGuide$2 r13 = r11;
        r0 = r10;
        Iterator r14 = r8;
        GuideSession r15 = r7;
        CoroutineScope r16 = r6;
    L10:
        if (r14.hasNext() == false) goto L24;
        Object r17 = r14.next();
        l r18 = (l) r17;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L14
        g49.d.d(r15.c(), "launchNextGuide checking guide=" + r18.f() + ':' + r18);     // Catch: Throwable -> L14
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        r13.L$0 = r16;
        r13.L$1 = r15;
        r13.L$2 = r14;
        r13.L$3 = r17;
        r13.label = 1;
        Object r21 = r18.c(r13);
        if (r21 != r0) goto L19;
        return r0;
    L19:
        Object r110 = r0;
        r11 = r13;
        r12 = r21;
        r6 = r16;
        r7 = r15;
        r8 = r14;
        r9 = r17;
        r10 = r110;
    L14:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L24:
        return null;
    L28:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        GuideSession r23 = this.this$0;
        r14 = r23.j.iterator();
        r16 = r111;
        r15 = r23;
        r13 = this;
        goto L10
    }
}
