package com.larus.doc.impl;

import android.text.TextUtils;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.platform.service.AccountService;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocFragment$jumpToChatPage$1", f = "DocFragment.kt", i = {}, l = {2746, 2750, 2753}, m = "invokeSuspend", n = {}, s = {})
final class DocFragment$jumpToChatPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DocFragment this$0;

    /* JADX INFO: renamed from: com.larus.doc.impl.DocFragment$jumpToChatPage$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.impl.DocFragment$jumpToChatPage$1$1", f = "DocFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $convId;
        int label;
        final /* synthetic */ DocFragment this$0;

        public AnonymousClass1(DocFragment r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$convId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$convId, r4);
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
            com.bytedance.router.i r5 = SmartRouter.buildRoute(this.this$0.getContext(), "//flow/chat_page");
            String r0 = ChatLandingChannel.CHAT_LIST.getChannel();
            r5.c.putExtra("landing_channel", r0);
            String r1 = this.$convId;
            r5.c.putExtra("argConversationId", r1);
            r5.d = 2130772343;
            r5.e = 2130772399;
            r5.d();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DocFragment$jumpToChatPage$1(DocFragment r1, Continuation<? super DocFragment$jumpToChatPage$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DocFragment$jumpToChatPage$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r7);
    L33:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r7);
    L23:
        wc9.e r8 = (wc9.e) r7;
        if (r8 == null) goto L26;
        String r9 = r8.a;
    L28:
        if (TextUtils.isEmpty(r9) == true) goto L33;
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, r9, null);
        this.label = 3;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L33;
        return r0;
    L26:
        r9 = null;
        goto L28
    L11:
        ResultKt.throwOnFailure(r7);
    L17:
        wc9.e r10 = (wc9.e) r7;
        if (r10 == null) goto L26;
        r9 = r10.a;
        goto L28
    L12:
        ResultKt.throwOnFailure(r7);
        if (com.larus.platform.exp.o.a() == false) goto L20;
        LocalSubConvHelper r11 = LocalSubConvHelper.a;
        String r4 = AccountService.a.getSecUserId();
        this.label = 1;
        r7 = r11.c(r4, null, this);
        if (r7 != r0) goto L17;
        return r0;
    L20:
        IConversationRepoService r12 = zh8.a.b;
        this.label = 2;
        r7 = r12.f(this);
        if (r7 != r0) goto L23;
        return r0;
    }
}
