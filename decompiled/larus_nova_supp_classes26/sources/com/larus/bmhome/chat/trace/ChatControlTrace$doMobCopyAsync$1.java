package com.larus.bmhome.chat.trace;

import android.text.SpannableStringBuilder;
import android.view.View;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.home.impl.sdk.SdkSheetsServiceImpl;
import com.larus.home.impl.sdk.d1;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatControlTrace$doMobCopyAsync$1", f = "ChatControlTrace.kt", i = {0, 1}, l = {4010, 4012}, m = "invokeSuspend", n = {"isCopyTextInOneTable", "isCopyTextInOneTable"}, s = {"Z$0", "Z$0"})
final class ChatControlTrace$doMobCopyAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $caseId;
    final /* synthetic */ String $caseRecommendFrom;
    final /* synthetic */ String $caseRequestId;
    final /* synthetic */ String $clickModule;
    final /* synthetic */ String $codeType;
    final /* synthetic */ String $contentType;
    final /* synthetic */ String $isCallBot;
    final /* synthetic */ boolean $isImmerseStyle;
    final /* synthetic */ String $isInterrupted;
    final /* synthetic */ boolean $isMessageGenerating;
    final /* synthetic */ boolean $isThinkingGenerating;
    final /* synthetic */ Message $lastShownMsg;
    final /* synthetic */ View $markdownView;
    final /* synthetic */ Message $msg;
    final /* synthetic */ JSONObject $params;
    final /* synthetic */ SelectionRangeType $selectRange;
    final /* synthetic */ by7.e $traceNode;
    final /* synthetic */ boolean $withCode;
    boolean Z$0;
    int label;

    public ChatControlTrace$doMobCopyAsync$1(View r4, String r5, JSONObject r6, Message r7, Message r8, boolean r9, boolean r10, String r11, SelectionRangeType r12, String r13, String r14, String r15, boolean r16, String r17, boolean r18, String r19, String r20, by7.e r21, Continuation<? super ChatControlTrace$doMobCopyAsync$1> r22) {
        this.$markdownView = r4;
        this.$contentType = r5;
        this.$params = r6;
        this.$msg = r7;
        this.$lastShownMsg = r8;
        this.$isImmerseStyle = r9;
        this.$withCode = r10;
        this.$clickModule = r11;
        this.$selectRange = r12;
        this.$caseRecommendFrom = r13;
        this.$isInterrupted = r14;
        this.$codeType = r15;
        this.$isMessageGenerating = r16;
        this.$isCallBot = r17;
        this.$isThinkingGenerating = r18;
        this.$caseId = r19;
        this.$caseRequestId = r20;
        this.$traceNode = r21;
        super(2, r22);
    }

    public final Continuation<Unit> create(Object r23, Continuation<?> r24) {
        return new ChatControlTrace$doMobCopyAsync$1(this.$markdownView, this.$contentType, this.$params, this.$msg, this.$lastShownMsg, this.$isImmerseStyle, this.$withCode, this.$clickModule, this.$selectRange, this.$caseRecommendFrom, this.$isInterrupted, this.$codeType, this.$isMessageGenerating, this.$isCallBot, this.$isThinkingGenerating, this.$caseId, this.$caseRequestId, this.$traceNode, r24);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r53) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r5 = true;
        String r6 = null;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        boolean r3 = this.Z$0;
        ResultKt.throwOnFailure(r53);
        Object r4 = r53;
    L49:
        String r32 = (String) r4;
        String r31 = null;
    L50:
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        ArtifactBlock r8 = com.larus.im.bean.message.a.n(this.$msg);
        if (r8 == null) goto L53;
        Integer r9 = r8.getResourceType();
    L54:
        if (r8 == null) goto L56;
        String r35 = r8.getResourceId();
    L57:
        if (r9 != null) goto L60;
    L62:
        if (r7 == null) goto L64;
        r7.h();
        String r10 = SdkSheetsServiceImpl.a.g().optString("canvas_type", "");
    L65:
        if (r7 == null) goto L72;
        r7.g();
        String r11 = d1.a.a(this.$msg);
        if (r11.length() <= 0) goto L69;
        boolean r12 = true;
    L70:
        if (r12 == false) goto L72;
        String r39 = r11;
    L73:
        JSONObject r13 = yc9.c0.c(this.$msg, this.$params);
        Message r14 = this.$msg;
        Map r15 = r14.getExt();
        if (r15 == null) goto L76;
        String r16 = (String) r15.get("feishu_record_id");
    L77:
        r13.putOpt("feishu_record_id", r16);
        Map r17 = r14.getExt();
        if (r17 == null) goto L80;
        String r18 = (String) r17.get("feishu_record_generated_type");
    L81:
        r13.putOpt("feishu_record_generated_type", r18);
        Map r19 = r14.getExt();
        if (r19 == null) goto L84;
        String r20 = (String) r19.get("feishu_record_generated_type");
    L85:
        r13.putOpt("record_scene", tx9.l.a(r20));
        String r110 = ve8.c.b(this.$isImmerseStyle);
        if (com.larus.bmhome.chat.bean.d.G0(this.$msg) == false) goto L88;
        String r21 = "user";
    L89:
        String r23 = r21;
        if (this.$withCode == false) goto L92;
        long r22 = 1;
    L93:
        long r111 = r22;
        if (com.larus.utils.o0.d(this.$clickModule) == false) goto L96;
        String r24 = this.$clickModule;
    L97:
        String r25 = r24;
        String r27 = com.larus.bmhome.chat.bean.d.u(this.$msg);
        String r45 = com.larus.im.bean.message.a.r(this.$msg);
        String r46 = com.larus.im.bean.message.a.s(this.$msg);
        SelectionRangeType r26 = this.$selectRange;
        if (r26 == null) goto L100;
        String r30 = r26.getValue();
    L101:
        String r33 = com.larus.im.bean.message.a.c(this.$msg);
        if (r9 == null) goto L104;
        String r36 = r9.toString();
    L105:
        if (r8 == null) goto L107;
        String r37 = r8.getArtifactMetaId();
    L108:
        if (r9 == null) goto L110;
        String r38 = r9.toString();
    L111:
        if (r10 != null) goto L113;
    L116:
        if (r5 == false) goto L118;
        String r40 = null;
    L119:
        if (r7 == null) goto L121;
        r7.h();
        r6 = SdkSheetsServiceImpl.a.d(this.$msg);
    L121:
        String r44 = r6;
        String r28 = this.$msg.getMessageId();
        if (r3 == false) goto L124;
        String r29 = "table";
    L125:
        String r34 = r35;
        tx9.j0.a(null, null, null, null, r110, r28, null, this.$caseRecommendFrom, this.$isInterrupted, Boxing.boxLong(r111), this.$codeType, null, null, Boxing.boxBoolean(this.$isMessageGenerating), this.$isCallBot, Boxing.boxBoolean(false), r23, null, r25, Boxing.boxBoolean(this.$isThinkingGenerating), r27, this.$caseId, this.$caseRequestId, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r29, null, com.larus.bmhome.chat.bean.d.l(this.$msg), r44, r45, r46, r13, this.$traceNode, null, 281538367, 4243456);
        return Unit.INSTANCE;
    L124:
        r29 = this.$contentType;
        goto L125
    L118:
        r40 = r10;
        goto L119
    L113:
        if (r10.length() == 0) goto L116;
        r5 = false;
        goto L116
    L110:
        r38 = null;
        goto L111
    L107:
        r37 = null;
        goto L108
    L104:
        r36 = null;
        goto L105
    L100:
        r30 = null;
        goto L101
    L96:
        r24 = ChatControlTrace.b.jb(this.$markdownView);
        goto L97
    L92:
        r22 = 0;
        goto L93
    L88:
        r21 = "bot";
        goto L89
    L84:
        r20 = null;
        goto L85
    L80:
        r18 = null;
        goto L81
    L76:
        r16 = null;
        goto L77
    L69:
        r12 = false;
    L72:
        r39 = null;
        goto L73
    L64:
        r10 = null;
        goto L65
    L60:
        if (r9.intValue() != 15) goto L62;
        r10 = "aibase";
        goto L65
    L56:
        r35 = null;
        goto L57
    L53:
        r9 = null;
        goto L54
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r3 = this.Z$0;
        ResultKt.throwOnFailure(r53);
        Object r41 = r53;
    L44:
        r31 = (String) r41;
        r32 = null;
        goto L50
    L10:
        ResultKt.throwOnFailure(r53);
        ChatControlTrace r42 = ChatControlTrace.b;
        Object r43 = this.$markdownView;
        if ((r43 instanceof CustomMarkdownTextView) == false) goto L13;
        CustomMarkdownTextView r47 = (CustomMarkdownTextView) r43;
    L14:
        String r48 = this.$contentType;
        int r49 = this.$params.optInt("start_index", -1);
        int r112 = this.$params.optInt("end_index", -1);
        r42.getClass();
        if (Intrinsics.areEqual(r48, ShareType.TEXT) == false) goto L37;
        if (r47 == null) goto L37;
        lw8.l r50 = r47.getMarkdownContent();
        if (r50 == null) goto L37;
        SpannableStringBuilder r51 = r50.e();
        if (r51 == null) goto L37;
        if (r49 < 0) goto L37;
        if (r112 <= r49) goto L37;
        io.noties.markwon.ext.tables.s[] r52 = (io.noties.markwon.ext.tables.s[]) r51.getSpans(r49, r112, io.noties.markwon.ext.tables.s.class);
        if (r52 != null) goto L29;
    L31:
        boolean r113 = false;
    L32:
        if (r113 == false) goto L37;
        io.noties.markwon.ext.tables.s r54 = r52[0];
        int r114 = r51.getSpanStart(r54);
        int r55 = r51.getSpanEnd(r54);
        if (r49 < r114) goto L37;
        if (r112 > r55) goto L37;
        boolean r56 = true;
    L39:
        if (com.larus.bmhome.chat.bean.d.G0(this.$msg) == false) goto L45;
        Message r57 = this.$msg;
        Message r58 = this.$lastShownMsg;
        this.Z$0 = r56;
        this.label = 1;
        r41 = r42.w(r57, r58, this);
        if (r41 != r1) goto L43;
        return r1;
    L43:
        r3 = r56;
        goto L44
    L45:
        Message r59 = this.$msg;
        Message r60 = this.$lastShownMsg;
        this.Z$0 = r56;
        this.label = 2;
        r4 = r42.w(r59, r60, this);
        if (r4 != r1) goto L48;
        return r1;
    L48:
        r3 = r56;
        goto L49
    L29:
        if (r52.length != 1) goto L31;
        r113 = true;
    L37:
        r56 = false;
        goto L39
    L13:
        r47 = null;
        goto L14
    }
}
