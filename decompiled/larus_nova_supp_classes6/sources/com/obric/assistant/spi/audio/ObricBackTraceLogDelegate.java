package com.obric.assistant.spi.audio;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hga.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J#\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0019\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\tH\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0016H\u0096\u0001¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricBackTraceLogDelegate;", "Lcom/obric/assistant/spi/audio/IObricBackTraceLogService;", "<init>", "()V", "createTracer", "Lcom/obric/assistant/spi/audio/IObricBackTraceTracer;", "reportAudioRecorderStart", "", "source", "", "reportAudioRecorderStartResult", "success", "", "errorReason", "reportBackTraceRecorderConfig", "scene", "historyLengthMs", "", "reportBacktraceDuration", "payloadJson", "reportBacktraceRecordError", "setHistoryLengthMs", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ObricBackTraceLogDelegate implements IObricBackTraceLogService {
    public static final ObricBackTraceLogDelegate b = null;
    public final /* synthetic */ IObricBackTraceLogService a;

    static {
        b = new ObricBackTraceLogDelegate();
    }

    @Override // com.obric.assistant.spi.audio.IObricBackTraceLogService
    public final void a(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.a.a(r2, r3);
    }

    @Override // com.obric.assistant.spi.audio.IObricBackTraceLogService
    public final void b(int r2) {
        this.a.b(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricBackTraceLogService
    public final b c() {
        return this.a.c();
    }

    private ObricBackTraceLogDelegate() {
        DefaultObricBackTraceLogServiceImpl r0 = (IObricBackTraceLogService) ServiceManager.get().getService(IObricBackTraceLogService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricBackTraceLogServiceImpl();
    L5:
        this.a = r0;
    }
}
