package com.larus.reach.impl;

import android.content.Context;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ns9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.reach.impl.ReachActionExecutor$execute$1", f = "ReachActionExecutor.kt", i = {}, l = {61, TraceLevel.ALL}, m = "invokeSuspend", n = {}, s = {})
final class ReachActionExecutor$execute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ e $click;
    final /* synthetic */ ns9.t $request;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ a this$0;

    public ReachActionExecutor$execute$1(e r1, a r2, Context r3, ns9.t r4, Continuation<? super ReachActionExecutor$execute$1> r5) {
        this.$click = r1;
        this.this$0 = r2;
        this.$applicationContext = r3;
        this.$request = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ReachActionExecutor$execute$1(this.$click, this.this$0, this.$applicationContext, this.$request, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Iterator r2 = (Iterator) this.L$4;
        e r4 = (e) this.L$3;
        ns9.t r5 = (ns9.t) this.L$2;
        Context r6 = (Context) this.L$1;
        a r7 = (a) this.L$0;
        ResultKt.throwOnFailure(r15);
        ReachActionExecutor$execute$1 r13 = this;
    L40:
        e r16 = r4;
        ns9.t r10 = r5;
        Context r11 = r6;
        a r12 = r7;
    L12:
        if (r2.hasNext() == false) goto L42;
        ns9.b r8 = (ns9.b) r2.next();
        int r9 = r8.getType();
        if (r9 == 1) goto L20;
        if (r9 != 2) goto L12;
        Intrinsics.checkNotNull(r11);
        r13.L$0 = r12;
        r13.L$1 = r11;
        r13.L$2 = r10;
        r13.L$3 = r16;
        r13.L$4 = r2;
        r13.label = 2;
        if (a.a(r12, r11, r10, r16, r8, r13) != r0) goto L39;
        return r0;
    L39:
        r4 = r16;
        r5 = r10;
        r6 = r11;
        r7 = r12;
        goto L40
    L20:
        Intrinsics.checkNotNull(r11);
        Map<String, String> r14 = r8.b;
        if (r14 == null) goto L23;
        String r17 = r14.get("schema");
    L24:
        r13.L$0 = r12;
        r13.L$1 = r11;
        r13.L$2 = r10;
        r13.L$3 = r16;
        r13.L$4 = r2;
        r13.label = 1;
        int r18 = a.b;
        r12.getClass();
        if (r17 != null) goto L27;
    L36:
        Object r19 = Unit.INSTANCE;
    L37:
        if (r19 != r0) goto L39;
        return r0;
    L43:
        r4 = r16;
        r5 = r10;
        r6 = r11;
        r7 = r12;
        goto L40
    L27:
        if ((!StringsKt.isBlank(r17)) == true) goto L30;
        r17 = null;
    L30:
        if (r17 == null) goto L36;
        r19 = BuildersKt.withContext(Dispatchers.getMain(), new ReachActionExecutor$openSchema$2(r11, r17, r10, null), r13);
        if (r19 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L37;
        r19 = Unit.INSTANCE;
        goto L37
    L23:
        r17 = null;
        goto L24
    L42:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r15);
        r16 = this.$click;
        List<ns9.b> r3 = r16.c;
        a r20 = this.this$0;
        Context r21 = this.$applicationContext;
        ns9.t r22 = this.$request;
        r2 = r3.iterator();
        r13 = this;
        r12 = r20;
        r11 = r21;
        r10 = r22;
        goto L12
    }
}
