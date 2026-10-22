package com.larus.bmhome.chat.component.share;

import android.content.ClipData;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.share.api.ConversationSharePanelResult;
import com.larus.bmhome.share.api.IConversationSharePanelService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.network.LarkMetaIdentity;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.bmhome.share.panel.h;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.audit.BehaviorAuditApi;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import sr8.b;
import sr8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$showCcmSharePanelForSelectedMessages$1", f = "ChatShareBottomComponent.kt", i = {}, l = {1180}, m = "invokeSuspend", n = {}, s = {})
final class ChatShareBottomComponent$showCcmSharePanelForSelectedMessages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ LarkMetaIdentity $identity;
    final /* synthetic */ SaveMessageShareInfo $snapshotShareInfo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatShareBottomComponent this$0;

    public ChatShareBottomComponent$showCcmSharePanelForSelectedMessages$1(LarkMetaIdentity r1, ChatShareBottomComponent r2, SaveMessageShareInfo r3, FragmentActivity r4, Continuation<? super ChatShareBottomComponent$showCcmSharePanelForSelectedMessages$1> r5) {
        this.$identity = r1;
        this.this$0 = r2;
        this.$snapshotShareInfo = r3;
        this.$activity = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ChatShareBottomComponent$showCcmSharePanelForSelectedMessages$1 r6 = new ChatShareBottomComponent$showCcmSharePanelForSelectedMessages$1(this.$identity, this.this$0, this.$snapshotShareInfo, this.$activity, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.bmhome.chat.component.share.q0] */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L29
    L27:
        Object r15 = Result.constructor-impl((ConversationSharePanelResult) r14);     // Catch: Throwable -> L29
    L31:
        Throwable r3 = Result.exceptionOrNull-impl(r15);
        if (r3 == null) goto L35;
        FLogger.a.e("ChatShareBottomComponent", "show ccm share panel failed: " + r3.getMessage(), r3);
        r15 = ConversationSharePanelResult.FAILED;
    L35:
        ConversationSharePanelResult r16 = (ConversationSharePanelResult) r15;
        FLogger.a.i("ChatShareBottomComponent", "show ccm share panel result=" + r16 + ", objType=" + this.$identity.getLarkMetaObjectType());
        ChatShareBottomComponent r4 = this.this$0;
        int r5 = ChatShareBottomComponent.R;
        u7 r6 = r4.Z3();
        if (r6 == null) goto L38;
        r6.dismissLoading();
    L38:
        ChatShareBottomComponent r7 = this.this$0;
        String r8 = this.$snapshotShareInfo.getShareId();
        ConversationSharePanelResult r9 = ConversationSharePanelResult.SHOWN;
        if (r16 != r9) goto L41;
        boolean r10 = true;
    L42:
        r7.getClass();
        ShareServiceDelegate r11 = ShareServiceDelegate.b;
        if (r10 == false) goto L45;
        String r12 = "1";
    L46:
        r11.d("ccm_share", "url", r8, r12);
        if (r16 != r9) goto L66;
        ChatShareBottomComponent r17 = this.this$0;
        FragmentActivity r13 = this.$activity;
        String r18 = this.$snapshotShareInfo.getShareUrl();
        r17.getClass();
        if (r18 != null) goto L51;
    L54:
        if (r2 == true) goto L68;
        ClipData r19 = ClipData.newPlainText(ChatDraftItem.TYPE_TEXT, r18);     // Catch: SecurityException -> L64
        IFlowSdkDepend r20 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: SecurityException -> L64
        if (r20 == null) goto L62;
        r20.d0();     // Catch: SecurityException -> L64
        com.larus.home.impl.sdk.i1 r21 = com.larus.home.impl.sdk.i1.a;
        Intrinsics.checkNotNull(r19);     // Catch: SecurityException -> L64
        r21.i(r13, r19, "bpea-message-share-link-copy");     // Catch: SecurityException -> L64
    L62:
        t19.s.a.getClass();     // Catch: SecurityException -> L64
        t19.s.o(r13, 2131908525, false);     // Catch: SecurityException -> L64
        BehaviorAuditApi.b(null, MapsKt.mapOf(TuplesKt.to("token", "bpea-message-share-link-copy")));     // Catch: SecurityException -> L64
    L64:
        e = move-exception;
        FLogger.a.e("ChatShareBottomComponent", "copy ccm share link failed", e);
    L68:
        return Unit.INSTANCE;
    L51:
        if (StringsKt.isBlank(r18) == true) goto L54;
        r2 = false;
        goto L54
    L66:
        t19.s.a.g(s1a.a.c(this.this$0).getContext(), 2131900870, false);
        goto L68
    L45:
        r12 = "0";
        goto L46
    L41:
        r10 = false;
        goto L42
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        final FragmentActivity r22 = this.$activity;
        LarkMetaIdentity r111 = this.$identity;
        final SaveMessageShareInfo r23 = this.$snapshotShareInfo;
        final ChatShareBottomComponent r24 = this.this$0;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L29
        int r26 = c.a;     // Catch: Throwable -> L29
        String r27 = r111.getLarkMetaToken();     // Catch: Throwable -> L29
        if (r27 != null) goto L14;
        r27 = "";
    L14:
        Integer r112 = r111.objectTypeOrNull();     // Catch: Throwable -> L29
        if (r112 == null) goto L17;
        int r113 = r112.intValue();     // Catch: Throwable -> L29
    L18:
        String r28 = r23.getShareUrl();     // Catch: Throwable -> L29
        if (r28 != null) goto L21;
        r28 = "";
    L21:
        ?? r29 = new q0(r24, r22, r23);     // Catch: Throwable -> L29
        int r30 = ChatShareBottomComponent.R;     // Catch: Throwable -> L29
        h r114 = r24.D3();     // Catch: Throwable -> L29
        b r115 = ChatShareBottomComponent.h3(r24);     // Catch: Throwable -> L29
        this.label = 1;     // Catch: Throwable -> L29
        IConversationSharePanelService r31 = (IConversationSharePanelService) ServiceManager.get().getService(IConversationSharePanelService.class);     // Catch: Throwable -> L29
        if (r31 != null) goto L24;
        r14 = ConversationSharePanelResult.UNSUPPORTED;     // Catch: Throwable -> L29
    L25:
        if (r14 != r0) goto L27;
        return r0;
    L24:
        r14 = r31.a(r22, r27, r113, r28, r29, r114, r115, this);     // Catch: Throwable -> L29
        goto L25
    L17:
        r113 = 0;
    L29:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    }
}
