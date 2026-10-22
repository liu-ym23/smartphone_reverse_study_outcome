package com.larus.share.impl.message;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.share.api.ConversationSharePanelResult;
import com.larus.bmhome.share.api.IConversationSharePanelService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.network.LarkMetaIdentity;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.bmhome.share.panel.h;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import sr8.b;
import sr8.c;
import t19.s;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.message.SubConversationShareManager$shareConversationWithCcmPanel$1", f = "SubConversationShareManager.kt", i = {1}, l = {107, 126}, m = "invokeSuspend", n = {"identity"}, s = {"L$0"})
final class SubConversationShareManager$shareConversationWithCcmPanel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ e $conversation;
    final /* synthetic */ l0 $loadingDialog;
    Object L$0;
    int label;

    public SubConversationShareManager$shareConversationWithCcmPanel$1(FragmentActivity r1, e r2, BotModel r3, l0 r4, Continuation<? super SubConversationShareManager$shareConversationWithCcmPanel$1> r5) {
        this.$activity = r1;
        this.$conversation = r2;
        this.$botModel = r3;
        this.$loadingDialog = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SubConversationShareManager$shareConversationWithCcmPanel$1(this.$activity, this.$conversation, this.$botModel, this.$loadingDialog, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r93) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        LarkMetaIdentity r1 = (LarkMetaIdentity) this.L$0;
        ResultKt.throwOnFailure(r93);
        LarkMetaIdentity r15 = r1;
        Object r2 = r93;
    L71:
        ConversationSharePanelResult r3 = (ConversationSharePanelResult) r2;
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("ccm share: panel result=");
        r5.append(r3);
        r5.append(", objType=");
        if (r15 == null) goto L74;
        String r6 = r15.getLarkMetaObjectType();
    L75:
        r5.append(r6);
        r4.i("SubConversationShareManger", r5.toString());
        if (r3 == ConversationSharePanelResult.SHOWN) goto L80;
        s.a.g(this.$activity, 2131900870, false);
    L80:
        if (this.$activity.isDestroyed() == true) goto L83;
        int r7 = SubConversationShareManager.a;
        SubConversationShareManager.b(this.$loadingDialog, null);
    L83:
        return Unit.INSTANCE;
    L74:
        r6 = null;
        goto L75
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r93);
        Object r8 = r93;
    L13:
        a.a r9 = (a) r8;
        if ((r9 instanceof a.b) == false) goto L16;
        a.b r11 = (a.b) r9;
    L17:
        if (r11 == null) goto L26;
        BizResponse r12 = r11.a;
        if (r12 == null) goto L26;
        if (r12.isSuccess() == true) goto L24;
        r12 = null;
    L24:
        if (r12 == null) goto L26;
        SaveMessageShareInfo r13 = (SaveMessageShareInfo) r12.getData();
    L27:
        if (r13 != null) goto L37;
        FLogger r14 = FLogger.a;
        if ((r9 instanceof a.a) == false) goto L31;
        a.a r16 = r9;
    L32:
        if (r16 == null) goto L34;
        Throwable r17 = r16.c;
    L35:
        r14.w("SubConversationShareManger", "ccm share: create share link failed", r17);
        s.a.g(this.$activity, 2131900870, false);
        goto L80
    L34:
        r17 = null;
        goto L35
    L31:
        r16 = null;
        goto L32
    L37:
        if (r13.isCcmSharePanelAvailable() == false) goto L78;
        r15 = r13.getLarkMetaIdentity();
        int r18 = c.a;
        FragmentActivity r19 = this.$activity;
        if (r15 == null) goto L41;
        String r20 = r15.getLarkMetaToken();
    L42:
        String r21 = "";
        if (r20 != null) goto L45;
        String r22 = "";
    L46:
        if (r15 == null) goto L50;
        Integer r23 = r15.objectTypeOrNull();
        if (r23 == null) goto L50;
        int r24 = r23.intValue();
    L51:
        String r25 = r13.getShareUrl();
        if (r25 != null) goto L54;
        String r26 = "";
    L55:
        h r91 = new h(this.$conversation, this.$botModel, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -4, -1, 1023);
        ShareServiceDelegate r27 = ShareServiceDelegate.b;
        String r110 = r27.p(this.$activity, this.$botModel);
        if (r110 == null) goto L59;
        r21 = r110;
    L59:
        String r28 = r27.n(this.$activity, this.$botModel);
        BotModel r111 = this.$botModel;
        if (r111 == null) goto L64;
        BotIconImage r112 = r111.getIconImage();
        if (r112 == null) goto L64;
        String r113 = r112.getOriginUrl();
    L65:
        b r29 = new b(r21, r28, r113);
        this.L$0 = r15;
        this.label = 2;
        IConversationSharePanelService r30 = (IConversationSharePanelService) ServiceManager.get().getService(IConversationSharePanelService.class);
        if (r30 != null) goto L68;
        r2 = ConversationSharePanelResult.UNSUPPORTED;
    L69:
        if (r2 != r10) goto L71;
        return r10;
    L68:
        r2 = r30.a(r19, r22, r24, r26, null, r91, r29, this);
    L64:
        r113 = null;
        goto L65
    L54:
        r26 = r25;
    L50:
        r24 = 0;
        goto L51
    L45:
        r22 = r20;
        goto L46
    L41:
        r20 = null;
        goto L42
    L78:
        FLogger.a.i("SubConversationShareManger", "ccm share: server did not return ccm identity, permissionType=" + r13.getSharePermissionType());
        s.a.g(this.$activity, 2131900870, false);
    L26:
        r13 = null;
        goto L27
    L16:
        r11 = null;
        goto L17
    L10:
        ResultKt.throwOnFailure(r93);
        CoroutineDispatcher r31 = Dispatchers.getIO();
        SubConversationShareManager$shareConversationWithCcmPanel$1$result$1 r32 = new SubConversationShareManager$shareConversationWithCcmPanel$1$result$1(this.$conversation, null);
        this.label = 1;
        r8 = BuildersKt.withContext(r31, r32, this);
        if (r8 != r10) goto L13;
        return r10;
    }
}
