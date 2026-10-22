package com.bytedance.apm6.service.perf;

import android.util.Pair;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public interface ICpuDataService {

    public static class ThreadCpuItem {
        private double cpuUsage;
        private String threadName;
        private int tid;

        public ThreadCpuItem(String r10, double r11, int r12) {
            this.threadName = r10;
            this.cpuUsage = r11;
            this.tid = r12;
        }

        public double getCpuUsage() {
            return this.cpuUsage;
        }

        public String getThreadName() {
            return this.threadName;
        }

        public int getTid() {
            return this.tid;
        }
    }

    double getCpuRate();

    double getCpuSpeed();

    Pair<Long, LinkedList<ThreadCpuItem>> getExceptionThreadList();

    Pair<Long, LinkedList<ThreadCpuItem>> getThreadList();
}
