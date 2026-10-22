package com.bytedance.android.live.cloudgrouplive.rtc;

import aj6.d;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ti6.f;
import ti6.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements j {
    public final String a;

    public final /* synthetic */ boolean b(d r1, aj6.b r2) {
        ti6.a.a(r1, r2);
        return false;
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "selfInteractId");
        this.a = r2;
    }

    public final String a(int r3, int r4, List<f> r5) {
        Intrinsics.checkNotNullParameter(r5, "mixRegions");
        r5.clear();
        f r6 = new f();
        r6.a(this.a);
        r6.d = 0.0d;
        r6.e = 0.0d;
        r6.f = 1.0d;
        r6.g = 1.0d;
        r6.o = 1;
        r6.a = 1;
        r6.l = false;
        r5.add(r6);
        return "cloud group live";
    }
}
