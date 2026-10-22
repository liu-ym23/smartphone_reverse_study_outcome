package com.bytedance.android.live.revenue.platform.preference.impl;

import com.bytedance.android.scope.g;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.o;
import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements o, g {
    public final wz0.b a;

    public static final class a implements com.bytedance.tools.kcp.spongepreference.runtime.b {
        public final /* synthetic */ b b;

        public a(b r1) {
            this.b = r1;
        }

        public final <T> com.bytedance.tools.kcp.spongepreference.runtime.a<T> a(String r2, T r3, Type r4) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r4, "type");
            return this.b.a.U3(r2, r3, r4);
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public b(wz0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "spongePreferenceService");
        this.a = r2;
        com.bytedance.tools.kcp.spongepreference.runtime.b r3 = SpongePreferenceManager.a;
        a r4 = new a(this);
        Intrinsics.checkNotNullParameter(r4, "factory");
        SpongePreferenceManager.a = r4;
    }

    public final boolean c(j r3, j r4) {
        Intrinsics.checkNotNullParameter(r3, "parentScope");
        Intrinsics.checkNotNullParameter(r4, "childScope");
        Intrinsics.checkNotNullParameter(r3, "parentScope");
        Intrinsics.checkNotNullParameter(r4, "childScope");
        return false;
    }
}
