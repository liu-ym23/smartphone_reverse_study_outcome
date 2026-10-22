package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class ArtDecoder extends DefaultDecoder {
    public ArtDecoder(BitmapPool r5, int r10, Pools.SynchronizedPool r11) {
        super(r5, r10, r11);
    }

    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    public final int a(int r5, int r10, BitmapFactory.Options r11) {
        int r12 = BitmapUtil.a(r11.inPreferredConfig);
        return r12 * (r5 * r10);
    }
}
