package nx8;

import android.graphics.Bitmap;
import android.view.View;
import com.larus.camera.impl.edulibs.cameraapi.SceneType;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface m {

    public interface a {
        void a(int r1);
    }

    void a(c r1, boolean r2);

    Bitmap b();

    void c(int r1, boolean r2);

    boolean d();

    void destroy();

    Bitmap e();

    void f(int r1, int r2);

    b g(String r1, int r2, int r3, boolean r4, SceneType r5, String r6, String r7, boolean r8);

    View getView();

    Bitmap h();

    StateFlowImpl i();

    g j(i r1);

    boolean k();

    int l();

    void m(a r1);

    void n(SceneType r1);

    void o(Bitmap r1, String r2, int r3, boolean r4);

    boolean p();

    boolean q();
}
