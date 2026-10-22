package com.larus.camera.impl.ui.component.result.general;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.crop.ImageCropView;
import com.larus.camera.impl.databinding.LarusLayoutViewCropComponentBinding;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResultCropComponent extends com.larus.camera.impl.ui.arch.b {
    public LarusLayoutViewCropComponentBinding m;

    public static final class a implements ImageCropView.a {
        public final /* synthetic */ CameraResultViewModel a;

        @Override // com.larus.bmhome.view.crop.ImageCropView.a
        public final void a() {
            CameraResultViewModel.onSingleFunctionEditButtonShow$default(this.a, "modify_range", "picture_crop", "camera_confirm", null, 8, null);
            this.a.clickButton("modify_range", "picture_crop", "drag");
        }

        @Override // com.larus.bmhome.view.crop.ImageCropView.a
        public final void b() {
            this.a.clickButton("modify_range", "picture_crop", "pinch");
        }

        @Override // com.larus.bmhome.view.crop.ImageCropView.a
        public final void c() {
            this.a.setCropRegionChanged(true);
        }

        public a(CameraResultViewModel r1) {
            this.a = r1;
        }
    }

    public ResultCropComponent() {
        super(com.larus.camera.impl.ui.arch.c.c, 1);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        final CameraResultViewModel r1 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r1 != null) goto L5;
        return;
    L5:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r1.isInCropMode(), new ResultCropComponent$onViewCreated$1(this, r1, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r1.m118getBitmapToCrop(), new ResultCropComponent$onViewCreated$2(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r1.getRotation(), new ResultCropComponent$onViewCreated$3(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r1.getCropRegionChanged(), new ResultCropComponent$onViewCreated$4(this, null)), k());
        r1.onCropComponentReady();
        LarusLayoutViewCropComponentBinding r0 = this.m;
        if (r0 == null) goto L10;
        Button r2 = r0.b;
        if (r2 == null) goto L10;
        com.larus.utils.e1.d(r2, new i(this, r1));
    L10:
        LarusLayoutViewCropComponentBinding r3 = this.m;
        if (r3 == null) goto L15;
        ImageCropView r4 = r3.c;
        if (r4 == null) goto L15;
        r4.setClipRegionChangedListener(new a(r1));
    L15:
        CameraResultViewModel.onSingleFunctionEditButtonShow$default(r1, "modify_range", "picture_crop", "camera_confirm", null, 8, null);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r2) {
        CameraContainer.b r3 = super.f(r2);
        ((FrameLayout.LayoutParams) r3).width = -1;
        ((FrameLayout.LayoutParams) r3).height = -1;
        return r3;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r6, "parent");
        ConstraintLayout r7 = r5.inflate(2131562909, r6, false);
        int r8 = 2131364481;
        if (ViewBindings.findChildViewById(r7, 2131364481) == null) goto L15;
        r8 = 2131364727;
        Button r0 = (Button) ViewBindings.findChildViewById(r7, 2131364727);
        if (r0 == null) goto L15;
        ConstraintLayout r9 = r7;
        ImageCropView r2 = (ImageCropView) ViewBindings.findChildViewById(r7, 2131382909);
        if (r2 != null) goto L9;
        r8 = 2131382909;
        goto L15
    L9:
        if (ViewBindings.findChildViewById(r7, 2131389181) == null) goto L12;
        this.m = new LarusLayoutViewCropComponentBinding(r9, r0, r2);
        return r9;
    L12:
        r8 = 2131389181;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r8)));
    }
}
