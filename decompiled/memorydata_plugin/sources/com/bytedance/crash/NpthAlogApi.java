package com.bytedance.crash;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NpthAlogApi {
    private static Runnable sAlogFlushRunnable;
    private static AlogGetFilesInterface sAlogGetFilesImpl;
    private static AlogInitInterface sAlogInitImpl;

    interface AlogGetFilesInterface {
        List<String> getFiles(long r1, String r3);
    }

    interface AlogInitInterface {
        boolean isInited();
    }

    public NpthAlogApi() {
    }

    public static void flushAlogSync() {
        Runnable r0 = sAlogFlushRunnable;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }

    public static List<String> getAlogFiles(long r1, String r3) {
        AlogGetFilesInterface r0 = sAlogGetFilesImpl;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFiles(r1, r3);
    }

    public static boolean getAlogFilesInit() {
        if (sAlogGetFilesImpl == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAlogInit() {
        AlogInitInterface r0 = sAlogInitImpl;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isInited() == false) goto L7;
        return true;
    }

    public static boolean sAlogFlushInit() {
        if (sAlogFlushRunnable == null) goto L5;
        return true;
    L5:
        return false;
    }

    static void setAlogFlushImpl(Runnable r2) {
        sAlogFlushRunnable = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
    }

    static void setAlogGetFilesImpl(AlogGetFilesInterface r2) {
        sAlogGetFilesImpl = (AlogGetFilesInterface) ZeusTransformUtils.wrapperContextForParams(r2, AlogGetFilesInterface.class, "com.obric.memorydata.plugin");
    }

    static void setAlogInitImpl(AlogInitInterface r2) {
        sAlogInitImpl = (AlogInitInterface) ZeusTransformUtils.wrapperContextForParams(r2, AlogInitInterface.class, "com.obric.memorydata.plugin");
    }
}
