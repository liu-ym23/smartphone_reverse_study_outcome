package cja;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public final long a;

    public final float a() {
        return Float.intBitsToFloat((int) (this.a >> 32));
    }

    public final float b() {
        return Float.intBitsToFloat((int) (this.a & 4294967295L));
    }

    public d(long r1) {
        this.a = r1;
    }
}
