package com.larus.search.impl.global.view.aggregate.kmp;

import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.SearchAccountPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p implements ei9.f {
    public final SearchAccountPayload a;

    public static final class a implements ei9.g<ISearchDataPayload, p> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean a(Object r2) {
            ISearchDataPayload r3 = (ISearchDataPayload) r2;
            Intrinsics.checkNotNullParameter(r3, "sourceData");
            if (r3.getType() != 118) goto L5;
            return true;
        L5:
            return false;
        }

        public final ei9.f b(Object r2) {
            SearchAccountPayload r3 = (ISearchDataPayload) r2;
            Intrinsics.checkNotNullParameter(r3, "sourceData");
            if ((r3 instanceof SearchAccountPayload) == false) goto L5;
            SearchAccountPayload r4 = r3;
        L6:
            if (r4 != null) goto L9;
            r4 = new SearchAccountPayload("");
        L9:
            return new p(r4);
        L5:
            r4 = null;
            goto L6
        }
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof p) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((p) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "KmpSearchAccountCellState(payload=" + this.a + ')';
    }

    public p(SearchAccountPayload r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        this.a = r2;
    }
}
