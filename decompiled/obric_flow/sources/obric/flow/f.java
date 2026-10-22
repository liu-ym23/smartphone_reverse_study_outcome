package obric.flow;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20453a;

    public f(int r5) {
        this.f20453a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L9;
        return false;
    L9:
        if (this.f20453a == ((f) r5).f20453a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f20453a);
    }

    public final String toString() {
        return androidx.constraintlayout.motion.widget.a.s(new StringBuilder("updateWidget(appWidgetId="), this.f20453a, ")");
    }
}
