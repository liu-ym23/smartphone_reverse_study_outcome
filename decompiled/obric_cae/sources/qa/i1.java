package qa;

/* JADX INFO: loaded from: classes.dex */
public abstract class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i1 f10519a;

    public i1() {
    }

    public i1(i1 r8) {
        this.f10519a = r8;
    }

    public void a() {
        i1 r8 = this.f10519a;
        if (r8 == null) goto L6;
        r8.a();
        return;
    }

    public void b(int r8) {
        i1 r10 = this.f10519a;
        if (r10 == null) goto L6;
        r10.b(r8);
        return;
    }

    public abstract boolean c();

    public int d() {
        i1 r8 = this.f10519a;
        if (r8 == null) goto L5;
        int r10 = r8.d();
    L7:
        return Math.min(Integer.MAX_VALUE, r10);
    L5:
        r10 = Integer.MAX_VALUE;
        goto L7
    }

    public final boolean e() {
        i1 r8 = this.f10519a;
        if (r8 == null) goto L5;
        boolean r10 = r8.e();
    L6:
        if (r10 == true) goto L10;
        return false;
    L10:
        return c();
    L5:
        r10 = true;
        goto L6
    }
}
