package com.larus.dora.impl.frameassembler;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface j {
    PolarisFileOutputStreamWrapper a(h r1) throws IOException;

    void b(h r1, OutputStream r2) throws IOException;

    void c(h r1, OutputStream r2, Throwable r3) throws IOException;

    void d(h r1, OutputStream r2, byte[] r3, int r4) throws IOException;

    void e(h r1, OutputStream r2, DoraIncompleteReason r3) throws IOException;
}
