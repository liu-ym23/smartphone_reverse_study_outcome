package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x implements dy0.c, com.bytedance.android.scope.o {
    public final Map<String, Map<String, String>> a;
    public final int b;
    public final int c;

    public final void onStart() {
    }

    public final void onStop() {
        ((LinkedHashMap) this.a).clear();
    }

    public x() {
        this.a = new LinkedHashMap();
        ReadOnlyProperty r0 = zz1.d.b;
        KProperty[] r1 = zz1.d.a;
        this.b = ((zz1.b) r0.getValue(null, r1[0])).b();
        this.c = ((zz1.b) r0.getValue(null, r1[0])).a();
    }
}
