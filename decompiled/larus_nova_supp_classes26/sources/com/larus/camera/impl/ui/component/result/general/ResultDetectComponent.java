package com.larus.camera.impl.ui.component.result.general;

import android.animation.Animator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBindings;
import com.larus.camera.impl.databinding.LarusLayoutViewResultDetectComponentBinding;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020\u0006H\u0014J\b\u0010#\u001a\u00020\u0006H\u0014J\b\u0010$\u001a\u00020\u0006H\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\u0006H\u0002J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.H\u0003J\u0014\u0010/\u001a\u00020\u0006*\u00020\u000f2\u0006\u00100\u001a\u000201H\u0002J\u0012\u00102\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u000104H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u00066"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/ResultDetectComponent;", "Lcom/larus/camera/impl/ui/arch/LayerComponent;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "onResume", "onPause", "onStop", "onDestroy", "binding", "Lcom/larus/camera/impl/databinding/LarusLayoutViewResultDetectComponentBinding;", "startLoadingAnimationJob", "Lkotlinx/coroutines/Job;", "mainCameraDetectConfig", "Lcom/larus/platform/model/camera/MainCameraDetectConfig;", "getMainCameraDetectConfig", "()Lcom/larus/platform/model/camera/MainCameraDetectConfig;", "mainCameraDetectConfig$delegate", "Lkotlin/Lazy;", "createView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "createLayoutParams", "Lcom/larus/camera/impl/ui/arch/CameraContainer$LayoutParams;", "gravity", "", "onViewCreated", "onViewDestroyed", "init", "onDetectStarted", "launchStartLoadingAnimationJob", "showLoadingThresholdMs", "", "startDetectAnimation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopDetectAnimation", "interceptTouchEvent", "intercept", "", "adjustDetectAnimationViewBounds", "previewBounds", "Landroid/graphics/Rect;", "onDetectCompleted", "intentDetectResult", "Lcom/larus/camera/api/vlm/VLMIntentDetectResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultDetectComponent extends com.larus.camera.impl.ui.arch.b implements DefaultLifecycleObserver {
    public static final /* synthetic */ int p = 0;
    public LarusLayoutViewResultDetectComponentBinding m;
    public Job n;
    public final Lazy o;

    public static final class a {
    }

    static {
    }

    public final void onCreate(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    public final void onDestroy(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    public final void onPause(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    public final void onResume(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    public final void onStart(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    public final void onStop(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    public ResultDetectComponent() {
        super(com.larus.camera.impl.ui.arch.c.c, 1);
        this.o = LazyKt.lazy(new m());
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        i().addObserver(this);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getResultDetectionStatus(), new ResultDetectComponent$onViewCreated$1(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getResultPreviewBounds(), new ResultDetectComponent$onViewCreated$2(this, null)), k());
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        Job r0 = this.n;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.n = null;
        LarusLayoutViewResultDetectComponentBinding r1 = this.m;
        if (r1 == null) goto L14;
        ResultDetectAnimationView r2 = r1.b;
        if (r2 == null) goto L15;
        Animator r3 = r2.a;
        if (r3 == null) goto L12;
        r3.cancel();
    L12:
        r2.a = null;
        return;
    L15:
        return;
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
        View r5 = r3.inflate(2131562920, r4, false);
        ResultDetectAnimationView r0 = (ResultDetectAnimationView) ViewBindings.findChildViewById(r5, 2131368910);
        if (r0 == null) goto L7;
        FrameLayout r6 = (FrameLayout) r5;
        this.m = new LarusLayoutViewResultDetectComponentBinding(r6, r0);
        return r6;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131368910)));
    }
}
