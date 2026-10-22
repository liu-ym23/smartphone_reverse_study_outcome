package com.larus.uaigc.chat.markdown.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverItem;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.utils.c4;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationMDCardClickHelper {
    public static final CreationMDCardClickHelper a = null;

    public static final class a implements VideoPlayView.a {
        public final /* synthetic */ iy9.b a;

        public a(iy9.b r1) {
            this.a = r1;
        }

        public final void a(String r3) {
            iy9.b r0 = this.a;
            if (r0 == null) goto L8;
            Function2<String, Boolean, Unit> r1 = r0.c;
            if (r1 == null) goto L9;
            r1.invoke(r3, Boolean.TRUE);
            return;
        L9:
            return;
        }

        public final void onPause(String r3) {
            iy9.b r0 = this.a;
            if (r0 == null) goto L8;
            Function2<String, Boolean, Unit> r1 = r0.c;
            if (r1 == null) goto L9;
            r1.invoke(r3, Boolean.FALSE);
            return;
        L9:
            return;
        }
    }

    static {
        a = new CreationMDCardClickHelper();
    }

    public CreationMDCardClickHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "transferred to block")
    public final Object a(String r49, View r50, View r51, String r52, String r53, Boolean r54, com.larus.bmhome.chat.api.q0.a r55, String r56, String r57, com.larus.bmhome.bigimg.e r58, CoroutineScope r59, com.larus.uaigc.chat.markdown.image.component.a r60, com.larus.uaigc.chat.markdown.image.component.k r61, iy9.b r62, Continuation<? super Unit> r63) {
        if ((r63 instanceof CreationMDCardClickHelper$onClickMDItem$1) == false) goto L7;
        CreationMDCardClickHelper$onClickMDItem$1 r1 = (CreationMDCardClickHelper$onClickMDItem$1) r63;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        String r12 = "";
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        int r5 = r1.I$0;
        long r13 = r1.J$0;
        Context r6 = (Context) r1.L$16;
        String r15 = (String) r1.L$15;
        CreationTask r11 = (CreationTask) r1.L$14;
        List r7 = (List) r1.L$13;
        List r8 = (List) r1.L$12;
        Map<String, CreationTask> r9 = (Map) r1.L$11;
        JSONObject r10 = (JSONObject) r1.L$10;
        Message r14 = (Message) r1.L$9;
        iy9.b r16 = (iy9.b) r1.L$8;
        com.larus.uaigc.chat.markdown.image.component.k r17 = (com.larus.uaigc.chat.markdown.image.component.k) r1.L$7;
        com.larus.uaigc.chat.markdown.image.component.a r18 = (com.larus.uaigc.chat.markdown.image.component.a) r1.L$6;
        CoroutineScope r19 = (CoroutineScope) r1.L$5;
        com.larus.bmhome.bigimg.e r20 = (com.larus.bmhome.bigimg.e) r1.L$4;
        String r21 = (String) r1.L$3;
        com.larus.bmhome.chat.api.q0.a r22 = (com.larus.bmhome.chat.api.q0.a) r1.L$2;
        View r23 = (View) r1.L$1;
        View r24 = (View) r1.L$0;
        ResultKt.throwOnFailure(r0);
        com.larus.uaigc.chat.markdown.image.component.k r110 = r17;
        String r25 = r21;
        com.larus.bmhome.chat.api.q0.a r26 = r22;
        View r29 = r23;
        iy9.b r27 = r16;
        r12 = "";
        com.larus.uaigc.chat.markdown.image.component.a r111 = r18;
        CoroutineScope r28 = r19;
        com.larus.bmhome.bigimg.e r112 = r20;
    L286:
        Map r30 = (Map) r0;
        if (k1.a(r24) == true) goto L409;
        CreationChatItemClickHelper r31 = CreationChatItemClickHelper.a;
        Intrinsics.checkNotNull(r6);
        if (r26 == null) goto L295;
        com.larus.bmhome.chat.api.q0 r113 = r26.e();
        if (r113 == null) goto L295;
        Function0 r114 = r113.getHostFragment();
        if (r114 == null) goto L295;
        Fragment r32 = (Fragment) r114.invoke();
    L296:
        jy9.x r115 = new jy9.x(r14, r26, r27, r25, null, r5, r28, null, r29, r32, null, null, null, null, false, false, null, null, null, null, null, null, null, 67105584);
        JSONObject r116 = r10;
        com.larus.uaigc.chat.markdown.image.component.a r410 = r111;
        if (r9 == null) goto L336;
        Collection<CreationTask> r33 = r9.values();
        if (r33 == null) goto L336;
        Collection<CreationTask> r34 = r33;
        ArrayList r35 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r34, 10));
        Iterator r36 = r34.iterator();
        int r117 = 0;
    L302:
        if (r36.hasNext() == false) goto L335;
        Object r210 = r36.next();
        int r211 = r117 + 1;
        if (r117 >= 0) goto L306;
        CollectionsKt.throwIndexOverflow();
    L306:
        CreationTask r118 = (CreationTask) r210;
        Iterator r510 = r36;
        String r511 = r15;
        Pair[] r119 = new Pair[4];
        long r512 = r13;
        r119[0] = TuplesKt.to("position", Boxing.boxInt(r211));
        if (r118 == null) goto L316;
        CreationAsset r37 = r118.asset;
        if (r37 == null) goto L316;
        UserCreationImage r38 = r37.imageContent;
        if (r38 == null) goto L316;
        ImageInfo r39 = r38.a;
        if (r39 == null) goto L316;
        String r40 = r39.e;
        if (r40 == null) goto L316;
    L317:
        r119[1] = TuplesKt.to("pic_id", r40);
        if (r118 == null) goto L327;
        CreationAsset r41 = r118.asset;
        if (r41 == null) goto L327;
        UserCreationImage r42 = r41.imageContent;
        if (r42 == null) goto L327;
        ImageInfo r43 = r42.a;
        if (r43 == null) goto L327;
        String r44 = r43.f;
        if (r44 == null) goto L327;
    L328:
        r119[2] = TuplesKt.to("request_id", r44);
        if (r118 == null) goto L331;
        String r45 = r118.id;
    L332:
        if (r45 != null) goto L334;
        r45 = r12;
    L334:
        r119[3] = TuplesKt.to("creation_task_id", r45);
        Map r46 = MapsKt.mutableMapOf(r119);
        r46.put("is_feely_img", "0");
        r35.add(r46);
        r36 = r510;
        r15 = r511;
        r13 = r512;
        r117 = r211;
        goto L302
    L331:
        r45 = null;
    L327:
        r44 = r12;
    L316:
        r40 = r12;
        goto L317
    L335:
        long r513 = r13;
        String r514 = r15;
    L337:
        uo8.k r47 = new uo8.k(r30, r35);
        Integer r48 = r11.taskType;
        if (r48 != null) goto L341;
    L343:
        if (r48 != null) goto L346;
    L348:
        if (r48 != null) goto L351;
    L353:
        if (r48 != null) goto L356;
    L358:
        int r310 = 2;
    L359:
        r31.getClass();
        CreationChatItemClickHelper.r(r6, r5, r14, r7, r8, r30, r47, r310, r513, null, r514, r112, r28, r410, r110, r115);
        Integer r64 = r11.loadingAssetType;
        if (r64 != null) goto L363;
    L373:
        String r120 = r514;
        com.larus.platform.service.o r65 = com.larus.platform.service.o.a;
        JSONObject r66 = new JSONObject();
        if (r120 != null) goto L376;
        r120 = r12;
    L376:
        r66.put("bot_id", r120);
        r66.put("message_id", r14.getMessageId());
        r66.put("conversation_id", r14.getConversationId());
        r66.put("user_type", "bot");
        r66.put("pic_position", String.valueOf(r5 + 1));
        CreationAsset r67 = r11.asset;
        if (r67 == null) goto L383;
        UserCreationImage r68 = r67.imageContent;
        if (r68 == null) goto L383;
        ImageInfo r69 = r68.a;
        if (r69 == null) goto L383;
        String r70 = r69.e;
    L384:
        r66.put("pic_id", r70);
        CreationAsset r71 = r11.asset;
        if (r71 == null) goto L394;
        UserCreationImage r72 = r71.imageContent;
        if (r72 == null) goto L394;
        ImageInfo r73 = r72.a;
        if (r73 == null) goto L394;
        String r74 = r73.f;
        if (r74 == null) goto L394;
        String r121 = r74;
    L395:
        r66.put("request_id", r121);
        r66.put("is_onboarding", 0);
        Object r75 = r30.get("recommend_from");
        if (r75 == null) goto L398;
        r66.put("recommend_from", r75);
    L398:
        Object r76 = r30.get("template_rec_extra");
        if (r76 == null) goto L401;
        r66.put("template_rec_extra", r76);
    L401:
        Object r77 = r30.get("template_rec_req_id");
        if (r77 == null) goto L404;
        r66.put("template_rec_req_id", r77);
    L404:
        Object r78 = r30.get("from_template_id");
        if (r78 == null) goto L407;
        r66.put("from_template_id", r78);
        Unit r79 = Unit.INSTANCE;
    L407:
        Unit r80 = Unit.INSTANCE;
        r65.reportEvent("picture_message_click", r66);
    L394:
        r121 = r12;
    L383:
        r70 = null;
        goto L384
    L363:
        if (r64.intValue() != 7) goto L373;
        CreationAsset r81 = r11.asset;
        if (r81 == null) goto L371;
        ep8.a r82 = r81.videoContent;
        if (r82 == null) goto L371;
        AiGenVideoContentData r83 = r82.videoInfo;
        if (r83 == null) goto L371;
        String r122 = r83.getVid();
    L372:
        a4.c(r122, r14.getMessageId(), r514, r116);
    L371:
        r122 = null;
        goto L372
    L356:
        if (r48.intValue() != 2) goto L358;
        r310 = 5;
        goto L359
    L351:
        if (r48.intValue() != 6) goto L353;
        r310 = 6;
        goto L359
    L346:
        if (r48.intValue() != 7) goto L348;
        r310 = 4;
        goto L359
    L341:
        if (r48.intValue() != 5) goto L343;
        r310 = 3;
    L336:
        r513 = r13;
        r514 = r15;
        r35 = null;
    L295:
        r32 = null;
    L409:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r84 = r1.J$0;
        Message r85 = (Message) r1.L$13;
        iy9.b r86 = (iy9.b) r1.L$12;
        com.larus.uaigc.chat.markdown.image.component.k r87 = (com.larus.uaigc.chat.markdown.image.component.k) r1.L$11;
        com.larus.uaigc.chat.markdown.image.component.a r88 = (com.larus.uaigc.chat.markdown.image.component.a) r1.L$10;
        CoroutineScope r89 = (CoroutineScope) r1.L$9;
        com.larus.bmhome.bigimg.e r123 = (com.larus.bmhome.bigimg.e) r1.L$8;
        String r124 = (String) r1.L$7;
        final com.larus.bmhome.chat.api.q0.a r125 = (com.larus.bmhome.chat.api.q0.a) r1.L$6;
        Boolean r126 = (Boolean) r1.L$5;
        String r127 = (String) r1.L$4;
        String r90 = (String) r1.L$3;
        View r91 = (View) r1.L$2;
        View r92 = (View) r1.L$1;
        String r93 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        iy9.b r94 = r86;
        r12 = "";
        Boolean r515 = r126;
        final Message r128 = r85;
        final View r95 = r92;
        com.larus.bmhome.bigimg.e r129 = r123;
        String r516 = r127;
        CoroutineScope r130 = r89;
        long r96 = r84;
        com.larus.uaigc.chat.markdown.image.component.k r97 = r87;
        com.larus.uaigc.chat.markdown.image.component.a r98 = r88;
        View r99 = r91;
        String r517 = r90;
    L26:
        JSONObject r100 = (JSONObject) r0;
        if (r128 == null) goto L29;
        CreationMsgContentData r101 = dp8.e.c(r128);
    L30:
        Map<String, CreationTask> r102 = j0.c(r101);
        ArrayList r131 = new ArrayList();
        if (r102 == null) goto L220;
        Collection<CreationTask> r212 = r102.values();
        if (r212 == null) goto L220;
        ArrayList r103 = new ArrayList();
        Iterator<T> r311 = r212.iterator();
        int r213 = 0;
    L36:
        if (r311.hasNext() == false) goto L219;
        Object r214 = r311.next();
        int r312 = r213 + 1;
        if (r213 >= 0) goto L40;
        CollectionsKt.throwIndexOverflow();
    L40:
        com.larus.uaigc.chat.markdown.image.component.a r518 = r98;
        final CreationTask r104 = (CreationTask) r214;
        if (r104 == null) goto L43;
        Integer r132 = r104.loadingAssetType;
    L44:
        if (r132 != null) goto L46;
        com.larus.bmhome.bigimg.e r610 = r129;
    L131:
        if (r104 == null) goto L214;
        CreationAsset r105 = r104.asset;
        if (r105 == null) goto L214;
        UserCreationImage r106 = r105.imageContent;
        if (r106 == null) goto L214;
        ImageInfo r107 = r106.a;
        if (r107 == null) goto L214;
        CreationNoWatermarkManager r108 = CreationNoWatermarkManager.a;
        r108.getClass();
        ImageInfo r109 = (ImageInfo) r108.U(CreationNoWatermarkManager.t0(r107), r107, true).a;
        if (r109 != null) goto L141;
        r109 = r107;
    L141:
        Image r133 = r109.c;
        if (r133 == null) goto L144;
        String r215 = r133.a;
    L145:
        Image r134 = r109.a;
        if (r134 == null) goto L148;
        String r216 = r134.a;
    L149:
        Image r135 = r109.i;
        if (r135 == null) goto L152;
        String r217 = r135.a;
    L153:
        if (r128 != null) goto L155;
    L157:
        boolean r136 = false;
    L158:
        if (r136 == true) goto L163;
        Image r137 = r109.d;
        if (r137 == null) goto L163;
        String r218 = r137.a;
    L164:
        Image r138 = r109.a;
        if (r138 == null) goto L167;
        Long r219 = Boxing.boxLong(r138.c);
    L168:
        Image r139 = r109.a;
        if (r139 == null) goto L171;
        Long r220 = Boxing.boxLong(r139.d);
    L172:
        n1 r140 = new n1(r215, r216, r217, r218, r219, r220);
        Integer r141 = r104.index;
        if (r141 == null) goto L175;
        r213 = r141.intValue();
    L175:
        String r221 = String.valueOf(r213);
        Image r142 = r107.a;
        if (r142 == null) goto L184;
        String r143 = r142.e;
        if (r143 == null) goto L184;
        if ((!StringsKt.isBlank(r143)) == true) goto L183;
        r143 = null;
    L183:
        if (r143 == null) goto L184;
    L212:
        String r313 = r143;
    L213:
        r131.add(new zo8.b(r140, "", r221, null, false, false, null, null, r313, 248));
    L215:
        ArrayList r144 = r103;
        if (r140 == null) goto L218;
        r144.add(r140);
    L218:
        r93 = r93;
        r98 = r518;
        r130 = r130;
        r129 = r610;
        r99 = r99;
        r103 = r144;
        r213 = r312;
        r1 = r1;
        r100 = r100;
        r102 = r102;
    L184:
        Image r145 = r107.c;
        if (r145 == null) goto L191;
        r143 = r145.e;
        if (r143 == null) goto L191;
        if ((!StringsKt.isBlank(r143)) == false) goto L191;
    L192:
        if (r143 != null) goto L212;
        Image r146 = r107.b;
        if (r146 == null) goto L200;
        r143 = r146.e;
        if (r143 == null) goto L200;
        if ((!StringsKt.isBlank(r143)) == false) goto L200;
    L201:
        if (r143 != null) goto L212;
        Image r147 = r107.i;
        if (r147 == null) goto L209;
        r143 = r147.e;
        if (r143 == null) goto L209;
        if ((!StringsKt.isBlank(r143)) == false) goto L209;
    L210:
        if (r143 != null) goto L212;
        r313 = r107.e;
    L209:
        r143 = null;
    L200:
        r143 = null;
    L191:
        r143 = null;
        goto L192
    L171:
        r220 = null;
        goto L172
    L167:
        r219 = null;
    L163:
        r218 = null;
        goto L164
    L155:
        if (ap8.a.c(r128) != true) goto L157;
        r136 = true;
        goto L158
    L152:
        r217 = null;
        goto L153
    L148:
        r216 = null;
        goto L149
    L144:
        r215 = null;
    L214:
        r140 = null;
        goto L215
    L46:
        r610 = r129;
        if (r132.intValue() != 7) goto L131;
        CreationAsset r148 = r104.asset;
        if (r148 == null) goto L129;
        ep8.a r149 = r148.videoContent;
        if (r149 == null) goto L129;
        AiGenVideoContentData r150 = r149.videoInfo;
        if (r150 == null) goto L129;
        CreationNoWatermarkManager r151 = CreationNoWatermarkManager.a;
        r99 = r99;
        String r152 = r150.getVid();
        CoverItem r222 = r150.getVideoCover();
        if (r222 == null) goto L57;
        String r153 = r222.getKey();
    L58:
        AiGenVideoContentData r154 = r151.a0(r152, r150, r153);
        if (r154 != null) goto L61;
        r154 = r150;
    L61:
        String r155 = r12;
        n1 r156 = new n1(r155, r155);
        String r157 = r104.id;
        Integer r158 = r104.index;
        if (r158 == null) goto L64;
        r213 = r158.intValue();
    L64:
        String r159 = String.valueOf(r213);
        if (r125 == null) goto L69;
        com.larus.bmhome.chat.component.cvs.y r223 = r125.u0();
        if (r223 == null) goto L69;
        String r224 = r223.getBotId();
    L70:
        if (r128 == null) goto L72;
        String r225 = r128.getMessageId();
    L74:
        if (r125 == null) goto L78;
        com.larus.bmhome.chat.component.cvs.y r226 = r125.u0();
        if (r226 == null) goto L78;
        BotModel r227 = r226.j0();
    L79:
        if (r125 == null) goto L83;
        com.larus.bmhome.chat.component.cvs.y r228 = r125.u0();
        if (r228 == null) goto L83;
        wc9.e r229 = r228.h();
    L84:
        r93 = r93;
        String r160 = r104.id;
        Integer r230 = Boxing.boxInt(r312);
        if (r128 == null) goto L87;
        String r314 = tz9.a.a(r128);
    L88:
        if (r128 == null) goto L90;
        Boolean r315 = Boxing.boxBoolean(com.larus.im.bean.message.a.C0(r128));
    L91:
        c4 r316 = new c4(r224, r225, "chat", r227, r229, "click", "0", r160, r230, r314, r315, r128, r100, null, 8192);
        if (Intrinsics.areEqual(r124, r104.id) == false) goto L97;
        if (r94 == null) goto L97;
        Long r161 = r94.d;
        if (r161 == null) goto L97;
        Integer r162 = Boxing.boxInt((int) r161.longValue());
    L98:
        if (r162 == null) goto L100;
        int r231 = r162.intValue();
        r103 = r103;
    L117:
        int r163 = hz9.a.a;
        String r232 = hz9.a.b(r128, r104.id, true, 8);
        a r164 = new a(r94);
        boolean r233 = z2.a.getCreationExtendVideoConfig().b();
        nr9.g r165 = ff8.a.a(r154);
        if (Intrinsics.areEqual(r124, r104.id) == false) goto L125;
        nr9.f r166 = r165.g;
        if (r166 == null) goto L125;
        if (r94 == null) goto L123;
        Bitmap r167 = r94.e;
    L124:
        r166.f = r167;
        Unit r168 = Unit.INSTANCE;
        goto L125
    L123:
        r167 = null;
    L125:
        if (r94 == null) goto L127;
        Function2<String, IVideoController, Unit> r234 = r94.b;
    L128:
        r131.add(new zo8.e(r159, r316, r165, r231, r232, r164, r234, r233, new b0(), new c0(r95, r128, r104, r125), r157, false, false, 6144));
        r140 = r156;
        goto L215
    L127:
        r234 = null;
        goto L128
    L100:
        ps8.a r169 = IAIChatUgcAIGCService.a.L();
        int r170 = hz9.a.a;
        r103 = r103;
        IVideoController r171 = r169.a(hz9.a.b(r128, r104.id, false, 12), "ugc_video", "message_card");
        if (r171 == null) goto L103;
        Integer r172 = Boxing.boxInt(r171.getCurrentPlaybackTime());
    L104:
        if (r172 != null) goto L115;
        if (r94 == null) goto L113;
        Function1<String, Integer> r173 = r94.a;
        if (r173 == null) goto L113;
        String r174 = r150.getVid();
        if (r174 != null) goto L112;
        r174 = r12;
    L112:
        r172 = (Integer) r173.invoke(r174);
    L114:
        if (r172 != null) goto L115;
        r231 = 0;
    L113:
        r172 = null;
    L115:
        r231 = r172.intValue();
        goto L117
    L103:
        r172 = null;
    L97:
        r162 = null;
        goto L98
    L90:
        r315 = null;
        goto L91
    L87:
        r314 = null;
    L83:
        r229 = null;
    L78:
        r227 = null;
        goto L79
    L72:
        r225 = null;
    L69:
        r224 = null;
        goto L70
    L57:
        r153 = null;
    L129:
        r1 = r1;
        r93 = r93;
        r103 = r103;
        r99 = r99;
        r100 = r100;
        r102 = r102;
        goto L214
    L43:
        r132 = null;
        goto L44
    L219:
        CreationMDCardClickHelper$onClickMDItem$1 r317 = r1;
        String r519 = r93;
        com.larus.uaigc.chat.markdown.image.component.a r520 = r98;
        View r611 = r99;
        JSONObject r411 = r100;
        Map<String, CreationTask> r412 = r102;
        com.larus.bmhome.bigimg.e r612 = r129;
        CoroutineScope r613 = r130;
        ArrayList r175 = r103;
    L222:
        if (r412 == null) goto L236;
        Set<String> r176 = r412.keySet();
        if (r176 == null) goto L236;
        Iterator<T> r177 = r176.iterator();
        int r178 = 0;
    L227:
        if (r177.hasNext() == false) goto L235;
        Object r179 = r177.next();
        if (r178 >= 0) goto L232;
        CollectionsKt.throwIndexOverflow();
    L232:
        if (Intrinsics.areEqual(r124, (String) r179) == true) goto L237;
        r178 = r178 + 1;
    L237:
        if (r101 == null) goto L243;
        CreationInfo r180 = r101.creationInfo;
        if (r180 == null) goto L243;
        Map r181 = r180.taskInfo;
        if (r181 == null) goto L243;
        CreationTask r182 = (CreationTask) r181.get(r124);
    L244:
        if (r178 == (-1)) goto L410;
        if (r182 == null) goto L252;
        Integer r183 = r182.status;
        if (r183 == null) goto L252;
        if (r183.intValue() != 4) goto L252;
        boolean r184 = true;
    L253:
        if (r184 == false) goto L410;
        Result.Companion r185 = Result.Companion;     // Catch: Throwable -> L257
        FLogger.a.i(r519, "onClickItem, hide ime");     // Catch: Throwable -> L257
        com.larus.utils.e1.p(r95);     // Catch: Throwable -> L257
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L257
    L259:
        if (r125 == null) goto L263;
        com.larus.bmhome.chat.component.cvs.y r186 = r125.u0();
        if (r186 == null) goto L263;
        r15 = r186.getBotId();
    L264:
        Context r187 = r95.getContext();
        CreationChatItemClickHelper r188 = CreationChatItemClickHelper.a;
        if (r125 == null) goto L269;
        com.larus.bmhome.chat.component.cvs.y r189 = r125.u0();
        if (r189 == null) goto L269;
        BotModel r190 = r189.j0();
    L270:
        if (r125 == null) goto L274;
        com.larus.bmhome.chat.component.cvs.y r191 = r125.u0();
        if (r191 == null) goto L274;
        wc9.e r192 = r191.h();
    L275:
        if (r125 == null) goto L281;
        u7 r193 = r125.u3();
        if (r193 == null) goto L281;
        MessageAdapter r194 = r193.MF();
        if (r194 == null) goto L281;
        List r195 = r194.getCurrentList();
    L282:
        r317.L$0 = r95;
        View r235 = r95;
        r317.L$1 = r611;
        r317.L$2 = r125;
        r317.L$3 = r124;
        r317.L$4 = r612;
        r317.L$5 = r613;
        r317.L$6 = r520;
        com.larus.uaigc.chat.markdown.image.component.k r196 = r97;
        r317.L$7 = r196;
        r317.L$8 = r94;
        r317.L$9 = r128;
        iy9.b r521 = r94;
        r317.L$10 = r411;
        r317.L$11 = r412;
        r317.L$12 = r131;
        r317.L$13 = r175;
        r317.L$14 = r182;
        r317.L$15 = r15;
        r317.L$16 = r187;
        ArrayList r236 = r175;
        long r197 = r96;
        r317.J$0 = r197;
        r317.I$0 = r178;
        r317.label = 3;
        Object r198 = CreationChatItemClickHelper.l(r188, r128, r517, r516, r515, r190, r192, r195, r317);
        if (r198 != r3) goto L285;
        return r3;
    L285:
        r27 = r521;
        r29 = r611;
        r5 = r178;
        r8 = r131;
        r25 = r124;
        r14 = r128;
        r110 = r196;
        r9 = r412;
        r111 = r520;
        r112 = r612;
        r6 = r187;
        r0 = r198;
        r11 = r182;
        r26 = r125;
        r24 = r235;
        r28 = r613;
        r13 = r197;
        r7 = r236;
        r10 = r411;
    L281:
        r195 = null;
    L274:
        r192 = null;
    L269:
        r190 = null;
    L263:
        r15 = null;
    L257:
        th = move-exception;
        Result.Companion r199 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L252:
        r184 = false;
    L410:
        String r200 = r519;
        FLogger r201 = FLogger.a;
        StringBuilder r202 = new StringBuilder("onClickItem, taskStatus: ");
        if (r182 == null) goto L413;
        Integer r1100 = r182.status;
    L414:
        r202.append(r1100);
        r201.e(r200, r202.toString());
        return Unit.INSTANCE;
    L413:
        r1100 = null;
    L243:
        r182 = null;
        goto L244
    L235:
        r178 = -1;
    L236:
        r178 = 0;
    L220:
        r317 = r1;
        r519 = r93;
        r520 = r98;
        r611 = r99;
        r411 = r100;
        r412 = r102;
        r612 = r129;
        r613 = r130;
        r175 = null;
        goto L222
    L29:
        r101 = null;
        goto L30
    L17:
        long r203 = r1.J$0;
        iy9.b r204 = (iy9.b) r1.L$12;
        com.larus.uaigc.chat.markdown.image.component.k r205 = (com.larus.uaigc.chat.markdown.image.component.k) r1.L$11;
        com.larus.uaigc.chat.markdown.image.component.a r206 = (com.larus.uaigc.chat.markdown.image.component.a) r1.L$10;
        CoroutineScope r207 = (CoroutineScope) r1.L$9;
        com.larus.bmhome.bigimg.e r208 = (com.larus.bmhome.bigimg.e) r1.L$8;
        String r1101 = (String) r1.L$7;
        com.larus.bmhome.chat.api.q0.a r1102 = (com.larus.bmhome.chat.api.q0.a) r1.L$6;
        Boolean r1103 = (Boolean) r1.L$5;
        String r1104 = (String) r1.L$4;
        String r1105 = (String) r1.L$3;
        View r209 = (View) r1.L$2;
        View r237 = (View) r1.L$1;
        String r238 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        Object r1106 = r0;
        long r1107 = r203;
        com.larus.uaigc.chat.markdown.image.component.k r239 = r205;
        com.larus.uaigc.chat.markdown.image.component.a r240 = r206;
        iy9.b r241 = r204;
        r99 = r209;
        r95 = r237;
        r130 = r207;
        String r242 = r1105;
        r129 = r208;
        String r243 = r1104;
        String r1108 = r1101;
        Boolean r1109 = r1103;
    L22:
        r128 = (Message) r1106;
        CreationChatItemClickHelper r1110 = CreationChatItemClickHelper.a;
        r1.L$0 = r238;
        r1.L$1 = r95;
        r1.L$2 = r99;
        r1.L$3 = r242;
        r1.L$4 = r243;
        r1.L$5 = r1109;
        r1.L$6 = r1102;
        r1.L$7 = r1108;
        r1.L$8 = r129;
        r1.L$9 = r130;
        r1.L$10 = r240;
        r1.L$11 = r239;
        r1.L$12 = r241;
        r1.L$13 = r128;
        com.larus.uaigc.chat.markdown.image.component.k r413 = r239;
        iy9.b r522 = r241;
        long r244 = r1107;
        r1.J$0 = r244;
        String r1111 = r238;
        r1.label = 2;
        r1110.getClass();
        Object r245 = CreationChatItemClickHelper.n(r128, r1);
        if (r245 != r3) goto L25;
        return r3;
    L25:
        r517 = r242;
        r516 = r243;
        r515 = r1109;
        r94 = r522;
        r96 = r244;
        r97 = r413;
        r98 = r240;
        r0 = r245;
        r93 = r1111;
        String r414 = r1108;
        r125 = r1102;
        r124 = r414;
        goto L26
    L18:
        ResultKt.throwOnFailure(r0);
        long r246 = System.currentTimeMillis();
        CreationChatItemClickHelper r247 = CreationChatItemClickHelper.a;
        r1.L$0 = r49;
        r95 = r50;
        r1.L$1 = r95;
        r99 = r51;
        r1.L$2 = r99;
        r242 = r52;
        r1.L$3 = r242;
        r243 = r53;
        r1.L$4 = r243;
        r1109 = r54;
        r1.L$5 = r1109;
        r1102 = r55;
        r1.L$6 = r1102;
        r1108 = r57;
        r1.L$7 = r1108;
        r129 = r58;
        r1.L$8 = r129;
        r130 = r59;
        r1.L$9 = r130;
        r1.L$10 = r60;
        r1.L$11 = r61;
        r1.L$12 = r62;
        r1.J$0 = r246;
        r1.label = 1;
        r247.getClass();
        Object r248 = CreationChatItemClickHelper.m(r56, r1);
        if (r248 != r3) goto L21;
        return r3;
    L21:
        r238 = r49;
        r1106 = r248;
        r1107 = r246;
        r240 = r60;
        r239 = r61;
        r241 = r62;
    L7:
        r1 = new CreationMDCardClickHelper$onClickMDItem$1(this, r63);
        goto L8
    }
}
