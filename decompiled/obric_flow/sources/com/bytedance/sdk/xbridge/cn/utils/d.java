package com.bytedance.sdk.xbridge.cn.utils;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7503b;

    public d(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        this.f7502a = r5;
        this.f7503b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        String r11 = r10.f7502a;
        if (Intrinsics.areEqual(this.f7502a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f7503b, r10.f7503b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f7502a.hashCode() * 31;
        return this.f7503b.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Stage(name=");
        r5.append(this.f7502a);
        r5.append(", sessionId=");
        return j0.p(r5, this.f7503b, ')');
    }
}
