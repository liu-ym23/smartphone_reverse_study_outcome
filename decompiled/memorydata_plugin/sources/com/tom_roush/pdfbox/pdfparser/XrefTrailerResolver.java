package com.tom_roush.pdfbox.pdfparser;

import android.util.Log;
import com.tom_roush.pdfbox.a.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class XrefTrailerResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Long, a> f16126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f16127b;
    private a c;

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.pdfparser.XrefTrailerResolver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final enum XRefType extends Enum<XRefType> {
        private static final /* synthetic */ XRefType[] $VALUES = null;
        public static final XRefType STREAM = null;
        public static final XRefType TABLE = null;

        static {
            XRefType r0 = new XRefType("TABLE", 0);
            TABLE = r0;
            XRefType r1 = new XRefType("STREAM", 1);
            STREAM = r1;
            $VALUES = new XRefType[]{r0, r1};
        }

        private XRefType(String r1, int r2) {
            super(r1, r2);
        }

        public static XRefType valueOf(String r2) {
            return (XRefType) ZeusTransformUtils.preCheckCast(Enum.valueOf(XRefType.class, r2), XRefType.class, "com.obric.memorydata.plugin");
        }

        public static XRefType[] values() {
            return (XRefType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), XRefType[].class, "com.obric.memorydata.plugin");
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected com.tom_roush.pdfbox.a.d f16128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private XRefType f16129b;
        private final Map<m, Long> c;

        private a() {
            this.f16128a = null;
            this.c = new HashMap();
            this.f16129b = XRefType.TABLE;
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ XRefType a(a r0) {
            return r0.f16129b;
        }

        static /* synthetic */ XRefType a(a r0, XRefType r1) {
            r0.f16129b = r1;
            return r1;
        }

        static /* synthetic */ Map b(a r0) {
            return r0.c;
        }

        public void a() {
            this.c.clear();
        }
    }

    public XrefTrailerResolver() {
        this.f16126a = new HashMap();
        this.f16127b = null;
        this.c = null;
    }

    public XRefType a() {
        a r0 = this.c;
        if (r0 != null) goto L6;
        return null;
    L6:
        return a.a(r0);
    }

    public void a(long r7) {
        if (this.c == null) goto L6;
        Log.w("PdfBox-Android", "Method must be called only ones with last startxref value.");
        return;
    L6:
        a r0 = new a(null);
        this.c = r0;
        r0.f16128a = new com.tom_roush.pdfbox.a.d();
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f16126a.get(Long.valueOf(r7)), a.class, "com.obric.memorydata.plugin");
        ArrayList r2 = new ArrayList();
        if (r1 != null) goto L9;
        Log.w("PdfBox-Android", "Did not found XRef object at specified startxref position " + r7);
        r2.addAll(this.f16126a.keySet());
        Collections.sort(r2);
    L21:
        Iterator r8 = r2.iterator();
    L23:
        if (r8.hasNext() == false) goto L28;
        a r9 = (a) ZeusTransformUtils.preCheckCast(this.f16126a.get((Long) ZeusTransformUtils.preCheckCast(r8.next(), Long.class, "com.obric.memorydata.plugin")), a.class, "com.obric.memorydata.plugin");
        if (r9.f16128a == null) goto L27;
        this.c.f16128a.a(r9.f16128a);
    L27:
        a.b(this.c).putAll(a.b(r9));
        goto L23
    L28:
        return;
    L9:
        a.a(this.c, a.a(r1));
        r2.add(Long.valueOf(r7));
    L11:
        if (r1.f16128a == null) goto L20;
        long r10 = r1.f16128a.b(com.tom_roush.pdfbox.a.i.gs, -1);
        if (r10 == (-1)) goto L20;
        r1 = (a) ZeusTransformUtils.preCheckCast(this.f16126a.get(Long.valueOf(r10)), a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L17;
        r2.add(Long.valueOf(r10));
        if (r2.size() < this.f16126a.size()) goto L11;
    L17:
        Log.w("PdfBox-Android", "Did not found XRef object pointed to by 'Prev' key at position " + r10);
    L20:
        Collections.reverse(r2);
        goto L21
    }

    public void a(long r3, XRefType r5) {
        this.f16127b = new a(null);
        this.f16126a.put(Long.valueOf(r3), this.f16127b);
        a.a(this.f16127b, r5);
    }

    public void a(com.tom_roush.pdfbox.a.d r1) {
        a r0 = this.f16127b;
        if (r0 != null) goto L6;
        Log.w("PdfBox-Android", "Cannot add trailer because XRef start was not signalled.");
        return;
    L6:
        r0.f16128a = r1;
    }

    public void a(m r2, long r3) {
        a r0 = this.f16127b;
        if (r0 != null) goto L7;
        Log.w("PdfBox-Android", "Cannot add XRef entry for '" + r2.b() + "' because XRef start was not signalled.");
        return;
    L7:
        if (a.b(r0).containsKey(r2) == true) goto L10;
        a.b(this.f16127b).put(r2, Long.valueOf(r3));
        return;
    }

    public com.tom_roush.pdfbox.a.d b() {
        return this.f16127b.f16128a;
    }

    public com.tom_roush.pdfbox.a.d c() {
        a r0 = this.c;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.f16128a;
    }

    public Map<m, Long> d() {
        a r0 = this.c;
        if (r0 != null) goto L6;
        return null;
    L6:
        return a.b(r0);
    }

    public void e() {
        Iterator<a> r0 = this.f16126a.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin")).a();
        goto L4
    L6:
        this.f16127b = null;
        this.c = null;
    }
}
