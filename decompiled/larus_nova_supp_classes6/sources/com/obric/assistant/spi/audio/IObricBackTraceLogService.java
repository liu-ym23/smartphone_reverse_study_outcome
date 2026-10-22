package com.obric.assistant.spi.audio;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import hga.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\nH&J&\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH&¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/spi/audio/IObricBackTraceLogService;", "", "setHistoryLengthMs", "", "historyLengthMs", "", "createTracer", "Lcom/obric/assistant/spi/audio/IObricBackTraceTracer;", "reportBackTraceRecorderConfig", "scene", "", "", "reportAudioRecorderStart", "source", "reportAudioRecorderStartResult", "success", "", "errorReason", "reportBacktraceDuration", "payloadJson", "reportBacktraceRecordError", "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public interface IObricBackTraceLogService {
    void a(String r1, long r2);

    void b(int r1);

    b c();
}
