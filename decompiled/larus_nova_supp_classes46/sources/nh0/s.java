package nh0;

import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.UpdateLayoutType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s {
    public final UpdateLayoutType a;
    public final int b;
    public final int c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof s) == false) goto L12;
        s r4 = (s) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        UpdateLayoutType r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (((r1 * 31) + this.b) * 31) + this.c;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "UpdateLayoutConfigExtraObject:{uiLayout=" + this.b + ", playMode=" + this.c + '}';
    }

    public final UpdateLayoutType getType() {
        return this.a;
    }

    public s(UpdateLayoutType r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
