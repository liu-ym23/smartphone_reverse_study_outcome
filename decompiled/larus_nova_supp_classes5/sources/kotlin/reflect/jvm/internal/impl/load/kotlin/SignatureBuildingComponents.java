package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE = null;

    static {
        INSTANCE = new SignatureBuildingComponents();
    }

    private SignatureBuildingComponents() {
    }

    public static /* synthetic */ CharSequence accessor$SignatureBuildingComponents$lambda0(String r0) {
        return jvmDescriptor$lambda$2(r0);
    }

    private final String escapeClassName(String r3) {
        if (r3.length() > 1) goto L5;
        return r3;
    L5:
        return "L" + r3 + ';';
    }

    private static final CharSequence jvmDescriptor$lambda$2(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return INSTANCE.escapeClassName(r1);
    }

    public final String[] constructors(String... r8) {
        Intrinsics.checkNotNullParameter(r8, "signatures");
        ArrayList r0 = new ArrayList(r8.length);
        int r1 = r8.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.add("<init>(" + r8[r3] + ")V");
        r3 = r3 + 1;
        goto L3
    L6:
        return (String[]) r0.toArray(new String[0]);
    }

    public final String javaFunction(String r3) {
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        return "java/util/function/" + r3;
    }

    public final String javaLang(String r3) {
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        return "java/lang/" + r3;
    }

    public final String javaUtil(String r3) {
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        return "java/util/" + r3;
    }

    public final Set<String> inClass(String r7, String... r8) {
        Intrinsics.checkNotNullParameter(r7, "internalName");
        Intrinsics.checkNotNullParameter(r8, "signatures");
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(r7 + '.' + r8[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public final Set<String> inJavaLang(String r2, String... r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "signatures");
        return inClass(javaLang(r2), (String[]) Arrays.copyOf(r3, r3.length));
    }

    public final Set<String> inJavaUtil(String r2, String... r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "signatures");
        return inClass(javaUtil(r2), (String[]) Arrays.copyOf(r3, r3.length));
    }

    public final String signature(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "internalName");
        Intrinsics.checkNotNullParameter(r3, "jvmDescriptor");
        return r2 + '.' + r3;
    }

    public final String jvmDescriptor(String r11, List<String> r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r12, "parameters");
        Intrinsics.checkNotNullParameter(r13, "ret");
        return r11 + '(' + CollectionsKt.joinToString$default(r12, "", null, null, 0, null, SignatureBuildingComponents$.Lambda.0.INSTANCE, 30, null) + ')' + escapeClassName(r13);
    }
}
