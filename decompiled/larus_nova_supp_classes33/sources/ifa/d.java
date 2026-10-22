package ifa;

import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface d {

    public static final class a implements d {
        public final Block a;
        public final ifa.b b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "File(block=" + this.a + ", fileResult=" + this.b + ')';
        }

        public a(Block r2, ifa.b r3) {
            Intrinsics.checkNotNullParameter(r2, "block");
            Intrinsics.checkNotNullParameter(r3, "fileResult");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements d {
        public final Block a;
        public final c b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Media(block=" + this.a + ", mediaItem=" + this.b + ')';
        }

        public b(Block r2, c r3) {
            Intrinsics.checkNotNullParameter(r2, "block");
            Intrinsics.checkNotNullParameter(r3, "mediaItem");
            this.a = r2;
            this.b = r3;
        }
    }
}
