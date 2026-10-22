package com.larus.uaigc.createpage.component.template;

import android.os.Bundle;
import android.view.View;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.platform.service.z2;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.uaigc.service.ICreationAvatarService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.u3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r implements zp9.m {
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
    public final boolean b(UserCreation r6) {
        Intrinsics.checkNotNullParameter(r6, "userCreation");
        if (TemplateFeedComponent.h3(this.a, r6, this.b, z2.a.H(), false) == false) goto L6;
        return true;
    L6:
        Intrinsics.checkNotNullParameter(r6, "userCreation");
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

    public r(TemplateFeedComponent r1, int r2, ChatParam r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // zp9.m
    public final void h(UserCreationModel r1, l0 r2, View r3) {
        zp9.m.a.b(r1, r2);
    }

    @Override // zp9.m
    public final boolean a(UserCreation r54, int r55, String r56, String r57, @DoSameQuickMenuType String r58) {
        Intrinsics.checkNotNullParameter(r54, "userCreation");
        TemplateFeedComponent r1 = this.a;
        int r2 = TemplateFeedComponent.I;
        ny9.u r3 = r1.E3();
        if (r3 == null) goto L7;
        Bundle r4 = r3.c;
        if (r4 == null) goto L7;
        r4.putString("ai_creation_recommend_from", "action_bar_template");
    L7:
        this.a.e4(r54, r58);
        oy9.a r11 = (oy9.a) this.a.B.getValue();
        String r14 = "template_list";
        Integer r15 = null;
        if (r11 == null) goto L51;
        String r5 = r54.a;
        if (r5 == null) goto L14;
        Long r6 = StringsKt.toLongOrNull(r5);
        if (r6 == null) goto L14;
        long r7 = r6.longValue();
    L15:
        UserCreationContent r8 = r54.e;
        if (r8 == null) goto L20;
        UserCreationUserAvatar r9 = r8.c;
        if (r9 == null) goto L20;
        String r10 = r9.c;
    L21:
        if (r8 == null) goto L29;
        UserCreationUserAvatar r12 = r8.c;
        if (r12 == null) goto L29;
        ImageInfo r13 = r12.a;
        if (r13 == null) goto L29;
        Image r16 = r13.b;
        if (r16 == null) goto L29;
        g1 r17 = gy9.d.a(r16);
    L30:
        UserCreationContent r18 = r54.e;
        if (r18 == null) goto L39;
        UserCreationUserAvatar r19 = r18.c;
        if (r19 == null) goto L39;
        ImageInfo r20 = r19.a;
        if (r20 == null) goto L39;
        Image r21 = r20.a;
        if (r21 == null) goto L39;
        g1 r22 = gy9.d.a(r21);
    L40:
        UserCreationContent r23 = r54.e;
        if (r23 == null) goto L49;
        UserCreationUserAvatar r24 = r23.c;
        if (r24 == null) goto L49;
        ImageInfo r25 = r24.a;
        if (r25 == null) goto L49;
        Image r26 = r25.c;
        if (r26 == null) goto L49;
        g1 r27 = gy9.d.a(r26);
    L50:
        r11.onDigitalAvatarTemplateChoose(new ab8.a(r7, r10, r17, r22, r27, r54), r55, "template_list");
    L49:
        r27 = null;
    L39:
        r22 = null;
    L29:
        r17 = null;
    L20:
        r10 = null;
    L14:
        r7 = 0;
    L51:
        ChatParam r28 = this.c;
        if (r28 == null) goto L54;
        String r29 = r28.b;
    L56:
        if (r29 != null) goto L58;
        String r110 = "";
    L60:
        if (r56 != null) goto L62;
        String r111 = null;
    L70:
        String r112 = String.valueOf(r54.a);
        ChatParam r30 = this.c;
        if (r30 == null) goto L73;
        String r31 = r30.e;
    L74:
        if (r31 != null) goto L76;
        String r113 = "";
    L77:
        String r210 = zp9.d.d(r54);
        String r211 = zp9.d.c(r54);
        AuthorInfo r32 = r54.g;
        if (r32 == null) goto L80;
        String r212 = r32.b;
    L81:
        String r213 = zp9.d.b(r54);
        int r33 = r55 + 1;
        UserCreationTrackParams r34 = r54.n;
        if (r34 == null) goto L84;
        Integer r214 = r34.b;
    L85:
        if (r34 == null) goto L87;
        String r215 = r34.a;
    L88:
        if (r34 == null) goto L90;
        String r216 = r34.d;
    L91:
        if (r34 == null) goto L93;
        String r35 = r34.e;
    L94:
        if (r34 == null) goto L96;
        String r217 = r34.f;
    L97:
        String r36 = r54.i;
        String r37 = zp9.d.c(r54);
        boolean r38 = r54.z();
        boolean r39 = r54.D();
        UserCreationRefContent r40 = r54.o;
        if (r40 == null) goto L102;
        List<ImageInfo> r41 = r40.a();
        if (r41 == null) goto L102;
        r15 = Integer.valueOf(r41.size());
    L102:
        Integer r310 = r15;
        ny9.s r42 = this.a.z3();
        if (r42 == null) goto L108;
        Bundle r43 = r42.a;
        if (r43 == null) goto L108;
        String r44 = r43.getString("enter_method");
        if (r44 == null) goto L108;
    L109:
        this.a.getClass();
        String r45 = zp9.d.a(r54, false);
        u3.l(r110, r112, r111, r113, r210, r211, r213, r212, Integer.valueOf(r33), r214, r215, Integer.valueOf(this.b), r216, r217, r35, "action_bar_template", "template_page", null, null, null, r36, r37, Boolean.valueOf(r39), r310, Boolean.valueOf(r38), r44, null, zp9.d.e(r54), r45, Boolean.valueOf(ICreationAvatarService.a.v()), null, null, null, null, null, 272105856, 31);
        String r46 = r54.a;
        if (r46 == null) goto L114;
        Long r47 = StringsKt.toLongOrNull(r46);
        if (r47 == null) goto L114;
        long r114 = r47.longValue();
    L115:
        com.larus.uaigc.template.p.a(r114);
        return true;
    L114:
        r114 = 0;
    L108:
        r44 = "chat_action_bar";
        goto L109
    L96:
        r217 = null;
        goto L97
    L93:
        r35 = null;
        goto L94
    L90:
        r216 = null;
        goto L91
    L87:
        r215 = null;
        goto L88
    L84:
        r214 = null;
        goto L85
    L80:
        r212 = null;
        goto L81
    L76:
        r113 = r31;
        goto L77
    L73:
        r31 = null;
        goto L74
    L62:
        if (r56.length() != 0) goto L64;
        boolean r48 = true;
    L65:
        if (r48 == true) goto L68;
        r14 = r56;
    L68:
        r111 = r14;
        goto L70
    L64:
        r48 = false;
        goto L65
    L58:
        r110 = r29;
        goto L60
    L54:
        r29 = null;
        goto L56
    }
}
