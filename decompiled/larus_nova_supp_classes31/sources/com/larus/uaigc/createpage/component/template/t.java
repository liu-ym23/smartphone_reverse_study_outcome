package com.larus.uaigc.createpage.component.template;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.creative.utils.ImageTemplateChooseViewModel;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.OptionItem;
import com.larus.platform.api.creation.Resource;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.platform.service.z2;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.uaigc.service.ICreationAvatarService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.u3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t implements zp9.m {
    public final /* synthetic */ TemplateFeedComponent a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ChatParam c;

    @Override // zp9.m
    public final boolean e() {
        return true;
    }

    @Override // zp9.m
    public final boolean g() {
        return false;
    }

    @Override // zp9.m
    public final boolean b(UserCreation r7) {
        Intrinsics.checkNotNullParameter(r7, "userCreation");
        TemplateFeedComponent r1 = this.a;
        int r2 = TemplateFeedComponent.I;
        r1.m3();
        ry9.h r3 = (ry9.h) this.a.A.getValue();
        if (r3 == null) goto L5;
        r3.QA(new ry9.b());
    L5:
        ICoreInputAbility r4 = this.a.B3();
        if (r4 == null) goto L9;
        r4.p80(true);
    L9:
        if (TemplateFeedComponent.h3(this.a, r7, this.b, z2.a.R2(), false) == false) goto L11;
        return true;
    L11:
        Intrinsics.checkNotNullParameter(r7, "userCreation");
        return false;
    }

    @Override // zp9.m
    public final void c(TabItemInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "tabItemInfo");
        this.a.r = r3;
        Intrinsics.checkNotNullParameter(r3, "tabItemInfo");
    }

    @Override // zp9.m
    public final void d(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    @Override // zp9.m
    public final void i(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    @Override // zp9.m
    public final void f(UserCreationModel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "userCreationModel");
    }

    public t(TemplateFeedComponent r1, int r2, ChatParam r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // zp9.m
    public final void h(UserCreationModel r1, l0 r2, View r3) {
        zp9.m.a.b(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zp9.m
    public final boolean a(UserCreation r74, int r75, String r76, String r77, @DoSameQuickMenuType String r78) {
        Intrinsics.checkNotNullParameter(r74, "userCreation");
        if (r74.b() == false) goto L5;
        return false;
    L5:
        TemplateFeedComponent r15 = this.a;
        int r2 = TemplateFeedComponent.I;
        r15.getClass();
        if (z2.a.getCreationMakeSameConfigV2().a() == true) goto L8;
    L207:
        ny9.s r1 = r15.z3();
        if (r1 == null) goto L210;
        ChatParam r3 = r1.c();
    L212:
        if (r3 == null) goto L214;
        String r11 = r3.b;
    L215:
        if (r11 != null) goto L217;
        String r31 = "";
    L218:
        if (r3 == null) goto L220;
        String r4 = r3.a;
    L221:
        if (r4 != null) goto L223;
        String r32 = "";
    L224:
        boolean r33 = true;
        sq9.p r8 = new sq9.p(null, "ai_generate_feed", "use_template", r74, "action_bar_template", null, null, r31, r32, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 33554017);
        sq9.t r5 = r15.p;
        if (r5 == null) goto L227;
        String r6 = null;
        r5.a(r8, null);
    L228:
        ChatParam r7 = this.c;
        if (r7 == null) goto L231;
        String r14 = r7.b;
    L232:
        if (r14 != null) goto L234;
        String r36 = "";
    L235:
        if (r76 != null) goto L237;
        String r38 = r6;
    L245:
        String r37 = String.valueOf(r74.a);
        ChatParam r9 = this.c;
        if (r9 == null) goto L248;
        String r16 = r9.e;
    L249:
        if (r16 != null) goto L251;
        String r39 = "";
    L252:
        String r41 = zp9.d.c(r74);
        this.a.getClass();
        AuthorInfo r10 = r74.g;
        if (r10 == null) goto L255;
        String r43 = r10.b;
    L256:
        String r42 = zp9.d.b(r74);
        int r12 = r75 + 1;
        UserCreationTrackParams r13 = r74.n;
        if (r13 == null) goto L259;
        Integer r45 = r13.b;
    L260:
        if (r13 == null) goto L262;
        String r46 = r13.a;
    L263:
        if (r13 == null) goto L265;
        String r48 = r13.d;
    L266:
        if (r13 == null) goto L268;
        String r50 = r13.e;
    L269:
        if (r13 == null) goto L271;
        String r49 = r13.f;
    L272:
        String r17 = r74.i;
        String r57 = zp9.d.c(r74);
        boolean r18 = r74.z();
        boolean r19 = r74.D();
        UserCreationRefContent r20 = r74.o;
        if (r20 == null) goto L277;
        List<ImageInfo> r21 = r20.a();
        if (r21 == null) goto L277;
        Integer r59 = Integer.valueOf(r21.size());
    L278:
        ny9.s r22 = this.a.z3();
        if (r22 == null) goto L284;
        Bundle r23 = r22.a;
        if (r23 == null) goto L284;
        String r24 = r23.getString("enter_method");
        if (r24 == null) goto L284;
    L285:
        String r64 = zp9.d.a(r74, false);
        String r63 = zp9.d.e(r74);
        boolean r25 = ICreationAvatarService.a.v();
        u3.l(r36, r37, r38, r39, "mix", r41, r42, r43, Integer.valueOf(r12), r45, r46, Integer.valueOf(this.b), r48, r49, r50, "action_bar_template", "template_page", null, null, null, r17, r57, Boolean.valueOf(r19), r59, Boolean.valueOf(r18), r24, null, r63, r64, Boolean.valueOf(r25), null, null, null, null, null, 272105856, 31);
        return r33;
    L284:
        r24 = "chat_action_bar";
    L277:
        r59 = r6;
        goto L278
    L271:
        r49 = r6;
        goto L272
    L268:
        r50 = r6;
        goto L269
    L265:
        r48 = r6;
        goto L266
    L262:
        r46 = r6;
        goto L263
    L259:
        r45 = r6;
        goto L260
    L255:
        r43 = r6;
        goto L256
    L251:
        r39 = r16;
        goto L252
    L248:
        r16 = r6;
        goto L249
    L237:
        if (r76.length() != 0) goto L239;
        boolean r26 = true;
    L240:
        if (r26 == false) goto L242;
        String r27 = "template_list";
    L243:
        r38 = r27;
        goto L245
    L242:
        r27 = r76;
        goto L243
    L239:
        r26 = false;
        goto L240
    L234:
        r36 = r14;
        goto L235
    L231:
        r14 = r6;
        goto L232
    L227:
        r6 = null;
        goto L228
    L223:
        r32 = r4;
        goto L224
    L220:
        r4 = null;
        goto L221
    L217:
        r31 = r11;
        goto L218
    L214:
        r11 = null;
        goto L215
    L210:
        r3 = null;
        goto L212
    L8:
        if (Intrinsics.areEqual(r78, DoSameQuickMenuType.REPLACE_PIC) == true) goto L207;
        CreationDynamicInfo r28 = r74.h;
        if (r28 == null) goto L21;
        TplInfo r29 = r28.e;
        if (r29 == null) goto L21;
        TplDetail r30 = r29.b;
        if (r30 == null) goto L21;
        Integer r34 = r30.d;
        if (r34 == null) goto L21;
        if (r34.intValue() != 1) goto L21;
        boolean r35 = true;
    L22:
        if (r35 == true) goto L207;
        ny9.s r40 = r15.z3();
        if (r40 == null) goto L26;
        ChatParam r44 = r40.c();
    L28:
        switch(r74.b) {
            case 2: goto L32;
            case 3: goto L29;
            case 4: goto L29;
            case 5: goto L32;
            case 6: goto L31;
            case 7: goto L30;
            case 8: goto L31;
            case 9: goto L30;
            case 10: goto L29;
            case 11: goto L30;
            case 12: goto L31;
            default: goto L29;
        };
    L29:
        String r47 = null;
        Integer r110 = null;
    L34:
        ArrayList r51 = new ArrayList();
        if (Intrinsics.areEqual(r78, DoSameQuickMenuType.USE_PICTURE) == false) goto L59;
        UserCreationRefContent r52 = r74.o;
        if (r52 == null) goto L76;
        List<Resource> r53 = r52.c;
        if (r53 == null) goto L76;
        Iterator<T> r54 = r53.iterator();
    L42:
        if (r54.hasNext() == false) goto L54;
        Object r55 = r54.next();
        Resource r56 = (Resource) r55;
        if (r56 == null) goto L51;
        Integer r58 = r56.a;
        if (r58 == null) goto L51;
        if (r58.intValue() != 1) goto L51;
        boolean r60 = true;
    L52:
        if (r60 == false) goto L42;
    L55:
        Resource r61 = (Resource) r55;
        if (r61 == null) goto L76;
        r51.add(new ResourceExt(r61, r74.e()));
    L51:
        r60 = false;
        goto L52
    L54:
        r55 = null;
    L76:
        if (r110 != null) goto L79;
    L87:
        Long r62 = null;
    L88:
        if (r62 == null) goto L94;
        long r65 = r62.longValue();
        ys8.a r66 = r15.C3();
        if (r66 == null) goto L93;
        ys8.b r67 = r66.Xx(r65);
        if (r67 == null) goto L93;
    L95:
        ys8.b r68 = r67;
        if ((r68 instanceof ys8.b.c) == false) goto L106;
        String r69 = ((ys8.b.c) r68).a;
        if (r69 != null) goto L100;
    L105:
        String r70 = null;
    L206:
        r6 = r70;
        r33 = true;
        goto L228
    L100:
        if ((!StringsKt.isBlank(r69)) == true) goto L103;
        r69 = null;
    L103:
        if (r69 == null) goto L105;
        t19.s r71 = t19.s.a;
        Application r72 = AppHost.a.getApplication();
        r71.getClass();
        t19.s.t(r72, r69);
        goto L105
    L106:
        if (r110 != null) goto L109;
    L132:
        r68 = r68;
        r51 = r51;
        r47 = r47;
    L133:
        if (r110 != null) goto L136;
    L148:
        int r73 = r74.b;
        if (r73 == 5) goto L157;
        if (r73 == 7) goto L157;
        if (r73 == 9) goto L157;
        if (r73 == 11) goto L157;
    L181:
        ys8.b r79 = r68;
        if (r110 == null) goto L205;
        int r80 = r110.intValue();
        if (r47 == null) goto L205;
        ry9.h r81 = (ry9.h) r15.A.getValue();
        if (r81 == null) goto L188;
        r81.QA(new ry9.b());
    L188:
        ys8.a r82 = r15.C3();
        if (r82 == null) goto L192;
        r82.b00(r80);
    L192:
        if ((r79 instanceof ys8.b.a) == false) goto L196;
        ys8.a r83 = r15.C3();
        if (r83 == null) goto L196;
        r83.GX(r80, ((ys8.b.a) r79).a);
    L196:
        ry9.h r84 = (ry9.h) r15.A.getValue();
        if (r84 == null) goto L199;
        r84.QA(new ry9.l(false, r51, TemplateFeedComponent.W3(r74)));
    L199:
        ICoreInputAbility r111 = r15.B3();
        if (r111 == null) goto L202;
        ICoreInputAbility.b.d(r111, r47, false, false, null, null, false, 62);
    L202:
        ICoreInputAbility r85 = r15.B3();
        if (r85 == null) goto L205;
        r70 = null;
        ICoreInputAbility.b.e(r85, "imageVideoMixDoSame", null, false, 6);
    L205:
        r70 = null;
    L157:
        if (z2.a.getCreationMakeSameConfig().a() == false) goto L181;
        if (r74.t() == true) goto L181;
        if (r110 == null) goto L205;
        int r86 = r110.intValue();
        if (r47 == null) goto L205;
        ICoreInputAbility r87 = r15.B3();
        if (r87 == null) goto L166;
        r87.p80(false);
    L166:
        r15.m3();
        ry9.h r88 = (ry9.h) r15.A.getValue();
        if (r88 == null) goto L169;
        r88.QA(new ry9.b());
    L169:
        ys8.b r89 = r68;
        if ((r89 instanceof ys8.b.a) == false) goto L177;
        ys8.a r90 = r15.C3();
        if (r90 == null) goto L174;
        r90.b00(r86);
    L174:
        ys8.a r91 = r15.C3();
        if (r91 == null) goto L177;
        r91.GX(r86, ((ys8.b.a) r89).a);
    L177:
        ry9.h r92 = (ry9.h) r15.A.getValue();
        if (r92 == null) goto L205;
        r92.xz(r47, r86, true);
        goto L205
    L136:
        if (r110.intValue() != 18) goto L148;
        UserCreationContent r93 = r74.e;
        if (r93 == null) goto L148;
        VideoUserContent r94 = r93.e;
        if (r94 == null) goto L148;
        OptionItem r95 = r94.e;
        if (r95 == null) goto L148;
        Long r96 = r95.a;
        if (r96 == null) goto L148;
        long r97 = r96.longValue();
        ys8.a r98 = r15.C3();
        if (r98 == null) goto L148;
        r98.selectRatio(18, r97);
        goto L148
    L109:
        if (r110.intValue() != 4) goto L132;
        Intrinsics.checkNotNullParameter(r15, "<this>");
        FragmentActivity r99 = com.larus.ui.arch.component.internal.attach.a.b(r15, r15).getActivity();
        if (r99 == null) goto L121;
        ImageTemplateChooseViewModel r100 = new ViewModelProvider(r99).get(ImageTemplateChooseViewModel.class);
        if (r44 == null) goto L115;
        String r101 = r44.a;
    L116:
        if (r101 != null) goto L118;
        String r102 = "";
    L119:
        r100.onImageTemplateChoose(new com.larus.bmhome.creative.utils.b(null, r102, true, r74, null, false, 33));
        goto L121
    L118:
        r102 = r101;
        goto L119
    L115:
        r101 = null;
    L121:
        UserCreationContent r103 = r74.e;
        if (r103 == null) goto L133;
        UserCreationImage r104 = r103.a;
        if (r104 == null) goto L133;
        OptionItem r105 = r104.d;
        if (r105 == null) goto L133;
        Long r106 = r105.a;
        if (r106 == null) goto L133;
        long r107 = r106.longValue();
        ys8.a r108 = r15.C3();
        if (r108 == null) goto L133;
        r108.selectRatio(4, r107);
    L93:
        r67 = new ys8.b.c(null);
        goto L95
    L94:
        r67 = ys8.b.b.a;
        goto L95
    L79:
        if (r110.intValue() != 18) goto L87;
        UserCreationContent r109 = r74.e;
        if (r109 == null) goto L87;
        VideoUserContent r112 = r109.e;
        if (r112 == null) goto L87;
        OptionItem r113 = r112.g;
        if (r113 == null) goto L87;
        r62 = r113.a;
        goto L88
    L59:
        if (TemplateFeedComponent.W3(r74) == false) goto L68;
        UserCreationRefContent r114 = r74.o;
        if (r114 == null) goto L65;
        List<Resource> r115 = r114.c;
        if (r115 == null) goto L65;
        List<ResourceExt> r116 = sq9.g.b(r115);
    L66:
        if (r116 == null) goto L76;
        r51.addAll(r116);
    L65:
        r116 = null;
        goto L66
    L68:
        UserCreationRefContent r117 = r74.o;
        if (r117 == null) goto L73;
        List<Resource> r118 = r117.c;
        if (r118 == null) goto L73;
        List<ResourceExt> r119 = sq9.g.a(r118);
    L74:
        if (r119 == null) goto L76;
        r51.addAll(r119);
    L73:
        r119 = null;
        goto L74
    L30:
        int r120 = 18;
        String r121 = TemplateFeedComponent.D3(r74, r78);
    L33:
        r110 = r120;
        r47 = r121;
        goto L34
    L31:
        r120 = 18;
        r121 = TemplateFeedComponent.D3(r74, r78);
        goto L33
    L32:
        r120 = 4;
        r121 = TemplateFeedComponent.D3(r74, r78);
        goto L33
    L26:
        r44 = null;
    L21:
        r35 = false;
        goto L22
    }
}
