package f3;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final Class<?> a;
    public final Class<?> b;
    public final e c;
    public final e d;
    public final Map<Class<? extends BaseModel>, e> e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "AnnotationData(paramClass=" + this.a + ", resultClass=" + this.b + ", paramModel=" + this.c + ", resultModel=" + this.d + ", models=" + this.e + ')';
    }

    public d(Class<?> r10, Class<?> r11, e r12, e r13, Map<Class<? extends BaseModel>, e> r14) {
        Intrinsics.checkNotNullParameter(r10, "paramClass");
        Intrinsics.checkNotNullParameter(r11, "resultClass");
        Intrinsics.checkNotNullParameter(r12, "paramModel");
        Intrinsics.checkNotNullParameter(r13, "resultModel");
        Intrinsics.checkNotNullParameter(r14, "models");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }
}
