package com.obric.assistant.live.gr.island.island.impl;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.live.gr.island.island.template.GRExpandedDialogueTemplate;
import com.obric.assistant.live.gr.island.island.template.GRExpandedNormalTemplate;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pea.e;
import pea.h;
import pea.j;
import pea.k;
import pea.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.live.gr.island.island.impl.GRIslandImpl$sendEvent$1", f = "GRIslandImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GRIslandImpl$sendEvent$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ oea.a $event;
    final /* synthetic */ String $eventId;
    final /* synthetic */ j $targetSession;
    final /* synthetic */ k $targetWidget;
    int label;
    final /* synthetic */ GRIslandImpl this$0;

    public GRIslandImpl$sendEvent$1(String r1, oea.a r2, k r3, GRIslandImpl r4, j r5, Continuation<? super GRIslandImpl$sendEvent$1> r6) {
        this.$eventId = r1;
        this.$event = r2;
        this.$targetWidget = r3;
        this.this$0 = r4;
        this.$targetSession = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new GRIslandImpl$sendEvent$1(this.$eventId, this.$event, this.$targetWidget, this.this$0, this.$targetSession, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r8);
        FLogger.a.d("GRIslandImpl", "sendEvent: eventId:" + this.$eventId + ", event:" + this.$event);
        k r9 = this.$targetWidget;
        oea.a r0 = this.$event;
        String r1 = r0.a;
        String r2 = r0.c;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "action");
        l r10 = r9.b;
        if ((r10 instanceof GRExpandedNormalTemplate) == false) goto L13;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRExpandedNormalTemplate");
        Iterator<T> r11 = ((GRExpandedNormalTemplate) r10).m6getActions().iterator();
    L8:
        if (r11.hasNext() == false) goto L20;
        h r3 = (h) r11.next();
        if (Intrinsics.areEqual(r3.c, r1) == false) goto L8;
        r3.k = r2;
        FLogger.a.d("XiaomiIslandWidget", "updateActionTitle: GRExpandedNormalTemplate  action:" + r1 + ", title:" + r2);
    L20:
        GRIslandImpl.a(this.this$0, this.$targetSession, AppHost.a.getApplication().getApplicationContext());
        return Unit.INSTANCE;
    L13:
        if ((r10 instanceof GRExpandedDialogueTemplate) == false) goto L20;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRExpandedDialogueTemplate");
        Iterator<T> r12 = ((GRExpandedDialogueTemplate) r10).getTextButton().iterator();
    L16:
        if (r12.hasNext() == false) goto L20;
        e r4 = (e) r12.next();
        if (Intrinsics.areEqual(r4.b, r1) == false) goto L16;
        r4.e = r2;
        FLogger.a.d("XiaomiIslandWidget", "updateActionTitle: GRExpandedDialogueTemplate action:" + r1 + ", title:" + r2);
        goto L16
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
