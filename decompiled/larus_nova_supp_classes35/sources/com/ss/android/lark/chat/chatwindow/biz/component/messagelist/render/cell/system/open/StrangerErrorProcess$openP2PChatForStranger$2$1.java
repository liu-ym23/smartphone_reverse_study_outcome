package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.j;
import w4b.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.StrangerErrorProcess$openP2PChatForStranger$2$1", f = "StrangerErrorProcess.kt", i = {0}, l = {80}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class StrangerErrorProcess$openP2PChatForStranger$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatterId;
    final /* synthetic */ Context $context;
    final /* synthetic */ Fragment $sourceFragment;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.StrangerErrorProcess$openP2PChatForStranger$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.StrangerErrorProcess$openP2PChatForStranger$2$1$1", f = "StrangerErrorProcess.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Chat $chat;
        final /* synthetic */ Context $context;
        final /* synthetic */ Fragment $sourceFragment;
        int label;

        public AnonymousClass1(Chat r1, Context r2, Fragment r3, Continuation<? super AnonymousClass1> r4) {
            this.$chat = r1;
            this.$context = r2;
            this.$sourceFragment = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$chat, this.$context, this.$sourceFragment, r5);
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
            ChatBundle.a r5 = new ChatBundle.a();
            r5.a = this.$chat.getId();
            r5.a(this.$chat.getChatMode());
            r5.y = 1;
            r5.h = SourceType.PROFILE;
            r5.d = ChatFromType.GROUP_CREATE;
            ChatBundle r0 = new ChatBundle(r5);
            g r6 = ChatCoreModule.a().getChatDependency();
            Context r1 = this.$context;
            Fragment r2 = this.$sourceFragment;
            Intrinsics.checkNotNull(r0);
            r6.t(r1, r2, r0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public StrangerErrorProcess$openP2PChatForStranger$2$1(a r1, String r2, Context r3, Fragment r4, Continuation<? super StrangerErrorProcess$openP2PChatForStranger$2$1> r5) {
        this.this$0 = r1;
        this.$chatterId = r2;
        this.$context = r3;
        this.$sourceFragment = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        StrangerErrorProcess$openP2PChatForStranger$2$1 r6 = new StrangerErrorProcess$openP2PChatForStranger$2$1(this.this$0, this.$chatterId, this.$context, this.$sourceFragment, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);
    L14:
        Chat r9 = (Chat) r8;
        if (r9 == null) goto L17;
        BuildersKt.launch$default(r2, Dispatchers.getMain(), null, new AnonymousClass1(r9, this.$context, this.$sourceFragment, null), 2, null);
        return Unit.INSTANCE;
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        a r3 = this.this$0;
        final String r4 = this.$chatterId;
        this.L$0 = r10;
        this.label = 1;
        int r5 = a.d;
        r3.getClass();
        final j r6 = new j(IntrinsicsKt.intercepted(this), 1);
        r6.C();
        r3.b.getP2pChatCreatedByChatterId(r4, new StrangerErrorProcess$getP2pChatCreatedByChatterId$2$1(r6, r4));
        Object r7 = r6.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r7 != r0) goto L13;
        return r0;
    L13:
        r2 = r10;
        r8 = r7;
        goto L14
    }
}
