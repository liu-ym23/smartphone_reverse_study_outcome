package kb;

import android.net.Uri;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f10147a;

    public a(String r10, String r11) {
        this(r10, r11, true, true);
    }

    public a(String r10, String r11, boolean r12, boolean r13) {
        int r14 = b.l(r10);
        if (r14 != 1) goto L10;
        this.f10147a = new d(r10, r11, r12);
        return;
    L10:
        Uri r15 = Uri.parse(r10);     // Catch: Throwable -> L7
        b.a(r15, r14);     // Catch: Throwable -> L7
        this.f10147a = new f(r15, r14, r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        this.f10147a = new c(th.toString());
        th.printStackTrace();
    }

    @Override // kb.e
    public String a() {
        return this.f10147a.a();
    }

    @Override // kb.e
    public boolean b() {
        return this.f10147a.b();
    }

    @Override // kb.e
    public File c() {
        return this.f10147a.c();
    }

    @Override // kb.e
    public String d() {
        return this.f10147a.d();
    }

    @Override // kb.e
    public boolean e() {
        return this.f10147a.e();
    }

    @Override // kb.e
    public boolean f(a r10) {
        return this.f10147a.f(r10);
    }

    @Override // kb.e
    public FileInputStream g() {
        return this.f10147a.g();
    }

    @Override // kb.e
    public File getFile() {
        return this.f10147a.getFile();
    }

    @Override // kb.e
    public String getPath() {
        return this.f10147a.getPath();
    }

    @Override // kb.e
    public boolean h() {
        return this.f10147a.h();
    }

    @Override // kb.e
    public int i() {
        return this.f10147a.i();
    }

    @Override // kb.e
    public long j() {
        return this.f10147a.j();
    }

    @Override // kb.e
    public FileOutputStream k() {
        return this.f10147a.k();
    }

    @Override // kb.e
    public boolean l() {
        return this.f10147a.l();
    }

    @Override // kb.e
    public long length() {
        return this.f10147a.length();
    }

    @Override // kb.e
    public boolean m(long r10) {
        return this.f10147a.m(r10);
    }

    public boolean n() {
        if (this.f10147a.i() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean o() {
        if (this.f10147a.i() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean p() {
        int r10 = this.f10147a.i();
        if (r10 != 2) goto L5;
    L12:
        return true;
    L5:
        if (r10 == 3) goto L12;
        if (r10 == 4) goto L12;
        if (r10 == 5) goto L12;
        return false;
    }
}
