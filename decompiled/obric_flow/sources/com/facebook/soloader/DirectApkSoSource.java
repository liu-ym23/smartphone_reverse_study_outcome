package com.facebook.soloader;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class DirectApkSoSource extends SoSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f8461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f8462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f8463c;

    public DirectApkSoSource(Context r5) {
        this.f8461a = new HashMap();
        this.f8462b = a("");
        this.f8463c = new File(r5.getApplicationInfo().sourceDir);
    }

    public static HashSet a(String r10) {
        HashSet r5 = new HashSet();
        String r11 = SysUtil.Api14Utils.a();
        if (r11 == null) goto L10;
        String[] r12 = r11.split(":");
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L10;
        String r15 = r12[r14];
        if (r15.contains(r10 + ".apk!/") == false) goto L9;
        r5.add(r15);
    L9:
        r14 = r14 + 1;
    L10:
        return r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(getClass().getName());
        r5.append("[root = ");
        StringBuilder r10 = new StringBuilder("(");
        Iterator r11 = this.f8462b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.append((String) r11.next());
        r10.append(", ");
        goto L4
    L6:
        r10.append(')');
        r5.append(r10.toString());
        r5.append(']');
        return r5.toString();
    }

    public DirectApkSoSource(File r5) {
        this.f8461a = new HashMap();
        String r10 = r5.getName();
        int r11 = r10.lastIndexOf(46);
        if (r11 <= 0) goto L5;
        r10 = r10.substring(0, r11);
    L5:
        this.f8462b = a(r10);
        this.f8463c = r5;
    }

    @Override // com.facebook.soloader.SoSource
    public final void a(int r10) {
        Iterator r11 = this.f8462b.iterator();
        String r5 = null;
    L4:
        if (r11.hasNext() == false) goto L47;
        String r12 = (String) r11.next();
        if (TextUtils.isEmpty(r12) == true) goto L13;
        int r13 = r12.indexOf(33);
        if (r13 < 0) goto L13;
        int r14 = r13 + 2;
        if (r14 >= r12.length()) goto L13;
        r5 = r12.substring(r14);
    L13:
        if (TextUtils.isEmpty(r5) == true) goto L4;
        ZipFile r15 = new ZipFile(this.f8463c);
        Enumeration<? extends ZipEntry> r16 = r15.entries();     // Catch: Throwable -> L39
    L18:
        if (r16.hasMoreElements() == false) goto L41;
        ZipEntry r17 = r16.nextElement();     // Catch: Throwable -> L39
        if (r17 == null) goto L18;
        if (r17.getName().startsWith(r5) == false) goto L18;
        if (r17.getName().endsWith(".so") == false) goto L18;
        if (r17.getMethod() != 0) goto L18;
        String r18 = r17.getName().substring(r5.length() + 1);     // Catch: Throwable -> L39
        monitor-enter(this);     // Catch: Throwable -> L39
        if (this.f8461a.containsKey(r12) == true) goto L34;
        this.f8461a.put(r12, new HashSet());     // Catch: Throwable -> L32
    L34:
        ((Set) this.f8461a.get(r12)).add(r18);     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        goto L18
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L41:
        r15.close();
    L39:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L44
    L46:
        throw th;
    L44:
        th = move-exception;
        th.addSuppressed(th);
        goto L46
    }
}
