package nuc;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@InternalSerializationApi
public abstract class n1 extends x2<String> {
    public abstract String p(luc.f r1, int r2);

    public n1() {
    }

    @Override // nuc.x2
    public final String n(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r4 = p(r2, r3);
        Intrinsics.checkNotNullParameter(r4, "nestedName");
        String r5 = (String) CollectionsKt.lastOrNull(this.a);
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        Intrinsics.checkNotNullParameter(r5, "parentName");
        Intrinsics.checkNotNullParameter(r4, "childName");
        return r4;
    }
}
