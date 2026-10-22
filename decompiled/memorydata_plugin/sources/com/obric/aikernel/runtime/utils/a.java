package com.obric.aikernel.runtime.utils;

import android.os.Build;
import com.bytedance.crypto.platform.PlatformConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010&\u001a\u00020\u0004J\n\u0010'\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u001b\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001d\u0010\u0010R\u0011\u0010 \u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010R\u001b\u0010\"\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b#\u0010\u0010R\u0010\u0010%\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/aikernel/runtime/utils/DeviceUtils;", "", "()V", "PROJECT_DH", "", "PROJECT_G1", "PROJECT_GR", "PROJECT_MOTO", "PROJECT_NUBIA", "PROJECT_OBRIC", "PROJECT_SIMULATOR", "PROJECT_UNKNOWN", "TAG", PlatformConst.BUNDLE_KEY_BRAND, "kotlin.jvm.PlatformType", "getBrand", "()Ljava/lang/String;", "device", "getDevice", "isDh", "", "()Z", "isG1", "isGR", "isN1", "isPacific", "isPike", "isSimulator", "obricProductType", "getObricProductType", "obricProductType$delegate", "Lkotlin/Lazy;", "obricProject", "getObricProject", "obricRegion", "getObricRegion", "obricRegion$delegate", "projectFromConfig", "dumpDeviceInfo", "getBrandFromStaticConfig", "pyvm_utils_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6212a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f6213b = null;
    private static final Lazy c = null;
    private static final String d = null;
    private static final String e = null;
    private static final String f = null;
    private static final String g = null;
    private static final boolean h = false;
    private static final boolean i = false;
    private static final boolean j = false;
    private static final boolean k = false;
    private static final boolean l = false;
    private static final boolean m = false;
    private static final boolean n = false;

    static {
        a r0 = new a();
        f6212a = r0;
        f6213b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(DeviceUtils$obricProductType$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(DeviceUtils$obricRegion$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        String r1 = r0.f();
        d = r1;
        String r2 = Build.BRAND;
        e = r2;
        boolean r4 = true;
        if (r1 != null) goto L5;
    L10:
        r4 = false;
    L12:
        if (r4 == false) goto L15;
        d.f6216a.e("DeviceUtils", "getBrandFromStaticConfig: " + r1);
    L39:
        f = r1;
        String r5 = Build.MODEL;
        g = r5;
        h = Intrinsics.areEqual(r1, "genesis_simu");
        i = Intrinsics.areEqual(r1, "genesis");
        j = Intrinsics.areEqual(r1, "genesis_r");
        k = Intrinsics.areEqual(r1, "nubia");
        l = Intrinsics.areEqual(r1, "obric");
        m = Intrinsics.areEqual(r1, "moto");
        n = Intrinsics.areEqual(r1, "genesis_dh");
        d.f6216a.e("DeviceUtils", "brand:" + r2 + ", project:" + r1 + ", device:" + r5 + ", region:" + r0.a() + ", o_product: " + r0.e() + ", " + r0.d());
        return;
    L15:
        if (Intrinsics.areEqual(Build.MODEL, "G1") == false) goto L18;
        r1 = "genesis";
        goto L39
    L18:
        if (Intrinsics.areEqual(Build.DEVICE, "PQ85A02") == false) goto L21;
    L19:
        r1 = "nubia";
        goto L39
    L21:
        if (Intrinsics.areEqual(Build.DEVICE, "pacific") == false) goto L24;
    L22:
        r1 = "obric";
        goto L39
    L24:
        if (Intrinsics.areEqual(r0.e(), "nerida") == true) goto L19;
        if (Intrinsics.areEqual(r0.e(), "pacific") == true) goto L22;
        if (Intrinsics.areEqual(r0.e(), "Genesis-R") == false) goto L33;
        r1 = "genesis_r";
        goto L39
    L33:
        if (Intrinsics.areEqual(r0.e(), "pike") == false) goto L36;
        r1 = "moto";
        goto L39
    L36:
        if (Intrinsics.areEqual(r0.e(), "Genesis-M") == false) goto L38;
        r1 = "genesis_dh";
        goto L39
    L38:
        r1 = "unknown";
        goto L39
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 != true) goto L10;
    L7:
        r3 = false;
        goto L8
    }

    private a() {
    }

    private final String e() {
        return (String) ZeusTransformUtils.preCheckCast(f6213b.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    private final String f() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Class r3 = ZeusTransformUtils.forName("com.obric.aikernel.dist.DeviceDistConfig", "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl((String) ZeusTransformUtils.preCheckCast(r3.getField(PlatformConst.BUNDLE_KEY_BRAND).get(r3), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r4) == false) goto L11;
        r4 = null;
    L11:
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final String a() {
        return (String) ZeusTransformUtils.preCheckCast(c.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final String b() {
        return f;
    }

    public final boolean c() {
        return i;
    }

    public final String d() {
        return Build.MODEL + '|' + Build.DEVICE;
    }
}
