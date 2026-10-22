package hq;

import ai.j0;
import com.obric.flow.cardlistpage.mvi.MviLogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17365b;

    public f(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "cardId");
        Intrinsics.checkNotNullParameter(r10, "cardTitle");
        this.f17364a = r5;
        this.f17365b = r10;
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
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r10 = (f) r5;
        String r11 = r10.f17364a;
        if (Intrinsics.areEqual(this.f17364a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17365b, r10.f17365b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f17364a.hashCode() * 31;
        return this.f17365b.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ShowDeleteConfirmDialog(cardId=");
        r5.append(this.f17364a);
        r5.append(", cardTitle=");
        return j0.q(r5, this.f17365b, ")");
    }
}
