package p6;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class p extends o6.a {
    public p() {
    }

    @Override // o6.a
    public String f() {
        return "sp";
    }

    @Override // o6.a
    public synchronized boolean g(n6.a r10) {
        monitor-enter(this);
        File r11 = r6.g.a(k6.a.k().i());     // Catch: Throwable -> L11
        if (r11 != null) goto L8;
        k("sp文件拷贝失败", r10);     // Catch: Throwable -> L11
        monitor-exit(this);
        return true;
    L8:
        t6.b.b().e(r10, r11.getParentFile(), "default_sp_file_type");     // Catch: Throwable -> L11
        monitor-exit(this);
        return true;
    L11:
        th = move-exception;
        throw th;
    }
}
