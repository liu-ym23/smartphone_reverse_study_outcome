package q7b;

import android.graphics.drawable.Drawable;
import android.util.LruCache;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final C0280a a = null;

    /* JADX INFO: renamed from: q7b.a$a, reason: collision with other inner class name */
    public static final class C0280a extends LruCache<String, WeakReference<Drawable>> {
        public C0280a() {
            super(10);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r2, WeakReference<Drawable> r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            return 1;
        }
    }

    static {
        a = new C0280a();
    }
}
