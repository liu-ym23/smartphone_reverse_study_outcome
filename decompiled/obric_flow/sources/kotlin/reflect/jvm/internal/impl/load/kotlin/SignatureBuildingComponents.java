package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.room.jarjarred.org.antlr.runtime.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSignatureBuildingComponents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponents\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,39:1\n11335#2:40\n11670#2,3:41\n11670#2,3:46\n37#3,2:44\n*S KotlinDebug\n*F\n+ 1 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponents\n*L\n20#1:40\n20#1:41,3\n25#1:46,3\n20#1:44,2\n*E\n"})
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE = null;

    static {
        INSTANCE = new SignatureBuildingComponents();
    }

    private SignatureBuildingComponents() {
    }

    public static final /* synthetic */ String access$escapeClassName(SignatureBuildingComponents r5, String r10) {
        return r5.escapeClassName(r10);
    }

    private final String escapeClassName(String r5) {
        if (r5.length() > 1) goto L5;
        return r5;
    L5:
        return a.p("L", ';', r5);
    }

    public final String[] constructors(String... r10) {
        Intrinsics.checkNotNullParameter(r10, "signatures");
        ArrayList r11 = new ArrayList(r10.length);
        int r5 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L6;
        r11.add("<init>(" + r10[r12] + ")V");
        r12 = r12 + 1;
        goto L3
    L6:
        return (String[]) r11.toArray(new String[0]);
    }

    public final Set<String> inClass(String r10, String... r11) {
        Intrinsics.checkNotNullParameter(r10, "internalName");
        Intrinsics.checkNotNullParameter(r11, "signatures");
        LinkedHashSet r5 = new LinkedHashSet();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r5.add(r10 + '.' + r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r5;
    }

    public final Set<String> inJavaLang(String r5, String... r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "signatures");
        return inClass(javaLang(r5), (String[]) Arrays.copyOf(r10, r10.length));
    }

    public final Set<String> inJavaUtil(String r5, String... r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "signatures");
        return inClass(javaUtil(r5), (String[]) Arrays.copyOf(r10, r10.length));
    }

    public final String javaFunction(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return "java/util/function/" + r5;
    }

    public final String javaLang(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return "java/lang/" + r5;
    }

    public final String javaUtil(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return "java/util/" + r5;
    }

    public final String jvmDescriptor(String r10, List<String> r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "parameters");
        Intrinsics.checkNotNullParameter(r12, "ret");
        return r10 + '(' + CollectionsKt.q(r11, "", null, null, 0, null, AnonymousClass1.INSTANCE, 30) + ')' + escapeClassName(r12);
    }

    public final String signature(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "internalName");
        Intrinsics.checkNotNullParameter(r10, "jvmDescriptor");
        return r5 + '.' + r10;
    }
}
