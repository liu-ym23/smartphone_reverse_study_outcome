package kotlinx.serialization.json;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.serialization.internal.e1;
import kotlinx.serialization.internal.f1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e1 f19447a = null;

    static {
        kotlinx.serialization.descriptors.e r5 = kotlinx.serialization.descriptors.e.f19228j;
        Intrinsics.checkNotNullParameter("kotlinx.serialization.json.JsonLiteral", "serialName");
        Intrinsics.checkNotNullParameter(r5, "kind");
        if (StringsKt.isBlank("kotlinx.serialization.json.JsonLiteral") == true) goto L17;
        Map r10 = f1.f19281a;
        Intrinsics.checkNotNullParameter("kotlinx.serialization.json.JsonLiteral", "serialName");
        Intrinsics.checkNotNullParameter(r5, "kind");
        Iterator r11 = f1.f19281a.keySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L14;
        String r12 = ((KClass) r11.next()).getSimpleName();
        Intrinsics.checkNotNull(r12);
        String r13 = f1.a(r12);
        if (StringsKt.l("kotlinx.serialization.json.JsonLiteral", "kotlin." + r13) == true) goto L13;
        if (StringsKt.l("kotlinx.serialization.json.JsonLiteral", r13) == false) goto L6;
    L13:
        throw new IllegalArgumentException(StringsKt.trimIndent("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name kotlinx.serialization.json.JsonLiteral there already exist " + f1.a(r13) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
    L14:
        f19447a = new e1("kotlinx.serialization.json.JsonLiteral", r5);
        return;
    L17:
        throw new IllegalArgumentException("Blank serial names are prohibited");
    }
}
