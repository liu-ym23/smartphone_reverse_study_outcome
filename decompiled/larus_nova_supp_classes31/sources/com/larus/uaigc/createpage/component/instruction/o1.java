package com.larus.uaigc.createpage.component.instruction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.bot.SceneModel;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.l3;
import tx9.s3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o1 implements com.larus.bmhome.view.actionbar.custom.t1 {
    public final /* synthetic */ CreationEditorComponent a;
    public final /* synthetic */ Function1<Integer, Unit> b;

    public final String a() {
        return "";
    }

    public final kotlinx.coroutines.flow.i1<Boolean> c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        return null;
    }

    public final void d(View r1, ImageView r2, TextView r3, com.larus.bmhome.actionbar.model.z0 r4) {
        Intrinsics.checkNotNullParameter(r1, "root");
        Intrinsics.checkNotNullParameter(r2, "icon");
        Intrinsics.checkNotNullParameter(r3, "nameView");
    }

    public final LifecycleCoroutineScope e() {
        return LifecycleOwnerKt.getLifecycleScope(s1a.a.c(this.a));
    }

    public final int f() {
        RecyclerView r0 = this.a.E;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getScrollState();
    }

    public final ReplyOption g(com.larus.bmhome.actionbar.model.z0 r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        ModelItemIdentity r0 = wa8.t0.a;
        return new ReplyOption(wa8.t0.a, null, null);
    }

    public o1(CreationEditorComponent r1, f1 r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    public final void b(com.larus.bmhome.actionbar.model.z0 r61, int r62, Boolean r63, View r64, boolean r65, aq8.e r66) {
        Intrinsics.checkNotNullParameter(r61, "item");
        CreationEditorComponent r1 = this.a;
        int r2 = CreationEditorComponent.g2;
        uy9.a r3 = r1.q4();
        SceneModel r5 = null;
        if (r3 == null) goto L5;
        r3.Rq();
        String r4 = "template_page";
    L6:
        Map<String, String> r6 = IAIChatRenderTraceService.a.i();
        if (r6 == null) goto L16;
        String r7 = r6.get("key_current_page");
        if (r7 == null) goto L16;
        if (com.larus.utils.o0.d(r7) == true) goto L14;
        r7 = null;
    L14:
        if (r7 == null) goto L16;
        Unit r8 = Unit.INSTANCE;
        String r13 = r7;
    L17:
        String r9 = r61.b;
        Long r10 = r61.a;
        com.larus.bmhome.actionbar.model.r r11 = r61.q;
        if (r11 == null) goto L20;
        String r22 = r11.g;
    L21:
        if (r11 == null) goto L23;
        Integer r17 = r11.a;
    L24:
        ny9.s r12 = this.a.W3();
        if (r12 == null) goto L31;
        ChatParam r14 = r12.c();
        if (r14 == null) goto L31;
        String r15 = r14.a;
        if (r15 == null) goto L31;
        Long r16 = StringsKt.toLongOrNull(r15);
    L32:
        ny9.s r18 = this.a.W3();
        if (r18 == null) goto L37;
        ChatParam r19 = r18.c();
        if (r19 == null) goto L37;
        String r110 = r19.b;
    L38:
        long r20 = r62;
        uy9.a r21 = this.a.q4();
        if (r21 == null) goto L41;
        String r39 = r21.PG();
    L42:
        tx9.b.b(r110, Long.valueOf(r20), r16, r13, null, null, null, r17, r9, null, null, null, r22, null, null, null, null, null, null, r10, null, i3.a.f(), null, null, "ai_generate_feed", null, null, null, null, r39, -310447120, 1);
        com.larus.bmhome.actionbar.model.d r23 = r61.J;
        boolean r24 = true;
        if (r23 == null) goto L50;
        Integer r25 = r23.a;
        if (r25 == null) goto L50;
        if (r25.intValue() != 1) goto L50;
        boolean r26 = true;
    L52:
        if (r26 == false) goto L63;
        FLogger.a.i("CreationEditorComponent", "server degrade item click " + r61.a + ' ' + r61.b + ' ' + r61.J);
        com.larus.bmhome.actionbar.model.d r27 = r61.J;
        if (r27 == null) goto L61;
        String r111 = r27.b;
        if (r111 == null) goto L61;
        t19.s r112 = t19.s.a;
        if (r64 == null) goto L60;
        r5 = r64.getContext();
    L60:
        t19.s.j(r112, r5, r111, null, false, 28);
        Unit r28 = Unit.INSTANCE;
    L61:
        s3.a("abar_server_" + r61.a);
        return;
    L63:
        String r29 = "1";
        if (Intrinsics.areEqual(PollingConfigService.a.f("abar_hid_" + r61.a), "1") == false) goto L87;
        FLogger.a.i("CreationEditorComponent", "hidden item click " + r61.a + ' ' + r61.b);
        t19.s r113 = t19.s.a;
        if (r64 == null) goto L68;
        Context r114 = r64.getContext();
    L69:
        z2 r30 = z2.a;
        FlowDowngradeToastConfig r31 = r30.getFlowDowngradeToastConfig();
        if (r31 == null) goto L72;
        String r32 = r31.getTrafficDegradationFeatureDisableCn();
    L73:
        if (r32 != null) goto L75;
    L78:
        if (r24 == false) goto L81;
        String r33 = AppHost.a.getApplication().getString(2131910602);
    L80:
        String r115 = r33;
        Intrinsics.checkNotNull(r115);
        t19.s.j(r113, r114, r115, null, false, 28);
        s3.a("abar_hid_" + r61.a);
        return;
    L81:
        FlowDowngradeToastConfig r34 = r30.getFlowDowngradeToastConfig();
        if (r34 == null) goto L84;
        r5 = r34.getTrafficDegradationFeatureDisableCn();
    L84:
        r33 = String.valueOf(r5);
        goto L80
    L75:
        if (r32.length() == 0) goto L78;
        r24 = false;
        goto L78
    L72:
        r32 = null;
        goto L73
    L68:
        r114 = null;
        goto L69
    L87:
        Long r35 = r61.a;
        if (r35 == null) goto L165;
        CreationEditorComponent r116 = this.a;
        long r117 = r35.longValue();
        ny9.s r36 = r116.W3();
        if (r36 == null) goto L92;
        String r118 = String.valueOf(r117);
        Intrinsics.checkNotNullParameter(r118, "itemId");
        String r37 = r36.b.get(r118);
    L93:
        if (r37 == null) goto L165;
        if (r37.length() <= 0) goto L97;
        boolean r119 = true;
    L98:
        if (r119 == true) goto L101;
        r37 = null;
    L101:
        if (r37 == null) goto L165;
        String r38 = UriProtector.parse(r37).getPath();
        String r40 = UriProtector.getQueryParameter(UriProtector.parse(r37), "actionbar_instruction_type");
        String r41 = UriProtector.getQueryParameter(UriProtector.parse(r37), "select_tab");
        if (Intrinsics.areEqual(r38, "/edit_instruction") == false) goto L138;
        if (r40 == null) goto L138;
        if (r41 == null) goto L138;
        if (l3.e(r40, 0) != 28) goto L138;
        com.larus.bmhome.actionbar.model.r r42 = r116.i4().getCurrentInstructionConf();
        if (r42 == null) goto L250;
        com.larus.bmhome.actionbar.model.y r43 = r42.i;
        if (r43 == null) goto L251;
        ArrayList r44 = r43.a;
        if (r44 == null) goto L252;
        Iterator r45 = r44.iterator();
        int r46 = 0;
    L116:
        if (r45.hasNext() == false) goto L137;
        Object r47 = r45.next();
        int r48 = r46 + 1;
        if (r46 >= 0) goto L120;
        CollectionsKt.throwIndexOverflow();
    L120:
        com.larus.bmhome.actionbar.model.r r49 = ((com.larus.bmhome.actionbar.model.z0) r47).q;
        if (r49 == null) goto L128;
        Integer r50 = r49.a;
        int r51 = l3.e(r41, 0);
        if (r50 == null) goto L128;
        if (r50.intValue() != r51) goto L128;
        boolean r52 = true;
    L129:
        if (r52 == false) goto L136;
        r116.I5(l3.e(r41, 0), true);
        ICoreInputAbility r53 = r116.a4();
        if (r53 == null) goto L133;
        r53.g2(1, true);
        Unit r54 = Unit.INSTANCE;
    L133:
        ICoreInputAbility r55 = r116.a4();
        if (r55 == null) goto L136;
        ICoreInputAbility.b.e(r55, "inner_action_bar_click", null, false, 6);
        Unit r56 = Unit.INSTANCE;
    L136:
        r46 = r48;
    L128:
        r52 = false;
        goto L129
    L137:
        Unit r57 = Unit.INSTANCE;
        return;
    L252:
        return;
    L251:
        return;
    L250:
        return;
    L138:
        Pair[] r58 = new Pair[10];
        r58[0] = TuplesKt.to("enter_from", "chat");
        r58[1] = TuplesKt.to("enter_method", "chat_action_bar");
        ny9.s r59 = r116.W3();
        if (r59 == null) goto L145;
        ChatParam r60 = r59.c();
        if (r60 == null) goto L145;
        String r67 = r60.a;
        if (r67 == null) goto L145;
        Long r68 = StringsKt.toLongOrNull(r67);
    L146:
        r58[2] = TuplesKt.to("conversation_id", r68);
        ny9.s r69 = r116.W3();
        if (r69 == null) goto L153;
        ChatParam r70 = r69.c();
        if (r70 == null) goto L153;
        String r71 = r70.a;
        if (r71 == null) goto L153;
        Long r72 = StringsKt.toLongOrNull(r71);
    L154:
        r58[3] = TuplesKt.to("argConversationId", r72);
        ny9.s r73 = r116.W3();
        if (r73 == null) goto L159;
        ChatParam r74 = r73.c();
        if (r74 == null) goto L159;
        String r75 = r74.b;
    L160:
        r58[4] = TuplesKt.to("bot_id", r75);
        r58[5] = TuplesKt.to("action_bar_key", r61.b);
        r58[6] = TuplesKt.to("action_bar_recommend_from", "chat_action_bar");
        r58[7] = TuplesKt.to("req_id", r61.A);
        r58[8] = TuplesKt.to("action_bar_item_id", r61.a);
        com.larus.bmhome.actionbar.model.e0 r76 = r61.m;
        if (r76 == null) goto L163;
        r5 = r76.b;
    L163:
        r58[9] = TuplesKt.to("realtime_call_scene_model", r5);
        Bundle r77 = com.larus.utils.f.c(r58);
        com.bytedance.router.i r78 = SmartRouter.buildRoute(AppHost.a.getApplication().getApplicationContext(), r37);
        r78.c.putExtras(r77);
        r78.d();
        Unit r79 = Unit.INSTANCE;
        return;
    L159:
        r75 = null;
    L153:
        r72 = null;
    L145:
        r68 = null;
        goto L146
    L97:
        r119 = false;
        goto L98
    L92:
        r37 = null;
    L165:
        ry9.h r80 = this.a.l4();
        if (r80 == null) goto L168;
        r80.QA(new ry9.b());
        Unit r81 = Unit.INSTANCE;
    L168:
        vp8.i r82 = this.a.G;
        if (r82 == null) goto L171;
        Boolean r83 = Boolean.valueOf(r82.c(r61));
    L172:
        FLogger r120 = FLogger.a;
        r120.i("CreationEditorComponent", "createActionBarClickCallback isIntercept = " + r83);
        Boolean r121 = Boolean.TRUE;
        if (Intrinsics.areEqual(r83, r121) == true) goto L214;
        CreationEditorComponent r122 = this.a;
        if (r122.G4(r61) == true) goto L202;
        com.larus.bmhome.actionbar.model.r r84 = r61.q;
        if (r84 != null) goto L180;
    L182:
        boolean r85 = false;
    L183:
        if (r85 == false) goto L203;
        ICoreInputAbility r86 = r122.a4();
        if (r86 == null) goto L187;
        r86.p80(false);
    L187:
        FragmentActivity r210 = s1a.a.getActivity(r122);
        r120.d("CreationEditorComponent", "handleInstructionForm-startCreationActivity, type=" + r61.g + ", action_key=" + r61.b + ", openFrom=1");
        ny9.s r87 = r122.W3();
        if (r87 == null) goto L190;
        ChatParam r123 = r87.c();
    L191:
        LinkedHashMap r124 = new LinkedHashMap();
        r124.put("is_creation_action_bar", "1");
        ICreationWorkflowService.Companion r125 = ICreationWorkflowService.a;
        p1 r88 = new p1(null, r123, r122, r61);
        ChatPageContext r410 = s1a.d.a(r122).a(ChatPageContext.class);
        Pair[] r89 = new Pair[3];
        ny9.s r90 = r122.W3();
        if (r90 != null) goto L194;
    L196:
        boolean r91 = false;
    L197:
        r89[0] = TuplesKt.to("enable_compact_fragment_forseti", Boolean.valueOf(r91));
        r89[1] = TuplesKt.to("actionbar_instruction_default_params", null);
        if (r61.y == true) goto L201;
        r29 = "0";
    L201:
        r89[2] = TuplesKt.to("actionbar_instruction_send_message_track_ext_map", new ICoreInputAbility.SendMessageTrackExtMap(MapsKt.mapOf(TuplesKt.to("red_dot", r29))));
        r125.f0(new ny9.b(false, r210, r61, r123, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, r88, null, com.larus.utils.f.c(r89), false, r124, null, null, false, null, false, null, null, null, null, r121, null, null, null, null, null, null, null, null, r410, null, null, null, null, false, -245366927, 258039));
        goto L202
    L194:
        if (r90.a() != true) goto L196;
        r91 = true;
        goto L197
    L190:
        r123 = null;
        goto L191
    L203:
        r5 = null;
        com.larus.bmhome.actionbar.model.z0 r126 = r61;
        Integer r92 = r126.g;
        int r93 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r92 != null) goto L207;
    L212:
        boolean r127 = false;
        com.larus.bmhome.view.actionbar.edit.c.a.a(r122.i4(), r61, null, 1, null, null, null, null, 96);
    L213:
        Unit r94 = Unit.INSTANCE;
    L218:
        if (this.a.T4() == false) goto L234;
        com.larus.bmhome.actionbar.model.r r95 = r126.q;
        if (r95 == null) goto L227;
        Integer r96 = r95.a;
        if (r96 == null) goto L227;
        boolean r97 = true;
        ?? r98 = 1;
        if (r96.intValue() != 1) goto L228;
        boolean r99 = true;
    L229:
        if (r99 == false) goto L234;
        ICoreInputAbility r100 = this.a.a4();
        if (r100 == null) goto L234;
        r100.g2(r98, r98);
        Unit r101 = Unit.INSTANCE;
    L228:
        r99 = false;
        r98 = r97;
    L227:
        r97 = true;
    L234:
        if (r126.y == false) goto L254;
        com.larus.bmhome.chat.api.e0 r102 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r102 == null) goto L240;
        LaunchInfo r103 = r102.a;
        if (r103 == null) goto L240;
        SceneModel r104 = r103.W();
    L241:
        com.larus.bmhome.view.actionbar.custom.cache.k r105 = (com.larus.bmhome.view.actionbar.custom.cache.k) this.a.q.getValue();
        if (r104 != null) goto L244;
        r104 = "";
    L244:
        r105.a(r104, String.valueOf(r126.a));
        r126.y = r127;
        this.b.invoke(Integer.valueOf(r62));
        return;
    L240:
        r104 = r5;
        goto L241
    L254:
        return;
    L207:
        if (r92.intValue() != r93) goto L212;
        ICoreInputAbility r106 = r122.a4();
        r127 = false;
        if (r106 == null) goto L211;
        r106.p80(false);
    L211:
        IAIChatUgcAIGCService.Companion r107 = IAIChatUgcAIGCService.a;
        Intrinsics.checkNotNullParameter(r122, "<this>");
        r107.a0(com.larus.ui.arch.component.internal.attach.a.b(r122, r122), r122, r61, Boolean.FALSE, false, null, null);
        goto L213
    L180:
        if (r84.f() != true) goto L182;
        r85 = true;
    L202:
        r126 = r61;
        r127 = false;
        goto L213
    L214:
        r5 = null;
        r126 = r61;
        r127 = false;
        ICoreInputAbility r108 = this.a.a4();
        if (r108 == null) goto L218;
        r108.p80(false);
        Unit r109 = Unit.INSTANCE;
        goto L218
    L171:
        r83 = null;
    L50:
        r26 = false;
        goto L52
    L41:
        r39 = null;
    L37:
        r110 = null;
    L31:
        r16 = null;
        goto L32
    L23:
        r17 = null;
        goto L24
    L20:
        r22 = null;
    L16:
        r13 = r4;
        goto L17
    L5:
        r4 = null;
        goto L6
    }
}
