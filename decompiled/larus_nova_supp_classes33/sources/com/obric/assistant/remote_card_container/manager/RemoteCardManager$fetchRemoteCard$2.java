package com.obric.assistant.remote_card_container.manager;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant_card.provider_core.ICardProviderService;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.remote_card_container.cache.CardCacheManager;
import com.obric.assistant.remote_card_container.cache.j;
import com.obric.assistant.remote_card_container.cache.m;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p9a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiagent/assistant_card/provider_core/bean/RemoteCard;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.manager.RemoteCardManager$fetchRemoteCard$2", f = "RemoteCardManager.kt", i = {0, 0}, l = {186}, m = "invokeSuspend", n = {"$this$async", "cardPkgName"}, s = {"L$0", "L$1"})
final class RemoteCardManager$fetchRemoteCard$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super o9a.d>, Object> {
    final /* synthetic */ String $cardUri;
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public RemoteCardManager$fetchRemoteCard$2(String r1, Context r2, Continuation<? super RemoteCardManager$fetchRemoteCard$2> r3) {
        this.$cardUri = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        RemoteCardManager$fetchRemoteCard$2 r0 = new RemoteCardManager$fetchRemoteCard$2(this.$cardUri, this.$context, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super o9a.d> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        String r3 = (String) this.L$1;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
    L12:
        ICardProviderService r13 = (ICardProviderService) r12;
        if (r13 != null) goto L16;
        p9a.b.b("RemoteCardManager", "cardProviderService is null");
        return null;
    L16:
        m r5 = m.a;
        j r6 = r5.a(this.$cardUri);
        if (r6 == null) goto L19;
        final String r7 = r6.d();
    L20:
        final rfa.c r8 = rfa.b.a(r3);
        String r9 = this.$cardUri;
        Context r10 = this.$context;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L37
        Bundle r14 = new Bundle();     // Catch: Throwable -> L37
        r14.putString("card_uri", r9);     // Catch: Throwable -> L37
        j r15 = r5.a(r9);     // Catch: Throwable -> L37
        if (r15 == null) goto L24;
        String r16 = r15.f();     // Catch: Throwable -> L37
    L25:
        r14.putString("card_extra_params", r16);     // Catch: Throwable -> L37
        Intrinsics.checkNotNullParameter(r10, "<this>");     // Catch: Throwable -> L37
        if ((r10.getResources().getConfiguration().uiMode & 48) != 32) goto L28;
        boolean r17 = true;
    L29:
        r14.putBoolean("is_night_mode", r17);     // Catch: Throwable -> L37
        Bundle r18 = r13.getCard(r14);     // Catch: Throwable -> L37
        if (r18 != null) goto L33;
        r18 = new Bundle();     // Catch: Throwable -> L37
    L33:
        if (r18.getBoolean("succeed", true) == true) goto L35;
        FLogger.a.w("RemoteCardManager", "failed error msg: " + r18.getString(WindowEvent.Params.ERROR_MSG));     // Catch: Throwable -> L37
    L35:
        int r0 = o9a.d.i;     // Catch: Throwable -> L37
        Object r19 = Result.constructor-impl(o9a.d.a.a(r18.getBundle("remote_card")));     // Catch: Throwable -> L37
    L39:
        String r20 = this.$cardUri;
        Throwable r21 = Result.exceptionOrNull-impl(r19);
        if (r21 == null) goto L42;
        p9a.e r22 = p9a.b.a;
        p9a.b.c("RemoteCardManager", "fetchRemoteCard: failed to fetch card for cardUri = " + r20, r21);
    L42:
        final String r23 = this.$cardUri;
        if (Result.isSuccess-impl(r19) == false) goto L53;
        final o9a.d r24 = (o9a.d) r19;
        p9a.e r25 = p9a.b.a;
        p9a.b.a("RemoteCardManager", "fetchRemoteCard: succeed for cardUri = " + r23 + ", remoteCard = " + r24);
        CardCacheManager r26 = CardCacheManager.a;
        Runnable r27 = new d(r7, r23, r24, r8);
        Intrinsics.checkNotNullParameter(r27, "action");
        monitor-enter(r26);
        r27.run();     // Catch: Throwable -> L49
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L49
        monitor-exit(r26);
    L49:
        th = move-exception;
        throw th;
    L53:
        if (Result.isFailure-impl(r19) == false) goto L56;
        return null;
    L56:
        return r19;
    L28:
        r17 = false;
        goto L29
    L24:
        r16 = null;
    L37:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L19:
        r7 = null;
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        String r30 = f.b(UriProtector.parse(this.$cardUri));
        CardProviderServices r31 = CardProviderServices.a;
        Context r32 = this.$context;
        String r33 = this.$cardUri;
        this.L$0 = r110;
        this.L$1 = r30;
        this.label = 1;
        r12 = r31.c(r32, r33, this);
        if (r12 != r1) goto L11;
        return r1;
    L11:
        r3 = r30;
        goto L12
    }
}
