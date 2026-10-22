package com.bytedance.byted_bach_sdk.finder;

import com.bef.effectsdk.ResourceFinder;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class EPResourceFinder extends BachResourceFinder {
    private native long nativeCreate(long r1);

    private native void nativeDestroy(long r1);

    @Override // com.bytedance.byted_bach_sdk.finder.BachResourceFinder
    public void destroy() {
        if (this.isDestroyed == false) goto L5;
        return;
    L5:
        this.isDestroyed = true;
        nativeDestroy(this.m_nativePtr);
    }

    private static long generateLongKey() {
        byte[] r2 = new byte[8];
        System.arraycopy(toBytes(UUID.randomUUID()), 0, r2, 0, 8);
        return ByteBuffer.wrap(r2).getLong();
    }

    public void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public EPResourceFinder(ResourceFinder r3) {
        this.m_nativePtr = nativeCreate(r3.createNativeResourceFinder(generateLongKey()));
    }

    private static byte[] toBytes(UUID r3) {
        ByteBuffer r0 = ByteBuffer.allocate(16);
        r0.putLong(r3.getMostSignificantBits());
        r0.putLong(r3.getLeastSignificantBits());
        return r0.array();
    }

    public EPResourceFinder(long r1) {
        this.m_nativePtr = nativeCreate(r1);
    }
}
