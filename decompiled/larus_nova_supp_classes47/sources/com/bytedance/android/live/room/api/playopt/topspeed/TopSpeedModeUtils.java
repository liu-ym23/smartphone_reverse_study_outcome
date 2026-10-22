package com.bytedance.android.live.room.api.playopt.topspeed;

import com.bytedance.android.live.room.api.playopt.topspeed.base.LivePrefStatus;
import com.bytedance.android.live.room.api.playopt.topspeed.base.LiveRiskStatus;
import com.bytedance.android.livesdkapi.service.IPerfBalanceService;
import com.bytedance.keva.Keva;
import fv1.f;
import java.util.Arrays;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class TopSpeedModeUtils {
    public static final Lazy a = null;
    public static final Keva b = null;

    public static f d() {
        return (f) a.getValue();
    }

    static {
        a = LazyKt.lazy(TopSpeedModeUtils$topSpeedConfig$2.INSTANCE);
        b = Keva.getRepo("topspeed_toast_store");
    }

    public static String c() {
        TopSpeedModeManager r0 = TopSpeedModeManager.l;
        int r1 = ((Number) r0.e.a).intValue();
        int r2 = ((Number) r0.f.a).intValue();
        if (r1 != LivePrefStatus.PREF_NORMAL.getCode()) goto L9;
        if (r2 != LiveRiskStatus.HIGH_RISK.getCode()) goto L7;
        return "risk";
    L7:
        return "good";
    L9:
        if (r1 != LivePrefStatus.PREF_MEDIUM.getCode()) goto L12;
        return "not_good";
    L12:
        if (r1 != LivePrefStatus.PREF_SERIOUS.getCode()) goto L14;
        return "poor";
    L14:
        return "";
    }

    public static void f() {
        b.storeString("topspeed_has_toast", "true," + System.currentTimeMillis());
    }

    public static boolean a() {
        return d().a();
    }

    public static boolean b() {
        if (d().a() == true) goto L5;
    L7:
        return false;
    L5:
        if (d().b() == false) goto L7;
        return true;
    }

    public static String e(int r10) {
        StringBuilder r0 = new StringBuilder();
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.c.a).booleanValue() == true) goto L5;
    L6:
        r10 = 0;
    L7:
        if (r10 != 0) goto L9;
        r0.append("开启后，关闭部分直播间功能和后台任务，改善设备卡顿、发热、耗电问题");
    L34:
        return r0.toString();
    L9:
        if (r10 != 1) goto L11;
        r0.append("生效中，正在为你优化性能...");
        goto L34
    L11:
        if (r10 != 2) goto L34;
        IPerfBalanceService r12 = k.f(IPerfBalanceService.class);
        if (r12 == null) goto L16;
        r12.getHeartEffect();
    L16:
        float r3 = -1.0f;
        if (r12 == null) goto L19;
        float r4 = r12.getTimeEffect();
    L20:
        if (r12 == null) goto L22;
        r3 = r12.getSpeedEffect();
    L22:
        float r13 = 0;
        if (r4 <= r13) goto L25;
        StringBuilder r8 = new StringBuilder("手机续航增加 ");
        StringCompanionObject r9 = StringCompanionObject.INSTANCE;
        r8.append(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r4 * 100.0f)}, 1)));
        r8.append("%，");
        r0.append(r8.toString());
    L27:
        if (r3 <= r13) goto L29;
        StringBuilder r14 = new StringBuilder("速度提升");
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        r14.append(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r3 * 100.0f)}, 1)));
        r14.append("%，");
        r0.append(r14.toString());
    L30:
        r0.append("温度恢复正常中");
        goto L34
    L29:
        r0.append("速度提升，");
        goto L30
    L25:
        r0.append("手机续航增加，");
        goto L27
    L19:
        r4 = -1.0f;
        goto L20
    L5:
        if (d().l() == true) goto L7;
        goto L6
    }
}
