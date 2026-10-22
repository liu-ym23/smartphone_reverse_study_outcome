package com.larus.disk.impl;

import com.larus.disk.api.ManualCacheCleanError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AppDiskManager$b {
    public final AppDiskManager$CleanExecutionStatus a;
    public final String b;
    public final ManualCacheCleanError c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppDiskManager$b) == true) goto L8;
        return false;
    L8:
        AppDiskManager$b r6 = (AppDiskManager$b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "CleanExecutionResult(status=" + this.a + ", taskId=" + this.b + ", error=" + this.c + ", failureOwner=" + this.d + ')';
    }

    public /* synthetic */ AppDiskManager$b(AppDiskManager$CleanExecutionStatus r2, String r3, ManualCacheCleanError r4) {
        this(r2, r3, r4, r4.getStage());
    }

    public AppDiskManager$b(AppDiskManager$CleanExecutionStatus r2, String r3, ManualCacheCleanError r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r5, "failureOwner");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
