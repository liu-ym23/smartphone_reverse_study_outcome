package com.obric.assistant.network.impl;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import com.obric.assistant.network.api.bean.ObricOmniUploadImageFeedback;
import com.obric.assistant.network.api.bean.ObricOmniUploadImageRequest;
import com.obric.capabilitykit.common.Ext;
import dm9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import m9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$uploadOmniDataFeedbackInternal$1", f = "ObricNetworkServiceImpl.kt", i = {0}, l = {1391}, m = "invokeSuspend", n = {Ext.KEY_REQUEST}, s = {"L$0"})
public final class ObricNetworkServiceImpl$uploadOmniDataFeedbackInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowNetworkResultCallbackIDL $callback;
    final /* synthetic */ Boolean $explicitIsFinish;
    final /* synthetic */ String $feedbackContent;
    final /* synthetic */ List<String> $feedbackTags;
    final /* synthetic */ int $imageCount;
    final /* synthetic */ boolean $isFeedbackOnly;
    final /* synthetic */ String $logName;
    final /* synthetic */ List<ObricNetworkServiceImpl$b> $payloadInputs;
    final /* synthetic */ String $safeTaskId;
    final /* synthetic */ String $safeToolId;
    final /* synthetic */ String $score;
    final /* synthetic */ String $source;
    final /* synthetic */ String $type;
    Object L$0;
    int label;
    final /* synthetic */ ObricNetworkServiceImpl this$0;

    public ObricNetworkServiceImpl$uploadOmniDataFeedbackInternal$1(List<ObricNetworkServiceImpl$b> r1, ObricNetworkServiceImpl r2, String r3, IFlowNetworkResultCallbackIDL r4, Boolean r5, String r6, String r7, boolean r8, int r9, String r10, String r11, List<String> r12, String r13, String r14, Continuation<? super ObricNetworkServiceImpl$uploadOmniDataFeedbackInternal$1> r15) {
        this.$payloadInputs = r1;
        this.this$0 = r2;
        this.$logName = r3;
        this.$callback = r4;
        this.$explicitIsFinish = r5;
        this.$safeTaskId = r6;
        this.$safeToolId = r7;
        this.$isFeedbackOnly = r8;
        this.$imageCount = r9;
        this.$source = r10;
        this.$feedbackContent = r11;
        this.$feedbackTags = r12;
        this.$type = r13;
        this.$score = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r19, Continuation<?> r20) {
        return new ObricNetworkServiceImpl$uploadOmniDataFeedbackInternal$1(this.$payloadInputs, this.this$0, this.$logName, this.$callback, this.$explicitIsFinish, this.$safeTaskId, this.$safeToolId, this.$isFeedbackOnly, this.$imageCount, this.$source, this.$feedbackContent, this.$feedbackTags, this.$type, this.$score, r20);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.obric.assistant.network.impl.j, java.lang.Object] */
    public final Object invokeSuspend(Object r36) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        Integer r9 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ObricOmniUploadImageRequest r1 = (ObricOmniUploadImageRequest) this.L$0;
        ResultKt.throwOnFailure(r36);
        Object r3 = r36;
    L247:
        a.b r4 = (a) r3;
        if ((r4 instanceof a.b) == false) goto L263;
        a.b r5 = r4;
        int r6 = (int) r5.a.getCode();
        if (r6 != 0) goto L252;
        boolean r12 = true;
    L253:
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder();
        r14.append(this.$logName);
        r14.append(" response, task=");
        r14.append(this.$safeTaskId);
        r14.append(", amount=");
        ObricOmniUploadImageFeedback r7 = r1.getFeedback();
        if (r7 == null) goto L256;
        r9 = Boxing.boxInt(r7.getAmount());
    L256:
        r14.append(r9);
        r14.append(", success=");
        r14.append(r12);
        r14.append(", code=");
        r14.append(r6);
        r14.append(", msg=");
        r14.append(r5.a.getMsg());
        r13.i("[ObricNetworkServiceImpl]", r14.toString());
        Map r8 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", String.valueOf(r6)), TuplesKt.to("msg", String.valueOf(r5.a.getMsg()))});
        if (r12 == true) goto L259;
        r8.put("failure_stage", "host_biz");
        r8.put("reason_code", "host_biz_error");
    L259:
        IFlowNetworkResultCallbackIDL r10 = this.$callback;
        if (r10 == null) goto L268;
        r10.onResult(r12, r8);
    L268:
        return Unit.INSTANCE;
    L252:
        r12 = false;
        goto L253
    L263:
        if ((r4 instanceof a.a) == false) goto L270;
        a.a r11 = (a.a) r4;
        FLogger.a.e("[ObricNetworkServiceImpl]", this.$logName + " error", r11.c);
        IFlowNetworkResultCallbackIDL r15 = this.$callback;
        if (r15 == null) goto L268;
        r15.onResult(false, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", String.valueOf(r11.a)), TuplesKt.to("msg", r11.b), TuplesKt.to("failure_stage", "host_http"), TuplesKt.to("reason_code", "host_transport_error")}));
        goto L268
    L270:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r36);
        ArrayList r16 = new ArrayList();
        Iterator<ObricNetworkServiceImpl$b> r17 = this.$payloadInputs.iterator();
    L10:
        if (r17.hasNext() == false) goto L29;
        ObricNetworkServiceImpl$b r18 = r17.next();
        r16.add(ObricNetworkServiceImpl.A(this.this$0, r18));
    L14:
        e = move-exception;
        ObricNetworkServiceImpl$OmniUploadPayloadKind r19 = r18.a;
        if (r19 == null) goto L19;
        String r20 = r19.getDataType();
        if (r20 == null) goto L19;
    L20:
        ObricNetworkServiceImpl r21 = this.this$0;
        String r22 = this.$logName;
        List r23 = ObricNetworkServiceImpl.i;
        r21.getClass();
        if (AppHost.a.isDebug() == false) goto L23;
        FLogger.a.e("[ObricNetworkServiceImpl]", r22 + " prepare failed, payloadKind=" + r20, e);
    L24:
        ObricNetworkServiceImpl r24 = this.this$0;
        IFlowNetworkResultCallbackIDL r25 = this.$callback;
        String r26 = e.getMessage();
        if (r26 != null) goto L27;
        r26 = "prepare upload file failed";
    L27:
        String r27 = e.getReasonCode();
        r24.getClass();
        ObricNetworkServiceImpl.H(r25, r26, "host_prepare", r27);
        return Unit.INSTANCE;
    L23:
        FLogger.a.e("[ObricNetworkServiceImpl]", r22 + " prepare failed, payloadKind=" + r20 + ", exception=" + SequencesKt.joinToString$default(SequencesKt.take(SequencesKt.generateSequence(e, new h()), 4), " <- ", null, null, 0, null, new i(), 30, null));
    L19:
        r20 = "legacy_image";
        goto L20
    L29:
        Iterator r110 = r16.iterator();
    L31:
        if (r110.hasNext() == false) goto L38;
        Object r111 = r110.next();
        if (((ObricNetworkServiceImpl$c) r111).a != ObricNetworkServiceImpl$OmniUploadPayloadKind.IMAGE) goto L35;
        boolean r112 = true;
    L36:
        if (r112 == false) goto L31;
    L39:
        ObricNetworkServiceImpl$c r113 = (ObricNetworkServiceImpl$c) r111;
        Iterator r114 = r16.iterator();
    L41:
        if (r114.hasNext() == false) goto L48;
        Object r115 = r114.next();
        if (((ObricNetworkServiceImpl$c) r115).a != ObricNetworkServiceImpl$OmniUploadPayloadKind.VIEW_TREE) goto L45;
        boolean r116 = true;
    L46:
        if (r116 == false) goto L41;
    L49:
        ObricNetworkServiceImpl$c r117 = (ObricNetworkServiceImpl$c) r115;
        Iterator r118 = r16.iterator();
    L51:
        if (r118.hasNext() == false) goto L58;
        Object r119 = r118.next();
        if (((ObricNetworkServiceImpl$c) r119).a != ObricNetworkServiceImpl$OmniUploadPayloadKind.REACT_VIEW_TREE) goto L55;
        boolean r120 = true;
    L56:
        if (r120 == false) goto L51;
    L59:
        ObricNetworkServiceImpl$c r121 = (ObricNetworkServiceImpl$c) r119;
        if (r113 != null) goto L62;
        final ObricNetworkServiceImpl$c r122 = (ObricNetworkServiceImpl$c) CollectionsKt.firstOrNull(r16);
    L63:
        int r123 = l.a;
        Boolean r124 = this.$explicitIsFinish;
        final ObricNetworkServiceImpl r125 = this.this$0;
        final String r28 = this.$safeTaskId;
        ?? r29 = new j(r122, r125, r28);
        Intrinsics.checkNotNullParameter(r29, "legacyResolver");
        if (r124 != null) goto L67;
        r124 = (Boolean) r29.invoke();
    L67:
        boolean r210 = r124.booleanValue();
        if (r113 == null) goto L71;
        String r30 = r113.d;
        if (r30 == null) goto L71;
    L75:
        String r31 = this.$safeTaskId;
        String r126 = this.$safeToolId;
        if ((!StringsKt.isBlank(r126)) == false) goto L78;
        String r211 = r126;
    L79:
        if (r113 == null) goto L83;
        k r127 = r113.c;
        if (r127 == null) goto L83;
        String r212 = r127.a;
    L84:
        if (r117 == null) goto L88;
        k r128 = r117.c;
        if (r128 == null) goto L88;
        String r213 = r128.a;
    L89:
        if (r121 == null) goto L93;
        k r129 = r121.c;
        if (r129 == null) goto L93;
        String r214 = r129.a;
    L95:
        if (this.$isFeedbackOnly == false) goto L97;
        int r215 = 0;
    L99:
        if (this.$isFeedbackOnly == true) goto L101;
        String r216 = r30;
    L102:
        String r32 = this.$source;
        if (r32 != null) goto L105;
    L109:
        r32 = "data_feedback";
    L110:
        String r217 = r32;
        String r33 = this.$feedbackContent;
        List<String> r130 = this.$feedbackTags;
        String r131 = this.$type;
        String r132 = this.$score;
        if (r33 != null) goto L113;
    L115:
        String r34 = null;
    L116:
        List r35 = b.b(r130);
        ArrayList r133 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10));
        Iterator r37 = ((ArrayList) r35).iterator();
    L118:
        if (r37.hasNext() == false) goto L120;
        r133.add(StringsKt.trim((String) r37.next()).toString());
        goto L118
    L120:
        ArrayList r38 = new ArrayList();
        Iterator r134 = r133.iterator();
    L122:
        if (r134.hasNext() == false) goto L129;
        Object r135 = r134.next();
        if (((String) r135).length() <= 0) goto L126;
        boolean r136 = true;
    L127:
        if (r136 == false) goto L122;
        r38.add(r135);
        goto L122
    L126:
        r136 = false;
        goto L127
    L129:
        if (r131 != null) goto L131;
    L133:
        String r39 = null;
    L134:
        if (r132 != null) goto L136;
    L138:
        String r310 = null;
    L139:
        int r137 = b.a;
        if (r130 == null) goto L153;
        Iterator<T> r138 = r130.iterator();
    L143:
        if (r138.hasNext() == false) goto L147;
        Object r139 = r138.next();
        if (StringsKt.startsWith$default((String) r139, "__omni_feedback_amount=", false, 2, null) == false) goto L143;
    L148:
        String r140 = (String) r139;
        if (r140 == null) goto L153;
        String r141 = StringsKt.removePrefix(r140, "__omni_feedback_amount=");
        if (r141 == null) goto L153;
        Integer r142 = StringsKt.toIntOrNull(r141);
    L154:
        Integer r143 = b.a(r142);
        if (r34 != null) goto L163;
        if (r38.isEmpty() == false) goto L163;
        if (r39 != null) goto L163;
        if (r310 != null) goto L163;
        if (r143 != null) goto L163;
        ObricOmniUploadImageFeedback r218 = null;
    L171:
        String r40 = this.$type;
        if (r40 != null) goto L174;
    L176:
        String r311 = null;
    L177:
        ObricNetworkServiceImpl r41 = this.this$0;
        List r144 = ObricNetworkServiceImpl.i;
        r41.getClass();
        if (r16.isEmpty() == false) goto L180;
        LinkedHashMap r312 = null;
    L218:
        ObricOmniUploadImageRequest r42 = new ObricOmniUploadImageRequest(r31, r211, r212, r213, r214, r215, r210, r216, r217, r218, r311, r312);
        FLogger r43 = FLogger.a;
        StringBuilder r145 = new StringBuilder();
        r145.append(this.$logName);
        r145.append(" start, task=");
        r145.append(this.$safeTaskId);
        r145.append(", tool=");
        r145.append(this.$safeToolId);
        r145.append(", imageCount=");
        r145.append(r42.getImageCount());
        r145.append(", isFinish=");
        r145.append(r42.isFinish());
        r145.append(", type=");
        String r146 = r42.getType();
        String r147 = "";
        if (r146 != null) goto L221;
        r146 = "";
    L221:
        r145.append(r146);
        r145.append(", feedbackType=");
        ObricOmniUploadImageFeedback r148 = r42.getFeedback();
        if (r148 == null) goto L224;
        String r149 = r148.getType();
    L225:
        if (r149 != null) goto L227;
        r149 = "";
    L227:
        r145.append(r149);
        r145.append(", amount=");
        ObricOmniUploadImageFeedback r150 = r42.getFeedback();
        if (r150 == null) goto L230;
        Integer r151 = Boxing.boxInt(r150.getAmount());
    L231:
        r145.append(r151);
        r145.append(", feedbackOnly=");
        r145.append(this.$isFeedbackOnly);
        r145.append(", files=");
        this.this$0.getClass();
        if (r16.isEmpty() == true) goto L235;
        r147 = CollectionsKt.joinToString$default(r16, ",", null, null, 0, null, new g(), 30, null);
    L235:
        r145.append(r147);
        r145.append(", sourceSize=");
        Iterator r152 = r16.iterator();
        long r153 = 0;
    L237:
        if (r152.hasNext() == false) goto L239;
        r153 = r153 + ((ObricNetworkServiceImpl$c) r152.next()).c.b;
        goto L237
    L239:
        r145.append(r153);
        r145.append(", ciphertextBase64=");
        Iterator r44 = r16.iterator();
        int r154 = 0;
    L241:
        if (r44.hasNext() == false) goto L243;
        r154 = r154 + ((ObricNetworkServiceImpl$c) r44.next()).c.a.length();
        goto L241
    L243:
        r145.append(r154);
        r43.i("[ObricNetworkServiceImpl]", r145.toString());
        ObricProtocolApi.a r45 = ObricProtocolApi.a;
        ObricNetworkServiceImpl$uploadOmniDataFeedbackInternal$1$response$1 r46 = new ObricNetworkServiceImpl$uploadOmniDataFeedbackInternal$1$response$1(r42, null);
        this.L$0 = r42;
        this.label = 1;
        r45.getClass();
        r3 = ObricProtocolApi.a.a(r46, this);
        if (r3 != r0) goto L246;
        return r0;
    L246:
        r1 = r42;
        goto L247
    L230:
        r151 = null;
        goto L231
    L224:
        r149 = null;
        goto L225
    L180:
        Iterator r47 = r16.iterator();
    L182:
        if (r47.hasNext() == false) goto L189;
        Object r155 = r47.next();
        if (((ObricNetworkServiceImpl$c) r155).a != ObricNetworkServiceImpl$OmniUploadPayloadKind.IMAGE) goto L186;
        boolean r156 = true;
    L187:
        if (r156 == false) goto L182;
    L190:
        ObricNetworkServiceImpl$c r157 = (ObricNetworkServiceImpl$c) r155;
        Iterator r48 = r16.iterator();
    L192:
        if (r48.hasNext() == false) goto L199;
        Object r158 = r48.next();
        if (((ObricNetworkServiceImpl$c) r158).a != ObricNetworkServiceImpl$OmniUploadPayloadKind.VIEW_TREE) goto L196;
        boolean r159 = true;
    L197:
        if (r159 == false) goto L192;
    L200:
        ObricNetworkServiceImpl$c r160 = (ObricNetworkServiceImpl$c) r158;
        Iterator r49 = r16.iterator();
    L202:
        if (r49.hasNext() == false) goto L209;
        Object r161 = r49.next();
        if (((ObricNetworkServiceImpl$c) r161).a != ObricNetworkServiceImpl$OmniUploadPayloadKind.REACT_VIEW_TREE) goto L206;
        boolean r162 = true;
    L207:
        if (r162 == false) goto L202;
    L210:
        ObricNetworkServiceImpl$c r163 = (ObricNetworkServiceImpl$c) r161;
        LinkedHashMap r50 = new LinkedHashMap();
        r50.put("crypto_app_id", "obric_doubao_assistant");
        if (r157 == null) goto L213;
        r50.put("local_file_name", r157.b.getName());
        String r164 = (String) r50.put("source_size_bytes", String.valueOf(r157.c.b));
    L213:
        if (r160 == null) goto L215;
        r50.put("view_tree_local_file_name", r160.b.getName());
        String r165 = (String) r50.put("view_tree_source_size_bytes", String.valueOf(r160.c.b));
    L215:
        if (r163 == null) goto L217;
        r50.put("react_view_tree_local_file_name", r163.b.getName());
        r50.put("react_view_tree_source_size_bytes", String.valueOf(r163.c.b));
    L217:
        r312 = r50;
        goto L218
    L206:
        r162 = false;
        goto L207
    L209:
        r161 = null;
        goto L210
    L196:
        r159 = false;
        goto L197
    L199:
        r158 = null;
        goto L200
    L186:
        r156 = false;
        goto L187
    L189:
        r155 = null;
        goto L190
    L174:
        if ((!StringsKt.isBlank(r40)) == false) goto L176;
        r311 = r40;
    L163:
        if ((!r38.isEmpty()) == false) goto L165;
        ArrayList r313 = r38;
    L166:
        Integer r51 = b.a(r143);
        if (r51 == null) goto L169;
        int r314 = r51.intValue();
    L170:
        r218 = new ObricOmniUploadImageFeedback(r34, r313, r39, r310, r314);
        goto L171
    L169:
        r314 = -1;
        goto L170
    L165:
        r313 = null;
        goto L166
    L147:
        r139 = null;
    L153:
        r142 = null;
        goto L154
    L136:
        if ((!StringsKt.isBlank(r132)) == false) goto L138;
        r310 = r132;
        goto L139
    L131:
        if ((!StringsKt.isBlank(r131)) == false) goto L133;
        r39 = r131;
        goto L134
    L113:
        if ((!StringsKt.isBlank(r33)) == false) goto L115;
        r34 = r33;
        goto L116
    L105:
        if ((!StringsKt.isBlank(r32)) == true) goto L108;
        r32 = null;
    L108:
        if (r32 != null) goto L110;
    L101:
        r216 = null;
        goto L102
    L97:
        r215 = RangesKt.coerceAtLeast(this.$imageCount, 0);
    L93:
        r214 = null;
    L88:
        r213 = null;
    L83:
        r212 = null;
        goto L84
    L78:
        r211 = null;
    L71:
        ObricNetworkServiceImpl$c r52 = (ObricNetworkServiceImpl$c) CollectionsKt.firstOrNull(r16);
        if (r52 == null) goto L74;
        r30 = r52.d;
        goto L75
    L74:
        r30 = "image/jpeg";
        goto L75
    L62:
        r122 = r113;
        goto L63
    L55:
        r120 = false;
        goto L56
    L58:
        r119 = null;
        goto L59
    L45:
        r116 = false;
        goto L46
    L48:
        r115 = null;
        goto L49
    L35:
        r112 = false;
        goto L36
    L38:
        r111 = null;
        goto L39
    }
}
