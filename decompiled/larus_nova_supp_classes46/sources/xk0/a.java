package xk0;

import android.view.SurfaceView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements b {
    public final WeakReference<b> a;

    @Override // xk0.b
    public final SurfaceView q1() {
        b r0 = this.a.get();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.q1();
    }

    public a(WeakReference<b> r2) {
        Intrinsics.checkNotNullParameter(r2, "callBackRef");
        this.a = r2;
    }
}
