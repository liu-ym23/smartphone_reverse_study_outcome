package k8;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10134a;

    public d(long r10) {
        this.f10134a = r10;
    }

    public final float a() {
        return Float.intBitsToFloat((int) (this.f10134a >> 32));
    }

    public final float b() {
        return Float.intBitsToFloat((int) (this.f10134a & 4294967295L));
    }
}
