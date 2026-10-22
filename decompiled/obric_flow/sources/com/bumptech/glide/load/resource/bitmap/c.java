package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.a0;
import com.bumptech.glide.load.engine.d0;

/* JADX INFO: loaded from: classes.dex */
public final class c implements d0, a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1604c;

    public c(Bitmap r5, com.bumptech.glide.load.engine.bitmap_recycle.a r10) {
        this.f1602a = 0;
        io.reactivex.internal.observers.h.h(r5, "Bitmap must not be null");
        this.f1603b = r5;
        io.reactivex.internal.observers.h.h(r10, "BitmapPool must not be null");
        this.f1604c = r10;
    }

    public static c b(Bitmap r5, com.bumptech.glide.load.engine.bitmap_recycle.a r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new c(r5, r10);
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final int a() {
        switch(this.f1602a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return ((d0) this.f1604c).a();
    L7:
        return q0.i.c((Bitmap) this.f1603b);
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final Class c() {
        switch(this.f1602a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return BitmapDrawable.class;
    L6:
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final Object get() {
        switch(this.f1602a) {
            case 0: goto L7;
            default: goto L4;
        };
    L4:
        Bitmap r5 = (Bitmap) ((d0) this.f1604c).get();
        return new BitmapDrawable((Resources) this.f1603b, r5);
    L7:
        return (Bitmap) this.f1603b;
    }

    @Override // com.bumptech.glide.load.engine.a0
    public final void initialize() {
        switch(this.f1602a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        d0 r5 = (d0) this.f1604c;
        if ((r5 instanceof a0) == false) goto L10;
        ((a0) r5).initialize();
        return;
    L10:
        return;
    L8:
        ((Bitmap) this.f1603b).prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final void recycle() {
        switch(this.f1602a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((d0) this.f1604c).recycle();
        return;
    L6:
        ((com.bumptech.glide.load.engine.bitmap_recycle.a) this.f1604c).b((Bitmap) this.f1603b);
    }

    public c(Resources r5, d0 r10) {
        this.f1602a = 1;
        io.reactivex.internal.observers.h.h(r5, "Argument must not be null");
        this.f1603b = r5;
        io.reactivex.internal.observers.h.h(r10, "Argument must not be null");
        this.f1604c = r10;
    }
}
