package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin;

import com.bytedance.lark.pb.im.v1.PushChatChattersResponse;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.parser.internal.h;
import com.ss.android.lark.parser.internal.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.ChatResolveOrRemovePlugin$RemoveChatterViewModel$setup$1", f = "ChatResolveOrRemovePlugin.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
public final class ChatResolveOrRemovePlugin$RemoveChatterViewModel$setup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ v $chatContainer;
    final /* synthetic */ String $chatId;
    Object L$0;
    int label;
    final /* synthetic */ ChatResolveOrRemovePlugin.RemoveChatterViewModel this$0;

    public ChatResolveOrRemovePlugin$RemoveChatterViewModel$setup$1(ChatResolveOrRemovePlugin.RemoveChatterViewModel r1, String r2, v r3, Continuation<? super ChatResolveOrRemovePlugin$RemoveChatterViewModel$setup$1> r4) {
        this.this$0 = r1;
        this.$chatId = r2;
        this.$chatContainer = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatResolveOrRemovePlugin$RemoveChatterViewModel$setup$1(this.this$0, this.$chatId, this.$chatContainer, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0040 -> B:13:0x0045). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        com.larksuite.rucket.job.extension.a r2 = (com.larksuite.rucket.job.extension.a) this.L$0;
        ResultKt.throwOnFailure(r10);
        com.larksuite.rucket.job.extension.a r3 = r2;
        Object r4 = r0;
        ChatResolveOrRemovePlugin$RemoveChatterViewModel$setup$1 r5 = this;
    L14:
        if (((Boolean) r10).booleanValue() == false) goto L36;
        com.larksuite.rucket.job.base.b r11 = r3.a();
        if (((PushChatChattersResponse) r11.b()).chat == null) goto L18;
        Chat r6 = h.a(((PushChatChattersResponse) r11.b()).chat, null);
        if (r6 == null) goto L22;
        PushChatChattersResponse.Type r7 = ((PushChatChattersResponse) r11.b()).type;
        if (Intrinsics.areEqual(r6.getId(), r5.$chatId) == true) goto L26;
    L34:
        ChatResolveOrRemovePlugin$RemoveChatterViewModel$setup$1 r12 = r5;
        r0 = r4;
        com.larksuite.rucket.job.extension.a r8 = r3;
    L9:
        r12.L$0 = r8;
        r12.label = 1;
        Object r9 = r8.hasNext(r12);
        if (r9 != r0) goto L12;
        return r0;
    L12:
        Object r13 = r0;
        r5 = r12;
        r10 = r9;
        r3 = r8;
        r4 = r13;
        goto L14
    L26:
        if (r7 != PushChatChattersResponse.Type.DELETE_CHATTER) goto L34;
        Map<String, ChatChatter> r14 = j.b(((PushChatChattersResponse) r11.b()).entity, null).a();
        String r15 = r5.$chatContainer.getUserId();
        if (r15 != null) goto L32;
        return Unit.INSTANCE;
    L32:
        if (((HashMap) r14).containsKey(r15) == false) goto L34;
        r5.this$0.getRemoveCurrentUserLiveData().postValue(Boxing.boxBoolean(true));
        goto L34
    L22:
        return Unit.INSTANCE;
    L18:
        return Unit.INSTANCE;
    L36:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r8 = ((ChatResolveOrRemovePlugin.a) b38.b.a.create(ChatResolveOrRemovePlugin.a.class)).chatChattersPush().iterator();
        r12 = this;
        goto L9
    }
}
