package qw0;

import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.scope.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements o, a {
    public final HashMap<Object, rw0.a> a;
    public final k b;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // qw0.a
    public final Map<Object, rw0.a> S0() {
        return this.a;
    }

    public d(k r2) {
        Intrinsics.checkNotNullParameter(r2, "roomService");
        this.b = r2;
        this.a = new HashMap();
    }

    @Override // qw0.a
    public final rw0.a Kc(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.a.get(r2);
    }

    @Override // qw0.a
    public final void Ue(Object r2, rw0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, FileUtils.FILTER);
        this.a.put(r2, r3);
    }
}
