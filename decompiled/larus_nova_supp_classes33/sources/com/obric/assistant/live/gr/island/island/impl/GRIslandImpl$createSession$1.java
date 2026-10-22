package com.obric.assistant.live.gr.island.island.impl;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.live.gr.island.island.template.GRComplexTaskExpandedTemplate;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import pea.j;
import pea.k;
import pea.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.live.gr.island.island.impl.GRIslandImpl$createSession$1", f = "GRIslandImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GRIslandImpl$createSession$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ j $session;
    int label;
    final /* synthetic */ GRIslandImpl this$0;

    public GRIslandImpl$createSession$1(j r1, GRIslandImpl r2, Context r3, Continuation<? super GRIslandImpl$createSession$1> r4) {
        this.$session = r1;
        this.this$0 = r2;
        this.$context = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new GRIslandImpl$createSession$1(this.$session, this.this$0, this.$context, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r4);
        this.$session.g = this.this$0.d.incrementAndGet();
        ConcurrentHashMap<j, Long> r5 = this.this$0.a;
        j r0 = this.$session;
        r5.put(r0, Boxing.boxLong(r0.l));
        FLogger.a.d("GRIslandImpl", "createSession()  taskId: " + this.$session.g + ", flags: " + this.$session.l);
        GRIslandImpl.a(this.this$0, this.$session, this.$context);
        j r6 = this.$session;
        k r1 = r6.b;
        if (r1 == null) goto L7;
        l r2 = r1.b;
    L9:
        if ((r2 instanceof GRComplexTaskExpandedTemplate) == false) goto L19;
        if (r6.a() == false) goto L15;
        j r7 = this.$session;
        nea.a r3 = r7.e;
        if (r3 == null) goto L19;
        r3.a(r7, -1);
        goto L19
    L15:
        j r8 = this.$session;
        nea.a r9 = r8.e;
        if (r9 == null) goto L19;
        r9.a(r8, -2);
    L19:
        return Unit.INSTANCE;
    L7:
        r2 = null;
        goto L9
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
