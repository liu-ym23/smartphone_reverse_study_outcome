package com.bytedance.apm6.memory;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
class Tools {
    Tools() {
    }

    private static String convertStreamToString(InputStream r10) {
        StringBuilder r11 = new StringBuilder();
        BufferedReader r12 = null;
        BufferedReader r13 = new BufferedReader(new InputStreamReader(r10));     // Catch: Throwable -> L12
    L16:
        String r14 = r13.readLine();     // Catch: Throwable -> L10
        if (r14 == null) goto L8;
        r11.append(r14);     // Catch: Throwable -> L10
        r11.append('\n');     // Catch: Throwable -> L10
        goto L16
    L8:
        r13.close();
        return r11.toString();
    L10:
        th = th;
        r12 = r13;
    L13:
        if (r12 == null) goto L15;
        r12.close();
    L15:
        throw th;
    L12:
        th = th;
        goto L13
    }

    private static String getStringFromFile(String r10) {
        FileInputStream r11 = new FileInputStream(new File(r10));     // Catch: Throwable -> L9
        String r12 = convertStreamToString(r11);     // Catch: Throwable -> L7
        r11.close();
        return r12;
    L7:
        Throwable th = th;
    L11:
        if (r11 == null) goto L13;
        r11.close();
    L13:
        throw th;
    L9:
        th = move-exception;
        r11 = null;
        th = th;
        goto L11
    }

    static long getVmSize() {
        int r10 = 0;
        String[] r11 = getStringFromFile(String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())})).trim().split("\n");     // Catch: Exception -> L20
        int r12 = r11.length;     // Catch: Exception -> L20
    L5:
        if (r10 >= r12) goto L14;
        String r13 = r11[r10];     // Catch: Exception -> L20
        if (r13.startsWith("VmSize") == false) goto L12;
        Matcher r14 = Pattern.compile("\\d+").matcher(r13);     // Catch: Exception -> L20
        if (r14.find() == false) goto L12;
        return Long.parseLong(r14.group());
    L12:
        r10 = r10 + 1;     // Catch: Exception -> L20
        goto L5
    L14:
        if (r11.length <= 12) goto L19;
        Matcher r15 = Pattern.compile("\\d+").matcher(r11[12]);     // Catch: Exception -> L20
        if (r15.find() == false) goto L19;
        return Long.parseLong(r15.group());
    L19:
        return -1;
    }
}
