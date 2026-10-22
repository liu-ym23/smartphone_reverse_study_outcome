package com.larus.bmhome.chat.component.bottom.core;

import android.net.Uri;
import bc8.a;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.utils.RegisterHelper;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q1 implements Function3 {
    public final /* synthetic */ CoreInputAbility a;
    public final /* synthetic */ AttachmentInfo b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Ref.BooleanRef d;
    public final /* synthetic */ ICoreInputAbility.OnSendParams e;
    public final /* synthetic */ Ref.ObjectRef f;
    public final /* synthetic */ Map g;
    public final /* synthetic */ boolean h;

    public /* synthetic */ q1(CoreInputAbility r1, AttachmentInfo r2, String r3, Ref.BooleanRef r4, ICoreInputAbility.OnSendParams r5, Ref.ObjectRef r6, Map r7, boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public final Object invoke(Object r33, Object r34, Object r35) {
        CoreInputAbility r2 = this.a;
        AttachmentInfo r3 = this.b;
        String r4 = this.c;
        Ref.BooleanRef r5 = this.d;
        ICoreInputAbility.OnSendParams r6 = this.e;
        Ref.ObjectRef r7 = this.f;
        Map r8 = this.g;
        boolean r9 = this.h;
        AttachmentInfo r10 = (AttachmentInfo) r33;
        List r11 = (List) r34;
        String r12 = (String) r35;
        Intrinsics.checkNotNullParameter(r10, "newAttachmentInfo");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L30
        IBachDetectCenterAbility.Companion r1 = IBachDetectCenterAbility.a;     // Catch: Throwable -> L30
        if (r1.b() == true) goto L6;
    L47:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L50:
        if (r11 == null) goto L53;
        String r13 = (String) CollectionsKt.firstOrNull(r11);
        if (r13 == null) goto L53;
    L54:
        if (r13 == null) goto L61;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r14 = r2.A().f70();
        if (r14 == null) goto L58;
        NestedFileContent r15 = r14.b6(r13);
    L59:
        if (r15 == null) goto L61;
        List r16 = r15.getEntities();
    L62:
        if (r16 != null) goto L64;
        r16 = CollectionsKt.emptyList();
    L64:
        String r17 = com.larus.bmhome.chat.component.bottom.core.inputtext.f0.c(r4, r16);
        if (com.larus.bmhome.chat.component.bottom.core.inputtext.f0.d(r17, r16) == false) goto L67;
        FLogger.a.e("CoreInputAbility", "[onSend] unresolved single attachment reference, skip send");
        r5.element = true;
    L168:
        return Unit.INSTANCE;
    L67:
        String r18 = r6.getTxtScene();
        String r19 = (String) r7.element;
        Boolean r20 = Boolean.valueOf(r9);
        r2.getClass();
        ArrayList r21 = new ArrayList();
        Map r22 = com.larus.utils.h.c(r8, new Pair[0]);
        String r110 = r10.getFromScene();
        String r23 = "shoot";
        if (CollectionsKt.listOf(new String[]{"shoot", "shoot_ocr"}).contains(r110) == false) goto L71;
    L74:
        if (r23 == null) goto L76;
        String r24 = (String) r22.put("content_source", r23);
    L76:
        SuggestedAction r25 = r6.getSuggestedAction();
        if (r25 == null) goto L82;
        Map r26 = r25.getMsgExt();
        if (r26 == null) goto L82;
        r22.putAll(r26);
    L82:
        if (r10.isImage() == false) goto L127;
        if (r11 == null) goto L86;
        String r27 = (String) CollectionsKt.firstOrNull(r11);
        if (r27 == null) goto L86;
    L89:
        String r111 = r2.getBotId();
        String r112 = r2.v();
        int r28 = RegisterHelper.a;
        String r113 = r10.getTosKey();
        String r29 = r10.getFileIdentifier();
        ResourceUploadInstantInfo r210 = r10.getInstantUploadInfo();
        Image r211 = r10.getImage();
        wc9.e r30 = r2.h();
        if (r30 == null) goto L92;
        String r212 = r30.B;
    L93:
        RegisterHelper.c(r27, r111, r112, r113, r29, r210, r211, r212, 16);
        String r114 = r10.getFilePath();
        String r115 = r10.getTosKey();
        Integer r31 = r10.getHeight();
        if (r31 == null) goto L96;
        int r32 = r31.intValue();
    L97:
        Integer r116 = r10.getWidth();
        if (r116 == null) goto L100;
        int r117 = r116.intValue();
    L101:
        String r213 = r10.getResourceId();
        String r214 = r10.getServerUrl();
        ReferenceInfo r215 = r6.getReferenceInfo();
        ChatPageContext r216 = r2.r(r6);
        Boolean r217 = r10.getAiCreationImage();
        String r118 = r10.getPreviewUrl();
        if (r118 != null) goto L104;
    L112:
        Image r119 = r10.getImage();
        if (r119 == null) goto L117;
        ImageObj r120 = r119.previewImage;
        if (r120 == null) goto L117;
        r118 = r120.url;
    L118:
        if (r118 != null) goto L125;
        r118 = r10.getServerUrl();
        if (r118 != null) goto L122;
    L124:
        String r36 = null;
    L126:
        ic8.w r37 = new ai8.e(r114, r115, Integer.valueOf(r32), Integer.valueOf(r117), r213, r214, r27, r215, r22, null, false, r216, r217, r36, 3136);
    L128:
        r21.add(r37);
        if (r17.length() <= 0) goto L131;
        boolean r121 = true;
    L132:
        if (r121 == false) goto L136;
        if (r12 != null) goto L135;
        int r38 = wf9.b.a;
        r12 = com.flow.kmp.common.util.i.a();
    L135:
        r21.add(new ai8.h(r17, r12, null, r6.getReferenceInfo(), r22, null, false, false, r2.r(r6), null, 740));
        Pair r39 = CoreInputAbility.H(r6.getSuggestedAction(), r27, r12);
        Object r40 = r39.getFirst();
        Object r41 = r39.getSecond();
    L137:
        ConcurrentHashMap r42 = ko8.b.a;
        String r43 = r6.getCreationSendTraceId();
        ArrayList r44 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator r122 = r21.iterator();
    L139:
        if (r122.hasNext() == false) goto L141;
        r44.add(((ic8.w) r122.next()).b());
        goto L139
    L141:
        ko8.b.b(r43, r44);
        gd8.g r123 = r2.A().h2();
        if (r123 == null) goto L154;
        wc9.e r124 = r2.h();
        String r45 = (String) r40;
        if (r45 != null) goto L148;
        if (r18 != null) goto L147;
        String r125 = r19;
    L149:
        String r46 = (String) r41;
        if (r46 != null) goto L152;
        String r218 = r10.getFromScene();
    L153:
        r123.sW(r124, r125, r21, r218, r20, r6.getSendClickTimestamp());
    L161:
        a r47 = r2.A().aE();
        if (r47 == null) goto L164;
        r47.mX();
    L164:
        com.larus.bmhome.chat.model.j1 r48 = r2.A().Y3();
        if (r48 == null) goto L168;
        r48.l(null);
        goto L168
    L152:
        r218 = r46;
        goto L153
    L147:
        r125 = r18;
        goto L149
    L148:
        r125 = r45;
        goto L149
    L154:
        Iterator r49 = r21.iterator();
    L156:
        if (r49.hasNext() == false) goto L161;
        ic8.w r50 = (ic8.w) r49.next();
        IChatRepoService r51 = RepoDispatcherDelegate.b.e();
        String r52 = r50.b();
        if (r52 != null) goto L160;
        r52 = "";
    L160:
        r51.t1(r52, 12);
        goto L156
    L136:
        r41 = null;
        r40 = null;
        goto L137
    L131:
        r121 = false;
        goto L132
    L122:
        if (Intrinsics.areEqual(r10.getAiCreationImage(), Boolean.TRUE) == false) goto L124;
    L125:
        r36 = r118;
    L117:
        r118 = null;
        goto L118
    L104:
        if (r118.length() != 0) goto L106;
        boolean r126 = true;
    L108:
        if ((!r126) == true) goto L111;
        r118 = null;
    L111:
        if (r118 != null) goto L125;
    L106:
        r126 = false;
        goto L108
    L100:
        r117 = 0;
        goto L101
    L96:
        r32 = 0;
        goto L97
    L92:
        r212 = null;
    L86:
        r27 = r10.getLocalMessageId();
        if (r27 != null) goto L89;
        int r53 = wf9.b.a;
        r27 = com.flow.kmp.common.util.i.a();
        goto L89
    L127:
        String r127 = r10.getFilePath();
        String r128 = r10.getFileName();
        String r129 = r10.getTosKey();
        String r219 = r10.getResourceId();
        int r54 = wf9.b.a;
        r37 = new ai8.d(r127, r128, r129, r219, com.flow.kmp.common.util.i.a(), r6.getReferenceInfo(), r22, null, r2.r(r6), 384);
        r27 = null;
        goto L128
    L71:
        if (CollectionsKt.listOf(new String[]{"album", "album_ocr"}).contains(r110) == false) goto L73;
        r23 = "upload";
        goto L74
    L73:
        r23 = null;
        goto L74
    L58:
        r15 = null;
    L61:
        r16 = null;
    L53:
        r13 = r3.getLocalMessageId();
        goto L54
    L6:
        if (r3.isImage() == false) goto L47;
        if (com.larus.utils.o0.d(r3.getServerUrl()) == false) goto L33;
        Uri r130 = com.larus.utils.y0.j(r3.getServerUrl());     // Catch: Throwable -> L30
        if (r130 == null) goto L47;
        if (Intrinsics.areEqual(r1.c(r130, true), Boolean.TRUE) == false) goto L16;
        r8.put(IAIChatUgcAIGCService.a.F0(), "1");     // Catch: Throwable -> L30
        goto L47
    L16:
        if (com.larus.utils.o0.d(r3.getFilePath()) == false) goto L47;
        PolarisFileWrapper r55 = new PolarisFileWrapper(r3.getFilePath());     // Catch: Throwable -> L30
        if (r55.exists() == false) goto L47;
        Object r56 = Result.constructor-impl(Uri.fromFile(r55));     // Catch: Throwable -> L21
    L24:
        if (Result.isSuccess-impl(r56) == false) goto L47;
        Uri r57 = (Uri) r56;     // Catch: Throwable -> L30
        IBachDetectCenterAbility.Companion r131 = IBachDetectCenterAbility.a;     // Catch: Throwable -> L30
        Intrinsics.checkNotNull(r57);     // Catch: Throwable -> L30
        Boolean r58 = r131.c(r57, true);     // Catch: Throwable -> L30
        if (r58 == null) goto L47;
        if (r58.booleanValue() == false) goto L47;
        r8.put(IAIChatUgcAIGCService.a.F0(), "1");     // Catch: Throwable -> L30
    L21:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L30
        r56 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L30
        goto L24
    L33:
        if (com.larus.utils.o0.d(r3.getFilePath()) == false) goto L47;
        PolarisFileWrapper r59 = new PolarisFileWrapper(r3.getFilePath());     // Catch: Throwable -> L30
        if (r59.exists() == false) goto L47;
        Object r60 = Result.constructor-impl(Uri.fromFile(r59));     // Catch: Throwable -> L38
    L41:
        if (Result.isSuccess-impl(r60) == false) goto L47;
        Uri r61 = (Uri) r60;     // Catch: Throwable -> L30
        IBachDetectCenterAbility.Companion r133 = IBachDetectCenterAbility.a;     // Catch: Throwable -> L30
        Intrinsics.checkNotNull(r61);     // Catch: Throwable -> L30
        Boolean r62 = r133.c(r61, true);     // Catch: Throwable -> L30
        if (r62 == null) goto L47;
        if (r62.booleanValue() == false) goto L47;
        r8.put(IAIChatUgcAIGCService.a.F0(), "1");     // Catch: Throwable -> L30
    L38:
        th = move-exception;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L30
        r60 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    }
}
