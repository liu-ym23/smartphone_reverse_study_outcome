package f3;

import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final HashMap<Method, n> a;

    public e() {
        this(null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((e) r10).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "AnnotationModel(methodModel=" + this.a + ')';
    }

    public e(Object r10) {
        HashMap<Method, n> r11 = new HashMap();
        Intrinsics.checkNotNullParameter(r11, "methodModel");
        this.a = r11;
    }
}
