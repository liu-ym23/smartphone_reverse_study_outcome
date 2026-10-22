package com.obric.assistant.interaction.impl;

import com.bytedance.apm.ApmAgent;
import com.larus.platform.IFlowSdkCommonDepend;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.api.IObricApmService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J.\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J.\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/interaction/impl/ObricApmServiceImpl;", "Lcom/obric/assistant/interaction/api/IObricApmService;", "<init>", "()V", "workScope", "Lkotlinx/coroutines/CoroutineScope;", "isReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingSlardarEvents", "", "Lcom/obric/assistant/interaction/impl/ObricApmServiceImpl$SlardarEventParams;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "markReady", "", "monitorEventForSlardar", "event", "", EffectConfiguration.KEY_CATEGORY, "Lorg/json/JSONObject;", "metric", "extraLog", "reportEventForSlardar", "Companion", "SlardarEventParams", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricApmServiceImpl implements IObricApmService {
    public static final Companion Companion = null;
    private static final String TAG = "ObricApmServiceImpl";
    private final AtomicBoolean isReady;
    private final a lock;
    private final List<SlardarEventParams> pendingSlardarEvents;
    private final CoroutineScope workScope;

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(ObricApmServiceImpl r0) {
        markReady$lambda$0(r0);
    }

    public void markReady() {
        t0.a.post(new g(this));
    }

    public ObricApmServiceImpl() {
        this.workScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.isReady = new AtomicBoolean(false);
        this.pendingSlardarEvents = new ArrayList();
        this.lock = b.a();
    }

    public static final /* synthetic */ a access$getLock$p(ObricApmServiceImpl r0) {
        return r0.lock;
    }

    public static final /* synthetic */ List access$getPendingSlardarEvents$p(ObricApmServiceImpl r0) {
        return r0.pendingSlardarEvents;
    }

    public static final /* synthetic */ AtomicBoolean access$isReady$p(ObricApmServiceImpl r0) {
        return r0.isReady;
    }

    private static final void markReady$lambda$0(ObricApmServiceImpl r6) {
        BuildersKt.launch$default(r6.workScope, null, null, new ObricApmServiceImpl$markReady$1$1(r6, null), 3, null);
    }

    private final void reportEventForSlardar(String r5, JSONObject r6, JSONObject r7, JSONObject r8) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        FLogger.a.i(TAG, "reportEventForSlardar: " + r5);     // Catch: Throwable -> L11
        IFlowSdkCommonDepend r1 = (IFlowSdkCommonDepend) ServiceManager.get().getService(IFlowSdkCommonDepend.class);     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        r1.getApmService();     // Catch: Throwable -> L11
        ic9.a r3 = ic9.a.a;
        Intrinsics.checkNotNullParameter(r5, "event");     // Catch: Throwable -> L11
        ApmAgent.monitorEvent(r5, r6, r7, r8);     // Catch: Throwable -> L11
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L11
    L13:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L19;
        FLogger.a.w(TAG, "report failed: " + r11.getMessage(), r11);
        return;
    L19:
        return;
    L8:
        r9 = null;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public void monitorEventForSlardar(String r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        Intrinsics.checkNotNullParameter(r12, "event");
        BuildersKt.launch$default(this.workScope, null, null, new monitorEventForSlardar.1(this, r12, r13, r14, r15, null), 3, null);
    }

    public static final /* synthetic */ void access$reportEventForSlardar(ObricApmServiceImpl r0, String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        r0.reportEventForSlardar(r1, r2, r3, r4);
    }
}
