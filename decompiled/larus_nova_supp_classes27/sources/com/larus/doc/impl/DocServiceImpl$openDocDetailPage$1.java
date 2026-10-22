package com.larus.doc.impl;

import android.content.Context;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.doc.sdk.api.IDocSdkServiceV2;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.office.base.preview.DocMeta;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocServiceImpl$openDocDetailPage$1", f = "DocServiceImpl.kt", i = {}, l = {669}, m = "invokeSuspend", n = {}, s = {})
public final class DocServiceImpl$openDocDetailPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionBarScene;
    final /* synthetic */ String $agentChatId;
    final /* synthetic */ String $applyPermissionConversationId;
    final /* synthetic */ String $applyPermissionMessageId;
    final /* synthetic */ String $artifactVersionId;
    final /* synthetic */ String $botId;
    final /* synthetic */ String $clickPreviousPage;
    final /* synthetic */ long $clickTimestamp;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $createDocByMsgConvId;
    final /* synthetic */ String $createPlatform;
    final /* synthetic */ String $currentPageOverride;
    final /* synthetic */ String $docConvId;
    final /* synthetic */ String $docEnterFrom;
    final /* synthetic */ ArrayList<DocMeta> $docListToApplyPermission;
    final /* synthetic */ String $feishuRecordId;
    final /* synthetic */ String $generalAgent;
    final /* synthetic */ boolean $isFromClickVoice;
    final /* synthetic */ boolean $isInMainConversation;
    final /* synthetic */ boolean $isNewAudioRecord;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $metaId;
    final /* synthetic */ String $offlineCreateAttemptId;
    final /* synthetic */ String $offlineRetryDocRealToken;
    final /* synthetic */ boolean $openChatWithNewLocalConv;
    final /* synthetic */ String $page;
    final /* synthetic */ String $recordScene;
    final /* synthetic */ String $recordingContentType;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ int $resourceType;
    final /* synthetic */ int $resourceVersion;
    final /* synthetic */ String $sourceUrlForParams;
    final /* synthetic */ String $title;
    final /* synthetic */ String $trackingConversationId;
    int label;
    final /* synthetic */ DocServiceImpl this$0;

    public DocServiceImpl$openDocDetailPage$1(boolean r4, String r5, DocServiceImpl r6, Context r7, String r8, int r9, String r10, String r11, String r12, String r13, int r14, String r15, boolean r16, String r17, String r18, String r110, String r20, long r21, String r23, String r24, String r25, String r26, ArrayList<DocMeta> r27, String r28, String r210, boolean r30, String r31, String r32, String r33, String r34, String r35, String r36, boolean r37, String r38, String r310, Continuation<? super DocServiceImpl$openDocDetailPage$1> r40) {
        this.$isInMainConversation = r4;
        this.$docConvId = r5;
        this.this$0 = r6;
        this.$context = r7;
        this.$resourceId = r8;
        this.$resourceType = r9;
        this.$title = r10;
        this.$metaId = r11;
        this.$trackingConversationId = r12;
        this.$botId = r13;
        this.$resourceVersion = r14;
        this.$actionBarScene = r15;
        this.$isFromClickVoice = r16;
        this.$artifactVersionId = r17;
        this.$messageId = r18;
        this.$createDocByMsgConvId = r110;
        this.$docEnterFrom = r20;
        this.$clickTimestamp = r21;
        this.$createPlatform = r23;
        this.$page = r24;
        this.$clickPreviousPage = r25;
        this.$currentPageOverride = r26;
        this.$docListToApplyPermission = r27;
        this.$applyPermissionConversationId = r28;
        this.$applyPermissionMessageId = r210;
        this.$isNewAudioRecord = r30;
        this.$feishuRecordId = r31;
        this.$recordingContentType = r32;
        this.$recordScene = r33;
        this.$generalAgent = r34;
        this.$agentChatId = r35;
        this.$sourceUrlForParams = r36;
        this.$openChatWithNewLocalConv = r37;
        this.$offlineCreateAttemptId = r38;
        this.$offlineRetryDocRealToken = r310;
        super(2, r40);
    }

    public final Continuation<Unit> create(Object r41, Continuation<?> r42) {
        return new DocServiceImpl$openDocDetailPage$1(this.$isInMainConversation, this.$docConvId, this.this$0, this.$context, this.$resourceId, this.$resourceType, this.$title, this.$metaId, this.$trackingConversationId, this.$botId, this.$resourceVersion, this.$actionBarScene, this.$isFromClickVoice, this.$artifactVersionId, this.$messageId, this.$createDocByMsgConvId, this.$docEnterFrom, this.$clickTimestamp, this.$createPlatform, this.$page, this.$clickPreviousPage, this.$currentPageOverride, this.$docListToApplyPermission, this.$applyPermissionConversationId, this.$applyPermissionMessageId, this.$isNewAudioRecord, this.$feishuRecordId, this.$recordingContentType, this.$recordScene, this.$generalAgent, this.$agentChatId, this.$sourceUrlForParams, this.$openChatWithNewLocalConv, this.$offlineCreateAttemptId, this.$offlineRetryDocRealToken, r42);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r41) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r41);
    L13:
        AuthModelDelegate r3 = AuthModelDelegate.b;
        wc9.e r4 = (wc9.e) r3.y().getValue();
        if (r4 == null) goto L17;
        String r5 = r4.a;
        if (r5 == null) goto L17;
    L22:
        if (this.$isInMainConversation == true) goto L35;
        String r6 = this.$docConvId;
        if (r6 != null) goto L26;
    L29:
        boolean r7 = true;
    L30:
        if (r7 == false) goto L32;
    L34:
        boolean r8 = false;
    L36:
        String r9 = this.$resourceId;
        int r10 = this.$resourceType;
        String r11 = this.$title;
        String r12 = this.$metaId;
        String r13 = this.$docConvId;
        String r14 = this.$trackingConversationId;
        String r15 = this.$botId;
        int r16 = this.$resourceVersion;
        String r17 = this.$actionBarScene;
        boolean r18 = this.$isFromClickVoice;
        String r110 = this.$artifactVersionId;
        String r20 = this.$messageId;
        String r21 = this.$createDocByMsgConvId;
        String r22 = this.$docEnterFrom;
        long r23 = this.$clickTimestamp;
        String r24 = this.$createPlatform;
        String r25 = this.$page;
        String r26 = this.$clickPreviousPage;
        DocServiceImpl r27 = this.this$0;
        String r28 = this.$currentPageOverride;
        ArrayList<DocMeta> r30 = this.$docListToApplyPermission;
        String r31 = this.$applyPermissionConversationId;
        String r32 = this.$applyPermissionMessageId;
        boolean r33 = this.$isNewAudioRecord;
        String r34 = this.$feishuRecordId;
        String r35 = this.$recordingContentType;
        String r36 = this.$recordScene;
        String r37 = this.$generalAgent;
        String r38 = this.$agentChatId;
        String r40 = this.$sourceUrlForParams;
        boolean r42 = this.$openChatWithNewLocalConv;
        String r43 = this.$offlineCreateAttemptId;
        String r44 = this.$offlineRetryDocRealToken;
        StringBuilder r0 = new StringBuilder("sslocal://doubao_apps?app_id=db_1JOlsY6&path=detail");
        r0.append("&route_mode=" + ApplicationRouter.Mode.NAVIGATE.getValue());
        if (r9.length() <= 0) goto L39;
        boolean r45 = true;
    L40:
        if (r45 == false) goto L87;
        List r46 = CollectionsKt.createListBuilder();
        r46.add(TuplesKt.to("biz", "docx"));
        r46.add(TuplesKt.to("page_token", r9));
        r46.add(TuplesKt.to("resource_type", String.valueOf(r10)));
        r46.add(TuplesKt.to("doc_title", r11));
        r46.add(TuplesKt.to("artifact_meta_id", r12));
        r46.add(TuplesKt.to("conversation_id", r13));
        r46.add(TuplesKt.to("tracking_conversation_id", r14));
        r46.add(TuplesKt.to("bot_id", r15));
        r46.add(TuplesKt.to("resource_version", String.valueOf(r16)));
        r46.add(TuplesKt.to("action_bar_scene", r17));
        r46.add(TuplesKt.to("create_new_doc_by_voice", String.valueOf(r18)));
        r46.add(TuplesKt.to("artifact_version_id", r110));
        r46.add(TuplesKt.to("is_in_main_conversation", String.valueOf(r8)));
        r46.add(TuplesKt.to("message_id", r20));
        r46.add(TuplesKt.to("create_doc_by_msg_conv_id", r21));
        r46.add(TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM, r22));
        r46.add(TuplesKt.to("click_timestamp", String.valueOf(r23)));
        r46.add(TuplesKt.to("meeting_record_create_platform", r24));
        r46.add(TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r25));
        if (r26 != null) goto L44;
        int r47 = DocServiceImpl.c;
        r27.getClass();
        String r48 = DocServiceImpl.b();
    L45:
        r46.add(TuplesKt.to("click_previous_page", r48));
        r46.add(TuplesKt.to("drive_override_current_page", r28));
        if (r30 == null) goto L48;
        String r50 = GsonProtectorUtils.toJson(new Gson(), r30);
    L49:
        r46.add(TuplesKt.to("doc_list_to_apply_permission", r50));
        r46.add(TuplesKt.to("apply_permission_conversation_id", r31));
        r46.add(TuplesKt.to("apply_permission_message_id", r32));
        String r51 = "0";
        if (r33 == false) goto L52;
        String r52 = "1";
    L53:
        r46.add(TuplesKt.to("is_new_audio_record", r52));
        r46.add(TuplesKt.to("feishu_record_id", r34));
        r46.add(TuplesKt.to("recording_artifact_content_type", r35));
        r46.add(TuplesKt.to("record_scene", r36));
        if (r37 != null) goto L56;
    L59:
        boolean r111 = true;
    L61:
        if ((!r111) == false) goto L63;
        String r53 = r37;
    L64:
        if (r53 == null) goto L67;
        r51 = r53;
    L67:
        r46.add(TuplesKt.to("general_agent", r51));
        if (r38 != null) goto L70;
        String r54 = "";
    L71:
        r46.add(TuplesKt.to("agent_chat_id", r54));
        r46.add(TuplesKt.to("key_source_url_for_params", r40));
        r46.add(TuplesKt.to("open_chat_with_new_local_conv", String.valueOf(r42)));
        r46.add(TuplesKt.to("offline_create_attempt_id", r43));
        r46.add(TuplesKt.to("key_offline_retry_doc_real_token", r44));
        List r55 = CollectionsKt.build(r46);
        ArrayList r56 = new ArrayList();
        Iterator r57 = r55.iterator();
    L73:
        if (r57.hasNext() == false) goto L86;
        Pair r58 = (Pair) r57.next();
        String r60 = (String) r58.component1();
        String r61 = (String) r58.component2();
        if (r61 != null) goto L77;
    L80:
        boolean r62 = true;
    L81:
        if (r62 == false) goto L83;
        String r63 = null;
    L84:
        if (r63 == null) goto L73;
        r56.add(r63);
        goto L73
    L83:
        r63 = r60 + '=' + URLEncoder.encode(r61, "UTF-8");
        goto L84
    L77:
        if (r61.length() == 0) goto L80;
        r62 = false;
        goto L81
    L86:
        StringBuilder r64 = r0;
        r64.append("&query=" + URLEncoder.encode(CollectionsKt.joinToString$default(r56, "&", null, null, 0, null, null, 62, null), "UTF-8"));
    L88:
        String r65 = r64.toString();
        this.this$0.b = false;
        SmartRouter.buildRoute(this.$context, r65).d();
        return Unit.INSTANCE;
    L70:
        r54 = r38;
        goto L71
    L63:
        r53 = null;
        goto L64
    L56:
        if (r37.length() == 0) goto L59;
        r111 = false;
        goto L61
    L52:
        r52 = "0";
        goto L53
    L48:
        r50 = null;
        goto L49
    L44:
        r48 = r26;
        goto L45
    L87:
        r64 = r0;
        goto L88
    L39:
        r45 = false;
        goto L40
    L32:
        if (Intrinsics.areEqual(this.$docConvId, r5) == false) goto L34;
    L26:
        if (r6.length() == 0) goto L29;
        r7 = false;
    L35:
        r8 = true;
    L17:
        wc9.e r66 = (wc9.e) r3.u().getValue();
        if (r66 == null) goto L20;
        r5 = r66.a;
        goto L22
    L20:
        r5 = null;
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r41);
        IDocSdkServiceV2 r67 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r67 == null) goto L13;
        this.label = 1;
        if (r67.initDocSdkIfNeeded(this) != r1) goto L13;
        return r1;
    }
}
