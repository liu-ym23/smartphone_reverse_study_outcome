package di8;

import com.larus.bmhome.chat.nestedmenu.ui.NestedMenuPopup;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m0 {
    public final c0 a;
    public final LinkedHashMap<String, List<d0>> b;
    public final NestedMenuPopup c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r6 = (m0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "NestedMenuPresentationState(config=" + this.a + ", models=" + this.b + ", popup=" + this.c + ')';
    }

    public static m0 a(m0 r2, LinkedHashMap r3) {
        c0 r0 = r2.a;
        NestedMenuPopup r4 = r2.c;
        Intrinsics.checkNotNullParameter(r0, "config");
        Intrinsics.checkNotNullParameter(r3, "models");
        Intrinsics.checkNotNullParameter(r4, "popup");
        return new m0(r0, r3, r4);
    }

    public m0(c0 r2, LinkedHashMap<String, List<d0>> r3, NestedMenuPopup r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "models");
        Intrinsics.checkNotNullParameter(r4, "popup");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
