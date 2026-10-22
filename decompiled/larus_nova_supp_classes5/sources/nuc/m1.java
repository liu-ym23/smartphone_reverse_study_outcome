package nuc;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@InternalSerializationApi
public abstract class m1 extends w2<String> {
    public final String q() {
        if (this.a.isEmpty() == false) goto L6;
        return "$";
    L6:
        return CollectionsKt.joinToString$default(this.a, ".", "$.", null, 0, null, null, 60, null);
    }

    public m1() {
    }

    @Override // nuc.w2
    public final /* bridge */ /* synthetic */ String m(luc.f r1, int r2) {
        return p(r1, r2);
    }

    public String o(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return r2.b(r3);
    }

    public final String p(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r4 = o(r2, r3);
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
