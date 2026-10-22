package com.obric.assistant.spi.wakeup;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/spi/wakeup/DefaultWakeupLatencyTrackServiceImpl;", "Lcom/obric/assistant/spi/wakeup/IWakeupLatencyTrackService;", "<init>", "()V", "markActivationStart", "", "activationStartUptimeMillis", "", "launchMethod", "", "mainProcessReady", "", "markIpcStart", "scene", "sessionName", "ipcStartTime", "markMainProcessReceived", "timestamp", "markAssistantLaunchStart", "markRecordStart", "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultWakeupLatencyTrackServiceImpl implements IWakeupLatencyTrackService {

    public static final class a {
    }

    static {
    }

    public DefaultWakeupLatencyTrackServiceImpl() {
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void a(long r1, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "launchMethod");
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void b(long r1) {
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void c(long r1) {
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void d(String r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "sessionName");
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void e(long r1) {
    }
}
