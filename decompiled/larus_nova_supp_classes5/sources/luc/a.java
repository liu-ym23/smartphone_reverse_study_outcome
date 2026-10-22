package luc;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public final String a;
    public List<? extends Annotation> b;
    public final List<String> c;
    public final Set<String> d;
    public final List<f> e;
    public final List<List<Annotation>> f;
    public final List<Boolean> g;

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "serialName");
        this.a = r2;
        this.b = CollectionsKt.emptyList();
        this.c = new ArrayList();
        this.d = new HashSet();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    public static void a(a r2, String r3, f r4) {
        List r0 = CollectionsKt.emptyList();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "elementName");
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        Intrinsics.checkNotNullParameter(r0, "annotations");
        if (((HashSet) r2.d).add(r3) == false) goto L7;
        ((ArrayList) r2.c).add(r3);
        ((ArrayList) r2.e).add(r4);
        ((ArrayList) r2.f).add(r0);
        ((ArrayList) r2.g).add(false);
        return;
    L7:
        throw new IllegalArgumentException(("Element with name '" + r3 + "' is already registered in " + r2.a).toString());
    }
}
