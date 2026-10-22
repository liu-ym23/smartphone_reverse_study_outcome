package kb;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f10153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f10154b;

    public d(String r10, String r11, boolean r12) {
        this.f10154b = true;
        if (TextUtils.isEmpty(r11) == true) goto L5;
        this.f10153a = new File(r10, r11);
    L6:
        if (r12 == false) goto L9;
        this.f10154b = com.ss.android.socialbase.downloader.utils.a.p(r10);
        return;
    L9:
        return;
    L5:
        this.f10153a = new File(r10);
        goto L6
    }

    @Override // kb.e
    public String a() {
        return "";
    }

    @Override // kb.e
    public boolean b() {
        return this.f10153a.canWrite();
    }

    @Override // kb.e
    public File c() {
        return this.f10153a.getParentFile();
    }

    @Override // kb.e
    public String d() {
        return this.f10153a.getAbsolutePath();
    }

    @Override // kb.e
    public boolean e() {
        return this.f10153a.isDirectory();
    }

    @Override // kb.e
    public boolean f(a r10) {
        return this.f10153a.renameTo(r10.getFile());
    }

    @Override // kb.e
    public FileInputStream g() {
        if (this.f10153a.isFile() == false) goto L7;
        return new FileInputStream(this.f10153a);
    L7:
        throw new IOException(this.f10153a.getAbsolutePath() + " Fail to obtain InputStream, file type error");
    }

    @Override // kb.e
    public File getFile() {
        return this.f10153a;
    }

    @Override // kb.e
    public String getPath() {
        return this.f10153a.getPath();
    }

    @Override // kb.e
    public boolean h() {
        return this.f10153a.exists();
    }

    @Override // kb.e
    public int i() {
        return 1;
    }

    @Override // kb.e
    public long j() {
        return this.f10153a.lastModified();
    }

    @Override // kb.e
    public FileOutputStream k() {
        return new FileOutputStream(this.f10153a);
    }

    @Override // kb.e
    public boolean l() {
        if (this.f10154b == true) goto L7;
        return true;
    L7:
        return this.f10153a.delete();
    }

    @Override // kb.e
    public long length() {
        return this.f10153a.length();
    }

    @Override // kb.e
    public boolean m(long r10) {
        return this.f10153a.setLastModified(r10);
    }
}
