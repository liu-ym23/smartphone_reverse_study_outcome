package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.d0;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class v implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1637b;

    public v(byte[] r5) {
        this.f1636a = 1;
        io.reactivex.internal.observers.h.h(r5, "Argument must not be null");
        this.f1637b = r5;
    }

    private final void b() {
    }

    private final void d() {
    }

    private final void e() {
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final int a() {
        switch(this.f1636a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L4;
        };
    L4:
        return 1;
    L7:
        return ((byte[]) this.f1637b).length;
    L9:
        return q0.i.c((Bitmap) this.f1637b);
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final Class c() {
        switch(this.f1636a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        return byte[].class;
    L8:
        return Bitmap.class;
    L5:
        return ((File) this.f1637b).getClass();
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final Object get() {
        switch(this.f1636a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return (File) this.f1637b;
    L7:
        return (byte[]) this.f1637b;
    L9:
        return (Bitmap) this.f1637b;
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final void recycle() {
        int r5 = this.f1636a;
    }

    public v(File r5) {
        this.f1636a = 2;
        io.reactivex.internal.observers.h.h(r5, "Argument must not be null");
        this.f1637b = r5;
    }

    public v(Bitmap r5) {
        this.f1636a = 0;
        this.f1637b = r5;
    }
}
