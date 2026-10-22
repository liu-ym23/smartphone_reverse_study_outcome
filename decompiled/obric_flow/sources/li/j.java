package li;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19667c;

    public j(int r5, boolean r10, boolean r11) {
        this.f19665a = r5;
        this.f19666b = r10;
        this.f19667c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r10 = (j) r5;
        int r11 = r10.f19665a;
        if (this.f19665a == r11) goto L12;
        return false;
    L12:
        if (this.f19666b == r10.f19666b) goto L15;
        return false;
    L15:
        if (this.f19667c == r10.f19667c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = kn.e.a(Integer.hashCode(this.f19665a) * 31, 31, this.f19666b);
        return Boolean.hashCode(this.f19667c) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("LynxAuthSwitch(signVerifyMode=");
        r5.append(this.f19665a);
        r5.append(", enableJsbAuth=");
        r5.append(this.f19666b);
        r5.append(", enableJsbCallLimit=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.f19667c, ')');
    }
}
