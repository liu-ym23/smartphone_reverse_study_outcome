package com.larus.api.bussiness;

import com.bytedance.keva.Keva;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final Keva a = null;

    static {
        a = Keva.getRepo("key_remind_dou_yin_authorization", 0);
    }

    public static void a(long r2) {
        a.storeLong("last_remind_timestamp", r2);
    }
}
