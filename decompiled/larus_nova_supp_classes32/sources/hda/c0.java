package hda;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c0 {
    public static final Handler a = null;
    public static final AtomicInteger b = null;
    public static final ExecutorService c = null;
    public static final a d = null;

    public static final class a extends LruCache<String, Bitmap> {
        public a(int r1) {
            super(r1);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r2, Bitmap r3) {
            Bitmap r4 = r3;
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r4, "value");
            return RangesKt.coerceAtLeast(r4.getByteCount() / 1024, 1);
        }
    }

    static {
        a = new Handler(Looper.getMainLooper());
        b = new AtomicInteger();
        c = PThreadExecutorsUtils.newFixedThreadPool(2, new z());
        d = new a(RangesKt.coerceIn(((int) (Runtime.getRuntime().maxMemory() / ((long) 1024))) / 16, 8192, 32768));
    }
}
