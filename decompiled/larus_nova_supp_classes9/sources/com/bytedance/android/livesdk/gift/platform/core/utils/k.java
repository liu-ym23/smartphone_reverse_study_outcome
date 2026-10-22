package com.bytedance.android.livesdk.gift.platform.core.utils;

import android.os.Build;
import android.os.Debug;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {
    public Disposable a;
    public Map<String, String> b;
    public final boolean c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            Debug.MemoryInfo r6 = new Debug.MemoryInfo();
            Debug.getMemoryInfo(r6);
            if (Build.VERSION.SDK_INT < 23) goto L6;
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("mem_pss_total", String.valueOf(r6.getTotalPss()));
            r0.put("mem_java", r6.getMemoryStat("summary.java-heap"));
            r0.put("mem_native", r6.getMemoryStat("summary.native-heap"));
            r0.put("mem_graphics", r6.getMemoryStat("summary.graphics"));
            this.a.b = r0;
            return;
        }
    }

    public final void a() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = null;
    }

    public final void b() {
        if (this.c == true) goto L5;
        return;
    L5:
        this.b = null;
        Disposable r0 = this.a;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        this.a = Observable.timer(1000, TimeUnit.MILLISECONDS).observeOn(Schedulers.computation()).subscribe(new a(this));
    }

    public k() {
        this.c = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.I.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[33])).booleanValue();
    }
}
