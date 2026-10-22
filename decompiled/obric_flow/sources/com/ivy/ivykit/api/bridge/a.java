package com.ivy.ivykit.api.bridge;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f9470b;

    public a(boolean r5, List r10) {
        Intrinsics.checkNotNullParameter(r10, "authHostWhiteList");
        this.f9469a = r5;
        this.f9470b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        boolean r11 = r10.f9469a;
        if (this.f9469a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9470b, r10.f9470b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final int hashCode() {
        boolean r5 = this.f9469a;
        ?? r10 = r5;
        if (r5 == false) goto L5;
        r10 = 1;
    L5:
        int r11 = this.f9470b.hashCode();
        return r11 + (r10 * 31);
    }

    public final String toString() {
        return "BridgeConfig(enableJSBPermission=" + this.f9469a + ", authHostWhiteList=" + this.f9470b + ")";
    }
}
