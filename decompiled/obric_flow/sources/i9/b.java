package i9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f17522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f17524c;
    public int d;

    public b(File r5, char r10) {
        this.f17522a = r5;
    }

    public final int a() {
        File r5 = this.f17522a;
        int r10 = -1;
        if (r5.exists() == true) goto L5;
    L39:
        return -1;
    L5:
        if (r5.isFile() == false) goto L39;
        BufferedReader r11 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L28
        int r12 = -1;
    L46:
        String r13 = r11.readLine();     // Catch: Throwable -> L17
        if (r13 == null) goto L27;
        int r14 = this.d;     // Catch: Throwable -> L17
        if (r13.startsWith(this.f17523b) == true) goto L40;
    L23:
        r12 = r14;
    L24:
        if (r12 != (-1)) goto L27;
    L40:
        r14 = Integer.parseInt(r13.split(this.f17524c)[1].trim());     // Catch: Throwable -> L17 NumberFormatException -> L19
    L21:
        if (r14 >= 0) goto L23;
        r12 = -2;
        goto L24
    L19:
        e = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L17
        m.b.h("NPTH_CATCH", e);     // Catch: Throwable -> L17
    L27:
        com.bytedance.android.anniex.base.service.f.h(r11);
        return r12;
    L17:
        th = th;
        r10 = r12;
    L44:
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L35
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L35
        if (r11 == null) goto L34;
        com.bytedance.android.anniex.base.service.f.h(r11);
    L34:
        return r10;
    L35:
        th = move-exception;
        if (r11 == null) goto L38;
        com.bytedance.android.anniex.base.service.f.h(r11);
    L38:
        throw th;
    L28:
        th = th;
        r11 = null;
        goto L44
    }

    public b(File r5, int r10) {
        switch(r10) {
            case 1: goto L7;
            case 2: goto L3;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        this(r5, 0);
        this.f17523b = "Total FD Count:";
        this.f17524c = ":";
        this.d = -2;
        return;
    L5:
        this(r5, 0);
        this.f17523b = "Total Threads Count:";
        this.f17524c = ":";
        this.d = -2;
        return;
    L7:
        this(r5, 0);
        this.f17523b = "VmSize:";
        this.f17524c = "\\s+";
        this.d = -1;
    }
}
