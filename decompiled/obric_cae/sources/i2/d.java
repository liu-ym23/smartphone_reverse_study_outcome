package i2;

import android.view.FrameMetrics;
import android.view.Window;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Window.OnFrameMetricsAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f8102a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameMetrics f8103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f8104b;

        public a(d r8, FrameMetrics r10, int r11) {
            this.f8104b = r8;
            this.f8103a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f8103a.getMetric(9) != 0) goto L8;
            b r8 = b.f8089k;
            Iterator r10 = this.f8104b.f8102a.f8093d.iterator();
        L6:
            if (r10.hasNext() == false) goto L10;
            ((com.bytedance.apm.block.a) r10.next()).getClass();
            goto L6
        L10:
            return;
        }
    }

    public d(b r8, String r10) {
        this.f8102a = r8;
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public final void onFrameMetricsAvailable(Window r8, FrameMetrics r10, int r11) {
        b r12 = this.f8102a;
        r12.getClass();
        a r13 = new a(this, new FrameMetrics(r10), r11);
        r12.f8096g.f3042a.offer(r13);
    }
}
