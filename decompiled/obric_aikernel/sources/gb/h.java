package gb;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9076b;

    public h(int r10) {
        this.f9076b = r10;
    }

    public boolean a(boolean r10) {
        int r11 = this.f9075a;
        if (r11 < this.f9076b) goto L7;
        return false;
    L7:
        if (r10 == false) goto L9;
        this.f9075a = r11 + 1;
    L9:
        return true;
    }
}
