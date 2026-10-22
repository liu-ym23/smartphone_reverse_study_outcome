package s4;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.utils.g;
import f3.k;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public static boolean a(String r10, ContainerType r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        if (StringsKt.isBlank(r10) == false) goto L6;
        g.a.e("CanIUseUtils", "handle empty schema");
        return false;
    L6:
        List r12 = StringsKt.split$default(r10, new char[]{'.'}, false, 0, 6, null);
        String r13 = (String) CollectionsKt.getOrNull(r12, 0);
        if (r13 != null) goto L9;
    L12:
        boolean r14 = true;
    L13:
        if (r14 == false) goto L16;
        g.a.e("CanIUseUtils", "API's scope name is empty");
        return false;
    L16:
        String r15 = (String) CollectionsKt.getOrNull(r12, 1);
        if (r15 != null) goto L19;
    L22:
        boolean r16 = true;
    L23:
        if (r16 == false) goto L26;
        g.a.e("CanIUseUtils", "API's method name is empty");
        return false;
    L26:
        if (r11 != null) goto L29;
        g.a.e("CanIUseUtils", "Container type is null");
        return false;
    L29:
        AIBridgeMethod r17 = k.b.a(r13 + '.' + r15, r11);
        if (r17 != null) goto L34;
        g.a.e("CanIUseUtils", "Not found: " + r13 + '.' + r15 + " with container type: " + r11);
        return false;
    L34:
        if (r12.size() != 2) goto L36;
        return true;
    L36:
        ConcurrentHashMap<Class<? extends AIBridgeMethod>, f3.d> r18 = f3.g.a;
        Class<?> r19 = r17.getClass();
        Intrinsics.checkNotNullParameter(r19, "clazz");
        f3.d r110 = f3.g.a.get(r19);
        g.a.d("CanIUseUtils", "annotationData: " + r110);
        return false;
    L19:
        if (r15.length() == 0) goto L22;
        r16 = false;
        goto L23
    L9:
        if (r13.length() == 0) goto L12;
        r14 = false;
        goto L13
    }
}
