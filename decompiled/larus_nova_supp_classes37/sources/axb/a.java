package axb;

import android.app.Application;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.utils.di.d;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.r;
import dxb.c;
import dxb.g;
import dxb.t;
import java.io.IOException;
import java.util.zip.ZipInputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ cxb.a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;

    public final void a() {
        j.e("WebErrorPageUIOptimize", "start try unzip error page");
        int r2 = d.a;
        Application r3 = d.a.a();
        if (r3 != null) goto L6;
        j.e("WebErrorPageUIOptimize", "context not init");
        return;
    L6:
        String r4 = b.b(r3);
        boolean r5 = false;
        if (r4 != null) goto L9;
    L14:
        boolean r6 = false;
    L15:
        if (r6 == false) goto L20;
        j.e("WebErrorPageUIOptimize", "error page exists, jump unzip");
        Runnable r0 = this.a;
        if (r0 == null) goto L36;
        r0.run();
        return;
    L36:
        return;
    L20:
        long r7 = System.currentTimeMillis();
        String r8 = b.a(r3, "lk_error_page");     // Catch: Throwable -> L32
        if (r8 != null) goto L24;
    L25:
        r5 = true;
    L26:
        if (r5 == true) goto L31;
        ZipInputStream r9 = new ZipInputStream(r3.getAssets().open("lk_error_page_html.zip"));     // Catch: Throwable -> L32
        int r10 = r.a;     // Catch: Throwable -> L32
        r.a.c(r9, r8);     // Catch: Throwable -> L32
        j.e("WebErrorPageUIOptimize", "unzip error page cost :" + (System.currentTimeMillis() - r7));     // Catch: Throwable -> L32
        Runnable r1 = this.a;     // Catch: Throwable -> L32
        if (r1 == null) goto L37;
        r1.run();     // Catch: Throwable -> L32
        return;
    L37:
        return;
    L31:
        throw new IOException("outPathString is null");     // Catch: Throwable -> L32
    L24:
        if (r8.length() != 0) goto L26;
    L32:
        th = move-exception;
        int r11 = t.a;
        cxb.a r12 = this.b;
        String r13 = this.c;
        String r14 = "unzip error pag error:" + this.d;
        Intrinsics.checkNotNullParameter(r14, "message");
        g r15 = new g("wb_container_error_page_message", c.m, r12);
        t.c(r15, r13);
        r15.a("error_page_message", r14);
        r15.b();
        j.b("WebErrorPageUIOptimize", "unzip error page error:" + th.getMessage());
        return;
    L9:
        if (r4.length() <= 0) goto L11;
        boolean r16 = true;
    L12:
        if (r16 != true) goto L14;
        r6 = true;
        goto L15
    L11:
        r16 = false;
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(cxb.a r2, String r3) {
        this.a = null;
        this.b = r2;
        this.c = r3;
        this.d = false;
    }
}
