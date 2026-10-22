package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE = null;

    static {
        INSTANCE = new SignatureBuildingComponents();
    }

    private SignatureBuildingComponents() {
    }

    public static final /* synthetic */ String access$escapeClassName(SignatureBuildingComponents r10, String r11) {
        return r10.escapeClassName(r11);
    }

    private final String escapeClassName(String r10) {
        if (r10.length() > 1) goto L5;
        return r10;
    L5:
        return 'L' + r10 + ';';
    }

    public final String[] constructors(String... r10) {
        Intrinsics.checkNotNullParameter(r10, "signatures");
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add("<init>(" + r10[r13] + ")V");
        r13 = r13 + 1;
        goto L3
    L5:
        Object[] r14 = r11.toArray(new String[0]);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) r14;
    }

    public final Set<String> inClass(String r10, String... r11) {
        Intrinsics.checkNotNullParameter(r10, "internalName");
        Intrinsics.checkNotNullParameter(r11, "signatures");
        LinkedHashSet r12 = new LinkedHashSet();
        int r13 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12.add(r10 + '.' + r11[r14]);
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    public final Set<String> inJavaLang(String r10, String... r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "signatures");
        return inClass(javaLang(r10), (String[]) Arrays.copyOf(r11, r11.length));
    }

    public final Set<String> inJavaUtil(String r10, String... r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "signatures");
        return inClass(javaUtil(r10), (String[]) Arrays.copyOf(r11, r11.length));
    }

    public final String javaFunction(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return "java/util/function/" + r10;
    }

    public final String javaLang(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return "java/lang/" + r10;
    }

    public final String javaUtil(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return "java/util/" + r10;
    }

    public final String jvmDescriptor(String r11, List<String> r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "parameters");
        Intrinsics.checkNotNullParameter(r13, "ret");
        return r11 + '(' + CollectionsKt.joinToString$default(r12, "", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null) + ')' + escapeClassName(r13);
    }

    public final String signature(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "internalName");
        Intrinsics.checkNotNullParameter(r11, "jvmDescriptor");
        return r10 + '.' + r11;
    }
}
