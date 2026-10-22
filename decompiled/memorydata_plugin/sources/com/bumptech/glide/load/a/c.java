package com.bumptech.glide.load.a;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.bumptech.glide.load.a<ByteBuffer> {
    public c() {
    }

    @Override // com.bumptech.glide.load.a
    public /* synthetic */ boolean a(ByteBuffer r3, File r4, com.bumptech.glide.load.e r5) {
        return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(ByteBuffer r1, File r2, com.bumptech.glide.load.e r3) {
        com.bumptech.glide.util.a.a(r1, r2);     // Catch: IOException -> L4
        return true;
    L4:
        e = move-exception;
        if (Log.isLoggable("ByteBufferEncoder", 3) == false) goto L8;
        Log.d("ByteBufferEncoder", "Failed to write data", e);
    L8:
        return false;
    }
}
