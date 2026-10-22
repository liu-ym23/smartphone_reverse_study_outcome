package wg8;

import android.content.Context;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import by7.h;
import com.larus.bmhome.chat.api.h0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.c4;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.showcase.x;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.u0;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.common.spi.interaction.ObricMessagePopupServiceDelegate;
import dg8.t;
import ic8.n;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import sr9.e0;
import ss8.g;
import tx9.t1;
import v19.i5;
import yc9.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public BaseMessageListCell<?> a;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [kotlin.jvm.functions.Function0, wg8.e] */
    public static void a(f r37, final Message r38, BotModel r39, CustomMarkdownTextView r40, st8.a r41, q0 r42, by7.e r43, String r44, LongClickSource r45, int r46) {
        if ((r46 & 16) == 0) goto L5;
        q0 r5 = null;
    L7:
        if ((r46 & 32) == 0) goto L9;
        by7.e r15 = null;
    L11:
        if ((r46 & 64) == 0) goto L13;
        String r16 = null;
    L15:
        if ((r46 & 128) == 0) goto L17;
        LongClickSource r11 = LongClickSource.Content;
    L18:
        r37.getClass();
        Intrinsics.checkNotNullParameter(r39, "bot");
        Intrinsics.checkNotNullParameter(r11, "longClickSource");
        FLogger r10 = FLogger.a;
        StringBuilder r1 = new StringBuilder("performLongClick, msg:");
        if (r38 == null) goto L21;
        String r3 = r38.getMessageId();
    L22:
        r1.append(r3);
        r10.i("TextCellLongClickProcessor", r1.toString());
        if (r38 == null) goto L190;
        if (r41 == null) goto L191;
        hc8.c r2 = hc8.c.a;
        if (r2.j(r38) == false) goto L35;
        String r4 = r39.getBotId();
        if (r4 != null) goto L33;
        r4 = "";
    L33:
        if (r2.e(r38, r4) == true) goto L35;
        return;
    L35:
        BaseMessageListCell<?> r6 = r37.a;
        if (r6 == null) goto L40;
        Fragment r7 = lf8.a.d(r6);
        if (r7 == null) goto L40;
        t1a.b r8 = s1a.a.g(r7);
    L41:
        if (r8 == null) goto L43;
        y r17 = (y) r8.getAbility(y.class);
    L44:
        if (r8 == null) goto L46;
        x r9 = (x) r8.getAbility(x.class);
    L47:
        if (r8 == null) goto L49;
        f1 r18 = (f1) r8.getAbility(f1.class);
    L50:
        if (r17 == null) goto L185;
        BotModel r19 = r17.j0();
        if (r19 == null) goto L193;
        BaseMessageListCell<?> r12 = r37.a;
        if (r12 == null) goto L186;
        q0 r20 = lf8.a.b(r12);
        if (r20 == null) goto L194;
        ChatMessageList r21 = r20.B7();
        if (r21 == null) goto L195;
        Fragment r22 = (Fragment) r20.getHostFragment().invoke();
        BaseMessageListCell<?> r13 = r37.a;
        if (r13 == null) goto L69;
        q0 r14 = lf8.a.b(r13);
        if (r14 == null) goto L69;
        h0 r23 = r14.A7();
        if (r23 == null) goto L69;
        wc9.e r24 = (wc9.e) r23.invoke();
    L70:
        boolean r25 = c4.a(r22);
        if (t.h(r17) == false) goto L74;
        if (r25 == true) goto L74;
        return;
    L74:
        if (r9 != null) goto L76;
    L78:
        boolean r26 = false;
    L79:
        if (r26 == true) goto L196;
        if (r8 == null) goto L87;
        g r27 = r8.getAbility(g.class);
        if (r27 == null) goto L87;
        if (r27.bc(ChatUIBlockConfig.DISABLE_MSG_LONG_PRESS) != true) goto L87;
        boolean r28 = true;
    L88:
        if (r28 == false) goto L90;
        r10.i("TextCellLongClickProcessor", "performLongClick blocked by ChatUIBlockConfig.DISABLE_MSG_LONG_PRESS");
        return;
    L90:
        Context r29 = r22.getContext();
        if (r29 == null) goto L197;
        boolean r30 = z2.a.enableMessageMenuTimestamp();
        if (r30 == false) goto L96;
        final Message r31 = t.c(r38);
    L97:
        ?? r32 = new e(r31, r38);
        IAIChatService.Companion r33 = IAIChatService.a;
        t0 r34 = r33.O7(r38, r24);
        r10.i("TextCellLongClickProcessor", "Message#" + r38.getMessageId() + " use menu generator: " + Reflection.getOrCreateKotlinClass(r34.getClass()).getSimpleName());
        if (r40 != null) goto L101;
        r34.b(CollectionsKt.listOf("select-text"));
    L101:
        if (r11 == LongClickSource.Thinking) goto L103;
    L105:
        if (r5 == null) goto L107;
        q0.a r110 = r5.getProvider();
    L108:
        wc9.e r310 = r24;
        t1a.b r35 = r8;
        by7.e r47 = r15;
        List r111 = t0.a.a(r34, r29, r38, r32, r5, r19, r24, r110, null, 128);
        ObricMessagePopupServiceDelegate r36 = ObricMessagePopupServiceDelegate.b;
        BaseMessageListCell<?> r0 = r37.a;
        if (r0 == null) goto L112;
        Context r48 = lf8.a.getContext(r0);
        if (r48 == null) goto L112;
    L113:
        r36.filterMessageMenuItemsIfNeeded(r48, r111);
        if (ObricFeatureServiceDelegate.b.a() == true) goto L116;
    L118:
        de8.c r49 = (de8.c) r35.a(de8.c.class);
        Context r112 = r22.getContext();
        if (r112 != null) goto L121;
        List r113 = r111;
        CommonMenu r50 = null;
    L133:
        if (r50 == null) goto L198;
        if (r18 == null) goto L137;
        r18.Ro();
    L137:
        r33.I7(r22, r21, r41, r38, r50);
        LruCache r51 = ko8.a.a;
        if (r40 == null) goto L143;
        by7.e r52 = h.g(r40);
        if (r52 == null) goto L143;
        by7.e r53 = r52;
    L144:
        wc9.e r54 = r17.h();
        if (r54 == null) goto L147;
        String r55 = n.f(r54);
    L148:
        JSONObject r56 = new JSONObject();
        Map r57 = r38.getExt();
        if (r57 == null) goto L151;
        String r58 = (String) r57.get("onboarding_from");
    L152:
        boolean r59 = Intrinsics.areEqual(r58, "meeting_minutes");
        r56.put("is_meeting_record_message", r59 ? 1 : 0);
        if (r59 == false) goto L155;
        r56.put("meeting_record_message_create_platform", "pc");
    L155:
        Unit r60 = Unit.INSTANCE;
        ko8.a.l(r113, r38, r19, r53, r55, "long_press_message", r56);
        JSONObject r61 = ko8.a.i(r38, null);
        if (r61 != null) goto L158;
        r61 = new JSONObject();
    L158:
        JSONObject r210 = c0.c(r38, r61);
        String r211 = ko8.a.c(r38);
        String r212 = r19.getBotId();
        Integer r311 = r19.getBotType();
        String r62 = r38.getConversationId();
        if (r62 == null) goto L161;
        Long r213 = StringsKt.toLongOrNull(r62);
    L163:
        if (com.larus.bmhome.chat.bean.d.G0(r38) == false) goto L165;
        String r63 = "user";
    L166:
        String r214 = r63;
        String r215 = r38.getMessageId();
        boolean r64 = com.larus.bmhome.chat.bean.d.Q0(r38);
        if (r40 == null) goto L172;
        by7.e r65 = h.g(r40);
        if (r65 == null) goto L172;
        by7.e r216 = r65;
    L173:
        if (r310 == 0) goto L175;
        Integer r66 = r310.v;
    L176:
        Integer r67 = r19.getBotType();
        BotCreatorInfo r68 = r19.getBotCreatorInfo();
        if (r68 == null) goto L179;
        String r114 = r68.getId();
    L180:
        String r217 = ko8.a.f(r66, r67, Intrinsics.areEqual(r114, AccountService.a.getUserId()));
        if (r16 != null) goto L183;
        r16 = IAIChatControlTraceService.a.jb(r40);
    L183:
        boolean r69 = com.larus.bmhome.chat.bean.d.f0(r38);
        t1.a(r212, r213, "chat", r214, r215, Boolean.valueOf(r64), r210, r216, r211, r217, r311, "private", r16, Boolean.valueOf(r69), null, null, 98336);
        return;
    L179:
        r114 = null;
        goto L180
    L175:
        r66 = null;
    L172:
        r216 = r47;
        goto L173
    L165:
        r63 = "assistant";
        goto L166
    L161:
        r213 = null;
        goto L163
    L151:
        r58 = null;
        goto L152
    L147:
        r55 = null;
    L143:
        r53 = r47;
        goto L144
    L198:
        return;
    L121:
        q0.a r70 = r20.getProvider();
        if (r49 == null) goto L124;
        Integer r71 = r49.m();
    L125:
        if (r71 == null) goto L127;
        boolean r72 = true;
    L128:
        r113 = r111;
        e0 r73 = IAIChatService.a.a(r33, r22, r21, r20, r40, r41, r70, r38, r32, r72, r11, 512);
        if (r30 == false) goto L131;
        Calendar r74 = oo8.b.a;
        String r75 = oo8.b.a(((Message) r32.invoke()).getCreateTime() * 1000, true);
    L132:
        List r76 = u0.b(r113, r30, r75);
        CommonMenu r77 = new CommonMenu(r112);
        com.larus.bmhome.view.screenmenu.g.a(r77);
        r77.i = i5.q();
        u0.a(r77, r30);
        r77.g(r76, r73);
        r73.l0(r77);
        r50 = r77;
        goto L133
    L131:
        r75 = null;
        goto L132
    L127:
        r72 = false;
        goto L128
    L124:
        r71 = null;
        goto L125
    L116:
        if (r111.isEmpty() == false) goto L118;
        r10.i("TextCellLongClickProcessor", "skip empty text message menu after OBRIC filter, messageId=" + r38.getMessageId());
        return;
    L112:
        r48 = r29;
        goto L113
    L107:
        r110 = null;
        goto L108
    L103:
        if (com.larus.bmhome.chat.bean.d.Q0(r38) == false) goto L105;
        r34.b(CollectionsKt.listOf("tts"));
        goto L105
    L96:
        r31 = null;
        goto L97
    L197:
        return;
    L87:
        r28 = false;
        goto L88
    L196:
        return;
    L76:
        if (r9.e6() != true) goto L78;
        r26 = true;
    L69:
        r24 = null;
        goto L70
    L195:
        return;
    L194:
        return;
    L186:
        return;
    L193:
        return;
    L185:
        return;
    L49:
        r18 = null;
        goto L50
    L46:
        r9 = null;
        goto L47
    L43:
        r17 = null;
    L40:
        r8 = null;
        goto L41
    L191:
        return;
    L190:
        return;
    L21:
        r3 = null;
        goto L22
    L17:
        r11 = r45;
        goto L18
    L13:
        r16 = r44;
        goto L15
    L9:
        r15 = r43;
        goto L11
    L5:
        r5 = r42;
        goto L7
    }
}
