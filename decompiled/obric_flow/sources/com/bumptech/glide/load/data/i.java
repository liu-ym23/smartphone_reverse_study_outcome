package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.resource.bitmap.s;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class i implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f1426c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1428b;

    static {
        f1426c = new h(0);
    }

    public i() {
        this.f1427a = 0;
        this.f1428b = new HashMap();
    }

    private final void a() {
    }

    private final void d() {
    }

    @Override // com.bumptech.glide.load.data.g
    public void b() {
        switch(this.f1427a) {
            case 1: goto L6;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        ((s) this.f1428b).d();
        return;
    }

    @Override // com.bumptech.glide.load.data.g
    public Object c() {
        switch(this.f1427a) {
            case 1: goto L9;
            case 2: goto L7;
            default: goto L4;
        };
    L4:
        s r5 = (s) this.f1428b;
        r5.reset();
        return r5;
    L7:
        return this.f1428b;
    L9:
        return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f1428b).rewind();
    }

    public ParcelFileDescriptor e() {
        return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f1428b).rewind();
    }

    public i(InputStream r5, com.bumptech.glide.load.engine.bitmap_recycle.f r10) {
        this.f1427a = 3;
        s r11 = new s(r5, r10);
        this.f1428b = r11;
        r11.mark(5242880);
    }

    public i(ParcelFileDescriptor r5) {
        this.f1427a = 1;
        this.f1428b = new ParcelFileDescriptorRewinder$InternalRewinder(r5);
    }

    public i(Object r5) {
        this.f1427a = 2;
        this.f1428b = r5;
    }
}
