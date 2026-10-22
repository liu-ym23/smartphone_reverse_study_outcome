package fn8;

import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaOverlayAlignment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class d0 {

    public static final class a extends d0 {
        public final String a;
        public final RichMediaOverlayAlignment b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Image(iconUrl=" + this.a + ", alignment=" + this.b + ')';
        }

        @Override // fn8.d0
        public final RichMediaOverlayAlignment a() {
            return this.b;
        }

        public a(String r2, RichMediaOverlayAlignment r3) {
            Intrinsics.checkNotNullParameter(r2, "iconUrl");
            Intrinsics.checkNotNullParameter(r3, "alignment");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends d0 {
        public final String a;
        public final RichMediaOverlayAlignment b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Link(openUrl=" + this.a + ", alignment=" + this.b + ')';
        }

        @Override // fn8.d0
        public final RichMediaOverlayAlignment a() {
            return this.b;
        }

        public b(String r2, RichMediaOverlayAlignment r3) {
            Intrinsics.checkNotNullParameter(r2, "openUrl");
            Intrinsics.checkNotNullParameter(r3, "alignment");
            this.a = r2;
            this.b = r3;
        }
    }

    public d0() {
    }

    public abstract RichMediaOverlayAlignment a();
}
