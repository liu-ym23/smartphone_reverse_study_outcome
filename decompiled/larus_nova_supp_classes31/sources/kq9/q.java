package kq9;

import com.larus.platform.model.album.FastSendFromCameraScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q {
    public final boolean a;
    public final int b;
    public final o c;

    public q() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (this.a == r6.a) goto L12;
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
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b) * 31;
        o r2 = this.c;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "FastSendImageInCameraConfig(isBottomControlAdapt=" + this.a + ", bottomScene=" + this.b + ", albumThumbConfig=" + this.c + ')';
    }

    public /* synthetic */ q(int r3) {
        this(true, FastSendFromCameraScene.DEFAULT.getScene(), new o(0));
    }

    public q(boolean r1, int r2, o r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
