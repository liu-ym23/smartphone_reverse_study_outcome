package com.tom_roush.pdfbox.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class f extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f16119a;

    public f(h r3) {
        this.f16119a = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
    }

    @Override // java.io.OutputStream
    public void write(int r1) {
        this.f16119a.c(r1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r1) {
        this.f16119a.a(r1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r1, int r2, int r3) {
        this.f16119a.a(r1, r2, r3);
    }
}
