package com.larus.camera.impl.ui.component.capture.scan;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.utils.e1;
import com.larus.utils.i;
import com.larus.utils.i0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ScanCaptureQrCodeAlbumComponent extends com.larus.camera.impl.ui.arch.b implements com.larus.camera.impl.ui.component.capture.a {
    public final List<String> m;
    public ActivityResultLauncher<Intent> n;

    public static final class a {
    }

    static {
    }

    public ScanCaptureQrCodeAlbumComponent() {
        super(com.larus.camera.impl.ui.arch.c.b, 1);
        this.m = fx8.a.b;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        ActivityResultLauncher<Intent> r2 = null;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getCaptureModeStatus(), new ScanCaptureQrCodeAlbumComponent$onViewCreated$1(this, null)), k());
        ComponentActivity r1 = i.getActivity(getContext());
        if ((r1 instanceof ComponentActivity) == false) goto L8;
        ComponentActivity r3 = r1;
    L9:
        if (r3 == null) goto L11;
        r2 = r3.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new com.larus.camera.impl.ui.component.capture.scan.a(this));
    L11:
        this.n = r2;
        e1.d(h(2131380572), new b(this));
        e1.d(h(2131385129), new c(this));
        return;
    L8:
        r3 = null;
        goto L9
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.m;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r2) {
        CameraContainer.b r3 = new CameraContainer.b(-1, -1);
        ((FrameLayout.LayoutParams) r3).gravity = 17;
        i0.a.getClass();
        ((ViewGroup.MarginLayoutParams) r3).bottomMargin = i0.e();
        return r3;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        ConstraintLayout r5 = r3.inflate(2131562922, r4, false);
        int r6 = 2131380572;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131380572)) == null) goto L9;
        r6 = 2131385129;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131385129)) == null) goto L9;
        return r5;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
