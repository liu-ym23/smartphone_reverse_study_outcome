package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizType;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public final CompositeDisposable a;

    public g() {
        this.a = new CompositeDisposable();
    }

    public static final String a(g r3) {
        r3.getClass();
        if (((Boolean) o61.a.h.a).booleanValue() == false) goto L5;
        k61.a r4 = o61.a.b;
        if (r4 == null) goto L28;
        boolean r1 = true;
        if (r4.c != LivePerfBizType.Degrade) goto L13;
        boolean r5 = true;
    L14:
        if (r5 != true) goto L28;
        k61.a r6 = o61.a.b;
        if (r6 == null) goto L25;
        LivePerfBizLevel r7 = r6.d;
        if (r7 == null) goto L25;
        if (r7.compareTo(LivePerfBizLevel.P1) >= 0) goto L23;
        r1 = false;
    L23:
        if (r1 == false) goto L25;
    L26:
        if (r7 == null) goto L28;
        return "当前性能状态一般，已为你进行极致优化，重启APP将自动关闭极致流畅看播";
    L25:
        r7 = null;
        goto L26
    L13:
        r5 = false;
    L28:
        return "当前性能状态优秀，无需极致优化，重启APP将自动关闭极致流畅看播";
    L5:
        if (PlatformExpUtils.c().i() == false) goto L7;
        return "开启后将为你屏蔽礼物特效、进房特效等其他高功耗功能，可大幅提升看播流畅性";
    L7:
        return "开启后将为你屏蔽礼物特效、进房特效、全服广播等信息，可大幅提升看播流畅性";
    }

    public static final String b(g r2) {
        r2.getClass();
        if (((Boolean) o61.a.f.a).booleanValue() == true) goto L6;
        return "开启后，将自动为你优化功耗&动画表现，降低性能负载，实现较流畅的看播";
    L6:
        return "当前性能状态一般，已为你进行优化，开关有效期为" + PlatformExpUtils.c().j() + 22825;
    }
}
