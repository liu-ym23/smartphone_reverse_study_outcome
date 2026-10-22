package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.entity.message.Message;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.MessageClearEventPlugin$onCreate$1$1", f = "MessageClearEventPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MessageClearEventPlugin$onCreate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ y6b.a<?> $currentItem;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ int $newFirstPosition;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageClearEventPlugin this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.MessageClearEventPlugin$onCreate$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.MessageClearEventPlugin$onCreate$1$1$1", f = "MessageClearEventPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Fragment $fragment;
        final /* synthetic */ int $newFirstPosition;
        final /* synthetic */ Message $rootMessage;
        int label;
        final /* synthetic */ MessageClearEventPlugin this$0;

        public AnonymousClass1(MessageClearEventPlugin r1, Message r2, int r3, Fragment r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$rootMessage = r2;
            this.$newFirstPosition = r3;
            this.$fragment = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$rootMessage, this.$newFirstPosition, this.$fragment, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            MessageClearEventPlugin.b(this.this$0, this.$rootMessage.getPosition(), this.$newFirstPosition, this.$fragment);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MessageClearEventPlugin$onCreate$1$1(y6b.a<?> r1, MessageClearEventPlugin r2, int r3, Fragment r4, Continuation<? super MessageClearEventPlugin$onCreate$1$1> r5) {
        this.$currentItem = r1;
        this.this$0 = r2;
        this.$newFirstPosition = r3;
        this.$fragment = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MessageClearEventPlugin$onCreate$1$1 r6 = new MessageClearEventPlugin$onCreate$1$1(this.$currentItem, this.this$0, this.$newFirstPosition, this.$fragment, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        String r11 = ((y6b.c) this.$currentItem).Q1;
        if (r11 == null) goto L7;
        Message r4 = this.this$0.a.w().za(r11);
        if (r4 == null) goto L11;
        BuildersKt.launch$default(r0, Dispatchers.getMain(), null, new AnonymousClass1(this.this$0, r4, this.$newFirstPosition, this.$fragment, null), 2, null);
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
