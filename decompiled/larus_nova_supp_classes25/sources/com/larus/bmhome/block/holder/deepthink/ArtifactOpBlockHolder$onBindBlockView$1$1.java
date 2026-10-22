package com.larus.bmhome.block.holder.deepthink;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.reference.MarkdownReferenceWidget;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.home.impl.sdk.n1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.ArtifactOPBlock;
import com.larus.im.bean.message.block.ArtifactStatus;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.d3;
import com.larus.trace.tracknode.TraceFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.block.holder.deepthink.ArtifactOpBlockHolder$onBindBlockView$1$1", f = "ArtifactOpBlockHolder.kt", i = {0, 0}, l = {DoraCallStateCode.DOUBAO_CMD_12}, m = "invokeSuspend", n = {"context", "artifactBlock"}, s = {"L$0", "L$1"})
final class ArtifactOpBlockHolder$onBindBlockView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArtifactOPBlock $block;
    final /* synthetic */ gb8.a $blockModel;
    final /* synthetic */ boolean $notSupportArrowAndJump;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ b this$0;

    public ArtifactOpBlockHolder$onBindBlockView$1$1(b r1, gb8.a r2, boolean r3, ArtifactOPBlock r4, Continuation<? super ArtifactOpBlockHolder$onBindBlockView$1$1> r5) {
        this.this$0 = r1;
        this.$blockModel = r2;
        this.$notSupportArrowAndJump = r3;
        this.$block = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ArtifactOpBlockHolder$onBindBlockView$1$1(this.this$0, this.$blockModel, this.$notSupportArrowAndJump, this.$block, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r3 = "";
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ArtifactBlock r2 = (ArtifactBlock) this.L$1;
        Context r4 = (Context) this.L$0;
        ResultKt.throwOnFailure(r15);
        ArtifactBlock r7 = r2;
        Context r5 = r4;
    L46:
        BotModel r16 = (BotModel) r15;
        Message r8 = this.$blockModel.j();
        d3 r6 = d3.a;
        if (r16 == null) goto L52;
        String r17 = r16.getBotId();
        if (r17 == null) goto L52;
        String r9 = r17;
    L53:
        Integer r18 = r7.getStatus();
        int r10 = ArtifactStatus.GENERATING.getValue();
        if (r18 != null) goto L57;
    L60:
        int r11 = ArtifactStatus.GENERATED.getValue();
        if (r18 != null) goto L64;
    L65:
        int r12 = ArtifactStatus.OUTDATED.getValue();
        if (r18 != null) goto L69;
    L70:
        int r13 = ArtifactStatus.DELETED.getValue();
        if (r18 != null) goto L74;
    L76:
        r6.g(r5, r9, r7, r8, r3);
    L132:
        return Unit.INSTANCE;
    L74:
        if (r18.intValue() != r13) goto L76;
    L75:
        r3 = "aippt_tool_result_card_click";
        goto L76
    L69:
        if (r18.intValue() == r12) goto L75;
    L64:
        if (r18.intValue() == r11) goto L75;
    L57:
        if (r18.intValue() != r10) goto L60;
        r3 = "aippt_tool_progress_card_click";
    L52:
        r9 = "";
        goto L53
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        MarkdownReferenceWidget r19 = this.this$0.e;
        if (r19 == null) goto L136;
        View r110 = r19.getRootView();
        if (r110 == null) goto L136;
        Context r14 = r110.getContext();
        if (r14 == null) goto L136;
        BlockContent r111 = this.$blockModel.a.getContent();
        if (r111 == null) goto L134;
        ArtifactOPBlock r112 = r111.getArtifactOpBlock();
        if (r112 == null) goto L134;
        ArtifactBlock r113 = r112.getArtifact();
        if (r113 != null) goto L25;
        return Unit.INSTANCE;
    L25:
        if (this.$notSupportArrowAndJump == true) goto L27;
        ArtifactOPBlock r20 = this.$block;
        TraceFragment r21 = null;
        if (r20 == null) goto L33;
        ArtifactBlock r22 = r20.getArtifact();
        if (r22 == null) goto L33;
        Integer r23 = r22.getResourceType();
    L35:
        if (r23 != null) goto L38;
    L77:
        b r24 = this.this$0;
        Message r25 = this.$blockModel.j();
        kc8.b r26 = this.this$0.d;
        if (r26 == null) goto L82;
        kc8.y r27 = r26.a;
        if (r27 == null) goto L82;
        Fragment r28 = r27.a;
    L83:
        r24.getClass();
        if (r113.getResourceId() == null) goto L132;
        if (r28 == null) goto L132;
        Integer r29 = r113.getSourceType();
        if (r29 != null) goto L92;
    L93:
        String r30 = r113.getConversationId();
    L95:
        IFlowSdkDepend r114 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r114 == null) goto L132;
        r114.N();
        n1 r115 = n1.a;
        Pair[] r116 = new Pair[14];
        r116[0] = TuplesKt.to("key_doc_id", r113.getResourceId());
        r116[1] = TuplesKt.to("artifact_meta_id", r113.getArtifactMetaId());
        r116[2] = TuplesKt.to("resource_type", r113.getResourceType());
        r116[3] = TuplesKt.to("argConversationId", r30);
        String r31 = r25.getConversationId();
        if (r31 != null) goto L100;
        r31 = r113.getConversationId();
    L100:
        r116[4] = TuplesKt.to("trackingConversationId", r31);
        r116[5] = TuplesKt.to("argBotId", r25.getSenderId());
        r116[6] = TuplesKt.to("key_resource_version", r113.getResourceVersion());
        r116[7] = TuplesKt.to("key_artifact_version_id", r113.getArtifactVersionId());
        Map r117 = r25.getExt();
        if (r117 == null) goto L103;
        String r118 = (String) r117.get("feishu_record_id");
    L105:
        if (TextUtils.isEmpty(r118) == true) goto L107;
        r3 = "feishu_recording_artifact_result_card_click";
    L107:
        r116[8] = TuplesKt.to("key_doc_enter_from", r3);
        r116[9] = TuplesKt.to("argMessageId", r25.getMessageId());
        Map r119 = r25.getExt();
        if (r119 == null) goto L110;
        String r120 = (String) r119.get("feishu_record_id");
    L111:
        r116[10] = TuplesKt.to("key_is_new_audio_record", Boolean.valueOf(!TextUtils.isEmpty(r120)));
        Map r121 = r25.getExt();
        if (r121 == null) goto L114;
        String r122 = (String) r121.get("feishu_record_id");
    L115:
        r116[11] = TuplesKt.to("feishu_record_id", r122);
        Map r123 = r25.getExt();
        if (r123 == null) goto L118;
        String r124 = (String) r123.get("feishu_record_generated_type");
    L119:
        r116[12] = TuplesKt.to("feishu_record_generated_type", r124);
        Map r125 = r25.getExt();
        if (r125 == null) goto L122;
        String r126 = (String) r125.get("feishu_record_generated_type");
    L123:
        r116[13] = TuplesKt.to("record_scene", tx9.l.a(r126));
        Bundle r127 = com.larus.utils.f.c(r116);
        if ((r28 instanceof TraceFragment) == false) goto L126;
        r21 = (TraceFragment) r28;
    L126:
        if (r21 == null) goto L129;
        String r32 = r21.k();
        if (r32 == null) goto L129;
    L130:
        r115.x(r14, r127, r32);
    L129:
        r32 = "chat";
        goto L130
    L122:
        r126 = null;
        goto L123
    L118:
        r124 = null;
        goto L119
    L114:
        r122 = null;
        goto L115
    L110:
        r120 = null;
        goto L111
    L103:
        r118 = null;
        goto L105
    L92:
        if (r29.intValue() != 2) goto L93;
        r30 = null;
    L82:
        r28 = null;
        goto L83
    L38:
        if (r23.intValue() != 9) goto L77;
        IBotRepoService r33 = zh8.a.e;
        String r34 = this.$blockModel.j().getConversationId();
        if (r34 != null) goto L42;
        r34 = "";
    L42:
        this.L$0 = r14;
        this.L$1 = r113;
        this.label = 1;
        Object r35 = r33.j1(r34, false, this);
        if (r35 != r0) goto L45;
        return r0;
    L45:
        r7 = r113;
        r5 = r14;
        r15 = r35;
    L33:
        r23 = null;
        goto L35
    L27:
        return Unit.INSTANCE;
    L134:
        return Unit.INSTANCE;
    L136:
        return Unit.INSTANCE;
    }
}
