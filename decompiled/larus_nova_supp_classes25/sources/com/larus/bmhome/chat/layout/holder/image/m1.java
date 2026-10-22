package com.larus.bmhome.chat.layout.holder.image;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.uaigc.utils.DataConverterKt;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m1 implements com.larus.bmhome.chat.layout.widget.i0 {
    public final /* synthetic */ ScrollImageViewHolder a;
    public final /* synthetic */ Pair<com.larus.bmhome.actionbar.model.z0, Boolean> b;
    public final /* synthetic */ m0 c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Pair<com.larus.bmhome.actionbar.model.z0, Boolean> e;
    public final /* synthetic */ boolean f;

    public static final class a implements zs8.a {
        public final /* synthetic */ BotModel a;
        public final /* synthetic */ boolean b;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String b() {
            return "chat";
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getClickFrom() {
            return "";
        }

        public final String getEnterMethod() {
            return "click_image_edit_button";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String getBotId() {
            if (this.b == false) goto L9;
            com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
            if (r0 == null) goto L21;
            LaunchInfo r1 = r0.a;
            if (r1 != null) goto L23;
            return null;
        L23:
            return r1.W();
        L21:
            return null;
        L9:
            BotModel r2 = this.a;
            if (r2 == null) goto L15;
            String r3 = r2.getBotId();
            if (r3 == null) goto L15;
            return r3;
        L15:
            com.larus.bmhome.chat.api.e0 r4 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
            if (r4 == null) goto L25;
            LaunchInfo r5 = r4.a;
            if (r5 != null) goto L20;
            return null;
        L20:
            return r5.W();
        L25:
            return null;
        }

        public final String getChatType() {
            BotModel r0 = this.a;
            if (r0 != null) goto L7;
            return "default";
        L7:
            return DataConverterKt.b(r0);
        }

        public a(BotModel r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements zs8.a {
        public final /* synthetic */ BotModel a;
        public final /* synthetic */ boolean b;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String b() {
            return "chat";
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getClickFrom() {
            return "";
        }

        public final String getEnterMethod() {
            return "ai_edit_picture_overview";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String getBotId() {
            if (this.b == false) goto L9;
            com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
            if (r0 == null) goto L21;
            LaunchInfo r1 = r0.a;
            if (r1 != null) goto L23;
            return null;
        L23:
            return r1.W();
        L21:
            return null;
        L9:
            BotModel r2 = this.a;
            if (r2 == null) goto L15;
            String r3 = r2.getBotId();
            if (r3 == null) goto L15;
            return r3;
        L15:
            com.larus.bmhome.chat.api.e0 r4 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
            if (r4 == null) goto L25;
            LaunchInfo r5 = r4.a;
            if (r5 != null) goto L20;
            return null;
        L20:
            return r5.W();
        L25:
            return null;
        }

        public final String getChatType() {
            BotModel r0 = this.a;
            if (r0 != null) goto L7;
            return "default";
        L7:
            return DataConverterKt.b(r0);
        }

        public b(BotModel r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.larus.bmhome.chat.layout.widget.i0
    public final void a() {
        Message r1 = this.a.k;
        if (r1 == null) goto L7;
        Map r2 = r1.getBusinessExt();
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("message_case_mode");
    L9:
        if (Intrinsics.areEqual(r3, "1") == false) goto L15;
        t19.s r4 = t19.s.a;
        AppHost.Companion r5 = AppHost.a;
        Application r6 = r5.getApplication();
        String r7 = r5.getApplication().getString(2131909395);
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        r4.getClass();
        t19.s.t(r6, r7);
        return;
    L15:
        com.larus.bmhome.chat.api.q0 r8 = this.a.i;
        if (r8 == null) goto L23;
        com.larus.bmhome.chat.api.n0 r9 = r8.M7();
        if (r9 == null) goto L23;
        com.larus.bmhome.chat.component.cvs.y r10 = (com.larus.bmhome.chat.component.cvs.y) r9.invoke();
        if (r10 == null) goto L23;
        BotModel r11 = r10.j0();
        if (r11 == null) goto L23;
    L24:
        AppHost.Companion r12 = AppHost.a;
        Activity r13 = r12.a().getCurrentActivity();
        if (r13 == null) goto L60;
        Pair<com.larus.bmhome.actionbar.model.z0, Boolean> r14 = this.b;
        ScrollImageViewHolder r15 = this.a;
        boolean r16 = this.d;
        m0 r17 = this.c;
        if (r14 == null) goto L60;
        com.larus.bmhome.actionbar.model.z0 r18 = (com.larus.bmhome.actionbar.model.z0) r14.getFirst();
        if (r18 == null) goto L60;
        ICreationWorkflowService.Companion r19 = ICreationWorkflowService.a;
        ChatParam r20 = ScrollImageViewHolder.T3(r15, r16, r11);
        if (r17 == null) goto L35;
        ImageItem r110 = r17.b;
        if (r110 == null) goto L35;
        String r111 = df8.b.a(r110);
    L36:
        if (r17 == null) goto L42;
        ImageItem r21 = r17.b;
        if (r21 == null) goto L42;
        ImageEntity r22 = r21.getRawImage();
        if (r22 == null) goto L42;
        String r112 = r22.getUrl();
    L43:
        Bundle r29 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("image_second_edit_scene", "generated_img_edit")});
        com.larus.bmhome.chat.api.q0 r23 = r15.i;
        if (r23 == null) goto L52;
        Function0<Fragment> r24 = r23.getHostFragment();
        if (r24 == null) goto L52;
        Fragment r25 = (Fragment) r24.invoke();
        if (r25 == null) goto L52;
        t1a.b r26 = s1a.a.g(r25);
        if (r26 == null) goto L52;
        ChatPageContext r50 = (ChatPageContext) r26.a(ChatPageContext.class);
    L53:
        a r113 = new a(r11, r16);
        com.larus.bmhome.chat.api.q0 r27 = r15.i;
        if (r27 == null) goto L58;
        Function0<Fragment> r28 = r27.getHostFragment();
        if (r28 == null) goto L58;
        Fragment r52 = (Fragment) r28.invoke();
    L59:
        r19.f0(new ny9.b(false, r13, r18, r20, r16, false, null, null, r111, r112, null, null, null, null, null, null, null, null, null, false, false, r113, null, r29, false, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, r50, null, r52, null, null, false, -10486559, 241663));
    L58:
        r52 = null;
    L52:
        r50 = null;
    L42:
        r112 = null;
    L35:
        r111 = null;
    L60:
        hy9.d r30 = ICreationReportService.a.j();
        String r31 = r12.getApplication().getString(2131906324);
        if (r11 == null) goto L63;
        String r114 = r11.getBotId();
    L64:
        Pair<com.larus.bmhome.actionbar.model.z0, Boolean> r32 = this.b;
        if (r32 == null) goto L73;
        com.larus.bmhome.actionbar.model.z0 r33 = (com.larus.bmhome.actionbar.model.z0) r32.getFirst();
        if (r33 == null) goto L73;
        com.larus.bmhome.actionbar.model.r r34 = r33.q;
        if (r34 == null) goto L73;
        Integer r35 = r34.a;
        if (r35 == null) goto L73;
        String r115 = r35.toString();
    L74:
        Pair<com.larus.bmhome.actionbar.model.z0, Boolean> r36 = this.b;
        if (r36 == null) goto L81;
        com.larus.bmhome.actionbar.model.z0 r37 = (com.larus.bmhome.actionbar.model.z0) r36.getFirst();
        if (r37 == null) goto L81;
        com.larus.bmhome.actionbar.model.r r38 = r37.q;
        if (r38 == null) goto L81;
        String r116 = r38.g;
    L82:
        ChatControlTrace r39 = ChatControlTrace.b;
        r39.getClass();
        String r117 = r39.bb(ChatControlTrace.y);
        Message r40 = this.a.k;
        if (r40 == null) goto L85;
        Boolean r118 = Boolean.valueOf(com.larus.im.bean.message.a.C0(r40));
    L86:
        Message r41 = this.a.k;
        if (r41 == null) goto L89;
        String r119 = tz9.a.a(r41);
    L90:
        m0 r42 = this.c;
        if (r42 == null) goto L93;
        String r210 = r42.e;
    L94:
        hy9.d.a.a(r30, r31, null, null, "picture_overview", "edit_entrance", r114, null, r115, r116, r117, r118, r119, null, null, null, null, null, r210, null, null, null, 4059206);
        return;
    L93:
        r210 = null;
        goto L94
    L89:
        r119 = null;
        goto L90
    L85:
        r118 = null;
    L81:
        r116 = null;
    L73:
        r115 = null;
        goto L74
    L63:
        r114 = null;
    L23:
        r11 = this.a.h;
    L7:
        r3 = null;
        goto L9
    }

    @Override // com.larus.bmhome.chat.layout.widget.i0
    public final void b() {
        com.larus.bmhome.chat.api.q0 r1 = this.a.i;
        if (r1 == null) goto L10;
        com.larus.bmhome.chat.api.n0 r2 = r1.M7();
        if (r2 == null) goto L10;
        com.larus.bmhome.chat.component.cvs.y r3 = (com.larus.bmhome.chat.component.cvs.y) r2.invoke();
        if (r3 == null) goto L10;
        BotModel r4 = r3.j0();
        if (r4 == null) goto L10;
    L11:
        AppHost.Companion r5 = AppHost.a;
        Activity r6 = r5.a().getCurrentActivity();
        if (r6 == null) goto L76;
        Pair<com.larus.bmhome.actionbar.model.z0, Boolean> r7 = this.e;
        ScrollImageViewHolder r13 = this.a;
        m0 r9 = this.c;
        boolean r8 = this.f;
        if (r7 == null) goto L41;
        com.larus.bmhome.actionbar.model.z0 r10 = (com.larus.bmhome.actionbar.model.z0) r7.getFirst();
        if (r10 == null) goto L41;
        ICreationWorkflowService.Companion r15 = ICreationWorkflowService.a;
        ChatParam r26 = ScrollImageViewHolder.T3(r13, r8, r4);
        if (r9 == null) goto L22;
        ImageItem r11 = r9.b;
        if (r11 == null) goto L22;
        String r28 = df8.b.a(r11);
    L23:
        Bundle r49 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("image_second_edit_scene", "generated_img_edit")});
        com.larus.bmhome.chat.api.q0 r12 = r13.i;
        if (r12 == null) goto L32;
        Function0<Fragment> r14 = r12.getHostFragment();
        if (r14 == null) goto L32;
        Fragment r16 = (Fragment) r14.invoke();
        if (r16 == null) goto L32;
        t1a.b r17 = s1a.a.g(r16);
        if (r17 == null) goto L32;
        ChatPageContext r51 = (ChatPageContext) r17.a(ChatPageContext.class);
    L33:
        b r18 = new b(r4, r8);
        com.larus.bmhome.chat.api.q0 r19 = r13.i;
        if (r19 == null) goto L38;
        Function0<Fragment> r20 = r19.getHostFragment();
        if (r20 == null) goto L38;
        Fragment r58 = (Fragment) r20.invoke();
    L39:
        r15.f0(new ny9.b(false, r6, r10, r26, r8, false, null, null, r28, null, null, null, null, null, null, null, null, null, null, false, false, r18, null, r49, false, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, r51, null, r58, null, null, false, -10486047, 241663));
    L38:
        r58 = null;
    L32:
        r51 = null;
    L22:
        r28 = null;
    L41:
        hy9.d r21 = ICreationReportService.a.j();
        String r22 = r5.getApplication().getString(2131906331);
        if (r4 == null) goto L44;
        String r110 = r4.getBotId();
    L46:
        if (r7 == null) goto L54;
        com.larus.bmhome.actionbar.model.z0 r23 = (com.larus.bmhome.actionbar.model.z0) r7.getFirst();
        if (r23 == null) goto L54;
        com.larus.bmhome.actionbar.model.r r24 = r23.q;
        if (r24 == null) goto L54;
        Integer r25 = r24.a;
        if (r25 == null) goto L54;
        String r111 = r25.toString();
    L55:
        if (r7 == null) goto L61;
        com.larus.bmhome.actionbar.model.z0 r27 = (com.larus.bmhome.actionbar.model.z0) r7.getFirst();
        if (r27 == null) goto L61;
        com.larus.bmhome.actionbar.model.r r29 = r27.q;
        if (r29 == null) goto L61;
        String r112 = r29.g;
    L62:
        ChatControlTrace r30 = ChatControlTrace.b;
        r30.getClass();
        String r113 = r30.bb(ChatControlTrace.y);
        Message r31 = r13.k;
        if (r31 == null) goto L65;
        Boolean r114 = Boolean.valueOf(com.larus.im.bean.message.a.C0(r31));
    L66:
        Message r32 = r13.k;
        if (r32 == null) goto L69;
        String r115 = tz9.a.a(r32);
    L71:
        if (r9 == null) goto L73;
        String r210 = r9.e;
    L74:
        hy9.d.a.a(r21, r22, null, null, "picture_overview", "single_function", r110, null, r111, r112, r113, r114, r115, null, null, null, null, null, r210, null, null, null, 4059206);
        return;
    L73:
        r210 = null;
        goto L74
    L69:
        r115 = null;
        goto L71
    L65:
        r114 = null;
    L61:
        r112 = null;
    L54:
        r111 = null;
        goto L55
    L44:
        r110 = null;
        goto L46
    L76:
        return;
    L10:
        r4 = this.a.h;
        goto L11
    }

    public m1(ScrollImageViewHolder r1, Pair<com.larus.bmhome.actionbar.model.z0, Boolean> r2, m0 r3, boolean r4, Pair<com.larus.bmhome.actionbar.model.z0, Boolean> r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
