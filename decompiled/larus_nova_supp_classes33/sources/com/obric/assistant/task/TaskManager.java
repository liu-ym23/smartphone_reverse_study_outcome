package com.obric.assistant.task;

import android.util.LruCache;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.common.ErrorCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0017J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\nH\u0002¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/task/TaskManager;", "Lcom/obric/assistant/task/ITaskCenter;", "<init>", "()V", "post", "", "newTask", "Lcom/obric/assistant/task/TaskEntry;", WindowEvent.WindowOpenPerfResult.CANCEL, "id", "", "get", "getAll", "", "emitSortedTasks", "printTaskSnapshot", WindowEvent.Params.REASON, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskManager implements ITaskCenter {
    public static final ConcurrentHashMap<String, com.obric.assistant.task.b> a = null;
    public static final LruCache<String, Boolean> b = null;
    public static final StateFlowImpl c = null;
    public static final b1 d = null;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((com.obric.assistant.task.b) r3).l), Long.valueOf(((com.obric.assistant.task.b) r4).l));
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((com.obric.assistant.task.b) r3).l), Long.valueOf(((com.obric.assistant.task.b) r4).l));
        }
    }

    public static final class d<T> implements Comparator {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((com.obric.assistant.task.b) r3).l), Long.valueOf(((com.obric.assistant.task.b) r4).l));
        }
    }

    public TaskManager() {
    }

    static {
        a = new ConcurrentHashMap();
        b = new LruCache(ErrorCode.ENTITY_NOT_EXIST_ERROR);
        StateFlowImpl r0 = j1.a(CollectionsKt.emptyList());
        c = r0;
        d = e.b(r0);
    }

    public static void b() {
        Collection<com.obric.assistant.task.b> r0 = a.values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L3:
        boolean r4 = true;
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        TaskStatus r6 = ((com.obric.assistant.task.b) r3).g;
        if (r6 != TaskStatus.PROGRESS) goto L8;
    L11:
        if (r4 == false) goto L3;
        r1.add(r3);
        goto L3
    L8:
        if (r6 == TaskStatus.COMPLETED) goto L11;
        r4 = false;
        goto L11
    L13:
        List r5 = CollectionsKt.sortedWith(r1, new b());
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r0.iterator();
    L15:
        if (r8.hasNext() == false) goto L22;
        Object r9 = r8.next();
        if (((com.obric.assistant.task.b) r9).g != TaskStatus.QUEUEING) goto L19;
        boolean r10 = true;
    L20:
        if (r10 == false) goto L15;
        r7.add(r9);
        goto L15
    L19:
        r10 = false;
        goto L20
    L22:
        List r11 = CollectionsKt.plus(r5, CollectionsKt.sortedWith(r7, new c()));
        c.setValue(new ArrayList(r11));
    }

    @Override // com.obric.assistant.task.ITaskCenter
    public final List<com.obric.assistant.task.b> getAll() {
        return CollectionsKt.toList(a.values());
    }

    public static void c(String r10) {
        List r0 = CollectionsKt.toList(a.values());
        if (r0.isEmpty() == false) goto L6;
        FLogger.a.i("TaskCenterTaskManager", "Task Snapshot [" + r10 + "] no active task");
        return;
    L6:
        StringBuilder r1 = new StringBuilder();
        r1.append("Task Snapshot [" + r10 + "] totally " + r0.size() + " tasks\n");
        r1.append("┌─────────────────────────────────────────────────────────\n");
        Iterator r11 = CollectionsKt.sortedWith(r0, new d()).iterator();
        int r3 = 0;
    L8:
        if (r11.hasNext() == false) goto L17;
        Object r4 = r11.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        com.obric.assistant.task.b r6 = (com.obric.assistant.task.b) r4;
        if (r6.g != TaskStatus.PROGRESS) goto L15;
        String r7 = "(" + r6.h + "%)";
    L16:
        StringCompanionObject r8 = StringCompanionObject.INSTANCE;
        r1.append(String.format("│ %2d. [%-10s] ID: %s %s\n", Arrays.copyOf(new Object[]{Integer.valueOf(r5), r6.g.name(), r6.a, r7}, 4)));
        r3 = r5;
        goto L8
    L15:
        r7 = "";
        goto L16
    L17:
        r1.append("└─────────────────────────────────────────────────────────");
        FLogger.a.i("TaskCenterTaskManager", r1.toString());
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.obric.assistant.task.c] */
    @Override // com.obric.assistant.task.ITaskCenter
    public final void a(final com.obric.assistant.task.b r7) {
        Intrinsics.checkNotNullParameter(r7, "newTask");
        if (Intrinsics.areEqual(b.get(r7.a), Boolean.TRUE) == false) goto L6;
        FLogger.a.i("TaskCenterTaskManager", "post task blocked (already cancelled), taskId = " + r7.a);
        return;
    L6:
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = "";
        FLogger.a.i("TaskCenterTaskManager", "post task, taskId = " + r7.a);
        ConcurrentHashMap<String, com.obric.assistant.task.b> r1 = a;
        String r3 = r7.a;
        final ?? r4 = new com.obric.assistant.task.c(r7, r0, r2);
        r1.compute(r3, new com.obric.assistant.task.d(r4));
        b();
        if (r0.element == false) goto L10;
        c((String) r2.element);
        return;
    }

    @Override // com.obric.assistant.task.ITaskCenter
    public final void cancel(String r4) {
        Intrinsics.checkNotNullParameter(r4, "id");
        FLogger.a.i("TaskCenterTaskManager", "cancel task, taskId = " + r4);
        b.put(r4, Boolean.TRUE);
        if (a.remove(r4) == null) goto L6;
        b();
        c("Task Cancelled");
        return;
    }

    @Override // com.obric.assistant.task.ITaskCenter
    public final com.obric.assistant.task.b get(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        return a.get(r2);
    }
}
