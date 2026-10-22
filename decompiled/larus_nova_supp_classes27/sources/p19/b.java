package p19;

import android.graphics.Bitmap;
import androidx.core.graphics.drawable.DrawableKt;
import com.github.alexzhirkevich.customqrgenerator.QrErrorCorrectionLevel;
import com.github.alexzhirkevich.customqrgenerator.vector.style.d;
import com.github.alexzhirkevich.customqrgenerator.vector.style.e;
import com.github.alexzhirkevich.customqrgenerator.vector.style.g;
import com.github.alexzhirkevich.customqrgenerator.vector.style.h;
import com.github.alexzhirkevich.customqrgenerator.vector.style.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Bitmap a(String r15, int r16, int r17, int r18) {
        Intrinsics.checkNotNullParameter(r15, "url");
        pu7.c.a r2 = new pu7.c.a();
        r2.g = false;
        QrErrorCorrectionLevel r4 = QrErrorCorrectionLevel.Low;
        Intrinsics.checkNotNullParameter(r4, "errorCorrectionLevel");
        r2.f = r4;
        g r5 = new g(new e.a(r18), new e.a(0), new e.a(r18), new e.a(r18));
        Intrinsics.checkNotNullParameter(r5, "colors");
        r2.c = r5;
        n r7 = new n(new a(1.0f), new d.b(), new h.c(), 18);
        Intrinsics.checkNotNullParameter(r7, "shapes");
        pu7.c r1 = new pu7.c(r2.a, r7, r2.b, r2.c, r2.d, r2.e, r2.f, r2.g, r2.h);
        com.github.alexzhirkevich.customqrgenerator.c.a r3 = new com.github.alexzhirkevich.customqrgenerator.c.a(r15);
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r1, "options");
        return DrawableKt.toBitmap$default(new pu7.b(r3, r1, null), r16, r17, null, 4, null);
    }
}
