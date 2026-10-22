package com.bytedance.android.live.liveinteract.spatial;

import aj6.c;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.model.f0;
import com.bytedance.android.livesdk.model.t0;
import com.bytedance.android.livesdk.model.u0;
import com.bytedance.android.livesdk.model.v0;
import com.bytedance.android.livesdk.model.w0;
import com.bytedance.android.livesdk.model.x0;
import com.bytedance.android.livesdk.model.y0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import rj0.k;
import ti6.f;
import vm2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final aj6.b a(int r8) {
        HashMap r0 = ((u0) d.F4.getValue(null, d.a[289(0x121, float:4.05E-43)])).b();
        if (r0 == null) goto L8;
        v0 r9 = (v0) r0.get(Integer.valueOf(r8));
        if (r9 == null) goto L8;
        t0 r10 = r9.a();
        if (r10 == null) goto L8;
    L9:
        x0 r2 = r10.a();
        float r3 = 1.0f;
        if (r2 == null) goto L12;
        float r4 = r2.a();
    L13:
        x0 r5 = r10.a();
        float r6 = 0.0f;
        if (r5 == null) goto L16;
        float r7 = r5.b();
    L17:
        x0 r11 = r10.a();
        if (r11 == null) goto L20;
        float r12 = r11.c();
    L21:
        c r1 = new c(r4, r7, r12);
        x0 r13 = r10.b();
        if (r13 == null) goto L24;
        float r14 = r13.a();
    L25:
        x0 r15 = r10.b();
        if (r15 == null) goto L28;
        float r16 = r15.b();
    L29:
        x0 r17 = r10.b();
        if (r17 == null) goto L32;
        float r18 = r17.c();
    L33:
        c r19 = new c(r14, r16, r18);
        x0 r20 = r10.c();
        if (r20 == null) goto L36;
        float r21 = r20.a();
    L37:
        x0 r22 = r10.c();
        if (r22 == null) goto L40;
        r6 = r22.b();
    L40:
        x0 r23 = r10.c();
        if (r23 == null) goto L44;
        r3 = r23.c();
    L44:
        return new aj6.b(r1, r19, new c(r21, r6, r3));
    L36:
        r21 = 0.0f;
        goto L37
    L32:
        r18 = 0.0f;
        goto L33
    L28:
        r16 = 1.0f;
        goto L29
    L24:
        r14 = 0.0f;
        goto L25
    L20:
        r12 = 0.0f;
        goto L21
    L16:
        r7 = 0.0f;
        goto L17
    L12:
        r4 = 1.0f;
    L8:
        r10 = new t0(0);
        goto L9
    }

    @JvmStatic
    public static final y0 b(int r3) {
        HashMap r0 = ((u0) d.F4.getValue(null, d.a[289(0x121, float:4.05E-43)])).b();
        if (r0 == null) goto L8;
        v0 r4 = (v0) r0.get(Integer.valueOf(r3));
        if (r4 == null) goto L8;
        y0 r5 = r4.b();
        if (r5 == null) goto L8;
    L10:
        return new y0(r5.a(), r5.b(), r5.c());
    L8:
        r5 = new y0(0, 0, 2000);
        goto L10
    }

    @JvmStatic
    public static final Object c(int r6) {
        ReadOnlyProperty r0 = d.C4;
        KProperty[] r1 = d.a;
        w0 r3 = (w0) r0.getValue(null, r1[286(0x11e, float:4.01E-43)]);
        if (r6 != 2) goto L5;
        com.bytedance.android.livesdk.model.d r7 = r3.b();
        if (r7 != null) goto L20;
        return null;
    L20:
        return r7.a();
    L5:
        if (r6 == 6) goto L13;
        f0 r2 = ((w0) r0.getValue(null, r1[286(0x11e, float:4.01E-43)])).a();
        if (r2 == null) goto L9;
        HashMap r4 = r2.a();
    L10:
        if (r4 != null) goto L12;
        return null;
    L12:
        return (HashMap) r4.get(Integer.valueOf(r6));
    L9:
        r4 = null;
        goto L10
    L13:
        com.bytedance.android.livesdk.model.d r8 = r3.c();
        if (r8 != null) goto L16;
        return null;
    L16:
        return r8.a();
    }

    @JvmStatic
    public static final String d(String r2) {
        k.m2.getClass();
        k r0 = k.a.a();
        IBaseUser r1 = null;
        if (r0 == null) goto L8;
        i<ILinkPlayerInfoBridge> r3 = r0.getLinkUserInfoCenter();
        if (r3 == null) goto L8;
        IBaseUser r4 = r3.U4(r2);
        if (r4 == null) goto L8;
    L14:
        if (r4 != null) goto L18;
        i r5 = jc1.k.n(IKtvService.class).getLinkUserInfoCenter();
        if (r5 == null) goto L19;
        r1 = r5.U4(r2);
    L19:
        if (r1 != null) goto L21;
        return "";
    L21:
        return r1.getIdString();
    L18:
        r1 = r4;
    L8:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r6 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r6 == null) goto L13;
        i<ILinkPlayerInfoBridge> r7 = r6.getLinkUserInfoCenter();
        if (r7 == null) goto L13;
        r4 = r7.U4(r2);
    L13:
        r4 = null;
        goto L14
    }

    @JvmStatic
    public static final boolean e(int r5) {
        String r2 = null;
        Double r0 = (Double) ((Map) d.E4.getValue(null, d.a[288(0x120, float:4.04E-43)])).get(String.valueOf(r5));
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf((int) r0.doubleValue());
    L7:
        if (r1 != null) goto L10;
    L27:
        if (r1 != null) goto L30;
    L32:
        if (r1 != null) goto L35;
    L37:
        return false;
    L35:
        if (r1.intValue() != 2) goto L37;
        return true;
    L30:
        if (r1.intValue() != 1) goto L32;
        return false;
    L10:
        if (r1.intValue() != 0) goto L27;
        m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L16;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L16;
        Map r6 = r4.getAnchorABMap();
    L17:
        com.bytedance.android.live.liveinteract.plantform.spatial.a r7 = SpatialAudioStrategyManager.c.a().a.get(Integer.valueOf(r5));
        if (r7 == null) goto L20;
        r2 = r7.c();
    L20:
        if (r6 == null) goto L38;
        String r8 = (String) r6.get(r2);
        if (r8 != null) goto L24;
        return false;
    L24:
        if (CastIntegerProtector.parseInt(r8) != 1) goto L40;
        return true;
    L40:
        return false;
    L38:
        return false;
    L16:
        r6 = null;
        goto L17
    L5:
        r1 = null;
        goto L7
    }

    @JvmStatic
    public static final void f(f r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r6, "region");
        Intrinsics.checkNotNullParameter("BaseMultiLinkWindowManager", "tag");
        boolean r2 = false;
        if (e(r8) == true) goto L6;
        r6.t = false;
        return;
    L6:
        String r0 = jc1.k.n(IKtvService.class).getKtvRoomCurrentSingerIdStr();
        InteractiveSongContext r3 = InteractiveSongContext.Companion.getContext();
        if (r3 == null) goto L12;
        m<String> r4 = r3.getSingingGuestId();
        if (r4 == null) goto L12;
        String r5 = (String) r4.getValue();
        if (r5 == null) goto L12;
    L13:
        b.a("BaseMultiLinkWindowManager", "setSpatialAudioInfoToRegionForMixStream singerId " + r0.toString() + " orderSingerId : " + r5);
        if ((!Intrinsics.areEqual(r0, d(r6.b))) == true) goto L16;
    L18:
        r6.t = r2;
        y0 r10 = SpatialAudioStrategyManager.c.a().b(r8, r9, r7, null);
        b.a("BaseMultiLinkWindowManager", "mixStream position: " + r9 + " enable " + r2 + " posX == " + r10.a() + " posY == " + r10.b() + " posZ == " + r10.c());
        int r11 = r10.a();
        int r12 = r10.b();
        int r13 = r10.c();
        r6.p = r11;
        r6.q = r12;
        r6.r = r13;
        return;
    L16:
        if ((!Intrinsics.areEqual(r5, d(r6.b))) == false) goto L18;
        r2 = true;
    L12:
        r5 = "";
        goto L13
    }
}
