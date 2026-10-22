package com.larus.drive.biz.impl.search.kmp;

import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.DrivePayload;
import ei9.f;
import ei9.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements f {
    public final DrivePayload a;

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.search.kmp.a$a, reason: collision with other inner class name */
    public static final class C0111a implements g<ISearchDataPayload, a> {
        public static final C0111a a = null;

        static {
            a = new C0111a();
        }

        public C0111a() {
        }

        public final boolean a(Object r2) {
            ISearchDataPayload r3 = (ISearchDataPayload) r2;
            Intrinsics.checkNotNullParameter(r3, "sourceData");
            if (r3.getType() != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public final f b(Object r110) {
            DrivePayload r0 = (ISearchDataPayload) r110;
            Intrinsics.checkNotNullParameter(r0, "sourceData");
            if ((r0 instanceof DrivePayload) == false) goto L5;
            DrivePayload r1 = r0;
        L6:
            if (r1 != null) goto L9;
            r1 = new DrivePayload("", null, null, null, null, 0, null, null, null, 0, null, null, 0, null, 32766);
        L9:
            return new a(r1);
        L5:
            r1 = null;
            goto L6
        }
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "KmpDriveSearchCellState(payload=" + this.a + ')';
    }

    public a(DrivePayload r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        this.a = r2;
    }
}
