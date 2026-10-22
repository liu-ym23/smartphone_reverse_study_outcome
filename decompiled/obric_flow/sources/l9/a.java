package l9;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f19552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19553c;
    public final String d;

    public a(String r5, long r10) {
        this.f19552b = r10;     // Catch: Throwable -> L5
        String[] r11 = r5.split("@");     // Catch: Throwable -> L5
        String r12 = r11[0];     // Catch: Throwable -> L5
        this.d = r11[1];     // Catch: Throwable -> L5
        int r13 = r12.lastIndexOf(".");     // Catch: Throwable -> L5
        this.f19551a = r12.substring(0, r13);     // Catch: Throwable -> L5
        this.f19553c = r12.substring(r13 + 1);     // Catch: Throwable -> L5
        return;
    }
}
