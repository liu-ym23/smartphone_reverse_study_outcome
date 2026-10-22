package com.larus.audio.flow.client.kmp_com.service;

import c68.b;
import com.bytedance.flow_audio.api.service.common.IKMPTrackerService;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.audiov3.report.AudioDeviceMonitorScenes;
import com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m58.a;
import m58.h;
import m58.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016JV\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/audio/flow/client/kmp_com/service/TrackerService;", "Lcom/bytedance/flow_audio/api/service/common/IKMPTrackerService;", "<init>", "()V", "event", "", "", "params", "", "", "hmdTrackService", "serviceName", "metric", "", "category", "extra", "onTtsStart", "ensureNotReachHere", "e", "", "msg", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TrackerService implements IKMPTrackerService {
    public TrackerService() {
    }

    public final void W0() {
        IAudioDeviceMonitorReporter r0 = (IAudioDeviceMonitorReporter) ServiceManager.get().getService(IAudioDeviceMonitorReporter.class);
        if (r0 == null) goto L6;
        r0.a(AudioDeviceMonitorScenes.TTS);
        return;
    }

    public final void ensureNotReachHere(Throwable r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "e");
        Intrinsics.checkNotNullParameter(r3, "msg");
        a r0 = h.h;
        if (r0 == null) goto L6;
        r0.ensureNotReachHere(r2, r3);
        return;
    }

    public final void event(String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r5 != null) goto L18;
        b.b("TrackerService", "report error by empty params");
        return;
    L18:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        s r2 = h.b;     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        r2.report(r4, new JSONObject(r5));     // Catch: Throwable -> L12
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L12
    L14:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L20;
        int r9 = b.a;
        b.b("TrackerService", "report error by " + r8.getMessage());
        return;
    L20:
        return;
    L9:
        r6 = null;
    L12:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
