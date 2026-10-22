package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.livesdk.config.link.InteractFrequencyConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public final InteractFrequencyConfig a;
    public final List<Long> b;
    public long c;

    public final boolean a() {
        if (this.a == null) goto L17;
        long r2 = System.currentTimeMillis();
        if ((r2 - this.c) > (this.a.cdTime * 1000)) goto L7;
        return false;
    L7:
        ((ArrayList) this.b).add(Long.valueOf(r2));
        if (Lists.isEmpty(this.b) == true) goto L17;
        if (((ArrayList) this.b).size() <= this.a.maxCount) goto L17;
        List<Long> r4 = this.b;
        if ((r2 - ((Long) ListProtector.get(r4, ((ArrayList) r4).size() - this.a.maxCount)).longValue()) >= (this.a.gapTime * 1000)) goto L16;
        this.c = r2;
        return false;
    L16:
        List<Long> r3 = this.b;
        ((ArrayList) r3).subList(0, ((ArrayList) r3).size() - this.a.maxCount).clear();
    L17:
        return true;
    }

    public g(InteractFrequencyConfig r3) {
        this.b = new ArrayList();
        this.c = 0;
        this.a = r3;
    }
}
