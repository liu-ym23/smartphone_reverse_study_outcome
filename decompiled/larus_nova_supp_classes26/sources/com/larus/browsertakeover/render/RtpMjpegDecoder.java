package com.larus.browsertakeover.render;

import android.graphics.Bitmap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class RtpMjpegDecoder {
    public static final Set<Integer> a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/browsertakeover/render/RtpMjpegDecoder$Reason;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_BASE64", "EMPTY_DATA", "DATA_TOO_LARGE", "NOT_JPEG", "INVALID_ROTATION", "BOUNDS_DECODE_FAILED", "INVALID_SOURCE_DIMENSIONS", "SOURCE_DIMENSIONS_TOO_LARGE", "DECODE_FAILED", "INVALID_BITMAP_DIMENSIONS", "BITMAP_DIMENSIONS_TOO_LARGE", "ROTATION_FAILED", "OUT_OF_MEMORY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Reason extends Enum<Reason> {
        public static final Reason BITMAP_DIMENSIONS_TOO_LARGE = null;
        public static final Reason BOUNDS_DECODE_FAILED = null;
        public static final Reason DATA_TOO_LARGE = null;
        public static final Reason DECODE_FAILED = null;
        public static final Reason EMPTY_DATA = null;
        public static final Reason INVALID_BASE64 = null;
        public static final Reason INVALID_BITMAP_DIMENSIONS = null;
        public static final Reason INVALID_ROTATION = null;
        public static final Reason INVALID_SOURCE_DIMENSIONS = null;
        public static final Reason NOT_JPEG = null;
        public static final Reason OUT_OF_MEMORY = null;
        public static final Reason ROTATION_FAILED = null;
        public static final Reason SOURCE_DIMENSIONS_TOO_LARGE = null;
        public static final /* synthetic */ Reason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Reason> getEntries() {
            return b;
        }

        static {
            Reason r0 = new Reason("INVALID_BASE64", 0);
            INVALID_BASE64 = r0;
            Reason r1 = new Reason("EMPTY_DATA", 1);
            EMPTY_DATA = r1;
            Reason r3 = new Reason("DATA_TOO_LARGE", 2);
            DATA_TOO_LARGE = r3;
            Reason r5 = new Reason("NOT_JPEG", 3);
            NOT_JPEG = r5;
            Reason r7 = new Reason("INVALID_ROTATION", 4);
            INVALID_ROTATION = r7;
            Reason r9 = new Reason("BOUNDS_DECODE_FAILED", 5);
            BOUNDS_DECODE_FAILED = r9;
            Reason r11 = new Reason("INVALID_SOURCE_DIMENSIONS", 6);
            INVALID_SOURCE_DIMENSIONS = r11;
            Reason r13 = new Reason("SOURCE_DIMENSIONS_TOO_LARGE", 7);
            SOURCE_DIMENSIONS_TOO_LARGE = r13;
            Reason r15 = new Reason("DECODE_FAILED", 8);
            DECODE_FAILED = r15;
            Reason r14 = new Reason("INVALID_BITMAP_DIMENSIONS", 9);
            INVALID_BITMAP_DIMENSIONS = r14;
            Reason r12 = new Reason("BITMAP_DIMENSIONS_TOO_LARGE", 10);
            BITMAP_DIMENSIONS_TOO_LARGE = r12;
            Reason r10 = new Reason("ROTATION_FAILED", 11);
            ROTATION_FAILED = r10;
            Reason r8 = new Reason("OUT_OF_MEMORY", 12);
            OUT_OF_MEMORY = r8;
            Reason[] r6 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
        }

        public static Reason[] values() {
            return (Reason[]) a.clone();
        }

        public static Reason valueOf(String r1) {
            return (Reason) r27.a.a(Reason.class, r1);
        }

        public Reason(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements c {
        public final Bitmap a;
        public final int b;
        public final int c;

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "Decoded(bitmap=" + this.a + ", sourceWidth=" + this.b + ", sourceHeight=" + this.c + ')';
        }

        public a(Bitmap r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "bitmap");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b implements c {
        public final Reason a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Rejected(reason=" + this.a + ')';
        }

        public b(Reason r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
        }
    }

    public interface c {
    }

    static {
        a = SetsKt.setOf(new Integer[]{0, 90, 180, 270});
    }
}
