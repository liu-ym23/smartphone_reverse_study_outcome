package com.larus.camera.impl.ui.component.video;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ CameraCaptureViewModel a;
    public final /* synthetic */ CaptureRecorderComponent b;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        if ((this.a.getRecordingState().getValue() instanceof px8.d.c) == false) goto L7;
        FLogger.a.i(this.b.A, "[initTouchListener] onSingleTapUp");
        this.a.updateRecordingState(px8.d.f.a);
        this.a.clickRecordOnCapturePage("record_end");
        return true;
    L7:
        return true;
    }

    public d(CameraCaptureViewModel r1, CaptureRecorderComponent r2) {
        this.a = r1;
        this.b = r2;
    }
}
