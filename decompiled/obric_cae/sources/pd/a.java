package pd;

import android.annotation.SuppressLint;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import r5.f;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi", "CI_InlinedApi", "CI_NewApi", "InlinedApi"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f9990a;

    public static String a() {
        String r8 = f9990a;
        if (f.b(r8) == true) goto L5;
        return r8;
    L5:
        String r10 = null;
        Process.myPid();     // Catch: Exception -> L8
        throw null;     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        BufferedReader r11 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L20
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L26
    L12:
        int r13 = r11.read();     // Catch: Throwable -> L26
        if (r13 <= 0) goto L16;
        r12.append((char) r13);     // Catch: Throwable -> L26
        goto L12
    L16:
        if (Logger.debug() == false) goto L18;
        Logger.d("Process", "get processName = " + r12.toString());     // Catch: Throwable -> L26
    L18:
        r10 = r12.toString();     // Catch: Throwable -> L26
    L33:
        r11.close();     // Catch: Exception -> L25
    L23:
        f9990a = r10;
        return r10;
    L21:
        if (r11 == null) goto L23;
    L20:
        r11 = null;
        goto L21
    }
}
