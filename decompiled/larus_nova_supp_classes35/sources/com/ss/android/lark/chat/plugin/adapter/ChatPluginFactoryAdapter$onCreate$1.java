package com.ss.android.lark.chat.plugin.adapter;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowMessageList;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.PluginLifecycleAdapter;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.b;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.extension.PausableLiveData;
import com.ss.android.lark.chat.component.ChatWindowAdapterComponent;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.scaffold.internal.PluginImpl;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.e;
import l3c.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter$onCreate$1", f = "ChatPluginFactoryAdapter.kt", i = {}, l = {47, 49}, m = "invokeSuspend", n = {}, s = {})
public final class ChatPluginFactoryAdapter$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatWindowOpenViewModel $chatViewModel;
    final /* synthetic */ ChatWindowAdapterComponent $chatWindowComponent;
    final /* synthetic */ f $runtime;
    int label;
    final /* synthetic */ ChatPluginFactoryAdapter this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter$onCreate$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter$onCreate$1$2", f = "ChatPluginFactoryAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChatWindowOpenViewModel $chatViewModel;
        int label;

        public AnonymousClass2(ChatWindowOpenViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.$chatViewModel = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$chatViewModel, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r4);
            MutableLiveData r5 = this.$chatViewModel.getInitData();
            if ((r5 instanceof PausableLiveData) == false) goto L7;
            PausableLiveData r6 = (PausableLiveData) r5;
        L8:
            if (r6 == null) goto L13;
            r6.a.set(false);
            T r0 = r6.c;
            if (r0 == 0) goto L13;
            r6.setValue(r0);
            r6.c = null;
        L13:
            return Unit.INSTANCE;
        L7:
            r6 = null;
            goto L8
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a implements ChatWindowMessageList.a {
        public final /* synthetic */ b a;

        public final void a() {
        }

        public final void b() {
            int r0 = com.ss.android.lark.chat.chatwindow.biz.component.keyboard.b.a;
            Lazy r1 = ChatCoreModule.a;
            this.a.a();
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    public ChatPluginFactoryAdapter$onCreate$1(ChatWindowOpenViewModel r1, ChatPluginFactoryAdapter r2, f r3, ChatWindowAdapterComponent r4, Continuation<? super ChatPluginFactoryAdapter$onCreate$1> r5) {
        this.$chatViewModel = r1;
        this.this$0 = r2;
        this.$runtime = r3;
        this.$chatWindowComponent = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatPluginFactoryAdapter$onCreate$1(this.$chatViewModel, this.this$0, this.$runtime, this.$chatWindowComponent, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L19:
        i7b.a r13 = (i7b.a) r12;
    L20:
        i7b.a r10 = r13;
        b r14 = new b(new ChatPluginFactoryAdapter.b(this.this$0.b));
        LifecycleRegistry r2 = ((PluginImpl) this.this$0).a;
        FragmentActivity r6 = this.$runtime.getActivity();
        LifecycleRegistry r7 = ((PluginImpl) this.this$0).a;
        ChatWindowAdapterComponent r9 = this.$chatWindowComponent;
        Intrinsics.checkNotNull(r10);
        r2.addObserver(new PluginLifecycleAdapter(r6, r7, r14, r9, r10));
        IMessageListComponent r3 = (IMessageListComponent) this.$runtime.a(IMessageListComponent.class);
        if (r3 == null) goto L23;
        r3.hg(new a(r14));
    L24:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new AnonymousClass2(this.$chatViewModel, null), 3, null);
        return Unit.INSTANCE;
    L23:
        int r4 = com.ss.android.lark.chat.chatwindow.biz.component.keyboard.b.a;
        Lazy r5 = ChatCoreModule.a;
        r14.a();
        goto L24
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L15:
        r13 = (i7b.a) r12;
        goto L20
    L10:
        ResultKt.throwOnFailure(r12);
        if ((this.$chatViewModel.getInitData() instanceof PausableLiveData) == false) goto L16;
        MutableLiveData r15 = this.$chatViewModel.getInitData();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.v2.extension.PausableLiveData<com.ss.android.lark.chatwindow.model.data.ChatWindowInitData>");
        Flow r16 = FlowLiveDataConversions.asFlow(((PausableLiveData) r15).b);
        ChatPluginFactoryAdapter$onCreate$1$initData$1 r8 = new ChatPluginFactoryAdapter$onCreate$1$initData$1(null);
        this.label = 1;
        r12 = e.t(r16, r8, this);
        if (r12 != r0) goto L15;
        return r0;
    L16:
        Flow r17 = FlowLiveDataConversions.asFlow(this.$chatViewModel.getInitData());
        ChatPluginFactoryAdapter$onCreate$1$initData$2 r11 = new ChatPluginFactoryAdapter$onCreate$1$initData$2(null);
        this.label = 2;
        r12 = e.t(r17, r11, this);
        if (r12 != r0) goto L19;
        return r0;
    }
}
