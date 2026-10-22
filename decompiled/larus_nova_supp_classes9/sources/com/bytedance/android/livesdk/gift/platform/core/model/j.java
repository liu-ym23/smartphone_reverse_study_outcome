package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.livesdk.gift.model.w1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public int a;
    public int b;
    public final List<w1> c;
    public final long d;
    public final int e;
    public final long f;
    public final String g;

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends w1> r2, long r3, int r5, long r6, String r8) {
        Intrinsics.checkNotNullParameter(r2, "giftPages");
        Intrinsics.checkNotNullParameter(r8, "logId");
        this.c = r2;
        this.d = r3;
        this.e = r5;
        this.f = r6;
        this.g = r8;
    }
}
