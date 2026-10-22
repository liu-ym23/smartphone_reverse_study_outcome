package com.larus.bmhome.chat.list.cell.prompt;

import android.app.Activity;
import android.net.Uri;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.api.b0$a;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.bean.SuggestActionType;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.model.repo.u1$a;
import com.larus.bmhome.instruction.suggest.IPromptSelectActionDispatcherService;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import zb8.e$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x implements Function4 {
    public final /* synthetic */ PromptCell a;
    public final /* synthetic */ Message b;

    public /* synthetic */ x(PromptCell r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r85, Object r86, Object r87, Object r88) {
        PromptCell r15 = this.a;
        Message r14 = this.b;
        View r13 = (View) r85;
        PromptContent.SuggestV2 r12 = (PromptContent.SuggestV2) r86;
        PromptContent.SuggestItem r11 = (PromptContent.SuggestItem) r87;
        PromptContent.SuggestV2ExtraForMultiAction r10 = (PromptContent.SuggestV2ExtraForMultiAction) r88;
        Keva r1 = PromptCell.Y;
        Intrinsics.checkNotNullParameter(r13, "view");
        if (r15.D().f == true) goto L522;
        com.larus.bmhome.chat.component.cvs.y r2 = r15.z();
        if (r2 == null) goto L12;
        BotModel r3 = r2.j0();
        if (r3 == null) goto L12;
        if (r3.getDisabled() != true) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L16;
        return Unit.INSTANCE;
    L16:
        if (r12 == null) goto L23;
        Integer r5 = r12.getSuggestType();
        if (r5 == null) goto L23;
        if (r5.intValue() != 3) goto L23;
        boolean r6 = true;
    L24:
        String r7 = null;
        if (r6 == false) goto L46;
        com.bytedance.router.i r8 = SmartRouter.buildRoute(r13.getContext(), "//flow/deep_search");
        String r9 = r14.getMessageId();
        if (r9 == null) goto L29;
        String r16 = com.larus.bmhome.social.userchat.model.b0.d(r9);
    L30:
        r8.j("deep_search_from_id", r16);
        r8.j("argConversationId", r14.getConversationId());
        com.larus.bmhome.chat.api.q0 r17 = lf8.a.b(r15);
        if (r17 == null) goto L37;
        com.larus.bmhome.chat.api.q0.a r18 = r17.getProvider();
        if (r18 == null) goto L37;
        com.larus.bmhome.chat.component.cvs.y r19 = r18.u0();
        if (r19 == null) goto L37;
        String r20 = r19.getBotId();
    L38:
        r8.j("bot_id", r20);
        r8.j("enter_from", "suggest_prompt");
        r8.d = 2130772401;
        r8.e = 2130772399;
        r8.d();
        de8.c r21 = r15.y();
        if (r21 == null) goto L41;
        String r22 = r21.p();
    L42:
        String r23 = r14.getMessageId();
        String r24 = r14.getConversationId();
        com.larus.bmhome.chat.component.cvs.y r25 = r15.z();
        if (r25 == null) goto L45;
        r7 = r25.getBotId();
    L45:
        sf8.n.a(r22, r23, r24, r7);
        return Unit.INSTANCE;
    L41:
        r22 = null;
    L37:
        r20 = null;
        goto L38
    L29:
        r16 = null;
        goto L30
    L46:
        if (r12 == null) goto L53;
        Integer r26 = r12.getSuggestType();
        if (r26 == null) goto L53;
        if (r26.intValue() != 4) goto L53;
        boolean r27 = true;
    L54:
        if (r27 == false) goto L63;
        Object r28 = r13.getParent();
        if ((r28 instanceof View) == false) goto L58;
        View r29 = (View) r28;
    L59:
        if (r29 == null) goto L62;
        PromptCell.L(r15, r14, r29, null, null, null, null, null, null, null, r12.getContent(), null, new PromptContent.SuggestV2ExtraForMultiAction(SuggestActionType.AI_PODCAST, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null), null, null, 13816);
        Unit r30 = Unit.INSTANCE;
    L62:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r15), Dispatchers.getIO(), null, new PromptCell$bindList$10$2(r14, r13, r15, r12, null), 2, null);
        return Unit.INSTANCE;
    L58:
        r29 = null;
        goto L59
    L63:
        String r110 = "";
        if (Intrinsics.areEqual(r14.getBizContentType(), "deep_search_card") == false) goto L109;
        if ((r13 instanceof TextView) == false) goto L68;
        TextView r31 = (TextView) r13;
    L69:
        if (r31 == null) goto L526;
        CharSequence r32 = r31.getText();
        if (r32 == null) goto L74;
        String r33 = r32.toString();
    L75:
        String r34 = r14.getConversationId();
        if (r34 != null) goto L78;
        String r210 = "";
    L79:
        com.larus.bmhome.chat.model.repo.u1 r111 = zh8.a.a.getSender();
        if (r33 != null) goto L82;
        String r112 = "";
    L83:
        u1$a.f(r111, r112, r210, "deep_search_prompt", null, null, null, UUID.randomUUID().toString(), false, null, "DeepSearchFragment#suggestPromptCell", null, r15.w(), null, false, 27000);
        PromptCell.L(r15, r14, r31, null, null, null, null, null, null, null, r31.getText().toString(), null, null, r12, null, 11768);
        Fragment r35 = lf8.a.d(r15);
        if (r35 == null) goto L86;
        Object r36 = r35.getActivity();
    L88:
        if ((r36 instanceof com.larus.bmhome.chat.deepsearch.n) == false) goto L90;
        Object r37 = (com.larus.bmhome.chat.deepsearch.n) r36;
    L91:
        if (r37 == null) goto L93;
        ((Activity) r37).finish();
        Unit r38 = Unit.INSTANCE;
    L93:
        Iterator r39 = AppHost.a.a().g().iterator();
    L95:
        if (r39.hasNext() == false) goto L527;
        d4 r40 = (Activity) r39.next();
        if ((r40 instanceof d4) == false) goto L99;
        d4 r41 = r40;
    L100:
        if (r41 == null) goto L95;
        t1a.b r42 = r41.getVContext();
        if (r42 == null) goto L95;
        u7 r43 = r42.getAbility(u7.class);
        if (r43 == null) goto L95;
        r43.w70();
        r43.TP(false);
        Unit r44 = Unit.INSTANCE;
        goto L95
    L99:
        r41 = null;
        goto L100
    L527:
        return Unit.INSTANCE;
    L90:
        r37 = null;
        goto L91
    L86:
        r36 = null;
        goto L88
    L82:
        r112 = r33;
        goto L83
    L78:
        r210 = r34;
        goto L79
    L74:
        r33 = null;
        goto L75
    L526:
        return Unit.INSTANCE;
    L68:
        r31 = null;
        goto L69
    L109:
        if (com.larus.bmhome.chat.bean.d.z0(r14) == true) goto L111;
        PromptContent.SuggestV2 r113 = r12;
        Message r114 = r14;
        SearchMobParam r45 = null;
        String r46 = com.larus.bmhome.chat.bean.d.f1(r114, r113, null);
    L114:
        PromptCell r47 = r15;
    L124:
        String r48 = r46;
    L126:
        Pair<Integer, Integer> r49 = y0.a(r13);
        SearchMobParam r50 = r47.e;
        if (r50 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r50 = r45;
    L130:
        if (r50.g == false) goto L132;
        Object r51 = r49.getSecond();
    L133:
        int r52 = ((Number) r51).intValue() + 1;
        if (r47.U == null) goto L139;
        SearchMobParam r53 = r47.e;
        if (r53 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r53 = r45;
    L138:
        SearchMobParam r54 = i1.c(r114, r11, r53, false);
    L140:
        int r55 = e1.l;
        e1 r56 = e1.a.a(r11, r114, r54, r52);
        if (r11 == null) goto L143;
        SearchMobParam r57 = r11.getItemType();
    L144:
        PromptContent.SuggestItemType r58 = PromptContent.SuggestItemType.Bot;
        if (Intrinsics.areEqual(r57, r58.getValue()) == false) goto L147;
    L334:
        e1 r115 = r56;
        String r89 = r48;
        PromptCell r59 = r47;
        PromptContent.SuggestV2ExtraForMultiAction r510 = r10;
        PromptContent.SuggestItem r810 = r11;
        PromptContent.SuggestV2 r60 = r113;
        Message r410 = r114;
        View r811 = r13;
        Parcelable r61 = new RecommendFrom(r89, com.larus.im.bean.message.a.x(r410), r89);
        String r62 = r810.getSchema();
        if (r62 == null) goto L337;
        String r63 = StringsKt.replace$default(r62, "//flow/chat", "//flow/chat_loading", false, 4, null);
    L339:
        if (z2.a.S3().a() == true) goto L341;
    L343:
        String r64 = null;
    L344:
        com.bytedance.router.i r65 = SmartRouter.buildRoute(lf8.a.getContext(r59), r63);
        r65.j("auto_send_text", r64);
        r65.j("argPreviousPage", "chat");
        r65.j("enter_method", r89);
        r65.c.putExtra("argBotRecommendFrom", r61);
        r65.d();
        PromptCell.L(r59, r410, r811, null, null, null, null, null, null, null, r810.getSuggest(), null, null, r60, null, 11768);
    L345:
        boolean r66 = true;
    L346:
        boolean r67 = r66;
        boolean r68 = true;
    L348:
        if (com.larus.bmhome.chat.bean.d.W0(r410) == false) goto L363;
        if (r68 == false) goto L353;
        PromptContent.SuggestItem r116 = r810;
        Message r117 = r410;
        PromptCell.M(r117, r116);
        fx9.a r69 = r59.C();
        if (r69 == null) goto L354;
        r69.yT(r117);
        Unit r70 = Unit.INSTANCE;
    L354:
        fx9.a r71 = r59.C();
        if (r71 == null) goto L364;
        if (r116 == null) goto L358;
        String r72 = r116.getItemId();
    L359:
        if (r116 == null) goto L361;
        String r73 = r116.getActivityId();
    L362:
        r71.k30(r117, r72, r73, com.larus.bmhome.chat.bean.d.x(r117).getOnboardingSugExpirationTime());
        Unit r74 = Unit.INSTANCE;
        goto L364
    L361:
        r73 = null;
        goto L362
    L358:
        r72 = null;
    L364:
        if (r67 == false) goto L367;
        return Unit.INSTANCE;
    L367:
        if (ce8.c.a() == false) goto L388;
        PromptContent.SuggestV2ExtraForMultiAction r118 = r510;
        if (r118 == null) goto L375;
        String r75 = r118.getSchemaUrl();
        if (r75 == null) goto L375;
        Continuation r119 = null;
        if (StringsKt.contains$default(r75, "//flow/realtime_chat", false, 2, null) != true) goto L376;
        boolean r76 = true;
    L377:
        if (r76 == true) goto L385;
        if (r118 == null) goto L380;
        Continuation r77 = r118.getSuggestActionType();
    L382:
        if (Intrinsics.areEqual(r77, SuggestActionType.CALL) == true) goto L385;
        PromptCell r78 = r59;
    L389:
        if (r60 == null) goto L394;
        Continuation r79 = r60.getContent();
        if (r79 == null) goto L394;
        View r80 = r811;
    L411:
        Continuation r81 = r79;
    L412:
        Continuation r120 = r81;
    L413:
        if (r116 == null) goto L415;
        Continuation r82 = n1.a(r116);
    L416:
        if (r82 == null) goto L419;
        Continuation r83 = r82.b;
        if (r83 == null) goto L419;
    L451:
        Continuation r121 = r83;
    L452:
        if (r118 == null) goto L461;
        IPromptSelectActionDispatcherService.a r84 = IPromptSelectActionDispatcherService.a;
        Fragment r90 = lf8.a.d(r78);
        r84.getClass();
        IPromptSelectActionDispatcherService.a.a(r90, r118, "click_spring_suggest", "spring_suggest");
        if (Intrinsics.areEqual(r118.getSuggestStyle(), PromptContent.SuggestV2Style.COLORFUL.getValue()) == false) goto L460;
        Fragment r91 = lf8.a.d(r78);
        if (r91 == null) goto L460;
        LifecycleCoroutineScope r122 = LifecycleOwnerKt.getLifecycleScope(r91);
        if (r122 == null) goto L460;
        BuildersKt.launch$default(r122, Dispatchers.getIO(), null, new PromptCell$bindList$10$6(r78, r118, r119), 2, null);
    L460:
        boolean r0 = false;
    L481:
        String r92 = r78.I;
        if (r92 == null) goto L484;
        boolean r93 = true;
        PromptCell.Y.storeBoolean("last_prompt_message".concat(r92), true);
        Unit r94 = Unit.INSTANCE;
    L485:
        com.larus.bmhome.chat.api.q0 r95 = lf8.a.b(r78);
        if (r95 == null) goto L490;
        ChatMessageList r96 = r95.B7();
        if (r96 == null) goto L490;
        b0$a.b(r96, r0, 14);
        Unit r97 = Unit.INSTANCE;
    L490:
        if (r118 != null) goto L506;
        if (r60 == null) goto L504;
        String r99 = r117.getLocalMessageId();
        if (r99 == null) goto L497;
        String r100 = null;
        if (StringsKt.contains$default(r99, "-aweme", r0, 2, null) != r93) goto L498;
        boolean r101 = true;
    L499:
        if (r101 == false) goto L501;
        PromptContent.SuggestV2 r102 = r60;
    L502:
        if (r102 == null) goto L505;
        r118 = r102.getSuggestV2ExtForMultiAction();
    L508:
        if (r60 == null) goto L512;
        PromptContent.SuggestV2Extra r103 = r60.getSuggestV2Extra();
        if (r103 == null) goto L512;
        r100 = r103.getRsRequestId();
    L512:
        PromptCell.L(r78, r117, r80, null, r100, null, null, null, null, null, r120, null, r118, r60, r116, 1520);
        return Unit.INSTANCE;
    L505:
        r118 = r100;
        goto L508
    L501:
        r102 = r100;
    L498:
        r101 = false;
        goto L499
    L497:
        r100 = null;
        goto L498
    L504:
        r100 = null;
        goto L505
    L506:
        r100 = null;
        goto L508
    L484:
        r93 = true;
        goto L485
    L461:
        if (r116 == null) goto L463;
        boolean r104 = Intrinsics.areEqual(r116.isHighlightPush(), Boolean.TRUE);
    L464:
        if (r104 == true) goto L466;
    L468:
        if (r116 == null) goto L470;
        boolean r105 = Intrinsics.areEqual(r116.isHighlightPush(), Boolean.TRUE);
    L471:
        if (r105 == true) goto L473;
    L477:
        if (r82 == null) goto L479;
        Continuation r211 = r82.a();
    L480:
        r0 = false;
        PromptCell.P(r78, r117, r60, r116, r120, r121, null, r110, r211, r115, 32);
        goto L481
    L479:
        r211 = r119;
        goto L480
    L473:
        if (com.larus.bmhome.chat.bean.d.k0(r117) == false) goto L477;
        String r106 = "onboarding_first_met_push";
    L475:
        r110 = r106;
        goto L477
    L470:
        r105 = false;
        goto L471
    L466:
        if (com.larus.bmhome.chat.bean.d.W0(r117) == false) goto L468;
        r106 = "new_topic_push";
        goto L475
    L463:
        r104 = false;
    L419:
        PromptContent.a r107 = PromptContent.Companion;
        if (r60 == null) goto L422;
        Continuation r108 = r60.getExtra();
    L423:
        r107.getClass();
        PromptContent.SuggestV2Extra r109 = PromptContent.a.a(r108);
        if (r109 == null) goto L426;
        r83 = r109.getSendPrompt();
    L427:
        if (r83 != null) goto L451;
        if (r60 == null) goto L430;
        r83 = r60.getContent();
    L431:
        if (r83 != null) goto L451;
        if (r116 == null) goto L434;
        r83 = r116.getSendingContent();
    L435:
        if (r83 != null) goto L451;
        if (r116 == null) goto L438;
        r83 = r116.getSuggest();
    L439:
        if (r83 != null) goto L451;
        if ((r80 instanceof TextView) == false) goto L443;
        Continuation r123 = (TextView) r80;
    L444:
        if (r123 == null) goto L448;
        CharSequence r124 = r123.getText();
        if (r124 == null) goto L448;
        r83 = r124.toString();
    L449:
        if (r83 != null) goto L451;
        r121 = "";
    L448:
        r83 = r119;
        goto L449
    L443:
        r123 = r119;
        goto L444
    L438:
        r83 = r119;
        goto L439
    L434:
        r83 = r119;
        goto L435
    L430:
        r83 = r119;
        goto L431
    L426:
        r83 = r119;
        goto L427
    L422:
        r108 = r119;
        goto L423
    L415:
        r82 = r119;
    L394:
        if (r116 == null) goto L396;
        Continuation r125 = r116.getSuggest();
    L397:
        r80 = r811;
        if (r125 == null) goto L400;
        r79 = r125;
        goto L411
    L400:
        if ((r80 instanceof TextView) == false) goto L402;
        Continuation r126 = (TextView) r80;
    L403:
        if (r126 == null) goto L407;
        CharSequence r127 = r126.getText();
        if (r127 == null) goto L407;
        r81 = r127.toString();
    L408:
        if (r81 != null) goto L412;
        r120 = "";
    L407:
        r81 = r119;
        goto L408
    L402:
        r126 = r119;
        goto L403
    L396:
        r125 = r119;
        goto L397
    L380:
        r77 = r119;
    L385:
        r78 = r59;
        xa8.b r128 = lf8.a.a(r78, xa8.b.class);
        if (r128 == null) goto L389;
        r128.closeContinuousTalk();
        Unit r129 = Unit.INSTANCE;
    L376:
        r76 = false;
    L375:
        r119 = null;
        goto L376
    L388:
        r78 = r59;
        r118 = r510;
        r119 = null;
        goto L389
    L353:
        r116 = r810;
        r117 = r410;
        goto L354
    L363:
        r116 = r810;
        r117 = r410;
        goto L364
    L341:
        if (Intrinsics.areEqual(r810.getItemType(), r58.getValue()) == false) goto L343;
        r64 = r810.getSendingContent();
        goto L344
    L337:
        r63 = null;
        goto L339
    L147:
        if (Intrinsics.areEqual(r57, PromptContent.SuggestItemType.TelUGCBot.getValue()) == true) goto L334;
        if (Intrinsics.areEqual(r57, PromptContent.SuggestItemType.Camera.getValue()) == false) goto L164;
        HashMap r130 = new HashMap();
        xe8.a r131 = lf8.a.d(r47);
        if ((r131 instanceof xe8.a) == false) goto L154;
        r130.put("chat_key", Long.valueOf(r131.getChatUniqueKey()));
    L154:
        r130.put("click_from", r48);
        String r132 = r11.getItemId();
        if (r132 != null) goto L157;
        r132 = "";
    L157:
        r130.put("onboarding_item_id", r132);
        String r133 = com.larus.im.bean.message.a.x(r114);
        if (r133 != null) goto L160;
        r133 = "";
    L160:
        r130.put("reco_request_id", r133);
        r47.W(r114, r11, r48);
        zb8.e r134 = (zb8.e) r47.k.getValue();
        if (r134 == null) goto L163;
        e$a.b(r134, "welcome_back", r130, new zb8.a(null, r48, r48, null, null, null, 48), null, null, false, 120);
        Unit r135 = Unit.INSTANCE;
    L163:
        e1 r511 = r56;
        r510 = r10;
        PromptContent.SuggestItem r812 = r11;
        r60 = r113;
        Message r813 = r114;
        r811 = r13;
        PromptCell.L(r47, r114, r13, null, null, null, null, null, null, null, r11.getSuggest(), null, null, r60, null, 11768);
        PromptCell r610 = r47;
    L210:
        r410 = r813;
        r59 = r610;
        r810 = r812;
    L287:
        r115 = r511;
        goto L345
    L164:
        r511 = r56;
        PromptCell r512 = r47;
        SearchMobParam r814 = r45;
        r510 = r10;
        r812 = r11;
        r60 = r113;
        r813 = r114;
        r811 = r13;
        if (Intrinsics.areEqual(r57, PromptContent.SuggestItemType.TelMainBot.getValue()) == false) goto L213;
        va8.o r136 = (va8.o) r512.m.getValue();
        if (r136 == null) goto L172;
        if (r136.a8() != true) goto L172;
        boolean r212 = true;
    L173:
        RecommendFrom r137 = new RecommendFrom(r48, com.larus.im.bean.message.a.x(r813), r48);
        Fragment r138 = lf8.a.d(r512);
        if (r138 == null) goto L528;
        String r213 = r813.getConversationId();
        com.larus.bmhome.chat.component.cvs.y r139 = r512.z();
        if (r139 == null) goto L181;
        wc9.e r140 = r139.h();
        if (r140 == null) goto L181;
        SearchMobParam r513 = r140.I;
    L182:
        String r214 = r813.getSectionId();
        long r141 = r813.getServerIndex();
        com.larus.bmhome.chat.component.cvs.y r142 = r512.z();
        if (r142 == null) goto L529;
        BotModel r215 = r142.j0();
        if (r215 == null) goto L529;
        de8.c r143 = r512.y();
        if (r143 == null) goto L190;
        SearchMobParam r310 = r143.e;
    L191:
        SearchMobParam r144 = lf8.a.d(r512);
        if ((r144 instanceof by7.e) == false) goto L194;
        SearchMobParam r311 = (by7.e) r144;
    L195:
        de8.c r145 = r512.y();
        if (r145 == null) goto L198;
        SearchMobParam r312 = r145.e();
    L199:
        de8.c r146 = r512.y();
        if (r146 == null) goto L202;
        SearchMobParam r313 = r146.d();
    L203:
        int r147 = gx9.o.a;
        String r411 = gx9.o.a();
        String r412 = gx9.o.c();
        String r413 = gx9.o.b();
        String r148 = r812.getSchema();
        if (r148 == null) goto L208;
        Uri r149 = UriProtector.parse(r148);
        if (r149 == null) goto L208;
        SearchMobParam r514 = com.larus.utils.y0.f(r149, "track_params");
    L209:
        VoiceCallServiceDelegate.a.t(new b3a.c(r138, r213, r214, Long.valueOf(r141), r215, r137, "default", "chat", r48, null, r212, r310, null, r311, r312, r313, 0, null, null, null, null, null, null, null, null, null, null, r411, r412, r413, null, null, null, r514, null, r513, -939585024, 59), false);
        r610 = r512;
        PromptCell.L(r512, r813, r811, null, null, null, null, null, null, null, r812.getSuggest(), null, null, r60, null, 11768);
    L208:
        r514 = r814;
        goto L209
    L202:
        r313 = r814;
        goto L203
    L198:
        r312 = r814;
        goto L199
    L194:
        r311 = r814;
        goto L195
    L190:
        r310 = r814;
    L529:
        return Unit.INSTANCE;
    L181:
        r513 = r814;
        goto L182
    L528:
        return Unit.INSTANCE;
    L172:
        r212 = false;
        goto L173
    L213:
        if (Intrinsics.areEqual(r57, PromptContent.SuggestItemType.Album.getValue()) == false) goto L229;
        r512.W(r813, r812, r48);
        com.larus.bmhome.chat.component.bottom.multimodal.g r150 = (com.larus.bmhome.chat.component.bottom.multimodal.g) r512.n.getValue();
        if (r150 == null) goto L218;
        com.larus.bmhome.chat.component.bottom.multimodal.f1.a r151 = new com.larus.bmhome.chat.component.bottom.multimodal.f1.a(false, 0, 3);
        com.larus.bmhome.chat.component.bottom.multimodal.g1 r152 = new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.PromptCellAlbum, false);
        LinkedHashMap r153 = new LinkedHashMap();
        r153.put("upload_file_click_from", r48);
        Unit r154 = Unit.INSTANCE;
        r150.n90(new com.larus.bmhome.chat.component.bottom.multimodal.e1(r151, r152, null, r153, 4));
    L218:
        String r155 = r48;
        r810 = r812;
        r410 = r813;
        r59 = r512;
        PromptCell.L(r512, r813, r811, null, null, null, null, null, null, null, r812.getSuggest(), null, null, r60, null, 11768);
        com.larus.bmhome.chat.component.cvs.y r156 = r59.z();
        if (r156 == null) goto L221;
        SearchMobParam r157 = r156.getBotId();
    L222:
        com.larus.bmhome.chat.component.cvs.y r158 = r59.z();
        if (r158 == null) goto L227;
        wc9.e r159 = r158.h();
        if (r159 == null) goto L227;
        SearchMobParam r216 = ic8.n.f(r159);
    L228:
        tx9.c0.H(r157, r155, null, null, r216, "chat", null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33554380);
    L227:
        r216 = r814;
        goto L228
    L221:
        r157 = r814;
        goto L222
    L229:
        r410 = r813;
        r59 = r512;
        r810 = r812;
        String r815 = r48;
        if (Intrinsics.areEqual(r57, PromptContent.SuggestItemType.VLM.getValue()) == false) goto L285;
        ArrayList r160 = new ArrayList();
        String r161 = r810.getSendingContent();
        if (r161 != null) goto L235;
        r161 = r810.getSuggest();
    L235:
        if (v19.h.a(r814) == false) goto L243;
        PromptContent.SuggestImageItem r162 = r810.getDarkUrlItem();
        if (r162 == null) goto L239;
        SearchMobParam r163 = r162.getUri();
    L241:
        if (com.larus.utils.o0.d(r163) == false) goto L243;
        PromptContent.SuggestImageItem r164 = r810.getDarkUrlItem();
    L244:
        Map r165 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_clear_context", String.valueOf(com.larus.bmhome.chat.bean.d.x(r410).isClickClearContext()))});
        String r166 = r810.getWcbItem();
        if (r166 == null) goto L247;
        r165.put("wcb_item_info", r166);
        Unit r167 = Unit.INSTANCE;
    L247:
        if (r164 == null) goto L249;
        SearchMobParam r168 = r164.getUri();
    L251:
        if (com.larus.utils.o0.d(r168) == false) goto L268;
        int r169 = wf9.b.a;
        String r170 = com.flow.kmp.common.util.i.a();
        UplinkFileEntity[] r171 = new UplinkFileEntity[1];
        Integer r172 = Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue());
        if (r164 == null) goto L255;
        SearchMobParam r611 = r164.getUri();
    L257:
        if (r164 == null) goto L261;
        Integer r173 = r164.getWidth();
        if (r173 == null) goto L261;
        int r314 = r173.intValue();
    L262:
        if (r164 == null) goto L266;
        Integer r174 = r164.getHeight();
        if (r174 == null) goto L266;
        int r315 = r174.intValue();
    L267:
        SearchMobParam r175 = r814;
        r171[0] = new UplinkFileEntity(r172, new UplinkEntityContent(r175, new Image(r611, null, null, new ImageObj(null, r314, r315, null, null, 25, null), null, null, null, null, null, null, null, null, null, null, 16374, null), 1, r175), null, null, null, null, null, null, null, false, null, null, null, null, 16380, null);
        r160.add(new ai8.f(new NestedFileContent(CollectionsKt.mutableListOf(r171), null, false, null, 14, null), r170, null, null, r165, null, false, null, r59.w(), null, 748));
        int r176 = gx9.o.a;
        String r177 = r810.getItemId();
        Intrinsics.checkNotNullParameter(r170, "msgId");
        IAIChatControlTraceService.Companion r178 = IAIChatControlTraceService.a;
        r178.qb(r170, r177);
        String r179 = r810.getItemType();
        Intrinsics.checkNotNullParameter(r170, "msgId");
        r178.Ga(r170, r179);
        String r180 = com.larus.im.bean.message.a.x(r410);
        Intrinsics.checkNotNullParameter(r170, "msgId");
        r178.Oa(r170, r180);
    L270:
        if (com.larus.utils.o0.d(r161) == false) goto L276;
        int r181 = wf9.b.a;
        String r182 = com.flow.kmp.common.util.i.a();
        if (r161 != null) goto L274;
        String r183 = "";
    L275:
        r160.add(new ai8.h(r183, r182, null, null, r165, null, false, false, r59.w(), null, 748));
        int r184 = gx9.o.a;
        String r185 = r810.getItemId();
        Intrinsics.checkNotNullParameter(r182, "msgId");
        IAIChatControlTraceService.Companion r186 = IAIChatControlTraceService.a;
        r186.qb(r182, r185);
        String r187 = r810.getItemType();
        Intrinsics.checkNotNullParameter(r182, "msgId");
        r186.Ga(r182, r187);
        String r188 = com.larus.im.bean.message.a.x(r410);
        Intrinsics.checkNotNullParameter(r182, "msgId");
        r186.Oa(r182, r188);
        goto L276
    L274:
        r183 = r161;
    L276:
        com.larus.bmhome.chat.component.cvs.y r189 = r59.z();
        if (r189 == null) goto L279;
        SearchMobParam r190 = r189.h();
    L280:
        gd8.g r191 = (gd8.g) r59.j.getValue();
        if (r191 == null) goto L283;
        gd8.g.a.a(r191, r190, r815, r160, r815, null, null, 48);
        Unit r192 = Unit.INSTANCE;
    L283:
        r59 = r59;
        PromptCell.L(r59, r410, r811, null, null, null, null, null, null, null, r810.getSuggest(), null, null, r60, null, 11768);
        goto L287
    L279:
        r190 = r175;
    L266:
        r315 = 0;
    L261:
        r314 = 0;
        goto L262
    L255:
        r611 = r814;
        goto L257
    L268:
        r175 = r814;
        goto L270
    L249:
        r168 = r814;
        goto L251
    L239:
        r163 = r814;
    L243:
        r164 = r810.getLightUrlItem();
        goto L244
    L285:
        if (Intrinsics.areEqual(r57, PromptContent.SuggestItemType.FestivalWelcomeBack.getValue()) == false) goto L289;
        IPromptSelectActionDispatcherService.a r193 = IPromptSelectActionDispatcherService.a;
        Fragment r194 = lf8.a.d(r59);
        PromptContent.SuggestV2ExtraForMultiAction r195 = com.larus.bmhome.chat.bean.g.a(r810);
        r193.getClass();
        IPromptSelectActionDispatcherService.a.a(r194, r195, "click_spring_new_topic", "spring_new_topic");
        PromptCell.L(r59, r410, r811, null, null, null, null, null, null, null, r810.getSuggest(), null, null, r60, null, 11768);
        goto L287
    L289:
        if (Intrinsics.areEqual(r57, PromptContent.SuggestItemType.WcbCreation.getValue()) == false) goto L291;
    L326:
        String r196 = r810.getItemId();
        if (r196 != null) goto L329;
        r196 = "";
    L329:
        boolean r197 = Intrinsics.areEqual(r810.getItemType(), PromptContent.SuggestItemType.WcbCreationSameStyle.getValue());
        d1 r198 = r59.V;
        if (r198 == null) goto L332;
        r198.d(r196, r197, r511);
        Unit r199 = Unit.INSTANCE;
    L332:
        r115 = r511;
        r59 = r59;
        PromptCell.L(r59, r410, r811, null, null, null, null, null, null, null, r810.getSuggest(), null, null, r60, r810, 3576);
    L333:
        r67 = true;
        r68 = false;
        goto L348
    L291:
        if (Intrinsics.areEqual(r57, PromptContent.SuggestItemType.WcbCreationSameStyle.getValue()) == true) goto L326;
        if (Intrinsics.areEqual(r57, PromptContent.SuggestItemType.WcbCreationAlbum.getValue()) == false) goto L296;
    L321:
        d1 r200 = r59.V;
        if (r200 == null) goto L324;
        e1 r1100 = r511;
        r200.f(r810.getSendingContent(), Intrinsics.areEqual(r810.getItemType(), PromptContent.SuggestItemType.WcbCreationAlbumMulti.getValue()), r1100, r810.getSendMsgExtra());
        Unit r201 = Unit.INSTANCE;
    L325:
        PromptCell.L(r59, r410, r811, null, null, null, null, null, null, null, r810.getSuggest(), null, null, r60, r810, 3576);
        r115 = r1100;
        r59 = r59;
        goto L333
    L324:
        r1100 = r511;
        goto L325
    L296:
        if (Intrinsics.areEqual(r57, PromptContent.SuggestItemType.WcbCreationAlbumMulti.getValue()) == true) goto L321;
        if (Intrinsics.areEqual(r57, PromptContent.SuggestItemType.JumpSchema.getValue()) == false) goto L306;
        d1 r202 = r59.V;
        if (r202 == null) goto L303;
        e1 r1101 = r511;
        r202.b(r810.getSchema(), r1101);
        Unit r203 = Unit.INSTANCE;
    L304:
        r511 = r1101;
        PromptCell.L(r59, r410, r811, null, null, null, null, null, null, null, r810.getSuggest(), null, null, r60, r810, 3576);
        PromptCell r710 = r59;
    L312:
        r115 = r511;
        r59 = r710;
        goto L333
    L303:
        r1101 = r511;
        goto L304
    L306:
        if (Intrinsics.areEqual(r57, PromptContent.SuggestItemType.FillInput.getValue()) == false) goto L314;
        k1 r204 = n1.a(r810);
        d1 r205 = r59.V;
        if (r205 == null) goto L310;
        PromptContent.SuggestItem r1102 = r810;
        Message r1103 = r410;
        r205.a(r204.a, r810.getSelectionPos(), r511, r59.s(r1103, r1102), r204.c, r204.d, r1103);
        Unit r206 = Unit.INSTANCE;
    L311:
        r59.D().a();
        r810 = r1102;
        r410 = r1103;
        r710 = r59;
        PromptCell.L(r59, r1103, r811, null, null, null, null, null, null, null, r1102.getSuggest(), null, null, r60, r810, 3576);
        goto L312
    L310:
        r1102 = r810;
        r1103 = r410;
        goto L311
    L314:
        if (Intrinsics.areEqual(r57, PromptContent.SuggestItemType.CameraNew.getValue()) == false) goto L320;
        d1 r207 = r59.V;
        if (r207 == null) goto L318;
        e1 r1104 = r511;
        r207.c(r810.getSendingContent(), de8.d.a(r59.y()), r1104);
        Unit r208 = Unit.INSTANCE;
    L319:
        PromptCell.L(r59, r410, r811, null, null, null, null, null, null, null, r810.getSuggest(), null, null, r60, r810, 3576);
        r115 = r1104;
        r59 = r59;
        goto L333
    L318:
        r1104 = r511;
        goto L319
    L320:
        r115 = r511;
        r59 = r59;
        r66 = false;
        goto L346
    L143:
        r57 = r45;
        goto L144
    L139:
        r54 = r45;
        goto L140
    L132:
        r51 = r49.getFirst();
        goto L133
    L111:
        r113 = r12;
        r114 = r14;
        r45 = null;
        if (com.larus.bmhome.chat.bean.d.k0(r114) == false) goto L116;
        r46 = "onboarding_first_met";
        goto L114
    L116:
        if (com.larus.bmhome.chat.bean.d.W0(r114) == false) goto L121;
        r47 = r15;
        if (r47.F(r114) == false) goto L120;
        r46 = "new_topic";
        goto L124
    L120:
        r46 = "onboarding_welcome_back";
        goto L124
    L121:
        r47 = r15;
        if (com.larus.bmhome.chat.bean.d.s0(r114) == false) goto L125;
        r46 = "onboarding_longtimenosee";
        goto L124
    L125:
        r48 = "";
    L53:
        r27 = false;
    L23:
        r6 = false;
    L12:
        r4 = false;
        goto L13
    L522:
        return Unit.INSTANCE;
    }
}
