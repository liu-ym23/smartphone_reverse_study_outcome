package com.obric.aikernel.runtime.utils;

import android.os.Build;
import com.bytedance.crypto.platform.PlatformConst;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DeviceUtils f5383a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f5384b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f5385c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f5386d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f5387e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f5388f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f5389g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final boolean f5390h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final boolean f5391i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final boolean f5392j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final boolean f5393k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final boolean f5394l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final boolean f5395m = false;

    static {
        DeviceUtils r10 = new DeviceUtils();
        f5383a = r10;
        f5384b = LazyKt.lazy(DeviceUtils$obricProductType$2.INSTANCE);
        f5385c = LazyKt.lazy(DeviceUtils$obricRegion$2.INSTANCE);
        String r11 = r10.c();
        f5386d = r11;
        String r12 = Build.BRAND;
        f5387e = r12;
        boolean r13 = true;
        if (r11 != null) goto L5;
    L10:
        r13 = false;
    L12:
        if (r13 == false) goto L15;
        d.f5417a.g("DeviceUtils", "getBrandFromStaticConfig: " + r11);
    L36:
        f5388f = r11;
        String r14 = Build.MODEL;
        f5389g = r14;
        f5390h = Intrinsics.areEqual(r11, "genesis_simu");
        f5391i = Intrinsics.areEqual(r11, "genesis");
        f5392j = Intrinsics.areEqual(r11, "genesis_r");
        f5393k = Intrinsics.areEqual(r11, "nubia");
        f5394l = Intrinsics.areEqual(r11, "obric");
        f5395m = Intrinsics.areEqual(r11, "moto");
        d.f5417a.g("DeviceUtils", "brand:" + r12 + ", project:" + r11 + ", device:" + r14 + ", region:" + r10.g() + ", o_product: " + r10.e() + ", " + r10.a());
        return;
    L15:
        if (Intrinsics.areEqual(Build.MODEL, "G1") == false) goto L17;
        r11 = "genesis";
        goto L36
    L17:
        String r15 = Build.DEVICE;
        if (Intrinsics.areEqual(r15, "PQ85A02") == false) goto L21;
    L19:
        r11 = "nubia";
        goto L36
    L21:
        if (Intrinsics.areEqual(r15, "pacific") == false) goto L24;
    L22:
        r11 = "obric";
        goto L36
    L24:
        if (Intrinsics.areEqual(r10.e(), "nerida") == true) goto L19;
        if (Intrinsics.areEqual(r10.e(), "pacific") == true) goto L22;
        if (Intrinsics.areEqual(r10.e(), "Genesis-R") == false) goto L33;
        r11 = "genesis_r";
        goto L36
    L33:
        if (Intrinsics.areEqual(r10.e(), "pike") == false) goto L35;
        r11 = "moto";
        goto L36
    L35:
        r11 = "unknown";
        goto L36
    L5:
        if (r11.length() <= 0) goto L7;
        boolean r16 = true;
    L8:
        if (r16 != true) goto L10;
    L7:
        r16 = false;
        goto L8
    }

    private DeviceUtils() {
    }

    private final String c() {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        Class<?> r11 = Class.forName("com.obric.aikernel.dist.DeviceDistConfig");     // Catch: Throwable -> L4
        Object r12 = Result.m32constructorimpl((String) r11.getField(PlatformConst.BUNDLE_KEY_BRAND).get(r11));     // Catch: Throwable -> L4
    L7:
        if (Result.m38isFailureimpl(r12) == false) goto L10;
        r12 = null;
    L10:
        return (String) r12;
    L4:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final String e() {
        return (String) f5384b.getValue();
    }

    public final String a() {
        return Build.MODEL + '|' + Build.DEVICE;
    }

    public final String b() {
        return f5387e;
    }

    public final String d() {
        return f5389g;
    }

    public final String f() {
        return f5388f;
    }

    public final String g() {
        return (String) f5385c.getValue();
    }

    public final boolean h() {
        return f5391i;
    }

    public final boolean i() {
        return f5392j;
    }

    public final boolean j() {
        return f5393k;
    }

    public final boolean k() {
        return f5394l;
    }

    public final boolean l() {
        return f5395m;
    }

    public final boolean m() {
        return f5390h;
    }
}
