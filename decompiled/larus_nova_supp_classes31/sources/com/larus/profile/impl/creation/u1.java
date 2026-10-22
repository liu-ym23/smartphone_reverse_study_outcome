package com.larus.profile.impl.creation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CustomInputInitData;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.service.AccountService;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u1 {
    public static final /* synthetic */ int h = 0;
    public final Context a;
    public final View b;
    public final LifecycleCoroutineScope c;
    public final UserCreation d;
    public final boolean e;
    public final boolean f;
    public final gs9.b g;

    public static final class a {
    }

    static {
    }

    public final void c(String r97) {
        UserCreation r8 = this.d;
        if (r8 == null) goto L420;
        gs9.b r1 = this.g;
        if (r1 == null) goto L8;
        String r2 = r1.a;
        if (r2 == null) goto L8;
    L9:
        String r13 = r2;
        String r12 = r8.a;
        String r15 = zp9.d.d(r8);
        String r16 = zp9.d.c(r8);
        String r17 = zp9.d.b(r8);
        AuthorInfo r3 = r8.g;
        if (r3 == null) goto L12;
        String r18 = r3.b;
    L13:
        UserCreationTrackParams r4 = r8.n;
        if (r4 == null) goto L16;
        String r21 = r4.a;
    L17:
        gs9.b r5 = this.g;
        if (r5 == null) goto L20;
        String r26 = r5.b;
    L21:
        if (r4 == null) goto L23;
        Integer r19 = r4.c;
    L24:
        if (r4 == null) goto L26;
        Integer r20 = r4.b;
    L27:
        if (r4 == null) goto L29;
        String r11 = r4.g;
    L30:
        if (r4 == null) goto L32;
        String r23 = r4.d;
    L33:
        if (r4 == null) goto L35;
        String r25 = r4.e;
    L36:
        if (r4 == null) goto L38;
        String r24 = r4.f;
    L39:
        String r6 = r8.i;
        String r32 = zp9.d.c(r8);
        boolean r7 = r8.z();
        boolean r9 = r8.D();
        UserCreationRefContent r10 = r8.o;
        if (r10 == null) goto L44;
        List<ImageInfo> r14 = r10.a();
        if (r14 == null) goto L44;
        Integer r34 = Integer.valueOf(r14.size());
    L45:
        tx9.u3.l(r11, r12, r13, null, r15, r16, r17, r18, r19, r20, r21, null, r23, r24, r25, r26, null, null, null, null, r6, r32, Boolean.valueOf(r9), r34, Boolean.valueOf(r7), null, null, zp9.d.e(r8), zp9.d.a(r8, false), Boolean.valueOf(IUgcAIGCService.a.v()), null, null, null, null, null, 406593928, 31);
        UserCreation r22 = this.d;
        if (r22 == null) goto L48;
        String r27 = is9.a.b(r22);
    L50:
        if (this.e == false) goto L54;
        LifecycleCoroutineScope r110 = this.c;
        if (r110 == null) goto L57;
        BuildersKt.launch$default(r110, null, null, new CreationTemplateComponent$jumpChatPageByMakeSame$1(r8, null), 3, null);
    L57:
        AuthModelDelegate r28 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r29 = (com.larus.bmhome.chat.api.e0) r28.e().getValue();
        if (r29 == null) goto L65;
        LaunchInfo r30 = r29.a;
        if (r30 == null) goto L65;
        String r31 = r30.W();
        if (r31 == null) goto L65;
        String r111 = r31;
    L66:
        Pair[] r33 = new Pair[5];
        r33[0] = TuplesKt.to("argBotId", r111);
        r33[1] = TuplesKt.to("argBotType", 1);
        r33[2] = TuplesKt.to("actionbar_creation_id", r8.a);
        gs9.b r112 = this.g;
        if (r112 == null) goto L70;
        String r113 = r112.a;
        if (r113 == null) goto L70;
    L71:
        r33[3] = TuplesKt.to("argPreviousPage", r113);
        r33[4] = TuplesKt.to("actionbar_instruction_default_params", r27);
        Bundle r35 = com.larus.utils.f.c(r33);
        int r36 = r8.b;
        String r114 = "id";
        if (r36 != 2) goto L152;
        List r0 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r111);
        if (r0 == null) goto L91;
        Iterator r37 = r0.iterator();
    L77:
        if (r37.hasNext() == false) goto L89;
        Object r38 = r37.next();
        com.larus.bmhome.actionbar.model.r r39 = ((com.larus.bmhome.actionbar.model.z0) r38).q;
        if (r39 == null) goto L86;
        Integer r40 = r39.a;
        if (r40 == null) goto L86;
        if (r40.intValue() != 4) goto L86;
        boolean r41 = true;
    L87:
        if (r41 == false) goto L77;
    L90:
        com.larus.bmhome.actionbar.model.z0 r42 = (com.larus.bmhome.actionbar.model.z0) r38;
    L92:
        if (r42 == null) goto L99;
        com.larus.bmhome.actionbar.model.r r43 = r42.q;
        if (r43 == null) goto L99;
        if (r43.f() != true) goto L99;
        boolean r44 = true;
    L101:
        if (r44 == false) goto L127;
        Activity r310 = AppHost.a.a().getCurrentActivity();
        if (r310 == null) goto L421;
        CustomInputInitData r65 = s.a(r8);
        IUgcAIGCService.Companion r45 = IUgcAIGCService.a;
        if (r65 == null) goto L107;
        boolean r311 = true;
    L108:
        ChatParam r312 = new ChatParam(null, r111, null, null, null, 253);
        UserCreationContent r46 = r8.e;
        if (r46 == null) goto L113;
        UserCreationImage r47 = r46.a;
        if (r47 == null) goto L113;
        String r48 = r47.c;
    L114:
        v1 r49 = new v1(r8);
        JSONObject r115 = new JSONObject();
        UserCreation r116 = this.d;
        if (r116 == null) goto L117;
        String r117 = r116.a;
    L118:
        r115.put("id", r117);
        gs9.b r118 = this.g;
        if (r118 == null) goto L121;
        String r119 = r118.b;
    L122:
        r115.put("recommend_from", r119);
        UserCreationTrackParams r120 = r8.n;
        if (r120 == null) goto L125;
        String r121 = r120.a;
    L126:
        r115.put("template_rec_req_id", r121);
        r115.put("template_rec_extra", r8.i);
        r115.put("from_template_id", r8.a);
        Unit r50 = Unit.INSTANCE;
        r45.W(new ny9.b(r311, r310, r42, r312, true, false, null, r48, null, null, null, null, null, null, null, null, null, null, null, false, false, r49, null, com.larus.utils.f.c(new Pair[]{TuplesKt.to("actionbar_instruction_send_message_track_ext_map", d(r8)), TuplesKt.to("actionbar_instruction_default_params", r27), TuplesKt.to("image_second_edit_scene", "generated_img_edit")}), false, MapsKt.mapOf(TuplesKt.to("creation_template", r115.toString())), null, null, false, r65, true, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1654653088, 262143));
        return;
    L125:
        r121 = null;
        goto L126
    L121:
        r119 = null;
        goto L122
    L117:
        r117 = null;
    L113:
        r48 = null;
        goto L114
    L107:
        r311 = false;
        goto L108
    L421:
        return;
    L127:
        FLogger r51 = FLogger.a;
        StringBuilder r52 = new StringBuilder("template is ");
        r52.append(r27);
        r52.append(" prompt is ");
        UserCreationContent r53 = r8.e;
        if (r53 == null) goto L132;
        UserCreationImage r54 = r53.a;
        if (r54 == null) goto L132;
        String r55 = r54.c;
    L133:
        r52.append(r55);
        r51.i("CreationTemplateComponent", r52.toString());
        com.bytedance.router.i r56 = SmartRouter.buildRoute(this.a, "//flow/chat_page");
        r56.c.putExtras(r35);
        Pair[] r57 = new Pair[5];
        r57[0] = TuplesKt.to("actionbar_instruction_type", 4);
        UserCreationContent r58 = r8.e;
        if (r58 == null) goto L138;
        UserCreationImage r59 = r58.a;
        if (r59 == null) goto L138;
        String r60 = r59.c;
    L139:
        r57[1] = TuplesKt.to("actionbar_instruction_prompt", r60);
        r57[2] = TuplesKt.to("actionbar_creation_type", "pic");
        JSONObject r61 = new JSONObject();
        UserCreation r62 = this.d;
        if (r62 == null) goto L142;
        String r63 = r62.a;
    L143:
        r61.put("id", r63);
        gs9.b r64 = this.g;
        if (r64 == null) goto L146;
        String r66 = r64.b;
    L147:
        r61.put("recommend_from", r66);
        UserCreationTrackParams r67 = r8.n;
        if (r67 == null) goto L150;
        String r68 = r67.a;
    L151:
        r61.put("template_rec_req_id", r68);
        r61.put("template_rec_extra", r8.i);
        r61.put("from_template_id", r8.a);
        Unit r69 = Unit.INSTANCE;
        r57[3] = TuplesKt.to("actionbar_instruction_message_ext_map", new ICoreInputAbility.MessageExtMap(MapsKt.mapOf(TuplesKt.to("creation_template", r61.toString()))));
        r57[4] = TuplesKt.to("actionbar_instruction_send_message_track_ext_map", d(r8));
        r56.c.putExtras(com.larus.utils.f.c(r57));
        r56.d = 2130772401;
        r56.e = 2130772399;
        r56.d();
        return;
    L150:
        r68 = null;
        goto L151
    L146:
        r66 = null;
        goto L147
    L142:
        r63 = null;
    L138:
        r60 = null;
    L132:
        r55 = null;
    L99:
        r44 = false;
    L86:
        r41 = false;
        goto L87
    L89:
        r38 = null;
        goto L90
    L91:
        r42 = null;
        goto L92
    L152:
        String r70 = "template_rec_extra";
        String r94 = "template_rec_req_id";
        String r95 = "recommend_from";
        if (r36 != 4) goto L176;
        UserCreationContent r71 = r8.e;
        if (r71 == null) goto L159;
        AiBeautifyUserContent r72 = r71.d;
        if (r72 == null) goto L159;
        String r73 = r72.d;
    L160:
        if (r71 == null) goto L164;
        AiBeautifyUserContent r74 = r71.d;
        if (r74 == null) goto L164;
        String r75 = r74.e;
    L165:
        w1 r76 = new w1();
        if (com.larus.utils.o0.d(r75) == false) goto L168;
        com.bytedance.router.i r77 = SmartRouter.buildRoute(this.a, r75);
        r77.c.putExtras(r35);
        r77.c.putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("input_image_uri", r97), TuplesKt.to("actionbar_instruction_prompt", r73), TuplesKt.to("instruction_hit_point_params", com.larus.utils.f.c(new Pair[]{TuplesKt.to("instruction_hit_point_params", ny9.v.a(r76))}))}));
        r77.d = 2130772400;
        r77.e = 2130772399;
        r77.d();
        Unit r78 = Unit.INSTANCE;
        return;
    L168:
        LifecycleCoroutineScope r122 = this.c;
        ICreationPageService.a.getClass();
        if (ICreationPageService.a.a() == true) goto L171;
    L174:
        com.bytedance.router.i r79 = SmartRouter.buildRoute(this.a, "//flow/chat_page");
        r79.c.putExtras(r35);
        r79.c.putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("actionbar_instruction_prompt", r73), TuplesKt.to("actionbar_instruction_type", 16), TuplesKt.to("actionbar_creation_type", "image_edit"), TuplesKt.to("actionbar_file_path", r97), TuplesKt.to("instruction_hit_point_params", com.larus.utils.f.c(new Pair[]{TuplesKt.to("instruction_hit_point_params", ny9.v.a(r76))}))}));
        r79.d = 2130772401;
        r79.e = 2130772399;
        r79.d();
        Unit r80 = Unit.INSTANCE;
        return;
    L171:
        if (com.larus.utils.o0.d(r97) == false) goto L174;
        if (r122 == null) goto L174;
        BuildersKt.launch$default(r122, null, null, new CreationTemplateComponent$jumpChatPageByMakeSame$5(this, r73, r97, r27, r76, r111, r8, null), 3, null);
        return;
    L164:
        r75 = null;
    L159:
        r73 = null;
        goto L160
    L176:
        if (r36 != 1) goto L320;
        Result.Companion r81 = Result.Companion;     // Catch: Throwable -> L185
        Gson r82 = HttpExtKt.f;     // Catch: Throwable -> L185
        UserCreationContent r83 = r8.e;     // Catch: Throwable -> L185
        if (r83 == null) goto L182;
        UserCreationMusic r84 = r83.b;     // Catch: Throwable -> L185
        if (r84 == null) goto L182;
        String r85 = r84.j;     // Catch: Throwable -> L185
    L183:
        Object r86 = Result.constructor-impl((com.larus.bmhome.music.protocol.e) r82.fromJson(r85, com.larus.bmhome.music.protocol.e.class));     // Catch: Throwable -> L185
    L188:
        if (Result.isFailure-impl(r86) == false) goto L190;
        r86 = null;
    L190:
        com.larus.bmhome.music.protocol.e r87 = (com.larus.bmhome.music.protocol.e) r86;
        if (r87 == null) goto L294;
        UserCreationContent r88 = r8.e;
        if (r88 == null) goto L197;
        UserCreationMusic r89 = r88.b;
        if (r89 == null) goto L197;
        String r90 = r89.j;
    L199:
        if (com.larus.platform.service.z2.a.V3() == false) goto L290;
        if (r90 != null) goto L202;
    L205:
        boolean r123 = true;
    L206:
        if (r123 == true) goto L290;
        AuthModelDelegate r124 = AuthModelDelegate.b;
        wc9.e r125 = (wc9.e) r124.y().getValue();
        if (r125 != null) goto L216;
        r125 = (wc9.e) r124.u().getValue();
        if (r125 != null) goto L216;
        String r98 = "";
        String r210 = "//flow/chat_page";
        ILaunchCacheService r91 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r91 == null) goto L215;
        wc9.e r92 = r91.b();
    L217:
        if (r92 == null) goto L220;
        String r93 = r92.a;
        if (r93 == null) goto L220;
    L226:
        if (r93 != null) goto L228;
    L231:
        boolean r126 = true;
    L232:
        if (r126 == false) goto L235;
        FLogger.a.e("CreationTemplateComponent", "open music do-same applet failed, main conversation is empty");
    L234:
        r114 = "id";
        String r96 = "from_template_id";
        String r99 = "actionbar_instruction_message_ext_map";
        r94 = r94;
        r95 = r95;
        boolean r100 = false;
    L292:
        if (r100 == true) goto L431;
    L295:
        com.bytedance.router.i r101 = SmartRouter.buildRoute(this.a, r210);
        r101.c.putExtras(r35);
        Pair[] r102 = new Pair[4];
        r102[0] = TuplesKt.to("actionbar_instruction_type", 1);
        if (r87 == null) goto L298;
        String r103 = r87.b();
    L300:
        if (com.larus.utils.o0.d(r103) == false) goto L303;
        if (r87 == null) goto L305;
        String r104 = r87.b();
    L306:
        r102[1] = TuplesKt.to("actionbar_instruction_prompt", r104);
        r102[2] = TuplesKt.to("actionbar_creation_type", "music");
        JSONObject r105 = new JSONObject();
        UserCreation r106 = this.d;
        if (r106 == null) goto L309;
        String r107 = r106.a;
    L310:
        r105.put(r114, r107);
        gs9.b r108 = this.g;
        if (r108 == null) goto L313;
        String r109 = r108.b;
    L314:
        r105.put(r95, r109);
        UserCreationTrackParams r127 = r8.n;
        if (r127 == null) goto L317;
        String r128 = r127.a;
    L318:
        r105.put(r94, r128);
        r105.put(r70, r8.i);
        r105.put(r96, r8.a);
        Unit r129 = Unit.INSTANCE;
        r102[3] = TuplesKt.to(r99, new ICoreInputAbility.MessageExtMap(MapsKt.mapOf(TuplesKt.to("creation_template", r105.toString()))));
        r101.c.putExtras(com.larus.utils.f.c(r102));
        r101.d = 2130772401;
        r101.e = 2130772399;
        r101.d();
        return;
    L317:
        r128 = null;
        goto L318
    L313:
        r109 = null;
        goto L314
    L309:
        r107 = null;
    L305:
        r104 = null;
        goto L306
    L303:
        if (r87 == null) goto L305;
        r104 = r87.a();
        goto L306
    L298:
        r103 = null;
        goto L300
    L431:
        return;
    L235:
        String r130 = r35.getString("argBotId");
        if (r130 != null) goto L238;
        String r313 = r98;
    L239:
        String r131 = r35.getString("argPreviousPage");
        if (r131 != null) goto L242;
        String r314 = "creation_detail";
    L243:
        if (r92 == null) goto L245;
        String r132 = ic8.n.f(r92);
    L246:
        if (r132 != null) goto L249;
        r132 = r98;
    L249:
        if (r132.length() != 0) goto L251;
        boolean r133 = true;
    L252:
        if (r133 == false) goto L255;
        r132 = "default";
    L255:
        if (com.larus.utils.o0.d(r87.b()) == false) goto L257;
        String r134 = r87.b();
    L258:
        r87 = r87;
        JSONObject r135 = new JSONObject();
        UserCreation r136 = this.d;
        if (r136 == null) goto L261;
        String r137 = r136.a;
    L262:
        r135.put("id", r137);
        gs9.b r138 = this.g;
        if (r138 == null) goto L265;
        String r139 = r138.b;
    L266:
        r135.put(r95, r139);
        UserCreationTrackParams r140 = r8.n;
        if (r140 == null) goto L269;
        String r141 = r140.a;
    L270:
        r135.put(r94, r141);
        r135.put(r70, r8.i);
        r70 = r70;
        r96 = "from_template_id";
        r135.put(r96, r8.a);
        Parcelable r142 = new ICoreInputAbility.MessageExtMap(MapsKt.mapOf(TuplesKt.to("creation_template", r135.toString())));
        Bundle r143 = new Bundle(r35);
        r143.putString("argConversationId", r93);
        r143.putString("arg_chat_type", r132);
        r143.putParcelable("chat_param", new ChatParam(r93, r313, r314, "chat", r132, 224));
        r143.putInt("actionbar_instruction_type", 1);
        r143.putString("actionbar_instruction_prompt", r134);
        r143.putString("actionbar_creation_type", "music");
        r99 = "actionbar_instruction_message_ext_map";
        r143.putParcelable(r99, r142);
        r143.putString("music_replica_params", r90);
        r143.putString("source", "profile_creation_detail");
        AuthorInfo r144 = r8.g;
        if (r144 == null) goto L277;
        String r145 = r144.b;
        if (r145 == null) goto L277;
        if ((!Intrinsics.areEqual(r145, AccountService.a.getUserId())) != true) goto L277;
        boolean r146 = true;
    L278:
        r143.putBoolean("keep_foreground_after_send", r146);
        r143.putString("from_entrance", "similar");
        r143.putBoolean("auto_open_input_panel", true);
        Object r147 = Result.constructor-impl(Boolean.valueOf(IUgcAIGCService.a.Y(r143)));     // Catch: Throwable -> L281
    L283:
        Throwable r148 = Result.exceptionOrNull-impl(r147);
        if (r148 == null) goto L286;
        FLogger.a.e("CreationTemplateComponent", "open music do-same applet failed", r148);
    L286:
        Boolean r149 = Boolean.FALSE;
        if (Result.isFailure-impl(r147) == false) goto L289;
        r147 = r149;
    L289:
        r100 = ((Boolean) r147).booleanValue();
    L281:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        r147 = Result.constructor-impl(ResultKt.createFailure(th));
    L277:
        r146 = false;
        goto L278
    L269:
        r141 = null;
        goto L270
    L265:
        r139 = null;
        goto L266
    L261:
        r137 = null;
        goto L262
    L257:
        r134 = r87.a();
        goto L258
    L251:
        r133 = false;
        goto L252
    L245:
        r132 = null;
        goto L246
    L242:
        r314 = r131;
        goto L243
    L238:
        r313 = r130;
        goto L239
    L228:
        if (StringsKt.isBlank(r93) == true) goto L231;
        r126 = false;
    L220:
        com.larus.bmhome.chat.api.e0 r151 = (com.larus.bmhome.chat.api.e0) r124.e().getValue();
        if (r151 == null) goto L225;
        LaunchInfo r152 = r151.a;
        if (r152 == null) goto L225;
        r93 = r152.Y();
    L225:
        r93 = null;
        goto L226
    L215:
        r92 = null;
    L216:
        r98 = "";
        r210 = "//flow/chat_page";
        r92 = r125;
        goto L217
    L202:
        if (StringsKt.isBlank(r90) == true) goto L205;
        r123 = false;
    L290:
        r210 = "//flow/chat_page";
    L197:
        r90 = null;
        goto L199
    L294:
        r70 = r70;
        r87 = r87;
        r210 = "//flow/chat_page";
        r114 = "id";
        r96 = "from_template_id";
        r99 = "actionbar_instruction_message_ext_map";
        r94 = r94;
        r95 = r95;
    L182:
        r85 = null;
    L185:
        th = move-exception;
        Result.Companion r153 = Result.Companion;
        r86 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L188
    L320:
        if (r36 == 3) goto L322;
        return;
    L322:
        if (this.f == false) goto L407;
        com.larus.bmhome.chat.api.e0 r154 = (com.larus.bmhome.chat.api.e0) r28.e().getValue();
        if (r154 == null) goto L329;
        LaunchInfo r155 = r154.a;
        if (r155 == null) goto L329;
        String r156 = r155.W();
        if (r156 == null) goto L329;
    L330:
        List r157 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r156);
        if (r157 == null) goto L349;
        Iterator r158 = r157.iterator();
    L334:
        if (r158.hasNext() == false) goto L347;
        Object r159 = r158.next();
        com.larus.bmhome.actionbar.model.r r160 = ((com.larus.bmhome.actionbar.model.z0) r159).q;
        if (r160 == null) goto L343;
        Integer r161 = r160.a;
        if (r161 == null) goto L343;
        if (r161.intValue() != 11) goto L343;
        boolean r162 = true;
    L344:
        if (r162 == false) goto L334;
    L348:
        com.larus.bmhome.actionbar.model.z0 r163 = (com.larus.bmhome.actionbar.model.z0) r159;
    L350:
        if (r163 == null) goto L357;
        Integer r164 = r163.g;
        int r165 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r164 == null) goto L357;
        if (r164.intValue() != r165) goto L357;
        boolean r166 = true;
    L358:
        if (r166 == false) goto L406;
        ILaunchCacheService r167 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r167 == null) goto L364;
        wc9.e r168 = r167.b();
        if (r168 == null) goto L364;
        String r169 = r168.a;
    L365:
        com.bytedance.router.i r170 = SmartRouter.buildRoute(this.a, "//flow/create_digital_avatar");
        r170.c.putExtra("argConversationId", r169);
        UserCreationContent r171 = r8.e;
        if (r171 == null) goto L370;
        UserCreationUserAvatar r172 = r171.c;
        if (r172 == null) goto L370;
        String r173 = r172.c;
    L371:
        r170.c.putExtra("actionbar_instruction_prompt", r173);
        r170.c.putExtra("need_router_to_chat", true);
        JSONObject r174 = new JSONObject();
        UserCreation r175 = this.d;
        if (r175 == null) goto L374;
        String r176 = r175.a;
    L375:
        r174.put("id", r176);
        gs9.b r177 = this.g;
        if (r177 == null) goto L378;
        String r178 = r177.b;
    L379:
        r174.put(r95, r178);
        UserCreationTrackParams r179 = r8.n;
        if (r179 == null) goto L382;
        String r180 = r179.a;
    L383:
        r174.put(r94, r180);
        r174.put(r70, r8.i);
        r174.put("from_template_id", r8.a);
        Unit r181 = Unit.INSTANCE;
        r170.c.putExtra("creation_template", r174.toString());
        UserCreationTrackParams r182 = r8.n;
        if (r182 == null) goto L386;
        String r183 = r182.d;
    L387:
        r170.c.putExtra("ai_generate_tab_id", r183);
        UserCreationTrackParams r184 = r8.n;
        if (r184 == null) goto L390;
        String r185 = r184.e;
    L391:
        r170.c.putExtra("ai_generate_tab_name", r185);
        UserCreationTrackParams r186 = r8.n;
        if (r186 == null) goto L394;
        String r187 = r186.f;
    L395:
        r170.c.putExtra("ai_generate_tab_type", r187);
        r170.c.putExtra("from_template_sub_type", zp9.d.c(r8));
        r170.c.putExtra("is_has_caption", String.valueOf(r8.z()));
        r170.c.putExtra("is_image_reference_public", String.valueOf(r8.D()));
        wc9.e r188 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r188 == null) goto L398;
        String r189 = ic8.n.f(r188);
    L399:
        if (r189 != null) goto L401;
        r189 = "";
    L401:
        r170.c.putExtra("chat_type", r189);
        UserCreationTrackParams r190 = r8.n;
        if (r190 == null) goto L404;
        String r191 = r190.g;
    L405:
        r170.c.putExtra("bot_id", r191);
        r170.c.addFlags(268435456);
        r170.d();
        FLogger.a.i("CreationTemplateComponent", "noAvatar so goto create avatar, conversation id: " + r169 + ' ');
        return;
    L404:
        r191 = null;
        goto L405
    L398:
        r189 = null;
        goto L399
    L394:
        r187 = null;
        goto L395
    L390:
        r185 = null;
        goto L391
    L386:
        r183 = null;
        goto L387
    L382:
        r180 = null;
        goto L383
    L378:
        r178 = null;
        goto L379
    L374:
        r176 = null;
    L370:
        r173 = null;
    L364:
        r169 = null;
        goto L365
    L406:
        b(r35, r8);
        return;
    L357:
        r166 = false;
    L343:
        r162 = false;
        goto L344
    L347:
        r159 = null;
        goto L348
    L349:
        r163 = null;
    L329:
        r156 = "7234781073513644036";
        goto L330
    L407:
        b(r35, r8);
        return;
    L70:
        r113 = "creation_detail";
    L65:
        r111 = "7234781073513644036";
        goto L66
    L54:
        LifecycleCoroutineScope r192 = this.c;
        if (r192 == null) goto L57;
        BuildersKt.launch$default(r192, null, null, new CreationTemplateComponent$jumpChatPageByMakeSame$2(r8, null), 3, null);
        goto L57
    L48:
        r27 = null;
    L44:
        r34 = null;
        goto L45
    L38:
        r24 = null;
        goto L39
    L35:
        r25 = null;
        goto L36
    L32:
        r23 = null;
        goto L33
    L29:
        r11 = null;
        goto L30
    L26:
        r20 = null;
        goto L27
    L23:
        r19 = null;
        goto L24
    L20:
        r26 = null;
        goto L21
    L16:
        r21 = null;
        goto L17
    L12:
        r18 = null;
    L8:
        r2 = "creation_others_detail";
        goto L9
    }

    public final ICoreInputAbility.SendMessageTrackExtMap d(UserCreation r6) {
        Pair[] r1 = new Pair[8];
        r1[0] = TuplesKt.to("from_template_id", r6.a);
        r1[1] = TuplesKt.to("from_template_type", zp9.d.d(r6));
        UserCreationTrackParams r2 = r6.n;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.a;
    L6:
        r1[2] = TuplesKt.to("template_rec_req_id", r4);
        r1[3] = TuplesKt.to("template_rec_extra", r6.i);
        r1[4] = TuplesKt.to("from_template_source", zp9.d.b(r6));
        gs9.b r7 = this.g;
        if (r7 == null) goto L9;
        String r8 = r7.b;
    L10:
        r1[5] = TuplesKt.to("recommend_from", r8);
        gs9.b r9 = this.g;
        if (r9 == null) goto L13;
        r3 = r9.g;
    L13:
        r1[6] = TuplesKt.to("ai_creation_recommend_from", r3);
        r1[7] = TuplesKt.to("is_from_template", "1");
        return new ICoreInputAbility.SendMessageTrackExtMap(MapsKt.mapOf(r1));
    L9:
        r8 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void e(int r4) {
        if (r4 != 2) goto L5;
        View r5 = this.b;
        if (r5 == null) goto L39;
        r5.setVisibility(8);
        return;
    L39:
        return;
    L5:
        if (r4 != 3) goto L7;
        View r6 = this.b;
        if (r6 == null) goto L37;
        r6.setVisibility(8);
        return;
    L37:
        return;
    L7:
        if (r4 == 4) goto L11;
        View r7 = this.b;
        if (r7 == null) goto L33;
        r7.setVisibility(8);
        return;
    L33:
        return;
    L11:
        View r8 = this.b;
        if (r8 == null) goto L14;
        com.larus.utils.e1.x(r8);
    L14:
        View r9 = this.b;
        Button r1 = null;
        if ((r9 instanceof TextView) == false) goto L17;
        TextView r10 = (TextView) r9;
    L19:
        if (r10 == null) goto L21;
        r10.setText(this.a.getResources().getString(2131907247));
    L21:
        View r11 = this.b;
        if ((r11 instanceof Button) == false) goto L24;
        r1 = (Button) r11;
    L24:
        if (r1 == null) goto L35;
        r1.setText(this.a.getResources().getString(2131907247));
        return;
    L35:
        return;
    L17:
        r10 = null;
        goto L19
    }

    public final void b(Bundle r6, UserCreation r7) {
        com.bytedance.router.i r0 = SmartRouter.buildRoute(this.a, "//flow/chat_page");
        r0.c.putExtras(r6);
        r0.c.putExtras(r6);
        Pair[] r8 = new Pair[7];
        r8[0] = TuplesKt.to("actionbar_instruction_type", 11);
        UserCreationContent r1 = r7.e;
        String r2 = null;
        if (r1 == null) goto L7;
        UserCreationUserAvatar r3 = r1.c;
        if (r3 == null) goto L7;
        String r4 = r3.c;
    L8:
        r8[1] = TuplesKt.to("actionbar_instruction_prompt", r4);
        r8[2] = TuplesKt.to("actionbar_creation_type", "avatar");
        JSONObject r5 = new JSONObject();
        UserCreation r9 = this.d;
        if (r9 == null) goto L11;
        String r10 = r9.a;
    L12:
        r5.put("id", r10);
        gs9.b r11 = this.g;
        if (r11 == null) goto L15;
        String r12 = r11.b;
    L16:
        r5.put("recommend_from", r12);
        UserCreationTrackParams r13 = r7.n;
        if (r13 == null) goto L19;
        r2 = r13.a;
    L19:
        r5.put("template_rec_req_id", r2);
        r5.put("template_rec_extra", r7.i);
        r5.put("from_template_id", r7.a);
        Unit r14 = Unit.INSTANCE;
        r8[3] = TuplesKt.to("actionbar_instruction_message_ext_map", new ICoreInputAbility.MessageExtMap(MapsKt.mapOf(TuplesKt.to("creation_template", r5.toString()))));
        r8[4] = TuplesKt.to("actionbar_instruction_send_message_track_ext_map", d(r7));
        r8[5] = TuplesKt.to("actionbar_instruction_auto_send", Boolean.TRUE);
        r8[6] = TuplesKt.to("is_need_fixed_bottom_tab", Boolean.FALSE);
        r0.c.putExtras(com.larus.utils.f.c(r8));
        r0.d = 2130772401;
        r0.e = 2130772399;
        r0.d();
        return;
    L15:
        r12 = null;
        goto L16
    L11:
        r10 = null;
    L7:
        r4 = null;
        goto L8
    }

    public u1(Context r2, View r3, LifecycleCoroutineScope r4, UserCreation r5, boolean r6, boolean r7, gs9.b r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public static final Object a(u1 r17, ICoreInputAbility.OnSendParams r18, UserCreation r19, w1 r20, String r21, String r22, Continuation r23) {
        r17.getClass();
        if ((r23 instanceof CreationTemplateComponent$buildCreationSendMessageConfig$1) == false) goto L7;
        CreationTemplateComponent$buildCreationSendMessageConfig$1 r2 = (CreationTemplateComponent$buildCreationSendMessageConfig$1) r23;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        String r13 = "";
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        String r5 = (String) r2.L$5;
        String r6 = (String) r2.L$4;
        String r7 = (String) r2.L$3;
        zs8.a r8 = (zs8.a) r2.L$2;
        UserCreation r10 = (UserCreation) r2.L$1;
        ICoreInputAbility.OnSendParams r11 = (ICoreInputAbility.OnSendParams) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L34:
        wc9.e r12 = (wc9.e) r1;
        if (r12 != null) goto L37;
        r12 = (wc9.e) AuthModelDelegate.b.u().getValue();
    L37:
        ICoreInputAbility.OnSendParams r14 = r11;
        String r15 = r6;
        UserCreation r16 = r10;
    L38:
        if (r12 == null) goto L40;
        String r24 = r12.a;
    L41:
        if (r24 == null) goto L45;
        r13 = r24;
    L45:
        if (r13.length() != 0) goto L47;
        boolean r25 = true;
    L48:
        if (r25 == true) goto L51;
        r5 = r13;
    L51:
        CreationSendMessageConfig.Companion.getClass();
        CreationSendMessageConfig.a r26 = new CreationSendMessageConfig.a();
        r26.j(r12);
        r26.l(r5);
        r26.f(r7);
        r26.i(r14.getContent());
        r26.s(r14.getScene());
        r26.u(r14.getTxtScene());
        r26.m(r14.getEnterMethod());
        r26.r(r14.getPreviousPage());
        r26.d(Boxing.boxInt(r14.getActionInstruction()));
        r26.c(r14.getActionBarInstructionMap());
        r26.e(r14.getAttachment());
        r26.q(r14.messageExt);
        r26.t(r17.d(r16).a);
        r26.n(new ny9.u(new ny9.s(com.larus.utils.f.c(new Pair[]{TuplesKt.to("instruction_hit_point_params", ny9.v.a(r8))}))));
        r26.a(r16.a);
        r26.b(r15);
        r26.p(r14.getLocalIntercepted());
        r26.o(r14.getLocalInterceptInfo());
        r26.h(r14.clearInputContent);
        return r26.a;
    L47:
        r25 = false;
        goto L48
    L40:
        r24 = null;
        goto L41
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r5 = (String) r2.L$5;
        String r27 = (String) r2.L$4;
        r7 = (String) r2.L$3;
        r8 = (zs8.a) r2.L$2;
        UserCreation r28 = (UserCreation) r2.L$1;
        ICoreInputAbility.OnSendParams r29 = (ICoreInputAbility.OnSendParams) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r15 = r27;
        r16 = r28;
        r14 = r29;
    L28:
        r12 = (wc9.e) r1;
        if (r12 != null) goto L38;
        RepoDispatcher.a.getClass();
        ConversationRepo r30 = RepoDispatcher.f;
        r2.L$0 = r14;
        r2.L$1 = r16;
        r2.L$2 = r8;
        r2.L$3 = r7;
        r2.L$4 = r15;
        r2.L$5 = r5;
        r2.label = 2;
        r1 = r30.f(r2);
        if (r1 == r9) goto L54;
        r6 = r15;
        r11 = r14;
        r10 = r16;
        goto L34
    L54:
        return r9;
    L16:
        ResultKt.throwOnFailure(r1);
        com.larus.bmhome.chat.api.e0 r31 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r31 == null) goto L21;
        LaunchInfo r32 = r31.a;
        if (r32 == null) goto L21;
        String r33 = r32.Y();
    L22:
        if (r33 != null) goto L24;
        r33 = "";
    L24:
        RepoDispatcher.a.getClass();
        ConversationRepo r34 = RepoDispatcher.f;
        r14 = r18;
        r2.L$0 = r14;
        r16 = r19;
        r2.L$1 = r16;
        r2.L$2 = r20;
        r2.L$3 = r21;
        r15 = r22;
        r2.L$4 = r15;
        r2.L$5 = r33;
        r2.label = 1;
        Object r35 = IConversationRepoService.a.c(r34, r33, false, null, r2, 6);
        if (r35 == r9) goto L53;
        r8 = r20;
        r7 = r21;
        r5 = r33;
        r1 = r35;
        goto L28
    L53:
        return r9;
    L21:
        r33 = null;
    L7:
        r2 = new CreationTemplateComponent$buildCreationSendMessageConfig$1(r17, r23);
        goto L8
    }
}
