package m5;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f11045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f11047c;

    public a(String r10) {
        this.f11045a = null;
        this.f11046b = null;
        this.f11047c = null;
        this.f11046b = r10;
    }

    protected b a(File r10) {
        return null;
    }

    public b b() {
        if (this.f11046b != null) goto L7;
        n5.b.g("refresh and path null");
        return null;
    L7:
        if (this.f11047c != null) goto L9;
        this.f11047c = new File(this.f11046b);
    L9:
        b r10 = a(this.f11047c);
        this.f11045a = r10;
        return r10;
    }

    public String toString() {
        return "BaseStatFile{mPath='" + this.f11046b + "', mFile=" + this.f11047c + ", mLastInfo=" + this.f11045a + '}';
    }
}
