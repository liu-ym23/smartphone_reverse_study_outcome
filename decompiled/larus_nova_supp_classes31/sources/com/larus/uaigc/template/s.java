package com.larus.uaigc.template;

import android.net.Uri;
import android.view.View;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.OptionItem;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateImage;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateType;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.uaigc.service.ICreationAvatarService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.u3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s implements zp9.m {
    public final /* synthetic */ ImageTemplateListDialogFragment a;

    @Override // zp9.m
    public final boolean e() {
        return true;
    }

    @Override // zp9.m
    public final boolean g() {
        return false;
    }

    public s(ImageTemplateListDialogFragment r1) {
        this.a = r1;
    }

    @Override // zp9.m
    public final boolean b(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        return false;
    }

    @Override // zp9.m
    public final void c(TabItemInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "tabItemInfo");
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

    @Override // zp9.m
    public final void h(UserCreationModel r1, l0 r2, View r3) {
        zp9.m.a.b(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zp9.m
    public final boolean a(UserCreation r64, int r65, String r66, String r67, @DoSameQuickMenuType String r68) {
        Intrinsics.checkNotNullParameter(r64, "userCreation");
        if (r64.b() == false) goto L5;
        return false;
    L5:
        Function3<? super TemplateInfo$TemplateInfo, ? super String, ? super Uri, Unit> r15 = this.a.d;
        long r17 = 0;
        if (r15 == null) goto L75;
        String r2 = r64.a;
        if (r2 == null) goto L12;
        Long r3 = StringsKt.toLongOrNull(r2);
        if (r3 == null) goto L12;
        long r4 = r3.longValue();
    L13:
        UserCreationContent r5 = r64.e;
        if (r5 == null) goto L18;
        UserCreationImage r6 = r5.a;
        if (r6 == null) goto L18;
        String r7 = r6.c;
    L19:
        TemplateInfo$TemplateType r8 = TemplateInfo$TemplateType.AI_ARTIST;
        if (r5 == null) goto L28;
        UserCreationImage r9 = r5.a;
        if (r9 == null) goto L28;
        ImageInfo r10 = r9.a;
        if (r10 == null) goto L28;
        Image r11 = r10.b;
        if (r11 == null) goto L28;
        TemplateInfo$TemplateImage r12 = io8.a.a(r11);
    L29:
        UserCreationContent r13 = r64.e;
        if (r13 == null) goto L38;
        UserCreationImage r14 = r13.a;
        if (r14 == null) goto L38;
        ImageInfo r16 = r14.a;
        if (r16 == null) goto L38;
        Image r18 = r16.a;
        if (r18 == null) goto L38;
        TemplateInfo$TemplateImage r19 = io8.a.a(r18);
    L39:
        UserCreationContent r20 = r64.e;
        if (r20 == null) goto L48;
        UserCreationImage r21 = r20.a;
        if (r21 == null) goto L48;
        ImageInfo r22 = r21.a;
        if (r22 == null) goto L48;
        Image r23 = r22.c;
        if (r23 == null) goto L48;
        TemplateInfo$TemplateImage r24 = io8.a.a(r23);
    L49:
        UserCreationContent r25 = r64.e;
        long r110 = -1;
        if (r25 == null) goto L58;
        UserCreationImage r26 = r25.a;
        if (r26 == null) goto L58;
        OptionItem r27 = r26.d;
        if (r27 == null) goto L58;
        Long r28 = r27.a;
        if (r28 == null) goto L58;
        long r111 = r28.longValue();
    L59:
        UserCreationContent r29 = r64.e;
        if (r29 == null) goto L68;
        UserCreationImage r30 = r29.a;
        if (r30 == null) goto L68;
        OptionItem r31 = r30.e;
        if (r31 == null) goto L68;
        Long r32 = r31.a;
        if (r32 == null) goto L68;
        r110 = r32.longValue();
    L68:
        long r210 = r110;
        String r33 = r64.a;
        if (r33 == null) goto L73;
        Long r34 = StringsKt.toLongOrNull(r33);
        if (r34 == null) goto L73;
        long r211 = r34.longValue();
    L74:
        String r0 = null;
        r15.invoke(new TemplateInfo$TemplateInfo(r4, r8, r7, r12, r19, r24, r111, r210, r211, r64), this.a.h, null);
    L76:
        String r35 = this.a.e;
        if (r35 != null) goto L79;
        String r212 = "";
    L81:
        if (r66 != null) goto L83;
        String r36 = r0;
        String r213 = r36;
    L91:
        String r214 = String.valueOf(r64.a);
        String r37 = this.a.f;
        if (r37 != null) goto L94;
        String r215 = "";
    L95:
        String r38 = zp9.d.c(r64);
        AuthorInfo r39 = r64.g;
        if (r39 == null) goto L98;
        String r310 = r39.b;
    L99:
        String r311 = zp9.d.b(r64);
        int r40 = r65 + 1;
        UserCreationTrackParams r41 = r64.n;
        if (r41 == null) goto L102;
        Integer r312 = r41.b;
    L103:
        if (r41 == null) goto L105;
        String r313 = r41.a;
    L106:
        if (r41 == null) goto L108;
        String r314 = r41.d;
    L109:
        if (r41 == null) goto L111;
        String r42 = r41.e;
    L112:
        if (r41 == null) goto L114;
        String r315 = r41.f;
    L115:
        String r43 = r64.i;
        String r47 = zp9.d.c(r64);
        boolean r44 = r64.z();
        boolean r45 = r64.D();
        UserCreationRefContent r46 = r64.o;
        if (r46 == null) goto L120;
        List<ImageInfo> r48 = r46.a();
        if (r48 == null) goto L120;
        Integer r49 = Integer.valueOf(r48.size());
    L121:
        String r54 = zp9.d.a(r64, false);
        u3.l(r212, r214, r213, r215, "pic", r38, r311, r310, Integer.valueOf(r40), r312, r313, 4, r314, r315, r42, "action_bar_template", null, null, null, null, r43, r47, Boolean.valueOf(r45), r49, Boolean.valueOf(r44), null, null, zp9.d.e(r64), r54, Boolean.valueOf(ICreationAvatarService.a.v()), null, null, null, null, null, 406585728, 31);
        String r1 = r64.a;
        if (r1 == null) goto L126;
        Long r50 = StringsKt.toLongOrNull(r1);
        if (r50 == null) goto L126;
        r17 = r50.longValue();
    L126:
        p.a(r17);
        this.a.dismiss();     // Catch: Exception -> L129
    L133:
        return true;
    L129:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r51 = DialogFragmentLancet.sLastShowStack;
        if (r51 == null) goto L133;
        com.bytedance.crash.d.d(r51, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L120:
        r49 = r36;
        goto L121
    L114:
        r315 = r36;
        goto L115
    L111:
        r42 = r36;
        goto L112
    L108:
        r314 = r36;
        goto L109
    L105:
        r313 = r36;
        goto L106
    L102:
        r312 = r36;
        goto L103
    L98:
        r310 = r36;
        goto L99
    L94:
        r215 = r37;
        goto L95
    L83:
        if (r66.length() != 0) goto L85;
        boolean r52 = true;
    L86:
        if (r52 == false) goto L88;
        String r53 = "template_list";
    L89:
        r213 = r53;
        r36 = r0;
        goto L91
    L88:
        r53 = r66;
        goto L89
    L85:
        r52 = false;
        goto L86
    L79:
        r212 = r35;
    L73:
        r211 = 0;
    L58:
        r111 = -1;
    L48:
        r24 = null;
    L38:
        r19 = null;
    L28:
        r12 = null;
    L18:
        r7 = null;
    L12:
        r4 = 0;
        goto L13
    L75:
        r0 = null;
        goto L76
    }
}
