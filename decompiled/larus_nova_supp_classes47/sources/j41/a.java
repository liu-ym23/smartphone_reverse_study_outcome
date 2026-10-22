package j41;

import android.graphics.Bitmap;
import com.bytedance.live.kmp.core.KmpEnv;
import fr2.e0;
import fr2.g0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ c a;

    public a(c r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        e0 r2 = null;
        xh6.b r0 = vh6.c.b(g0.class).o6().b(Reflection.getOrCreateKotlinClass(e0.class), null);
        if ((r0 instanceof e0) == true) goto L5;
        r0 = null;
    L5:
        e0 r1 = (e0) r0;
        KmpEnv r3 = KmpEnv.a;
        com.bytedance.live.kmp.core.b.a();
        if (r1 == null) goto L8;
        r1.Y0();
        r1.d1();
        r1.setY(0.0f);
        r1.setH(0.19f);
        r1.f1();
        r1.x4(r5);
        r2 = r1;
    L8:
        c.a(this.a, r5, r2);
    }
}
