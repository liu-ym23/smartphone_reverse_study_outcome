package com.larus.share.impl.message;

import android.content.Context;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.bmhome.share.panel.h;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import dm9.a;
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
import t19.s;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.message.SubConversationShareManager$shareConversation$1", f = "SubConversationShareManager.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
public final class SubConversationShareManager$shareConversation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ Context $context;
    final /* synthetic */ e $conversation;
    final /* synthetic */ l0 $loadingDialog;
    final /* synthetic */ by7.e $node;
    final /* synthetic */ ShareScene $shareScene;
    int label;

    public SubConversationShareManager$shareConversation$1(Context r1, BotModel r2, e r3, ShareScene r4, by7.e r5, l0 r6, Continuation<? super SubConversationShareManager$shareConversation$1> r7) {
        this.$context = r1;
        this.$botModel = r2;
        this.$conversation = r3;
        this.$shareScene = r4;
        this.$node = r5;
        this.$loadingDialog = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new SubConversationShareManager$shareConversation$1(this.$context, this.$botModel, this.$conversation, this.$shareScene, this.$node, this.$loadingDialog, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r86) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r86);
        Object r3 = r86;
    L11:
        a.b r4 = (a) r3;
        if ((r4 instanceof a.b) == false) goto L23;
        a.b r5 = r4;
        if (r5.a.isSuccess() == false) goto L20;
        ShareServiceDelegate r6 = ShareServiceDelegate.b;
        SaveMessageShareInfo r7 = (SaveMessageShareInfo) r5.a.getData();
        if (r7 == null) goto L18;
        String r8 = r7.getShareUrl();
    L19:
        String r9 = r6.p(this.$context, this.$botModel);
        h r10 = new h(this.$conversation, this.$botModel, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -4, -1, 1023);
        IShareService.a.c(r6, this.$context, r8, r9, r6.n(this.$context, this.$botModel), this.$shareScene, r10, this.$node, null, 288);
    L21:
        int r11 = SubConversationShareManager.a;
        SubConversationShareManager.b(this.$loadingDialog, null);
    L26:
        return Unit.INSTANCE;
    L18:
        r8 = null;
        goto L19
    L20:
        s.a.g(this.$context, 2131900870, false);
        goto L21
    L23:
        if ((r4 instanceof a.a) == false) goto L26;
        int r12 = SubConversationShareManager.a;
        SubConversationShareManager.b(this.$loadingDialog, null);
        FLogger.a.i("SubConversationShareManger", String.valueOf(((a.a) r4).c));
        s.a.g(this.$context, 2131900870, false);
        goto L26
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r86);
        CoroutineDispatcher r13 = Dispatchers.getIO();
        SubConversationShareManager$shareConversation$1$result$1 r14 = new SubConversationShareManager$shareConversation$1$result$1(this.$conversation, null);
        this.label = 1;
        r3 = BuildersKt.withContext(r13, r14, this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
