package com.larus.camera.impl.ui.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import com.larus.camera.impl.utils.CameraData;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface q0 extends com.larus.camera.impl.utils.j0 {
    void A(int r1, int r2, int r3, int r4);

    Bundle B();

    boolean B0(Context r1);

    StateFlowImpl E();

    void F(String r1);

    Bitmap G();

    void G0(boolean r1, CameraCaptureViewModel.i r2);

    void H(String r1, Bitmap r2);

    Pair<Bitmap, Boolean> P(Context r1, boolean r2);

    Bitmap Q(Context r1, Bitmap r2);

    void R(boolean r1);

    Bitmap S(Context r1, Uri r2);

    xx8.c W();

    void X(Intent r1, boolean r2, Function1<? super ActivityResult, Unit> r3);

    void b0(CameraCaptureViewModel.j r1);

    void closePage();

    void d(float r1);

    void d0(boolean r1, Integer r2, String r3, boolean r4, b r5, c r6);

    void e(int r1, CameraCaptureViewModel.a r2);

    void f(CameraCaptureViewModel.b r1);

    boolean g();

    boolean g0();

    Fragment getCurrentFragment();

    String getFlashMode();

    int getRenderFps();

    void h(float r1);

    Fragment h0();

    void i();

    void j(String r1);

    String k(Bitmap r1, int r2, pq9.h r3);

    Bitmap l(Context r1, Uri r2);

    void l0(Function1<? super CameraData, CameraData> r1);

    Bitmap p0(String r1);

    void r();

    Bitmap s(String r1);

    void s0();

    void setResult(int r1, Intent r2);

    void switchCamera();

    boolean t();

    boolean u();

    int u0();

    void x0(String r1);

    CameraData y0();

    void z(SurfaceHolder r1, CameraCaptureViewModel.d r2, pq9.b r3, Boolean r4, boolean r5);
}
