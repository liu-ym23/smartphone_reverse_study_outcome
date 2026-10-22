package ch8;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface b {

    public static final class a implements b {
        public final Uri a;

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
            return "ContentUri(uri=" + this.a + ')';
        }

        public a(Uri r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: ch8.b$b, reason: collision with other inner class name */
    public static final class C0003b implements b {
        public final File a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0003b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0003b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "FilePath(file=" + this.a + ')';
        }

        public C0003b(PolarisFileWrapper r2) {
            Intrinsics.checkNotNullParameter(r2, "file");
            this.a = r2;
        }
    }
}
