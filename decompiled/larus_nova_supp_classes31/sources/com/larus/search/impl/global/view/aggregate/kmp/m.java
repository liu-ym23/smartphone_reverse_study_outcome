package com.larus.search.impl.global.view.aggregate.kmp;

import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.MixedFeedPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m implements ei9.f {
    public final MixedFeedPayload a;

    public static final class a implements ei9.g<ISearchDataPayload, m> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean a(Object r2) {
            ISearchDataPayload r3 = (ISearchDataPayload) r2;
            Intrinsics.checkNotNullParameter(r3, "sourceData");
            if (r3.getType() != 119) goto L5;
            return true;
        L5:
            return false;
        }

        public final ei9.f b(Object r3) {
            MixedFeedPayload r4 = (ISearchDataPayload) r3;
            Intrinsics.checkNotNullParameter(r4, "sourceData");
            if ((r4 instanceof MixedFeedPayload) == false) goto L5;
            MixedFeedPayload r5 = r4;
        L6:
            if (r5 != null) goto L9;
            r5 = new MixedFeedPayload("", "", "", 2097136);
        L9:
            return new m(r5);
        L5:
            r5 = null;
            goto L6
        }
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof m) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((m) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "KmpMixedFeedCellState(payload=" + this.a + ')';
    }

    public m(MixedFeedPayload r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        this.a = r2;
    }
}
