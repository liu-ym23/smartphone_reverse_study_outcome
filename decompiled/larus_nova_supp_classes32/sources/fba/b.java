package fba;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final Lazy<Boolean> a;
    public final Lazy<Boolean> b;
    public final Lazy<Boolean> c;
    public final Lazy<Boolean> d;
    public final Lazy<Boolean> e;
    public final Lazy<Integer> f;
    public final Lazy<Boolean> g;
    public final Lazy<Boolean> h;
    public final Lazy<Boolean> i;
    public final Lazy<Boolean> j;

    public static void a(StringBuilder r1, String r2, Lazy r3) {
        if (r3.isInitialized() == true) goto L6;
        return;
    L6:
        if (r1.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        r1.append(' ');
    L11:
        r1.append(r2);
        r1.append('=');
        r1.append(r3.getValue());
        return;
    L8:
        r0 = false;
        goto L9
    }

    public b(o r2, p r3, d r4, e r5, f r6, g r7, h r8, i r9, j r10, k r11) {
        Intrinsics.checkNotNullParameter(r2, "isScreenInteractiveProvider");
        Intrinsics.checkNotNullParameter(r3, "aiKeyEnabledWhenScreenOffProvider");
        Intrinsics.checkNotNullParameter(r4, "isLandscapeProvider");
        Intrinsics.checkNotNullParameter(r5, "isKeyguardLockedProvider");
        Intrinsics.checkNotNullParameter(r6, "isDeviceLockedProvider");
        Intrinsics.checkNotNullParameter(r7, "audioModeProvider");
        Intrinsics.checkNotNullParameter(r8, "hasRecordAudioPermissionProvider");
        Intrinsics.checkNotNullParameter(r9, "isMicInUseByOtherPackageProvider");
        Intrinsics.checkNotNullParameter(r10, "isNetworkAvailableProvider");
        Intrinsics.checkNotNullParameter(r11, "canDrawOverlaysProvider");
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.a = LazyKt.lazy(r0, r2);
        this.b = LazyKt.lazy(r0, r3);
        this.c = LazyKt.lazy(r0, r4);
        this.d = LazyKt.lazy(r0, r5);
        this.e = LazyKt.lazy(r0, r6);
        this.f = LazyKt.lazy(r0, r7);
        this.g = LazyKt.lazy(r0, r8);
        this.h = LazyKt.lazy(r0, r9);
        this.i = LazyKt.lazy(r0, r10);
        this.j = LazyKt.lazy(r0, r11);
    }
}
