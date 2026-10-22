package com.bytedance.lark.lark_bitable_android;

import com.sun.jna.Pointer;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o0 extends OutputStream {
    public final Pointer a;
    public long b;

    public o0(Pointer r10) {
        Intrinsics.checkNotNullParameter(r10, "pointer");
        this.a = r10;
    }

    @Override // java.io.OutputStream
    public final void write(int r10) {
        this.a.write(this.b, new int[]{r10}, 0, 1);
        this.b++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.a.write(this.b, r10, 0, r10.length);
        this.b += (long) r10.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r10, int r11, int r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.a.write(this.b, r10, r11, r12);
        this.b += (long) r12;
    }
}
