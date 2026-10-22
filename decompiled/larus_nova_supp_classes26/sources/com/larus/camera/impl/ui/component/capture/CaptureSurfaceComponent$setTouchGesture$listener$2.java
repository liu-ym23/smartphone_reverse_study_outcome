package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class CaptureSurfaceComponent$setTouchGesture$listener$2 extends AdaptedFunctionReference implements Function2<Float, Float, Unit> {
    public CaptureSurfaceComponent$setTouchGesture$listener$2(Object r8) {
        super(2, r8, CameraCaptureViewModel.class, "updateOnSurfaceFling", "updateOnSurfaceFling(FF)Lkotlinx/coroutines/Job;", 8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).floatValue(), ((Number) r2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float r2, float r3) {
        ((CameraCaptureViewModel) ((AdaptedFunctionReference) this).receiver).updateOnSurfaceFling(r2, r3);
    }
}
