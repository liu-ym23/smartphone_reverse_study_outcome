package wx8;

import com.larus.camera.impl.databinding.LarusLayoutResultVideoViewBinding;
import com.larus.camera.impl.ui.component.result.video.ResultVideoView;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements PlayerProgressView.a {
    public double a;
    public final /* synthetic */ LarusLayoutResultVideoViewBinding b;
    public final /* synthetic */ PlayerProgressView c;
    public final /* synthetic */ ResultVideoView d;

    public final void b() {
        ResultVideoView r0 = this.d;
        r0.b = false;
        r0.c = System.currentTimeMillis();
        FLogger.a.d("ResultVideoView", "[IProgressChangedListener] onProgressChanged, userDragProgress:" + this.a);
        double r4 = (double) 100;
        double r2 = Math.ceil(this.a * r4) / r4;
        VideoPlayView r1 = this.b.f;
        if (r1 == null) goto L11;
        int r3 = (int) (r1.getDuration() * r2);
        VideoPlayView r5 = this.b.f;
        if (r5 == null) goto L7;
        r5.J(r3);
    L7:
        this.c.n6(r3, (int) this.d.d);
        com.larus.camera.impl.ui.component.result.general.viewpager.e r6 = this.d.e;
        if (r6 == null) goto L12;
        r6.b(false);
        return;
    L12:
        return;
    }

    public final void c() {
        ResultVideoView r0 = this.d;
        r0.b = true;
        com.larus.camera.impl.ui.component.result.general.viewpager.e r1 = r0.e;
        if (r1 == null) goto L6;
        r1.b(true);
        return;
    }

    public final void a(double r3) {
        double r0 = 100;
        this.c.n6((int) (this.b.f.getDuration() * (Math.ceil(r3 * r0) / r0)), (int) this.d.d);
    }

    public final void onProgressChanged(double r1) {
        this.a = r1;
    }

    public g(LarusLayoutResultVideoViewBinding r1, PlayerProgressView r2, ResultVideoView r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.a = 1.0d;
    }
}
