package nuc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r0 extends g2 {
    public final boolean m;

    @Override // nuc.g2
    public final int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // nuc.g2, luc.f
    public final boolean isInline() {
        return this.m;
    }

    @Override // nuc.g2
    public final boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if ((r7 instanceof r0) == false) goto L29;
        luc.f r3 = (luc.f) r7;
        if (Intrinsics.areEqual(this.a, r3.f()) == false) goto L29;
        r0 r8 = (r0) r7;
        if (r8.m == true) goto L14;
    L16:
        boolean r9 = false;
    L17:
        if (r9 == false) goto L29;
        if (this.c != r3.d()) goto L29;
        int r10 = this.c;
        int r1 = 0;
    L23:
        if (r1 >= r10) goto L36;
        if (Intrinsics.areEqual(h(r1).f(), r3.h(r1).f()) == false) goto L29;
        if (Intrinsics.areEqual(h(r1).getKind(), r3.h(r1).getKind()) == false) goto L29;
        r1 = r1 + 1;
        goto L23
    L36:
        return true;
    L14:
        if (Arrays.equals((luc.f[]) this.k.getValue(), (luc.f[]) r8.k.getValue()) == false) goto L16;
        r9 = true;
    L29:
        return false;
    }

    public r0(String r2, m0<?> r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "generatedSerializer");
        super(r2, r3, 1);
        this.m = true;
    }
}
