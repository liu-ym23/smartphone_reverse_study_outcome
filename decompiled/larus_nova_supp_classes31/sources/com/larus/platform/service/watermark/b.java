package com.larus.platform.service.watermark;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class b {

    public static final class a extends b {
        public final Bitmap a;

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
            return "FromBitmap(bitmap=" + this.a + ')';
        }

        public a(Bitmap r2) {
            Intrinsics.checkNotNullParameter(r2, "bitmap");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.platform.service.watermark.b$b, reason: collision with other inner class name */
    public static final class C0012b extends b {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0012b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0012b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "FromPath(localPath=" + this.a + ')';
        }

        public C0012b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "localPath");
            this.a = r2;
        }
    }

    public b() {
    }
}
