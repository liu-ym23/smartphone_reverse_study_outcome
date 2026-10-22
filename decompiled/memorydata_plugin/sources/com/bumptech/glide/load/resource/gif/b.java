package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class b implements com.bumptech.glide.b.a.InterfaceC0055a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f902b;

    public b(com.bumptech.glide.load.engine.bitmap_recycle.e r3, com.bumptech.glide.load.engine.bitmap_recycle.b r4) {
        com.bumptech.glide.load.engine.bitmap_recycle.e r5 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.b r6 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        this.f901a = r5;
        this.f902b = r6;
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0055a
    public Bitmap a(int r1, int r2, Bitmap.Config r3) {
        return this.f901a.b(r1, r2, r3);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0055a
    public void a(Bitmap r1) {
        this.f901a.a(r1);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0055a
    public void a(byte[] r1) {
        com.bumptech.glide.load.engine.bitmap_recycle.b r0 = this.f902b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0055a
    public void a(int[] r1) {
        com.bumptech.glide.load.engine.bitmap_recycle.b r0 = this.f902b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0055a
    public byte[] a(int r2) {
        com.bumptech.glide.load.engine.bitmap_recycle.b r1 = this.f902b;
        if (r1 != null) goto L7;
        return new byte[r2];
    L7:
        return (byte[]) ZeusTransformUtils.preCheckCast(r1.a(r2, byte[].class), byte[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0055a
    public int[] b(int r2) {
        com.bumptech.glide.load.engine.bitmap_recycle.b r1 = this.f902b;
        if (r1 != null) goto L7;
        return new int[r2];
    L7:
        return (int[]) ZeusTransformUtils.preCheckCast(r1.a(r2, int[].class), int[].class, "com.obric.memorydata.plugin");
    }
}
