package com.bytedance.android.live.broadcastgame.xplay.servermergecast;

import android.graphics.Rect;
import com.bytedance.android.live.broadcastgame.api.xplay.LiveCoreUtilsKt;
import com.bytedance.android.live.broadcastgame.api.xplay.i;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.k30;
import com.bytedance.android.livesdk.config.li;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveReuseStreamAdaptLandScapeConfig;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.j;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements o, com.bytedance.android.live.broadcastgame.xplay.servermergecast.a {
    public i a;
    public final com.bytedance.android.live.broadcastgame.xplay.littlewindow.b b;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.servermergecast.a
    public final void c() {
        if (this.a != null) goto L15;
        com.bytedance.android.live.pushstream.d r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        j r1 = r0.getLiveStream();
        if (r1 == null) goto L9;
        r4 = (com.bytedance.android.live.pushstream.d) r1.getValue();
    L9:
        if (r4 == null) goto L16;
        d0 r2 = r4.A();
        if (r2 == null) goto L17;
        i r3 = new i();
        LiveCoreUtilsKt.a(r2, r3);
        Unit r5 = Unit.INSTANCE;
        this.a = r3;
        int r6 = XplayLog.a;
        XplayLog.a("XplayLittleWindowCastManager", "backup old push params: " + this.a);
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.servermergecast.a
    public final void d() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        j r1 = r0.getLiveStream();
        if (r1 == null) goto L7;
        com.bytedance.android.live.pushstream.d r2 = (com.bytedance.android.live.pushstream.d) r1.getValue();
    L8:
        if (r2 == null) goto L20;
        d0 r3 = r2.A();
        if (r3 == null) goto L22;
        i r4 = this.a;
        if (r4 != null) goto L15;
        return;
    L15:
        if (((LiveReuseStreamAdaptLandScapeConfig) li.a.getValue()).isEnable() == false) goto L17;
        r2.I();
    L18:
        this.a = null;
        return;
    L17:
        LiveCoreUtilsKt.b(r3, r4);
        goto L18
    L22:
        return;
    L20:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public d(com.bytedance.android.live.broadcastgame.xplay.littlewindow.b r2) {
        Intrinsics.checkNotNullParameter(r2, "littleWindowService");
        this.b = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.servermergecast.a
    public final c a(int r13, int r14) {
        Integer r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        j r1 = r0.getLiveStream();
        if (r1 == null) goto L7;
        com.bytedance.android.live.pushstream.d r2 = (com.bytedance.android.live.pushstream.d) r1.getValue();
    L8:
        boolean r3 = false;
        if (r2 == null) goto L76;
        d0 r5 = r2.A();
        if (r5 == null) goto L76;
        Rect r6 = this.b.d();
        if (r6 != null) goto L16;
        c r15 = new c(0);
        r15.f = 8;
    L73:
        int r16 = XplayLog.a;
        XplayLog.a("XplayLittleWindowCastManager", "update camera mixer desc: " + r15);
        return r15;
    L16:
        Integer r7 = Integer.valueOf(r6.width());
        if (r7.intValue() <= 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == true) goto L23;
        r7 = null;
    L23:
        if (r7 == null) goto L25;
        int r9 = r7.intValue();
    L26:
        Integer r11 = Integer.valueOf(r6.height());
        if (r11.intValue() <= 0) goto L29;
        r3 = true;
    L29:
        if (r3 == true) goto L32;
        r11 = null;
    L32:
        if (r11 == null) goto L34;
        int r12 = r11.intValue();
    L35:
        int r17 = this.b.a().getWidth();
        int r18 = this.b.a().getHeight();
        Integer r19 = (Integer) k30.a.getValue();
        if (r19 != null) goto L39;
    L52:
        if (r19 != null) goto L55;
    L57:
        if (r19 != null) goto L60;
    L68:
        int r21 = r6.left;
        int r22 = r6.top;
        int r23 = XplayLog.a;
        XplayLog.a("XplayStreamMixer", "compute camera mixer desc: sw=" + r17 + ", sh=" + r18 + ", x=" + r21 + ", y=" + r22 + ", w=" + r9 + ", h=" + r12);
        if (this.b.g() == false) goto L71;
        int r24 = (r18 - r14) / 2;
        int r25 = (r17 - r13) / 2;
        int r26 = (r9 + r21) - r25;
        float r110 = r13;
        float r111 = r14;
        float r27 = r26 / r110;
        float r28 = ((r12 + r22) - r24) / r111;
        float r29 = (r21 - r25) / r110;
        float r31 = (r22 - r24) / r111;
    L72:
        r15 = new c(r29, r31, r27, r28, 2, 32);
        goto L73
    L71:
        int r32 = r9 + r21;
        int r33 = r12 + r22;
        float r112 = r17;
        float r113 = r22;
        float r34 = r18;
        r27 = r32 / r112;
        r31 = r113 / r34;
        r28 = r33 / r34;
        r29 = r21 / r112;
        goto L72
    L60:
        if (r19.intValue() != 2) goto L68;
        i r35 = this.a;
        if (r35 == null) goto L66;
        Integer r36 = r35.d();
        if (r36 == null) goto L66;
        int r37 = r36.intValue();
    L67:
        float r38 = r37 / r17;
        float r39 = r9 * r38;
        float r114 = r12 * r38;
        i r41 = new i();
        r41.f(1);
        r41.g(Integer.valueOf(MathKt.roundToInt(r39)));
        r41.e(Integer.valueOf(MathKt.roundToInt(r114)));
        LiveCoreUtilsKt.b(r5, r41);
    L66:
        r37 = 720;
        goto L67
    L55:
        if (r19.intValue() != 1) goto L57;
        i r42 = new i();
        r42.f(1);
        r42.g(Integer.valueOf(r9));
        r42.e(Integer.valueOf(r12));
        LiveCoreUtilsKt.b(r5, r42);
        goto L68
    L39:
        if (r19.intValue() != (-1)) goto L52;
        i r43 = new i();
        i r44 = this.a;
        if (r44 == null) goto L43;
        Integer r45 = r44.b();
    L44:
        r43.f(r45);
        i r46 = this.a;
        if (r46 == null) goto L47;
        Integer r47 = r46.c();
    L48:
        r43.g(r47);
        i r48 = this.a;
        if (r48 == null) goto L51;
        r4 = r48.a();
    L51:
        r43.e(r4);
        LiveCoreUtilsKt.b(r5, r43);
        goto L68
    L47:
        r47 = null;
        goto L48
    L43:
        r45 = null;
        goto L44
    L34:
        r12 = (int) s1.e(130.0f);
        goto L35
    L25:
        r9 = (int) s1.e(90.0f);
        goto L26
    L19:
        r8 = false;
    L76:
        return new c(0);
    L7:
        r2 = null;
        goto L8
    }
}
