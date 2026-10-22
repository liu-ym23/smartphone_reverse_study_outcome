package com.larus.uaigc.spring.lottery;

import com.bytedance.keva.Keva;
import com.larus.platform.service.AccountService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static final Keva a = null;

    static {
        a = Keva.getRepo("lottery_state", 0);
    }

    public static String a(int r2) {
        return "lottery_state_" + AccountService.a.getUserId() + '_' + r2;
    }
}
