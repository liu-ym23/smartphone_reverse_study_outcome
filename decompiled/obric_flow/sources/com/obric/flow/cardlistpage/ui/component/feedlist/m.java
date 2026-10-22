package com.obric.flow.cardlistpage.ui.component.feedlist;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f11592a = null;

    static {
        f11592a = new m();
    }

    @Override // com.obric.flow.cardlistpage.mvi.e
    public final String a() {
        return "StopListening";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final int hashCode() {
        return 1323648512;
    }

    public final String toString() {
        return "StopListening";
    }
}
