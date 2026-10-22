package com.larus.uaigc.createpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.j1;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.platform.service.z2;
import com.larus.uaigc.applet.IAICreationAppletHostService;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s0 {
    public static final s0 a = null;
    public static WeakReference<Fragment> b;
    public static final Lazy c = null;

    public s0() {
    }

    static {
        a = new s0();
        c = LazyKt.lazy(new r0());
    }

    public static Bundle a(ny9.a r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        Pair[] r0 = new Pair[5];
        r0[0] = TuplesKt.to("custom_action_bar_item", xt7.d.b.a(com.larus.bmhome.actionbar.model.z0.Companion.serializer(), r4.b));
        r0[1] = TuplesKt.to("chat_param", r4.c);
        r0[2] = TuplesKt.to("template_info", r4.d);
        zs8.a r1 = r4.e;
        if (r1 == null) goto L5;
        Bundle r2 = ny9.v.a(r1);
    L6:
        r0[3] = TuplesKt.to("instruction_hit_point_params", r2);
        r0[4] = TuplesKt.to("chat_page_context", r4.h);
        Bundle r3 = com.larus.utils.f.c(r0);
        r3.putBoolean("is_enter_template", false);
        Bundle r5 = r4.g;
        if (r5 == null) goto L9;
        r3.putAll(r5);
    L9:
        return r3;
    L5:
        r2 = null;
        goto L6
    }

    public static Bundle b(ny9.b r18) {
        Intrinsics.checkNotNullParameter(r18, "config");
        a.getClass();
        String r3 = "";
        String r5 = null;
        boolean r6 = false;
        if (r18.e == true) goto L5;
        ChatParam r2 = r18.d;
    L65:
        Pair[] r8 = new Pair[44];
        com.larus.bmhome.actionbar.model.z0 r9 = r18.c;
        com.larus.bmhome.actionbar.model.r r10 = r9.q;
        if (r10 == null) goto L73;
        Integer r11 = r10.a;
        if (r11 == null) goto L73;
        if (r11.intValue() != 28) goto L73;
        boolean r12 = true;
    L74:
        if (r12 == false) goto L85;
        com.larus.bmhome.actionbar.model.r r13 = r9.q;
        if (r13 == null) goto L79;
        j1 r14 = r13.e;
    L80:
        if (r14 == null) goto L85;
        String r15 = r14.t;
        if (r15 == null) goto L85;
        r3 = r15;
        goto L85
    L79:
        r14 = null;
    L85:
        r8[0] = TuplesKt.to("bottom_action_bar_item_id_list", r3);
        r8[1] = TuplesKt.to("need_finish_current_create_page", r18.J);
        r8[2] = TuplesKt.to("slides_mob_config", GsonProtectorUtils.toJson((Gson) c.getValue(), r18.M));
        r8[3] = TuplesKt.to("query_image_ratio", r18.N);
        r8[4] = TuplesKt.to("open_from", r18.O);
        r8[5] = TuplesKt.to("chat_param", r2);
        r8[6] = TuplesKt.to("chat_section_id", r18.W);
        r8[7] = TuplesKt.to("ref_image_url", r18.i);
        r8[8] = TuplesKt.to("ref_raw_image_url", r18.j);
        r8[9] = TuplesKt.to("ref_image_url_list", r18.k);
        r8[10] = TuplesKt.to("avatar_image_url_list", r18.l);
        r8[11] = TuplesKt.to("white_tee_index_list", r18.m);
        r8[12] = TuplesKt.to("select_instruction_type", r18.n);
        r8[13] = TuplesKt.to("open_new_chat_page_on_send", Boolean.valueOf(r18.e));
        r8[14] = TuplesKt.to("open_new_chat_page_on_send_with_clear_top", Boolean.valueOf(r18.f));
        r8[15] = TuplesKt.to("template_instruction_conf", r18.g);
        r8[16] = TuplesKt.to("user_prompt", r18.h);
        r8[17] = TuplesKt.to("reedit_ref_image", r18.o);
        r8[18] = TuplesKt.to("ref_image_instant_upload_info", r18.p);
        r8[19] = TuplesKt.to("ref_image_local_message_id", r18.q);
        r8[20] = TuplesKt.to("ref_image_album_path", r18.r);
        r8[21] = TuplesKt.to("ref_image_album_path_list", r18.s);
        r8[22] = TuplesKt.to("is_ai_creation", Boolean.valueOf(r18.t));
        r8[23] = TuplesKt.to("is_reedit", Boolean.valueOf(r18.u));
        zs8.a r4 = r18.v;
        if (r4 == null) goto L88;
        Bundle r7 = ny9.v.a(r4);
    L89:
        r8[24] = TuplesKt.to("instruction_hit_point_params", r7);
        r8[25] = TuplesKt.to("clear_input", Boolean.valueOf(r18.y));
        r8[26] = TuplesKt.to("select_start_position", r18.A);
        r8[27] = TuplesKt.to("select_end_position", r18.B);
        r8[28] = TuplesKt.to("is_enter_template", Boolean.valueOf(r18.C));
        r8[29] = TuplesKt.to("custom_input_init_data", r18.D);
        r8[30] = TuplesKt.to("ignore_side_bar", Boolean.valueOf(r18.E));
        r8[31] = TuplesKt.to("is_from_chat_double_page", r18.F);
        r8[32] = TuplesKt.to("is_show_reselect", r18.G);
        r8[33] = TuplesKt.to("is_private_image", r18.H);
        r8[34] = TuplesKt.to("no_ime_when_init", r18.I);
        r8[35] = TuplesKt.to("previous_page_name", r18.K);
        r8[36] = TuplesKt.to("feed_landing_tab", r18.L);
        r8[37] = TuplesKt.to("key_avatar_create_format", r18.P);
        r8[38] = TuplesKt.to("dosame_landing_type", r18.Q);
        r8[39] = TuplesKt.to("is_send_from_detail", r18.R);
        r8[40] = TuplesKt.to("creation_dosame_notify_info", r18.V);
        r8[41] = TuplesKt.to("chat_page_context", r18.S);
        xe8.a r16 = r18.U;
        if ((r16 instanceof xe8.a) == false) goto L92;
        xe8.a r17 = r16;
    L93:
        if (r17 == null) goto L99;
        ChatBubbleParams r19 = r17.Mz();
        if (r19 == null) goto L99;
        if (r19.b != true) goto L99;
        boolean r20 = true;
    L100:
        r8[42] = TuplesKt.to("enable_compact_fragment_forseti", Boolean.valueOf(r20));
        Map<String, String> r110 = r18.z;
        if (r110 != null) goto L103;
        r110 = MapsKt.emptyMap();
    L103:
        r8[43] = TuplesKt.to("actionbar_instruction_message_ext_map", new ICoreInputAbility.MessageExtMap(r110));
        Bundle r21 = com.larus.utils.f.c(r8);
        com.larus.bmhome.actionbar.model.z0 r22 = r18.c;
        List r23 = CollectionsKt.listOf(new Integer[]{4, 16, 18, 24});
        com.larus.bmhome.actionbar.model.r r24 = r22.q;
        if (r24 == null) goto L106;
        Integer r25 = r24.a;
    L108:
        if (CollectionsKt.contains(r23, r25) == true) goto L110;
    L120:
        com.larus.bmhome.actionbar.model.r r26 = r18.c.q;
        if (r26 == null) goto L123;
        boolean r27 = Intrinsics.areEqual(r26.j, Boolean.TRUE);
    L124:
        if (r27 == true) goto L126;
    L128:
        boolean r28 = false;
    L129:
        r21.putBoolean("is_enter_template", r28);
    L130:
        r21.putString("custom_action_bar_item", xt7.d.b.a(com.larus.bmhome.actionbar.model.z0.Companion.serializer(), r18.c));
        com.larus.bmhome.actionbar.model.r r29 = r18.c.q;
        if (r29 == null) goto L133;
        r6 = Intrinsics.areEqual(r29.j, Boolean.TRUE);
    L133:
        if (r6 == false) goto L140;
        Bundle r30 = r18.x;
        if (r30 == null) goto L138;
        r5 = r30.getString("default_open_page");
    L138:
        if (Intrinsics.areEqual(r5, "image_template") == true) goto L140;
        r21.putBoolean("template_enhance", true);
    L140:
        Bundle r31 = r18.x;
        if (r31 == null) goto L143;
        r21.putAll(r31);
    L143:
        int r32 = com.larus.uaigc.applet.a.a;
        Intrinsics.checkNotNullParameter(r18, "config");
        if (IAICreationAppletHostService.a.e(r18) == false) goto L146;
        r21.putBoolean("route_result_to_chat_after_ai_creation_applet", true);
    L146:
        return r21;
    L126:
        if (r21.getBoolean("is_enter_template", true) == false) goto L128;
        r28 = true;
        goto L129
    L123:
        r27 = false;
        goto L124
    L110:
        if (com.larus.utils.o0.d(r18.h) == false) goto L112;
    L119:
        r21.putBoolean("is_enter_template", false);
        goto L130
    L112:
        if (com.larus.utils.o0.d(r18.i) == true) goto L119;
        if (r18.o != null) goto L119;
        if (com.larus.utils.o0.d(r18.r) == true) goto L119;
        if (r18.u == false) goto L120;
    L106:
        r25 = null;
    L99:
        r20 = false;
        goto L100
    L92:
        r17 = null;
        goto L93
    L88:
        r7 = null;
    L73:
        r12 = false;
        goto L74
    L5:
        AuthModelDelegate r33 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r34 = (com.larus.bmhome.chat.api.e0) r33.e().getValue();
        if (r34 == null) goto L10;
        LaunchInfo r35 = r34.a;
        if (r35 == null) goto L10;
        String r36 = r35.W();
    L11:
        wc9.e r37 = (wc9.e) r33.y().getValue();
        if (r37 == null) goto L14;
        String r38 = r37.a;
    L15:
        if (r38 != null) goto L17;
        r38 = "";
    L17:
        ChatParam r111 = r18.d;
        if (r111 == null) goto L20;
        String r112 = r111.a;
    L21:
        if (r112 != null) goto L24;
        r112 = "";
    L24:
        if (com.larus.platform.exp.o.a() == false) goto L40;
        String[] r39 = new String[2];
        wc9.e r113 = (wc9.e) r33.y().getValue();
        if (r113 == null) goto L28;
        String r114 = r113.a;
    L29:
        r39[0] = r114;
        wc9.e r40 = (wc9.e) r33.u().getValue();
        if (r40 == null) goto L32;
        String r41 = r40.a;
    L33:
        r39[1] = r41;
        if (SetsKt.setOfNotNull(r39).contains(r112) == false) goto L37;
        r112 = null;
    L37:
        if (r112 != null) goto L47;
        r112 = "";
    L47:
        ChatParam r42 = r18.d;
        if (r42 != null) goto L50;
        r42 = new ChatParam(null, null, null, null, null, 255);
    L50:
        ChatParam r43 = r18.d;
        if (r43 == null) goto L53;
        String r44 = r43.b;
    L54:
        if (r44 != null) goto L57;
        r44 = "";
    L57:
        if (r44.length() != 0) goto L59;
        boolean r115 = true;
    L60:
        if (r115 == false) goto L64;
        if (r36 != null) goto L63;
        r36 = "";
    L63:
        r44 = r36;
    L64:
        r2 = ChatParam.a(r42, r112, r44, null, 252);
        goto L65
    L59:
        r115 = false;
        goto L60
    L53:
        r44 = null;
        goto L54
    L32:
        r41 = null;
        goto L33
    L28:
        r114 = null;
        goto L29
    L40:
        if (r112.length() != 0) goto L42;
        boolean r45 = true;
    L43:
        if (r45 == true) goto L46;
        r38 = r112;
    L46:
        r112 = r38;
        goto L47
    L42:
        r45 = false;
        goto L43
    L20:
        r112 = null;
        goto L21
    L14:
        r38 = null;
    L10:
        r36 = null;
        goto L11
    }

    public static void d(ny9.c r7) {
        Intrinsics.checkNotNullParameter(r7, "config");
        if ((r7 instanceof ny9.a) == false) goto L6;
        ny9.a r8 = (ny9.a) r7;
        s0 r0 = a;
        r0.getClass();
        e(r8);
        Bundle r2 = a(r8);
        c(r0, r8.a, r2, 0, null, null, 60);
        return;
    L6:
        if ((r7 instanceof ny9.b) == false) goto L10;
        f((ny9.b) r7, null);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static void e(ny9.c r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        if ((r3 instanceof ny9.a) == false) goto L10;
        com.larus.bmhome.actionbar.model.r r4 = ((ny9.a) r3).b.q;
        if (r4 == null) goto L16;
        Integer r5 = r4.a;
        if (r5 == null) goto L16;
        String r6 = r5.toString();
    L17:
        if (r6 != null) goto L19;
        r6 = "";
    L19:
        String r0 = UUID.randomUUID().toString();
        nz9.b r2 = nz9.b.a;
        Intrinsics.checkNotNullParameter(r0, "traceId");
        Intrinsics.checkNotNullParameter(r6, "instructionType");
        nz9.b.b = r0;
        nz9.b.c = r6;
        nz9.b.h("creation_page", "creation_page", null, null, 28);
        nz9.b.g("creation_page/first_frame", "creation_page", null, null, true);
        return;
    L16:
        r6 = null;
        goto L17
    L10:
        if ((r3 instanceof ny9.b) == false) goto L16;
        com.larus.bmhome.actionbar.model.r r7 = ((ny9.b) r3).c.q;
        if (r7 == null) goto L16;
        Integer r8 = r7.a;
        if (r8 == null) goto L16;
        r6 = r8.toString();
        goto L17
    }

    public static void f(ny9.b r7, ActivityResultLauncher r8) {
        s0 r0 = a;
        r0.getClass();
        e(r7);
        Bundle r2 = b(r7);
        int r3 = 2130772343;
        if (r7.a == false) goto L30;
        Activity r1 = r7.b;
        Fragment r4 = r7.T;
        Fragment r9 = r7.U;
        if (r8 != null) goto L29;
        Object r10 = null;
        if (r4 == null) goto L9;
        WeakReference<Fragment> r6 = new WeakReference(r4);
    L10:
        b = r6;
        if (r4 != null) goto L14;
        if (r9 == null) goto L14;
        boolean r5 = r9 instanceof xe8.a;
    L14:
        z2.a.w3();
        com.bytedance.router.i r11 = SmartRouter.buildRoute(r1, "//flow/instruction_half_independent_page");
        r11.c.putExtras(r2);
        r11.d = 2130772343;
        r11.e = 2130772399;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L17
        Object r13 = Result.constructor-impl(r11.b());     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r13) == true) goto L23;
        r10 = r13;
    L23:
        Intent r14 = (Intent) r10;
        if (r14 != null) goto L26;
    L28:
        r11.e(100);
        return;
    L26:
        if (g(r14, r1, 2130772343, 2130772399, r9) == false) goto L28;
        return;
    L17:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L9:
        r6 = null;
        goto L10
    L29:
        com.bytedance.router.i r16 = SmartRouter.buildRoute(r1, "//flow/instruction_half_independent_page");
        r16.c.putExtras(r2);
        r16.d = 2130772343;
        r16.e = 2130772399;
        r8.launch(r16.b());
        return;
    L30:
        com.larus.bmhome.actionbar.model.r r17 = r7.c.q;
        boolean r18 = false;
        if (r17 == null) goto L33;
        boolean r19 = Intrinsics.areEqual(r17.j, Boolean.TRUE);
    L34:
        if (r19 == false) goto L48;
        String r20 = r7.h;
        if (r20 != null) goto L38;
    L39:
        r18 = true;
    L40:
        if (r18 == false) goto L48;
        if (r7.i != null) goto L48;
        if (r7.r != null) goto L48;
        if (r7.o != null) goto L48;
        r3 = 2130772400;
        goto L48
    L38:
        if (r20.length() != 0) goto L40;
    L48:
        c(r0, r7.b, r2, r3, r7.U, r8, 8);
        return;
    L33:
        r19 = false;
        goto L34
    }

    public static boolean g(Intent r5, Activity r6, int r7, int r8, Fragment r9) {
        Fragment r2 = null;
        if ((r9 instanceof xe8.a) == false) goto L5;
        xe8.a r1 = (xe8.a) r9;
    L7:
        if (r1 == null) goto L13;
        ChatBubbleParams r3 = r1.Mz();
        if (r3 == null) goto L13;
        boolean r4 = true;
        if (r3.b != true) goto L13;
    L14:
        if (r4 == false) goto L22;
        if (r9 == null) goto L22;
        r2 = r9.getParentFragment();
    L18:
        if (r2 == null) goto L22;
        if ((r2 instanceof xe8.a) == false) goto L22;
        r2 = r2.getParentFragment();
    L22:
        if (r2 != null) goto L34;
        return false;
    L34:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L26
        FLogger.a.i("CreationPageLauncher", "start creation by forseti result owner:" + r2.getClass().getName());     // Catch: Throwable -> L26
        r2.startActivityForResult(r5, 100);     // Catch: Throwable -> L26
        r6.overridePendingTransition(r7, r8);     // Catch: Throwable -> L26
        Object r11 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L26
    L28:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L33;
        FLogger.a.e("CreationPageLauncher", "start creation by forseti result owner failed", r12);
        r11 = Boolean.FALSE;
    L33:
        return ((Boolean) r11).booleanValue();
    L26:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        r4 = false;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public static void c(s0 r3, Activity r4, Bundle r5, int r6, Fragment r7, ActivityResultLauncher r8, int r9) {
        if ((r9 & 4) == 0) goto L6;
        r6 = 2130772343;
    L6:
        if ((r9 & 8) == 0) goto L8;
        int r0 = 2130772399;
    L9:
        Object r2 = null;
        if ((r9 & 16) == 0) goto L13;
        r7 = null;
    L13:
        if ((r9 & 32) == 0) goto L15;
        r8 = null;
    L15:
        r3.getClass();
        if (r8 != null) goto L32;
        com.bytedance.router.i r10 = SmartRouter.buildRoute(r4, "//flow/instruction_independent_page");
        r10.c.putExtras(r5);
        r10.d = r6;
        r10.e = r0;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L20
        Object r12 = Result.constructor-impl(r10.b());     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r12) == true) goto L26;
        r2 = r12;
    L26:
        Intent r13 = (Intent) r2;
        if (r13 != null) goto L29;
    L31:
        r10.e(100);
        return;
    L29:
        if (g(r13, r4, r6, r0, r7) == false) goto L31;
        return;
    L20:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L32:
        com.bytedance.router.i r15 = SmartRouter.buildRoute(r4, "//flow/instruction_independent_page");
        r15.c.putExtras(r5);
        r15.d = r6;
        r15.e = r0;
        r8.launch(r15.b());
        return;
    L8:
        r0 = 0;
        goto L9
    }
}
