package com.bytedance.android.annie.lynx.service.latch;

import com.bytedance.android.annie.service.latch.ILatchService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public final Map<Integer, Pair<ILatchService.e, String>> a;
    public final AtomicInteger b;

    public f() {
        this.a = new LinkedHashMap();
        this.b = new AtomicInteger(0);
    }
}
