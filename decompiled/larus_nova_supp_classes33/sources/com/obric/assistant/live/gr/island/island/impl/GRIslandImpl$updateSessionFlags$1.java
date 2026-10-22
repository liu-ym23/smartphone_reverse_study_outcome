package com.obric.assistant.live.gr.island.island.impl;

import com.larus.common.apphost.AppHost;
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
@DebugMetadata(c = "com.obric.assistant.live.gr.island.island.impl.GRIslandImpl$updateSessionFlags$1", f = "GRIslandImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GRIslandImpl$updateSessionFlags$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ j $session;
    int label;
    final /* synthetic */ GRIslandImpl this$0;

    public GRIslandImpl$updateSessionFlags$1(GRIslandImpl r1, j r2, Continuation<? super GRIslandImpl$updateSessionFlags$1> r3) {
        this.this$0 = r1;
        this.$session = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new GRIslandImpl$updateSessionFlags$1(this.this$0, this.$session, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r8);
        Long r9 = this.this$0.a.get(this.$session);
        long r0 = this.$session.l;
        if (r9 != null) goto L8;
    L11:
        k r10 = this.$session.b;
        l r1 = null;
        if (r10 == null) goto L14;
        l r11 = r10.b;
    L16:
        if ((r11 instanceof GRComplexTaskExpandedTemplate) == true) goto L22;
        FLogger r12 = FLogger.a;
        StringBuilder r2 = new StringBuilder("updateSessionFlags()  taskId: ");
        r2.append(this.$session.g);
        r2.append("  isComplexTaskSession: ");
        k r3 = this.$session.b;
        if (r3 == null) goto L20;
        r1 = r3.b;
    L20:
        r2.append(r1 instanceof GRComplexTaskExpandedTemplate);
        r2.append(", not complex task session, return");
        r12.d("GRIslandImpl", r2.toString());
        return Unit.INSTANCE;
    L22:
        FLogger r13 = FLogger.a;
        r13.d("GRIslandImpl", "updateSessionFlags()  taskId: " + this.$session.g + "  flags: " + this.$session.l);
        if (this.$session.a() == false) goto L27;
        r13.d("GRIslandImpl", "updateSessionFlags()  taskId: " + this.$session.g + "  isDialogueMode: " + this.$session.a());
        j r14 = this.$session;
        r14.o = true;
        GRIslandImpl.a(this.this$0, r14, AppHost.a.getApplication().getApplicationContext());
        j r15 = this.$session;
        nea.a r4 = r15.e;
        if (r4 == null) goto L30;
        r4.a(r15, -1);
    L30:
        ConcurrentHashMap<j, Long> r16 = this.this$0.a;
        j r5 = this.$session;
        r16.put(r5, Boxing.boxLong(r5.l));
        return Unit.INSTANCE;
    L27:
        r13.d("GRIslandImpl", "updateSessionFlags()  taskId: " + this.$session.g + "  isDialogueMode: " + this.$session.a());
        j r17 = this.$session;
        r17.o = false;
        GRIslandImpl.a(this.this$0, r17, AppHost.a.getApplication().getApplicationContext());
        j r18 = this.$session;
        nea.a r6 = r18.e;
        if (r6 == null) goto L30;
        r6.a(r18, -2);
        goto L30
    L14:
        r11 = null;
        goto L16
    L8:
        if (r9.longValue() != r0) goto L11;
        FLogger.a.d("GRIslandImpl", "updateSessionFlags()  taskId: " + this.$session.g + "  flags: " + this.$session.l + "  same flags, return");
        return Unit.INSTANCE;
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
