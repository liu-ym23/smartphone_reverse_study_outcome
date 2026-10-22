package d01;

import android.graphics.Bitmap;
import io.reactivex.Single;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface c {

    public static final class a {
        public final Bitmap.CompressFormat a;
        public final int b;

        public a(Bitmap.CompressFormat r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "compressFormat");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final File a;

        public b(File r2) {
            Intrinsics.checkNotNullParameter(r2, "file");
            this.a = r2;
        }
    }

    Single<b> a(a r1);
}
