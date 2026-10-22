package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.tencent.tauth.Tencent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class a extends Tracer implements Handler.Callback {
    private b a;
    private FileWriter b;
    private FileWriter c;
    private File d;
    private File e;
    private char[] f;
    private volatile f g;
    private volatile f h;
    private volatile f i;
    private volatile f j;
    private volatile boolean k;
    private HandlerThread l;
    private Handler m;

    private void j() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.i != this.g) goto L6;
        this.i = this.h;     // Catch: Throwable -> L9
        this.j = this.g;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L6:
        this.i = this.g;     // Catch: Throwable -> L9
        this.j = this.h;     // Catch: Throwable -> L9
        goto L7
    }

    private void h() {
        FileWriter r0 = this.b;     // Catch: IOException -> L6
        if (r0 == null) goto L11;
        r0.flush();     // Catch: IOException -> L6
        this.b.close();     // Catch: IOException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        SLog.e(SLog.TAG, "-->closeFileWriter() exception:", e);
    }

    private void i() {
        FileWriter r0 = this.c;     // Catch: IOException -> L6
        if (r0 == null) goto L11;
        r0.flush();     // Catch: IOException -> L6
        this.c.close();     // Catch: IOException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        SLog.e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e);
    }

    public void a() {
        if (this.m.hasMessages(1024) == false) goto L5;
        this.m.removeMessages(1024);
    L5:
        this.m.sendEmptyMessage(1024);
    }

    private void f() {
        if (ThreadMethodProxy.currentThread() == this.l) goto L6;
        return;
    L6:
        if (this.k == false) goto L8;
        return;
    L8:
        this.k = true;
        j();
        this.j.a(g(), this.f);     // Catch: Throwable -> L11 IOException -> L13
    L10:
        this.j.b();
        this.k = false;
        return;
    L13:
        e = move-exception;
        SLog.e("FileTracer", "flushBuffer exception", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.j.b();
        throw th;
    }

    private Writer[] g() {
        File[] r0 = c().a();
        if (r0 == null) goto L30;
        if (r0.length < 2) goto L30;
        File r4 = r0[0];
        if (r4 == null) goto L11;
        if (r4.equals(this.d) == true) goto L11;
    L13:
        this.d = r4;
        h();
        this.b = new PolarisFileWriterWrapper(this.d, true);     // Catch: IOException -> L16
    L17:
        File r1 = r0[1];
        if (r1 == null) goto L22;
        if (r1.equals(this.e) == true) goto L22;
    L24:
        this.e = r1;
        i();
        this.c = new PolarisFileWriterWrapper(this.e, true);     // Catch: IOException -> L27
    L28:
        a(r1);
    L27:
        this.c = null;
        SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
    L22:
        if (this.c != null) goto L30;
        if (r1 == null) goto L30;
    L16:
        this.b = null;
        SLog.e(SLog.TAG, "-->obtainFileWriter() old log file permission denied");
    L11:
        if (this.b != null) goto L17;
        if (r4 == null) goto L17;
    L30:
        return new Writer[]{this.b, this.c};
    }

    public void b() {
        h();
        i();
        this.l.quit();
    }

    public b c() {
        return this.a;
    }

    public a(b r4) {
        this(c.b, true, g.a, r4);
    }

    private void a(File r10) {
        File r11 = r10.getParentFile();
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.exists() == true) goto L7;
        return;
    L7:
        if (r11.isDirectory() == false) goto L32;
        File[] r12 = r11.listFiles();
        if (r12 != null) goto L12;
        return;
    L12:
        int r0 = r12.length;
        int r1 = 0;
    L13:
        if (r1 >= r0) goto L33;
        File r2 = r12[r1];
        if (b(r2) == false) goto L25;
        String r3 = r2.getName();
        String r4 = r3.substring(32, 43);
        long r5 = System.currentTimeMillis();
        if (Tencent.USE_ONE_HOUR == false) goto L20;
        long r7 = 3600000;
    L22:
        if (b.a(r5 - r7).compareTo(r4) <= 0) goto L25;
        SLog.d("FileTracer", "delete name=" + r3 + ", success=" + r2.delete());
        goto L25
    L20:
        r7 = 259200000;
    L25:
        r1 = r1 + 1;
        goto L13
    L33:
        return;
    }

    private boolean b(File r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String r5 = r4.getName();
        SLog.d("FileTracer", "name=" + r5);
        if (TextUtils.isEmpty(r5) == false) goto L9;
        return false;
    L9:
        if (r5.length() == 47) goto L12;
        return false;
    L12:
        if (r5.startsWith("com.tencent.mobileqq_connectSdk.") == true) goto L14;
        return false;
    L14:
        if (r5.endsWith(".log") == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        if (r2.what != 1024) goto L8;
        f();
        return true;
    L8:
        return true;
    }

    private void a(String r2) {
        this.i.a(r2);
        if (this.i.a() < c().d()) goto L6;
        a();
        return;
    }

    public void a(b r1) {
        this.a = r1;
    }

    public a(int r1, boolean r2, g r3, b r4) {
        super(r1, r2, r3);
        this.k = false;
        a(r4);
        this.g = new f();
        this.h = new f();
        this.i = this.g;
        this.j = this.h;
        this.f = new char[r4.d()];
        PthreadHandlerThreadV2 r5 = new PthreadHandlerThreadV2(r4.c(), r4.f());
        this.l = r5;
        ThreadMethodProxy.start(r5);
        if (ThreadMethodProxy.isAlive(this.l) == true) goto L5;
        return;
    L5:
        if (this.l.getLooper() == null) goto L9;
        this.m = new Handler(this.l.getLooper(), this);
        return;
    }

    @Override // com.tencent.open.log.Tracer
    public void doTrace(int r9, Thread r10, long r11, String r13, String r14, Throwable r15) {
        a(e().a(r9, r10, r11, r13, r14, r15));
    }
}
