package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.m1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
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
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import tx9.y3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2$1$3$1", f = "ImageEditSendMessageStrategy.kt", i = {0, 1, 1, 1, 2, 2, 2, 2}, l = {576, 585, 592}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "uri", "imageUploadInfo", "$this$launch", "uri", "imageUploadInfo", "url"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
public final class ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AttachmentInfo $attachmentInfo;
    final /* synthetic */ Ref.ObjectRef<Map<String, String>> $extra;
    final /* synthetic */ ImageEditDataWithMask $imageEditDataWithMask;
    final /* synthetic */ Message $imageMsg;
    final /* synthetic */ Message $textMsg;
    final /* synthetic */ hy9.f $this_run;
    final /* synthetic */ String $tosKey;
    final /* synthetic */ Deferred<mr9.l> $uploadMaskJob;
    final /* synthetic */ Deferred<mr9.l> $uploadOriginalJob;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ImageEditSendMessageStrategy this$0;

    public ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2$1$3$1(Deferred<mr9.l> r1, ImageEditDataWithMask r2, Deferred<mr9.l> r3, Ref.ObjectRef<Map<String, String>> r4, hy9.f r5, ImageEditSendMessageStrategy r6, Message r7, Message r8, AttachmentInfo r9, String r10, Continuation<? super ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2$1$3$1> r11) {
        this.$uploadOriginalJob = r1;
        this.$imageEditDataWithMask = r2;
        this.$uploadMaskJob = r3;
        this.$extra = r4;
        this.$this_run = r5;
        this.this$0 = r6;
        this.$imageMsg = r7;
        this.$textMsg = r8;
        this.$attachmentInfo = r9;
        this.$tosKey = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2$1$3$1 r12 = new ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2$1$3$1(this.$uploadOriginalJob, this.$imageEditDataWithMask, this.$uploadMaskJob, this.$extra, this.$this_run, this.this$0, this.$imageMsg, this.$textMsg, this.$attachmentInfo, this.$tosKey, r15);
        r12.L$0 = r14;
        return r12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r72) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        String r1 = (String) this.L$3;
        ImageUploadInfo r3 = (ImageUploadInfo) this.L$2;
        String r4 = (String) this.L$1;
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r72);
        String r10 = r1;
        ImageUploadInfo r12 = r3;
        String r11 = r4;
        Object r6 = r72;
    L70:
        mr9.l r7 = (mr9.l) r6;
        hy9.f r8 = this.$this_run;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L76
        ouc.v r13 = xt7.d.b;     // Catch: Throwable -> L76
        juc.c r14 = com.larus.bmhome.actionbar.model.r.Companion.serializer();     // Catch: Throwable -> L76
        String r15 = r8.e;     // Catch: Throwable -> L76
        if (r15 != null) goto L74;
        r15 = "";
    L74:
        Object r16 = Result.constructor-impl((com.larus.bmhome.actionbar.model.r) r13.c(r14, r15));     // Catch: Throwable -> L76
    L79:
        if (Result.isFailure-impl(r16) == false) goto L81;
        r16 = null;
    L81:
        com.larus.bmhome.actionbar.model.r r17 = (com.larus.bmhome.actionbar.model.r) r16;
        if (r17 == null) goto L89;
        Integer r18 = r17.a;
        if (r18 == null) goto L89;
        if (r18.intValue() != 28) goto L89;
        boolean r19 = true;
    L90:
        if (r19 == false) goto L162;
        com.larus.bmhome.actionbar.model.y r20 = r17.i;
        if (r20 == null) goto L214;
        ArrayList r21 = r20.a;
        if (r21 == null) goto L214;
        z0 r22 = (z0) CollectionsKt.firstOrNull(r21);
        if (r22 == null) goto L214;
        com.larus.bmhome.actionbar.model.r r23 = r22.q;
        if (r23 == null) goto L105;
        Integer r24 = r23.a;
        if (r24 == null) goto L105;
        if (r24.intValue() != 4) goto L105;
        boolean r25 = true;
    L106:
        if (r25 == false) goto L161;
        com.larus.bmhome.actionbar.model.r r26 = r22.q;
        if (r26 == null) goto L161;
        List r27 = r26.b;
        if (r27 == null) goto L161;
        Iterator r28 = r27.iterator();
    L113:
        if (r28.hasNext() == false) goto L123;
        Object r29 = r28.next();
        Integer r110 = ((com.larus.bmhome.actionbar.model.u) r29).b;
        if (r110 != null) goto L118;
    L120:
        boolean r111 = false;
    L121:
        if (r111 == false) goto L113;
    L124:
        com.larus.bmhome.actionbar.model.u r30 = (com.larus.bmhome.actionbar.model.u) r29;
        if (r30 == null) goto L161;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L155
        ouc.v r112 = xt7.d.b;     // Catch: Throwable -> L155
        com.larus.bmhome.actionbar.model.v.b r32 = com.larus.bmhome.actionbar.model.v.Companion;     // Catch: Throwable -> L155
        juc.n r113 = r32.serializer();     // Catch: Throwable -> L155
        juc.c r33 = r32.serializer();     // Catch: Throwable -> L155
        com.larus.bmhome.actionbar.model.r r34 = r22.q;     // Catch: Throwable -> L155
        if (r34 == null) goto L146;
        List r35 = r34.b;     // Catch: Throwable -> L155
        if (r35 == null) goto L146;
        Iterator r36 = r35.iterator();     // Catch: Throwable -> L155
    L132:
        if (r36.hasNext() == false) goto L142;
        Object r114 = r36.next();     // Catch: Throwable -> L155
        Integer r37 = ((com.larus.bmhome.actionbar.model.u) r114).b;     // Catch: Throwable -> L155
        if (r37 != null) goto L137;
    L139:
        boolean r38 = false;
    L140:
        if (r38 == false) goto L132;
    L143:
        com.larus.bmhome.actionbar.model.u r39 = (com.larus.bmhome.actionbar.model.u) r114;     // Catch: Throwable -> L155
        if (r39 == null) goto L146;
        String r40 = r39.d;     // Catch: Throwable -> L155
    L147:
        if (r40 != null) goto L149;
        r40 = "";
    L149:
        com.larus.bmhome.actionbar.model.v r41 = (com.larus.bmhome.actionbar.model.v) r112.c(r33, r40);     // Catch: Throwable -> L155
        if (r7 == null) goto L152;
        String r210 = r7.a;     // Catch: Throwable -> L155
    L153:
        r41.c = CollectionsKt.mutableListOf(new MediaAttachment[]{new MediaAttachment(r10, r11, r12, null, null, null, null, null, null, null, r210, null, 3064, null)});     // Catch: Throwable -> L155
        Object r42 = Result.constructor-impl(r112.a(r113, r41));     // Catch: Throwable -> L155
    L158:
        if (Result.isFailure-impl(r42) == false) goto L160;
        r42 = null;
    L160:
        r30.d = (String) r42;
        Unit r43 = Unit.INSTANCE;
        goto L161
    L152:
        r210 = null;
        goto L153
    L137:
        if (r37.intValue() != 15) goto L139;
        r38 = true;
        goto L140
    L142:
        r114 = null;
    L146:
        r40 = null;
    L155:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r42 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L158
    L118:
        if (r110.intValue() != 15) goto L120;
        r111 = true;
        goto L121
    L123:
        r29 = null;
    L161:
        Unit r45 = Unit.INSTANCE;
    L105:
        r25 = false;
    L214:
        if (r17 != null) goto L272;
        String r115 = null;
    L224:
        Ref.ObjectRef<Map<String, String>> r46 = this.$extra;
        com.larus.bmhome.instruction.j r47 = IAIChatUgcAIGCService.a.e0();
        hy9.f r48 = this.$this_run;
        Map r49 = com.larus.bmhome.instruction.j.a.c(r47, r48.l, "16", r115, false, r48.g, null, 40);
        if (r49 == null) goto L232;
        Map r50 = MapsKt.toMutableMap(r49);
        if (r50 == null) goto L232;
        ImageEditDataWithMask r51 = this.$imageEditDataWithMask;
        zd9.h.a.getClass();
        String r52 = zd9.h.c(r51);
        if (r52 != null) goto L231;
        r52 = "";
    L231:
        r50.put("image_edit_media_data", r52);
    L233:
        r46.element = r50;
        ImageEditSendMessageStrategy.a(this.this$0, this.$imageMsg, false);
        hy9.f r53 = this.$this_run;
        ICoreInputAbility r54 = r53.k;
        if (r54 == null) goto L246;
        String r55 = r53.d;
        Map r310 = (Map) this.$extra.element;
        String r56 = this.$imageMsg.getLocalMessageId();
        if (r56 != null) goto L238;
        r56 = "";
    L238:
        List r410 = CollectionsKt.listOf(r56);
        String r411 = this.$textMsg.getLocalMessageId();
        ny9.u r57 = this.$this_run.f;
        if (r57 == null) goto L241;
        String r58 = r57.getEnterMethod();
    L242:
        if (r58 != null) goto L244;
        String r412 = "";
    L245:
        r54.E0(new ICoreInputAbility.OnSendParams(r55, "", this.$attachmentInfo, null, null, r310, null, null, 16, false, "", false, false, false, null, null, r410, r411, false, r412, null, null, null, null, null, null, null, null, this.$this_run.o, this.this$0.h(), null, null, null, -806291264, 1, null));
        Unit r59 = Unit.INSTANCE;
        goto L246
    L244:
        r412 = r58;
        goto L245
    L241:
        r58 = null;
    L246:
        ny9.u r60 = this.$this_run.f;
        if (r60 == null) goto L249;
        String r311 = r60.getClickFrom();
    L250:
        ny9.u r61 = this.$this_run.f;
        if (r61 == null) goto L253;
        String r312 = r61.m();
    L254:
        ny9.u r62 = this.$this_run.f;
        if (r62 == null) goto L257;
        String r313 = r62.i();
    L258:
        ny9.u r63 = this.$this_run.f;
        if (r63 == null) goto L261;
        String r314 = r63.getEnterMethod();
    L262:
        String r64 = this.$this_run.h;
        if (StringsKt.isBlank(this.$tosKey) == false) goto L265;
        String r65 = "0";
    L266:
        String r315 = r65;
        if (StringsKt.isBlank(this.$tosKey) == false) goto L269;
        String r211 = "upload";
    L270:
        IAIChatControlTraceService.Companion r66 = IAIChatControlTraceService.a;
        y3.a(r64, "chat", null, r211, "pic", null, r315, null, null, r311, null, r312, r313, null, null, r314, null, r66.h(r66.gb()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -682076, 65535);
        return Unit.INSTANCE;
    L269:
        r211 = null;
        goto L270
    L265:
        r65 = "1";
        goto L266
    L261:
        r314 = null;
        goto L262
    L257:
        r313 = null;
        goto L258
    L253:
        r312 = null;
        goto L254
    L249:
        r311 = null;
    L232:
        r50 = null;
        goto L233
    L272:
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L217
        Object r68 = Result.constructor-impl(xt7.d.b.a(com.larus.bmhome.actionbar.model.r.Companion.serializer(), r17));     // Catch: Throwable -> L217
    L220:
        if (Result.isFailure-impl(r68) == false) goto L222;
        r68 = null;
    L222:
        r115 = (String) r68;
    L217:
        th = move-exception;
        Result.Companion r69 = Result.Companion;
        r68 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L220
    L162:
        if (r17 == null) goto L214;
        List r70 = r17.b;
        if (r70 == null) goto L214;
        Iterator r71 = r70.iterator();
    L167:
        if (r71.hasNext() == false) goto L177;
        Object r73 = r71.next();
        Integer r74 = ((com.larus.bmhome.actionbar.model.u) r73).b;
        if (r74 != null) goto L172;
    L174:
        boolean r75 = false;
    L175:
        if (r75 == false) goto L167;
    L178:
        com.larus.bmhome.actionbar.model.u r76 = (com.larus.bmhome.actionbar.model.u) r73;
        if (r76 == null) goto L214;
        Result.Companion r77 = Result.Companion;     // Catch: Throwable -> L208
        ouc.v r78 = xt7.d.b;     // Catch: Throwable -> L208
        m1.b r79 = m1.Companion;     // Catch: Throwable -> L208
        juc.n r116 = r79.serializer();     // Catch: Throwable -> L208
        juc.c r80 = r79.serializer();     // Catch: Throwable -> L208
        List r117 = r17.b;     // Catch: Throwable -> L208
        if (r117 == null) goto L199;
        Iterator r118 = r117.iterator();     // Catch: Throwable -> L208
    L184:
        if (r118.hasNext() == false) goto L195;
        Object r119 = r118.next();     // Catch: Throwable -> L208
        Integer r81 = ((com.larus.bmhome.actionbar.model.u) r119).b;     // Catch: Throwable -> L208
        if (r81 != null) goto L189;
    L191:
        boolean r82 = false;
    L192:
        if (r82 == false) goto L184;
    L196:
        com.larus.bmhome.actionbar.model.u r120 = (com.larus.bmhome.actionbar.model.u) r119;     // Catch: Throwable -> L208
        if (r120 == null) goto L199;
        String r83 = r120.d;     // Catch: Throwable -> L208
    L200:
        if (r83 != null) goto L202;
        r83 = "";
    L202:
        m1 r84 = (m1) r78.c(r80, r83);     // Catch: Throwable -> L208
        if (r7 == null) goto L205;
        String r212 = r7.a;     // Catch: Throwable -> L208
    L206:
        r84.d = new MediaAttachment(r10, r11, r12, null, null, null, null, null, null, null, r212, null, 3064, null);     // Catch: Throwable -> L208
        Object r85 = Result.constructor-impl(r78.a(r116, r84));     // Catch: Throwable -> L208
    L211:
        if (Result.isFailure-impl(r85) == false) goto L213;
        r85 = null;
    L213:
        r76.d = (String) r85;
        Unit r86 = Unit.INSTANCE;
        goto L214
    L205:
        r212 = null;
        goto L206
    L189:
        if (r81.intValue() != 14) goto L191;
        r82 = true;
        goto L192
    L195:
        r119 = null;
    L199:
        r83 = null;
    L208:
        th = move-exception;
        Result.Companion r87 = Result.Companion;
        r85 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L211
    L172:
        if (r74.intValue() != 14) goto L174;
        r75 = true;
        goto L175
    L177:
        r73 = null;
    L89:
        r19 = false;
    L76:
        th = move-exception;
        Result.Companion r88 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L79
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ImageUploadInfo r89 = (ImageUploadInfo) this.L$2;
        String r90 = (String) this.L$1;
        CoroutineScope r91 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r72);
        String r121 = r90;
        Object r92 = r72;
    L53:
        if ((r92 instanceof com.larus.network.http.y) == false) goto L55;
        com.larus.network.http.y r93 = (com.larus.network.http.y) r92;
    L56:
        if (r93 == null) goto L64;
        FileUrlRespData r94 = (FileUrlRespData) ((com.larus.network.http.a) r93).b;
        if (r94 == null) goto L64;
        List r95 = r94.getFileUrlList();
        if (r95 == null) goto L64;
        FileUrlData r96 = (FileUrlData) CollectionsKt.firstOrNull(r95);
        if (r96 == null) goto L64;
        String r97 = r96.getMainUrl();
        ImageUploadInfo r122 = r89;
        CoroutineScope r98 = r91;
    L66:
        Deferred<mr9.l> r99 = this.$uploadMaskJob;
        this.L$0 = r98;
        this.L$1 = r121;
        this.L$2 = r122;
        this.L$3 = r97;
        this.label = 3;
        r6 = r99.await(this);
        if (r6 != r0) goto L69;
        return r0;
    L69:
        r12 = r122;
        r11 = r121;
        r10 = r97;
    L64:
        r122 = r89;
        r98 = r91;
        r97 = null;
        goto L66
    L55:
        r93 = null;
        goto L56
    L11:
        r98 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r72);
        Object r100 = r72;
    L17:
        mr9.l r101 = (mr9.l) r100;
    L19:
        r121 = this.$imageEditDataWithMask.getOriImgUri();
        if (r121 != null) goto L26;
        if (r101 == null) goto L23;
        r121 = r101.a;
    L24:
        if (r121 != null) goto L26;
        r121 = "";
        goto L26
    L23:
        r121 = null;
    L26:
        r122 = this.$imageEditDataWithMask.getImageUploadInfo();
        if (r122 == null) goto L29;
    L40:
        String r102 = this.$imageEditDataWithMask.getOriImgUrl();
        if (r102 != null) goto L43;
    L46:
        boolean r103 = true;
    L47:
        if (r103 == false) goto L65;
        List r104 = CollectionsKt.listOf(r121);
        UploadDataType r123 = UploadDataType.IMAGE;
        this.L$0 = r98;
        this.L$1 = r121;
        this.L$2 = r122;
        this.label = 2;
        r92 = com.larus.uaigc.api.o.b(r104, r123, this);
        if (r92 != r0) goto L51;
        return r0;
    L51:
        r91 = r98;
        r89 = r122;
        goto L53
    L65:
        r97 = this.$imageEditDataWithMask.getOriImgUrl();
        goto L66
    L43:
        if (StringsKt.isBlank(r102) == true) goto L46;
        r103 = false;
        goto L47
    L29:
        if (r101 == null) goto L33;
        mr9.d r124 = r101.d;
        if (r124 == null) goto L33;
        Long r125 = Boxing.boxLong(r124.b);
    L34:
        if (r101 == null) goto L38;
        mr9.d r105 = r101.d;
        if (r105 == null) goto L38;
        Long r106 = Boxing.boxLong(r105.a);
    L39:
        r122 = new ImageUploadInfo(r125, r106);
    L38:
        r106 = null;
    L33:
        r125 = null;
        goto L34
    L12:
        ResultKt.throwOnFailure(r72);
        r98 = (CoroutineScope) this.L$0;
        Deferred<mr9.l> r107 = this.$uploadOriginalJob;
        if (r107 == null) goto L18;
        this.L$0 = r98;
        this.label = 1;
        r100 = r107.await(this);
        if (r100 != r0) goto L17;
        return r0;
    L18:
        r101 = null;
        goto L19
    }
}
