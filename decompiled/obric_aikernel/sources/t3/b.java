package t3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public b() {
    }

    public void a(File r10, File r11) {
        b(r10, r11, false);
    }

    public void b(File r10, File r11, boolean r12) {
        long r13 = System.currentTimeMillis();
        Closeable r14 = null;
        if (r12 == false) goto L13;
        c r15 = new c();
        FileInputStream r16 = new FileInputStream(r10);     // Catch: Throwable -> L10
        new g(new BufferedInputStream(r16)).a(new h(r15));     // Catch: Throwable -> L8
        x3.d.b(r16);
        p3.c.c("shrink::step1 cost=" + (System.currentTimeMillis() - r13), new Object[0]);
    L34:
        FileInputStream r17 = new FileInputStream(r10);     // Catch: Throwable -> L23
        BufferedOutputStream r18 = new BufferedOutputStream(new FileOutputStream(r11));     // Catch: Throwable -> L21
        new g(new BufferedInputStream(r17)).a(new h(new i(r18, r15)));     // Catch: Throwable -> L19
        x3.d.b(r18);
        x3.d.b(r17);
        p3.c.c("shrink::total cost=" + (System.currentTimeMillis() - r13), new Object[0]);
        return;
    L19:
        th = th;
        r14 = r18;
    L22:
        r16 = r17;
    L24:
        x3.d.b(r14);
        x3.d.b(r16);
        throw th;
    L21:
        th = th;
    L23:
        th = th;
    L8:
        th = th;
        r14 = r16;
    L11:
        x3.d.b(r14);
        throw th;
    L10:
        th = th;
        goto L11
    L13:
        r15 = null;
        r16 = null;
        goto L34
    }
}
