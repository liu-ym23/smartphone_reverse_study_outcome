package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll;

import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.MessageListScrollFeature$scrollToPosition$1", f = "MessageListScrollFeature.kt", i = {}, l = {216, 219}, m = "invokeSuspend", n = {}, s = {})
public final class MessageListScrollFeature$scrollToPosition$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<MessageInfo, Boolean> $interceptor;
    final /* synthetic */ IMessageListComponent.k $listener;
    final /* synthetic */ int $messagePosition;
    final /* synthetic */ ScrollScene $scene;
    final /* synthetic */ boolean $showAnim;
    final /* synthetic */ boolean $toBottom;
    final /* synthetic */ IMessageListViewModel $viewModel;
    int label;
    final /* synthetic */ MessageListScrollFeature this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.MessageListScrollFeature$scrollToPosition$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.MessageListScrollFeature$scrollToPosition$1$1", f = "MessageListScrollFeature.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IMessageListComponent.k $listener;
        int label;

        public AnonymousClass1(IMessageListComponent.k r1, Continuation<? super AnonymousClass1> r2) {
            this.$listener = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$listener, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            IMessageListComponent.k r3 = this.$listener;
            if (r3 == null) goto L7;
            r3.a();
            return Unit.INSTANCE;
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessageListScrollFeature$scrollToPosition$1(IMessageListViewModel r1, int r2, Function1<? super MessageInfo, Boolean> r3, IMessageListComponent.k r4, boolean r5, MessageListScrollFeature r6, ScrollScene r7, boolean r8, Continuation<? super MessageListScrollFeature$scrollToPosition$1> r9) {
        this.$viewModel = r1;
        this.$messagePosition = r2;
        this.$interceptor = r3;
        this.$listener = r4;
        this.$toBottom = r5;
        this.this$0 = r6;
        this.$scene = r7;
        this.$showAnim = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new MessageListScrollFeature$scrollToPosition$1(this.$viewModel, this.$messagePosition, this.$interceptor, this.$listener, this.$toBottom, this.this$0, this.$scene, this.$showAnim, r12);
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
        boolean r3 = true;
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
    L13:
        MessageInfo r12 = (MessageInfo) r11;
        Function1<MessageInfo, Boolean> r2 = this.$interceptor;
        if (r2 != null) goto L16;
    L18:
        r3 = false;
    L19:
        if (r3 == false) goto L25;
        Log.i("MessageListScrollFeature", "intercept scrollToPosition " + this.$messagePosition);
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        AnonymousClass1 r4 = new AnonymousClass1(this.$listener, null);
        this.label = 2;
        if (BuildersKt.withContext(r13, r4, this) != r0) goto L24;
        return r0;
    L25:
        IMessageListViewModel r14 = this.$viewModel;
        final int r7 = this.$messagePosition;
        final IMessageListComponent.k r5 = this.$listener;
        final boolean r6 = this.$toBottom;
        final MessageListScrollFeature r8 = this.this$0;
        final ScrollScene r9 = this.$scene;
        final boolean r10 = this.$showAnim;
        r14.loadSpecialPage(r7, new UIGetDataCallback(new AnonymousClass2(r5, r6, r8, r9, r7, r10)));
        return Unit.INSTANCE;
    L16:
        if (((Boolean) r2.invoke(r12)).booleanValue() != true) goto L18;
    L10:
        ResultKt.throwOnFailure(r11);
        IMessageListViewModel r15 = this.$viewModel;
        int r16 = this.$messagePosition;
        this.label = 1;
        r11 = r15.loadSpecialPosition(r16, this);
        if (r11 != r0) goto L13;
        return r0;
    }
}
