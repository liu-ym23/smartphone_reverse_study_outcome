package com.bytedance.android.live.profile.standard.honour;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.profile.event.SpreadStateType;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ ProfileStandardHonourWallComponent a;

    public c(ProfileStandardHonourWallComponent r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.profile.event.a r6 = (com.bytedance.android.live.profile.event.a) r5;
        if (r6 == null) goto L17;
        ProfileStandardHonourWallComponent r0 = this.a;
        int r1 = r0.q;
        int r2 = r0.r;
        if (r1 <= r2) goto L18;
        SpreadStateType r7 = r6.a;
        if (r7 != SpreadStateType.Open) goto L12;
        a1.k(r0.f, -2);
        return;
    L12:
        if (r7 != SpreadStateType.Close) goto L16;
        int r3 = r1 - r2;
        int r8 = (r0.f.getHeight() - (r0.l * r3)) - (r3 * UtilityKotlinExtentionsKt.i(6));
        a1.k(r0.f, r8);
        return;
    L16:
        return;
    L18:
        return;
    }
}
