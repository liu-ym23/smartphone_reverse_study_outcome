package com.bumptech.glide.load.data;

import ai.j0;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class a extends b {
    public final /* synthetic */ int e;

    public /* synthetic */ a(ContentResolver r5, Uri r10, int r11) {
        this.e = r11;
        super(1, r10, r5);
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class c() {
        switch(this.e) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return ParcelFileDescriptor.class;
    L6:
        return AssetFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.b
    public final void g(Object r5) {
        switch(this.e) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((ParcelFileDescriptor) r5).close();
        return;
    L6:
        ((AssetFileDescriptor) r5).close();
    }

    @Override // com.bumptech.glide.load.data.b
    public final Object h(ContentResolver r5, Uri r10) {
        switch(this.e) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        AssetFileDescriptor r11 = r5.openAssetFileDescriptor(r10, "r");
        if (r11 == null) goto L9;
        return r11.getParcelFileDescriptor();
    L9:
        throw new FileNotFoundException(j0.i(r10, "FileDescriptor is null for: "));
    L10:
        AssetFileDescriptor r12 = r5.openAssetFileDescriptor(r10, "r");
        if (r12 == null) goto L14;
        return r12;
    L14:
        throw new FileNotFoundException(j0.i(r10, "FileDescriptor is null for: "));
    }
}
