package com.ss.android.ugc.bytex.pthread.base.convergence.scheduler;

import com.ss.android.ugc.bytex.pthread.base.convergence.dredge.DredgeStrategies;
import com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy;
import com.ss.android.ugc.bytex.pthread.base.convergence.executor.IResourceExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.executor.IResourceExecutorFactory;
import com.ss.android.ugc.bytex.pthread.base.convergence.executor.MigrateExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadExecutePolicy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J,\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J$\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J6\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bJ\b\u0010\u001e\u001a\u00020\u000bH\u0016J\u0018\u0010\u001f\u001a\u00020\u001c*\u00020\u00072\n\u0010 \u001a\u00020!\"\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PrioritySchedulerFactory;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/SchedulerFactory;", "factory", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutorFactory;", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutorFactory;)V", "priorityExecutorMap", "", "", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/MigrateExecutor;", "schedulers", "", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/Scheduler;", "addInferiorScheduler", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutor;", "expectSize", "interval", "", "keepAliveTime", "threadExecutePolicy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadExecutePolicy;", "addOrdinaryScheduler", "fusingSize", "addPivotalScheduler", "addPriorityScheduler", "level", "dredgeStrategy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;", "addScheduler", "", "scheduler", "createScheduler", "migrateTo", "recipientLevel", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class PrioritySchedulerFactory implements SchedulerFactory {
    private final IResourceExecutorFactory factory;
    private final Map<Integer, MigrateExecutor> priorityExecutorMap;
    private final List<Scheduler> schedulers;

    public PrioritySchedulerFactory(IResourceExecutorFactory r1) {
        this.factory = r1;
        this.priorityExecutorMap = new LinkedHashMap();
        this.schedulers = new ArrayList();
    }

    public static /* synthetic */ IResourceExecutor addInferiorScheduler$default(PrioritySchedulerFactory r7, int r8, long r9, long r11, IThreadExecutePolicy r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = 500;
    L5:
        long r2 = r9;
        if ((r14 & 4) == 0) goto L8;
        r11 = 30000;
    L8:
        long r4 = r11;
        if ((r14 & 8) == 0) goto L12;
        r13 = null;
    L12:
        return r7.addInferiorScheduler(r8, r2, r4, r13);
    }

    public static /* synthetic */ IResourceExecutor addOrdinaryScheduler$default(PrioritySchedulerFactory r6, int r7, int r8, long r9, IThreadExecutePolicy r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = 30000;
    L5:
        long r3 = r9;
        if ((r12 & 8) == 0) goto L9;
        r11 = null;
    L9:
        return r6.addOrdinaryScheduler(r7, r8, r3, r11);
    }

    public static /* synthetic */ IResourceExecutor addPivotalScheduler$default(PrioritySchedulerFactory r0, int r1, long r2, IThreadExecutePolicy r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = 30000;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r0.addPivotalScheduler(r1, r2, r4);
    }

    public static /* synthetic */ IResourceExecutor addPriorityScheduler$default(PrioritySchedulerFactory r7, int r8, int r9, IDredgeStrategy r10, long r11, IThreadExecutePolicy r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = 30000;
    L5:
        long r4 = r11;
        if ((r14 & 16) == 0) goto L9;
        r13 = null;
    L9:
        return r7.addPriorityScheduler(r8, r9, r10, r4, r13);
    }

    private final void migrateTo(int r5, int... r6) {
        MigrateExecutor r7 = this.priorityExecutorMap.get(Integer.valueOf(r5));
        if (r7 == null) goto L10;
        int r0 = r6.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L14;
        int r2 = r6[r1];
        MigrateExecutor r3 = this.priorityExecutorMap.get(Integer.valueOf(r2));
        if (r3 == null) goto L9;
        r7.migrateTo(r3);
    L9:
        r1 = r1 + 1;
        goto L5
    L14:
        return;
    }

    public final IResourceExecutor addInferiorScheduler(int r13, long r14, long r16, IThreadExecutePolicy r18) {
        return addPriorityScheduler(1, r13, DredgeStrategies.createLooseStrategy$default(DredgeStrategies.INSTANCE, r13, r14, 0.5f, 0, 0, 0, 56, null), r16, r18);
    }

    public final IResourceExecutor addOrdinaryScheduler(int r13, int r14, long r15, IThreadExecutePolicy r17) {
        return addPriorityScheduler(6, r13, DredgeStrategies.createFusingStrategy$default(DredgeStrategies.INSTANCE, r13, r14, 0, 0, 0, 28, null), r15, r17);
    }

    public final IResourceExecutor addPivotalScheduler(int r13, long r14, IThreadExecutePolicy r16) {
        return addPriorityScheduler(11, r13, DredgeStrategies.createLooseStrategy$default(DredgeStrategies.INSTANCE, r13, 0, 1.0f, 0, 0, 0, 58, null), r14, r16);
    }

    public final IResourceExecutor addPriorityScheduler(int r9, int r10, IDredgeStrategy r11, long r12, IThreadExecutePolicy r14) {
        IResourceExecutor r13 = this.factory.create("level-" + r9, 0, r10, r11, r14, r12);
        this.priorityExecutorMap.put(Integer.valueOf(r9), r13);
        addScheduler(new PriorityScheduler(r9, r13));
        return r13;
    }

    public final void addScheduler(Scheduler r2) {
        this.schedulers.add(r2);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.SchedulerFactory
    public Scheduler createScheduler() {
        migrateTo(16, new int[]{11});
        migrateTo(11, new int[]{6});
        migrateTo(6, new int[]{11, 1});
        List<Scheduler> r0 = this.schedulers;
        if (r0 == null) goto L11;
        Object[] r1 = r0.toArray(new Scheduler[0]);
        if (r1 == null) goto L9;
        return new DispatchScheduler((Scheduler[]) r1);
    L9:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L11:
        throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
    }
}
