package com.larus.camera.impl.ui.component.video;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.keva.Keva;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.e;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CaptureRecorderComponent extends com.larus.camera.impl.ui.arch.b {
    public final String A;
    public Job B;
    public Job C;
    public final b D;
    public final c E;
    public ImageView m;
    public ImageView n;
    public TextView o;
    public TextView p;
    public FrameLayout q;
    public View r;
    public ImageView s;
    public GradientDrawable t;
    public int u;
    public final int v;
    public final Handler w;
    public View x;
    public boolean y;
    public float z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CaptureRecorderComponent a;

        public final void a() {
            CaptureRecorderComponent r0 = this.a;
            int r1 = r0.u;
            r0.getClass();
            StringCompanionObject r3 = StringCompanionObject.INSTANCE;
            String r2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r1 / 60), Integer.valueOf(r1 % 60)}, 2));
            TextView r4 = r0.o;
            if (r4 == null) goto L5;
            r4.setText(r2);
        L5:
            CaptureRecorderComponent r5 = this.a;
            int r6 = r5.u;
            if (r6 < r5.v) goto L10;
            FLogger.a.i(r5.A, "[updateRunnable] max duration:" + this.a.v);
            CameraCaptureViewModel r7 = (CameraCaptureViewModel) com.larus.camera.impl.ui.arch.b.e(this.a).a();
            if (r7 == null) goto L12;
            r7.updateRecordingState(px8.d.f.a);
            return;
        L12:
            return;
        L10:
            r5.u = r6 + 1;
            r5.w.postDelayed(this, 1000);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(CaptureRecorderComponent r1) {
            this.a = r1;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ CaptureRecorderComponent a;

        @Override // java.lang.Runnable
        public final void run() {
            CameraCaptureViewModel r0 = (CameraCaptureViewModel) com.larus.camera.impl.ui.arch.b.e(this.a).a();     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            int r1 = r0.getRenderFps();     // Catch: Throwable -> L7
            qx8.a.b.h(r1, "record");     // Catch: Throwable -> L7
        L5:
            this.a.w.postDelayed(this, 5000);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public c(CaptureRecorderComponent r1) {
            this.a = r1;
        }
    }

    static {
    }

    public CaptureRecorderComponent() {
        com.larus.camera.impl.ui.arch.c r0 = com.larus.camera.impl.ui.arch.c.a;
        super(17, com.larus.camera.impl.ui.arch.c.c);
        Keva r1 = zx8.b.a;
        this.v = zx8.b.f;
        this.w = new Handler(Looper.getMainLooper());
        this.y = true;
        this.z = -1.0f;
        this.A = "CaptureRecorderComponent" + hashCode();
        this.D = new b(this);
        this.E = new c(this);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        FLogger r0 = FLogger.a;
        r0.i(this.A, " [onViewCreated]");
        CameraCaptureViewModel r1 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r1 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r1, h(2131367728), 0, null, 6, null);
        GradientDrawable r2 = new GradientDrawable();
        r2.setShape(0);
        r2.setColor(ContextCompat.getColor(getContext(), 2131101300));
        r2.setCornerRadius(c7.c(28));
        this.t = r2;
        ImageView r4 = this.m;
        if (r4 == null) goto L8;
        r4.setBackground(r2);
    L8:
        this.u = 0;
        this.w.post(this.D);
        this.w.post(this.E);
        MotionEvent r3 = r1.getDownEvent();
        if (r3 == null) goto L13;
        r0.i(this.A, "downEvent " + r3);
        View r5 = this.x;
        if (r5 == null) goto L13;
        r5.dispatchTouchEvent(r3);
    L13:
        this.B = e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r1.getCaptureButtonTouchEvent(), new CaptureRecorderComponent$onViewCreated$3(this, null)), k());
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = r1.getRecordingState().getValue();
        this.C = e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r1.getRecordingState(), new CaptureRecorderComponent$onViewCreated$4(this, r1, r6, null)), k());
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        FLogger.a.i(this.A, "onViewDestroyed");
        Job r0 = this.B;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        Job r1 = this.C;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.w.removeCallbacksAndMessages(null);
        this.B = null;
        this.C = null;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r2) {
        CameraContainer.b r3 = super.f(r2);
        ((FrameLayout.LayoutParams) r3).width = -1;
        ((FrameLayout.LayoutParams) r3).height = -1;
        return r3;
    }

    public final void r(float r5) {
        if (this.z != r5) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.z = r5;
        FLogger.a.i(this.A, "Zoom factor: " + r5);
        CameraCaptureViewModel r1 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r1 == null) goto L12;
        r1.zoom(r5);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r13, ViewGroup r14) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        Intrinsics.checkNotNullParameter(r14, "parent");
        View r15 = r13.inflate(2131562773, r14, false);
        this.m = (ImageView) r15.findViewById(2131384051);
        this.n = (ImageView) r15.findViewById(2131374189);
        this.o = (TextView) r15.findViewById(2131384050);
        this.p = (TextView) r15.findViewById(2131374193);
        this.q = (FrameLayout) r15.findViewById(2131373056);
        this.r = r15.findViewById(2131367687);
        this.s = (ImageView) r15.findViewById(2131384052);
        Intrinsics.checkNotNull(r15);
        final CameraCaptureViewModel r4 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r4 == null) goto L10;
        ImageView r16 = this.m;
        if (r16 == null) goto L8;
        Context r17 = r16.getContext();
    L9:
        final GestureDetector r6 = new GestureDetector(r17, new d(r4, this));
        final Ref.FloatRef r9 = new Ref.FloatRef();
        final Rect r10 = new Rect();
        final Rect r8 = new Rect();
        final Rect r5 = new Rect();
        final Rect r11 = new Rect();
        final Ref.BooleanRef r1 = new Ref.BooleanRef();
        final Ref.BooleanRef r7 = new Ref.BooleanRef();
        r7.element = true;
        final Ref.IntRef r2 = new Ref.IntRef();
        r2.element = -1;
        r15.setOnTouchListener(new com.larus.camera.impl.ui.component.video.c(r1, r2, this, r4, r5, r6, r7, r8, r9, r10, r11));
        goto L10
    L8:
        r17 = null;
    L10:
        this.x = r15;
        return r15;
    }

    public static final void p(CaptureRecorderComponent r1, int r2, float r3) {
        ImageView r0 = r1.m;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r4 = r0.getLayoutParams();
    L6:
        if (r4 == null) goto L8;
        r4.width = r2;
    L8:
        if (r4 == null) goto L10;
        r4.height = r2;
    L10:
        ImageView r5 = r1.m;
        if (r5 == null) goto L13;
        r5.setLayoutParams(r4);
    L13:
        GradientDrawable r6 = r1.t;
        if (r6 == null) goto L17;
        r6.setCornerRadius(r3);
        return;
    L17:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static final boolean q(CameraCaptureViewModel r2, Ref.BooleanRef r3, Ref.IntRef r4, CaptureRecorderComponent r5) {
        px8.d r0 = (px8.d) r2.getRecordingState().getValue();
        r3.element = false;
        r4.element = -1;
        r5.r(0.0f);
        if ((r0 instanceof px8.d.b) == false) goto L6;
        r2.updateRecordingState(px8.d.c.a);
        r2.clickRecordOnCapturePage("record_hands_free");
        FLogger.a.i(r5.A, "-> HandsFreeRecording");
        return true;
    L6:
        if ((r0 instanceof px8.d.C0130d) == false) goto L8;
    L12:
        r2.updateRecordingState(px8.d.f.a);
        r2.clickRecordOnCapturePage("record_end");
        FLogger.a.i(r5.A, "-> RecordingEnd");
        return true;
    L8:
        if ((r0 instanceof px8.d.e) == true) goto L12;
        FLogger.a.i(r5.A, "finalize with state=" + r0 + " (no-op)");
        return false;
    }
}
