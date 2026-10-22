package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.x2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v {
    public boolean a;
    public final long b;
    public final long c;
    public final int d;
    public final IBaseBattleSetting e;
    public final x2 f;
    public final int g;

    public v(long r2, long r4, int r6, IBaseBattleSetting r7, x2 r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "setting");
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.a = true;
    }
}
