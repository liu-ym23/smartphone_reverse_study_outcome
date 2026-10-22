package com.obric.flow.cardlistpage.ui.component.popupdialog;

import ai.j0;
import com.obric.flow.cardlistpage.mvi.MviLogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11733b;

    public h(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "cardId");
        Intrinsics.checkNotNullParameter(r10, "cardTitle");
        this.f11732a = r5;
        this.f11733b = r10;
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final String a() {
        return toString();
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r10 = (h) r5;
        String r11 = r10.f11732a;
        if (Intrinsics.areEqual(this.f11732a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11733b, r10.f11733b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f11732a.hashCode() * 31;
        return this.f11733b.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("OnDeleteClick(cardId=");
        r5.append(this.f11732a);
        r5.append(", cardTitle=");
        return j0.q(r5, this.f11733b, ")");
    }
}
