package com.bytedance.ai.bridge.method.calendar.remote;

import evc.j;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final Property.NodeInfo d = null;
    public static final j e = null;
    public static final j f = null;
    public final List<Property> a;
    public final j b;
    public final List<Error> c;

    public static final class a {
    }

    public c() {
        throw null;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        List<Error> r1 = this.c;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return r0 + r10;
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "PropStat(properties=" + this.a + ", status=" + this.b + ", error=" + this.c + ')';
    }

    static {
        d = new Property.NodeInfo("DAV:", "propstat");
        Protocol r1 = Protocol.HTTP_1_1;
        e = new j(r1, 200, "Assuming OK");
        f = new j(r1, 500, "Invalid status line");
    }

    public c(List r10, j r11) {
        Intrinsics.checkNotNullParameter(r10, "properties");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_STATUS);
        this.a = r10;
        this.b = r11;
        this.c = null;
    }
}
