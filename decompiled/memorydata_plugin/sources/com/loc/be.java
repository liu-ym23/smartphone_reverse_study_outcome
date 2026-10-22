package com.loc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class be extends bf {
    public be() {
    }

    public be(bf r1) {
        super(r1);
    }

    @Override // com.loc.bf
    public final byte[] a(byte[] r4) {
        StringBuffer r3 = new StringBuffer();
        r3.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        r3.append(" ");
        r3.append(UUID.randomUUID().toString());
        r3.append(" ");
        if (r3.length() != 53) goto L5;
        byte[] r5 = fx.a(r3.toString());
        byte[] r0 = new byte[r5.length + r4.length];
        System.arraycopy(r5, 0, r0, 0, r5.length);
        System.arraycopy(r4, 0, r0, r5.length, r4.length);
        return r0;
    L5:
        return new byte[0];
    }
}
