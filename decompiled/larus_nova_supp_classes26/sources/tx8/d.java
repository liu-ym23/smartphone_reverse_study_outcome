package tx8;

import androidx.lifecycle.LifecycleOwner;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface d {
    void a(CameraContainer r1);

    void b(BaseCameraViewModel r1, e r2, LifecycleOwner r3);

    void c(CameraContainer r1);

    String getId();

    com.larus.camera.impl.ui.arch.c getPriority();
}
