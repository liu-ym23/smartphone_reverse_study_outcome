package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.desktopmode.app.DesktopCompatFragment;
import com.ss.android.lark.forsetiutils.BizType;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.create.groupchat.impl.service.interceptor.StrangerInterceptor$openP2PChatForStranger$2$1", f = "StrangerInterceptor.kt", i = {0}, l = {101}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class StrangerInterceptor$openP2PChatForStranger$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatterId;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $skipSourcePage;
    final /* synthetic */ Fragment $sourceFragment;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ g this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.create.groupchat.impl.service.interceptor.StrangerInterceptor$openP2PChatForStranger$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.create.groupchat.impl.service.interceptor.StrangerInterceptor$openP2PChatForStranger$2$1$1", f = "StrangerInterceptor.kt", i = {0}, l = {120}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Chat $chat;
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $skipSourcePage;
        final /* synthetic */ Fragment $sourceFragment;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Chat r1, Fragment r2, Context r3, boolean r4, Continuation<? super AnonymousClass1> r5) {
            this.$chat = r1;
            this.$sourceFragment = r2;
            this.$context = r3;
            this.$skipSourcePage = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.$chat, this.$sourceFragment, this.$context, this.$skipSourcePage, r9);
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
            DesktopCompatFragment r2 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r8);
        L28:
            Fragment r9 = this.$sourceFragment;
            if ((r9 instanceof DesktopCompatFragment) == false) goto L31;
            r2 = (DesktopCompatFragment) r9;
        L31:
            if (r2 == null) goto L33;
            zab.a.a(r2);
        L37:
            return Unit.INSTANCE;
        L33:
            Activity r10 = ContextsKt.findActivity(this.$context);
            if (r10 == null) goto L37;
            r10.finish();
            goto L37
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            CoroutineScope r11 = (CoroutineScope) this.L$0;
            ChatBundle.a r4 = new ChatBundle.a();
            r4.a = this.$chat.getId();
            r4.a(this.$chat.getChatMode());
            r4.y = 1;
            r4.h = SourceType.PROFILE;
            r4.d = ChatFromType.GROUP_CREATE;
            ChatBundle r5 = new ChatBundle(r4);
            Lazy r6 = ForsetiFGHelpers.a;
            if (ForsetiFGHelpers.c(BizType.IM, "sec_create_group") == true) goto L11;
        L17:
            int r7 = iab.a.c;
            hab.b r12 = iab.a.C0236a.a().a;
            if (r12 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("chatDependency");
            r12 = null;
        L21:
            Context r13 = this.$context;
            Intrinsics.checkNotNull(r5);
            r12.openChat(r13, r5);
        L23:
            if (this.$skipSourcePage == false) goto L25;
            Log.i("StrangerInterceptor", "[IMPickerAddBot] skip source page finish for bot-only p2p group creation");
            goto L37
        L25:
            this.L$0 = r11;
            this.label = 1;
            if (DelayKt.delay(300, this) != r0) goto L28;
            return r0;
        L11:
            if (this.$sourceFragment == null) goto L17;
            int r14 = iab.a.c;
            hab.b r15 = iab.a.C0236a.a().a;
            if (r15 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("chatDependency");
            r15 = null;
        L16:
            Fragment r16 = this.$sourceFragment;
            Context r17 = this.$context;
            Intrinsics.checkNotNull(r5);
            r15.c(r16, r17, r5);
            goto L23
        }
    }

    public StrangerInterceptor$openP2PChatForStranger$2$1(g r1, String r2, Fragment r3, Context r4, boolean r5, Continuation<? super StrangerInterceptor$openP2PChatForStranger$2$1> r6) {
        this.this$0 = r1;
        this.$chatterId = r2;
        this.$sourceFragment = r3;
        this.$context = r4;
        this.$skipSourcePage = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        StrangerInterceptor$openP2PChatForStranger$2$1 r7 = new StrangerInterceptor$openP2PChatForStranger$2$1(this.this$0, this.$chatterId, this.$sourceFragment, this.$context, this.$skipSourcePage, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.ss.android.lark.create.groupchat.impl.service.interceptor.StrangerInterceptor$getP2pChatCreatedByChatterId$2$1] */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L18:
        Chat r3 = (Chat) r10;
        if (r3 == null) goto L21;
        BuildersKt.launch$default(r2, Dispatchers.getMain(), null, new AnonymousClass1(r3, this.$sourceFragment, this.$context, this.$skipSourcePage, null), 2, null);
        return Unit.INSTANCE;
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        g r4 = this.this$0;
        final String r5 = this.$chatterId;
        this.L$0 = r11;
        this.label = 1;
        int r6 = g.a;
        r4.getClass();
        final j r7 = new j(IntrinsicsKt.intercepted(this), 1);
        r7.C();
        int r8 = iab.a.c;
        hab.b r9 = iab.a.C0236a.a().a;
        hab.b r12 = r9;
        if (r9 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("chatDependency");
        r12 = 0;
    L12:
        r12.b(r5, new StrangerInterceptor$getP2pChatCreatedByChatterId$2$1(r7, r5));
        Object r13 = r7.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(this);
    L15:
        if (r13 != r0) goto L17;
        return r0;
    L17:
        r2 = r11;
        r10 = r13;
        goto L18
    }
}
