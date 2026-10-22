package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public interface l extends z {
    j c();

    l d(byte[] r5, int r10, int r11);

    l e(ByteBuffer r5);

    l f(CharSequence r5, Charset r10);

    @Override // com.google.common.hash.z
    l putInt(int r5);

    @Override // com.google.common.hash.z
    l putLong(long r5);
}
