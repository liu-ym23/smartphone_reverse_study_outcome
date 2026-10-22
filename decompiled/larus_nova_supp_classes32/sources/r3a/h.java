package r3a;

import android.content.Context;
import android.view.OrientationEventListener;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h extends OrientationEventListener {
    public final /* synthetic */ f a;

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int r5) {
        if (r5 != (-1)) goto L5;
        return;
    L5:
        int r0 = this.a.k;
        this.a.getClass();
        int r1 = f.E(r0);
        int r2 = Math.abs(f.E(r5) - f.E(r1));
        if (Math.min(r2, 360 - r2) < 50) goto L9;
        r1 = f.E(((r5 + 45) / 90) * 90);
    L9:
        if (r1 == r0) goto L12;
        this.a.k = r1;
        FLogger.a.i("CameraContextImpl", "gravity sensor rotation changed, orientation=" + r5 + ", rotation=" + r1);
        return;
    }

    public h(f r1, Context r2) {
        this.a = r1;
        super(r2, 2);
    }
}
