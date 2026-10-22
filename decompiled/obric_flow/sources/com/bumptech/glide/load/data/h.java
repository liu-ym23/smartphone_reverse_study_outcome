package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class h implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1425a;

    public /* synthetic */ h(int r5) {
        this.f1425a = r5;
    }

    @Override // com.bumptech.glide.load.data.f
    public final g a(Object r5) {
        switch(this.f1425a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return new g8.g((ByteBuffer) r5, 8);
    L7:
        return new i((ParcelFileDescriptor) r5);
    L9:
        return new i(r5);
    }

    @Override // com.bumptech.glide.load.data.f
    public final Class c() {
        switch(this.f1425a) {
            case 0: goto L9;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        return ByteBuffer.class;
    L6:
        return ParcelFileDescriptor.class;
    L9:
        throw new UnsupportedOperationException("Not implemented");
    }
}
