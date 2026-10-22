package com.tom_roush.fontbox.g.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
public class h implements b {
    public h() {
    }

    private String a(String r3) {
        Runtime r2 = Runtime.getRuntime();
        if (r3.startsWith("Windows 9") == false) goto L5;
        String r4 = "command.com /c echo %windir%";
    L6:
        BufferedReader r5 = new BufferedReader(new InputStreamReader(r2.exec(r4).getInputStream(), com.tom_roush.fontbox.g.b.f16026a));
        String r6 = r5.readLine();
        r5.close();
        return r6;
    L5:
        r4 = "cmd.exe /c echo %windir%";
        goto L6
    }

    @Override // com.tom_roush.fontbox.g.a.b
    public List<File> b() {
        ArrayList r0 = new ArrayList();
        String r1 = System.getProperty("env.windir");     // Catch: SecurityException -> L5
    L6:
        String r2 = System.getProperty("os.name");
        if (r1 != null) goto L10;
        r1 = a(r2);     // Catch: Throwable -> L60
    L10:
        if (r1 == null) goto L27;
        if (r1.length() <= 2) goto L27;
        if (r1.endsWith("/") == false) goto L16;
        r1 = r1.substring(0, r1.length() - 1);
    L16:
        File r3 = new File(r1 + File.separator + "FONTS");
        if (r3.exists() == true) goto L19;
    L21:
        File r4 = new File(r1.substring(0, 2) + File.separator + "PSFONTS");
        if (r4.exists() == true) goto L24;
    L64:
        String r10 = System.getenv("LOCALAPPDATA");     // Catch: SecurityException -> L61
        if (r10 == null) goto L59;
        if (r10.isEmpty() == true) goto L59;
        File r5 = new File(r10 + File.separator + "Microsoft" + File.separator + "Windows" + File.separator + "Fonts");     // Catch: SecurityException -> L61
        if (r5.exists() == false) goto L59;
        if (r5.canRead() == false) goto L59;
        r0.add(r5);     // Catch: SecurityException -> L61
    L59:
        return r0;
    L24:
        if (r4.canRead() == false) goto L64;
        r0.add(r4);
        goto L64
    L19:
        if (r3.canRead() == false) goto L21;
        r0.add(r3);
    L27:
        if (r2.endsWith("NT") == false) goto L29;
        String r6 = "WINNT";
    L30:
        char r7 = 'C';
        char r8 = 'C';
    L32:
        if (r8 > 'E') goto L41;
        File r9 = new File(r8 + ParameterizedMessage.ERROR_MSG_SEPARATOR + File.separator + r6 + File.separator + "FONTS");
        if (r9.exists() == false) goto L40;
        if (r9.canRead() == false) goto L40;
        r0.add(r9);     // Catch: SecurityException -> L62
    L40:
        r8 = (char) (r8 + 1);
    L41:
        if (r7 > 'E') goto L64;
        File r11 = new File(r7 + ParameterizedMessage.ERROR_MSG_SEPARATOR + File.separator + "PSFONTS");
        if (r11.exists() == false) goto L49;
        if (r11.canRead() == false) goto L49;
        r0.add(r11);     // Catch: SecurityException -> L63
    L49:
        r7 = (char) (r7 + 1);
        goto L41
    L29:
        r6 = "WINDOWS";
    L5:
        r1 = null;
        goto L6
    }
}
