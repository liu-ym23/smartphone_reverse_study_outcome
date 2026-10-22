package js;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f18458c;
    public final List d;

    public c(String r5, String r10, o r11, List r12) {
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r10, "bindingKey");
        Intrinsics.checkNotNullParameter(r12, "properties");
        this.f18456a = r5;
        this.f18457b = r10;
        this.f18458c = r11;
        this.d = r12;
    }

    @Override // js.e
    public final String a() {
        return this.f18456a;
    }

    @Override // js.e
    public final List b() {
        return this.d;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        String r11 = r10.f18456a;
        if (Intrinsics.areEqual(this.f18456a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18457b, r10.f18457b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f18458c, r10.f18458c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.f18456a.hashCode() * 31, 31, this.f18457b);
        o r10 = this.f18458c;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = this.d.hashCode();
        return r12 + ((r5 + r11) * 31);
    L5:
        r11 = r10.f18474a.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ExternalView(id=");
        r5.append(this.f18456a);
        r5.append(", bindingKey=");
        r5.append(this.f18457b);
        r5.append(", material=");
        r5.append(this.f18458c);
        r5.append(", properties=");
        return androidx.constraintlayout.motion.widget.a.v(r5, this.d, ')');
    }
}
