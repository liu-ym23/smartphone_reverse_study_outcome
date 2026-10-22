package com.larus.camera.impl.ui.component.capture;

import android.content.Context;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.larus.camera.impl.FlowCameraImpl;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.ui.viewmodel.ChangeState;
import com.larus.camera.impl.widget.SwipeVerticalView;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001SB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010+\u001a\u00020\u0007H\u0015J\u001c\u0010,\u001a\u00020\u00072\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070.H\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0014H\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\u0010\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0014H\u0002J\u0010\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020/H\u0002J\b\u00107\u001a\u00020\u0007H\u0002J&\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070<H\u0002J\u0010\u0010>\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0014\u0010?\u001a\u00020\u0007*\u00020@2\u0006\u0010A\u001a\u00020BH\u0002J\u0014\u0010C\u001a\u00020\u0007*\u00020@2\u0006\u0010D\u001a\u00020\u0014H\u0002J\u0018\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0014H\u0002J\b\u0010H\u001a\u00020\u0007H\u0014J\u0016\u0010I\u001a\u00020\u00072\f\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u000fH\u0014J&\u0010L\u001a\u00020/2\u000e\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010N0\u000f2\u0006\u0010O\u001a\u00020/H\u0082@¢\u0006\u0002\u0010PJ\b\u0010Q\u001a\u00020\u0007H\u0002J\b\u0010R\u001a\u00020\u0007H\u0002R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b$\u0010!R\u001b\u0010&\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0018\u001a\u0004\b'\u0010\u0016R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/larus/camera/impl/ui/component/capture/CaptureControlComponent;", "Lcom/larus/camera/impl/ui/base/BaseControlComponent;", "Lcom/larus/camera/impl/ui/component/capture/CaptureComponent;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "onPause", "onStop", "onDestroy", "supportedCaptureMode", "", "", "getSupportedCaptureMode", "()Ljava/util/List;", "containerBgColor", "", "getContainerBgColor", "()I", "containerBgColor$delegate", "Lkotlin/Lazy;", "swipeUpArrowPhotoPickerFromAlbumThumbView", "Lcom/larus/camera/impl/widget/SwipeVerticalView;", "getSwipeUpArrowPhotoPickerFromAlbumThumbView", "()Lcom/larus/camera/impl/widget/SwipeVerticalView;", "swipeUpArrowPhotoPickerFromAlbumThumbView$delegate", "arrowPhotoPickerFromAlbumThumbView", "Landroid/view/View;", "getArrowPhotoPickerFromAlbumThumbView", "()Landroid/view/View;", "arrowPhotoPickerFromAlbumThumbView$delegate", "arrowPhotoPickerFromBottomView", "getArrowPhotoPickerFromBottomView", "arrowPhotoPickerFromBottomView$delegate", "arrowBottomViewMaxBottomMargin", "getArrowBottomViewMaxBottomMargin", "arrowBottomViewMaxBottomMargin$delegate", "lastClickTime", "", "onViewCreated", "tryStartRecorder", "onNext", "Lkotlin/Function1;", "", "initArrowToBottomPhotoPicker", "adapterBottomOffset", "initArrowToAlbumThumbListView", "resetArrowFromAlbumThumbVisibilityWhenStateChanged", "changeState", "resetArrowFromAlbumThumbVisibility", "isShow", "initAllArrowToPhotoPickerListener", "calculatePost", "view", "startTimestamp", "callback", "Lkotlin/Function0;", "isFirstChangeWhenResumed", "onResume", "updateImageBitmap", "Landroid/widget/ImageView;", "bitmap", "Landroid/graphics/Bitmap;", "updateImageResource", "resId", "startRotation", "v", "degree", "onHandleCapture", "onHandlePictureSelected", "item", "Lcom/larus/platform/model/album/AlbumSelectItem;", "interceptResultPageOpen", "outputParamList", "Lcom/larus/camera/api/params/OutputParam;", "isFromAlbum", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateCaptureOnActionDown", "animateCaptureOnActionUp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CaptureControlComponent extends com.larus.camera.impl.ui.base.j implements com.larus.camera.impl.ui.component.capture.a, DefaultLifecycleObserver {
    public static final /* synthetic */ int u = 0;
    public final List<String> m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public long s;
    public boolean t;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(o r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
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

    public final void onStart(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    public final void onStop(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.camera.impl.ui.component.capture.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.camera.impl.ui.component.capture.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.camera.impl.ui.component.capture.n0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.larus.camera.impl.ui.component.capture.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.larus.camera.impl.ui.base.i, java.lang.Object] */
    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        final CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        i().addObserver(this);
        final boolean r7 = r0.getCameraData().getEnableCaptureAlbum();
        BaseCameraViewModel.tryAdaptBottomLine$default(r0, h(2131367728), 0, new l0(r7, this), 2, null);
        if (r7 == false) goto L20;
        CameraCaptureViewModel r5 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r5 == null) goto L19;
        ICameraEventExt r6 = r5.getCameraData().getEventExt();
        if (r6 == null) goto L19;
        String r8 = r6.getConversationId();
        if (r8 == null) goto L19;
        if (Intrinsics.areEqual(d(), fx8.a.a) == false) goto L18;
        BuildersKt.launch$default(k(), Dispatchers.getMain(), null, new CaptureControlComponent$initArrowToAlbumThumbListView$1(r5, this, r8, null), 2, null);
        goto L19
    L18:
        A(false);
    L19:
        ((SwipeVerticalView) this.o.getValue()).setOnSwipeListener(new o0(this));
        com.larus.utils.e1.d((View) this.p.getValue(), new j(this));
        com.larus.utils.e1.d(w(), new k(this));
        p(c7.b(16), new m0(this, r0));
        com.larus.camera.impl.ui.base.j.q(this, c7.b(16), x());
    L21:
        int r9 = c7.b(16);
        int r10 = x();
        ?? r11 = new com.larus.camera.impl.ui.base.i();
        Intrinsics.checkNotNullParameter(r11, "config");
        View r12 = h(2131384589);
        FrameLayout r13 = (FrameLayout) r12;
        com.larus.utils.w0.e(r13, r9);
        r13.setBackgroundColor(r10);
        r11.invoke(r12);
        int r3 = c7.b(16);
        ?? r14 = new c(r0);
        Intrinsics.checkNotNullParameter(r14, "config");
        View r15 = h(2131384584);
        ImageView r16 = (ImageView) r15;
        com.larus.utils.w0.e(r16, r3);
        r16.setBackgroundColor(0);
        r14.invoke(r15);
        ?? r2 = new d();
        Intrinsics.checkNotNullParameter(r2, "config");
        r2.invoke(h(2131379442));
        ?? r4 = new e(r0, this);
        Intrinsics.checkNotNullParameter(r4, "config");
        r4.invoke(h(2131379443));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getCaptureModeStatus(), new CaptureControlComponent$onViewCreated$7(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getOnPictureSelected(), new CaptureControlComponent$onViewCreated$8(this, r0, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getOnOrientationChanged(), new CaptureControlComponent$onViewCreated$9(this, null)), k());
        return;
    L20:
        ?? r17 = new n0();
        Intrinsics.checkNotNullParameter(r17, "config");
        r17.invoke(h(2131377775));
        goto L21
    }

    public final View w() {
        return (View) this.q.getValue();
    }

    public final int x() {
        return ((Number) this.n.getValue()).intValue();
    }

    public void y() {
        CameraCaptureViewModel r1 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r1 != null) goto L5;
        return;
    L5:
        r1.leaveCapturePageOnCapture();
        CameraCaptureViewModel.capturePhoto$default(r1, getContext(), true, new CaptureControlComponent$onHandleCapture$1(this), null, 8, null);
    }

    public CaptureControlComponent() {
        List<String> r0 = fx8.a.a;
        this.m = fx8.a.a;
        this.n = LazyKt.lazy(new com.larus.camera.impl.ui.component.capture.b(this));
        this.o = LazyKt.lazy(new m(this));
        this.p = LazyKt.lazy(new x(this));
        this.q = LazyKt.lazy(new h0(this));
        this.r = LazyKt.lazy(new i0());
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public List<String> d() {
        return this.m;
    }

    public final void A(boolean r4) {
        if (r4 == false) goto L7;
        com.larus.utils.e1.x((View) this.p.getValue());
        com.larus.utils.e1.x((SwipeVerticalView) this.o.getValue());
        CameraCaptureViewModel r5 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r5 != null) goto L6;
        return;
    L6:
        CameraCaptureViewModel.showCameraItemMobOnCapture$default(r5, "above_album_icon_arrow", null, 2, null);
        return;
    L7:
        com.larus.utils.e1.o((View) this.p.getValue());
        com.larus.utils.e1.o((SwipeVerticalView) this.o.getValue());
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.camera.impl.ui.component.capture.j0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.camera.impl.ui.component.capture.k0, java.lang.Object] */
    public final void onResume(LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        final CameraCaptureViewModel r5 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.getCameraData().getEnableCaptureAlbum() == true) goto L9;
        r5.resetEnterCapturePageTimer();
        return;
    L9:
        ?? r0 = new j0(r5, this);
        Intrinsics.checkNotNullParameter(r0, "config");
        r0.invoke(h(2131377773));
        ?? r1 = new k0(r5);
        Intrinsics.checkNotNullParameter(r1, "config");
        r1.invoke(h(2131377775));
        r5.resetEnterCapturePageTimer();
    }

    public void z(List<AlbumSelectItem> r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.openResultPageFromAlbum(getContext(), r4, new CaptureControlComponent$onHandlePictureSelected$1(this));
    }

    public static final void s(CaptureControlComponent r2, int r3) {
        r2.getClass();
        if (r3 != ChangeState.SHOW.getState()) goto L6;
        r2.A(false);
        return;
    L6:
        if (r3 != ChangeState.HIDE.getState()) goto L9;
        r2.A(true);
        return;
    L9:
        if (r3 != ChangeState.DEFAULT.getState()) goto L14;
        r2.A(false);
        return;
    }

    public static final void u(CaptureControlComponent r3, p0 r4) {
        r3.getClass();
        com.larus.camera.impl.starter.a.a.getClass();
        if (com.larus.camera.impl.starter.a.d(new String[]{"android.permission.RECORD_AUDIO"}) == false) goto L6;
        FLogger.a.i("CaptureControlComponent", "[tryStartRecorder] has audio permission");
        r4.invoke(Boolean.TRUE);
        return;
    L6:
        if (zx8.b.k == false) goto L8;
    L10:
        boolean r0 = false;
    L11:
        if (r0 == false) goto L17;
        FLogger r5 = FLogger.a;
        r5.i("CaptureControlComponent", "[tryStartRecorder] request audio permission");
        r5.i("CameraRecordConfigManager", "recordPermission");
        zx8.b.k = true;
        zx8.b.a.storeBoolean("key_permission_out_side_camera", true);
        FragmentActivity r6 = AppHost.a.a().getCurrentActivity();
        if ((r6 instanceof FragmentActivity) == false) goto L15;
        FragmentActivity r7 = r6;
    L16:
        com.larus.camera.impl.starter.a.a(r7, new h());
        return;
    L15:
        r7 = null;
        goto L16
    L17:
        FLogger.a.i("CaptureControlComponent", "[tryStartRecorder] no audio permission");
        r4.invoke(Boolean.FALSE);
        t19.s r8 = t19.s.a;
        Context r9 = r3.getContext();
        r8.getClass();
        t19.s.s(r9, 2131908721);
        return;
    L8:
        if (zx8.b.b() == false) goto L10;
        r0 = true;
        goto L11
    }

    public static final void t(CaptureControlComponent r0, View r1, int r2) {
        r0.getClass();
        ViewPropertyAnimator r3 = r1.animate();
        int r4 = com.larus.camera.impl.utils.c0.d;
        r3.rotation(com.larus.camera.impl.utils.c0.a.a(r2, false));
        r3.setDuration(300);
        r3.start();
    }

    public static void v(View r5, long r6, final Function0 r8) {
        long r0 = ((long) 300) - (System.currentTimeMillis() - r6);
        long r7 = 0;
        long r1 = RangesKt.coerceAtLeast(r0, 0);
        Runnable r2 = new c0(r8);
        if (r1 >= 300) goto L5;
        r7 = r1;
    L5:
        r5.postDelayed(r2, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v8 */
    public static final Object r(CaptureControlComponent r10, List r11, boolean r12, Continuation r13) {
        r10.getClass();
        if ((r13 instanceof CaptureControlComponent$interceptResultPageOpen$1) == false) goto L7;
        CaptureControlComponent$interceptResultPageOpen$1 r0 = (CaptureControlComponent$interceptResultPageOpen$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r15 = r0.I$0;
        ResultKt.throwOnFailure(r14);
    L31:
        ?? r6 = r15;
    L32:
        if (r6 == 0) goto L35;
        r4 = true;
    L35:
        return Boxing.boxBoolean(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        CameraCaptureViewModel r16 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) r10.e.getValue()).a();
        if (r16 == null) goto L36;
        ex8.b r5 = FlowCameraImpl.c;
        if (r5 == null) goto L37;
        boolean r7 = Intrinsics.areEqual(r5.a(r16.getCameraData().getScene(), 6, null), Boxing.boxBoolean(true));
        boolean r8 = !r16.enableResultDetect();
        if (r7 == false) goto L24;
        if (r8 == false) goto L24;
        boolean r9 = true;
    L25:
        FLogger.a.i("CaptureControlComponent", "[interceptResultPageOpen] intercept:" + r9 + " (commandSkipped:" + r7 + ", resultDetectDisabled:" + r8 + ')');
        r6 = r9;
        if (r9 == false) goto L32;
        Context r17 = r10.getContext();
        r0.I$0 = r9 ? 1 : 0;
        r0.label = 1;
        if (r16.skipResultPageAndFinish(r17, r11, r12, r0) == r2) goto L38;
        r15 = r9 ? 1 : 0;
        goto L31
    L38:
        return r2;
    L24:
        r9 = false;
        goto L25
    L37:
        return Boxing.boxBoolean(false);
    L36:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new CaptureControlComponent$interceptResultPageOpen$1(r10, r13);
        goto L8
    }
}
