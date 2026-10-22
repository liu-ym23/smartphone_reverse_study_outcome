package v3;

import he.i;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f12717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f12718c;

        public a(String r8, String r10, String r11) {
            this.f12716a = r8;
            this.f12717b = r10;
            this.f12718c = r11;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r10 = (a) r8;
            String r11 = r10.f12716a;
            if (i.a(this.f12716a, r11) == true) goto L12;
            return false;
        L12:
            if (i.a(this.f12717b, r10.f12717b) == true) goto L15;
            return false;
        L15:
            if (i.a(this.f12718c, r10.f12718c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r8 = this.f12716a.hashCode() * 31;
            int r10 = defpackage.a.b(this.f12717b, r8, 31);
            return this.f12718c.hashCode() + r10;
        }

        public final String toString() {
            return "PageInfo(pid=" + this.f12716a + ", pName=" + this.f12717b + ", sdkPageId=" + this.f12718c + ')';
        }
    }
}
