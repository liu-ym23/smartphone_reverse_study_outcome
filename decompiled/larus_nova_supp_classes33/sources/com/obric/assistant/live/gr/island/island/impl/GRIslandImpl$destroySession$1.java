package com.obric.assistant.live.gr.island.island.impl;

import android.app.NotificationManager;
import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pea.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.live.gr.island.island.impl.GRIslandImpl$destroySession$1", f = "GRIslandImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GRIslandImpl$destroySession$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ j $session;
    int label;
    final /* synthetic */ GRIslandImpl this$0;

    public GRIslandImpl$destroySession$1(j r1, GRIslandImpl r2, Continuation<? super GRIslandImpl$destroySession$1> r3) {
        this.$session = r1;
        this.this$0 = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new GRIslandImpl$destroySession$1(this.$session, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.obric.assistant.live.gr.island.island.impl.a] */
    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r6);
        FLogger r7 = FLogger.a;
        r7.d("GRIslandImpl", "destroySession() ******* taskId: " + this.$session.g + ", before mSessionMap.size: " + this.this$0.a.size());
        Set<j> r0 = this.this$0.a.keySet();
        final j r3 = this.$session;
        final ?? r4 = new a(r3);
        r0.removeIf(new b(r4));
        r7.i("GRIslandImpl", "destroySession() ******* taskId: " + this.$session.g + ", after mSessionMap.size: " + this.this$0.a.size());
        GRIslandImpl r8 = this.this$0;
        Context r1 = AppHost.a.getApplication().getApplicationContext();
        r8.getClass();
        Object r9 = r1.getSystemService("notification");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) r9).cancel((int) this.$session.g);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
