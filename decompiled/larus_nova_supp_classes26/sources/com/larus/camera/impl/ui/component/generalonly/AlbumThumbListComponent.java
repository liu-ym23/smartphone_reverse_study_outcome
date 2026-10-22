package com.larus.camera.impl.ui.component.generalonly;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.ui.viewmodel.ChangeState;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.utils.e1;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class AlbumThumbListComponent extends com.larus.camera.impl.ui.arch.b implements com.larus.camera.impl.ui.component.capture.a {
    public static final /* synthetic */ int u = 0;
    public final List<String> m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public boolean t;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ Function0<Unit> a;

        public b(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Function0<Unit> r3 = this.a;
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }
    }

    static {
    }

    public AlbumThumbListComponent() {
        super(com.larus.camera.impl.ui.arch.c.c, 1);
        this.m = fx8.a.a;
        this.n = LazyKt.lazy(new com.larus.camera.impl.ui.component.generalonly.a(this));
        this.o = LazyKt.lazy(new com.larus.camera.impl.ui.component.generalonly.b(this));
        this.p = LazyKt.lazy(new c(this));
        this.q = LazyKt.lazy(new d(this));
        this.r = LazyKt.lazy(new e());
        this.s = LazyKt.lazy(new f(this));
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        e1.o((View) this.n.getValue());
        ((LinkedHashMap) ((com.larus.camera.impl.utils.album.d.c) com.larus.camera.impl.utils.album.d.a.getValue()).a.b).clear();
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r0, h(2131367728), 0, null, 6, null);
        ICameraEventExt r1 = r0.getCameraData().getEventExt();
        if (r1 == null) goto L12;
        String r2 = r1.getConversationId();
        if (r2 == null) goto L13;
        BuildersKt.launch$default(k(), Dispatchers.getMain(), null, new AlbumThumbListComponent$onViewCreated$1(r0, this, r2, null), 2, null);
        return;
    L13:
        return;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        ((LinkedHashMap) ((com.larus.camera.impl.utils.album.d.c) com.larus.camera.impl.utils.album.d.a.getValue()).a.b).clear();
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.m;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r2) {
        CameraContainer.b r3 = super.f(r2);
        ((FrameLayout.LayoutParams) r3).width = -1;
        ((FrameLayout.LayoutParams) r3).height = -1;
        return r3;
    }

    public static final void p(AlbumThumbListComponent r3, boolean r4) {
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) r3.e.getValue()).a();
        if (r0 == null) goto L10;
        if (r4 == false) goto L7;
        r3.t = true;
        r0.albumThumbListStateChanged(ChangeState.SHOW);
        CameraCaptureViewModel.showCameraItemMobOnCapture$default(r0, "album_thumbnail", null, 2, null);
        e1.x((View) r3.n.getValue());
        return;
    L7:
        r3.t = false;
        r0.albumThumbListStateChanged(ChangeState.HIDE);
        e1.o((View) r3.n.getValue());
        return;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return r3.inflate(2131562738, r4, false);
    }

    public final void q(final View r4, int r5, int r6, Function0<Unit> r7) {
        final CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        ValueAnimator r8 = ValueAnimator.ofInt(new int[]{r5, r6});
        if (r5 <= 0) goto L8;
        r8.setInterpolator(new AccelerateInterpolator());
    L9:
        r8.addUpdateListener(new h(r4, r0));
        r8.addListener(new b(r7));
        r8.setDuration(200);
        r8.start();
        return;
    L8:
        r8.setInterpolator(new DecelerateInterpolator());
        goto L9
    }
}
