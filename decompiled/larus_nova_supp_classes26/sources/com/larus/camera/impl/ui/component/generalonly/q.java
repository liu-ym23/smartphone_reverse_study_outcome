package com.larus.camera.impl.ui.component.generalonly;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.camera.api.params.CaptureMode;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.utils.CameraData;
import com.larus.camera.impl.widget.CaptureFocusFrame;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q extends com.larus.camera.impl.ui.arch.b implements com.larus.camera.impl.ui.component.capture.a {
    public static final /* synthetic */ int t = 0;
    public final Lazy m;
    public xx8.h n;
    public final Set<String> o;
    public final List<String> p;
    public CaptureFocusFrame q;
    public int r;
    public int s;

    public static final class a {
    }

    static {
    }

    public q() {
        super(com.larus.camera.impl.ui.arch.c.c, 1);
        this.m = LazyKt.lazy(new n(this));
        this.o = new LinkedHashSet();
        this.p = fx8.a.a;
        this.r = 8;
        this.s = 8;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 == null) goto L9;
        CameraData r1 = r0.getCameraData();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.getEnableCaptureTips() != true) goto L9;
    L11:
        if (r2 == false) goto L15;
        IFlowChatThemeConfigProvider r3 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r3 == null) goto L21;
        r3.a(new m(this), AdaptThemeFeatureKey.CHAT_CAMERA_TIPS);
    L21:
        CameraCaptureViewModel r4 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r4 == null) goto L35;
        String r5 = r4.getCameraData().getCaptureMode();
        List<CaptureMode> r6 = r4.getCaptureModeList();
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L26:
        if (r8.hasNext() == false) goto L28;
        r7.add(((CaptureMode) r8.next()).getMode());
        goto L26
    L28:
        FLogger.a.i("CaptureCameraTipsComponent", "[setupFocusFrame] current:" + r5 + ", modeList:" + r7);
        if (r4.getCameraData().getEnableFocusFrame() == false) goto L35;
        if (Intrinsics.areEqual(r5, "CAPTURE_MODE_PHOTO") == false) goto L33;
    L34:
        this.q = new CaptureFocusFrame(getContext(), null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r4.getCaptureModeStatus(), new CaptureCameraTipsComponent$setupFocusFrame$1(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r4.getOnOrientationChanged(), new CaptureCameraTipsComponent$setupFocusFrame$2(this, null)), k());
        goto L35
    L33:
        if (r7.contains("CAPTURE_MODE_PHOTO") == true) goto L34;
    L35:
        CameraCaptureViewModel r9 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r9 == null) goto L41;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r9.getRecordingState(), new CaptureCameraTipsComponent$setupObserver$1(this, null)), k());
        return;
    L41:
        return;
    L15:
        View r10 = h(2131365103);
        if (r10 == null) goto L18;
        e1.o(r10);
    L18:
        e1.o(q());
        if (r0 == null) goto L21;
        r0.recordCameraTipsType(null);
    L9:
        r2 = false;
        goto L11
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        FLogger.a.i("CaptureCameraTipsComponent", "onViewDestroyed");
        xx8.h r0 = this.n;
        if (r0 != null) goto L13;
        return;
    L13:
        Handler r2 = r0.e;     // Catch: Exception -> L9
        if (r2 == null) goto L11;
        r2.removeCallbacksAndMessages(null);     // Catch: Exception -> L9
    L11:
        r0.a = null;
        r0.e = null;
        return;
    L9:
        e = move-exception;
        FLogger.a.e("TextViewSwitcherAdapter", "onDestroy e=" + e);
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        goto L11
    }

    public final TextSwitcher q() {
        return (TextSwitcher) this.m.getValue();
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.p;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.larus.camera.impl.ui.component.generalonly.p] */
    public static final void p(final q r8) {
        final CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) r8.e.getValue()).a();
        if (r0 == null) goto L63;
        List<String> r1 = r0.getCameraData().getTips();
        List<String> r2 = r1;
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        String r4 = null;
        if (r3 == false) goto L15;
        e1.o(r8.q());
        r0.recordCameraTipsType(null);
        return;
    L15:
        e1.x(r8.q());
        r0.recordCameraTipsType(r0.getCameraData().getTipsShowOrder());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getAlbumThumbListStateChanged(), new CaptureCameraTipsComponent$setupTipsSwitcher$1(r8, null)), r8.k());
        r8.q().setFactory(new o(r8));
        r8.n = new xx8.h(r8.q(), r1, new p(r8, r0));
        r0.autoRecordCameraTipsCount();
        Integer r5 = r0.getCameraData().getTipsShowOrder();
        int r6 = CameraTabTipsShowOrder.ORDER.getType();
        if (r5 != null) goto L19;
    L26:
        int r7 = CameraTabTipsShowOrder.RANDOM.getType();
        if (r5 != null) goto L30;
    L46:
        xx8.h r9 = r8.n;
        if (r9 == null) goto L49;
        r4 = r9.a(r8.getContext());
    L49:
        xx8.h r10 = r8.n;
        if (r10 == null) goto L52;
        r10.b();
    L52:
        if (r4 != null) goto L54;
        return;
    L54:
        if ((!StringsKt.isBlank(r4)) == true) goto L56;
        return;
    L56:
        if (r8.o.add(r4) == false) goto L62;
        r0.showCameraItemMobOnCapture("intro_text", r4);
        return;
    L62:
        return;
    L30:
        if (r5.intValue() != r7) goto L46;
        xx8.h r11 = r8.n;
        if (r11 == null) goto L43;
        Context r12 = r8.getContext();
        Intrinsics.checkNotNullParameter(r12, "context");
        r4 = (String) ListProtector.get(r11.b, ((Number) ListProtector.get((List) r11.g.getValue(), r11.d % r11.b.size())).intValue());
        TextSwitcher r13 = r11.a;
        if (r13 == null) goto L36;
        r13.setText(r4);
    L36:
        TextSwitcher r14 = r11.a;
        if (r14 == null) goto L39;
        r14.setInAnimation(r12, 2130772383);
    L39:
        TextSwitcher r15 = r11.a;
        if (r15 == null) goto L42;
        r15.setOutAnimation(r12, 2130772386);
    L42:
        r11.d++;
    L43:
        xx8.h r16 = r8.n;
        if (r16 == null) goto L52;
        r16.c();
        goto L52
    L19:
        if (r5.intValue() != r6) goto L26;
        xx8.h r17 = r8.n;
        if (r17 == null) goto L23;
        r4 = r17.a(r8.getContext());
    L23:
        xx8.h r18 = r8.n;
        if (r18 == null) goto L52;
        r18.b();
        goto L52
    L8:
        if (r2.isEmpty() == true) goto L11;
        r3 = false;
        goto L12
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
        return r3.inflate(2131562770, r4, false);
    }
}
