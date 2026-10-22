package p9;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements e {
    public static final a a = null;
    public static final Collection<h> b = null;
    public static final Collection<d> c = null;

    public a() {
    }

    static {
        a = new a();
        b = new CopyOnWriteArrayList();
        c = new CopyOnWriteArrayList();
    }

    @Override // p9.e
    public final void T0(com.bytedance.android.annie.debug.c r10) {
        Intrinsics.checkNotNullParameter(r10, "provider");
        ((CopyOnWriteArrayList) c).add(r10);
    }

    @Override // p9.e
    public final void b0(h r10) {
        Intrinsics.checkNotNullParameter(r10, "provider");
        ((CopyOnWriteArrayList) b).add(r10);
    }
}
