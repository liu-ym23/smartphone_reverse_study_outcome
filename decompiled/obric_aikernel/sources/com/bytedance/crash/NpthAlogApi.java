package com.bytedance.crash;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NpthAlogApi {

    @Nullable
    private static Runnable sAlogFlushRunnable;

    @Nullable
    private static AlogGetFilesInterface sAlogGetFilesImpl;

    @Nullable
    private static AlogInitInterface sAlogInitImpl;

    interface AlogGetFilesInterface {
        List<String> getFiles(long r10, String r11);
    }

    interface AlogInitInterface {
        boolean isInited();
    }

    public NpthAlogApi() {
    }

    public static void flushAlogSync() {
        Runnable r10 = sAlogFlushRunnable;
        if (r10 == null) goto L6;
        r10.run();
        return;
    }

    @Nullable
    public static List<String> getAlogFiles(long r10, String r11) {
        AlogGetFilesInterface r12 = sAlogGetFilesImpl;
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.getFiles(r10, r11);
    }

    public static boolean getAlogFilesInit() {
        if (sAlogGetFilesImpl == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAlogInit() {
        AlogInitInterface r10 = sAlogInitImpl;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isInited() == false) goto L7;
        return true;
    }

    public static boolean sAlogFlushInit() {
        if (sAlogFlushRunnable == null) goto L5;
        return true;
    L5:
        return false;
    }

    static void setAlogFlushImpl(Runnable r10) {
        sAlogFlushRunnable = r10;
    }

    static void setAlogGetFilesImpl(AlogGetFilesInterface r10) {
        sAlogGetFilesImpl = r10;
    }

    static void setAlogInitImpl(AlogInitInterface r10) {
        sAlogInitImpl = r10;
    }
}
