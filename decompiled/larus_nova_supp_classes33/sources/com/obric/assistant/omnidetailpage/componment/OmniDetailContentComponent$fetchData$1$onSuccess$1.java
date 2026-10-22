package com.obric.assistant.omnidetailpage.componment;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent$fetchData$1$onSuccess$1", f = "OmniDetailContentComponent.kt", i = {0, 1}, l = {1171, 1170}, m = "invokeSuspend", n = {"appendBlocks", "appendBlocks"}, s = {"L$0", "L$0"})
final class OmniDetailContentComponent$fetchData$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ mf9.c $result;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OmniDetailContentComponent this$0;

    public OmniDetailContentComponent$fetchData$1$onSuccess$1(OmniDetailContentComponent r1, mf9.c r2, Continuation<? super OmniDetailContentComponent$fetchData$1$onSuccess$1> r3) {
        this.this$0 = r1;
        this.$result = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OmniDetailContentComponent$fetchData$1$onSuccess$1(this.this$0, this.$result, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        final int r2 = 0;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        List r3 = (List) this.L$0;
        ResultKt.throwOnFailure(r8);
    L19:
        if (this.$result.b == true) goto L28;
        final OmniDetailContentComponent r9 = this.this$0;
        int r4 = OmniDetailContentComponent.I;
        final String r5 = r9.W3();
        Integer r6 = this.$result.c;
        if (r6 == null) goto L23;
        r2 = r6.intValue();
    L23:
        com.larus.im.internal.research.d.a r7 = r9.s;
        if (r7 == null) goto L26;
        r7.a();
    L26:
        com.larus.im.e r10 = com.larus.im.c.a;
        r9.s = com.larus.im.internal.research.a.a.b(new mf9.f(r5, r2, r3, new OmniDetailContentComponent$fetchDeepResearchBySSE$1(r9, r5, r2)));
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        OmniDetailContentComponent r11 = (OmniDetailContentComponent) this.L$1;
        List r12 = (List) this.L$0;
        ResultKt.throwOnFailure(r8);
    L14:
        this.L$0 = r12;
        this.L$1 = null;
        this.label = 2;
        if (OmniDetailContentComponent.m3(r11, (List) r8, this) != r0) goto L17;
        return r0;
    L17:
        r3 = r12;
        goto L19
    L10:
        ResultKt.throwOnFailure(r8);
        this.this$0.D = Boxing.boxBoolean(!this.$result.b);
        OmniDetailContentComponent r13 = this.this$0;
        mf9.c r14 = this.$result;
        r13.E = r14.b;
        List r15 = OmniDetailContentComponent.Y2(r13, r14.a);
        OmniDetailContentComponent.B3(this.this$0, r15, false);
        r11 = this.this$0;
        boolean r16 = this.$result.b;
        this.L$0 = r15;
        this.L$1 = r11;
        this.label = 1;
        Object r17 = OmniDetailContentComponent.h3(r11, r15, r16, this);
        if (r17 != r0) goto L13;
        return r0;
    L13:
        r12 = r15;
        r8 = r17;
        goto L14
    }
}
