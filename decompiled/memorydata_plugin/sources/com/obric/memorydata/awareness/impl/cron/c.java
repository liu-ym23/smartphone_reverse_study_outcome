package com.obric.memorydata.awareness.impl.cron;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0016J<\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0016J<\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/awareness/impl/cron/EcaConditionEventListener;", "Lcom/obric/memorydata/awareness/api/EventListener;", "targetTask", "", "<init>", "(Ljava/lang/String;)V", "observable", "", "onEvent", "", "eventName", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "onFeatureEvent", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c implements com.obric.memorydata.awareness.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8656b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/impl/cron/EcaConditionEventListener$Companion;", "", "<init>", "()V", "TAG", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8655a = new a(null);
    }

    public c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetTask");
        this.f8656b = r2;
    }

    @Override // com.obric.memorydata.awareness.api.a
    public void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "feature");
    }

    @Override // com.obric.memorydata.awareness.api.a
    public void a(String r5, Map<String, ? extends Object> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "eventName");
        RunLog.INSTANCE.debug("EcaConditionEventListener", "EcaConditionEventListener onEvent " + r5 + " extra: " + r7);
        JSONObject r0 = new JSONObject();
        r0.put("task_type", "trigger_eca");
        r0.put("event", r5);
        if (r7 == null) goto L5;
        r0.put(WsConstants.KEY_EXTRA, new JSONObject(u.a(r7)));
    L5:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(this.f8656b).setInputParam(r0), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    @Override // com.obric.memorydata.awareness.api.a
    public boolean a() {
        return true;
    }

    @Override // com.obric.memorydata.awareness.api.a
    public void b(String r6, Object r7, Object r8, Map<String, ? extends Object> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "feature");
        RunLog.INSTANCE.debug("EcaConditionEventListener", "EcaConditionEventListener onFeatureEvent " + r6 + " oldValue: " + r7 + " newValue: " + r8 + " extra: " + r10);
        JSONObject r2 = new JSONObject();
        r2.put("task_type", "trigger_eca");
        r2.put("feature", r6);
        r2.put("oldValue", r7);
        r2.put("newValue", r8);
        if (r10 == null) goto L5;
        r2.put("extras", new JSONObject(u.a(r10)));
    L5:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(this.f8656b).setInputParam(r2), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }
}
