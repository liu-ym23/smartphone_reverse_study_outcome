package ry9;

import com.larus.bmhome.actionbar.model.MediaAttachment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface i {

    public static final class a implements i {
        public final MediaAttachment a;
        public final Boolean b;

        public /* synthetic */ a() {
            throw null;
        }

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
            int r0 = this.a.hashCode() * 31;
            Boolean r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ImageSelectorData(selectedData=" + this.a + ", hasFace=" + this.b + ')';
        }

        public a(MediaAttachment r2, Boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "selectedData");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements i {
        public final MediaAttachment a;

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
            return "VideoSelectorData(selectedData=" + this.a + ')';
        }

        public b(MediaAttachment r2) {
            Intrinsics.checkNotNullParameter(r2, "selectedData");
            this.a = r2;
        }
    }
}
