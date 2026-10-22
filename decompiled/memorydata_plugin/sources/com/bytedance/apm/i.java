package com.bytedance.apm;

import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class i implements com.bytedance.services.apm.api.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f1368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1369b;
    private ZstdDictCompress c;

    public i() {
    }

    @Override // com.bytedance.services.apm.api.i
    public byte[] a(byte[] r1, int r2) {
        return ZstdCompress.compress(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.i
    public byte[] a(byte[] r2, byte[] r3, int r4) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (this.c != null) goto L8;
    L11:
        this.c = new ZstdDictCompress(r3, r4);
        this.f1368a = r3;
        this.f1369b = r4;
    L13:
        return ZstdCompress.compress(r2, this.c);
    L8:
        if (Arrays.equals(r3, this.f1368a) == false) goto L11;
        if (r4 == this.f1369b) goto L13;
        goto L11
    }
}
