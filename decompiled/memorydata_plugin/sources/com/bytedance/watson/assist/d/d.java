package com.bytedance.watson.assist.d;

import android.os.Process;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f3391a = -1;

    static {
    }

    public static ArrayList<Long> a() {
        return a("/proc/self/task/");
    }

    private static ArrayList<Long> a(String r5) {
        ArrayList<Long> r0 = new ArrayList();
        File[] r6 = new File(r5).listFiles(new AnonymousClass1());
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(Long.valueOf(Long.parseLong(r6[r2].getName())));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static int b() {
        if (f3391a != (-1)) goto L6;
        f3391a = Process.myPid();
    L6:
        return f3391a;
    }
}
