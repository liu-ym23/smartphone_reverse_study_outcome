package d18;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements e18.a<a> {
    public final String[] a;
    public final int b;
    public final int c;

    public final class a implements e18.c {
        public final int a;
        public final /* synthetic */ e b;

        @Override // e18.c
        public final String a() {
            int r0 = this.b.getItemsCount();
            int r1 = this.a;
            boolean r2 = true;
            if (r1 < 0) goto L6;
            if (r1 >= r0) goto L6;
            boolean r3 = true;
        L7:
            if (r3 == false) goto L9;
            int r4 = (this.b.b + r1) - 1;
        L10:
            if (r4 >= 0) goto L12;
        L14:
            r2 = false;
        L15:
            if (r2 == true) goto L19;
            return "";
        L19:
            return this.b.a[r4];
        L12:
            if (r4 >= this.b.a.length) goto L14;
        L9:
            r4 = -1;
        L6:
            r3 = false;
            goto L7
        }

        public a(e r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // e18.a
    public final int getItemsCount() {
        return (this.c - this.b) + 1;
    }

    @Override // e18.a
    public final int a(Object r1) {
        return e18.a.C0102a.a(this, r1);
    }

    @Override // e18.a
    public final a getItem(int r2) {
        return new a(this, r2);
    }

    @Override // e18.a
    public final int indexOf(a r2) {
        a r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "o");
        return r3.a;
    }

    public e(int r2, int r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r4, "monthStringArray");
        this.a = r4;
        this.b = r2;
        this.c = r3;
    }
}
