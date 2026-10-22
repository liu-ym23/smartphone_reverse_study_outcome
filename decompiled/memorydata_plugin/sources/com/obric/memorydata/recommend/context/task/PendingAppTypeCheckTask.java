package com.obric.memorydata.recommend.context.task;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.recommend.settings.t;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.handler.GlobalMainHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/recommend/context/task/PendingAppTypeCheckTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskParameter", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PendingAppTypeCheckTask extends NativeTask {
    public static final a Companion = null;
    public static final String NAME = "PendingAppTypeCheckTask";
    private static final String TAG = "PendingAppTypeCheckTask";
    private static final List<a.InterfaceC0668a> pendingAppTypeCheckObservers = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007J\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/recommend/context/task/PendingAppTypeCheckTask$Companion;", "", "<init>", "()V", "TAG", "", "NAME", "pendingAppTypeCheckObservers", "", "Lcom/obric/memorydata/recommend/context/task/PendingAppTypeCheckTask$Companion$PendingAppTypeCheckObserver;", "addCheckTaskRefreshObserver", "", "observer", "notifyCheckTaskRefresh", "removeCheckTaskRefreshObserver", "PendingAppTypeCheckObserver", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.memorydata.recommend.context.task.PendingAppTypeCheckTask$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/recommend/context/task/PendingAppTypeCheckTask$Companion$PendingAppTypeCheckObserver;", "", "onCheckTaskRefresh", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public interface InterfaceC0668a {
            void a();
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private static final void b() {
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(PendingAppTypeCheckTask.access$getPendingAppTypeCheckObservers$cp(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((InterfaceC0668a) ZeusTransformUtils.preCheckCast(r0.next(), InterfaceC0668a.class, "com.obric.memorydata.plugin")).a();
            goto L4
        }

        public static /* synthetic */ void lambda$Rxns3gBdRRCXviqfYqYCWqY2sgM() {
            b();
        }

        public final void a() {
            GlobalMainHandler.Companion.getInstance().post($$Lambda$PendingAppTypeCheckTask$a$Rxns3gBdRRCXviqfYqYCWqY2sgM.INSTANCE);
        }

        public final void a(InterfaceC0668a r2) {
            InterfaceC0668a r1 = (InterfaceC0668a) ZeusTransformUtils.wrapperContextForParams(r2, InterfaceC0668a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "observer");
            PendingAppTypeCheckTask.access$getPendingAppTypeCheckObservers$cp().add(r1);
        }

        public final void b(InterfaceC0668a r2) {
            InterfaceC0668a r1 = (InterfaceC0668a) ZeusTransformUtils.wrapperContextForParams(r2, InterfaceC0668a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "observer");
            PendingAppTypeCheckTask.access$getPendingAppTypeCheckObservers$cp().remove(r1);
        }
    }

    static {
        Companion = new a(null);
        pendingAppTypeCheckObservers = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public PendingAppTypeCheckTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskParameter");
        super(r2);
    }

    public static final /* synthetic */ List access$getPendingAppTypeCheckObservers$cp() {
        return pendingAppTypeCheckObservers;
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PendingAppTypeCheckTask", "run", false, 4, null);
        t.f12630a.q();
        return new TaskResult(0, null, null, null, 14, null);
    }
}
