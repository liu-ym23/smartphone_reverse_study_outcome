package n50;

import com.bytedance.android.live.core.gl.camera.BaseCamera;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final BaseCamera a;

    public b() {
        i50.b r0 = new i50.b();
        Intrinsics.checkNotNullParameter(r0, NewBroadcastMonitor.STAGE.CAMERA);
        this.a = r0;
    }
}
