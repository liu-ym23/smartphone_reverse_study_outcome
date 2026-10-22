package i2a;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.upload.k;
import com.larus.camera.impl.ui.component.capture.scan.d;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.platform.api.c4;
import com.larus.platform.model.camera.ve.VeCameraInputParam;
import com.larus.vesdk.api.IVeSDK;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import pq9.h;
import pq9.j;
import pq9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements c4 {
    public static final b b = null;
    public static final Lazy c = null;

    public b() {
    }

    static {
        b = new b();
        c = LazyKt.lazy(new a());
    }

    public static IVeSDK e() {
        return (IVeSDK) c.getValue();
    }

    public final void c() {
        IVeSDK r0 = e();
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "identifier");
        IVeSDK r0 = e();
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    public final Map<String, String> f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "srcPath");
        IVeSDK r0 = e();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g(r2);
    }

    @Override // com.larus.platform.api.c4
    public final void a(Integer r2, long r3) {
        IVeSDK r0 = e();
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    public final j d(FragmentActivity r2, VeCameraInputParam r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "param");
        IVeSDK r0 = e();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f(r2, r3);
    }

    public final void g(Bitmap r2, CameraCaptureViewModel.f r3) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        Intrinsics.checkNotNullParameter(r3, "callback");
        IVeSDK r0 = e();
        if (r0 == null) goto L6;
        r0.j(r2, r3);
        return;
    }

    public final void i(Uri r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "onSuccess");
        IVeSDK r0 = e();
        if (r0 == null) goto L6;
        r0.i(r2, r3);
        return;
    }

    public final String h(Bitmap r2, int r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        IVeSDK r0 = e();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.k(r2, r3, r4);
    }

    public final boolean j(String r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "srcPath");
        Intrinsics.checkNotNullParameter(r3, "dstPath");
        IVeSDK r0 = e();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d(r2, r3, r4);
    }

    public final boolean k(String r8, String r9, String r10, l r11, k r12) {
        Intrinsics.checkNotNullParameter(r8, "identifier");
        Intrinsics.checkNotNullParameter(r9, "videoPath");
        Intrinsics.checkNotNullParameter(r10, "outPath");
        Intrinsics.checkNotNullParameter(r11, "transcodeParam");
        Intrinsics.checkNotNullParameter(r12, "callback");
        IVeSDK r1 = e();
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.l(r8, r9, r10, r11, r12);
    }
}
