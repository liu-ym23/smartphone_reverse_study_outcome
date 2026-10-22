package i5;

import android.net.Uri;
import com.bytedance.ai.model.widgets.g0;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public final String[] a;
    public final Uri b;
    public final Function1<? super String[], Unit> c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof i) == true) goto L8;
        return false;
    L8:
        i r11 = (i) r10;
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
        int r0 = Arrays.hashCode(this.a) * 31;
        Uri r1 = this.b;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return ((r0 + r10) * 31) + this.c.hashCode();
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "RequestPermission(resources=" + Arrays.toString(this.a) + ", origin=" + this.b + ", onGrantResult=" + this.c + ')';
    }

    public final String[] getResources() {
        return this.a;
    }

    public i(String[] r10, Uri r11, g0 r12) {
        Intrinsics.checkNotNullParameter(r10, "resources");
        Intrinsics.checkNotNullParameter(r12, "onGrantResult");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
