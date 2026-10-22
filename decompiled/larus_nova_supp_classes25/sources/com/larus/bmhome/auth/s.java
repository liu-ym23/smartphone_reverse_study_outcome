package com.larus.bmhome.auth;

import com.google.gson.Gson;
import com.larus.bmhome.chat.api.LaunchRequestScene;
import com.larus.bmhome.chat.api.e0;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s implements Function0 {
    public final /* synthetic */ AuthViewModel a;
    public final /* synthetic */ LaunchRequestScene b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ s(AuthViewModel r1, LaunchRequestScene r2, String r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = true;
        this.e = r4;
    }

    public final Object invoke() {
        AuthViewModel r7 = this.a;
        LaunchRequestScene r1 = this.b;
        String r2 = this.c;
        boolean r3 = this.d;
        boolean r4 = this.e;
        AtomicBoolean r5 = AuthViewModel.A;
        r7.U();
        int r6 = AuthViewModel.d.c[r1.ordinal()];
        boolean r8 = true;
        if (r6 == 1) goto L8;
        if (r6 != 2) goto L7;
        r7.O("tourist from:" + r2);
        r7.K("tourist from:" + r2);
        Gson r9 = z0.a;
        z0.l = null;
        z0.m = null;
        z0.n = null;
        z0.o = null;
        r7.Y(r2, r3, r4, true, false, r7.e0(r2, AuthViewModel.C, true));
    L116:
        return Unit.INSTANCE;
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r7.O("login or switch from:" + r2);
        r7.K("login or switch from:" + r2);
        Gson r10 = z0.a;
        z0.l = null;
        z0.m = null;
        z0.n = null;
        z0.o = null;
        String r11 = z0.b();
        if (r11.length() != 0) goto L11;
        boolean r12 = true;
    L12:
        if (r12 == false) goto L14;
        g1 r13 = null;
    L23:
        if (r13 == null) goto L45;
        h0 r14 = r13.c;
        if (r14 == null) goto L45;
        e0 r15 = r13.d;
        j0 r16 = r13.e;
        b r17 = r13.f;
        List r18 = CollectionsKt.listOf(new Object[]{r15, r16, r17});
        if ((r18 instanceof Collection) == true) goto L30;
    L32:
        Iterator r19 = r18.iterator();
    L34:
        if (r19.hasNext() == false) goto L41;
        if (r19.next() != null) goto L38;
        boolean r110 = true;
    L39:
        if (r110 == false) goto L34;
        boolean r111 = true;
    L42:
        if (r111 == true) goto L45;
        LaunchInfo r112 = AuthViewModel.L(r14, r15, r16, r17, null);
    L46:
        if (r112 == null) goto L55;
        AccountService r20 = AccountService.a;
        if (r20.isLogin().booleanValue() == true) goto L51;
        r112.J1();
    L51:
        if (r112.z1() != UserBanStatus.Mute.getValue()) goto L53;
        boolean r21 = true;
    L54:
        r20.y(r21);
        e0 r22 = (e0) r7.q.getValue();
        r7.q.setValue(new e0(r112, 2, r2, null));
        goto L55
    L53:
        r21 = false;
    L55:
        if (r13 == null) goto L69;
        h0 r113 = r13.c;
        if (r113 == null) goto L60;
        r7.r.setValue(new c1(LaunchBiz.CORE, 2, r2, r113, true, 16));
    L60:
        e0 r114 = r13.d;
        if (r114 == null) goto L63;
        r7.s.setValue(new c1(LaunchBiz.BASIC, 2, r2, r114, true, 16));
    L63:
        j0 r115 = r13.e;
        if (r115 == null) goto L66;
        r7.t.setValue(new c1(LaunchBiz.IM, 2, r2, r115, true, 16));
    L66:
        b r116 = r13.f;
        if (r116 == null) goto L70;
        r7.u.setValue(new c1(LaunchBiz.AUDIO, 2, r2, r116, true, 16));
    L70:
        if (r13 == null) goto L72;
        h0 r23 = r13.c;
    L73:
        if (r23 == null) goto L75;
        boolean r24 = true;
    L77:
        if (r112 != null) goto L106;
        if (r24 == true) goto L106;
        FLogger.a.i("AuthViewModel", "requestSplitLaunchInfoForLoginOrSwitch no cache, request core first from:" + r2);
        Long r25 = r7.e0(r2, AuthViewModel.C, true);
        if (r3 == true) goto L88;
        if (r13 == null) goto L84;
        h0 r26 = r13.c;
    L85:
        if (r26 != null) goto L88;
        boolean r27 = false;
    L90:
        if (r13 != null) goto L92;
    L104:
        r8 = false;
    L105:
        r7.Y(r2, r27, r4, true, r8, r25);
        goto L116
    L92:
        if (r13.c == null) goto L94;
    L101:
        boolean r28 = true;
    L102:
        if (r28 != true) goto L104;
    L94:
        if (r13.d != null) goto L101;
        if (r13.e != null) goto L101;
        if (r13.f != null) goto L101;
        r28 = false;
        goto L102
    L84:
        r26 = null;
    L88:
        r27 = true;
    L106:
        FLogger r29 = FLogger.a;
        StringBuilder r30 = new StringBuilder("requestSplitLaunchInfoForLoginOrSwitch hit cache, hasFull=");
        if (r112 == null) goto L109;
        boolean r31 = true;
    L110:
        r30.append(r31);
        r30.append(", landing first from:");
        r30.append(r2);
        r29.i("AuthViewModel", r30.toString());
        Set r32 = AuthViewModel.C;
        if (r112 != null) goto L113;
        boolean r33 = true;
    L114:
        Long r34 = r7.e0("launch_cache_async_refresh", r32, r33);
        AuthViewModel.Z(r7, "launch_cache_async_refresh", true, false, false, r34);
        r7.a0("launch_cache_async_refresh", SetsKt.setOf(new LaunchBiz[]{LaunchBiz.BASIC, LaunchBiz.IM, LaunchBiz.AUDIO}), true, r34);
        goto L116
    L113:
        r33 = false;
        goto L114
    L109:
        r31 = false;
        goto L110
    L75:
        r24 = false;
        goto L77
    L72:
        r23 = null;
        goto L73
    L69:
        r112 = r112;
        goto L70
    L38:
        r110 = false;
    L41:
        r111 = false;
        goto L42
    L30:
        if (r18.isEmpty() == false) goto L32;
    L45:
        r112 = null;
        goto L46
    L14:
        boolean r117 = AccountService.a.isLogin().booleanValue();
        LaunchInfo r35 = z0.g();
        if (r35 == null) goto L18;
        g1 r118 = new g1(r11, r117, a1.d(r35), a1.c(r35), a1.e(r35), a1.b(r35));
    L17:
        r13 = r118;
        goto L23
    L18:
        if (r117 == false) goto L20;
        String r36 = "login";
    L21:
        r118 = new g1(r11, r117, (h0) z0.h(z0.i("launch_cache_core_info", r11, r36), h0.class), (e0) z0.h(z0.i("launch_cache_basic_info", r11, r36), e0.class), (j0) z0.h(z0.i("launch_cache_im_info", r11, r36), j0.class), (b) z0.h(z0.i("launch_cache_audio_info", r11, r36), b.class));
        goto L17
    L20:
        r36 = "guest";
        goto L21
    L11:
        r12 = false;
        goto L12
    }
}
