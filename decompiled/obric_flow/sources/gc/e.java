package gc;

import com.bytedance.ies.bullet.service.base.a0;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wc.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f17086a = null;

    static {
        ArrayList r5 = new ArrayList();
        r5.add("http");
        r5.add("local_file");
        r5.add("assets");
        r5.add(IIvyAIPackageResourceService.SCHEMA);
        r5.add("lynxview");
        f17086a = r5;
    }

    public static void a(a0 r5, g r10) {
        Intrinsics.checkNotNullParameter(r5, "resource");
        Intrinsics.checkNotNullParameter(r10, "config");
        String r11 = r5.f5932a.getScheme();
        if (com.bytedance.ies.bullet.kit.resourceloader.g.f5453c == false) goto L6;
    L13:
        boolean r12 = true;
    L14:
        r5.g = r12;
        return;
    L6:
        if (CollectionsKt.contains(f17086a, r11) == true) goto L13;
        if (r5.d != null) goto L13;
        if (r10.f.length() > 0) goto L13;
        r12 = false;
        goto L14
    }

    public static boolean b(String r5, wc.e r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r5, "url");
        if (com.bytedance.ies.bullet.kit.resourceloader.g.f5453c == false) goto L6;
        return false;
    L6:
        if (r10.f22832k.isEmpty() == true) goto L13;
        Iterator r11 = r10.f22832k.iterator();
    L9:
        if (r11.hasNext() == false) goto L13;
        if (StringsKt.g(r5, (String) r11.next()) == false) goto L9;
        return false;
    L13:
        return true;
    }
}
