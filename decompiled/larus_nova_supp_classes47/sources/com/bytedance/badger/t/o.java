package com.bytedance.badger.t;

import java.io.ByteArrayOutputStream;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {
    public final ByteArrayOutputStream a;

    public o() {
        this.a = new ByteArrayOutputStream();
    }

    public final void a(int r3) {
        this.a.write(1);
        this.a.write((r3 >> 24) & 255);
        this.a.write((r3 >> 16) & 255);
        this.a.write((r3 >> 8) & 255);
        this.a.write(r3 & 255);
    }

    public final void b(long r6) {
        this.a.write(2);
        this.a.write((int) ((r6 >> 56) & 255));
        this.a.write((int) ((r6 >> 48) & 255));
        this.a.write((int) ((r6 >> 40) & 255));
        this.a.write((int) ((r6 >> 32) & 255));
        this.a.write((int) ((r6 >> 24) & 255));
        this.a.write((int) ((r6 >> 16) & 255));
        this.a.write((int) ((r6 >> 8) & 255));
        this.a.write((int) (r6 & 255));
    }

    public final void c(String r4) {
        byte[] r5 = r4.getBytes(Charsets.UTF_8);
        this.a.write(3);
        int r0 = r5.length;
        this.a.write((r0 >> 8) & 255);
        this.a.write(r0 & 255);
        this.a.write(r5);
    }

    public final void d(byte[] r4) {
        this.a.write(4);
        int r0 = r4.length;
        this.a.write((r0 >> 8) & 255);
        this.a.write(r0 & 255);
        this.a.write(r4);
    }
}
