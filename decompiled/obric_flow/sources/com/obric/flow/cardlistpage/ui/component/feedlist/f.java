package com.obric.flow.cardlistpage.ui.component.feedlist;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11582a;

    public f(int r5) {
        this.f11582a = r5;
    }

    @Override // com.obric.flow.cardlistpage.mvi.e
    public final String a() {
        return androidx.constraintlayout.motion.widget.a.s(new StringBuilder("AddCard(widgetId="), this.f11582a, ")");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L9;
        return false;
    L9:
        if (this.f11582a == ((f) r5).f11582a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11582a);
    }

    public final String toString() {
        return androidx.constraintlayout.motion.widget.a.s(new StringBuilder("AddCard(widgetId="), this.f11582a, ")");
    }
}
