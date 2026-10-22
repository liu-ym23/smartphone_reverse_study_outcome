package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public final int a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof h) == true) goto L6;
        return false;
    L6:
        if (this.a == ((h) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "InputPanelRedDot(sdkVersion=" + this.a + ")";
    }

    public h(int r1) {
        this.a = r1;
    }
}
