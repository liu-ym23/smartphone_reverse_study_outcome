package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text;

import android.content.Context;
import android.view.View;
import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.filedetail.dto.FileDetailLaunchParams;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.detail.FileDetailController;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mya.h;
import mya.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ m2b.a a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Chat c;
    public final /* synthetic */ int d;
    public final /* synthetic */ y6b.a<?> e;
    public final /* synthetic */ Message f;
    public final /* synthetic */ File g;
    public final /* synthetic */ String h;
    public final /* synthetic */ List<String> i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;

    public g(m2b.a r1, View r2, Chat r3, int r4, y6b.a r5, Message r6, File r7, String r8, List r9, String r10, String r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r21) {
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L12;
        m2b.a r1 = this.a;
        if (r1 == null) goto L146;
        h r2 = r1.j5();
        if (r2 == null) goto L147;
        k r3 = r2.b(k.class);
        if (r3 == null) goto L148;
        r3.l(this.b.getContext(), this.c.getId(), this.d);
        return;
    L148:
        return;
    L147:
        return;
    L146:
        return;
    L12:
        d r4 = d.a;
        View r5 = this.b;
        y6b.a<?> r6 = this.e;
        Message r7 = this.f;
        Chat r8 = this.c;
        r4.getClass();
        if (r6 != null) goto L16;
        if (r7 != null) goto L16;
        boolean r9 = false;
    L53:
        if (r9 == false) goto L55;
        return;
    L55:
        View r10 = this.b;
        File r11 = this.g;
        String r12 = this.h;
        Chat r13 = this.c;
        int r14 = this.d;
        List<String> r15 = this.i;
        m2b.a r16 = this.a;
        Message r17 = this.f;
        String r18 = this.j;
        String r19 = this.k;
        String r20 = r11.key;
        if (r20 != null) goto L58;
        r20 = BuildConfig.FLAVOR;
    L58:
        if (r13 != null) goto L61;
        return;
    L61:
        if (r20.length() != 0) goto L63;
        boolean r22 = true;
    L64:
        if (r22 == true) goto L155;
        xtb.a r23 = ChatCoreModule.a().getFileDetailDependency();
        if ((r16 instanceof com.ss.android.lark.chat.message.menu.context.c) == false) goto L69;
        com.ss.android.lark.chat.message.menu.context.c r24 = (com.ss.android.lark.chat.message.menu.context.c) r16;
    L70:
        if (r24 == null) goto L75;
        if (r12 != null) goto L73;
        String r110 = BuildConfig.FLAVOR;
    L74:
        Message r111 = r24.b(r110);
    L77:
        if (r24 == null) goto L103;
        if (r111 == null) goto L103;
        int r25 = r24.U();
        if (r25 == 1) goto L84;
        if (r25 == 3) goto L83;
        int r26 = -99;
    L86:
        if (Intrinsics.areEqual(r11.is_folder, Boolean.TRUE) == false) goto L95;
        Context r27 = r10.getContext();
        FolderContent r28 = d.f(r11);
        String r29 = r24.g0();
        String r30 = r13.getId();
        r23.getClass();
        boolean r31 = y0.b(r13);
        boolean r32 = y0.c(r13);
        String r112 = r111.getId();
        Intrinsics.checkNotNullParameter(r112, "messageId");
        Chat.Type.UNKNOWN.getNumber();
        String r33 = r28.getKey();
        Intrinsics.checkNotNullParameter(r33, "folderKey");
        String r0 = r28.getName();
        Intrinsics.checkNotNullParameter(r0, "folderName");
        long r34 = r28.getSize();
        int r35 = xtb.a.a(r13);
        String r36 = r28.getKey();
        if (r29 == null) goto L90;
        Intrinsics.checkNotNullParameter(r29, "originMergeForwardId");
        String r113 = r29;
    L91:
        if (r30 == null) goto L93;
        Intrinsics.checkNotNullParameter(r30, "chatId");
        String r114 = r30;
    L94:
        int r115 = com.ss.android.lark.officesdk.integrator.im.impl.g.a;
        FolderManageLaunchParams r116 = new FolderManageLaunchParams();
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r116.a = r112;
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r116.b = r114;
        r116.c = -1;
        r116.d = false;
        r116.e = 5;
        r116.f = r26;
        Intrinsics.checkNotNullParameter(r33, "<set-?>");
        r116.g = r33;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r116.h = r0;
        r116.i = r29;
        r116.j = r30;
        r116.k = null;
        r116.l = -1;
        r116.m = r111;
        r116.n = r34;
        r116.o = null;
        r116.p = r31;
        r116.q = r32;
        r116.r = 1;
        r116.s = null;
        r116.t = null;
        r116.u = r36;
        r116.v = r113;
        r116.w = r35;
        FileDetailModule.a(r27, r116);
        return;
    L93:
        r30 = null;
        r114 = BuildConfig.FLAVOR;
        goto L94
    L90:
        r113 = null;
        r29 = null;
        goto L91
    L95:
        Context r37 = r10.getContext();
        FileContent r38 = d.d(r11, r15);
        String r39 = r24.g0();
        String r40 = r13.getId();
        r23.getClass();
        boolean r41 = r13.isSecret();
        boolean r42 = r13.isCrossWithKa();
        boolean r43 = y0.b(r13);
        boolean r44 = y0.c(r13);
        FileDetailLaunchParams.a r117 = new FileDetailLaunchParams.a(r37, r38, r111.getId());
        Intrinsics.checkNotNullParameter(r111, "message");
        r117.b = r111;
        r117.f = r41;
        r117.g = r42;
        r117.m = (r117.m | 4) ^ 4;
        r117.c(r43);
        r117.b(r44);
        r117.B = xtb.a.a(r13);
        r117.z = r38.getKey();
        r117.s = r26;
        if (r39 == null) goto L98;
        Intrinsics.checkNotNullParameter(r39, "id");
        r117.n = r39;
        Intrinsics.checkNotNullParameter(r39, "originMergeForwardId");
        r117.w = r39;
    L98:
        if (r40 == null) goto L100;
        Intrinsics.checkNotNullParameter(r40, "chatId");
        r117.d = r40;
        Intrinsics.checkNotNullParameter(r40, "chatId");
        r117.o = r40;
    L100:
        if (r26 != 3) goto L102;
        r117.j = 7;
    L102:
        int r45 = com.ss.android.lark.officesdk.integrator.im.impl.g.a;
        FileDetailLaunchParams r46 = r117.a();
        Intrinsics.checkNotNullParameter(r46, "params");
        FileDetailController.d(r46);
        return;
    L83:
        r26 = 3;
        goto L86
    L84:
        r26 = 2;
    L103:
        if (r18 != null) goto L105;
    L108:
        boolean r47 = true;
    L109:
        if (r47 == false) goto L119;
        if (r19 != null) goto L112;
    L115:
        boolean r48 = true;
    L116:
        if (r48 == false) goto L119;
        boolean r49 = false;
    L120:
        boolean r118 = !r49;
        Boolean r119 = r11.is_folder;
        Boolean r50 = Boolean.TRUE;
        if (Intrinsics.areEqual(r119, r50) == false) goto L129;
        if (r49 == false) goto L129;
        Context r51 = r10.getContext();
        FolderContent r52 = d.f(r11);
        if (r12 != null) goto L126;
        String r53 = BuildConfig.FLAVOR;
    L127:
        r23.f(r51, r17, r52, r53, r13, r14, r18, r19, r118);
        return;
    L126:
        r53 = r12;
    L129:
        if (Intrinsics.areEqual(r11.is_folder, r50) == false) goto L135;
        Context r54 = r10.getContext();
        FolderContent r55 = d.f(r11);
        if (r12 != null) goto L133;
        r12 = BuildConfig.FLAVOR;
    L133:
        r23.getClass();
        boolean r56 = y0.b(r13);
        boolean r57 = y0.c(r13);
        Intrinsics.checkNotNullParameter(r12, "messageId");
        Chat.Type.UNKNOWN.getNumber();
        String r58 = r55.getKey();
        Intrinsics.checkNotNullParameter(r58, "folderKey");
        String r59 = r55.getName();
        Intrinsics.checkNotNullParameter(r59, "folderName");
        long r60 = r55.getSize();
        int r120 = xtb.a.a(r13);
        String r61 = r55.getKey();
        String r62 = r13.getId();
        Intrinsics.checkNotNullParameter(r62, "chatId");
        FolderManageLaunchParams r121 = new FolderManageLaunchParams();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r121.a = r12;
        Intrinsics.checkNotNullParameter(r62, "<set-?>");
        r121.b = r62;
        r121.c = r14;
        r121.d = false;
        r121.e = 10;
        r121.f = -99;
        Intrinsics.checkNotNullParameter(r58, "<set-?>");
        r121.g = r58;
        Intrinsics.checkNotNullParameter(r59, "<set-?>");
        r121.h = r59;
        r121.i = null;
        r121.j = null;
        r121.k = null;
        r121.l = -1;
        r121.m = null;
        r121.n = r60;
        r121.o = null;
        r121.p = r56;
        r121.q = r57;
        r121.r = 1;
        r121.s = null;
        r121.t = null;
        r121.u = r61;
        r121.v = null;
        r121.w = r120;
        FileDetailModule.a(r54, r121);
        return;
    L135:
        if (r49 == false) goto L141;
        Context r63 = r10.getContext();
        FileContent r64 = d.d(r11, r15);
        if (r12 != null) goto L139;
        String r65 = BuildConfig.FLAVOR;
    L140:
        r23.c(r63, r17, r64, r65, r13, r14, d.c(r13), r18, r19, r118);
        return;
    L139:
        r65 = r12;
        goto L140
    L141:
        Context r66 = r10.getContext();
        FileContent r67 = d.d(r11, r15);
        if (r12 != null) goto L144;
        r12 = BuildConfig.FLAVOR;
    L144:
        r23.d(r66, r67, r12, r13, r14, d.c(r13));
        return;
    L112:
        if (r19.length() == 0) goto L115;
        r48 = false;
    L119:
        r49 = true;
        goto L120
    L105:
        if (r18.length() == 0) goto L108;
        r47 = false;
        goto L109
    L73:
        r110 = r12;
        goto L74
    L75:
        r111 = null;
        goto L77
    L69:
        r24 = null;
        goto L70
    L155:
        return;
    L63:
        r22 = false;
    L16:
        AuthorizationServiceV2 r68 = owa.a.c();
        if (r6 == null) goto L22;
        ValidateIMFileResult r69 = r6.N();
        if (r69 == null) goto L22;
        ValidateResult r70 = r69.getValidateResult();
        if (r70 == null) goto L22;
    L27:
        if (r6 == null) goto L32;
        ValidateIMFileResult r71 = r6.N();
        if (r71 == null) goto L32;
        IMFileResult r72 = r71.getResultType();
        if (r72 == null) goto L32;
    L37:
        MessagePermissionUtil.ReceiveAuthorizationState r73 = MessagePermissionUtil.h(r72);
        if (MessagePermissionUtil.g(r73) == false) goto L46;
        int r74 = d.b.a[r73.ordinal()];
        if (r74 == 1) goto L44;
        if (r74 != 2) goto L45;
        r68.d(r70, MessagePermissionUtil.a());
    L45:
        r68.a(r70, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        r9 = true;
        goto L53
    L44:
        MessagePermissionUtil.m(r5.getContext());
        goto L45
    L46:
        r68.a(r70, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        ValidateResult r75 = MessagePermissionUtil.b();
        if (r6 == null) goto L49;
        boolean r76 = MessagePermissionUtil.f(r6, r8, r75);
    L50:
        if (r76 == true) goto L52;
        MessagePermissionUtil.n(r5.getContext(), 2131891409, r75);
    L52:
        r68.a(r75, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        r9 = !r76;
        goto L53
    L49:
        r76 = MessagePermissionUtil.c(r7, r8, r75);
    L32:
        if (r7 == null) goto L36;
        ValidateIMFileResult r77 = r7.getValidateIMFileResult();
        if (r77 == null) goto L36;
        r72 = r77.getResultType();
    L36:
        r72 = null;
    L22:
        if (r7 == null) goto L26;
        ValidateIMFileResult r78 = r7.getValidateIMFileResult();
        if (r78 == null) goto L26;
        r70 = r78.getValidateResult();
    L26:
        r70 = null;
        goto L27
    }
}
