package com.larus.bmhome.chat.helper;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.ConversationMode;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService;
import com.larus.bmhome.chat.nestedmenu.NestedMenuPopupStrategy;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.menu.CreateMenuV2;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.InputDialog;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;
import tx9.i3;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class CocoSubConversationSettingMenuTrigger implements Function1<Integer, Unit> {
    public final Context a;
    public final View b;
    public final RecommendFrom c;
    public final ChatFragment d;
    public final wc9.e e;
    public final BotModel f;
    public final String g;
    public final String h;
    public final Function0<View> i;
    public final boolean j;
    public final boolean k;

    public final void b(String r8) {
        LifecycleOwner r0 = (LifecycleOwner) this.d.getViewLifecycleOwnerLiveData().getValue();
        if (r0 == null) goto L8;
        LifecycleCoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(r0);
        if (r1 == null) goto L9;
        BuildersKt.launch$default(r1, null, null, new CocoSubConversationSettingMenuTrigger$doDeleteConversation$1(r8, null), 3, null);
        return;
    L9:
        return;
    }

    public final void d(int r50) {
        String r12 = "";
        by7.e r14 = null;
        switch(r50) {
            case 1: goto L246;
            case 2: goto L218;
            case 3: goto L195;
            case 4: goto L167;
            case 5: goto L130;
            case 6: goto L109;
            case 7: goto L7;
            case 8: goto L5;
            default: goto L248;
        };
    L5:
        com.bytedance.router.i r0 = SmartRouter.buildRoute(this.a, "//flow/app_setting");
        r0.c.putExtra("is_side_bar", "1");
        r0.d();
        goto L248
    L109:
        final wc9.e r6 = this.e;
        if (r6 == null) goto L248;
        d0 r4 = d0.a;
        Application r5 = AppHost.a.getApplication();
        BotModel r1 = this.f;
        if (r1 == null) goto L114;
        String r9 = r1.getBotId();
    L115:
        ChatControlTrace r2 = ChatControlTrace.b;
        Integer r3 = r6.v;
        BotModel r10 = this.f;
        if (r10 == null) goto L118;
        Integer r11 = r10.getBotType();
    L119:
        BotModel r13 = this.f;
        if (r13 == null) goto L124;
        BotCreatorInfo r15 = r13.getBotCreatorInfo();
        if (r15 == null) goto L124;
        String r16 = r15.getId();
    L125:
        String r17 = r2.g(r3, r11, Intrinsics.areEqual(r16, AccountService.a.getUserId()));
        by7.e r7 = this.d;
        if ((r7 instanceof by7.e) == false) goto L128;
        by7.e r18 = r7;
    L129:
        r4.a(r5, r6, "chat", "chat_title_menu", r9, r17, r18, new k(this, r6));
        goto L248
    L128:
        r18 = null;
    L124:
        r16 = null;
        goto L125
    L118:
        r11 = null;
        goto L119
    L114:
        r9 = null;
        goto L115
    L130:
        by7.e r8 = this.d;
        if ((r8 instanceof by7.e) == true) goto L134;
        r8 = null;
    L134:
        Bundle r19 = BundleKt.bundleOf();
        if (r8 == null) goto L137;
        by7.h.k(r19, r8);
    L137:
        ic8.k.b(r19, (ChatPassThroughParams) this.d.WF().a(ChatPassThroughParams.class));
        ChatControlTrace r20 = ChatControlTrace.b;
        wc9.e r21 = this.e;
        if (r21 == null) goto L140;
        Integer r22 = r21.v;
    L141:
        BotModel r23 = this.f;
        if (r23 == null) goto L144;
        Integer r24 = r23.getBotType();
    L145:
        BotModel r110 = this.f;
        if (r110 == null) goto L150;
        BotCreatorInfo r111 = r110.getBotCreatorInfo();
        if (r111 == null) goto L150;
        String r112 = r111.getId();
    L151:
        String r25 = r20.g(r22, r24, Intrinsics.areEqual(r112, AccountService.a.getUserId()));
        Bundle r26 = new Bundle(r19);
        Pair[] r27 = new Pair[3];
        wc9.e r28 = this.e;
        if (r28 == null) goto L154;
        String r29 = r28.a;
    L155:
        r27[0] = TuplesKt.to("key.search.in.conv.id", r29);
        BotModel r30 = this.f;
        if (r30 == null) goto L158;
        String r31 = r30.getBotId();
    L159:
        r27[1] = TuplesKt.to("key.search.bot.id", r31);
        r27[2] = TuplesKt.to("key.search.chat.type", r25);
        r26.putAll(com.larus.utils.f.c(r27));
        sd8.a r32 = this.d.WF().getAbility(sd8.a.class);
        if (r32 == null) goto L162;
        r32.yu();
    L162:
        com.bytedance.router.i r33 = SmartRouter.buildRoute(this.a, "//flow/chat_search");
        r33.c.putExtras(r26);
        r33.d();
        JSONObject r34 = new JSONObject().put("chat_type", r25);
        BotModel r35 = this.f;
        if (r35 == null) goto L165;
        r14 = r35.getBotId();
    L165:
        i3.a(null, null, null, "chat", r34.put("bot_id", r14).put("click_from", "chat_popup_menu").put("function_type", "chat_search"), r8, 15);
        goto L248
    L158:
        r31 = null;
        goto L159
    L154:
        r29 = null;
    L150:
        r112 = null;
        goto L151
    L144:
        r24 = null;
        goto L145
    L140:
        r22 = null;
        goto L141
    L246:
        a(this.d, true, false);
        goto L248
    L7:
        if (z2.a.J3() == true) goto L9;
    L107:
        FLogger.a.d("CocoSubConversationSettingMenuTrigger", "conversation fork blocked: settings or conversation disabled");
        t19.s r36 = t19.s.a;
        Context r37 = this.a;
        r36.getClass();
        t19.s.b(r37, 2131905626, false);
        return;
    L9:
        if (ic8.n.o(this.e) == true) goto L107;
        View r38 = (View) this.i.invoke();
        if (r38 != null) goto L14;
        r38 = this.b;
    L14:
        View r210 = r38;
        final Ref.ObjectRef r39 = new Ref.ObjectRef();
        View r40 = r210;
    L15:
        if (r40 == null) goto L26;
        if (r39.element != null) goto L26;
        if ((r40 instanceof CreateMenuV2) == false) goto L21;
        CreateMenuV2 r41 = (CreateMenuV2) r40;
    L22:
        r39.element = r41;
        CreateMenuV2 r42 = r40.getParent();
        if ((r42 instanceof View) == true) goto L24;
        r40 = null;
        goto L15
    L24:
        r40 = (View) r42;
        goto L15
    L21:
        r41 = null;
    L26:
        com.larus.bmhome.instruction.g r43 = this.d.WF().getAbility(com.larus.bmhome.instruction.g.class);
        if (r43 == null) goto L29;
        z0 r211 = r43.un(ActiveSwitchType.DEEPTHINK, null);
    L30:
        if (r211 != null) goto L255;
        t19.s r44 = t19.s.a;
        Context r45 = this.a;
        r44.getClass();
        t19.s.b(r45, 2131905626, false);
        goto L248
    L255:
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L40
        wc9.e r47 = this.e;     // Catch: Throwable -> L40
        if (r47 == null) goto L35;
        String r48 = r47.r;     // Catch: Throwable -> L40
    L36:
        if (r48 != null) goto L38;
        r48 = "";
    L38:
        Object r49 = Result.constructor-impl(new JSONObject(r48));     // Catch: Throwable -> L40
    L42:
        JSONObject r51 = new JSONObject();
        if (Result.isFailure-impl(r49) == false) goto L45;
        r49 = r51;
    L45:
        JSONObject r52 = (JSONObject) r49;
        List r53 = CollectionsKt.listOf(new String[]{"reply_mode", "agent_task_param"});
        ArrayList r113 = new ArrayList();
        Iterator r54 = r53.iterator();
    L47:
        if (r54.hasNext() == false) goto L58;
        String r55 = (String) r54.next();
        String r114 = r52.optString(r55);
        Intrinsics.checkNotNull(r114);
        if ((!StringsKt.isBlank(r114)) == false) goto L51;
        String r115 = r114;
    L52:
        if (r115 == null) goto L54;
        Pair r56 = TuplesKt.to(r55, r115);
    L55:
        if (r56 == null) goto L47;
        r113.add(r56);
        goto L47
    L54:
        r56 = null;
        goto L55
    L51:
        r115 = null;
        goto L52
    L58:
        Map r310 = MapsKt.toMap(r113);
        ChatControlTrace r57 = ChatControlTrace.b;
        wc9.e r58 = this.e;
        if (r58 == null) goto L61;
        Integer r59 = r58.v;
    L62:
        BotModel r60 = this.f;
        if (r60 == null) goto L65;
        Integer r61 = r60.getBotType();
    L66:
        BotModel r116 = this.f;
        if (r116 == null) goto L71;
        BotCreatorInfo r117 = r116.getBotCreatorInfo();
        if (r117 == null) goto L71;
        String r118 = r117.getId();
    L72:
        String r62 = r57.g(r59, r61, Intrinsics.areEqual(r118, AccountService.a.getUserId()));
        CreateMenuV2 r63 = (CreateMenuV2) r39.element;
        if (r63 == null) goto L75;
        CreateMenu.a.a r64 = CreateMenuV2.s;
        r63.H(true, null);
    L75:
        IMainBotNestedMenuService.Companion r65 = IMainBotNestedMenuService.a;
        NestedMenuScene r66 = NestedMenuScene.SETTINGS;
        View r119 = this.d.requireView();
        Pair[] r120 = new Pair[7];
        r120[0] = TuplesKt.to("click_from", "new_chat_setting_panel");
        r120[1] = TuplesKt.to("current_page", "chat");
        by7.e r67 = this.d;
        if ((r67 instanceof by7.e) == true) goto L80;
        r67 = null;
    L80:
        if (r67 == null) goto L86;
        HashMap r68 = by7.h.a(r67).getParams();
        if (r68 == null) goto L86;
        Object r69 = r68.get("previous_page");
        if (r69 == null) goto L86;
        String r70 = r69.toString();
    L87:
        if (r70 != null) goto L89;
        r70 = "";
    L89:
        r120[2] = TuplesKt.to("previous_page", r70);
        wc9.e r71 = this.e;
        if (r71 == null) goto L92;
        String r72 = r71.a;
    L93:
        if (r72 != null) goto L95;
        r72 = "";
    L95:
        r120[3] = TuplesKt.to("conversation_id", r72);
        r120[4] = TuplesKt.to("message_id", "");
        BotModel r73 = this.f;
        if (r73 == null) goto L98;
        String r74 = r73.getBotId();
    L99:
        if (r74 == null) goto L102;
        r12 = r74;
    L102:
        r120[5] = TuplesKt.to("bot_id", r12);
        r120[6] = TuplesKt.to("chat_type", r62);
        Map r311 = MapsKt.mapOf(r120);
        NestedMenuPopupStrategy r312 = NestedMenuPopupStrategy.DROP_DOWN;
        if (IMainBotNestedMenuService.a.a(r65, r66, "fork_conv", r119, r210, r210, r211, new di8.o0(true, true, r310, true, r311, 0, i5.R(), false, null, r312, new l(), new m(), (CreateMenuV2) r39.element, new n(this), true, false, new o(r39), null, null, 27293574), null, new p(this), new q(r39, this), 384) == true) goto L248;
        CreateMenuV2 r75 = (CreateMenuV2) r39.element;
        if (r75 == null) goto L248;
        CreateMenu.a.a r76 = CreateMenuV2.s;
        r75.H(false, null);
        goto L248
    L98:
        r74 = null;
        goto L99
    L92:
        r72 = null;
    L86:
        r70 = null;
    L71:
        r118 = null;
        goto L72
    L65:
        r61 = null;
        goto L66
    L61:
        r59 = null;
        goto L62
    L35:
        r48 = null;
    L40:
        th = move-exception;
        Result.Companion r77 = Result.Companion;
        r49 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L29:
        r211 = null;
        goto L30
    L167:
        if (this.k == false) goto L169;
        t19.s.a.g(AppHost.a.getApplication(), 2131905448, false);
        goto L248
    L169:
        wc9.e r78 = this.e;
        if (r78 == null) goto L172;
        String r79 = r78.a;
    L173:
        if (r79 == null) goto L176;
        r12 = r79;
    L176:
        BotModel r80 = this.f;
        if (r80 == null) goto L179;
        Integer r81 = Integer.valueOf(ni8.a.b(r80));
    L180:
        if (r81 == null) goto L186;
        if (r81.intValue() != (-10)) goto L186;
        b(r12);
    L186:
        if (this.d.isAdded() == false) goto L248;
        if (this.d.getChildFragmentManager().isStateSaved() == true) goto L248;
        CommonDialog.a r82 = new CommonDialog.a();
        r82.i(this.a.getString(2131901554));
        r82.g(this.a.getString(2131901553));
        CommonDialog.a.f(r82, new s(r12, this), this.a.getString(2131900203), false, 12);
        CommonDialog.a.e(r82, new t(), this.a.getString(2131900202), 4);
        CommonDialog r83 = r82.a();
        FragmentManager r84 = this.d.getChildFragmentManager();
        LandscapeRestrictionOperation r85 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r83, null, r85);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r84, r83, r85) == true) goto L248;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L251
    L193:
        r83.show(r84, null);
        goto L248
    L179:
        r81 = null;
        goto L180
    L172:
        r79 = null;
        goto L173
    L195:
        if (this.j == false) goto L197;
        t19.s.a.g(AppHost.a.getApplication(), 2131905449, false);
        goto L248
    L197:
        wc9.e r86 = this.e;
        if (r86 == null) goto L248;
        if (this.d.isAdded() == false) goto L248;
        if (this.d.getChildFragmentManager().isStateSaved() == true) goto L248;
        List r87 = CollectionsKt.emptyList();
        Boolean r88 = Boolean.TRUE;
        String r89 = this.a.getString(2131905460);
        Intrinsics.checkNotNullParameter(r89, "title");
        String r90 = r86.c;
        if (r90 == null) goto L208;
        r12 = r90;
    L208:
        u r91 = new u(r86, this);
        Intrinsics.checkNotNullParameter(r91, "listener");
        v r92 = new v(this, r86);
        Intrinsics.checkNotNullParameter(r92, "listener");
        InputDialog r93 = new InputDialog();
        r93.e = r88;
        r93.f = r89;
        r93.g = r12;
        r93.k = null;
        r93.l = r91;
        r93.m = null;
        r93.n = r92;
        r93.h = 40;
        r93.i = r87;
        r93.j = false;
        FragmentManager r94 = this.d.getChildFragmentManager();
        LandscapeRestrictionOperation r95 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r93, null, r95);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r94, r93, r95) == false) goto L257;
    L213:
        int r96 = com.larus.bmhome.chat.trace.i0.a;
        JSONObject r97 = c(r86, this.f);
        by7.e r99 = this.d;
        if ((r99 instanceof by7.e) == false) goto L216;
        r14 = r99;
    L216:
        Intrinsics.checkNotNullParameter(r97, "params");
        com.larus.bmhome.chat.trace.i0.a("click_edit_chat_name", r97, r14);
        goto L248
    L257:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L252
    L212:
        r93.show(r94, null);
        goto L213
    L218:
        if (ic8.n.C(this.e) == false) goto L220;
        t19.s r100 = t19.s.a;
        Context r101 = this.a;
        r100.getClass();
        t19.s.s(r101, 2131900761);
        goto L248
    L220:
        ShareServiceDelegate r121 = ShareServiceDelegate.b;
        Context r102 = this.a;
        wc9.e r103 = this.e;
        BotModel r104 = this.f;
        if (z2.a.getShareConfig().m() == false) goto L223;
        ShareScene r105 = ShareScene.COMMON_BOT_WITH_SAVE;
    L224:
        ShareScene r122 = r105;
        by7.e r106 = this.d;
        if ((r106 instanceof by7.e) == false) goto L227;
        by7.e r212 = r106;
    L228:
        IShareService.a.b(r121, r102, r103, r104, r122, null, r212, null, 80);
        JSONObject r107 = ChatControlTrace.b.Xb(this.c);
        if (this.c == null) goto L231;
    L233:
        BotModel r108 = this.f;
        if (r108 == null) goto L236;
        String r109 = r108.getBotId();
    L237:
        r107.put("bot_id", r109);
        BotModel r123 = this.f;
        if (r123 == null) goto L240;
        String r124 = r123.getBotId();
    L241:
        r107.put("item_id", r124);
        wc9.e r125 = this.e;
        if (r125 == null) goto L244;
        String r126 = r125.a;
    L245:
        r107.put("conversation_id", r126);
        r107.put("chat_type", "default_new");
        r107.put("group_type", "private");
        r107.put("click_from", "chat_popup_menu");
        r107.put("user_case_item_id", ChatControlTrace.L);
        r107.put("user_case_reco_request_id", ChatControlTrace.M);
        Unit r127 = Unit.INSTANCE;
        tx9.c0.B(r107, null, "0", 884735);
        goto L248
    L244:
        r126 = null;
        goto L245
    L240:
        r124 = null;
        goto L241
    L236:
        r109 = null;
        goto L237
    L231:
        if (com.larus.utils.o0.d(ChatControlTrace.P) == false) goto L233;
        r107.put("recommend_from", ChatControlTrace.P);
        goto L233
    L227:
        r212 = null;
        goto L228
    L223:
        r105 = ShareScene.COMMON_BOT;
    L248:
        if (r50 == 7) goto L269;
        com.larus.bmhome.view.screenmenu.d r128 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(this.b);
        return;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        d(((Number) r1).intValue());
        return Unit.INSTANCE;
    }

    public static JSONObject c(wc9.e r2, BotModel r3) {
        JSONObject r0 = new JSONObject();
        if (r3 == null) goto L5;
        String r4 = r3.getBotId();
    L6:
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r0.put("bot_id", r4);
        r0.put("conversation_id", r2.a);
        r0.put("chat_type", "default_new");
        r0.put("click_from", "chat_popup_menu");
        return r0;
    L5:
        r4 = null;
        goto L6
    }

    public final void a(ChatFragment r32, boolean r33, boolean r34) {
        Intrinsics.checkNotNullParameter(r32, "chatFragment");
        if (r34 == true) goto L5;
    L7:
        com.larus.platform.service.i3 r1 = com.larus.platform.service.i3.a;
        if (r1.a() == false) goto L10;
        r1.g(TriggerLoginScene.TRIGGER_LOGIN_MESSAGE_LIMITED);
        return;
    L10:
        BotModel r2 = this.f;
        qy8.f r3 = null;
        if (r2 == null) goto L13;
        String r4 = r2.getBotId();
    L14:
        wc9.e r5 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r5 == null) goto L17;
        String r29 = r5.a;
    L18:
        by7.e r6 = this.d;
        if ((r6 instanceof by7.e) == false) goto L21;
        by7.e r30 = r6;
    L22:
        boolean r7 = false;
        if (com.larus.utils.o0.d(r4) == true) goto L25;
    L71:
        t19.s r8 = t19.s.a;
        Context r9 = this.a;
        r8.getClass();
        t19.s.b(r9, 2131901132, false);
        return;
    L25:
        if (com.larus.utils.o0.d(r29) == false) goto L71;
        if (r30 == null) goto L71;
        z2 r10 = z2.a;
        if (z2.c4() == false) goto L51;
        com.larus.bmhome.chat.mode.e r11 = s1a.a.g(this.d).getAbility(com.larus.bmhome.chat.mode.e.class);
        if (r11 == null) goto L38;
        i1 r12 = r11.Si();
        if (r12 == null) goto L38;
        ConversationMode r13 = (ConversationMode) r12.getValue();
        if (r13 == null) goto L38;
        String r14 = r13.a();
        if (r14 == null) goto L38;
    L46:
        Bundle r15 = new Bundle();
        if (Intrinsics.areEqual(r14, "office") == false) goto L49;
        String r16 = "new_office_task";
    L50:
        r15.putString("entry_type", r16);
        r15.putString("conversation_mode_key_override", r14);
        Bundle r23 = r15;
    L52:
        sd8.a r17 = this.d.WF().getAbility(sd8.a.class);
        if (r17 == null) goto L57;
        qy8.a r18 = r17.yu();
        if (r18 == null) goto L57;
        r3 = r18.b;
    L57:
        if (r3 == null) goto L59;
        r3.a();
    L59:
        ChatRouterHelper r19 = ChatRouterHelper.a;
        ChatRouterHelper.h(this.a, r4, r5, null, this.g, this.h, null, null, null, null, null, null, null, false, true, false, false, r30, null, (ChatPassThroughParams) this.d.WF().a(ChatPassThroughParams.class), r23, null, false, null, null, 31834056);
        if (r33 == false) goto L75;
        JSONObject r20 = new JSONObject();
        com.larus.bmhome.chat.mode.e r21 = s1a.a.g(this.d).getAbility(com.larus.bmhome.chat.mode.e.class);
        if (r21 == null) goto L70;
        i1 r22 = r21.Si();
        if (r22 == null) goto L70;
        ConversationMode r24 = (ConversationMode) r22.getValue();
        if (r24 == null) goto L70;
        String r25 = r24.a();
        if (r25 == null) goto L70;
        r20.put("target_mode", r25);
    L70:
        tx9.k0.a(r4, "chat_popup_menu", r29, null, null, null, null, null, null, null, null, null, null, null, r20, r30, null, null, 950257);
        return;
    L75:
        return;
    L49:
        r16 = "new_conversation";
    L38:
        com.larus.bmhome.instruction.g r26 = s1a.a.g(this.d).getAbility(com.larus.bmhome.instruction.g.class);
        if (r26 != null) goto L41;
    L43:
        if (r7 == false) goto L45;
        r14 = "office";
        goto L46
    L45:
        r14 = "chat";
        goto L46
    L41:
        if (r26.yW() != true) goto L43;
        r7 = true;
        goto L43
    L51:
        r23 = null;
        goto L52
    L21:
        r30 = null;
        goto L22
    L17:
        r29 = null;
        goto L18
    L13:
        r4 = null;
        goto L14
    L5:
        if (AccountService.a.isLogin().booleanValue() == true) goto L7;
        com.larus.platform.service.i3.a.g(TriggerLoginScene.TRIGGER_LOGIN_CLICK_INPUT);
    }

    public CocoSubConversationSettingMenuTrigger(Context r3, View r4, RecommendFrom r5, ChatFragment r6, wc9.e r7, BotModel r8, String r9, String r10, g r11, int r12) {
        if ((r12 & 64) == 0) goto L6;
        r9 = "";
    L6:
        if ((r12 & 128) == 0) goto L8;
        r10 = "";
    L8:
        Function0<View> r13 = r11;
        if ((r12 & 256) == 0) goto L11;
        r13 = r.a;
    L11:
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "hostView");
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter(r13, "selectedActionSourceViewProvider");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r13;
        this.j = ic8.n.A(r7);
        this.k = ic8.n.p(r7);
    }
}
