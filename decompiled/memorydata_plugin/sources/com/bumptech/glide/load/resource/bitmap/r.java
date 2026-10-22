package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bytedance.bdinstall.honor.HonorKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class r implements com.bumptech.glide.load.f<ParcelFileDescriptor, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f877a;

    public r(j r1) {
        this.f877a = r1;
    }

    private boolean a(ParcelFileDescriptor r4) {
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L9;
        if (HonorKeys.NAME.equalsIgnoreCase(Build.MANUFACTURER) == true) goto L9;
        return true;
    L9:
        if (r4.getStatSize() <= 536870912) goto L13;
        return false;
    L13:
        return true;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.s<Bitmap> a2(ParcelFileDescriptor r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        return this.f877a.a(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ com.bumptech.glide.load.engine.s<Bitmap> a(ParcelFileDescriptor r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r3, ParcelFileDescriptor.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(ParcelFileDescriptor r1, com.bumptech.glide.load.e r2) {
        if (a(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f877a.a(r1) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ boolean a(ParcelFileDescriptor r3, com.bumptech.glide.load.e r4) {
        return a2((ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r3, ParcelFileDescriptor.class, "com.obric.memorydata.plugin"), r4);
    }
}
