package com.larus.dora.obric.device_management.device_home;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraObricGlassesBusinessState.values().length];
            r0[DoraObricGlassesBusinessState.INTERPRETING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[DoraObricGlassesBusinessState.VIDEO_CALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[DoraObricGlassesBusinessState.RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[DoraObricGlassesBusinessState.VIDEO_RECORDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[DoraObricGlassesBusinessState.IDLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public static b a(DoraObricDeviceModeEntryProduct r17, h3 r18) {
        Intrinsics.checkNotNullParameter(r17, "product");
        Intrinsics.checkNotNullParameter(r18, "glassesMode");
        boolean r6 = a2.a(r17);
        boolean r1 = false;
        if (r6 == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r6 == true) goto L10;
    L12:
        boolean r8 = false;
    L13:
        DoraObricGlassesMode r5 = r18.d;
        DoraObricGlassesMode r7 = DoraObricGlassesMode.HEADPHONE;
        if (r5 == r7) goto L16;
    L18:
        boolean r9 = false;
    L20:
        if (r18.l == DoraObricGlassesBusinessState.IDLE) goto L22;
        boolean r10 = true;
    L23:
        if (r6 == true) goto L25;
    L31:
        boolean r11 = false;
    L32:
        if (r4 == true) goto L34;
    L36:
        boolean r12 = false;
    L38:
        if (r6 == true) goto L40;
    L42:
        boolean r13 = !r6;
        if (r9 == true) goto L50;
        if (r10 == true) goto L50;
        if (r18.i != DoraObricEnvironmentMemoryState.WORKING) goto L49;
        DoraObricEnvironmentMemoryLabel r2 = DoraObricEnvironmentMemoryLabel.ON;
    L51:
        DoraObricEnvironmentMemoryLabel r14 = r2;
        if (r12 == false) goto L54;
        DoraObricEnvironmentMemoryIcon r3 = DoraObricEnvironmentMemoryIcon.RUNNING;
    L55:
        DoraObricEnvironmentMemoryIcon r15 = r3;
        if (r11 == true) goto L60;
        DoraObricEnvironmentMemoryTextStyle r16 = DoraObricEnvironmentMemoryTextStyle.DISABLED;
    L58:
        DoraObricEnvironmentMemoryTextStyle r110 = r16;
        if (r4 == false) goto L83;
        int r0 = a.a[r18.l.ordinal()];
        if (r0 != 1) goto L69;
        DoraObricDeviceBusinessStatus r20 = DoraObricDeviceBusinessStatus.INTERPRETATION;
    L85:
        return new b(r6, r1, r13, r6, r13, r8, r11, r11, r12, r14, r15, r110, r20);
    L69:
        if (r0 != 2) goto L71;
        r20 = DoraObricDeviceBusinessStatus.VIDEO_CALL;
        goto L85
    L71:
        if (r0 != 3) goto L73;
        r20 = DoraObricDeviceBusinessStatus.RECORDING_MINUTES;
        goto L85
    L73:
        if (r0 != 4) goto L75;
        r20 = DoraObricDeviceBusinessStatus.VIDEO_RECORDING;
        goto L85
    L75:
        if (r0 == 5) goto L83;
        throw new NoWhenBranchMatchedException();
    L83:
        r20 = null;
        goto L85
    L60:
        if (r18.d != r7) goto L62;
        r16 = DoraObricEnvironmentMemoryTextStyle.HEADPHONE;
        goto L58
    L62:
        if (r12 == false) goto L64;
        r16 = DoraObricEnvironmentMemoryTextStyle.RUNNING;
        goto L58
    L64:
        r16 = DoraObricEnvironmentMemoryTextStyle.PAUSED;
        goto L58
    L54:
        r3 = DoraObricEnvironmentMemoryIcon.PAUSED;
        goto L55
    L49:
        r2 = DoraObricEnvironmentMemoryLabel.OFF;
    L50:
        r2 = DoraObricEnvironmentMemoryLabel.UNAVAILABLE;
        goto L51
    L40:
        if (b2.a(r17, r18) == null) goto L42;
        r1 = true;
        goto L42
    L34:
        if (r18.i != DoraObricEnvironmentMemoryState.WORKING) goto L36;
        r12 = true;
        goto L38
    L25:
        if (r18.i == DoraObricEnvironmentMemoryState.UNKNOWN) goto L31;
        if (r18.j == null) goto L31;
        if (r9 == true) goto L31;
        if (r10 == true) goto L31;
        r11 = true;
        goto L32
    L22:
        r10 = false;
        goto L23
    L16:
        if (r18.i != DoraObricEnvironmentMemoryState.UNAVAILABLE) goto L18;
        r9 = true;
        goto L20
    L10:
        if (r18.d == DoraObricGlassesMode.UNKNOWN) goto L12;
        r8 = true;
        goto L13
    L5:
        if (r18.d != DoraObricGlassesMode.ASSISTANT) goto L7;
        r4 = true;
        goto L8
    }
}
