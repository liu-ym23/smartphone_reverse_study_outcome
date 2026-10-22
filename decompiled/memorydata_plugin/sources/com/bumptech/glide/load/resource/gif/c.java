package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.bumptech.glide.load.g<GifDrawable> {
    public c() {
    }

    @Override // com.bumptech.glide.load.g
    public EncodeStrategy a(com.bumptech.glide.load.e r1) {
        return EncodeStrategy.SOURCE;
    }

    public boolean a(s<GifDrawable> r1, File r2, com.bumptech.glide.load.e r3) {
        com.bumptech.glide.util.a.a(((GifDrawable) ZeusTransformUtils.preCheckCast(((s) ZeusTransformUtils.wrapperContextForParams(r1, s.class, "com.obric.memorydata.plugin")).d(), GifDrawable.class, "com.obric.memorydata.plugin")).getBuffer(), r2);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        if (Log.isLoggable("GifEncoder", 5) == false) goto L9;
        Log.w("GifEncoder", "Failed to encode GIF drawable data", e);
    L9:
        return false;
    }

    @Override // com.bumptech.glide.load.a
    public /* synthetic */ boolean a(Object r3, File r4, com.bumptech.glide.load.e r5) {
        return a((s) ZeusTransformUtils.preCheckCast(r3, s.class, "com.obric.memorydata.plugin"), r4, r5);
    }
}
