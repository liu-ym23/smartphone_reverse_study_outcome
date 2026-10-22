package com.tom_roush.pdfbox.contentstream;

import android.util.Log;
import com.tom_roush.pdfbox.a.k;
import com.tom_roush.pdfbox.a.o;
import com.tom_roush.pdfbox.contentstream.operator.MissingOperandException;
import com.tom_roush.pdfbox.contentstream.operator.c;
import com.tom_roush.pdfbox.contentstream.operator.state.EmptyGraphicsStackException;
import com.tom_roush.pdfbox.filter.MissingImageReaderException;
import com.tom_roush.pdfbox.pdmodel.MissingResourceException;
import com.tom_roush.pdfbox.pdmodel.common.h;
import com.tom_roush.pdfbox.pdmodel.font.aa;
import com.tom_roush.pdfbox.pdmodel.font.ac;
import com.tom_roush.pdfbox.pdmodel.font.ad;
import com.tom_roush.pdfbox.pdmodel.font.p;
import com.tom_roush.pdfbox.pdmodel.g;
import com.tom_roush.pdfbox.pdmodel.graphics.state.d;
import com.tom_roush.pdfbox.pdmodel.i;
import com.tom_roush.pdfbox.util.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, c> f16092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.tom_roush.pdfbox.util.c f16093b;
    private com.tom_roush.pdfbox.util.c c;
    private Deque<com.tom_roush.pdfbox.pdmodel.graphics.state.b> d;
    private i e;
    private g f;
    private boolean g;
    private com.tom_roush.pdfbox.util.c h;
    private int i;

    public b() {
        this.f16092a = new HashMap(80);
        this.d = new ArrayDeque();
        this.i = 0;
    }

    private void a(a r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        i r0 = c(r8);
        Deque<com.tom_roush.pdfbox.pdmodel.graphics.state.b> r1 = e();
        com.tom_roush.pdfbox.util.c r2 = this.h;
        com.tom_roush.pdfbox.pdmodel.graphics.state.b r3 = g();
        r3.a().a(r8.c());
        this.h = r3.a().b();
        a(r8.b());
        b(r8);     // Catch: Throwable -> L6
        this.h = r2;
        a(r1);
        a(r0);
        return;
    L6:
        th = move-exception;
        this.h = r2;
        a(r1);
        a(r0);
        throw th;
    }

    private void a(h r2) {
        if (r2 == null) goto L5;
        com.tom_roush.pdfbox.pdmodel.graphics.state.b r1 = g();
        r1.a(r2.a(r1.a()));
        return;
    }

    private void a(i r1) {
        this.e = r1;
    }

    private void b(a r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        com.tom_roush.pdfbox.pdfparser.g r2 = new com.tom_roush.pdfbox.pdfparser.g(r6);
    L3:
        Object r7 = r2.r();
        if (r7 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r7, com.tom_roush.pdfbox.contentstream.operator.b.class) == true) goto L7;
        r0.add((com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r7, com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin"));
        goto L3
    L7:
        a((com.tom_roush.pdfbox.contentstream.operator.b) ZeusTransformUtils.preCheckCast(r7, com.tom_roush.pdfbox.contentstream.operator.b.class, "com.obric.memorydata.plugin"), r0);
        r0.clear();
        goto L3
    }

    private void b(g r4) {
        if (r4 == null) goto L6;
        this.f = r4;
        this.d.clear();
        this.d.push(new com.tom_roush.pdfbox.pdmodel.graphics.state.b(r4.h()));
        this.f16093b = null;
        this.c = null;
        this.e = null;
        this.h = r4.c();
        return;
    L6:
        throw new IllegalArgumentException("Page cannot be null");
    }

    private i c(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        i r0 = this.e;
        i r5 = r4.getResources();
        if (r5 == null) goto L6;
    L4:
        this.e = r5;
    L11:
        return r0;
    L6:
        if (this.e != null) goto L11;
        i r6 = this.f.getResources();
        this.e = r6;
        if (r6 != null) goto L11;
        r5 = new i();
        goto L4
    }

    public void a() {
    }

    public void a(float r1, float r2) {
        this.f16093b.a(com.tom_roush.pdfbox.util.c.b(r1, r2));
    }

    public void a(com.tom_roush.pdfbox.a.a r9) {
        d r0 = g().b();
        float r1 = r0.f();
        float r2 = r0.c() / 100.0f;
        p r3 = r0.e();
        if (r3 == null) goto L5;
        boolean r4 = r3.l();
    L6:
        Iterator<com.tom_roush.pdfbox.a.b> r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L24;
        com.tom_roush.pdfbox.a.b r5 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r10.next(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.a.class) == false) goto L22;
        StringBuilder r6 = new StringBuilder();
        String r7 = "Nested arrays are not allowed in an array for TJ operation: ";
    L23:
        Log.e("PdfBox-Android", r6.append(r7).append(r5).toString());
        goto L8
    L22:
        r6 = new StringBuilder().append("Unknown type ").append(r5.getClass().getSimpleName());
        r7 = " in array for TJ operation: ";
        goto L23
    L18:
        b(((o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.memorydata.plugin")).b());
        goto L8
    L11:
        float r8 = 0.0f;
        float r11 = ((-((k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.memorydata.plugin")).a()) / 1000.0f) * r1;
        if (r4 == true) goto L15;
        r8 = r11 * r2;
        r11 = 0.0f;
    L15:
        a(r8, r11);
        goto L8
    L24:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public void a(com.tom_roush.pdfbox.contentstream.operator.b r4, List<com.tom_roush.pdfbox.a.b> r5) {
        List<com.tom_roush.pdfbox.a.b> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        String r0 = r4.a();
        c r1 = (c) ZeusTransformUtils.preCheckCast(this.f16092a.get(r0), c.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        r1.a(this);
        r1.a(r4, r6);     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        a(r4, r6, e);
        return;
    L9:
        b(r4, r6);
    }

    public void a(com.tom_roush.pdfbox.contentstream.operator.b r2, List<com.tom_roush.pdfbox.a.b> r3, IOException r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, MissingOperandException.class) == false) goto L5;
    L16:
        Log.e("PdfBox-Android", r4.getMessage());
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, MissingResourceException.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r4, MissingImageReaderException.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r4, EmptyGraphicsStackException.class) == false) goto L13;
    L11:
        Log.w("PdfBox-Android", r4.getMessage());
        return;
    L13:
        if (r2.a().equals("Do") == true) goto L11;
        throw r4;
    }

    public final void a(c r2) {
        r2.a(this);
        this.f16092a.put(r2.a(), r2);
    }

    public void a(ac r5, com.tom_roush.pdfbox.util.c r6) {
        if (this.f == null) goto L12;
        i r0 = c(r5);
        Deque<com.tom_roush.pdfbox.pdmodel.graphics.state.b> r1 = e();
        g().a(r6);
        r6.a(r5.c());
        com.tom_roush.pdfbox.util.c r7 = this.f16093b;
        this.f16093b = new com.tom_roush.pdfbox.util.c();
        com.tom_roush.pdfbox.util.c r2 = this.c;
        this.c = new com.tom_roush.pdfbox.util.c();
        b(r5);     // Catch: Throwable -> L8
        this.f16093b = r7;
        this.c = r2;
        a(r1);
        a(r0);
        return;
    L8:
        th = move-exception;
        this.f16093b = r7;
        this.c = r2;
        a(r1);
        a(r0);
        throw th;
    L12:
        throw new IllegalStateException("No current page, call #processChildStream(PDContentStream, PDPage) instead");
    }

    public void a(g r2) {
        b(r2);
        if (r2.f() == false) goto L6;
        this.g = true;
        a(r2);
        this.g = false;
        return;
    }

    public void a(com.tom_roush.pdfbox.pdmodel.graphics.c.a r5) {
        if (this.f == null) goto L9;
        if (r5.k_().j() <= 0) goto L10;
        a(r5);
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("No current page, call #processChildStream(PDContentStream, PDPage) instead");
    }

    public void a(com.tom_roush.pdfbox.pdmodel.graphics.c.b r1) {
        b(r1);
    }

    public void a(com.tom_roush.pdfbox.util.c r1) {
        this.c = r1;
    }

    public void a(com.tom_roush.pdfbox.util.c r7, ad r8, int r9, e r10) {
        a(r7, r8, r9, r8.e(r9), r10);
    }

    public void a(com.tom_roush.pdfbox.util.c r1, ad r2, int r3, String r4, e r5) {
        ac r6 = r2.f(r3);
        if (r6 == null) goto L6;
        a(r6, r1);
        return;
    }

    public void a(com.tom_roush.pdfbox.util.c r7, p r8, int r9, e r10) {
        a(r7, r8, r9, r8.e(r9), r10);
    }

    public void a(com.tom_roush.pdfbox.util.c r2, p r3, int r4, String r5, e r6) {
        if (ZeusTransformUtils.instanceOf(r3, ad.class) == false) goto L5;
        a(r2, (ad) ZeusTransformUtils.preCheckCast(r3, ad.class, "com.obric.memorydata.plugin"), r4, r6);
        return;
    L5:
        b(r2, r3, r4, r6);
    }

    public void a(String r3, List<com.tom_roush.pdfbox.a.b> r4) {
        List<com.tom_roush.pdfbox.a.b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        a(com.tom_roush.pdfbox.contentstream.operator.b.a(r3), r5);
    }

    public final void a(Deque<com.tom_roush.pdfbox.pdmodel.graphics.state.b> r3) {
        this.d = (Deque) ZeusTransformUtils.wrapperContextForParams(r3, Deque.class, "com.obric.memorydata.plugin");
    }

    public void a(byte[] r1) {
        b(r1);
    }

    public void b() {
    }

    public void b(com.tom_roush.pdfbox.contentstream.operator.b r1, List<com.tom_roush.pdfbox.a.b> r2) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }

    public void b(com.tom_roush.pdfbox.pdmodel.graphics.c.b r7) {
        if (this.f == null) goto L12;
        i r0 = c(r7);
        Deque<com.tom_roush.pdfbox.pdmodel.graphics.state.b> r1 = e();
        com.tom_roush.pdfbox.util.c r2 = this.h;
        com.tom_roush.pdfbox.pdmodel.graphics.state.b r3 = g();
        this.h = r3.a().b();
        r3.a().a(r7.c());
        r3.a(com.tom_roush.pdfbox.pdmodel.graphics.a.a.f16257a);
        r3.a(1.0d);
        r3.b(1.0d);
        r3.a(null);
        a(r7.b());
        b(r7);     // Catch: Throwable -> L8
        this.h = r2;
        a(r1);
        a(r0);
        return;
    L8:
        th = move-exception;
        this.h = r2;
        a(r1);
        a(r0);
        throw th;
    L12:
        throw new IllegalStateException("No current page, call #processChildStream(PDContentStream, PDPage) instead");
    }

    public void b(com.tom_roush.pdfbox.util.c r1) {
        this.f16093b = r1;
    }

    public void b(com.tom_roush.pdfbox.util.c r7, p r8, int r9, e r10) {
        b(r7, r8, r9, r8.e(r9), r10);
    }

    public void b(com.tom_roush.pdfbox.util.c r1, p r2, int r3, String r4, e r5) {
    }

    public void b(byte[] r17) {
        com.tom_roush.pdfbox.pdmodel.graphics.state.b r1 = g();
        d r2 = r1.b();
        p r3 = r2.e();
        if (r3 != null) goto L5;
        Log.w("PdfBox-Android", "No current font, will use default");
        r3 = aa.i;
    L5:
        float r11 = r2.f();
        float r12 = r2.c() / 100.0f;
        float r13 = r2.a();
        com.tom_roush.pdfbox.util.c r14 = new com.tom_roush.pdfbox.util.c(r11 * r12, 0.0f, 0.0f, r11, 0.0f, r2.g());
        ByteArrayInputStream r4 = new ByteArrayInputStream(r17);
    L7:
        if (r4.available() <= 0) goto L22;
        int r5 = r4.available();
        int r6 = r3.a(r4);
        float r8 = 0.0f;
        if ((r5 - r4.available()) == 1) goto L11;
    L13:
        float r7 = 0.0f;
    L14:
        com.tom_roush.pdfbox.util.c r9 = r14.b(this.f16093b).b(r1.a());
        if (r3.l() == false) goto L17;
        r9.a(r3.a(r6));
    L17:
        e r10 = r3.b(r6);
        a(r9, r3, r6, r10);
        if (r3.l() == false) goto L20;
        float r15 = ((r10.b() * r11) + r13) + r7;
    L21:
        this.f16093b.a(com.tom_roush.pdfbox.util.c.b(r8, r15));
        goto L7
    L20:
        r8 = (((r10.a() * r11) + r13) + r7) * r12;
        r15 = 0.0f;
        goto L21
    L11:
        if (r6 != 32) goto L13;
        r7 = r2.b() + 0.0f;
        goto L14
    }

    public void c() {
        Deque<com.tom_roush.pdfbox.pdmodel.graphics.state.b> r3 = this.d;
        r3.push(((com.tom_roush.pdfbox.pdmodel.graphics.state.b) ZeusTransformUtils.preCheckCast(r3.peek(), com.tom_roush.pdfbox.pdmodel.graphics.state.b.class, "com.obric.memorydata.plugin")).c());
    }

    public void d() {
        this.d.pop();
    }

    public final Deque<com.tom_roush.pdfbox.pdmodel.graphics.state.b> e() {
        Deque<com.tom_roush.pdfbox.pdmodel.graphics.state.b> r0 = this.d;
        ArrayDeque r1 = new ArrayDeque(1);
        this.d = r1;
        r1.add(((com.tom_roush.pdfbox.pdmodel.graphics.state.b) ZeusTransformUtils.preCheckCast(r0.peek(), com.tom_roush.pdfbox.pdmodel.graphics.state.b.class, "com.obric.memorydata.plugin")).c());
        return r0;
    }

    public int f() {
        return this.d.size();
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.state.b g() {
        return (com.tom_roush.pdfbox.pdmodel.graphics.state.b) ZeusTransformUtils.preCheckCast(this.d.peek(), com.tom_roush.pdfbox.pdmodel.graphics.state.b.class, "com.obric.memorydata.plugin");
    }

    public i getResources() {
        return this.e;
    }

    public com.tom_roush.pdfbox.util.c h() {
        return this.c;
    }

    public com.tom_roush.pdfbox.util.c i() {
        return this.f16093b;
    }

    public int j() {
        return this.i;
    }

    public void k() {
        this.i++;
    }

    public void l() {
        int r0 = this.i - 1;
        this.i = r0;
        if (r0 >= 0) goto L6;
        Log.e("PdfBox-Android", "level is " + this.i);
        return;
    }
}
