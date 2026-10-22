package com.larus.search.impl.global.view.aggregate.kmp;

import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.ContactPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i implements ei9.f {
    public final ContactPayload a;

    public static final class a implements ei9.g<ISearchDataPayload, i> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean a(Object r2) {
            ISearchDataPayload r3 = (ISearchDataPayload) r2;
            Intrinsics.checkNotNullParameter(r3, "sourceData");
            if (r3.getType() != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public final ei9.f b(Object r2) {
            ContactPayload r3 = (ISearchDataPayload) r2;
            Intrinsics.checkNotNullParameter(r3, "sourceData");
            if ((r3 instanceof ContactPayload) == false) goto L5;
            ContactPayload r4 = r3;
        L6:
            if (r4 != null) goto L9;
            r4 = new ContactPayload(0);
        L9:
            return new i(r4);
        L5:
            r4 = null;
            goto L6
        }
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((i) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "KmpContactSearchCellState(payload=" + this.a + ')';
    }

    public i(ContactPayload r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        this.a = r2;
    }
}
