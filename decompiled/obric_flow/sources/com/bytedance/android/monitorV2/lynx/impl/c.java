package com.bytedance.android.monitorV2.lynx.impl;

import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import k5.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import mn.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3680a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f3681b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f3682c = null;

    static {
        f3680a = LazyKt.lazy(LynxProxy$setExtraTimingMethod$2.f3644a);
        LazyKt.lazy(LynxProxy$isHasActualFMP$2.f3642a);
        f3681b = LazyKt.lazy(LynxProxy$onTimingSetupMethod$2.f3643a);
        f3682c = LazyKt.lazy(LynxProxy$getOriginLeft$2.f3641a);
    }

    public static void a(LynxView r10) {
        if (r10 == null) goto L31;
        Lazy r5 = f3680a;
        if (((g) r5.getValue()).a() == null) goto L32;
        ConcurrentHashMap r11 = j5.b.d(r10).s();
        d5.b.f("setExtraTiming_containerInfoData", r11.toString());
        g r12 = (g) r5.getValue();
        r12.getClass();
        r12.e = new WeakReference(r10);
        String[] r13 = {"open_time", "container_init_start", "container_init_end", "prepare_template_start", "prepare_template_end"};
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r13, "keys");
        LinkedHashMap r14 = new LinkedHashMap();
        int r15 = 0;
    L7:
        if (r15 >= 5) goto L12;
        String r16 = r13[r15];
        if (r11.containsKey(r16) == false) goto L11;
        r14.put(r16, r11.get(r16));
    L11:
        r15 = r15 + 1;
        goto L7
    L12:
        Object[] r17 = {r14};
        Intrinsics.checkNotNullParameter(r17, "args");
        if (r12.a() == null) goto L33;
        Method r18 = r12.a();     // Catch: Throwable -> L19
        if (r18 == null) goto L34;
        WeakReference r19 = r12.e;     // Catch: Throwable -> L19
        if (r19 == null) goto L21;
        Object r20 = r19.get();     // Catch: Throwable -> L19
    L22:
        r18.invoke(r20, Arrays.copyOf(r17, 1));     // Catch: Throwable -> L19
        return;
    L21:
        r20 = null;
        goto L22
    L34:
        return;
    L19:
        th = move-exception;
        h.g("default_handle", th);
        return;
    L33:
        return;
    L32:
        return;
    }
}
