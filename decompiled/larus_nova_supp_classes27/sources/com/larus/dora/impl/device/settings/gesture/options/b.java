package com.larus.dora.impl.device.settings.gesture.options;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(List r4) {
        List r5 = r4;
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator r6 = r5.iterator();
        int r0 = 0;
    L9:
        if (r6.hasNext() == false) goto L21;
        DoraGGestureSettings r2 = (DoraGGestureSettings) r6.next();
        if (c(r2) == true) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L9;
        r0 = r0 + 1;
        if (r0 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        if (r2.d != 40) goto L15;
        r3 = true;
        goto L16
    L21:
        return r0;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return 0;
    }

    public static boolean c(DoraGGestureSettings r5) {
        if (SetsKt.setOf(new Byte[]{(byte) 16, (byte) 0}).contains(Byte.valueOf(r5.a)) == true) goto L5;
        return false;
    L5:
        if (r5.b == 6) goto L7;
        return false;
    L7:
        if (SetsKt.setOf(new Byte[]{(byte) 2, (byte) 3}).contains(Byte.valueOf(r5.c)) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static int b(List r5, DoraGGestureSettings r6) {
        Iterator r7 = r5.iterator();
        int r1 = 0;
    L4:
        if (r7.hasNext() == false) goto L16;
        DoraGGestureSettings r2 = (DoraGGestureSettings) r7.next();
        if (r2.a == r6.a) goto L8;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == true) goto L20;
        r1 = r1 + 1;
        goto L4
    L20:
        return r1;
    L8:
        if (r2.b != r6.b) goto L12;
        if (r2.c != r6.c) goto L12;
        r3 = true;
        goto L13
    L16:
        return -1;
    }

    public static boolean d(boolean r1, DoraGGestureSettings r2, DoraGGestureSettings r3, List r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "currentGesture");
        Intrinsics.checkNotNullParameter(r3, "selectedOption");
        Intrinsics.checkNotNullParameter(r4, "currentSettings");
        if (r5 == true) goto L23;
        if (r1 == false) goto L23;
        if (c(r2) == false) goto L23;
        if (r2.d != 40) goto L23;
        if (r3.d == 40) goto L23;
        List r6 = CollectionsKt.toMutableList(r4);
        int r7 = b(r6, r2);
        if (r7 < 0) goto L15;
        ListProtector.set(r6, r7, r2);
    L16:
        int r8 = a(r6);
        List r9 = CollectionsKt.toMutableList(r6);
        int r10 = b(r9, r2);
        if (r10 < 0) goto L19;
        ListProtector.set(r9, r10, r3);
    L19:
        int r11 = a(r9);
        if (r8 != 1) goto L23;
        if (r11 != 0) goto L23;
        return true;
    L15:
        r6.add(r2);
    L23:
        return false;
    }
}
