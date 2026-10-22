package com.bytedance.badger.t;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public final ByteBuffer a;

    public m(byte[] r2) {
        this.a = ByteBuffer.wrap(r2).order(ByteOrder.BIG_ENDIAN);
    }

    public final List a(int r4) {
        ArrayList r0 = new ArrayList();
    L4:
        if (this.a.hasRemaining() == false) goto L10;
        int r1 = this.a.position();
        if ((this.a.get() & 255) == r4) goto L7;
        this.a.position(r1);
        r0.add(b());
        goto L4
    L7:
        return r0;
    L10:
        throw new IllegalStateException("Missing end marker: " + r4);
    }

    public final l b() {
        int r0 = this.a.get() & 255;
        boolean r1 = true;
        if (r0 != 1) goto L6;
        return new g(this.a.getInt());
    L6:
        if (r0 != 2) goto L9;
        return new i(this.a.getLong());
    L9:
        if (r0 != 5) goto L16;
        if (this.a.get() != 0) goto L32;
        r1 = false;
    L32:
        return new e(r1);
    L16:
        if (r0 != 3) goto L19;
        byte[] r2 = new byte[this.a.getShort() & 65535];
        this.a.get(r2);
        return new k(new String(r2, Charsets.UTF_8));
    L19:
        if (r0 != 4) goto L22;
        byte[] r3 = new byte[this.a.getShort() & 65535];
        this.a.get(r3);
        return new f(r3);
    L22:
        if (r0 != 16) goto L25;
        return new j(a(17));
    L25:
        if (r0 != 32) goto L29;
        return new h(a(33));
    L29:
        throw new IllegalArgumentException("Unknown TLV type: " + r0);
    }
}
