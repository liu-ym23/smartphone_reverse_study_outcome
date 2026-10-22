package j29;

import com.larus.bmhome.actionbar.model.j1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b implements t1a.c {
    public static final /* synthetic */ int b = 0;
    public final j1 a;

    public static final class a {
    }

    public b() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        j1 r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "InstructionConfExtWrap(avatarDetectInfo=" + this.a + ')';
    }

    static {
    }

    public b(j1 r1) {
        this.a = r1;
    }
}
