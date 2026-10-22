package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f8095a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f8096b;
    private static a c;

    public interface a {
        void a(long r1);
    }

    static class b implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<Printer> f8097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<Printer> f8098b;
        List<Printer> c;
        boolean d;
        boolean e;

        @Override // android.util.Printer
        public void println(String r10) {
            if (TextUtils.isEmpty(r10) == false) goto L6;
            return;
        L6:
            if (f.a() == null) goto L8;
            long r3 = System.currentTimeMillis();
        L10:
            if (r10.charAt(0) != '>') goto L21;
            if (this.e == false) goto L21;
            Iterator<Printer> r5 = this.c.iterator();
        L15:
            if (r5.hasNext() == false) goto L19;
            Printer r6 = (Printer) ZeusTransformUtils.preCheckCast(r5.next(), Printer.class, "com.obric.memorydata.plugin");
            if (this.f8097a.contains(r6) == true) goto L15;
            this.f8097a.add(r6);
            goto L15
        L19:
            this.c.clear();
            this.e = false;
        L21:
            if (this.f8097a.size() <= f.b()) goto L23;
            Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
        L23:
            Iterator<Printer> r7 = this.f8097a.iterator();
        L25:
            if (r7.hasNext() == false) goto L30;
            Printer r8 = (Printer) ZeusTransformUtils.preCheckCast(r7.next(), Printer.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L25;
            r8.println(r10);
            goto L25
        L30:
            if (r10.charAt(0) != '<') goto L39;
            if (this.d == false) goto L39;
            Iterator<Printer> r11 = this.f8098b.iterator();
        L35:
            if (r11.hasNext() == false) goto L37;
            Printer r9 = (Printer) ZeusTransformUtils.preCheckCast(r11.next(), Printer.class, "com.obric.memorydata.plugin");
            this.f8097a.remove(r9);
            this.c.remove(r9);
            goto L35
        L37:
            this.f8098b.clear();
            this.d = false;
        L39:
            if (f.a() != null) goto L41;
            return;
        L41:
            if (r3 <= 0) goto L56;
            f.a().a(System.currentTimeMillis() - r3);
            return;
        L56:
            return;
        L8:
            r3 = 0;
            goto L10
        }
    }

    static {
    }

    private f() {
    }

    static /* synthetic */ a a() {
        return c;
    }

    static /* synthetic */ int b() {
        return f8095a;
    }
}
