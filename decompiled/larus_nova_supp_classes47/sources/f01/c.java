package f01;

import android.graphics.Bitmap;
import com.bytedance.android.scope.o;
import e01.l;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements o, l {
    public final d01.c a;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            d01.c.b r3 = (d01.c.b) r2;
            Intrinsics.checkNotNullParameter(r3, "resp");
            e01.b r0 = new e01.b();
            r0.b(r3.a.getAbsolutePath());
            return r0;
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public c(d01.c r2) {
        Intrinsics.checkNotNullParameter(r2, "streamCaptureService");
        this.a = r2;
    }

    @Override // e01.l
    public final Single<e01.b> captureVideoFrame(e01.a r6) {
        Intrinsics.checkNotNullParameter(r6, "request");
        String r1 = r6.a();
        if (r1 == null) goto L5;
        String r2 = r1.toLowerCase(Locale.ROOT);
    L6:
        if (r2 == null) goto L27;
        int r3 = r2.hashCode();
        if (r3 == 0) goto L26;
        if (r3 == 105441) goto L23;
        if (r3 == 111145) goto L20;
        if (r3 != 3268712) goto L35;
        if (r2.equals("jpeg") == false) goto L35;
    L24:
        Bitmap.CompressFormat r4 = Bitmap.CompressFormat.JPEG;
    L28:
        Integer r7 = r6.b();
        if (r7 == null) goto L31;
        int r8 = r7.intValue();
    L33:
        return this.a.a(new d01.c.a(r4, RangesKt.coerceIn(r8, 0, 100))).map(a.a);
    L31:
        r8 = 100;
    L35:
        throw new IllegalArgumentException("Unsupported compress format: " + r1);
    L20:
        if (r2.equals("png") == false) goto L35;
        r4 = Bitmap.CompressFormat.PNG;
        goto L28
    L23:
        if (r2.equals("jpg") == false) goto L35;
    L26:
        if (r2.equals("") == false) goto L35;
    L27:
        r4 = Bitmap.CompressFormat.PNG;
        goto L28
    L5:
        r2 = null;
        goto L6
    }
}
