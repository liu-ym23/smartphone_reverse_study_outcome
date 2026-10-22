package com.ss.android.socialbase.downloader.d;

import android.net.Uri;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f15356a;

    public a(String r2, String r3) {
        this(r2, r3, true, true);
    }

    public a(String r3, String r4, boolean r5, boolean r6) {
        int r0 = b.c(r3);
        if (r0 != 1) goto L10;
        this.f15356a = new d(r3, r4, r5);
        return;
    L10:
        Uri r7 = Uri.parse(r3);     // Catch: Throwable -> L7
        b.a(r7, r0);     // Catch: Throwable -> L7
        this.f15356a = new f(r7, r0, r6);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        this.f15356a = new c(th.toString());
        th.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public long a() {
        return this.f15356a.a();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean a(long r1) {
        return this.f15356a.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean a(a r1) {
        return this.f15356a.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean b() {
        return this.f15356a.b();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean c() {
        return this.f15356a.c();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public String d() {
        return this.f15356a.d();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean delete() {
        return this.f15356a.delete();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean e() {
        return this.f15356a.e();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public File f() {
        return this.f15356a.f();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public long g() {
        return this.f15356a.g();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public FileInputStream h() {
        return this.f15356a.h();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public FileOutputStream i() {
        return this.f15356a.i();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public File j() {
        return this.f15356a.j();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public String k() {
        return this.f15356a.k();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public int l() {
        return this.f15356a.l();
    }

    public boolean m() {
        if (this.f15356a.l() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean n() {
        int r1 = this.f15356a.l();
        if (r1 != 2) goto L5;
    L12:
        return true;
    L5:
        if (r1 == 3) goto L12;
        if (r1 == 4) goto L12;
        if (r1 == 5) goto L12;
        return false;
    }

    public boolean o() {
        if (this.f15356a.l() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public String p() {
        return this.f15356a.p();
    }
}
