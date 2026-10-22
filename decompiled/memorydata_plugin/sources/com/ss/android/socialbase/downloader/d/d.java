package com.ss.android.socialbase.downloader.d;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f15361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15362b;

    public d(String r2, String r3, boolean r4) {
        this.f15362b = true;
        if (TextUtils.isEmpty(r3) == true) goto L5;
        this.f15361a = new File(r2, r3);
    L6:
        if (r4 == false) goto L9;
        this.f15362b = com.ss.android.socialbase.downloader.utils.a.a(r2);
        return;
    L9:
        return;
    L5:
        this.f15361a = new File(r2);
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public long a() {
        return this.f15361a.length();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean a(long r1) {
        return this.f15361a.setLastModified(r1);
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean a(a r1) {
        return this.f15361a.renameTo(r1.f());
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean b() {
        return this.f15361a.exists();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean c() {
        return this.f15361a.isDirectory();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public String d() {
        return this.f15361a.getPath();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean delete() {
        if (this.f15362b == true) goto L7;
        return true;
    L7:
        return this.f15361a.delete();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public boolean e() {
        return this.f15361a.canWrite();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public File f() {
        return this.f15361a;
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public long g() {
        return this.f15361a.lastModified();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public FileInputStream h() {
        if (this.f15361a.isFile() == false) goto L7;
        return new FileInputStream(this.f15361a);
    L7:
        throw new IOException(this.f15361a.getAbsolutePath() + " Fail to obtain InputStream, file type error");
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public FileOutputStream i() {
        return new FileOutputStream(this.f15361a);
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public File j() {
        return this.f15361a.getParentFile();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public String k() {
        return this.f15361a.getAbsolutePath();
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public int l() {
        return 1;
    }

    @Override // com.ss.android.socialbase.downloader.d.e
    public String p() {
        return "";
    }
}
