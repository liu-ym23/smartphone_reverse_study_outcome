package hq;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17359a = null;

    static {
        f17359a = new b();
    }

    @Override // hq.h
    public final String a() {
        return "OpenSearchPage";
    }

    @Override // hq.h
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final int hashCode() {
        return -283809469;
    }

    public final String toString() {
        return "OpenSearchPage";
    }
}
