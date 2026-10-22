package op8;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.platform.model.preview.AttachmentSnapshot;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class a {

    /* JADX INFO: renamed from: op8.a$a, reason: collision with other inner class name */
    public static final class C0124a extends a {
        public final List<AttachmentSnapshot> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0124a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0124a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "AppendAttachments(attachments=" + this.a + ')';
        }

        public C0124a(List<AttachmentSnapshot> r2) {
            Intrinsics.checkNotNullParameter(r2, "attachments");
            this.a = r2;
        }
    }

    public static final class b extends a {
        public final String a;
        public final String b;
        public final AttachmentSnapshot c;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            AttachmentSnapshot r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "CommitAlbumSelection(originStableId=" + this.a + ", originUri=" + this.b + ", attachment=" + this.c + ')';
        }

        public b(String r2, String r3, AttachmentSnapshot r4) {
            Intrinsics.checkNotNullParameter(r2, "originStableId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c extends a {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
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
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "RemoveAttachment(originStableId=" + this.a + ", originUri=" + this.b + ')';
        }

        public c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "originStableId");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d extends a {
        public final String a;
        public final String b;
        public final AttachmentSnapshot c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.c.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ReplaceAttachment(originStableId=" + this.a + ", originUri=" + this.b + ", edited=" + this.c + ')';
        }

        public d(String r2, String r3, AttachmentSnapshot r4) {
            Intrinsics.checkNotNullParameter(r2, "originStableId");
            Intrinsics.checkNotNullParameter(r4, "edited");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class e extends a {
        public final String a;

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
            return "UpdateText(text=" + this.a + ')';
        }

        public e(String r2) {
            Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
            this.a = r2;
        }
    }

    public a() {
    }
}
