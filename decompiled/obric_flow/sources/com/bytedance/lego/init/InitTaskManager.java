package com.bytedance.lego.init;

import ai.j0;
import androidx.annotation.UiThread;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u0003J\u001b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\fJ\r\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u0003J\u0017\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b#\u0010$R\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\t0(j\b\u0012\u0004\u0012\u00020\t`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010.R\u0014\u00100\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b5\u00106¨\u00067"}, d2 = {"Lcom/bytedance/lego/init/InitTaskManager;", "", "<init>", "()V", "", "hasNonUiTask", "()Z", "", "initReadyQueue", "Lkf/d;", "taskInfo", "letTaskReady", "(Lkf/d;)V", "init", "", "timeout", "takeUiTaskIfExist", "(J)Lkf/d;", "takeNonUiTaskIfExist", "(Ljava/lang/Long;)Lkf/d;", "Lcom/bytedance/lego/init/model/InitPeriod;", "period", "takeNonUiTaskMainThreadIfExist", "(Lcom/bytedance/lego/init/model/InitPeriod;)Lkf/d;", "task", "onTaskComplete", "beforeSendMonitor", "", "taskId", "getInitTaskInfoById", "(Ljava/lang/String;)Lkf/d;", "", "getTaskDependencyById", "(Ljava/lang/String;)Ljava/util/List;", "", "getPriorityByTaskId", "(Ljava/lang/String;)F", "", "taskIndex", "Ljava/util/Map;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "unDispatchTask", "Ljava/util/ArrayList;", "Ljava/util/concurrent/PriorityBlockingQueue;", "uiReadyQueue", "Ljava/util/concurrent/PriorityBlockingQueue;", "nonUiReadyQueue", "readWriteLock", "Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicInteger;", "completedTaskCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "TAG", "Ljava/lang/String;", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
public final class InitTaskManager {
    private final String TAG;
    private AtomicInteger completedTaskCount;
    private final PriorityBlockingQueue<kf.d> nonUiReadyQueue;
    private final Object readWriteLock;
    private Map<String, kf.d> taskIndex;
    private final PriorityBlockingQueue<kf.d> uiReadyQueue;
    private final ArrayList<kf.d> unDispatchTask;

    public InitTaskManager() {
        this.taskIndex = new LinkedHashMap();
        this.unDispatchTask = new ArrayList();
        this.uiReadyQueue = new PriorityBlockingQueue();
        this.nonUiReadyQueue = new PriorityBlockingQueue();
        this.readWriteLock = new Object();
        this.completedTaskCount = new AtomicInteger(0);
        this.TAG = "InitTaskManager";
    }

    private final boolean hasNonUiTask() {
        Object r5 = this.readWriteLock;
        monitor-enter(r5);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.nonUiReadyQueue.isEmpty() == true) goto L9;
        monitor-exit(r5);
        return true;
    L9:
        Iterator<T> r10 = this.unDispatchTask.iterator();     // Catch: Throwable -> L16
        if (r10.hasNext() == true) goto L14;
        monitor-exit(r5);
        return false;
    L14:
        j0.A(r10.next());     // Catch: Throwable -> L16
        throw null;     // Catch: Throwable -> L16
    }

    private final void initReadyQueue() {
        Collection<kf.d> r5 = this.taskIndex.values();
        if (r5 == null) goto L9;
        Iterator<T> r10 = r5.iterator();
        if (r10.hasNext() == false) goto L10;
        j0.A(r10.next());
        throw null;
    L10:
        return;
    }

    private final void letTaskReady(kf.d r5) {
        throw null;
    }

    public static /* synthetic */ kf.d takeNonUiTaskIfExist$default(InitTaskManager r5, Long r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        r5.takeNonUiTaskIfExist(r10);
        return null;
    }

    @UiThread
    public static /* synthetic */ kf.d takeUiTaskIfExist$default(InitTaskManager r5, long r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = 5;
    L5:
        r5.takeUiTaskIfExist(r10);
        return null;
    }

    public final void beforeSendMonitor() {
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.completedTaskCount.get() == this.taskIndex.size()) goto L14;
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L7
        r5.put("count", this.completedTaskCount.get() - this.taskIndex.size());     // Catch: Exception -> L7
        r5.put("undispatchCount", this.unDispatchTask.size());     // Catch: Exception -> L7
        Iterator<T> r10 = this.unDispatchTask.iterator();     // Catch: Exception -> L7
        if (r10.hasNext() == true) goto L9;
        InitMonitor r11 = InitMonitor.INSTANCE;     // Catch: Exception -> L7
        Category r12 = Category.TASK_COUNT_EXCEPTION;     // Catch: Exception -> L7
        String r13 = String.valueOf(this.completedTaskCount.get() - this.taskIndex.size());     // Catch: Exception -> L7
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L7
        r14.put("task_count_exception", r5);     // Catch: Exception -> L7
        r11.monitorEvent(r12, r13, r14);     // Catch: Exception -> L7
        return;
    L9:
        j0.A(r10.next());     // Catch: Exception -> L7
        throw null;     // Catch: Exception -> L7
    }

    public final kf.d getInitTaskInfoById(String r5) {
        j0.A(this.taskIndex.get(r5));
        return null;
    }

    public final float getPriorityByTaskId(String r5) {
        j0.A(this.taskIndex.get(r5));
        return -1.0f;
    }

    public final List<String> getTaskDependencyById(String r5) {
        ArrayList r10 = new ArrayList();
        Object r11 = this.readWriteLock;
        monitor-enter(r11);
        j0.A(this.taskIndex.get(r5));     // Catch: Throwable -> L7
        monitor-exit(r11);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final void init() {
        long r5 = System.currentTimeMillis();
        HashMap r10 = o.g;
        r10.isEmpty();
        this.taskIndex = r10;
        com.bytedance.lego.init.util.b.b("collect cos: " + (System.currentTimeMillis() - r5) + "ms  size: " + this.taskIndex.size());
        InitMonitor r11 = InitMonitor.INSTANCE;
        r11.monitorCosTime("InitTaskManager.CollectTasks", System.currentTimeMillis() - r5, false);
        this.unDispatchTask.addAll(this.taskIndex.values());
        initReadyQueue();
        l r12 = l.f6750m;
        boolean r13 = this.taskIndex.isEmpty();
        r12.getClass();
        l.f6748k = r13;
        r11.monitorCosTime("InitTaskManager.init", System.currentTimeMillis() - r5, false);
    }

    public final void onTaskComplete(kf.d r5) {
        monitor-enter(this.readWriteLock);
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final kf.d takeNonUiTaskIfExist(Long r5) {
        if (hasNonUiTask() == true) goto L5;
        return null;
    L5:
        if (r5 == null) goto L8;
        j0.A(this.nonUiReadyQueue.poll(r5.longValue(), TimeUnit.MILLISECONDS));
        return null;
    L8:
        j0.A(this.nonUiReadyQueue.take());
        return null;
    }

    public final kf.d takeNonUiTaskMainThreadIfExist(InitPeriod r5) {
        if (hasNonUiTask() == true) goto L5;
        return null;
    L5:
        Iterator<kf.d> r10 = this.nonUiReadyQueue.iterator();
        if (r10.hasNext() == true) goto L8;
        return null;
    L8:
        j0.A(r10.next());
        throw null;
    }

    @UiThread
    public final kf.d takeUiTaskIfExist(long r5) {
        j0.A(this.uiReadyQueue.poll(r5, TimeUnit.MILLISECONDS));     // Catch: Exception -> L5
        return null;
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
