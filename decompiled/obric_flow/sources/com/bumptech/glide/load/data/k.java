package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class k extends b {
    public final /* synthetic */ int e;

    public /* synthetic */ k(AssetManager r5, String r10, int r11) {
        this.e = r11;
        super(0, r10, r5);
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class c() {
        switch(this.e) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return InputStream.class;
    L6:
        return ParcelFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.b
    public final void g(Object r5) {
        switch(this.e) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((InputStream) r5).close();
        return;
    L6:
        ((ParcelFileDescriptor) r5).close();
    }

    @Override // com.bumptech.glide.load.data.b
    public final Object i(AssetManager r5, String r10) {
        switch(this.e) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return r5.open(r10);
    L7:
        return r5.openFd(r10).getParcelFileDescriptor();
    }
}
