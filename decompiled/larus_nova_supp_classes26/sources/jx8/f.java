package jx8;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.impl.FlowCameraImpl;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ FlowCameraImpl a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ Fragment c;
    public final /* synthetic */ InputParam d;
    public final /* synthetic */ Fragment e;

    public /* synthetic */ f(FlowCameraImpl r1, FragmentActivity r2, Fragment r3, InputParam r4, Fragment r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke(Object r9) {
        final FlowCameraImpl r2 = this.a;
        final FragmentActivity r1 = this.b;
        final Fragment r3 = this.c;
        final InputParam r4 = this.d;
        final Fragment r5 = this.e;
        boolean r10 = ((Boolean) r9).booleanValue();
        ex8.b r0 = FlowCameraImpl.c;
        FLogger r6 = FLogger.a;
        r6.i("FlowCameraImpl", "checkCameraPermission, result:" + r10);
        if (r10 == false) goto L14;
        if (zx8.b.k == false) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == false) goto L12;
        r6.i("CameraRecordConfigManager", "recordPermission");
        zx8.b.k = true;
        zx8.b.a.storeBoolean("key_permission_out_side_camera", true);
        t0.a.postDelayed(new k(r1, r2, r3, r4, r5), 300);
        goto L14
    L12:
        r2.getClass();
        FlowCameraImpl.B(r1, r3, r4, r5);
        goto L14
    L7:
        if (zx8.b.b() == false) goto L9;
        r11 = true;
    L14:
        return Unit.INSTANCE;
    }
}
