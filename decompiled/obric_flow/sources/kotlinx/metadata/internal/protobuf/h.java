package kotlinx.metadata.internal.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f19172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19173b;

    public h(Object r5, int r10) {
        this.f19172a = r5;
        this.f19173b = r10;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof h) == true) goto L5;
        return false;
    L5:
        h r10 = (h) r5;
        Object r11 = r10.f19172a;
        if (this.f19172a == r11) goto L8;
        return false;
    L8:
        if (this.f19173b != r10.f19173b) goto L12;
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f19172a) * 65535) + this.f19173b;
    }
}
