package com.obric.assistant.state.impl.multitask.producer;

import com.obric.assistant.state.api.multitask.producer.IObricAlarmTtsStateProducerService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jha.f;
import jha.j;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\u001e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/ObricAlarmTtsStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowStateProducer;", "Lcom/obric/assistant/state/api/multitask/producer/IObricAlarmTtsStateProducerService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeTasks", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/assistant/state/multitask/core/TaskHandle;", "Lcom/obric/assistant/state/api/multitask/state/ObricAlarmTtsState;", "timeoutJobs", "Lkotlinx/coroutines/Job;", "dispatchAlarmTtsStart", "", "messageId", "extra", "", "", "dispatchAlarmTtsEnd", "handle", "buildMessageId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAlarmTtsStateProducer implements j, IObricAlarmTtsStateProducerService {
    public static final /* synthetic */ int d = 0;
    public final CoroutineScope a;
    public final ConcurrentHashMap<String, jha.l<aha.h>> b;
    public final ConcurrentHashMap<String, Job> c;

    public static final class a {
    }

    static {
    }

    public ObricAlarmTtsStateProducer() {
        ExecutorCoroutineDispatcher r0 = f.a;
        this.a = f.b;
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
    }

    @Override // com.obric.assistant.state.api.multitask.producer.IObricAlarmTtsStateProducerService
    public final void a(Map r7) {
        BuildersKt.launch$default(this.a, null, null, new ObricAlarmTtsStateProducer$dispatchAlarmTtsStart$1(this, "obric_alarm_tts", r7, null), 3, null);
    }
}
