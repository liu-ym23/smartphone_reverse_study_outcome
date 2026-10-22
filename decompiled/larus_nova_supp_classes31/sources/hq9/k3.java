package hq9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k3 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public k3() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k3) == true) goto L8;
        return false;
    L8:
        k3 r6 = (k3) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        return "MusicCreateConfig(musicLyricsCustomWordMax=" + this.a + ", musicLyricsCustomWordMin=" + this.b + ", musicLyricsPromptWordMax=" + this.c + ", musicLyricsPromptWordMin=" + this.d + ", saveVideoBlackListStrategy=" + this.e + ')';
    }

    public /* synthetic */ k3(int r7) {
        this(200, 5, 200, 3, 0);
    }

    public k3(int r1, int r2, int r3, int r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
