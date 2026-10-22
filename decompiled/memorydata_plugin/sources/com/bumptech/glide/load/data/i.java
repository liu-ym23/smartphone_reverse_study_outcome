package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public class i extends l<ParcelFileDescriptor> {
    public i(ContentResolver r1, Uri r2) {
        super(r1, r2);
    }

    public ParcelFileDescriptor a(Uri r2, ContentResolver r3) {
        AssetFileDescriptor r1 = r3.openAssetFileDescriptor(r2, "r");
        if (r1 == null) goto L7;
        return r1.getParcelFileDescriptor();
    L7:
        throw new FileNotFoundException("FileDescriptor is null for: " + r2);
    }

    @Override // com.bumptech.glide.load.data.d
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(ParcelFileDescriptor r1) {
        r1.close();
    }

    @Override // com.bumptech.glide.load.data.l
    public /* synthetic */ void a(ParcelFileDescriptor r3) {
        a2((ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r3, ParcelFileDescriptor.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.load.data.l
    public /* synthetic */ ParcelFileDescriptor b(Uri r1, ContentResolver r2) {
        return a(r1, r2);
    }
}
