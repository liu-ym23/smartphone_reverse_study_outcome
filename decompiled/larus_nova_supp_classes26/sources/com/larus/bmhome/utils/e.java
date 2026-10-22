package com.larus.bmhome.utils;

import com.bytedance.keva.Keva;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import lq9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static boolean a;
    public static final Lazy b = null;

    static {
        a = true;
        b = LazyKt.lazy(new d());
    }

    public static Keva a() {
        return (Keva) b.getValue();
    }

    public static boolean b() {
        com.larus.platform.service.z2 r0 = com.larus.platform.service.z2.a;
        if (r0.m3() == true) goto L5;
    L38:
        return false;
    L5:
        if (r0.disableVoiceInput() == true) goto L38;
        b r1 = r0.getAsrInputEntranceConfig();
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("isColdStart=");
        r3.append(a);
        r3.append(", isAccountNewUser=");
        AccountService r4 = AccountService.a;
        r3.append(r4.isNewUser());
        r3.append(", isKevaNewUser=");
        r3.append(a().getBoolean("is_new_user", false));
        r3.append(", oldUserHasSwitched=");
        r3.append(a().getBoolean("old_user_has_switched_asr", false));
        r3.append(", asrInputEntranceConfig=");
        r3.append(r1);
        r2.i("AsrInputEntrance", r3.toString());
        if (a == false) goto L38;
        a = false;
        if (r1.a() == false) goto L13;
        return true;
    L13:
        if (r4.isNewUser() == true) goto L24;
        if (a().getBoolean("is_new_user", false) == true) goto L24;
        if (r1.d() == false) goto L38;
        if (a().getBoolean("old_user_has_switched_asr", false) == true) goto L38;
        r2.i("AsrInputEntrance", "Old user, force switch");
        a().storeBoolean("old_user_has_switched_asr", true);
        return true;
    L24:
        if (r4.isNewUser() == false) goto L27;
        a().storeBoolean("is_new_user", true);
        a().storeLong("last_force_switch_asr_time", System.currentTimeMillis());
        return false;
    L27:
        long r6 = a().getLong("last_force_switch_asr_time", -1);
        int r5 = a().getInt("force_switch_asr_times", 0);
        long r10 = r1.b();
        int r7 = r1.c();
        long r12 = System.currentTimeMillis() - r6;
        long r8 = 60000;
        long r14 = r12 / r8;
        long r13 = r12 % r8;
        r2.i("AsrInputEntrance", "time interval: " + r14 + ", milliSecondsGap: " + r13 + ", switchedTimes: " + r5);
        if (r10 <= 0) goto L38;
        if (r7 <= 0) goto L38;
        if (r14 > r10) goto L35;
        if (r14 != r10) goto L38;
        if (r13 <= 0) goto L38;
    L35:
        if (r5 >= r7) goto L38;
        r2.i("AsrInputEntrance", "New user force switched");
        a().storeLong("last_force_switch_asr_time", System.currentTimeMillis());
        a().storeInt("force_switch_asr_times", r5 + 1);
        return true;
    }
}
