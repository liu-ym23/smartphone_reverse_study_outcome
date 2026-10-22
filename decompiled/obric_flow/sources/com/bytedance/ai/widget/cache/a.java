package com.bytedance.ai.widget.cache;

import com.bytedance.keva.Keva;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f2980a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f2981b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f2982c = null;
    public static final ConcurrentHashMap d = null;

    static {
        f2980a = Keva.getRepo("AI_SDK_WIDGET_DEBUG_REPO").getBoolean("WIDGET_ENABLE_CACHE", true);
        f2981b = new ConcurrentHashMap();
        f2982c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
    }

    public static String a(String r5, String r10) {
        return androidx.constraintlayout.motion.widget.a.m(r5, ':', r10);
    }
}
