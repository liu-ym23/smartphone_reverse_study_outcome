package com.obric.assistant.spi.wakeup;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0005H&J\u0012\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0005H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/spi/wakeup/IWakeupLatencyTrackService;", "", "markActivationStart", "", "activationStartUptimeMillis", "", "launchMethod", "", "mainProcessReady", "", "markIpcStart", "scene", "sessionName", "ipcStartTime", "markMainProcessReceived", "timestamp", "markAssistantLaunchStart", "markRecordStart", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IWakeupLatencyTrackService {

    public static final class a {
        public static /* synthetic */ void a(IWakeupLatencyTrackService r2) {
            r2.e(System.currentTimeMillis());
        }

        public static /* synthetic */ void b(ObricWakeupLatencyTrackService r2) {
            r2.c(System.currentTimeMillis());
        }
    }

    void a(long r1, String r3, boolean r4);

    void b(long r1);

    void c(long r1);

    void d(String r1, String r2, long r3);

    void e(long r1);
}
