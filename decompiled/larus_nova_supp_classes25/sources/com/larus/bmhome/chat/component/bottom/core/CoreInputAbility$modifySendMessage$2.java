package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputAbility$modifySendMessage$2", f = "CoreInputAbility.kt", i = {}, l = {2935}, m = "invokeSuspend", n = {}, s = {})
final class CoreInputAbility$modifySendMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    final /* synthetic */ String $newContent;
    final /* synthetic */ Map<String, String> $resourceMentionExt;
    final /* synthetic */ Long $sendClickTimestamp;
    int label;
    final /* synthetic */ CoreInputAbility<ComponentFeature> this$0;

    public CoreInputAbility$modifySendMessage$2(CoreInputAbility<ComponentFeature> r1, Message r2, String r3, Map<String, String> r4, Long r5, Continuation<? super CoreInputAbility$modifySendMessage$2> r6) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$newContent = r3;
        this.$resourceMentionExt = r4;
        this.$sendClickTimestamp = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CoreInputAbility$modifySendMessage$2(this.this$0, this.$msg, this.$newContent, this.$resourceMentionExt, this.$sendClickTimestamp, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L13:
        CoreInputAbility<ComponentFeature> r14 = this.this$0;
        String r2 = CoreInputAbility.U;
        gd8.g r3 = r14.A().h2();
        if (r3 == null) goto L17;
        gd8.g.a.b(r3, this.this$0.v(), this.$newContent, "edit", this.$resourceMentionExt, false, null, null, null, null, this.$sendClickTimestamp, 1520);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CoreInputAbility<ComponentFeature> r15 = this.this$0;
        String r4 = CoreInputAbility.U;
        gd8.g r16 = r15.A().h2();
        if (r16 == null) goto L13;
        Message r5 = this.$msg;
        this.label = 1;
        if (r16.hi(r5, this) != r0) goto L13;
        return r0;
    }
}
