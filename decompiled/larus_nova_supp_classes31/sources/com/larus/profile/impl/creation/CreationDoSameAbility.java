package com.larus.profile.impl.creation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.facebook.common.references.CloseableReference;
import com.google.gson.Gson;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.CreationPublishExtra;
import com.larus.platform.api.creation.CustomInputInitData;
import com.larus.platform.api.creation.Resource;
import com.larus.platform.api.creation.TplButtonType;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.platform.kmp.chat.TemplateInfo$DefaultTab;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.platform.service.AccountService;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.createpage.component.sendmessage.CreationSendUiEvent;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationDoSameAbility implements sq9.t {
    public static final /* synthetic */ int f = 0;
    public final Fragment a;
    public final AiBeautifyPickPhotoHelper b;
    public sq9.p c;
    public final Lazy d;
    public final Lazy e;

    public static final class a {
    }

    public static final class b implements zs8.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ sq9.p b;
        public final /* synthetic */ UserCreation c;

        public final String a() {
            return null;
        }

        public final String c() {
            return null;
        }

        public final String getBotId() {
            return null;
        }

        public final String getChatType() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String Y1() {
            return this.b.i;
        }

        public final String d() {
            return zp9.d.c(this.c);
        }

        public final String e() {
            sq9.d0 r0 = this.b.s;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.a;
        }

        public final String f() {
            UserCreationTrackParams r0 = this.c.n;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.d;
        }

        public final String g() {
            sq9.d0 r0 = this.b.s;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.d;
        }

        public final String getClickFrom() {
            String r0 = this.b.c;
            if (r0 != null) goto L6;
            return "use_template";
        L6:
            return r0;
        }

        public final String getEnterMethod() {
            String r0 = this.b.c;
            if (r0 != null) goto L6;
            return "use_template";
        L6:
            return r0;
        }

        public final String getTemplateType() {
            return zp9.d.d(this.c);
        }

        public final String h() {
            return this.b.g;
        }

        public final String j() {
            UserCreationTrackParams r0 = this.c.n;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.f;
        }

        public final String k() {
            sq9.d0 r0 = this.b.s;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.c;
        }

        public final String n() {
            sq9.d0 r0 = this.b.s;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.b;
        }

        public final String p() {
            UserCreationTrackParams r0 = this.c.n;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.e;
        }

        public final String b() {
            return this.a;
        }

        public b(String r1, sq9.p r2, UserCreation r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements zs8.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ sq9.p b;
        public final /* synthetic */ UserCreation c;

        public final String a() {
            return null;
        }

        public final String c() {
            return null;
        }

        public final String getBotId() {
            return null;
        }

        public final String getChatType() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String Y1() {
            return this.b.i;
        }

        public final String d() {
            return zp9.d.c(this.c);
        }

        public final String e() {
            sq9.d0 r0 = this.b.s;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.a;
        }

        public final String f() {
            UserCreationTrackParams r0 = this.c.n;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.d;
        }

        public final String g() {
            sq9.d0 r0 = this.b.s;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.d;
        }

        public final String getClickFrom() {
            String r0 = this.b.c;
            if (r0 != null) goto L6;
            return "use_template";
        L6:
            return r0;
        }

        public final String getEnterMethod() {
            String r0 = this.b.c;
            if (r0 != null) goto L6;
            return "use_template";
        L6:
            return r0;
        }

        public final String getTemplateType() {
            return zp9.d.d(this.c);
        }

        public final String h() {
            return this.b.g;
        }

        public final String j() {
            UserCreationTrackParams r0 = this.c.n;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.f;
        }

        public final String k() {
            sq9.d0 r0 = this.b.s;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.c;
        }

        public final String n() {
            sq9.d0 r0 = this.b.s;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.b;
        }

        public final String p() {
            UserCreationTrackParams r0 = this.c.n;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.e;
        }

        public final String b() {
            return this.a;
        }

        public c(String r1, sq9.p r2, UserCreation r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public static boolean r() {
        ICreationPageService.a.getClass();
        return ICreationPageService.a.a();
    }

    public final void A() {
        AiBeautifyPickPhotoHelper r1 = this.b;
        if (r1 == null) goto L5;
        com.larus.bmhome.instruction.helper.f.a.a(r1, null, 7);
    L5:
        tx9.c0.H(null, "use_template", "use_template", null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33554425);
    }

    @Override // sq9.t
    public final void onDestroy() {
        AiBeautifyPickPhotoHelper r0 = this.b;
        if (r0 == null) goto L6;
        r0.onDestroy();
        return;
    }

    public final boolean s() {
        int r0 = cy9.f.d;
        cy9.f r1 = cy9.f.a.a(this.a.getArguments());
        if (r1.a == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r1.b, "/creation/detail") == false) goto L7;
        return true;
    }

    public static boolean D(sq9.p r5) {
        if (r5.k == true) goto L5;
        return false;
    L5:
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{1, 2}), r5.x) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean g(CreationDoSameAbility r2) {
        FragmentActivity r0 = r2.a.getActivity();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r2.a.isAdded() == true) goto L8;
        return false;
    L8:
        if (r0.isFinishing() == false) goto L10;
        return false;
    L10:
        if (r0.isDestroyed() == true) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean t(com.larus.bmhome.actionbar.model.z0 r1) {
        com.larus.bmhome.actionbar.model.r r2 = r1.q;
        if (r2 == null) goto L10;
        Integer r3 = r2.a;
        if (r3 == null) goto L10;
        if (r3.intValue() != 28) goto L10;
        return true;
    L10:
        return false;
    }

    public CreationDoSameAbility(Fragment r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        if (r3 == false) goto L5;
        AiBeautifyPickPhotoHelper r4 = null;
    L6:
        this.b = r4;
        this.d = LazyKt.lazy(new com.larus.profile.impl.creation.c());
        this.e = LazyKt.lazy(new d());
        return;
    L5:
        AiBeautifyPickPhotoHelper r5 = new AiBeautifyPickPhotoHelper(r2);
        r5.b = new com.larus.profile.impl.creation.b(this);
        r4 = r5;
        goto L6
    }

    public static final CreationSendUiEvent d(CreationDoSameAbility r19, CreationSendMessageConfig r20) {
        r19.getClass();
        String r1 = r20.getCvsId();
        boolean r14 = r20.getClearInputContent();
        if (r20.getAttachmentInfo() == null) goto L5;
    L8:
        boolean r15 = true;
    L10:
        return new CreationSendUiEvent(r1, null, false, false, true, true, true, true, false, true, true, true, true, r14, r15, 270, null);
    L5:
        if (r20.getImageEditDataWithMask() != null) goto L8;
        r15 = false;
        goto L10
    }

    public static String j(UserCreation r2, sq9.p r3) {
        if (r3 == null) goto L5;
        String r4 = r3.l;
    L7:
        if (Intrinsics.areEqual(r4, DoSameQuickMenuType.REPLACE_PIC) == false) goto L12;
        TplDetail r5 = is9.a.c(r2);
        if (r5 != null) goto L28;
        return null;
    L28:
        return r5.i;
    L12:
        if (Intrinsics.areEqual(r4, DoSameQuickMenuType.USE_PICTURE) == false) goto L15;
        return null;
    L15:
        if (3 != r2.b) goto L21;
        UserCreationContent r6 = r2.e;
        if (r6 == null) goto L29;
        UserCreationUserAvatar r7 = r6.c;
        if (r7 != null) goto L31;
        return null;
    L31:
        return r7.c;
    L29:
        return null;
    L21:
        UserCreationContent r8 = r2.e;
        if (r8 == null) goto L32;
        UserCreationImage r9 = r8.a;
        if (r9 != null) goto L26;
        return null;
    L26:
        return r9.c;
    L32:
        return null;
    L5:
        r4 = null;
        goto L7
    }

    public static String k(UserCreation r2, sq9.p r3) {
        if (Intrinsics.areEqual(r3.l, DoSameQuickMenuType.REPLACE_PIC) == false) goto L5;
    L28:
        String r4 = r2.e();
    L29:
        if (r4 != null) goto L32;
        return "";
    L32:
        return r4;
    L5:
        if (Intrinsics.areEqual(r3.l, DoSameQuickMenuType.USE_PICTURE) == true) goto L28;
        if (v(r2, r3) == false) goto L18;
        UserCreationRefContent r5 = r2.o;
        if (r5 == null) goto L27;
        List<ImageInfo> r6 = r5.a();
        if (r6 == null) goto L27;
        ImageInfo r7 = (ImageInfo) CollectionsKt.getOrNull(r6, 0);
        if (r7 == null) goto L27;
        Image r8 = r7.h;
        if (r8 == null) goto L27;
        r4 = r8.a;
    L27:
        r4 = null;
        goto L29
    L18:
        UserCreationRefContent r9 = r2.o;
        if (r9 == null) goto L27;
        List<ImageInfo> r10 = r9.a();
        if (r10 == null) goto L27;
        ImageInfo r11 = (ImageInfo) CollectionsKt.getOrNull(r10, 0);
        if (r11 == null) goto L27;
        Image r12 = r11.c;
        if (r12 == null) goto L27;
        r4 = r12.a;
        goto L29
    }

    public static List l(UserCreation r4, sq9.p r5) {
        ArrayList r0 = new ArrayList();
        List<ResourceExt> r2 = null;
        if (Intrinsics.areEqual(r5.l, DoSameQuickMenuType.REPLACE_PIC) == false) goto L5;
    L23:
        r0.add(new ResourceExt(null, r4.e(), 1));
    L24:
        return r0;
    L5:
        if (Intrinsics.areEqual(r5.l, DoSameQuickMenuType.USE_PICTURE) == true) goto L23;
        if (v(r4, r5) == false) goto L16;
        UserCreationRefContent r6 = r4.o;
        if (r6 == null) goto L14;
        List<Resource> r7 = r6.c;
        if (r7 == null) goto L14;
        r2 = sq9.g.b(r7);
    L14:
        if (r2 == null) goto L24;
        r0.addAll(r2);
        goto L24
    L16:
        UserCreationRefContent r8 = r4.o;
        if (r8 == null) goto L21;
        List<Resource> r9 = r8.c;
        if (r9 == null) goto L21;
        r2 = sq9.g.a(r9);
    L21:
        if (r2 == null) goto L24;
        r0.addAll(r2);
        goto L24
    }

    public static Integer m(UserCreation r2, sq9.p r3) {
        if (Intrinsics.areEqual(r3.l, DoSameQuickMenuType.REPLACE_PIC) == false) goto L9;
        TplDetail r4 = is9.a.c(r2);
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4.k;
    L9:
        return r3.u;
    }

    public static Integer n(UserCreation r2, sq9.p r3) {
        if (Intrinsics.areEqual(r3.l, DoSameQuickMenuType.REPLACE_PIC) == false) goto L9;
        TplDetail r4 = is9.a.c(r2);
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4.j;
    L9:
        return r3.t;
    }

    public static ICoreInputAbility.SendMessageTrackExtMap o(sq9.p r5, UserCreation r6) {
        Pair[] r1 = new Pair[25];
        r1[0] = TuplesKt.to("from_template_id", r6.a);
        r1[1] = TuplesKt.to("from_template_type", zp9.d.d(r6));
        UserCreationTrackParams r2 = r6.n;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.a;
    L6:
        r1[2] = TuplesKt.to("template_rec_req_id", r4);
        r1[3] = TuplesKt.to("from_template_source", zp9.d.b(r6));
        r1[4] = TuplesKt.to("recommend_from", r5.e);
        UserCreationTrackParams r7 = r6.n;
        if (r7 == null) goto L9;
        String r8 = r7.d;
    L10:
        r1[5] = TuplesKt.to("ai_generate_tab_id", r8);
        UserCreationTrackParams r9 = r6.n;
        if (r9 == null) goto L13;
        String r10 = r9.e;
    L14:
        r1[6] = TuplesKt.to("ai_generate_tab_name", r10);
        UserCreationTrackParams r11 = r6.n;
        if (r11 == null) goto L17;
        String r12 = r11.f;
    L18:
        r1[7] = TuplesKt.to("ai_generate_tab_type", r12);
        r1[8] = TuplesKt.to("ai_creation_recommend_from", r5.g);
        r1[9] = TuplesKt.to("enter_method", r5.c);
        r1[10] = TuplesKt.to("is_from_template", "1");
        r1[11] = TuplesKt.to("template_rec_extra", r6.i);
        r1[12] = TuplesKt.to("from_template_sub_type", zp9.d.c(r6));
        r1[13] = TuplesKt.to("is_has_caption", String.valueOf(r6.z()));
        r1[14] = TuplesKt.to("is_image_reference_public", String.valueOf(r6.D()));
        UserCreationRefContent r13 = r6.o;
        if (r13 == null) goto L23;
        List<ImageInfo> r14 = r13.a();
        if (r14 == null) goto L23;
        String r15 = Integer.valueOf(r14.size()).toString();
    L24:
        r1[15] = TuplesKt.to("image_reference_cnt", r15);
        sq9.d0 r16 = r5.s;
        if (r16 == null) goto L27;
        String r17 = r16.a;
    L28:
        r1[16] = TuplesKt.to("prompt_type", r17);
        sq9.d0 r18 = r5.s;
        if (r18 == null) goto L31;
        String r19 = r18.b;
    L32:
        r1[17] = TuplesKt.to("prompt_from", r19);
        sq9.d0 r20 = r5.s;
        if (r20 == null) goto L35;
        String r21 = r20.c;
    L36:
        r1[18] = TuplesKt.to("visual_size", r21);
        sq9.d0 r22 = r5.s;
        if (r22 == null) goto L39;
        String r23 = r22.d;
    L40:
        r1[19] = TuplesKt.to("tag_code", r23);
        sq9.d0 r24 = r5.s;
        if (r24 == null) goto L43;
        String r25 = r24.e;
    L44:
        r1[20] = TuplesKt.to("item_id", r25);
        sq9.d0 r26 = r5.s;
        if (r26 == null) goto L47;
        String r27 = r26.e;
    L48:
        r1[21] = TuplesKt.to("onboarding_item_id", r27);
        sq9.d0 r28 = r5.s;
        if (r28 == null) goto L51;
        r3 = r28.f;
    L51:
        r1[22] = TuplesKt.to("reco_request_id", r3);
        r1[23] = TuplesKt.to("anchor_creation_id", r5.v);
        r1[24] = TuplesKt.to("douyin_gid", r5.w);
        return new ICoreInputAbility.SendMessageTrackExtMap(MapsKt.mapOf(r1));
    L47:
        r27 = null;
        goto L48
    L43:
        r25 = null;
        goto L44
    L39:
        r23 = null;
        goto L40
    L35:
        r21 = null;
        goto L36
    L31:
        r19 = null;
        goto L32
    L27:
        r17 = null;
    L23:
        r15 = null;
        goto L24
    L17:
        r12 = null;
        goto L18
    L13:
        r10 = null;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public static boolean v(UserCreation r3, sq9.p r4) {
        List r0 = CollectionsKt.listOf(new String[]{DoSameQuickMenuType.REPLACE_PIC, DoSameQuickMenuType.USE_PICTURE});
        String r1 = null;
        if (r4 == null) goto L5;
        String r5 = r4.l;
    L7:
        if (CollectionsKt.contains(r0, r5) == true) goto L20;
        CreationPublishExtra r6 = r3.p;
        if (r6 == null) goto L11;
        boolean r7 = Intrinsics.areEqual(r6.b, Boolean.FALSE);
    L12:
        if (r7 == false) goto L21;
        AuthorInfo r8 = r3.g;
        if (r8 == null) goto L17;
        r1 = r8.b;
    L17:
        if (Intrinsics.areEqual(r1, AccountService.a.getUserId()) == true) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L11:
        r7 = false;
        goto L12
    L20:
        return false;
    L5:
        r5 = null;
        goto L7
    }

    public final void E(Bundle r5, sq9.p r6) {
        if (Intrinsics.areEqual(r6.y, Boolean.TRUE) == true) goto L5;
        return;
    L5:
        if (s() == false) goto L11;
        int r0 = cy9.f.d;
        cy9.f r1 = cy9.f.a.a(this.a.getArguments());
        r5.putBoolean("from_ai_creation_applet", true);
        r5.putString("ai_creation_applet_path", "/creation/detail");
        r5.putBoolean("ai_creation_applet_is_root_page", r1.c);
        if (D(r6) == false) goto L12;
        r5.putBoolean("route_result_to_chat_after_ai_creation_applet", true);
        return;
    L12:
        return;
    }

    @Override // sq9.t
    public final void a(sq9.p r72, String r73) {
        Intrinsics.checkNotNullParameter(r72, "doSameInitParams");
        Boolean r1 = r72.y;
        Boolean r10 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r10) == false) goto L5;
    L8:
        sq9.p r12 = r72;
    L9:
        UserCreation r13 = r12.d;
        if (r13 == null) goto L425;
        this.c = r12;
        String r0 = r12.f;
        if (r0 != null) goto L14;
    L18:
        r0 = r73;
    L19:
        String r15 = r12.b;
        String r9 = r12.h;
        String r8 = r12.i;
        if (Intrinsics.areEqual(r12.l, DoSameQuickMenuType.REPLACE_PIC) == false) goto L22;
    L35:
        String r6 = null;
    L36:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new CreationDoSameAbility$jumpChatPageByMakeSame$1(r13, null), 3, null);
        AuthModelDelegate r2 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r4 = (com.larus.bmhome.chat.api.e0) r2.e().getValue();
        if (r4 == null) goto L42;
        LaunchInfo r5 = r4.a;
        if (r5 == null) goto L42;
        String r7 = r5.W();
        if (r7 == null) goto L42;
    L43:
        String r16 = r7;
        Pair[] r11 = new Pair[6];
        if (r9 != null) goto L46;
        String r14 = r16;
    L47:
        r11[0] = TuplesKt.to("argBotId", r14);
        r11[1] = TuplesKt.to("argBotType", 1);
        r11[2] = TuplesKt.to("actionbar_creation_id", r13.a);
        r11[3] = TuplesKt.to("argPreviousPage", r15);
        r11[4] = TuplesKt.to("actionbar_instruction_default_params", r6);
        r11[5] = TuplesKt.to("key_is_chat_double_page", r12.j);
        Bundle r17 = com.larus.utils.f.c(r11);
        TplDetail r18 = is9.a.c(r13);
        String r19 = "CreationDoSameAbility";
        String r25 = "";
        if (Intrinsics.areEqual(r12.l, DoSameQuickMenuType.REPLACE_PIC) == false) goto L65;
        if (r18 == null) goto L56;
        Integer r110 = r18.d;
        if (r110 == null) goto L56;
        String r27 = r6;
        int r20 = 1;
        if (r110.intValue() != 1) goto L57;
        boolean r111 = true;
    L58:
        if (r111 == false) goto L66;
        Integer r112 = r18.a;
        if (r112 == null) goto L66;
        if (r112.intValue() != r20) goto L66;
    L76:
        if (r0 != null) goto L78;
    L81:
        boolean r21 = true;
    L82:
        if (r21 == false) goto L84;
        A();
        String r22 = r8;
        Object r65 = TplType.AI_REPLICA;
        Object r113 = "actionbar_instruction_default_params";
        Bundle r23 = r17;
        String r26 = r9;
        String r24 = r27;
    L156:
        Object r114 = r113;
        Bundle r115 = r23;
        String r116 = r24;
    L175:
        boolean r3 = true;
    L178:
        if (r3 == true) goto L425;
        CreationDynamicInfo r28 = r13.h;
        if (r28 == null) goto L185;
        TplInfo r29 = r28.e;
        if (r29 == null) goto L185;
        String r30 = r29.a;
    L187:
        if (Intrinsics.areEqual(r30, r65) == false) goto L190;
        w(r12, r115, r13, r116);
        goto L425
    L190:
        switch(r13.b) {
            case 1: goto L384;
            case 2: goto L379;
            case 3: goto L378;
            case 4: goto L337;
            case 5: goto L320;
            case 6: goto L315;
            case 7: goto L298;
            case 8: goto L315;
            case 9: goto L298;
            case 10: goto L196;
            case 11: goto L298;
            case 12: goto L192;
            default: goto L425;
        };
    L192:
        if (r26 != null) goto L194;
        String r31 = r16;
    L195:
        y(r12, r13, r31, r15, r116, r115, r22, null);
        goto L425
    L194:
        r31 = r26;
        goto L195
    L196:
        if (r26 != null) goto L198;
        String r32 = r16;
    L199:
        IUgcAIGCService.Companion r33 = IUgcAIGCService.a;
        boolean r117 = !r33.v();
        if (Intrinsics.areEqual(r12.a, "template_detail_caption") == false) goto L202;
        y(r12, r13, r32, r15, r116, r115, r22, null);
        goto L425
    L202:
        if (r117 == false) goto L204;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new CreationDoSameAbility$jumpToAvatar2VideoDoSame$1(this, r13, r12, null), 3, null);
        goto L425
    L204:
        Pair<com.larus.bmhome.actionbar.model.z0, Boolean> r34 = q(r32, ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(24));
        com.larus.bmhome.actionbar.model.z0 r35 = (com.larus.bmhome.actionbar.model.z0) r34.getFirst();
        boolean r41 = ((Boolean) r34.getSecond()).booleanValue();
        if (r35 == null) goto L211;
        com.larus.bmhome.actionbar.model.r r36 = r35.q;
        if (r36 == null) goto L211;
        Object r37 = "actionbar_creation_type";
        if (r36.f() != true) goto L212;
        boolean r38 = true;
    L214:
        if (r38 == false) goto L277;
        FragmentActivity r118 = this.a.getActivity();
        if (r118 == null) goto L425;
        CustomInputInitData r42 = s.a(r13);
        boolean r39 = t(r35);
        List<ResourceExt> r210 = sq9.g.c(sq9.g.d(r13));
        UserCreationContent r40 = r13.e;
        if (r40 == null) goto L229;
        VideoUserContent r43 = r40.e;
        if (r43 == null) goto L229;
        ImageInfo r44 = r43.b;
        if (r44 == null) goto L229;
        Image r45 = r44.c;
        if (r45 == null) goto L229;
        String r46 = r45.a;
        if (r46 == null) goto L229;
        String r47 = r46;
    L231:
        if (r33.S() == false) goto L239;
        ICreationPageService r48 = (ICreationPageService) ServiceManager.get().getService(ICreationPageService.class);
        if (r48 == null) goto L244;
        String r49 = r48.g();
        if (r49 == null) goto L244;
    L237:
        r25 = r49;
    L244:
        boolean r119 = v(r13, r12);
        boolean r120 = u(r35, null, r47);
        if (r39 == true) goto L249;
        if (r42 != null) goto L249;
        boolean r310 = false;
    L250:
        boolean r311 = !r12.k;
        String r410 = r47;
        ChatParam r312 = new ChatParam(r22, r32, null, null, null, 252);
        boolean r50 = r12.k;
        List r51 = CollectionsKt.listOf(r25);
        Boolean r52 = r12.j;
        if (r42 == null) goto L253;
        boolean r53 = true;
    L254:
        UserCreationContent r54 = r13.e;
        if (r54 == null) goto L259;
        VideoUserContent r55 = r54.e;
        if (r55 == null) goto L259;
        String r56 = r55.d;
    L260:
        String r57 = r12.b;
        q r58 = new q(r15, r12, r13);
        Pair[] r59 = new Pair[1];
        JSONObject r60 = new JSONObject();
        UserCreation r61 = r12.d;
        if (r61 == null) goto L263;
        String r62 = r61.a;
    L264:
        r60.put("id", r62);
        r60.put("recommend_from", r12.g);
        UserCreationTrackParams r63 = r13.n;
        if (r63 == null) goto L267;
        String r64 = r63.a;
    L268:
        r60.put("template_rec_req_id", r64);
        r60.put("template_rec_extra", r13.i);
        r60.put("from_template_id", r13.a);
        Unit r66 = Unit.INSTANCE;
        r59[0] = TuplesKt.to("creation_template", r60.toString());
        Map r67 = MapsKt.mutableMapOf(r59);
        UserCreationContent r68 = r13.e;
        if (r68 == null) goto L273;
        VideoUserContent r69 = r68.e;
        if (r69 == null) goto L273;
        String r70 = r69.h;
    L274:
        if (r70 == null) goto L276;
        r67.put("internal_resources", r70);
    L276:
        Bundle r71 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("actionbar_instruction_send_message_track_ext_map", o(r12, r13)), TuplesKt.to(r114, r116), TuplesKt.to("image_second_edit_scene", "generated_img_edit")});
        E(r71, r12);
        r33.W(new ny9.b(r310, r118, r35, r312, r50, r53, null, r56, r410, null, r210, r51, null, 18, null, null, null, null, null, false, false, r58, null, r71, false, r67, null, null, r41, r42, false, r52, r10, Boolean.valueOf(r119), Boolean.valueOf(r120), Boolean.valueOf(r311), r57, null, null, null, null, null, r12.x, r12.y, null, null, null, com.larus.uaigc.service.a.a(r13), null, false, 1297994304, 226272));
        return;
    L273:
        r70 = null;
        goto L274
    L267:
        r64 = null;
        goto L268
    L263:
        r62 = null;
    L259:
        r56 = null;
        goto L260
    L253:
        r53 = false;
    L249:
        r310 = true;
        goto L250
    L239:
        if (r33.h() == false) goto L244;
        ICreationPageService r74 = (ICreationPageService) ServiceManager.get().getService(ICreationPageService.class);
        if (r74 == null) goto L244;
        r49 = r74.d();
        if (r49 != null) goto L237;
    L229:
        r47 = "";
        goto L231
    L277:
        Bundle r75 = r115;
        FLogger r76 = FLogger.a;
        StringBuilder r77 = new StringBuilder("template is ");
        r77.append(r116);
        r77.append(" prompt is ");
        UserCreationContent r78 = r13.e;
        if (r78 == null) goto L282;
        UserCreationImage r79 = r78.a;
        if (r79 == null) goto L282;
        String r80 = r79.c;
    L283:
        r77.append(r80);
        r76.i(r19, r77.toString());
        com.bytedance.router.i r81 = SmartRouter.buildRoute(this.a.getContext(), "//flow/chat_page");
        r81.c.putExtras(r75);
        Pair[] r82 = new Pair[5];
        r82[0] = TuplesKt.to("actionbar_instruction_type", 18);
        UserCreationContent r83 = r13.e;
        if (r83 == null) goto L288;
        UserCreationImage r84 = r83.a;
        if (r84 == null) goto L288;
        String r85 = r84.c;
    L289:
        r82[1] = TuplesKt.to("actionbar_instruction_prompt", r85);
        r82[2] = TuplesKt.to(r37, "video");
        JSONObject r86 = new JSONObject();
        UserCreation r87 = r12.d;
        if (r87 == null) goto L292;
        String r88 = r87.a;
    L293:
        r86.put("id", r88);
        r86.put("recommend_from", r12.g);
        UserCreationTrackParams r89 = r13.n;
        if (r89 == null) goto L296;
        String r121 = r89.a;
    L297:
        r86.put("template_rec_req_id", r121);
        r86.put("template_rec_extra", r13.i);
        r86.put("from_template_id", r13.a);
        boolean r90 = r33.v();
        r86.put("tpl_tag_type", r13.q(r90));
        r86.put("tpl_button_type", sq9.q.a(r12.l, r13, r90, r12.m));
        Unit r91 = Unit.INSTANCE;
        r82[3] = TuplesKt.to("actionbar_instruction_message_ext_map", new ICoreInputAbility.MessageExtMap(MapsKt.mapOf(TuplesKt.to("creation_template", r86.toString()))));
        r82[4] = TuplesKt.to("actionbar_instruction_send_message_track_ext_map", o(r12, r13));
        r81.c.putExtras(com.larus.utils.f.c(r82));
        r81.d = 2130772401;
        r81.e = 2130772399;
        r81.d();
        return;
    L296:
        r121 = null;
        goto L297
    L292:
        r88 = null;
    L288:
        r85 = null;
    L282:
        r80 = null;
    L212:
        r38 = false;
    L211:
        r37 = "actionbar_creation_type";
        goto L212
    L198:
        r32 = r26;
        goto L199
    L298:
        Bundle r92 = r115;
        if (r0 != null) goto L301;
    L304:
        boolean r122 = true;
    L305:
        if (r122 == true) goto L307;
    L311:
        if (r26 != null) goto L313;
        String r93 = r16;
    L314:
        y(r12, r13, r93, r15, r116, r92, r22, r0);
        return;
    L313:
        r93 = r26;
        goto L314
    L307:
        if (com.larus.platform.service.z2.a.getCreationMakeSameConfig().b() == false) goto L311;
        if (r13.t() == true) goto L311;
        A();
        return;
    L301:
        if (r0.length() == 0) goto L304;
        r122 = false;
        goto L305
    L315:
        Bundle r94 = r115;
        if (r26 != null) goto L318;
        String r95 = r16;
    L319:
        y(r12, r13, r95, r15, r116, r94, r22, null);
        return;
    L318:
        r95 = r26;
        goto L319
    L320:
        Bundle r96 = r115;
        if (r0 != null) goto L323;
    L326:
        boolean r123 = true;
    L327:
        if (r123 == true) goto L329;
    L333:
        if (r26 != null) goto L335;
        String r97 = r16;
    L336:
        x(r12, r13, r97, r15, r116, r96, r22, r0);
        return;
    L335:
        r97 = r26;
        goto L336
    L329:
        if (com.larus.platform.service.z2.a.getCreationMakeSameConfig().a() == false) goto L333;
        if (r13.t() == true) goto L333;
        A();
        return;
    L323:
        if (r0.length() == 0) goto L326;
        r123 = false;
        goto L327
    L337:
        Bundle r98 = r115;
        UserCreationContent r99 = r13.e;
        if (r99 == null) goto L342;
        AiBeautifyUserContent r100 = r99.d;
        if (r100 == null) goto L342;
        String r101 = r100.e;
    L343:
        if (r101 == null) goto L346;
        r25 = r101;
    L346:
        boolean r102 = UriProtector.parse(r25).getBooleanQueryParameter("need_ref_image", false);
        if (r0 == null) goto L349;
    L353:
        UserCreationContent r103 = r13.e;
        if (r103 == null) goto L358;
        AiBeautifyUserContent r104 = r103.d;
        if (r104 == null) goto L358;
        String r105 = r104.d;
    L359:
        if (r103 == null) goto L363;
        AiBeautifyUserContent r106 = r103.d;
        if (r106 == null) goto L363;
        String r107 = r106.e;
    L364:
        p r108 = new p();
        if (com.larus.utils.o0.d(r107) == false) goto L369;
        Context r109 = this.a.getContext();
        if (r109 == null) goto L440;
        com.bytedance.router.i r124 = SmartRouter.buildRoute(r109, r107);
        r124.c.putExtras(r98);
        r124.c.putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("input_image_uri", r0), TuplesKt.to("actionbar_instruction_prompt", r105), TuplesKt.to("instruction_hit_point_params", com.larus.utils.f.c(new Pair[]{TuplesKt.to("instruction_hit_point_params", ny9.v.a(r108))}))}));
        r124.d = 2130772400;
        r124.e = 2130772399;
        r124.d();
        return;
    L440:
        return;
    L369:
        Context r125 = this.a.getContext();
        if (r125 != null) goto L372;
        return;
    L372:
        if (r() == true) goto L374;
    L376:
        CreationDoSameAbility r126 = this;
        com.bytedance.router.i r127 = SmartRouter.buildRoute(r125, "//flow/chat_page");
        r127.c.putExtras(r98);
        r127.c.putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("actionbar_instruction_prompt", r105), TuplesKt.to("actionbar_instruction_type", 16), TuplesKt.to("actionbar_creation_type", "image_edit"), TuplesKt.to("actionbar_file_path", r0), TuplesKt.to("argConversationId", r12.i), TuplesKt.to("instruction_hit_point_params", com.larus.utils.f.c(new Pair[]{TuplesKt.to("instruction_hit_point_params", ny9.v.a(r108))}))}));
        r127.d = 2130772401;
        r127.e = 2130772399;
        r127.d();
    L443:
        return;
    L374:
        if (com.larus.utils.o0.d(r0) == false) goto L376;
        r126 = this;
        r126.z("jumpToAIBeautifyDoSame", Dispatchers.getMain().getImmediate(), new CreationDoSameAbility$jumpToAIBeautifyDoSame$2$1(this, r105, r0, r116, r108, r12, r13, r125, null));
    L363:
        r107 = null;
    L358:
        r105 = null;
        goto L359
    L349:
        if (com.larus.utils.o0.d(r101) == false) goto L352;
        if (r102 == false) goto L353;
    L352:
        A();
        return;
    L342:
        r101 = null;
        goto L343
    L378:
        w(r12, r115, r13, r116);
        return;
    L379:
        Bundle r128 = r115;
        if (r26 != null) goto L382;
        String r129 = r16;
    L383:
        x(r12, r13, r129, r15, r116, r128, r22, null);
        return;
    L382:
        r129 = r26;
        goto L383
    L384:
        Object r130 = "creation_template";
        Bundle r131 = r115;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L400
        Gson r133 = HttpExtKt.f;     // Catch: Throwable -> L400
        Object r313 = "actionbar_instruction_message_ext_map";
        UserCreationContent r134 = r13.e;     // Catch: Throwable -> L398
        if (r134 == null) goto L393;
        UserCreationMusic r135 = r134.b;     // Catch: Throwable -> L398
        if (r135 == null) goto L393;
        String r136 = r135.j;     // Catch: Throwable -> L398
    L426:
        Object r137 = Result.constructor-impl((com.larus.bmhome.music.protocol.e) r133.fromJson(r136, com.larus.bmhome.music.protocol.e.class));     // Catch: Throwable -> L396
    L404:
        if (Result.isFailure-impl(r137) == false) goto L406;
        r137 = null;
    L406:
        com.larus.bmhome.music.protocol.e r138 = (com.larus.bmhome.music.protocol.e) r137;
        Context r139 = this.a.getContext();
        if (r139 == null) goto L446;
        com.bytedance.router.i r140 = SmartRouter.buildRoute(r139, "//flow/chat_page");
        r140.c.putExtras(r131);
        Pair[] r141 = new Pair[4];
        r141[0] = TuplesKt.to("actionbar_instruction_type", 1);
        if (r138 == null) goto L411;
        String r142 = r138.b();
    L413:
        if (com.larus.utils.o0.d(r142) == false) goto L416;
        if (r138 == null) goto L418;
        String r143 = r138.b();
    L419:
        r141[1] = TuplesKt.to("actionbar_instruction_prompt", r143);
        r141[2] = TuplesKt.to("actionbar_creation_type", "music");
        JSONObject r144 = new JSONObject();
        r144.put("id", r13.a);
        r144.put("recommend_from", r12.g);
        UserCreationTrackParams r145 = r13.n;
        if (r145 == null) goto L422;
        String r146 = r145.a;
    L423:
        r144.put("template_rec_req_id", r146);
        r144.put("template_rec_extra", r13.i);
        r144.put("from_template_id", r13.a);
        Unit r147 = Unit.INSTANCE;
        r141[3] = TuplesKt.to(r313, new ICoreInputAbility.MessageExtMap(MapsKt.mapOf(TuplesKt.to(r130, r144.toString()))));
        r140.c.putExtras(com.larus.utils.f.c(r141));
        r140.d = 2130772401;
        r140.e = 2130772399;
        r140.d();
        return;
    L422:
        r146 = null;
    L418:
        r143 = null;
        goto L419
    L416:
        if (r138 == null) goto L418;
        r143 = r138.a();
        goto L419
    L411:
        r142 = null;
        goto L413
    L446:
        return;
    L396:
        th = th;
    L402:
        Result.Companion r148 = Result.Companion;
        r137 = Result.constructor-impl(ResultKt.createFailure(th));
    L393:
        r136 = null;
    L398:
        th = th;
    L399:
        r130 = r130;
    L400:
        th = th;
        r313 = "actionbar_instruction_message_ext_map";
    L185:
        r30 = null;
    L84:
        com.larus.bmhome.chat.api.e0 r149 = (com.larus.bmhome.chat.api.e0) r2.e().getValue();
        if (r149 == null) goto L90;
        LaunchInfo r150 = r149.a;
        if (r150 == null) goto L90;
        String r151 = r150.W();
        if (r151 == null) goto L90;
    L101:
        String r152 = r151;
    L102:
        CreationDynamicInfo r153 = r13.h;
        if (r153 == null) goto L107;
        TplInfo r154 = r153.e;
        if (r154 == null) goto L107;
        String r155 = r154.a;
    L109:
        if (Intrinsics.areEqual(r155, "change_picture") == true) goto L111;
    L117:
        String r710 = r27;
        String r156 = r12.l;
        if (Intrinsics.areEqual(r156, DoSameQuickMenuType.REPLACE_PIC) == false) goto L160;
        if (r18 == null) goto L121;
        Integer r157 = r18.d;
    L123:
        if (r157 != null) goto L126;
    L140:
        r113 = "actionbar_instruction_default_params";
        r22 = r8;
        r26 = r9;
        r65 = TplType.AI_REPLICA;
        r24 = r710;
        r23 = r17;
        if (r157 != null) goto L144;
    L158:
        FLogger.a.i("CreationDoSameAbility", "quickMenuLogicIntercept: unknown action type");
    L159:
        r114 = r113;
        r115 = r23;
        r116 = r24;
    L177:
        r3 = false;
        goto L178
    L144:
        if (r157.intValue() != 1) goto L158;
        Integer r158 = r18.a;
        if (r158 != null) goto L149;
    L151:
        if (r158 != null) goto L154;
    L157:
        FLogger.a.i("CreationDoSameAbility", "quickMenuLogicIntercept: unknown create type");
        goto L159
    L154:
        if (r158.intValue() != 2) goto L157;
        w(r12, r23, r13, r24);
        goto L156
    L149:
        if (r158.intValue() != 1) goto L151;
        i(r12, r23, r13, r0, r152);
        goto L156
    L126:
        if (r157.intValue() != 0) goto L140;
        Integer r159 = r18.a;
        if (r159 != null) goto L131;
    L133:
        r113 = "actionbar_instruction_default_params";
        r22 = r8;
        r26 = r9;
        r65 = TplType.AI_REPLICA;
        if (r159 != null) goto L137;
    L139:
        r24 = r710;
        r23 = r17;
        FLogger.a.i("CreationDoSameAbility", "quickMenuLogicIntercept: unknown create type");
        goto L159
    L137:
        if (r159.intValue() != 2) goto L139;
        r24 = r710;
        r23 = r17;
        w(r12, r23, r13, r24);
        goto L156
    L131:
        if (r159.intValue() != 1) goto L133;
        String r160 = r12.b;
        String r161 = r12.i;
        r65 = TplType.AI_REPLICA;
        r22 = r8;
        r26 = r9;
        x(r12, r13, r152, r160, r710, r17, r161, r0);
        r114 = "actionbar_instruction_default_params";
        r116 = r710;
        r115 = r17;
        goto L175
    L121:
        r157 = null;
        goto L123
    L160:
        r22 = r8;
        r26 = r9;
        r65 = TplType.AI_REPLICA;
        if (Intrinsics.areEqual(r156, DoSameQuickMenuType.USE_PICTURE) == false) goto L176;
        String r162 = r17.getString("argBotId");
        if (r162 != null) goto L166;
        r162 = "";
    L166:
        if (r162.length() != 0) goto L168;
        boolean r163 = true;
    L169:
        if (r163 == false) goto L173;
        r162 = r12.h;
        if (r162 != null) goto L173;
        String r164 = "";
    L174:
        r114 = "actionbar_instruction_default_params";
        r115 = r17;
        r116 = r710;
        x(r12, r13, r164, r12.b, r710, r17, r12.i, r0);
    L173:
        r164 = r162;
        goto L174
    L168:
        r163 = false;
        goto L169
    L176:
        r114 = "actionbar_instruction_default_params";
        r116 = r710;
        r115 = r17;
        goto L177
    L111:
        if (r12.m == true) goto L117;
        if (com.larus.utils.o0.d(r0) == false) goto L117;
        if (r13.b == 4) goto L117;
        i(r12, r17, r13, r0, r152);
        r22 = r8;
        r26 = r9;
        r114 = "actionbar_instruction_default_params";
        r65 = TplType.AI_REPLICA;
        r3 = true;
        r116 = r27;
        r19 = "CreationDoSameAbility";
        r115 = r17;
    L107:
        r155 = null;
    L90:
        r151 = r17.getString("argBotId");
        if (r151 != null) goto L94;
        r151 = "";
    L94:
        if (r151.length() != 0) goto L96;
        boolean r165 = true;
    L97:
        if (r165 == false) goto L101;
        r151 = r12.h;
        if (r151 != null) goto L101;
        r152 = "";
        goto L102
    L96:
        r165 = false;
        goto L97
    L78:
        if (r0.length() == 0) goto L81;
        r21 = false;
    L66:
        CreationDynamicInfo r166 = r13.h;
        if (r166 == null) goto L71;
        TplInfo r167 = r166.e;
        if (r167 == null) goto L71;
        String r168 = r167.a;
    L73:
        if (Intrinsics.areEqual(r168, "change_picture") == false) goto L84;
        if (r12.m == true) goto L84;
    L71:
        r168 = null;
    L57:
        r111 = false;
    L56:
        r27 = r6;
        r20 = 1;
        goto L57
    L65:
        r27 = r6;
        goto L66
    L46:
        r14 = r9;
    L42:
        r7 = "7234781073513644036";
        goto L43
    L22:
        if (Intrinsics.areEqual(r12.l, DoSameQuickMenuType.USE_PICTURE) == true) goto L35;
        CreationDynamicInfo r169 = r13.h;
        if (r169 == null) goto L28;
        TplInfo r170 = r169.e;
        if (r170 == null) goto L28;
        String r171 = r170.a;
    L30:
        if (Intrinsics.areEqual(r171, TplType.AI_REPLICA) == true) goto L35;
        UserCreation r172 = r12.d;
        if (r172 == null) goto L35;
        r6 = is9.a.b(r172);
    L28:
        r171 = null;
        goto L30
    L14:
        if (com.larus.utils.o0.d(r0) == true) goto L17;
        r0 = null;
    L17:
        if (r0 != null) goto L19;
    L425:
        return;
    L5:
        if (s() == false) goto L8;
        String r173 = r72.a;
        String r174 = r72.b;
        String r175 = r72.c;
        UserCreation r176 = r72.d;
        String r177 = r72.e;
        String r178 = r72.f;
        String r179 = r72.g;
        String r180 = r72.h;
        String r181 = r72.i;
        Boolean r182 = r72.j;
        boolean r183 = r72.k;
        String r184 = r72.l;
        boolean r185 = r72.m;
        String r186 = r72.n;
        String r187 = r72.o;
        String r188 = r72.p;
        String r189 = r72.q;
        String r190 = r72.r;
        sq9.d0 r191 = r72.s;
        Integer r192 = r72.t;
        Integer r193 = r72.u;
        String r194 = r72.v;
        String r195 = r72.w;
        Integer r196 = r72.x;
        Intrinsics.checkNotNullParameter(r174, "previousPageName");
        r12 = new sq9.p(r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r10);
        goto L9
    }

    public final Pair<com.larus.bmhome.actionbar.model.z0, Boolean> q(String r2, com.larus.bmhome.actionbar.model.z0 r3) {
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L5;
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L12;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L12;
        String r4 = r1.W();
        if (r4 == null) goto L12;
    L14:
        if (Intrinsics.areEqual(r2, r4) == false) goto L16;
        com.larus.bmhome.actionbar.model.z0 r5 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(28);
        if (r5 == null) goto L21;
        return new Pair(r5, Boolean.FALSE);
    L21:
        return new Pair(r3, Boolean.TRUE);
    L16:
        return new Pair(r3, Boolean.TRUE);
    L12:
        r4 = "7234781073513644036";
        goto L14
    L5:
        return new Pair(r3, Boolean.TRUE);
    }

    public static final String b(CreationDoSameAbility r9, com.larus.bmhome.actionbar.model.z0 r10, String r11) {
        r9.getClass();
        com.larus.bmhome.view.actionbar.custom.e r0 = com.larus.bmhome.view.actionbar.custom.e.a;     // Catch: Exception -> L9
        if (r10 == null) goto L6;
        com.larus.bmhome.actionbar.model.r r12 = r10.q;     // Catch: Exception -> L9
    L7:
        return com.larus.bmhome.view.actionbar.custom.w2.a.a(r0, r11, r12, null, null, null, 0, null, 112);
    L6:
        r12 = null;
    L9:
        e = move-exception;
        FLogger.a.e("CreationDoSameAbility", "buildContent error = " + e.getMessage());
        if (AppHost.a.isDebug() == true) goto L14;
        return r11;
    L14:
        throw new IllegalArgumentException("InstructionComponent, " + e.getMessage());
    }

    public static final Object e(CreationDoSameAbility r4, CreationSendMessageConfig r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof CreationDoSameAbility$doSendWithCreationMessage$1) == false) goto L7;
        CreationDoSameAbility$doSendWithCreationMessage$1 r0 = (CreationDoSameAbility$doSendWithCreationMessage$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L14;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L21
    L19:
        Object r9 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r7).booleanValue()));     // Catch: Throwable -> L21
    L23:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L26;
        FLogger.a.e("CreationDoSameAbility", "doSendWithCreationMessage failed", r10);
    L26:
        ResultKt.throwOnFailure(r9);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L21
        ICreationWorkflowService.Companion r12 = ICreationWorkflowService.a;     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        r7 = r12.W(r5, r0);     // Catch: Throwable -> L21
        if (r7 != r8) goto L19;
        return r8;
    L21:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new CreationDoSameAbility$doSendWithCreationMessage$1(r4, r6);
        goto L8
    }

    public static final String f(CreationDoSameAbility r2, UserCreation r3, sq9.p r4) {
        r2.getClass();
        CreationDynamicInfo r5 = r3.h;
        String r0 = null;
        if (r5 == null) goto L7;
        TplInfo r6 = r5.e;
        if (r6 == null) goto L7;
        String r7 = r6.a;
    L9:
        if (Intrinsics.areEqual(r7, TplType.AI_REPLICA) == false) goto L15;
        TplDetail r8 = is9.a.c(r3);
        if (r8 == null) goto L13;
        r0 = r8.i;
    L13:
        if (r0 != null) goto L41;
    L34:
        return "";
    L41:
        return r0;
    L15:
        if (r4 == null) goto L17;
        String r9 = r4.l;
    L19:
        if (Intrinsics.areEqual(r9, DoSameQuickMenuType.REPLACE_PIC) == false) goto L35;
        TplDetail r10 = is9.a.c(r3);
        if (r10 == null) goto L28;
        Integer r11 = r10.a;
        if (r11 == null) goto L28;
        if (r11.intValue() != 2) goto L28;
        boolean r12 = true;
    L29:
        if (r12 == false) goto L35;
        TplDetail r13 = is9.a.c(r3);
        if (r13 == null) goto L33;
        r0 = r13.i;
    L33:
        if (r0 == null) goto L34;
        return r0;
    L28:
        r12 = false;
    L35:
        UserCreationContent r14 = r3.e;
        if (r14 == null) goto L44;
        UserCreationUserAvatar r15 = r14.c;
        if (r15 != null) goto L40;
        return null;
    L40:
        return r15.c;
    L44:
        return null;
    L17:
        r9 = null;
    L7:
        r7 = null;
        goto L9
    }

    public static boolean u(com.larus.bmhome.actionbar.model.z0 r3, String r4, String r5) {
        com.larus.bmhome.actionbar.model.r r6 = r3.q;
        if (r6 == null) goto L10;
        Integer r7 = r6.a;
        if (r7 == null) goto L10;
        if (r7.intValue() != 28) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == true) goto L26;
        if (r4 != null) goto L15;
    L18:
        boolean r9 = true;
    L19:
        if (r9 == true) goto L21;
        return false;
    L21:
        if (com.larus.utils.o0.d(r5) == false) goto L25;
        return true;
    L25:
        return false;
    L15:
        if (r4.length() == 0) goto L18;
        r9 = false;
        goto L19
    L26:
        return false;
    L10:
        r8 = false;
        goto L11
    }

    public final Object C(Context r10, String r11, Continuation<? super String> r12) {
        if ((r12 instanceof CreationDoSameAbility$saveRemoteUrl2Local$1) == false) goto L7;
        CreationDoSameAbility$saveRemoteUrl2Local$1 r0 = (CreationDoSameAbility$saveRemoteUrl2Local$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Ref.ObjectRef r14 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L26:
        File r15 = (File) r13;
        if (r15 == null) goto L33;
        CloseableReference r16 = (CloseableReference) r14.element;
        if (r16 == null) goto L32;
        r16.close();
    L32:
        return r15.getAbsolutePath();
    L33:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r14 = (Ref.ObjectRef) r0.L$1;
        Context r17 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L20:
        Bitmap r18 = (Bitmap) r13;
        if (r18 != null) goto L23;
        return null;
    L23:
        IUgcAIGCService.Companion r4 = IUgcAIGCService.a;
        String r5 = "remote_attachment_url_default" + System.currentTimeMillis() + ".jpeg";
        r0.L$0 = r14;
        r0.L$1 = null;
        r0.label = 2;
        r13 = r4.e(r17, r18, r5, r0);
        if (r13 != r2) goto L26;
        return r2;
    L16:
        ResultKt.throwOnFailure(r13);
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        CoroutineDispatcher r6 = Dispatchers.getIO();
        CreationDoSameAbility$saveRemoteUrl2Local$bitmap$1 r7 = new CreationDoSameAbility$saveRemoteUrl2Local$bitmap$1(r11, r19, null);
        r0.L$0 = r10;
        r0.L$1 = r19;
        r0.label = 1;
        Object r110 = BuildersKt.withContext(r6, r7, r0);
        if (r110 != r2) goto L19;
        return r2;
    L19:
        r17 = r10;
        r14 = r19;
        r13 = r110;
    L7:
        r0 = new CreationDoSameAbility$saveRemoteUrl2Local$1(this, r12);
        goto L8
    }

    public final Job z(String r8, CoroutineDispatcher r9, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r10) {
        return BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), r9, null, new CreationDoSameAbility$launchCreationSendSafely$1(r10, r8, null), 2, null);
    }

    public static final Object h(CreationDoSameAbility r3, String r4, Function0 r5, Continuation r6) {
        r3.getClass();
        Object r7 = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new CreationDoSameAbility$runWhenFragmentActive$2(r3, r4, r5, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    public final void B(sq9.p r7, UserCreation r8, Bundle r9, String r10) {
        if (r7.k == true) goto L5;
        z("directBackToChatFromAvatar", Dispatchers.getDefault(), new CreationDoSameAbility$directBackToChatFromAvatar$1(this, r8, r7, null));
        return;
    L5:
        i(r7, r9, r8, null, r10);
    }

    public final void p(final sq9.p r9, UserCreation r10, Bundle r11, String r12) {
        Integer r0 = r9.x;
        if (r0 == null) goto L9;
        if (r0.intValue() != 0) goto L9;
        B(r9, r10, r11, r12);
        return;
    L9:
        if (r0 != null) goto L12;
    L16:
        if (r0 != null) goto L19;
        return;
    L19:
        if (r0.intValue() != 2) goto L30;
        z("directSendAvatarMsg", Dispatchers.getDefault(), new CreationDoSameAbility$directSendAvatarMsg$1(this, r10, r9, null));
        FragmentActivity r13 = this.a.getActivity();
        if (r13 == null) goto L23;
        Intent r14 = new Intent();
        r14.putExtra("creation_dosame_notify_info", com.larus.uaigc.service.a.a(r10));
        Unit r15 = Unit.INSTANCE;
        r13.setResult(372, r14);
    L23:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new CreationDoSameAbility$handleAvatarDoSameLanding$3(null), 3, null);
        FragmentActivity r16 = this.a.getActivity();
        if (r16 == null) goto L31;
        r16.finish();
        return;
    L31:
        return;
    L30:
        return;
    L12:
        if (r0.intValue() != 1) goto L16;
        z("directSendAvatarMsg", Dispatchers.getDefault(), new CreationDoSameAbility$directSendAvatarMsg$1(this, r10, r9, null));
        IUgcAIGCService.Companion r2 = IUgcAIGCService.a;
        r2.y();
        FragmentActivity r5 = this.a.getActivity();
        if (r5 == null) goto L28;
        r2.Z(com.larus.uaigc.service.a.a(r10), r5, r5, r9.c, new com.larus.profile.impl.creation.a(this, r9));
        return;
    }

    public final void w(sq9.p r67, Bundle r68, UserCreation r69, String r70) {
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L8;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L8;
        String r2 = r1.W();
        if (r2 == null) goto L8;
    L9:
        String r3 = r2;
        IUgcAIGCService.Companion r4 = IUgcAIGCService.a;
        boolean r5 = !r4.v();
        if (Intrinsics.areEqual(r67.a, "template_detail_caption") == false) goto L14;
        x(r67, r69, r3, r67.b, r70, r68, r67.i, null);
        return;
    L14:
        if (r5 == false) goto L16;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new CreationDoSameAbility$jumpToAvatarDoSame$1(this, r69, r67, null), 3, null);
        return;
    L16:
        CreationDynamicInfo r6 = r69.h;
        if (r6 == null) goto L21;
        TplInfo r7 = r6.e;
        if (r7 == null) goto L21;
        String r8 = r7.a;
    L23:
        if (Intrinsics.areEqual(r8, TplType.AI_REPLICA) == false) goto L27;
        p(r67, r69, r68, r3);
        return;
    L27:
        if (((Boolean) this.e.getValue()).booleanValue() == false) goto L102;
        String r9 = r67.h;
        if (r9 != null) goto L31;
        String r12 = r3;
    L32:
        com.larus.bmhome.actionbar.model.z0 r10 = (com.larus.bmhome.actionbar.model.z0) q(r12, ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(4)).getFirst();
        if (r10 == null) goto L39;
        com.larus.bmhome.actionbar.model.r r11 = r10.q;
        if (r11 == null) goto L39;
        if (r11.f() != true) goto L39;
        boolean r13 = true;
    L40:
        if (r13 == false) goto L107;
        FragmentActivity r14 = this.a.getActivity();
        if (r14 == null) goto L108;
        CustomInputInitData r43 = s.a(r69);
        UserCreationContent r15 = r69.e;
        String r16 = "";
        if (r15 == null) goto L55;
        UserCreationUserAvatar r17 = r15.c;
        if (r17 == null) goto L55;
        ImageInfo r18 = r17.a;
        if (r18 == null) goto L55;
        Image r19 = r18.i;
        if (r19 == null) goto L55;
        String r110 = r19.a;
        if (r110 == null) goto L55;
        String r111 = r110;
    L56:
        List<ResourceExt> r112 = sq9.g.c(sq9.g.d(r69));
        if (r4.S() == false) goto L65;
        ICreationPageService r113 = (ICreationPageService) ServiceManager.get().getService(ICreationPageService.class);
        if (r113 == null) goto L70;
        String r114 = r113.g();
        if (r114 == null) goto L70;
    L63:
        r16 = r114;
    L70:
        String r115 = r16;
        boolean r116 = u(r10, null, r111);
        String r22 = r111;
        ChatParam r21 = new ChatParam(r67.i, r12, null, null, null, 252);
        boolean r117 = r67.k;
        boolean r118 = !r117;
        if (Intrinsics.areEqual(r67.l, DoSameQuickMenuType.REPLACE_PIC) == false) goto L73;
    L75:
        boolean r119 = false;
    L76:
        boolean r120 = v(r69, r67);
        if (r4.v() == true) goto L81;
        r22 = null;
    L81:
        if (r4.v() == false) goto L83;
        List<ResourceExt> r24 = r112;
    L85:
        if (r4.v() == false) goto L87;
        List r121 = CollectionsKt.listOf(r115);
    L88:
        List r25 = r121;
        Boolean r122 = r67.j;
        if (r43 == null) goto L91;
        boolean r35 = true;
    L92:
        String r40 = j(r69, r67);
        Integer r41 = n(r69, r67);
        Integer r45 = m(r69, r67);
        String r123 = r67.b;
        r r20 = new r(r67, r69);
        Pair[] r23 = new Pair[2];
        r23[0] = TuplesKt.to("original_content_source", "use_template");
        JSONObject r26 = new JSONObject();
        UserCreation r124 = r67.d;
        if (r124 == null) goto L95;
        String r125 = r124.a;
    L96:
        r26.put("id", r125);
        r26.put("recommend_from", r67.g);
        UserCreationTrackParams r27 = r69.n;
        if (r27 == null) goto L99;
        String r28 = r27.a;
    L100:
        r26.put("template_rec_req_id", r28);
        r26.put("template_rec_extra", r69.i);
        r26.put("from_template_id", r69.a);
        boolean r29 = r4.v();
        r26.put("tpl_tag_type", r69.q(r29));
        r26.put("tpl_button_type", sq9.q.a(r67.l, r69, r29, r67.m));
        Unit r30 = Unit.INSTANCE;
        r23[1] = TuplesKt.to("creation_template", r26.toString());
        Map r39 = MapsKt.mapOf(r23);
        Bundle r31 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("actionbar_instruction_send_message_track_ext_map", o(r67, r69)), TuplesKt.to("actionbar_instruction_default_params", r70), TuplesKt.to("image_second_edit_scene", "generated_img_edit")});
        E(r31, r67);
        r4.W(new ny9.b(true, r14, r10, r21, r117, r35, null, r40, r22, null, r24, r25, null, 4, null, null, null, null, null, false, false, r20, null, r31, false, r39, r41, r45, false, r43, false, r122, Boolean.valueOf(r119), Boolean.valueOf(r120), Boolean.valueOf(r116), Boolean.valueOf(r118), r123, null, null, null, null, null, r67.x, r67.y, null, null, null, com.larus.uaigc.service.a.a(r69), null, false, 1365234240, 226272));
        return;
    L99:
        r28 = null;
        goto L100
    L95:
        r125 = null;
        goto L96
    L91:
        r35 = false;
        goto L92
    L87:
        r121 = CollectionsKt.emptyList();
        goto L88
    L83:
        r24 = CollectionsKt.emptyList();
        goto L85
    L73:
        if (Intrinsics.areEqual(r67.l, DoSameQuickMenuType.USE_PICTURE) == true) goto L75;
        r119 = true;
        goto L76
    L65:
        if (r4.h() == false) goto L70;
        ICreationPageService r126 = (ICreationPageService) ServiceManager.get().getService(ICreationPageService.class);
        if (r126 == null) goto L70;
        r114 = r126.d();
        if (r114 != null) goto L63;
    L55:
        r111 = "";
        goto L56
    L108:
        return;
    L107:
        return;
    L39:
        r13 = false;
        goto L40
    L31:
        r12 = r9;
        goto L32
    L102:
        if (Intrinsics.areEqual(r67.y, Boolean.TRUE) == false) goto L104;
        p(r67, r69, r68, r3);
        return;
    L104:
        B(r67, r69, r68, r3);
        return;
    L21:
        r8 = null;
    L8:
        r2 = "7234781073513644036";
        goto L9
    }

    public final void i(sq9.p r15, Bundle r16, UserCreation r17, String r18, String r19) {
        if (r15.k == false) goto L34;
        Context r7 = this.a.getContext();
        if (r7 == null) goto L36;
        Pair[] r1 = new Pair[2];
        r1[0] = TuplesKt.to("original_content_source", "use_template");
        JSONObject r2 = new JSONObject();
        UserCreation r6 = r15.d;
        String r8 = null;
        if (r6 == null) goto L9;
        String r9 = r6.a;
    L10:
        r2.put("id", r9);
        r2.put("recommend_from", r15.g);
        UserCreationTrackParams r10 = r17.n;
        if (r10 == null) goto L13;
        String r11 = r10.a;
    L14:
        r2.put("template_rec_req_id", r11);
        r2.put("template_rec_extra", r17.i);
        r2.put("from_template_id", r17.a);
        boolean r12 = IUgcAIGCService.a.v();
        r2.put("tpl_tag_type", r17.q(r12));
        if (r17.b == 3) goto L28;
        CreationDynamicInfo r13 = r17.h;
        if (r13 == null) goto L21;
        TplInfo r14 = r13.e;
        if (r14 == null) goto L21;
        String r20 = r14.a;
    L23:
        if (Intrinsics.areEqual(r20, TplType.AI_REPLICA) == true) goto L28;
        String r21 = r15.l;
        if (r21 == null) goto L29;
        r8 = sq9.q.a(r21, r17, r12, false);
    L29:
        r2.put("tpl_button_type", r8);
        Unit r22 = Unit.INSTANCE;
        r1[1] = TuplesKt.to("creation_template", r2.toString());
        Map r23 = MapsKt.mapOf(r1);
        Boolean r0 = Boolean.TRUE;
        Bundle r3 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("actionbar_instruction_message_ext_map", new ICoreInputAbility.MessageExtMap(r23)), TuplesKt.to("actionbar_instruction_send_message_track_ext_map", o(r15, r17)), TuplesKt.to("argConversationId", r15.i), TuplesKt.to("default_tab", Integer.valueOf(TemplateInfo$DefaultTab.CHAT.ordinal())), TuplesKt.to("is_from_template_detail", r0), TuplesKt.to("is_need_fixed_bottom_tab", Boolean.FALSE), TuplesKt.to("actionbar_creation_type", "avatar")});
        if (Intrinsics.areEqual(r15.j, r0) == false) goto L32;
        String r4 = "//flow/chat_page_double_tab";
    L33:
        Bundle r110 = new Bundle(r16);
        r110.putAll(r3);
        z("directJumpToChat", Dispatchers.getMain().getImmediate(), new CreationDoSameAbility$directJumpToChat$1$1(r17, this, r15, r23, r19, r18, r7, r4, r110, null));
        return;
    L32:
        r4 = "//flow/chat_page";
    L21:
        r20 = null;
    L28:
        r8 = TplButtonType.GEN_CREATE_AVATAR;
        goto L29
    L13:
        r11 = null;
        goto L14
    L9:
        r9 = null;
        goto L10
    L36:
        return;
    L34:
        z("directBackToChatFromImage", Dispatchers.getDefault(), new CreationDoSameAbility$directBackToChatFromImage$1(this, r19, r15, r17, "avatar", r18, null));
    }

    public static final Object c(CreationDoSameAbility r16, ICoreInputAbility.OnSendParams r17, sq9.p r18, UserCreation r19, String r20, Continuation r21) {
        sq9.p r0 = r18;
        r16.getClass();
        if ((r21 instanceof CreationDoSameAbility$buildCreationSendMessageConfig$1) == false) goto L7;
        CreationDoSameAbility$buildCreationSendMessageConfig$1 r2 = (CreationDoSameAbility$buildCreationSendMessageConfig$1) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        String r10 = null;
        String r11 = "";
        boolean r13 = true;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        String r5 = (String) r2.L$4;
        String r6 = (String) r2.L$3;
        UserCreation r7 = (UserCreation) r2.L$2;
        sq9.p r8 = (sq9.p) r2.L$1;
        ICoreInputAbility.OnSendParams r12 = (ICoreInputAbility.OnSendParams) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L41:
        wc9.e r14 = (wc9.e) r1;
        if (r14 != null) goto L44;
        r14 = (wc9.e) AuthModelDelegate.b.u().getValue();
    L44:
        ICoreInputAbility.OnSendParams r15 = r12;
        UserCreation r110 = r7;
        wc9.e r22 = r14;
        String r23 = r5;
        r0 = r8;
    L45:
        if (r22 == null) goto L47;
        String r24 = r22.a;
    L48:
        if (r24 == null) goto L52;
        r11 = r24;
    L52:
        if (r11.length() == 0) goto L55;
        r13 = false;
    L55:
        if (r13 == true) goto L58;
        r23 = r11;
    L58:
        CreationSendMessageConfig.Companion.getClass();
        CreationSendMessageConfig.a r25 = new CreationSendMessageConfig.a();
        r25.j(r22);
        r25.l(r23);
        String r26 = r0.h;
        if (r26 != null) goto L65;
        com.larus.bmhome.chat.api.e0 r27 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r27 == null) goto L66;
        LaunchInfo r28 = r27.a;
        if (r28 == null) goto L66;
        r10 = r28.W();
    L66:
        r25.f(r10);
        r25.i(r15.getContent());
        r25.s(r15.getScene());
        r25.u(r15.getTxtScene());
        r25.m(r15.getEnterMethod());
        r25.r(r15.getPreviousPage());
        r25.d(Boxing.boxInt(r15.getActionInstruction()));
        r25.c(r15.getActionBarInstructionMap());
        r25.e(r15.getAttachment());
        r25.k(r15.getCustomMultiAttachment());
        r25.q(r15.messageExt);
        r25.t(o(r0, r110).a);
        r25.a(r110.a);
        r25.b(r6);
        r25.p(r15.getLocalIntercepted());
        r25.o(r15.getLocalInterceptInfo());
        r25.h(r15.clearInputContent);
        return r25.a;
    L65:
        r10 = r26;
        goto L66
    L47:
        r24 = null;
        goto L48
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r29 = (String) r2.L$4;
        r6 = (String) r2.L$3;
        UserCreation r30 = (UserCreation) r2.L$2;
        sq9.p r31 = (sq9.p) r2.L$1;
        ICoreInputAbility.OnSendParams r32 = (ICoreInputAbility.OnSendParams) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r110 = r30;
        r15 = r32;
        Object r33 = r1;
        r23 = r29;
        r0 = r31;
    L35:
        r22 = (wc9.e) r33;
        if (r22 != null) goto L45;
        RepoDispatcher.a.getClass();
        ConversationRepo r34 = RepoDispatcher.f;
        r2.L$0 = r15;
        r2.L$1 = r0;
        r2.L$2 = r110;
        r2.L$3 = r6;
        r2.L$4 = r23;
        r2.label = 2;
        Object r35 = r34.f(r2);
        if (r35 == r9) goto L69;
        r8 = r0;
        r5 = r23;
        r1 = r35;
        r12 = r15;
        r7 = r110;
        goto L41
    L69:
        return r9;
    L16:
        ResultKt.throwOnFailure(r1);
        r23 = r0.i;
        if (r23 != null) goto L19;
    L23:
        com.larus.bmhome.chat.api.e0 r36 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r36 == null) goto L28;
        LaunchInfo r37 = r36.a;
        if (r37 == null) goto L28;
        r23 = r37.Y();
    L29:
        if (r23 != null) goto L31;
        r23 = "";
    L31:
        RepoDispatcher.a.getClass();
        ConversationRepo r38 = RepoDispatcher.f;
        r15 = r17;
        r2.L$0 = r15;
        r2.L$1 = r0;
        r110 = r19;
        r2.L$2 = r110;
        r2.L$3 = r20;
        r2.L$4 = r23;
        r2.label = 1;
        Object r39 = IConversationRepoService.a.c(r38, r23, false, null, r2, 6);
        if (r39 == r9) goto L68;
        r33 = r39;
        r6 = r20;
        goto L35
    L68:
        return r9;
    L28:
        r23 = null;
        goto L29
    L19:
        if (com.larus.utils.o0.d(r23) == true) goto L22;
        r23 = null;
    L22:
        if (r23 != null) goto L31;
    L7:
        r2 = new CreationDoSameAbility$buildCreationSendMessageConfig$1(r16, r21);
        goto L8
    }

    public final void x(sq9.p r69, UserCreation r70, String r71, String r72, String r73, Bundle r74, String r75, String r76) {
        Pair<com.larus.bmhome.actionbar.model.z0, Boolean> r4 = q(r71, ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(4));
        com.larus.bmhome.actionbar.model.z0 r14 = (com.larus.bmhome.actionbar.model.z0) r4.getFirst();
        boolean r33 = ((Boolean) r4.getSecond()).booleanValue();
        if (r14 == null) goto L9;
        com.larus.bmhome.actionbar.model.r r6 = r14.q;
        if (r6 == null) goto L9;
        if (r6.f() != true) goto L9;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L58;
        FragmentActivity r26 = this.a.getActivity();
        if (r26 == null) goto L81;
        CustomInputInitData r34 = s.a(r70);
        boolean r8 = t(r14);
        String r12 = k(r70, r69);
        boolean r31 = v(r70, r69);
        boolean r32 = u(r14, r76, r12);
        List r17 = l(r70, r69);
        IUgcAIGCService.Companion r15 = IUgcAIGCService.a;
        if (r8 == true) goto L19;
        if (r34 != null) goto L19;
        boolean r36 = false;
    L20:
        ChatParam r41 = new ChatParam(r75, r71, null, null, null, 252);
        boolean r9 = r69.k;
        boolean r10 = !r9;
        if (Intrinsics.areEqual(r69.l, DoSameQuickMenuType.REPLACE_PIC) == false) goto L23;
    L25:
        boolean r13 = false;
    L26:
        if (r76 != null) goto L28;
    L31:
        boolean r11 = true;
    L32:
        if (r11 == false) goto L34;
        String r60 = r12;
    L35:
        if (r76 != null) goto L37;
    L40:
        boolean r16 = true;
    L41:
        if (r16 == false) goto L43;
        List r61 = r17;
    L44:
        Boolean r18 = r69.j;
        if (r34 == null) goto L47;
        boolean r62 = true;
    L48:
        String r63 = j(r70, r69);
        Integer r64 = n(r70, r69);
        Integer r65 = m(r70, r69);
        String r19 = r69.b;
        b r20 = new b(r72, r69, r70);
        Pair[] r21 = new Pair[2];
        r21[0] = TuplesKt.to("original_content_source", "use_template");
        JSONObject r22 = new JSONObject();
        UserCreation r110 = r69.d;
        if (r110 == null) goto L51;
        String r111 = r110.a;
    L52:
        r22.put("id", r111);
        r22.put("recommend_from", r69.g);
        UserCreationTrackParams r3 = r70.n;
        if (r3 == null) goto L55;
        String r5 = r3.a;
    L56:
        r22.put("template_rec_req_id", r5);
        r22.put("template_rec_extra", r70.i);
        r22.put("from_template_id", r70.a);
        boolean r0 = r15.v();
        r22.put("tpl_tag_type", r70.q(r0));
        r22.put("tpl_button_type", sq9.q.a(r69.l, r70, r0, r69.m));
        Unit r1 = Unit.INSTANCE;
        r21[1] = TuplesKt.to("creation_template", r22.toString());
        Map r30 = MapsKt.mapOf(r21);
        Bundle r2 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("actionbar_instruction_send_message_track_ext_map", o(r69, r70)), TuplesKt.to("actionbar_instruction_default_params", r73), TuplesKt.to("image_second_edit_scene", "generated_img_edit")});
        E(r2, r69);
        r15.W(new ny9.b(r36, r26, r14, r41, r9, r62, null, r63, r60, null, r61, null, null, 4, null, null, null, r76, null, false, false, r20, null, r2, false, r30, r64, r65, r33, r34, false, r18, Boolean.valueOf(r13), Boolean.valueOf(r31), Boolean.valueOf(r32), Boolean.valueOf(r10), r19, null, null, null, null, null, r69.x, r69.y, null, null, null, com.larus.uaigc.service.a.a(r70), null, false, 1096669760, 226272));
        return;
    L55:
        r5 = null;
        goto L56
    L51:
        r111 = null;
        goto L52
    L47:
        r62 = false;
        goto L48
    L43:
        r61 = new ArrayList();
        goto L44
    L37:
        if (r76.length() == 0) goto L40;
        r16 = false;
        goto L41
    L34:
        r60 = null;
        goto L35
    L28:
        if (r76.length() == 0) goto L31;
        r11 = false;
        goto L32
    L23:
        if (Intrinsics.areEqual(r69.l, DoSameQuickMenuType.USE_PICTURE) == true) goto L25;
        r13 = true;
    L19:
        r36 = true;
        goto L20
    L81:
        return;
    L58:
        FLogger r112 = FLogger.a;
        StringBuilder r113 = new StringBuilder("template is ");
        r113.append(r73);
        r113.append(" prompt is ");
        UserCreationContent r23 = r70.e;
        if (r23 == null) goto L63;
        UserCreationImage r24 = r23.a;
        if (r24 == null) goto L63;
        String r25 = r24.c;
    L64:
        r113.append(r25);
        r112.i("CreationDoSameAbility", r113.toString());
        com.bytedance.router.i r27 = SmartRouter.buildRoute(this.a.getContext(), "//flow/chat_page");
        r27.c.putExtras(r74);
        Pair[] r28 = new Pair[5];
        r28[0] = TuplesKt.to("actionbar_instruction_type", 4);
        UserCreationContent r114 = r70.e;
        if (r114 == null) goto L69;
        UserCreationImage r115 = r114.a;
        if (r115 == null) goto L69;
        String r116 = r115.c;
    L70:
        r28[1] = TuplesKt.to("actionbar_instruction_prompt", r116);
        r28[2] = TuplesKt.to("actionbar_creation_type", "pic");
        JSONObject r117 = new JSONObject();
        UserCreation r118 = r69.d;
        if (r118 == null) goto L73;
        String r119 = r118.a;
    L74:
        r117.put("id", r119);
        r117.put("recommend_from", r69.g);
        UserCreationTrackParams r29 = r70.n;
        if (r29 == null) goto L77;
        String r35 = r29.a;
    L78:
        r117.put("template_rec_req_id", r35);
        r117.put("template_rec_extra", r70.i);
        r117.put("from_template_id", r70.a);
        boolean r37 = IUgcAIGCService.a.v();
        r117.put("tpl_tag_type", r70.q(r37));
        r117.put("tpl_button_type", sq9.q.a(r69.l, r70, r37, r69.m));
        Unit r38 = Unit.INSTANCE;
        r28[3] = TuplesKt.to("actionbar_instruction_message_ext_map", new ICoreInputAbility.MessageExtMap(MapsKt.mapOf(TuplesKt.to("creation_template", r117.toString()))));
        r28[4] = TuplesKt.to("actionbar_instruction_send_message_track_ext_map", o(r69, r70));
        r27.c.putExtras(com.larus.utils.f.c(r28));
        r27.d = 2130772401;
        r27.e = 2130772399;
        r27.d();
        return;
    L77:
        r35 = null;
        goto L78
    L73:
        r119 = null;
    L69:
        r116 = null;
    L63:
        r25 = null;
    L9:
        r7 = false;
        goto L11
    }

    public final void y(sq9.p r64, UserCreation r65, String r66, String r67, String r68, Bundle r69, String r70, String r71) {
        Pair<com.larus.bmhome.actionbar.model.z0, Boolean> r4 = q(r66, ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(18));
        com.larus.bmhome.actionbar.model.z0 r15 = (com.larus.bmhome.actionbar.model.z0) r4.getFirst();
        boolean r32 = ((Boolean) r4.getSecond()).booleanValue();
        if (r15 == null) goto L9;
        com.larus.bmhome.actionbar.model.r r6 = r15.q;
        if (r6 == null) goto L9;
        if (r6.f() != true) goto L9;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L66;
        FragmentActivity r21 = this.a.getActivity();
        if (r21 == null) goto L88;
        CustomInputInitData r33 = s.a(r65);
        boolean r8 = t(r15);
        String r12 = k(r65, r64);
        boolean r25 = v(r65, r64);
        boolean r29 = u(r15, r71, r12);
        List r23 = l(r65, r64);
        IUgcAIGCService.Companion r16 = IUgcAIGCService.a;
        if (r8 == true) goto L19;
        if (r33 != null) goto L19;
        boolean r35 = false;
    L20:
        boolean r39 = !r64.k;
        ChatParam r40 = new ChatParam(r70, r66, null, null, null, 252);
        boolean r9 = r64.k;
        if (r71 != null) goto L23;
    L26:
        boolean r10 = true;
    L27:
        if (r10 == false) goto L29;
        List r61 = r23;
    L30:
        if (r71 != null) goto L32;
    L35:
        boolean r11 = true;
    L36:
        if (r11 == false) goto L38;
        String r13 = r12;
    L39:
        Boolean r14 = r64.j;
        if (r33 == null) goto L42;
        boolean r17 = true;
    L43:
        UserCreationContent r18 = r65.e;
        if (r18 == null) goto L48;
        VideoUserContent r19 = r18.e;
        if (r19 == null) goto L48;
        String r62 = r19.d;
    L49:
        String r20 = r64.b;
        c r22 = new c(r67, r64, r65);
        Pair[] r110 = new Pair[1];
        JSONObject r111 = new JSONObject();
        UserCreation r24 = r64.d;
        if (r24 == null) goto L52;
        String r26 = r24.a;
    L53:
        r111.put("id", r26);
        r111.put("recommend_from", r64.g);
        UserCreationTrackParams r5 = r65.n;
        if (r5 == null) goto L56;
        String r27 = r5.a;
    L57:
        r111.put("template_rec_req_id", r27);
        r111.put("template_rec_extra", r65.i);
        r111.put("from_template_id", r65.a);
        Unit r28 = Unit.INSTANCE;
        r110[0] = TuplesKt.to("creation_template", r111.toString());
        Map r30 = MapsKt.mutableMapOf(r110);
        UserCreationContent r31 = r65.e;
        if (r31 == null) goto L62;
        VideoUserContent r34 = r31.e;
        if (r34 == null) goto L62;
        String r36 = r34.h;
    L63:
        if (r36 == null) goto L65;
        r30.put("internal_resources", r36);
    L65:
        Bundle r3 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("actionbar_instruction_send_message_track_ext_map", o(r64, r65)), TuplesKt.to("actionbar_instruction_default_params", r68), TuplesKt.to("image_second_edit_scene", "generated_img_edit")});
        E(r3, r64);
        r16.W(new ny9.b(r35, r21, r15, r40, r9, r17, null, r62, r13, null, r61, null, null, 18, null, null, null, r71, null, false, false, r22, null, r3, false, r30, r64.t, r64.u, r32, r33, false, r14, Boolean.TRUE, Boolean.valueOf(r25), Boolean.valueOf(r29), Boolean.valueOf(r39), r20, null, null, null, null, null, r64.x, r64.y, null, null, null, com.larus.uaigc.service.a.a(r65), null, false, 1096669760, 226272));
        return;
    L62:
        r36 = null;
        goto L63
    L56:
        r27 = null;
        goto L57
    L52:
        r26 = null;
    L48:
        r62 = null;
        goto L49
    L42:
        r17 = false;
        goto L43
    L38:
        r13 = null;
        goto L39
    L32:
        if (r71.length() == 0) goto L35;
        r11 = false;
        goto L36
    L29:
        r61 = new ArrayList();
        goto L30
    L23:
        if (r71.length() == 0) goto L26;
        r10 = false;
    L19:
        r35 = true;
        goto L20
    L88:
        return;
    L66:
        FLogger r112 = FLogger.a;
        StringBuilder r113 = new StringBuilder("template is ");
        r113.append(r68);
        r113.append(" prompt is ");
        UserCreationContent r37 = r65.e;
        if (r37 == null) goto L71;
        UserCreationImage r38 = r37.a;
        if (r38 == null) goto L71;
        String r41 = r38.c;
    L72:
        r113.append(r41);
        r112.i("CreationDoSameAbility", r113.toString());
        com.bytedance.router.i r42 = SmartRouter.buildRoute(this.a.getContext(), "//flow/chat_page");
        r42.c.putExtras(r69);
        Pair[] r114 = new Pair[5];
        r114[0] = TuplesKt.to("actionbar_instruction_type", 4);
        UserCreationContent r115 = r65.e;
        if (r115 == null) goto L77;
        UserCreationImage r116 = r115.a;
        if (r116 == null) goto L77;
        String r117 = r116.c;
    L78:
        r114[1] = TuplesKt.to("actionbar_instruction_prompt", r117);
        r114[2] = TuplesKt.to("actionbar_creation_type", "pic");
        JSONObject r118 = new JSONObject();
        UserCreation r119 = r64.d;
        if (r119 == null) goto L81;
        String r120 = r119.a;
    L82:
        r118.put("id", r120);
        r118.put("recommend_from", r64.g);
        UserCreationTrackParams r43 = r65.n;
        if (r43 == null) goto L85;
        String r44 = r43.a;
    L86:
        r118.put("template_rec_req_id", r44);
        r118.put("template_rec_extra", r65.i);
        r118.put("from_template_id", r65.a);
        boolean r45 = IUgcAIGCService.a.v();
        r118.put("tpl_tag_type", r65.q(r45));
        r118.put("tpl_button_type", sq9.q.a(r64.l, r65, r45, r64.m));
        Unit r46 = Unit.INSTANCE;
        r114[3] = TuplesKt.to("actionbar_instruction_message_ext_map", new ICoreInputAbility.MessageExtMap(MapsKt.mapOf(TuplesKt.to("creation_template", r118.toString()))));
        r114[4] = TuplesKt.to("actionbar_instruction_send_message_track_ext_map", o(r64, r65));
        r42.c.putExtras(com.larus.utils.f.c(r114));
        r42.d = 2130772401;
        r42.e = 2130772399;
        r42.d();
        return;
    L85:
        r44 = null;
        goto L86
    L81:
        r120 = null;
    L77:
        r117 = null;
    L71:
        r41 = null;
    L9:
        r7 = false;
        goto L11
    }
}
