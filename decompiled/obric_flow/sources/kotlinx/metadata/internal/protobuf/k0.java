package kotlinx.metadata.internal.protobuf;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 implements Map.Entry, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparable f19183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f19184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g0 f19185c;

    public k0(g0 r5, Comparable r10, Object r11) {
        this.f19185c = r5;
        this.f19183a = r10;
        this.f19184b = r11;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        Comparable r10 = ((k0) r5).f19183a;
        return this.f19183a.compareTo(r10);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Map.Entry) == true) goto L8;
        return false;
    L8:
        Map.Entry r10 = (Map.Entry) r5;
        Object r11 = r10.getKey();
        Comparable r12 = this.f19183a;
        if (r12 != null) goto L13;
        if (r11 != null) goto L12;
        boolean r13 = true;
    L14:
        if (r13 == false) goto L24;
        Object r14 = this.f19184b;
        Object r15 = r10.getValue();
        if (r14 != null) goto L20;
        if (r15 != null) goto L19;
        boolean r16 = true;
    L21:
        if (r16 == false) goto L24;
        return true;
    L19:
        r16 = false;
        goto L21
    L20:
        r16 = r14.equals(r15);
    L24:
        return false;
    L12:
        r13 = false;
        goto L14
    L13:
        r13 = r12.equals(r11);
        goto L14
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f19183a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f19184b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int r5 = 0;
        Comparable r10 = this.f19183a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        Object r12 = this.f19184b;
        if (r12 == null) goto L11;
        r5 = r12.hashCode();
    L11:
        return r11 ^ r5;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object r5) {
        this.f19185c.b();
        Object r10 = this.f19184b;
        this.f19184b = r5;
        return r10;
    }

    public final String toString() {
        String r5 = String.valueOf(this.f19183a);
        String r10 = String.valueOf(this.f19184b);
        int r11 = r5.length() + 1;
        return androidx.constraintlayout.motion.widget.a.t(new StringBuilder(r10.length() + r11), r5, "=", r10);
    }
}
