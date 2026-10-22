package com.obric.oui.color;

import av.i;
import com.bytedance.ai.model.m;
import com.obric.oui.graphic.BlendMode;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final d A = null;
    public static final m B = null;
    public static final d C = null;
    public static final d D = null;
    public static final m E = null;
    public static final d F = null;
    public static final d G = null;
    public static final m H = null;
    public static final d I = null;
    public static final d J = null;
    public static final m K = null;
    public static final d L = null;
    public static final d M = null;
    public static final m N = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap f12429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ConcurrentHashMap f12430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f12431c = null;
    public static final d d = null;
    public static final m e = null;
    public static final d f = null;
    public static final d g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final m f12432h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f12433i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f12434j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final m f12435k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f12436l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f12437m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final m f12438n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f12439o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f12440p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d f12441q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f12442r = null;
    public static final m s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final d f12443t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f12444u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final m f12445v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f12446w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final d f12447x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final m f12448y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final d f12449z = null;

    static {
        BlendMode r5 = BlendMode.SRC_OVER;
        f12431c = new d(1.0f, 1728053247, r5);
        d = new d(1.0f, 1715618370, r5);
        e = new m(4);
        f = new d(1.0f, 452984831, r5);
        g = new d(1.0f, 452984831, r5);
        f12432h = new m(9);
        f12433i = new d(1.0f, 1728053247, r5);
        f12434j = new d(1.0f, 134217728, r5);
        f12435k = new m(10);
        f12436l = new d(1.0f, 1727526903, r5);
        f12437m = new d(1.0f, 1294872110, r5);
        f12438n = new m(11);
        f12439o = new d(1.0f, 1728053247, r5);
        f12440p = new d(1.0f, 1728053247, r5);
        f12441q = new d(1.0f, 1713799679, r5);
        f12442r = new d(1.0f, 1713799679, r5);
        s = new m(12);
        f12443t = new d(1.0f, 1718003455, r5);
        f12444u = new d(1.0f, 1718003455, r5);
        f12445v = new m(13);
        f12446w = new d(1.0f, 1728007501, r5);
        f12447x = new d(1.0f, 1728007501, r5);
        f12448y = new m(14);
        f12449z = new d(1.0f, 1728022407, r5);
        A = new d(1.0f, 1728022407, r5);
        B = new m(15);
        C = new d(1.0f, 1712637776, r5);
        D = new d(1.0f, 1712637776, r5);
        E = new m(5);
        F = new d(1.0f, 1719135647, r5);
        G = new d(1.0f, 1719135647, r5);
        H = new m(6);
        I = new d(1.0f, 1728038170, r5);
        J = new d(1.0f, 1728038170, r5);
        K = new m(7);
        L = new d(1.0f, 1728041577, r5);
        M = new d(1.0f, 1728041577, r5);
        N = new m(8);
    }

    public static ConcurrentHashMap a(StrokeToken r5) {
        ConcurrentHashMap r10 = f12430b;
        if (r10 == null) goto L5;
    L15:
        return r10;
    L5:
        monitor-enter(f.class);
        r10 = f12430b;     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        ConcurrentHashMap r11 = i.n(Function1.class, r5);     // Catch: Throwable -> L9
        f12430b = r11;     // Catch: Throwable -> L9
        r10 = r11;
    L11:
        monitor-exit(f.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public static ConcurrentHashMap b(StrokeToken r5) {
        ConcurrentHashMap r10 = f12429a;
        if (r10 == null) goto L5;
    L15:
        return r10;
    L5:
        monitor-enter(f.class);
        r10 = f12429a;     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        ConcurrentHashMap r11 = i.n(d.class, r5);     // Catch: Throwable -> L9
        f12429a = r11;     // Catch: Throwable -> L9
        r10 = r11;
    L11:
        monitor-exit(f.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
