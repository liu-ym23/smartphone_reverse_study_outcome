package com.larus.uaigc.createpage.utils;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.m1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import tx9.y3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$onUploadSuccess$1", f = "ImageEditSendMessageStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$onUploadSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $finalFilePath;
    final /* synthetic */ Message $imageMsg;
    final /* synthetic */ int $instructionType;
    final /* synthetic */ mr9.l $result;
    final /* synthetic */ Message $textMsg;
    final /* synthetic */ Function1<hy9.j, Unit> $uploadSuccessCallback;
    int label;
    final /* synthetic */ ImageEditSendMessageStrategy this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$onUploadSuccess$1(Function1<? super hy9.j, Unit> r1, mr9.l r2, String r3, Message r4, Message r5, ImageEditSendMessageStrategy r6, int r7, Continuation<? super ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$onUploadSuccess$1> r8) {
        this.$uploadSuccessCallback = r1;
        this.$result = r2;
        this.$finalFilePath = r3;
        this.$imageMsg = r4;
        this.$textMsg = r5;
        this.this$0 = r6;
        this.$instructionType = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$onUploadSuccess$1(this.$uploadSuccessCallback, this.$result, this.$finalFilePath, this.$imageMsg, this.$textMsg, this.this$0, this.$instructionType, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r82) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L226;
        ResultKt.throwOnFailure(r82);
        Function1<hy9.j, Unit> r0 = this.$uploadSuccessCallback;
        String r2 = "";
        if (r0 == null) goto L14;
        mr9.l r4 = this.$result;
        String r5 = this.$finalFilePath;
        String r6 = this.$imageMsg.getLocalMessageId();
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        String r7 = this.$textMsg.getLocalMessageId();
        if (r7 == null) goto L13;
        r2 = r7;
    L13:
        r0.invoke(new hy9.j(r4, r5, r6, r2));
    L224:
        return Unit.INSTANCE;
    L14:
        ImageEditSendMessageStrategy r11 = this.this$0;
        mr9.l r3 = this.$result;
        String r1 = this.$finalFilePath;
        final Message r9 = this.$imageMsg;
        Message r10 = this.$textMsg;
        int r8 = this.$instructionType;
        final hy9.f r12 = r11.a;
        String r13 = r3.a;
        if (r13 != null) goto L17;
        r13 = "";
    L17:
        FLogger.a.i("ImageEditSendMessageStrategy", "ai beautify upload image success, tosKey = ".concat(r13));
        mr9.d r14 = r3.d;
        String r33 = null;
        if (r14 == null) goto L20;
        Integer r15 = Integer.valueOf(r14.a);
    L21:
        mr9.d r16 = r3.d;
        if (r16 == null) goto L24;
        Integer r17 = Integer.valueOf(r16.b);
    L25:
        final AttachmentInfo r32 = new AttachmentInfo(true, r13, r15, r17, r1, null, "", null, null, null, null, null, null, r3.g, null, null, null, 122752, null);
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L31
        ouc.v r19 = xt7.d.b;     // Catch: Throwable -> L31
        juc.c r20 = com.larus.bmhome.actionbar.model.r.Companion.serializer();     // Catch: Throwable -> L31
        String r21 = r12.e;     // Catch: Throwable -> L31
        if (r21 != null) goto L29;
        r21 = "";
    L29:
        Object r22 = Result.constructor-impl((com.larus.bmhome.actionbar.model.r) r19.c(r20, r21));     // Catch: Throwable -> L31
    L34:
        if (Result.isFailure-impl(r22) == false) goto L36;
        r22 = null;
    L36:
        com.larus.bmhome.actionbar.model.r r23 = (com.larus.bmhome.actionbar.model.r) r22;
        if (r23 == null) goto L44;
        Integer r110 = r23.a;
        if (r110 == null) goto L44;
        if (r110.intValue() != 28) goto L44;
        boolean r111 = true;
    L45:
        if (r111 == false) goto L124;
        com.larus.bmhome.actionbar.model.y r112 = r23.i;
        if (r112 == null) goto L185;
        ArrayList r113 = r112.a;
        if (r113 == null) goto L185;
        z0 r114 = (z0) CollectionsKt.firstOrNull(r113);
        if (r114 == null) goto L185;
        com.larus.bmhome.actionbar.model.r r115 = r114.q;
        if (r115 == null) goto L60;
        Integer r116 = r115.a;
        if (r116 == null) goto L60;
        if (r116.intValue() != 4) goto L60;
        boolean r117 = true;
    L61:
        if (r117 == false) goto L122;
        com.larus.bmhome.actionbar.model.r r118 = r114.q;
        if (r118 == null) goto L122;
        List r119 = r118.b;
        if (r119 == null) goto L122;
        Iterator r120 = r119.iterator();
    L68:
        if (r120.hasNext() == false) goto L78;
        Object r121 = r120.next();
        Integer r24 = ((com.larus.bmhome.actionbar.model.u) r121).b;
        if (r24 != null) goto L73;
    L75:
        boolean r25 = false;
    L76:
        if (r25 == false) goto L68;
    L79:
        com.larus.bmhome.actionbar.model.u r26 = (com.larus.bmhome.actionbar.model.u) r121;
        if (r26 == null) goto L122;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L116
        ouc.v r123 = xt7.d.b;     // Catch: Throwable -> L116
        com.larus.bmhome.actionbar.model.v.b r124 = com.larus.bmhome.actionbar.model.v.Companion;     // Catch: Throwable -> L116
        juc.n r27 = r124.serializer();     // Catch: Throwable -> L116
        juc.c r125 = r124.serializer();     // Catch: Throwable -> L116
        com.larus.bmhome.actionbar.model.r r126 = r114.q;     // Catch: Throwable -> L116
        if (r126 == null) goto L102;
        List r127 = r126.b;     // Catch: Throwable -> L116
        if (r127 == null) goto L102;
        Iterator r128 = r127.iterator();     // Catch: Throwable -> L116
    L87:
        if (r128.hasNext() == false) goto L98;
        Object r129 = r128.next();     // Catch: Throwable -> L116
        Integer r130 = ((com.larus.bmhome.actionbar.model.u) r129).b;     // Catch: Throwable -> L116
        if (r130 != null) goto L92;
    L94:
        boolean r131 = false;
    L95:
        if (r131 == false) goto L87;
    L99:
        com.larus.bmhome.actionbar.model.u r28 = (com.larus.bmhome.actionbar.model.u) r129;     // Catch: Throwable -> L116
        if (r28 == null) goto L102;
        String r29 = r28.d;     // Catch: Throwable -> L116
    L103:
        if (r29 == null) goto L106;
        r2 = r29;
    L106:
        com.larus.bmhome.actionbar.model.v r30 = (com.larus.bmhome.actionbar.model.v) r123.c(r125, r2);     // Catch: Throwable -> L116
        mr9.d r132 = r3.d;     // Catch: Throwable -> L116
        if (r132 == null) goto L109;
        long r133 = r132.b;     // Catch: Throwable -> L116
    L110:
        Long r134 = Long.valueOf(r133);     // Catch: Throwable -> L116
        mr9.d r31 = r3.d;     // Catch: Throwable -> L116
        if (r31 == null) goto L113;
        long r135 = r31.a;     // Catch: Throwable -> L116
    L114:
        r30.c = CollectionsKt.mutableListOf(new MediaAttachment[]{new MediaAttachment(null, r13, new ImageUploadInfo(r134, Long.valueOf(r135)), null, null, null, null, null, null, null, null, null, 4089, null)});     // Catch: Throwable -> L116
        Object r34 = Result.constructor-impl(r123.a(r27, r30));     // Catch: Throwable -> L116
    L119:
        if (Result.isFailure-impl(r34) == false) goto L121;
        r34 = null;
    L121:
        r26.d = (String) r34;
        Unit r35 = Unit.INSTANCE;
        goto L122
    L113:
        r135 = 0;
        goto L114
    L109:
        r133 = 0;
        goto L110
    L92:
        if (r130.intValue() != 15) goto L94;
        r131 = true;
        goto L95
    L98:
        r129 = null;
    L102:
        r29 = null;
    L116:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L119
    L73:
        if (r24.intValue() != 15) goto L75;
        r25 = true;
        goto L76
    L78:
        r121 = null;
    L122:
        Unit r37 = Unit.INSTANCE;
    L60:
        r117 = false;
    L185:
        r10 = r10;
        r11 = r11;
    L186:
        if (r23 != null) goto L227;
        String r136 = null;
    L196:
        final Map r137 = com.larus.bmhome.instruction.j.a.c(IAIChatUgcAIGCService.a.e0(), r12.l, String.valueOf(r8), r136, false, r12.g, null, 40);
        FragmentActivity r38 = r12.a.getActivity();
        if (r38 == null) goto L199;
        final Message r138 = r10;
        final ImageEditSendMessageStrategy r139 = r11;
        r38.runOnUiThread(new f(r12, r9, r138, r139, r32, r137));
        Unit r39 = Unit.INSTANCE;
    L199:
        ny9.u r40 = r12.f;
        if (r40 == null) goto L202;
        String r43 = r40.getClickFrom();
    L203:
        ny9.u r41 = r12.f;
        if (r41 == null) goto L206;
        String r45 = r41.m();
    L207:
        ny9.u r42 = r12.f;
        if (r42 == null) goto L210;
        String r46 = r42.i();
    L211:
        ny9.u r44 = r12.f;
        if (r44 == null) goto L214;
        String r49 = r44.getEnterMethod();
    L215:
        String r47 = r12.h;
        if (StringsKt.isBlank(r13) == false) goto L218;
        String r48 = "0";
    L219:
        String r410 = r48;
        if (StringsKt.isBlank(r13) == false) goto L222;
        r33 = "upload";
    L222:
        IAIChatControlTraceService.Companion r50 = IAIChatControlTraceService.a;
        y3.a(r47, "chat", null, r33, "pic", null, r410, null, null, r43, null, r45, r46, null, null, r49, null, r50.h(r50.gb()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -682076, 65535);
        Unit r51 = Unit.INSTANCE;
        goto L224
    L218:
        r48 = "1";
        goto L219
    L214:
        r49 = null;
        goto L215
    L210:
        r46 = null;
        goto L211
    L206:
        r45 = null;
        goto L207
    L202:
        r43 = null;
        goto L203
    L227:
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L189
        Object r53 = Result.constructor-impl(xt7.d.b.a(com.larus.bmhome.actionbar.model.r.Companion.serializer(), r23));     // Catch: Throwable -> L189
    L192:
        if (Result.isFailure-impl(r53) == false) goto L194;
        r53 = null;
    L194:
        r136 = (String) r53;
    L189:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        r53 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L192
    L124:
        if (r23 == null) goto L185;
        List r55 = r23.b;
        if (r55 == null) goto L185;
        Iterator r56 = r55.iterator();
    L129:
        if (r56.hasNext() == false) goto L139;
        Object r57 = r56.next();
        Integer r140 = ((com.larus.bmhome.actionbar.model.u) r57).b;
        if (r140 != null) goto L134;
    L136:
        boolean r141 = false;
    L137:
        if (r141 == false) goto L129;
    L140:
        com.larus.bmhome.actionbar.model.u r58 = (com.larus.bmhome.actionbar.model.u) r57;
        if (r58 == null) goto L185;
        Result.Companion r59 = Result.Companion;     // Catch: Throwable -> L178
        ouc.v r60 = xt7.d.b;     // Catch: Throwable -> L178
        m1.b r142 = m1.Companion;     // Catch: Throwable -> L178
        juc.n r143 = r142.serializer();     // Catch: Throwable -> L178
        juc.c r144 = r142.serializer();     // Catch: Throwable -> L178
        List r145 = r23.b;     // Catch: Throwable -> L178
        if (r145 == null) goto L161;
        Iterator r146 = r145.iterator();     // Catch: Throwable -> L178
    L146:
        if (r146.hasNext() == false) goto L157;
        Object r147 = r146.next();     // Catch: Throwable -> L178
        Integer r148 = ((com.larus.bmhome.actionbar.model.u) r147).b;     // Catch: Throwable -> L178
        if (r148 != null) goto L151;
    L153:
        boolean r149 = false;
    L154:
        if (r149 == false) goto L146;
    L158:
        com.larus.bmhome.actionbar.model.u r61 = (com.larus.bmhome.actionbar.model.u) r147;     // Catch: Throwable -> L178
        if (r61 == null) goto L161;
        String r62 = r61.d;     // Catch: Throwable -> L178
    L162:
        if (r62 == null) goto L165;
        r2 = r62;
    L165:
        m1 r63 = (m1) r60.c(r144, r2);     // Catch: Throwable -> L178
        mr9.d r150 = r3.d;     // Catch: Throwable -> L178
        if (r150 == null) goto L168;
        long r151 = r150.b;     // Catch: Throwable -> L178
    L169:
        Long r152 = Long.valueOf(r151);     // Catch: Throwable -> L178
        mr9.d r64 = r3.d;     // Catch: Throwable -> L178
        if (r64 == null) goto L173;
        long r153 = r64.a;     // Catch: Throwable -> L178
    L229:
        r63.d = new MediaAttachment(null, r13, new ImageUploadInfo(r152, Long.valueOf(r153)), null, null, null, null, null, null, null, null, null, 4089, null);     // Catch: Throwable -> L176
        Object r65 = Result.constructor-impl(r60.a(r143, r63));     // Catch: Throwable -> L176
    L182:
        if (Result.isFailure-impl(r65) == false) goto L184;
        r65 = null;
    L184:
        r58.d = (String) r65;
        Unit r66 = Unit.INSTANCE;
    L176:
        th = th;
    L180:
        Result.Companion r67 = Result.Companion;
        r65 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L182
    L173:
        r153 = 0;
        goto L229
    L168:
        r151 = 0;
        goto L169
    L151:
        if (r148.intValue() != 14) goto L153;
        r149 = true;
        goto L154
    L157:
        r147 = null;
    L161:
        r62 = null;
    L178:
        th = th;
        r10 = r10;
        r11 = r11;
        goto L180
    L134:
        if (r140.intValue() != 14) goto L136;
        r141 = true;
        goto L137
    L139:
        r57 = null;
    L44:
        r111 = false;
    L31:
        th = move-exception;
        Result.Companion r68 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L24:
        r17 = null;
        goto L25
    L20:
        r15 = null;
        goto L21
    L226:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
