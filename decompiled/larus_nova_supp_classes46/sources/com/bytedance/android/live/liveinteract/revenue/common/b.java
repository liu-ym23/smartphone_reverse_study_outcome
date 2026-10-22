package com.bytedance.android.live.liveinteract.revenue.common;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.profit.dress.config.RolePropConfigKt;
import com.bytedance.android.live.profit.dress.config.s;
import com.bytedance.android.live.profit.dress.x;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import zt0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {

    public static final class a implements zt0.b {
        public a() {
        }

        public final void a(String r3) {
            ALogger.i("RevenueDressResource", "#DressResourceDebug# [getTimeFightPkInProgress] onSyncSuccess id " + r3);
        }

        public final void b(String r1, String r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "version");
            ALogger.i("RevenueDressResource", "#DressResourceDebug# [getTimeFightPkInProgress] onSyncFailed id " + r1);
        }
    }

    public static String b() {
        LinkRoomFightContext.a r0 = LinkRoomFightContext.Companion;
        if (r0.c() == false) goto L9;
        LinkRoomFightContext r1 = r0.getContext();
        if (r1 == null) goto L16;
        m<String> r2 = r1.getDressId();
        if (r2 == null) goto L16;
        String r3 = (String) r2.getValue();
    L18:
        if (v.a() == false) goto L27;
        if (r3 != null) goto L21;
    L24:
        boolean r4 = true;
    L25:
        if (r4 == false) goto L27;
        f2.f("dressId为空，请抓取LinkMicTeamFightMessage消息");
        goto L27
    L21:
        if (r3.length() == 0) goto L24;
        r4 = false;
    L27:
        return r3;
    L16:
        r3 = null;
        goto L18
    L9:
        TeamFightContext.a r5 = TeamFightContext.Companion;
        if (r5.h() == false) goto L16;
        TeamFightContext r6 = r5.getContext();
        if (r6 == null) goto L16;
        m<String> r7 = r6.getDressId();
        if (r7 == null) goto L16;
        r3 = (String) r7.getValue();
        goto L18
    }

    public static String c() {
        String r0 = b();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return null;
    L12:
        e r2 = yt0.c.a();
        String r3 = b();
        Intrinsics.checkNotNull(r3);
        m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L17;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L17;
        long r6 = r5.getRoomId();
    L18:
        x r7 = r2.getDressData(r3, 31, r6, "RevenueDressResource asyncCrownBeautyEffectId", new a());
        StringBuilder r8 = new StringBuilder("#DressResourceDebug# [getTimeFightPkInProgress] getDressModel config ");
        if (r7 == null) goto L21;
        String r9 = r7.d;
    L22:
        r8.append(r9);
        ALogger.i("RevenueDressResource", r8.toString());
        if (r7 != null) goto L25;
        return null;
    L25:
        return r7.d;
    L21:
        r9 = null;
    L17:
        r6 = 0;
        goto L18
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    static {
    }

    public static String a(int r12) {
        ALogger.i("RevenueDressResource", "#DressResourceDebug# [getCrownSettingIcon] dressId " + b());
        String r0 = b();
        int r2 = 1;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L50;
        e r5 = yt0.c.a();
        String r6 = b();
        Intrinsics.checkNotNull(r6);
        m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L17;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L17;
        long r8 = r4.getRoomId();
    L18:
        x r7 = r5.getDressData(r6, 31, r8, "RevenueDressResource asyncCrownBeautyEffectId", new com.bytedance.android.live.liveinteract.revenue.common.a());
        StringBuilder r9 = new StringBuilder("#DressResourceDebug# [getCrownSettingIcon] getDressModel config ");
        if (r7 == null) goto L23;
        Map r10 = r7.a;
        if (r10 == null) goto L23;
        String r11 = RolePropConfigKt.b(r10, RevenueDressResource$getCrownSettingIcon$1.INSTANCE);
    L24:
        r9.append(r11);
        ALogger.i("RevenueDressResource", r9.toString());
        int r13 = ki0.a.a;
        if (r12 != 2) goto L27;
        r2 = 2;
    L30:
        long r14 = r2;
        if (r7 == null) goto L44;
        Map r15 = r7.a;
        if (r15 == null) goto L45;
        s r16 = (s) r15.get(Long.valueOf(r14));
        if (r16 == null) goto L46;
        k r17 = r16.getStaticLinkmicImg();
        if (r17 != null) goto L39;
        return null;
    L39:
        if (r17.getUrls() != null) goto L41;
        return null;
    L41:
        if (r17.getUrls().size() > 0) goto L43;
        return null;
    L43:
        return (String) ListProtector.get(r17.getUrls(), 0);
    L46:
        return null;
    L45:
        return null;
    L44:
        return null;
    L27:
        if (r12 == 3) goto L30;
        r2 = 0;
    L23:
        r11 = null;
    L17:
        r8 = 0;
        goto L18
    L50:
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }
}
