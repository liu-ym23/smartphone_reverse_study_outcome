package bp;

import java.io.StringWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends StringWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f968b;

    @Override // java.io.StringWriter, java.io.Writer
    public final void write(String r5, int r10, int r11) {
        if (this.f968b == false) goto L5;
        return;
    L5:
        int r12 = this.f967a + r11;
        if (r12 <= 4000) goto L9;
        this.f968b = true;
        return;
    L9:
        this.f967a = r12;
        super.write(r5, r10, r11);
    }
}
