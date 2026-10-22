package com.ss.android.ug.bus;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f15733a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Type, ConcurrentHashMap<InterfaceC0838a, Object>> f15734b = null;
    private static final Handler c = null;

    /* JADX INFO: renamed from: com.ss.android.ug.bus.a$a, reason: collision with other inner class name */
    public interface InterfaceC0838a<T> {
    }

    static {
        f15733a = new Object();
        f15734b = new ConcurrentHashMap();
        c = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ ConcurrentHashMap a() {
        return f15734b;
    }
}
