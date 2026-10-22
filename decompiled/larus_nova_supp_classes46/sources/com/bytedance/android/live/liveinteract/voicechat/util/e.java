package com.bytedance.android.live.liveinteract.voicechat.util;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final boolean a = false;
    public static final boolean b = false;

    static {
        ReadOnlyProperty r0 = vm2.d.K7;
        KProperty[] r1 = vm2.d.a;
        a = ((Boolean) r0.getValue(null, r1[449(0x1c1, float:6.29E-43)])).booleanValue();
        b = ((Boolean) vm2.d.J7.getValue(null, r1[448(0x1c0, float:6.28E-43)])).booleanValue();
    }

    public static boolean a(boolean r2) {
        if (r2 == false) goto L8;
        if (b == true) goto L8;
        return false;
    L8:
        if (TeamFightContext.isTeamFightShowing() == false) goto L11;
        return false;
    L11:
        if (je0.d.M() == false) goto L13;
    L41:
        return false;
    L13:
        if (je0.d.s() == true) goto L41;
        if (r2 == false) goto L17;
    L19:
        if (r2 == true) goto L30;
        ILinkPlayerInfoBridge r3 = je0.d.c();
        if (r3 == null) goto L25;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L25;
        String r5 = r4.getIdString();
    L27:
        if (Intrinsics.areEqual(r5, je0.d.b0()) == false) goto L30;
        return false;
    L25:
        r5 = null;
    L30:
        if (TextUtils.equals(j0.l().c(am2.x.class).l(), "true") == false) goto L32;
        return false;
    L32:
        IBaseUser r6 = jc1.k.f(IMiddlewareUserService.class).user().b();
        if (r6 == null) goto L41;
        if (TextUtils.isEmpty(r6.getIdString()) == true) goto L41;
        if (r6.getSecret() != 1) goto L40;
        return false;
    L40:
        return true;
    L17:
        if (a == true) goto L19;
        return false;
    }
}
