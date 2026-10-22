package com.bytedance.android.livesdk.gift.platform.business.tray2;

import com.bytedance.android.scope.o;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements o {
    public final Map<String, i02.f> a;

    public final void onStart() {
    }

    public final void onStop() {
        ((LinkedHashMap) this.a).clear();
    }

    public d() {
        this.a = new LinkedHashMap();
    }
}
