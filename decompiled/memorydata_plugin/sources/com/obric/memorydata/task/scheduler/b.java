package com.obric.memorydata.task.scheduler;

import com.bytedance.bdinstall.Api;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH&J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J*\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000fH&J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000fH&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000fH&J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000fH&J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000fH&J\b\u0010\u001b\u001a\u00020\u0007H'J\b\u0010\u001c\u001a\u00020\u0007H'J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H&J$\u0010\"\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000f2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070$H&J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000fH&¨\u0006&"}, d2 = {"Lcom/obric/memorydata/task/scheduler/ITaskManager;", "", "executeAwait", "Lcom/obric/memorydata/task/impl/TaskResult;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/task/AbsTaskRequest;", "enqueue", "", "requests", "", "enqueueWithUniqueTask", "existingTaskPolicy", "Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;", "dispatchEvent", "event", "", WsConstants.KEY_EXTRA, "", "removeTask", "taskName", "removeTaskIncludingScheduled", "removeScheduledTasks", "cancelTaskIncludingScheduled", "removeTaskId", Api.KEY_UUID, "cancelTaskId", "", "removeAllBackgroundTask", "printAllBackgroundTask", "hasTask", "notifyProgress", "taskId", "payload", "Lorg/json/JSONObject;", "registerProgressCallback", f.c, "Lkotlin/Function1;", "unregisterProgressCallback", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface b {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(b r2, String r3, Map r4, int r5, Object r6) {
            b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            Map<String, ? extends Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L7;
            r8 = null;
        L7:
            r7.a(r3, r8);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchEvent");
        }
    }

    TaskResult a(AbsTaskRequest r1);

    void a(String r1);

    void a(String r1, Map<String, ? extends Object> r2);

    void a(String r1, Function1<? super JSONObject, Unit> r2);

    void a(String r1, JSONObject r2);

    void a(List<? extends AbsTaskRequest> r1);

    void b(AbsTaskRequest r1);

    void b(String r1);

    void c(String r1);

    boolean c(AbsTaskRequest r1);

    void d(String r1);

    void e(String r1);

    boolean f(String r1);

    void g(String r1);
}
