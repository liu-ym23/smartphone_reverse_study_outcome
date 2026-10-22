package io.noties.markwon.a;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f16400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f16401b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f16402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f16403b;

        public a(float r1, String r2) {
            this.f16402a = r1;
            this.f16403b = r2;
        }

        public String toString() {
            return "Dimension{value=" + this.f16402a + ", unit='" + this.f16403b + "'}";
        }
    }

    public h(a r1, a r2) {
        this.f16400a = r1;
        this.f16401b = r2;
    }

    public String toString() {
        return "ImageSize{width=" + this.f16400a + ", height=" + this.f16401b + '}';
    }
}
