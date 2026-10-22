package com.larus.camera.impl.ui.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.api.vlm.VLMIntent;
import com.larus.camera.impl.monitor.CameraEvent;
import com.larus.camera.impl.ui.Scene;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraFragment;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.component.result.general.ResultCropComponent;
import com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent;
import com.larus.camera.impl.ui.component.result.general.ResultSuggestedActionComponent;
import com.larus.camera.impl.ui.component.result.general.edu.ResultEduIntentPreviewComponent;
import com.larus.camera.impl.ui.component.result.general.p;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.utils.w;
import com.larus.platform.api.IVideoController;
import com.larus.utils.logger.FLogger;
import ix8.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;
import org.json.JSONObject;
import wx8.j;
import yx8.b;
import yx8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\b\u0010\f\u001a\u00020\rH\u0014J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u001b\u0010\u0006\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, d2 = {"Lcom/larus/camera/impl/ui/fragment/CameraResultFragment;", "Lcom/larus/camera/impl/ui/base/BaseCameraFragment;", "Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel;", "Lcom/larus/camera/api/CameraResultUiContract;", "<init>", "()V", "vm", "getVm", "()Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel;", "vm$delegate", "Lkotlin/Lazy;", "viewModel", "cameraScene", "Lcom/larus/camera/impl/ui/Scene;", "handleBackPressed", "", "setSuggestedActionBarDimmed", "", "dimmed", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "componentsByDetectIntentScene", "", "Lcom/larus/camera/impl/ui/arch/Component;", "vlmIntent", "Lcom/larus/camera/api/vlm/VLMIntent;", "resolveBottomComponentMode", "Lcom/larus/camera/impl/utils/input/ResultBottomComponentMode;", "onDestroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraResultFragment extends BaseCameraFragment<CameraResultViewModel> implements ex8.a {
    public static final /* synthetic */ int h = 0;
    public final Lazy g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[VLMIntent.values().length];
            r0[VLMIntent.COMMON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[VLMIntent.EDU.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.fragment.CameraResultFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.fragment.CameraResultFragment$onViewCreated$1", f = "CameraResultFragment.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ View $view;
        int label;
        final /* synthetic */ CameraResultFragment this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.fragment.CameraResultFragment$onViewCreated$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CameraResultFragment a;
            public final /* synthetic */ View b;

            public a(CameraResultFragment r1, View r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(Object r3, Continuation r4) {
                d r5 = (d) r3;
                FLogger.a.i("CameraResultFragment", "onDetectIntentSceneChanged: " + r5);
                if ((r5 instanceof d.a) == false) goto L7;
                if (this.a.V90().resultSupportMark() == true) goto L7;
            L31:
                return Unit.INSTANCE;
            L7:
                if ((r5 instanceof d.b) == false) goto L9;
                this.a.V90().updateInputParamAfetrEduIntentDetected();
            L9:
                CameraResultFragment r6 = this.a;
                VLMIntent r7 = r5.a;
                int r0 = CameraResultFragment.h;
                r6.getClass();
                Scene r1 = Scene.CAPTURE;
                int r2 = a.a[r7.ordinal()];
                if (r2 != 1) goto L12;
                ArrayList r8 = new ArrayList();
                b r9 = CameraResultFragment.W90(r7);
                yx8.a r10 = c.a;
                r8.addAll(c.a(r9));
                r8.add(new ResultPreviewComponent());
                if (r6.V90().resultSupportCrop() == false) goto L24;
                r8.add(new ResultCropComponent());
            L24:
                if (r6.V90().getCameraData().getEnableResultSuggestedAction() == false) goto L26;
                r8.add(new ResultSuggestedActionComponent());
            L26:
                r8.add(new p());
            L27:
                View r11 = this.b;
                CameraResultFragment r12 = this.a;
                CameraContainer r13 = (CameraContainer) r11.findViewById(2131367728);
                if (r13 == null) goto L31;
                r13.e(r12.V90(), r12.getViewLifecycleOwner(), r8);
                goto L31
            L12:
                if (r2 != 2) goto L19;
                r8 = new ArrayList();
                b r14 = CameraResultFragment.W90(r7);
                yx8.a r15 = c.a;
                r8.addAll(c.a(r14));
                r8.add(new ResultEduIntentPreviewComponent());
                if ((r14 instanceof b.c) == false) goto L27;
                if (r6.V90().getCameraData().getEnableResultSuggestedAction() == false) goto L27;
                r8.add(new ResultSuggestedActionComponent());
                goto L27
            L19:
                throw new NoWhenBranchMatchedException();
            }
        }

        public AnonymousClass1(CameraResultFragment r1, View r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$view = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$view, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            d1<d> r7 = this.this$0.V90().getOnDetectResultChanged();
            a r2 = new a(this.this$0, this.$view);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public final CameraResultViewModel V90() {
        return (CameraResultViewModel) this.g.getValue();
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraFragment
    public final void onDestroy() {
        Iterator r0 = ((ConcurrentHashMap) j.a.getValue()).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IVideoController) r0.next()).release();
        goto L4
    L6:
        ((ConcurrentHashMap) j.a.getValue()).clear();
        super.onDestroy();
    }

    public CameraResultFragment() {
        final Function0<Fragment> r0 = new CameraResultFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CameraResultViewModel.class), new CameraResultFragment$special$$inlined$viewModels$default$2(r0), new CameraResultFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraFragment
    public final BaseCameraViewModel U90() {
        return V90();
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraFragment
    public final Scene S90() {
        return Scene.RESULT;
    }

    public static b W90(VLMIntent r1) {
        if (w.a() == true) goto L5;
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L14;
        if (r2 != 2) goto L12;
        return b.C0145b.a;
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        return b.a.a;
    L5:
        return new b.c(0);
    }

    @Override // ex8.a
    public final void bS(boolean r2) {
        V90().setSuggestedActionBarDimmed(r2);
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        FLogger.a.i("CameraResultFragment", "[onViewCreated] cameraData: scene=" + V90().getCameraData().getScene() + ", enableResultSuggestedAction=" + V90().getCameraData().getEnableResultSuggestedAction() + ", enableCaptureDetectModeList=" + V90().getCameraData().getEnableCaptureDetectModeList() + ", captureMode=" + V90().getCameraData().getCaptureMode());
        LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()).launchWhenResumed(new AnonymousClass1(this, r4, null));
        if (V90().isFromAlbum() == true) goto L12;
        OutputParam r6 = V90().getCurrentDisplayOutputParam();
        boolean r7 = false;
        if (r6 != null) goto L7;
    L9:
        if (r7 == false) goto L13;
        gx8.b r8 = qx8.a.b.a;
        CameraEvent r9 = CameraEvent.CAPTURE_RESULT;
        JSONObject r0 = new JSONObject();
        r0.put("is_success", "1");
        Unit r1 = Unit.INSTANCE;
        r8.b(r9, r0);
        return;
    L13:
        return;
    L7:
        if (r6.isVideo() == true) goto L9;
        r7 = true;
        goto L9
    }
}
