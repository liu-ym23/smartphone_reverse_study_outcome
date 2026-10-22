package es;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap f16864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a[] f16865b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a[] f16866c = null;
    public static final a[] d = null;
    public static final a[] e = null;
    public static final a[] f = null;
    public static final a[] g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a[] f16867h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a[] f16868i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a[] f16869j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a[] f16870k = null;

    static {
        f16865b = new a[]{new a(251658240, -1, 0.0f, 2.0f, 10.0f, 0.0f)};
        f16866c = new a[]{new a(335544320, -1, 0.0f, 8.0f, 24.0f, 0.0f), new a(134217728, -1, 0.0f, 2.0f, 10.0f, 0.0f)};
        d = new a[]{new a(603979776, -1, 0.0f, 12.0f, 24.0f, 0.0f)};
        e = new a[]{new a(687865856, -1, 0.0f, 16.0f, 60.0f, 0.0f)};
        f = new a[]{new a(167772160, -1, 0.0f, 1.0f, 2.5f, 0.0f), new a(167772160, -1, 0.0f, 0.0f, 1.0f, 0.0f)};
        g = new a[]{new a(251658240, -1, 0.0f, 2.0f, 10.0f, 0.0f)};
        f16867h = new a[]{new a(218103808, -1, 0.0f, 6.0f, 20.0f, 0.0f), new a(83886080, -1, 0.0f, 2.0f, 10.0f, 0.0f)};
        f16868i = new a[]{new a(520093696, -1, 0.0f, 12.0f, 24.0f, 0.0f)};
        f16869j = new a[]{new a(687865856, -1, 0.0f, 16.0f, 60.0f, 0.0f)};
        f16870k = new a[]{new a(167772160, -1, 0.0f, 1.0f, 2.5f, 0.0f), new a(167772160, -1, 0.0f, 0.0f, 1.0f, 0.0f)};
    }

    public static final a a(b r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        float r5 = r10.f16861a;
        int r11 = r10.f;
        float r12 = r10.f16862b;
        float r13 = r10.f16863c;
        return new a(r10.d, r11, r5, r12, r13, r10.e);
    }
}
