package d6;

import android.view.FrameMetrics;
import android.view.Window;
import com.lynx.tasm.ui.image.v;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Window.OnFrameMetricsAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f16597a;

    public b(c r5, String r10) {
        this.f16597a = r5;
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public final void onFrameMetricsAvailable(Window r5, FrameMetrics r10, int r11) {
        c r12 = this.f16597a;
        v r13 = new v(this, new FrameMetrics(r10), r11);
        ((LinkedTransferQueue) r12.g.f17073b).offer(r13);
    }
}
