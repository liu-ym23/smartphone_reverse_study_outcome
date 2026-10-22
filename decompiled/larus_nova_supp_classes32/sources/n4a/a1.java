package n4a;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a1 extends b1 {
    public a1(c1 r1) {
        super(r1);
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r5) {
        StringBuffer r0 = new StringBuffer();
        r0.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        r0.append(" ");
        r0.append(UUID.randomUUID().toString());
        r0.append(" ");
        if (r0.length() != 53) goto L5;
        byte[] r1 = f5.j(r0.toString());
        byte[] r2 = new byte[r1.length + r5.length];
        System.arraycopy(r1, 0, r2, 0, r1.length);
        System.arraycopy(r5, 0, r2, r1.length, r5.length);
        return r2;
    L5:
        return new byte[0];
    }
}
