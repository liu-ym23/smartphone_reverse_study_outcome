package com.bytedance.apm.l;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashSet<HandlerThread> f1394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Handler f1395b;

    static {
        f1394a = new HashSet();
        f1395b = new Handler(Looper.getMainLooper());
    }

    public static Handler a() {
        return f1395b;
    }
}
