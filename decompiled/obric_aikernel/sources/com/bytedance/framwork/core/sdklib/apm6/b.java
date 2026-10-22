package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.util.FileUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f1900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<c> f1901d;

    public b(int r10, int r11, List<c> r12) {
        this.f1898a = r10;
        this.f1899b = r11;
        this.f1901d = r12;
    }

    public static b a(File r10) {
        byte[] r11 = FileUtils.readFileToByteArray(r10);     // Catch: Throwable -> L12
        if (r11 == null) goto L10;
        b r12 = b(ByteBuffer.wrap(r11));     // Catch: Throwable -> L12
        if (r12 == null) goto L8;
        r12.f1900c = r10;     // Catch: Throwable -> L12
    L9:
        return r12;
    L8:
        j3.c.b("APM-SDK", "fromMemory bytes is null");     // Catch: Throwable -> L12
        goto L9
    L10:
        j3.c.b("APM-SDK", "fromFile bytes is null");     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        j3.c.c("APM-SDK", "fromFile", th);
        return null;
    }

    public static b b(ByteBuffer r15) {
    L15:
        th = move-exception;
        j3.c.c("APM-SDK", "construct LogFile failed.", th);
        return null;
    L4:
        if (r15.getInt() == 1095781686) goto L6;
        return null;
    L6:
        r15.getInt();     // Catch: Throwable -> L15
        int r10 = r15.getInt();     // Catch: Throwable -> L15
        int r11 = r15.getInt();     // Catch: Throwable -> L15
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L15
        int r13 = 0;
        int r14 = 0;
    L7:
        if (r13 >= r10) goto L14;
        int r16 = r15.getInt();     // Catch: Throwable -> L15
        r14 = r14 + r16;     // Catch: Throwable -> L15
        if (r14 > r11) goto L10;
        long r17 = r15.getLong();     // Catch: Throwable -> L15
        long r18 = r15.getLong();     // Catch: Throwable -> L15
        byte[] r19 = new byte[r16];     // Catch: Throwable -> L15
        r15.get(r19);     // Catch: Throwable -> L15
        r12.add(new c(r19, r17, r18));     // Catch: Throwable -> L15
        r13 = r13 + 1;     // Catch: Throwable -> L15
        goto L7
    L10:
        j3.c.b("APM-SDK", "construct LogFile failed.");     // Catch: Throwable -> L15
        return null;
    L14:
        return new b(r10, r11, r12);
    }

    public List<c> c() {
        return this.f1901d;
    }

    public File d() {
        return this.f1900c;
    }

    public int e() {
        return this.f1899b;
    }

    public String toString() {
        return "LogFile{totalCount=" + this.f1898a + ", totalBytes=" + this.f1899b + ", source=" + this.f1900c + ", logList=" + this.f1901d + '}';
    }
}
