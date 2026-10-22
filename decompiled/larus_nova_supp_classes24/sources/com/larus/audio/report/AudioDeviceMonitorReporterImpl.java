package com.larus.audio.report;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.audiov3.report.AudioDeviceMonitorScenes;
import com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tx9.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/audio/report/AudioDeviceMonitorReporterImpl;", "Lcom/larus/audio/audiov3/report/IAudioDeviceMonitorReporter;", "<init>", "()V", "report", "", "scene", "Lcom/larus/audio/audiov3/report/AudioDeviceMonitorScenes;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AudioDeviceMonitorReporterImpl implements IAudioDeviceMonitorReporter {
    public AudioDeviceMonitorReporterImpl() {
    }

    @Override // com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter
    public final void a(AudioDeviceMonitorScenes r4) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        if (z2.a.enableBluetoothDevicesReportEvent() == true) goto L6;
        return;
    L6:
        i1.d(r4.getValue());     // Catch: Throwable -> L8
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L16;
        FLogger.a.e("AudioDeviceMonitorReporter", "report error: " + r6.getMessage());
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
