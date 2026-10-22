package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements com.bytedance.android.scope.o {
    public final Map<String, PriorityQueue<d>> a;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        ((LinkedHashMap) this.a).clear();
    }

    public f() {
        this.a = new LinkedHashMap();
    }
}
