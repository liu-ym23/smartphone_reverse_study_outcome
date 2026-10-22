package com.bumptech.glide.load.resource.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.o;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<T extends Drawable> implements o, s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f832a;

    public c(T r3) {
        this.f832a = (T) ZeusTransformUtils.preCheckCast(j.a(r3), Drawable.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.engine.o
    public void a() {
        if (ZeusTransformUtils.instanceOf(this.f832a, BitmapDrawable.class) == false) goto L7;
        Bitmap r3 = ((BitmapDrawable) ZeusTransformUtils.preCheckCast(this.f832a, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap();
    L5:
        r3.prepareToDraw();
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(this.f832a, GifDrawable.class) == false) goto L10;
        r3 = ((GifDrawable) ZeusTransformUtils.preCheckCast(this.f832a, GifDrawable.class, "com.obric.memorydata.plugin")).getFirstFrame();
        goto L5
    }

    public final T b() {
        Drawable.ConstantState r0 = this.f832a.getConstantState();
        if (r0 != null) goto L7;
        return this.f832a;
    L7:
        return (T) r0.newDrawable();
    }

    @Override // com.bumptech.glide.load.engine.s
    public /* synthetic */ Object d() {
        return b();
    }
}
