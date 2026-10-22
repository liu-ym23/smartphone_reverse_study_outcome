package com.obric.assistant.remote_card_container;

import com.larus.im.bean.message.Message;
import com.obric.assistant.remote_card_container.cache.CardCacheManager;
import com.obric.assistant.remote_card_container.cache.m;
import com.obric.assistant.remote_card_container.manager.RemoteCardManager;
import java.util.Set;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.RemoteCardImpl$observeMessageList$1$onDelete$1", f = "RemoteCardImpl.kt", i = {}, l = {336, 337}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteCardImpl$observeMessageList$1$onDelete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.obric.assistant.remote_card_container.widget.a $cardData;
    final /* synthetic */ Message $msg;
    int label;

    public RemoteCardImpl$observeMessageList$1$onDelete$1(Message r1, com.obric.assistant.remote_card_container.widget.a r2, Continuation<? super RemoteCardImpl$observeMessageList$1$onDelete$1> r3) {
        this.$msg = r1;
        this.$cardData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RemoteCardImpl$observeMessageList$1$onDelete$1(this.$msg, this.$cardData, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = false;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L22:
        if (((Boolean) r8).booleanValue() != true) goto L24;
        boolean r9 = true;
    L26:
        if (r9 == true) goto L38;
        p9a.e r10 = p9a.b.a;
        p9a.b.a("RemoteCardImpl", "is real deleted: " + this.$msg);
        m r11 = m.a;
        final com.obric.assistant.remote_card_container.widget.a r2 = this.$cardData;
        com.obric.assistant.remote_card_container.cache.j r12 = r11.b(r2.a, new f(r2));
        if (r12 == null) goto L30;
        Set<String> r13 = r12.g();
    L31:
        Set<String> r14 = r13;
        if (r14 != null) goto L34;
    L35:
        r3 = true;
    L36:
        if (r3 == false) goto L40;
        p9a.b.a("RemoteCardImpl", "delete cache because of no msg link to " + this.$cardData);
        CardCacheManager r15 = CardCacheManager.a;
        final String r16 = this.$cardData.a;
        Intrinsics.checkNotNullParameter(r16, "cardUri");
        CardCacheManager.b(new com.obric.assistant.remote_card_container.cache.d(r16));
    L40:
        return Unit.INSTANCE;
    L34:
        if (r14.isEmpty() == false) goto L36;
    L30:
        r13 = null;
        goto L31
    L38:
        p9a.e r17 = p9a.b.a;
        p9a.b.a("RemoteCardImpl", "is not deleted: " + this.$msg);
    L24:
        r9 = false;
        goto L26
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        sfa.a r18 = RemoteCardManager.d;
        if (r18 == null) goto L24;
        String r4 = this.$msg.getLocalMessageId();
        if (r4 != null) goto L18;
        r4 = "";
    L18:
        this.label = 2;
        r8 = r18.b(r4, this);
        if (r8 != r0) goto L22;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        this.label = 1;
        if (DelayKt.delay(5000, this) != r0) goto L13;
        return r0;
    }
}
