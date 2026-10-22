package com.bytedance.android.live.revenue.platform.preference.impl;

import com.bytedance.android.scope.o;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements wz0.b, o {
    public final nr2.a a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public c(nr2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginPropertyService");
        this.a = r2;
    }

    @Override // wz0.b
    public final a U3(final String r3, final Object r4, final Type r5) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r5, "type");
        return new a(new SpongePreferenceService$createSpongePreference$1(this, r3, r5, r4), new SpongePreferenceService$createSpongePreference$2(this, r3, r5), new SpongePreferenceService$createSpongePreference$3(this, r3));
    }
}
