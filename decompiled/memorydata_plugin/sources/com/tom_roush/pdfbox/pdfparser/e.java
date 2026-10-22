package com.tom_roush.pdfbox.pdfparser;

import android.util.Log;
import com.tom_roush.pdfbox.a.l;
import com.tom_roush.pdfbox.a.n;
import com.tom_roush.pdfbox.android.PDFBoxConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes6.dex */
public class e extends a {
    private List<l> d;
    private final int e;
    private final int f;

    public e(n r3, com.tom_roush.pdfbox.a.e r4) {
        super(new d(r3.h()));
        this.d = null;
        this.c = r4;
        int r5 = r3.i(com.tom_roush.pdfbox.a.i.fg);
        this.e = r5;
        if (r5 == (-1)) goto L16;
        if (r5 < 0) goto L14;
        int r6 = r3.i(com.tom_roush.pdfbox.a.i.cU);
        this.f = r6;
        if (r6 == (-1)) goto L12;
        if (r6 < 0) goto L10;
        return;
    L10:
        throw new IOException("Illegal /First entry in object stream: " + r6);
    L12:
        throw new IOException("/First entry missing in object stream");
    L14:
        throw new IOException("Illegal /N entry in object stream: " + r5);
    L16:
        throw new IOException("/N entry missing in object stream");
    }

    private com.tom_roush.pdfbox.a.b g(int r6) {
        long r0 = this.f16131b.b();
        int r2 = this.f + r6;
        if (r2 <= 0) goto L8;
        if (r0 >= r2) goto L8;
        this.f16131b.b(r2 - ((int) r0));
    L8:
        return f();
    }

    private Map<Integer, Long> t() {
        TreeMap r0 = new TreeMap();
        long r1 = (this.f16131b.b() + ((long) this.f)) - 1;
        int r3 = 0;
    L4:
        if (r3 >= this.e) goto L9;
        if (this.f16131b.b() >= r1) goto L9;
        long r4 = m();
        r0.put(Integer.valueOf((int) p()), Long.valueOf(r4));
        r3 = r3 + 1;
    L9:
        return r0;
    }

    public void r() {
        Map<Integer, Long> r1 = t();     // Catch: Throwable -> L12
        this.d = new ArrayList(r1.size());     // Catch: Throwable -> L12
        Iterator<Map.Entry<Integer, Long>> r2 = r1.entrySet().iterator();     // Catch: Throwable -> L12
    L5:
        if (r2.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        l r4 = new l(g(((Integer) ZeusTransformUtils.preCheckCast(r3.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue()));     // Catch: Throwable -> L12
        r4.a(0);     // Catch: Throwable -> L12
        r4.a(((Long) ZeusTransformUtils.preCheckCast(r3.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Throwable -> L12
        this.d.add(r4);     // Catch: Throwable -> L12
        if (PDFBoxConfig.b() == false) goto L5;
        Log.d("PdfBox-Android", "parsed=" + r4);     // Catch: Throwable -> L12
        goto L5
    L10:
        this.f16131b.close();
        return;
    L12:
        th = move-exception;
        this.f16131b.close();
        throw th;
    }

    public List<l> s() {
        return this.d;
    }
}
