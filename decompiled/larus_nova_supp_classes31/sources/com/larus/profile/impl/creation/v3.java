package com.larus.profile.impl.creation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.music.protocol.MusicShareApi;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.utils.IVideoShareService;
import com.larus.bmhome.utils.c4;
import com.larus.community.api.ICommunityService;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.platform.service.AccountService;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.settings.value.e10;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.uaigc.service.IUgcAIGCService$a;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v3 implements zp9.m {
    public final /* synthetic */ ProfileCreationListFragmentV2 a;

    @Override // zp9.m
    public final void d(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    @Override // zp9.m
    public final boolean e() {
        return true;
    }

    @Override // zp9.m
    public final boolean g() {
        return false;
    }

    public v3(ProfileCreationListFragmentV2 r1) {
        this.a = r1;
    }

    @Override // zp9.m
    public final boolean b(UserCreation r45) {
        Intrinsics.checkNotNullParameter(r45, "userCreation");
        ProfileCreationListFragmentV2 r3 = this.a;
        int r4 = ProfileCreationListFragmentV2.r;
        r3.getClass();
        String r15 = "creation_private";
        if (r3.o != 2) goto L5;
        String r6 = "creation_private";
    L6:
        String r7 = r3.ba0();
        UserCreationTrackParams r5 = r45.n;
        if (r5 == null) goto L9;
        Integer r8 = r5.c;
    L10:
        String r9 = String.valueOf(r8);
        int r10 = r45.b;
        switch(r10) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L12;
            case 4: goto L14;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L13;
            case 9: goto L13;
            case 10: goto L13;
            case 11: goto L13;
            case 12: goto L13;
            default: goto L12;
        };
    L12:
        String r11 = "replica";
    L17:
        String r12 = r11;
    L18:
        String r13 = r45.a;
        if (r10 != 2) goto L21;
    L24:
        String r14 = "1";
    L25:
        Integer r16 = r45.d;
        if (r16 != null) goto L29;
    L31:
        String r17 = "1";
    L32:
        tx9.e2.a.b(new tx9.j2(r6, r7, r9, r12, r13, r14, r17, zp9.y.a(r45.b), 1), null, 3);
        ProfileCreationListFragmentV2 r18 = this.a;
        if (r18.da0() == true) goto L108;
        Integer r19 = r45.d;
        if (r19 != null) goto L37;
        int r20 = 2;
    L40:
        if (r45.b == 1) goto L108;
        Context r21 = r18.getContext();
        if (r21 == null) goto L108;
        int r22 = com.larus.profile.impl.info.a.c;
        com.larus.profile.impl.info.a r23 = com.larus.profile.impl.info.a.C0014a.a(r18.getArguments(), r18.getActivity());
        AuthorInfo r110 = r45.g;
        if (r110 == null) goto L50;
        String r111 = r110.b;
        if (r111 == null) goto L50;
        boolean r112 = !Intrinsics.areEqual(r111, AccountService.a.getUserId());
    L51:
        int r113 = r18.o;
        if (r113 != 4) goto L54;
        String r27 = "creation_others";
    L55:
        if (r113 == r20) goto L59;
        if (r113 == 4) goto L58;
        r15 = "bot_list_profile";
        goto L59
    L58:
        r15 = "bot_list_others";
    L59:
        zp9.g r114 = new zp9.g(r15, "personal_homepage_portfolio", null, null, null, null, r27, r18.p, "personal_homepage_portfolio", "personal_homepage_portfolio", null, "creation_others", null, null, null, null, null, null, null, null, null, null, 4191292);
        ICreationWorkflowService.Companion r115 = ICreationWorkflowService.a;
        Bundle r116 = new Bundle();
        r116.putString("creation", GsonProtectorUtils.toJson(new Gson(), r45));
        r116.putString("track_params", GsonProtectorUtils.toJson(new Gson(), r114));
        if (r112 == true) goto L62;
    L64:
        boolean r24 = false;
    L65:
        r116.putBoolean("is_show_profile", r24);
        if (r18.o == r20) goto L68;
        boolean r25 = true;
    L69:
        r116.putBoolean("show_usage_count", r25);
        r116.putBoolean("can_show_inspiration_list", r112);
        r116.putBoolean("open_new_chat_page_on_send", true);
        e10 r26 = e10.a;
        r116.putInt("creation_dosame_landing_type", e10.K());
        r116.putBoolean("is_send_from_detail", true);
        if (r23.a == false) goto L98;
        AuthorInfo r28 = r45.g;
        if (r28 == null) goto L98;
        String r29 = r28.b;
        if (r29 == null) goto L98;
        if (r29.length() <= 0) goto L79;
        boolean r30 = true;
    L80:
        if (r30 == true) goto L83;
        r29 = null;
    L83:
        if (r29 == null) goto L98;
        if (r18.k.length() <= 0) goto L88;
        boolean r31 = true;
    L89:
        if (r31 == false) goto L94;
        if (Intrinsics.areEqual(r29, r18.k) == false) goto L94;
        String r117 = r18.k;
    L99:
        if (r117 == null) goto L101;
        r116.putString("ai_creation_host_source_profile_user_id", r117);
    L101:
        Unit r32 = Unit.INSTANCE;
        boolean r33 = r115.O(r21, r116, !r23.a);
        if (r23.a == false) goto L105;
        if (r33 == true) goto L105;
        boolean r34 = true;
    L106:
        if (r34 == false) goto L109;
        FLogger.a.e("ProfileCreationListFragmentV2", "open AI creation applet detail failed from profile creation list");
    L109:
        if (r33 == false) goto L111;
        return true;
    L111:
        Intrinsics.checkNotNullParameter(r45, "userCreation");
        return false;
    L105:
        r34 = false;
    L94:
        if (r18.o == 4) goto L98;
        if (Intrinsics.areEqual(r29, AccountService.a.getUserId()) == false) goto L98;
        r117 = r29;
        goto L99
    L88:
        r31 = false;
        goto L89
    L79:
        r30 = false;
    L98:
        r117 = null;
        goto L99
    L68:
        r25 = false;
        goto L69
    L62:
        if (r18.o != 4) goto L64;
        r24 = true;
        goto L65
    L54:
        r27 = null;
    L50:
        r112 = false;
        goto L51
    L37:
        r20 = 2;
        if (r19.intValue() != 2) goto L40;
    L108:
        r33 = false;
        goto L109
    L29:
        if (r16.intValue() != 2) goto L31;
        r17 = "0";
        goto L32
    L21:
        if (r10 == 5) goto L24;
        r14 = "0";
        goto L25
    L13:
        r11 = "video";
        goto L17
    L14:
        r11 = "image_edit";
        goto L17
    L15:
        r11 = "picture_created";
        goto L17
    L16:
        r12 = "creation_others";
        goto L18
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = "creation";
        goto L6
    }

    @Override // zp9.m
    public final void c(TabItemInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "tabItemInfo");
    }

    @Override // zp9.m
    public final void i(UserCreation r14) {
        Intrinsics.checkNotNullParameter(r14, "userCreation");
        ProfileCreationListFragmentV2 r0 = this.a;
        int r1 = ProfileCreationListFragmentV2.r;
        r0.getClass();
    L34:
        e = move-exception;
        FLogger.a.i("ProfileCreationListFragmentV2", "[reportItemShow] error:" + e.getMessage());
        return;
    L4:
        if (r0.o != 2) goto L6;
        String r2 = "creation_private";
    L7:
        String r4 = r2;
        String r3 = r0.ba0();     // Catch: Exception -> L34
        UserCreationTrackParams r5 = r14.n;     // Catch: Exception -> L34
        if (r5 == null) goto L10;
        Integer r6 = r5.c;     // Catch: Exception -> L34
    L11:
        String r7 = String.valueOf(r6);     // Catch: Exception -> L34
        int r8 = r14.b;     // Catch: Exception -> L34
        switch(r8) {
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L17;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L14;
            case 9: goto L14;
            case 10: goto L14;
            case 11: goto L14;
            case 12: goto L14;
            default: goto L13;
        };     // Catch: Exception -> L34
    L13:
        String r9 = "music_created";
    L18:
        String r10 = r14.a;     // Catch: Exception -> L34
        String r11 = "1";
        if (r8 != 2) goto L22;
    L25:
        String r12 = "1";
    L26:
        Integer r13 = r14.d;     // Catch: Exception -> L34
        if (r13 != null) goto L30;
    L32:
        tx9.e2.a.b(new tx9.l2(r4, r3, r7, r9, r10, r12, r11, zp9.y.a(r14.b), 1), null, 3);     // Catch: Exception -> L34
        return;
    L30:
        if (r13.intValue() != 2) goto L32;
        r11 = "0";
        goto L32
    L22:
        if (r8 == 5) goto L25;
        r12 = "0";
        goto L26
    L14:
        r9 = "video";
        goto L18
    L15:
        r9 = "image_edit";
        goto L18
    L16:
        r9 = "replica";
        goto L18
    L17:
        r9 = "picture_created";
        goto L18
    L10:
        r6 = null;
        goto L11
    L6:
        r2 = "creation";
        goto L7
    }

    @Override // zp9.m
    public final void f(UserCreationModel r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "userCreationModel");
        n3 r1 = this.a.m;
        if (r1 == null) goto L39;
        Intrinsics.checkNotNullParameter(r11, "userCreationModel");
        List<UserCreation> r13 = r11.b();
        if (r13 == null) goto L40;
        UserCreation r14 = (UserCreation) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L41;
        int r2 = r1.c;
        if (r2 != 2) goto L12;
        String r5 = "creation_private";
    L13:
        String r6 = "creation_others";
        if (r1.b != true) goto L18;
        if (r2 != 2) goto L17;
        String r3 = "creation_private";
    L19:
        String r15 = String.valueOf(r12 + 1);
        int r4 = r14.b;
        if (r4 == 1) goto L30;
        if (r4 != 2) goto L23;
    L28:
        String r7 = "picture_created";
    L29:
        r6 = r7;
        goto L30
    L23:
        if (r4 != 4) goto L25;
        r7 = "image_edit";
        goto L29
    L25:
        if (r4 == 5) goto L28;
        r7 = "replica";
    L30:
        String r8 = r14.a;
        Integer r16 = r14.d;
        if (r16 != null) goto L34;
    L36:
        String r17 = "1";
    L37:
        String r9 = r5;
        String r10 = r3;
        tx9.e2.a.b(new tx9.k2(r9, r10, r15, r6, r8, r17, 1), null, 3);
        return;
    L34:
        if (r16.intValue() != 2) goto L36;
        r17 = "0";
        goto L37
    L17:
        r3 = "creation_list";
        goto L19
    L18:
        r3 = "creation_others";
        goto L19
    L12:
        r5 = "creation";
        goto L13
    L41:
        return;
    L40:
        return;
    }

    @Override // zp9.m
    public final void h(UserCreationModel r91, com.larus.bmhome.view.screenmenu.l0 r92, View r93) {
        UserCreationModel r0 = r91;
        Intrinsics.checkNotNullParameter(r0, "userCreationModel");
        Intrinsics.checkNotNullParameter(r92, "menuItem");
        String r4 = null;
        if ((r0 instanceof UserCreationModel) == true) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L271;
        n3 r5 = this.a.m;
        if (r5 != null) goto L11;
        return;
    L11:
        if ((r93 instanceof bp8.a) == false) goto L13;
        bp8.a r2 = (bp8.a) r93;
    L14:
        monitor-enter(r5);
        Intrinsics.checkNotNullParameter(r92, "menuItem");     // Catch: Throwable -> L268
        Intrinsics.checkNotNullParameter(r0, "userCreationModel");     // Catch: Throwable -> L268
        List<UserCreation> r6 = r0.b();     // Catch: Throwable -> L268
        if (r6 == null) goto L266;
        UserCreation r14 = (UserCreation) CollectionsKt.firstOrNull(r6);     // Catch: Throwable -> L268
        if (r14 == null) goto L266;
        int r1 = r92.a;     // Catch: Throwable -> L268
        if (r1 != 2131901248) goto L252;
        String r15 = r14.a;     // Catch: Throwable -> L268
        String r16 = zp9.d.d(r14);     // Catch: Throwable -> L268
        String r17 = zp9.d.b(r14);     // Catch: Throwable -> L268
        AuthorInfo r3 = r14.g;     // Catch: Throwable -> L268
        if (r3 == null) goto L25;
        String r18 = r3.b;     // Catch: Throwable -> L268
    L26:
        UserCreationTrackParams r7 = r14.n;     // Catch: Throwable -> L268
        if (r7 == null) goto L29;
        Integer r20 = r7.c;     // Catch: Throwable -> L268
    L30:
        if (r7 == null) goto L32;
        Integer r21 = r7.b;     // Catch: Throwable -> L268
    L33:
        if (r7 == null) goto L35;
        String r23 = r7.a;     // Catch: Throwable -> L268
    L36:
        if (r7 == null) goto L38;
        String r28 = r7.g;     // Catch: Throwable -> L268
    L39:
        if (r7 == null) goto L41;
        String r25 = r7.d;     // Catch: Throwable -> L268
    L42:
        if (r7 == null) goto L44;
        String r27 = r7.e;     // Catch: Throwable -> L268
    L45:
        if (r7 == null) goto L47;
        String r26 = r7.f;     // Catch: Throwable -> L268
    L48:
        tx9.u3.e(r15, r16, r17, r18, null, r20, r21, "overview_long_press", r23, "personal_homepage_portfolio", r25, r26, r27, r28, null, null, null, null, null, null, null, null, null, 33538064);     // Catch: Throwable -> L268
        ChatControlTrace r8 = ChatControlTrace.b;     // Catch: Throwable -> L268
        r8.getClass();     // Catch: Throwable -> L268
        String r19 = r8.bb(ChatControlTrace.y);     // Catch: Throwable -> L268
        String r22 = r8.h(ChatControlTrace.y);     // Catch: Throwable -> L268
        if (r5.b == false) goto L51;
        String r9 = "creation_list";
    L52:
        String r110 = r9;
        int r10 = r14.b;     // Catch: Throwable -> L268
        if (r10 != 3) goto L55;
        boolean r29 = true;
    L56:
        String r11 = r14.a;     // Catch: Throwable -> L268
        String r210 = zp9.d.d(r14);     // Catch: Throwable -> L268
        String r211 = zp9.d.b(r14);     // Catch: Throwable -> L268
        Long r12 = r14.f;     // Catch: Throwable -> L268
        if (r12 == null) goto L59;
        Integer r39 = Integer.valueOf((int) r12.longValue());     // Catch: Throwable -> L268
    L60:
        AuthorInfo r13 = r14.g;     // Catch: Throwable -> L268
        if (r13 == null) goto L63;
        String r40 = r13.b;     // Catch: Throwable -> L268
    L64:
        com.larus.bmhome.share.panel.h r111 = new com.larus.bmhome.share.panel.h(null, null, r19, r110, r22, null, null, null, null, r29, Integer.valueOf(r10), r11, r210, r211, null, null, null, null, Boolean.FALSE, null, null, null, null, r39, r40, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r14.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -235993145, -4097, 1023);     // Catch: Throwable -> L268
        switch(r14.b) {
            case 1: goto L238;
            case 2: goto L78;
            case 3: goto L78;
            case 4: goto L78;
            case 5: goto L78;
            case 6: goto L67;
            case 7: goto L67;
            case 8: goto L67;
            case 9: goto L67;
            case 10: goto L67;
            case 11: goto L67;
            case 12: goto L67;
            default: goto L264;
        };     // Catch: Throwable -> L268
    L67:
        IVideoShareService r41 = (IVideoShareService) ServiceManager.get().getService(IVideoShareService.class);     // Catch: Throwable -> L268
        if (r41 == null) goto L264;
        ViewGroup r24 = r5.f;     // Catch: Throwable -> L268
        CoroutineScope r30 = r5.d;     // Catch: Throwable -> L268
        nr9.g r45 = i2.b(r14, r5.b);     // Catch: Throwable -> L268
        CreationDynamicInfo r31 = r14.h;     // Catch: Throwable -> L268
        if (r31 == null) goto L73;
        String r32 = r31.d;     // Catch: Throwable -> L268
        if (r32 == null) goto L73;
    L74:
        String r46 = r32;
        ShareScene r47 = ShareScene.VIDEO_VIEWER;     // Catch: Throwable -> L268
        c4 r49 = new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);     // Catch: Throwable -> L268
        String r33 = r14.a;     // Catch: Throwable -> L268
        if (r33 != null) goto L77;
        r33 = "";
    L77:
        IVideoShareService.a.b(r41, r24, r30, null, r45, r46, r47, r111, r49, r33, IUgcAIGCService.a.B(r14, null), null, 2304);     // Catch: Throwable -> L268
        Unit r34 = Unit.INSTANCE;     // Catch: Throwable -> L268
    L73:
        r32 = "";
        goto L74
    L78:
        ShareServiceDelegate r35 = ShareServiceDelegate.b;     // Catch: Throwable -> L268
        JSONObject r36 = new JSONObject();     // Catch: Throwable -> L268
        r36.put("enter_picture_method", "click_creation_list");     // Catch: Throwable -> L268
        if (r14.b != 3) goto L81;
        int r37 = 1;
    L82:
        r36.put("is_replica_gen", r37);     // Catch: Throwable -> L268
        if (r14.b != 4) goto L85;
        int r38 = 1;
    L86:
        r36.put("is_image_edit", r38);     // Catch: Throwable -> L268
        r35.w(r36);     // Catch: Throwable -> L268
        if (r5.a == null) goto L264;
        ImageInfo r42 = i2.a(r14, r5.b);     // Catch: Throwable -> L268
        com.larus.platform.service.z2 r43 = com.larus.platform.service.z2.a;     // Catch: Throwable -> L268
        hq9.v1 r44 = r43.getCreationShareSettings().a();     // Catch: Throwable -> L268
        if (r44 != null) goto L91;
    L93:
        boolean r48 = false;
    L94:
        if (r48 == false) goto L203;
        hq9.v1 r50 = r43.getCreationShareSettings().a();     // Catch: Throwable -> L268
        if (r50 != null) goto L98;
    L100:
        boolean r51 = false;
    L102:
        if (r51 == false) goto L104;
        boolean r52 = CollectionsKt.listOf(new Integer[]{2, 5, 4}).contains(Integer.valueOf(r14.b));     // Catch: Throwable -> L268
    L105:
        if (r52 == false) goto L203;
        FragmentActivity r53 = r5.a;     // Catch: Throwable -> L268
        if ((r53 instanceof FragmentActivity) == false) goto L109;
        FragmentActivity r54 = r53;     // Catch: Throwable -> L268
    L110:
        if (r54 == null) goto L264;
        FragmentManager r55 = r54.getSupportFragmentManager();     // Catch: Throwable -> L268
        if (r55 == null) goto L264;
        ICommunityService.Companion r56 = ICommunityService.a;     // Catch: Throwable -> L268
        if (r42 == null) goto L118;
        Image r57 = r42.c;     // Catch: Throwable -> L268
        if (r57 == null) goto L118;
        String r58 = r57.a;     // Catch: Throwable -> L268
    L119:
        String r410 = String.valueOf(r58);     // Catch: Throwable -> L268
        if (r42 == null) goto L124;
        Image r59 = r42.a;     // Catch: Throwable -> L268
        if (r59 == null) goto L124;
        String r60 = r59.a;     // Catch: Throwable -> L268
    L125:
        String r411 = String.valueOf(r60);     // Catch: Throwable -> L268
        if (r42 == null) goto L130;
        Image r61 = r42.i;     // Catch: Throwable -> L268
        if (r61 == null) goto L130;
        String r412 = r61.a;     // Catch: Throwable -> L268
    L131:
        AuthorInfo r62 = r14.g;     // Catch: Throwable -> L268
        if (r62 == null) goto L134;
        String r63 = r62.b;     // Catch: Throwable -> L268
    L136:
        if (Intrinsics.areEqual(r63, AccountService.a.getUserId()) == false) goto L152;
        UserCreationRefContent r64 = r14.o;     // Catch: Throwable -> L268
        if (r64 == null) goto L140;
        boolean r65 = Intrinsics.areEqual(r64.b, Boolean.TRUE);     // Catch: Throwable -> L268
    L141:
        if (r65 == true) goto L152;
        UserCreationRefContent r66 = r14.o;     // Catch: Throwable -> L268
        if (r66 == null) goto L152;
        List<ImageInfo> r67 = r66.a();     // Catch: Throwable -> L268
        if (r67 == null) goto L152;
        ImageInfo r68 = (ImageInfo) CollectionsKt.getOrNull(r67, 0);     // Catch: Throwable -> L268
        if (r68 == null) goto L152;
        Image r69 = r68.c;     // Catch: Throwable -> L268
        if (r69 == null) goto L152;
        String r413 = r69.a;     // Catch: Throwable -> L268
    L153:
        ShareScene r414 = ShareScene.IMAGE_VIEWER_REPORT;     // Catch: Throwable -> L268
        if (r42 == null) goto L158;
        Image r70 = r42.a;     // Catch: Throwable -> L268
        if (r70 == null) goto L158;
        long r71 = r70.c;     // Catch: Throwable -> L268
    L162:
        long r510 = r71;
    L164:
        if (r42 == null) goto L168;
        Image r72 = r42.a;     // Catch: Throwable -> L268
        if (r72 == null) goto L168;
        long r73 = r72.d;     // Catch: Throwable -> L268
    L172:
        long r511 = r73;
    L174:
        sq9.i r74 = new sq9.i("share", null, r14.a, 2);     // Catch: Throwable -> L268
        Map r512 = IUgcAIGCService.a.H(r14, null);     // Catch: Throwable -> L268
        if (r42 == null) goto L180;
        Image r75 = r42.a;     // Catch: Throwable -> L268
        if (r75 == null) goto L180;
        String r76 = r75.e;     // Catch: Throwable -> L268
        if (r76 == null) goto L180;
    L201:
        String r610 = r76;
    L202:
        r56.Z0(r55, new sq9.j(null, r410, r411, r412, r413, null, r111, r414, r510, r511, r74, r512, 0, null, null, null, r610, 61473));     // Catch: Throwable -> L268
        Unit r77 = Unit.INSTANCE;     // Catch: Throwable -> L268
    L180:
        if (r42 == null) goto L184;
        Image r78 = r42.c;     // Catch: Throwable -> L268
        if (r78 == null) goto L184;
        r76 = r78.e;     // Catch: Throwable -> L268
    L185:
        if (r76 != null) goto L201;
        if (r42 == null) goto L190;
        Image r79 = r42.b;     // Catch: Throwable -> L268
        if (r79 == null) goto L190;
        r76 = r79.e;     // Catch: Throwable -> L268
    L191:
        if (r76 != null) goto L201;
        if (r42 == null) goto L196;
        Image r80 = r42.i;     // Catch: Throwable -> L268
        if (r80 == null) goto L196;
        r76 = r80.e;     // Catch: Throwable -> L268
    L197:
        if (r76 != null) goto L201;
        if (r42 == null) goto L200;
        r4 = r42.e;     // Catch: Throwable -> L268
    L200:
        r610 = r4;
    L196:
        r76 = null;
    L190:
        r76 = null;
    L184:
        r76 = null;
    L168:
        if (r42 == null) goto L173;
        Image r81 = r42.c;     // Catch: Throwable -> L268
        if (r81 == null) goto L173;
        r73 = r81.d;     // Catch: Throwable -> L268
    L173:
        r511 = -1;
    L158:
        if (r42 == null) goto L163;
        Image r82 = r42.c;     // Catch: Throwable -> L268
        if (r82 == null) goto L163;
        r71 = r82.c;     // Catch: Throwable -> L268
    L163:
        r510 = -1;
        goto L164
    L140:
        r65 = false;
    L152:
        r413 = null;
        goto L153
    L134:
        r63 = null;
    L130:
        r412 = null;
    L124:
        r60 = null;
    L118:
        r58 = null;
        goto L119
    L109:
        r54 = null;
        goto L110
    L104:
        r52 = CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{5, 4}), Integer.valueOf(r14.b));     // Catch: Throwable -> L268
        goto L105
    L98:
        if (r50.f() != true) goto L100;
        r51 = true;
    L203:
        IUgcAIGCService.Companion r83 = IUgcAIGCService.a;     // Catch: Throwable -> L268
        Context r84 = r5.a;     // Catch: Throwable -> L268
        boolean r85 = r5.b;     // Catch: Throwable -> L268
        Intrinsics.checkNotNullParameter(r14, "<this>");     // Catch: Throwable -> L268
        ImageInfo r86 = i2.a(r14, r85);     // Catch: Throwable -> L268
        if (r86 == null) goto L206;
        Image r87 = r86.a;     // Catch: Throwable -> L268
    L207:
        String r88 = i2.d(r87);     // Catch: Throwable -> L268
        if (r88 != null) goto L210;
        r88 = r14.h();     // Catch: Throwable -> L268
    L210:
        String r89 = r88;
        ShareScene r112 = ShareScene.IMAGE_VIEWER_REPORT;     // Catch: Throwable -> L268
        hs9.b r113 = new hs9.b(String.valueOf(r14.a));     // Catch: Throwable -> L268
        if (r42 == null) goto L216;
        Image r90 = r42.a;     // Catch: Throwable -> L268
        if (r90 == null) goto L216;
        String r94 = r90.e;     // Catch: Throwable -> L268
        if (r94 == null) goto L216;
    L236:
        r4 = r94;
    L237:
        IUgcAIGCService$a.d(r83, r84, r89, r112, r113, r111, null, r14, r4, 352);     // Catch: Throwable -> L268
        Unit r95 = Unit.INSTANCE;     // Catch: Throwable -> L268
    L216:
        if (r42 == null) goto L220;
        Image r96 = r42.c;     // Catch: Throwable -> L268
        if (r96 == null) goto L220;
        r94 = r96.e;     // Catch: Throwable -> L268
    L221:
        if (r94 != null) goto L236;
        if (r42 == null) goto L226;
        Image r97 = r42.b;     // Catch: Throwable -> L268
        if (r97 == null) goto L226;
        r94 = r97.e;     // Catch: Throwable -> L268
    L227:
        if (r94 != null) goto L236;
        if (r42 == null) goto L232;
        Image r98 = r42.i;     // Catch: Throwable -> L268
        if (r98 == null) goto L232;
        r94 = r98.e;     // Catch: Throwable -> L268
    L233:
        if (r94 != null) goto L236;
        if (r42 == null) goto L237;
        r4 = r42.e;     // Catch: Throwable -> L268
    L232:
        r94 = null;
    L226:
        r94 = null;
    L220:
        r94 = null;
        goto L221
    L206:
        r87 = null;
        goto L207
    L91:
        if (r44.e() != true) goto L93;
        r48 = true;
        goto L94
    L85:
        r38 = 0;
        goto L86
    L81:
        r37 = 0;
        goto L82
    L238:
        UserCreationContent r99 = r14.e;     // Catch: Throwable -> L268
        if (r99 == null) goto L241;
        UserCreationMusic r100 = r99.b;     // Catch: Throwable -> L268
    L242:
        if (r100 == null) goto L264;
        MusicShareApi r101 = MusicShareApi.a;     // Catch: Throwable -> L268
        ViewGroup r102 = r5.f;     // Catch: Throwable -> L268
        CoroutineScope r103 = r5.d;     // Catch: Throwable -> L268
        if (r5.b != true) goto L246;
        String r104 = "creation_list";
    L247:
        String r415 = r104;
        com.larus.bmhome.music.protocol.f r416 = com.larus.bmhome.music.protocol.h.a(r100, r14.a);     // Catch: Throwable -> L268
        ShareScene r417 = ShareScene.MUSIC_VIDEO_REPORT;     // Catch: Throwable -> L268
        UserCreationTrackParams r105 = r14.n;     // Catch: Throwable -> L268
        if (r105 == null) goto L250;
        r4 = r105.g;     // Catch: Throwable -> L268
    L250:
        MusicShareApi.d(r102, r103, null, r415, "click_creation_list", "", null, r416, r417, r111, r4, null, 5120);     // Catch: Throwable -> L268
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L268
        goto L264
    L246:
        r104 = "creation_others";
        goto L247
    L241:
        r100 = null;
    L264:
        monitor-exit(r5);
        return;
    L63:
        r40 = null;
        goto L64
    L59:
        r39 = null;
        goto L60
    L55:
        r29 = false;
        goto L56
    L51:
        r9 = "creation_others";
        goto L52
    L47:
        r26 = null;
        goto L48
    L44:
        r27 = null;
        goto L45
    L41:
        r25 = null;
        goto L42
    L38:
        r28 = null;
        goto L39
    L35:
        r23 = null;
        goto L36
    L32:
        r21 = null;
        goto L33
    L29:
        r20 = null;
        goto L30
    L25:
        r18 = null;
        goto L26
    L252:
        if (r1 != 2131900629) goto L255;
        r5.e.b(r14);     // Catch: Throwable -> L268
        goto L264
    L255:
        if (r1 != 2131899197) goto L258;
        r5.e.b(r14);     // Catch: Throwable -> L268
        goto L264
    L258:
        if (r1 != 2131900631) goto L264;
        if (r14.b != 1) goto L263;
        if (r2 == null) goto L263;
        r2.a();     // Catch: Throwable -> L268
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L268
    L263:
        r5.e.a(r0);     // Catch: Throwable -> L268
    L266:
        monitor-exit(r5);
        return;
    L268:
        th = move-exception;
        throw th;
    L13:
        r2 = null;
        goto L14
    }

    @Override // zp9.m
    public final boolean a(UserCreation r1, int r2, String r3, String r4, @DoSameQuickMenuType String r5) {
        Intrinsics.checkNotNullParameter(r1, "userCreation");
        return false;
    }
}
