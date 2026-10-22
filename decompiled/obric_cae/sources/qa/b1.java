package qa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class b1 extends c1 {
    public b1(d1 r8) {
        super(r8);
    }

    @Override // qa.c1
    public final byte[] b(byte[] r8) {
        StringBuffer r10 = new StringBuffer();
        r10.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        r10.append(" ");
        r10.append(UUID.randomUUID().toString());
        r10.append(" ");
        if (r10.length() != 53) goto L5;
        byte[] r11 = t4.i(r10.toString());
        byte[] r12 = new byte[r11.length + r8.length];
        System.arraycopy(r11, 0, r12, 0, r11.length);
        System.arraycopy(r8, 0, r12, r11.length, r8.length);
        return r12;
    L5:
        return new byte[0];
    }
}
