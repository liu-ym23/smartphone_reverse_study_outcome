package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x implements com.bytedance.android.scope.o {
    public final Map<String, Set<String>> a;

    public final void onStart() {
    }

    public final void onStop() {
        ((LinkedHashMap) this.a).clear();
    }

    public x() {
        this.a = new LinkedHashMap();
    }
}
