package com.obric.assistant.chat.menu.omnitask;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.special_input.util.j;
import com.obric.assistant.util.VContextMessageExKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.menu.omnitask.OmniTaskAdditionMenuItemHandler$handleMenuItemClick$1", f = "OmniTaskAdditionMenuItemHandler.kt", i = {}, l = {MessageContentType.CONTENT_TYPE_LYRICS_TO_SONGS_BY_LIST}, m = "invokeSuspend", n = {}, s = {})
public final class OmniTaskAdditionMenuItemHandler$handleMenuItemClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ String $refMsgId;
    final /* synthetic */ DMTaskState $taskState;
    int label;

    public OmniTaskAdditionMenuItemHandler$handleMenuItemClick$1(String r1, Fragment r2, DMTaskState r3, Continuation<? super OmniTaskAdditionMenuItemHandler$handleMenuItemClick$1> r4) {
        this.$refMsgId = r1;
        this.$fragment = r2;
        this.$taskState = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new OmniTaskAdditionMenuItemHandler$handleMenuItemClick$1(this.$refMsgId, this.$fragment, this.$taskState, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L16:
        Message r15 = (Message) r14;
    L18:
        FLogger.a.i("OmniTaskAdditionMenuItemHandler", "refMsg = " + r15);
        ISpecialInputTask r6 = com.obric.assistant.special_input.c.a();
        if (r6 == null) goto L27;
        Pair[] r3 = new Pair[2];
        if (r15 == null) goto L23;
        r2 = d.H(r15);
    L23:
        if (r2 != null) goto L25;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L25:
        r3[0] = TuplesKt.to("o_reference_msg_content", r2);
        r3[1] = TuplesKt.to("source_from", "bot_chat_menu");
        ISpecialInputTask.a.a(r6, j.d(2, false, MapsKt.mapOf(r3), this.$refMsgId, this.$taskState, 2), true, true, false, null, 16);
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        if (this.$refMsgId.length() <= 0) goto L11;
        boolean r16 = true;
    L12:
        if (r16 == false) goto L17;
        t1a.b r17 = s1a.a.g(this.$fragment);
        String r4 = this.$refMsgId;
        this.label = 1;
        r14 = VContextMessageExKt.a(r17, r4, this);
        if (r14 != r0) goto L16;
        return r0;
    L17:
        r15 = null;
        goto L18
    L11:
        r16 = false;
        goto L12
    }
}
