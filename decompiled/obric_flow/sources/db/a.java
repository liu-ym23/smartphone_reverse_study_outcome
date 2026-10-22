package db;

import com.bytedance.gkfs.storage.io.GkFSBlockBuffer;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f16624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.gkfs.storage.a f16625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GkFSBlockBuffer f16626c;

    public a(com.bytedance.gkfs.storage.a r5, GkFSBlockBuffer r10) {
        this.f16625b = r5;
        this.f16626c = r10;
    }

    @Override // java.io.InputStream
    public final int available() {
        return (int) (((long) this.f16625b.f4914b) - this.f16624a);
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] r5 = new byte[1];
        int r10 = read(r5, 0, 1);
        Integer r11 = Integer.valueOf(r10);
        if (r10 != (-1)) goto L6;
        r11 = null;
    L6:
        if (r11 != null) goto L8;
        return -1;
    L8:
        return r5[0] & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r10, int r11, int r12) {
        r10.getClass();
        if (r11 < 0) goto L17;
        if (r12 < 0) goto L17;
        if (r12 > (r10.length - r11)) goto L17;
        if (r12 != 0) goto L10;
        return 0;
    L10:
        int r5 = available();
        if (r5 > 0) goto L14;
        return -1;
    L14:
        int r13 = Math.min(r12, r5);
        this.f16626c.b(this.f16624a + this.f16625b.f4913a, r10, r11, r13);
        this.f16624a += (long) r13;
        return r13;
    L17:
        throw new IndexOutOfBoundsException();
    }
}
