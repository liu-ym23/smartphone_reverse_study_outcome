package com.bytedance.ies.bullet.lynx.init;

import com.google.android.material.timepicker.TimeModel;
import com.lynx.tasm.u;
import com.lynx.tasm.z;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f5673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f5674b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f5675c = null;

    static {
        f5673a = new Object();
        f5674b = new LinkedHashMap();
        f5675c = new LinkedHashMap();
    }

    public static u a(String r10, boolean r11, boolean r12, String[] r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "groupName");
        if (r11 == false) goto L11;
        if (r12 == true) goto L8;
        if (r15 == true) goto L8;
        boolean r5 = false;
    L10:
        return new u(r10, r10, r13, r5, r14, Boolean.FALSE, false);
    L8:
        r5 = true;
        goto L10
    L11:
        if (r12 == true) goto L15;
        if (r15 == true) goto L15;
        boolean r16 = false;
    L16:
        String r17 = String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(u.g)});
        u.g++;
        return new u(r10, r17, r13, r16, r14, Boolean.FALSE, false);
    L15:
        r16 = true;
        goto L16
    }

    public static u b(String r12, String[] r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "groupName");
        Object r5 = f5673a;
        monitor-enter(r5);
        LinkedHashMap r10 = f5675c;     // Catch: Throwable -> L7
        Integer r11 = (Integer) r10.get(r12);     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        int r16 = r11.intValue();     // Catch: Throwable -> L7
    L10:
        r10.put(r12, Integer.valueOf(r16 + 1));     // Catch: Throwable -> L7
        LinkedHashMap r17 = f5674b;     // Catch: Throwable -> L7
        u r18 = (u) r17.get(r12);     // Catch: Throwable -> L7
        if (r18 != null) goto L14;
        String r19 = String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(u.g)});     // Catch: Throwable -> L7
        u.g++;     // Catch: Throwable -> L7
        r18 = new u(r12, r19, r13, r14, r15, Boolean.FALSE, false);     // Catch: Throwable -> L7
        r17.put(r12, r18);     // Catch: Throwable -> L7
    L14:
        monitor-exit(r5);
        return r18;
    L9:
        r16 = 0;
    L7:
        th = move-exception;
        throw th;
    }

    public static u c(String r12, String[] r13, boolean r14, boolean r15, boolean r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r12, "groupName");
        Object r10 = f5673a;
        monitor-enter(r10);
        LinkedHashMap r5 = f5675c;     // Catch: Throwable -> L7
        Integer r11 = (Integer) r5.get(r12);     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        int r18 = r11.intValue();     // Catch: Throwable -> L7
    L10:
        r5.put(r12, Integer.valueOf(r18 + 1));     // Catch: Throwable -> L7
        LinkedHashMap r19 = f5674b;     // Catch: Throwable -> L7
        u r20 = (u) r19.get(r12);     // Catch: Throwable -> L7
        if (r20 != null) goto L29;
        if (r17 == false) goto L21;
        if (r14 == true) goto L18;
        if (r16 == true) goto L18;
        boolean r21 = false;
    L19:
        u r110 = new z(r12, r12, r13, r21, r15, null, true);     // Catch: Throwable -> L7
    L20:
        r20 = r110;
        r19.put(r12, r20);     // Catch: Throwable -> L7
    L18:
        r21 = true;
        goto L19
    L21:
        String r22 = String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(u.g)});     // Catch: Throwable -> L7
        u.g++;     // Catch: Throwable -> L7
        if (r14 == true) goto L26;
        if (r16 == true) goto L26;
        boolean r23 = false;
    L27:
        r110 = new u(r12, r22, r13, r23, r15, Boolean.FALSE, false);     // Catch: Throwable -> L7
    L26:
        r23 = true;
    L29:
        monitor-exit(r10);
        return r20;
    L9:
        r18 = 0;
    L7:
        th = move-exception;
        throw th;
    }

    public static void d(String r5) {
        Object r10 = f5673a;
        monitor-enter(r10);
        if (r5 != null) goto L28;
    L26:
        monitor-exit(r10);
        return;
    L28:
    L15:
        th = move-exception;
        throw th;
    L6:
        if (r5.length() == 0) goto L26;
        LinkedHashMap r11 = f5675c;     // Catch: Throwable -> L15
        Integer r12 = (Integer) r11.get(r5);     // Catch: Throwable -> L15
        if (r12 == null) goto L22;
        int r13 = r12.intValue();     // Catch: Throwable -> L15
        if (r13 != 1) goto L21;
        u r14 = (u) f5674b.remove(r5);     // Catch: Throwable -> L15
        if ((r14 instanceof z) == false) goto L17;
        z r15 = (z) r14;     // Catch: Throwable -> L15
    L18:
        if (r15 == null) goto L20;
        r15.a();     // Catch: Throwable -> L15
    L20:
        r11.remove(r5);     // Catch: Throwable -> L15
        goto L22
    L17:
        r15 = null;
        goto L18
    L21:
        r11.put(r5, Integer.valueOf(r13 - 1));     // Catch: Throwable -> L15
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L22:
        monitor-exit(r10);
    }
}
