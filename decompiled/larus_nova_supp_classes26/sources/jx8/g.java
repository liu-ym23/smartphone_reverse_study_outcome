package jx8;

import android.app.Activity;
import com.larus.camera.impl.FlowCameraImpl;
import com.larus.camera.impl.result.CameraResultFirstFlow;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ FlowCameraImpl a;
    public final /* synthetic */ List b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Activity d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Activity f;

    public /* synthetic */ g(FlowCameraImpl r1, List r2, Activity r3, String r4, Activity r5) {
        this.a = r1;
        this.b = r2;
        this.c = -1;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowCameraImpl r0 = this.a;
        List r1 = this.b;
        int r2 = this.c;
        Activity r3 = this.d;
        String r4 = this.e;
        Activity r5 = this.f;
        ex8.b r6 = FlowCameraImpl.c;
        r0.getClass();
        Iterator r7 = r1.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        Activity r8 = (Activity) r7.next();
        if (r8.isFinishing() == true) goto L4;
        if (r8.isDestroyed() == true) goto L4;
        FLogger.a.i("FlowCameraImpl", "set empty result and finish camera: ".concat(r8.getClass().getSimpleName()));
        r8.setResult(r2);
        r8.finish();
        r8.overridePendingTransition(0, 0);
        goto L4
    L10:
        if (r3 == null) goto L12;
        CameraResultFirstFlow.a.getClass();
        CameraResultFirstFlow.d(r3, r4);
        return;
    L12:
        if (r5 == null) goto L23;
        com.larus.camera.impl.result.a.a.getClass();
        com.larus.camera.impl.result.a.b(r5, r4);
        return;
    }
}
