package com.ss.android.socialbase.downloader.d;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f15363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f15364b;
    private int c;
    private boolean d;

    public f(Uri r1, int r2, boolean r3) {
        this.f15363a = r1;
        this.c = r2;
        this.d = r3;
        String r4 = d();
        if (TextUtils.isEmpty(r4) == true) goto L6;
        this.f15364b = new File(r4);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public long a() {
        return b.b(this.f15363a);
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean a(long r2) {
        File r0 = this.f15364b;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.exists() == true) goto L7;
        return false;
    L7:
        return this.f15364b.setLastModified(r2);
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean a(a r1) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean b() {
        return b.c(this.f15363a);
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean c() {
        File r0 = this.f15364b;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isDirectory();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public String d() {
        return b.d(this.f15363a);
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean delete() {
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    L3:
        if (this.d == true) goto L5;
        b.a(this.f15363a);     // Catch: Throwable -> L8
        return false;
    L5:
        return b.a(i());
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean e() {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public File f() {
        return this.f15364b;
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public long g() {
        File r0 = this.f15364b;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.exists() == true) goto L7;
        return 0;
    L7:
        return this.f15364b.lastModified();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public FileInputStream h() {
        if (this.f15363a == null) goto L7;
        return new FileInputStream(b.b(this.f15363a, "r"));
    L7:
        throw new IOException("Fail to obtain InputStream, uri is null");
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public FileOutputStream i() {
        if (this.f15363a == null) goto L7;
        return new FileOutputStream(b.b(this.f15363a, "w"));
    L7:
        throw new IOException("Fail to obtain OutputStream, uri is null");
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public File j() {
        File r0 = this.f15364b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getParentFile();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public String k() {
        File r0 = this.f15364b;
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getAbsolutePath();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public int l() {
        return this.c;
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public String p() {
        return "";
    }
}
