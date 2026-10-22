package com.larus.bmhome.chat.bubble.floating.datasource;

import androidx.fragment.app.Fragment;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerSource;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerStyle;
import com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService;
import com.larus.bmhome.chat.bubble.floating.runtime.k;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.extension.offline_message.api.OfflineMessageServiceDelegate;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.reach.api.ReachButtonStyle;
import com.larus.reach.api.ReachButtonType;
import com.larus.reach.api.ReachPosition;
import com.larus.reach.api.ReachRequestSource;
import com.larus.reach.api.ReachService;
import com.larus.reach.api.ReachType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ns9.b;
import ns9.l;
import ns9.r;
import ns9.s;
import ns9.t;
import ns9.w;
import pc8.a;
import pc8.h;
import rc8.c;
import rc8.d;
import rc8.e;
import rc8.f;
import rc8.g;
import sc8.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/datasource/BubbleBannerDataServiceImpl;", "Lcom/larus/bmhome/chat/bubble/floating/datasource/IBubbleBannerDataService;", "<init>", "()V", "handleBannerNotify", "", "input", "Lcom/larus/bmhome/chat/bubble/floating/datasource/BubbleBannerNotifyInput;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BubbleBannerDataServiceImpl implements IBubbleBannerDataService {
    public BubbleBannerDataServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.bubble.floating.datasource.IBubbleBannerDataService
    public final void a(c r34) {
        int r0 = g.a;
        ReachService r1 = (ReachService) ServiceManager.get().getService(ReachService.class);
        boolean r9 = false;
        Integer r10 = 0;
        if (r1 == null) goto L12;
        if (r34 == null) goto L12;
        e r11 = d.a(r34);
        if (r11 == null) goto L12;
        if (r1.d(r11.a()) == false) goto L12;
        f r12 = d.b(r11.f());
        Pair[] r13 = new Pair[3];
        r13[0] = TuplesKt.to("page_id", "conversation");
        String r14 = r11.c();
        if (r14 == null) goto L16;
        String r15 = StringsKt.trim(r14).toString();
    L18:
        if (r15 != null) goto L20;
        r15 = "";
    L20:
        r13[1] = TuplesKt.to("conversation_id", r15);
        String r4 = r11.i();
        if (r4 != null) goto L23;
        r4 = "";
    L23:
        r13[2] = TuplesKt.to("query_message_id", r4);
        Map r5 = MapsKt.mapOf(r13);
        LinkedHashMap r16 = new LinkedHashMap();
        String r17 = r11.j();
        if (r17 != null) goto L26;
    L31:
        String r18 = r11.d();
        if (r18 != null) goto L34;
    L39:
        LinkedHashMap r19 = new LinkedHashMap();
        Map<String, String> r110 = d.c(r11.e());
        if (r110 != null) goto L42;
        r110 = MapsKt.emptyMap();
    L42:
        Iterator<Map.Entry<String, String>> r111 = r110.entrySet().iterator();
    L44:
        if (r111.hasNext() == false) goto L46;
        Map.Entry<String, String> r112 = r111.next();
        r19.put(r112.getKey(), r112.getValue());
        goto L44
    L46:
        String r2 = r11.g();
        if (r2 != null) goto L49;
    L54:
        a r3 = r34.g;
        if (r3 != null) goto L57;
    L96:
        String r6 = r34.d;
        if (r6 != null) goto L99;
    L105:
        b r7 = null;
    L106:
        ReachType r25 = ReachType.BANNER;
        String r8 = r11.a();
        if (r8 != null) goto L109;
        String r26 = "";
    L110:
        l r20 = new l(null, r25, r26, null, null, ReachRequestSource.CLIENT_BRIDGE, null, 89);
        ReachPosition r21 = ReachPosition.BOTTOM;
        if (r12 != null) goto L113;
        Map r22 = MapsKt.emptyMap();
        Integer r113 = 1;
    L129:
        w r23 = new w(r21, r5, r22, 12);
        if (r12 == null) goto L143;
        Long r24 = r12.a();
        if (r24 == null) goto L143;
        if (r24.longValue() <= 0) goto L136;
        boolean r27 = true;
    L137:
        if (r27 == true) goto L140;
        r24 = null;
    L140:
        if (r24 == null) goto L143;
        Long r28 = Long.valueOf(r24.longValue() * 1000);
    L144:
        if (r12 == null) goto L146;
        Integer r29 = r12.b();
    L147:
        if (r29 != null) goto L150;
    L151:
        if (r29 != null) goto L153;
        int r30 = 2;
    L156:
        int r31 = 0;
    L160:
        if (r31 == 1) goto L164;
        if (r31 == r30) goto L163;
        String r32 = "dismiss";
    L165:
        s r33 = new s(DoraCallStateCode.DORA_OB_USER_END, r28, r32);
        Integer r35 = r34.e;
        if (r35 == null) goto L168;
        int r36 = r35.intValue();
    L169:
        Integer r210 = Integer.valueOf(r36);
        String r37 = r34.a;
        String r38 = r34.b;
        String r114 = r34.c;
        List r211 = CollectionsKt.listOfNotNull(r7);
        String r115 = r11.b();
        if (r115 != null) goto L172;
    L177:
        ns9.d r116 = null;
    L178:
        r1.a(new t(r20, r23, r33, new ns9.f(r210, r37, r38, r114, r211, CollectionsKt.listOfNotNull(r116)), new r(r16, r19)));
        r9 = true;
    L179:
        if (r9 == false) goto L181;
        return;
    L181:
        rc8.a.a.getClass();
        if (r34 == null) goto L398;
        e r39 = d.a(r34);
        if (r39 == null) goto L250;
        String r40 = r39.c();
        if (r40 == null) goto L248;
        String r41 = StringsKt.trim(r40).toString();
        if (r41 == null) goto L248;
        if ((!StringsKt.isBlank(r41)) == true) goto L195;
        r41 = null;
    L195:
        if (r41 == null) goto L248;
        if (Intrinsics.areEqual(r41, "-1") == true) goto L384;
        String r42 = OfflineMessageServiceDelegate.b.a(r41);
        if (r42 != null) goto L202;
    L247:
        String r43 = r41;
    L249:
        if (r43 == null) goto L250;
        f r44 = d.b(r39.f());
        String r45 = r39.h();
        if (r44 == null) goto L254;
        Integer r46 = r44.e();
    L255:
        if (r44 == null) goto L257;
        Integer r47 = r44.c();
    L258:
        if (r46 != null) goto L261;
    L262:
        if (r46 != null) goto L265;
    L267:
        int r48 = 0;
    L269:
        if (r46 != null) goto L272;
    L274:
        if (r47 != null) goto L277;
    L278:
        if (r47 != null) goto L281;
    L283:
        int r49 = 0;
    L285:
        Integer r50 = Integer.valueOf(r49);
        r50.intValue();
        rc8.a.a.getClass();
        if (r48 == 0) goto L307;
        if (r49 == 0) goto L307;
        if (r48 == 1) goto L295;
        int r51 = 3;
        if (r48 == 3) goto L294;
        Integer r117 = null;
    L296:
        if (r117 == null) goto L307;
        int r118 = r117.intValue();
        if (r49 == 1) goto L302;
        if (r49 == r51) goto L301;
        Integer r52 = null;
    L303:
        if (r52 == null) goto L307;
        if (r52.intValue() > r118) goto L307;
        boolean r53 = true;
    L308:
        if (r53 == false) goto L311;
        r50 = null;
    L311:
        if (r50 == null) goto L313;
        int r119 = r50.intValue();
    L315:
        if (r44 == null) goto L319;
        Long r54 = r44.a();
        if (r54 == null) goto L319;
        long r120 = r54.longValue();
    L320:
        if (r44 == null) goto L322;
        boolean r121 = Intrinsics.areEqual(r44.d(), Boolean.TRUE);
    L323:
        if (r44 == null) goto L325;
        Integer r55 = r44.b();
    L326:
        if (r55 != null) goto L329;
    L330:
        if (r55 != null) goto L333;
    L335:
        int r122 = 0;
    L337:
        if (r45 == null) goto L343;
        String r56 = StringsKt.trim(r45).toString();
        if (r56 == null) goto L343;
        Integer r57 = StringsKt.toIntOrNull(r56);
        if (r57 == null) goto L343;
        int r123 = r57.intValue();
    L344:
        h r124 = new h(r48, r119, r120, r121, r122, r123);
        BubbleBannerSource r58 = BubbleBannerSource.CMD;
        String r59 = r39.a();
        BubbleBannerStyle.a r60 = BubbleBannerStyle.Companion;
        Integer r61 = r34.e;
        r60.getClass();
        Iterator r62 = BubbleBannerStyle.getEntries().iterator();
    L346:
        if (r62.hasNext() == false) goto L356;
        Object r63 = r62.next();
        int r64 = ((BubbleBannerStyle) r63).getLayout();
        if (r61 != null) goto L351;
    L353:
        boolean r65 = false;
    L354:
        if (r65 == false) goto L346;
    L357:
        BubbleBannerStyle r66 = (BubbleBannerStyle) r63;
        if (r66 != null) goto L360;
        r66 = BubbleBannerStyle.access$getDEFAULT_STYLE$cp();
    L360:
        com.larus.bmhome.chat.bubble.floating.a r125 = new com.larus.bmhome.chat.bubble.floating.a(r66, r34.a, r34.b, r34.c, r39.b(), r34.d);
        String r67 = r39.i();
        if (r67 == null) goto L363;
        String r68 = StringsKt.trim(r67).toString();
    L364:
        pc8.c r126 = new pc8.c(r39.j(), r39.d(), r39.g(), d.c(r39.e()));
        a r69 = r34.g;
        if (r69 == null) goto L367;
        a r127 = new a(r69.getType(), r69.b);
    L368:
        pc8.d r70 = new pc8.d(r58, r43, r59, r125, r68, r124, r126, r127);
    L369:
        if (r70 == null) goto L399;
        Intrinsics.checkNotNullParameter(r70, "<this>");
        String r212 = UUID.randomUUID().toString();
        BubbleBannerState r213 = BubbleBannerState.RECEIVED;
        String r71 = pc8.g.a(r70);
        if (r71 == null) goto L374;
        int r72 = pc8.f.d;
        pc8.f r214 = pc8.f.a.a(r71);
    L375:
        final pc8.e r73 = new pc8.e(r212, r70, r213, r214, 0, false, false, false, null, null, null, SetsKt.emptySet());
        i.a.getClass();
        Intrinsics.checkNotNullParameter(r73, "prompt");
        final sc8.b r74 = pc8.g.b(r73);
        final List r75 = i.b(r73.b.c);
        i.c(new sc8.d(r75, r74, r73));
        if (Intrinsics.areEqual(r70.c, "notification_switch") == false) goto L380;
        uc8.a.a.getClass();
        if (uc8.a.a() == false) goto L380;
        return;
    L380:
        int r76 = k.a;
        Intrinsics.checkNotNullParameter(r73, "prompt");
        IBubbleBannerRuntimeService r77 = k.c();
        if (r77 == null) goto L397;
        r77.p(r73);
        return;
    L397:
        return;
    L374:
        r214 = null;
        goto L375
    L399:
        return;
    L367:
        r127 = null;
        goto L368
    L363:
        r68 = null;
        goto L364
    L351:
        if (r64 != r61.intValue()) goto L353;
        r65 = true;
        goto L354
    L356:
        r63 = null;
    L343:
        r123 = 0;
        goto L344
    L333:
        if (r55.intValue() != 2) goto L335;
    L336:
        r122 = r55.intValue();
        goto L337
    L329:
        if (r55.intValue() == 1) goto L336;
    L325:
        r55 = null;
        goto L326
    L322:
        r121 = false;
    L319:
        r120 = 0;
        goto L320
    L313:
        r119 = 0;
        goto L315
    L301:
        r52 = r10;
        goto L303
    L302:
        r52 = r113;
        goto L303
    L294:
        r117 = r10;
        goto L296
    L295:
        r51 = 3;
        r117 = r113;
    L307:
        r53 = false;
        goto L308
    L281:
        if (r47.intValue() != 3) goto L283;
    L284:
        r49 = r47.intValue();
        goto L285
    L277:
        if (r47.intValue() == 1) goto L284;
    L272:
        if (r46.intValue() != 2) goto L274;
        r49 = 3;
        goto L285
    L265:
        if (r46.intValue() != 3) goto L267;
    L268:
        r48 = r46.intValue();
        goto L269
    L261:
        if (r46.intValue() == 1) goto L268;
    L257:
        r47 = null;
        goto L258
    L254:
        r46 = null;
        goto L255
    L202:
        if ((!StringsKt.isBlank(r42)) == true) goto L205;
        r42 = null;
    L205:
        if (r42 == null) goto L247;
        r41 = r42;
        goto L247
    L384:
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        IFlowSdkDepend r79 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L241
        if (r79 == null) goto L212;
        r79.P();     // Catch: Throwable -> L241
        Fragment r80 = ChatServiceImpl.a.f();     // Catch: Throwable -> L241
    L214:
        if ((r80 instanceof xe8.a) == false) goto L216;
        xe8.a r81 = (xe8.a) r80;     // Catch: Throwable -> L241
    L217:
        if (r81 == null) goto L238;
        String r82 = r81.getConversationId();     // Catch: Throwable -> L241
        if (r82 == null) goto L238;
        if ((!StringsKt.isBlank(r82)) == true) goto L223;
    L225:
        boolean r83 = false;
    L226:
        if (r83 == true) goto L229;
        r82 = null;
    L229:
        if (r82 == null) goto L238;
        String r84 = OfflineMessageServiceDelegate.b.a(r82);     // Catch: Throwable -> L241
        if (r84 != null) goto L233;
    L239:
        Object r85 = Result.constructor-impl(r82);     // Catch: Throwable -> L241
    L244:
        if (Result.isFailure-impl(r85) == false) goto L246;
        r85 = null;
    L246:
        r41 = (String) r85;
        goto L247
    L233:
        if ((!StringsKt.isBlank(r84)) == true) goto L236;
        r84 = null;
    L236:
        if (r84 == null) goto L239;
        r82 = r84;
        goto L239
    L223:
        if (Intrinsics.areEqual(r82, "-1") == true) goto L225;
        r83 = true;
    L238:
        r82 = null;
        goto L239
    L216:
        r81 = null;
        goto L217
    L212:
        r80 = null;
    L241:
        th = move-exception;
        Result.Companion r86 = Result.Companion;
        r85 = Result.constructor-impl(ResultKt.createFailure(th));
    L248:
        r43 = null;
    L250:
        r70 = null;
        goto L369
    L398:
        return;
    L172:
        if ((!StringsKt.isBlank(r115)) == true) goto L175;
        r115 = null;
    L175:
        if (r115 == null) goto L177;
        r116 = new ns9.d(ReachButtonType.NORMAL, ReachButtonStyle.PRIMARY, r115, CollectionsKt.listOfNotNull(r7));
        goto L178
    L168:
        r36 = 1;
        goto L169
    L163:
        r32 = "none";
        goto L165
    L164:
        r32 = "keep";
        goto L165
    L153:
        r30 = 2;
        if (r29.intValue() != 2) goto L156;
    L158:
        r31 = r29.intValue();
        goto L160
    L150:
        if (r29.intValue() != 1) goto L151;
        r30 = 2;
        goto L158
    L146:
        r29 = null;
        goto L147
    L136:
        r27 = false;
    L143:
        r28 = null;
        goto L144
    L113:
        Map r87 = MapsKt.createMapBuilder();
        Integer r128 = r12.e();
        if (r128 != null) goto L116;
        r113 = 1;
    L119:
        Integer r88 = r12.e();
        if (r88 == null) goto L122;
        String r89 = (String) r87.put("show_timing", String.valueOf(r88.intValue()));
    L122:
        Integer r90 = r12.c();
        if (r90 == null) goto L125;
        String r91 = (String) r87.put("dismiss_timing", String.valueOf(r90.intValue()));
    L125:
        Boolean r92 = r12.d();
        if (r92 == null) goto L128;
        r87.put("keep_on_leave", String.valueOf(r92.booleanValue()));
    L128:
        r22 = MapsKt.build(r87);
        goto L129
    L116:
        r113 = 1;
        if (r128.intValue() != 2) goto L119;
        String r93 = (String) r87.put("dismiss_timing", "3");
        goto L125
    L109:
        r26 = r8;
        goto L110
    L99:
        if ((!StringsKt.isBlank(r6)) == true) goto L102;
        r6 = null;
    L102:
        if (r6 == null) goto L105;
        r7 = new b(1, MapsKt.mapOf(TuplesKt.to("schema", r6)));
        goto L106
    L57:
        if (r3.getType() == null) goto L64;
        Integer r94 = r3.getType();
        if (r94 != null) goto L62;
    L63:
        boolean r95 = true;
    L65:
        if (r95 == true) goto L68;
        r3 = null;
    L68:
        if (r3 == null) goto L96;
        Integer r96 = r3.getType();
        if (r96 == null) goto L95;
        int r97 = r96.intValue();
        if (r97 != 2) goto L84;
        Map<String, String> r99 = r3.b;
        if (r99 == null) goto L85;
        Map r129 = MapsKt.createMapBuilder();
        String r100 = r99.get("biz_req_id");
        if (r100 == null) goto L79;
        String r101 = (String) r129.put("biz_req_id", r100);
    L79:
        String r102 = r99.get("params");
        if (r102 == null) goto L82;
        r129.put("params", r102);
    L82:
        Map r103 = MapsKt.build(r129);
    L93:
        r7 = new b(r97, r103);
    L85:
        r103 = null;
        goto L93
    L84:
        if (r3.b == null) goto L85;
        Map r104 = MapsKt.createMapBuilder();
        Iterator r105 = r104.entrySet().iterator();
    L88:
        if (r105.hasNext() == false) goto L92;
        Map.Entry r106 = (Map.Entry) r105.next();
        String r130 = (String) r106.getKey();
        String r107 = (String) r106.getValue();
        if (r107 == null) goto L88;
        r104.put(r130, r107);
        goto L88
    L92:
        r103 = MapsKt.build(r104);
        goto L93
    L95:
        throw new IllegalStateException("Required value was null.".toString());
    L62:
        if (r94.intValue() != 0) goto L63;
    L64:
        r95 = false;
        goto L65
    L49:
        if ((!StringsKt.isBlank(r2)) == true) goto L52;
        r2 = null;
    L52:
        if (r2 == null) goto L54;
        r19.put("popup_scene", r2);
        goto L54
    L34:
        if ((!StringsKt.isBlank(r18)) == true) goto L37;
        r18 = null;
    L37:
        if (r18 == null) goto L39;
        r16.put("tracking_info", r18);
        goto L39
    L26:
        if ((!StringsKt.isBlank(r17)) == true) goto L29;
        r17 = null;
    L29:
        if (r17 == null) goto L31;
        r16.put("request_info", r17);
        goto L31
    L16:
        r15 = null;
    L12:
        r113 = 1;
        r10 = r10;
        goto L179
    }
}
