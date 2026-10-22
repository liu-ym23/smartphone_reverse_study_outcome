package com.larus.avlink.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.avlink.platform.AndroidPlatformKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.AccountService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraCustomSignalPlugin$handleSessionConfigResponse$1$1", f = "DoraCustomSignalPlugin.kt", i = {1}, l = {202, 203}, m = "invokeSuspend", n = {"conversation"}, s = {"L$0"})
public final class DoraCustomSignalPlugin$handleSessionConfigResponse$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RealtimeCallParam $this_apply;
    Object L$0;
    int label;

    public DoraCustomSignalPlugin$handleSessionConfigResponse$1$1(RealtimeCallParam r1, Continuation<? super DoraCustomSignalPlugin$handleSessionConfigResponse$1$1> r2) {
        this.$this_apply = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraCustomSignalPlugin$handleSessionConfigResponse$1$1(this.$this_apply, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        wc9.e r2 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r12);
    L17:
        BotModel r13 = (BotModel) r12;
        RealtimeCallParam.k r4 = this.$this_apply.p;
        String r5 = null;
        if (r2 == null) goto L20;
        Integer r6 = r2.v;
    L21:
        if (r6 != null) goto L24;
    L26:
        if (r6 != null) goto L29;
    L31:
        if (r6 != null) goto L34;
    L52:
        String r14 = "others_created";
    L53:
        r4.g = r14;
        return Unit.INSTANCE;
    L34:
        if (r6.intValue() != 2) goto L52;
        if (r13 == null) goto L42;
        Integer r7 = r13.getBotType();
        if (r7 == null) goto L42;
        if (r7.intValue() != 2) goto L42;
    L43:
        if (r3 == false) goto L45;
        r14 = "other_default";
        goto L53
    L45:
        if (r13 == null) goto L50;
        BotCreatorInfo r15 = r13.getBotCreatorInfo();
        if (r15 == null) goto L50;
        r5 = r15.getId();
    L50:
        if (Intrinsics.areEqual(r5, AccountService.a.getUserId()) == false) goto L52;
        r14 = "self_created";
    L42:
        r3 = false;
        goto L43
    L29:
        if (r6.intValue() != 3) goto L31;
        r14 = "default_new";
        goto L53
    L24:
        if (r6.intValue() != 1) goto L26;
        r14 = "default";
        goto L53
    L20:
        r6 = null;
        goto L21
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L13:
        wc9.e r16 = (wc9.e) r12;
        String r8 = this.$this_apply.o.h;
        this.L$0 = r16;
        this.label = 2;
        Object r9 = IBotRepoService.b.a(RepoDispatcherDelegate.b.b(), r8, false, null, false, this, 30);
        if (r9 != r0) goto L16;
        return r0;
    L16:
        r2 = r16;
        r12 = r9;
        goto L17
    L10:
        ResultKt.throwOnFailure(r12);
        String r17 = this.$this_apply.o.c;
        this.label = 1;
        r12 = AndroidPlatformKt.b(r17, this);
        if (r12 != r0) goto L13;
        return r0;
    }
}
