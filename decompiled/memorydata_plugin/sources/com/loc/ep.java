package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ep extends am {
    Map<String, String> h;
    String i;
    String j;
    byte[] k;
    byte[] l;
    boolean m;
    String n;
    Map<String, String> o;
    boolean p;
    private String q;

    public ep(Context r3, fw r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
        this.h = null;
        this.q = "";
        this.i = "";
        this.j = "";
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = null;
        this.o = null;
        this.p = false;
    }

    @Override // com.loc.bo
    public final Map<String, String> a() {
        return this.h;
    }

    public final void a(Map<String, String> r3) {
        this.o = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.loc.am, com.loc.bo
    public final Map<String, String> b() {
        return this.o;
    }

    public final void b(String r1) {
        this.n = r1;
    }

    public final void b(Map<String, String> r3) {
        this.h = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public final void b(boolean r1) {
        this.m = r1;
    }

    public final void b(byte[] r3) {
        ByteArrayOutputStream r0 = null;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L14
        if (r3 != null) goto L31;
    L6:
        this.l = r1.toByteArray();     // Catch: Throwable -> L12
        r1.close();     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        th = th;
        r0 = r1;
    L33:
        th.printStackTrace();     // Catch: Throwable -> L22
        if (r0 == null) goto L41;
        r0.close();     // Catch: IOException -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L41:
        return;
    L22:
        th = move-exception;
        if (r0 != null) goto L29;
    L28:
        throw th;
    L29:
        r0.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L31:
        r1.write(a(r3));     // Catch: Throwable -> L12
        r1.write(r3);     // Catch: Throwable -> L12
    L14:
        th = th;
        goto L33
    }

    @Override // com.loc.bo
    public final String c() {
        return this.i;
    }

    public final void c(String r1) {
        this.i = r1;
    }

    public final void c(boolean r1) {
        this.p = r1;
    }

    public final void c(byte[] r1) {
        this.k = r1;
    }

    public final void d(String r1) {
        this.j = r1;
    }

    public final void e(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.q = r2;
        return;
    L6:
        this.q = "";
    }

    @Override // com.loc.bo
    public final String f() {
        return "loc";
    }

    @Override // com.loc.am
    public final boolean g() {
        return this.m;
    }

    @Override // com.loc.am
    public final String h() {
        return this.n;
    }

    @Override // com.loc.am
    public final byte[] j() {
        return this.k;
    }

    @Override // com.loc.am
    public final byte[] k() {
        return this.l;
    }

    @Override // com.loc.am
    public final boolean l() {
        return this.p;
    }

    @Override // com.loc.bo
    public final String o() {
        return this.q;
    }

    @Override // com.loc.fs, com.loc.bo
    public final String p() {
        return this.j;
    }
}
