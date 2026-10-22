package com.bytedance.android.live.revenue.core.util;

import com.bytedance.android.livesdk.ability.IAbility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public static final class a implements IAbility {
        public final com.bytedance.android.live.revenue.core.a a;

        public final /* synthetic */ void onAbilityClear() {
            IAbility.-CC.$default$onAbilityClear(this);
        }

        public a(com.bytedance.android.live.revenue.core.a r2) {
            Intrinsics.checkNotNullParameter(r2, "instance");
            this.a = r2;
        }
    }

    static {
    }
}
