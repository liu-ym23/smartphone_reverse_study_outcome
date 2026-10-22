package com.lynx.component.svg.parser;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.util.Log;
import com.lynx.base.log.LynxLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 implements lm.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f9841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f9843c;

    public n0() {
        this.f9841a = null;
        this.f9842b = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static g0 d(e0 r5, String r10) {
        g0 r11 = (g0) r5;
        if (r10.equals(r11.f9810c) == false) goto L5;
        return r11;
    L5:
        Iterator r12 = r5.getChildren().iterator();
    L7:
        if (r12.hasNext() == false) goto L19;
        g0 r13 = (g0) r12.next();
        if (r13 == 0) goto L7;
        if (r10.equals(r13.f9810c) == true) goto L13;
        if ((r13 instanceof e0) == false) goto L7;
        g0 r14 = d((e0) r13, r10);
        if (r14 == null) goto L7;
        return r14;
    L13:
        return r13;
    L19:
        return null;
    }

    public static n0 e(String r5) {
        LynxLog.b(2, "lynx_UISvg", "getFromString():" + r5);
        t0 r10 = new t0();
        r10.f9870a = null;
        r10.f9871b = null;
        r10.f9872c = false;
        InputStream r11 = new ByteArrayInputStream(r5.getBytes());
        if (r11.markSupported() == true) goto L27;
        r11 = new BufferedInputStream(r11);
    L27:
        r11.mark(3);     // Catch: IOException -> L20
        int r12 = r11.read() + (r11.read() << 8);     // Catch: IOException -> L20
        r11.reset();     // Catch: IOException -> L20
        if (r12 != 35615) goto L23;
        r11 = new BufferedInputStream(new GZIPInputStream(r11));     // Catch: IOException -> L20
    L23:
        r10.k(r11);     // Catch: Throwable -> L15
        n0 r13 = r10.f9870a;     // Catch: Throwable -> L15
        r11.close();     // Catch: IOException -> L13
    L14:
        return r13;
    L13:
        Log.e("SVGParser", "Exception thrown closing input stream");
    L15:
        th = move-exception;
        r11.close();     // Catch: IOException -> L18
    L19:
        throw th;
    L18:
        Log.e("SVGParser", "Exception thrown closing input stream");
        goto L19
    }

    @Override // lm.d
    /* JADX INFO: renamed from: a */
    public void mo1706a() {
    }

    public Picture b(d r10, i4.a r11) {
        this.f9843c = r10;
        c0 r5 = (c0) this.f9841a;
        if (r5 != null) goto L6;
        LynxLog.b(4, "SVG", " bad format SVG, rootElement is null");
        return null;
    L6:
        e r12 = r5.f9833j;
        if (r10 == null) goto L12;
        e r13 = (e) r10.f9799c;
        if (r13 == null) goto L12;
        return a((int) Math.ceil(r13.f9801a + r13.f9803c), (int) Math.ceil(r13.f9802b + r13.d), r10, r11);
    L12:
        q r14 = r5.f9795m;
        if (r14 == null) goto L22;
        SVG$Unit r15 = SVG$Unit.d;
        if (r14.f9858b == r15) goto L22;
        q r16 = r5.f9796n;
        if (r16 == null) goto L22;
        if (r16.f9858b == r15) goto L22;
        float r17 = r10.f9797a;
        float r18 = r10.f9798b;
        return a((int) Math.ceil(r14.a(r17, r18)), (int) Math.ceil(((c0) this.f9841a).f9796n.a(r10.f9797a, r18)), r10, r11);
    L22:
        if (r14 == null) goto L26;
        if (r12 == null) goto L26;
        float r19 = r14.a(r10.f9797a, r10.f9798b);
        return a((int) Math.ceil(r19), (int) Math.ceil((r12.d * r19) / r12.f9803c), r10, r11);
    L26:
        q r20 = r5.f9796n;
        if (r20 == null) goto L32;
        if (r12 == null) goto L32;
        float r21 = r20.a(r10.f9797a, r10.f9798b);
        return a((int) Math.ceil((r12.f9803c * r21) / r12.d), (int) Math.ceil(r21), r10, r11);
    L32:
        return a(512, 512, r10, r11);
    }

    public e c() {
        c0 r5 = (c0) this.f9841a;
        q r10 = r5.f9795m;
        q r11 = r5.f9796n;
        if (r10 == null) goto L32;
        if (r10.f() == true) goto L32;
        SVG$Unit r12 = SVG$Unit.d;
        SVG$Unit r13 = r10.f9858b;
        if (r13 == r12) goto L32;
        SVG$Unit r14 = SVG$Unit.f9758b;
        if (r13 == r14) goto L32;
        SVG$Unit r15 = SVG$Unit.f9759c;
        if (r13 == r15) goto L32;
        d r16 = (d) this.f9843c;
        float r17 = r10.a(r16.f9797a, r16.f9798b);
        if (r11 != null) goto L16;
        e r18 = ((c0) this.f9841a).f9833j;
        if (r18 == null) goto L28;
        float r19 = (r18.d * r17) / r18.f9803c;
    L30:
        return new e(0.0f, 0.0f, r17, r19);
    L28:
        r19 = r17;
        goto L30
    L16:
        if (r11.f() == true) goto L24;
        SVG$Unit r20 = r11.f9858b;
        if (r20 == r12) goto L24;
        if (r20 == r14) goto L24;
        if (r20 == r15) goto L24;
        d r21 = (d) this.f9843c;
        r19 = r11.a(r21.f9797a, r21.f9798b);
    L24:
        return new e(-1.0f, -1.0f, -1.0f, -1.0f);
    L32:
        return new e(-1.0f, -1.0f, -1.0f, -1.0f);
    }

    public g0 f(String r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.startsWith("\"") == false) goto L11;
        if (r5.endsWith("\"") == false) goto L11;
        r5 = r5.substring(1, r5.length() - 1).replace("\\\"", "\"");
    L15:
        String r10 = r5.replace("\\\n", "").replace("\\A", "\n");
        if (r10.length() > 1) goto L18;
    L34:
        return null;
    L18:
        if (r10.startsWith("#") == false) goto L34;
        String r11 = r10.substring(1);
        if (r11 == null) goto L34;
        if (r11.length() == 0) goto L34;
        if (r11.equals(((c0) this.f9841a).f9810c) == true) goto L27;
        HashMap r12 = (HashMap) this.f9842b;
        if (r12.containsKey(r11) == true) goto L31;
        g0 r13 = d((c0) this.f9841a, r11);
        r12.put(r11, r13);
        return r13;
    L31:
        return (g0) r12.get(r11);
    L27:
        return (c0) this.f9841a;
    L11:
        if (r5.startsWith("'") == false) goto L15;
        if (r5.endsWith("'") == false) goto L15;
        r5 = r5.substring(1, r5.length() - 1).replace("\\'", "'");
        goto L15
    }

    @Override // lm.d
    public void a(Bitmap r5) {
        p r10 = (p) this.f9841a;
        c r11 = (c) this.f9842b;
        ((p0) this.f9843c).n(r10, r11, r5);
    }

    public n0(p0 r5, p r10, c r11) {
        this.f9843c = r5;
        this.f9841a = r10;
        this.f9842b = r11;
    }

    public Picture a(int r10, int r11, d r12, i4.a r13) {
        this.f9843c = r12;
        Picture r5 = new Picture();
        Canvas r14 = r5.beginRecording(r10, r11);
        if (r12 != null) goto L5;
    L6:
        if (r12 != null) goto L8;
        r12 = new d(14.0f, 14.0f);
    L13:
        r12.f9799c = new e(0.0f, 0.0f, r10, r11);
    L14:
        p0 r15 = new p0(r14, r12.f9797a, r13);
        LynxLog.b(2, "lynx_UISvg", "beforeRenderDocument(),  svg hasCode:" + this);
        r15.d = this;
        c0 r16 = (c0) this.f9841a;
        if (r16 != null) goto L17;
        LynxLog.b(3, "SVGAndroidRenderer", "Nothing to render. Document is empty.");
    L21:
        LynxLog.b(2, "lynx_UISvg", "AfterRenderDocument(),svg hasCode:" + this);
        r5.endRecording();
        return r5;
    L17:
        e r17 = r16.f9833j;
        c r18 = r16.f9819i;
        r15.e = new o0();
        r15.f = new Stack();
        r15.t(r15.e, b0.a());
        o0 r19 = r15.e;
        r19.f = null;
        r15.f.push(new o0(r19));
        r15.f9856h = new Stack();
        r15.g = new Stack();
        if (r16.d == null) goto L20;
        r15.e.getClass();
    L20:
        r15.H();
        r15.p(r16, new e((e) r12.f9799c), r17, r18);
        r15.G();
        goto L21
    L8:
        d r20 = new d();
        r20.f9799c = null;
        r20.f9797a = 14.0f;
        r20.f9798b = 14.0f;
        if (r12 == null) goto L12;
        r20.f9799c = (e) r12.f9799c;
        r20.f9797a = r12.f9797a;
        r20.f9798b = r12.f9798b;
    L12:
        r12 = r20;
        goto L13
    L5:
        if (((e) r12.f9799c) != null) goto L14;
        goto L6
    }
}
