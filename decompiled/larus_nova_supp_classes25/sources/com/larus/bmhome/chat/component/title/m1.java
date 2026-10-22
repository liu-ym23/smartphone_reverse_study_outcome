package com.larus.bmhome.chat.component.title;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.audio.IAudioService;
import com.larus.bmhome.auth.TouristModeABParam;
import com.larus.bmhome.auth.h1;
import com.larus.bmhome.auth.i1;
import com.larus.bmhome.chat.ChatDoubleTabFragment;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.g4;
import com.larus.bmhome.chat.j4;
import com.larus.bmhome.chat.reddot.a;
import com.larus.bmhome.chat.reddot.f;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.utils.i;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.ChatTitleAlignLeftStyle;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.j;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.g;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ic8.n;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import te8.b;
import te8.d;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m1 implements com.larus.bmhome.chat.component.cvs.y.a<e> {
    public final /* synthetic */ ChatTitleComponent a;

    public m1(ChatTitleComponent r1) {
        this.a = r1;
    }

    public final void c(Object r9) {
        final e r10 = (e) r9;
        Intrinsics.checkNotNullParameter(r10, "new");
        ChatTitleComponent r0 = this.a;
        Integer r1 = r10.v;
        boolean r2 = false;
        if (r1 != null) goto L6;
    L10:
        boolean r3 = false;
    L12:
        if (r0.p1 == r3) goto L16;
        com.larus.platform.api.g0 r4 = r0.n;
        if (r4 == null) goto L16;
        r4.setIsLocalSubConvChange(r3);
    L16:
        r0.p1 = r3;
        ChatTitleComponent r5 = this.a;
        ChatTitleAlignLeftStyle r6 = r5.n;
        String r7 = null;
        if ((r6 instanceof ChatTitleAlignLeftStyle) == false) goto L19;
        ChatTitleAlignLeftStyle r8 = r6;
    L20:
        if (r8 == null) goto L40;
        r8.setTopLeftCreateNewCvsAvailable(!n.r(r10));
        if (n.r(r10) == false) goto L24;
        r8.setArrowVisible(false);
        goto L40
    L24:
        z2 r11 = z2.a;
        if (r11.getChatNavigatorConfig().b == false) goto L40;
        String r12 = r10.a;
        e r13 = (e) AuthModelDelegate.b.y().getValue();
        if (r13 == null) goto L29;
        String r14 = r13.a;
    L31:
        if (Intrinsics.areEqual(r12, r14) == false) goto L33;
        r11.w3();
    L33:
        g4 r15 = r5.e4();
        if (r15 != null) goto L36;
    L38:
        boolean r16 = false;
    L39:
        r8.setArrowVisible(!r16);
        goto L40
    L36:
        if (r15.c() == true) goto L38;
        r16 = true;
        goto L39
    L29:
        r14 = null;
    L40:
        final ChatTitleComponent r17 = this.a;
        if (r17.B3() == null) goto L168;
        FLogger.a.i(r17.d4(), "setupTitle called " + r17.n);
        AccountService.a.getSecUserId();
        final com.larus.platform.api.g0 r18 = r17.n;
        if (r18 == null) goto L167;
        Bundle r19 = r17.f1().b;
        if (r19 == null) goto L48;
        boolean r20 = r19.getBoolean("show_two_tab", false);
    L49:
        if (r20 == true) goto L51;
    L57:
        ChatTitleAlignLeftStyle r21 = r17.n;
        if ((r21 instanceof ChatTitleAlignLeftStyle) == false) goto L60;
        ChatTitleAlignLeftStyle r22 = r21;
    L61:
        if (r22 == null) goto L64;
        r22.setCvsOnlyRead(n.d(r10));
    L64:
        if (i3.a.f() == false) goto L79;
        i1 r23 = h1.a();
        if (r23 == null) goto L75;
        TouristModeABParam r24 = r23.b;
        if (r24 == null) goto L75;
        Integer r25 = r24.getType();
        if (r25 == null) goto L75;
        if (r25.intValue() != 1) goto L75;
        boolean r26 = true;
    L76:
        if (r26 == false) goto L79;
    L110:
        boolean r27 = false;
    L111:
        if (r27 == true) goto L113;
        FLogger.a.d(r17.d4(), "initTitleRedDotListener: not in conversation tab, can not register listener");
    L130:
        r18.setRedDotViewClickListener(new n0(r17));
        r18.setOnSideNavClickListener(new o0(r17));
        final g4 r28 = r17.e4();
        if (r28 == null) goto L133;
        r28.b();
        r18.setOnMoreClickListener(new p0(r28));
    L134:
        Integer r29 = r10.f;
        if (r29 == null) goto L147;
        if (r29.intValue() != 1) goto L147;
        Lazy r30 = n.a;
        Map r31 = r10.x;
        if (r31 != null) goto L142;
    L144:
        boolean r32 = false;
    L145:
        if (r32 == false) goto L147;
    L148:
        r2 = true;
    L149:
        r18.setHasAddBot(r2);
        b r33 = r17.k1;
        if (r33 == null) goto L152;
        r33.b(r18.getHasAddBot());
    L152:
        r18.setHasMore(!r18.getHasAddBot());
        b r34 = r17.k1;
        if (r34 == null) goto L155;
        r34.a(!r18.getHasAddBot());
    L155:
        BotModel r35 = r17.j0();
        if (r35 == null) goto L161;
        BotCreatorInfo r36 = r35.getBotCreatorInfo();
        if (r36 == null) goto L161;
        r7 = r36.getId();
    L161:
        if (Intrinsics.areEqual(r7, AccountService.a.getUserId()) == false) goto L163;
        r18.setHasMore(true);
    L163:
        r18.setOnAddBotClickListener(new r0(r18, r10, r17));
        r18.setCreateNewCvsClickListener(new t0(r17, r10, r18));
        r18.setOnSearchClickListener(new u0(r17, r10));
        r18.setOnMultitaskClickListener(new v0(r17, r10));
        if ((r17.Z3() instanceof ChatDoubleTabFragment) == false) goto L166;
        ChatDoubleTabFragment r37 = r17.Z3();
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type com.larus.bmhome.chat.ChatDoubleTabFragment");
        ChatDoubleTabFragment r38 = r37;
        d r39 = new ChatTitleComponent$setupTitle$1$9(r18, r17, r10);
        r38.getClass();
        Intrinsics.checkNotNullParameter(r39, "parentAddBotChangedListener");
        r38.h = r39;
        ChatDoubleTabFragment r40 = r17.Z3();
        Intrinsics.checkNotNull(r40, "null cannot be cast to non-null type com.larus.bmhome.chat.ChatDoubleTabFragment");
        Function0 r41 = new w0(r17);
        r40.getClass();
        Intrinsics.checkNotNullParameter(r41, "listener");
    L166:
        r17.p4();
        goto L167
    L142:
        if (r31.containsKey("is_from_local_discovery") != true) goto L144;
        r32 = true;
    L147:
        if (n.l(r10) == false) goto L149;
    L133:
        r18.setOnMoreClickListener(new q0(r17));
        goto L134
    L113:
        a r42 = r17.P0;
        if (r42 == null) goto L116;
        f r43 = f.a;
        f.e(r42);
    L116:
        Bundle r44 = r17.f1().b;
        if (r44 != null) goto L119;
        r44 = r17.f1().a;
    L119:
        if (r44 == null) goto L121;
        String r45 = r44.getString("argPreviousPage", "");
    L123:
        if (Intrinsics.areEqual(r45, "chat_list_only_send") == false) goto L125;
    L128:
        boolean r46 = true;
    L129:
        a r47 = new a(new r1(r46, r17, r18, r10));
        f r48 = f.a;
        f.d(r47);
        r17.P0 = r47;
        goto L130
    L125:
        if (Intrinsics.areEqual(r45, "chat_list_doubao_pc") == true) goto L128;
        r46 = false;
        goto L129
    L121:
        r45 = null;
    L75:
        r26 = false;
    L79:
        if (r17.k4() == false) goto L82;
        r27 = z2.a.getChatNavigatorConfig().h;
        goto L111
    L82:
        if (Intrinsics.areEqual(r17.h1, "CONVERSATION") == false) goto L106;
        List r49 = AppHost.a.a().g();     // Catch: Exception -> L94
        if ((CollectionsKt.lastOrNull(r49) instanceof j4) == false) goto L87;
    L96:
        boolean r50 = true;
    L97:
        if (r50 == true) goto L109;
        IAudioService r51 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r51 != null) goto L101;
    L103:
        boolean r52 = false;
    L104:
        if (r52 == true) goto L109;
    L101:
        if (r51.l() != true) goto L103;
        r52 = true;
    L109:
        r27 = true;
        goto L111
    L87:
        if (r49.size() <= 1) goto L93;
        ComponentCallbacks2 r53 = (Activity) ListProtector.get(r49, r49.size() - 2);     // Catch: Exception -> L94
        if ((r53 instanceof j4) == false) goto L93;
        if (((j4) r53).c0() == false) goto L96;
    L93:
        r50 = false;
    L94:
        e = move-exception;
        g.a.ensureNotReachHere(e, "isLastConversationPage Crash");
    L106:
        if (r17.f1().w() == false) goto L110;
        if (z2.a.isLazyMainComponentEnable() == false) goto L110;
    L60:
        r22 = null;
        goto L61
    L51:
        if ((r17.Z3() instanceof ChatDoubleTabFragment) == false) goto L57;
        LarusPageChatBinding r54 = r17.B3();
        if (r54 == null) goto L57;
        ChatConstraintLayout r55 = r54.a;
        if (r55 == null) goto L57;
        r55.U5();
        goto L57
    L48:
        r20 = false;
    L167:
        Unit r56 = Unit.INSTANCE;
    L168:
        this.a.B4();
        ChatTitleComponent r57 = this.a;
        boolean r58 = i.f(r10);
        com.larus.platform.api.g0 r59 = r57.n;
        if (r59 == null) goto L171;
        r59.setMainBot(r58);
    L171:
        ChatTitleComponent.Y2(this.a);
        this.a.j4();
        return;
    L19:
        r8 = null;
        goto L20
    L6:
        if (r1.intValue() != 3) goto L10;
        Lazy r60 = j.a;
        if (j.f(r10.a) == false) goto L10;
        r3 = true;
        goto L12
    }
}
