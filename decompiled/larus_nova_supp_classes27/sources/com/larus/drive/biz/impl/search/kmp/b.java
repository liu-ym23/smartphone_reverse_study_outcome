package com.larus.drive.biz.impl.search.kmp;

import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.RecentDrivePayload;
import ei9.f;
import ei9.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b implements f {
    public final RecentDrivePayload a;

    public static final class a implements g<ISearchDataPayload, b> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean a(Object r2) {
            ISearchDataPayload r3 = (ISearchDataPayload) r2;
            Intrinsics.checkNotNullParameter(r3, "sourceData");
            if (r3.getType() != 114) goto L5;
            return true;
        L5:
            return false;
        }

        public final f b(Object r2) {
            RecentDrivePayload r3 = (ISearchDataPayload) r2;
            Intrinsics.checkNotNullParameter(r3, "sourceData");
            if ((r3 instanceof RecentDrivePayload) == false) goto L5;
            RecentDrivePayload r4 = r3;
        L6:
            if (r4 != null) goto L9;
            r4 = new RecentDrivePayload(0);
        L9:
            return new b(r4);
        L5:
            r4 = null;
            goto L6
        }
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "KmpRecentDriveCellState(payload=" + this.a + ')';
    }

    public b(RecentDrivePayload r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        this.a = r2;
    }
}
