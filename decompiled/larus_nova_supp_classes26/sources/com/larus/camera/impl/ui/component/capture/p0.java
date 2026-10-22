package com.larus.camera.impl.ui.component.capture;

import android.view.MotionEvent;
import com.larus.camera.impl.monitor.CameraEvent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class p0 implements Function1 {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ CameraCaptureViewModel b;
    public final /* synthetic */ MotionEvent c;

    public /* synthetic */ p0(Ref.BooleanRef r1, CameraCaptureViewModel r2, MotionEvent r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r8) {
        Ref.BooleanRef r0 = this.a;
        CameraCaptureViewModel r1 = this.b;
        MotionEvent r2 = this.c;
        boolean r9 = ((Boolean) r8).booleanValue();
        r0.element = true;
        FLogger r3 = FLogger.a;
        r3.i("CaptureControlComponent", "onActionDown: enter record");
        qx8.a r4 = qx8.a.b;
        r4.getClass();
        r3.i("CameraMonitor", "[onTriggerRecord] hasAudioPermission: " + r9);
        r4.a.c(CameraEvent.START_RECORD);
        qx8.a.f = true;
        qx8.a.g = false;
        qx8.a.h = r9;
        qx8.a.i = null;
        r1.pendingDownEvent(MotionEvent.obtain(r2));
        r1.startRecord(r9);
        r1.clickRecordOnCapturePage("record");
        return Unit.INSTANCE;
    }
}
