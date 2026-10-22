package d18;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements e18.a<String> {
    public final String[] a;

    @Override // e18.a
    public final int getItemsCount() {
        return 2;
    }

    public a(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "mAMPMArray");
        this.a = r2;
    }

    @Override // e18.a
    public final int a(Object r1) {
        return e18.a.C0102a.a(this, r1);
    }

    @Override // e18.a
    public final String getItem(int r2) {
        if (r2 >= 0) goto L4;
    L7:
        return "";
    L4:
        if (r2 > 1) goto L7;
        return this.a[r2];
    }

    @Override // e18.a
    public final int indexOf(String r3) {
        String r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "o");
        return !Intrinsics.areEqual(r4, this.a[0]) ? 1 : 0;
    }
}
