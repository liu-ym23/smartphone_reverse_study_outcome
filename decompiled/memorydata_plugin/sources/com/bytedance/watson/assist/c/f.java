package com.bytedance.watson.assist.c;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3382b;
    private List<List<File>> c;
    private int d;
    private List<Integer> e;

    public f() {
        super("");
        this.f3382b = false;
        this.c = new ArrayList();
        this.d = -1;
    }

    private b a(List<List<File>> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.isEmpty() == true) goto L21;
        com.bytedance.watson.assist.b.c.a r0 = new com.bytedance.watson.assist.b.c.a();
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        List<Long> r2 = b((List) ZeusTransformUtils.preCheckCast(r7.next(), List.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L9;
        r0.a(r2);
        goto L9
    L13:
        return r0;
    L21:
        return null;
    }

    private List<Long> b(List<File> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        ArrayList r8 = new ArrayList();
        Iterator r9 = r6.iterator();
    L4:
        if (r9.hasNext() == false) goto L24;
        BufferedReader r1 = com.bytedance.watson.assist.d.c.a((File) ZeusTransformUtils.preCheckCast(r9.next(), File.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L7;
    L25:
        String r2 = r1.readLine();     // Catch: Throwable -> L17 Exception -> L19
        if (r2 == null) goto L16;
        if (r2.isEmpty() == true) goto L16;
        r8.add(Long.valueOf(Long.parseLong(r2) / 1000));     // Catch: Throwable -> L17 Exception -> L19
    L16:
        com.bytedance.watson.assist.d.c.a(r1);
    L19:
        e = move-exception;
        com.bytedance.watson.assist.d.b.d(Log.getStackTraceString(e));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        com.bytedance.watson.assist.d.c.a(r1);
        throw th;
    L7:
        return null;
    L24:
        return r8;
    }

    @Override // com.bytedance.watson.assist.c.a
    public b a() {
        if (this.f3382b == true) goto L6;
        this.d = com.bytedance.watson.assist.d.a.a();
        this.e = com.bytedance.watson.assist.d.a.b();
        this.f3382b = true;
    L6:
        if (this.e != null) goto L10;
        return null;
    L10:
        if (this.c.isEmpty() == false) goto L18;
        int r1 = 0;
    L13:
        if (r1 >= this.d) goto L18;
        int r2 = ((Integer) ZeusTransformUtils.preCheckCast(this.e.get(r1), Integer.class, "com.obric.memorydata.plugin")).intValue();
        ArrayList r3 = new ArrayList();
        int r4 = 0;
    L15:
        if (r4 >= r2) goto L17;
        r3.add(new File("/sys/devices/system/cpu/cpu" + r1 + "/cpuidle/state" + r4 + "/time"));
        r4 = r4 + 1;
        goto L15
    L17:
        this.c.add(r3);
        r1 = r1 + 1;
    L18:
        this.f3379a = a(this.c);
        return this.f3379a;
    }
}
