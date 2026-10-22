package dz7;

import com.larksuite.component.card.protocol.CardActionDataSource;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final String a;
    public final Map<String, String> b;
    public final String c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final OPTrace g;
    public final int h;
    public final String i;
    public final String j;
    public final boolean k;
    public final CardActionDataSource l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        int r5 = 1231;
        if (this.e == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.f == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (((((r7 + r8) * 31) + this.g.hashCode()) * 31) + this.h) * 31;
        String r10 = this.i;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.j;
        if (r13 == null) goto L22;
        r2 = r13.hashCode();
    L22:
        int r14 = (r12 + r2) * 31;
        if (this.k == true) goto L27;
        r5 = 1237;
    L27:
        return ((r14 + r5) * 31) + this.l.hashCode();
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CardActionRequestParams(cardID=" + this.a + ", params=" + this.b + ", actionId=" + this.c + ", contentVersion=" + this.d + ", isEphemeral=" + this.e + ", isMultiAction=" + this.f + ", actionTrace=" + this.g + ", sourceType=" + this.h + ", sourceId=" + this.i + ", requestVersion=" + this.j + ", isStreamingMode=" + this.k + ", actionDataSource=" + this.l + ')';
    }

    public b(String r2, Map<String, String> r3, String r4, String r5, boolean r6, boolean r7, OPTrace r8, int r9, String r10, String r11, boolean r12, CardActionDataSource r13) {
        Intrinsics.checkNotNullParameter(r2, "cardID");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "actionId");
        Intrinsics.checkNotNullParameter(r8, "actionTrace");
        Intrinsics.checkNotNullParameter(r13, "actionDataSource");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
