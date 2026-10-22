package hq;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f17363a = null;

    static {
        f17363a = new e();
    }

    @Override // hq.h
    public final String a() {
        return "OpenWidgetPicker";
    }

    @Override // hq.h
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final int hashCode() {
        return -1163836962;
    }

    public final String toString() {
        return "OpenWidgetPicker";
    }
}
