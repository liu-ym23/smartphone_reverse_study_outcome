package dq1;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class e {
    public e() {
    }

    public void a(VSCameraInfo r1, VSCameraInfo r2, Bundle r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "targetCamera");
    }

    public void b(VSCameraInfo r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "targetCamera");
    }

    public void c() {
    }

    public void d(VSCameraInfo r1, VSCameraInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "targetCamera");
    }
}
