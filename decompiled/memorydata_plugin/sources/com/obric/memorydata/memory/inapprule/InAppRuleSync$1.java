package com.obric.memorydata.memory.inapprule;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.channels.m;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.inapprule.InAppRuleSync$1", f = "InAppRuleSync.kt", i = {}, l = {27, 30, 31}, m = "invokeSuspend", n = {}, s = {})
final class InAppRuleSync$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;

    InAppRuleSync$1(Continuation<? super InAppRuleSync$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new InAppRuleSync$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((InAppRuleSync$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), InAppRuleSync$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0103 -> B:31:0x0106). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$1, Iterator.class, "com.obric.memorydata.plugin");
        k r8 = (k) ZeusTransformUtils.preCheckCast(this.L$0, k.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L32:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L34;
    L37:
        k r3 = r8;
    L14:
        Continuation<? super Boolean> r14 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r3;
        this.L$1 = null;
        this.label = 1;
        r13 = r3.a(r14);
        if (r13 != r0) goto L18;
        return r0;
    L18:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L39;
        r3.a();
        k r11 = r3;
        r2 = CollectionsKt.listOf(new Long[]{Boxing.boxLong(0), Boxing.boxLong(30000), Boxing.boxLong(120000), Boxing.boxLong(600000)}).iterator();
        k r15 = r11;
    L21:
        if (r2.hasNext() == true) goto L22;
        r3 = r15;
        goto L14
    L22:
        long r9 = ((Number) ZeusTransformUtils.preCheckCast(r2.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r9 <= 0) goto L27;
        Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r15;
        this.L$1 = r2;
        this.label = 2;
        if (au.a(r9, r10) != r0) goto L27;
        return r0;
    L27:
        r8 = r15;
    L28:
        d r16 = d.f10154a;
        Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r8;
        this.L$1 = r2;
        this.label = 3;
        r13 = d.a(r16, r12);
        if (r13 != r0) goto L32;
        return r0;
    L39:
        return Unit.INSTANCE;
    L34:
        if (m.a(d.b().i()) == false) goto L36;
        d.b().mo54trySendJP2dKIU(Unit.INSTANCE);
        goto L37
    L36:
        r15 = r8;
        goto L21
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$1, Iterator.class, "com.obric.memorydata.plugin");
        r8 = (k) ZeusTransformUtils.preCheckCast(this.L$0, k.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
        goto L28
    L11:
        r3 = (k) ZeusTransformUtils.preCheckCast(this.L$0, k.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
        goto L18
    L12:
        ResultKt.throwOnFailure(r13);
        r3 = d.b().l();
        goto L14
    }
}
