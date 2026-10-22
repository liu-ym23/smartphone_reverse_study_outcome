package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.d0;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class w implements z.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1638a;

    public /* synthetic */ w(int r5) {
        this.f1638a = r5;
    }

    @Override // z.g
    public final /* bridge */ /* synthetic */ boolean a(Object r5, z.f r10) {
        switch(this.f1638a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        File r11 = (File) r5;
        return true;
    L6:
        Drawable r12 = (Drawable) r5;
        return true;
    L8:
        Bitmap r13 = (Bitmap) r5;
        return true;
    }

    @Override // z.g
    public final d0 b(Object r5, int r10, int r11, z.f r12) {
        switch(this.f1638a) {
            case 0: goto L12;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        Drawable r13 = (Drawable) r5;
        if (r13 != null) goto L13;
        return null;
    L13:
        return new h0.b(r13);
    L5:
        return new v((File) r5);
    L12:
        return new v((Bitmap) r5);
    }
}
