package com.larus.camera.impl.ui.viewmodel;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.Window;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.entity.EduIntentMode;
import com.larus.camera.impl.utils.CameraData;
import com.larus.camera.impl.utils.CaptureResultDetectLogic;
import com.larus.platform.AlbumHelper;
import com.larus.platform.api.g3;
import com.larus.platform.model.album.AlbumInputState;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.model.camera.CameraSettings;
import com.larus.platform.model.camera.ve.Ratio;
import com.larus.platform.model.camera.ve.VeCameraInputParam;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.InputDraftSnapshot;
import com.larus.platform.model.preview.MediaEntry;
import com.larus.platform.service.k2;
import com.larus.platform.service.o3;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IChatTraceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m0 implements r0 {
    public final Fragment a;
    public final boolean b;
    public pq9.j c;
    public com.larus.camera.impl.utils.c0 d;
    public com.larus.camera.impl.utils.f e;
    public com.larus.camera.impl.utils.r f;
    public final Lazy g;
    public Function1<? super ActivityResult, Unit> h;
    public final ActivityResultLauncher<Intent> i;
    public final Lazy j;
    public final Lazy k;
    public xx8.c l;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void A0() {
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.A0();
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final Bundle B() {
        return this.a.getArguments();
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void C() {
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.C();
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void E0() {
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.E0();
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final Bitmap G() {
        pq9.k r1 = pq9.k.a;
        Ratio r2 = Ratio.RATIO_3_4;
        r1.getClass();
        if (new PolarisFileWrapper(pq9.k.a(r2)).exists() == true) goto L7;
        return null;
    L7:
        return BitmapFactory.decodeFile(pq9.k.a(r2));
    }

    public final CameraData.Manager N0() {
        return (CameraData.Manager) this.g.getValue();
    }

    public final CameraSettings O0() {
        return (CameraSettings) this.j.getValue();
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final xx8.c W() {
        if (this.l != null) goto L14;
        pq9.j r0 = this.c;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L11;
        xx8.c r2 = new xx8.b();
    L12:
        this.l = r2;
        goto L14
    L11:
        r2 = new xx8.a();
        goto L12
    L7:
        if (r0.c() != true) goto L9;
        r1 = true;
    L14:
        return this.l;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void closePage() {
        FragmentActivity r0 = this.a.getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isFinishing() == false) goto L7;
        return;
    L7:
        if (r0.isDestroyed() == true) goto L12;
        r0.finish();
        return;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final boolean g() {
        pq9.j r0 = this.c;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.g();
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final boolean g0() {
        CaptureResultDetectLogic r0 = CaptureResultDetectLogic.a;
        return CaptureResultDetectLogic.a(y0());
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final String getFlashMode() {
        pq9.j r0 = this.c;
        if (r0 == null) goto L6;
        String r1 = r0.getFlashMode();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final int getRenderFps() {
        pq9.j r0 = this.c;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.t();
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void i() {
        pq9.j r0 = this.c;
        if (r0 == null) goto L6;
        r0.i();
        return;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void r() {
        pq9.j r0 = this.c;
        if (r0 == null) goto L6;
        r0.u();
        return;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void s0() {
        pq9.j r0 = this.c;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void switchCamera() {
        pq9.j r0 = this.c;
        if (r0 == null) goto L6;
        r0.switchCamera();
        return;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final boolean t() {
        com.larus.camera.impl.utils.f r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("albumService");
        r0 = null;
    L6:
        return r0.i;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.r0
    public final void t0() {
        pq9.j r0 = this.c;
        if (r0 == null) goto L5;
        r0.o();
    L5:
        com.larus.camera.impl.utils.c0 r1 = this.d;
        if (r1 == null) goto L12;
        r1.a = new com.larus.camera.impl.utils.b0();
        com.larus.camera.impl.utils.d0 r2 = r1.c;
        if (r2 == null) goto L10;
        r2.disable();
    L10:
        r1.c = null;
        return;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final int u0() {
        com.larus.camera.impl.utils.f r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("albumService");
        r0 = null;
    L5:
        boolean r1 = r0.i;
        if (r1 == false) goto L10;
        if (r1 == true) goto L12;
        return 1;
    L12:
        return r0.j - t.e();
    L10:
        return -1;
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void y() {
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.y();
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final StateFlowImpl E() {
        return N0().b;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final boolean u() {
        if (N0().a().getEnableFocusFrame() == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(N0().a().getCaptureMode(), "CAPTURE_MODE_PHOTO") == false) goto L7;
        return true;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final CameraData y0() {
        return N0().a();
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final Fragment getCurrentFragment() {
        return this.a;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final Fragment h0() {
        return this.a;
    }

    public static View M0(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final boolean B0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        com.larus.camera.impl.utils.f r3 = this.e;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("albumService");
        r3 = null;
    L5:
        r3.getClass();
        k2 r4 = k2.a;
        return g3.a.d();
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void C0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.C0(r2);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void F(String r4) {
        Intrinsics.checkNotNullParameter(r4, "captureMode");
        com.larus.camera.impl.utils.f r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("albumService");
        r1 = null;
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "captureMode");
        if (r1.k.contains(r4) == false) goto L8;
        r1.i = r1.c;
    L9:
        FLogger.a.i("AlbumManager", "updateMultiPickConfig supportMultiPick=" + r1.i);
        return;
    L8:
        r1.i = false;
        goto L9
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void I(String r2) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.I(r2);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void I0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.I0(r2);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void K(String r2) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.K(r2);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void L(String r2) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.L(r2);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void N(String r2) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.N(r2);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void O(Integer r2) {
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.b = r2;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void R(boolean r15) {
        final FragmentActivity r0 = this.a.getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        Window r1 = r0.getWindow();
        if (r1 != null) goto L9;
        return;
    L9:
        if (Build.VERSION.SDK_INT >= 24) goto L11;
    L13:
        boolean r2 = false;
    L14:
        z2 r3 = z2.a;
        r3.w3();
        int r5 = com.larus.utils.u.c(r0);
        FLogger r6 = FLogger.a;
        r6.i("CameraViewModelAbility", "updatePageStyle " + r0 + " immersive=" + r15 + " statusBarHeight=" + com.larus.utils.u.c(r0) + ", isInMultiWindowMode=" + r2 + ", enableSmallWindowTopPaddingFix=false");
        if (r15 == false) goto L17;
        r1.setBackgroundDrawableResource(R.color.transparent);
        View r16 = M0(r1);
        int r4 = r16.getPaddingStart();
        int r7 = r16.getPaddingEnd();
        r6.i("updatePaddingRelative", "view:" + r16.getClass().getSimpleName() + ",source:,start:" + r4 + ",top:0,end:" + r7 + ",bottom:0");
        r16.setPaddingRelative(r4, 0, r7, 0);
        return;
    L17:
        r1.setBackgroundDrawableResource(2131103292);
        if (r3.getCameraTopPaddingFixConfig() == false) goto L20;
        View r17 = M0(r1);
        int r11 = r17.getPaddingStart();
        int r12 = r17.getPaddingEnd();
        r6.i("updatePaddingRelative", "view:" + r17.getClass().getSimpleName() + ",source:,start:" + r11 + ",top:" + r5 + ",end:" + r12 + ",bottom:0");
        r17.setPaddingRelative(r11, r5, r12, 0);
        M0(r1).setOnApplyWindowInsetsListener(new d0(r0));
        return;
    L20:
        View r18 = M0(r1);
        int r8 = r18.getPaddingStart();
        int r9 = r18.getPaddingEnd();
        r6.i("updatePaddingRelative", "view:" + r18.getClass().getSimpleName() + ",source:,start:" + r8 + ",top:" + r5 + ",end:" + r9 + ",bottom:0");
        r18.setPaddingRelative(r8, r5, r9, 0);
        return;
    L11:
        if (r0.isInMultiWindowMode() == false) goto L13;
        r2 = true;
        goto L14
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.b(r2);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void b0(CameraCaptureViewModel.j r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        pq9.j r0 = this.c;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.c(r2);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void d(float r2) {
        pq9.j r0 = this.c;
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void f(CameraCaptureViewModel.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        pq9.j r0 = this.c;
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void f0(CaptureResultDetectLogic.a r2) {
        Intrinsics.checkNotNullParameter(r2, "mobInfo");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.f0(r2);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void h(float r2) {
        pq9.j r0 = this.c;
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "flashMode");
        pq9.j r0 = this.c;
        if (r0 == null) goto L6;
        r0.j(r2);
        return;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void l0(Function1<? super CameraData, CameraData> r3) {
        Intrinsics.checkNotNullParameter(r3, "update");
        CameraData.Manager r1 = N0();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "update");
        r1.c((CameraData) r3.invoke(r1.b.getValue()));
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void o(String r2) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.o(r2);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final Bitmap p0(String r2) {
        Intrinsics.checkNotNullParameter(r2, MusicAppletPage.KEY_PATH);
        return com.larus.camera.impl.utils.e0.a(r2);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final Bitmap s(String r10) {
        Intrinsics.checkNotNullParameter(r10, MusicAppletPage.KEY_PATH);
        com.larus.camera.impl.utils.f r1 = this.e;
        Object r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("albumService");
        r1 = null;
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, MusicAppletPage.KEY_PATH);
        FLogger.a.i("AlbumManager", "[getFirstBitmapFromVideoPath] path:" + r10);
        MediaMetadataRetriever r0 = new MediaMetadataRetriever();
        r0.setDataSource(r10);     // Catch: Throwable -> L8 Exception -> L10
        Bitmap r11 = r0.getFrameAtTime(0);     // Catch: Throwable -> L8 Exception -> L10
    L21:
        r0.release();
        return r11;
    L10:
        e = move-exception;
        FLogger.a.e("AlbumManager", "[getFirstBitmapFromVideoPath] e:" + e.getMessage());     // Catch: Throwable -> L8
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        r0.setDataSource(r10);     // Catch: Throwable -> L14
        Object r12 = Result.constructor-impl(r0.getFrameAtTime(0));     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r12) == true) goto L20;
        r2 = r12;
    L20:
        r11 = (Bitmap) r2;     // Catch: Throwable -> L8
    L14:
        th = move-exception;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r0.release();
        throw th;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void x0(String r4) {
        FragmentActivity r0 = this.a.getActivity();
        if (r0 == null) goto L9;
        Intent r1 = new Intent();
        if (r4 == null) goto L7;
        r1.putExtra("preview_delete_image_path", r4);
    L7:
        Unit r5 = Unit.INSTANCE;
        r0.setResult(300001, r1);
        return;
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void z0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.z0(r2);
    }

    public m0(Fragment r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.b = r3;
        this.g = LazyKt.lazy(new h0(this));
        this.h = new i0();
        this.i = r2.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new j0(this));
        this.j = LazyKt.lazy(new k0());
        this.k = LazyKt.lazy(new l0());
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void D0(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.D0(r2, r3);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void G0(boolean r3, CameraCaptureViewModel.i r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        pq9.j r0 = this.c;
        if (r0 == null) goto L6;
        r0.k(r3, r4, false);
        return;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void H(String r2, Bitmap r3) {
        Intrinsics.checkNotNullParameter(r2, MusicAppletPage.KEY_PATH);
        com.larus.camera.impl.utils.e0.b(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void H0(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.H0(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void K0(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.K0(r2, r3);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final Pair<Bitmap, Boolean> P(Context r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        com.larus.camera.impl.utils.f r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("albumService");
        r1 = null;
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "context");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Uri r9 = com.larus.camera.impl.utils.f.e(r7, r8);     // Catch: Throwable -> L12
        FLogger.a.i("AlbumManager", "getLatestPhotoBitmap uri=" + r9 + " lastUri=" + r1.n);     // Catch: Throwable -> L12
        Bitmap r10 = com.larus.camera.impl.utils.f.c(r7, r9);     // Catch: Throwable -> L12
        if (Intrinsics.areEqual(r9, r1.n) == true) goto L9;
        boolean r2 = true;
    L10:
        r1.n = r9;     // Catch: Throwable -> L12
        Object r11 = Result.constructor-impl(TuplesKt.to(r10, Boolean.valueOf(r2)));     // Catch: Throwable -> L12
    L15:
        if (Result.exceptionOrNull-impl(r11) == null) goto L19;
        FLogger.a.e("AlbumManager", "getLatestPhotoBitmap fail");
        r11 = TuplesKt.to(null, Boolean.FALSE);
    L19:
        return (Pair) r11;
    L9:
        r2 = false;
    L12:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final Bitmap Q(Context r6, Bitmap r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        com.larus.camera.impl.utils.f r1 = this.e;
        Object r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("albumService");
        r1 = null;
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r7 == null) goto L20;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        RenderScript r8 = RenderScript.create(r6);     // Catch: Throwable -> L10
        Allocation r3 = Allocation.createFromBitmap(r8, r7, Allocation.MipmapControl.MIPMAP_NONE, 1);     // Catch: Throwable -> L10
        Allocation r4 = Allocation.createTyped(r8, r3.getType());     // Catch: Throwable -> L10
        ScriptIntrinsicBlur r5 = ScriptIntrinsicBlur.create(r8, Element.U8_4(r8));     // Catch: Throwable -> L10
        r5.setRadius(25.0f);     // Catch: Throwable -> L10
        r5.setInput(r3);     // Catch: Throwable -> L10
        r5.forEach(r4);     // Catch: Throwable -> L10
        r4.copyTo(r7);     // Catch: Throwable -> L10
        r8.destroy();     // Catch: Throwable -> L10
        Object r9 = Result.constructor-impl(r7);     // Catch: Throwable -> L10
    L12:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 != null) goto L15;
        r2 = r9;
    L17:
        return (Bitmap) r2;
    L15:
        FLogger.a.e("AlbumManager", "blurBitmapWithRenderScript fail: -1 " + r10.getMessage());
    L10:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L20:
        return null;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final Bitmap S(Context r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        com.larus.camera.impl.utils.f r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("albumService");
        r0 = null;
    L5:
        r0.getClass();
        return com.larus.camera.impl.utils.f.c(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void T(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        Intrinsics.checkNotNullParameter(r3, "button");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.T(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void V(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.V(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void Y(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        Intrinsics.checkNotNullParameter(r3, "toCaptureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.Y(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void a0(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.a0(r2, r3);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void e(int r2, CameraCaptureViewModel.a r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        pq9.j r0 = this.c;
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void e0(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.e0(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void k0(OutputParam.ResultType r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "contentType");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.k0(r2, r3);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final Bitmap l(Context r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        com.larus.camera.impl.utils.f r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("albumService");
        r0 = null;
    L5:
        r0.getClass();
        return com.larus.camera.impl.utils.f.d(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void m(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.m(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void m0(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.m0(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void o0(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.o0(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void q(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.q(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void r0(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.r0(r2, r3);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.r0, com.larus.camera.impl.ui.viewmodel.q0
    public void setResult(int r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        FragmentActivity r0 = this.a.getActivity();
        if (r0 == null) goto L6;
        r0.setResult(r2, r3);
        return;
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void v0(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.v0(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void x(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.x(r2, r3);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void D(boolean r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.D(r2, r3, r4);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void J(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter("camera", "currentPage");
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        Intrinsics.checkNotNullParameter(r4, "clickFrom");
        Intrinsics.checkNotNullParameter(r5, "enterMethod");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.J(r3, r4, r5);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void J0(String r2, String r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        Intrinsics.checkNotNullParameter(r3, "button");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.J0(r2, r3, r4);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void M(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        Intrinsics.checkNotNullParameter(r3, "buttonType");
        Intrinsics.checkNotNullParameter(r4, "switchMethod");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.M(r2, r3, r4);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void X(Intent r2, boolean r3, Function1<? super ActivityResult, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        Intrinsics.checkNotNullParameter(r4, "resultCallback");
        this.h = r4;
        this.i.launch(r2);
        if (r3 == false) goto L7;
        FragmentActivity r5 = this.a.getActivity();
        if (r5 == null) goto L11;
        r5.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return;
    L11:
        return;
    L7:
        FragmentActivity r6 = this.a.getActivity();
        if (r6 == null) goto L13;
        r6.overridePendingTransition(0, 0);
        return;
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final String k(Bitmap r2, int r3, pq9.h r4) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        String r5 = o3.b.g(r2, r3, r4);
        if (r5 != null) goto L6;
        return "";
    L6:
        return r5;
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void n0(String r2, Boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.n0(r2, r3, r4);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void p(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "itemType");
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.p(r2, r3, r4);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void w(String r2, String r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        Intrinsics.checkNotNullParameter(r3, "buttonType");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.w(r2, r3, r4);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void w0(boolean r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        Intrinsics.checkNotNullParameter(r4, "leaveReason");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.w0(r2, r3, r4);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void A(int r1, int r2, int r3, int r4) {
        pq9.j r5 = this.c;
        if (r5 == null) goto L6;
        r5.r(r1, r2, r3);
        return;
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void c0(String r2, String r3, Integer r4, Boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "itemType");
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.c0(r2, r3, r4, r5);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void i0(String r2, String r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
        Intrinsics.checkNotNullParameter(r3, "toast");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.i0(r2, r3, r4, r5);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void q0(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "currentPage");
        Intrinsics.checkNotNullParameter(r3, "captureMode");
        Intrinsics.checkNotNullParameter(r4, "enterMethod");
        Intrinsics.checkNotNullParameter(r5, "previousPage");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.q0(r2, r3, r4, r5);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.camera.impl.ui.viewmodel.g0] */
    @Override // com.larus.camera.impl.ui.viewmodel.r0
    public final void v(Function1 r8, final Function1 r9, final Function1 r10, com.larus.camera.impl.ui.base.f r11) {
        Intrinsics.checkNotNullParameter(r8, "cameraInitResult");
        Intrinsics.checkNotNullParameter(r9, "onDegreeChanged");
        Intrinsics.checkNotNullParameter(r10, "onPictureSelected");
        N0().b(B());
        this.d = new com.larus.camera.impl.utils.c0(this.a.requireContext().getApplicationContext(), new g0(r9));
        com.larus.camera.impl.utils.f r12 = new com.larus.camera.impl.utils.f(this.a);
        this.e = r12;
        CameraData r1 = y0();
        Intrinsics.checkNotNullParameter(r1, "cameraData");
        r12.b = r1;
        boolean r2 = r1.getBotSupportAlbumMultiTake();
        r12.c = r2;
        r12.i = r2;
        r1.getAlbumInputText();
        r12.d = r1.getAlbumAttachmentUris();
        r12.e = r1.getAlbumInputSnapshotId();
        r1.getAlbumInputSourceNodeId();
        r12.f = r1.getReturnAlbumNodeId();
        r1.getScene();
        r1.getCaptureMode();
        r12.g = r1.getAddedAttachmentCount();
        dr9.g r3 = dr9.g.a;
        InputDraftSnapshot r4 = dr9.g.d(r12.e);
        if (r4 == null) goto L13;
        List r5 = r4.getAttachments();
        if (r5 == null) goto L13;
        HashSet r6 = new HashSet();
        ArrayList r7 = new ArrayList();
        Iterator r13 = r5.iterator();
    L8:
        if (r13.hasNext() == false) goto L12;
        Object r14 = r13.next();
        if (r6.add(((AttachmentSnapshot) r14).getStableId()) == false) goto L8;
        r7.add(r14);
        goto L8
    L12:
        int r15 = r7.size();
    L14:
        r12.h = r15;
        boolean r16 = false;
        if (r1.getEnableCameraAlbumQuickInput() == true) goto L26;
        String r17 = r12.e;
        if (r17 != null) goto L19;
    L22:
        boolean r18 = true;
    L23:
        if (r18 == false) goto L26;
        boolean r19 = false;
    L27:
        if (r19 == false) goto L29;
        int r20 = Math.max(r12.g, r12.h);
    L30:
        r12.j = RangesKt.coerceAtLeast(r1.getAlbumMultiTakeMaxCount() - r20, 0);
        FLogger r21 = FLogger.a;
        StringBuilder r22 = new StringBuilder("setupMultiPickConfig initSupportMultiPick=");
        r22.append(r12.c);
        r22.append(" supportMultiPick=");
        r22.append(r12.i);
        r22.append(" maxSelectCount=");
        if (r12.i == false) goto L33;
        int r23 = r12.j - t.e();
    L34:
        r22.append(r23);
        r21.i("AlbumManager", r22.toString());
        com.larus.camera.impl.utils.f r24 = this.e;
        pq9.j r25 = null;
        if (r24 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("albumService");
        r24 = null;
    L37:
        Function1 r26 = new e0(r10);
        r24.getClass();
        Intrinsics.checkNotNullParameter(r26, "onPictureSelected");
        ((AlbumHelper) r24.l.getValue()).b(r24.a, "camera", r26);
        com.larus.camera.impl.utils.f r27 = this.e;
        if (r27 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("albumService");
        r27 = null;
    L40:
        Function1 r0 = new f0(this, r10);
        r27.getClass();
        Intrinsics.checkNotNullParameter(r0, "onPictureMultiSelected");
        ((AlbumHelper) r27.l.getValue()).e(r27.a, "camera", r0);
        if (this.b == false) goto L90;
        CameraData.Manager r28 = N0();
        if ((!Intrinsics.areEqual(r28.b.getValue(), CameraData.access$getDEFAULT$cp())) == true) goto L46;
        r28 = null;
    L46:
        if (r28 == null) goto L83;
        CameraData r29 = r28.a();
        if (r29 == null) goto L83;
        VeCameraInputParam r110 = new VeCameraInputParam();
        r110.setFlashMode(r29.getFlashMode());
        r110.setFrontCamera(r29.getUseFontCamera());
        if (O0().getSupport1080p() != 1) goto L52;
        boolean r30 = true;
    L53:
        r110.setUse1080p(r30);
        if (O0().getAsyncDestroyRecorder() != 1) goto L56;
        boolean r31 = true;
    L57:
        r110.setAsyncDestroyRecorder(r31);
        if (O0().getFirstStopPreview() != 1) goto L60;
        boolean r32 = true;
    L61:
        r110.setFirstStopPreview(r32);
        if (O0().getAsyncStopPreview() != 1) goto L64;
        boolean r33 = true;
    L65:
        r110.setAsyncStopPreview(r33);
        if (O0().getAsyncCloseCapture() != 1) goto L68;
        boolean r34 = true;
    L69:
        r110.setAsyncCloseCapture(r34);
        if (Intrinsics.areEqual(r29.getCaptureMode(), "CAPTURE_MODE_SCAN") == false) goto L72;
    L81:
        Ratio r35 = Ratio.RATIO_9_16;
    L82:
        r110.setPreviewRatio(r35);
        r110.setEnableRecorder(zx8.b.b());
        r110.setEnableZoomAnimation(((oq9.d) com.larus.camera.impl.utils.k.a.getValue()).b());
    L84:
        if (r110 == null) goto L86;
        r25 = o3.b.d(this.a.requireActivity(), r110);
    L86:
        this.c = r25;
        if (r25 == null) goto L89;
        r16 = true;
    L89:
        r8.invoke(Boolean.valueOf(r16));
        goto L90
    L72:
        if (zx8.b.h == false) goto L74;
    L77:
        boolean r36 = true;
    L78:
        if (r36 == false) goto L81;
        r35 = Ratio.RATIO_3_4;
        goto L82
    L74:
        if (((oq9.f) zx8.b.b.getValue()).c == true) goto L77;
        r36 = false;
        goto L78
    L68:
        r34 = false;
        goto L69
    L64:
        r33 = false;
        goto L65
    L60:
        r32 = false;
        goto L61
    L56:
        r31 = false;
        goto L57
    L52:
        r30 = false;
    L83:
        r110 = null;
    L90:
        this.f = new com.larus.camera.impl.utils.r(y0().getEventExt(), r11);
        return;
    L33:
        r23 = 1;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L19:
        if (StringsKt.isBlank(r17) == true) goto L22;
        r18 = false;
    L26:
        r19 = true;
    L13:
        r15 = CollectionsKt.distinct(r12.d).size();
        goto L14
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void Z(String r8, String r9, Boolean r10, Integer r11, Boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "captureMode");
        Intrinsics.checkNotNullParameter(r9, "buttonType");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.Z(r8, r9, r10, r11, r12);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void j0(String r8, String r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "captureMode");
        Intrinsics.checkNotNullParameter(r9, "zoomButtonType");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.j0(r8, r9, r10, r11, r12);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void n(String r8, String r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "buttonName");
        Intrinsics.checkNotNullParameter(r9, "currentPage");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.n(r8, r9, r10, r11, r12);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void z(SurfaceHolder r9, CameraCaptureViewModel.d r10, pq9.b r11, Boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r9, "surfaceHolder");
        int r3 = O0().getVeLogLevel();
        pq9.j r1 = this.c;
        if (r1 == null) goto L6;
        r1.q(r9, r3, r10, r11, r12, r13);
        return;
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void F0(boolean r9, boolean r10, String r11, Boolean r12, Boolean r13, EduIntentMode r14) {
        Intrinsics.checkNotNullParameter(r11, "captureMode");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.F0(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void U(String r9, String r10, String r11, String r12, JSONObject r13, by7.e r14) {
        Intrinsics.checkNotNullParameter(r13, "params");
        com.larus.camera.impl.utils.r r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r0 = null;
    L5:
        r0.U(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.larus.camera.impl.ui.viewmodel.q0
    public final void d0(boolean r20, Integer r21, String r22, boolean r23, b r24, c r25) {
        Intrinsics.checkNotNullParameter(r24, "onSuccess");
        Intrinsics.checkNotNullParameter(r25, "onFail");
        com.larus.camera.impl.utils.f r2 = this.e;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("albumService");
        r2 = null;
    L5:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r24, "onSuccess");
        Intrinsics.checkNotNullParameter(r25, "onFail");
        CameraData r0 = r2.b;
        boolean r1 = true;
        if (r0 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == true) goto L13;
    L15:
        boolean r4 = false;
    L16:
        AlbumHelper r7 = (AlbumHelper) r2.l.getValue();
        Fragment r8 = r2.a;
        AlbumSettingConfig.a r10 = new AlbumSettingConfig.a();
        if (r2.i == false) goto L19;
        int r11 = r2.j - t.e();
    L20:
        r10.d = r11;
        r10.f = "camera_page_icon";
        r10.i = r20;
        if (r21 != null) goto L23;
        Integer r12 = 0;
    L24:
        r10.j = r12;
        r10.c = r2.i;
        r10.x = r23;
        r10.k = r4;
        if (r4 == true) goto L27;
        AlbumInputState r13 = null;
    L33:
        r10.b(r13);
        String r14 = r2.f;
        if (uy8.b.c() == true) goto L36;
    L38:
        boolean r15 = false;
    L39:
        if (r15 == true) goto L42;
        r14 = null;
    L42:
        if (r14 != null) goto L44;
        r14 = "";
    L44:
        r10.b = r14;
        CameraData r16 = r2.b;
        if (r16 != null) goto L47;
    L49:
        boolean r17 = false;
    L50:
        if (r17 == true) goto L52;
    L54:
        boolean r18 = false;
    L55:
        r10.m = r18;
        CameraData r19 = r2.b;
        if (r19 == null) goto L58;
        Boolean r110 = Boolean.valueOf(r19.getUseUnifiedMediaCanvas());
    L59:
        r10.o = r110;
        CameraData r111 = r2.b;
        if (r111 != null) goto L62;
    L64:
        boolean r112 = false;
    L65:
        if (r112 == true) goto L67;
    L69:
        r1 = false;
    L70:
        r10.n = r1;
        r10.c(MediaEntry.CAMERA_ALBUM);
        r10.q = r4;
        AlbumSettingConfig r113 = r10.a();
        IChatTraceService r5 = (IChatTraceService) r2.m.getValue();
        if (r5 == null) goto L73;
        String r114 = r5.e();
    L74:
        IChatTraceService r6 = (IChatTraceService) r2.m.getValue();
        if (r6 == null) goto L77;
        String r115 = r6.d();
    L78:
        IChatTraceService r9 = (IChatTraceService) r2.m.getValue();
        if (r9 == null) goto L83;
        Integer r26 = r9.f();
        if (r26 == null) goto L83;
        int r116 = r26.intValue();
    L84:
        IChatTraceService r27 = (IChatTraceService) r2.m.getValue();
        if (r27 == null) goto L87;
        String r117 = r27.b();
    L88:
        AlbumHelper.f(r7, r8, r113, r24, r25, r114, r115, r116, r117, "camera", r22, null, null, 3072);
        return;
    L87:
        r117 = null;
    L83:
        r116 = 0;
        goto L84
    L77:
        r115 = null;
        goto L78
    L73:
        r114 = null;
        goto L74
    L67:
        if (r2.f() == true) goto L69;
    L62:
        if (r111.getMobilePreviewHostEnabled() != true) goto L64;
        r112 = true;
        goto L65
    L58:
        r110 = null;
        goto L59
    L52:
        if (r2.f() == true) goto L54;
        r18 = true;
        goto L55
    L47:
        if (r16.getEnableCameraAlbumUnifiedPreview() != true) goto L49;
        r17 = true;
        goto L50
    L36:
        if (kq9.b.c(r14) == false) goto L38;
        r15 = true;
        goto L39
    L27:
        CameraData r118 = r2.b;
        if (r118 == null) goto L30;
        r13 = com.larus.camera.impl.utils.album.e.a(r118);
    L31:
        if (r13 != null) goto L33;
        FLogger.a.e("AlbumManager", "cameraAlbumInputState rejected unavailable snapshot");
        goto L33
    L30:
        r13 = null;
        goto L31
    L23:
        r12 = r21;
        goto L24
    L19:
        r11 = 1;
        goto L20
    L13:
        if (r2.f() == true) goto L15;
        r4 = true;
        goto L16
    L8:
        if (r0.getEnableCameraAlbumQuickInput() != true) goto L10;
        r3 = true;
        goto L11
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void a(String r10, boolean r11, boolean r12, String r13, Boolean r14, Boolean r15, EduIntentMode r16) {
        Intrinsics.checkNotNullParameter(r10, "leaveReason");
        Intrinsics.checkNotNullParameter(r13, "captureMode");
        com.larus.camera.impl.utils.r r1 = this.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r1 = null;
    L5:
        r1.a(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void L0(String r12, String r13, String r14, String r15, String r16, String r17, String r18, JSONObject r19, by7.e r20) {
        Intrinsics.checkNotNullParameter(r19, "params");
        com.larus.camera.impl.utils.r r1 = this.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackService");
        r1 = null;
    L5:
        r1.L0(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }
}
