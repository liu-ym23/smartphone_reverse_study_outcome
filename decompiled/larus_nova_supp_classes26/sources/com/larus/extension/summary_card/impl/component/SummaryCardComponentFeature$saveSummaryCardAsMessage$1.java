package com.larus.extension.summary_card.impl.component;

import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.extension.account_auth.api.FlowAccountAuthServiceDelegate;
import com.larus.extension.offline_message.api.OfflineMessageServiceDelegate;
import java.util.List;
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
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.extension.summary_card.impl.component.SummaryCardComponentFeature$saveSummaryCardAsMessage$1", f = "SummaryCardComponentFeature.kt", i = {0, 1}, l = {GuidePriority.VLM_REALTIME_CALL_PRIORITY, GuidePriority.DEEP_RESEARCH_PRIORITY, 101}, m = "invokeSuspend", n = {"offlineMessageContext", "offlineMessageContext"}, s = {"L$0", "L$0"})
public final class SummaryCardComponentFeature$saveSummaryCardAsMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ e $conversation;
    final /* synthetic */ k99.b $offlineMessage;
    final /* synthetic */ long $session;
    Object L$0;
    int label;

    public SummaryCardComponentFeature$saveSummaryCardAsMessage$1(e r1, String r2, k99.b r3, long r4, Continuation<? super SummaryCardComponentFeature$saveSummaryCardAsMessage$1> r6) {
        this.$conversation = r1;
        this.$botId = r2;
        this.$offlineMessage = r3;
        this.$session = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new SummaryCardComponentFeature$saveSummaryCardAsMessage$1(this.$conversation, this.$botId, this.$offlineMessage, this.$session, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r10);
    L23:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        k99.c r2 = (k99.c) this.L$0;
        ResultKt.throwOnFailure(r10);
    L19:
        OfflineMessageServiceDelegate r3 = OfflineMessageServiceDelegate.b;
        long r4 = this.$session;
        List<? extends k99.b> r7 = CollectionsKt.listOf(this.$offlineMessage);
        this.L$0 = null;
        this.label = 3;
        if (r3.g(r4, r2, r7, this) != r0) goto L23;
        return r0;
    L11:
        r2 = (k99.c) this.L$0;
        ResultKt.throwOnFailure(r10);
    L16:
        OfflineMessageServiceDelegate r11 = OfflineMessageServiceDelegate.b;
        List r5 = CollectionsKt.listOf(this.$offlineMessage);
        FlowAccountAuthServiceDelegate.b.b();
        this.L$0 = r2;
        this.label = 2;
        if (r11.b(r2, r5, this) != r0) goto L19;
        return r0;
    L12:
        ResultKt.throwOnFailure(r10);
        k99.c r12 = new k99.c(this.$conversation.a, this.$botId);
        OfflineMessageServiceDelegate r6 = OfflineMessageServiceDelegate.b;
        List<? extends k99.b> r8 = CollectionsKt.listOf(this.$offlineMessage);
        this.L$0 = r12;
        this.label = 1;
        if (r6.e(r12, r8, this) != r0) goto L15;
        return r0;
    L15:
        r2 = r12;
        goto L16
    }
}
