package g5;

import com.bytedance.ai.settings.b;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r10) {
        com.bytedance.ai.settings.a<g> r0 = b.e;
        List<String> r1 = r0.a().b();
        if (r1 != null) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if (r0.a().a() == true) goto L8;
    L20:
        return true;
    L8:
        if (r10 == null) goto L17;
        Iterator<String> r11 = r1.iterator();
    L11:
        if (r11.hasNext() == false) goto L17;
        String r12 = r11.next();
        if (StringsKt.endsWith$default(r10, r12, false, 2, null) == true) goto L16;
        if (Intrinsics.areEqual(r10, r12) == false) goto L11;
    L16:
        boolean r13 = true;
    L18:
        if (r13 == true) goto L20;
        return false;
    L17:
        r13 = false;
        goto L18
    }
}
