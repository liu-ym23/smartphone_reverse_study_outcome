package com.larus.dora.impl.device.manage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f implements p0 {
    public final String a;
    public final String b;

    public f() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "DoraGDeviceManagementFeedbackItem(id=" + this.a + ", title=" + this.b + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.a;
    }

    public f(int r3) {
        int r4 = com.larus.utils.j0.a;
        String r5 = com.larus.utils.j0.d(2131902729);
        Intrinsics.checkNotNullParameter("DoraGDeviceManagementFeedbackItem", "id");
        Intrinsics.checkNotNullParameter(r5, "title");
        this.a = "DoraGDeviceManagementFeedbackItem";
        this.b = r5;
    }
}
