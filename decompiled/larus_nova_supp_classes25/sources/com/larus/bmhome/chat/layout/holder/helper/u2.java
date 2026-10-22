package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.c4;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u2 implements t0 {

    public static final class a {
    }

    static {
    }

    public u2() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
    }

    public static List c(Message r6, BotModel r7, wc9.e r8, com.larus.bmhome.chat.api.q0.a r9, boolean r10, boolean r11) {
        ArrayList r0 = new ArrayList();
        BotCreatorInfo r1 = r7.getBotCreatorInfo();
        if (r1 == null) goto L5;
        String r2 = r1.getId();
    L6:
        boolean r3 = Intrinsics.areEqual(r2, AccountService.a.getUserId());
        Integer r4 = r7.getBotStatus();
        if (r4 != null) goto L10;
    L11:
        Integer r5 = r7.getBotStatus();
        if (r5 != null) goto L15;
    L16:
        Integer r12 = r7.getBotStatus();
        if (r12 != null) goto L20;
    L21:
        Integer r13 = r7.getBotStatus();
        if (r13 != null) goto L25;
    L27:
        boolean r14 = false;
    L29:
        int r15 = com.larus.bmhome.chat.manager.l0.a;
        if (com.larus.bmhome.chat.manager.l0.a(r7.getBotType()) == false) goto L44;
        if (ic8.n.r(r8) == true) goto L44;
        if (r3 == true) goto L39;
        Integer r16 = r7.getBotStatus();
        if (r16 == null) goto L39;
        if (r16.intValue() != 10) goto L39;
    L41:
        if (r11 == true) goto L44;
        r0.add(com.larus.bmhome.chat.layout.holder.menu.item.j0.a(null));
    L39:
        if (r3 == false) goto L44;
        if (r14 == true) goto L41;
    L44:
        if (com.larus.bmhome.chat.bean.d.b0(r6) == true) goto L48;
        com.larus.bmhome.view.screenmenu.l0 r17 = com.larus.bmhome.chat.layout.holder.menu.item.h0.a(r6, r9, null);
        if (r17 == null) goto L48;
        r0.add(r17);
    L48:
        if (r10 == true) goto L50;
        r0.add(com.larus.bmhome.chat.layout.holder.menu.item.n.a());
    L50:
        return r0;
    L25:
        if (r13.intValue() != (-50)) goto L27;
    L28:
        r14 = true;
        goto L29
    L20:
        if (r12.intValue() == (-40)) goto L28;
    L15:
        if (r5.intValue() == (-20)) goto L28;
    L10:
        if (r4.intValue() == 10) goto L28;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r20, Message r21, Function0<Message> r22, com.larus.bmhome.chat.api.q0 r23, BotModel r24, wc9.e r25, com.larus.bmhome.chat.api.q0.a r26, JSONObject r27) {
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r21, "data");
        Intrinsics.checkNotNullParameter(r24, "chatBot");
        if (r23 == null) goto L11;
        Function0<Fragment> r2 = r23.getHostFragment();
        if (r2 == null) goto L11;
        Fragment r3 = (Fragment) r2.invoke();
        if (r3 == null) goto L11;
        t1a.b r4 = s1a.a.g(r3);
        if (r4 == null) goto L11;
        va8.f0 r5 = (va8.f0) r4.getAbility(va8.f0.class);
    L13:
        if (r5 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        com.larus.platform.service.z2 r7 = com.larus.platform.service.z2.a;
        boolean r8 = r7.W1();
        if (r23 == null) goto L23;
        Function0<Fragment> r9 = r23.getHostFragment();
        if (r9 == null) goto L23;
        Fragment r10 = (Fragment) r9.invoke();
    L24:
        boolean r11 = c4.a(r10);
        BotCreatorInfo r12 = r24.getBotCreatorInfo();
        if (r12 == null) goto L27;
        String r13 = r12.getId();
    L28:
        boolean r14 = Intrinsics.areEqual(r13, AccountService.a.getUserId());
        Integer r15 = r24.getBotStatus();
        if (r15 != null) goto L32;
    L33:
        Integer r16 = r24.getBotStatus();
        if (r16 != null) goto L37;
    L38:
        Integer r17 = r24.getBotStatus();
        if (r17 != null) goto L42;
    L43:
        Integer r18 = r24.getBotStatus();
        if (r18 != null) goto L47;
    L49:
        boolean r19 = false;
    L51:
        int r110 = com.larus.bmhome.chat.manager.l0.a;
        if (com.larus.bmhome.chat.manager.l0.a(r24.getBotType()) == true) goto L54;
    L64:
        boolean r111 = false;
    L65:
        ArrayList r112 = new ArrayList();
        int r28 = r7.getSelfMessageMenuStyle();
        IFlowSdkDepend r113 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r113 == null) goto L72;
        FlowAppletServiceImpl r114 = r113.g0();
        if (r114 == null) goto L72;
        if (r114.m(r25) != true) goto L72;
        boolean r115 = true;
    L73:
        FLogger.a.i("SelfTextMenuCreator", "buildMenuWithDebug, selfMenuStyle = " + r28 + ", isSelfCreateBot = " + r14 + ", isSelfCreateBotInCanUseState = " + r19 + ", canReply = " + r111 + ", disableReplyFold = " + r8 + ", isFloatChat = " + r6 + ", isAppletDebuggerCvs = " + r115);
        if (r28 != 0) goto L95;
        com.larus.bmhome.view.screenmenu.l0 r0 = com.larus.bmhome.chat.layout.holder.menu.item.b0.a(r21, r23, r26);
        if (r0 == null) goto L78;
        r112.add(r0);
    L78:
        r112.add(com.larus.bmhome.chat.layout.holder.menu.item.j.a(null));
        r112.add(com.larus.bmhome.chat.layout.holder.menu.item.u0.a());
        if (com.larus.bmhome.chat.bean.d.y0(r21) == true) goto L85;
        if (r11 == true) goto L85;
        if (r115 == true) goto L85;
        com.larus.bmhome.view.screenmenu.l0 r1 = com.larus.bmhome.chat.layout.holder.menu.item.w0.a(r21, r26);
        if (r1 == null) goto L85;
        r112.add(r1);
    L85:
        if (r8 == false) goto L88;
        if (r111 == false) goto L88;
        r112.add(com.larus.bmhome.chat.layout.holder.menu.item.j0.a(null));
    L88:
        if (r6 == true) goto L92;
        if (r11 == true) goto L92;
        boolean r29 = false;
    L93:
        List r30 = c(r21, r24, r25, r26, r29, r8);
    L94:
        String r31 = "context";
    L153:
        if (Build.VERSION.SDK_INT < 26) goto L161;
        if (r112.size() < 3) goto L161;
        if (r30.size() <= 1) goto L161;
        Intrinsics.checkNotNullParameter(r20, r31);
        r112.add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r20, v19.c.b(2130972086, null, 2131103159))));
        r112.add(com.larus.bmhome.chat.layout.holder.menu.item.c0.a(r30));
    L178:
        v1.d(r112, r21, r25, r26);
        IObricChatUIService r32 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r32 == null) goto L182;
        r32.M(r20, r21, r24, r25, r112);
    L182:
        return e.b(r112);
    L161:
        Iterator r33 = r30.iterator();
        int r34 = 0;
    L163:
        if (r33.hasNext() == false) goto L171;
        if (((ot8.a) r33.next()).getId() != 2131907182) goto L167;
        boolean r35 = true;
    L168:
        if (r35 == true) goto L172;
        r34 = r34 + 1;
    L172:
        if (r34 < 0) goto L174;
        Intrinsics.checkNotNullParameter(r20, r31);
        ListProtector.add(r30, r34, new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r20, v19.c.b(2130972086, null, 2131103159))));
    L174:
        com.larus.bmhome.view.screenmenu.l0 r36 = com.larus.bmhome.chat.layout.holder.menu.item.l.a();
        if (r36 == null) goto L177;
        r30.add(r36);
    L177:
        r112.addAll(r30);
        goto L178
    L167:
        r35 = false;
        goto L168
    L171:
        r34 = -1;
    L92:
        r29 = true;
        goto L93
    L95:
        com.larus.bmhome.view.screenmenu.l0 r116 = com.larus.bmhome.chat.layout.holder.menu.item.j.a(null);
        com.larus.bmhome.view.screenmenu.l0 r37 = com.larus.bmhome.chat.layout.holder.menu.item.b0.a(r21, r23, r26);
        com.larus.bmhome.view.screenmenu.l0 r38 = com.larus.bmhome.chat.layout.holder.menu.item.u0.a();
        if (com.larus.bmhome.chat.bean.d.y0(r21) == true) goto L100;
        if (r11 == true) goto L100;
        if (r115 == true) goto L100;
        com.larus.bmhome.view.screenmenu.l0 r117 = com.larus.bmhome.chat.layout.holder.menu.item.w0.a(r21, r26);
    L101:
        if (r111 == false) goto L103;
        com.larus.bmhome.view.screenmenu.l0 r118 = com.larus.bmhome.chat.layout.holder.menu.item.j0.a(null);
    L104:
        if (r6 == true) goto L108;
        if (r11 == true) goto L108;
        boolean r119 = false;
    L109:
        r30 = c(r21, r24, r25, r26, r119, r8);
        CollectionsKt.removeAll(r30, new q2());
        ArrayList r39 = new ArrayList();
        r39.add(r116);
        if (r37 == null) goto L112;
        r39.add(r37);
    L112:
        if (r118 == null) goto L114;
        r39.add(r118);
    L114:
        ArrayList r40 = new ArrayList();
        Iterator r41 = r39.iterator();
    L116:
        if (r41.hasNext() == false) goto L123;
        Object r42 = r41.next();
        if (((ot8.a) r42).getId() <= 0) goto L120;
        boolean r43 = true;
    L121:
        if (r43 == false) goto L116;
        r40.add(r42);
        goto L116
    L120:
        r43 = false;
        goto L121
    L123:
        ArrayList r44 = new ArrayList();
        r44.add(r38);
        if (r117 == null) goto L126;
        r44.add(r117);
    L126:
        ArrayList r45 = new ArrayList();
        Iterator r46 = r44.iterator();
    L128:
        if (r46.hasNext() == false) goto L136;
        Object r47 = r46.next();
        if (((ot8.a) r47).getId() <= 0) goto L132;
        boolean r48 = true;
    L133:
        if (r48 == false) goto L128;
        r45.add(r47);
        goto L128
    L132:
        r48 = false;
        goto L133
    L136:
        if (r28 != 1) goto L138;
        Function2 r49 = new r2();
    L142:
        r49.invoke(r112, r40);
        IObricChatUIService r50 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r50 == null) goto L146;
        r50.I(r20, r21, r112);
    L146:
        if ((!r45.isEmpty()) == false) goto L94;
        if ((!r112.isEmpty()) == false) goto L150;
        r31 = "context";
        Intrinsics.checkNotNullParameter(r20, r31);
        r112.add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r20, v19.c.b(2130972086, null, 2131103159))));
    L151:
        r112.addAll(r45);
        goto L153
    L150:
        r31 = "context";
        goto L151
    L138:
        if (r28 == 2) goto L140;
        r49 = new t2();
        goto L142
    L140:
        r49 = new s2();
    L108:
        r119 = true;
        goto L109
    L103:
        r118 = null;
    L100:
        r117 = null;
    L72:
        r115 = false;
        goto L73
    L54:
        if (ic8.n.r(r25) == true) goto L64;
        if (r14 == true) goto L61;
        Integer r120 = r24.getBotStatus();
        if (r120 == null) goto L61;
        if (r120.intValue() != 10) goto L61;
    L63:
        r111 = true;
    L61:
        if (r14 == false) goto L64;
        if (r19 == false) goto L64;
    L47:
        if (r18.intValue() != (-50)) goto L49;
    L50:
        r19 = true;
        goto L51
    L42:
        if (r17.intValue() == (-40)) goto L50;
    L37:
        if (r16.intValue() == (-20)) goto L50;
    L32:
        if (r15.intValue() == 10) goto L50;
    L27:
        r13 = null;
    L23:
        r10 = null;
        goto L24
    L15:
        if (r5.R() != true) goto L17;
        r6 = true;
    L11:
        r5 = null;
        goto L13
    }
}
