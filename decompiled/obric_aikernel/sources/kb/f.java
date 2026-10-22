package kb;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f10155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f10156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10158d;

    public f(Uri r10, int r11, boolean r12) {
        this.f10155a = r10;
        this.f10157c = r11;
        this.f10158d = r12;
        String r13 = getPath();
        if (TextUtils.isEmpty(r13) == true) goto L6;
        this.f10156b = new File(r13);
        return;
    }

    @Override // kb.e
    public String a() {
        return "";
    }

    @Override // kb.e
    public boolean b() {
        return true;
    }

    @Override // kb.e
    public File c() {
        File r10 = this.f10156b;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getParentFile();
    }

    @Override // kb.e
    public String d() {
        File r10 = this.f10156b;
        if (r10 != null) goto L5;
        return "";
    L5:
        return r10.getAbsolutePath();
    }

    @Override // kb.e
    public boolean e() {
        File r10 = this.f10156b;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.isDirectory();
    }

    @Override // kb.e
    public boolean f(a r10) {
        return false;
    }

    @Override // kb.e
    public FileInputStream g() {
        if (this.f10155a == null) goto L7;
        return new FileInputStream(b.h(this.f10155a, "r"));
    L7:
        throw new IOException("Fail to obtain InputStream, uri is null");
    }

    @Override // kb.e
    @Nullable
    public File getFile() {
        return this.f10156b;
    }

    @Override // kb.e
    public String getPath() {
        return b.i(this.f10155a);
    }

    @Override // kb.e
    public boolean h() {
        return b.e(this.f10155a);
    }

    @Override // kb.e
    public int i() {
        return this.f10157c;
    }

    @Override // kb.e
    public long j() {
        File r10 = this.f10156b;
        if (r10 != null) goto L5;
        return 0;
    L5:
        if (r10.exists() == true) goto L7;
        return 0;
    L7:
        return this.f10156b.lastModified();
    }

    @Override // kb.e
    public FileOutputStream k() {
        if (this.f10155a == null) goto L7;
        return new FileOutputStream(b.h(this.f10155a, "w"));
    L7:
        throw new IOException("Fail to obtain OutputStream, uri is null");
    }

    @Override // kb.e
    public boolean l() {
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    L3:
        if (this.f10158d == true) goto L5;
        b.c(this.f10155a);     // Catch: Throwable -> L8
        return false;
    L5:
        return b.d(k());
    }

    @Override // kb.e
    public long length() {
        return b.j(this.f10155a);
    }

    @Override // kb.e
    public boolean m(long r10) {
        File r11 = this.f10156b;
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.exists() == true) goto L7;
        return false;
    L7:
        return this.f10156b.setLastModified(r10);
    }
}
