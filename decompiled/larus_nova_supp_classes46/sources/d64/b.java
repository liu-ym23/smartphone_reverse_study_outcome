package d64;

import android.app.ActivityManager;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements Supplier<MemoryCacheParams> {
    public final ActivityManager a;

    public final Object get() {
        int r0 = Math.min(this.a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (r0 >= 33554432) goto L6;
        int r2 = 4194304;
    L10:
        return new MemoryCacheParams(r2, 128, r2 / 12, Integer.MAX_VALUE, Integer.MAX_VALUE);
    L6:
        if (r0 >= 67108864) goto L8;
        r2 = 6291456;
        goto L10
    L8:
        r2 = r0 / 8;
        goto L10
    }

    public b(ActivityManager r1) {
        this.a = r1;
    }
}
