package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ad1;
import com.bytedance.android.livesdk.config.ge0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements Consumer {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void accept(Object r11) {
        Long r12 = (Long) r11;
        OpenPlatformPerfDog r13 = OpenPlatformPerfDog.p;
        OpenPlatformPerfDog.h = r13.c();
        OpenPlatformPerfDog.i = r13.a();
        IHostPerformanceMonitor r0 = (IHostPerformanceMonitor) OpenPlatformPerfDog.f.getValue();
        if (r0 == null) goto L5;
        r0.getGpuUsage();
    L5:
        OpenPlatformPerfDog.j = r13.b();
        OpenPlatformPerfDog.k = r13.d();
        jc1.k.n(IPerformanceManager.class).getUIStallDuration();
        OpenPlatformPerfDog.l = r13.getUIStallRate();
        long r1 = OpenPlatformPerfDog.m;
        ge0 r14 = ge0.a;
        OpenPlatformPerfDog.m = r1 + ((long) ((ad1) r14.getValue()).d());
        int r2 = OpenPlatformPerfDog.j;
        float r3 = OpenPlatformPerfDog.l;
        float r4 = OpenPlatformPerfDog.k;
        LiveMode r7 = null;
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L11;
        com.bytedance.live.datacontext.i r6 = r5.getLiveMode();
        if (r6 == null) goto L11;
        r7 = (LiveMode) r6.getValue();
    L11:
        if (r7 == LiveMode.VIDEO) goto L13;
        return;
    L13:
        if (OpenPlatformPerfDog.g == true) goto L16;
        return;
    L16:
        if (r2 != 0) goto L19;
    L21:
        final boolean r8 = false;
    L23:
        if (r3 <= ((Number) OpenPlatformPerfDog.b.getValue()).floatValue()) goto L25;
        final boolean r9 = true;
    L27:
        if (r4 <= ((Number) OpenPlatformPerfDog.c.getValue()).intValue()) goto L29;
        final boolean r15 = true;
    L31:
        if (((ad1) r14.getValue()).g() == false) goto L36;
        if (r8 == true) goto L39;
        if (r9 == true) goto L39;
        if (r15 == true) goto L39;
    L40:
        boolean r16 = false;
    L41:
        if (r16 == false) goto L47;
        int r17 = OpenPlatformPerfDog.e + 1;
        OpenPlatformPerfDog.e = r17;
        if (r17 < OpenPlatformPerfDog.d) goto L50;
        com.bytedance.android.livesdk.utils.c r18 = OpenPlatformPerfDog.n;
        if (r18.a() == true) goto L51;
        UtilityKotlinExtentionsKt.s(0, false, false, new OpenPlatformPerfDog$checkIfShowPerfOverloadToast$1(r8, r9, r15), 7);
        ((ArrayList) r18.a).add(Long.valueOf(System.currentTimeMillis()));
        return;
    L51:
        return;
    L50:
        return;
    L47:
        OpenPlatformPerfDog.e = 0;
        return;
    L39:
        r16 = true;
        goto L41
    L36:
        if (r8 == false) goto L40;
        if (r9 == false) goto L40;
        if (r15 == false) goto L40;
    L29:
        r15 = false;
        goto L31
    L25:
        r9 = false;
        goto L27
    L19:
        if (r2 >= ((Number) OpenPlatformPerfDog.a.getValue()).intValue()) goto L21;
        r8 = true;
        goto L23
    }
}
