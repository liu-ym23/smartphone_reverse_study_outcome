package com.bytedance.bdlocation.trace;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class LocateState {
    private static volatile long aMapLocateStopTime;
    private static Map<Object, Void> aMapLocationMark;
    private static AtomicInteger privacyMethodExecuteMark;

    static {
        privacyMethodExecuteMark = new AtomicInteger(0);
        aMapLocationMark = Collections.synchronizedMap(new WeakHashMap());
    }

    public LocateState() {
    }

    public static void aMapLocationStart(Object r8) {
        aMapLocationMark.put(r8, null);
    }

    public static void aMapLocationStop(Object r8) {
        aMapLocateStopTime = System.currentTimeMillis();
        aMapLocationMark.remove(r8);
    }

    public static long getAMapLocateStopTime() {
        return aMapLocateStopTime;
    }

    public static boolean isLocating() {
        if (privacyMethodExecuteMark.get() == 0) goto L5;
    L8:
        return true;
    L5:
        if (aMapLocationMark.isEmpty() == false) goto L8;
        return false;
    }

    public static void privacyMethodExecuteAdd() {
        privacyMethodExecuteMark.incrementAndGet();
    }

    public static void privacyMethodExecuteSubtract() {
        privacyMethodExecuteMark.decrementAndGet();
    }

    public static void updateAMapLocateStopTime() {
        aMapLocateStopTime = System.currentTimeMillis();
    }
}
