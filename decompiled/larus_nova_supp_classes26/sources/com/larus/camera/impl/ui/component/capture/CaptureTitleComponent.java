package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.utils.CameraData;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class CaptureTitleComponent extends com.larus.camera.impl.ui.base.k implements a {
    public final List<String> m;

    public void t(String r2) {
        Intrinsics.checkNotNullParameter(r2, "captureMode");
    }

    /* JADX WARN: Type inference failed for: r1v17, types: [com.larus.camera.impl.ui.component.capture.m2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.larus.camera.impl.ui.component.capture.j2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.larus.camera.impl.ui.component.capture.k2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.larus.camera.impl.ui.component.capture.l2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.larus.camera.impl.ui.component.capture.n2, java.lang.Object] */
    @Override // com.larus.camera.impl.ui.arch.b
    public void m() {
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getCaptureModeStatus(), new CaptureTitleComponent$onViewCreated$1(this, null)), k());
        if (((Boolean) r0.multiCaptureStatusFlow().getValue()).booleanValue() == false) goto L8;
        p(new h2(r0));
    L9:
        s(r0);
        ?? r1 = new j2();
        Intrinsics.checkNotNullParameter(r1, "config");
        r1.invoke(h(2131388872));
        ?? r2 = new k2();
        Intrinsics.checkNotNullParameter(r2, "config");
        r2.invoke(h(2131388836));
        ?? r3 = new l2();
        Intrinsics.checkNotNullParameter(r3, "config");
        r3.invoke(h(2131388772));
        CameraData r4 = r0.getCameraData();
        if (r4.getEnableCaptureTitle() == false) goto L18;
        final String r6 = r4.getCameraNameUrl();
        if (com.larus.utils.o0.d(r6) == false) goto L15;
        ?? r5 = new m2(r6);
        Intrinsics.checkNotNullParameter(r5, "config");
        r5.invoke(h(2131388872));
        CameraCaptureViewModel.showCameraItemMobOnCapture$default(r0, "doubao_camera", null, 2, null);
        goto L18
    L15:
        final String r7 = r4.getCameraName();
        if (com.larus.utils.o0.d(r7) == false) goto L18;
        ?? r8 = new n2(r7);
        Intrinsics.checkNotNullParameter(r8, "config");
        r8.invoke(h(2131388836));
        CameraCaptureViewModel.showCameraItemMobOnCapture$default(r0, "doubao_camera", null, 2, null);
    L18:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getOnOrientationChanged(), new CaptureTitleComponent$onViewCreated$2(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.multiCaptureStatusFlow(), new CaptureTitleComponent$onViewCreated$3(this, r0, null)), k());
        return;
    L8:
        p(new i2(r0));
        goto L9
    }

    public CaptureTitleComponent() {
        List<String> r0 = fx8.a.a;
        this.m = CollectionsKt.plus(fx8.a.a, fx8.a.c);
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public List<String> d() {
        return this.m;
    }

    public void s(final CameraCaptureViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        r2.initFlashStatus();
        q(new c2(r2, this));
    }
}
