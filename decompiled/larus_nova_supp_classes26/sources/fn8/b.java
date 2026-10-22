package fn8;

import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.block.GenericImageItem;
import com.larus.im.bean.message.block.GenericVideoItem;
import com.larus.im.bean.message.block.SearchImageItem;
import com.larus.im.bean.message.block.SearchVideoItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class b {

    public static final class a extends b {
        public final CreationItem a;

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
            return "Creation(item=" + this.a + ')';
        }

        public a(CreationItem r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: fn8.b$b, reason: collision with other inner class name */
    public static final class C0108b extends b {
        public final GenericImageItem a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0108b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0108b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "GenericImage(item=" + this.a + ')';
        }

        public C0108b(GenericImageItem r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.a = r2;
        }
    }

    public static final class c extends b {
        public final GenericVideoItem a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "GenericVideo(item=" + this.a + ')';
        }

        public c(GenericVideoItem r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.a = r2;
        }
    }

    public static final class d extends b {
        public final SearchImageItem a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SearchImage(item=" + this.a + ')';
        }

        public d(SearchImageItem r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.a = r2;
        }
    }

    public static final class e extends b {
        public final SearchVideoItem a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((e) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SearchVideo(item=" + this.a + ')';
        }

        public e(SearchVideoItem r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.a = r2;
        }
    }

    public b() {
    }
}
