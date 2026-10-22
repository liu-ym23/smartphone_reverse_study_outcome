package jx8;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.impl.FlowCameraImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ FlowCameraImpl a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ Fragment c;
    public final /* synthetic */ InputParam d;
    public final /* synthetic */ Fragment e;

    public /* synthetic */ e(FlowCameraImpl r1, FragmentActivity r2, Fragment r3, InputParam r4, Fragment r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowCameraImpl r0 = this.a;
        FragmentActivity r1 = this.b;
        Fragment r2 = this.c;
        InputParam r3 = this.d;
        Fragment r4 = this.e;
        ex8.b r5 = FlowCameraImpl.c;
        r0.getClass();
        FlowCameraImpl.B(r1, r2, r3, r4);
    }
}
