package qp9;

import android.content.Context;
import androidx.core.view.GestureDetectorCompat;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h {
    public final i a;
    public final boolean b;
    public final GestureDetectorCompat c;
    public final j d;
    public final rp9.c e;

    public h(Context r5, ScaleGestureLayout.b r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.a = r6;
        this.b = true;
        d r7 = new d(this);
        e r0 = new e(this);
        g r1 = new g(this);
        f r2 = new f(this);
        GestureDetectorCompat r3 = new GestureDetectorCompat(r5, r0);
        this.c = r3;
        this.d = new j(r1);
        this.e = new rp9.c(r5, r2);
        r3.setOnDoubleTapListener(r7);
    }
}
