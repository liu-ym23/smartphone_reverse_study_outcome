package com.bytedance.android.annie.business.latch;

import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final Map<Integer, Pair<IAnnieBusinessLatchService.b, String>> a;
    public final AtomicInteger b;

    public e() {
        this.a = new LinkedHashMap();
        this.b = new AtomicInteger(0);
    }
}
