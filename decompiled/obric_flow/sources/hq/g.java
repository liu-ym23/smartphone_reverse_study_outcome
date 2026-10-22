package hq;

import ai.j0;
import com.obric.flow.cardlistpage.mvi.MviLogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17368c;
    public final int d;
    public final String e;

    public g(String r5, int r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        this.f17366a = r10;
        this.f17367b = r11;
        this.f17368c = r12;
        this.d = r13;
        this.e = r5;
    }

    @Override // hq.h
    public final String a() {
        return toString();
    }

    @Override // hq.h
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r5;
        int r11 = r10.f17366a;
        if (this.f17366a == r11) goto L12;
        return false;
    L12:
        if (this.f17367b == r10.f17367b) goto L15;
        return false;
    L15:
        if (this.f17368c == r10.f17368c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f17366a) * 31;
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f17367b, r5, 31);
        int r11 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f17368c, r10, 31);
        int r12 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.d, r11, 31);
        return this.e.hashCode() + r12;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("UpdateGestureExclusion(left=");
        r5.append(this.f17366a);
        r5.append(", top=");
        r5.append(this.f17367b);
        r5.append(", right=");
        r5.append(this.f17368c);
        r5.append(", bottom=");
        r5.append(this.d);
        r5.append(", tag=");
        return j0.q(r5, this.e, ")");
    }
}
