package kotlinx.serialization.descriptors;

import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.serialization.internal.h1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19240a;

    public /* synthetic */ k() {
        this.f19240a = 2;
    }

    public static final h a(String r10, g[] r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r10, "serialName");
        Intrinsics.checkNotNullParameter(r11, "typeParameters");
        Intrinsics.checkNotNullParameter(r12, "builderAction");
        if (StringsKt.isBlank(r10) == true) goto L7;
        a r13 = new a(r10);
        r12.invoke(r13);
        return new h(r10, n.f19243b, r13.f19218c.size(), ArraysKt.toList(r11), r13);
    L7:
        throw new IllegalArgumentException("Blank serial names are prohibited");
    }

    public static final h b(String r10, k r11, g[] r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r10, "serialName");
        Intrinsics.checkNotNullParameter(r11, "kind");
        Intrinsics.checkNotNullParameter(r12, "typeParameters");
        Intrinsics.checkNotNullParameter(r13, "builder");
        if (StringsKt.isBlank(r10) == true) goto L11;
        if (Intrinsics.areEqual(r11, n.f19243b) == true) goto L9;
        a r14 = new a(r10);
        r13.invoke(r14);
        return new h(r10, r11, r14.f19218c.size(), ArraysKt.toList(r12), r14);
    L9:
        throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
    L11:
        throw new IllegalArgumentException("Blank serial names are prohibited");
    }

    public static /* synthetic */ h c(String r5, k r10, g[] r11) {
        return b(r5, r10, r11, SerialDescriptorsKt$buildSerialDescriptor$1.INSTANCE);
    }

    public static final KClass d(g r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof b) == false) goto L6;
        return ((b) r5).f19220b;
    L6:
        if ((r5 instanceof h1) == true) goto L11;
        return null;
    L11:
        return d(((h1) r5).f19291a);
    }

    public int hashCode() {
        switch(this.f19240a) {
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.hashCode();
    L7:
        return toString().hashCode();
    }

    public String toString() {
        switch(this.f19240a) {
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        String r5 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        Intrinsics.checkNotNull(r5);
        return r5;
    L5:
        return super.toString();
    }
}
