package gm;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f17107b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17108a;

    static {
        f17107b = new b("default");
    }

    public b(String r5) {
        this.f17108a = r5.toLowerCase();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L10;
        return false;
    L10:
        return this.f17108a.equals(((b) r5).f17108a);
    }

    public final int hashCode() {
        return this.f17108a.hashCode();
    }

    public final String toString() {
        return this.f17108a;
    }
}
