package com.larus.camera.impl.ui.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.camera.impl.ui.Scene;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraFragment;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.component.video.CaptureRecorderComponent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.utils.album.FastPhotoPickerInCameraManager;
import com.larus.camera.impl.utils.album.m;
import com.larus.platform.api.a0;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
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
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import px8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0016\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0014J\u0006\u0010\u001c\u001a\u00020\u001dR\u001b\u0010\u0005\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/larus/camera/impl/ui/fragment/CameraCaptureFragment;", "Lcom/larus/camera/impl/ui/base/BaseCameraFragment;", "Lcom/larus/camera/impl/ui/viewmodel/CameraCaptureViewModel;", "<init>", "()V", "vm", "getVm", "()Lcom/larus/camera/impl/ui/viewmodel/CameraCaptureViewModel;", "vm$delegate", "Lkotlin/Lazy;", "viewModel", "cameraScene", "Lcom/larus/camera/impl/ui/Scene;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onStop", "initBottomPhotoPickerFragment", "showBottomPhotoPickerManagerInternal", "onDestroy", "onPictureSelected", "result", "", "Lcom/larus/platform/model/album/AlbumSelectItem;", "onBackPressed", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraCaptureFragment extends BaseCameraFragment<CameraCaptureViewModel> {
    public static final /* synthetic */ int h = 0;
    public final Lazy g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.fragment.CameraCaptureFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.fragment.CameraCaptureFragment$onViewCreated$1", f = "CameraCaptureFragment.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ View $view;
        int label;
        final /* synthetic */ CameraCaptureFragment this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.fragment.CameraCaptureFragment$onViewCreated$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ View a;
            public final /* synthetic */ CameraCaptureFragment b;

            public a(View r1, CameraCaptureFragment r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(Object r3, Continuation r4) {
                d r5 = (d) r3;
                CameraContainer r6 = (CameraContainer) this.a.findViewById(2131367728);
                if ((r5 instanceof d.a) == false) goto L10;
                if (((d.a) r5).a == false) goto L10;
                FLogger.a.i("CameraCaptureFragment", "[onViewCreated] enterRecorder");
                this.b.W90().enterRecorder();
                if (r6 == null) goto L10;
                r6.a(new CaptureRecorderComponent(), this.b.W90(), this.b.getViewLifecycleOwner());
            L10:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(CameraCaptureFragment r1, View r2, Continuation<? super AnonymousClass1> r3) {
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
            i1<d> r7 = this.this$0.W90().getRecordingState();
            a r2 = new a(this.$view, this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final CameraCaptureViewModel W90() {
        return (CameraCaptureViewModel) this.g.getValue();
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraFragment
    public final void onDestroy() {
        FLogger.a.i("CameraCaptureFragment", "onDestroy setMobShow showState=false hashcode=" + hashCode());
        WeakReference<a0> r0 = m.a;
        m.b = false;
        super.onDestroy();
    }

    public CameraCaptureFragment() {
        final Function0<Fragment> r0 = new CameraCaptureFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CameraCaptureViewModel.class), new CameraCaptureFragment$special$$inlined$viewModels$default$2(r0), new CameraCaptureFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraFragment
    public final /* bridge */ /* synthetic */ BaseCameraViewModel U90() {
        return W90();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.camera.impl.ui.fragment.a] */
    public final void V90() {
        final FragmentActivity r0 = getActivity();     // Catch: Exception -> L10
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isFinishing() == false) goto L7;
        return;
    L7:
        if (r0.isDestroyed() == true) goto L17;
        WeakReference<a0> r1 = m.a;     // Catch: Exception -> L10
        m.c(r0, W90(), new com.larus.camera.impl.ui.fragment.a(this, r0));     // Catch: Exception -> L10
        return;
    L17:
        return;
    L10:
        e = move-exception;
        FLogger.a.i("CameraCaptureFragment", "showBottomPhotoPickerManagerInternal e=" + e.getMessage());
        g.a.ensureNotReachHere(e);
    }

    public final void onStop() {
        super.onStop();
        if ((W90().getRecordingState().getValue() instanceof d.f) == true) goto L5;
        return;
    L5:
        if (isDetached() == false) goto L7;
        return;
    L7:
        if (isAdded() == false) goto L16;
        FLogger.a.i("CameraCaptureFragment", "[onStop] remove recorder");
        View r0 = getView();
        if (r0 == null) goto L17;
        CameraContainer r1 = (CameraContainer) r0.findViewById(2131367728);
        if (r1 == null) goto L18;
        r1.d(CaptureRecorderComponent.class);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraFragment
    public final Scene S90() {
        return Scene.CAPTURE;
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraFragment
    public final void T90(List<AlbumSelectItem> r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        W90().updateToResultPageConfig("camera_page_icon");
        super.T90(r3);
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        FLogger.a.i("CameraCaptureFragment", "onCreate setMobShow showState=false hashCode=" + hashCode());
        WeakReference<a0> r4 = m.a;
        m.b = false;
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        if (fx8.a.b.contains(W90().getCurrentCaptureMode()) == false) goto L6;
        FLogger.a.i("CameraCaptureFragment", "initBottomPhotoPickerFragment skip scan mode");
    L20:
        LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()).launchWhenResumed(new AnonymousClass1(this, r5, null));
        return;
    L6:
        if (W90().getCameraData().getEnableCaptureAlbum() == true) goto L8;
        FLogger.a.i("CameraCaptureFragment", "initBottomPhotoPickerFragment skip disabled album");
        goto L20
    L8:
        ICameraEventExt r7 = W90().getCameraData().getEventExt();
        if (r7 == null) goto L12;
        String r8 = r7.getConversationId();
        if (r8 == null) goto L12;
    L14:
        if (W90().getShowBottomAlbum() == true) goto L19;
        FastPhotoPickerInCameraManager r2 = FastPhotoPickerInCameraManager.a;
        if (FastPhotoPickerInCameraManager.c(r8) == true) goto L19;
        if (W90().shouldReturnToExistingAlbum() == false) goto L20;
    L19:
        FLogger.a.i("CameraCaptureFragment", "initBottomPhotoPickerFragment showPage hashCode=" + hashCode());
        V90();
        e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(W90().getOnLatestPhotoChanged(), new CameraCaptureFragment$initBottomPhotoPickerFragment$1(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
    L12:
        r8 = "";
        goto L14
    }
}
