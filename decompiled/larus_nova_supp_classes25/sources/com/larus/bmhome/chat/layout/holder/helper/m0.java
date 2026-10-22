package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.c4;
import com.larus.bmhome.chat.layout.holder.menu.item.MenuActionType;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.GroupInfo;
import com.larus.im.bean.bot.GroupKey;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.internal.protocol.model.BotActionScene;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.ExportFileConfig;
import com.larus.platform.service.AccountService;
import com.larus.podcast.IFlowPodcastService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m0 implements t0 {
    public final String a;
    public final List<String> b;

    public static final class a {
    }

    static {
    }

    public m0(String r1) {
        this.a = r1;
        this.b = new ArrayList();
    }

    public static Integer i(JSONObject r2) {
        if (r2 == null) goto L5;
        Object r3 = r2.opt("content_type");
    L7:
        if ((r3 instanceof Number) == false) goto L10;
        return Integer.valueOf(((Number) r3).intValue());
    L10:
        if ((r3 instanceof String) == true) goto L12;
        return null;
    L12:
        return StringsKt.toIntOrNull((String) r3);
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
        ArrayList r0 = (ArrayList) this.b;
        r0.addAll(r2);
    }

    public final boolean e(Message r3) {
        if (r3.getMessageStatusLocal() == 21) goto L9;
        if (r3.getMessageStatusLocal() == 23) goto L9;
        if (com.larus.bmhome.chat.bean.d.d(r3) == true) goto L9;
    L11:
        return false;
    L9:
        if (com.larus.bmhome.chat.bean.d.z0(r3) == true) goto L11;
        return true;
    }

    public static boolean f(Message r3, com.larus.bmhome.chat.api.q0 r4) {
        if (r4 == null) goto L17;
        com.larus.bmhome.chat.api.f0 r2 = r4.s5();
        if (r2 == null) goto L17;
        com.larus.bmhome.chat.component.regen.a r5 = (com.larus.bmhome.chat.component.regen.a) r2.invoke();
        if (r5 == null) goto L17;
        wc9.e r6 = (wc9.e) r4.A7().invoke();
        if (r6 != null) goto L11;
    L13:
        boolean r7 = false;
    L15:
        if (r5.Z2(r3, !r7) != true) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == true) goto L20;
        return false;
    L20:
        if (com.larus.platform.service.z2.a.canLongActionAddRegenerate() == false) goto L24;
        return true;
    L24:
        return false;
    L11:
        if (r6.h() != true) goto L13;
        r7 = true;
    L17:
        r8 = false;
        goto L18
    }

    public static Integer j(Message r4, JSONObject r5) {
        Integer r6 = i(r5);
        if (r6 != null) goto L5;
        int r7 = r4.getContentType();
        if (r7 == 5) goto L36;
        if (r7 == 6) goto L40;
        if (r7 == 2021) goto L36;
        ic8.u.a.getClass();
        UplinkFileEntity r8 = ic8.u.b(r4, null);
        if (r8 != null) goto L15;
        return null;
    L15:
        Integer r2 = r8.getEntityType();
        int r3 = UplinkEntityType.EntityTypeImage.getValue();
        if (r2 != null) goto L19;
    L21:
        UplinkEntityContent r9 = r8.getUplinkEntityContent();
        if (r9 == null) goto L31;
        UplinkFileInfo r10 = r9.getUplinkFileInfo();
        if (r10 == null) goto L31;
        Integer r11 = r10.getFileType();
        int r1 = FileType.FileTypeVideo.getValue();
        if (r11 == null) goto L31;
        if (r11.intValue() != r1) goto L31;
        boolean r12 = true;
    L32:
        if (r12 == true) goto L39;
        return null;
    L39:
        return 5;
    L31:
        r12 = false;
        goto L32
    L19:
        if (r2.intValue() != r3) goto L21;
        return 6;
    L40:
        return 6;
    L36:
        return 5;
    L5:
        return Integer.valueOf(r6.intValue());
    }

    public static boolean k(String r3, wc9.e r4) {
        if (Intrinsics.areEqual(r3, "video_img_question_action") == false) goto L5;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == false) goto L28;
        if (r4 == null) goto L19;
        Integer r6 = r4.j;
        if (r6 == null) goto L19;
        if (r6.intValue() != 2) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
    L25:
        boolean r8 = true;
    L26:
        if (r8 == false) goto L28;
        return true;
    L22:
        if (ic8.n.q(r4) == true) goto L25;
        r8 = false;
    L19:
        r7 = false;
    L28:
        return false;
    L5:
        if (Intrinsics.areEqual(r3, "file_question_action") == true) goto L10;
        if (Intrinsics.areEqual(r3, "creativity_answer_action") == true) goto L10;
        r5 = false;
        goto L11
    }

    public static boolean h(ot8.a r3, boolean r4, boolean r5) {
        if (r5 == true) goto L6;
        return false;
    L6:
        if (r4 == false) goto L12;
        if (r3.getId() != 2131901131) goto L17;
        return true;
    L17:
        return false;
    L12:
        if (r3.getId() != 2131907406) goto L14;
    L15:
        return true;
    L14:
        if (r3.getId() == 2131901131) goto L15;
        return false;
    }

    public static com.larus.bmhome.view.screenmenu.l0 g(Message r1, com.larus.bmhome.chat.api.q0.a r2, JSONObject r3, boolean r4) {
        if (r4 == false) goto L4;
        Integer r5 = j(r1, r3);
        if (r5 != null) goto L9;
    L11:
        if (r5 == null) goto L17;
        if (r5.intValue() != 5) goto L17;
        return com.larus.bmhome.chat.layout.holder.menu.item.w0.c();
    L17:
        return com.larus.bmhome.chat.layout.holder.menu.item.w0.a(r1, r2);
    L9:
        if (r5.intValue() != 6) goto L11;
        return com.larus.bmhome.chat.layout.holder.menu.item.w0.b();
    L4:
        return com.larus.bmhome.chat.layout.holder.menu.item.w0.a(r1, r2);
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r52, Message r53, Function0<Message> r54, com.larus.bmhome.chat.api.q0 r55, BotModel r56, wc9.e r57, com.larus.bmhome.chat.api.q0.a r58, JSONObject r59) {
        Intrinsics.checkNotNullParameter(r52, "context");
        Intrinsics.checkNotNullParameter(r53, "data");
        Intrinsics.checkNotNullParameter(r56, "chatBot");
        ArrayList r10 = new ArrayList();
        String r9 = this.a;
        Integer r1 = j(r53, r59);
        Integer r4 = 1;
        if (r9 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        String r7 = "1";
        GroupInfo r22 = null;
        if (r5 == true) goto L86;
        AccountService r6 = AccountService.a;
        if (r6.isEnterpriseAccount() == false) goto L15;
    L16:
        Integer r8 = com.larus.platform.service.z2.a.attachmentEditConfig().getEnterpriseAttachmentMenuEnabled();
        if (r8 != null) goto L20;
    L22:
        List r11 = r56.getActionScenes();
        if (r11 == null) goto L86;
        Iterator r12 = r11.iterator();
    L26:
        if (r12.hasNext() == false) goto L30;
        Object r23 = r12.next();
        if (Intrinsics.areEqual(((BotActionScene) r23).getScene(), r9) == false) goto L26;
    L31:
        BotActionScene r24 = (BotActionScene) r23;
        if (r24 == null) goto L86;
        List r2 = r24.getActionList();
        if (r2 != null) goto L37;
        r2 = CollectionsKt.emptyList();
    L37:
        if (r1 != null) goto L40;
    L54:
        List r13 = r56.getBotConf();
        if (r13 == null) goto L72;
        Iterator r14 = r13.iterator();
    L58:
        if (r14.hasNext() == false) goto L68;
        Object r15 = r14.next();
        BotConfItem r25 = (BotConfItem) r15;
        Iterator r26 = r14;
        if (Intrinsics.areEqual(r25.getConfGroupKey(), "show_icon") == true) goto L62;
    L64:
        boolean r16 = false;
    L65:
        if (r16 == true) goto L66;
        r14 = r26;
        goto L58
    L66:
        Object r17 = r15;
    L69:
        BotConfItem r18 = (BotConfItem) r17;
        if (r18 == null) goto L72;
        String r19 = r18.getConfValue();
    L73:
        boolean r20 = Intrinsics.areEqual(r19, "1");
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{6, 5, 7}), r1) == false) goto L84;
        if (r20 == true) goto L84;
        ArrayList r3 = new ArrayList();
        Iterator r21 = r2.iterator();
    L78:
        if (r21.hasNext() == false) goto L82;
        Object r27 = r21.next();
        if (Intrinsics.areEqual(((AnswerAction) r27).getKey(), "quote-reply") == true) goto L78;
        r3.add(r27);
        goto L78
    L82:
        r2 = r3;
    L84:
        if (r2.isEmpty() == false) goto L87;
        r2 = CollectionsKt.emptyList();
    L87:
        if (r9 != null) goto L89;
    L92:
        boolean r28 = true;
    L93:
        String r29 = "DynamicMenuGroupCreator";
        if (r28 == true) goto L101;
        if (r2 == null) goto L101;
        if (r2.isEmpty() == false) goto L101;
        FLogger.a.i("DynamicMenuGroupCreator", "actionScene hit but action_list empty, hide menu, scene=" + r9);
        return CollectionsKt.emptyList();
    L101:
        if (r2 == null) goto L104;
        List r30 = CollectionsKt.toMutableList(r2);
        if (r30 == null) goto L104;
    L108:
        boolean r31 = com.larus.platform.service.z2.a.J3();
        List r110 = r56.getAnswerActions();
        if (r110 == null) goto L132;
        Iterator r111 = r110.iterator();
    L112:
        if (r111.hasNext() == false) goto L117;
        Object r112 = r111.next();
        Iterator r210 = r111;
        if (Intrinsics.areEqual(((AnswerAction) r112).getKey(), "fork_conv") == true) goto L118;
        r111 = r210;
    L118:
        AnswerAction r113 = (AnswerAction) r112;
        if (r113 == null) goto L132;
        if (r31 == false) goto L129;
        if (r9 != null) goto L123;
    L126:
        boolean r114 = true;
    L127:
        if (r114 == false) goto L129;
        boolean r115 = true;
    L130:
        if (r115 == false) goto L132;
        AnswerAction r211 = r113;
    L134:
        if (r211 == null) goto L191;
        List r116 = r30;
        ArrayList r117 = r10;
        boolean r118 = r116 instanceof Collection;
        if (r118 == true) goto L138;
    L140:
        Iterator r119 = r116.iterator();
    L142:
        if (r119.hasNext() == false) goto L139;
        String r33 = r9;
        if (Intrinsics.areEqual(((AnswerAction) r119.next()).getKey(), "fork_conv") == true) goto L145;
        r9 = r33;
        goto L142
    L145:
        boolean r32 = false;
    L148:
        if (r32 == false) goto L192;
        if (r118 == true) goto L151;
    L153:
        Iterator r34 = r116.iterator();
    L155:
        if (r34.hasNext() == false) goto L169;
        GroupInfo r120 = ((AnswerAction) r34.next()).getGroup();
        if (r120 == null) goto L159;
        String r121 = r120.getKey();
    L160:
        if (r121 != null) goto L162;
    L165:
        boolean r212 = true;
    L167:
        if ((!r212) == true) goto L155;
        boolean r35 = false;
    L170:
        if (r35 == false) goto L186;
        Iterator r36 = r116.iterator();
    L173:
        if (r36.hasNext() == false) goto L177;
        Object r122 = r36.next();
        if (Intrinsics.areEqual(((AnswerAction) r122).getKey(), "create-conversation") == false) goto L173;
    L178:
        AnswerAction r123 = (AnswerAction) r122;
        if (r123 == null) goto L183;
        GroupInfo r37 = r123.getGroup();
        if (r37 == null) goto L183;
    L188:
        if (r37 != null) goto L190;
        r37 = r211.getGroup();
    L190:
        r30.add(AnswerAction.copy$default(r211, null, null, null, null, null, null, r37, 63, null));
    L183:
        AnswerAction r38 = (AnswerAction) CollectionsKt.lastOrNull(r30);
        if (r38 == null) goto L186;
        r37 = r38.getGroup();
        goto L188
    L177:
        r122 = null;
    L186:
        r37 = null;
        goto L188
    L162:
        if (r121.length() == 0) goto L165;
        r212 = false;
        goto L167
    L159:
        r121 = null;
    L169:
        r35 = true;
        goto L170
    L151:
        if (r116.isEmpty() == false) goto L153;
    L192:
        if (r31 == true) goto L194;
        CollectionsKt.removeAll(r30, new u());
    L194:
        FLogger r39 = FLogger.a;
        StringBuilder r40 = new StringBuilder("Message#");
        r40.append(r53.getMessageId());
        r40.append(" before filter, actions = ");
        List r41 = r30;
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r41, 10));
        Iterator r125 = r41.iterator();
    L196:
        if (r125.hasNext() == false) goto L198;
        r124.add(((AnswerAction) r125.next()).getKey());
        goto L196
    L198:
        r40.append(r124);
        r39.i("DynamicMenuGroupCreator", r40.toString());
        if (r55 == null) goto L207;
        Function0<Fragment> r42 = r55.getHostFragment();
        if (r42 == null) goto L207;
        Fragment r43 = (Fragment) r42.invoke();
        if (r43 == null) goto L207;
        t1a.b r44 = s1a.a.g(r43);
        if (r44 == null) goto L207;
        va8.f0 r45 = (va8.f0) r44.getAbility(va8.f0.class);
    L208:
        if (r45 != null) goto L210;
    L212:
        boolean r46 = false;
    L213:
        if (r55 == null) goto L217;
        Function0<Fragment> r47 = r55.getHostFragment();
        if (r47 == null) goto L217;
        Fragment r48 = (Fragment) r47.invoke();
    L218:
        boolean r49 = c4.a(r48);
        ArrayList r126 = new ArrayList();
        Iterator r50 = r41.iterator();
    L219:
        String r213 = r29;
        if (r50.hasNext() == false) goto L244;
        Object r127 = r50.next();
        AnswerAction r214 = (AnswerAction) r127;
        String r215 = com.larus.bmhome.chat.bean.d.x(r53).getRecordCardMsgId();
        if (r215 != null) goto L224;
    L227:
        boolean r216 = true;
    L228:
        if (r216 == true) goto L239;
        Iterator r217 = r50;
        if (Intrinsics.areEqual(r214.getKey(), "copy") == false) goto L232;
    L240:
        boolean r51 = true;
    L241:
        if (r51 == false) goto L243;
        r126.add(r127);
    L243:
        r29 = r213;
        r50 = r217;
        goto L219
    L232:
        if (Intrinsics.areEqual(r214.getKey(), "delete") == true) goto L240;
        if (Intrinsics.areEqual(r214.getKey(), "select-text") == true) goto L240;
        if (Intrinsics.areEqual(r214.getKey(), "report") == true) goto L240;
        r51 = false;
        goto L241
    L239:
        r217 = r50;
        goto L240
    L224:
        if (r215.length() == 0) goto L227;
        r216 = false;
        goto L228
    L244:
        ArrayList r60 = new ArrayList();
        Iterator r128 = r126.iterator();
    L245:
        String r218 = r7;
        Integer r219 = r4;
        boolean r220 = r49;
        if (r128.hasNext() == false) goto L272;
        Object r129 = r128.next();
        AnswerAction r221 = (AnswerAction) r129;
        if (com.larus.bmhome.chat.bean.d.x0(r53) == false) goto L267;
        Iterator r222 = r128;
        boolean r223 = r46;
        if (Intrinsics.areEqual(r221.getKey(), "share") == false) goto L252;
    L266:
        boolean r61 = false;
    L269:
        if (r61 == false) goto L271;
        r60.add(r129);
    L271:
        r7 = r218;
        r4 = r219;
        r49 = r220;
        r128 = r222;
        r46 = r223;
        goto L245
    L252:
        if (Intrinsics.areEqual(r221.getKey(), "collection") == true) goto L266;
        if (Intrinsics.areEqual(r221.getKey(), "single-collection") == true) goto L266;
        if (Intrinsics.areEqual(r221.getKey(), "cancel_collection") == true) goto L266;
        if (Intrinsics.areEqual(r221.getKey(), "create-conversation") == true) goto L266;
        if (Intrinsics.areEqual(r221.getKey(), "fork_conv") == true) goto L266;
        if (Intrinsics.areEqual(r221.getKey(), "export-file") == true) goto L266;
        if (Intrinsics.areEqual(r221.getKey(), "quote-reply") == true) goto L266;
    L268:
        r61 = true;
        goto L269
    L267:
        r223 = r46;
        r222 = r128;
        goto L268
    L272:
        boolean r224 = r46;
        Intrinsics.checkNotNullParameter(r60, "<this>");
        if (ce8.c.a() == false) goto L292;
        ArrayList r62 = new ArrayList();
        Iterator r63 = r60.iterator();
    L276:
        if (r63.hasNext() == false) goto L291;
        Object r130 = r63.next();
        AnswerAction r131 = (AnswerAction) r130;
        Iterator r225 = r63;
        if (Intrinsics.areEqual(r131.getKey(), "like") == false) goto L280;
    L287:
        boolean r64 = true;
    L288:
        if (r64 == false) goto L290;
        r62.add(r130);
    L290:
        r63 = r225;
        goto L276
    L280:
        if (Intrinsics.areEqual(r131.getKey(), "dislike") == true) goto L287;
        if (Intrinsics.areEqual(r131.getKey(), "copy") == true) goto L287;
        if (Intrinsics.areEqual(r131.getKey(), "select-text") == true) goto L287;
        r64 = false;
        goto L288
    L291:
        r60 = r62;
    L292:
        Intrinsics.checkNotNullParameter(r60, "<this>");
        Intrinsics.checkNotNullParameter(r53, "data");
        if (com.larus.im.bean.message.a.f0(r53) == false) goto L318;
        if (com.larus.bmhome.chat.bean.d.e0(r53) == true) goto L318;
        if (r53.getMessageStatusLocal() != 23) goto L299;
    L300:
        ArrayList r0 = new ArrayList();
        Iterator r65 = r60.iterator();
    L302:
        if (r65.hasNext() == false) goto L316;
        Object r66 = r65.next();
        AnswerAction r67 = (AnswerAction) r66;
        if (Intrinsics.areEqual(r67.getKey(), "tts") == false) goto L306;
    L313:
        boolean r68 = true;
    L314:
        if (r68 == true) goto L302;
        r0.add(r66);
        goto L302
    L306:
        if (Intrinsics.areEqual(r67.getKey(), "quote-reply") == true) goto L313;
        if (Intrinsics.areEqual(r67.getKey(), "export-file") == true) goto L313;
        if (Intrinsics.areEqual(r67.getKey(), "save") == true) goto L313;
        r68 = false;
        goto L314
    L316:
        r60 = r0;
        goto L318
    L299:
        if (r53.getMessageStatusLocal() == 22) goto L300;
    L318:
        if (Intrinsics.areEqual(com.larus.utils.l.b(r53, "need_filter_select"), Boolean.TRUE) == false) goto L326;
        ArrayList r69 = new ArrayList();
        Iterator r70 = r60.iterator();
    L321:
        if (r70.hasNext() == false) goto L325;
        Object r71 = r70.next();
        if (Intrinsics.areEqual(((AnswerAction) r71).getKey(), "select-text") == true) goto L321;
        r69.add(r71);
        goto L321
    L325:
        r60 = r69;
    L326:
        List<AnswerAction> r72 = e.d(e.h(r60, this.b), r53);
        if (r224 == false) goto L330;
        if (r220 == true) goto L330;
        boolean r73 = true;
    L331:
        List<AnswerAction> r74 = CollectionsKt.toMutableList(e.g(e.i(e.c(e.a(e.f(e.e(r72, r73), r220), r53), r53), r53), r53));
        if (r55 == null) goto L344;
        Function0<Fragment> r75 = r55.getHostFragment();
        if (r75 == null) goto L344;
        Fragment r76 = (Fragment) r75.invoke();
        if (r76 == null) goto L344;
        t1a.b r77 = s1a.a.g(r76);
        if (r77 == null) goto L344;
        ss8.g r78 = r77.getAbility(ss8.g.class);
        if (r78 == null) goto L344;
        if (r78.bc(ChatUIBlockConfig.DISABLE_MESSAGE_INTERACTION) != true) goto L344;
        boolean r79 = true;
    L345:
        if (r79 == false) goto L348;
        CollectionsKt.removeAll(r74, new i0());
    L348:
        if (e(r53) == true) goto L351;
        CollectionsKt.removeAll(r74, new j0());
    L351:
        if (com.larus.bmhome.chat.bean.d.a0(r53) == true) goto L357;
        if (com.larus.bmhome.chat.bean.d.k(r53) == false) goto L360;
        if (com.larus.bmhome.chat.bean.d.j1(r53) == true) goto L357;
    L360:
        if (com.larus.im.bean.message.a.i0(r53) == false) goto L363;
        CollectionsKt.removeAll(r74, new l0());
    L363:
        if (com.larus.im.bean.message.a.p0(r53) == false) goto L365;
        CollectionsKt.removeAll(r74, new v());
    L365:
        List<AnswerAction> r80 = r74;
        if ((r80 instanceof Collection) == true) goto L368;
    L370:
        Iterator<T> r81 = r80.iterator();
    L372:
        if (r81.hasNext() == false) goto L376;
        if (Intrinsics.areEqual(((AnswerAction) r81.next()).getKey(), "regenerate") == false) goto L372;
        boolean r82 = true;
    L377:
        if (r82 == true) goto L379;
    L381:
        boolean r83 = false;
    L382:
        if (r83 == true) goto L384;
        CollectionsKt.removeAll(r74, new w());
    L384:
        Iterator<AnswerAction> r84 = r74.iterator();
        int r85 = 0;
    L385:
        int r86 = -1;
        if (r84.hasNext() == false) goto L391;
        if (Intrinsics.areEqual(r84.next().getKey(), "single-collection") == true) goto L392;
        r85 = r85 + 1;
    L392:
        if (r85 < 0) goto L394;
        boolean r87 = true;
    L395:
        Iterator<AnswerAction> r88 = r74.iterator();
        int r89 = 0;
    L397:
        if (r88.hasNext() == false) goto L410;
        AnswerAction r90 = r88.next();
        if (Intrinsics.areEqual(r90.getKey(), "collection") == false) goto L401;
    L406:
        boolean r91 = true;
    L407:
        if (r91 == true) goto L411;
        r89 = r89 + 1;
    L411:
        AnswerAction r92 = (AnswerAction) CollectionsKt.getOrNull(r74, r89);
        if (r92 == null) goto L414;
        GroupInfo r410 = r92.getGroup();
    L415:
        CollectionsKt.removeAll(r74, new x());
        List r93 = CollectionsKt.listOf(new Integer[]{r219, 9999});
        IFlowSdkDepend r94 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r94 == null) goto L420;
        r94.getCollectService();
        if (com.larus.home.impl.sdk.j1.a.e() != true) goto L420;
        boolean r95 = true;
    L421:
        if (r95 == true) goto L423;
    L441:
        BotCreatorInfo r96 = r56.getBotCreatorInfo();
        if (r96 == null) goto L444;
        String r97 = r96.getId();
    L445:
        boolean r99 = Intrinsics.areEqual(r97, AccountService.a.getUserId());
        Integer r100 = r56.getBotStatus();
        if (r100 != null) goto L449;
    L450:
        Integer r101 = r56.getBotStatus();
        if (r101 != null) goto L454;
    L455:
        Integer r102 = r56.getBotStatus();
        if (r102 != null) goto L459;
    L460:
        Integer r103 = r56.getBotStatus();
        if (r103 != null) goto L464;
    L466:
        boolean r104 = false;
    L468:
        int r105 = com.larus.bmhome.chat.manager.l0.a;
        if (com.larus.bmhome.chat.manager.l0.a(r56.getBotType()) == true) goto L471;
    L480:
        CollectionsKt.removeAll(r74, new y());
    L481:
        String r106 = r33;
        if (k(r106, r57) == false) goto L485;
        CollectionsKt.removeAll(r74, new z());
    L485:
        if ((!com.larus.bmhome.chat.bean.d.Z(r53)) == true) goto L488;
        CollectionsKt.removeAll(r74, new d0());
    L488:
        if (com.larus.bmhome.chat.bean.d.A0(r53) == false) goto L490;
        CollectionsKt.removeAll(r74, new e0());
    L490:
        Iterator<AnswerAction> r107 = r74.iterator();
        int r108 = 0;
    L492:
        if (r107.hasNext() == false) goto L497;
        if (Intrinsics.areEqual(r107.next().getKey(), "convert-doc") == true) goto L495;
        r108 = r108 + 1;
        goto L492
    L495:
        r86 = r108;
    L497:
        AnswerAction r109 = (AnswerAction) CollectionsKt.getOrNull(r74, r86);
        if (r109 == null) goto L500;
        r22 = r109.getGroup();
    L500:
        GroupInfo r310 = r22;
        CollectionsKt.removeAll(r74, new f0());
        if (r86 < 0) goto L510;
        if (CollectionsKt.listOf(new Integer[]{r219, 9999}).contains(Integer.valueOf(r53.getContentType())) == false) goto L510;
        if (com.larus.bmhome.chat.adapter.h0.e(r53) == true) goto L510;
        if (com.larus.im.bean.message.a.W(r53) == true) goto L510;
        ListProtector.add(r74, r86, new AnswerAction(null, "convert-doc", null, null, null, null, r310, 61, null));
    L510:
        ExportFileConfig r132 = com.larus.platform.service.z2.a.exportFileConfig();
        if (AppHost.a.isOversea() == true) goto L531;
        if (r132.getEnableMenuExportToDoc() == false) goto L531;
        if (r132.getEnableMenuCreateDoc() == false) goto L531;
        List<AnswerAction> r133 = r74;
        if ((r133 instanceof Collection) == true) goto L519;
    L521:
        Iterator<T> r134 = r133.iterator();
    L523:
        if (r134.hasNext() == false) goto L527;
        if (Intrinsics.areEqual(((AnswerAction) r134.next()).getKey(), "convert-doc") == false) goto L523;
        boolean r135 = true;
    L528:
        if (r135 == false) goto L531;
        CollectionsKt.removeAll(r74, new g0());
    L527:
        r135 = false;
        goto L528
    L519:
        if (r133.isEmpty() == false) goto L521;
    L531:
        if (com.larus.bmhome.chat.bean.d.x(r53).getSupportPodcastGenerate() == true) goto L533;
        CollectionsKt.removeAll(r74, new h0());
    L533:
        FLogger r136 = FLogger.a;
        StringBuilder r137 = new StringBuilder("Message#");
        r137.append(r53.getMessageId());
        r137.append(" after filter, actions = ");
        List<AnswerAction> r138 = r74;
        ArrayList r139 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r138, 10));
        Iterator<T> r140 = r138.iterator();
    L535:
        if (r140.hasNext() == false) goto L537;
        r139.add(((AnswerAction) r140.next()).getKey());
        goto L535
    L537:
        r137.append(r139);
        r136.i(r213, r137.toString());
        if (Intrinsics.areEqual(r106, "creativity_answer_action") == false) goto L540;
    L543:
        boolean r141 = true;
    L544:
        ArrayList r142 = r117;
        d(r117, r52, r74, r53, r54, r55, r58, r59, r141, r106);
        v1.d(r142, r53, r57, r58);
        IObricChatUIService r143 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r143 == null) goto L547;
        r143.M(r52, r53, r56, r57, r142);
        Unit r144 = Unit.INSTANCE;
    L547:
        HashSet r145 = new HashSet();
        ArrayList r146 = new ArrayList();
        Iterator r147 = r142.iterator();
    L549:
        if (r147.hasNext() == false) goto L557;
        Object r148 = r147.next();
        ot8.a r149 = (ot8.a) r148;
        if ((r149 instanceof com.larus.bmhome.view.screenmenu.i0) == false) goto L553;
        String r150 = UUID.randomUUID().toString();
    L555:
        if (r145.add(r150) == false) goto L549;
        r146.add(r148);
        goto L549
    L553:
        r150 = String.valueOf(r149.getId());
        goto L555
    L557:
        return r146;
    L540:
        if (Intrinsics.areEqual(r106, "homework_answer_action") == true) goto L543;
        r141 = false;
        goto L544
    L471:
        if (ic8.n.r(r57) == true) goto L480;
        if (r99 == true) goto L478;
        Integer r151 = r56.getBotStatus();
        if (r151 == null) goto L480;
        if (r151.intValue() != 10) goto L480;
    L478:
        if (r99 == false) goto L481;
        if (r104 == true) goto L481;
    L464:
        if (r103.intValue() != (-50)) goto L466;
    L467:
        r104 = true;
        goto L468
    L459:
        if (r102.intValue() == (-40)) goto L467;
    L454:
        if (r101.intValue() == (-20)) goto L467;
    L449:
        if (r100.intValue() == 10) goto L467;
    L444:
        r97 = null;
        goto L445
    L423:
        if (r93.contains(Integer.valueOf(r53.getContentType())) == false) goto L425;
    L426:
        Map r152 = r53.getExt();
        if (r152 == null) goto L429;
        String r153 = (String) r152.get("need_auth_identity");
    L431:
        if (Intrinsics.areEqual(r153, r218) == true) goto L441;
        if (r89 < 0) goto L441;
        if (com.larus.bmhome.utils.i.f(r57) == false) goto L441;
        if (com.larus.bmhome.chat.bean.d.B0(r53) == false) goto L438;
        ListProtector.add(r74, r89, new AnswerAction(null, "cancel_collection", null, null, null, null, r410, 61, null));
        goto L441
    L438:
        if (r87 == false) goto L440;
        ListProtector.add(r74, r89, new AnswerAction(null, "single-collection", null, null, null, null, r410, 61, null));
        goto L441
    L440:
        ListProtector.add(r74, r89, new AnswerAction(null, "collection", null, null, null, null, r410, 61, null));
        goto L441
    L429:
        r153 = null;
        goto L431
    L425:
        if (com.larus.bmhome.chat.bean.d.a0(r53) == false) goto L441;
    L420:
        r95 = false;
        goto L421
    L414:
        r410 = null;
        goto L415
    L401:
        if (Intrinsics.areEqual(r90.getKey(), "single-collection") == true) goto L406;
        if (Intrinsics.areEqual(r90.getKey(), "cancel_collection") == true) goto L406;
        r91 = false;
        goto L407
    L410:
        r89 = -1;
        goto L411
    L394:
        r87 = false;
        goto L395
    L391:
        r85 = -1;
        goto L392
    L379:
        if (f(r53, r55) == false) goto L381;
        r83 = true;
    L376:
        r82 = false;
        goto L377
    L368:
        if (r80.isEmpty() == false) goto L370;
    L357:
        if (com.larus.platform.service.z2.a.enableCreationMsgExportFile() == true) goto L360;
        CollectionsKt.removeAll(r74, new k0());
    L344:
        r79 = false;
    L330:
        r73 = false;
    L217:
        r48 = null;
        goto L218
    L210:
        if (r45.R() != true) goto L212;
        r46 = true;
    L207:
        r45 = null;
    L139:
        r33 = r9;
        r32 = true;
        goto L148
    L138:
        if (r116.isEmpty() == false) goto L140;
    L191:
        r33 = r9;
        r117 = r10;
        goto L192
    L123:
        if (StringsKt.isBlank(r9) == true) goto L126;
        r114 = false;
    L129:
        r115 = false;
        goto L130
    L117:
        r112 = null;
    L132:
        r211 = null;
    L104:
        List r154 = r56.getMenuActions();
        if (r154 == null) goto L107;
        r30 = CollectionsKt.toMutableList(r154);
        goto L108
    L107:
        FLogger.a.w("DynamicMenuGroupCreator", "BotModel menuActions is null, use default actions");
        r30 = CollectionsKt.mutableListOf(new AnswerAction[]{new AnswerAction(null, "like", null, null, null, null, null, 125, null), new AnswerAction(null, "dislike", null, null, null, null, null, 125, null), new AnswerAction(null, "regenerate", null, null, null, null, null, 125, null), new AnswerAction(null, "copy", null, null, null, null, null, 125, null), new AnswerAction(null, "select-text", null, null, null, null, null, 125, null), new AnswerAction(null, "create-conversation", null, null, null, null, null, 125, null), new AnswerAction(null, "export-file", null, null, null, null, null, 125, null), new AnswerAction(null, "search", null, null, null, null, null, 125, null), new AnswerAction(null, "report", null, null, null, null, null, 125, null), new AnswerAction(null, "share", null, null, null, null, null, 125, null), new AnswerAction(null, "collection", null, null, null, null, null, 125, null), new AnswerAction(null, "cancel_collection", null, null, null, null, null, 125, null), new AnswerAction(null, "quote-reply", null, null, null, null, null, 125, null)});
        goto L108
    L89:
        if (StringsKt.isBlank(r9) == true) goto L92;
        r28 = false;
        goto L93
    L62:
        if (Intrinsics.areEqual(r25.getConfKey(), "show_image_icon") == false) goto L64;
        r16 = true;
        goto L65
    L68:
        r17 = null;
    L72:
        r19 = null;
        goto L73
    L40:
        if (r1.intValue() != 5) goto L54;
        Integer r155 = com.larus.platform.service.z2.a.attachmentEditConfig().getCreationVideoCoverFollowUp();
        if (r155 != null) goto L45;
    L46:
        ArrayList r156 = new ArrayList();
        Iterator r157 = r2.iterator();
    L48:
        if (r157.hasNext() == false) goto L53;
        Object r158 = r157.next();
        Iterator r226 = r157;
        if (Intrinsics.areEqual(((AnswerAction) r158).getKey(), "quote-reply") == true) goto L52;
        r156.add(r158);
    L52:
        r157 = r226;
        goto L48
    L53:
        r2 = r156;
        goto L54
    L45:
        if (r155.intValue() == 1) goto L54;
    L30:
        r23 = null;
        goto L31
    L20:
        if (r8.intValue() != 0) goto L22;
    L15:
        if (r6.a() == false) goto L22;
    L86:
        r2 = null;
        goto L87
    L5:
        if (StringsKt.isBlank(r9) == true) goto L8;
        r5 = false;
        goto L9
    }

    public static void c(List r47, String r48, List r49, Message r50, Function0 r51, com.larus.bmhome.chat.api.q0 r52, com.larus.bmhome.chat.api.q0.a r53, JSONObject r54, boolean r55) {
        Iterator r3 = r49.iterator();
    L3:
        com.larus.bmhome.view.screenmenu.l0 r5 = null;
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((AnswerAction) r4).getKey(), r48) == false) goto L3;
    L9:
        AnswerAction r6 = (AnswerAction) r4;
        switch(r48.hashCode()) {
            case -2141375499: goto L128;
            case -1900923220: goto L116;
            case -1741312354: goto L112;
            case -1435723453: goto L108;
            case -1335458389: goto L104;
            case -1281605464: goto L100;
            case -1085143522: goto L94;
            case -934521548: goto L90;
            case -906336856: goto L80;
            case -793123453: goto L76;
            case -330459047: goto L72;
            case 115187: goto L69;
            case 3059573: goto L65;
            case 3108362: goto L59;
            case 3321751: goto L55;
            case 3522941: goto L36;
            case 109400031: goto L30;
            case 169275230: goto L26;
            case 1245108660: goto L20;
            case 1671642405: goto L16;
            case 1751975057: goto L13;
            default: goto L137;
        };
    L137:
        FLogger.a.d("DynamicMenuGroupCreator", "unknown action key: ".concat(r48));
        return;
    L13:
        if (r48.equals("fork_conv") == false) goto L137;
    L22:
        com.larus.bmhome.view.screenmenu.l0 r0 = com.larus.bmhome.chat.layout.holder.menu.item.h0.a(r50, r53, r6);
        if (r0 == null) goto L143;
        ((ArrayList) r47).add(r0);
        return;
    L143:
        return;
    L16:
        if (r48.equals("dislike") == false) goto L137;
        ((ArrayList) r47).add(com.larus.bmhome.chat.layout.holder.menu.item.p.a(r50));
        return;
    L20:
        if (r48.equals("create-conversation") == true) goto L22;
    L26:
        if (r48.equals("select-text") == false) goto L137;
        ((ArrayList) r47).add(com.larus.bmhome.chat.layout.holder.menu.item.u0.a());
        return;
    L30:
        if (r48.equals("share") == false) goto L137;
        com.larus.bmhome.view.screenmenu.l0 r1 = g(r50, r53, r54, r55);
        if (r1 == null) goto L146;
        ((ArrayList) r47).add(r1);
        return;
    L146:
        return;
    L36:
        if (r48.equals("save") == false) goto L137;
        Integer r2 = i(r54);
        if (r2 == null) goto L41;
        int r7 = r2.intValue();
    L43:
        if (r7 != 5) goto L45;
        r5 = com.larus.bmhome.chat.layout.holder.menu.item.s0.b();
    L52:
        if (r5 == null) goto L148;
        ((ArrayList) r47).add(r5);
        return;
    L148:
        return;
    L45:
        if (r7 != 6) goto L47;
        r5 = com.larus.bmhome.chat.layout.holder.menu.item.s0.a();
        goto L52
    L47:
        if (r7 != 7) goto L52;
        r5 = new com.larus.bmhome.view.screenmenu.l0(MenuActionType.DOWNLOAD_FILE.getType(), 2131906511, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971735, null, 2131241420)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127);
        goto L52
    L41:
        r7 = r50.getContentType();
        goto L43
    L55:
        if (r48.equals("like") == false) goto L137;
        ((ArrayList) r47).add(com.larus.bmhome.chat.layout.holder.menu.item.x.a(r50));
        return;
    L59:
        if (r48.equals("edit") == false) goto L137;
        com.larus.bmhome.view.screenmenu.l0 r8 = com.larus.bmhome.chat.layout.holder.menu.item.b0.a(r50, r52, r53);
        if (r8 == null) goto L151;
        ((ArrayList) r47).add(r8);
        return;
    L151:
        return;
    L65:
        if (r48.equals("copy") == false) goto L137;
        ((ArrayList) r47).add(com.larus.bmhome.chat.layout.holder.menu.item.j.a(r6));
        return;
    L69:
        if (r48.equals("tts") == false) goto L137;
    L82:
        if (r51 == null) goto L85;
        Message r9 = (Message) r51.invoke();
        if (r9 == null) goto L85;
    L86:
        com.larus.bmhome.view.screenmenu.l0 r10 = com.larus.bmhome.chat.layout.holder.menu.item.d1.a(r9, r53);
        if (r10 == null) goto L156;
        ((ArrayList) r47).add(r10);
        return;
    L156:
        return;
    L85:
        r9 = r50;
        goto L86
    L72:
        if (r48.equals("quote-reply") == false) goto L137;
        ((ArrayList) r47).add(com.larus.bmhome.chat.layout.holder.menu.item.j0.a(r6));
        return;
    L76:
        if (r48.equals("cancel_collection") == false) goto L137;
        ((ArrayList) r47).add(com.larus.bmhome.chat.layout.holder.menu.item.f.a());
        return;
    L80:
        if (r48.equals("search") == true) goto L82;
    L90:
        if (r48.equals("report") == false) goto L137;
        ((ArrayList) r47).add(com.larus.bmhome.chat.layout.holder.menu.item.n0.a());
        return;
    L94:
        if (r48.equals("convert-doc") == false) goto L137;
        if (com.larus.platform.service.z2.a.exportFileConfig().getEnableMenuCreateDoc() == false) goto L159;
        ((ArrayList) r47).add(com.larus.bmhome.chat.layout.holder.menu.item.q.a());
        return;
    L159:
        return;
    L100:
        if (r48.equals("regenerate") == false) goto L137;
        ((ArrayList) r47).add(com.larus.bmhome.chat.layout.holder.menu.item.i0.a(r50));
        return;
    L104:
        if (r48.equals("delete") == false) goto L137;
        ((ArrayList) r47).add(com.larus.bmhome.chat.layout.holder.menu.item.n.a());
        return;
    L108:
        if (r48.equals("single-collection") == false) goto L137;
        ((ArrayList) r47).add(com.larus.bmhome.chat.layout.holder.menu.item.b1.a());
        return;
    L112:
        if (r48.equals("collection") == false) goto L137;
        ((ArrayList) r47).add(com.larus.bmhome.chat.layout.holder.menu.item.i.a());
        return;
    L116:
        if (r48.equals("generate-podcast") == false) goto L137;
        IFlowPodcastService r11 = (IFlowPodcastService) ServiceManager.get().getService(IFlowPodcastService.class);
        if (r11 == null) goto L121;
        com.larus.bmhome.view.screenmenu.l0 r12 = r11.a(r6);
    L123:
        if ((r12 instanceof com.larus.bmhome.view.screenmenu.l0) == false) goto L125;
        r5 = r12;
    L125:
        if (r5 == null) goto L165;
        ((ArrayList) r47).add(r5);
        return;
    L165:
        return;
    L121:
        r12 = null;
        goto L123
    L128:
        if (r48.equals("export-file") == false) goto L137;
        if (com.larus.bmhome.chat.adapter.h0.e(r50) == true) goto L133;
    L134:
        com.larus.bmhome.view.screenmenu.l0 r13 = com.larus.bmhome.chat.layout.holder.menu.item.t.a(r50, r53);
        if (r13 == null) goto L168;
        ((ArrayList) r47).add(r13);
        return;
    L168:
        return;
    L133:
        if (com.larus.platform.service.z2.a.exportFileConfig().getEnableMenuExportToDoc() == false) goto L134;
        return;
    L8:
        r4 = null;
        goto L9
    }

    public final void d(List<ot8.a> r24, Context r25, List<AnswerAction> r26, Message r27, Function0<Message> r28, com.larus.bmhome.chat.api.q0 r29, com.larus.bmhome.chat.api.q0.a r30, JSONObject r31, boolean r32, String r33) {
        List<AnswerAction> r1 = r26;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        String r4 = ((AnswerAction) r3.next()).getKey();
        if (r4 == null) goto L4;
        r2.add(r4);
        goto L4
    L8:
        ArrayList r15 = new ArrayList();
        if ((!r26.isEmpty()) == false) goto L34;
        Iterator<T> r5 = r1.iterator();
    L12:
        if (r5.hasNext() == false) goto L31;
        Object r6 = r5.next();
        AnswerAction r7 = (AnswerAction) r6;
        if (r7.getGroup() == null) goto L28;
        GroupInfo r8 = r7.getGroup();
        if (r8 == null) goto L18;
        String r9 = r8.getKey();
    L19:
        if (r9 != null) goto L21;
    L24:
        boolean r10 = true;
    L25:
        if (r10 == true) goto L28;
        boolean r11 = false;
    L29:
        if (r11 == false) goto L12;
    L32:
        if (r6 != null) goto L34;
        boolean r12 = true;
    L35:
        if (r30 == null) goto L41;
        com.larus.bmhome.chat.component.collection.o r13 = r30.i2();
        if (r13 == null) goto L41;
        if (r13.i0() != true) goto L41;
        boolean r14 = true;
    L42:
        boolean r16 = com.larus.platform.service.z2.a.W1();
        List r17 = CollectionsKt.emptyList();
        FLogger.a.i("DynamicMenuGroupCreator", "buildDynamicMenuWithDebug, hasServerGrouping:" + r12 + ", isCollectionMode:" + r14 + ", disableReplyFold:" + r16);
        if (r12 == false) goto L148;
        if (r14 == true) goto L148;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r1.iterator();
    L48:
        if (r19.hasNext() == false) goto L56;
        Object r20 = r19.next();
        GroupInfo r110 = ((AnswerAction) r20).getGroup();
        if (r110 == null) goto L52;
        String r21 = r110.getKey();
    L54:
        if (Intrinsics.areEqual(r21, GroupKey.Top.getValue()) == false) goto L48;
        r18.add(r20);
        goto L48
    L52:
        r21 = null;
        goto L54
    L56:
        ArrayList r22 = new ArrayList();
        Iterator r23 = r1.iterator();
    L58:
        if (r23.hasNext() == false) goto L67;
        Object r34 = r23.next();
        GroupInfo r35 = ((AnswerAction) r34).getGroup();
        if (r35 == null) goto L62;
        String r36 = r35.getKey();
    L63:
        Iterator r210 = r23;
        if (Intrinsics.areEqual(r36, GroupKey.First.getValue()) == false) goto L66;
        r22.add(r34);
    L66:
        r23 = r210;
        goto L58
    L62:
        r36 = null;
        goto L63
    L67:
        ArrayList r37 = new ArrayList();
        Iterator r38 = r1.iterator();
    L69:
        if (r38.hasNext() == false) goto L79;
        Object r39 = r38.next();
        GroupInfo r40 = ((AnswerAction) r39).getGroup();
        if (r40 == null) goto L73;
        String r41 = r40.getKey();
    L74:
        Iterator r211 = r38;
        if (Intrinsics.areEqual(r41, GroupKey.Second.getValue()) == false) goto L77;
        r37.add(r39);
    L77:
        r38 = r211;
        goto L69
    L73:
        r41 = null;
        goto L74
    L79:
        if ((!r18.isEmpty()) == false) goto L108;
        ArrayList r42 = new ArrayList();
        Iterator r43 = r18.iterator();
    L82:
        if (r43.hasNext() == false) goto L86;
        String r44 = ((AnswerAction) r43.next()).getKey();
        if (r44 == null) goto L82;
        r42.add(r44);
        goto L82
    L86:
        ArrayList r45 = new ArrayList();
        Iterator r111 = r42.iterator();
    L88:
        if (r111.hasNext() == false) goto L90;
        c(r45, (String) r111.next(), r26, r27, r28, r29, r30, r31, r32);
        r45 = r45;
        r37 = r37;
        r22 = r22;
        r12 = r12;
        r16 = r16;
        goto L88
    L90:
        boolean r212 = r16;
        boolean r213 = r12;
        ArrayList r0 = r45;
        ArrayList r112 = r37;
        ArrayList r113 = r22;
        ArrayList r46 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r47 = r0.iterator();
    L92:
        if (r47.hasNext() == false) goto L95;
        r46.add(Integer.valueOf(((ot8.a) r47.next()).getId()));
        goto L92
    L95:
        if (r0.size() != 2) goto L97;
        boolean r48 = true;
        ((ArrayList) r24).add(new com.larus.bmhome.view.screenmenu.y((ot8.a) ListProtector.get(r0, 0), (ot8.a) ListProtector.get(r0, 1)));
    L105:
        List r49 = r46;
        if ((r0.isEmpty() ^ r48) == false) goto L109;
        Intrinsics.checkNotNullParameter(r25, "context");
        Object r114 = null;
        ((ArrayList) r24).add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r25, v19.c.b(2130972086, null, 2131103159))));
        List r50 = r46;
    L110:
        List r51 = r50;
        LinkedHashMap r52 = new LinkedHashMap();
        Iterator r53 = r113.iterator();
    L112:
        if (r53.hasNext() == false) goto L121;
        Object r54 = r53.next();
        GroupInfo r55 = ((AnswerAction) r54).getGroup();
        if (r55 == null) goto L116;
        int r56 = r55.getPosition();
    L117:
        Integer r57 = Integer.valueOf(r56);
        Object r58 = r52.get(r57);
        if (r58 != null) goto L120;
        r58 = new ArrayList();
        r52.put(r57, r58);
    L120:
        ((List) r58).add(r54);
        goto L112
    L116:
        r56 = 0;
        goto L117
    L121:
        SortedMap r59 = MapsKt.toSortedMap(r52);
        int r60 = r59.size();
        Iterator r115 = r59.entrySet().iterator();
        int r116 = 0;
    L123:
        if (r115.hasNext() == false) goto L137;
        List r61 = (List) ((Map.Entry) r115.next()).getValue();
        Intrinsics.checkNotNull(r61);
        Iterator r117 = r61.iterator();
        List r62 = r51;
    L126:
        if (r117.hasNext() == false) goto L132;
        String r63 = ((AnswerAction) r117.next()).getKey();
        if (r63 == null) goto L131;
        c(r24, r63, r26, r27, r28, r29, r30, r31, r32);
        Unit r64 = Unit.INSTANCE;
    L131:
        r60 = r60;
        r62 = r62;
        goto L126
    L132:
        List r214 = r62;
        int r118 = r60;
        int r65 = r116 + 1;
        if (r65 >= r118) goto L135;
        Intrinsics.checkNotNullParameter(r25, "context");
        Object r66 = null;
        ((ArrayList) r24).add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r25, v19.c.b(2130972086, null, 2131103159))));
    L136:
        r116 = r65;
        r60 = r118;
        r51 = r214;
        r114 = r66;
        goto L123
    L135:
        r66 = null;
        goto L136
    L137:
        List r215 = r51;
        Object r67 = r114;
        ArrayList r68 = new ArrayList();
        Iterator r69 = r112.iterator();
    L139:
        if (r69.hasNext() == false) goto L143;
        String r70 = ((AnswerAction) r69.next()).getKey();
        if (r70 == null) goto L139;
        r68.add(r70);
        goto L139
    L143:
        Iterator r119 = r68.iterator();
    L145:
        if (r119.hasNext() == false) goto L147;
        c(r15, (String) r119.next(), r26, r27, r28, r29, r30, r31, r32);
        r67 = r67;
        goto L145
    L147:
        Unit r71 = Unit.INSTANCE;
        final m0 r72 = this;
        List r73 = r215;
        final boolean r216 = r212;
    L327:
        final boolean r74 = !r213;
        if (Intrinsics.areEqual(r33, "video_img_question_action") == false) goto L330;
    L333:
        boolean r75 = true;
    L334:
        if (r75 == true) goto L357;
        if (Build.VERSION.SDK_INT < 26) goto L357;
        if (r15.size() <= 1) goto L357;
        ArrayList r76 = new ArrayList();
        Iterator<T> r77 = r24.iterator();
    L341:
        if (r77.hasNext() == false) goto L354;
        Object r78 = r77.next();
        ot8.a r120 = (ot8.a) r78;
        if (h(r120, r216, r74) == false) goto L345;
    L350:
        boolean r121 = true;
    L351:
        if (r121 == true) goto L341;
        r76.add(r78);
        goto L341
    L345:
        if (r120.getId() <= 0) goto L350;
        if (r73.contains(Integer.valueOf(r120.getId())) == true) goto L350;
        r121 = false;
        goto L351
    L354:
        if (r76.size() < 3) goto L357;
        CollectionsKt.removeAll(r24, new b0(r72, r216, r74));
        Intrinsics.checkNotNullParameter(r25, "context");
        ArrayList r79 = (ArrayList) r24;
        r79.add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r25, v19.c.b(2130972086, null, 2131103159))));
        r79.add(com.larus.bmhome.chat.layout.holder.menu.item.c0.a(r15));
        return;
    L357:
        if (r75 == true) goto L359;
        CollectionsKt.removeAll(r15, new c0(r72));
    L359:
        Iterator r80 = r15.iterator();
        int r81 = 0;
    L361:
        if (r80.hasNext() == false) goto L375;
        ot8.a r82 = (ot8.a) r80.next();
        if (r82.getId() != 2131900233) goto L365;
    L371:
        boolean r83 = true;
    L372:
        if (r83 == true) goto L376;
        r81 = r81 + 1;
    L376:
        if (r81 < 0) goto L378;
        Intrinsics.checkNotNullParameter(r25, "context");
        ListProtector.add(r15, r81, new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r25, v19.c.b(2130972086, null, 2131103159))));
    L378:
        com.larus.bmhome.view.screenmenu.l0 r84 = com.larus.bmhome.chat.layout.holder.menu.item.l.a();
        if (r84 == null) goto L381;
        r15.add(r84);
    L381:
        ((ArrayList) r24).addAll(r15);
        return;
    L365:
        if (r82.getId() == 2131907182) goto L371;
        if (r75 == true) goto L368;
    L370:
        r83 = false;
        goto L372
    L368:
        if (r82.getId() != 2131901131) goto L370;
    L375:
        r81 = -1;
        goto L376
    L330:
        if (Intrinsics.areEqual(r33, "file_question_action") == true) goto L333;
        r75 = false;
    L109:
        r114 = null;
        r50 = r49;
        goto L110
    L97:
        r48 = true;
        if (r0.size() != 3) goto L100;
        ((ArrayList) r24).add(new com.larus.bmhome.view.screenmenu.o1((ot8.a) ListProtector.get(r0, 0), (ot8.a) ListProtector.get(r0, 1), (ot8.a) ListProtector.get(r0, 2)));
        goto L105
    L100:
        Iterator r85 = r0.iterator();
    L102:
        if (r85.hasNext() == false) goto L104;
        ((ArrayList) r24).add((ot8.a) r85.next());
        goto L102
    L104:
        Unit r86 = Unit.INSTANCE;
        goto L105
    L108:
        r212 = r16;
        r213 = r12;
        r112 = r37;
        r113 = r22;
        r49 = r17;
    L148:
        r216 = r16;
        r213 = r12;
        List r87 = CollectionsKt.listOf(new Integer[]{2131907405, 2131907403});
        if (r2.containsAll(CollectionsKt.listOf(new String[]{"like", "dislike"})) == false) goto L161;
        ArrayList r88 = (ArrayList) r24;
        r88.add(new com.larus.bmhome.view.screenmenu.y(com.larus.bmhome.chat.layout.holder.menu.item.x.a(r27), com.larus.bmhome.chat.layout.holder.menu.item.p.a(r27)));
        Intrinsics.checkNotNullParameter(r25, "context");
        r88.add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r25, v19.c.b(2130972086, null, 2131103159))));
        ArrayList r89 = new ArrayList();
        Iterator r90 = r2.iterator();
    L152:
        if (r90.hasNext() == false) goto L162;
        Object r91 = r90.next();
        String r122 = (String) r91;
        if (Intrinsics.areEqual(r122, "like") == false) goto L156;
    L158:
        boolean r123 = false;
    L159:
        if (r123 == false) goto L152;
        r89.add(r91);
        goto L152
    L156:
        if (Intrinsics.areEqual(r122, "dislike") == true) goto L158;
        r123 = true;
    L162:
        Iterator r92 = r89.iterator();
    L164:
        if (r92.hasNext() == false) goto L258;
        String r93 = (String) r92.next();
        Iterator<T> r124 = r1.iterator();
    L167:
        if (r124.hasNext() == false) goto L172;
        Object r125 = r124.next();
        if (Intrinsics.areEqual(((AnswerAction) r125).getKey(), r93) == false) goto L167;
    L173:
        AnswerAction r94 = (AnswerAction) r125;
        switch(r93.hashCode()) {
            case -1741312354: goto L252;
            case -1435723453: goto L248;
            case -1281605464: goto L244;
            case -1085143522: goto L238;
            case -906336856: goto L228;
            case -793123453: goto L224;
            case -330459047: goto L220;
            case 115187: goto L217;
            case 3059573: goto L213;
            case 3108362: goto L208;
            case 3321751: goto L203;
            case 109400031: goto L197;
            case 169275230: goto L191;
            case 1245108660: goto L185;
            case 1671642405: goto L181;
            case 1751975057: goto L178;
            default: goto L209;
        };
    L213:
        Iterator r217 = r92;
        if (r93.equals("copy") == false) goto L256;
        ((ArrayList) r24).add(com.larus.bmhome.chat.layout.holder.menu.item.j.a(r94));
    L257:
        r92 = r217;
    L256:
        FLogger.a.d("DynamicMenuGroupCreator", "unknown action key: ".concat(r93));
        goto L257
    L217:
        r217 = r92;
        if (r93.equals("tts") == false) goto L256;
    L231:
        if (r28 == null) goto L234;
        Message r95 = (Message) r28.invoke();
        if (r95 == null) goto L234;
    L235:
        com.larus.bmhome.view.screenmenu.l0 r96 = com.larus.bmhome.chat.layout.holder.menu.item.d1.a(r95, r30);
        if (r96 == null) goto L257;
        ((ArrayList) r24).add(r96);
    L234:
        r95 = r27;
        goto L235
    L220:
        r217 = r92;
        if (r93.equals("quote-reply") == false) goto L256;
        ((ArrayList) r24).add(com.larus.bmhome.chat.layout.holder.menu.item.j0.a(r94));
        goto L257
    L224:
        r217 = r92;
        if (r93.equals("cancel_collection") == false) goto L256;
        ((ArrayList) r24).add(com.larus.bmhome.chat.layout.holder.menu.item.f.a());
        goto L257
    L228:
        r217 = r92;
        if (r93.equals("search") == true) goto L231;
    L238:
        r217 = r92;
        if (r93.equals("convert-doc") == false) goto L256;
        if (com.larus.platform.service.z2.a.exportFileConfig().getEnableMenuCreateDoc() == false) goto L257;
        ((ArrayList) r24).add(com.larus.bmhome.chat.layout.holder.menu.item.q.a());
        goto L257
    L244:
        r217 = r92;
        if (r93.equals("regenerate") == false) goto L256;
        ((ArrayList) r24).add(com.larus.bmhome.chat.layout.holder.menu.item.i0.a(r27));
        goto L257
    L248:
        r217 = r92;
        if (r93.equals("single-collection") == false) goto L256;
        ((ArrayList) r24).add(com.larus.bmhome.chat.layout.holder.menu.item.b1.a());
        goto L257
    L252:
        r217 = r92;
        if (r93.equals("collection") == false) goto L256;
        ((ArrayList) r24).add(com.larus.bmhome.chat.layout.holder.menu.item.i.a());
    L209:
        r217 = r92;
        goto L256
    L178:
        if (r93.equals("fork_conv") == false) goto L209;
    L187:
        com.larus.bmhome.view.screenmenu.l0 r97 = com.larus.bmhome.chat.layout.holder.menu.item.h0.a(r27, r30, r94);
        if (r97 == null) goto L195;
        ((ArrayList) r24).add(r97);
    L195:
        r217 = r92;
        goto L257
    L181:
        if (r93.equals("dislike") == false) goto L209;
        ((ArrayList) r24).add(com.larus.bmhome.chat.layout.holder.menu.item.p.a(r27));
        goto L195
    L185:
        if (r93.equals("create-conversation") == true) goto L187;
    L191:
        if (r93.equals("select-text") == false) goto L209;
        ((ArrayList) r24).add(com.larus.bmhome.chat.layout.holder.menu.item.u0.a());
        goto L195
    L197:
        if (r93.equals("share") == false) goto L209;
        com.larus.bmhome.view.screenmenu.l0 r99 = g(r27, r30, r31, r32);
        if (r99 == null) goto L195;
        ((ArrayList) r24).add(r99);
        goto L195
    L203:
        if (r93.equals("like") == false) goto L209;
        ((ArrayList) r24).add(com.larus.bmhome.chat.layout.holder.menu.item.x.a(r27));
        goto L195
    L208:
        if (r93.equals("edit") == false) goto L209;
        com.larus.bmhome.view.screenmenu.l0 r100 = com.larus.bmhome.chat.layout.holder.menu.item.b0.a(r27, r29, r30);
        r217 = r92;
        if (r100 == null) goto L257;
        ((ArrayList) r24).add(r100);
        goto L257
    L172:
        r125 = null;
        goto L173
    L258:
        ArrayList r101 = new ArrayList();
        Iterator r102 = r2.iterator();
    L260:
        if (r102.hasNext() == false) goto L323;
        String r103 = (String) r102.next();
        Iterator<T> r104 = r1.iterator();
    L263:
        if (r104.hasNext() == false) goto L268;
        Object r105 = r104.next();
        List<AnswerAction> r126 = r1;
        if (Intrinsics.areEqual(((AnswerAction) r105).getKey(), r103) == true) goto L269;
        r1 = r126;
    L269:
        AnswerAction r106 = (AnswerAction) r105;
        switch(r103.hashCode()) {
            case -2141375499: goto L307;
            case -1900923220: goto L294;
            case -1335458389: goto L290;
            case -934521548: goto L286;
            case -330459047: goto L282;
            case 1245108660: goto L276;
            case 1751975057: goto L273;
            default: goto L321;
        };
    L321:
        FLogger.a.d("DynamicMenuGroupCreator", "unknown fold action key: ".concat(r103));
    L322:
        r1 = r126;
        goto L260
    L273:
        if (r103.equals("fork_conv") == false) goto L321;
    L278:
        com.larus.bmhome.view.screenmenu.l0 r107 = com.larus.bmhome.chat.layout.holder.menu.item.h0.a(r27, r30, r106);
        if (r107 == null) goto L322;
        r101.add(r107);
        goto L322
    L276:
        if (r103.equals("create-conversation") == true) goto L278;
    L282:
        if (r103.equals("quote-reply") == false) goto L321;
        r101.add(com.larus.bmhome.chat.layout.holder.menu.item.j0.a(r106));
        goto L322
    L286:
        if (r103.equals("report") == false) goto L321;
        r101.add(com.larus.bmhome.chat.layout.holder.menu.item.n0.a());
        goto L322
    L290:
        if (r103.equals("delete") == false) goto L321;
        r101.add(com.larus.bmhome.chat.layout.holder.menu.item.n.a());
        goto L322
    L294:
        if (r103.equals("generate-podcast") == false) goto L321;
        IFlowPodcastService r108 = (IFlowPodcastService) ServiceManager.get().getService(IFlowPodcastService.class);
        if (r108 == null) goto L299;
        com.larus.bmhome.view.screenmenu.l0 r109 = r108.a(r106);
    L301:
        if ((r109 instanceof com.larus.bmhome.view.screenmenu.l0) == true) goto L304;
        r109 = null;
    L304:
        if (r109 == null) goto L322;
        r101.add(r109);
        goto L322
    L299:
        r109 = null;
        goto L301
    L307:
        if (r103.equals("export-file") == false) goto L321;
        if (Intrinsics.areEqual(r103, "export-file") == true) goto L312;
    L316:
        boolean r127 = false;
    L317:
        if (r127 == true) goto L322;
        com.larus.bmhome.view.screenmenu.l0 r128 = com.larus.bmhome.chat.layout.holder.menu.item.t.a(r27, r30);
        if (r128 == null) goto L322;
        r101.add(r128);
        goto L322
    L312:
        if (com.larus.bmhome.chat.adapter.h0.e(r27) == false) goto L316;
        if (com.larus.platform.service.z2.a.exportFileConfig().getEnableMenuExportToDoc() == false) goto L316;
        r127 = true;
        goto L317
    L268:
        r126 = r1;
        r105 = null;
        goto L269
    L323:
        if (r216 == false) goto L325;
        r72 = this;
        CollectionsKt.removeAll(r101, new a0(r72));
    L326:
        r15 = r101;
        r73 = r87;
        goto L327
    L325:
        r72 = this;
        goto L326
    L161:
        r89 = r2;
    L41:
        r14 = false;
        goto L42
    L21:
        if (r9.length() == 0) goto L24;
        r10 = false;
        goto L25
    L18:
        r9 = null;
    L28:
        r11 = true;
        goto L29
    L31:
        r6 = null;
    L34:
        r12 = false;
        goto L35
    }
}
