package m;

import androidx.constraintlayout.motion.widget.a;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19874b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (e0.class == r5.getClass()) goto L11;
        return false;
    L11:
        e0 r10 = (e0) r5;
        if (this.f19874b == r10.f19874b) goto L14;
        return false;
    L14:
        String r11 = r10.f19873a;
        String r12 = this.f19873a;
        if (r12 != null) goto L19;
        if (r11 == null) goto L21;
        return false;
    L21:
        return true;
    L19:
        if (r12.equals(r11) == true) goto L21;
        return false;
    }

    public final int hashCode() {
        int r5 = (this.f19874b + 31) * 31;
        String r10 = this.f19873a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r5 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Regex [name=null, rule=");
        r5.append(this.f19873a);
        r5.append(", flags=");
        return a.s(r5, this.f19874b, ", desc=null]");
    }
}
