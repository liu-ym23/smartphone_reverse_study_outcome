package com.larus.uaigc.spring.utils;

import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.b0;
import com.larus.bmhome.actionbar.model.c0;
import com.larus.bmhome.actionbar.model.h;
import com.larus.bmhome.actionbar.model.k1;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.s;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.actionbar.model.y;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.actionbar.util.g;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.instruction.d2;
import com.larus.bmhome.instruction.e2;
import com.larus.bmhome.instruction.j;
import com.larus.bmhome.view.actionbar.custom.w2;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.lynx.pocket.Pocket;
import com.larus.uaigc.lynx.pocket.PocketExtCreationConfig;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import ouc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = LazyKt.lazy(new b());
        b = LazyKt.lazy(new c());
        c = LazyKt.lazy(new d());
    }

    public static final Object a(ICoreInputAbility.OnSendParams r61, Pocket r62, Boolean r63, Continuation r64) {
        ICoreInputAbility.OnSendParams r0 = r61;
        if ((r64 instanceof SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$1) == false) goto L7;
        SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$1 r2 = (SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$1) r64;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        Ref.ObjectRef r6 = (Ref.ObjectRef) r2.L$3;
        Boolean r7 = (Boolean) r2.L$2;
        Pocket r8 = (Pocket) r2.L$1;
        ICoreInputAbility.OnSendParams r9 = (ICoreInputAbility.OnSendParams) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Ref.ObjectRef r10 = r6;
        r0 = r9;
    L37:
        ICoreInputAbility.OnSendParams r11 = r0;
    L39:
        z0 r12 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(28);
        if (r12 == null) goto L80;
        ArrayList r13 = new ArrayList();
        r r14 = r12.q;
        if (r14 == null) goto L49;
        List r15 = r14.b;
        if (r15 == null) goto L49;
        Iterator r16 = r15.iterator();
    L47:
        if (r16.hasNext() == false) goto L49;
        r13.add(u.a((u) r16.next(), null, 255));
    L49:
        ArrayList r17 = new ArrayList();
        r r18 = r12.q;
        if (r18 == null) goto L71;
        y r19 = r18.i;
        if (r19 == null) goto L71;
        ArrayList r20 = r19.a;
        if (r20 == null) goto L71;
        Iterator r21 = r20.iterator();
    L57:
        if (r21.hasNext() == false) goto L71;
        z0 r110 = (z0) r21.next();
        ArrayList r111 = new ArrayList();
        r r112 = r110.q;
        if (r112 == null) goto L66;
        List r113 = r112.b;
        if (r113 == null) goto L66;
        Iterator r114 = r113.iterator();
    L64:
        if (r114.hasNext() == false) goto L66;
        r111.add(u.a((u) r114.next(), null, 255));
    L66:
        r r115 = r110.q;
        if (r115 == null) goto L69;
        r r26 = r.a(r115, r111, null, null, null, 4093);
    L70:
        r17.add(z0.a(r110, null, null, null, null, null, null, null, null, r26, null, null, null, false, -65537));
        goto L57
    L69:
        r26 = null;
    L71:
        r r22 = r12.q;
        if (r22 != null) goto L74;
        r r23 = null;
    L79:
        z0 r24 = z0.a(r12, null, null, null, null, null, null, null, null, r23, null, null, null, false, -65537);
    L81:
        if (r24 == null) goto L104;
        r r25 = r24.q;
        if (r25 == null) goto L104;
        y r27 = r25.i;
        if (r27 == null) goto L104;
        ArrayList r28 = r27.a;
        if (r28 == null) goto L104;
        Iterator r29 = r28.iterator();
    L90:
        if (r29.hasNext() == false) goto L102;
        Object r30 = r29.next();
        r r116 = ((z0) r30).q;
        if (r116 == null) goto L99;
        Integer r117 = r116.a;
        if (r117 == null) goto L99;
        if (r117.intValue() != 18) goto L99;
        boolean r118 = true;
    L100:
        if (r118 == false) goto L90;
    L103:
        z0 r31 = (z0) r30;
    L105:
        if (r31 != null) goto L107;
        return r11;
    L107:
        r r32 = r31.q;
        if (r32 == null) goto L125;
        List r33 = r32.b;
        if (r33 == null) goto L125;
        Iterator r34 = r33.iterator();
    L113:
        if (r34.hasNext() == false) goto L123;
        Object r119 = r34.next();
        Integer r120 = ((u) r119).b;
        if (r120 != null) goto L118;
    L120:
        boolean r121 = false;
    L121:
        if (r121 == false) goto L113;
    L124:
        u r122 = (u) r119;
    L126:
        r r35 = r31.q;
        if (r35 == null) goto L131;
        List r36 = r35.b;
        if (r36 == null) goto L131;
        Integer r123 = Boxing.boxInt(CollectionsKt.indexOf(r36, r122));
    L132:
        String r124 = "<this>";
        Intrinsics.checkNotNullParameter(r8, "<this>");
        String r37 = r8.getExt();
        String r38 = "SpringMainVenueInputComponent";
        if (r37 != null) goto L458;
    L143:
        PocketExtCreationConfig r125 = null;
    L144:
        FLogger.a.d("InstructionHitPoints", "selectVideoGenerateInfoByPocket creationConfig = " + r125);
        if (r122 == null) goto L147;
        Intrinsics.checkNotNullParameter(r122, "<this>");
        g.a.getClass();
        r122.e = g.a(r122);
    L147:
        if (r122 == null) goto L149;
        k1 r39 = r122.e;
    L151:
        if ((r39 instanceof b0) == false) goto L153;
        b0 r126 = (b0) r39;
    L154:
        if (r126 == null) goto L182;
        List r40 = r126.a;
        if (r40 == null) goto L182;
        ArrayList r41 = new ArrayList();
        Iterator r42 = r40.iterator();
    L159:
        if (r42.hasNext() == false) goto L181;
        Object r43 = r42.next();
        c0 r127 = (c0) r43;
        Integer r44 = r127.a;
        if (r44 != null) goto L163;
        String r128 = r38;
    L165:
        Integer r45 = r127.a;
        if (r45 != null) goto L169;
    L170:
        Integer r46 = r127.a;
        if (r46 != null) goto L174;
    L176:
        boolean r47 = false;
    L178:
        if (r47 == false) goto L180;
        r41.add(r43);
    L180:
        r38 = r128;
        goto L159
    L174:
        if (r46.intValue() != 6) goto L176;
    L177:
        r47 = true;
        goto L178
    L169:
        if (r45.intValue() == 5) goto L177;
    L163:
        r128 = r38;
        if (r44.intValue() == 1) goto L177;
    L181:
        String r129 = r38;
    L183:
        String r48 = "";
        if (r41 == null) goto L298;
        Iterator r49 = r41.iterator();
    L187:
        if (r49.hasNext() == false) goto L298;
        c0 r50 = (c0) r49.next();
        int r51 = r50.b;
        if (r51 != 3) goto L191;
    L460:
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L203
        v r53 = xt7.d.b;     // Catch: Throwable -> L203
        juc.c r130 = h.Companion.serializer();     // Catch: Throwable -> L203
        String r131 = r48;
        String r54 = r50.c;     // Catch: Throwable -> L201
        if (r54 != null) goto L199;
        r54 = r131;
    L199:
        Object r55 = Result.constructor-impl((h) r53.c(r130, r54));     // Catch: Throwable -> L201
    L207:
        if (Result.exceptionOrNull-impl(r55) == null) goto L210;
        r55 = null;
    L210:
        h r56 = (h) r55;
        Integer r57 = r50.a;
        if (r57 != null) goto L213;
        Iterator r132 = r49;
    L234:
        if (r57 != null) goto L237;
    L257:
        if (r57 != null) goto L260;
    L233:
        r124 = r124;
        w r58 = null;
    L280:
        ArrayList r59 = new ArrayList();
        if (r58 == null) goto L283;
        r59.add(r58);
    L283:
        if (r56 == null) goto L285;
        r56.e = r59;
    L285:
        if (r56 != null) goto L448;
    L295:
        String r60 = r50.c;
    L296:
        r50.c = r60;
    L297:
        r48 = r131;
        r49 = r132;
        r124 = r124;
        goto L187
    L448:
        Result.Companion r65 = Result.Companion;     // Catch: Throwable -> L288
        Object r66 = Result.constructor-impl(xt7.d.b.a(h.Companion.serializer(), r56));     // Catch: Throwable -> L288
    L291:
        if (Result.isFailure-impl(r66) == false) goto L293;
        r66 = null;
    L293:
        r60 = (String) r66;
        if (r60 != null) goto L296;
    L288:
        th = move-exception;
        Result.Companion r67 = Result.Companion;
        r66 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L291
    L260:
        if (r57.intValue() != 6) goto L233;
        if (r56 == null) goto L233;
        List r68 = r56.e;
        if (r68 == null) goto L233;
        Iterator r69 = r68.iterator();
    L266:
        if (r69.hasNext() == false) goto L277;
        Object r133 = r69.next();
        Long r70 = ((w) r133).a;
        if (r125 == null) goto L272;
        Intrinsics.checkNotNullParameter(r125, r124);
        Long r210 = r125.getSelectedModel();
        if (r210 == null) goto L272;
        Long r71 = (Long) ((Map) a.getValue()).get(Long.valueOf(r210.longValue()));
    L274:
        if (Intrinsics.areEqual(r70, r71) == true) goto L278;
        r124 = r124;
        r69 = r69;
    L278:
        r58 = (w) r133;
    L272:
        r71 = null;
        goto L274
    L277:
        r124 = r124;
        r133 = null;
        goto L278
    L237:
        if (r57.intValue() != 5) goto L257;
        if (r56 == null) goto L233;
        List r72 = r56.e;
        if (r72 == null) goto L233;
        Iterator r73 = r72.iterator();
    L243:
        if (r73.hasNext() == false) goto L254;
        Object r211 = r73.next();
        Long r134 = ((w) r211).a;
        if (r125 == null) goto L249;
        Intrinsics.checkNotNullParameter(r125, r124);
        Long r212 = r125.getSelectedDuration();
        if (r212 == null) goto L249;
        Long r74 = (Long) ((Map) c.getValue()).get(Long.valueOf(r212.longValue()));
    L251:
        if (Intrinsics.areEqual(r134, r74) == true) goto L255;
        r73 = r73;
    L255:
        w r213 = (w) r211;
    L256:
        r58 = r213;
        r124 = r124;
    L249:
        r74 = null;
        goto L251
    L254:
        r211 = null;
        goto L255
    L213:
        r132 = r49;
        if (r57.intValue() != 1) goto L234;
        if (r56 == null) goto L233;
        List r75 = r56.e;
        if (r75 == null) goto L233;
        Iterator r76 = r75.iterator();
    L220:
        if (r76.hasNext() == false) goto L231;
        Object r214 = r76.next();
        Long r135 = ((w) r214).a;
        if (r125 == null) goto L226;
        Intrinsics.checkNotNullParameter(r125, r124);
        Long r215 = r125.getSelectedRatio();
        if (r215 == null) goto L226;
        Long r77 = (Long) ((Map) b.getValue()).get(Long.valueOf(r215.longValue()));
    L228:
        if (Intrinsics.areEqual(r135, r77) == true) goto L232;
        r76 = r76;
    L232:
        r213 = (w) r214;
    L226:
        r77 = null;
        goto L228
    L231:
        r214 = null;
    L201:
        th = th;
    L205:
        Result.Companion r78 = Result.Companion;
        r55 = Result.constructor-impl(ResultKt.createFailure(th));
    L203:
        th = th;
        r131 = r48;
        goto L205
    L191:
        if (r51 == 6) goto L460;
        r131 = r48;
        r132 = r49;
        r124 = r124;
    L298:
        String r136 = r48;
        if (r126 == null) goto L301;
        r126.a = r41;
    L301:
        if (r122 == null) goto L303;
        s.a(r122);
    L303:
        if (r122 == null) goto L305;
        r122.e = null;
    L305:
        r r79 = r31.q;
        if (r79 == null) goto L323;
        List r80 = r79.b;
        if (r80 == null) goto L323;
        Iterator r81 = r80.iterator();
    L311:
        if (r81.hasNext() == false) goto L321;
        Object r82 = r81.next();
        Integer r83 = ((u) r82).b;
        if (r83 != null) goto L316;
    L318:
        boolean r84 = false;
    L319:
        if (r84 == false) goto L311;
    L322:
        u r85 = (u) r82;
    L324:
        Ref.ObjectRef r86 = new Ref.ObjectRef();
        if (r85 == null) goto L327;
        String r87 = r85.d;
    L328:
        r86.element = r87;
        Result.Companion r88 = Result.Companion;     // Catch: Throwable -> L334
        v r89 = xt7.d.b;     // Catch: Throwable -> L334
        juc.c r90 = com.larus.bmhome.actionbar.model.v.Companion.serializer();     // Catch: Throwable -> L334
        String r91 = (String) r86.element;     // Catch: Throwable -> L334
        if (r91 != null) goto L332;
        r91 = r136;
    L332:
        Object r92 = Result.constructor-impl((com.larus.bmhome.actionbar.model.v) r89.c(r90, r91));     // Catch: Throwable -> L334
    L337:
        if (Result.exceptionOrNull-impl(r92) == null) goto L340;
        r92 = null;
    L340:
        com.larus.bmhome.actionbar.model.v r93 = (com.larus.bmhome.actionbar.model.v) r92;
        Object r94 = r10.element;
        if (r94 != null) goto L343;
        return r11;
    L343:
        com.larus.uaigc.api.a r95 = (com.larus.uaigc.api.a) r94;
        DigitalAvatarInfoManager.a.getClass();
        String r96 = r95.d();
        String r97 = r95.c();
        if (r96 != null) goto L346;
    L349:
        boolean r98 = true;
    L350:
        if (r98 == false) goto L357;
        r96 = DigitalAvatarInfoManager.e();
        if (DigitalAvatarInfoManager.i() == false) goto L356;
        r97 = DigitalAvatarInfoManager.g;
        if (r97 != null) goto L357;
        r97 = DigitalAvatarInfoManager.e;
        goto L357
    L356:
        r97 = DigitalAvatarInfoManager.e;
    L357:
        Pair r99 = new Pair(r96, r97);
        String r100 = (String) r99.component1();
        String r101 = (String) r99.component2();
        MediaAttachment r102 = new MediaAttachment(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
        r102.setUrl(r100);
        r102.setUri(r101);
        r102.setImageUploadInfo(new ImageUploadInfo(Boxing.boxLong(640), Boxing.boxLong(640)));
        if (r93 == null) goto L360;
        ArrayList r137 = new ArrayList();
        r137.add(r102);
        r93.c = r137;
    L360:
        if (r93 != null) goto L452;
    L370:
        if (r85 == null) goto L372;
        String r103 = r85.d;
    L373:
        r86.element = r103;
        if (r85 == null) goto L376;
        r85.d = r103;
    L376:
        r r104 = r31.q;
        if (r104 == null) goto L379;
        List r105 = r104.b;
    L380:
        String r106 = r11.getContent();
        if (r123 == null) goto L383;
        int r216 = r123.intValue();
    L454:
        w2 r138 = IAIChatUgcAIGCService.a.z0();     // Catch: Exception -> L394
        if (r24 == null) goto L387;
        r r217 = r24.q;     // Catch: Exception -> L394
    L389:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L391;
        d2 r107 = d2.a;     // Catch: Exception -> L394
    L392:
        String r108 = w2.a.a(r138, r106, r217, r105, null, null, r216, r107, 16);     // Catch: Exception -> L394
    L398:
        HashMap r109 = new HashMap();
        Map r139 = r11.messageExt;
        if (r139 == null) goto L401;
        r109.putAll(r139);
    L401:
        ArrayList r140 = new ArrayList();
        r140.add(0);
        r109.put("white_tee_index_list", r140.toString());
        Image r141 = new Image(r101, null, null, new ImageObj(r100, 640, 640, null, null, 24, null), null, null, null, null, null, null, null, null, null, null, 16374, null);
        Long r142 = null;
        UplinkEntityContent r143 = new UplinkEntityContent(null, r141, 1, null);
        ArrayList r144 = new ArrayList();
        r144.add(new UplinkFileEntity(Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue()), r143, null, null, Integer.valueOf(FileReviewState.ACCESS.getValue()), Integer.valueOf(FileParseState.SUCCESS.getValue()), 100, Integer.valueOf(UpLinkState.SUCCESS.getValue()), null, false, null, null, null, null, 16140, null));
        CustomMultiAttachmentInfo r310 = new CustomMultiAttachmentInfo("album", r11.getEnterMethod(), new NestedFileContent(r144, null, false, null, 14, null), false, false, false, false, null, 248, null);
        if (r24 == null) goto L408;
        r r145 = r24.q;
        if (r145 == null) goto L408;
        Integer r146 = r145.a;
        if (r146 == null) goto L408;
        int r147 = r146.intValue();
    L409:
        IAIChatUgcAIGCService.Companion r148 = IAIChatUgcAIGCService.a;
        j r149 = r148.e0();
        if (r24 == null) goto L412;
        String r150 = r24.b;
    L413:
        if (r150 != null) goto L415;
        r150 = r136;
    L415:
        if (r24 == null) goto L421;
        r r151 = r24.q;
        if (r151 == null) goto L421;
        Integer r152 = r151.a;
        if (r152 == null) goto L421;
        String r153 = r152.toString();
    L422:
        if (r153 == null) goto L425;
        r136 = r153;
    L425:
        j r154 = r148.e0();
        if (r24 == null) goto L430;
        r r155 = r24.q;
        if (r155 == null) goto L430;
        Integer r218 = r155.a;
    L431:
        if (r24 == null) goto L433;
        r r219 = r24.q;
    L434:
        if (r123 == null) goto L436;
        int r220 = r123.intValue();
    L437:
        r r156 = r154.a(r218, r106, r105, r219, r220);
        if (r156 == null) goto L440;
        String r221 = HttpExtKt.p(r156);
    L442:
        if (r24 == null) goto L445;
        r142 = r24.a;
    L445:
        return ICoreInputAbility.OnSendParams.copy$default(r11, r108, "", null, null, null, r149.b(r150, r136, r221, false, r109, r142), null, null, r147, false, null, false, false, false, null, null, null, null, false, null, r109, null, null, null, null, null, r310, null, null, null, null, null, null, -68157760, 1, null);
    L440:
        r221 = null;
        goto L442
    L436:
        r220 = 1;
        goto L437
    L433:
        r219 = null;
    L430:
        r218 = null;
    L421:
        r153 = null;
        goto L422
    L412:
        r150 = null;
    L408:
        r147 = 0;
        goto L409
    L391:
        r107 = e2.a;     // Catch: Exception -> L394
        goto L392
    L387:
        r217 = null;
    L394:
        e = move-exception;
        FLogger.a.e(r129, "buildContent error = " + e.getMessage());
        if (AppHost.a.isDebug() == true) goto L447;
        r108 = r106;
        goto L398
    L447:
        throw new IllegalArgumentException("InstructionComponent, " + e.getMessage());
    L383:
        r216 = 1;
        goto L454
    L379:
        r105 = null;
        goto L380
    L372:
        r103 = null;
        goto L373
    L452:
        Object r157 = Result.constructor-impl(xt7.d.b.a(com.larus.bmhome.actionbar.model.v.Companion.serializer(), r93));     // Catch: Throwable -> L363
    L366:
        if (Result.isFailure-impl(r157) == false) goto L368;
        r157 = null;
    L368:
        r103 = (String) r157;
        if (r103 != null) goto L373;
    L363:
        th = move-exception;
        Result.Companion r158 = Result.Companion;
        r157 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L366
    L346:
        if (r96.length() == 0) goto L349;
        r98 = false;
    L334:
        th = move-exception;
        Result.Companion r159 = Result.Companion;
        r92 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L337
    L327:
        r87 = null;
        goto L328
    L316:
        if (r83.intValue() != 15) goto L318;
        r84 = true;
        goto L319
    L321:
        r82 = null;
    L323:
        r85 = null;
    L182:
        r129 = "SpringMainVenueInputComponent";
        r41 = null;
        goto L183
    L153:
        r126 = null;
        goto L154
    L149:
        r39 = null;
        goto L151
    L458:
        JSONObject r160 = new JSONObject(r37).optJSONObject("creation_config");     // Catch: Exception -> L141
        if (r160 == null) goto L139;
        PocketExtCreationConfig r222 = new PocketExtCreationConfig(Long.valueOf(r160.optLong("selected_model")), Long.valueOf(r160.optLong("selected_ratio")), Long.valueOf(r160.optLong("selected_resolution")), Long.valueOf(r160.optLong("selected_duration")), r160.optString("hidden_resource_url"), r160.optString("hidden_resource_uri"), r160.optString("hidden_resource_vid"));     // Catch: Exception -> L141
    L140:
        r125 = r222;
        goto L144
    L139:
        r222 = null;
    L141:
        e = move-exception;
        FLogger.a.e("SpringMainVenueInputComponent", "getPocketCreationConfig error = " + e.getMessage());
    L131:
        r123 = null;
        goto L132
    L118:
        if (r120.intValue() != 8) goto L120;
        r121 = true;
        goto L121
    L123:
        r119 = null;
    L125:
        r122 = null;
    L99:
        r118 = false;
        goto L100
    L102:
        r30 = null;
    L104:
        r31 = null;
        goto L105
    L74:
        if (r22.i == null) goto L76;
        y r161 = new y(r17);
    L77:
        r23 = r.a(r22, r13, null, null, r161, 3837);
        goto L79
    L76:
        r161 = null;
        goto L77
    L80:
        r24 = null;
        goto L81
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        Integer r162 = r62.getIntentionType();
        if (r162 != null) goto L18;
    L19:
        return r0;
    L18:
        if (r162.intValue() != 14) goto L19;
        Integer r163 = r62.getPocketType();
        if (r163 != null) goto L24;
    L25:
        Integer r164 = r62.getPocketType();
        if (r164 != null) goto L29;
    L30:
        return r0;
    L29:
        if (r164.intValue() != 2) goto L30;
    L31:
        r10 = new Ref.ObjectRef();
        DigitalAvatarInfoManager.a.getClass();
        com.larus.uaigc.api.a r165 = DigitalAvatarInfoManager.i;
        r10.element = r165;
        if (r165 != null) goto L38;
        CoroutineDispatcher r166 = Dispatchers.getIO();
        SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$2 r167 = new SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$2(r10, null);
        r2.L$0 = r0;
        r2.L$1 = r62;
        r2.L$2 = r63;
        r2.L$3 = r10;
        r2.label = 1;
        if (BuildersKt.withContext(r166, r167, r2) != r4) goto L36;
        return r4;
    L36:
        r8 = r62;
        r7 = r63;
        goto L37
    L38:
        r11 = r0;
        r8 = r62;
        r7 = r63;
        goto L39
    L24:
        if (r163.intValue() == 1) goto L31;
    L7:
        r2 = new SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$1(r64);
        goto L8
    }
}
