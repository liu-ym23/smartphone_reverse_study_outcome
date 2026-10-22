package p8a;

import android.graphics.drawable.Drawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q {
    public static final ResizeOptions f = null;
    public final String a;
    public final s b;
    public final CountDownLatch c;
    public DraweeHolder<GenericDraweeHierarchy> d;
    public Drawable e;

    static {
        f = new ResizeOptions(1000, 1000);
    }

    public q(String r3, final boolean r4, boolean r5, s r6) {
        CountDownLatch r0 = new CountDownLatch(1);
        this.c = r0;
        this.a = r3;
        this.b = r6;
        UIThreadUtils.runOnUiThreadImmediately(new n(this, r4));
        if (r5 == false) goto L9;
        r0.await(100, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L6
        return;
    L10:
        return;
    }
}
