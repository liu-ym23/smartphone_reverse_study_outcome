package pq9;

import android.view.SurfaceHolder;
import com.larus.avatar.impl.scan.component.ScanCameraComponent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.platform.model.camera.ve.Ratio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface j {
    void a();

    void b(f r1);

    boolean c();

    void d(float r1);

    void e(int r1, CameraCaptureViewModel.a r2);

    void f(CameraCaptureViewModel.b r1);

    boolean g();

    String getFlashMode();

    void h(float r1);

    void i();

    void j(String r1);

    void k(boolean r1, g r2, boolean r3);

    boolean l(String r1);

    void m(Ratio r1);

    void n(ScanCameraComponent.b r1);

    void o();

    void p();

    void q(SurfaceHolder r1, int r2, CameraCaptureViewModel.d r3, b r4, Boolean r5, boolean r6);

    void r(int r1, int r2, int r3);

    void s(String r1, String r2);

    void switchCamera();

    int t();

    void u();
}
