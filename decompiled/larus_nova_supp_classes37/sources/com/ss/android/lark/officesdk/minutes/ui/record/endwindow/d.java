package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements l {
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c a;
    public final boolean b;
    public final String c;

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.c.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmEndWindowVMState(entity=" + this.a + ", isLoading=" + this.b + ", url=" + this.c + ')';
    }

    public /* synthetic */ d(int r3) {
        this(new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c(0), true, "");
    }

    public d(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r4, "url");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static d a(d r1, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r3 & 2) == 0) goto L8;
        boolean r0 = r1.b;
    L10:
        if ((r3 & 4) == 0) goto L12;
        String r4 = r1.c;
    L13:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r4, "url");
        return new d(r2, r0, r4);
    L12:
        r4 = null;
        goto L13
    L8:
        r0 = false;
        goto L10
    }
}
