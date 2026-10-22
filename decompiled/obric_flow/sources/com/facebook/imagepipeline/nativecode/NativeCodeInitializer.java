package com.facebook.imagepipeline.nativecode;

import android.content.Context;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.soloader.SoLoader;

/* JADX INFO: loaded from: classes2.dex */
@DoNotStrip
public class NativeCodeInitializer {
    public NativeCodeInitializer() {
    }

    @DoNotStrip
    public static void init(Context r5) {
        SoLoader.init(r5, 0);
    }
}
