package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.Context;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.voicechat.interactacting.InteractActingContext;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.live.kmp.util.KmpToastUtil;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r16, Function0 r17, v r18, VoiceInteractSceneUtil.a r19) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "voiceSceneSwitchRealFuncDelegate");
        Intrinsics.checkNotNullParameter(r18, "voiceSceneSwitchConfirmDialogParam");
        int r4 = r18.a;
        int r5 = r18.b;
        if (r4 == r5) goto L5;
    L7:
        int r6 = m.a;
        if (vm2.e.m() == false) goto L11;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == true) goto L23;
        return;
    L23:
        int r8 = r18.a;
        Integer r9 = null;
        int r11 = 2131918765;
        if (r8 == 5) goto L54;
        if (r8 != 9) goto L27;
        int r10 = r18.c;
        if (r10 == 61) goto L35;
    L37:
        if (r10 != 61) goto L42;
        if (r18.b != 5) goto L42;
        b(r16, 2131915164, 2131915163, r17, r19);
        return;
    L42:
        if (r18.d == 61) goto L44;
    L46:
        if (r10 == 0) goto L48;
    L50:
        r17.invoke();
        if (r19 == null) goto L180;
        r19.c();
        return;
    L180:
        return;
    L48:
        if (r18.b != 5) goto L50;
        b(r16, 2131915157, 2131915156, r17, r19);
        return;
    L44:
        if (r18.b != 9) goto L46;
        b(r16, null, 2131915158, r17, r19);
        return;
    L35:
        if (r18.b != 9) goto L37;
        b(r16, 2131915166, 2131915165, r17, r19);
        return;
    L27:
        if (r8 == 16) goto L31;
        r17.invoke();
        if (r19 == null) goto L173;
        r19.c();
        return;
    L173:
        return;
    L31:
        f2.b(2131918765, 0);
        return;
    L54:
        if (GuestBattleContext.Companion.e() == false) goto L59;
        r17.invoke();
        if (r19 == null) goto L182;
        r19.c();
        return;
    L182:
        return;
    L59:
        if (TeamFightContext.Companion.h() == false) goto L68;
        int r0 = r18.d;
        if (r0 == 30) goto L65;
        if (r0 == 27) goto L65;
        int r1 = 2131922813;
    L66:
        f2.b(r1, 0);
        return;
    L65:
        r1 = 2131922814;
        goto L66
    L68:
        if (LinkRoomFightContext.Companion.c() == false) goto L75;
        int r2 = r18.d;
        if (r2 == 30) goto L72;
        if (r2 == 27) goto L72;
    L73:
        f2.b(r11, 0);
        return;
    L72:
        r11 = 2131918751;
        goto L73
    L75:
        if (InteractiveSongContext.Companion.f() == false) goto L82;
        if (r18.b == 5) goto L82;
        if (r18.d == 61) goto L82;
        f2.b(2131919177, 0);
        return;
    L82:
        if (InteractActingContext.Companion.a() == true) goto L84;
    L88:
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == false) goto L91;
        f2.b(2131914606, 0);
        return;
    L91:
        ReadOnlyProperty r12 = vm2.e.b0;
        KProperty[] r13 = vm2.e.a;
        if (((Boolean) r12.getValue(null, r13[52])).booleanValue() == false) goto L99;
        if (r18.c != 29) goto L99;
        r17.invoke();
        if (r19 == null) goto L189;
        r19.c();
        return;
    L189:
        return;
    L99:
        if (((Boolean) r12.getValue(null, r13[52])).booleanValue() == false) goto L115;
        int r14 = r18.d;
        if (r14 == 30) goto L104;
        if (r14 != 27) goto L115;
    L104:
        if (r18.c == 28) goto L108;
        if (ThemedCompetitionContext.Companion.h() == false) goto L115;
    L108:
        if (r18.c != 28) goto L111;
        int r3 = 2131918740;
    L114:
        f2.b(r3, 0);
        return;
    L111:
        if (ThemedCompetitionContext.Companion.h() == false) goto L113;
        r3 = 2131922725;
        goto L114
    L113:
        r3 = 2131918741;
    L115:
        int r15 = r18.b;
        if (r15 == 9) goto L118;
    L130:
        if (r15 == 9) goto L132;
        if (r15 != 5) goto L169;
        int r20 = r18.d;
        if (r20 == 21) goto L165;
        if (r20 == 22) goto L164;
        if (r20 == 26) goto L163;
        if (r20 == 27) goto L165;
        if (r20 == 30) goto L162;
        int r21 = 2131915176;
    L166:
        if (r20 != 30) goto L168;
        r9 = 2131923225;
    L168:
        b(r16, r9, r21, r17, r19);
        return;
    L162:
        r21 = 2131923224;
        goto L166
    L163:
        r21 = 2131915174;
        goto L166
    L164:
        r21 = 2131915175;
    L165:
        r21 = 2131915173;
        goto L166
    L169:
        r17.invoke();
        if (r19 == null) goto L197;
        r19.c();
        return;
    L197:
        return;
    L132:
        if (r18.c == 26) goto L135;
    L136:
        boolean r22 = false;
    L149:
        if (r22 == false) goto L151;
        b(r16, null, 2131915152, r17, r19);
        return;
    L151:
        r17.invoke();
        if (r19 == null) goto L194;
        r19.c();
        return;
    L194:
        return;
    L135:
        if (Intrinsics.areEqual(com.bytedance.android.live.ktv.common.util.a.c().getAnchorAbValue("linkmic_audience_anchor_hide"), "1") == false) goto L136;
        IInteractService r23 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r23 == null) goto L144;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r24 = r23.getLinkUserInfoCenter();
        if (r24 == null) goto L144;
        List<T> r25 = r24.getOnlineUserList();
        if (r25 == 0) goto L144;
        int r26 = r25.size();
    L145:
        if (r26 <= 9) goto L147;
        boolean r27 = true;
    L148:
        r22 = r27;
        goto L149
    L147:
        r27 = false;
    L144:
        r26 = 0;
        goto L145
    L118:
        if (r18.d != 61) goto L130;
        if (((Boolean) vm2.i.O.getValue(null, vm2.i.a[39])).booleanValue() == false) goto L128;
        int r28 = r18.c;
        if (r28 == 27) goto L127;
        if (r28 == 22) goto L127;
        if (r28 == 26) goto L127;
        if (r28 == 21) goto L127;
        if (r28 != 28) goto L128;
    L127:
        int r29 = 2131915159;
    L129:
        b(r16, null, r29, r17, r19);
        return;
    L128:
        r29 = 2131915158;
        goto L129
    L84:
        if (r18.b == 5) goto L88;
        if (r18.d == 61) goto L88;
        f2.b(2131919175, 0);
        return;
    L11:
        if (r4 == 5) goto L13;
        if (r4 == 9) goto L13;
    L15:
        if (r4 != 10) goto L20;
        if (r5 == 5) goto L18;
        if (r5 != 9) goto L20;
    L18:
        KmpToastUtil.a("请先切换电台，暂不支持直接切换", 0);
    L19:
        r7 = false;
    L13:
        if (r5 != 10) goto L15;
        KmpToastUtil.a("请先切换电台，暂不支持直接切换", 0);
        goto L19
    L5:
        if (r18.c != r18.d) goto L7;
    }

    public static void b(Context r3, Integer r4, int r5, Function0 r6, VoiceInteractSceneUtil.a r7) {
        if (r7 == null) goto L4;
        r7.d();
    L4:
        x0.b r0 = new x0.b(r3, 0);
        if (r4 != null) goto L7;
        r0.a.a = 4;
    L8:
        r0.l(r5);
        r0.i(1, 2131915442, new w(r7));
        r0.i(0, 2131918116, new x(r7, r6));
        r0.a.k = false;
        r0.n();
        return;
    L7:
        r0.a.a = 5;
        r0.m(r4.intValue());
        goto L8
    }
}
