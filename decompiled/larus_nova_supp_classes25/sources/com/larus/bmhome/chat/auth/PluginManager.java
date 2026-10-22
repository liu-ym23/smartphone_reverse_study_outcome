package com.larus.bmhome.chat.auth;

import com.larus.platform.service.AccountService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PluginManager {
    public static final ConcurrentHashMap<String, PluginManager> d = null;
    public static final ConcurrentHashMap<String, String> e = null;
    public static final PluginAuthRepository f = null;
    public final PluginItemPagingCache a;
    public final b b;
    public final n0 c;

    public static final class a {
        public static PluginManager a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "botId");
            ConcurrentHashMap<String, PluginManager> r0 = PluginManager.d;
            StringBuilder r1 = new StringBuilder();
            AccountService r2 = AccountService.a;
            r1.append(r2.getUserId());
            r1.append('_');
            r1.append(r5);
            PluginManager r3 = r0.get(r1.toString());
            if (r3 != null) goto L6;
            PluginManager r4 = new PluginManager(r5);
            r0.put(r2.getUserId() + '_' + r5, r4);
            return r4;
        L6:
            return r3;
        }
    }

    static {
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = new PluginAuthRepository();
    }

    public PluginManager(String r4) {
        this.a = new PluginItemPagingCache(r4, new PluginManager$cache$1(f));
        this.b = new b(r4);
        this.c = new n0();
    }
}
