package tb;

import java.io.File;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RandomAccessFile f12975a;

    public a(File r10) {
        this.f12975a = new RandomAccessFile(r10, "r");
    }

    @Override // tb.b
    public void a(long r10, long r11) {
        this.f12975a.seek(r10);
    }

    @Override // tb.b
    public void close() {
        this.f12975a.close();
    }

    @Override // tb.b
    public long length() {
        return this.f12975a.length();
    }

    @Override // tb.b
    public int read(byte[] r10, int r11, int r12) {
        return this.f12975a.read(r10, r11, r12);
    }
}
