package kotlinx.serialization.descriptors;

import ai.j0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f19217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f19218c;
    public final HashSet d;
    public final ArrayList e;
    public final ArrayList f;
    public final ArrayList g;

    public a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "serialName");
        this.f19216a = r5;
        this.f19217b = CollectionsKt.emptyList();
        this.f19218c = new ArrayList();
        this.d = new HashSet();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    public static void a(a r5, String r10, g r11) {
        List r12 = CollectionsKt.emptyList();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "elementName");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        Intrinsics.checkNotNullParameter(r12, "annotations");
        if (r5.d.add(r10) == false) goto L6;
        r5.f19218c.add(r10);
        r5.e.add(r11);
        r5.f.add(r12);
        r5.g.add(false);
        return;
    L6:
        StringBuilder r13 = j0.x("Element with name '", r10, "' is already registered in ");
        r13.append(r5.f19216a);
        throw new IllegalArgumentException(r13.toString().toString());
    }
}
