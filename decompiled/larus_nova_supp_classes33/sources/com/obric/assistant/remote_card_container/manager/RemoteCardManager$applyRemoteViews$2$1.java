package com.obric.assistant.remote_card_container.manager;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.manager.RemoteCardManager$applyRemoteViews$2$1", f = "RemoteCardManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RemoteCardManager$applyRemoteViews$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardUri;
    final /* synthetic */ Context $context;
    final /* synthetic */ i<Pair<? extends View, Boolean>> $continuation;
    final /* synthetic */ ViewGroup $parent;
    final /* synthetic */ RemoteViews $remoteViews;
    private /* synthetic */ Object L$0;
    int label;

    public RemoteCardManager$applyRemoteViews$2$1(RemoteViews r1, Context r2, ViewGroup r3, String r4, i<? super Pair<? extends View, Boolean>> r5, Continuation<? super RemoteCardManager$applyRemoteViews$2$1> r6) {
        this.$remoteViews = r1;
        this.$context = r2;
        this.$parent = r3;
        this.$cardUri = r4;
        this.$continuation = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        RemoteCardManager$applyRemoteViews$2$1 r7 = new RemoteCardManager$applyRemoteViews$2$1(this.$remoteViews, this.$context, this.$parent, this.$cardUri, this.$continuation, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        long r0 = SystemClock.elapsedRealtime();
        RemoteViews r12 = this.$remoteViews;
        Context r2 = this.$context;
        ViewGroup r3 = this.$parent;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L11
        if (r12 == null) goto L8;
        View r13 = r12.apply(r2.getApplicationContext(), r3);     // Catch: Throwable -> L11
    L9:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L11
    L13:
        String r4 = this.$cardUri;
        i<Pair<? extends View, Boolean>> r6 = this.$continuation;
        Throwable r7 = Result.exceptionOrNull-impl(r14);
        if (r7 == null) goto L18;
        p9a.e r8 = p9a.b.a;
        p9a.b.c("RemoteCardManager", "applyRemoteViews failed for " + r4 + ". errMsg: " + r7.getMessage(), r7);
        if (r6.isActive() == false) goto L18;
        r6.resumeWith(Result.constructor-impl(TuplesKt.to(null, Boxing.boxBoolean(false))));
    L18:
        String r9 = this.$cardUri;
        i<Pair<? extends View, Boolean>> r15 = this.$continuation;
        if (Result.isSuccess-impl(r14) == false) goto L24;
        View r16 = (View) r14;
        p9a.e r17 = p9a.b.a;
        p9a.b.a("RemoteCardManager", "apply used " + (SystemClock.elapsedRealtime() - r0) + " ms for " + r9);
        if (r15.isActive() == false) goto L24;
        r15.resumeWith(Result.constructor-impl(TuplesKt.to(r16, Boxing.boxBoolean(true))));
    L24:
        return Unit.INSTANCE;
    L8:
        r13 = null;
    L11:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
