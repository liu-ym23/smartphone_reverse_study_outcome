package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService;
import com.larus.bmhome.chat.nestedmenu.NestedMenuPopupStrategy;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.s3;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class NewCvsMenuHandler extends a {
    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != 2131901131) goto L5;
    L8:
        return true;
    L5:
        if (r2 == 2131909358) goto L8;
        return false;
    }

    public NewCvsMenuHandler() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r38, final View r39, final ef8.b r40) {
        Intrinsics.checkNotNullParameter(r38, "item");
        Intrinsics.checkNotNullParameter(r39, "view");
        Intrinsics.checkNotNullParameter(r40, "menuContext");
        if (i3.a.a() == false) goto L6;
        s3.a.b();
        return true;
    L6:
        if (r38.getId() != 2131909358) goto L125;
        com.larus.bmhome.chat.api.q0 r1 = r40.c;
        if (r1 == null) goto L13;
        Function0<Fragment> r2 = r1.getHostFragment();
        if (r2 == null) goto L13;
        Fragment r3 = (Fragment) r2.invoke();
        if (r3 == null) goto L13;
    L16:
        com.larus.bmhome.instruction.g r4 = s1a.a.g(r3).getAbility(com.larus.bmhome.instruction.g.class);
        if (r4 == null) goto L123;
        com.larus.bmhome.actionbar.model.z0 r7 = r4.un(ActiveSwitchType.DEEPTHINK, null);
        if (r7 == null) goto L145;
        com.larus.bmhome.chat.api.q0.a r5 = r40.b;
        if (r5 == null) goto L25;
        com.larus.bmhome.chat.component.cvs.y r6 = r5.u0();
        if (r6 == null) goto L25;
        wc9.e r8 = r6.h();
    L27:
        if (z2.a.J3() == true) goto L29;
        return true;
    L29:
        if (ic8.n.o(r8) == true) goto L144;
        BotModel r9 = r40.a();
        ChatControlTrace r10 = ChatControlTrace.b;
        if (r8 == null) goto L34;
        Integer r11 = r8.v;
    L35:
        if (r9 == null) goto L37;
        Integer r12 = r9.getBotType();
    L38:
        if (r9 == null) goto L42;
        BotCreatorInfo r13 = r9.getBotCreatorInfo();
        if (r13 == null) goto L42;
        String r14 = r13.getId();
    L43:
        String r15 = r10.g(r11, r12, Intrinsics.areEqual(r14, AccountService.a.getUserId()));
        final Ref.ObjectRef r16 = new Ref.ObjectRef();
        View r17 = r39;
    L44:
        if (r17 == null) goto L55;
        if (r16.element != null) goto L55;
        if ((r17 instanceof CommonMenu) == false) goto L50;
        CommonMenu r18 = (CommonMenu) r17;
    L51:
        r16.element = r18;
        Object r19 = r17.getParent();
        if ((r19 instanceof View) == true) goto L53;
        r17 = null;
        goto L44
    L53:
        r17 = (View) r19;
        goto L44
    L50:
        r18 = null;
    L55:
        CommonMenu r20 = (CommonMenu) r16.element;
        if (r20 == null) goto L66;
        Integer r21 = Integer.valueOf(r20.getWidth());
        if (r21.intValue() <= 0) goto L60;
        boolean r22 = true;
    L61:
        if (r22 == true) goto L64;
        r21 = null;
    L64:
        if (r21 == null) goto L66;
    L76:
        int r23 = r21.intValue();
    L78:
        Map r24 = MapsKt.emptyMap();
        Map r25 = MapsKt.emptyMap();
        i5.r0();
        i5.B();
        int r110 = i5.y0(v19.c.b(2130971356, null, 2131167081));
        NestedMenuPopupStrategy r111 = NestedMenuPopupStrategy.ALIGN_TOP;
        Intrinsics.checkNotNullParameter(r24, "conversationForkSourceExt");
        Intrinsics.checkNotNullParameter(r25, "conversationForkTrackingParams");
        Intrinsics.checkNotNullParameter(r111, "popupStrategy");
        int r26 = RangesKt.coerceAtMost(r23 + i5.c(), r110);
        CommonMenu r27 = (CommonMenu) r16.element;
        if (r27 == null) goto L81;
        r27.setMaskView(true);
    L81:
        IMainBotNestedMenuService.Companion r28 = IMainBotNestedMenuService.a;
        NestedMenuScene r29 = NestedMenuScene.ACTION_BAR;
        View r112 = r3.requireView();
        View r113 = (CommonMenu) r16.element;
        if (r113 == null) goto L84;
        View r36 = r113;
    L85:
        Map r114 = r40.a.getExt();
        if (r114 != null) goto L88;
        r114 = MapsKt.emptyMap();
    L88:
        Map r115 = r114;
        Pair[] r116 = new Pair[7];
        r116[0] = TuplesKt.to("click_from", "long_press_panel");
        r116[1] = TuplesKt.to("current_page", "chat");
        if ((r3 instanceof by7.e) == false) goto L91;
        by7.e r30 = (by7.e) r3;
    L93:
        if (r30 == null) goto L99;
        HashMap r31 = by7.h.a(r30).getParams();
        if (r31 == null) goto L99;
        Object r32 = r31.get("previous_page");
        if (r32 == null) goto L99;
        String r33 = r32.toString();
    L100:
        String r117 = "";
        if (r33 != null) goto L103;
        r33 = "";
    L103:
        r116[2] = TuplesKt.to("previous_page", r33);
        String r34 = r40.a.getConversationId();
        if (r34 != null) goto L106;
        r34 = "";
    L106:
        r116[3] = TuplesKt.to("conversation_id", r34);
        String r35 = r40.a.getMessageId();
        if (r35 != null) goto L109;
        r35 = "";
    L109:
        r116[4] = TuplesKt.to("message_id", r35);
        if (r9 == null) goto L112;
        String r37 = r9.getBotId();
    L113:
        if (r37 == null) goto L116;
        r117 = r37;
    L116:
        r116[5] = TuplesKt.to("bot_id", r117);
        r116[6] = TuplesKt.to("chat_type", r15);
        if (IMainBotNestedMenuService.a.a(r28, r29, "fork_conv", r112, r39, r36, r7, new di8.o0(true, true, r115, false, MapsKt.mapOf(r116), r26, r26, false, null, r111, null, null, (CommonMenu) r16.element, new d0(r39), false, true, new e0(r16), null, null, 26440614), null, new f0(r39), new g0(r16, r40, r39), 384) == true) goto L147;
        CommonMenu r0 = (CommonMenu) r16.element;
        if (r0 == null) goto L148;
        r0.setMaskView(false);
        return true;
    L148:
        return true;
    L147:
        return true;
    L112:
        r37 = null;
    L99:
        r33 = null;
        goto L100
    L91:
        r30 = null;
        goto L93
    L84:
        r36 = r39;
        goto L85
    L60:
        r22 = false;
    L66:
        CommonMenu r41 = (CommonMenu) r16.element;
        if (r41 == null) goto L74;
        r21 = Integer.valueOf(r41.getMeasuredWidth());
        if (r21.intValue() <= 0) goto L71;
        boolean r42 = true;
    L72:
        if (r42 == false) goto L74;
    L75:
        if (r21 != null) goto L76;
        r23 = r39.getWidth();
        goto L78
    L71:
        r42 = false;
    L74:
        r21 = null;
    L42:
        r14 = null;
        goto L43
    L37:
        r12 = null;
        goto L38
    L34:
        r11 = null;
        goto L35
    L144:
        return true;
    L25:
        r8 = null;
        goto L27
    L145:
        return true;
    L123:
        return true;
    L13:
        r3 = e1.k(r39);
        if (r3 != null) goto L16;
        return true;
    L125:
        Message r43 = r40.a;
        com.larus.bmhome.chat.api.q0 r44 = r40.c;
        if (r44 == null) goto L130;
        com.larus.bmhome.chat.api.j0 r45 = r44.y7();
        if (r45 == null) goto L130;
        CoroutineScope r46 = (CoroutineScope) r45.invoke();
    L131:
        if (r46 != null) goto L134;
        a.d("NewCvsMenuHandler", "adapter.coroutineScopeGetter");
        return true;
    L134:
        BuildersKt.launch$default(r46, null, null, new NewCvsMenuHandler$handleAction$1(r43, r40.a(), r40.b, r40.b(), r39, null), 3, null);
        return true;
    L130:
        r46 = null;
        goto L131
    }
}
