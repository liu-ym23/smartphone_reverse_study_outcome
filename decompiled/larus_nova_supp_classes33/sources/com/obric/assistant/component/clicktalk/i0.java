package com.obric.assistant.component.clicktalk;

import com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestStoreKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i0 {
    public final boolean a;
    public final long b;
    public final boolean c;

    public i0() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r9 = (i0) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        long r3 = this.b;
        int r2 = ((r0 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        if (this.c == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ClickTalkConfig(enableSilenceTimeout=" + this.a + ", silenceTimeout=" + this.b + ", staticBlur=" + this.c + ')';
    }

    public i0(int r3) {
        this.a = false;
        this.b = ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS;
        this.c = false;
    }
}
