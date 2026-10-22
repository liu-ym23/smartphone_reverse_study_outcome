package com.ss.android.lark.compose.chatsetting.common.repository;

import com.lark.kmp.pb.basic.v1.Chat;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/lark/kmp/pb/basic/v1/Chat;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepositoryKt$fetchAndObserveChat$1", f = "ChatSettingRepository.kt", i = {0, 1}, l = {578, 578, 579}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
final class ChatSettingRepositoryKt$fetchAndObserveChat$1 extends SuspendLambda implements Function2<FlowCollector<? super Chat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ ChatSettingRepository $this_fetchAndObserveChat;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ FlowCollector<Chat> a;

        public a(FlowCollector<? super Chat> r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            FlowCollector<Chat> r0 = this.a;
            Object r4 = r0.emit((Chat) r2, r3);
            if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r4;
        L6:
            return Unit.INSTANCE;
        }
    }

    public ChatSettingRepositoryKt$fetchAndObserveChat$1(ChatSettingRepository r1, String r2, Continuation<? super ChatSettingRepositoryKt$fetchAndObserveChat$1> r3) {
        this.$this_fetchAndObserveChat = r1;
        this.$chatId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ChatSettingRepositoryKt$fetchAndObserveChat$1 r0 = new ChatSettingRepositoryKt$fetchAndObserveChat$1(this.$this_fetchAndObserveChat, this.$chatId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super Chat> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r8);
    L25:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        FlowCollector r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r8);
    L21:
        FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1 r9 = this.$this_fetchAndObserveChat.i(this.$chatId);
        a r3 = new a(r2);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        if (r9.collect(r3, this) != r0) goto L25;
        return r0;
    L11:
        r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r8);
        Object r10 = ((Result) r8).unbox-impl();
    L17:
        if (Result.isSuccess-impl(r10) == false) goto L21;
        this.L$0 = r2;
        this.L$1 = r10;
        this.label = 2;
        if (r2.emit((Chat) r10, this) != r0) goto L21;
        return r0;
    L12:
        ResultKt.throwOnFailure(r8);
        FlowCollector r11 = (FlowCollector) this.L$0;
        ChatSettingRepository r4 = this.$this_fetchAndObserveChat;
        String r5 = this.$chatId;
        this.L$0 = r11;
        this.label = 1;
        Object r6 = r4.e(r5, this);
        if (r6 != r0) goto L15;
        return r0;
    L15:
        r2 = r11;
        r10 = r6;
        goto L17
    }
}
