package com.larus.bmhome.instruction.suggest;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import aq8.g;
import aq8.h;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.bean.BotOnBoarding;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.instruction.f;
import com.larus.bmhome.instruction.handler.InstructionHandlerType;
import com.larus.bmhome.instruction.n;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.im.bean.bot.BotSwitchConfInfo;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tx9.x3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/instruction/suggest/PromptSelectActionDispatcherServiceImpl;", "Lcom/larus/bmhome/instruction/suggest/IPromptSelectActionDispatcherService;", "<init>", "()V", "dispatch", "", "fragment", "Landroidx/fragment/app/Fragment;", "extra", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestV2ExtraForMultiAction;", "enterMethod", "", "scene", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptSelectActionDispatcherServiceImpl implements IPromptSelectActionDispatcherService {
    public PromptSelectActionDispatcherServiceImpl() {
    }

    @Override // com.larus.bmhome.instruction.suggest.IPromptSelectActionDispatcherService
    public final void a(Fragment r77, PromptContent.SuggestV2ExtraForMultiAction r78, String r79, String r80) {
        Intrinsics.checkNotNullParameter(r78, "extra");
        Intrinsics.checkNotNullParameter(r79, "enterMethod");
        Intrinsics.checkNotNullParameter(r80, "scene");
        c r3 = new c(r77, r78, r79, r80);
        StringBuilder r0 = new StringBuilder("enter_method=");
        r0.append(r3.c);
        r0.append(",suggest_action_type=");
        String r1 = r3.b.getSuggestActionType();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.append(r1);
        r0.append(",scene=");
        r0.append(r3.d);
        x3.a("suggest_v2_extra_for_multi_action", "dispatch", r0.toString());
        eq8.a r2 = r3.e;
        String r4 = r3.c;
        String r5 = r3.b.getSuggestActionType();
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        String r6 = r3.g;
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        r2.d(r4, r5, r6);
        FLogger r7 = FLogger.a;
        r7.i("PromptSelectActionDispatcher", "doDispatch: suggestV2ExtraForMultiAction = " + r3.b);
        String r8 = r3.b.getSchemaUrl();
        if (r8 != null) goto L14;
    L27:
        String r9 = r3.b.getSuggestActionType();
        if (r9 != null) goto L30;
    L329:
        r7.i("PromptSelectActionDispatcher", "doDispatch: do nothing");
        r3.e.c("do dispatch", "no handler", null);
        Unit r10 = Unit.INSTANCE;
    L330:
        Fragment r11 = r3.a;
        if (r11 == null) goto L345;
        LifecycleCoroutineScope r12 = LifecycleOwnerKt.getLifecycleScope(r11);
        if (r12 == null) goto L346;
        BuildersKt.launch$default(r12, Dispatchers.getIO(), null, new PromptSelectActionDispatcher$doDispatch$17(r3, null), 2, null);
        return;
    L346:
        return;
    L345:
        return;
    L30:
        switch(r9.hashCode()) {
            case -1697881269: goto L300;
            case -1053848247: goto L270;
            case 2060894: goto L261;
            case 54840997: goto L236;
            case 73725445: goto L206;
            case 76105234: goto L181;
            case 81665115: goto L163;
            case 1089697796: goto L79;
            case 1368705275: goto L76;
            case 1942336857: goto L58;
            case 2031361578: goto L33;
            default: goto L329;
        };
    L33:
        if (r9.equals("SEND_MSG") == false) goto L329;
        String r13 = r3.g;
        if (r13 == null) goto L330;
        if (o0.d(r13) == true) goto L41;
        r13 = null;
    L41:
        if (r13 == null) goto L330;
        f r14 = r3.c();
        if (r14 == null) goto L330;
        String r15 = r3.g;
        PromptContent.CursorPosition r16 = r3.b.getCursorPosition();
        if (r16 == null) goto L47;
        Integer r17 = r16.getStartPos();
    L48:
        PromptContent.CursorPosition r18 = r3.b.getCursorPosition();
        if (r18 == null) goto L51;
        Integer r19 = r18.getEndPos();
    L52:
        aq8.e r20 = new aq8.e(r15, r17, r19, null, null, false, r3.c, r3.d, null, null, 824);
        Map<String, String> r21 = r20.e;
        String r22 = r3.b.getMsgExt();
        if (r22 == null) goto L55;
        Map<? extends String, ? extends String> r23 = e.a(r22);
    L56:
        r21.putAll(r23);
        Unit r24 = Unit.INSTANCE;
        r14.b(new n(InstructionHandlerType.TEXT_TO_TEXT, r20, true, null, null, 24));
        goto L330
    L55:
        r23 = MapsKt.emptyMap();
        goto L56
    L51:
        r19 = null;
        goto L52
    L47:
        r17 = null;
        goto L48
    L58:
        if (r9.equals(InstructionHandlerType.AVATAR) == false) goto L329;
        f r25 = r3.c();
        if (r25 == null) goto L330;
        String r26 = r3.g;
        PromptContent.CursorPosition r27 = r3.b.getCursorPosition();
        if (r27 == null) goto L65;
        Integer r110 = r27.getStartPos();
    L66:
        PromptContent.CursorPosition r28 = r3.b.getCursorPosition();
        if (r28 == null) goto L69;
        Integer r111 = r28.getEndPos();
    L70:
        aq8.e r29 = new aq8.e(r26, r110, r111, null, null, true, r3.c, r3.d, null, null, 792);
        Map<String, String> r30 = r29.e;
        String r31 = r3.b.getMsgExt();
        if (r31 == null) goto L73;
        Map<? extends String, ? extends String> r32 = e.a(r31);
    L74:
        r30.putAll(r32);
        Unit r33 = Unit.INSTANCE;
        r25.b(new n(InstructionHandlerType.AVATAR, r29, true, null, null, 24));
        goto L330
    L73:
        r32 = MapsKt.emptyMap();
        goto L74
    L69:
        r111 = null;
        goto L70
    L65:
        r110 = null;
        goto L66
    L76:
        if (r9.equals(InstructionHandlerType.IMAGE_TO_IMAGE) == false) goto L329;
    L302:
        f r34 = r3.c();
        if (r34 == null) goto L330;
        String r112 = r3.g;
        PromptContent.CursorPosition r35 = r3.b.getCursorPosition();
        if (r35 == null) goto L307;
        Integer r113 = r35.getStartPos();
    L308:
        PromptContent.CursorPosition r36 = r3.b.getCursorPosition();
        if (r36 == null) goto L311;
        Integer r114 = r36.getEndPos();
    L312:
        g r37 = new g(c.b(r3.b, "image_gen_style_btn"), c.b(r3.b, "image_gen_aspect_ratio"), null, null, 12);
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L315
        Object r39 = Result.constructor-impl(xt7.d.b.a(g.Companion.serializer(), r37));     // Catch: Throwable -> L315
    L318:
        if (Result.isFailure-impl(r39) == false) goto L320;
        r39 = null;
    L320:
        String r40 = (String) r39;
        if (r40 != null) goto L323;
        String r115 = "";
    L324:
        aq8.e r41 = new aq8.e(r112, r113, r114, r115, null, false, r3.c, r3.d, null, null, 816);
        Map<String, String> r42 = r41.e;
        String r43 = r3.b.getMsgExt();
        if (r43 == null) goto L327;
        Map<? extends String, ? extends String> r44 = e.a(r43);
    L328:
        r42.putAll(r44);
        Unit r45 = Unit.INSTANCE;
        r34.b(new n(InstructionHandlerType.IMAGE_TO_IMAGE, r41, Intrinsics.areEqual(r3.b.getSuggestActionType(), InstructionHandlerType.IMAGE_TO_IMAGE), null, null, 24));
        goto L330
    L327:
        r44 = MapsKt.emptyMap();
        goto L328
    L323:
        r115 = r40;
    L315:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L318
    L311:
        r114 = null;
        goto L312
    L307:
        r113 = null;
        goto L308
    L79:
        if (r9.equals("BOT_RECOMMEND") == false) goto L329;
        PromptContent.BotInfo r47 = r3.b.getBotInfoModel();
        String r48 = r3.b.getBotId();
        a r49 = new a(r3.a, r3.c, r3.d);
        if (r47 == null) goto L155;
        Intrinsics.checkNotNullParameter(r47, "<this>");
        Long r50 = r47.getBotId();
        if (r50 == null) goto L89;
        String r51 = r50.toString();
        if (r51 == null) goto L89;
        String r52 = r51;
    L90:
        String r53 = r47.getName();
        BotIconImage r54 = r47.getIconImage();
        if (r54 == null) goto L93;
        String r116 = r54.getUri();
    L94:
        BotIconImage r55 = r47.getIconImage();
        if (r55 == null) goto L97;
        String r117 = r55.getTinyUrl();
    L98:
        BotIconImage r56 = r47.getIconImage();
        if (r56 == null) goto L101;
        String r118 = r56.getOriginUrl();
    L102:
        BotIconImage r57 = new BotIconImage(r116, r117, r118, null, null, 24, null);
        Long r119 = r47.getUpdateTime();
        Integer r120 = r47.getBotType();
        BotCreatorInfo r58 = r47.getBotCreatorInfo();
        if (r58 == null) goto L105;
        String r59 = r58.getName();
    L106:
        BotCreatorInfo r121 = r47.getBotCreatorInfo();
        if (r121 == null) goto L109;
        String r122 = r121.getId();
    L110:
        BotCreatorInfo r123 = r47.getBotCreatorInfo();
        if (r123 == null) goto L115;
        BotIconImage r124 = r123.getAvatar();
        if (r124 == null) goto L115;
        String r125 = r124.getUri();
    L116:
        BotCreatorInfo r126 = r47.getBotCreatorInfo();
        if (r126 == null) goto L121;
        BotIconImage r127 = r126.getAvatar();
        if (r127 == null) goto L121;
        String r128 = r127.getTinyUrl();
    L122:
        BotCreatorInfo r129 = r47.getBotCreatorInfo();
        if (r129 == null) goto L127;
        BotIconImage r130 = r129.getAvatar();
        if (r130 == null) goto L127;
        String r131 = r130.getOriginUrl();
    L128:
        BotCreatorInfo r132 = new BotCreatorInfo(r59, r122, new BotIconImage(r125, r128, r131, null, null, 24, null));
        Integer r210 = r47.getPrivateStatus();
        ConversationPage r133 = r47.getConversationPage();
        String r211 = r47.getDescriptionForHuman();
        ModelItem r212 = r47.getModel();
        SpeakerVoice r213 = r47.getVoiceType();
        String r214 = r47.getEditPos();
        boolean r215 = r47.getMuted();
        String r310 = r47.getBioEdit();
        String r311 = r47.getBio();
        BotStatistic r312 = r47.getBotStatic();
        List r313 = r47.getBotConf();
        int r410 = r47.getBotMode();
        String r411 = r47.getBgImgUrl();
        String r412 = r47.getBgImgColor();
        String r413 = r47.getBgVideoModel();
        BotSwitchConfInfo r414 = r47.getSwitchConfInfo();
        BotOnBoarding r60 = r47.getOnBoarding();
        if (r60 == null) goto L134;
        String r61 = r60.d();
        if (r61 == null) goto L134;
        String r415 = r61;
    L135:
        BotOnBoarding r62 = r47.getOnBoarding();
        if (r62 == null) goto L138;
        List r416 = r62.e();
    L139:
        BotOnBoarding r63 = r47.getOnBoarding();
        if (r63 == null) goto L145;
        String r64 = r63.b();
        if (r64 == null) goto L145;
        String r510 = r64;
    L146:
        BotOnBoarding r65 = r47.getOnBoarding();
        if (r65 == null) goto L149;
        int r511 = r65.a();
    L150:
        BotOnBoarding r66 = r47.getOnBoarding();
        if (r66 == null) goto L153;
        List r512 = r66.c();
    L154:
        BotModel r67 = new BotModel(r52, r53, r57, 0, r119, r120, null, r132, null, null, r133, null, r211, null, null, r210, r212, r213, r214, r215, null, null, null, r310, r311, r312, null, null, null, null, r313, null, r410, r411, r412, r413, null, r414, new com.larus.im.bean.bot.BotOnBoarding(r415, r416, r510, r511, r512), r47.getCallerName(), r47.getCallerNameSetting(), r47.getSceneModelList(), r47.getDisabled(), r47.getFirstMet(), null, null, r47.getBgImgUri(), r47.getBgImgInfo(), r47.getUserBotGender(), r47.getUserBotType(), null, r47.getDynamicImgUri(), r47.getDynamicImgUrl(), null, null, null, null, null, null, null, null, null, r47.getExtra(), -1133483192, 1071919120, null);
    L156:
        Fragment r68 = r49.a;
        if (r68 == null) goto L161;
        LifecycleCoroutineScope r69 = LifecycleOwnerKt.getLifecycleScope(r68);
        if (r69 == null) goto L161;
        BuildersKt.launch$default(r69, null, null, new JumpUgcBotAction$handleToBot$1(r67, r49, r48, null), 3, null);
    L161:
        Unit r70 = Unit.INSTANCE;
        goto L330
    L153:
        r512 = null;
        goto L154
    L149:
        r511 = 0;
    L145:
        r510 = "";
        goto L146
    L138:
        r416 = null;
    L134:
        r415 = "";
    L127:
        r131 = null;
    L121:
        r128 = null;
    L115:
        r125 = null;
        goto L116
    L109:
        r122 = null;
        goto L110
    L105:
        r59 = null;
        goto L106
    L101:
        r118 = null;
        goto L102
    L97:
        r117 = null;
        goto L98
    L93:
        r116 = null;
    L89:
        r52 = "";
        goto L90
    L155:
        r67 = null;
        goto L156
    L163:
        if (r9.equals(InstructionHandlerType.VIDEO) == false) goto L329;
        f r71 = r3.c();
        if (r71 == null) goto L330;
        String r72 = r3.g;
        PromptContent.CursorPosition r73 = r3.b.getCursorPosition();
        if (r73 == null) goto L170;
        Integer r134 = r73.getStartPos();
    L171:
        PromptContent.CursorPosition r74 = r3.b.getCursorPosition();
        if (r74 == null) goto L174;
        Integer r135 = r74.getEndPos();
    L175:
        aq8.e r75 = new aq8.e(r72, r134, r135, null, null, false, r3.c, r3.d, null, null, 824);
        Map<String, String> r76 = r75.e;
        String r81 = r3.b.getMsgExt();
        if (r81 == null) goto L178;
        Map<? extends String, ? extends String> r82 = e.a(r81);
    L179:
        r76.putAll(r82);
        Unit r83 = Unit.INSTANCE;
        r71.b(new n(InstructionHandlerType.VIDEO, r75, true, null, null, 24));
        goto L330
    L178:
        r82 = MapsKt.emptyMap();
        goto L179
    L174:
        r135 = null;
        goto L175
    L170:
        r134 = null;
        goto L171
    L181:
        if (r9.equals("PHOTO") == false) goto L329;
        String r84 = r3.b.getUserPrompt();
        if (r84 == null) goto L330;
        if (o0.d(r84) == true) goto L189;
        r84 = null;
    L189:
        if (r84 == null) goto L330;
        f r85 = r3.c();
        if (r85 == null) goto L330;
        String r86 = r3.g;
        PromptContent.CursorPosition r87 = r3.b.getCursorPosition();
        if (r87 == null) goto L195;
        Integer r136 = r87.getStartPos();
    L196:
        PromptContent.CursorPosition r88 = r3.b.getCursorPosition();
        if (r88 == null) goto L199;
        Integer r137 = r88.getEndPos();
    L200:
        aq8.e r89 = new aq8.e(r86, r136, r137, null, null, false, r3.c, r3.d, null, null, 824);
        Map<String, String> r90 = r89.e;
        String r91 = r3.b.getMsgExt();
        if (r91 == null) goto L203;
        Map<? extends String, ? extends String> r92 = e.a(r91);
    L204:
        r90.putAll(r92);
        Unit r93 = Unit.INSTANCE;
        r85.b(new n(InstructionHandlerType.TEXT_TO_OPEN_CAMERA, r89, true, null, null, 24));
        goto L330
    L203:
        r92 = MapsKt.emptyMap();
        goto L204
    L199:
        r137 = null;
        goto L200
    L195:
        r136 = null;
        goto L196
    L206:
        if (r9.equals(InstructionHandlerType.MUSIC) == false) goto L329;
        f r94 = r3.c();
        if (r94 == null) goto L330;
        String r95 = r3.g;
        PromptContent.CursorPosition r96 = r3.b.getCursorPosition();
        if (r96 == null) goto L213;
        Integer r138 = r96.getStartPos();
    L214:
        PromptContent.CursorPosition r97 = r3.b.getCursorPosition();
        if (r97 == null) goto L217;
        Integer r139 = r97.getEndPos();
    L218:
        String r98 = c.b(r3.b, "music_genre");
        h r99 = new h(c.b(r3.b, "music_mood"), c.b(r3.b, "music_vocal"), r98);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L221
        Object r101 = Result.constructor-impl(xt7.d.b.a(h.Companion.serializer(), r99));     // Catch: Throwable -> L221
    L224:
        if (Result.isFailure-impl(r101) == false) goto L226;
        r101 = null;
    L226:
        String r102 = (String) r101;
        if (r102 != null) goto L229;
        String r140 = "";
    L230:
        aq8.e r103 = new aq8.e(r95, r138, r139, r140, null, true, r3.c, r3.d, null, null, 784);
        Map<String, String> r104 = r103.e;
        String r105 = r3.b.getMsgExt();
        if (r105 == null) goto L233;
        Map<? extends String, ? extends String> r106 = e.a(r105);
    L234:
        r104.putAll(r106);
        Unit r107 = Unit.INSTANCE;
        r94.b(new n(InstructionHandlerType.MUSIC, r103, false, null, null, 24));
        goto L330
    L233:
        r106 = MapsKt.emptyMap();
        goto L234
    L229:
        r140 = r102;
    L221:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r101 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L224
    L217:
        r139 = null;
        goto L218
    L213:
        r138 = null;
        goto L214
    L236:
        if (r9.equals("FILL_MSG") == false) goto L329;
        String r109 = r3.g;
        if (r109 == null) goto L330;
        if (o0.d(r109) == true) goto L244;
        r109 = null;
    L244:
        if (r109 == null) goto L330;
        f r141 = r3.c();
        if (r141 == null) goto L330;
        String r142 = r3.g;
        PromptContent.CursorPosition r143 = r3.b.getCursorPosition();
        if (r143 == null) goto L250;
        Integer r144 = r143.getStartPos();
    L251:
        PromptContent.CursorPosition r145 = r3.b.getCursorPosition();
        if (r145 == null) goto L254;
        Integer r146 = r145.getEndPos();
    L255:
        aq8.e r147 = new aq8.e(r142, r144, r146, null, null, false, r3.c, r3.d, null, null, 824);
        Map<String, String> r148 = r147.e;
        String r149 = r3.b.getMsgExt();
        if (r149 == null) goto L258;
        Map<? extends String, ? extends String> r150 = e.a(r149);
    L259:
        r148.putAll(r150);
        Unit r151 = Unit.INSTANCE;
        r141.b(new n(InstructionHandlerType.TEXT_TO_TEXT, r147, false, null, null, 24));
        goto L330
    L258:
        r150 = MapsKt.emptyMap();
        goto L259
    L254:
        r146 = null;
        goto L255
    L250:
        r144 = null;
        goto L251
    L261:
        if (r9.equals("CALL") == false) goto L329;
        Fragment r152 = r3.a;
        if (r152 == null) goto L268;
        LifecycleCoroutineScope r153 = LifecycleOwnerKt.getLifecycleScope(r152);
        if (r153 == null) goto L268;
        BuildersKt.launch$default(r153, null, null, new PromptSelectActionDispatcher$handleUgcBotCall$1(r3, null), 3, null);
    L268:
        Unit r154 = Unit.INSTANCE;
        goto L330
    L270:
        if (r9.equals(InstructionHandlerType.TEXT_TO_IMAGE) == false) goto L329;
        f r155 = r3.c();
        if (r155 == null) goto L330;
        String r156 = r3.g;
        PromptContent.CursorPosition r157 = r3.b.getCursorPosition();
        if (r157 == null) goto L277;
        Integer r158 = r157.getStartPos();
    L278:
        PromptContent.CursorPosition r159 = r3.b.getCursorPosition();
        if (r159 == null) goto L281;
        Integer r160 = r159.getEndPos();
    L282:
        g r161 = new g(c.b(r3.b, "image_gen_style_btn"), c.b(r3.b, "image_gen_aspect_ratio"), null, null, 12);
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L285
        Object r163 = Result.constructor-impl(xt7.d.b.a(g.Companion.serializer(), r161));     // Catch: Throwable -> L285
    L288:
        if (Result.isFailure-impl(r163) == false) goto L290;
        r163 = null;
    L290:
        String r164 = (String) r163;
        if (r164 != null) goto L293;
        String r165 = "";
    L294:
        aq8.e r166 = new aq8.e(r156, r158, r160, r165, null, true, r3.c, r3.d, null, null, 784);
        Map<String, String> r167 = r166.e;
        String r168 = r3.b.getMsgExt();
        if (r168 == null) goto L297;
        Map<? extends String, ? extends String> r169 = e.a(r168);
    L298:
        r167.putAll(r169);
        Unit r170 = Unit.INSTANCE;
        r155.b(new n(InstructionHandlerType.TEXT_TO_IMAGE, r166, false, null, null, 28));
        goto L330
    L297:
        r169 = MapsKt.emptyMap();
        goto L298
    L293:
        r165 = r164;
    L285:
        th = move-exception;
        Result.Companion r171 = Result.Companion;
        r163 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L288
    L281:
        r160 = null;
        goto L282
    L277:
        r158 = null;
        goto L278
    L300:
        if (r9.equals("ALBUM_IMAGE") == true) goto L302;
    L14:
        if (o0.d(r8) == true) goto L17;
        r8 = null;
    L17:
        if (r8 == null) goto L27;
        Activity r172 = AppHost.a.a().getCurrentActivity();
        if (r172 == null) goto L21;
        SmartRouter.buildRoute(r172, r8).d();
    L22:
        r7.i("PromptSelectActionDispatcher", "doDispatch: openSchema, so return, schema:".concat(r8));
        Fragment r173 = r3.a;
        if (r173 == null) goto L342;
        LifecycleCoroutineScope r174 = LifecycleOwnerKt.getLifecycleScope(r173);
        if (r174 == null) goto L343;
        BuildersKt.launch$default(r174, Dispatchers.getIO(), null, new PromptSelectActionDispatcher$doDispatch$2$3(r3, null), 2, null);
        return;
    L343:
        return;
    L342:
        return;
    L21:
        r3.e.c("openSchema", "current activity null", null);
        goto L22
    }
}
