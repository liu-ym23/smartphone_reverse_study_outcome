package ek;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import ko.r;
import sj.k;
import ug.e;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f16826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f16827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zm.c f16828c;
    public final AtomicBoolean d;
    public volatile boolean e;
    public final sg.a f;
    public final k g;

    public d(ck.a r5, OutputStream r10, zm.c r11) {
        this.d = new AtomicBoolean(false);
        this.f = new sg.a(this);
        this.g = new k(this, false);
        this.f16826a = new r(r5);
        this.f16827b = new e(r10);
        this.f16828c = r11;
    }

    public final void a(a r5) {
        if (this.d.get() == true) goto L6;
        b(new IOException("Session is closed"));
        return;
    L6:
        e r10 = this.f16827b;
        k r11 = this.g;
        monitor-enter(r10);
        r5.a((BufferedOutputStream) r10.f22361b);     // Catch: Throwable -> L11 IOException -> L13
        ((BufferedOutputStream) r10.f22361b).flush();     // Catch: Throwable -> L11 IOException -> L13
        r11.getClass();     // Catch: Throwable -> L11 IOException -> L13
        monitor-exit(r10);
        return;
    L11:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        ((d) r11.f21937a).b(e);     // Catch: Throwable -> L11
    }

    public final void b(IOException r5) {
        zm.c r10 = this.f16828c;
        r10.getClass();
        Log.e("ChromeDevtoolsServer", r5.getMessage());
        ((bk.c) r10.f23470b).a();
    }

    public final void c(String r5) {
        if (this.d.getAndSet(false) == false) goto L6;
        zm.c r10 = this.f16828c;
        r10.getClass();
        Log.w("ChromeDevtoolsServer", "onClose: " + r5);
        ((bk.c) r10.f23470b).a();
        return;
    }
}
