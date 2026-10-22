package com.larus.common.account.douyin.ai.chat;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.setting.api.u;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.douyin.ai.chat.AiChatOpenDouyinAuthServiceImpl$requestAuthorizeCardMessage$1", f = "AiChatOpenDouyinAuthServiceImpl.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
public final class AiChatOpenDouyinAuthServiceImpl$requestAuthorizeCardMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $musicPlatform;
    int label;
    final /* synthetic */ AiChatOpenDouyinAuthServiceImpl this$0;

    /* JADX INFO: renamed from: com.larus.common.account.douyin.ai.chat.AiChatOpenDouyinAuthServiceImpl$requestAuthorizeCardMessage$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common.account.douyin.ai.chat.AiChatOpenDouyinAuthServiceImpl$requestAuthorizeCardMessage$1$1", f = "AiChatOpenDouyinAuthServiceImpl.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ String $cvsId;
        final /* synthetic */ String $messageId;
        final /* synthetic */ String $musicPlatform;
        int label;
        final /* synthetic */ AiChatOpenDouyinAuthServiceImpl this$0;

        public AnonymousClass1(AiChatOpenDouyinAuthServiceImpl r1, String r2, String r3, String r4, String r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$messageId = r2;
            this.$cvsId = r3;
            this.$botId = r4;
            this.$musicPlatform = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$messageId, this.$cvsId, this.$botId, this.$musicPlatform, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r16) {
            Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r16);
            Object r1 = r16;
        L14:
            com.larus.network.http.a r2 = (com.larus.network.http.a) r1;
            if ((r2 instanceof y) == false) goto L17;
            FLogger.a.i(this.this$0.a, "requestAuthorizeCardMessage success");
        L19:
            return Unit.INSTANCE;
        L17:
            FLogger.a.i(this.this$0.a, "requestAuthorizeCardMessage fail response = " + r2.b);
            goto L19
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r16);
            JSONObject r3 = new JSONObject();
            String r4 = this.$messageId;
            String r5 = this.$cvsId;
            String r6 = this.$botId;
            String r7 = this.$musicPlatform;
            r3.putOpt("msg_id", r4);
            r3.putOpt("conversation_id", r5);
            if (r6 == null) goto L11;
            r3.putOpt("bot_id", r6);
        L11:
            r3.putOpt("auth_target", r7);
            String r8 = u.h;
            JSONObject r9 = u.a("SendAuthCard", r3, 4);
            this.label = 1;
            r1 = HttpExtKt.k("Basic", zs9.a.class, r8, r9, null, null, false, null, null, null, this, 1008);
            if (r1 != r13) goto L14;
            return r13;
        }
    }

    public AiChatOpenDouyinAuthServiceImpl$requestAuthorizeCardMessage$1(AiChatOpenDouyinAuthServiceImpl r1, String r2, String r3, String r4, String r5, Continuation<? super AiChatOpenDouyinAuthServiceImpl$requestAuthorizeCardMessage$1> r6) {
        this.this$0 = r1;
        this.$messageId = r2;
        this.$cvsId = r3;
        this.$botId = r4;
        this.$musicPlatform = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AiChatOpenDouyinAuthServiceImpl$requestAuthorizeCardMessage$1(this.this$0, this.$messageId, this.$cvsId, this.$botId, this.$musicPlatform, r9);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineDispatcher r12 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$messageId, this.$cvsId, this.$botId, this.$musicPlatform, null);
        this.label = 1;
        if (BuildersKt.withContext(r12, r2, this) != r0) goto L12;
        return r0;
    }
}
