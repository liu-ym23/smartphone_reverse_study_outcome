package kq9;

import com.larus.platform.model.album.FastSendFromCameraScene;
import com.larus.platform.model.album.FastSendFromShowType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o {
    public final int a;
    public final int b;
    public final int c;

    public o() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "FastSendFromCameraAlbumThumbConfig(scene=" + this.a + ", showType=" + this.b + ", showCount=" + this.c + ')';
    }

    public /* synthetic */ o(int r3) {
        this(FastSendFromCameraScene.DEFAULT.getScene(), FastSendFromShowType.EVERY_COLD_LAUNCH.getType(), 0);
    }

    public o(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
