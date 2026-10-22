package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import androidx.core.util.Pools;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(26)
public class OreoDecoder extends DefaultDecoder {
    public OreoDecoder(BitmapPool r5, int r10, Pools.SynchronizedPool r11) {
        super(r5, r10, r11);
    }

    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    public int a(int r5, int r10, BitmapFactory.Options r11) {
        ColorSpace r12 = r11.outColorSpace;
        if (r12 != null) goto L5;
    L10:
        int r13 = BitmapUtil.a(r11.inPreferredConfig);
        return r13 * (r5 * r10);
    L5:
        if (r12.isWideGamut() == false) goto L10;
        if (r11.inPreferredConfig == Bitmap.Config.RGBA_F16) goto L10;
        return (r5 * r10) * 8;
    }
}
