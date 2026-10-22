package om0;

import com.bytedance.crash.d;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static b a;
    public static volatile boolean b;
    public static a c;
    public static volatile boolean d;
    public static final c e = null;

    public c() {
    }

    static {
        e = new c();
    }

    public static boolean a() {
        if (d == true) goto L6;
        d.d(new RuntimeException("LiveMiddleLayerSDK host failed"), "LiveMiddleLayerSDK  host failed");
    L6:
        return d;
    }

    public static boolean b() {
        if (b == true) goto L6;
        d.d(new RuntimeException("LiveMiddleLayerSDK live failed"), "LiveMiddleLayerSDK live failed");
    L6:
        return b;
    }

    @JvmStatic
    public static final pm0.a c() {
        if (a() == false) goto L9;
        a r0 = c;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mHostMiddleLayer");
    L8:
        return r0.a;
    L9:
        return null;
    }

    @JvmStatic
    public static final qm0.a d() {
        if (a() == false) goto L9;
        a r0 = c;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mHostMiddleLayer");
    L8:
        return r0.b;
    L9:
        return null;
    }

    @JvmStatic
    public static final rm0.a e() {
        if (a() == false) goto L9;
        a r0 = c;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mHostMiddleLayer");
    L8:
        return r0.f;
    L9:
        return null;
    }

    @JvmStatic
    public static final pm0.b f() {
        if (b() == false) goto L9;
        b r0 = a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mMiddleLayer");
    L8:
        return r0.a;
    L9:
        return null;
    }

    @JvmStatic
    public static final qm0.b g() {
        if (b() == false) goto L9;
        b r0 = a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mMiddleLayer");
    L8:
        return r0.b;
    L9:
        return null;
    }

    @JvmStatic
    public static final wm0.a h() {
        if (b() == false) goto L9;
        b r0 = a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mMiddleLayer");
    L8:
        return r0.c;
    L9:
        return null;
    }

    @JvmStatic
    public static final um0.a i() {
        if (b() == false) goto L9;
        b r0 = a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mMiddleLayer");
    L8:
        return r0.d;
    L9:
        return null;
    }

    @JvmStatic
    public static final wm0.b j() {
        if (a() == false) goto L9;
        a r0 = c;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mHostMiddleLayer");
    L8:
        return r0.c;
    L9:
        return null;
    }

    @JvmStatic
    public static final vm0.a k() {
        if (a() == false) goto L9;
        a r0 = c;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mHostMiddleLayer");
    L8:
        return r0.d;
    L9:
        return null;
    }
}
