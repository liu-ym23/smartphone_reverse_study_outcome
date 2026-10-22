package ns9;

import com.larus.reach.api.ReachRequestSource;
import com.larus.reach.api.ReachType;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l {
    public final String a;
    public final ReachType b;
    public final String c;
    public final String d;
    public final String e;
    public final ReachRequestSource f;
    public final List<Integer> g;
    public final String h;

    public l() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r4 = this.d;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.e;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + this.f.hashCode()) * 31;
        List<Integer> r10 = this.g;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReachMeta(pushId=" + this.a + ", type=" + this.b + ", pushScene=" + this.c + ", templateId=" + this.d + ", toastLevel=" + this.e + ", requestSource=" + this.f + ", notificationGroup=" + this.g + ')';
    }

    public final ReachType getType() {
        return this.b;
    }

    public l(String r3, ReachType r4, String r5, String r6, String r7, ReachRequestSource r8, List r9, int r10) {
        String r1 = null;
        if ((r10 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r10 & 8) == 0) goto L9;
        r6 = null;
    L9:
        if ((r10 & 16) == 0) goto L12;
        r7 = null;
    L12:
        if ((r10 & 32) == 0) goto L15;
        r8 = ReachRequestSource.SERVER_CMD;
    L15:
        if ((r10 & 64) == 0) goto L17;
        r9 = null;
    L17:
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "pushScene");
        Intrinsics.checkNotNullParameter(r8, "requestSource");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        if (r3 != null) goto L20;
    L23:
        r1 = UUID.randomUUID().toString();
    L24:
        this.h = r1;
        return;
    L20:
        if ((!StringsKt.isBlank(r3)) == false) goto L22;
        r1 = r3;
    L22:
        if (r1 != null) goto L24;
        goto L23
    }
}
