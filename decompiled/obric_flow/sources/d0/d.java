package d0;

import java.io.File;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes.dex */
public final class d implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f16535b;

    public /* synthetic */ d(Object r5, int r10) {
        this.f16534a = r10;
        this.f16535b = r5;
    }

    @Override // d0.r
    public final boolean a(Object r5) {
        switch(this.f16534a) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        g r10 = (g) r5;
        return true;
    L6:
        File r11 = (File) r5;
        return true;
    L10:
        byte[] r12 = (byte[]) r5;
        return true;
    L9:
        return r5.toString().startsWith("data:image");
    }

    @Override // d0.r
    public final q b(Object r5, int r10, int r11, z.f r12) {
        switch(this.f16534a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        g r13 = (g) r5;
        return new q(r13, new y.a((OkHttpClient) this.f16535b, r13));
    L6:
        File r14 = (File) r5;
        int r15 = 2;
        return new q(new p0.b(r14), new a0.b(r15, r14, (c) this.f16535b));
    L8:
        int r16 = 1;
        return new q(new p0.b(r5), new a0.b(r16, r5.toString(), (c) this.f16535b));
    L10:
        byte[] r17 = (byte[]) r5;
        return new q(new p0.b(r17), new m(1, r17, (c) this.f16535b));
    }
}
