package mrb;

import com.larksuite.component.card.protocol.CardActionDataSource;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final String a;
    public final String b;
    public final int c;
    public final String d;
    public final Map<String, String> e;
    public final String f;
    public final OPTrace g;
    public final HashMap<String, Object> h;
    public final boolean i;
    public final boolean j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final CardActionDataSource o;

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
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((r3 + r5) * 31) + this.c) * 31) + this.d.hashCode()) * 31;
        Map<String, String> r7 = this.e;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + this.f.hashCode()) * 31;
        OPTrace r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        HashMap<String, Object> r13 = this.h;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        int r16 = 1231;
        if (this.i == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.j == true) goto L30;
        r16 = 1237;
    L30:
        int r19 = (((((((r18 + r16) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31;
        String r20 = this.n;
        if (r20 == null) goto L35;
        r1 = r20.hashCode();
    L35:
        return ((r19 + r1) * 31) + this.o.hashCode();
    L25:
        r17 = 1237;
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "LynxCardActionRequestEntity(msgId=" + this.a + ", actionId=" + this.b + ", contentVersion=" + this.c + ", traceId=" + this.d + ", params=" + this.e + ", callbackEventName=" + this.f + ", mActionTrace=" + this.g + ", sendLynxParams=" + this.h + ", isMultiAction=" + this.i + ", messageIsEphemeral=" + this.j + ", scene=" + this.k + ", renderBusinessType=" + this.l + ", componentTag=" + this.m + ", requestVersion=" + this.n + ", actionDataSource=" + this.o + ')';
    }

    public a(String r4, String r5, int r6, Map r7, OPTrace r8, HashMap r9, boolean r10, boolean r11, String r12, CardActionDataSource r13) {
        Intrinsics.checkNotNullParameter("", "traceId");
        Intrinsics.checkNotNullParameter("updateCardState", "callbackEventName");
        Intrinsics.checkNotNullParameter("", "scene");
        Intrinsics.checkNotNullParameter("", "renderBusinessType");
        Intrinsics.checkNotNullParameter("", "componentTag");
        Intrinsics.checkNotNullParameter(r13, "actionDataSource");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = "";
        this.e = r7;
        this.f = "updateCardState";
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = r12;
        this.o = r13;
    }
}
