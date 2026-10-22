package com.bytedance.applog.priority;

import c4.b;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PriorityWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f3780a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3781b = null;

    public static class a extends b {
        public a() {
            super(0);
        }

        @Override // c4.b
        public final Object a(Object[] r8) {
            System.loadLibrary("applog_rust");
            return Boolean.TRUE;
        }
    }

    static {
        f3780a = Collections.singletonList("Priority3");
        f3781b = new a();
    }

    public PriorityWrapper() {
        throw null;
    }

    private static native int initHooks();

    private static native int nativeAddSessionDuration(String r8, String r10, String r11, long r12, String r13);

    private static native int nativeInitPriority(String r8, String r10, String r11, String r12, PriorityCallback r13, PriorityEventMetaFactory r14, boolean r15, boolean r16);

    private static native boolean nativeIsPriorityEmpty(String r8);

    private static native boolean nativeIsPriorityMatchEventType(String r8, int r10);

    private static native int nativeNewSession(String r8, String r10, boolean r11, long r12, String r13);

    private static native int nativePriorityFlush(String r8);

    private static native String nativePriorityGetVersionConfig(String r8);

    private static native int nativePriorityOnEvent(String r8, int r10, String r11, NativeLazyString r12);

    private static native int nativePrioritySetConfig(String r8, String r10);

    private static native int nativeStartPriority(String r8);

    private static native void onHttpPostResponse(long r8, PriorityHttpResponse r10);

    private static native void setDefaultThreadNum(int r8);

    private static native void setThreadType(int r8);
}
