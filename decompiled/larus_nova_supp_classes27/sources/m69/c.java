package m69;

import com.larus.im.service.audio.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements f {
    public static final c a = null;
    public static final List<f> b = null;

    public c() {
    }

    static {
        a = new c();
        b = new ArrayList();
    }

    @Override // m69.f
    public final void a() {
        Iterator r0 = ((ArrayList) b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).a();
        goto L4
    }

    @Override // m69.f
    public final void b(Map<String, String> r3) {
        Iterator r0 = ((ArrayList) b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).b(r3);
        goto L4
    }

    @Override // m69.f
    public final void c(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Iterator r0 = ((ArrayList) b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).c(r3);
        goto L4
    }

    @Override // m69.f
    public final void d(Integer r3) {
        Iterator r0 = ((ArrayList) b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).d(r3);
        goto L4
    }

    @Override // m69.f
    public final void e(z0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Iterator r0 = ((ArrayList) b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).e(r3);
        goto L4
    }
}
