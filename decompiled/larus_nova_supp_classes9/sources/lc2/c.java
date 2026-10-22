package lc2;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.o;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements o {
    public static final List<d> a = null;
    public static final c b = null;

    public c() {
    }

    static {
        b = new c();
        a = CollectionsKt.listOf(d.a);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.o
    public final void a(f<?> r3, e52.a r4) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r4, "config");
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).a(r3, r4);
        goto L4
    }
}
