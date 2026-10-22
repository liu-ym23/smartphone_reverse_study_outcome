package com.larus.uaigc.createpage.component.input;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.uaigc.createpage.processor.CreatePageSendMessageProcessor;
import com.larus.uaigc.createpage.utils.CreationMediaAttachmentExtUpdater;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.input.CreationInputComponent$onSend$1", f = "CreationInputComponent.kt", i = {0}, l = {1218, 1324, 1330, 1366, 1371}, m = "invokeSuspend", n = {"isImagePreprocessed"}, s = {"L$0"})
public final class CreationInputComponent$onSend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ICoreInputAbility.OnSendParams $onSendParams;
    Object L$0;
    int label;
    final /* synthetic */ CreationInputComponent this$0;

    public CreationInputComponent$onSend$1(CreationInputComponent r1, ICoreInputAbility.OnSendParams r2, Continuation<? super CreationInputComponent$onSend$1> r3) {
        this.this$0 = r1;
        this.$onSendParams = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationInputComponent$onSend$1(this.this$0, this.$onSendParams, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r54) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L14;
        if (r0 == 2) goto L9;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L12;
        if (r0 == 5) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r54);
    L388:
        String r1 = null;
    L392:
        ny9.s r2 = this.this$0.C3();
        if (r2 == null) goto L402;
        com.larus.bmhome.actionbar.model.r r3 = r2.k();
        if (r3 == null) goto L402;
        Integer r4 = r3.a;
        if (r4 == null) goto L402;
        if (r4.intValue() != 4) goto L402;
        boolean r5 = true;
    L403:
        if (r5 == true) goto L416;
        ny9.s r6 = this.this$0.C3();
        if (r6 == null) goto L414;
        com.larus.bmhome.actionbar.model.r r7 = r6.k();
        if (r7 == null) goto L414;
        Integer r8 = r7.a;
        if (r8 == null) goto L414;
        if (r8.intValue() != 16) goto L414;
        boolean r12 = true;
    L415:
        if (r12 == true) goto L416;
    L450:
        return Unit.INSTANCE;
    L414:
        r12 = false;
    L416:
        ny9.u r9 = this.this$0.H3();
        if (r9 == null) goto L419;
        String r13 = r9.m();
    L420:
        ny9.u r11 = this.this$0.H3();
        if (r11 == null) goto L423;
        String r14 = r11.i();
    L424:
        ny9.u r15 = this.this$0.H3();
        if (r15 == null) goto L427;
        String r16 = r15.getEnterMethod();
    L428:
        ny9.u r17 = this.this$0.H3();
        if (r17 == null) goto L431;
        Integer r18 = Boxing.boxInt((int) (System.currentTimeMillis() - r17.b));
    L432:
        ny9.u r19 = this.this$0.H3();
        if (r19 == null) goto L435;
        String r110 = r19.f();
    L436:
        ny9.u r20 = this.this$0.H3();
        if (r20 == null) goto L439;
        String r111 = r20.p();
    L440:
        ny9.u r21 = this.this$0.H3();
        if (r21 == null) goto L443;
        String r112 = r21.j();
    L444:
        ny9.u r22 = this.this$0.H3();
        if (r22 == null) goto L447;
        String r113 = r22.getBotId();
    L448:
        nz9.c.c("complete", r18, r16, r13, r14, r110, r112, r111, r113);
        goto L450
    L447:
        r113 = r1;
        goto L448
    L443:
        r112 = r1;
        goto L444
    L439:
        r111 = r1;
        goto L440
    L435:
        r110 = r1;
        goto L436
    L431:
        r18 = r1;
        goto L432
    L427:
        r16 = r1;
        goto L428
    L423:
        r14 = r1;
        goto L424
    L419:
        r13 = r1;
    L402:
        r5 = false;
        goto L403
    L13:
        ResultKt.throwOnFailure(r54);
    L342:
        r1 = null;
    L9:
        ResultKt.throwOnFailure(r54);
    L314:
        r1 = null;
        goto L392
    L14:
        Ref.BooleanRef r23 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r54);
        Object r24 = r54;
    L20:
        AttachmentInfo r25 = (AttachmentInfo) r24;
        if (r25 != null) goto L33;
    L22:
        ys8.a r26 = this.this$0.Q3();
        if (r26 == null) goto L25;
        r25 = r26.n4();
    L26:
        if (r25 != null) goto L33;
        sy9.a r27 = (sy9.a) this.this$0.x.getValue();
        if (r27 == null) goto L32;
        r25 = r27.t20();
        if (r25 == null) goto L32;
        r23.element = false;
    L32:
        AttachmentInfo r114 = null;
    L34:
        CreationInputComponent r28 = this.this$0;
        long[] r29 = CreationInputComponent.F;
        if (r114 == null) goto L47;
        ny9.s r30 = r28.C3();
        if (r30 != null) goto L39;
    L41:
        boolean r31 = false;
    L42:
        if (r31 == false) goto L48;
        Boolean r32 = r114.getAiCreationImage();
        Boolean r33 = Boolean.TRUE;
        if (Intrinsics.areEqual(r32, r33) == true) goto L48;
        r114 = AttachmentInfo.copy$default(r114, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r33, 65535, null);
    L48:
        ys8.a r34 = this.this$0.Q3();
        if (r34 == null) goto L51;
        boolean r210 = r34.x(this.$onSendParams.getContent());
    L52:
        if (r210 == false) goto L56;
        return Unit.INSTANCE;
    L56:
        if (this.this$0.d4() == true) goto L58;
        this.this$0.p3();
        ny9.u r35 = this.this$0.H3();
        if (r35 == null) goto L62;
        String r36 = r35.getEnterMethod();
    L63:
        String r37 = "";
        if (r36 != null) goto L66;
        r36 = "";
    L66:
        com.larus.uaigc.helper.f.a.getClass();
        boolean r38 = com.larus.uaigc.helper.f.a();
        Ref.ObjectRef r39 = new Ref.ObjectRef();
        ny9.s r40 = this.this$0.C3();
        if (r40 == null) goto L69;
        com.larus.bmhome.actionbar.model.r r41 = r40.k();
    L70:
        if (r41 == null) goto L77;
        Integer r42 = r41.a;
        if (r42 == null) goto L77;
        if (r42.intValue() != 28) goto L77;
        boolean r43 = true;
    L78:
        String r44 = "new_topic";
        if (r43 == false) goto L109;
        if (r38 == false) goto L88;
        ys8.a r45 = this.this$0.Q3();
        if (r45 == null) goto L85;
        NestedFileContent r46 = r45.Wd();
        if (r46 == null) goto L85;
    L91:
        NestedFileContent r310 = r46;
    L93:
        if (r310 == null) goto L109;
        if (o0.d(r36) == false) goto L97;
        String r47 = r36;
    L98:
        if (r47 != null) goto L100;
        r47 = "creation";
    L100:
        String r211 = r47;
        if (Intrinsics.areEqual(r36, "new_topic") == false) goto L103;
        String r212 = "new_topic";
    L104:
        ys8.a r48 = this.this$0.Q3();
        if (r48 == null) goto L107;
        String r311 = r48.J6();
    L108:
        r39.element = new CustomMultiAttachmentInfo(r212, r211, r310, false, false, false, false, r311, 120, null);
        goto L109
    L107:
        r311 = null;
        goto L108
    L103:
        r212 = "album";
        goto L104
    L97:
        r47 = null;
    L85:
        ys8.a r49 = this.this$0.Q3();
        if (r49 == null) goto L92;
        r46 = r49.T();
    L92:
        r310 = null;
        goto L93
    L88:
        ys8.a r50 = this.this$0.Q3();
        if (r50 == null) goto L92;
        r46 = r50.T();
    L109:
        CustomMultiAttachmentInfo r51 = (CustomMultiAttachmentInfo) r39.element;
        if (r51 == null) goto L118;
        if (r38 == true) goto L114;
        r51 = null;
    L114:
        if (r51 == null) goto L118;
        Map<String, String> r52 = this.this$0.m3(this.$onSendParams.getContent(), true);
        if (r52 == null) goto L118;
        Map<String, String> r53 = MapsKt.toMutableMap(r52);
    L119:
        CustomMultiAttachmentInfo r115 = (CustomMultiAttachmentInfo) r39.element;
        if (r115 == null) goto L124;
        NestedFileContent r116 = r115.getNestedFileContent();
        if (r116 == null) goto L124;
        List r117 = r116.getEntities();
    L125:
        if (r117 != null) goto L127;
        r117 = CollectionsKt.emptyList();
    L127:
        if (r38 == true) goto L129;
    L161:
        boolean r55 = this.this$0.p4();
        ConcurrentHashMap r56 = ko8.b.a;
        String r118 = UUID.randomUUID().toString();
        CreationInputComponent r57 = this.this$0;
        CustomMultiAttachmentInfo r119 = (CustomMultiAttachmentInfo) r39.element;
        r57.getClass();
        if (r119 == null) goto L164;
        String r58 = "multi_attachment";
    L167:
        ko8.b.d(r118, r58);
        nz9.b.f("-1", CollectionsKt.listOf(new String[]{"creation_page", "creation_page/album_upload", "creation_page/album_upload/video", "creation_page/re_upload"}), null);
        ys8.a r59 = this.this$0.Q3();
        if (r59 == null) goto L176;
        View r60 = this.this$0.C;
        if (r60 == null) goto L174;
        TextView r61 = (TextView) r60.findViewById(2131375415);
        if (r61 == null) goto L174;
        CharSequence r62 = r61.getText();
    L175:
        r59.A8(String.valueOf(r62));
        Unit r63 = Unit.INSTANCE;
    L174:
        r62 = null;
    L176:
        ys8.a r64 = this.this$0.Q3();
        if (r64 == null) goto L180;
        String r65 = r64.y6(this.$onSendParams.getContent());
        if (r65 == null) goto L180;
    L181:
        String r66 = r65;
        Map<String, String> r312 = this.this$0.Jw(this.$onSendParams.getContent());
        CreationInputComponent r67 = this.this$0;
        if (r114 == null) goto L184;
        String r120 = r114.getFileIdentifier();
    L185:
        r67.getClass();
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L204;
        if (r120 == null) goto L204;
        if (r120.length() <= 0) goto L192;
        boolean r121 = true;
    L193:
        if (r121 == true) goto L196;
        r120 = null;
    L196:
        if (r120 == null) goto L204;
        CreationResourceAccessUploader r122 = CreationResourceAccessUploader.a;
        CreationResourceAccessUploader.h(r120);
        ry9.g r123 = (ry9.g) r67.r.getValue();
        if (r123 == null) goto L201;
        r123.C2(r120);
        goto L204
    L201:
        sy9.a r68 = (sy9.a) r67.x.getValue();
        if (r68 == null) goto L204;
        r68.C2(r120);
        goto L204
    L192:
        r121 = false;
    L204:
        CreationInputComponent r69 = this.this$0;
        CustomMultiAttachmentInfo r124 = (CustomMultiAttachmentInfo) r39.element;
        r69.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L246;
        if (r124 == null) goto L246;
        NestedFileContent r125 = r124.getNestedFileContent();
        if (r125 == null) goto L246;
        List r126 = r125.getEntities();
        if (r126 == null) goto L246;
        ArrayList r127 = new ArrayList();
        Iterator r128 = r126.iterator();
    L214:
        if (r128.hasNext() == false) goto L237;
        UplinkFileEntity r129 = (UplinkFileEntity) r128.next();
        String r130 = r129.getFileIdentifier();
        if (r130 != null) goto L218;
        String r510 = r37;
    L233:
        String r70 = null;
    L234:
        if (r70 == null) goto L236;
        r127.add(r70);
    L236:
        r37 = r510;
        goto L214
    L218:
        if (r130.length() <= 0) goto L220;
        boolean r131 = true;
    L221:
        if (r131 == false) goto L228;
        Integer r132 = r129.getUpLinkStatus();
        int r133 = UpLinkState.PROCESSING.getValue();
        if (r132 == null) goto L228;
        r510 = r37;
        if (r132.intValue() != r133) goto L229;
        boolean r71 = true;
    L230:
        if (r71 == false) goto L233;
        r70 = r130;
    L229:
        r71 = false;
    L228:
        r510 = r37;
        goto L229
    L220:
        r131 = false;
        goto L221
    L237:
        String r511 = r37;
        List r72 = CollectionsKt.distinct(r127);
        if (r72 == null) goto L247;
        Iterator r73 = r72.iterator();
    L241:
        if (r73.hasNext() == false) goto L247;
        String r134 = (String) r73.next();
        CreationResourceAccessUploader r135 = CreationResourceAccessUploader.a;
        CreationResourceAccessUploader.h(r134);
        ry9.h r136 = (ry9.h) r69.o.getValue();
        if (r136 == null) goto L245;
        r136.C2(r134);
    L245:
        FLogger.a.i("CreationInputComponent", "mark multi attachment upload handoff to send, identifier=" + r134);
        r69 = r69;
    L247:
        if (r114 == null) goto L249;
        String r74 = r114.getFilePath();
    L251:
        if (o0.d(r74) == false) goto L344;
        if (r114 == null) goto L254;
        String r75 = r114.getTosKey();
    L255:
        if (r75 != null) goto L257;
    L260:
        boolean r76 = true;
    L261:
        if (r76 == false) goto L344;
        ys8.a r77 = this.this$0.Q3();
        if (r77 == null) goto L265;
        String r78 = r77.y60(this.$onSendParams.getContent(), true);
    L267:
        if (Intrinsics.areEqual(r36, "new_topic") == true) goto L270;
        r44 = this.$onSendParams.getScene();
    L270:
        String r313 = r44;
        Map<String, String> r79 = this.this$0.Jw(this.$onSendParams.getContent());
        if (r114 == null) goto L273;
        String r137 = r114.getFilePath();
    L274:
        if (r137 != null) goto L276;
        r137 = r511;
    L276:
        String r138 = y0.k(Uri.fromFile(new PolarisFileWrapper(r137)));
        CustomMultiAttachmentInfo r410 = (CustomMultiAttachmentInfo) r39.element;
        ny9.s r80 = this.this$0.C3();
        if (r80 == null) goto L283;
        com.larus.bmhome.actionbar.model.r r81 = r80.k();
        if (r81 == null) goto L283;
        Integer r82 = r81.a;
        if (r82 == null) goto L283;
        int r213 = r82.intValue();
    L284:
        if (r53 != null) goto L286;
        r53 = this.this$0.m3(this.$onSendParams.getContent(), true);
    L286:
        Map<String, String> r214 = r53;
        if (r210 == false) goto L289;
        String r215 = "client_language_interception";
    L290:
        ny9.s r83 = this.this$0.C3();
        if (r83 == null) goto L293;
        boolean r216 = r83.D();
    L294:
        ny9.s r84 = this.this$0.C3();
        if (r84 == null) goto L297;
        boolean r314 = r84.y();
    L298:
        ys8.a r85 = this.this$0.Q3();
        if (r85 == null) goto L304;
        String r86 = r85.c0();
        if (r86 == null) goto L304;
        String r315 = r86;
    L305:
        ny9.u r87 = this.this$0.H3();
        if (r87 == null) goto L308;
        String r411 = r87.b();
    L309:
        ICoreInputAbility.OnSendParams r88 = ICoreInputAbility.OnSendParams.copy$default(this.$onSendParams, r66, null, r114, null, null, r214, null, null, r213, r210, r215, false, r216, false, null, r315, null, null, r314, r36, r79, null, r313, null, r411, null, r410, null, null, null, null, null, null, -89954086, 1, null);
        if (r55 == false) goto L315;
        CreatePageSendMessageProcessor r89 = this.this$0.V3();
        boolean r90 = r23.element;
        this.L$0 = null;
        this.label = 2;
        if (ny9.d.a.a(r89, null, r88, r90, r118, this, 1) != r10) goto L314;
        return r10;
    L315:
        CreatePageSendMessageProcessor r91 = this.this$0.V3();
        this.this$0.getClass();
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L333;
        if (r114 == null) goto L319;
        String r92 = r114.getTosKey();
    L320:
        if (r92 != null) goto L322;
    L325:
        boolean r93 = true;
    L326:
        if (r93 == false) goto L333;
        if (r114 == null) goto L329;
        String r94 = r114.getFileIdentifier();
    L331:
        if (o0.d(r94) == false) goto L333;
        boolean r95 = true;
    L334:
        if (r95 == false) goto L336;
        Bundle r96 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("actionbar_remote_image", r114)});
    L337:
        if (r78 != null) goto L339;
        r78 = r511;
    L339:
        boolean r97 = r23.element;
        this.L$0 = null;
        this.label = 3;
        if (r91.b(r96, r78, r138, r97, r66, r79, r118, this) != r10) goto L342;
        return r10;
    L336:
        r96 = com.larus.utils.f.c(new Pair[0]);
        goto L337
    L329:
        r94 = null;
        goto L331
    L322:
        if (r92.length() == 0) goto L325;
        r93 = false;
        goto L326
    L319:
        r92 = null;
    L333:
        r95 = false;
        goto L334
    L308:
        r411 = null;
    L304:
        r315 = r511;
        goto L305
    L297:
        r314 = false;
        goto L298
    L293:
        r216 = false;
        goto L294
    L289:
        r215 = r511;
    L283:
        r213 = 0;
        goto L284
    L273:
        r137 = null;
        goto L274
    L265:
        r78 = null;
        goto L267
    L257:
        if (r75.length() == 0) goto L260;
        r76 = false;
        goto L261
    L254:
        r75 = null;
    L344:
        if (Intrinsics.areEqual(r36, "new_topic") == false) goto L346;
        String r316 = "new_topic";
    L347:
        CustomMultiAttachmentInfo r412 = (CustomMultiAttachmentInfo) r39.element;
        ny9.s r98 = this.this$0.C3();
        if (r98 == null) goto L354;
        com.larus.bmhome.actionbar.model.r r99 = r98.k();
        if (r99 == null) goto L354;
        Integer r100 = r99.a;
        if (r100 == null) goto L354;
        int r217 = r100.intValue();
    L355:
        if (r53 != null) goto L357;
        Map<String, String> r218 = this.this$0.m3(this.$onSendParams.getContent(), false);
    L358:
        if (r210 == false) goto L360;
        String r219 = "client_language_interception";
    L361:
        ny9.s r101 = this.this$0.C3();
        if (r101 == null) goto L364;
        boolean r220 = r101.D();
    L365:
        ny9.s r102 = this.this$0.C3();
        if (r102 == null) goto L368;
        boolean r317 = r102.y();
    L369:
        ys8.a r103 = this.this$0.Q3();
        if (r103 == null) goto L375;
        String r104 = r103.c0();
        if (r104 == null) goto L375;
        String r318 = r104;
    L376:
        ny9.u r105 = this.this$0.H3();
        if (r105 == null) goto L379;
        String r413 = r105.b();
    L380:
        ChatPageContext r106 = this.$onSendParams.chatPageContext;
        if (r106 != null) goto L383;
        r106 = this.this$0.B3();
    L383:
        ICoreInputAbility.OnSendParams r107 = ICoreInputAbility.OnSendParams.copy$default(this.$onSendParams, r66, null, r114, null, null, r218, null, null, r217, r210, r219, false, r220, false, null, r318, null, null, r317, r36, r312, null, r316, null, r413, null, r412, null, null, r106, null, null, null, -626824998, 1, null);
        if (r55 == false) goto L389;
        CreatePageSendMessageProcessor r108 = this.this$0.V3();
        this.L$0 = null;
        this.label = 4;
        if (ny9.d.a.a(r108, null, r107, false, r118, this, 5) != r10) goto L388;
        return r10;
    L389:
        CreatePageSendMessageProcessor r109 = this.this$0.V3();
        r1 = null;
        this.L$0 = null;
        this.label = 5;
        if (r109.x(r107, r118, this) != r10) goto L392;
        return r10;
    L379:
        r413 = null;
    L375:
        r318 = r511;
        goto L376
    L368:
        r317 = false;
        goto L369
    L364:
        r220 = false;
        goto L365
    L360:
        r219 = r511;
        goto L361
    L357:
        r218 = r53;
    L354:
        r217 = 0;
        goto L355
    L346:
        r316 = this.$onSendParams.getScene();
        goto L347
    L249:
        r74 = null;
    L246:
        r511 = "";
        goto L247
    L184:
        r120 = null;
    L180:
        r65 = this.$onSendParams.getContent();
        goto L181
    L164:
        if (r114 == null) goto L166;
        r58 = "single_attachment";
        goto L167
    L166:
        r58 = "text";
        goto L167
    L129:
        if ((!r117.isEmpty()) == false) goto L161;
        List r139 = r117;
        if ((r139 instanceof Collection) == true) goto L133;
    L135:
        Iterator r140 = r139.iterator();
    L137:
        if (r140.hasNext() == false) goto L153;
        UplinkFileEntity r141 = (UplinkFileEntity) r140.next();
        Integer r142 = r141.getUpLinkStatus();
        int r143 = UpLinkState.SUCCESS.getValue();
        if (r142 != null) goto L142;
    L149:
        boolean r144 = false;
    L150:
        if (r144 == true) goto L137;
        boolean r145 = false;
    L154:
        if (r145 == false) goto L161;
        if (r53 == null) goto L161;
        CreationMediaAttachmentExtUpdater r146 = CreationMediaAttachmentExtUpdater.a;
        CustomMultiAttachmentInfo r147 = (CustomMultiAttachmentInfo) r39.element;
        if (r147 == null) goto L159;
        NestedFileContent r148 = r147.getNestedFileContent();
    L160:
        r146.getClass();
        CreationMediaAttachmentExtUpdater.c(r53, r148);
        Unit r149 = Unit.INSTANCE;
        goto L161
    L159:
        r148 = null;
        goto L160
    L142:
        if (r142.intValue() != r143) goto L149;
        Integer r150 = r141.getFileReviewStatus();
        int r151 = FileReviewState.ACCESS.getValue();
        if (r150 == null) goto L149;
        if (r150.intValue() != r151) goto L149;
        r144 = true;
    L153:
        r145 = true;
        goto L154
    L133:
        if (r139.isEmpty() == false) goto L135;
    L124:
        r117 = null;
    L118:
        r53 = null;
    L77:
        r43 = false;
        goto L78
    L69:
        r41 = null;
        goto L70
    L62:
        r36 = null;
        goto L63
    L58:
        return Unit.INSTANCE;
    L51:
        r210 = false;
        goto L52
    L39:
        if (r30.x() != true) goto L41;
        r31 = true;
        goto L42
    L47:
        r28.getClass();
        goto L48
    L25:
        r25 = null;
    L33:
        r114 = r25;
        goto L34
    L15:
        ResultKt.throwOnFailure(r54);
        r23 = new Ref.BooleanRef();
        r23.element = true;
        CreationInputComponent r152 = this.this$0;
        long[] r153 = CreationInputComponent.F;
        ry9.g r154 = (ry9.g) r152.r.getValue();
        if (r154 == null) goto L22;
        this.L$0 = r23;
        this.label = 1;
        r24 = r154.Zt(this);
        if (r24 != r10) goto L20;
        return r10;
    }
}
