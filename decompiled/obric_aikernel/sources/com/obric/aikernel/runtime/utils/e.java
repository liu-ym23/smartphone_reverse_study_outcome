package com.obric.aikernel.runtime.utils;

import android.content.Context;
import android.os.Process;
import android.os.UserManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f5420a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f5421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f5422c;

    static {
        f5420a = new e();
    }

    private e() {
    }

    public final int a() {
        return Process.myUid() / 100000;
    }

    public final boolean b(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Boolean r11 = f5422c;
        if (r11 == null) goto L6;
        return r11.booleanValue();
    L6:
        if (r10.getPackageManager().checkPermission("android.permission.INTERACT_ACROSS_USERS", r10.getPackageName()) != 0) goto L8;
        boolean r12 = true;
    L9:
        d.f5417a.g("MultiUserHelper", "isAllowInteractUsers got " + r12);
        f5422c = Boolean.valueOf(r12);
        return r12;
    L8:
        r12 = false;
        goto L9
    }

    public final boolean c(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Boolean r11 = f5421b;
        if (r11 != null) goto L7;
        Object r12 = r10.getSystemService("user");
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.os.UserManager");
        boolean r13 = ((UserManager) r12).isSystemUser();
        d.f5417a.g("MultiUserHelper", "isSystemUser got " + r13);
        f5421b = Boolean.valueOf(r13);
        return r13;
    L7:
        return r11.booleanValue();
    }
}
