package com.ss.android.lark.compose.chatsetting.common.repository;

import com.lark.kmp.pb.basic.v1.Entity;
import com.lark.kmp.pb.im.v1.PushChatChattersResponse;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepositoryKt$observeQuit$1", f = "ChatSettingRepository.kt", i = {}, l = {586}, m = "invokeSuspend", n = {}, s = {})
final class ChatSettingRepositoryKt$observeQuit$1 extends SuspendLambda implements Function2<FlowCollector<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ ChatSettingRepository $this_observeQuit;
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FlowCollector<Unit> c;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepositoryKt$observeQuit$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0130a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[PushChatChattersResponse.Type.values().length];
                r0[PushChatChattersResponse.Type.DELETE_CHATTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[PushChatChattersResponse.Type.DELETE_ME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public a(String r1, String r2, FlowCollector<? super Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object emit(Object r3, Continuation r4) {
            PushChatChattersResponse r5 = (PushChatChattersResponse) r3;
            PushChatChattersResponse.Type r0 = r5.getType();
            int r1 = C0130a.a[r0.ordinal()];
            boolean r2 = true;
            if (r1 != 1) goto L5;
            Entity r6 = r5.getEntity();
            if (r6 == null) goto L21;
            Map r7 = r6.getChat_chatters();
            if (r7 == null) goto L21;
            Entity.ChatChatter r8 = (Entity.ChatChatter) r7.get(this.a);
            if (r8 == null) goto L21;
            Map r9 = r8.getChatters();
            if (r9 == null) goto L21;
            if (r9.containsKey(this.b) != true) goto L21;
        L22:
            if (r2 == false) goto L27;
            FlowCollector<Unit> r10 = this.c;
            Unit r11 = Unit.INSTANCE;
            Object r12 = r10.emit(r11, r4);
            if (r12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
            return r11;
        L29:
            return r12;
        L27:
            return Unit.INSTANCE;
        L21:
            r2 = false;
            goto L22
        L5:
            if (r1 != 2) goto L27;
            FlowCollector<Unit> r13 = this.c;
            Unit r14 = Unit.INSTANCE;
            r12 = r13.emit(r14, r4);
            if (r12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
            return r14;
        }
    }

    public ChatSettingRepositoryKt$observeQuit$1(ChatSettingRepository r1, String r2, String r3, Continuation<? super ChatSettingRepositoryKt$observeQuit$1> r4) {
        this.$this_observeQuit = r1;
        this.$chatId = r2;
        this.$userId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ChatSettingRepositoryKt$observeQuit$1 r0 = new ChatSettingRepositoryKt$observeQuit$1(this.$this_observeQuit, this.$chatId, this.$userId, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super Unit> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FlowCollector r8 = (FlowCollector) this.L$0;
        FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 r2 = this.$this_observeQuit.j();
        String r3 = this.$chatId;
        a r4 = new a(r3, this.$userId, r8);
        this.label = 1;
        Object r9 = r2.collect(new ChatSettingRepositoryKt$observeQuit$1$invokeSuspend$$inlined$filter$1$2(r4, r3), this);
        if (r9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r9 = Unit.INSTANCE;
    L12:
        if (r9 != r0) goto L15;
        return r0;
    }
}
