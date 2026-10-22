package rga;

import com.obric.assistant.spi.miniapp.ObricIntentWidgetUpdateMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final ObricIntentWidgetUpdateMode a;
    public final boolean b;
    public final Integer c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        Integer r3 = this.c;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return r2 + r4;
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricIntentWidgetPolicy(updateMode=" + this.a + ", requiresHostSurfaceCompatibility=" + this.b + ", minimumHeightDp=" + this.c + ')';
    }

    public /* synthetic */ a(int r3) {
        this(ObricIntentWidgetUpdateMode.DEFAULT, false, null);
    }

    public a(ObricIntentWidgetUpdateMode r2, boolean r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "updateMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
