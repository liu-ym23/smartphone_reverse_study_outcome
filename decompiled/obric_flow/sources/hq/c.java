package hq;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f17360a = null;

    static {
        f17360a = new c();
    }

    @Override // hq.h
    public final String a() {
        return "OpenSettings";
    }

    @Override // hq.h
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final int hashCode() {
        return -374978545;
    }

    public final String toString() {
        return "OpenSettings";
    }
}
