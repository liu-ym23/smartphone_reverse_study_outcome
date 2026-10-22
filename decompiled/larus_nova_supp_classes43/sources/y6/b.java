package y6;

import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.web.jsbridge2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class b<T extends f<?, ?>> implements f.b, HybridFragment.a {
    public T a;

    public b() {
    }

    public abstract f<?, ?> b();

    public final f<?, ?> a() {
        f<?, ?> r0 = b();
        if ((r0 instanceof f) == false) goto L5;
        T r1 = (T) r0;
    L6:
        this.a = r1;
        return r0;
    L5:
        r1 = null;
        goto L6
    }
}
