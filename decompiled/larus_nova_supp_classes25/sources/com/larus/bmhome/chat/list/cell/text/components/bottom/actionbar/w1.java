package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.actionbar.ActionStyle;
import com.larus.bmhome.view.actionbar.MessageActionBarAlign;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.bot.ActionIcon;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.RegenStatus;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.ObricChatSPIServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Triple;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w1 {
    public static final /* synthetic */ int c = 0;
    public final a2 a;
    public Job b;

    public static final class a {
    }

    static {
    }

    public w1(AnswerActionComponent r2) {
        Intrinsics.checkNotNullParameter(r2, "answerActionLogic");
        this.a = r2;
    }

    public static void c(Message r2) {
        String r3 = com.larus.im.bean.message.a.D(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        com.larus.bmhome.chat.model.repo.x1 r0 = zh8.a.a.x1().a();
        if (Intrinsics.areEqual(r0.q6(), r3) == false) goto L9;
        r0.i6("Crowd test switch group", true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v128, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v129, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v140, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v141, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v148, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v152, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v159, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v164, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v179 */
    /* JADX WARN: Type inference failed for: r0v182, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v183 */
    /* JADX WARN: Type inference failed for: r0v187, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v52, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v60, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v67, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v77, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v86, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r13v41, types: [java.util.List] */
    public final List b(final z r41, AnswerAction r42, List r43, final Message r44, BotModel r45, rs8.h r46) {
        Intrinsics.checkNotNullParameter(r41, "creator");
        Intrinsics.checkNotNullParameter(r42, "answerAction");
        Intrinsics.checkNotNullParameter(r43, "returnActions");
        String r9 = "msg";
        Intrinsics.checkNotNullParameter(r44, "msg");
        Intrinsics.checkNotNullParameter(r45, "bot");
        String r0 = "<this>";
        Intrinsics.checkNotNullParameter(r42, "<this>");
        if (r42.isEnd() == false) goto L5;
        MessageActionBarAlign r3 = MessageActionBarAlign.END;
    L6:
        MessageActionBarAlign r5 = r3;
        String r4 = r42.getKey();
        if (r4 == null) goto L499;
        String r20 = "";
        String r15 = "key";
        switch(r4.hashCode()) {
            case -2000279691: goto L479;
            case -1772571018: goto L452;
            case -1741312354: goto L432;
            case -1435723453: goto L408;
            case -1281605464: goto L235;
            case -1085143522: goto L222;
            case -906336856: goto L180;
            case -415415205: goto L147;
            case 115187: goto L143;
            case 3059573: goto L139;
            case 3321751: goto L112;
            case 109400031: goto L49;
            case 431825529: goto L36;
            case 1671642405: goto L12;
            default: goto L237;
        };
    L180:
        boolean r1 = true;
        if (r4.equals("search") == false) goto L237;
    L184:
        if (this.a.g(r44) == true) goto L186;
        ?? r2 = CollectionsKt.emptyList();
    L545:
        return r2;
    L186:
        r2 = new ArrayList();
        Iterator r6 = r43.iterator();
    L188:
        if (r6.hasNext() == false) goto L192;
        if (((rs8.g) r6.next()).getId() != 2131380350) goto L188;
    L192:
        PlayStateEnum r7 = AudioServiceDelegate.a.r0().l();
        Context r11 = this.a.d();
        if (r11 == null) goto L217;
        com.larus.bmhome.chat.api.q0 r12 = this.a.f();
        com.larus.bmhome.chat.api.q0 r8 = this.a.f();
        if (r8 == null) goto L197;
        com.larus.bmhome.chat.api.q0.a r13 = r8.getProvider();
    L198:
        AnswerActionGenerator$buildTtsAction$1$creator$1 r16 = new AnswerActionGenerator$buildTtsAction$1$creator$1(this.a);
        Object r10 = this.a;
        if ((r10 instanceof bd8.b) == false) goto L201;
        bd8.b r14 = (bd8.b) r10;
    L202:
        if (r14 == null) goto L206;
        Fragment r17 = r14.c;
        if (r17 == null) goto L206;
        t1a.b r18 = s1a.a.g(r17);
    L207:
        Fragment r19 = this.a.e();
        de8.c r21 = this.a.q();
        if (r21 == null) goto L210;
        Bundle r22 = r21.b;
    L211:
        if (r22 != null) goto L213;
    L215:
        boolean r110 = false;
    L216:
        rs8.g r111 = new d2(r11, r12, r13, r5, r16, r45, r18, r19, r110).b(r7, new v1(r44));
    L218:
        FLogger.a.d("TtsActionCreator", "onBindData: tts play state: " + r7 + ", new action: " + r111 + '.');
        if (r111 == null) goto L545;
        r2.add(r111);
        goto L545
    L213:
        if (r22.getBoolean("human_merge_forward_float_chat") != r1) goto L215;
        r110 = true;
        goto L216
    L210:
        r22 = null;
    L206:
        r18 = null;
        goto L207
    L201:
        r14 = null;
        goto L202
    L197:
        r13 = null;
        goto L198
    L217:
        r111 = null;
        goto L218
    L452:
        String r23 = null;
        if (r4.equals("switch_group_msg") == true) goto L455;
    L454:
        r5 = r5;
    L501:
        if (Intrinsics.areEqual(r42.getKey(), "fork_conv") == false) goto L524;
        com.larus.bmhome.chat.api.q0 r24 = this.a.f();
        if (r24 == null) goto L507;
        com.larus.bmhome.chat.api.h0 r25 = r24.A7();
        if (r25 == null) goto L507;
        String r112 = (wc9.e) r25.invoke();
    L509:
        if (z2.a.J3() == false) goto L547;
        Map r26 = r44.getExt();
        if (r26 == null) goto L514;
        r23 = (String) r26.get("disable_fork");
    L514:
        if (Intrinsics.areEqual(r23, "1") == true) goto L547;
        if (ic8.n.o(r112) == true) goto L547;
        String r27 = r42.getKey();
        if (r27 != null) goto L521;
        String r28 = r20;
    L546:
        return CollectionsKt.listOf(r41.a(r44, r42, r5, r28, new AnswerActionGenerator$generateNormalAction$1(this.a)));
    L521:
        r28 = r27;
    L547:
        return CollectionsKt.emptyList();
    L507:
        r112 = r23;
        goto L509
    L524:
        ActionIcon r29 = r42.getIcon();
        if (r29 == null) goto L527;
        String r113 = r29.getDefault_url();
    L529:
        if (com.larus.utils.o0.d(r113) == false) goto L538;
        if (com.larus.utils.o0.d(r42.getUrl()) == false) goto L538;
        String r30 = r42.getKey();
        if (r30 != null) goto L535;
        String r31 = r20;
    L548:
        return CollectionsKt.listOf(r41.a(r44, r42, r5, r31, new AnswerActionGenerator$generateNormalAction$2(this.a)));
    L535:
        r31 = r30;
    L538:
        return CollectionsKt.emptyList();
    L527:
        r113 = r23;
        goto L529
    L455:
        ArrayList r32 = new ArrayList();
        Map r33 = r44.getBusinessExt();
        if (r33 == null) goto L478;
        String r34 = (String) r33.get("sub_group_number");
        if (r34 == null) goto L478;
        Integer r35 = StringsKt.toIntOrNull(r34);
        if (r35 == null) goto L478;
        int r36 = r35.intValue();
        Integer r37 = com.larus.im.bean.message.a.M(r44);
        if (r37 == null) goto L478;
        final int r114 = r37.intValue();
        final String r38 = com.larus.im.bean.message.a.D(r44);
        if (r38 == null) goto L478;
        if (r114 >= (r36 - 1)) goto L469;
        final boolean r39 = true;
    L470:
        if (r39 == false) goto L472;
        String r40 = AppHost.a.getApplication().getString(2131908598);
    L473:
        String r115 = r40;
        Intrinsics.checkNotNull(r115);
        if (r39 == false) goto L476;
        ActionStyle r47 = ActionStyle.HIGHLIGHT;
    L477:
        ActionStyle r48 = r47;
        Function1 r49 = new t1(this, r44, r39, r38, r114);
        Intrinsics.checkNotNullParameter(r44, "msg");
        Intrinsics.checkNotNullParameter(r5, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r115, "description");
        Intrinsics.checkNotNullParameter(r48, "style");
        Intrinsics.checkNotNullParameter("switch_group_msg", "key");
        Intrinsics.checkNotNullParameter(r49, "onClick");
        rs8.j r50 = new rs8.j("switch_group_msg", 2131380356, r115, null, null, 0.0f, r5, false, false, null, r48, null, r49, 3000);
        r2 = r32;
        r2.add(r50);
        goto L545
    L476:
        r47 = ActionStyle.HIGHLIGHT_WITH_LEFT_ICON;
        goto L477
    L472:
        r40 = AppHost.a.getApplication().getString(2131908597);
        goto L473
    L469:
        r39 = false;
    L478:
        r2 = r32;
        goto L545
    L479:
        r23 = null;
        if (r4.equals("next_group_msg") == true) goto L482;
        r5 = r5;
        goto L501
    L482:
        ArrayList r116 = new ArrayList();
        Map r51 = r44.getBusinessExt();
        if (r51 == null) goto L498;
        String r52 = (String) r51.get("sub_group_number");
        if (r52 == null) goto L498;
        Integer r53 = StringsKt.toIntOrNull(r52);
        if (r53 == null) goto L498;
        int r54 = r53.intValue();
        Integer r55 = com.larus.im.bean.message.a.M(r44);
        if (r55 == null) goto L498;
        final int r56 = r55.intValue();
        final String r57 = com.larus.im.bean.message.a.D(r44);
        if (r57 == null) goto L498;
        if (r56 >= (r54 - 1)) goto L496;
        boolean r117 = true;
    L497:
        final boolean r58 = r117;
        Function1 r118 = new u1(r58, this, r44, r57, r56);
        Intrinsics.checkNotNullParameter(r44, "msg");
        Intrinsics.checkNotNullParameter(r5, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter("next_group_msg", "key");
        Intrinsics.checkNotNullParameter(r118, "onClick");
        r2 = r116;
        r2.add(new rs8.j("next_group_msg", 2131380347, "", ContextCompat.getDrawable(r41.c, 2131242744), null, 0.0f, r5, false, r117, 2131242744, null, null, r118, 3248));
        goto L545
    L496:
        r117 = false;
    L498:
        r2 = r116;
        goto L545
    L12:
        if (r4.equals("dislike") == false) goto L237;
        final AnswerActionGenerator$generateDislikeAction$1 r59 = new AnswerActionGenerator$generateDislikeAction$1(this.a);
        Intrinsics.checkNotNullParameter(r44, "msg");
        Intrinsics.checkNotNullParameter(r5, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter("dislike", "key");
        Intrinsics.checkNotNullParameter(r59, "chatKey");
        Drawable r119 = z.f(r41.c, 2130971700, 2131241190);
        if (z2.a.c1() == false) goto L33;
        com.larus.bmhome.chat.api.q0.a r60 = r41.e;
        if (r60 == null) goto L21;
        u7 r61 = r60.u3();
        if (r61 == null) goto L21;
        Integer r120 = r61.n00(r44.getLocalMessageId());
    L23:
        if (com.larus.bmhome.chat.bean.d.h0(r44) == false) goto L27;
        if (r120 != null) goto L26;
    L31:
        boolean r121 = true;
    L34:
        int r62 = com.larus.utils.j0.a;
        r2 = CollectionsKt.listOf(new rs8.j("dislike", 2131380343, "", r119, null, 0.0f, r5, r121, false, null, null, com.larus.utils.j0.d(2131898813), new s(r44, r41, r59), 1840));
        goto L545
    L26:
        if (r120.intValue() == (-1)) goto L31;
    L27:
        if (r120 != null) goto L30;
    L32:
        r121 = false;
        goto L34
    L30:
        if (r120.intValue() != (-1)) goto L32;
    L21:
        r120 = null;
        goto L23
    L33:
        r121 = com.larus.bmhome.chat.bean.d.h0(r44);
        goto L34
    L36:
        if (r4.equals("previous_group_msg") == false) goto L237;
        ArrayList r122 = new ArrayList();
        Integer r63 = com.larus.im.bean.message.a.M(r44);
        if (r63 == null) goto L47;
        final int r123 = r63.intValue();
        final String r64 = com.larus.im.bean.message.a.D(r44);
        if (r64 == null) goto L47;
        if (r123 <= 0) goto L45;
        boolean r124 = true;
    L46:
        final boolean r65 = r124;
        Function1 r66 = new o1(r65, this, r44, r64, r123);
        Intrinsics.checkNotNullParameter(r44, "msg");
        Intrinsics.checkNotNullParameter(r5, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter("previous_group_msg", "key");
        Intrinsics.checkNotNullParameter(r66, "onClick");
        r2 = r122;
        r2.add(new rs8.j("previous_group_msg", 2131380349, "", ContextCompat.getDrawable(r41.c, 2131242759), null, 0.0f, r5, false, r124, 2131242759, null, null, r66, 3248));
        goto L545
    L45:
        r124 = false;
    L47:
        r2 = r122;
        goto L545
    L49:
        if (r4.equals("share") == false) goto L237;
        com.larus.bmhome.chat.api.q0 r67 = this.a.f();
        if (r67 == null) goto L54;
        com.larus.bmhome.chat.api.q0.a r68 = r67.getProvider();
    L56:
        if (z2.a.getShareConfig().f() == false) goto L92;
        if (r68 == null) goto L64;
        IChatMessageShareAbility r69 = r68.J9();
        if (r69 == null) goto L64;
        if (r69.yk(r44) != true) goto L64;
        boolean r70 = true;
    L65:
        if (r70 == false) goto L92;
        com.larus.bmhome.chat.component.cvs.y r71 = r68.u0();
        if (r71 == null) goto L74;
        BotModel r72 = r71.j0();
        if (r72 == null) goto L74;
        ShareInfo r73 = r72.getShareInfo();
        if (r73 == null) goto L74;
        boolean r74 = Intrinsics.areEqual(r73.isShowMessageShare(), Boolean.TRUE);
    L75:
        if (r74 == false) goto L92;
        IFlowSdkDepend r75 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r75 == null) goto L90;
        FlowAppletServiceImpl r76 = r75.g0();
        if (r76 == null) goto L90;
        com.larus.bmhome.chat.api.q0 r77 = r68.e();
        if (r77 == null) goto L86;
        com.larus.bmhome.chat.api.h0 r78 = r77.A7();
        if (r78 == null) goto L86;
        wc9.e r79 = (wc9.e) r78.invoke();
    L88:
        if (r76.m(r79) != true) goto L90;
        boolean r80 = true;
    L91:
        if (r80 == true) goto L92;
        boolean r210 = true;
    L94:
        if (r210 == false) goto L110;
        com.larus.bmhome.chat.api.q0 r81 = this.a.f();
        if (r81 == null) goto L100;
        com.larus.bmhome.chat.api.h0 r82 = r81.A7();
        if (r82 == null) goto L100;
        final wc9.e r83 = (wc9.e) r82.invoke();
    L102:
        if (Intrinsics.areEqual(r42.getNeedShowName(), Boolean.TRUE) == false) goto L104;
        final String r84 = r42.getName();
    L105:
        Intrinsics.checkNotNullParameter(r44, "msg");
        Intrinsics.checkNotNullParameter(r5, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter("share", "key");
        if (r84 != null) goto L108;
        String r125 = r20;
    L109:
        Context r85 = r41.c;
        Drawable r126 = ContextCompat.getDrawable(r85, v19.c.b(2130971761, r85, 2131241548));
        Integer r211 = Integer.valueOf(v19.c.b(2130971761, r41.c, 2131241548));
        int r86 = com.larus.utils.j0.a;
        r2 = CollectionsKt.listOf(new rs8.j("share", 2131380354, r125, r126, null, 0.0f, r5, false, false, r211, null, com.larus.utils.j0.d(2131898834), new r(r41, r83, r44, r84), 1456));
        goto L545
    L108:
        r125 = r84;
        goto L109
    L104:
        r84 = r20;
    L100:
        r83 = null;
        goto L102
    L110:
        r2 = CollectionsKt.emptyList();
    L86:
        r79 = null;
    L90:
        r80 = false;
    L74:
        r74 = false;
    L64:
        r70 = false;
    L92:
        r210 = false;
        goto L94
    L54:
        r68 = null;
        goto L56
    L112:
        if (r4.equals("like") == false) goto L237;
        final AnswerActionGenerator$generateLikeAction$1 r87 = new AnswerActionGenerator$generateLikeAction$1(this.a);
        Intrinsics.checkNotNullParameter(r44, "msg");
        Intrinsics.checkNotNullParameter(r5, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter("like", "key");
        Intrinsics.checkNotNullParameter(r87, "chatKey");
        Drawable r127 = z.f(r41.c, 2130971750, 2131241486);
        if (z2.a.c1() == false) goto L136;
        com.larus.bmhome.chat.api.q0.a r88 = r41.e;
        if (r88 == null) goto L121;
        u7 r89 = r88.u3();
        if (r89 == null) goto L121;
        Integer r128 = r89.n00(r44.getLocalMessageId());
    L123:
        if (com.larus.bmhome.chat.bean.d.q0(r44) == false) goto L129;
        if (r128 == null) goto L134;
        int r129 = 1;
        if (r128.intValue() == 1) goto L134;
    L130:
        if (r128 != null) goto L133;
    L135:
        boolean r130 = false;
    L137:
        int r90 = com.larus.utils.j0.a;
        r2 = CollectionsKt.listOf(new rs8.j("like", 2131380345, "", r127, null, 0.0f, r5, r130, false, null, null, com.larus.utils.j0.d(2131898821), new b(r44, r41, r87), 1840));
        goto L545
    L133:
        if (r128.intValue() != r129) goto L135;
    L134:
        r130 = true;
        goto L137
    L129:
        r129 = 1;
    L121:
        r128 = null;
        goto L123
    L136:
        r130 = com.larus.bmhome.chat.bean.d.q0(r44);
        goto L137
    L139:
        if (r4.equals("copy") == false) goto L237;
        r2 = CollectionsKt.listOf(a(false, r41, r44, r45, r5, null, r46));
        goto L545
    L143:
        if (r4.equals("tts") == false) goto L237;
        r1 = true;
        goto L184
    L147:
        if (r4.equals("deep_search") == false) goto L237;
        AnswerActionGenerator$generateDeepSearchAction$deeSearch$1 r91 = new AnswerActionGenerator$generateDeepSearchAction$deeSearch$1(this.a);
        Intrinsics.checkNotNullParameter(r44, "msg");
        Intrinsics.checkNotNullParameter(r5, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter("deep_search", "key");
        Intrinsics.checkNotNullParameter(r91, "chatKey");
        boolean r92 = true;
        rs8.j r93 = new rs8.j("deep_search", 2131380342, r41.c.getString(2131909110), ContextCompat.getDrawable(r41.c, 2131241167), null, 0.0f, r5, false, false, null, null, null, new c(r41, r44), 4016);
        com.larus.bmhome.chat.api.q0 r94 = this.a.f();
        if (r94 == null) goto L154;
        ChatMessageList r95 = r94.B7();
        if (r95 == null) goto L154;
        Object r131 = r95.getTag(2131384073);
    L156:
        if (TypeIntrinsics.isMutableSet(r131) == false) goto L158;
        Set r132 = (Set) r131;
    L159:
        Triple r96 = new Triple(r44.getMessageId(), 2131909110, "deep_search_entry_show");
        if (r132 != null) goto L162;
    L164:
        r92 = false;
    L165:
        if (r92 == false) goto L179;
        ILegacyChatUiServiceDelegate r97 = ILegacyChatUiServiceDelegate.b;
        de8.c r99 = this.a.q();
        if (r99 == null) goto L169;
        String r100 = r99.p();
    L170:
        String r101 = r44.getMessageId();
        String r102 = r44.getConversationId();
        de8.c r103 = this.a.q();
        if (r103 == null) goto L174;
        String r104 = r103.f();
        if (r104 == null) goto L174;
    L178:
        r97.w8(r100, r101, r102, r104);
        r132.add(r96);
    L174:
        ChatParam r105 = this.a.l();
        if (r105 == null) goto L177;
        r104 = r105.b;
        goto L178
    L177:
        r104 = null;
        goto L178
    L169:
        r100 = null;
    L179:
        r2 = CollectionsKt.listOf(r93);
        goto L545
    L162:
        if (r132.contains(r96) == true) goto L164;
    L158:
        r132 = null;
    L154:
        r131 = null;
        goto L156
    L222:
        if (r4.equals("convert-doc") == false) goto L237;
        if (r44.getContentType() == 1) goto L229;
        if (com.larus.bmhome.chat.bean.d.k(r44) == true) goto L229;
    L233:
        r2 = CollectionsKt.emptyList();
    L229:
        if (com.larus.bmhome.chat.adapter.h0.e(r44) == true) goto L233;
        if (com.larus.bmhome.chat.bean.d.b0(r44) == true) goto L233;
        Intrinsics.checkNotNullParameter(r44, "msg");
        Intrinsics.checkNotNullParameter(r5, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter("convert-doc", "key");
        Context r106 = r41.c;
        r2 = CollectionsKt.listOf(new rs8.j("convert-doc", 2131380344, "", ContextCompat.getDrawable(r106, v19.c.b(2130971704, r106, 2131241208)), null, 0.0f, r5, false, false, Integer.valueOf(v19.c.b(2130971704, r41.c, 2131241208)), null, null, new t(r44, r41), 3504));
        goto L545
    L235:
        if (r4.equals("regenerate") == false) goto L237;
        ArrayList r107 = new ArrayList();
        if (AccountService.a.isLogin().booleanValue() == true) goto L244;
        if (z2.a.s0() == true) goto L244;
    L245:
        ArrayList r410 = r107;
    L293:
        ArrayList r108 = r410;
    L544:
        return r108;
    L244:
        if (com.larus.bmhome.chat.bean.d.b0(r44) == true) goto L245;
        if (com.larus.bmhome.chat.bean.d.x0(r44) == true) goto L245;
        Map r109 = r44.getExt();
        if (r109 == null) goto L252;
        String r133 = (String) r109.get("clear_context");
    L254:
        if (Intrinsics.areEqual(r133, "1") == true) goto L245;
        Map r134 = r44.getExt();
        if (r134 == null) goto L259;
        String r135 = (String) r134.get("disable_regen");
    L261:
        if (Intrinsics.areEqual(r135, "1") == true) goto L245;
        if (k99.d.a(r44) == true) goto L245;
        com.larus.bmhome.chat.api.q0 r136 = this.a.f();
        if (r136 == null) goto L275;
        ChatMessageList r137 = r136.B7();
        if (r137 == null) goto L275;
        Fragment r138 = com.larus.utils.e1.k(r137);
        if (r138 == null) goto L275;
        t1a.b r139 = s1a.a.g(r138);
        if (r139 == null) goto L275;
        ss8.g r140 = (ss8.g) r139.getAbility(ss8.g.class);
    L276:
        if (r140 != null) goto L278;
    L280:
        boolean r141 = false;
    L281:
        if (r141 == true) goto L245;
        final com.larus.bmhome.chat.component.regen.a r142 = this.a.n();
        if (r142 == null) goto L245;
        boolean r143 = r142.gB(r44);
        if (r142.nS(r44) == false) goto L290;
        if (r143 == false) goto L290;
        boolean r144 = true;
    L291:
        FLogger r145 = FLogger.a;
        r410 = r107;
        StringBuilder r146 = new StringBuilder("generateRegenerateActions validFor=");
        r146.append(r144);
        r146.append(" canShowRegenerateBtn=");
        r146.append(r143);
        r146.append(" msgId=");
        r146.append(r44.getMessageId());
        r146.append(" localMsgId=");
        r146.append(r44.getLocalMessageId());
        r146.append(" replyId=");
        r146.append(r44.getReplyId());
        r146.append(" contentType=");
        r146.append(r44.getContentType());
        r146.append(" localIndex=");
        String r147 = "description";
        r146.append(r44.getLocalIndex());
        r146.append(" regenStatus=");
        r146.append(r44.getRegenStatus());
        r145.i("ActionbarComponent", r146.toString());
        if (r144 == false) goto L293;
        RegenStatus.a r148 = RegenStatus.Companion;
        int r149 = r44.getRegenStatus();
        r148.getClass();
        boolean r150 = ArraysKt.contains(new Integer[]{1, 2}, Integer.valueOf(r149));
        boolean r151 = ArraysKt.contains(new Integer[]{2, 3}, Integer.valueOf(r44.getRegenStatus()));
        if (r150 == true) goto L352;
        com.larus.bmhome.chat.api.q0 r152 = this.a.f();
        if (r152 == null) goto L305;
        com.larus.bmhome.chat.api.h0 r153 = r152.A7();
        if (r153 == null) goto L305;
        wc9.e r154 = (wc9.e) r153.invoke();
        if (r154 == null) goto L305;
        if (r154.h() != true) goto L305;
        boolean r155 = true;
    L306:
        if (r155 == true) goto L352;
        if (com.larus.bmhome.chat.bean.d.M0(r44) == true) goto L352;
        if (r142.DO() == true) goto L352;
        com.larus.bmhome.chat.api.q0 r156 = this.a.f();
        if (r156 == null) goto L338;
        List r157 = r156.getCurrentList();
        if (r157 == null) goto L338;
        Iterator r158 = r157.iterator();
    L317:
        if (r158.hasNext() == false) goto L336;
        Object r159 = r158.next();
        Iterator r411 = r158;
        Message r160 = (Message) r159;
        String r161 = r147;
        Object r162 = r159;
        if (r160.getUserType() != 2) goto L331;
        Intrinsics.checkNotNullParameter(r160, r0);
        String r163 = r160.getMessageId();
        String r212 = r0;
        if (r163 == null) goto L325;
        String r213 = r9;
        String r214 = r15;
        rs8.j r164 = null;
        if (StringsKt.contains$default(r163, ":", false, 2, null) != true) goto L326;
        boolean r165 = true;
    L327:
        if (r165 == false) goto L329;
    L332:
        boolean r166 = false;
    L333:
        if (r166 == true) goto L337;
        r158 = r411;
        r147 = r161;
        r0 = r212;
        r15 = r214;
        r9 = r213;
    L337:
        Message r167 = (Message) r162;
    L340:
        if (Intrinsics.areEqual(r167, r44) == true) goto L349;
        if (r167 != null) goto L343;
    L345:
        boolean r168 = false;
    L346:
        if (r168 == true) goto L349;
        boolean r169 = false;
    L350:
        if (r169 == false) goto L353;
        boolean r170 = true;
    L354:
        FLogger r171 = FLogger.a;
        StringBuilder r172 = new StringBuilder("generateRegenerateActions shouldShowRecreateAction=");
        r172.append(r170);
        r172.append(" hasNext=");
        r172.append(r150);
        r172.append(" hasPre=");
        r172.append(r151);
        r172.append(" conversationDisabled=");
        com.larus.bmhome.chat.api.q0 r173 = this.a.f();
        if (r173 == null) goto L363;
        com.larus.bmhome.chat.api.h0 r174 = r173.A7();
        if (r174 == null) goto L363;
        wc9.e r175 = (wc9.e) r174.invoke();
        if (r175 == null) goto L363;
        if (r175.h() != true) goto L363;
        boolean r176 = true;
    L364:
        r172.append(r176);
        r172.append(" isReplySpringMark=");
        r172.append(com.larus.bmhome.chat.bean.d.M0(r44));
        r172.append(" noRegenAction=");
        r172.append(r142.DO());
        r172.append(" msgId=");
        r172.append(r44.getMessageId());
        r172.append(" localMsgId=");
        r172.append(r44.getLocalMessageId());
        r171.i("ActionbarComponent", r172.toString());
        if (r170 == false) goto L367;
        rs8.j r177 = r41.e(r44, r5, new AnswerActionGenerator$generateRegenerateActions$recreateAction$1(this.a), new q1(r142, r44));
    L368:
        if (r151 == true) goto L370;
        if (r150 == true) goto L370;
    L393:
        if (r150 == false) goto L395;
        rs8.j r178 = r41.d(r44, r5);
    L399:
        r108 = r410;
        if (r164 == null) goto L402;
        r108.add(r164);
    L402:
        if (r178 == null) goto L404;
        r108.add(r178);
    L404:
        if (r177 == null) goto L544;
        r108.add(r177);
        goto L544
    L395:
        if (r151 == false) goto L398;
        if (r177 != null) goto L398;
        r178 = rs8.j.e(r41.d(r44, r5), false);
    L398:
        r178 = null;
    L370:
        Intrinsics.checkNotNullParameter(r44, r213);
        Intrinsics.checkNotNullParameter(r5, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter("regen_prev", r214);
        Context r179 = r41.c;
        Drawable r180 = ContextCompat.getDrawable(r179, v19.c.b(2130971635, r179, 2131240791));
        int r181 = com.larus.utils.j0.a;
        String r182 = com.larus.utils.j0.d(2131898828);
        rs8.i r183 = new e(r44, r41);
        if ((1 & 1936) == 0) goto L373;
        String r215 = null;
    L375:
        if ((1936 & 8) == 0) goto L377;
        Drawable r310 = null;
    L379:
        if ((1936 & 64) == 0) goto L381;
        MessageActionBarAlign r184 = MessageActionBarAlign.START;
    L383:
        if ((1936 & 1024) == 0) goto L385;
        rs8.j r185 = ActionStyle.NORMAL;
    L387:
        if ((1936 & 2048) == 0) goto L390;
        r182 = r20;
    L390:
        if ((1936 & 4096) == 0) goto L392;
        r183 = new rs8.i();
    L392:
        String r186 = r161;
        Intrinsics.checkNotNullParameter("", r186);
        Intrinsics.checkNotNullParameter(r184, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r185, "style");
        Intrinsics.checkNotNullParameter(r182, "accessibilityContent");
        Intrinsics.checkNotNullParameter(r183, "onClick");
        Intrinsics.checkNotNullParameter("", r186);
        Intrinsics.checkNotNullParameter(r184, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r185, "style");
        Intrinsics.checkNotNullParameter(r182, "accessibilityContent");
        Intrinsics.checkNotNullParameter(r183, "onClick");
        r164 = new rs8.j(r215, 2131380348, "", r310, null, 0.0f, r184, false, r151, null, r185, r182, r183);
        goto L393
    L385:
        r185 = r164;
        goto L387
    L381:
        r184 = r5;
        goto L383
    L377:
        r310 = r180;
        goto L379
    L373:
        r215 = "regen_prev";
        goto L375
    L367:
        r177 = r164;
    L363:
        r176 = false;
    L353:
        r170 = false;
        goto L354
    L343:
        if (com.larus.bmhome.chat.bean.d.E0(r167) != true) goto L345;
        r168 = true;
    L349:
        r169 = true;
        goto L350
    L329:
        if (ObricChatSPIServiceDelegate.b.h(r160) == true) goto L332;
        r166 = true;
    L326:
        r165 = false;
        goto L327
    L325:
        r213 = r9;
        r214 = r15;
        r164 = null;
        goto L326
    L331:
        r212 = r0;
        r213 = r9;
        r214 = r15;
        r164 = null;
        goto L332
    L336:
        r213 = r9;
        r161 = r147;
        r214 = r15;
        r164 = null;
        r162 = null;
    L338:
        r213 = "msg";
        r161 = r147;
        r214 = "key";
        r164 = null;
        r167 = null;
    L305:
        r155 = false;
    L352:
        r213 = "msg";
        r161 = r147;
        r214 = "key";
        r164 = null;
    L290:
        r144 = false;
        goto L291
    L278:
        if (r140.bc(ChatUIBlockConfig.DISABLE_MESSAGE_INTERACTION) != true) goto L280;
        r141 = true;
    L275:
        r140 = null;
        goto L276
    L259:
        r135 = null;
        goto L261
    L252:
        r133 = null;
        goto L254
    L408:
        if (r4.equals("single-collection") == true) goto L411;
    L433:
        r23 = null;
        goto L454
    L411:
        if (com.larus.bmhome.chat.bean.d.y0(r44) == false) goto L413;
    L430:
        r2 = CollectionsKt.emptyList();
        goto L545
    L413:
        if (r44.getContentType() != 1) goto L415;
    L418:
        IFlowSdkDepend r187 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r187 == null) goto L423;
        r187.getCollectService();
        if (com.larus.home.impl.sdk.j1.a.e() != true) goto L423;
        boolean r188 = true;
    L424:
        if (r188 == false) goto L430;
        boolean r189 = com.larus.bmhome.chat.bean.d.B0(r44);
        Intrinsics.checkNotNullParameter(r44, "message");
        Intrinsics.checkNotNullParameter(r5, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter("single-collection", "key");
        if (r189 == false) goto L428;
        Context r190 = r41.c;
        Drawable r191 = ContextCompat.getDrawable(r190, v19.c.b(2130971637, r190, 2131240827));
        Integer r216 = Integer.valueOf(v19.c.b(2130971637, r41.c, 2131240827));
        int r192 = com.larus.utils.j0.a;
        rs8.j r193 = new rs8.j("single-collection", 2131380355, "", r191, null, 0.0f, r5, false, false, r216, null, com.larus.utils.j0.d(2131898810), new w(r41, r44), 1456);
    L429:
        r2 = CollectionsKt.listOf(r193);
        goto L545
    L428:
        Context r194 = r41.c;
        Drawable r195 = ContextCompat.getDrawable(r194, v19.c.b(2130971638, r194, 2131240830));
        Integer r217 = Integer.valueOf(v19.c.b(2130971638, r41.c, 2131240830));
        int r196 = com.larus.utils.j0.a;
        r193 = new rs8.j("single-collection", 2131380355, "", r195, null, 0.0f, r5, false, false, r217, null, com.larus.utils.j0.d(2131898810), new x(r41, r44), 1456);
    L423:
        r188 = false;
        goto L424
    L415:
        if (com.larus.bmhome.chat.bean.d.a0(r44) == true) goto L418;
        if (com.larus.bmhome.chat.bean.d.k(r44) == false) goto L430;
    L432:
        if (r4.equals("collection") == false) goto L433;
        if (com.larus.bmhome.chat.bean.d.y0(r44) == false) goto L437;
    L450:
        r2 = CollectionsKt.emptyList();
        goto L545
    L437:
        if (r44.getContentType() != 1) goto L439;
    L442:
        IFlowSdkDepend r197 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r197 == null) goto L447;
        r197.getCollectService();
        if (com.larus.home.impl.sdk.j1.a.e() != true) goto L447;
        boolean r198 = true;
    L448:
        if (r198 == false) goto L450;
        Intrinsics.checkNotNullParameter(r44, "message");
        Intrinsics.checkNotNullParameter(r5, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter("collection", "key");
        Context r199 = r41.c;
        Drawable r1100 = ContextCompat.getDrawable(r199, v19.c.b(2130971638, r199, 2131240830));
        Integer r218 = Integer.valueOf(v19.c.b(2130971638, r41.c, 2131240830));
        int r200 = com.larus.utils.j0.a;
        r2 = CollectionsKt.listOf(new rs8.j("collection", 2131380339, "", r1100, null, 0.0f, r5, false, false, r218, null, com.larus.utils.j0.d(2131898810), new v(r41, r44), 1456));
    L447:
        r198 = false;
        goto L448
    L439:
        if (com.larus.bmhome.chat.bean.d.a0(r44) == true) goto L442;
        if (com.larus.bmhome.chat.bean.d.k(r44) == false) goto L450;
    L237:
        r23 = null;
        goto L501
    L499:
        r20 = "";
        goto L237
    L5:
        r3 = MessageActionBarAlign.START;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.s1] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.r1, java.lang.Object] */
    public final rs8.j a(boolean r29, final z r30, final Message r31, final BotModel r32, final MessageActionBarAlign r33, final CustomMarkdownTextView r34, final rs8.h r35) {
        final ?? r9 = new r1(r31);
        final AnswerActionGenerator$buildCopyAction$2 r10 = new AnswerActionGenerator$buildCopyAction$2(this.a);
        final ?? r12 = new s1(r35, this, r30, r31, r32, r33, r34);
        r30.getClass();
        Intrinsics.checkNotNullParameter(r9, "msgGetter");
        Intrinsics.checkNotNullParameter(r32, "bot");
        Intrinsics.checkNotNullParameter(r33, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r10, "chatKey");
        Intrinsics.checkNotNullParameter("copy", "key");
        if (r29 == false) goto L5;
        Context r2 = r30.c;
        Drawable r16 = ContextCompat.getDrawable(r2, v19.c.b(2130971640, r2, 2131240835));
        Integer r22 = Integer.valueOf(v19.c.b(2130971640, r30.c, 2131240835));
        int r3 = com.larus.utils.j0.a;
        return new rs8.j("copy", 2131380341, "", r16, null, 0.0f, r33, false, false, r22, null, com.larus.utils.j0.d(2131898811), new g(), 1456);
    L5:
        Context r1 = r30.c;
        Drawable r17 = ContextCompat.getDrawable(r1, v19.c.b(2130971639, r1, 2131240833));
        Integer r23 = Integer.valueOf(v19.c.b(2130971639, r30.c, 2131240833));
        int r4 = com.larus.utils.j0.a;
        return new rs8.j("copy", 2131380341, "", r17, null, 0.0f, r33, false, false, r23, null, com.larus.utils.j0.d(2131898811), new h(r9, r30, r10, r34, r12, r32), 1456);
    }
}
