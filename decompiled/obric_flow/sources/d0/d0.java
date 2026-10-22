package d0;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0 f16536b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16537a;

    static {
        f16536b = new d0(0);
    }

    public /* synthetic */ d0(int r5) {
        this.f16537a = r5;
    }

    @Override // d0.r
    public final boolean a(Object r5) {
        switch(this.f16537a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        File r10 = (File) r5;
        return true;
    L8:
        return true;
    }

    @Override // d0.r
    public final q b(Object r5, int r10, int r11, z.f r12) {
        switch(this.f16537a) {
            case 0: goto L9;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        return null;
    L6:
        File r13 = (File) r5;
        return new q(new p0.b(r13), new e(r13, 0));
    L9:
        return new q(new p0.b(r5), new e(r5, 1));
    }
}
