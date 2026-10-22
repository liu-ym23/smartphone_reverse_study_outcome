package com.larus.bmhome.chat.helper;

import android.os.Bundle;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.helper.ChatRouterHelper$gotoSubConversation$4", f = "ChatRouterHelper.kt", i = {}, l = {193, 209}, m = "invokeSuspend", n = {}, s = {})
final class ChatRouterHelper$gotoSubConversation$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Bundle $chatBundle;
    final /* synthetic */ wc9.e $conv;
    final /* synthetic */ boolean $forbiddenAnimation;
    final /* synthetic */ List<Message> $msgList;
    final /* synthetic */ boolean $openKeyboardInNonLocalConv;
    final /* synthetic */ com.bytedance.router.i $router;
    final /* synthetic */ boolean $shouldAbortRemoteCreate;
    final /* synthetic */ String $targetProjectId;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.helper.ChatRouterHelper$gotoSubConversation$4$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.helper.ChatRouterHelper$gotoSubConversation$4$1", f = "ChatRouterHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $chatBundle;
        final /* synthetic */ boolean $forbiddenAnimation;
        final /* synthetic */ com.bytedance.router.i $router;
        int label;

        public AnonymousClass1(com.bytedance.router.i r1, Bundle r2, boolean r3, Continuation<? super AnonymousClass1> r4) {
            this.$router = r1;
            this.$chatBundle = r2;
            this.$forbiddenAnimation = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$router, this.$chatBundle, this.$forbiddenAnimation, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            this.$router.g(this.$chatBundle);
            if (this.$forbiddenAnimation == false) goto L7;
            com.bytedance.router.i r3 = this.$router;
            r3.d = 2130772399;
            r3.e = 2130772399;
            r3.d();
        L9:
            return Unit.INSTANCE;
        L7:
            this.$router.d();
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatRouterHelper$gotoSubConversation$4(Bundle r1, String r2, wc9.e r3, List<Message> r4, String r5, boolean r6, boolean r7, com.bytedance.router.i r8, boolean r9, Continuation<? super ChatRouterHelper$gotoSubConversation$4> r10) {
        this.$chatBundle = r1;
        this.$botId = r2;
        this.$conv = r3;
        this.$msgList = r4;
        this.$targetProjectId = r5;
        this.$shouldAbortRemoteCreate = r6;
        this.$openKeyboardInNonLocalConv = r7;
        this.$router = r8;
        this.$forbiddenAnimation = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new ChatRouterHelper$gotoSubConversation$4(this.$chatBundle, this.$botId, this.$conv, this.$msgList, this.$targetProjectId, this.$shouldAbortRemoteCreate, this.$openKeyboardInNonLocalConv, this.$router, this.$forbiddenAnimation, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L14:
        if (((Boolean) r11).booleanValue() == false) goto L16;
    L20:
        MainCoroutineDispatcher r12 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$router, this.$chatBundle, this.$forbiddenAnimation, null);
        this.label = 2;
        if (BuildersKt.withContext(r12, r2, this) != r0) goto L24;
        return r0;
    L16:
        if (this.$shouldAbortRemoteCreate == false) goto L19;
        FLogger.a.i("ChatRouterHelper", "abort remote sub conversation create in main conversation downgrade");
        return Unit.INSTANCE;
    L19:
        ChatRouterHelper r13 = ChatRouterHelper.a;
        ChatRouterHelper.c(this.$chatBundle, this.$conv, this.$openKeyboardInNonLocalConv);
        goto L20
    L10:
        ResultKt.throwOnFailure(r11);
        ChatRouterHelper r14 = ChatRouterHelper.a;
        Bundle r4 = this.$chatBundle;
        String r5 = this.$botId;
        wc9.e r6 = this.$conv;
        List<Message> r7 = this.$msgList;
        String r8 = this.$targetProjectId;
        this.label = 1;
        r11 = ChatRouterHelper.a(r14, r4, r5, r6, r7, r8, this);
        if (r11 != r0) goto L14;
        return r0;
    }
}
