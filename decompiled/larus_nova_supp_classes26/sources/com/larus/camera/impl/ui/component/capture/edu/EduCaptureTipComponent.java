package com.larus.camera.impl.ui.component.capture.edu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.widget.EduCaptureTipView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class EduCaptureTipComponent extends com.larus.camera.impl.ui.arch.b implements com.larus.camera.impl.ui.component.capture.a {
    public EduCaptureTipView m;
    public final List<String> n;

    public EduCaptureTipComponent() {
        super(com.larus.camera.impl.ui.arch.c.b, 1);
        this.n = fx8.a.d;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r0, h(2131365096), 0, null, 6, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getCaptureModeStatus(), new EduCaptureTipComponent$onViewCreated$1(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getOnOrientationChanged(), new EduCaptureTipComponent$onViewCreated$2(this, null)), k());
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.n;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r2) {
        CameraContainer.b r3 = new CameraContainer.b(-1, -1);
        ((FrameLayout.LayoutParams) r3).gravity = 17;
        return r3;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        com.larus.camera.impl.utils.u.a();
        ConstraintLayout r6 = r4.inflate(2131562910, r5, false);
        int r7 = 2131364481;
        if (ViewBindings.findChildViewById(r6, 2131364481) == null) goto L16;
        ConstraintLayout r8 = r6;
        EduCaptureTipView r1 = (EduCaptureTipView) ViewBindings.findChildViewById(r6, 2131371493);
        if (r1 != null) goto L7;
        r7 = 2131371493;
        goto L16
    L7:
        if (((FrameLayout) ViewBindings.findChildViewById(r6, 2131388740)) != null) goto L9;
        r7 = 2131388740;
        goto L16
    L9:
        if (ViewBindings.findChildViewById(r6, 2131389181) == null) goto L12;
        this.m = r1;
        return r8;
    L12:
        r7 = 2131389181;
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
