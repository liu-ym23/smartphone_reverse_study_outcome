package nd;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    public static class a extends StringWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9531b;

        public a() {
            this.f9530a = 0;
            this.f9531b = false;
        }

        @Override // java.io.StringWriter, java.io.Writer
        public final void write(String r8, int r10, int r11) {
            if (this.f9531b == false) goto L5;
            return;
        L5:
            int r12 = this.f9530a;
            if ((r12 + r11) <= 4000) goto L9;
            this.f9531b = true;
            return;
        L9:
            this.f9530a = r12 + r11;
            super.write(r8, r10, r11);
        }
    }

    public static String a(Throwable r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        Throwable r10 = r8;
    L6:
        if (r10 == null) goto L12;
        if ((r10 instanceof UnknownHostException) == true) goto L9;
        r10 = r10.getCause();
        goto L6
    L9:
        return "ALOG:UnknownHostException";
    L12:
        a r11 = new a();
        PrintWriter r12 = new PrintWriter(r11);
        r8.printStackTrace(r12);     // Catch: Throwable -> L16
    L14:
        r12.flush();
        return r11.toString();
    }
}
