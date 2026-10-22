package com.bytedance.android.livesdk.gift.platform.core.manager;

import com.bytedance.android.live.gift.GiftType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static a b;
    public final Map<GiftType, ca0.b> a;

    public static a b() {
        if (b != null) goto L6;
        b = new a();
    L6:
        return b;
    }

    public a() {
        this.a = new HashMap();
    }

    public final ca0.b a(GiftType r2) {
        return (ca0.b) ((HashMap) this.a).get(r2);
    }
}
