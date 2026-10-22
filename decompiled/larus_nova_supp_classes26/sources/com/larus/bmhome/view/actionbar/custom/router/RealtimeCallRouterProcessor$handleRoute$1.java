package com.larus.bmhome.view.actionbar.custom.router;

import android.os.Bundle;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SceneModel;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.AccountService;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.router.RealtimeCallRouterProcessor$handleRoute$1", f = "RealtimeCallRouterProcessor.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallRouterProcessor$handleRoute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botSayHelloTextKey;
    final /* synthetic */ ChatParam $chatParam;
    final /* synthetic */ Bundle $commonArgs;
    final /* synthetic */ Long $convLastMessageId;
    final /* synthetic */ String $convLastSectionId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ String $openVLM;
    final /* synthetic */ String $sessionExtraJsonStr;
    final /* synthetic */ wc9.e $sourceConv;
    final /* synthetic */ ChatFragment $sourceFragment;
    final /* synthetic */ int $targetSceneId;
    final /* synthetic */ String $trackParams;
    final /* synthetic */ String $triggerHello;
    int label;

    public RealtimeCallRouterProcessor$handleRoute$1(ChatParam r1, ChatFragment r2, wc9.e r3, Bundle r4, Map<String, String> r5, String r6, String r7, Long r8, int r9, String r10, String r11, String r12, String r13, String r14, Continuation<? super RealtimeCallRouterProcessor$handleRoute$1> r15) {
        this.$chatParam = r1;
        this.$sourceFragment = r2;
        this.$sourceConv = r3;
        this.$commonArgs = r4;
        this.$ext = r5;
        this.$conversationId = r6;
        this.$convLastSectionId = r7;
        this.$convLastMessageId = r8;
        this.$targetSceneId = r9;
        this.$botSayHelloTextKey = r10;
        this.$triggerHello = r11;
        this.$openVLM = r12;
        this.$trackParams = r13;
        this.$sessionExtraJsonStr = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r19, Continuation<?> r20) {
        return new RealtimeCallRouterProcessor$handleRoute$1(this.$chatParam, this.$sourceFragment, this.$sourceConv, this.$commonArgs, this.$ext, this.$conversationId, this.$convLastSectionId, this.$convLastMessageId, this.$targetSceneId, this.$botSayHelloTextKey, this.$triggerHello, this.$openVLM, this.$trackParams, this.$sessionExtraJsonStr, r20);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r50) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r50);
        Object r1 = r50;
    L14:
        BotModel r15 = (BotModel) r1;
        de8.c r2 = this.$sourceFragment.WF().a(de8.c.class);
        wc9.e r3 = this.$sourceConv;
        if (r3 == null) goto L17;
        String r46 = r3.I;
    L18:
        if (r2 == null) goto L20;
        RecommendFrom r16 = r2.d;
    L21:
        ChatControlTrace r4 = ChatControlTrace.b;
        y r5 = (y) this.$sourceFragment.w.getValue();
        if (r5 == null) goto L24;
        wc9.e r6 = r5.h();
    L25:
        if (r6 == null) goto L27;
        Integer r7 = r6.v;
    L28:
        if (r15 == null) goto L30;
        Integer r9 = r15.getBotType();
    L31:
        if (r15 == null) goto L35;
        BotCreatorInfo r10 = r15.getBotCreatorInfo();
        if (r10 == null) goto L35;
        String r11 = r10.getId();
    L36:
        String r17 = r4.g(r7, r9, Intrinsics.areEqual(r11, AccountService.a.getUserId()));
        if (r2 == null) goto L39;
        SearchMobParam r22 = r2.e;
    L40:
        by7.e r12 = this.$sourceFragment;
        if ((r12 instanceof by7.e) == false) goto L43;
        by7.e r24 = r12;
    L44:
        if (r2 == null) goto L48;
        Bundle r13 = r2.b;
        if (r13 == null) goto L48;
        String r25 = r13.getString("from_activity_name");
    L49:
        if (r2 == null) goto L53;
        Bundle r14 = r2.b;
        if (r14 == null) goto L53;
        String r26 = r14.getString("from_activity_module");
    L54:
        SceneModel r18 = this.$commonArgs.getSerializable("realtime_call_scene_model");
        if ((r18 instanceof SceneModel) == false) goto L57;
        SceneModel r28 = r18;
    L58:
        String r19 = this.$ext.get("sub_conv_firstmet_type");
        if (r19 != null) goto L61;
        String r29 = "";
    L62:
        String r20 = this.$ext.get("sub_conv_source_message");
        if (r20 != null) goto L65;
        String r30 = "";
    L66:
        VoiceCallServiceDelegate.a.J(new b3a.c(this.$sourceFragment, this.$conversationId, this.$convLastSectionId, this.$convLastMessageId, r15, r16, r17, "chat", "chat_action_bar", null, false, r22, "chat_action_bar", r24, r25, r26, this.$targetSceneId, r28, r29, r30, this.$commonArgs.getString("action_bar_recommend_from"), this.$commonArgs.getString("req_id"), String.valueOf(this.$commonArgs.getLong("action_bar_item_id")), String.valueOf(this.$commonArgs.getString("action_bar_key")), this.$botSayHelloTextKey, this.$triggerHello, this.$openVLM, ChatControlTrace.L, ChatControlTrace.M, ChatControlTrace.P, null, null, null, this.$trackParams, this.$sessionExtraJsonStr, r46, -1073740288, 27), this.$sourceFragment.getChildFragmentManager(), "action_bar");
        return Unit.INSTANCE;
    L65:
        r30 = r20;
        goto L66
    L61:
        r29 = r19;
        goto L62
    L57:
        r28 = null;
    L53:
        r26 = null;
    L48:
        r25 = null;
        goto L49
    L43:
        r24 = null;
        goto L44
    L39:
        r22 = null;
    L35:
        r11 = null;
        goto L36
    L30:
        r9 = null;
        goto L31
    L27:
        r7 = null;
        goto L28
    L24:
        r6 = null;
        goto L25
    L20:
        r16 = null;
        goto L21
    L17:
        r46 = null;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r50);
        RepoDispatcher.a.getClass();
        BotRepo r21 = RepoDispatcher.g;
        String r23 = this.$chatParam.b;
        if (r23 != null) goto L11;
        r23 = "";
    L11:
        this.label = 1;
        r1 = IBotRepoService.b.a(r21, r23, false, null, false, this, 30);
        if (r1 != r8) goto L14;
        return r8;
    }
}
