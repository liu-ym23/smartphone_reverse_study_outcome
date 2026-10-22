package px8;

import com.larus.camera.impl.entity.EduResultMode;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final b e = null;
    public final List<EduResultMode> a;
    public final EduResultMode b;
    public final boolean c;
    public final EduResultMode d;

    public static final class a {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.d.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "EduResultTabState(availableModes=" + this.a + ", selectedMode=" + this.b + ", showTab=" + this.c + ", defaultMode=" + this.d + ')';
    }

    static {
        List r1 = CollectionsKt.emptyList();
        EduResultMode r2 = EduResultMode.SINGLE_QUESTION;
        e = new b(r1, r2, false, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends EduResultMode> r2, EduResultMode r3, boolean r4, EduResultMode r5) {
        Intrinsics.checkNotNullParameter(r2, "availableModes");
        Intrinsics.checkNotNullParameter(r3, "selectedMode");
        Intrinsics.checkNotNullParameter(r5, "defaultMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
