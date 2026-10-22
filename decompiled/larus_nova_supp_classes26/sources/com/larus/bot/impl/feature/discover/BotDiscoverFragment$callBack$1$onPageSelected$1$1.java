package com.larus.bot.impl.feature.discover;

import com.larus.bot.impl.databinding.LarusPageBotDiscoverBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverFragment$callBack$1$onPageSelected$1$1", f = "BotDiscoverFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BotDiscoverFragment$callBack$1$onPageSelected$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ BotDiscoverFragment this$0;

    public BotDiscoverFragment$callBack$1$onPageSelected$1$1(BotDiscoverFragment r1, int r2, Continuation<? super BotDiscoverFragment$callBack$1$onPageSelected$1$1> r3) {
        this.this$0 = r1;
        this.$position = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotDiscoverFragment$callBack$1$onPageSelected$1$1(this.this$0, this.$position, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r7);
        BotDiscoverFragment r8 = this.this$0;
        int r0 = r8.s;
        if (r0 == (-1)) goto L28;
        int r1 = this.$position;
        if (r0 == r1) goto L28;
        LarusPageBotDiscoverBinding r2 = r8.j;
        if (r2 == null) goto L28;
        if (r2.m.getCurrent() != r1) goto L13;
        String r3 = "click";
    L14:
        zp9.w r4 = (zp9.w) CollectionsKt.getOrNull(r8.o, r1);
        String r5 = null;
        if (r4 == null) goto L17;
        String r6 = Long.valueOf(r4.a).toString();
    L18:
        String r9 = "";
        if (r6 != null) goto L21;
        r6 = "";
    L21:
        zp9.w r10 = (zp9.w) CollectionsKt.getOrNull(r8.o, r1);
        if (r10 == null) goto L24;
        r5 = r10.b;
    L24:
        if (r5 == null) goto L27;
        r9 = r5;
    L27:
        tx9.c0.p(r3, r9, r6, "bot_discover_tab");
        Unit r11 = Unit.INSTANCE;
        goto L28
    L17:
        r6 = null;
        goto L18
    L13:
        r3 = "slide";
    L28:
        this.this$0.s = this.$position;
        return Unit.INSTANCE;
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
