package com.bytedance.apm6.cpu.service;

import android.util.Pair;
import com.bytedance.apm6.service.perf.ICpuDataService;
import java.util.Collection;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class CurrentCpuDataHolder implements ICpuDataService {
    private Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> exceptionTopThread;
    private double rate;
    private double speed;
    private Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> topThread;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.service.CurrentCpuDataHolder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class SingletonHolder {
        private static final CurrentCpuDataHolder instance = null;

        static {
            instance = new CurrentCpuDataHolder(null);
        }

        private SingletonHolder() {
        }

        static /* synthetic */ CurrentCpuDataHolder access$100() {
            return instance;
        }
    }

    private CurrentCpuDataHolder() {
        this.rate = -1.0d;
        this.speed = -1.0d;
        this.topThread = new Pair(0L, new LinkedList());
        this.exceptionTopThread = new Pair(0L, new LinkedList());
    }

    /* synthetic */ CurrentCpuDataHolder(AnonymousClass1 r10) {
        this();
    }

    public static CurrentCpuDataHolder getInstance() {
        return SingletonHolder.access$100();
    }

    @Override // com.bytedance.apm6.service.perf.ICpuDataService
    public double getCpuRate() {
        return this.rate;
    }

    @Override // com.bytedance.apm6.service.perf.ICpuDataService
    public double getCpuSpeed() {
        return this.speed;
    }

    @Override // com.bytedance.apm6.service.perf.ICpuDataService
    public Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> getExceptionThreadList() {
        if (((LinkedList) this.exceptionTopThread.second).isEmpty() == false) goto L7;
        return this.exceptionTopThread;
    L7:
        return new Pair(this.exceptionTopThread.first, new LinkedList((Collection) this.exceptionTopThread.second));
    }

    @Override // com.bytedance.apm6.service.perf.ICpuDataService
    public Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> getThreadList() {
        if (((LinkedList) this.topThread.second).isEmpty() == false) goto L7;
        return this.topThread;
    L7:
        return new Pair(this.topThread.first, new LinkedList((Collection) this.topThread.second));
    }

    public void refreshData(double r10, double r11) {
        this.rate = r10;
        this.speed = r11;
    }

    public synchronized void refreshExceptionTopThreadData(LinkedList<ICpuDataService.ThreadCpuItem> r10) {
        monitor-enter(this);
        this.exceptionTopThread = new Pair(Long.valueOf(System.currentTimeMillis()), r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void refreshTopThreadData(LinkedList<ICpuDataService.ThreadCpuItem> r10) {
        monitor-enter(this);
        this.topThread = new Pair(Long.valueOf(System.currentTimeMillis()), r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
