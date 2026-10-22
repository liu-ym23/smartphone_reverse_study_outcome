package com.lynx.tasm;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class PlatformCallBack {
    public PlatformCallBack() {
    }

    public abstract void a(Object r1);

    private void onDataBack(ByteBuffer r2) {
        j7a.a.a.getClass();
        a(j7a.a.a(r2));
    }
}
