package iy9;

import android.graphics.Bitmap;
import com.larus.platform.api.IVideoController;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final Function1<String, Integer> a;
    public final Function2<String, IVideoController, Unit> b;
    public final Function2<String, Boolean, Unit> c;
    public final Long d;
    public final Bitmap e;

    public b() {
        this(null, null, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super String, Integer> r1, Function2<? super String, ? super IVideoController, Unit> r2, Function2<? super String, ? super Boolean, Unit> r3, Long r4, Bitmap r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
