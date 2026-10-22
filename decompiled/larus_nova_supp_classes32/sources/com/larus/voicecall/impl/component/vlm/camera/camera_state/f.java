package com.larus.voicecall.impl.component.vlm.camera.camera_state;

import android.view.TextureView;
import com.larus.voicecall.impl.component.vlm.h1;
import com.larus.voicecall.impl.component.vlm.i1;
import com.ss.android.vesdk.VEDisplaySettings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface f {
    void b(boolean r1);

    boolean c(boolean r1);

    void closeCamera();

    void d(float r1);

    void e(int r1, int r2, VEDisplaySettings.VEDisplayFitMode r3);

    void f(float r1, float r2);

    r3a.l getCurrentState();

    boolean isCameraTorchSupported();

    void j(h1 r1);

    void m(TextureView r1);

    void onDestroy();

    void openCamera();

    void q(i1 r1);
}
