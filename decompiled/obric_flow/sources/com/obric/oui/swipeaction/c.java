package com.obric.oui.swipeaction;

import ai.j0;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.ViewHolder f14614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14616c;

    public c(RecyclerView.ViewHolder r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        this.f14614a = r5;
        this.f14615b = r10;
        this.f14616c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        RecyclerView.ViewHolder r11 = r10.f14614a;
        if (Intrinsics.areEqual(this.f14614a, r11) == true) goto L12;
        return false;
    L12:
        if (this.f14615b == r10.f14615b) goto L15;
        return false;
    L15:
        if (this.f14616c == r10.f14616c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f14614a.hashCode() * 31;
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f14615b, r5, 31);
        return Integer.hashCode(this.f14616c) + r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("MoveInfo(holder=");
        r5.append(this.f14614a);
        r5.append(", deltaX=");
        r5.append(this.f14615b);
        r5.append(", deltaY=");
        return j0.n(r5, this.f14616c, ')');
    }
}
