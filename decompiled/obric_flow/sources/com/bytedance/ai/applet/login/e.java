package com.bytedance.ai.applet.login;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends f8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FinishReason f1746a;

    public e(FinishReason r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        this.f1746a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.f1746a == ((e) r5).f1746a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f1746a.hashCode();
    }

    public final String toString() {
        return "Finished(reason=" + this.f1746a + ')';
    }
}
