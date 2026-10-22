package com.lynx.tasm;

import com.lynx.tasm.base.CalledByNative;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PlatformCallBack {
    @CalledByNative
    private void onDataBack(ByteBuffer r5) {
        kn.b.a(r5);
        a();
    }

    public abstract void a();
}
