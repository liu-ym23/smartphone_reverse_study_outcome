package com.bytedance.apm;

import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class l implements t4.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f1000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ZstdDictCompress f1002c;

    public l() {
    }

    @Override // t4.j
    public byte[] a(byte[] r10, int r11) {
        return ZstdCompress.compress(r10, r11);
    }

    @Override // t4.j
    public byte[] b(byte[] r10, byte[] r11, int r12) {
        if (r11 != null) goto L6;
        return null;
    L6:
        if (this.f1002c != null) goto L8;
    L11:
        this.f1002c = new ZstdDictCompress(r11, r12);
        this.f1000a = r11;
        this.f1001b = r12;
    L13:
        return ZstdCompress.compress(r10, this.f1002c);
    L8:
        if (Arrays.equals(r11, this.f1000a) == false) goto L11;
        if (r12 == this.f1001b) goto L13;
        goto L11
    }
}
