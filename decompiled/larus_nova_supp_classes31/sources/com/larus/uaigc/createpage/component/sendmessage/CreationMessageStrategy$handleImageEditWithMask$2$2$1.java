package com.larus.uaigc.createpage.component.sendmessage;

import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.m1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import tx9.y3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMessageStrategy$handleImageEditWithMask$2$2$1", f = "CreationMessageStrategy.kt", i = {1, 1, 2, 2, 2}, l = {317, 326, 333}, m = "invokeSuspend", n = {"uri", "imageUploadInfo", "uri", "imageUploadInfo", "url"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
public final class CreationMessageStrategy$handleImageEditWithMask$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AttachmentInfo $attachment;
    final /* synthetic */ CreationSendMessageConfig $config;
    final /* synthetic */ ImageEditDataWithMask $imageEditDataWithMask;
    final /* synthetic */ Message $imageMsg;
    final /* synthetic */ Message $textMsg;
    final /* synthetic */ String $tosKey;
    final /* synthetic */ Deferred<mr9.l> $uploadMaskJob;
    final /* synthetic */ Deferred<mr9.l> $uploadOriginalJob;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CreationMessageStrategy this$0;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class a extends TypeToken<com.larus.bmhome.actionbar.model.r> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class b extends TypeToken<m1> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class c extends TypeToken<com.larus.bmhome.actionbar.model.v> {
        public c() {
        }
    }

    public CreationMessageStrategy$handleImageEditWithMask$2$2$1(Deferred<mr9.l> r1, ImageEditDataWithMask r2, Deferred<mr9.l> r3, CreationSendMessageConfig r4, CreationMessageStrategy r5, AttachmentInfo r6, Message r7, Message r8, String r9, Continuation<? super CreationMessageStrategy$handleImageEditWithMask$2$2$1> r10) {
        this.$uploadOriginalJob = r1;
        this.$imageEditDataWithMask = r2;
        this.$uploadMaskJob = r3;
        this.$config = r4;
        this.this$0 = r5;
        this.$attachment = r6;
        this.$imageMsg = r7;
        this.$textMsg = r8;
        this.$tosKey = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new CreationMessageStrategy$handleImageEditWithMask$2$2$1(this.$uploadOriginalJob, this.$imageEditDataWithMask, this.$uploadMaskJob, this.$config, this.this$0, this.$attachment, this.$imageMsg, this.$textMsg, this.$tosKey, r13);
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
        String r7 = "";
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        String r1 = (String) this.L$2;
        ImageUploadInfo r3 = (ImageUploadInfo) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r72);
        String r10 = r1;
        ImageUploadInfo r12 = r3;
        String r11 = r5;
        Object r6 = r72;
    L69:
        mr9.l r8 = (mr9.l) r6;
        zd9.h r4 = zd9.h.a;
        Map<String, String> r9 = this.$config.getActionBarInstructionMap();
        if (r9 == null) goto L72;
        String r13 = r9.get("action_bar_instruction");
    L73:
        if (r13 != null) goto L75;
    L78:
        boolean r14 = true;
    L80:
        if (r14 == false) goto L304;
    L91:
        Object r15 = null;
    L92:
        com.larus.bmhome.actionbar.model.r r16 = (com.larus.bmhome.actionbar.model.r) r15;
        if (r16 == null) goto L100;
        Integer r17 = r16.a;
        if (r17 == null) goto L100;
        if (r17.intValue() != 28) goto L100;
        boolean r18 = true;
    L101:
        if (r18 == false) goto L190;
        com.larus.bmhome.actionbar.model.y r19 = r16.i;
        if (r19 == null) goto L189;
        ArrayList r20 = r19.a;
        if (r20 == null) goto L189;
        z0 r21 = (z0) CollectionsKt.firstOrNull(r20);
        if (r21 == null) goto L189;
        com.larus.bmhome.actionbar.model.r r22 = r21.q;
        if (r22 == null) goto L116;
        Integer r23 = r22.a;
        if (r23 == null) goto L116;
        if (r23.intValue() != 4) goto L116;
        boolean r24 = true;
    L117:
        if (r24 == false) goto L187;
        com.larus.bmhome.actionbar.model.r r25 = r21.q;
        if (r25 == null) goto L187;
        List r26 = r25.b;
        if (r26 == null) goto L187;
        Iterator r27 = r26.iterator();
    L124:
        if (r27.hasNext() == false) goto L135;
        Object r28 = r27.next();
        Integer r29 = ((com.larus.bmhome.actionbar.model.u) r28).b;
        if (r29 != null) goto L129;
    L131:
        boolean r30 = false;
    L132:
        if (r30 == false) goto L124;
    L136:
        com.larus.bmhome.actionbar.model.u r31 = (com.larus.bmhome.actionbar.model.u) r28;
        if (r31 == null) goto L187;
        zd9.h r32 = zd9.h.a;
        com.larus.bmhome.actionbar.model.r r33 = r21.q;
        if (r33 == null) goto L159;
        List r34 = r33.b;
        if (r34 == null) goto L159;
        Iterator r35 = r34.iterator();
    L144:
        if (r35.hasNext() == false) goto L155;
        Object r36 = r35.next();
        Integer r37 = ((com.larus.bmhome.actionbar.model.u) r36).b;
        if (r37 != null) goto L148;
        Iterator r110 = r35;
    L151:
        boolean r38 = false;
    L152:
        if (r38 == true) goto L156;
        r35 = r110;
    L156:
        com.larus.bmhome.actionbar.model.u r39 = (com.larus.bmhome.actionbar.model.u) r36;
        if (r39 == null) goto L159;
        String r40 = r39.d;
    L160:
        if (r40 != null) goto L162;
    L165:
        boolean r41 = true;
    L166:
        if (r41 == false) goto L302;
        r7 = "";
    L178:
        Object r42 = null;
    L179:
        com.larus.bmhome.actionbar.model.v r43 = (com.larus.bmhome.actionbar.model.v) r42;
        if (r43 == null) goto L185;
        if (r8 == null) goto L183;
        String r210 = r8.a;
    L184:
        r43.c = CollectionsKt.mutableListOf(new MediaAttachment[]{new MediaAttachment(r10, r11, r12, null, null, null, null, null, null, null, r210, null, 3064, null)});
    L186:
        r32.getClass();
        r31.d = zd9.h.c(r43);
        Unit r44 = Unit.INSTANCE;
    L188:
        Unit r45 = Unit.INSTANCE;
    L253:
        if (r16 == null) goto L266;
        CreationSendMessageConfig r46 = this.$config;
        ImageEditDataWithMask r47 = this.$imageEditDataWithMask;
        Map<String, String> r48 = r46.getActionBarInstructionMap();
        if (r48 != null) goto L257;
        r48 = MapsKt.emptyMap();
    L257:
        Map r49 = MapsKt.toMutableMap(r48);
        zd9.h.a.getClass();
        String r50 = zd9.h.c(r16);
        if (r50 != null) goto L260;
        r50 = r7;
    L260:
        r49.put("action_bar_instruction", r50);
        String r51 = zd9.h.c(r47);
        if (r51 != null) goto L263;
        String r52 = r7;
    L264:
        r49.put("image_edit_media_data", r52);
        Unit r53 = Unit.INSTANCE;
        CreationSendMessageConfig r54 = CreationSendMessageConfig.copy$default(r46, null, null, null, null, null, null, null, null, null, r49, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217215, null);
        if (r54 == null) goto L266;
    L267:
        CreationMessageStrategy r55 = this.this$0;
        AttachmentInfo r56 = this.$attachment;
        String r57 = this.$imageMsg.getLocalMessageId();
        String r58 = this.$textMsg.getLocalMessageId();
        int r59 = CreationMessageStrategy.e;
        r55.B(r54, r56, r57, r58);
        ny9.u r60 = this.$config.getHitPointData();
        if (r60 == null) goto L270;
        String r310 = r60.getClickFrom();
    L271:
        ny9.u r61 = this.$config.getHitPointData();
        if (r61 == null) goto L274;
        String r311 = r61.m();
    L275:
        ny9.u r62 = this.$config.getHitPointData();
        if (r62 == null) goto L278;
        String r312 = r62.i();
    L279:
        ny9.u r63 = this.$config.getHitPointData();
        if (r63 == null) goto L282;
        String r64 = r63.getEnterMethod();
    L283:
        String r313 = r64;
        String r65 = this.$config.getBotId();
        if (r65 != null) goto L289;
        ny9.u r66 = this.$config.getHitPointData();
        if (r66 == null) goto L288;
        r65 = r66.getBotId();
        goto L289
    L288:
        String r211 = null;
    L291:
        if (StringsKt.isBlank(this.$tosKey) == false) goto L293;
        String r67 = "0";
    L294:
        String r314 = r67;
        if (StringsKt.isBlank(this.$tosKey) == false) goto L297;
        String r212 = "upload";
    L298:
        IAIChatControlTraceService.Companion r68 = IAIChatControlTraceService.a;
        y3.a(r211, "chat", null, r212, "pic", null, r314, null, null, r310, null, r311, r312, null, null, r313, null, r68.h(r68.gb()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -682076, 65535);
        return Unit.INSTANCE;
    L297:
        r212 = null;
        goto L298
    L293:
        r67 = "1";
    L289:
        r211 = r65;
        goto L291
    L282:
        r64 = this.$config.getEnterMethod();
        goto L283
    L278:
        r312 = null;
        goto L279
    L274:
        r311 = null;
        goto L275
    L270:
        r310 = null;
        goto L271
    L263:
        r52 = r51;
    L266:
        r54 = this.$config;
        goto L267
    L183:
        r210 = null;
        goto L184
    L185:
        r43 = null;
        goto L186
    L302:
        Result.Companion r69 = Result.Companion;     // Catch: Throwable -> L170
        r32.getClass();     // Catch: Throwable -> L170
        r42 = Result.constructor-impl(zd9.h.b.fromJson(r40, new c().getType()));     // Catch: Throwable -> L170
    L172:
        Throwable r70 = Result.exceptionOrNull-impl(r42);
        if (r70 == null) goto L177;
        com.larus.im.internal.delegate.c0 r71 = com.larus.im.internal.delegate.c0.b;
        StringBuilder r73 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r70, "<this>");
        r73.append(ExceptionsKt.stackTraceToString(r70));
        r71.e("GsonHolder", r73.toString());
    L177:
        if (Result.isFailure-impl(r42) == false) goto L179;
    L170:
        th = move-exception;
        Result.Companion r74 = Result.Companion;
        r42 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L172
    L162:
        if (StringsKt.isBlank(r40) == true) goto L165;
        r41 = false;
        goto L166
    L148:
        r110 = r35;
        if (r37.intValue() != 15) goto L151;
        r38 = true;
        goto L152
    L155:
        r36 = null;
    L159:
        r40 = null;
        goto L160
    L129:
        if (r29.intValue() != 15) goto L131;
        r30 = true;
        goto L132
    L135:
        r28 = null;
    L187:
        r7 = "";
    L116:
        r24 = false;
    L189:
        r7 = "";
        goto L253
    L190:
        r7 = "";
        boolean r75 = false;
        if (r16 == null) goto L253;
        List r76 = r16.b;
        if (r76 == null) goto L253;
        Iterator r77 = r76.iterator();
    L196:
        if (r77.hasNext() == false) goto L206;
        Object r78 = r77.next();
        Integer r79 = ((com.larus.bmhome.actionbar.model.u) r78).b;
        if (r79 != null) goto L201;
    L203:
        boolean r80 = false;
    L204:
        if (r80 == false) goto L196;
    L207:
        com.larus.bmhome.actionbar.model.u r81 = (com.larus.bmhome.actionbar.model.u) r78;
        if (r81 == null) goto L253;
        zd9.h r82 = zd9.h.a;
        List r83 = r16.b;
        if (r83 == null) goto L228;
        Iterator r84 = r83.iterator();
    L213:
        if (r84.hasNext() == false) goto L224;
        Object r111 = r84.next();
        Integer r85 = ((com.larus.bmhome.actionbar.model.u) r111).b;
        if (r85 != null) goto L218;
    L220:
        boolean r86 = false;
    L221:
        if (r86 == false) goto L213;
    L225:
        com.larus.bmhome.actionbar.model.u r87 = (com.larus.bmhome.actionbar.model.u) r111;
        if (r87 == null) goto L228;
        String r88 = r87.d;
    L229:
        if (r88 != null) goto L231;
    L232:
        r75 = true;
    L233:
        if (r75 == false) goto L300;
    L244:
        Object r89 = null;
    L245:
        m1 r90 = (m1) r89;
        if (r90 == null) goto L251;
        if (r8 == null) goto L249;
        String r213 = r8.a;
    L250:
        r90.d = new MediaAttachment(r10, r11, r12, null, null, null, null, null, null, null, r213, null, 3064, null);
    L252:
        r82.getClass();
        r81.d = zd9.h.c(r90);
        Unit r91 = Unit.INSTANCE;
        goto L253
    L249:
        r213 = null;
        goto L250
    L251:
        r90 = null;
        goto L252
    L300:
        Result.Companion r92 = Result.Companion;     // Catch: Throwable -> L237
        r82.getClass();     // Catch: Throwable -> L237
        r89 = Result.constructor-impl(zd9.h.b.fromJson(r88, new b().getType()));     // Catch: Throwable -> L237
    L239:
        Throwable r93 = Result.exceptionOrNull-impl(r89);
        if (r93 == null) goto L243;
        com.larus.im.internal.delegate.c0 r94 = com.larus.im.internal.delegate.c0.b;
        StringBuilder r95 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r93, "<this>");
        r95.append(ExceptionsKt.stackTraceToString(r93));
        r94.e("GsonHolder", r95.toString());
    L243:
        if (Result.isFailure-impl(r89) == false) goto L245;
    L237:
        th = move-exception;
        Result.Companion r96 = Result.Companion;
        r89 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L239
    L231:
        if (StringsKt.isBlank(r88) == false) goto L233;
    L218:
        if (r85.intValue() != 14) goto L220;
        r86 = true;
        goto L221
    L224:
        r111 = null;
    L228:
        r88 = null;
        goto L229
    L201:
        if (r79.intValue() != 14) goto L203;
        r80 = true;
        goto L204
    L206:
        r78 = null;
    L100:
        r18 = false;
        goto L101
    L304:
        Result.Companion r97 = Result.Companion;     // Catch: Throwable -> L84
        r4.getClass();     // Catch: Throwable -> L84
        r15 = Result.constructor-impl(zd9.h.b.fromJson(r13, new a().getType()));     // Catch: Throwable -> L84
    L86:
        Throwable r98 = Result.exceptionOrNull-impl(r15);
        if (r98 == null) goto L90;
        com.larus.im.internal.delegate.c0 r99 = com.larus.im.internal.delegate.c0.b;
        StringBuilder r100 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r98, "<this>");
        r100.append(ExceptionsKt.stackTraceToString(r98));
        r99.e("GsonHolder", r100.toString());
    L90:
        if (Result.isFailure-impl(r15) == false) goto L92;
    L84:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L86
    L75:
        if (StringsKt.isBlank(r13) == true) goto L78;
        r14 = false;
        goto L80
    L72:
        r13 = null;
        goto L73
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ImageUploadInfo r102 = (ImageUploadInfo) this.L$1;
        String r103 = (String) this.L$0;
        ResultKt.throwOnFailure(r72);
        String r104 = r103;
        Object r105 = r72;
    L52:
        if ((r105 instanceof com.larus.network.http.y) == false) goto L54;
        com.larus.network.http.y r106 = (com.larus.network.http.y) r105;
    L55:
        if (r106 == null) goto L63;
        FileUrlRespData r107 = (FileUrlRespData) ((com.larus.network.http.a) r106).b;
        if (r107 == null) goto L63;
        List r108 = r107.getFileUrlList();
        if (r108 == null) goto L63;
        FileUrlData r109 = (FileUrlData) CollectionsKt.firstOrNull(r108);
        if (r109 == null) goto L63;
        String r112 = r109.getMainUrl();
    L65:
        Deferred<mr9.l> r113 = this.$uploadMaskJob;
        this.L$0 = r104;
        this.L$1 = r102;
        this.L$2 = r112;
        this.label = 3;
        r6 = r113.await(this);
        if (r6 != r0) goto L68;
        return r0;
    L68:
        r12 = r102;
        r10 = r112;
        r11 = r104;
    L63:
        r112 = null;
        goto L65
    L54:
        r106 = null;
        goto L55
    L11:
        ResultKt.throwOnFailure(r72);
        Object r114 = r72;
    L17:
        mr9.l r115 = (mr9.l) r114;
    L19:
        r104 = this.$imageEditDataWithMask.getOriImgUri();
        if (r104 != null) goto L26;
        if (r115 == null) goto L23;
        r104 = r115.a;
    L24:
        if (r104 != null) goto L26;
        r104 = "";
        goto L26
    L23:
        r104 = null;
    L26:
        ImageUploadInfo r116 = this.$imageEditDataWithMask.getImageUploadInfo();
        if (r116 == null) goto L29;
    L40:
        r102 = r116;
        String r117 = this.$imageEditDataWithMask.getOriImgUrl();
        if (r117 != null) goto L43;
    L46:
        boolean r118 = true;
    L47:
        if (r118 == false) goto L64;
        List r119 = CollectionsKt.listOf(r104);
        UploadDataType r120 = UploadDataType.IMAGE;
        this.L$0 = r104;
        this.L$1 = r102;
        this.label = 2;
        r105 = com.larus.uaigc.api.o.b(r119, r120, this);
        if (r105 != r0) goto L52;
        return r0;
    L64:
        r112 = this.$imageEditDataWithMask.getOriImgUrl();
        goto L65
    L43:
        if (StringsKt.isBlank(r117) == true) goto L46;
        r118 = false;
        goto L47
    L29:
        if (r115 == null) goto L33;
        mr9.d r121 = r115.d;
        if (r121 == null) goto L33;
        Long r122 = Boxing.boxLong(r121.b);
    L34:
        if (r115 == null) goto L38;
        mr9.d r123 = r115.d;
        if (r123 == null) goto L38;
        Long r124 = Boxing.boxLong(r123.a);
    L39:
        r116 = new ImageUploadInfo(r122, r124);
    L38:
        r124 = null;
    L33:
        r122 = null;
        goto L34
    L12:
        ResultKt.throwOnFailure(r72);
        Deferred<mr9.l> r125 = this.$uploadOriginalJob;
        if (r125 == null) goto L18;
        this.label = 1;
        r114 = r125.await(this);
        if (r114 != r0) goto L17;
        return r0;
    L18:
        r115 = null;
        goto L19
    }
}
