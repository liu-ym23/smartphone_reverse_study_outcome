package com.bytedance.apm6.cpu.exception;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ThreadExceptionItem {
    private double cpuUsage;
    private StackTraceElement firstElement;
    private int priority;
    private long processCpuTime;
    private String stack;
    private long threadCpuTime;
    private int threadId;
    private String threadName;
    private String weight;

    public ThreadExceptionItem() {
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ThreadExceptionItem) == true) goto L8;
        return false;
    L8:
        ThreadExceptionItem r11 = (ThreadExceptionItem) r10;
        if (getThreadId() != r11.getThreadId()) goto L14;
        if (getThreadName().equals(r11.getThreadName()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public double getCpuUsage() {
        return this.cpuUsage;
    }

    public StackTraceElement getFirstElement() {
        return this.firstElement;
    }

    public String getKey() {
        return this.threadName + "/" + this.threadId;
    }

    public int getPriority() {
        return this.priority;
    }

    public long getProcessCpuTime() {
        return this.processCpuTime;
    }

    public String getStack() {
        return this.stack;
    }

    public long getThreadCpuTime() {
        return this.threadCpuTime;
    }

    public int getThreadId() {
        return this.threadId;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public String getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(getThreadId()), getThreadName()});
    }

    public void setCpuUsage(double r10) {
        this.cpuUsage = r10;
    }

    public void setFirstElement(StackTraceElement r10) {
        this.firstElement = r10;
    }

    public void setPriority(int r10) {
        this.priority = r10;
    }

    public void setProcessCpuTime(long r10) {
        this.processCpuTime = r10;
    }

    public void setStack(String r10) {
        this.stack = r10;
    }

    public void setThreadCpuTime(long r10) {
        this.threadCpuTime = r10;
    }

    public void setThreadId(int r10) {
        this.threadId = r10;
    }

    public void setThreadName(String r10) {
        this.threadName = r10;
    }

    public void setWeight(String r10) {
        this.weight = r10;
    }

    public String toString() {
        return "ThreadExceptionItem{threadId=" + this.threadId + ", threadName='" + this.threadName + "', threadCpuTime=" + this.threadCpuTime + ", processCpuTime=" + this.processCpuTime + ", cpuUsage=" + this.cpuUsage + ", weight=" + this.weight + ", nice=" + this.priority + '}';
    }
}
