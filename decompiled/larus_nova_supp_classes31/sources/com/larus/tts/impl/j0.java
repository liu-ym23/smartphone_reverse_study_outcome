package com.larus.tts.impl;

import com.bytedance.keva.Keva;
import com.larus.platform.api.b;
import com.larus.platform.api.c;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o2;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j0 {
    public static volatile Keva a;

    public static final class a implements b {
        public a() {
        }

        public final void a(c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Keva r3 = j0.a;
            j0.a = null;
        }

        public final void b(c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Keva r3 = j0.a;
            j0.a = null;
        }
    }

    static {
        a r0 = new a();
        AccountService.a.E(r0);
    }

    public static boolean b() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("getMainBotUserChangedTtsSwitch, ");
        Keva r2 = d();
        if (r2 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r2.getBoolean("user_has_changed_tts_switch", false));
    L6:
        r1.append(r3);
        r0.e("SettingRepo", r1.toString());
        Keva r4 = d();
        if (r4 != null) goto L9;
        return false;
    L9:
        return r4.getBoolean("user_has_changed_tts_switch", false);
    L5:
        r3 = null;
        goto L6
    }

    public static Keva d() {
        if (a != null) goto L6;
        a = Keva.getRepo(AccountService.a.getSecUserId() + '_' + o2.a.e(), 0);
    L6:
        return a;
    }

    public static int a() {
        Keva r0 = d();
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.getInt("bot_global_tts_switch", -1);
    }

    public static int c(String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        FLogger.a.e("SettingRepo", "cvs id is null please check code !!!");
        return -1;
    L12:
        Keva r1 = d();
        if (r1 != null) goto L15;
        return -1;
    L15:
        return r1.getInt("bot_tts_switch_" + r4, -1);
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L9
    }
}
