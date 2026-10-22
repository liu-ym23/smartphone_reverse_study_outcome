package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.h;
import com.bumptech.glide.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements h<Bitmap> {
    public abstract Bitmap a(Context r1, e r2, Bitmap r3, int r4, int r5);

    @Override // com.bumptech.glide.load.h
    public final s<Bitmap> a(Context r10, s<Bitmap> r11, int r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        s<Bitmap> r15 = (s) ZeusTransformUtils.wrapperContextForParams(r11, s.class, "com.obric.memorydata.plugin");
        if (k.a(r12, r13) == false) goto L16;
        e r0 = c.a(r14).a();
        Bitmap r8 = (Bitmap) ZeusTransformUtils.preCheckCast(r15.d(), Bitmap.class, "com.obric.memorydata.plugin");
        if (r12 != Integer.MIN_VALUE) goto L7;
        r12 = r8.getWidth();
    L7:
        int r6 = r12;
        if (r13 != Integer.MIN_VALUE) goto L10;
        r13 = r8.getHeight();
    L10:
        Bitmap r9 = a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r0, r8, r6, r13);
        if (r8.equals(r9) == false) goto L14;
        return r15;
    L14:
        return com.bumptech.glide.load.resource.bitmap.e.a(r9, r0);
    L16:
        throw new IllegalArgumentException("Cannot apply transformation on width: " + r12 + " or height: " + r13 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    void a(Bitmap r1, Bitmap r2) {
        r2.setDensity(r1.getDensity());
    }
}
