package hq;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f17362b;

    public d(int r5, boolean r10) {
        this.f17361a = r5;
        this.f17362b = r10;
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
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        int r11 = r10.f17361a;
        if (this.f17361a == r11) goto L12;
        return false;
    L12:
        if (this.f17362b == r10.f17362b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f17361a) * 31;
        return Boolean.hashCode(this.f17362b) + r5;
    }

    public final String toString() {
        return "OpenWidgetConfig(appWidgetId=" + this.f17361a + ", isCustomClock=" + this.f17362b + ")";
    }
}
