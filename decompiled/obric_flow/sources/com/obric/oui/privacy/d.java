package com.obric.oui.privacy;

import cn.nubia.neopush.commons.Constant;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f14192b;

    public d(String r5, List r10) {
        Intrinsics.checkNotNullParameter(r5, Constant.DESCRIPTION);
        Intrinsics.checkNotNullParameter(r10, "permissions");
        this.f14191a = r5;
        this.f14192b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        String r11 = r10.f14191a;
        if (Intrinsics.areEqual(this.f14191a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f14192b, r10.f14192b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f14191a.hashCode() * 31;
        return this.f14192b.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PermissionItem(description=");
        r5.append(this.f14191a);
        r5.append(", permissions=");
        return androidx.constraintlayout.motion.widget.a.v(r5, this.f14192b, ')');
    }
}
