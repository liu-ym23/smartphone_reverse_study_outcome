package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements f52.f {
    public final String a;
    public final int b;
    public final String c;

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "CommonTrayType(desc=" + this.c + ", priority=" + this.b + ')';
    }

    @Override // f52.f
    public final int getPriority() {
        return this.b;
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof d) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((d) r2).a, this.a) == false) goto L7;
        return true;
    }

    public d(String r3, String r4, int r5) {
        String r6 = r3 + '-' + r4;
        Intrinsics.checkNotNullParameter(r6, "desc");
        this.a = r3;
        this.b = r5;
        this.c = r6;
    }
}
