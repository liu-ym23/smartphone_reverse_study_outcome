package vr8;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements b {
    public final WeakReference<b> a;

    public g(f r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = new WeakReference(r2);
    }

    @Override // vr8.b
    public final void b(com.larus.bmhome.social.page.datasource.event.e.a r2) {
        Intrinsics.checkNotNullParameter(r2, "operation");
        b r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // vr8.b
    public final void a(com.larus.bmhome.social.page.datasource.event.e.a r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "operation");
        b r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4);
        return;
    }
}
