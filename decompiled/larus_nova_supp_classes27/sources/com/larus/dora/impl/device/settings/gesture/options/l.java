package com.larus.dora.impl.device.settings.gesture.options;

import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import com.larus.utils.j0;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static p a(DoraGGestureSettings r11, List r12) {
        Intrinsics.checkNotNullParameter(r11, "gesture");
        Intrinsics.checkNotNullParameter(r12, "currentSettings");
        if (r11.b == 6) goto L5;
    L22:
        return null;
    L5:
        if (r11.c != 1) goto L22;
        if (r11.a != 16) goto L10;
        int r0 = j0.a;
        int r1 = 2131903027;
    L11:
        j0.d(r1);
        byte r2 = r11.d;
        if (r2 == 16) goto L14;
        if (r2 != 0) goto L22;
        if (c(r12, r11.a, r11.b, (byte) 16, (byte) 20) == true) goto L22;
        int r3 = j0.a;
        String r4 = j0.d(2131902745);
        String r7 = j0.d(2131902743);
        byte r8 = r11.a;
        byte r13 = r11.b;
        return new p(r4, r7, CollectionsKt.listOf(new DoraGGestureSettings[]{new DoraGGestureSettings(r8, r13, (byte) 2, (byte) 16), new DoraGGestureSettings(r8, r13, (byte) 3, (byte) 20)}));
    L14:
        if (c(r12, r11.a, r11.b, (byte) 20, (byte) 19) == true) goto L22;
        int r5 = j0.a;
        String r6 = j0.d(2131902745);
        String r9 = j0.d(2131902744);
        byte r10 = r11.a;
        byte r14 = r11.b;
        return new p(r6, r9, CollectionsKt.listOf(new DoraGGestureSettings[]{new DoraGGestureSettings(r10, r14, (byte) 2, (byte) 20), new DoraGGestureSettings(r10, r14, (byte) 3, (byte) 19)}));
    L10:
        int r15 = j0.a;
        r1 = 2131903047;
        goto L11
    }

    public static Byte b(List r4, byte r5, byte r6, byte r7) {
        Iterator r8 = r4.iterator();
    L4:
        if (r8.hasNext() == false) goto L15;
        Object r0 = r8.next();
        DoraGGestureSettings r2 = (DoraGGestureSettings) r0;
        if (r2.a == r5) goto L8;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L4;
    L16:
        DoraGGestureSettings r1 = (DoraGGestureSettings) r0;
        if (r1 != null) goto L19;
        return null;
    L19:
        return Byte.valueOf(r1.d);
    L8:
        if (r2.b != r6) goto L12;
        if (r2.c != r7) goto L12;
        r3 = true;
        goto L13
    L15:
        r0 = null;
        goto L16
    }

    public static boolean c(List r2, byte r3, byte r4, byte r5, byte r6) {
        Byte r0 = b(r2, r3, r4, (byte) 2);
        Byte r7 = b(r2, r3, r4, (byte) 3);
        if (r0 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == false) goto L17;
        if (r7 != null) goto L11;
    L13:
        boolean r9 = false;
    L14:
        if (r9 == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        if (r7.byteValue() != r6) goto L13;
        r9 = true;
        goto L14
    L17:
        return false;
    L5:
        if (r0.byteValue() != r5) goto L7;
        r8 = true;
        goto L8
    }
}
