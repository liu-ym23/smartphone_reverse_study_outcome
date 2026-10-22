package com.obric.memorydata.memory.ui.list;

import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PendingPersonalInfoNotificationTask extends NativeTask {
    public static final a Companion = null;
    public static final String KEY_GENERATION = "generation";
    public static final String NAME = "PendingPersonalInfoNotificationTask";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationTask$Companion;", "", "<init>", "()V", "NAME", "", "KEY_GENERATION", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public PendingPersonalInfoNotificationTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        super(r2);
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        at r0 = at.f11208a;
        String r9 = getTaskParameter().getInputParams().optString(KEY_GENERATION);
        Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");
        String r4 = r0.a(r9);
        JSONObject r5 = new JSONObject().put("status", r4);
        Intrinsics.checkNotNullExpressionValue(r5, "put(...)");
        return new TaskResult(0, r4, r5, null, 8, null);
    }
}
