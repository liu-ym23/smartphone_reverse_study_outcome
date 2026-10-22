package com.obric.assistant.spi.wakeup;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0001J!\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0001¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/spi/wakeup/ObricWakeupLatencyTrackService;", "Lcom/obric/assistant/spi/wakeup/IWakeupLatencyTrackService;", "<init>", "()V", "markActivationStart", "", "activationStartUptimeMillis", "", "launchMethod", "", "mainProcessReady", "", "markAssistantLaunchStart", "timestamp", "markIpcStart", "scene", "sessionName", "ipcStartTime", "markMainProcessReceived", "markRecordStart", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWakeupLatencyTrackService implements IWakeupLatencyTrackService {
    public static final ObricWakeupLatencyTrackService b = null;
    public final /* synthetic */ IWakeupLatencyTrackService a;

    static {
        b = new ObricWakeupLatencyTrackService();
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void a(long r2, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "launchMethod");
        this.a.a(r2, r4, r5);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void b(long r2) {
        this.a.b(r2);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void c(long r2) {
        this.a.c(r2);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void d(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "sessionName");
        this.a.d(r2, r3, r4);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void e(long r2) {
        this.a.e(r2);
    }

    private ObricWakeupLatencyTrackService() {
        IWakeupLatencyTrackService r0 = (IWakeupLatencyTrackService) ServiceManager.get().getService(IWakeupLatencyTrackService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultWakeupLatencyTrackServiceImpl();
    L5:
        this.a = r0;
    }
}
