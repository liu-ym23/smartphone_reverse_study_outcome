package d9;

import wc.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16612b;

    @Override // wc.f
    public final boolean f(String r5) {
        if (this.f16612b == true) goto L8;
        if (r5.contains("android.os.Looper.loop") == false) goto L8;
        this.f16612b = true;
    L8:
        return !this.f16612b;
    }
}
