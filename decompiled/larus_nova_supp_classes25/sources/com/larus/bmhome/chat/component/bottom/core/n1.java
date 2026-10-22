package com.larus.bmhome.chat.component.bottom.core;

import android.net.Uri;
import bc8.a;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.MultiAttachmentInfo;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n1 implements Function0 {
    public final /* synthetic */ CoreInputAbility a;
    public final /* synthetic */ ICoreInputAbility.OnSendParams b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Ref.BooleanRef d;
    public final /* synthetic */ Ref.ObjectRef e;
    public final /* synthetic */ Map f;

    public /* synthetic */ n1(CoreInputAbility r1, ICoreInputAbility.OnSendParams r2, String r3, Ref.BooleanRef r4, Ref.ObjectRef r5, Map r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object invoke() {
        CoreInputAbility r2 = this.a;
        ICoreInputAbility.OnSendParams r3 = this.b;
        String r0 = this.c;
        Ref.BooleanRef r4 = this.d;
        Ref.ObjectRef r5 = this.e;
        Map r6 = this.f;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r7 = r2.A().f70();
        String r9 = "";
        if (r7 == null) goto L13;
        MultiAttachmentInfo r10 = r3.getMultiAttachment();
        if (r10 == null) goto L7;
        String r11 = r10.getLocalMsgId();
    L8:
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        NestedFileContent r8 = r7.b6(r11);
        if (r8 == null) goto L13;
        List r12 = r8.getEntities();
    L14:
        if (r12 != null) goto L16;
        r12 = CollectionsKt.emptyList();
    L16:
        String r13 = com.larus.bmhome.chat.component.bottom.core.inputtext.f0.c(r0, r12);
        boolean r1 = com.larus.bmhome.chat.component.bottom.core.inputtext.f0.d(r13, r12);
        boolean r14 = true;
        if (r1 == false) goto L19;
        FLogger.a.e("CoreInputAbility", "[onSend] unresolved attachment reference, skip send");
        r4.element = true;
    L150:
        return Unit.INSTANCE;
    L19:
        String r15 = (String) r5.element;
        ArrayList r16 = new ArrayList();
        Map r17 = com.larus.utils.h.c(r6, new Pair[0]);
        SuggestedAction r18 = r3.getSuggestedAction();
        if (r18 == null) goto L24;
        Map r19 = r18.getMsgExt();
        if (r19 == null) goto L24;
        r17.putAll(r19);
    L24:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r20 = r2.A().f70();
        if (r20 == null) goto L104;
        MultiAttachmentInfo r110 = r3.getMultiAttachment();
        if (r110 == null) goto L29;
        String r111 = r110.getLocalMsgId();
    L30:
        Intrinsics.checkNotNull(r111);
        NestedFileContent r112 = r20.b6(r111);
        if (r112 == null) goto L104;
        yc9.v0.g(r112);
        boolean r113 = Intrinsics.areEqual(r6.get("chat_raf_option"), "1");
        List r21 = r112.getEntities();
        String r114 = "shoot";
        if (r21 == null) goto L82;
        Iterator r115 = r21.iterator();
        Boolean r22 = null;
        Boolean r116 = null;
    L36:
        if (r115.hasNext() == false) goto L81;
        UplinkFileEntity r23 = (UplinkFileEntity) r115.next();
        if (yc9.n1.d(r23) == false) goto L41;
        if (r113 == false) goto L41;
        r23.setFileReviewStatus(Integer.valueOf(FileReviewState.PROCESSING.getValue()));
    L41:
        Uri r24 = r23.getUri();
        if (r24 == null) goto L46;
        String r25 = r24.toString();
        if (r25 == null) goto L46;
        String r26 = (String) com.larus.utils.l.b(r25, "image_from_scene");
    L48:
        if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"shoot", "shoot_ocr"}), r26) == false) goto L51;
        r22 = Boolean.TRUE;
    L51:
        if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"album", "album_ocr"}), r26) == false) goto L54;
        r116 = Boolean.TRUE;
    L54:
        if (IBachDetectCenterAbility.a.b() == false) goto L79;
        Integer r27 = r23.getEntityType();
        int r28 = UplinkEntityType.EntityTypeImage.getValue();
        if (r27 == null) goto L79;
        if (r27.intValue() != r28) goto L79;
        UplinkEntityContent r29 = r23.getUplinkEntityContent();
        if (r29 == null) goto L79;
        Image r30 = r29.getUplinkImageInfo();
        if (r30 == null) goto L79;
        String r31 = r30.localResPath;
        if (r31 == null) goto L79;
        PolarisFileWrapper r32 = new PolarisFileWrapper(r31);
        if (r32.exists() == false) goto L79;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L70
        Object r34 = Result.constructor-impl(Uri.fromFile(r32));     // Catch: Throwable -> L70
    L73:
        if (Result.isSuccess-impl(r34) == false) goto L79;
        Uri r35 = (Uri) r34;
        IBachDetectCenterAbility.Companion r36 = IBachDetectCenterAbility.a;
        Intrinsics.checkNotNull(r35);
        r14 = true;
        Boolean r37 = r36.c(r35, true);
        if (r37 == null) goto L80;
        if (r37.booleanValue() == false) goto L80;
        r17.put(IAIChatUgcAIGCService.a.F0(), "1");
    L80:
        r22 = r22;
    L70:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
    L79:
        r14 = true;
    L46:
        r26 = null;
        goto L48
    L81:
        Boolean r39 = r116;
    L83:
        Boolean r40 = Boolean.TRUE;
        if (Intrinsics.areEqual(r22, r40) == false) goto L89;
        if (Intrinsics.areEqual(r39, r40) == false) goto L89;
        r114 = "upload_and_shoot";
    L95:
        if (r114 == null) goto L98;
        String r41 = (String) r17.put("content_source", r114);
    L98:
        if (yc9.v0.h(r112) <= 0) goto L104;
        MultiAttachmentInfo r42 = r3.getMultiAttachment();
        if (r42 == null) goto L102;
        String r117 = r42.getLocalMsgId();
    L103:
        Map r43 = r17;
        r16.add(new ai8.f(r112, r117, null, r3.getReferenceInfo(), r43, null, false, null, r2.r(r3), null, 740));
    L106:
        if (r13.length() > 0) goto L109;
        r14 = false;
    L109:
        if (r14 == false) goto L115;
        int r44 = wf9.b.a;
        String r45 = com.flow.kmp.common.util.i.a();
        Map r118 = r43;
        r16.add(new ai8.h(r13, r45, null, r3.getReferenceInfo(), r118, null, false, false, r2.r(r3), null, 740));
        SuggestedAction r46 = r3.getSuggestedAction();
        MultiAttachmentInfo r47 = r3.getMultiAttachment();
        if (r47 == null) goto L113;
        String r48 = r47.getLocalMsgId();
    L114:
        Pair r49 = CoreInputAbility.H(r46, r48, r45);
        Object r50 = r49.getFirst();
        Object r51 = r49.getSecond();
    L116:
        ConcurrentHashMap r52 = ko8.b.a;
        String r53 = r3.getCreationSendTraceId();
        ArrayList r54 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r119 = r16.iterator();
    L118:
        if (r119.hasNext() == false) goto L120;
        r54.add(((ic8.w) r119.next()).b());
        goto L118
    L120:
        ko8.b.b(r53, r54);
        com.larus.bmhome.chat.component.bottom.attachment.g1 r55 = r2.A().f70();
        if (r55 == null) goto L129;
        MultiAttachmentInfo r56 = r3.getMultiAttachment();
        if (r56 == null) goto L128;
        String r57 = r56.getLocalMsgId();
        if (r57 == null) goto L128;
        r9 = r57;
    L128:
        r55.b2(r9);
    L129:
        Boolean r120 = ObricActionBarSendServiceDelegate.b.g(r6);
        gd8.g r121 = r2.A().h2();
        if (r121 == null) goto L143;
        wc9.e r122 = r2.h();
        String r58 = (String) r50;
        if (r58 != null) goto L134;
        String r123 = r15;
    L135:
        String r59 = (String) r51;
        if (r59 != null) goto L141;
        MultiAttachmentInfo r60 = r3.getMultiAttachment();
        if (r60 == null) goto L140;
        r59 = r60.getFromScene();
        goto L141
    L140:
        String r124 = null;
    L142:
        r121.sW(r122, r123, r16, r124, r120, r3.getSendClickTimestamp());
    L141:
        r124 = r59;
        goto L142
    L134:
        r123 = r58;
    L143:
        a r61 = r2.A().aE();
        if (r61 == null) goto L146;
        r61.mX();
    L146:
        com.larus.bmhome.chat.model.j1 r62 = r2.A().Y3();
        if (r62 == null) goto L150;
        r62.l(null);
        goto L150
    L113:
        r48 = null;
        goto L114
    L115:
        r51 = null;
        r50 = null;
        goto L116
    L102:
        r117 = null;
    L89:
        if (Intrinsics.areEqual(r22, r40) == true) goto L95;
        if (Intrinsics.areEqual(r39, r40) == false) goto L94;
        r114 = "upload";
        goto L95
    L94:
        r114 = null;
        goto L95
    L82:
        r22 = null;
        r39 = null;
        goto L83
    L29:
        r111 = null;
    L104:
        r43 = r17;
        goto L106
    L7:
        r11 = null;
    L13:
        r12 = null;
        goto L14
    }
}
