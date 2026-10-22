package com.larus.camera.impl.ui.component.result.general;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p extends com.larus.camera.impl.ui.arch.b {
    public static final /* synthetic */ int o = 0;
    public final Lazy m;
    public Job n;

    public static final class a {
    }

    static {
    }

    public p() {
        super(com.larus.camera.impl.ui.arch.c.c, 1);
        this.m = LazyKt.lazy(new o(this));
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraResultViewModel r1 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r1 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r1, h(2131367728), 0, null, 6, null);
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.resultSupportMark() == true) goto L12;
        return;
    L12:
        if (AppHost.a.isOversea() == true) goto L17;
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.e() == false) goto L17;
        p().setText(2131897932);
    L17:
        if (r0.shouldUseMarkSelectMode() == false) goto L20;
        FLogger.a.i("ResultMarkedTipsComponent", "initMarkedTipsView shouldUseMarkSelectMode");
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(new kotlinx.coroutines.flow.v0(r0.isInMarkSelectMode(), r0.isInCropMode(), new ResultMarkedTipsComponent$initMarkedTipsView$1(null)), new ResultMarkedTipsComponent$initMarkedTipsView$2(r0, this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getCurrentBitmap(), new ResultMarkedTipsComponent$initMarkedTipsView$3(r0, this, null)), k());
        return;
    L20:
        if (r0.enableResultDetect() == false) goto L22;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getOnDetectResultChanged(), new ResultMarkedTipsComponent$initMarkedTipsView$4(this, null)), k());
    L23:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.isInCropMode(), new ResultMarkedTipsComponent$initMarkedTipsView$5(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getCurrentBitmap(), new ResultMarkedTipsComponent$initMarkedTipsView$6(r0, this, null)), k());
        return;
    L22:
        r();
        goto L23
    }

    public final TextView p() {
        return (TextView) this.m.getValue();
    }

    public final void q() {
        Job r0 = this.n;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        p().clearAnimation();
        p().setAlpha(1.0f);
        com.larus.utils.e1.x(p());
        this.n = BuildersKt.launch$default(k(), null, null, new ResultMarkedTipsComponent$hideMarkedTipsWithAnimation$1(this, null), 3, null);
    }

    public final void r() {
        p().setAlpha(1.0f);
        boolean r0 = com.larus.camera.impl.utils.l.a;
        boolean r1 = com.larus.camera.impl.utils.l.a;
        if (r1 == true) goto L5;
        com.larus.camera.impl.utils.l.a = true;
    L5:
        FLogger.a.i("ResultMarkedTipsComponent", "tryShowMarkedTips isAlreadyShow=" + r1);
        if (r1 == false) goto L8;
        com.larus.utils.e1.o(p());
        return;
    L8:
        q();
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r2) {
        CameraContainer.b r3 = super.f(r2);
        ((FrameLayout.LayoutParams) r3).width = -1;
        ((FrameLayout.LayoutParams) r3).height = -1;
        return r3;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return r3.inflate(2131562914, r4, false);
    }
}
