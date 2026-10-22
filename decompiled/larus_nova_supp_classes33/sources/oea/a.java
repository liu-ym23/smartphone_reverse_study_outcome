package oea;

import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final String a;
    public final Boolean b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Boolean r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.c.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "GRUpdateActionTitleEvent(action=" + this.a + ", disabled=" + this.b + ", text=" + this.c + ')';
    }

    public a(String r3, Boolean r4) {
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L5;
        String r0 = AppHost.a.getApplication().getString(2131912330);
        Intrinsics.checkNotNull(r0);
    L6:
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r0, "text");
        this.a = r3;
        this.b = r4;
        this.c = r0;
        return;
    L5:
        r0 = AppHost.a.getApplication().getString(2131912331);
        Intrinsics.checkNotNull(r0);
        goto L6
    }
}
