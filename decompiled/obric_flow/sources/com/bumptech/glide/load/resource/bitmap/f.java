package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class f extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f1607b = null;

    static {
        f1607b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(z.c.f23353a);
    }

    @Override // z.c
    public final void b(MessageDigest r5) {
        r5.update(f1607b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.d
    public final Bitmap c(com.bumptech.glide.load.engine.bitmap_recycle.a r10, Bitmap r11, int r12, int r13) {
        Paint r14 = u.f1634a;
        if (r11.getWidth() == r12) goto L5;
    L7:
        Matrix r15 = new Matrix();
        float r5 = 0.0f;
        if ((r11.getWidth() * r13) <= (r11.getHeight() * r12)) goto L10;
        float r16 = r13 / r11.getHeight();
        r5 = (r12 - (r11.getWidth() * r16)) * 0.5f;
        float r17 = 0.0f;
    L11:
        r15.setScale(r16, r16);
        r15.postTranslate((int) (r5 + 0.5f), (int) (r17 + 0.5f));
        if (r11.getConfig() == null) goto L14;
        Bitmap.Config r18 = r11.getConfig();
    L15:
        Bitmap r19 = r10.g(r12, r13, r18);
        r19.setHasAlpha(r11.hasAlpha());
        u.a(r11, r19, r15);
        return r19;
    L14:
        r18 = Bitmap.Config.ARGB_8888;
        goto L15
    L10:
        r16 = r12 / r11.getWidth();
        r17 = (r13 - (r11.getHeight() * r16)) * 0.5f;
        goto L11
    L5:
        if (r11.getHeight() != r13) goto L7;
        return r11;
    }

    @Override // z.c
    public final boolean equals(Object r5) {
        return r5 instanceof f;
    }

    @Override // z.c
    public final int hashCode() {
        return -599754482;
    }
}
