package com.larus.dora.obric.device_management.device_home;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b2 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraObricGlassesMode.values().length];
            r0[DoraObricGlassesMode.ASSISTANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DoraObricGlassesMode.HEADPHONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DoraObricGlassesMode.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public static z1 a(DoraObricDeviceModeEntryProduct r8, h3 r9) {
        Intrinsics.checkNotNullParameter(r8, "product");
        Intrinsics.checkNotNullParameter(r9, "state");
        if (a2.a(r8) == true) goto L5;
        return null;
    L5:
        if (r9.a == false) goto L41;
        int r10 = a.a[r9.d.ordinal()];
        boolean r0 = true;
        if (r10 != 1) goto L10;
        DoraObricDeviceModeEntryLabel r11 = DoraObricDeviceModeEntryLabel.ASSISTANT;
    L18:
        DoraObricDeviceModeEntryLabel r2 = r11;
        boolean r5 = r9.f;
        if (r9.e == false) goto L22;
        if (r5 == true) goto L22;
    L23:
        boolean r3 = !r0;
        if (r9.c == false) goto L26;
        float r6 = 0.3f;
    L30:
        if (r9.d != DoraObricGlassesMode.HEADPHONE) goto L34;
        DoraObricDeviceModeIndicator r12 = DoraObricDeviceModeIndicator.HEADPHONE;
    L38:
        return new z1(r2, r3, r5, r5, r6, r12);
    L34:
        if (r9.i != DoraObricEnvironmentMemoryState.WORKING) goto L36;
        r12 = DoraObricDeviceModeIndicator.ASSISTANT_MEMORY_ON;
        goto L38
    L36:
        r12 = DoraObricDeviceModeIndicator.ASSISTANT_MEMORY_OFF;
        goto L38
    L26:
        if (r0 == false) goto L28;
        r6 = 0.9f;
        goto L30
    L28:
        r6 = 1.0f;
    L22:
        r0 = false;
        goto L23
    L10:
        if (r10 != 2) goto L12;
        r11 = DoraObricDeviceModeEntryLabel.HEADPHONE;
        goto L18
    L12:
        if (r10 != 3) goto L15;
        r11 = DoraObricDeviceModeEntryLabel.ASSISTANT;
        goto L18
    L15:
        throw new NoWhenBranchMatchedException();
    L41:
        return null;
    }
}
