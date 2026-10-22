package com.larus.camera.impl.ui.component.capture;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.camera.api.params.CaptureMode;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.widget.TabPickerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CaptureTabComponent extends com.larus.camera.impl.ui.arch.b implements com.larus.camera.impl.ui.component.capture.a {
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final List<String> p;

    public static final class a extends com.larus.camera.impl.widget.q {
        public final /* synthetic */ CaptureTabComponent a;

        @Override // com.larus.camera.impl.widget.q, com.larus.camera.impl.widget.p
        public final void a() {
            CameraCaptureViewModel r0 = (CameraCaptureViewModel) com.larus.camera.impl.ui.arch.b.e(this.a).a();
            if (r0 != null) goto L5;
            return;
        L5:
            List<String> r1 = fx8.a.a;
            if (fx8.a.a.contains(r0.getCurrentCaptureMode()) == false) goto L9;
            r0.tryChangeAlbumThumbListState(true);
            r0.clickCameraButtonOnCapturePage("above_album_icon_arrow", "drag_open_album");
            r0.clickUploadEntrance("camera_album_thumbnail_click", "camera_album_thumbnail_click");
            return;
        }

        public a(CaptureTabComponent r1) {
            this.a = r1;
        }
    }

    public CaptureTabComponent() {
        super(com.larus.camera.impl.ui.arch.c.c, 1);
        this.m = LazyKt.lazy(new z1(this));
        this.n = LazyKt.lazy(new a2(this));
        this.o = LazyKt.lazy(new b2(this));
        this.p = fx8.a.f;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        final CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r0, h(2131367728), 0, null, 6, null);
        r0.resetCamera();
        CaptureMode r1 = r0.initCaptureMode();
        TabPickerView r2 = p();
        List<CaptureMode> r3 = r0.getCaptureModeList();
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        CaptureMode r6 = (CaptureMode) r5.next();
        r4.add(new TabPickerView.a(r6.getTabName(), Intrinsics.areEqual(r6.getMode(), r1.getMode())));
        goto L7
    L9:
        r2.setTabList(r4);
        r2.setOnTabPickedListener(new y1(r0));
        Unit r7 = Unit.INSTANCE;
        if (com.larus.camera.impl.utils.k.a() == false) goto L12;
        com.larus.utils.e1.o(h(2131365141));
    L13:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getOnOrientationChanged(), new CaptureTabComponent$onViewCreated$2(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getSurfaceFlingAction(), new CaptureTabComponent$onViewCreated$3(r0, this, null)), k());
        if (p().getTabCount() <= 0) goto L16;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getAlbumThumbListStateChanged(), new CaptureTabComponent$onViewCreated$4(this, null)), k());
        com.larus.utils.e1.x(p());
        return;
    L16:
        com.larus.utils.e1.o(p());
        return;
    L12:
        com.larus.utils.e1.x(h(2131365141));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getCaptureModeStatus(), new CaptureTabComponent$onViewCreated$1(r0, this, null)), k());
        goto L13
    }

    public final TabPickerView p() {
        return (TabPickerView) this.m.getValue();
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.p;
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
        return r3.inflate(2131562926, r4, false);
    }
}
