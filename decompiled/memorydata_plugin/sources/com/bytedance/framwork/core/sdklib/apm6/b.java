package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.util.FileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2582b;
    private File c;
    private List<c> d;

    public b(int r3, int r4, List<c> r5) {
        List<c> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.f2581a = r3;
        this.f2582b = r4;
        this.d = r6;
    }

    public static b a(File r2) {
        byte[] r1 = FileUtils.readFileToByteArray(r2);     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        b r3 = a(ByteBuffer.wrap(r1));     // Catch: Throwable -> L12
        if (r3 == null) goto L8;
        r3.c = r2;     // Catch: Throwable -> L12
    L9:
        return r3;
    L8:
        com.bytedance.framwork.core.sdklib.apm6.safety.c.c("APM-SDK", "fromMemory bytes is null");     // Catch: Throwable -> L12
        goto L9
    L10:
        com.bytedance.framwork.core.sdklib.apm6.safety.c.c("APM-SDK", "fromFile bytes is null");     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "fromFile", th);
        return null;
    }

    public static b a(ByteBuffer r15) {
    L15:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "construct LogFile failed.", th);
        return null;
    L4:
        if (r15.getInt() == 1095781686) goto L6;
        return null;
    L6:
        r15.getInt();     // Catch: Throwable -> L15
        int r3 = r15.getInt();     // Catch: Throwable -> L15
        int r4 = r15.getInt();     // Catch: Throwable -> L15
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L15
        int r6 = 0;
        int r7 = 0;
    L7:
        if (r6 >= r3) goto L14;
        int r8 = r15.getInt();     // Catch: Throwable -> L15
        r7 = r7 + r8;     // Catch: Throwable -> L15
        if (r7 > r4) goto L10;
        long r10 = r15.getLong();     // Catch: Throwable -> L15
        long r12 = r15.getLong();     // Catch: Throwable -> L15
        byte[] r9 = new byte[r8];     // Catch: Throwable -> L15
        r15.get(r9);     // Catch: Throwable -> L15
        r5.add(new c(r9, r10, r12));     // Catch: Throwable -> L15
        r6 = r6 + 1;     // Catch: Throwable -> L15
        goto L7
    L10:
        com.bytedance.framwork.core.sdklib.apm6.safety.c.c("APM-SDK", "construct LogFile failed.");     // Catch: Throwable -> L15
        return null;
    L14:
        return new b(r3, r4, r5);
    }

    public int a() {
        return this.f2582b;
    }

    public List<c> b() {
        return this.d;
    }

    public File c() {
        return this.c;
    }

    public String toString() {
        return "LogFile{totalCount=" + this.f2581a + ", totalBytes=" + this.f2582b + ", source=" + this.c + ", logList=" + this.d + '}';
    }
}
