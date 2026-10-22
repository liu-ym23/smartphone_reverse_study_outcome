package kotlinx.metadata.internal.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f19199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WireFormat$FieldType f19201c;
    public final boolean d;
    public final boolean e;

    public p(s r5, int r10, WireFormat$FieldType r11, boolean r12, boolean r13) {
        this.f19199a = r5;
        this.f19200b = r10;
        this.f19201c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        return this.f19200b - ((p) r5).f19200b;
    }
}
