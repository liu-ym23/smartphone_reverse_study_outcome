package zt1;

import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import yt1.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements d {
    public final WeakReference<ViewGroup> a;

    @Override // zt1.d
    public final int a() {
        return 1;
    }

    @Override // zt1.d
    public final void b() {
    }

    @Override // zt1.d
    public final void d(o r3, String r4) {
        Intrinsics.checkNotNullParameter("", "biz_data");
        Intrinsics.checkNotNullParameter(r3, "dslData");
        Intrinsics.checkNotNullParameter(r4, "data");
    }

    @Override // zt1.d
    public final ViewGroup c() {
        Intrinsics.checkNotNullParameter("", "biz_data");
        return this.a.get();
    }

    @Override // zt1.d
    public final void e() {
        ViewGroup r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.removeAllViews();
        return;
    }

    public e(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        this.a = new WeakReference(r2);
    }
}
