package com.larus.chat.job.impl.page;

import android.content.Context;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.job.impl.page.ChatJobFragment$routeWithResolvedBotIdAsync$1", f = "ChatJobFragment.kt", i = {0, 1, 1, 2, 2}, l = {398, 400, 402}, m = "invokeSuspend", n = {"shouldDowngrade", "routeConversation", "shouldDowngrade", "routeConversation", "shouldDowngrade"}, s = {"Z$0", "L$0", "Z$0", "L$0", "Z$0"})
final class ChatJobFragment$routeWithResolvedBotIdAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pendingCameraResultKey;
    final /* synthetic */ ICoreInputAbility.OnSendParams $sendParams;
    final /* synthetic */ wc9.e $sourceConversation;
    Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ ChatJobFragment this$0;

    public ChatJobFragment$routeWithResolvedBotIdAsync$1(wc9.e r1, ChatJobFragment r2, String r3, ICoreInputAbility.OnSendParams r4, Continuation<? super ChatJobFragment$routeWithResolvedBotIdAsync$1> r5) {
        this.$sourceConversation = r1;
        this.this$0 = r2;
        this.$pendingCameraResultKey = r3;
        this.$sendParams = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatJobFragment$routeWithResolvedBotIdAsync$1(this.$sourceConversation, this.this$0, this.$pendingCameraResultKey, this.$sendParams, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        String r5 = null;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        boolean r2 = this.Z$0;
        wc9.e r3 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r15);
    L33:
        String r16 = (String) r15;
        wc9.e r6 = r3;
        boolean r7 = r2;
    L37:
        String r8 = r16;
        boolean r12 = r7;
        wc9.e r9 = r6;
    L38:
        if (r8 != null) goto L40;
    L43:
        if (r4 == false) goto L53;
        FLogger r17 = FLogger.a;
        StringBuilder r10 = new StringBuilder("resolve route bot id from arguments or conversation failed, sourceConversationId=");
        wc9.e r11 = this.$sourceConversation;
        if (r11 == null) goto L47;
        String r13 = r11.a;
    L48:
        r10.append(r13);
        r10.append(", mainConversationId=");
        if (r9 == null) goto L51;
        r5 = r9.a;
    L51:
        r10.append(r5);
        r17.e("ChatJobFragment", r10.toString());
        ConcurrentHashMap r18 = com.larus.bmhome.chat.camera.command.k.a;
        com.larus.bmhome.chat.camera.command.k.b(this.$pendingCameraResultKey);
        return Unit.INSTANCE;
    L47:
        r13 = null;
        goto L48
    L53:
        Context r14 = this.this$0.getContext();
        if (r14 != null) goto L57;
        ConcurrentHashMap r19 = com.larus.bmhome.chat.camera.command.k.a;
        com.larus.bmhome.chat.camera.command.k.b(this.$pendingCameraResultKey);
        return Unit.INSTANCE;
    L57:
        ChatJobFragment r20 = this.this$0;
        ICoreInputAbility.OnSendParams r110 = this.$sendParams;
        String r111 = this.$pendingCameraResultKey;
        int r112 = ChatJobFragment.q;
        r20.U90(r14, r8, r9, r110, r111, r12);
        return Unit.INSTANCE;
    L40:
        if (StringsKt.isBlank(r8) == true) goto L43;
        r4 = false;
        goto L43
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r7 = this.Z$0;
        wc9.e r21 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r15);
    L26:
        String r22 = (String) r15;
        if (r22 != null) goto L35;
        if (r7 == false) goto L34;
        LocalSubConvHelper r113 = LocalSubConvHelper.a;
        this.L$0 = r21;
        this.Z$0 = r7;
        this.label = 3;
        r15 = LocalSubConvHelper.a.a(AccountService.a.getSecUserId(), this);
        if (r15 != r0) goto L32;
        return r0;
    L32:
        r2 = r7;
        r3 = r21;
        goto L33
    L34:
        r12 = r7;
        r9 = r21;
        r8 = null;
        goto L38
    L35:
        wc9.e r114 = r21;
    L36:
        r6 = r114;
        r16 = r22;
        goto L37
    L11:
        r7 = this.Z$0;
        ResultKt.throwOnFailure(r15);
    L19:
        r114 = (wc9.e) r15;
    L20:
        ChatJobFragment r23 = this.this$0;
        int r24 = ChatJobFragment.q;
        r22 = r23.T90();
        if (r22 != null) goto L36;
        LocalSubConvHelper r25 = LocalSubConvHelper.a;
        this.L$0 = r114;
        this.Z$0 = r7;
        this.label = 2;
        Object r26 = r25.f(r114, this);
        if (r26 != r0) goto L25;
        return r0;
    L25:
        r21 = r114;
        r15 = r26;
        goto L26
    L12:
        ResultKt.throwOnFailure(r15);
        r7 = com.larus.platform.exp.o.a();
        r114 = this.$sourceConversation;
        if (r114 != null) goto L20;
        if (r7 == false) goto L16;
        r114 = null;
        goto L20
    L16:
        final ChatJobFragment r115 = this.this$0;
        this.Z$0 = r7;
        this.label = 1;
        int r27 = ChatJobFragment.q;
        r115.getClass();
        final CompletableDeferred r28 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.larus.im.d.d().getMainConversation(new ChatJobFragment$fetchMainConversation$2(r28, r115));
        r15 = r28.await(this);
        if (r15 != r0) goto L19;
        return r0;
    }
}
