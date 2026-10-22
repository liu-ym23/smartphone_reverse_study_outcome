package r3a;

import android.app.Activity;
import android.view.TextureView;
import androidx.fragment.app.Fragment;
import com.larus.voicecall.impl.component.vlm.camera.core.CameraOpenScene;
import com.ss.android.ttve.model.VEFrame;
import com.ss.android.vesdk.VEDisplaySettings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface k {
    void a();

    void b(boolean r1);

    boolean c(boolean r1);

    boolean d(String r1);

    void e(int r1, int r2, VEDisplaySettings.VEDisplayFitMode r3);

    void f(float r1, float r2);

    m g();

    Activity getActivity();

    Fragment getFragment();

    void h();

    void i();

    boolean isCameraTorchSupported();

    p3a.c j();

    boolean k();

    void l(VEFrame r1);

    void m(TextureView r1);

    boolean n();

    void o();

    boolean p(String r1, CameraOpenScene r2);

    boolean q();

    boolean r(boolean r1, String r2);

    void s();

    void t(s3a.a r1);

    void u(float r1);
}
