package p21;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements com.bytedance.android.live.revlink.impl.pk.utils.d {
    public Long a;
    public final com.bytedance.android.live.revlink.impl.global.c b;
    public long c;

    @Override // com.bytedance.android.live.revlink.impl.pk.utils.d
    public final long a() {
        i97.a r0 = i97.a.a;
        long r1 = System.currentTimeMillis();
        long r2 = this.c;
        Long r4 = this.a;
        if (r4 == null) goto L5;
        long r5 = r4.longValue();
    L7:
        return r2 + (r1 - r5);
    L5:
        r5 = r1;
        goto L7
    }

    public final void b() {
        i97.a r0 = i97.a.a;
        long r1 = System.currentTimeMillis();
        long r2 = this.c;
        Long r4 = this.a;
        if (r4 == null) goto L5;
        long r5 = r4.longValue();
    L6:
        this.c = r2 + RangesKt.coerceAtLeast(r1 - r5, 0);
        return;
    L5:
        r5 = r1;
        goto L6
    }

    public e(com.bytedance.android.live.revlink.impl.global.c r3) {
        this.b = r3;
        this.c = 0;
    }
}
