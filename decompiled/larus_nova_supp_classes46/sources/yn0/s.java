package yn0;

import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.livesdkapi.util.IScreenRotateMonitor;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s implements l81.s {
    public static final s a = null;

    public s() {
    }

    static {
        a = new s();
    }

    public final void a(DataCenter r2) {
        IScreenRotateService r0 = jc1.k.f(IScreenRotateService.class);
        if (r0 == null) goto L8;
        IScreenRotateMonitor r3 = r0.rotateMonitor(r2);
        if (r3 == null) goto L9;
        r3.markClickToRotate(0);
        return;
    L9:
        return;
    }
}
