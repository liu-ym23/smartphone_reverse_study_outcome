package com.larus.bmhome.chat.list.cell.prompt;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.platform.model.RecommendFrom;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t0 implements Function3 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PromptCell c;
    public final /* synthetic */ String d;

    public /* synthetic */ t0(boolean r1, String r2, PromptCell r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r53, Object r54, Object r55) {
        boolean r1 = this.a;
        String r2 = this.b;
        PromptCell r3 = this.c;
        String r4 = this.d;
        BotModel r5 = (BotModel) r53;
        boolean r6 = ((Boolean) r54).booleanValue();
        String r7 = (String) r55;
        if (r1 == false) goto L6;
        FLogger.a.d("WcbSugPromptCell", "preLoad botInfo success >>>  botId " + r2 + "  ,message >> " + r7);
        return Unit.INSTANCE;
    L6:
        if (r6 == false) goto L101;
        FLogger r8 = FLogger.a;
        r8.d("WcbSugPromptCell", "requireBot >>>  botId " + r2 + "  ,message >> " + r7);
        if (r5 == null) goto L100;
        Keva r9 = PromptCell.Y;
        r3.getClass();
        String r10 = r5.getBotId();
        if (r10 != null) goto L12;
        String r11 = "";
    L13:
        Integer r12 = r5.getBotType();
        BotIconImage r13 = r5.getIconImage();
        if (r13 == null) goto L16;
        String r15 = r13.getOriginUrl();
    L17:
        BotIconImage r14 = r5.getIconImage();
        if (r14 == null) goto L20;
        String r16 = r14.getUri();
    L21:
        BotIconImage r17 = r5.getIconImage();
        if (r17 == null) goto L24;
        String r18 = r17.getTinyUrl();
    L25:
        if (r18 != null) goto L27;
    L30:
        boolean r19 = true;
    L31:
        if (r19 == false) goto L35;
        BotIconImage r20 = r5.getIconImage();
        if (r20 == null) goto L39;
        String r21 = r20.getOriginUrl();
    L38:
        String r110 = r21;
    L40:
        BotIconImage r22 = new BotIconImage(r16, r110, r15, null, null, 24, null);
        String r23 = r5.getName();
        if (r23 != null) goto L43;
        String r24 = "";
    L44:
        BotOnBoarding r25 = r5.getOnBoarding();
        if (r25 == null) goto L50;
        String r26 = r25.getPrologue();
        if (r26 == null) goto L50;
        String r111 = r26;
    L51:
        BotOnBoarding r27 = r5.getOnBoarding();
        if (r27 == null) goto L54;
        List r112 = r27.getSuggests();
    L55:
        BotOnBoarding r28 = r5.getOnBoarding();
        if (r28 == null) goto L61;
        String r29 = r28.getContent();
        if (r29 == null) goto L61;
        String r113 = r29;
    L62:
        com.larus.bmhome.chat.bean.BotOnBoarding r210 = new com.larus.bmhome.chat.bean.BotOnBoarding(r111, r112, r113, 2, 16);
        BotCreatorInfo r30 = r5.getBotCreatorInfo();
        if (r30 == null) goto L66;
        String r31 = r30.getName();
        if (r31 == null) goto L66;
    L67:
        BotCreatorInfo r114 = r5.getBotCreatorInfo();
        if (r114 == null) goto L71;
        String r115 = r114.getId();
        if (r115 == null) goto L71;
    L72:
        BotCreatorInfo r116 = r5.getBotCreatorInfo();
        if (r116 == null) goto L80;
        BotIconImage r117 = r116.getAvatar();
        if (r117 == null) goto L80;
        String r118 = r117.getUri();
        if (r118 == null) goto L80;
        String r45 = r118;
    L81:
        BotCreatorInfo r119 = r5.getBotCreatorInfo();
        if (r119 == null) goto L89;
        BotIconImage r120 = r119.getAvatar();
        if (r120 == null) goto L89;
        String r121 = r120.getTinyUrl();
        if (r121 == null) goto L89;
        String r46 = r121;
    L90:
        BotCreatorInfo r122 = r5.getBotCreatorInfo();
        if (r122 == null) goto L98;
        BotIconImage r123 = r122.getAvatar();
        if (r123 == null) goto L98;
        String r124 = r123.getOriginUrl();
        if (r124 == null) goto L98;
        String r47 = r124;
    L99:
        BotCreatorInfo r125 = new BotCreatorInfo(r31, r115, new BotIconImage(r45, r46, r47, null, null, 24, null));
        RecommendFrom r32 = new RecommendFrom("chat_suggestedprompt_click", r4, null, 4);
        String r34 = r5.getBgImgColor();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PromptCell$goToOtherChatPage$1(r3, new RecommendBot(r11, r24, r12, null, r22, 0, 0, 0, false, null, r210, r125, null, null, null, null, null, null, null, null, null, null, null, r5.getBgImgUrl(), r34, null, r5.getBgImgUri(), r5.getBgImgInfo(), null, null, null, null, null, null, false, r32, -1811949608, 7167), null), 3, null);
    L103:
        return Unit.INSTANCE;
    L98:
        r47 = "";
    L89:
        r46 = "";
    L80:
        r45 = "";
    L71:
        r115 = "";
    L66:
        r31 = "";
    L61:
        r113 = "";
        goto L62
    L54:
        r112 = null;
    L50:
        r111 = "";
        goto L51
    L43:
        r24 = r23;
    L39:
        r110 = null;
        goto L40
    L35:
        BotIconImage r33 = r5.getIconImage();
        if (r33 == null) goto L39;
        r21 = r33.getTinyUrl();
        goto L38
    L27:
        if (r18.length() == 0) goto L30;
        r19 = false;
        goto L31
    L24:
        r18 = null;
        goto L25
    L20:
        r16 = null;
        goto L21
    L16:
        r15 = null;
        goto L17
    L12:
        r11 = r10;
        goto L13
    L100:
        r8.d("WcbSugPromptCell", "error botModel is null >>>  botId " + r2 + " ,message >> " + r7);
        goto L103
    L101:
        FLogger.a.d("WcbSugPromptCell", "error >>>  botId " + r2 + " ,message >> " + r7);
        goto L103
    }
}
