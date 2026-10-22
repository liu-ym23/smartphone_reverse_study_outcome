package com.larus.voicecall.impl.component.subtitle;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/Message;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.subtitle.RealtimeSubtitleComponent$tryShowPopupMenu$1$message$1", f = "RealtimeSubtitleComponent.kt", i = {}, l = {366}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeSubtitleComponent$tryShowPopupMenu$1$message$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Message>, Object> {
    final /* synthetic */ com.larus.voicecall.impl.subtitle.c $data;
    int label;

    public RealtimeSubtitleComponent$tryShowPopupMenu$1$message$1(com.larus.voicecall.impl.subtitle.c r1, Continuation<? super RealtimeSubtitleComponent$tryShowPopupMenu$1$message$1> r2) {
        this.$data = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeSubtitleComponent$tryShowPopupMenu$1$message$1(this.$data, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Message> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L16:
        return (Message) r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        IChatRepoService r5 = (IChatRepoService) ServiceManager.get().getService(IChatRepoService.class);
        if (r5 == null) goto L14;
        String r2 = this.$data.j;
        this.label = 1;
        r4 = r5.E1(r2, this);
        if (r4 != r0) goto L16;
        return r0;
    L14:
        return null;
    }
}
