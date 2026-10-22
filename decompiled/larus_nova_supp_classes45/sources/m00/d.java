package m00;

import android.view.SurfaceView;
import hh1.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface d extends v0 {

    public static class a {
        public a() {
        }
    }

    void a();

    long b();

    void closeCamera();

    SurfaceView getSurfaceView();

    boolean isCameraOpen();

    void openCamera();

    void switchCamera();
}
