package com.bytedance.android.live.browser.schema.core;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements b {
    public static final RedirectRule c = null;
    public final Map<String, RedirectRule> a;
    public final b b;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.schema.core.a$a, reason: collision with other inner class name */
    public static final class C0130a {
    }

    static {
        c = new RedirectRule(new com.bytedance.android.live.browser.schema.core.strategy.b(-1, "miss placeholder"), null, null);
    }

    public a(RedirectRuleCreator r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.b = r2;
        this.a = new HashMap();
    }

    @Override // com.bytedance.android.live.browser.schema.core.b
    public final RedirectRule get(String r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        monitor-enter(this);
        RedirectRule r2 = (RedirectRule) ((HashMap) this.a).get(r5);     // Catch: Throwable -> L19
        RedirectRule r3 = null;
        if (r2 != null) goto L7;
        RedirectRule r1 = this.b.get(r5);     // Catch: Throwable -> L19
        if (r1 == null) goto L15;
        ((HashMap) this.a).put(r5, r1);     // Catch: Throwable -> L19
        r3 = r1;
    L16:
        com.bytedance.android.live.schema.api.utils.a.a("RedirectRuleCache", "miss cache for " + r5);     // Catch: Throwable -> L19
        monitor-exit(this);
        return r3;
    L15:
        ((HashMap) this.a).put(r5, c);     // Catch: Throwable -> L19
        goto L16
    L7:
        if (r2 != c) goto L9;
        r2 = null;
    L9:
        com.bytedance.android.live.schema.api.utils.a.a("RedirectRuleCache", "hit cache for " + r5);     // Catch: Throwable -> L19
        monitor-exit(this);
        return r2;
    L19:
        th = move-exception;
        throw th;
    }
}
