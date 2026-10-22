package com.larus.camera.impl.ui.component.capture.scan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.utils.i0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import v19.j5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ScanCaptureTipComponent extends com.larus.camera.impl.ui.arch.b implements com.larus.camera.impl.ui.component.capture.a {
    public final List<String> m;

    public ScanCaptureTipComponent() {
        super(com.larus.camera.impl.ui.arch.c.b, 1);
        this.m = fx8.a.b;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        if (AppHost.a.isOversea() == false) goto L5;
        ((TextView) h(2131388735)).setText(j5.a(getContext(), 2131894311, 2131901947));
    L6:
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L9;
        return;
    L9:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getCaptureModeStatus(), new ScanCaptureTipComponent$onViewCreated$1(this, null)), k());
        return;
    L5:
        ((TextView) h(2131388735)).setVisibility(8);
        goto L6
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
        ConstraintLayout r5 = r3.inflate(2131562923, r4, false);
        if (((TextView) ViewBindings.findChildViewById(r5, 2131388735)) == null) goto L7;
        return r5;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131388735)));
    }
}
