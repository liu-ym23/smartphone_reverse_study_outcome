package com.bytedance.android.livesdk.gift.platform.business.config;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class e implements m {
    public e() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.m
    public final boolean a(boolean r1, boolean r2, boolean r3) {
        if (r1 == false) goto L7;
        if (r2 == true) goto L6;
        if (r3 == false) goto L7;
    L6:
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.m
    public final void g() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.m
    public boolean h() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.m
    public boolean j(boolean r1) {
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.m
    public final pz1.e d(l2 r2) {
        Intrinsics.checkNotNullParameter(r2, "prop");
        return new pz1.e(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.m
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a l(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "gift");
        return new com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a(r2);
    }
}
