package tf;

import cf.k;
import cf.o;
import com.bytedance.android.ec.common.api.IPageStateService;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements IPageStateService {
    public final AtomicInteger a;
    public final ConcurrentHashMap<String, WeakReference<o>> b;

    /* JADX INFO: renamed from: tf.a$a, reason: collision with other inner class name */
    public static final class C0200a implements k {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;

        @Override // cf.k
        public final void remove() {
            this.a.b.remove(this.b);
        }

        @Override // cf.k
        public final String getId() {
            return this.b;
        }

        public C0200a(a r1, String r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public a() {
        this.a = new AtomicInteger(0);
        this.b = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.ec.common.api.IPageStateService
    public final o getPageStateListener(String r10) {
        Intrinsics.checkNotNullParameter(r10, "id");
        WeakReference<o> r11 = this.b.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.get();
    }

    @Override // com.bytedance.android.ec.common.api.IPageStateService
    public final k setPageStateListener(o r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        String r0 = String.valueOf(this.a.incrementAndGet());
        this.b.put(r0, new WeakReference(r10));
        return new C0200a(this, r0);
    }
}
