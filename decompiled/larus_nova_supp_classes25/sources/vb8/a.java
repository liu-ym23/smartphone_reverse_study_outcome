package vb8;

import com.larus.bmhome.chat.bean.BotOnBoarding;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.common_ui.widget.TagTextView;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.bot.ShowTagInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.protocol.model.BotCommentInfo;
import com.larus.im.internal.protocol.model.LikeInfo;
import com.larus.platform.service.AccountService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final boolean a(BotModel r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r0 = r7.getBotId();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        List r8 = r7.getTagList();
        Object r2 = null;
        if (r8 == null) goto L25;
        Iterator r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L24;
        Object r3 = r9.next();
        ShowTagInfo r4 = (ShowTagInfo) r3;
        if (r4.getType() == 4) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == false) goto L15;
        r2 = r3;
        goto L24
    L19:
        if (r4.getPosition() != 2) goto L21;
        r5 = true;
    L24:
        r2 = (ShowTagInfo) r2;
    L25:
        if (r2 != null) goto L34;
        return false;
    L34:
        return true;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static final boolean b(BotModel r4) {
        if (r4 == null) goto L10;
        Integer r2 = r4.getBotRecommendStatus();
        if (r2 == null) goto L10;
        if (r2.intValue() != 3) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L30;
        if (r4 == null) goto L19;
        Integer r5 = r4.getBotStatus();
        if (r5 == null) goto L19;
        if (r5.intValue() != (-50)) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L28;
        BotCreatorInfo r7 = r4.getBotCreatorInfo();
        if (r7 == null) goto L24;
        String r8 = r7.getId();
    L26:
        if (Intrinsics.areEqual(r8, AccountService.a.getUserId()) == false) goto L28;
        return true;
    L24:
        r8 = null;
    L28:
        return false;
    L19:
        r6 = false;
        goto L20
    L30:
        return true;
    L10:
        r3 = false;
        goto L11
    }

    public static final boolean c(BotModel r5) {
        if (r5 == null) goto L10;
        Integer r3 = r5.getBotStatus();
        if (r3 == null) goto L10;
        if (r3.intValue() != (-10)) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L19;
        Integer r6 = r5.getBotType();
        if (r6 != null) goto L16;
    L17:
        return true;
    L16:
        if (r6.intValue() != 1) goto L17;
    L19:
        if (b(r5) == false) goto L30;
        if (r5 == null) goto L27;
        Integer r7 = r5.getBotType();
        if (r7 == null) goto L27;
        if (r7.intValue() != 1) goto L27;
        boolean r8 = true;
    L28:
        if (r8 == true) goto L30;
        return true;
    L27:
        r8 = false;
    L30:
        if (r5 == null) goto L37;
        Integer r9 = r5.getBotStatus();
        if (r9 == null) goto L37;
        if (r9.intValue() != (-40)) goto L37;
        boolean r10 = true;
    L38:
        if (r10 == true) goto L48;
        if (r5 == null) goto L46;
        Integer r11 = r5.getBotStatus();
        if (r11 == null) goto L46;
        if (r11.intValue() != (-10)) goto L46;
        boolean r0 = true;
    L47:
        if (r0 == true) goto L48;
    L60:
        return false;
    L46:
        r0 = false;
    L48:
        Integer r1 = r5.getBotType();
        if (r1 == null) goto L60;
        if (r1.intValue() != 0) goto L60;
        BotCreatorInfo r12 = r5.getBotCreatorInfo();
        if (r12 == null) goto L56;
        String r13 = r12.getId();
    L58:
        if (Intrinsics.areEqual(r13, AccountService.a.getUserId()) == true) goto L60;
        return true;
    L56:
        r13 = null;
    L37:
        r10 = false;
    L10:
        r4 = false;
        goto L11
    }

    public static TagTextView.TagStyle d(Integer r2) {
        if (r2 != null) goto L5;
    L6:
        if (r2 != null) goto L9;
    L11:
        if (r2 == null) goto L20;
        if (r2.intValue() != 1) goto L20;
        return TagTextView.TagStyle.ORANGE;
    L20:
        return TagTextView.TagStyle.ORANGE;
    L9:
        if (r2.intValue() != 3) goto L11;
    L18:
        return TagTextView.TagStyle.BLUE;
    L5:
        if (r2.intValue() == 2) goto L18;
        goto L6
    }

    public static final BotModel e(RecommendBot r74) {
        Intrinsics.checkNotNullParameter(r74, "<this>");
        String r2 = r74.o();
        if (r2 != null) goto L5;
        String r5 = "";
    L6:
        String r6 = r74.getName();
        BotIconImage r4 = r74.O();
        if (r4 == null) goto L9;
        String r8 = r4.getUri();
    L10:
        BotIconImage r7 = r74.O();
        if (r7 == null) goto L13;
        String r9 = r7.getTinyUrl();
    L14:
        BotIconImage r10 = r74.O();
        if (r10 == null) goto L17;
        String r11 = r10.getOriginUrl();
    L18:
        BotIconImage r3 = new BotIconImage(r8, r9, r11, null, null, 24, null);
        long r12 = r74.I();
        long r13 = r74.f0();
        List<BotConfItem> r36 = r74.i();
        Integer r14 = r74.r();
        ShareInfo r15 = r74.b0();
        BotCreatorInfo r16 = r74.j();
        if (r16 == null) goto L21;
        String r17 = r16.getName();
    L22:
        BotCreatorInfo r18 = r74.j();
        if (r18 == null) goto L25;
        String r19 = r18.getId();
    L26:
        BotCreatorInfo r110 = r74.j();
        if (r110 == null) goto L31;
        BotIconImage r111 = r110.getAvatar();
        if (r111 == null) goto L31;
        String r112 = r111.getUri();
    L32:
        BotCreatorInfo r113 = r74.j();
        if (r113 == null) goto L37;
        BotIconImage r114 = r113.getAvatar();
        if (r114 == null) goto L37;
        String r115 = r114.getTinyUrl();
    L38:
        BotCreatorInfo r116 = r74.j();
        if (r116 == null) goto L43;
        BotIconImage r117 = r116.getAvatar();
        if (r117 == null) goto L43;
        String r118 = r117.getOriginUrl();
    L44:
        BotCreatorInfo r119 = new BotCreatorInfo(r17, r19, new BotIconImage(r112, r115, r118, null, null, 24, null));
        BotStatistic r31 = r74.q();
        Integer r21 = r74.Z();
        ConversationPage r120 = r74.F();
        String r121 = r74.N();
        Intrinsics.checkNotNullParameter(r74, "<this>");
        String r1 = r74.K();
        if (r1 == null) goto L69;
        switch(r1.hashCode()) {
            case -314497661: goto L65;
            case -259719452: goto L61;
            case 97295: goto L57;
            case 493044106: goto L53;
            case 1550463001: goto L50;
            default: goto L69;
        };
    L50:
        if (r1.equals("deleted") == false) goto L69;
    L70:
        int r20 = -10;
    L72:
        ModelItem r22 = r74.U();
        String r25 = r74.L();
        Boolean r23 = r74.W();
        if (r23 == null) goto L75;
        boolean r30 = r23.booleanValue();
    L76:
        int r24 = (int) r74.a0();
        BotOnBoarding r26 = r74.Y();
        if (r26 == null) goto L82;
        String r27 = r26.d();
        if (r27 == null) goto L82;
        String r42 = r27;
    L83:
        BotOnBoarding r28 = r74.Y();
        if (r28 == null) goto L86;
        List<String> r43 = r28.e();
    L87:
        BotOnBoarding r29 = r74.Y();
        if (r29 == null) goto L93;
        String r32 = r29.b();
        if (r32 == null) goto L93;
        String r44 = r32;
    L94:
        BotOnBoarding r33 = r74.Y();
        if (r33 == null) goto L97;
        int r45 = r33.a();
    L98:
        BotOnBoarding r34 = r74.Y();
        if (r34 == null) goto L101;
        List<Message> r46 = r34.c();
    L102:
        com.larus.im.bean.bot.BotOnBoarding r51 = new com.larus.im.bean.bot.BotOnBoarding(r42, r43, r44, r45, r46);
        String r35 = r74.h();
        SpeakerVoice r210 = r74.i0();
        String r41 = r74.a();
        String r47 = r74.e();
        String r48 = r74.g();
        String r52 = r74.d();
        BgImageInfo r53 = r74.b();
        String r49 = r74.s();
        Boolean r64 = r74.t();
        String r67 = r74.k();
        LikeInfo r72 = r74.R();
        BotCommentInfo r73 = r74.z();
        List<ShowTagInfo> r0 = r74.c0();
        if (r0 == null) goto L105;
        ArrayList r211 = new ArrayList(r0);
    L106:
        ArrayList r122 = r211;
        boolean r212 = r30;
        return new BotModel(r5, r6, r3, r12, Long.valueOf(r13), r14, r15, r119, r122, null, r120, null, r121, Integer.valueOf(r20), null, r21, r22, r210, r25, r212, Integer.valueOf(r24), null, null, null, r35, r31, null, null, null, null, r36, null, 0, r47, r41, r48, null, null, r51, r49, r64, null, false, null, null, r67, r52, r53, null, null, null, null, null, null, null, null, null, null, r72, null, null, r73, null, -1126151680, 1543446065, null);
    L105:
        r211 = null;
        goto L106
    L101:
        r46 = null;
        goto L102
    L97:
        r45 = 0;
    L93:
        r44 = "";
        goto L94
    L86:
        r43 = null;
    L82:
        r42 = "";
        goto L83
    L75:
        r30 = false;
        goto L76
    L53:
        if (r1.equals("reviewing") == false) goto L69;
        r20 = -20;
        goto L72
    L57:
        if (r1.equals("ban") == false) goto L69;
        r20 = -30;
        goto L72
    L61:
        if (r1.equals("rollback") == false) goto L69;
        r20 = -50;
        goto L72
    L65:
        if (r1.equals("private") == false) goto L69;
        r20 = -40;
    L69:
        if (r74.J() == true) goto L70;
        r20 = 10;
    L43:
        r118 = null;
    L37:
        r115 = null;
    L31:
        r112 = null;
        goto L32
    L25:
        r19 = null;
        goto L26
    L21:
        r17 = null;
        goto L22
    L17:
        r11 = null;
        goto L18
    L13:
        r9 = null;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r5 = r2;
        goto L6
    }
}
